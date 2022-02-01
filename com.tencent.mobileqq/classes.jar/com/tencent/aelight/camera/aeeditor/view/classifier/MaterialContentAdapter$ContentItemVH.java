package com.tencent.aelight.camera.aeeditor.view.classifier;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;

public class MaterialContentAdapter$ContentItemVH
  extends RecyclerView.ViewHolder
{
  public TextView a;
  public AEDownLoadingView a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public ImageView f;
  public ImageView g;
  
  public MaterialContentAdapter$ContentItemVH(View paramView)
  {
    super(paramView);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122331));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122795));
    this.c = ((ImageView)paramView.findViewById(2064122325));
    this.d = ((ImageView)paramView.findViewById(2064122327));
    this.e = ((ImageView)paramView.findViewById(2064122295));
    this.f = ((ImageView)paramView.findViewById(2064122313));
    this.g = ((ImageView)paramView.findViewById(2064122307));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2064122512));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122776));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgCorner(paramInt3 / 2);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumHeight(paramInt3);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumWidth(paramInt3);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressSizeAndMode(paramInt1, paramInt2, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.g.getVisibility() != 0))
    {
      this.g.setVisibility(0);
      return;
    }
    if ((!paramBoolean) && (this.g.getVisibility() != 4)) {
      this.g.setVisibility(4);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.f.getVisibility() != 0)
      {
        this.f.setVisibility(0);
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(0);
      }
      a(false);
    }
    else if (this.f.getVisibility() != 4)
    {
      this.f.setVisibility(4);
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.ContentItemVH
 * JD-Core Version:    0.7.0.1
 */