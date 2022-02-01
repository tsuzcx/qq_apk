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
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bocm
  extends QIMEffectCameraCaptureUnit
{
  public static long a;
  private SessionWrap a;
  public boolean a;
  private int d;
  private String l;
  private String m;
  private boolean y;
  private boolean z = false;
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public bocm(bqai parambqai, bqah parambqah)
  {
    super(parambqai, parambqah);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bqaa = new bqaa(10000, 100, 2);
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
    bozv.a().a(i, str);
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bozv.a().a(str);
    bozv.a().a(true);
    bozv.a().a();
    bozv.a().b();
    bozv.a().b(boqg.a(a()));
    bozr.a().Y();
  }
  
  public int a()
  {
    return 2131560977;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.z) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(2);
    }
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
    bpty.jdField_a_of_type_Bptz.a(3, System.currentTimeMillis());
    bpty.a();
    if (bcwd.j != 0L)
    {
      bcwd.k = System.currentTimeMillis();
      QLog.d("CAM_START_MONITOR", 1, new Object[] { "aio cost: ", Long.valueOf(bcwd.k - bcwd.jdField_b_of_type_Long), "\nStartClick cost: ", Long.valueOf(bcwd.jdField_b_of_type_Long - bcwd.jdField_a_of_type_Long), "\nStartActiv cost: ", Long.valueOf(bcwd.c - bcwd.jdField_b_of_type_Long), "\nStartProce cost: ", Long.valueOf(bcwd.d - bcwd.c), "\nCreateBase cost: ", Long.valueOf(bcwd.e - bcwd.d), "\nCreateQimA cost: ", Long.valueOf(bcwd.f - bcwd.e), "\nStartBaseA cost: ", Long.valueOf(bcwd.g - bcwd.f), "\nStartQimAc cost: ", Long.valueOf(bcwd.h - bcwd.g), "\nResumeBase cost: ", Long.valueOf(bcwd.i - bcwd.h), "\nResumeQimA cost: ", Long.valueOf(bcwd.j - bcwd.i), "\nFirstFrame cost: ", Long.valueOf(bcwd.k - bcwd.j), "\nPeakCreatS cost: ", Long.valueOf(bcwd.l - bcwd.d), "\nPeakCreatT cost: ", Long.valueOf(bcwd.m - bcwd.l) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap.a());
    }
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(false);
      boed.a(this.jdField_a_of_type_Bqai.a(), paramIntent, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_Bqah, null);
    }
    while ((paramInt1 != 1012) || (paramInt2 != -1)) {
      return;
    }
    if (paramIntent != null) {}
    for (String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");; str = "")
    {
      boolean bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getBooleanExtra("input_full_screen_mode", false)) {
          bool1 = true;
        }
      }
      paramIntent = new Intent();
      paramIntent.putExtra("input_full_screen_mode_result", str);
      paramIntent.putExtra("input_full_screen_mode", bool1);
      a().setResult(-1, paramIntent);
      a().finish();
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Bqai.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.l = this.jdField_a_of_type_Bqai.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    paramBundle = this.jdField_a_of_type_Bqai.a().getIntent();
    long l1 = paramBundle.getLongExtra("ACTIVITY_START_TIME", -1L);
    int i = paramBundle.getIntExtra("edit_video_type", 10000);
    if ((bpty.jdField_a_of_type_Boolean) && (i == 10000)) {}
    for (boolean bool = true;; bool = false)
    {
      bpty.b = bool;
      if (bpty.b)
      {
        bpty.jdField_a_of_type_Bptz.b();
        bpty.jdField_a_of_type_Bptz.a(0, l1);
        bpty.jdField_a_of_type_Bptz.a(1, System.currentTimeMillis());
      }
      l1 = this.jdField_a_of_type_Bqai.a().getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L);
      if (l1 != 0L)
      {
        bcwd.d = QLog.sInitLogTime;
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_PEAK_ATTACH ", Long.valueOf(bcwd.d) });
        bcwd.jdField_a_of_type_Long = this.jdField_a_of_type_Bqai.a().getIntent().getLongExtra("TIMESTAMP_PRELOAD_PEAK", 0L);
        bcwd.jdField_b_of_type_Long = this.jdField_a_of_type_Bqai.a().getIntent().getLongExtra("TIMESTAMP_CLICK_CAMERA", 0L);
        bcwd.c = l1;
        bcwd.f = System.currentTimeMillis();
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONCREATE ", Long.valueOf(bcwd.f) });
      }
      return;
    }
  }
  
  public void a(bbhq parambbhq)
  {
    super.a(parambbhq);
    bqab localbqab = new bqad(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).a(this.jdField_a_of_type_DovComQqImAeSessionWrap).a(this.l).a(1).b(106).a();
    this.jdField_a_of_type_Bqaa.a(localbqab);
    brdx.a(this.jdField_a_of_type_Bqai.a(), parambbhq, this.jdField_a_of_type_Bqaa, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
    yup.a("clk_shoot", yup.b(this.jdField_a_of_type_Bqaa.a()), 1, false, new String[0]);
    bozv.a().b(1L);
    bozr.a().c(-1L);
    yup.a("check_beacon_Android", 14, 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    a(paramLocalMediaInfo);
    bqae localbqae = new bqag().c(true).e(false).a(true).l(true).b(1).a();
    this.jdField_a_of_type_Bqaa.a(localbqae);
    brdx.a(this.jdField_a_of_type_Bqai.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Bqaa, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
    yup.a("clk_shoot", yup.b(this.jdField_a_of_type_Bqaa.a()), 3, false, new String[0]);
    bozv.a().b(2L);
    bozr.a().c(paramLocalMediaInfo.mDuration);
    yup.a("check_beacon_Android", 14, 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
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
      yup.a("video_shoot_new", "time_waitshoot", yup.b(10000), i, new String[] { "", "1", "", "" });
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
    Activity localActivity = this.jdField_a_of_type_Bqai.a();
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
      yup.a("video_shoot_new", "time_openshoot", yup.b(10000), i, new String[] { str, localObject1, "", String.valueOf(k) });
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
    bozv.a().a(false);
    bczl.a(this.jdField_m_of_type_Boolean, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.x, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.j(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.y);
  }
  
  public void f()
  {
    super.f();
    bpty.jdField_a_of_type_Bptz.a(2, System.currentTimeMillis());
    if (bcwd.jdField_b_of_type_Long != 0L)
    {
      bcwd.j = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONRESUME ", Long.valueOf(bcwd.j) });
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
      yup.a("video_shoot_new", "time_waitshoot", yup.b(10000), i, new String[] { "", "0", "", "" });
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
    Bundle localBundle = this.jdField_a_of_type_Bqai.a().getIntent().getExtras();
    this.y = localBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.d = localBundle.getInt("ARG_DD_CATEGORY_ID");
    this.jdField_m_of_type_JavaLangString = localBundle.getString("ARG_DD_ITEM_ID");
    this.z = localBundle.getBoolean("input_full_screen_mode");
  }
  
  public void p()
  {
    super.p();
    if (bcwd.jdField_b_of_type_Long != 0L)
    {
      bcwd.h = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONSTART ", Long.valueOf(bcwd.h) });
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
      yup.a("video_shoot_new", "time_waitshoot", yup.b(10000), i, new String[] { "", "0", "", "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocm
 * JD-Core Version:    0.7.0.1
 */