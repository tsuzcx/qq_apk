package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gyailib.library.GYAISceneChain;
import com.gyailib.library.GYDetectCommonItemParams;
import com.gyailib.library.GYDetectCommonResultStruct;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.takevideo.StoryMediaEditNotifier;
import com.tencent.aelight.camera.api.IAEPhotoAIManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.aelight.camera.struct.camera.AEPhotoAIResult;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class VideoFilterViewPager
  extends UnHandleTouchEventViewPager
  implements CaptureComboManager.CaptureComboListener
{
  private static GYAISceneChain jdField_a_of_type_ComGyailibLibraryGYAISceneChain;
  public int a;
  long jdField_a_of_type_Long = 0L;
  private View jdField_a_of_type_AndroidViewView;
  private AEAdjust jdField_a_of_type_ComTencentAekitApiStandardFilterAEAdjust;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private VideoFilterViewPager.SelectCallBack jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$SelectCallBack;
  private VideoFilterViewPager.VideoFilterPageChangeListener jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPageChangeListener;
  private VideoFilterViewPager.VideoFilterPagerAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter;
  private AEPhotoAIResult jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoAIResult;
  private SimpleGLThread jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int b;
  public boolean b;
  private int c;
  public boolean c;
  private int d;
  public boolean d;
  public boolean e = false;
  private boolean g = true;
  private boolean h;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  
  public VideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    f();
  }
  
  public VideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    f();
  }
  
  private static int a()
  {
    if (jdField_a_of_type_ComGyailibLibraryGYAISceneChain != null) {
      return 0;
    }
    if ((AEResUtil.b(AEResInfo.LIGHT_RES_BASE_PACKAGE)) && (AEResUtil.b(AEResInfo.AE_RES_BASE_PACKAGE)) && (AEResUtil.b(AEResInfo.LIGHT_RES_BUNDLE_SCENE)))
    {
      if ((FeatureManager.Features.LIGHT_SDK.init()) && (FeatureManager.Features.PTU_TOOLS.init()) && (FeatureManager.Features.PTU_ALGO.init()) && (FeatureManager.Features.IMAGE_ALGO.init()))
      {
        Object localObject = new SDKDeviceConfig();
        ((SDKDeviceConfig)localObject).setDevice("ARM");
        jdField_a_of_type_ComGyailibLibraryGYAISceneChain = new GYAISceneChain();
        int m = jdField_a_of_type_ComGyailibLibraryGYAISceneChain.initInstance((SDKDeviceConfig)localObject);
        if (m != 0) {
          return m;
        }
        localObject = new SDKModelConfig();
        String str = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightModelDir();
        ((SDKModelConfig)localObject).modelPaths = new HashMap();
        Map localMap = ((SDKModelConfig)localObject).modelPaths;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("LightSceneClassify.bundle");
        localMap.put("scene-dir", localStringBuilder.toString());
        localMap = ((SDKModelConfig)localObject).modelPaths;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("LightFaceModel.bundle");
        localMap.put("face-dir", localStringBuilder.toString());
        localMap = ((SDKModelConfig)localObject).modelPaths;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("LightGenderModel.bundle");
        localMap.put("gender-dir", localStringBuilder.toString());
        m = jdField_a_of_type_ComGyailibLibraryGYAISceneChain.setupWithModel((SDKModelConfig)localObject);
        if (m != 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("init error code: ");
          ((StringBuilder)localObject).append(m);
          AEQLog.d("VideoFilterViewPager", ((StringBuilder)localObject).toString());
          return m;
        }
        return 0;
      }
      AEQLog.d("VideoFilterViewPager", "ensureInitSceneChain---features init fail");
      return -1;
    }
    AEQLog.d("VideoFilterViewPager", "ensureInitSceneChain---res not exist");
    return -1;
  }
  
  public static String a(Bitmap paramBitmap)
  {
    Object localObject1 = "";
    if (paramBitmap == null)
    {
      AEQLog.d("VideoFilterViewPager", "bitmap is null.");
      return "";
    }
    Object localObject2 = localObject1;
    if (a() == 0)
    {
      long l = System.currentTimeMillis();
      localObject2 = new GYDetectCommonResultStruct();
      GYAISceneChain localGYAISceneChain;
      if ((paramBitmap.getHeight() <= 512) && (paramBitmap.getWidth() <= 512))
      {
        localGYAISceneChain = jdField_a_of_type_ComGyailibLibraryGYAISceneChain;
        if (localGYAISceneChain != null) {
          localGYAISceneChain.forwardDetect(paramBitmap, (GYDetectCommonResultStruct)localObject2, 0);
        }
      }
      else
      {
        paramBitmap = BitmapUtil.scaleBitmap(paramBitmap, 512);
        localGYAISceneChain = jdField_a_of_type_ComGyailibLibraryGYAISceneChain;
        if (localGYAISceneChain != null) {
          localGYAISceneChain.forwardDetect(paramBitmap, (GYDetectCommonResultStruct)localObject2, 0);
        }
        paramBitmap.recycle();
      }
      paramBitmap = (Bitmap)localObject1;
      if (((GYDetectCommonResultStruct)localObject2).items != null)
      {
        paramBitmap = (Bitmap)localObject1;
        if (((GYDetectCommonResultStruct)localObject2).items.length > 0)
        {
          paramBitmap = (Bitmap)localObject1;
          if (!TextUtils.isEmpty(localObject2.items[0].classifyName))
          {
            paramBitmap = localObject2.items[0].classifyName;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("aio photo ai sub-label: ");
            ((StringBuilder)localObject1).append(paramBitmap);
            AEQLog.b("VideoFilterViewPager", ((StringBuilder)localObject1).toString());
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[AICost] aio ai process time (getSubAILabel): ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      AEQLog.a("VideoFilterViewPager", ((StringBuilder)localObject1).toString());
      localObject2 = paramBitmap;
    }
    return localObject2;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread = new SimpleGLThread(null, "AIOEdit");
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread.postJob(new VideoFilterViewPager.1(this, paramInt1, paramInt2));
  }
  
  private void a(int paramInt, String paramString)
  {
    View localView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
      if (localQIMFilterCategoryItem != null)
      {
        localQIMFilterCategoryItem.i = paramString;
        a(localView, localQIMFilterCategoryItem, 3);
      }
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoAIResult == null)
    {
      AEQLog.d("VideoFilterViewPager", "aePhotoAIResult is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread.postJob(new VideoFilterViewPager.4(this, paramBitmap));
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPageSelect position: ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", mCurPosition: ");
      ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
      ((StringBuilder)localObject1).append(", mFromOnlyChangeUi: ");
      ((StringBuilder)localObject1).append(this.jdField_d_of_type_Boolean);
      QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt == this.jdField_d_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_d_of_type_Int = paramInt;
    paramView.setVisibility(0);
    QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
    if (localQIMFilterCategoryItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterViewPager", 2, "onPageSelect cannot find item");
      }
      return;
    }
    boolean bool = ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).getGifMode();
    Object localObject1 = "none";
    if (bool)
    {
      localObject2 = (IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class);
      if (paramInt != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((IAEBaseDataReporter)localObject2).reportEmoFilterItem((String)localObject1);
    }
    else
    {
      localObject2 = (IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class);
      if (paramInt != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((IAEBaseDataReporter)localObject2).reportClickFilterItem((String)localObject1);
    }
    localObject1 = (TextView)paramView.findViewById(2131364895);
    Object localObject2 = (TextView)paramView.findViewById(2131364894);
    Object localObject3 = (CaptureComboManager)QIMManager.a(5);
    if (localQIMFilterCategoryItem.d()) {
      a(paramInt, false);
    }
    Object localObject4;
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject4 = new Bundle();
      ((Bundle)localObject4).putInt("apply_source", 2);
      ((Bundle)localObject4).putInt("capture_scene", this.jdField_a_of_type_Int);
      ((CaptureComboManager)localObject3).a(localQIMFilterCategoryItem, (Activity)getContext(), (Bundle)localObject4);
      if ((this.j) && (this.i)) {
        a(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
      }
      if ((paramBoolean) && (((Activity)getContext()).getIntent() != null)) {
        StoryReportor.b("filter_swipe", ((Activity)getContext()).getIntent().getIntExtra("edit_video_type", 10002), 0, new String[] { "", localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString });
      }
    }
    localObject3 = ((CaptureComboManager)localObject3).a(localQIMFilterCategoryItem);
    paramInt = ((FilterSet)localObject3).d();
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("onPageSelect state = ");
      ((StringBuilder)localObject4).append(paramInt);
      ((StringBuilder)localObject4).append(" ");
      ((StringBuilder)localObject4).append(((FilterSet)localObject3).toString());
      QLog.i("QCombo", 2, ((StringBuilder)localObject4).toString());
    }
    if ((!localQIMFilterCategoryItem.b()) && (!localQIMFilterCategoryItem.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
    }
    else
    {
      ((TextView)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    if (!this.g) {
      this.g = true;
    }
    paramView.setVisibility(0);
    if (localQIMFilterCategoryItem.d())
    {
      a(paramView, localQIMFilterCategoryItem, 3);
      return;
    }
    a(paramView, localQIMFilterCategoryItem, paramInt);
  }
  
  private void a(View paramView, QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131364895);
    TextView localTextView2 = (TextView)paramView.findViewById(2131364894);
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof RelativeLayout))) {
      localObject = (RelativeLayout)((RelativeLayout)localObject).findViewById(2131370396);
    } else {
      localObject = null;
    }
    boolean bool = ((CaptureComboManager)QIMManager.a(5)).b();
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt == 4)
        {
          if (localObject != null)
          {
            ((RelativeLayout)localObject).setVisibility(8);
            QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
          }
          paramView.setVisibility(8);
        }
      }
      else if (!bool)
      {
        if (localObject != null) {
          ((RelativeLayout)localObject).setVisibility(8);
        }
        localTextView1.setText(paramQIMFilterCategoryItem.b);
        if (localTextView2 != null) {
          localTextView2.setText(paramQIMFilterCategoryItem.i);
        }
        paramQIMFilterCategoryItem = new VideoFilterViewPager.5(this, paramView);
        paramView.setVisibility(0);
        paramView.postDelayed(paramQIMFilterCategoryItem, 800L);
        paramView.setTag(paramQIMFilterCategoryItem);
      }
      else
      {
        if (localObject != null) {
          ((RelativeLayout)localObject).setVisibility(8);
        }
        localTextView1.setText(paramQIMFilterCategoryItem.b);
        localTextView1.setVisibility(8);
        if (localTextView2 != null)
        {
          localTextView2.setText(paramQIMFilterCategoryItem.i);
          localTextView2.setVisibility(8);
        }
      }
    }
    else if (!bool)
    {
      if (!this.e)
      {
        if (localObject != null)
        {
          ((RelativeLayout)localObject).setVisibility(0);
          QLog.i("VideoFilterViewPager", 2, "loadingView VISIBLE");
        }
      }
      else if (localObject != null)
      {
        ((RelativeLayout)localObject).setVisibility(8);
        QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
      }
      paramView.setVisibility(0);
      localTextView1.setText(paramQIMFilterCategoryItem.b);
      if (localTextView2 != null) {
        localTextView2.setText(paramQIMFilterCategoryItem.i);
      }
    }
    else
    {
      localTextView1.setText(paramQIMFilterCategoryItem.b);
      localTextView1.setVisibility(8);
      if (localTextView2 != null)
      {
        localTextView2.setText(paramQIMFilterCategoryItem.i);
        localTextView2.setVisibility(8);
      }
      if (localObject != null)
      {
        ((RelativeLayout)localObject).setVisibility(8);
        QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
      }
    }
    if ((this.h) && (localTextView1 != null) && (localTextView2 != null))
    {
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
    }
  }
  
  public static void a(String paramString)
  {
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("ae_filter_id", paramString, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFilterPref(ae_filter_id, ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      QLog.d("VideoFilterViewPager", 2, localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_JavaLangString = c(paramBitmap);
    this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoAIResult = ((IAEPhotoAIManager)QRoute.api(IAEPhotoAIManager.class)).getPhotoAIResult(this.jdField_a_of_type_JavaLangString);
    if (!paramBoolean)
    {
      g();
      a(paramBitmap);
    }
  }
  
  private void b(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
      if (localQIMFilterCategoryItem != null)
      {
        paramInt = ((CaptureComboManager)QIMManager.a(5)).a(localQIMFilterCategoryItem).jdField_a_of_type_Int;
        if (localQIMFilterCategoryItem.d()) {
          paramInt = 3;
        }
        a(localView, localQIMFilterCategoryItem, paramInt);
      }
    }
  }
  
  private static String c(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      AEQLog.d("VideoFilterViewPager", "bitmap is null.");
      return "";
    }
    long l = System.currentTimeMillis();
    a();
    GYDetectCommonResultStruct localGYDetectCommonResultStruct = new GYDetectCommonResultStruct();
    if ((paramBitmap.getHeight() <= 512) && (paramBitmap.getWidth() <= 512))
    {
      jdField_a_of_type_ComGyailibLibraryGYAISceneChain.forwardDetect(paramBitmap, localGYDetectCommonResultStruct, 0);
    }
    else
    {
      paramBitmap = BitmapUtil.scaleBitmap(paramBitmap, 512);
      localObject = jdField_a_of_type_ComGyailibLibraryGYAISceneChain;
      if (localObject != null) {
        ((GYAISceneChain)localObject).forwardDetect(paramBitmap, localGYDetectCommonResultStruct, 0);
      }
      paramBitmap.recycle();
    }
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131689714);
    paramBitmap = (Bitmap)localObject;
    if (localGYDetectCommonResultStruct.items != null)
    {
      paramBitmap = (Bitmap)localObject;
      if (localGYDetectCommonResultStruct.items.length > 0)
      {
        paramBitmap = (Bitmap)localObject;
        if (!TextUtils.isEmpty(localGYDetectCommonResultStruct.items[0].classifyType))
        {
          paramBitmap = localGYDetectCommonResultStruct.items[0].classifyType;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("aio photo ai label: ");
          ((StringBuilder)localObject).append(paramBitmap);
          AEQLog.b("VideoFilterViewPager", ((StringBuilder)localObject).toString());
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[AICost] aio ai process time: ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    AEQLog.a("VideoFilterViewPager", ((StringBuilder)localObject).toString());
    return paramBitmap;
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, 4);
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter = new VideoFilterViewPager.VideoFilterPagerAdapter(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPageChangeListener = new VideoFilterViewPager.VideoFilterPageChangeListener(this);
    setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter);
    addOnPageChangeListener(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPageChangeListener);
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new VideoFilterViewPager.3(this));
  }
  
  public String a()
  {
    String str = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("ae_filter_id", "", 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFilterId(ae_filter_id, ");
      localStringBuilder.append(str);
      localStringBuilder.append(")");
      QLog.d("VideoFilterViewPager", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public void a()
  {
    String str = a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(str);
  }
  
  public void a(int paramInt)
  {
    setCurrentItem(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a() * 50 + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!VideoFilterTools.b(getContext()))
    {
      AEQLog.d("VideoFilterViewPager", "ai filter res not ready.");
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    this.k = paramBoolean;
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new VideoFilterViewPager.2(this);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (paramComboFilterData != null)
    {
      paramComboFilterData = paramComboFilterData.a(this.jdField_a_of_type_Int);
      if (paramComboFilterData != null)
      {
        a(VideoFilterTools.ComboFilterData.a(paramComboFilterData.c));
        int m = paramComboFilterData.c.indexOf(VideoFilterTools.a().c(this.jdField_a_of_type_Int));
        paramComboFilterData = new StringBuilder();
        paramComboFilterData.append("onResourceDownload - update viewpagerIndex = ");
        paramComboFilterData.append(m);
        paramComboFilterData.append("; getCurrentItem()");
        paramComboFilterData.append(getCurrentItem());
        QLog.i("VideoFilterViewPager", 2, paramComboFilterData.toString());
        if ((m != -1) && (m != getCurrentItem()))
        {
          QLog.i("VideoFilterViewPager", 2, "onResourceDownload - initialViewPagerPosition ");
          this.jdField_d_of_type_Boolean = true;
          a(m);
          this.jdField_d_of_type_Boolean = false;
        }
      }
    }
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("QCombo", 1, "onComboApply aborted");
      return;
    }
    paramInt = -1;
    int m = paramBundle.getInt("capture_scene", -1);
    if (this.jdField_a_of_type_Int != m)
    {
      paramComboSet = new StringBuilder();
      paramComboSet.append("onComboApply aborted ");
      paramComboSet.append(this.jdField_a_of_type_Int);
      paramComboSet.append(m);
      QLog.e("QCombo", 2, paramComboSet.toString());
      return;
    }
    paramBundle = ((CaptureComboManager)QIMManager.a(5)).a(paramComboSet, this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a;
    this.jdField_c_of_type_Boolean = true;
    if (localObject != null)
    {
      m = ((ArrayList)localObject).indexOf(paramBundle);
      paramInt = m;
      if (m >= 0)
      {
        paramInt = m;
        if (m != getCurrentItem())
        {
          this.jdField_d_of_type_Boolean = true;
          a(m);
          paramInt = m;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vp onComboApply combo ");
      ((StringBuilder)localObject).append(paramComboSet.jdField_a_of_type_JavaLangObject);
      ((StringBuilder)localObject).append(" filter ");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(" index ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("QCombo", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("QCombo", 1, "onFilterApply aborted");
      return;
    }
    paramInt = paramBundle.getInt("capture_scene", -1);
    if (this.jdField_a_of_type_Int != paramInt)
    {
      paramFilterSet = new StringBuilder();
      paramFilterSet.append("onFilterApply aborted ");
      paramFilterSet.append(this.jdField_a_of_type_Int);
      paramFilterSet.append(paramInt);
      QLog.e("QCombo", 2, paramFilterSet.toString());
      return;
    }
    if ((paramFilterSet.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem))
    {
      ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setFilterId(paramFilterSet.b());
      paramFilterSet = (QIMFilterCategoryItem)paramFilterSet.jdField_a_of_type_JavaLangObject;
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a;
      if (localArrayList != null)
      {
        paramInt = localArrayList.indexOf(paramFilterSet);
        if (paramInt >= 0)
        {
          this.jdField_c_of_type_Boolean = false;
          if ((paramBundle.getInt("apply_source", 2) != 1) && (paramBundle.getInt("apply_source", 2) != CaptureComboManager.jdField_a_of_type_Int))
          {
            if ((paramBundle.getInt("apply_source", 2) == 2) && (paramInt == this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(this.jdField_d_of_type_Int)))
            {
              paramInt = this.jdField_d_of_type_Int;
              if (paramBoolean) {
                b(paramInt);
              } else {
                c(paramInt);
              }
            }
          }
          else
          {
            this.jdField_d_of_type_Boolean = true;
            int m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a() * 50 + paramInt;
            if (m == this.jdField_d_of_type_Int)
            {
              if (paramBoolean)
              {
                b(m);
                this.jdField_d_of_type_Boolean = false;
              }
              else
              {
                c(m);
              }
            }
            else if (paramBoolean) {
              a(paramInt);
            }
          }
          StoryReportor.a((Activity)getContext(), "filter_element", String.valueOf(paramFilterSet.jdField_a_of_type_Int), paramFilterSet.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Boolean) {
            StoryMediaEditNotifier.a().a();
          }
        }
      }
    }
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    if (!(getContext() instanceof QzoneEditVideoActivity))
    {
      setVisibility(0);
      setEnabled(true);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a(paramList);
    paramList = new StringBuilder();
    paramList.append("update getCurrentItem = ");
    paramList.append(getCurrentItem());
    QLog.i("VideoFilterViewPager", 2, paramList.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void b()
  {
    int m = getCurrentItem();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needReselectMiddle getActualCount ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a());
    QLog.i("VideoFilterViewPager", 2, localStringBuilder.toString());
    if ((m != 0) && (m % this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a() != 0))
    {
      m = 0;
    }
    else
    {
      QLog.i("VideoFilterViewPager", 2, "needReselectMiddle ");
      m = 1;
    }
    if (m != 0) {
      setCurrentItem(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$VideoFilterPagerAdapter.a() * 50, false);
    }
  }
  
  public void c()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.destroy();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
    }
  }
  
  public void d()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ((CaptureComboManager)QIMManager.a(5)).a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ((CaptureComboManager)QIMManager.a(5)).b(this);
    Object localObject = jdField_a_of_type_ComGyailibLibraryGYAISceneChain;
    if (localObject != null)
    {
      ((GYAISceneChain)localObject).cleanupModelData();
      jdField_a_of_type_ComGyailibLibraryGYAISceneChain = null;
    }
    c();
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSimpleGLThread;
    if (localObject != null) {
      ((SimpleGLThread)localObject).destroy();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if ((m != 0) && (m == 2)) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCaptureScene(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setIsNormalMode(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (!this.j) {
      this.j = true;
    }
  }
  
  public void setReadyToApply(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setSecleteCallBack(VideoFilterViewPager.SelectCallBack paramSelectCallBack)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager$SelectCallBack = paramSelectCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */