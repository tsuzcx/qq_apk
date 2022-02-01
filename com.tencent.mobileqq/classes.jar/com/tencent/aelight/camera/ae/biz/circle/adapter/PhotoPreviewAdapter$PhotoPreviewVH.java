package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.widget.AECircleVideoPreviewItemView;
import com.tencent.aelight.camera.ae.biz.circle.widget.MultiTouchImageView;

public class PhotoPreviewAdapter$PhotoPreviewVH
  extends RecyclerView.ViewHolder
{
  public MultiTouchImageView a;
  public AECircleVideoPreviewItemView b;
  
  public PhotoPreviewAdapter$PhotoPreviewVH(View paramView)
  {
    super(paramView);
    this.a = ((MultiTouchImageView)paramView.findViewById(2063991303));
    if ((paramView instanceof AECircleVideoPreviewItemView)) {
      this.b = ((AECircleVideoPreviewItemView)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoPreviewAdapter.PhotoPreviewVH
 * JD-Core Version:    0.7.0.1
 */