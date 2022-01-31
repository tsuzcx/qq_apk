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
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.story.SessionWrap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bhdh
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
  
  public bhdh(bhzc parambhzc, bhzb parambhzb)
  {
    super(parambhzc, parambhzb);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bhyu = new bhyu(10000, 100, 2);
    this.jdField_a_of_type_Int = 1;
    ad();
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
  
  private void ad()
  {
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    bhcm.a().a(i, str);
    bhcm.a().a(bhfc.a());
    bhcm.a().a(true);
    bhcm.a().a();
    bhcm.a().b();
    bhcm.a().a(avzk.a(a()));
    bhci.a().B();
  }
  
  public int a()
  {
    return 2131494974;
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
    bhnt.jdField_a_of_type_Bhnu.a(3, System.currentTimeMillis());
    bhnt.a();
    if (awdp.j != 0L)
    {
      awdp.k = System.currentTimeMillis();
      QLog.d("CAM_START_MONITOR", 1, new Object[] { "aio cost: ", Long.valueOf(awdp.k - awdp.jdField_b_of_type_Long), "\nStartClick cost: ", Long.valueOf(awdp.jdField_b_of_type_Long - awdp.jdField_a_of_type_Long), "\nStartActiv cost: ", Long.valueOf(awdp.c - awdp.jdField_b_of_type_Long), "\nStartProce cost: ", Long.valueOf(awdp.d - awdp.c), "\nCreateBase cost: ", Long.valueOf(awdp.e - awdp.d), "\nCreateQimA cost: ", Long.valueOf(awdp.f - awdp.e), "\nStartBaseA cost: ", Long.valueOf(awdp.g - awdp.f), "\nStartQimAc cost: ", Long.valueOf(awdp.h - awdp.g), "\nResumeBase cost: ", Long.valueOf(awdp.i - awdp.h), "\nResumeQimA cost: ", Long.valueOf(awdp.j - awdp.i), "\nFirstFrame cost: ", Long.valueOf(awdp.k - awdp.j), "\nPeakCreatS cost: ", Long.valueOf(awdp.l - awdp.d), "\nPeakCreatT cost: ", Long.valueOf(awdp.m - awdp.l) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImStorySessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImStorySessionWrap.a());
    }
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(false);
      bhez.a(this.jdField_a_of_type_Bhzc.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_Bhzb, null);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImStorySessionWrap = ((SessionWrap)this.jdField_a_of_type_Bhzc.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.l = this.jdField_a_of_type_Bhzc.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    paramBundle = this.jdField_a_of_type_Bhzc.a().getIntent();
    long l1 = paramBundle.getLongExtra("ACTIVITY_START_TIME", -1L);
    int i = paramBundle.getIntExtra("edit_video_type", 10000);
    if ((bhnt.jdField_a_of_type_Boolean) && (i == 10000)) {}
    for (boolean bool = true;; bool = false)
    {
      bhnt.b = bool;
      if (bhnt.b)
      {
        bhnt.jdField_a_of_type_Bhnu.b();
        bhnt.jdField_a_of_type_Bhnu.a(0, l1);
        bhnt.jdField_a_of_type_Bhnu.a(1, System.currentTimeMillis());
      }
      l1 = this.jdField_a_of_type_Bhzc.a().getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L);
      if (l1 != 0L)
      {
        awdp.d = QLog.sInitLogTime;
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_PEAK_ATTACH ", Long.valueOf(awdp.d) });
        awdp.jdField_a_of_type_Long = this.jdField_a_of_type_Bhzc.a().getIntent().getLongExtra("TIMESTAMP_PRELOAD_PEAK", 0L);
        awdp.jdField_b_of_type_Long = this.jdField_a_of_type_Bhzc.a().getIntent().getLongExtra("TIMESTAMP_CLICK_CAMERA", 0L);
        awdp.c = l1;
        awdp.f = System.currentTimeMillis();
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONCREATE ", Long.valueOf(awdp.f) });
      }
      return;
    }
  }
  
  public void a(auuy paramauuy)
  {
    super.a(paramauuy);
    bhyv localbhyv = new bhyx(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(this.jdField_a_of_type_DovComQqImStorySessionWrap).a(this.l).a(1).b(106).a();
    this.jdField_a_of_type_Bhyu.a(localbhyv);
    bjeg.a(this.jdField_a_of_type_Bhzc.a(), paramauuy, this.jdField_a_of_type_Bhyu, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
    urp.a("clk_shoot", urp.b(this.jdField_a_of_type_Bhyu.a()), 1, false, new String[0]);
    bhcm.a().b(1L);
    bhci.a().b(-1L);
    urp.a("check_beacon_Android", 14, 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    a(paramLocalMediaInfo);
    bhyy localbhyy = new bhza().c(true).e(false).a(true).l(true).b(1).a();
    this.jdField_a_of_type_Bhyu.a(localbhyy);
    bjeg.a(this.jdField_a_of_type_Bhzc.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Bhyu, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
    urp.a("clk_shoot", urp.b(this.jdField_a_of_type_Bhyu.a()), 3, false, new String[0]);
    bhcm.a().b(2L);
    bhci.a().b(paramLocalMediaInfo.mDuration);
    urp.a("check_beacon_Android", 14, 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
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
      urp.a("video_shoot_new", "time_waitshoot", urp.b(10000), i, new String[] { "", "1", "", "" });
      return bool;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_DovComQqImStorySessionWrap.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if ((this.jdField_a_of_type_DovComQqImStorySessionWrap.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_DovComQqImStorySessionWrap.jdField_a_of_type_Int == 1)) {
      return 2;
    }
    return 3;
  }
  
  public void b(long paramLong)
  {
    int j = 0;
    Activity localActivity = this.jdField_a_of_type_Bhzc.a();
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
      urp.a("video_shoot_new", "time_openshoot", urp.b(10000), i, new String[] { str, localObject1, "", String.valueOf(k) });
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
    bhcm.a().a(false);
    awgw.a(this.jdField_m_of_type_Boolean, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.x, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.j(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.y);
  }
  
  public void f()
  {
    super.f();
    bhnt.jdField_a_of_type_Bhnu.a(2, System.currentTimeMillis());
    if (awdp.jdField_b_of_type_Long != 0L)
    {
      awdp.j = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONRESUME ", Long.valueOf(awdp.j) });
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
      urp.a("video_shoot_new", "time_waitshoot", urp.b(10000), i, new String[] { "", "0", "", "" });
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
    Bundle localBundle = this.jdField_a_of_type_Bhzc.a().getIntent().getExtras();
    this.y = localBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.d = localBundle.getInt("ARG_DD_CATEGORY_ID");
    this.jdField_m_of_type_JavaLangString = localBundle.getString("ARG_DD_ITEM_ID");
  }
  
  public void q()
  {
    super.q();
    if (awdp.jdField_b_of_type_Long != 0L)
    {
      awdp.h = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONSTART ", Long.valueOf(awdp.h) });
    }
  }
  
  public void u()
  {
    if (this.jdField_b_of_type_Int == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().j();
    }
    super.u();
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
      urp.a("video_shoot_new", "time_waitshoot", urp.b(10000), i, new String[] { "", "0", "", "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhdh
 * JD-Core Version:    0.7.0.1
 */