package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
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
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
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
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  private boolean A = false;
  private HandlerThread B;
  private int C = -1;
  private GYAISceneChain D;
  public boolean a = false;
  public boolean b = true;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public int f = 0;
  long g = 0L;
  private VideoFilterViewPager.VideoFilterPagerAdapter i;
  private VideoFilterViewPager.VideoFilterPageChangeListener j;
  private boolean k = true;
  private VideoFilterViewPager.SelectCallBack l;
  private VideoFilterViewPager.IAISubLabelReady m;
  private View n;
  private boolean o;
  private boolean p = true;
  private boolean q = false;
  private String r;
  private AEFilterManager s;
  private AEPhotoAIResult t;
  private SimpleGLThread u;
  private Handler v;
  private Runnable w;
  private int x;
  private int y;
  private String z;
  
  public VideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public VideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.u = new SimpleGLThread(null, "AIOEdit");
    this.u.postJob(new VideoFilterViewPager.2(this, paramInt1, paramInt2));
  }
  
  private void a(int paramInt, String paramString)
  {
    View localView = this.i.c(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.i.a(paramInt);
      if (localQIMFilterCategoryItem != null)
      {
        localQIMFilterCategoryItem.r = paramString;
        a(localView, localQIMFilterCategoryItem, 3);
      }
    }
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPageSelect position: ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", mCurPosition: ");
      ((StringBuilder)localObject1).append(this.C);
      ((StringBuilder)localObject1).append(", mFromOnlyChangeUi: ");
      ((StringBuilder)localObject1).append(this.d);
      QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt == this.C) {
      return;
    }
    this.n = paramView;
    this.C = paramInt;
    paramView.setVisibility(0);
    QIMFilterCategoryItem localQIMFilterCategoryItem = this.i.a(paramInt);
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
        ((StringBuilder)localObject1).append(localQIMFilterCategoryItem.a);
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
        ((StringBuilder)localObject1).append(localQIMFilterCategoryItem.a);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((IAEBaseDataReporter)localObject2).reportClickFilterItem((String)localObject1);
    }
    localObject1 = (TextView)paramView.findViewById(2131431021);
    Object localObject2 = (TextView)paramView.findViewById(2131431020);
    Object localObject3 = (CaptureComboManager)QIMManager.a(5);
    if (localQIMFilterCategoryItem.e()) {
      a(paramInt, false);
    }
    Object localObject4;
    if (!this.d)
    {
      localObject4 = new Bundle();
      ((Bundle)localObject4).putInt("apply_source", 2);
      ((Bundle)localObject4).putInt("capture_scene", this.f);
      ((CaptureComboManager)localObject3).a(localQIMFilterCategoryItem, (Activity)getContext(), (Bundle)localObject4);
      if ((this.q) && (this.p)) {
        a(localQIMFilterCategoryItem.a);
      }
      if ((paramBoolean) && (((Activity)getContext()).getIntent() != null)) {
        StoryReportor.b("filter_swipe", ((Activity)getContext()).getIntent().getIntExtra("edit_video_type", 10002), 0, new String[] { "", localQIMFilterCategoryItem.a });
      }
    }
    localObject3 = ((CaptureComboManager)localObject3).b(localQIMFilterCategoryItem);
    paramInt = ((FilterSet)localObject3).j();
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("onPageSelect state = ");
      ((StringBuilder)localObject4).append(paramInt);
      ((StringBuilder)localObject4).append(" ");
      ((StringBuilder)localObject4).append(((FilterSet)localObject3).toString());
      QLog.i("QCombo", 2, ((StringBuilder)localObject4).toString());
    }
    if ((!localQIMFilterCategoryItem.c()) && (!localQIMFilterCategoryItem.p) && (!this.c))
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
    }
    else
    {
      ((TextView)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    if (this.b) {
      this.b = false;
    }
    if (!this.k) {
      this.k = true;
    }
    paramView.setVisibility(0);
    if (localQIMFilterCategoryItem.e())
    {
      a(paramView, localQIMFilterCategoryItem, 3);
      return;
    }
    a(paramView, localQIMFilterCategoryItem, paramInt);
  }
  
  private void a(View paramView, QIMFilterCategoryItem paramQIMFilterCategoryItem, int paramInt)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131431021);
    TextView localTextView2 = (TextView)paramView.findViewById(2131431020);
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof RelativeLayout))) {
      localObject = (RelativeLayout)((RelativeLayout)localObject).findViewById(2131437664);
    } else {
      localObject = null;
    }
    boolean bool = ((CaptureComboManager)QIMManager.a(5)).j();
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
          localTextView2.setText(paramQIMFilterCategoryItem.r);
        }
        paramQIMFilterCategoryItem = new VideoFilterViewPager.6(this, paramView);
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
          localTextView2.setText(paramQIMFilterCategoryItem.r);
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
        localTextView2.setText(paramQIMFilterCategoryItem.r);
      }
    }
    else
    {
      localTextView1.setText(paramQIMFilterCategoryItem.b);
      localTextView1.setVisibility(8);
      if (localTextView2 != null)
      {
        localTextView2.setText(paramQIMFilterCategoryItem.r);
        localTextView2.setVisibility(8);
      }
      if (localObject != null)
      {
        ((RelativeLayout)localObject).setVisibility(8);
        QLog.i("VideoFilterViewPager", 2, "loadingView GONE");
      }
    }
    if ((this.o) && (localTextView1 != null) && (localTextView2 != null))
    {
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
    }
  }
  
  public static void a(String paramString)
  {
    String str;
    if (AEDashboardUtil.d()) {
      str = "dy_filter_id";
    } else {
      str = "ae_filter_id";
    }
    ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString(str, paramString, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveFilterPref(");
      localStringBuilder.append(str);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      QLog.d("VideoFilterViewPager", 2, localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean, Bitmap paramBitmap)
  {
    this.z = b(paramBitmap);
    this.t = ((IAEPhotoAIManager)QRoute.api(IAEPhotoAIManager.class)).getPhotoAIResult(this.z);
    if (!paramBoolean)
    {
      i();
      c(paramBitmap);
    }
  }
  
  private String b(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      AEQLog.d("VideoFilterViewPager", "bitmap is null.");
      return "";
    }
    long l1 = System.currentTimeMillis();
    h();
    GYDetectCommonResultStruct localGYDetectCommonResultStruct = new GYDetectCommonResultStruct();
    if ((paramBitmap.getHeight() <= 512) && (paramBitmap.getWidth() <= 512))
    {
      this.D.forwardDetect(paramBitmap, localGYDetectCommonResultStruct, 0);
    }
    else
    {
      paramBitmap = BitmapUtil.scaleBitmap(paramBitmap, 512);
      if (paramBitmap != null)
      {
        localObject = this.D;
        if (localObject != null) {
          ((GYAISceneChain)localObject).forwardDetect(paramBitmap, localGYDetectCommonResultStruct, 0);
        }
        paramBitmap.recycle();
      }
    }
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131886327);
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
          this.r = localGYDetectCommonResultStruct.items[0].classifyName;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("aio photo ai label: ");
          ((StringBuilder)localObject).append(paramBitmap);
          ((StringBuilder)localObject).append(" subLabel: ");
          ((StringBuilder)localObject).append(this.r);
          AEQLog.b("VideoFilterViewPager", ((StringBuilder)localObject).toString());
        }
      }
    }
    localObject = this.m;
    if (localObject != null) {
      ((VideoFilterViewPager.IAISubLabelReady)localObject).a(this.r);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[AICost] aio ai process time: ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
    AEQLog.a("VideoFilterViewPager", ((StringBuilder)localObject).toString());
    return paramBitmap;
  }
  
  private void b(int paramInt)
  {
    View localView = this.i.c(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.i.a(paramInt);
      if (localQIMFilterCategoryItem != null)
      {
        paramInt = ((CaptureComboManager)QIMManager.a(5)).b(localQIMFilterCategoryItem).b;
        if (localQIMFilterCategoryItem.e()) {
          paramInt = 3;
        }
        a(localView, localQIMFilterCategoryItem, paramInt);
      }
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.i.c(paramInt);
    if (localView != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = this.i.a(paramInt);
      if (localQIMFilterCategoryItem != null) {
        a(localView, localQIMFilterCategoryItem, 4);
      }
    }
  }
  
  private void c(Bitmap paramBitmap)
  {
    if (this.t == null)
    {
      AEQLog.d("VideoFilterViewPager", "aePhotoAIResult is null.");
      return;
    }
    this.u.postJob(new VideoFilterViewPager.5(this, paramBitmap));
  }
  
  private void g()
  {
    this.i = new VideoFilterViewPager.VideoFilterPagerAdapter(this);
    this.j = new VideoFilterViewPager.VideoFilterPageChangeListener(this);
    setAdapter(this.i);
    addOnPageChangeListener(this.j);
    this.B = new HandlerThread("AIDetectThread");
    this.B.start();
    this.v = new Handler(this.B.getLooper());
    a();
  }
  
  private int h()
  {
    if (this.D != null) {
      return 0;
    }
    if ((AEResUtil.d(AEResInfo.LIGHT_RES_BASE_PACKAGE)) && (AEResUtil.d(AEResInfo.AE_RES_BASE_PACKAGE)) && (AEResUtil.d(AEResInfo.LIGHT_RES_BUNDLE_SCENE)))
    {
      if ((FeatureManager.Features.LIGHT_SDK.init()) && (FeatureManager.Features.PTU_TOOLS.init()) && (FeatureManager.Features.PTU_ALGO.init()) && (FeatureManager.Features.IMAGE_ALGO.init()))
      {
        Object localObject = new SDKDeviceConfig();
        ((SDKDeviceConfig)localObject).setDevice("ARM");
        this.D = new GYAISceneChain();
        int i1 = this.D.initInstance((SDKDeviceConfig)localObject);
        if (i1 != 0) {
          return i1;
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
        i1 = this.D.setupWithModel((SDKModelConfig)localObject);
        if (i1 != 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("init error code: ");
          ((StringBuilder)localObject).append(i1);
          AEQLog.d("VideoFilterViewPager", ((StringBuilder)localObject).toString());
          return i1;
        }
        return 0;
      }
      AEQLog.d("VideoFilterViewPager", "ensureInitSceneChain---features init fail");
      return -1;
    }
    AEQLog.d("VideoFilterViewPager", "ensureInitSceneChain---res not exist");
    return -1;
  }
  
  private void i()
  {
    ThreadManager.getUIHandler().post(new VideoFilterViewPager.4(this));
  }
  
  public String a(Bitmap paramBitmap)
  {
    return this.r;
  }
  
  public void a()
  {
    Object localObject = ((CaptureComboManager)QIMManager.a(5)).l;
    if (localObject == null) {
      return;
    }
    localObject = ((VideoFilterTools.ComboFilterData)localObject).a(this.f);
    if (localObject == null) {
      return;
    }
    a(((VideoFilterTools.DataSet)localObject).c);
  }
  
  public void a(int paramInt)
  {
    setCurrentItem(this.i.a() * 50 + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!VideoFilterTools.b(getContext()))
    {
      AEQLog.d("VideoFilterViewPager", "ai filter res not ready.");
      return;
    }
    this.y = paramInt;
    this.A = paramBoolean;
    if (this.w == null) {
      this.w = new VideoFilterViewPager.3(this);
    }
    Handler localHandler = this.v;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.w);
      this.v.post(this.w);
    }
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (paramComboFilterData != null)
    {
      paramComboFilterData = paramComboFilterData.a(this.f);
      if (paramComboFilterData != null)
      {
        a();
        int i1 = paramComboFilterData.c.indexOf(VideoFilterTools.a().c(this.f));
        paramComboFilterData = new StringBuilder();
        paramComboFilterData.append("onResourceDownload - update viewpagerIndex = ");
        paramComboFilterData.append(i1);
        paramComboFilterData.append("; getCurrentItem()");
        paramComboFilterData.append(getCurrentItem());
        QLog.i("VideoFilterViewPager", 2, paramComboFilterData.toString());
        if ((i1 != -1) && (i1 != getCurrentItem()))
        {
          QLog.i("VideoFilterViewPager", 2, "onResourceDownload - initialViewPagerPosition ");
          this.d = true;
          a(i1);
          this.d = false;
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
    int i1 = paramBundle.getInt("capture_scene", -1);
    if (this.f != i1)
    {
      paramComboSet = new StringBuilder();
      paramComboSet.append("onComboApply aborted ");
      paramComboSet.append(this.f);
      paramComboSet.append(i1);
      QLog.e("QCombo", 2, paramComboSet.toString());
      return;
    }
    paramBundle = ((CaptureComboManager)QIMManager.a(5)).a(paramComboSet, this.i.c);
    Object localObject = this.i.c;
    this.c = true;
    if (localObject != null)
    {
      i1 = ((ArrayList)localObject).indexOf(paramBundle);
      paramInt = i1;
      if (i1 >= 0)
      {
        paramInt = i1;
        if (i1 != getCurrentItem())
        {
          this.d = true;
          a(i1);
          paramInt = i1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vp onComboApply combo ");
      ((StringBuilder)localObject).append(paramComboSet.e);
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
    if (this.f != paramInt)
    {
      paramFilterSet = new StringBuilder();
      paramFilterSet.append("onFilterApply aborted ");
      paramFilterSet.append(this.f);
      paramFilterSet.append(paramInt);
      QLog.e("QCombo", 2, paramFilterSet.toString());
      return;
    }
    if ((paramFilterSet.e instanceof QIMFilterCategoryItem))
    {
      ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setFilterId(paramFilterSet.h());
      paramFilterSet = (QIMFilterCategoryItem)paramFilterSet.e;
      ArrayList localArrayList = this.i.c;
      if (localArrayList != null)
      {
        paramInt = localArrayList.indexOf(paramFilterSet);
        if (paramInt >= 0)
        {
          this.c = false;
          if ((paramBundle.getInt("apply_source", 2) != 1) && (paramBundle.getInt("apply_source", 2) != CaptureComboManager.a))
          {
            if ((paramBundle.getInt("apply_source", 2) == 2) && (paramInt == this.i.b(this.C)))
            {
              paramInt = this.C;
              if (paramBoolean) {
                b(paramInt);
              } else {
                c(paramInt);
              }
            }
          }
          else
          {
            this.d = true;
            int i1 = this.i.a() * 50 + paramInt;
            if (i1 == this.C)
            {
              if (paramBoolean)
              {
                b(i1);
                this.d = false;
              }
              else
              {
                c(i1);
              }
            }
            else if (paramBoolean) {
              a(paramInt);
            }
          }
          StoryReportor.a((Activity)getContext(), "filter_element", String.valueOf(paramFilterSet.e), paramFilterSet.a);
          if (this.a) {
            StoryMediaEditNotifier.b().a();
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
    this.i.a(paramList);
    paramList = new StringBuilder();
    paramList.append("update getCurrentItem = ");
    paramList.append(getCurrentItem());
    QLog.i("VideoFilterViewPager", 2, paramList.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void b()
  {
    String str = getFilterId();
    this.i.a(str);
  }
  
  public void c()
  {
    int i1 = getCurrentItem();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needReselectMiddle getActualCount ");
    localStringBuilder.append(this.i.a());
    QLog.i("VideoFilterViewPager", 2, localStringBuilder.toString());
    if ((i1 != 0) && (i1 % this.i.a() != 0))
    {
      i1 = 0;
    }
    else
    {
      QLog.i("VideoFilterViewPager", 2, "needReselectMiddle ");
      i1 = 1;
    }
    if (i1 != 0) {
      setCurrentItem(this.i.a() * 50, false);
    }
  }
  
  public void d()
  {
    AEFilterManager localAEFilterManager = this.s;
    if (localAEFilterManager != null)
    {
      localAEFilterManager.destroy();
      this.s = null;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void e()
  {
    View localView = this.n;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void f()
  {
    this.g = 0L;
  }
  
  public String getFilterId()
  {
    String str1;
    if (AEDashboardUtil.d()) {
      str1 = "dy_filter_id";
    } else {
      str1 = "ae_filter_id";
    }
    String str2 = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString(str1, "", 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFilterId(");
      localStringBuilder.append(str1);
      localStringBuilder.append(", ");
      localStringBuilder.append(str2);
      localStringBuilder.append(")");
      QLog.d("VideoFilterViewPager", 2, localStringBuilder.toString());
    }
    return str2;
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
    Object localObject = this.v;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacks(null);
      this.v.post(new VideoFilterViewPager.1(this));
      this.v = null;
    }
    d();
    localObject = this.u;
    if (localObject != null) {
      ((SimpleGLThread)localObject).destroy();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 0) && (i1 == 2)) {
      this.g = System.currentTimeMillis();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCaptureScene(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setIaiSubLabelReady(VideoFilterViewPager.IAISubLabelReady paramIAISubLabelReady)
  {
    this.m = paramIAISubLabelReady;
  }
  
  public void setIsNormalMode(boolean paramBoolean)
  {
    this.p = paramBoolean;
    if (!this.q) {
      this.q = true;
    }
  }
  
  public void setReadyToApply(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setSecleteCallBack(VideoFilterViewPager.SelectCallBack paramSelectCallBack)
  {
    this.l = paramSelectCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */