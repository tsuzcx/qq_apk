import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureSegmentView;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ptv.LightWeightProgress;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.1;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.2;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.3;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.4;
import dov.com.qq.im.ptv.PtvCameraCaptureActivity;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class bhyn
  implements View.OnClickListener, auut, awfg, awfi, bhzd
{
  private int jdField_a_of_type_Int;
  protected long a;
  protected View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhzb jdField_a_of_type_Bhzb;
  private bhzc jdField_a_of_type_Bhzc;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected CameraCaptureSegmentView a;
  public CircleProgress a;
  protected LightWeightProgress a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public bhyn(bhzc parambhzc, bhzb parambhzb)
  {
    this.jdField_a_of_type_Bhzc = parambhzc;
    this.jdField_a_of_type_Bhzb = parambhzb;
  }
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new LightWeightSoDownloadUnit.2(this, paramString));
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new LightWeightSoDownloadUnit.3(this, paramString));
  }
  
  private void c()
  {
    boolean bool = badq.g(null);
    VideoEnvironment.a("LightWeightSoDownloadUnit", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("LightWeightSoDownloadUnit", ajjy.a(2131640283), null);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    a(ajjy.a(2131640299));
  }
  
  public void I_()
  {
    a(ajjy.a(2131640289));
    VideoEnvironment.a("LightWeightSoDownloadUnit", ajjy.a(2131640295), null);
    awek.a(3, -1500);
  }
  
  public void J_()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(this.jdField_a_of_type_Bhzc.a() instanceof PtvCameraCaptureActivity)) {
      return;
    }
    PtvCameraCaptureActivity localPtvCameraCaptureActivity = (PtvCameraCaptureActivity)this.jdField_a_of_type_Bhzc.a();
    int i;
    if (localPtvCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localPtvCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label93;
      }
    }
    label93:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label98;
      }
      localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label98:
    if (i != 0)
    {
      localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  protected int a()
  {
    return 2131494963;
  }
  
  public View a()
  {
    Object localObject = new RelativeLayout(this.jdField_a_of_type_Bhzc.a());
    ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localObject = this.jdField_a_of_type_Bhzc.a().getLayoutInflater().inflate(a(), (ViewGroup)localObject, false);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131300884);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298339));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView = ((CameraCaptureSegmentView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298277));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setUseVideoOrientation(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDynamicResolutionMode(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)((View)localObject).findViewById(2131299259));
    Resources localResources = this.jdField_a_of_type_Bhzc.a().getResources();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, localResources.getColor(2131101537), 100, localResources.getColor(2131099760));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress = ((LightWeightProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131306333));
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStrokeWidth(3.0F);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297450));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131300882));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_Bhzc.a());
    if (!VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bbmy.a(VideoEnvironment.a(), ajjy.a(2131640297), 1);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      boolean bool = VideoEnvironment.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (awlw.a(this.jdField_a_of_type_Bhzc.a()) != 2) {}
      for (int i = 1;; i = 0)
      {
        if ((bool) && (i != 0)) {
          break label398;
        }
        awek.a(2);
        c();
        break;
      }
      label398:
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Int = 100;
      this.jdField_b_of_type_Boolean = true;
      VideoEnvironment.a("LightWeightSoDownloadUnit", "checkAVCodecLoadIsOK loaded=true", null);
      ThreadManager.getUIHandler().postDelayed(new LightWeightSoDownloadUnit.1(this), 5L);
    }
  }
  
  protected auuv a()
  {
    return bjef.a().c(this.jdField_a_of_type_Bhzc.a());
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      bhyq localbhyq = (bhyq)this.jdField_a_of_type_Bhzc.a();
      if (localbhyq != null) {
        localbhyq.b();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("LightWeightSoDownloadUnit", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("LightWeightSoDownloadUnit", ajjy.a(2131640290) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(ajjy.a(2131640282));
        awek.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("LightWeightSoDownloadUnit", ajjy.a(2131640278), null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        paramInt1 = awlw.a(VideoEnvironment.a());
        VideoEnvironment.a("LightWeightSoDownloadUnit", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2)
        {
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
          return;
        }
        if (paramInt1 == 1) {
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        }
        this.jdField_b_of_type_Int = 100;
        this.jdField_b_of_type_Boolean = true;
        VideoEnvironment.a("LightWeightSoDownloadUnit", "onConfigResult| supportSVFilterDownloadSo=false", null);
        return;
      }
      VideoEnvironment.a("LightWeightSoDownloadUnit", ajjy.a(2131640285) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(ajjy.a(2131640279));
      awek.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("LightWeightSoDownloadUnit", ajjy.a(2131640294) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(ajjy.a(2131640305));
    awek.a(1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Bhzc.a().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        VideoEnvironment.a("LightWeightSoDownloadUnit", ajjy.a(2131640287) + paramInt + "]", null);
        ShortVideoResourceManager.a(ajjy.a(2131640293));
        awek.a(2, paramInt);
      }
    }
    for (;;)
    {
      VideoEnvironment.a("LightWeightSoDownloadUnit", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      a();
      continue;
      if (paramString1.startsWith("new_qq_android_native_short_filter_")) {
        if (paramInt != 0)
        {
          VideoEnvironment.a("LightWeightSoDownloadUnit", ajjy.a(2131640312) + paramInt + "]", null);
          ShortVideoResourceManager.a(ajjy.a(2131640301));
          awek.a(2, paramInt);
        }
        else
        {
          this.jdField_b_of_type_Int = 100;
          this.jdField_b_of_type_Boolean = true;
          a();
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    for (;;)
    {
      this.c = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
      b("doUserDownloadResourceAVCodec:");
      a(ajjy.a(2131640298) + this.c + "%");
      VideoEnvironment.a("LightWeightSoDownloadUnit", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramString.startsWith("new_qq_android_native_short_filter_")) {
        this.jdField_b_of_type_Int = i;
      }
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Bhzc.a();
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b_(int paramInt1, int paramInt2) {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.onPause();
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int j = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Bhzc.a();
    int i;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label78;
      }
      label41:
      if ((i == 0) || (j == 0)) {
        break label83;
      }
      localObject = ajjy.a(2131640296);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new LightWeightSoDownloadUnit.4(this, (String)localObject));
      return;
      i = 0;
      break;
      label78:
      j = 0;
      break label41;
      label83:
      if (i != 0) {
        localObject = ajjy.a(2131640309);
      } else {
        localObject = ajjy.a(2131640284);
      }
    }
  }
  
  public void e()
  {
    GLGestureProxy.getInstance().removeAllListener();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightSoDownloadUnit", 2, "onActivityResume");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.onResume();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionResult(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a();
  }
  
  public void p() {}
  
  public void q() {}
  
  public void r() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhyn
 * JD-Core Version:    0.7.0.1
 */