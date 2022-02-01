package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.widget.AECircleVideoPreviewItemView;
import com.tencent.aelight.camera.ae.biz.circle.widget.MultiTouchImageView;

public class PhotoPreviewAdapter$PhotoPreviewVH
  extends RecyclerView.ViewHolder
{
  public AECircleVideoPreviewItemView a;
  public MultiTouchImageView a;
  
  public PhotoPreviewAdapter$PhotoPreviewVH(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetMultiTouchImageView = ((MultiTouchImageView)paramView.findViewById(2064122489));
    if ((paramView instanceof AECircleVideoPreviewItemView)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleWidgetAECircleVideoPreviewItemView = ((AECircleVideoPreviewItemView)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoPreviewAdapter.PhotoPreviewVH
 * JD-Core Version:    0.7.0.1
 */