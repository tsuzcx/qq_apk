package com.tencent.av.smallscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SmallScreenMultiVideoControlUI
  extends SmallScreenVideoControlUI
{
  static int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new SmallScreenMultiVideoControlUI.1(this);
  SmallScreenMultiVideoControlUI.StartRecvVideoRunnable jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable = new SmallScreenMultiVideoControlUI.StartRecvVideoRunnable(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  TraeMediaPlayer jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  long[] jdField_a_of_type_ArrayOfLong = null;
  int jdField_b_of_type_Int = -1;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  int jdField_c_of_type_Int = -1;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  int jdField_d_of_type_Int = 0;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  
  static
  {
    int i = 16;
    jdField_a_of_type_Int = 16;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      jdField_a_of_type_Int = i;
      return;
      i = 9;
    }
  }
  
  SmallScreenMultiVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
  }
  
  long a()
  {
    long l = 0L;
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L)) {
        l = localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long;
      }
    }
    else
    {
      return l;
    }
    return localSessionInfo.jdField_g_of_type_Long;
  }
  
  void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "drawUI, type[" + paramInt1 + "], uin[" + paramLong + "], fresh[" + paramBoolean + "], originalType[" + paramInt2 + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    label153:
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().an) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        TraeHelper.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
      }
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label391;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
        break label375;
      }
      localObject2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695859);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.l())
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b.equals("1"))) {
          break label361;
        }
        localObject1 = localObject2;
      }
      label256:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = true;
      }
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject1);
      label293:
      l();
    }
    for (;;)
    {
      label297:
      p();
      return;
      if ((paramInt1 != 1) || (paramLong == this.jdField_a_of_type_Long) || (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) || (!this.jdField_a_of_type_ComTencentAvVideoController.m())) {
        break label153;
      }
      TraeHelper.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
      break label153;
      label361:
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695849);
      break label256;
      label375:
      if (paramInt1 != 0) {
        break label293;
      }
      this.jdField_c_of_type_Boolean = false;
      t();
      break label293;
      label391:
      if ((paramInt1 != 68) && (paramInt1 != 82))
      {
        if ((paramInt1 == 5) || (paramInt1 == 6))
        {
          paramInt2 = 0;
          paramBoolean = true;
          if (paramLong == this.jdField_a_of_type_Long) {
            paramInt2 = 1;
          }
          if (paramInt1 == 6)
          {
            boolean bool = a();
            paramBoolean = bool;
            if (paramInt2 != 0)
            {
              paramBoolean = bool;
              if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aq)
              {
                this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
                paramBoolean = bool;
              }
            }
          }
          if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().an) || (!paramBoolean)) {
            continue;
          }
          if (this.e >= 4) {
            break;
          }
          if ((NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().b() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().as))
          {
            if (paramInt2 == 0)
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
              continue;
            }
            paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_a_of_type_Long, 1);
            int i = this.jdField_a_of_type_ComTencentAvVideoController.a().b();
            if (QLog.isColorLevel()) {
              QLog.d("SmallScreenMultiVideoControlUI", 2, "onSelfVideoIn.-->FirstVideo=" + i + ",index=" + paramInt2);
            }
            if ((i != -1) && ((paramInt2 != i) || (paramInt2 == 0))) {
              continue;
            }
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
            continue;
          }
          if (paramInt2 != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.1", true, true);
          o();
          a(true, true, true);
          continue;
        }
        if ((paramInt1 == 7) || (paramInt1 == 8))
        {
          paramBoolean = true;
          if (paramInt1 == 8)
          {
            localObject1 = new VideoViewInfo();
            ((VideoViewInfo)localObject1).jdField_a_of_type_Long = paramLong;
            ((VideoViewInfo)localObject1).jdField_a_of_type_Int = 2;
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(localObject1);
            this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localObject2 });
          }
          for (;;)
          {
            if (paramInt1 == 8) {
              paramBoolean = a();
            }
            if (((!this.jdField_a_of_type_ComTencentAvVideoController.a().J) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().an)) || (!paramBoolean)) {
              break label297;
            }
            if (this.e >= 4) {
              break;
            }
            if ((!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().b() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().as)) {
              break label1125;
            }
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
            break label297;
            if (this.jdField_d_of_type_Int == 2) {
              ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
            }
          }
          label1125:
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.2", true, true);
          o();
          a(true, true, true);
        }
        else if ((paramInt1 == 97) || (paramInt1 == 98))
        {
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
          }
        }
        else if (paramInt1 == 10)
        {
          paramBoolean = a();
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().an) && (paramBoolean))
          {
            if (this.e >= 4) {
              break;
            }
            if ((NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().b() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().as))
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
            }
            else
            {
              this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.3", true, true);
              o();
              a(true, true, true);
            }
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a(paramLong);
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
    }
    super.a(paramLong);
  }
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin=" + paramLong + " type=" + paramInt1 + " isRefreshTitle=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (paramLong == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin == 0");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        SmallScreenMultiVideoControlUI.RefreshUIRunnable localRefreshUIRunnable = new SmallScreenMultiVideoControlUI.RefreshUIRunnable(this, paramInt1, paramLong, paramBoolean, paramInt2);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(localRefreshUIRunnable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->mApp == null");
  }
  
  void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        VideoViewInfo localVideoViewInfo = (VideoViewInfo)paramArrayList.get(i);
        if ((localVideoViewInfo.jdField_a_of_type_Long == this.jdField_a_of_type_Long) && (localVideoViewInfo.jdField_a_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
        return;
      }
      i += 1;
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1))
    {
      k();
      b(paramLong, paramBoolean);
    }
    for (;;)
    {
      f();
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        String str1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 9)
        {
          this.jdField_c_of_type_Boolean = true;
          String str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695859);
          str1 = str2;
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b.equals("1"))) {
              str1 = str2;
            }
          }
          else {
            label137:
            if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
              this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
            }
          }
        }
        for (;;)
        {
          t();
          break;
          str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695849);
          break label137;
          this.jdField_c_of_type_Boolean = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "handleExterData-->Wrong gaudioStatusType-->type=" + this.jdField_b_of_type_Int + ",relationId=" + a() + ",relationType=" + this.jdField_d_of_type_Int);
      }
    }
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Add-->FunctionName=" + paramString);
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
      return;
      this.jdField_b_of_type_JavaLangRunnable = new SmallScreenMultiVideoControlUI.RequestVideoTimeOutRunnable(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    h();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().b())
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().q;
      TraeHelper.a().a(l, this.jdField_c_of_type_JavaLangString, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenMultiVideoControlUI", 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.jdField_c_of_type_JavaLangString + "], deviceName[" + (String)localObject + "], seq[" + l + "]");
      }
      TraeHelper.a().a(l, (String)localObject);
    }
    a(l, paramBoolean);
    p();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.l()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b.equals("1")))
    {
      localObject = (SmallScreenAudio)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(0);
      if ((localObject != null) && (((SmallScreenAudio)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null))
      {
        ((SmallScreenAudio)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842440);
        ((SmallScreenAudio)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      if (this.jdField_d_of_type_Int == 2) {
        if (!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
        {
          ReportController.b(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
          if (!paramBoolean2) {
            break label230;
          }
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
        }
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        a(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
      }
      return;
      ReportController.b(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
      break;
      if (this.jdField_d_of_type_Int != 1) {
        break;
      }
      if (NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        ReportController.b(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
      break;
      label230:
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      continue;
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      k();
      a(false, false, false);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_a_of_type_Long))
    {
      a(false, false, false);
      b("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.v();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "goOffStage", false, false);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
    o();
  }
  
  void b(long paramLong, boolean paramBoolean)
  {
    long l = a();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "createOrEnterGAudio, mType[" + this.jdField_b_of_type_Int + "], relationType[" + this.jdField_d_of_type_Int + "], groupId[" + l + "], seq[" + paramLong + "], isDoubleAudioToMultiAudio[" + paramBoolean + "]");
    }
    if (l == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio-->mGroupId == 0");
      }
    }
    do
    {
      do
      {
        return;
        String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695851);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        }
        if (this.jdField_b_of_type_Int != 0) {
          break;
        }
      } while ((this.jdField_a_of_type_ArrayOfLong != null) || (this.jdField_d_of_type_Int != 2));
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio uinList is null");
      }
      d(true);
      return;
    } while ((this.jdField_b_of_type_Int != 1) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_d_of_type_Int, l, this.jdField_a_of_type_ArrayOfLong, false);
  }
  
  void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Remove-->FunctionName=" + paramString);
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return false;
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size();
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) {
          i = j - 1;
        }
        if (i != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->There is no dispaly view");
      return false;
    } while (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1);
    ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
    int i = this.jdField_a_of_type_ComTencentAvVideoController.g();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->VideoAblityLevel=" + i);
    }
    if (i != 4)
    {
      if (this.jdField_d_of_type_Int != 2) {
        break label333;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3007);
      this.jdField_a_of_type_ComTencentAvVideoController.a().e.clear();
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
      {
        if ((((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_c_of_type_Boolean) && (l != ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().e.add(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i));
        }
        i += 1;
      }
      label333:
      if (this.jdField_d_of_type_Int != 1) {}
    }
    a(false, false, false);
    return this.jdField_a_of_type_ComTencentAvVideoController.a(false);
  }
  
  void c(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = new TraeMediaPlayer((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (!paramBoolean) {
        break label97;
      }
      if (GAudioSoundUtil.a("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a(l, 2, 0, null, GAudioSoundUtil.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label97:
    while (!GAudioSoundUtil.a("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a(l);
      break;
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a(l, 2, 0, null, GAudioSoundUtil.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
  }
  
  void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(a()), Boolean.valueOf(paramBoolean) });
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onResume");
    }
    String str1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.d)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.o();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
          break label223;
        }
        this.jdField_c_of_type_Boolean = true;
        String str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695859);
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentAvVideoController.l())
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b.equals("1"))) {
            break label210;
          }
          str1 = str2;
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
        }
      }
    }
    for (;;)
    {
      t();
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().aq = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.d) {
        i();
      }
      f();
      return;
      label210:
      str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695849);
      break;
      label223:
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.d) {}
    long l = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_c_of_type_Int, String.valueOf(l));
  }
  
  public void g()
  {
    super.g();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().b() != -1)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a("Small_onPause");
    }
  }
  
  void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData-->mType=" + this.jdField_a_of_type_ComTencentAvVideoController.a().E + " IntentGroupId=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long + " isInRoom=" + this.jdField_a_of_type_ComTencentAvVideoController.d + " mRoomDiscussionId=" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo != null)
    {
      this.jdField_c_of_type_Int = localSessionInfo.jdField_j_of_type_Int;
      if (this.jdField_c_of_type_Int != 3000) {
        break label278;
      }
      this.jdField_d_of_type_Int = 2;
    }
    for (;;)
    {
      if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long <= 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData sessionInfo.mAnychat_Info.matchStatus = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int);
        }
        if (((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 1) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 2)) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695860);
        }
      }
      this.jdField_b_of_type_Int = localSessionInfo.E;
      this.jdField_a_of_type_ArrayOfLong = localSessionInfo.jdField_a_of_type_ArrayOfLong;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData mGroupId = " + a());
      }
      return;
      label278:
      if (this.jdField_c_of_type_Int == 1) {
        this.jdField_d_of_type_Int = 1;
      } else if (this.jdField_c_of_type_Int == 0) {
        this.jdField_d_of_type_Int = 3;
      } else {
        this.jdField_d_of_type_Int = localSessionInfo.F;
      }
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new SmallScreenMultiVideoControlUI.AutoCheckRunnable(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  protected void j()
  {
    super.j();
    String str2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int == 9)
    {
      str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695859);
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.l()) {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b.equals("1"))) {
          break label156;
        }
      }
    }
    label156:
    for (String str1 = str2;; str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695849))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().b()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a("SmallScreenMultiVideoControlUI.initUI", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long, false);
      }
      return;
    }
  }
  
  void k()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenMultiVideoControlUI", 1, "closeRemoteVideo, seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("Meeting_closeRemoteVideo");
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "closeRemoteVideo", false, true);
      o();
    }
    b("closeRemoteVideo");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList });
    }
  }
  
  void l()
  {
    m();
  }
  
  void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshGAFList");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) && (QLog.isColorLevel())) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshGAFList-->mVideoContrl is null");
    }
  }
  
  void n()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoControl is null");
      }
    }
    label230:
    label248:
    do
    {
      int i;
      for (;;)
      {
        return;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.d)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoController.mGAudioInRoom =" + this.jdField_a_of_type_ComTencentAvVideoController.d);
          }
        }
        else
        {
          i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_a_of_type_Long, 1);
          int j = this.jdField_a_of_type_ComTencentAvVideoController.b();
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->index=" + i + ", onstageNum=" + j);
          }
          if ((!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().as)) {
            break;
          }
          if (i != -1)
          {
            if (this.jdField_a_of_type_ComTencentAvVideoController.b() >= jdField_a_of_type_Int) {
              break label248;
            }
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.k())) {
              break label230;
            }
          }
          while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
          {
            b();
            return;
            if (QLog.isColorLevel())
            {
              QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->go on stage fail,can not find the session");
              continue;
              this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
              this.jdField_a_of_type_ComTencentAvVideoController.u();
            }
          }
        }
      }
      if (i != -1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.u();
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(-1023L, "enterOrResumeRemoteOrLocalVideo", true, true);
    o();
    a(true, true, true);
  }
  
  @SuppressLint({"NewApi"})
  void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "switchUIMode, sessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
  }
  
  void p()
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.l()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.b.equals("1")))
    {
      int k = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int;
      int j = 0;
      i = j;
      switch (k)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (i != 0)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
      }
      return;
      i = 2131695851;
      continue;
      i = 2131695859;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI
 * JD-Core Version:    0.7.0.1
 */