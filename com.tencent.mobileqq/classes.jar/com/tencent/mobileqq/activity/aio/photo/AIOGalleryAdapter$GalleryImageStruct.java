package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery.LayoutParams;

public class AIOGalleryAdapter$GalleryImageStruct
  extends LinearLayout
{
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AIOGalleryAdapter.GalleryImageStruct.GalleryUrlImageView jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView;
  private TextView b;
  
  public AIOGalleryAdapter$GalleryImageStruct(AIOGalleryAdapter paramAIOGalleryAdapter, Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView = new AIOGalleryAdapter.GalleryImageStruct.GalleryUrlImageView(this, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setId(2131361846);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131436120);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(DisplayUtil.b(paramAIOGalleryAdapter.a, 30.4F));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a6a6a6"));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.topMargin = DisplayUtil.b(paramAIOGalleryAdapter.a, -60.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    if (getLayoutParams() == null) {
      setLayoutParams(new Gallery.LayoutParams(-1, -1));
    }
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.getDrawable();
  }
  
  public URLDrawable a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.jdField_a_of_type_ComTencentImageURLDrawable;
  }
  
  public AIORichMediaInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0) && (!paramString.equals("null")))
    {
      TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a);
      localTextView.setText("来自" + paramString);
      localTextView.setClickable(false);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setTextColor(Color.parseColor("#777777"));
      localTextView.setVisibility(0);
      localTextView.setPadding(0, AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a.getResources()), AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a.getResources()), 0);
      this.b = localTextView;
      paramString = new LinearLayout.LayoutParams(-2, -2);
      paramString.gravity = 5;
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = paramString;
      addView(localTextView, 1, paramString);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.b;
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setAdjustViewBounds(paramBoolean);
  }
  
  public void setDecodingDrawble(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setDecodingDrawble(paramURLDrawable);
  }
  
  public void setIgnoreLayout(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.b = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setImageDrawable(paramDrawable);
  }
  
  public void setImageInfo(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = paramAIORichMediaInfo;
  }
  
  public void setOriginalImage(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.b = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.jdField_a_of_type_Int = paramInt;
  }
  
  public void setScaleY(float paramFloat)
  {
    super.setScaleY(paramFloat);
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ProGallery)) && (((ProGallery)localViewParent).c) && (this.b != null) && (this.b.getVisibility() == 0) && (paramFloat != 0.0F))
    {
      paramFloat = 1.0F / paramFloat;
      if (paramFloat >= 1.0F) {
        break label141;
      }
    }
    for (;;)
    {
      this.b.setPivotX(this.b.getWidth());
      this.b.setPivotY(0.0F);
      this.b.setScaleX(paramFloat);
      this.b.setScaleY(paramFloat);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryAdapter", 2, "mSupplyLogo setScale " + this.b.getScaleX());
      }
      return;
      label141:
      localViewParent = getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)getParent()).setClipChildren(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct
 * JD-Core Version:    0.7.0.1
 */