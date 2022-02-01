package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.AEPath.AISCENE.FILES;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit.ViewStubHoldersViewModel;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.SelectCallBack;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.TTAutoAISceneType;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.AISceneCallback;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mqq.os.MqqHandler;

public class VideoStoryAIScenePart
  extends VideoStoryBasePart
  implements VideoFilterViewPager.SelectCallBack, CameraCaptureView.AISceneCallback
{
  private volatile AtomicBoolean A = new AtomicBoolean();
  private boolean B = false;
  private boolean C = false;
  private Runnable D;
  private AEPituCameraUnit E = (AEPituCameraUnit)this.mPartManager.a(65537, new Object[0]);
  private boolean F;
  private int G;
  private int H;
  private int I;
  private Runnable J;
  private final int a = 400;
  private final int b = 1500;
  private final int c = 2000;
  private final String d = "ai_guide_shown";
  private IAIScene e = new TTAutoAIScene();
  private AtomicReference<CameraCaptureView.AISceneCallback> f = new AtomicReference();
  private AtomicBoolean g = new AtomicBoolean(false);
  private Runnable h;
  private View i;
  private TextView j;
  private TextView k;
  private Handler l;
  private QQAnimationDrawable m;
  private QQAnimationDrawable n;
  private QQAnimationDrawable o;
  private ImageView p;
  private View q;
  private AECameraGLSurfaceView r;
  private AbsAECaptureButton s;
  private FilterPagerViewStubHolder t;
  private QIMFilterCategoryItem u;
  private AnimationSet v;
  private AEMaterialPanel w;
  private int x;
  private long y;
  private boolean z = false;
  
  public VideoStoryAIScenePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
  }
  
  private void a(int paramInt, String paramString)
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(1000L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(1000L);
    String str2 = AEPath.AISCENE.FILES.f;
    String str1;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            str1 = "";
          } else {
            str1 = "face";
          }
        }
        else {
          str1 = "scene";
        }
      }
      else {
        str1 = "food";
      }
    }
    else {
      str1 = "object";
    }
    if (Build.VERSION.SDK_INT <= 22) {
      str1 = "scene";
    }
    Object localObject1 = this.k;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913597));
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913596));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    this.j.setText(paramString);
    this.j.setVisibility(0);
    this.j.setAnimation(g());
    localObject1 = null;
    paramString = (String)localObject1;
    if (!TextUtils.isEmpty(str2))
    {
      paramString = new StringBuilder();
      paramString.append(str2);
      paramString.append(File.separator);
      paramString.append(str1);
      str2 = paramString.toString();
      localObject2 = new File(str2);
      paramString = (String)localObject1;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          paramString = (String)localObject1;
          if (localObject2.length > 0)
          {
            localObject1 = new String[localObject2.length];
            int i1;
            for (paramInt = 0;; paramInt = i1)
            {
              paramString = (String)localObject1;
              if (paramInt >= localObject2.length) {
                break;
              }
              paramString = new StringBuilder();
              paramString.append(str2);
              paramString.append(File.separator);
              paramString.append(str1);
              paramString.append("_");
              i1 = paramInt + 1;
              paramString.append(i1);
              paramString.append(".png");
              paramString = paramString.toString();
              if (new File(paramString).exists()) {
                localObject1[paramInt] = paramString;
              }
            }
          }
        }
      }
    }
    this.m.a(2500L);
    this.m.a(true);
    this.i.setVisibility(0);
    this.i.setBackgroundDrawable(this.m);
    if (paramString != null) {
      this.m.a(paramString);
    }
    this.m.start();
    this.i.postDelayed(new VideoStoryAIScenePart.8(this), 2500L);
    localAlphaAnimation1.setAnimationListener(new VideoStoryAIScenePart.9(this, localAlphaAnimation2));
    localAlphaAnimation2.setAnimationListener(new VideoStoryAIScenePart.10(this));
  }
  
  private void a(AEMaterialPanel paramAEMaterialPanel)
  {
    Activity localActivity = (Activity)paramAEMaterialPanel.getContext();
    View localView = this.i;
    if ((localView != null) && (this.k != null) && (this.j != null) && ((localView.getVisibility() == 0) || (this.j.getVisibility() == 0) || (this.i.getVisibility() == 0) || (this.k.getVisibility() == 0)))
    {
      int i1 = UIUtils.d(localActivity);
      this.i.post(new VideoStoryAIScenePart.18(this, paramAEMaterialPanel, i1));
    }
  }
  
  private void a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    Object localObject = AEVideoStoryTopBarViewModel.Ratio.R_1_1;
    int i1 = 0;
    if (paramRatio == localObject)
    {
      localObject = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2063990947);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(f1 - this.p.getMeasuredWidth()) >> 1);
      this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL)
    {
      localObject = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 0);
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1)
    {
      double d1 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels / f1;
      if (d1 < 1.78D) {
        i1 = -20;
      } else if (d1 >= 1.78D) {
        i1 = -DisplayUtil.a(this.mActivity, f1 / 2.0F);
      }
    }
    else if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL)
    {
      i1 = 46;
    }
    if (i1 == 0) {
      return;
    }
    paramRatio = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
    int i2 = this.G;
    f1 = i1;
    paramRatio.bottomMargin = (i2 - ScreenUtil.dip2px(f1));
    this.i.setLayoutParams(paramRatio);
    paramRatio = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
    paramRatio.bottomMargin = (this.H - ScreenUtil.dip2px(f1));
    this.j.setLayoutParams(paramRatio);
    paramRatio = (ViewGroup.MarginLayoutParams)this.k.getLayoutParams();
    paramRatio.bottomMargin = (this.I - ScreenUtil.dip2px(f1));
    this.k.setLayoutParams(paramRatio);
  }
  
  private void a(AtomicReference<CameraCaptureView.AISceneCallback> paramAtomicReference, AEFilterManager paramAEFilterManager)
  {
    if (paramAtomicReference.get() == null)
    {
      Logger.a("Q.videostory", "Q.videostory.capture", "requestAIScene()", "sceneCallback is null");
      return;
    }
    if ((paramAEFilterManager != null) && (paramAEFilterManager.getFaceAttr() != null))
    {
      Logger.a("Q.videostory", "Q.videostory.capture", "requestAIScene()", "start");
      Object localObject1 = paramAEFilterManager.getFaceAttr();
      int i1 = ((PTFaceAttr)localObject1).getFaceDetWidth();
      int i2 = ((PTFaceAttr)localObject1).getFaceDetHeight();
      paramAEFilterManager = new ArrayList();
      localObject1 = ((PTFaceAttr)localObject1).getAllFacePoints();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (List)((Iterator)localObject1).next();
          float f1 = ((PointF)((List)localObject2).get(18)).x;
          float f2 = ((PointF)((List)localObject2).get(0)).x;
          float f3 = ((PointF)((List)localObject2).get(9)).y;
          float f4 = ((PointF)((List)localObject2).get(87)).y;
          localObject2 = new IAIScene.FaceRect();
          ((IAIScene.FaceRect)localObject2).b = ((int)(f3 - f4));
          ((IAIScene.FaceRect)localObject2).a = ((int)(f1 - f2));
          paramAEFilterManager.add(localObject2);
        }
      }
      if ((i1 != 0) && (i2 != 0))
      {
        localObject1 = this.E;
        if (localObject1 == null)
        {
          AEQLog.d("AEAIScenePart", "requestAIScene: ptFaceAttr.getData() == null, 不使用智能滤镜");
          return;
        }
        localObject1 = ((AEPituCameraUnit)localObject1).aK();
        try
        {
          this.A.set(false);
          this.l.sendEmptyMessage(2);
          this.e.a((Bitmap)localObject1, paramAEFilterManager, new VideoStoryAIScenePart.12(this, paramAtomicReference));
          return;
        }
        catch (Exception paramAEFilterManager)
        {
          if ((CameraCaptureView.AISceneCallback)paramAtomicReference.get() == null) {
            break label368;
          }
        }
        ((CameraCaptureView.AISceneCallback)paramAtomicReference.get()).a(paramAEFilterManager.toString());
      }
      else
      {
        AEQLog.d("AEAIScenePart", "width or height is 0, fail to request AIScene!");
        if ((CameraCaptureView.AISceneCallback)paramAtomicReference.get() != null) {
          ((CameraCaptureView.AISceneCallback)paramAtomicReference.get()).a("no bitmap");
        }
      }
      label368:
      return;
    }
    if (paramAtomicReference.get() != null) {
      ((CameraCaptureView.AISceneCallback)paramAtomicReference.get()).a("mQQFilterRenderManager is null");
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.equals("network error"))) {
      this.mRootView.post(new VideoStoryAIScenePart.15(this));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      if (((AECameraGLSurfaceView)localObject).getSelectedCamera() == 1)
      {
        b();
        a(null);
        localObject = this.J;
        if (localObject != null) {
          this.r.removeCallbacks((Runnable)localObject);
        }
        f();
      }
      this.r.postDelayed(new VideoStoryAIScenePart.21(this), 1000L);
    }
    VSReporter.a("mystatus_shoot", "cam_reverse", 0, 0, new String[0]);
  }
  
  private void d()
  {
    if (this.mActivity != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
      this.G = localMarginLayoutParams1.bottomMargin;
      ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
      this.H = localMarginLayoutParams2.bottomMargin;
      ViewGroup.MarginLayoutParams localMarginLayoutParams3 = (ViewGroup.MarginLayoutParams)this.k.getLayoutParams();
      this.I = localMarginLayoutParams3.bottomMargin;
      if (this.F) {
        return;
      }
      int i1 = 0;
      if (AECameraEntryManager.k(this.mActivity.getIntent())) {
        i1 = 76;
      }
      if (i1 == 0) {
        return;
      }
      int i2 = this.G;
      float f1 = i1;
      localMarginLayoutParams1.bottomMargin = (i2 - ScreenUtil.dip2px(f1));
      this.i.setLayoutParams(localMarginLayoutParams1);
      localMarginLayoutParams2.bottomMargin = (this.H - ScreenUtil.dip2px(f1));
      this.j.setLayoutParams(localMarginLayoutParams2);
      localMarginLayoutParams3.bottomMargin = (this.I - ScreenUtil.dip2px(f1));
      this.k.setLayoutParams(localMarginLayoutParams3);
    }
  }
  
  private void e()
  {
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.E).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).b.observe(this.E, new VideoStoryAIScenePart.2(this));
    ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.E).get(AEVideoStoryCaptureModeViewModel.class)).a.observe(this.E, new VideoStoryAIScenePart.3(this));
    if (this.F) {
      ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.E).get(AEVideoStoryTopBarViewModel.class)).a.observe(this.E, new VideoStoryAIScenePart.4(this));
    }
  }
  
  private void f()
  {
    ImageView localImageView = this.p;
    if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
      this.p.post(new VideoStoryAIScenePart.6(this));
    }
  }
  
  private AnimationSet g()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.j.getMeasuredHeight(), 0.0F);
    if (this.v != null)
    {
      this.v = new AnimationSet(true);
      this.v.setInterpolator(new DecelerateInterpolator());
      this.v.setDuration(400L);
      this.v.addAnimation(localAlphaAnimation);
      this.v.addAnimation(localTranslateAnimation);
    }
    return this.v;
  }
  
  private void h()
  {
    if ((this.E.s() != null) && (this.F))
    {
      localObject = ThreadManager.getUIHandler();
      VideoStoryAIScenePart.19 local19 = new VideoStoryAIScenePart.19(this);
      this.D = local19;
      ((MqqHandler)localObject).postDelayed(local19, 250L);
    }
    Object localObject = this.i;
    if ((localObject != null) && (this.k != null) && (this.j != null)) {
      ((View)localObject).post(new VideoStoryAIScenePart.20(this));
    }
  }
  
  public void a()
  {
    this.j.setText(HardCodeUtil.a(2131913577));
    this.j.setVisibility(0);
    g();
    Object localObject1 = this.v;
    if (localObject1 != null) {
      this.j.setAnimation((Animation)localObject1);
    }
    this.n = new QQAnimationDrawable();
    String str = AEPath.AISCENE.FILES.e;
    String[] arrayOfString = null;
    localObject1 = arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      Object localObject2 = new File(str);
      localObject1 = arrayOfString;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        localObject1 = arrayOfString;
        if (localObject2 != null)
        {
          localObject1 = arrayOfString;
          if (localObject2.length > 0)
          {
            arrayOfString = new String[localObject2.length];
            int i1 = 0;
            for (;;)
            {
              localObject1 = arrayOfString;
              if (i1 >= localObject2.length) {
                break;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(File.separator);
              ((StringBuilder)localObject1).append("image_000");
              ((StringBuilder)localObject1).append(i1);
              ((StringBuilder)localObject1).append(".png");
              localObject1 = ((StringBuilder)localObject1).toString();
              if (new File((String)localObject1).exists()) {
                arrayOfString[i1] = localObject1;
              }
              i1 += 1;
            }
          }
        }
      }
    }
    this.n.a(1500L);
    this.n.a(false);
    this.i.setVisibility(0);
    this.i.setBackgroundDrawable(this.n);
    if (localObject1 != null) {
      this.n.a((String[])localObject1);
    }
    this.y = System.currentTimeMillis();
    this.n.start();
    this.mPartManager.b(851972, new Object[0]);
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    String str;
    if (paramQIMFilterCategoryItem != null) {
      str = paramQIMFilterCategoryItem.b;
    } else {
      str = "no filter";
    }
    localStringBuilder.append(str);
    Logger.a("Q.videostory", "Q.videostory.capture", "onFilterSelect", localStringBuilder.toString());
    if (paramInt != 0) {
      a(null);
    }
    if (this.B) {
      this.B = false;
    } else {
      b();
    }
    this.x = paramInt;
    this.u = paramQIMFilterCategoryItem;
    VSReporter.a("mystatus_shoot", "filter_change", 0, 0, new String[0]);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = this.j;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0) && (!this.z) && (!this.A.get()))
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.j.getMeasuredHeight());
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      this.j.startAnimation(localAnimationSet);
      localAnimationSet.setAnimationListener(new VideoStoryAIScenePart.7(this, paramBoolean, paramInt, paramString));
    }
  }
  
  public void a(TTAutoAISceneType paramTTAutoAISceneType)
  {
    Object localObject1 = this.s;
    if ((localObject1 != null) && (((AbsAECaptureButton)localObject1).g()))
    {
      a(null);
      b();
      return;
    }
    if (paramTTAutoAISceneType.a != -1)
    {
      localObject1 = this.E;
      if ((localObject1 == null) || (((AEPituCameraUnit)localObject1).aE()))
      {
        localObject1 = paramTTAutoAISceneType.d;
        if (AEDashboardUtil.d()) {
          localObject1 = paramTTAutoAISceneType.f;
        }
        Object localObject2 = VideoFilterTools.a().c(0);
        if (localObject2 != null) {
          localObject2 = ((QIMFilterCategoryItem)localObject2).b;
        } else {
          localObject2 = "";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append((String)localObject2);
          Logger.a("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", ((StringBuilder)localObject3).toString());
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("apply_source", CaptureComboManager.a);
          ((Bundle)localObject3).putInt("capture_scene", 0);
          ((Bundle)localObject3).putBoolean("capture_force_enable", this.C);
          CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
          if (localCaptureComboManager.f() == null)
          {
            paramTTAutoAISceneType = new ArrayList();
            b();
          }
          else
          {
            localObject2 = localCaptureComboManager.f().c;
            Object localObject4 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject4).next();
              if (localQIMFilterCategoryItem.b.equals(localObject1))
              {
                localQIMFilterCategoryItem.c = ((String)localObject1);
                localObject1 = new Message();
                localObject4 = new Bundle();
                ((Bundle)localObject4).putString("sceneName", paramTTAutoAISceneType.c);
                ((Bundle)localObject4).putInt("sceneLvOne", paramTTAutoAISceneType.a);
                ((Message)localObject1).setData((Bundle)localObject4);
                ((Message)localObject1).what = 1;
                long l1 = this.y;
                this.l.sendMessageDelayed((Message)localObject1, 0L);
                this.mRootView.postDelayed(new VideoStoryAIScenePart.13(this, localQIMFilterCategoryItem, (Bundle)localObject3, localCaptureComboManager), 500L);
              }
            }
            paramTTAutoAISceneType = (TTAutoAISceneType)localObject2;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("filterLister is empty:");
          ((StringBuilder)localObject1).append(paramTTAutoAISceneType.size());
          Logger.a("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", ((StringBuilder)localObject1).toString());
          return;
        }
        b();
        return;
      }
    }
    b();
  }
  
  public void a(CameraCaptureView.AISceneCallback paramAISceneCallback)
  {
    this.f.set(paramAISceneCallback);
  }
  
  public void a(String paramString)
  {
    AbsAECaptureButton localAbsAECaptureButton = this.s;
    if ((localAbsAECaptureButton != null) && (localAbsAECaptureButton.g()))
    {
      a(null);
      return;
    }
    b(paramString);
    this.mRootView.post(new VideoStoryAIScenePart.14(this));
    Logger.a("Q.videostory", "Q.videostory.capture", "onAISceneFail", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void b()
  {
    a(0, null, false);
  }
  
  public void c()
  {
    this.g.set(true);
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 196610) {
      return super.get(paramInt, paramVarArgs);
    }
    return this.u;
  }
  
  protected void initView()
  {
    this.F = AECameraEntryManager.o(this.mActivity.getIntent());
    this.i = this.mRootView.findViewById(2063990867);
    this.k = ((TextView)this.mRootView.findViewById(2063990871));
    this.j = ((TextView)this.mRootView.findViewById(2063990870));
    this.p = ((ImageView)this.mRootView.findViewById(2063990868));
    this.q = this.mRootView.findViewById(2063990869);
    this.m = new QQAnimationDrawable();
    this.o = new QQAnimationDrawable();
    this.r = ((AECameraGLSurfaceView)this.mRootView.findViewById(2063990947));
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2063991433);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    this.s = ((AbsAECaptureButton)this.mRootView.findViewById(2063990959));
    this.w = ((AEMaterialPanel)this.mRootView.findViewById(2063991338));
    a(this);
    this.l = new VideoStoryAIScenePart.1(this, Looper.getMainLooper());
    d();
    e();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    QQAnimationDrawable localQQAnimationDrawable = this.n;
    if (localQQAnimationDrawable != null) {
      localQQAnimationDrawable.stop();
    }
    localQQAnimationDrawable = this.o;
    if (localQQAnimationDrawable != null) {
      localQQAnimationDrawable.stop();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume()
  {
    super.onActivityResume();
    QQAnimationDrawable localQQAnimationDrawable = this.n;
    if (localQQAnimationDrawable != null) {
      localQQAnimationDrawable.start();
    }
    localQQAnimationDrawable = this.o;
    if (localQQAnimationDrawable != null) {
      localQQAnimationDrawable.start();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Runnable localRunnable = this.h;
    if (localRunnable != null)
    {
      ThreadManager.removeJobFromThreadPool(localRunnable, 128);
      this.h = null;
    }
    if (this.D != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.D);
    }
    this.mActivity = null;
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 196610: 
    default: 
    case 196616: 
      f();
      return;
    case 196615: 
      a(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    case 196614: 
      f();
      a(this);
      c();
      return;
    case 196613: 
      h();
      return;
    case 196612: 
      paramVarArgs = this.w;
      if (paramVarArgs != null)
      {
        a(paramVarArgs);
        return;
      }
      break;
    case 196611: 
      b(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    case 196609: 
      a(null);
      this.A.set(true);
      this.l.removeMessages(1);
      this.l.post(new VideoStoryAIScenePart.17(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart
 * JD-Core Version:    0.7.0.1
 */