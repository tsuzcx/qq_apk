package com.tencent.aelight.camera.ae.mode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;

class AEVideoStoryCaptureModePart$AECaptureModeAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder> jdField_a_of_type_AndroidUtilSparseArray;
  
  AEVideoStoryCaptureModePart$AECaptureModeAdapter(AEVideoStoryCaptureModePart paramAEVideoStoryCaptureModePart, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModePart) == null) {
      return 0;
    }
    return AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModePart).length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @SuppressLint({"ResourceType"})
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2064318470, null);
      localObject1 = new AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder(this);
      ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2);
      ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2064122405));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    localObject2 = AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModePart)[paramInt];
    TextView localTextView = ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setText(((AECaptureMode)localObject2).textId);
    if (AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModePart))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165327));
    }
    else
    {
      localTextView.setShadowLayer(4.0F, 0.0F, 2.0F, localTextView.getResources().getColor(2131165337));
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    }
    if (AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModePart) == localObject2) {
      localTextView.setAlpha(1.0F);
    } else {
      localTextView.setAlpha(0.6F);
    }
    localTextView.setOnClickListener(new AEVideoStoryCaptureModePart.AECaptureModeAdapter.1(this, (AECaptureMode)localObject2, paramInt));
    paramViewGroup.addView(((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView);
    return ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart.AECaptureModeAdapter
 * JD-Core Version:    0.7.0.1
 */