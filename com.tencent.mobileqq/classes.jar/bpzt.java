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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class bpzt
  implements View.OnClickListener, bbhl, bcxw, bcxy, bori, bqaj
{
  private int jdField_a_of_type_Int;
  protected long a;
  protected View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bqah jdField_a_of_type_Bqah;
  private bqai jdField_a_of_type_Bqai;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected CameraCaptureSegmentView a;
  public CircleProgress a;
  protected LightWeightProgress a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public bpzt(bqai parambqai, bqah parambqah)
  {
    this.jdField_a_of_type_Bqai = parambqai;
    this.jdField_a_of_type_Bqah = parambqah;
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
    boolean bool = bhnv.g(null);
    VideoEnvironment.a("LightWeightSoDownloadUnit", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("LightWeightSoDownloadUnit", anzj.a(2131704981), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    a(anzj.a(2131704997));
  }
  
  public void B_()
  {
    a(anzj.a(2131704987));
    VideoEnvironment.a("LightWeightSoDownloadUnit", anzj.a(2131704993), null);
    bcwy.a(3, -1500);
  }
  
  public void C_()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(this.jdField_a_of_type_Bqai.a() instanceof PtvCameraCaptureActivity)) {
      return;
    }
    PtvCameraCaptureActivity localPtvCameraCaptureActivity = (PtvCameraCaptureActivity)this.jdField_a_of_type_Bqai.a();
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
    return 2131560966;
  }
  
  public View a()
  {
    Object localObject = new RelativeLayout(this.jdField_a_of_type_Bqai.a());
    ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localObject = this.jdField_a_of_type_Bqai.a().getLayoutInflater().inflate(a(), (ViewGroup)localObject, false);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131366922);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364198));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView = ((CameraCaptureSegmentView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364134));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setUseVideoOrientation(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDynamicResolutionMode(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)((View)localObject).findViewById(2131365187));
    Resources localResources = this.jdField_a_of_type_Bqai.a().getResources();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, localResources.getColor(2131167302), 100, localResources.getColor(2131165367));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress = ((LightWeightProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131373074));
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStrokeWidth(3.0F);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363234));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366920));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_Bqai.a());
    if (!VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      QQToast.a(VideoEnvironment.a(), anzj.a(2131704995), 1);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      boolean bool = VideoEnvironment.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bork.a(borf.jdField_b_of_type_Borf) != 2) {}
      for (int i = 1;; i = 0)
      {
        if ((bool) && (i != 0)) {
          break label392;
        }
        bcwy.a(2);
        c();
        break;
      }
      label392:
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Int = 100;
      this.jdField_b_of_type_Boolean = true;
      VideoEnvironment.a("LightWeightSoDownloadUnit", "checkAVCodecLoadIsOK loaded=true", null);
      ThreadManager.getUIHandler().postDelayed(new LightWeightSoDownloadUnit.1(this), 5L);
    }
  }
  
  protected bbhn a()
  {
    return brdw.a().c(this.jdField_a_of_type_Bqai.a());
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      bpzw localbpzw = (bpzw)this.jdField_a_of_type_Bqai.a();
      if (localbpzw != null) {
        localbpzw.b();
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
        VideoEnvironment.a("LightWeightSoDownloadUnit", anzj.a(2131704988) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(anzj.a(2131704980));
        bcwy.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("LightWeightSoDownloadUnit", anzj.a(2131704976), null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        paramInt1 = bork.a(borf.jdField_b_of_type_Borf);
        VideoEnvironment.a("LightWeightSoDownloadUnit", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2)
        {
          borg.a().a(borf.jdField_b_of_type_Borf, this, false);
          return;
        }
        if (paramInt1 == 1) {
          borg.a().a(borf.jdField_b_of_type_Borf, this, false);
        }
        this.jdField_b_of_type_Int = 100;
        this.jdField_b_of_type_Boolean = true;
        VideoEnvironment.a("LightWeightSoDownloadUnit", "onConfigResult| supportSVFilterDownloadSo=false", null);
        return;
      }
      VideoEnvironment.a("LightWeightSoDownloadUnit", anzj.a(2131704983) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(anzj.a(2131704977));
      bcwy.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("LightWeightSoDownloadUnit", anzj.a(2131704992) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(anzj.a(2131705003));
    bcwy.a(1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Bqai.a().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
  }
  
  public void a(borf paramborf, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if ((paramborf != null) && (paramborf.jdField_b_of_type_JavaLangString != null) && (paramborf.jdField_b_of_type_JavaLangString.equals(borf.jdField_b_of_type_Borf.jdField_b_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = i;
    }
    this.c = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
    b("doUserDownloadResourceAVCodec:");
    a(anzj.a(2131704996) + this.c + "%");
    VideoEnvironment.a("LightWeightSoDownloadUnit", "name=" + paramborf.jdField_b_of_type_JavaLangString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
  
  public void a(borf paramborf, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramborf != null) && (paramborf.jdField_b_of_type_JavaLangString != null) && (paramborf.jdField_b_of_type_JavaLangString.equals(borf.jdField_b_of_type_Borf.jdField_b_of_type_JavaLangString)))
    {
      if (paramInt != 0)
      {
        bpam.d("LightWeightSoDownloadUnit", "[onAEDownloadFinish] error:" + paramInt);
        VideoEnvironment.a("LightWeightSoDownloadUnit", anzj.a(2131705010) + paramInt + "]", null);
        ShortVideoResourceManager.a(anzj.a(2131704999));
        bcwy.a(2, paramInt);
      }
    }
    else {
      return;
    }
    bpam.b("LightWeightSoDownloadUnit", "[onAEDownloadFinish] mFilterState 100");
    this.jdField_b_of_type_Int = 100;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label110;
      }
      VideoEnvironment.a("LightWeightSoDownloadUnit", anzj.a(2131704985) + paramInt + "]", null);
      ShortVideoResourceManager.a(anzj.a(2131704991));
      bcwy.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("LightWeightSoDownloadUnit", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label110:
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      a();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    this.c = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
    b("doUserDownloadResourceAVCodec:");
    a(anzj.a(2131704996) + this.c + "%");
    VideoEnvironment.a("LightWeightSoDownloadUnit", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Bqai.a();
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
    Object localObject = this.jdField_a_of_type_Bqai.a();
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
      localObject = anzj.a(2131704994);
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
        localObject = anzj.a(2131705007);
      } else {
        localObject = anzj.a(2131704982);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
    }
  }
  
  public void p() {}
  
  public void s() {}
  
  public void t() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpzt
 * JD-Core Version:    0.7.0.1
 */