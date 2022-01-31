import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bigo
  extends QIMEffectCameraCaptureUnit
{
  public static long a;
  private SessionWrap a;
  public boolean a;
  private int d;
  private String l;
  private String m;
  private boolean y;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public bigo(bjrl parambjrl, bjrk parambjrk)
  {
    super(parambjrl, parambjrk);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bjrd = new bjrd(10000, 100, 2);
    this.jdField_a_of_type_Int = 1;
    ac();
  }
  
  public static Bundle a(SessionWrap paramSessionWrap, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putInt("edit_video_type", paramInt1);
    localBundle.putInt("entrance_type", paramInt2);
    localBundle.putString("ARG_AIO_CLASS", paramString);
    if (paramInt1 == 10000) {
      localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    }
    localBundle.putBoolean("enable_local_video", false);
    return localBundle;
  }
  
  public static Bundle a(SessionWrap paramSessionWrap, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putInt("edit_video_type", paramInt1);
    localBundle.putInt("entrance_type", paramInt2);
    localBundle.putString("ARG_AIO_CLASS", paramString1);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putBoolean("enable_local_video", false);
    localBundle.putBoolean("ARG_UNFOLD_DD", paramBoolean);
    localBundle.putInt("ARG_DD_CATEGORY_ID", paramInt3);
    localBundle.putString("ARG_DD_ITEM_ID", paramString2);
    return localBundle;
  }
  
  private void ac()
  {
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    bizx.a().a(i, str);
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bizx.a().a(str);
    bizx.a().a(true);
    bizx.a().a();
    bizx.a().b();
    bizx.a().b(biqu.a(a()));
    bizt.a().D();
  }
  
  public int a()
  {
    return 2131560547;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    return localView;
  }
  
  protected List<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_AndroidWidgetTextView);
    return localArrayList;
  }
  
  public void a()
  {
    super.a();
    bjjc.jdField_a_of_type_Bjjd.a(3, System.currentTimeMillis());
    bjjc.a();
    if (axcz.j != 0L)
    {
      axcz.k = System.currentTimeMillis();
      QLog.d("CAM_START_MONITOR", 1, new Object[] { "aio cost: ", Long.valueOf(axcz.k - axcz.jdField_b_of_type_Long), "\nStartClick cost: ", Long.valueOf(axcz.jdField_b_of_type_Long - axcz.jdField_a_of_type_Long), "\nStartActiv cost: ", Long.valueOf(axcz.c - axcz.jdField_b_of_type_Long), "\nStartProce cost: ", Long.valueOf(axcz.d - axcz.c), "\nCreateBase cost: ", Long.valueOf(axcz.e - axcz.d), "\nCreateQimA cost: ", Long.valueOf(axcz.f - axcz.e), "\nStartBaseA cost: ", Long.valueOf(axcz.g - axcz.f), "\nStartQimAc cost: ", Long.valueOf(axcz.h - axcz.g), "\nResumeBase cost: ", Long.valueOf(axcz.i - axcz.h), "\nResumeQimA cost: ", Long.valueOf(axcz.j - axcz.i), "\nFirstFrame cost: ", Long.valueOf(axcz.k - axcz.j), "\nPeakCreatS cost: ", Long.valueOf(axcz.l - axcz.d), "\nPeakCreatT cost: ", Long.valueOf(axcz.m - axcz.l) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap.a());
    }
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(false);
      biig.a(this.jdField_a_of_type_Bjrl.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_Bjrk, null);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Bjrl.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.l = this.jdField_a_of_type_Bjrl.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    paramBundle = this.jdField_a_of_type_Bjrl.a().getIntent();
    long l1 = paramBundle.getLongExtra("ACTIVITY_START_TIME", -1L);
    int i = paramBundle.getIntExtra("edit_video_type", 10000);
    if ((bjjc.jdField_a_of_type_Boolean) && (i == 10000)) {}
    for (boolean bool = true;; bool = false)
    {
      bjjc.b = bool;
      if (bjjc.b)
      {
        bjjc.jdField_a_of_type_Bjjd.b();
        bjjc.jdField_a_of_type_Bjjd.a(0, l1);
        bjjc.jdField_a_of_type_Bjjd.a(1, System.currentTimeMillis());
      }
      l1 = this.jdField_a_of_type_Bjrl.a().getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L);
      if (l1 != 0L)
      {
        axcz.d = QLog.sInitLogTime;
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_PEAK_ATTACH ", Long.valueOf(axcz.d) });
        axcz.jdField_a_of_type_Long = this.jdField_a_of_type_Bjrl.a().getIntent().getLongExtra("TIMESTAMP_PRELOAD_PEAK", 0L);
        axcz.jdField_b_of_type_Long = this.jdField_a_of_type_Bjrl.a().getIntent().getLongExtra("TIMESTAMP_CLICK_CAMERA", 0L);
        axcz.c = l1;
        axcz.f = System.currentTimeMillis();
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONCREATE ", Long.valueOf(axcz.f) });
      }
      return;
    }
  }
  
  public void a(avuo paramavuo)
  {
    super.a(paramavuo);
    bjre localbjre = new bjrg(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(this.jdField_a_of_type_DovComQqImAeSessionWrap).a(this.l).a(1).b(106).a();
    this.jdField_a_of_type_Bjrd.a(localbjre);
    bkvh.a(this.jdField_a_of_type_Bjrl.a(), paramavuo, this.jdField_a_of_type_Bjrd, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
    vei.a("clk_shoot", vei.b(this.jdField_a_of_type_Bjrd.a()), 1, false, new String[0]);
    bizx.a().b(1L);
    bizt.a().b(-1L);
    vei.a("check_beacon_Android", 14, 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    a(paramLocalMediaInfo);
    bjrh localbjrh = new bjrj().c(true).e(false).a(true).l(true).b(1).a();
    this.jdField_a_of_type_Bjrd.a(localbjrh);
    bkvh.a(this.jdField_a_of_type_Bjrl.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Bjrd, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
    vei.a("clk_shoot", vei.b(this.jdField_a_of_type_Bjrd.a()), 3, false, new String[0]);
    bizx.a().b(2L);
    bizt.a().b(paramLocalMediaInfo.mDuration);
    vei.a("check_beacon_Android", 14, 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
  }
  
  protected void a(CameraCaptureView paramCameraCaptureView)
  {
    if (paramCameraCaptureView != null) {
      paramCameraCaptureView.d(true);
    }
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if ((!this.jdField_a_of_type_Boolean) && (bool))
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label88;
      }
    }
    label88:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      vei.a("video_shoot_new", "time_waitshoot", vei.b(10000), i, new String[] { "", "1", "", "" });
      return bool;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_DovComQqImAeSessionWrap.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if ((this.jdField_a_of_type_DovComQqImAeSessionWrap.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_DovComQqImAeSessionWrap.jdField_a_of_type_Int == 1)) {
      return 2;
    }
    return 3;
  }
  
  public void b(long paramLong)
  {
    int j = 0;
    Activity localActivity = this.jdField_a_of_type_Bjrl.a();
    int k = localActivity.getIntent().getIntExtra("entrance_type", 1);
    String str;
    Object localObject2;
    int i;
    if (localActivity.getIntent().hasExtra("pendingIntentClass"))
    {
      str = "1";
      localObject2 = "0";
      i = j;
      if (this.jdField_b_of_type_Long != -1L)
      {
        i = j;
        if (str.equals("0")) {
          i = (int)(paramLong - this.jdField_b_of_type_Long);
        }
      }
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT < 23) {}
    }
    for (;;)
    {
      try
      {
        if (localActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          continue;
        }
        bool1 = true;
        if (localActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
          continue;
        }
        bool2 = true;
        if (localActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          continue;
        }
        bool3 = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AIOEffectsCameraCaptureFragment", 2, new Object[] { "checkSelfPermission ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool3) });
      }
      catch (Exception localException)
      {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        localObject1 = "4";
        QLog.e("AIOEffectsCameraCaptureFragment", 1, "checkSelfPermission error, ", localException);
        continue;
        if ((bool1) || (bool2)) {
          continue;
        }
        localObject1 = localException;
        if (!bool3) {
          continue;
        }
        continue;
      }
      localObject1 = "";
      if (bool1) {
        localObject1 = "".concat("1");
      }
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = ((String)localObject1).concat(",3");
      }
      localObject1 = localObject2;
      if (bool3) {
        localObject1 = ((String)localObject2).concat(",2");
      }
      vei.a("video_shoot_new", "time_openshoot", vei.b(10000), i, new String[] { str, localObject1, "", String.valueOf(k) });
      return;
      str = "0";
      break;
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      bool3 = false;
    }
  }
  
  public void e()
  {
    super.e();
    bizx.a().a(false);
    axge.a(this.jdField_m_of_type_Boolean, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.x, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.j(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.y);
  }
  
  public void f()
  {
    super.f();
    bjjc.jdField_a_of_type_Bjjd.a(2, System.currentTimeMillis());
    if (axcz.jdField_b_of_type_Long != 0L)
    {
      axcz.j = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONRESUME ", Long.valueOf(axcz.j) });
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void j()
  {
    if (this.jdField_b_of_type_Int == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().h();
    }
    super.j();
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label106;
      }
    }
    label106:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      vei.a("video_shoot_new", "time_waitshoot", vei.b(10000), i, new String[] { "", "0", "", "" });
      return;
    }
  }
  
  public void n()
  {
    super.n();
    if (this.y) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(102, this.d, this.jdField_m_of_type_JavaLangString);
    }
  }
  
  public void o()
  {
    Bundle localBundle = this.jdField_a_of_type_Bjrl.a().getIntent().getExtras();
    this.y = localBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.d = localBundle.getInt("ARG_DD_CATEGORY_ID");
    this.jdField_m_of_type_JavaLangString = localBundle.getString("ARG_DD_ITEM_ID");
  }
  
  public void p()
  {
    super.p();
    if (axcz.jdField_b_of_type_Long != 0L)
    {
      axcz.h = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONSTART ", Long.valueOf(axcz.h) });
    }
  }
  
  public void q()
  {
    if (this.jdField_b_of_type_Int == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().j();
    }
    super.q();
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label106;
      }
    }
    label106:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      vei.a("video_shoot_new", "time_waitshoot", vei.b(10000), i, new String[] { "", "0", "", "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigo
 * JD-Core Version:    0.7.0.1
 */