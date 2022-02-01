package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AEProviderContainerView
  extends AEAbsBottomPanal
{
  public int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AEProviderContainerView.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private AECaptureController jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
  private AEBeautyProviderView jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView;
  private AEFilterProviderView jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
  private AECaptureMode jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode = AECaptureMode.NORMAL;
  private VideoStoryCapturePartManager jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  
  public AEProviderContainerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), 195.0F);
    i();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), 195.0F);
    i();
  }
  
  public AEProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), 195.0F);
    i();
  }
  
  private void i()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2064318520, null);
    addView(localView);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2064121977);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2064122198);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2064122516));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2064122517);
    this.jdField_d_of_type_AndroidViewView = localView.findViewById(2064122029);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void j()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      l();
      return;
    }
    k();
  }
  
  private void k()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewView.setSelected(true);
    this.jdField_a_of_type_AndroidViewView.setSelected(false);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView;
    if (localObject != null)
    {
      ((AEBeautyProviderView)localObject).setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView = null;
      n();
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView = new AEFilterProviderView(getContext());
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.setNeedTabBar(false);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.d(UIUtils.a(getContext(), 162.0F));
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    if (localObject != null)
    {
      if (!((AEFilterProviderView)localObject).d) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.a(null);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.c();
    }
    if (AECameraEntryManager.k(((Activity)getContext()).getIntent())) {
      AEReportUtils.a(11, null);
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_AndroidViewView.setSelected(false);
    this.jdField_a_of_type_AndroidViewView.setSelected(true);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    if (localObject != null)
    {
      ((AEFilterProviderView)localObject).d();
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView = new AEBeautyProviderView(getContext());
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView;
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView;
    if (localObject != null)
    {
      if (!((AEBeautyProviderView)localObject).jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView.setController(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController);
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView.a(null);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView.a();
    }
    if (AECameraEntryManager.k(((Activity)getContext()).getIntent()))
    {
      this.jdField_c_of_type_Int = AEBeautyProviderView.a();
      this.jdField_d_of_type_Int = AEBeautyProviderView.b();
      AEReportUtils.a(12, null);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject = ObjectAnimator.ofFloat(this, "translationY", new float[] { 0.0F, this.jdField_a_of_type_Int });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.addListener(new AEProviderContainerView.4(this));
    localAnimatorSet.setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this, 1.0F, 0.0F);
    ((Animation)localObject).setStartOffset(0L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEProviderContainerView.5(this));
    startAnimation((Animation)localObject);
  }
  
  private void n()
  {
    if (AECameraEntryManager.k(((Activity)getContext()).getIntent()))
    {
      int i = AEBeautyProviderView.a();
      HashMap localHashMap;
      if (i != this.jdField_c_of_type_Int)
      {
        localHashMap = new HashMap();
        localHashMap.put("ext15", String.valueOf(i));
        AEReportUtils.a(12, 3, localHashMap);
      }
      i = AEBeautyProviderView.b();
      if (i != this.jdField_d_of_type_Int)
      {
        localHashMap = new HashMap();
        localHashMap.put("ext15", String.valueOf(i));
        AEReportUtils.a(12, 4, localHashMap);
      }
    }
  }
  
  public void a()
  {
    AEFilterProviderView localAEFilterProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    if (localAEFilterProviderView != null)
    {
      localAEFilterProviderView.a();
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      m();
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    if (localObject != null)
    {
      ((AEFilterProviderView)localObject).d();
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView.setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView;
    if (localObject != null)
    {
      ((AEBeautyProviderView)localObject).setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView = null;
      n();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).a(196613, new Object[0]);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEProviderContainerView", 2, "panel closed");
    }
  }
  
  public boolean a()
  {
    return c() ^ true;
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOpenProviderView failed isInflated");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        QLog.e("AEProviderContainerView", 2, localStringBuilder.toString());
      }
      return;
    }
    j();
    e();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.GIF;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    if (localObject != null) {
      ((AEFilterProviderView)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView;
    if (localObject != null) {
      ((AEBeautyProviderView)localObject).b();
    }
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    int j = 0;
    if ((localObject == null) && (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView == null)) {
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    int i;
    boolean bool1;
    if (localObject != null)
    {
      if (((AEFilterProviderView)localObject).getVisibility() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = i | 0x0;
    }
    else
    {
      bool1 = false;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      i = j;
      if (((AEBeautyProviderView)localObject).getVisibility() == 0) {
        i = 1;
      }
      bool2 = bool1 | i;
    }
    return bool2;
  }
  
  public void d()
  {
    a(true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(ObjectAnimator.ofFloat(this, "translationY", new float[] { this.jdField_a_of_type_Int, 0.0F }));
    ((AnimatorSet)localObject).addListener(new AEProviderContainerView.2(this));
    ((AnimatorSet)localObject).setDuration(300L).start();
    localObject = QIMAnimationUtils.a(this, 0.0F, 1.0F);
    ((Animation)localObject).setStartOffset(200L);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new AEProviderContainerView.3(this));
    startAnimation((Animation)localObject);
  }
  
  public void f()
  {
    AEFilterProviderView localAEFilterProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    if (localAEFilterProviderView != null) {
      localAEFilterProviderView.f();
    }
  }
  
  public void g()
  {
    AEFilterProviderView localAEFilterProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEFilterProviderView;
    if (localAEFilterProviderView != null) {
      localAEFilterProviderView.b();
    }
    VideoFilterTools.a().b(null, (Activity)getContext(), 0);
    VideoFilterTools.a().a(null, 0);
    ((CaptureComboManager)QIMManager.a(5)).a((Activity)getContext());
  }
  
  public void h()
  {
    AEBeautyProviderView localAEBeautyProviderView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEBeautyProviderView;
    if (localAEBeautyProviderView != null) {
      localAEBeautyProviderView.c();
    }
  }
  
  public void setBackGroundAlpha(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        if (localView != null) {
          localView.setAlpha(paramFloat);
        }
      }
    }
  }
  
  public void setCaptureMode(AECaptureMode paramAECaptureMode)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode = paramAECaptureMode;
  }
  
  public void setControllerAndManager(AECaptureController paramAECaptureController, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController = paramAECaptureController;
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager = paramVideoStoryCapturePartManager;
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderContainerView
 * JD-Core Version:    0.7.0.1
 */