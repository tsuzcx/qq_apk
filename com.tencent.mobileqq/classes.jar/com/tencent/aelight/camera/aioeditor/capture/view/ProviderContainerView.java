package com.tencent.aelight.camera.aioeditor.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@TargetApi(14)
public class ProviderContainerView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ProviderContainerView.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProviderContainerView.ProviderContainViewListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView$ProviderContainViewListener;
  private ProviderView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
  private ProviderViewBuilder jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder;
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public ProviderContainerView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ProviderContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.c(paramInt);
    if (paramInt == 100)
    {
      paramImageView.setContentDescription(HardCodeUtil.a(2131709773));
      return;
    }
    if (paramInt == 101) {
      paramImageView.setContentDescription(HardCodeUtil.a(2131709777));
    }
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560871, null);
    addView(localView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368356));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131373177));
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
    if (localObject != null)
    {
      ((ProviderView)localObject).d();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.c(paramInt))))
    {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.c(paramInt)));
    }
    else
    {
      int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.c(paramInt);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.a(getContext(), i);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.c(paramInt)), localObject);
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
      if (!((ProviderView)localObject).d) {
        ((ProviderView)localObject).a(null);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = ((ProviderView)localObject);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.c();
    }
  }
  
  public <T extends ProviderView> T a(Class<? extends ProviderView> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      if (paramClass.isInstance(localProviderView)) {
        return localProviderView;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount()))
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setSelected(false);
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      c(paramInt);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOpenProviderView failed out bounds");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" size:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount());
      QLog.e("ProviderContainerView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, List<Integer> paramList)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder = new ProviderViewBuilder(paramInt, paramList);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.a())
    {
      paramList = new PressScaleImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      paramList.setTag(Integer.valueOf(paramInt));
      paramList.setId(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.b(paramInt));
      paramList.setImageResource(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewBuilder.a(paramInt));
      paramList.setScaleType(ImageView.ScaleType.CENTER);
      paramList.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(paramList, paramInt);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList, localLayoutParams);
      paramInt += 1;
    }
    paramList = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    paramList.height = UIUtils.a(getContext(), 272.0F);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramList);
  }
  
  public void b(int paramInt)
  {
    String str;
    if (paramInt == 102) {
      str = "0X800B3D1";
    } else if (paramInt == 101) {
      str = "0X800B3CD";
    } else if (paramInt == 100) {
      str = "0X800B3CF";
    } else {
      str = null;
    }
    if (str != null) {
      EditActivityEntranceUtil.a(str, this.jdField_a_of_type_Int);
    }
  }
  
  public void setEditActivityEntrance(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setProviderContainViewListener(ProviderContainerView.ProviderContainViewListener paramProviderContainViewListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView$ProviderContainViewListener = paramProviderContainViewListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView
 * JD-Core Version:    0.7.0.1
 */