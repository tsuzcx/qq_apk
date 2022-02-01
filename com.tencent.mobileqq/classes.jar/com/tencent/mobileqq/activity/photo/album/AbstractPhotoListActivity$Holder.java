package com.tencent.mobileqq.activity.photo.album;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.NumberCheckBox;

public class AbstractPhotoListActivity$Holder
  extends RecyclerView.ViewHolder
{
  AbstractPhotoListActivity.CheckBoxClickedListener checkBoxListener;
  public NumberCheckBox mCheckBox;
  URLDrawable mDrawable;
  TextView mImageType;
  ImageView mImageView;
  public ImageView mImageViewPanoramaIcon;
  ImageView mMaskView;
  AbstractPhotoListActivity.OnItemClickListener mOnItemClickListener;
  public ImageView mPhotoFlagView;
  View mSelectedBtn;
  ImageView mSelectedIconView;
  TextView mTextView;
  
  public AbstractPhotoListActivity$Holder(@NonNull View paramView)
  {
    super(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.Holder
 * JD-Core Version:    0.7.0.1
 */