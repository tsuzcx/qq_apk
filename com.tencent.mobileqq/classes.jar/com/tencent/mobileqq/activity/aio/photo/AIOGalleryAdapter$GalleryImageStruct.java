package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;

public class AIOGalleryAdapter$GalleryImageStruct
  extends RelativeLayout
{
  public ImageView a;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AIOGalleryAdapter.GalleryImageStruct.GalleryUrlImageView a;
  private TextView b;
  
  public AIOGalleryAdapter$GalleryImageStruct(AIOGalleryAdapter paramAIOGalleryAdapter, Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView = new AIOGalleryAdapter.GalleryImageStruct.GalleryUrlImageView(this, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setId(2131368729);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    RelativeLayout.LayoutParams localLayoutParams = null;
    if (paramInt == 0) {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
    for (;;)
    {
      if (localLayoutParams != null) {
        localLayoutParams.addRule(13, -1);
      }
      addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131373467);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838159);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13, -1);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695007);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(DisplayUtil.b(paramAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 30.4F));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a6a6a6"));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(12);
      paramContext.addRule(14, -1);
      paramContext.bottomMargin = DisplayUtil.b(paramAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity, 40.0F);
      addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      if (paramInt == 1) {
        setTag(2131296433, Boolean.valueOf(true));
      }
      if (getLayoutParams() == null) {
        setLayoutParams(new Gallery.LayoutParams(-1, -1));
      }
      return;
      if (paramInt == 1) {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      }
    }
  }
  
  public Bitmap a(Rect paramRect, Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.a(paramRect, paramMatrix, paramInt1, paramInt2);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof URLDrawable))) {
      ((URLDrawable)localDrawable).pauseVideo();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "resume");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt);
    AIOShortVideoData localAIOShortVideoData = null;
    if (localObject != null) {
      localAIOShortVideoData = (AIOShortVideoData)((AIORichMediaInfo)localObject).a;
    }
    int i;
    if ((localAIOShortVideoData != null) && (localAIOShortVideoData.a(0) != null) && (AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter) == paramInt) && (AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter) != null))
    {
      setImageDrawable(AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter));
      i = AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter).getPlayState();
      if (QLog.isColorLevel()) {
        QLog.i(" AIOGalleryAdapter", 2, "resume video mVideoDrawable1 getPlayState =" + i);
      }
      if ((i == 4) || (i == 0)) {
        AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter).resumeVideo();
      }
    }
    label185:
    do
    {
      do
      {
        do
        {
          break label185;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(" AIOGalleryAdapter", 2, "getView(): load thumb and mVideoDrawable1 exist, position is " + paramInt);
            }
            return;
            if (i == 6) {
              AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter).replay();
            }
          }
          if (localAIOShortVideoData == null) {
            break;
          }
          localObject = localAIOShortVideoData.a(1);
          if (localObject == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(" AIOGalleryAdapter", 2, "resume,  mIsmute =  " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_Boolean);
          }
          AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter, paramInt, this, localAIOShortVideoData, (File)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_Boolean);
        } while (!QLog.isColorLevel());
        QLog.i(" AIOGalleryAdapter", 2, "resume setShortVideoDrawable video exist, position is " + paramInt);
        return;
        if ((localAIOShortVideoData == null) || ((!localAIOShortVideoData.jdField_a_of_type_Boolean) && (!localAIOShortVideoData.b))) {
          break;
        }
        setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt, false);
      } while (!QLog.isColorLevel());
      QLog.i(" AIOGalleryAdapter", 2, "getView(): MEDIA_FILE_ERROR");
      return;
      setImageDrawable(URLDrawableHelper.TRANSPARENT);
      if (localAIOShortVideoData != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOShortVideoData.jdField_f_of_type_Long, localAIOShortVideoData.jdField_f_of_type_Int, 1);
      }
    } while (!QLog.isColorLevel());
    QLog.i(" AIOGalleryAdapter", 2, "getView(): video and thumb not exist, download video, position is " + paramInt);
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0) && (!paramString.equals("null")))
    {
      TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity);
      localTextView.setText(HardCodeUtil.a(2131700137) + paramString);
      localTextView.setClickable(false);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setTextColor(Color.parseColor("#777777"));
      localTextView.setVisibility(0);
      localTextView.setPadding(0, AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources()), AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources()), 0);
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
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        Rect localRect = new Rect();
        this.jdField_a_of_type_AndroidWidgetImageView.getGlobalVisibleRect(localRect);
        bool1 = bool2;
        if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void b(int paramInt)
  {
    Drawable localDrawable = a();
    URLDrawable localURLDrawable = null;
    if ((localDrawable instanceof URLDrawable)) {
      localURLDrawable = (URLDrawable)a();
    }
    if (localURLDrawable != null) {}
    for (int i = localURLDrawable.getPlayState();; i = -1)
    {
      if ((i == -1) || (i == 4) || (i == 6) || (i == 0) || (i == 1))
      {
        a(paramInt);
        return;
      }
      a();
      return;
    }
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setAdjustViewBounds(paramBoolean);
  }
  
  public void setCenterBtnVisiable(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
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
    if ((localViewParent != null) && ((localViewParent instanceof ProGallery)) && (((ProGallery)localViewParent).e) && (this.b != null) && (this.b.getVisibility() == 0) && (paramFloat != 0.0F))
    {
      paramFloat = 1.0F / paramFloat;
      if (paramFloat >= 1.0F) {
        break label142;
      }
    }
    for (;;)
    {
      this.b.setPivotX(this.b.getWidth());
      this.b.setPivotY(0.0F);
      this.b.setScaleX(paramFloat);
      this.b.setScaleY(paramFloat);
      if (QLog.isColorLevel()) {
        QLog.d(" AIOGalleryAdapter", 2, "mSupplyLogo setScale " + this.b.getScaleX());
      }
      return;
      label142:
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