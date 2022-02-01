package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.capture.AbsQIMCaptureController;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMProviderViewBuilder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public class QIMProviderContainerView
  extends AbsBottomPanal
{
  private float jdField_a_of_type_Float = 0.0F;
  public int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QIMProviderContainerView.1(this);
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AbsQIMCaptureController jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAbsQIMCaptureController;
  private QIMProviderViewBuilder jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder;
  private ProviderView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<QIMProviderContainerView.ContainerViewListener2> jdField_a_of_type_JavaUtilList = new ArrayList();
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  View c;
  public boolean c;
  private View d;
  public boolean d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = true;
  private boolean i = false;
  
  public QIMProviderContainerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  public QIMProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560877, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368356));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131373177));
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366465);
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131366464);
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131380368);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder = new QIMProviderViewBuilder(0);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_AndroidViewView);
  }
  
  private void a(int paramInt)
  {
    this.f = true;
    a(paramInt, true);
    paramInt = UIUtils.a(getContext(), 88.0F);
    Object localObject1 = new ArrayList();
    float f1 = paramInt;
    ((List)localObject1).add(ObjectAnimator.ofFloat(this, "translationY", new float[] { f1, 0.0F }));
    ((List)localObject1).add(ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "alpha", new float[] { 0.0F, 1.0F }));
    ((List)localObject1).add(QIMAnimationUtils.a(this.jdField_a_of_type_AndroidViewView, getResources().getColor(2131165473), 0, 153));
    ((List)localObject1).add(QIMAnimationUtils.a(this.jdField_b_of_type_AndroidViewView, getResources().getColor(2131165473), 0, 153));
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAbsQIMCaptureController.jdField_a_of_type_AndroidViewView.findViewById(2131380580);
    if (localObject2 != null) {
      ((List)localObject1).add(ObjectAnimator.ofFloat(localObject2, "translationY", new float[] { f1, 0.0F }));
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).addListener(new QIMProviderContainerView.2(this));
    ((AnimatorSet)localObject2).setDuration(300L).start();
    localObject1 = QIMAnimationUtils.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView, 0.0F, 1.0F);
    ((Animation)localObject1).setStartOffset(200L);
    ((Animation)localObject1).setDuration(100L);
    ((Animation)localObject1).setAnimationListener(new QIMProviderContainerView.3(this));
    startAnimation((Animation)localObject1);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
    if (localObject != null)
    {
      ((ProviderView)localObject).d();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.c(paramInt))))
    {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.c(paramInt)));
    }
    else
    {
      int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.c(paramInt);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.a(getContext(), j);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.c(paramInt)), localObject);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("build provider view failed ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.e("ProviderContainerView", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (localObject != null)
    {
      if (!((ProviderView)localObject).jdField_d_of_type_Boolean)
      {
        ((ProviderView)localObject).setProviderViewListener(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAbsQIMCaptureController);
        ((ProviderView)localObject).setDoodleEventListener(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAbsQIMCaptureController);
        ((ProviderView)localObject).a(null);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = ((ProviderView)localObject);
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.getId() != 2131364288) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAbsQIMCaptureController.b(false);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMProviderContainerView.ContainerViewListener2 localContainerViewListener2 = (QIMProviderContainerView.ContainerViewListener2)((Iterator)localObject).next();
        if (localContainerViewListener2 != null) {
          localContainerViewListener2.a(false);
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.c();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.h = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAbsQIMCaptureController.jdField_a_of_type_Int;
    }
  }
  
  private void b()
  {
    ThreadManager.excute(new QIMProviderContainerView.7(this), 64, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!this.g)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("doOpenProviderView failed isInflated");
        paramString1.append(this.g);
        QLog.e("ProviderContainerView", 2, paramString1.toString());
      }
      return;
    }
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()))
    {
      Object localObject = this.jdField_d_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setSelected(false);
        this.e = true;
      }
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
      this.jdField_d_of_type_AndroidViewView.setSelected(true);
      this.jdField_a_of_type_Int = paramInt1;
      ((ImageView)this.jdField_d_of_type_AndroidViewView).setImageResource(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.a(paramInt1));
      if (!this.e) {
        a(paramInt1);
      } else {
        a(paramInt1, false);
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAbsQIMCaptureController;
      if (localObject != null) {
        ((AbsQIMCaptureController)localObject).a(paramInt1, paramBoolean);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.a(paramInt1);
      if (paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("openSpecificTabByWeb tab_index= ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(",categoryId=");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(",categoryName=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("itemId=");
          ((StringBuilder)localObject).append(paramString2);
          QLog.d("ProviderContainerView", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.a(paramInt2, paramString1, paramString2);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("doOpenProviderView failed out bounds");
      paramString1.append(paramInt1);
      paramString1.append(" size:");
      paramString1.append(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount());
      QLog.e("ProviderContainerView", 2, paramString1.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, null, paramString, paramBoolean);
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
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.a(paramBoolean);
    }
  }
  
  public void setCaptureControllerAndPreloadView(AbsQIMCaptureController paramAbsQIMCaptureController)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureAbsQIMCaptureController = paramAbsQIMCaptureController;
    this.g = true;
    if (QLog.isColorLevel()) {
      QLog.d("ProviderContainerView", 2, "preloadProviderView");
    }
  }
  
  public void setComboEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.d(paramBoolean);
    }
  }
  
  public void setDpcEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.f(paramBoolean);
    }
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.c(paramBoolean);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.b(paramBoolean);
    }
  }
  
  public void setIsGuideMode(boolean paramBoolean)
  {
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
    if (localMusicProviderView != null) {
      localMusicProviderView.setIsGuideMode(paramBoolean);
    }
  }
  
  public void setMusicEnable(boolean paramBoolean)
  {
    QIMProviderViewBuilder localQIMProviderViewBuilder = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder;
    if (localQIMProviderViewBuilder != null) {
      localQIMProviderViewBuilder.e(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView
 * JD-Core Version:    0.7.0.1
 */