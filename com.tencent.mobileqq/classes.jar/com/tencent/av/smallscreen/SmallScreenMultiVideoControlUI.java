package com.tencent.av.smallscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeMediaPlayerApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SmallScreenMultiVideoControlUI
  extends SmallScreenVideoControlUI
{
  static int jdField_a_of_type_Int = 16;
  long jdField_a_of_type_Long = 0L;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new SmallScreenMultiVideoControlUI.MyGAudioUIObserver(this, null);
  SmallScreenMultiVideoControlUI.StartRecvVideoRunnable jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable = new SmallScreenMultiVideoControlUI.StartRecvVideoRunnable(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  ITraeMediaPlayerApi jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi = null;
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
    int i;
    if (Build.VERSION.SDK_INT >= 21) {
      i = 16;
    } else {
      i = 9;
    }
    jdField_a_of_type_Int = i;
  }
  
  SmallScreenMultiVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
  }
  
  long a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long;
    }
    return 0L;
  }
  
  void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.b();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("drawUI, type[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], uin[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], fresh[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], originalType[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if ((paramInt1 == 0) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ab) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 2)) {
      TraeHelper.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230740, null, 0, null);
    }
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if ((paramInt1 != 5) && (paramInt1 != 6))
      {
        if ((paramInt1 != 7) && (paramInt1 != 8))
        {
          if ((paramInt1 != 97) && (paramInt1 != 98))
          {
            if (paramInt1 == 10) {
              a(l, paramInt1);
            }
          }
          else if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Request remote video failed.Uin = ");
            localStringBuilder.append(paramLong);
            localStringBuilder.append(",type=");
            localStringBuilder.append(paramInt1);
            QLog.e("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
          }
        }
        else {
          b(l, paramInt1, paramLong);
        }
      }
      else {
        a(l, paramInt1, paramLong);
      }
    }
    else {
      b(paramInt1);
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
    ITraeMediaPlayerApi localITraeMediaPlayerApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi;
    if (localITraeMediaPlayerApi != null)
    {
      localITraeMediaPlayerApi.stopRing(paramLong);
      this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi = null;
    }
    super.a(paramLong);
  }
  
  void a(long paramLong, int paramInt)
  {
    boolean bool = a();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ab) && (bool))
    {
      if (this.e >= 4) {
        return;
      }
      if ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "drawUI.3", true, true);
        o();
        a(true, true, true);
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
      SmallScreenMultiVideoControlUI.StartRecvVideoRunnable localStartRecvVideoRunnable = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DrawUI:TYPE=");
      localStringBuilder.append(String.valueOf(paramInt));
      localStartRecvVideoRunnable.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
    }
  }
  
  void a(long paramLong1, int paramInt, long paramLong2)
  {
    int i;
    if (paramLong2 == this.jdField_a_of_type_Long) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1;
    if (paramInt == 6)
    {
      boolean bool2 = a();
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ae)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = true;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ab) && (bool1))
    {
      if (this.e >= 4) {
        return;
      }
      if ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))
      {
        if (i == 0)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong1, "drawUI.1", true, true);
          o();
          a(true, true, true);
        }
      }
      else
      {
        Object localObject;
        StringBuilder localStringBuilder;
        if (i == 0)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
          localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DrawUI:TYPE=");
          localStringBuilder.append(String.valueOf(paramInt));
          ((SmallScreenMultiVideoControlUI.StartRecvVideoRunnable)localObject).jdField_a_of_type_JavaLangString = localStringBuilder.toString();
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
          return;
        }
        i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_a_of_type_Long, 1);
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().c();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onSelfVideoIn.-->FirstVideo=");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(",index=");
          ((StringBuilder)localObject).append(i);
          QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
        }
        if ((j == -1) || ((i == j) && (i != 0)))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
          localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DrawUI:TYPE=");
          localStringBuilder.append(String.valueOf(paramInt));
          ((SmallScreenMultiVideoControlUI.StartRecvVideoRunnable)localObject).jdField_a_of_type_JavaLangString = localStringBuilder.toString();
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
        }
      }
    }
  }
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshUI-->uin=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" type=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" isRefreshTitle=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" originalType=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin == 0");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = new SmallScreenMultiVideoControlUI.RefreshUIRunnable(this, paramInt1, paramLong, paramBoolean, paramInt2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post((Runnable)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->mApp == null");
    }
  }
  
  void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)paramArrayList.get(i);
      if ((localVideoViewInfo.jdField_a_of_type_Long == this.jdField_a_of_type_Long) && (localVideoViewInfo.jdField_a_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
      {
        paramArrayList.remove(i);
        break;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_b_of_type_Int;
    if ((i != 0) && (i != 1))
    {
      Object localObject;
      if (i == 2)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 9)
        {
          this.jdField_c_of_type_Boolean = true;
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695871);
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          }
        }
        else
        {
          this.jdField_c_of_type_Boolean = false;
        }
        s();
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleExterData-->Wrong gaudioStatusType-->type=");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(",relationId=");
        ((StringBuilder)localObject).append(a());
        ((StringBuilder)localObject).append(",relationType=");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
        QLog.e("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      k();
      b(paramLong, paramBoolean);
    }
    f();
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestVideoTimeoutRunnable-->Add-->functionName=");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    } else {
      this.jdField_b_of_type_JavaLangRunnable = new SmallScreenMultiVideoControlUI.RequestVideoTimeOutRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
  }
  
  public void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    h();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().b())
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().p;
      TraeHelper.a().a(l, this.jdField_c_of_type_JavaLangString, str);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCreate, switchToGaudio, mAudioSesstionType[");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("], deviceName[");
        localStringBuilder.append(str);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.w("SmallScreenMultiVideoControlUI", 1, localStringBuilder.toString());
      }
      TraeHelper.a().a(l, str);
    }
    a(l, paramBoolean);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      int i = this.jdField_d_of_type_Int;
      if (i == 2)
      {
        if (!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
          ReportController.b(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
        }
      }
      else if (i == 1) {
        if (NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
          ReportController.b(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
        }
      }
      if (paramBoolean2) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      } else {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      }
    }
    else
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    }
    if (paramBoolean3) {
      a(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvVideoController.a().c);
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() == 0)
    {
      k();
      a(false, false, false);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() == 1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Long == this.jdField_a_of_type_Long))
    {
      a(false, false, false);
      b("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 9)
    {
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695871);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = true;
      }
      UITools.a(this.jdField_a_of_type_AndroidWidgetTextView, str);
    }
    else if (paramInt == 0)
    {
      this.jdField_c_of_type_Boolean = false;
      s();
    }
    l();
  }
  
  void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.x();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "goOffStage", false, false);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
    o();
  }
  
  void b(long paramLong1, int paramInt, long paramLong2)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt == 8)
    {
      localObject1 = new VideoViewInfo();
      ((VideoViewInfo)localObject1).jdField_a_of_type_Long = paramLong2;
      ((VideoViewInfo)localObject1).jdField_a_of_type_Int = 2;
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localObject2 });
    }
    else if (this.jdField_d_of_type_Int == 2)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
    }
    boolean bool;
    if (paramInt == 8) {
      bool = a();
    } else {
      bool = true;
    }
    if (((this.jdField_a_of_type_ComTencentAvVideoController.a().y) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ab)) && (bool))
    {
      if (this.e >= 4) {
        return;
      }
      if ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!NetworkUtil.isMobileNetWork((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong1, "drawUI.2", true, true);
        o();
        a(true, true, true);
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable);
      localObject1 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DrawUI:TYPE=");
      ((StringBuilder)localObject2).append(String.valueOf(paramInt));
      ((SmallScreenMultiVideoControlUI.StartRecvVideoRunnable)localObject1).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenMultiVideoControlUI$StartRecvVideoRunnable, 1000L);
    }
  }
  
  void b(long paramLong, boolean paramBoolean)
  {
    long l = a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createOrEnterGAudio, mType[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append("], relationType[");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      ((StringBuilder)localObject).append("], groupId[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], isDoubleAudioToMultiAudio[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, ((StringBuilder)localObject).toString());
    }
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio-->mGroupId == 0");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695865);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    int i = this.jdField_b_of_type_Int;
    if (i == 0)
    {
      if ((this.jdField_a_of_type_ArrayOfLong == null) && (this.jdField_d_of_type_Int == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio uinList is null");
        }
        d(true);
      }
    }
    else if ((i == 1) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_d_of_type_Int, l, this.jdField_a_of_type_ArrayOfLong, false);
    }
  }
  
  void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestVideoTimeoutRunnable-->Remove-->functionName=");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    int j = this.jdField_a_of_type_ComTencentAvVideoController.a().c.size();
    int i = j;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) {
      i = j - 1;
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->There is no dispaly view");
      }
      return false;
    }
    if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1) {
      return false;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
    i = this.jdField_a_of_type_ComTencentAvVideoController.g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecvAllVideo-->VideoAblityLevel=");
      localStringBuilder.append(i);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if (i != 4)
    {
      if (this.jdField_d_of_type_Int == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3007);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().e.clear();
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    i = 0;
    while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().c.size())
    {
      if ((((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(i)).jdField_c_of_type_Boolean) && (l != ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(i)).jdField_a_of_type_Long)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().e.add(this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(i));
      }
      i += 1;
    }
    a(false, false, false);
    return this.jdField_a_of_type_ComTencentAvVideoController.a(false);
  }
  
  void c(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    ITraeMediaPlayerApi localITraeMediaPlayerApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi;
    if (localITraeMediaPlayerApi == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi = ((ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class));
      this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi.init((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    }
    else
    {
      localITraeMediaPlayerApi.stopRing(l);
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (GAudioSoundUtil.a("qav_gaudio_muted.mp3"))
      {
        localITraeMediaPlayerApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(GAudioSoundUtil.a());
        localStringBuilder.append("qav_gaudio_muted.mp3");
        localITraeMediaPlayerApi.playRing(l, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
      }
    }
    else if (GAudioSoundUtil.a("qav_gaudio_cancel_muted.mp3"))
    {
      localITraeMediaPlayerApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(GAudioSoundUtil.a());
      localStringBuilder.append("qav_gaudio_cancel_muted.mp3");
      localITraeMediaPlayerApi.playRing(l, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
    }
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
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.d)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.q();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 9)
        {
          this.jdField_c_of_type_Boolean = true;
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695871);
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          }
        }
        else
        {
          this.jdField_c_of_type_Boolean = false;
        }
        s();
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification;
      if (localObject != null) {
        ((QAVNotification)localObject).a(this.jdField_a_of_type_ComTencentAvVideoController.a().b);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().ae = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.d) {
        i();
      }
      f();
    }
  }
  
  void f()
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.d;
    long l = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_c_of_type_Int, String.valueOf(l));
  }
  
  public void g()
  {
    super.g();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c() != -1)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a("Small_onPause");
    }
  }
  
  void h()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processExtraData-->mType=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().D);
      ((StringBuilder)localObject).append(" IntentGroupId=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long);
      ((StringBuilder)localObject).append(" isInRoom=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.d);
      ((StringBuilder)localObject).append(" mRoomDiscussionId=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
      QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null)
    {
      this.jdField_c_of_type_Int = ((SessionInfo)localObject).k;
      int i = this.jdField_c_of_type_Int;
      if (i == 3000) {
        this.jdField_d_of_type_Int = 2;
      } else if (i == 1) {
        this.jdField_d_of_type_Int = 1;
      } else if (i == 0) {
        this.jdField_d_of_type_Int = 3;
      } else {
        this.jdField_d_of_type_Int = ((SessionInfo)localObject).E;
      }
      this.jdField_b_of_type_Int = ((SessionInfo)localObject).D;
      this.jdField_a_of_type_ArrayOfLong = ((SessionInfo)localObject).jdField_a_of_type_ArrayOfLong;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processExtraData mGroupId = ");
      ((StringBuilder)localObject).append(a());
      QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new SmallScreenMultiVideoControlUI.AutoCheckRunnable(this);
    } else {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  protected void j()
  {
    super.j();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 9)
    {
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695871);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().b()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().g)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a("SmallScreenMultiVideoControlUI.initUI", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long, false);
    }
  }
  
  void k()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeRemoteVideo, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("Meeting_closeRemoteVideo");
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "closeRemoteVideo", false, true);
      o();
    }
    b("closeRemoteVideo");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().c });
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
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoControl is null");
      }
      return;
    }
    StringBuilder localStringBuilder;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.d)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterOrResumeRemoteOrLocalVideo-->mVideoController.mGAudioInRoom =");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.d);
        QLog.e("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
      }
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_a_of_type_Long, 1);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterOrResumeRemoteOrLocalVideo-->index=");
      localStringBuilder.append(i);
      localStringBuilder.append(", onstageNum=");
      localStringBuilder.append(j);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!NetworkUtil.isMobileNetWork((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))
    {
      if (i != -1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.w();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(-1023L, "enterOrResumeRemoteOrLocalVideo", true, true);
        o();
        a(true, true, true);
      }
    }
    else
    {
      if (i != -1) {
        if (this.jdField_a_of_type_ComTencentAvVideoController.b() < jdField_a_of_type_Int)
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.l()) && (QLog.isColorLevel())) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->go on stage fail,can not find the session");
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
          this.jdField_a_of_type_ComTencentAvVideoController.w();
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) {
        b();
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  void o()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchUIMode, sessionType = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI
 * JD-Core Version:    0.7.0.1
 */