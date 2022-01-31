package com.tencent.av.smallscreen;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jqh;
import jql;
import jqm;
import jqn;
import jqo;

public class SmallScreenMultiVideoControlUI
  extends SmallScreenVideoControlUI
{
  static int jdField_a_of_type_Int = 4;
  public long a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jqh(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  TraeMediaPlayer jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  public jqo a;
  boolean jdField_a_of_type_Boolean = false;
  public long[] a;
  public int b;
  Runnable b;
  public int c;
  Runnable c;
  public int d;
  Runnable d;
  
  SmallScreenMultiVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Jqo = new jqo(this);
    this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().i;
  }
  
  public long a()
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
    return localSessionInfo.jdField_f_of_type_Long;
  }
  
  @TargetApi(11)
  public void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "drawUI-->type=" + paramInt1 + " uin=" + paramLong + " fresh=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().an) && (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        TraeHelper.a().a("SmallScreenMultiVideoControlUI.drawUI.1", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
      }
      if ((paramInt1 != 0) && (paramInt1 != 1)) {
        break label371;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().g != 9) {
        break label355;
      }
      localObject2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429411);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.l())
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
          break label341;
        }
        localObject1 = localObject2;
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = true;
      }
      UITools.a(this.jdField_b_of_type_AndroidWidgetTextView, (String)localObject1);
      m();
    }
    label277:
    label341:
    label355:
    label371:
    while ((paramInt1 == 68) || (paramInt1 == 82)) {
      for (;;)
      {
        r();
        return;
        if ((paramInt1 != 1) || (paramLong == this.jdField_a_of_type_Long) || (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2) || (!this.jdField_a_of_type_ComTencentAvVideoController.m())) {
          break;
        }
        TraeHelper.a().a("SmallScreenMultiVideoControlUI.drawUI.2", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
        break;
        localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429423);
        continue;
        if (paramInt1 == 0)
        {
          this.jdField_c_of_type_Boolean = false;
          v();
        }
      }
    }
    if ((paramInt1 == 5) || (paramInt1 == 6))
    {
      paramBoolean = true;
      if (paramLong != this.jdField_a_of_type_Long) {
        break label1345;
      }
    }
    label1339:
    label1343:
    label1345:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt1 == 6)
      {
        boolean bool = a();
        paramBoolean = bool;
        if (paramInt2 != 0)
        {
          paramBoolean = bool;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aq)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
            paramBoolean = bool;
          }
        }
      }
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().an) || (!paramBoolean)) {
        break label277;
      }
      if (this.e >= 4) {
        break;
      }
      if ((NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().as))
      {
        if (paramInt2 == 0)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jqo);
          this.jdField_a_of_type_Jqo.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jqo, 1000L);
          break label277;
        }
        paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_a_of_type_Long, 1);
        int i = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenMultiVideoControlUI", 2, "onSelfVideoIn.-->FirstVideo=" + i + ",index=" + paramInt2);
        }
        if ((i != -1) && ((paramInt2 != i) || (paramInt2 == 0))) {
          break label277;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jqo);
        this.jdField_a_of_type_Jqo.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jqo, 1000L);
        break label277;
      }
      if (paramInt2 != 0) {
        break label277;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
      q();
      a(true, true, true);
      break label277;
      if ((paramInt1 == 7) || (paramInt1 == 8)) {
        if (paramInt1 == 8)
        {
          localObject1 = new VideoViewInfo();
          ((VideoViewInfo)localObject1).jdField_a_of_type_Long = paramLong;
          ((VideoViewInfo)localObject1).jdField_a_of_type_Int = 2;
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(localObject1);
          this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localObject2 });
          label881:
          if (paramInt1 != 8) {
            break label1339;
          }
        }
      }
      for (paramBoolean = a();; paramBoolean = true)
      {
        if (((!this.jdField_a_of_type_ComTencentAvVideoController.a().G) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().an)) || (!paramBoolean)) {
          break label1343;
        }
        if (this.e >= 4) {
          break;
        }
        if ((NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().as))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jqo);
          this.jdField_a_of_type_Jqo.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jqo, 1000L);
          break label277;
          if (this.jdField_d_of_type_Int != 2) {
            break label881;
          }
          ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
          break label881;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
        q();
        a(true, true, true);
        break label277;
        if ((paramInt1 == 97) || (paramInt1 == 98))
        {
          if (!QLog.isColorLevel()) {
            break label277;
          }
          QLog.e("SmallScreenMultiVideoControlUI", 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
          break label277;
        }
        if (paramInt1 != 10) {
          break label277;
        }
        paramBoolean = a();
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().an) || (!paramBoolean)) {
          break label277;
        }
        if (this.e >= 4) {
          break;
        }
        if ((NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().as))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jqo);
          this.jdField_a_of_type_Jqo.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jqo, 1000L);
          break label277;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
        q();
        a(true, true, true);
        break label277;
      }
      break label277;
    }
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
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
        jqm localjqm = new jqm(this, paramInt1, paramLong, paramBoolean, paramInt2);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(localjqm);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->mApp == null");
  }
  
  public void a(String paramString)
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
      this.jdField_b_of_type_JavaLangRunnable = new jqn(this);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if ((((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Long == this.jdField_a_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList });
        return;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    i();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().T)
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().o;
      TraeHelper.a().a(this.jdField_c_of_type_JavaLangString, str);
      TraeHelper.a().b(str);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenMultiVideoControlUI", 2, "switchToGaudio config :" + this.jdField_c_of_type_JavaLangString + "，connectDeviceName : " + str);
      }
    }
    c(paramBoolean);
    r();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.l()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1")))
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130840341);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      if (this.jdField_d_of_type_Int == 2) {
        if (!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
        {
          ReportController.b(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
          {
            if (!paramBoolean2) {
              break label255;
            }
            String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429240);
            TipsManager.a(102, str);
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102, str, false);
          }
        }
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
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
      label255:
      TipsManager.c(102);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102);
      continue;
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        TipsManager.c(102);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(102);
        TipsManager.c(107);
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107);
      }
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      l();
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
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Remove-->FunctionName=" + paramString);
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return false;
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size();
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) {
          i = j - 1;
        }
        if (i != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->There is no dispaly view");
      return false;
    } while ((!VcSystemInfo.b()) || (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1));
    ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
    int i = this.jdField_a_of_type_ComTencentAvVideoController.g();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->VideoAblityLevel=" + i);
    }
    if (i != 4)
    {
      if (this.jdField_d_of_type_Int != 2) {
        break label309;
      }
      ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(62, true);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.clear();
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
      {
        if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i));
        }
        i += 1;
      }
      label309:
      if (this.jdField_d_of_type_Int != 1) {}
    }
    a(false, false, false);
    return this.jdField_a_of_type_ComTencentAvVideoController.e();
  }
  
  public void c()
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
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("SmallScreenMultiVideoControlUI.onDestroy");
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = null;
    }
    super.c();
  }
  
  void c(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 1))
    {
      l();
      d(paramBoolean);
    }
    for (;;)
    {
      g();
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        String str1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().g == 9)
        {
          this.jdField_c_of_type_Boolean = true;
          String str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429411);
          str1 = str2;
          if (this.jdField_a_of_type_ComTencentAvVideoController.l())
          {
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
              str1 = str2;
            }
          }
          else {
            label131:
            if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
            }
          }
        }
        for (;;)
        {
          v();
          break;
          str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429423);
          break label131;
          this.jdField_c_of_type_Boolean = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "handleExterData-->Wrong gaudioStatusType-->type=" + this.jdField_b_of_type_Int + ",relationId=" + a() + ",relationType=" + this.jdField_d_of_type_Int);
      }
    }
  }
  
  void d(boolean paramBoolean)
  {
    long l = a();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio mType: " + this.jdField_b_of_type_Int + ".DiscussionID=" + l);
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
        String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429403);
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        }
        if (this.jdField_b_of_type_Int != 0) {
          break;
        }
      } while ((this.jdField_a_of_type_ArrayOfLong != null) || (this.jdField_d_of_type_Int != 2));
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio uinList is null");
      }
      f(true);
      return;
    } while ((this.jdField_b_of_type_Int != 1) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_d_of_type_Int, l, this.jdField_a_of_type_ArrayOfLong, false);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer = new TraeMediaPlayer((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (!paramBoolean) {
        break label97;
      }
      if (GAudioSoundUtil.a("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("SmallScreenMultiVideoControlUI.playGAudioMicChangedSound.1", 2, 0, null, GAudioSoundUtil.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label97:
    while (!GAudioSoundUtil.a("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("SmallScreenMultiVideoControlUI.playGAudioMicChangedSound");
      break;
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer.a("SmallScreenMultiVideoControlUI.playGAudioMicChangedSound.2", 2, 0, null, GAudioSoundUtil.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onResume");
    }
    String str1;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.e)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.u();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().g != 9) {
          break label223;
        }
        this.jdField_c_of_type_Boolean = true;
        String str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429411);
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentAvVideoController.l())
        {
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
            break label210;
          }
          str1 = str2;
        }
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
        }
      }
    }
    for (;;)
    {
      v();
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().b);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().aq = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.e) {
        j();
      }
      g();
      return;
      label210:
      str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429423);
      break;
      label223:
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(a()), Boolean.valueOf(paramBoolean) });
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.e) {}
    long l = a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_c_of_type_Int, String.valueOf(l));
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1)) {
      this.jdField_a_of_type_ComTencentAvVideoController.f();
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData-->mType=" + this.jdField_a_of_type_ComTencentAvVideoController.a().E + " IntentGroupId=" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long + " isInRoom=" + this.jdField_a_of_type_ComTencentAvVideoController.e + " mRoomDiscussionId=" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo != null)
    {
      this.jdField_c_of_type_Int = localSessionInfo.i;
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
        if (((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 1) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int == 2)) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131429422);
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
      }
    }
  }
  
  void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new jql(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  protected void k()
  {
    super.k();
    String str2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().g == 9)
    {
      str2 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429411);
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.l()) {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1"))) {
          break label156;
        }
      }
    }
    label156:
    for (String str1 = str2;; str1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131429423))
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().T) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a("SmallScreenMultiVideoControlUI.initUI", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long, false);
      }
      return;
    }
  }
  
  void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "closeRemoteVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
      q();
    }
    b("closeRemoteVideo");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList });
    }
  }
  
  public void m()
  {
    n();
  }
  
  void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshGAFList");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) && (QLog.isColorLevel())) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshGAFList-->mVideoContrl is null");
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "goOffStage");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.z();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, false);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
    q();
  }
  
  public void p()
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
        if (!this.jdField_a_of_type_ComTencentAvVideoController.e)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoController.mGAudioInRoom =" + this.jdField_a_of_type_ComTencentAvVideoController.e);
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
            if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvVideoController.k())) {
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
              this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
              this.jdField_a_of_type_ComTencentAvVideoController.y();
            }
          }
        }
      }
      if (i != -1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.y();
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
    q();
    a(true, true, true);
  }
  
  @SuppressLint({"NewApi"})
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "switchUIMode, sessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
  }
  
  void r()
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.l()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m.equals("1")))
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
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (i != 0)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(i);
      }
      return;
      i = 2131429403;
      continue;
      i = 2131429411;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI
 * JD-Core Version:    0.7.0.1
 */