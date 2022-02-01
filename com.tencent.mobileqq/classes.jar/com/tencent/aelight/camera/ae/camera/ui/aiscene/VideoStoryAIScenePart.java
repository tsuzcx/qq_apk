package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
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
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
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
import java.nio.Buffer;
import java.nio.ByteBuffer;
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
  private final int jdField_a_of_type_Int = 400;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = (AEPituCameraUnit)this.mPartManager.a(65537, new Object[0]);
  private AECameraGLSurfaceView jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView;
  private FilterPagerViewStubHolder jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder;
  private IAIScene jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneIAIScene = new TTAutoAIScene();
  private AEMaterialPanel jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
  private AbsAECaptureButton jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton;
  private QIMFilterCategoryItem jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString = "ai_guide_shown";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicReference<CameraCaptureView.AISceneCallback> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int = 1500;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQAnimationDrawable jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 2000;
  private QQAnimationDrawable jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  
  public VideoStoryAIScenePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
  }
  
  private AnimationSet a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight(), 0.0F);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localTranslateAnimation);
    }
    return this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
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
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131716148));
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131716147));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setAnimation(a());
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
            int i;
            for (paramInt = 0;; paramInt = i)
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
              i = paramInt + 1;
              paramString.append(i);
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
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2500L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    if (paramString != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    this.jdField_a_of_type_AndroidViewView.postDelayed(new VideoStoryAIScenePart.8(this), 2500L);
    localAlphaAnimation1.setAnimationListener(new VideoStoryAIScenePart.9(this, localAlphaAnimation2));
    localAlphaAnimation2.setAnimationListener(new VideoStoryAIScenePart.10(this));
  }
  
  private void a(AEMaterialPanel paramAEMaterialPanel)
  {
    Activity localActivity = (Activity)paramAEMaterialPanel.getContext();
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && ((localView.getVisibility() == 0) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)))
    {
      int i = UIUtils.c(localActivity);
      this.jdField_a_of_type_AndroidViewView.post(new VideoStoryAIScenePart.18(this, paramAEMaterialPanel, i));
    }
  }
  
  private void a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    Object localObject = AEVideoStoryTopBarViewModel.Ratio.R_1_1;
    int i = 0;
    if (paramRatio == localObject)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2064122016);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(f1 - this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth()) >> 1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 0);
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1)
    {
      double d1 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels / f1;
      if (d1 < 1.78D) {
        i = -20;
      } else if (d1 >= 1.78D) {
        i = -DisplayUtil.a(this.mActivity, f1 / 2.0F);
      }
    }
    else if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL)
    {
      i = 46;
    }
    if (i == 0) {
      return;
    }
    paramRatio = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int j = this.e;
    f1 = i;
    paramRatio.bottomMargin = (j - ScreenUtil.dip2px(f1));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramRatio);
    paramRatio = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramRatio.bottomMargin = (this.f - ScreenUtil.dip2px(f1));
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramRatio);
    paramRatio = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    paramRatio.bottomMargin = (this.g - ScreenUtil.dip2px(f1));
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramRatio);
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
      Object localObject2 = paramAEFilterManager.getFaceAttr();
      Object localObject1 = ((PTFaceAttr)localObject2).getData();
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        int i = ((PTFaceAttr)localObject2).getFaceDetWidth();
        int j = ((PTFaceAttr)localObject2).getFaceDetHeight();
        paramAEFilterManager = new ArrayList();
        localObject2 = ((PTFaceAttr)localObject2).getAllFacePoints();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (List)((Iterator)localObject2).next();
            float f1 = ((PointF)((List)localObject3).get(18)).x;
            float f2 = ((PointF)((List)localObject3).get(0)).x;
            float f3 = ((PointF)((List)localObject3).get(9)).y;
            float f4 = ((PointF)((List)localObject3).get(87)).y;
            localObject3 = new IAIScene.FaceRect();
            ((IAIScene.FaceRect)localObject3).jdField_b_of_type_Int = ((int)(f3 - f4));
            ((IAIScene.FaceRect)localObject3).jdField_a_of_type_Int = ((int)(f1 - f2));
            paramAEFilterManager.add(localObject3);
          }
        }
        if ((i != 0) && (j != 0))
        {
          localObject2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          localObject1 = ByteBuffer.wrap((byte[])localObject1);
          try
          {
            ((Bitmap)localObject2).copyPixelsFromBuffer((Buffer)localObject1);
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
            this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAisceneIAIScene.a((Bitmap)localObject2, paramAEFilterManager, new VideoStoryAIScenePart.12(this, paramAtomicReference));
            return;
          }
          catch (Exception paramAEFilterManager)
          {
            if ((CameraCaptureView.AISceneCallback)paramAtomicReference.get() == null) {
              break label387;
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
        label387:
        return;
      }
      AEQLog.d("AEAIScenePart", "requestAIScene: ptFaceAttr.getData() == null, 不使用智能滤镜");
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
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView;
    if (localObject != null)
    {
      if (((AECameraGLSurfaceView)localObject).getSelectedCamera() == 1)
      {
        b();
        a(null);
        localObject = this.jdField_c_of_type_JavaLangRunnable;
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.removeCallbacks((Runnable)localObject);
        }
        g();
      }
      else if (!paramBoolean)
      {
        if (this.jdField_c_of_type_JavaLangRunnable == null) {
          this.jdField_c_of_type_JavaLangRunnable = new VideoStoryAIScenePart.21(this);
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1000L);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.postDelayed(new VideoStoryAIScenePart.22(this), 1000L);
    }
    VSReporter.a("mystatus_shoot", "cam_reverse", 0, 0, new String[0]);
  }
  
  private void d()
  {
    if (this.mActivity != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      this.e = localMarginLayoutParams1.bottomMargin;
      ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      this.f = localMarginLayoutParams2.bottomMargin;
      ViewGroup.MarginLayoutParams localMarginLayoutParams3 = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      this.g = localMarginLayoutParams3.bottomMargin;
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      int i = 0;
      if (AECameraEntryManager.g(this.mActivity.getIntent())) {
        i = 76;
      }
      if (i == 0) {
        return;
      }
      int j = this.e;
      float f1 = i;
      localMarginLayoutParams1.bottomMargin = (j - ScreenUtil.dip2px(f1));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localMarginLayoutParams1);
      localMarginLayoutParams2.bottomMargin = (this.f - ScreenUtil.dip2px(f1));
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localMarginLayoutParams2);
      localMarginLayoutParams3.bottomMargin = (this.g - ScreenUtil.dip2px(f1));
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localMarginLayoutParams3);
    }
  }
  
  private void e()
  {
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).b.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryAIScenePart.2(this));
    ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class)).a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryAIScenePart.3(this));
    if (this.jdField_d_of_type_Boolean) {
      ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class)).a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryAIScenePart.4(this));
    }
  }
  
  private void f()
  {
    if (AECameraPrefsUtil.a().a("ai_guide_shown", false, 0)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getSelectedCamera() == 1) {
      return;
    }
    String str = AEPath.AISCENE.FILES.d;
    String[] arrayOfString = null;
    Object localObject1 = arrayOfString;
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
            int i = 0;
            for (;;)
            {
              localObject1 = arrayOfString;
              if (i >= localObject2.length) {
                break;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(File.separator);
              ((StringBuilder)localObject1).append("tap_");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(".png");
              localObject1 = ((StringBuilder)localObject1).toString();
              if (new File((String)localObject1).exists()) {
                arrayOfString[i] = localObject1;
              }
              i += 1;
            }
          }
        }
      }
    }
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2000L);
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (localObject1 != null) {
      this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject1);
    }
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new VideoStoryAIScenePart.5(this), 10000L);
  }
  
  private void g()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetImageView.post(new VideoStoryAIScenePart.6(this));
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a() != null) && (this.jdField_d_of_type_Boolean))
    {
      localObject = ThreadManager.getUIHandler();
      VideoStoryAIScenePart.19 local19 = new VideoStoryAIScenePart.19(this);
      this.jdField_b_of_type_JavaLangRunnable = local19;
      ((MqqHandler)localObject).postDelayed(local19, 250L);
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if ((localObject != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      ((View)localObject).post(new VideoStoryAIScenePart.20(this));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131716128));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
    Object localObject1 = this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
    if (localObject1 != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setAnimation((Animation)localObject1);
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
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
            int i = 0;
            for (;;)
            {
              localObject1 = arrayOfString;
              if (i >= localObject2.length) {
                break;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(File.separator);
              ((StringBuilder)localObject1).append("image_000");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(".png");
              localObject1 = ((StringBuilder)localObject1).toString();
              if (new File((String)localObject1).exists()) {
                arrayOfString[i] = localObject1;
              }
              i += 1;
            }
          }
        }
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(1500L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    if (localObject1 != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject1);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    this.mPartManager.a(851972, new Object[0]);
  }
  
  public void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    Log.d("AEAIScenePart", "onAIScene: ");
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) && (paramInt == 2))
    {
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new VideoStoryAIScenePart.11(this, paramAEFilterManager);
      }
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 128, null, true);
    }
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
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    } else {
      b();
    }
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem = paramQIMFilterCategoryItem;
    VSReporter.a("mystatus_shoot", "filter_change", 0, 0, new String[0]);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight());
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
      localAnimationSet.setAnimationListener(new VideoStoryAIScenePart.7(this, paramBoolean, paramInt, paramString));
    }
  }
  
  public void a(TTAutoAISceneType paramTTAutoAISceneType)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton;
    if ((localObject1 != null) && (((AbsAECaptureButton)localObject1).a()))
    {
      a(null);
      b();
      return;
    }
    if (paramTTAutoAISceneType.jdField_a_of_type_Int != -1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
      if ((localObject1 == null) || (((AEPituCameraUnit)localObject1).n()))
      {
        Object localObject2 = paramTTAutoAISceneType.b;
        localObject1 = VideoFilterTools.a().c(0);
        if (localObject1 != null) {
          localObject1 = ((QIMFilterCategoryItem)localObject1).b;
        } else {
          localObject1 = "";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append((String)localObject1);
          Logger.a("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", ((StringBuilder)localObject3).toString());
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("apply_source", CaptureComboManager.jdField_a_of_type_Int);
          ((Bundle)localObject3).putInt("capture_scene", 0);
          ((Bundle)localObject3).putBoolean("capture_force_enable", this.jdField_c_of_type_Boolean);
          CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
          if (localCaptureComboManager.a() == null)
          {
            paramTTAutoAISceneType = new ArrayList();
            b();
          }
          else
          {
            localObject1 = localCaptureComboManager.a().c;
            Object localObject4 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject4).next();
              if (localQIMFilterCategoryItem.b.equals(localObject2))
              {
                localQIMFilterCategoryItem.c = ((String)localObject2);
                localObject2 = new Message();
                localObject4 = new Bundle();
                ((Bundle)localObject4).putString("sceneName", paramTTAutoAISceneType.jdField_a_of_type_JavaLangString);
                ((Bundle)localObject4).putInt("sceneLvOne", paramTTAutoAISceneType.jdField_a_of_type_Int);
                ((Message)localObject2).setData((Bundle)localObject4);
                ((Message)localObject2).what = 1;
                long l = this.jdField_a_of_type_Long;
                this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, 0L);
                this.mRootView.postDelayed(new VideoStoryAIScenePart.13(this, localQIMFilterCategoryItem, (Bundle)localObject3, localCaptureComboManager), 500L);
              }
            }
            paramTTAutoAISceneType = (TTAutoAISceneType)localObject1;
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(paramAISceneCallback);
  }
  
  public void a(String paramString)
  {
    AbsAECaptureButton localAbsAECaptureButton = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton;
    if ((localAbsAECaptureButton != null) && (localAbsAECaptureButton.a()))
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
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    a(0, null, false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 196610) {
      return super.get(paramInt, paramVarArgs);
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataQIMFilterCategoryItem;
  }
  
  protected void initView()
  {
    this.jdField_d_of_type_Boolean = AECameraEntryManager.k(this.mActivity.getIntent());
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2064121933);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2064121937));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2064121936));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mRootView.findViewById(2064121934));
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2064121935);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2064122016));
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2064122646);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton = ((AbsAECaptureButton)this.mRootView.findViewById(2064122025));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.mRootView.findViewById(2064122519));
    a(this);
    this.jdField_a_of_type_AndroidOsHandler = new VideoStoryAIScenePart.1(this, Looper.getMainLooper());
    d();
    e();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    QQAnimationDrawable localQQAnimationDrawable = this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
    if (localQQAnimationDrawable != null) {
      localQQAnimationDrawable.stop();
    }
    localQQAnimationDrawable = this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
    if (localQQAnimationDrawable != null) {
      localQQAnimationDrawable.stop();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume()
  {
    super.onActivityResume();
    QQAnimationDrawable localQQAnimationDrawable = this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
    if (localQQAnimationDrawable != null) {
      localQQAnimationDrawable.start();
    }
    localQQAnimationDrawable = this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
    if (localQQAnimationDrawable != null) {
      localQQAnimationDrawable.start();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      ThreadManager.removeJobFromThreadPool(localRunnable, 128);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.mActivity = null;
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 196610: 
    default: 
    case 196617: 
      a(((Integer)paramVarArgs[0]).intValue(), (AEFilterManager)paramVarArgs[1]);
      return;
    case 196616: 
      g();
      return;
    case 196615: 
      a(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    case 196614: 
      g();
      a(this);
      c();
      return;
    case 196613: 
      h();
      return;
    case 196612: 
      paramVarArgs = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
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
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoStoryAIScenePart.17(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart
 * JD-Core Version:    0.7.0.1
 */