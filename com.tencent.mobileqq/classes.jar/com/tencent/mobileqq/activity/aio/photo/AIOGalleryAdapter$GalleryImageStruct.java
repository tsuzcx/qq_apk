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
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setId(2131368461);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (paramInt == 0) {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    } else if (paramInt == 1) {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    } else {
      localLayoutParams = null;
    }
    if (localLayoutParams != null) {
      localLayoutParams.addRule(13, -1);
    }
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter$GalleryImageStruct$GalleryUrlImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131373042);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838000);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694997);
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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).a;
    }
    if ((localObject1 != null) && (((AIOShortVideoData)localObject1).a(0) != null) && (AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter) == paramInt) && (AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter) != null))
    {
      setImageDrawable(AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter));
      int i = AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter).getPlayState();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("resume video mVideoDrawable1 getPlayState =");
        ((StringBuilder)localObject1).append(i);
        QLog.i(" AIOGalleryAdapter", 2, ((StringBuilder)localObject1).toString());
      }
      if ((i != 4) && (i != 0))
      {
        if (i == 6) {
          AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter).replay();
        }
      }
      else {
        AIOGalleryAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter).resumeVideo();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getView(): load thumb and mVideoDrawable1 exist, position is ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.i(" AIOGalleryAdapter", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (localObject1 != null)
      {
        localObject2 = ((AIOShortVideoData)localObject1).a(1);
        if (localObject2 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("resume,  mIsmute =  ");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_Boolean);
            QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
          AIOGalleryAdapter.a((AIOGalleryAdapter)localObject3, paramInt, this, (AIOShortVideoData)localObject1, (File)localObject2, ((AIOGalleryAdapter)localObject3).jdField_a_of_type_Boolean);
          if (!QLog.isColorLevel()) {
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("resume setShortVideoDrawable video exist, position is ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.i(" AIOGalleryAdapter", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      if ((localObject1 != null) && ((((AIOShortVideoData)localObject1).jdField_a_of_type_Boolean) || (((AIOShortVideoData)localObject1).b)))
      {
        setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt, false);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "getView(): MEDIA_FILE_ERROR");
        }
      }
      else
      {
        setImageDrawable(URLDrawableHelperConstants.a);
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOShortVideoData)localObject1).jdField_f_of_type_Long, ((AIOShortVideoData)localObject1).jdField_f_of_type_Int, 1);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getView(): video and thumb not exist, download video, position is ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.i(" AIOGalleryAdapter", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0) && (!paramString.equals("null")))
    {
      TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131700278));
      localStringBuilder.append(paramString);
      localTextView.setText(localStringBuilder.toString());
      localTextView.setClickable(false);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setTextColor(Color.parseColor("#777777"));
      localTextView.setVisibility(0);
      localTextView.setPadding(0, AIOUtils.b(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources()), AIOUtils.b(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.getResources()), 0);
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
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      localObject = new Rect();
      this.jdField_a_of_type_AndroidWidgetImageView.getGlobalVisibleRect((Rect)localObject);
      if (((Rect)localObject).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void b(int paramInt)
  {
    URLDrawable localURLDrawable;
    if ((a() instanceof URLDrawable)) {
      localURLDrawable = (URLDrawable)a();
    } else {
      localURLDrawable = null;
    }
    int i;
    if (localURLDrawable != null) {
      i = localURLDrawable.getPlayState();
    } else {
      i = -1;
    }
    if ((i != -1) && (i != 4) && (i != 6) && (i != 0) && (i != 1))
    {
      a();
      return;
    }
    a(paramInt);
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
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof ProGallery)) && (((ProGallery)localObject).mIsLayoutScale))
    {
      localObject = this.b;
      if ((localObject != null) && (((TextView)localObject).getVisibility() == 0) && (paramFloat != 0.0F))
      {
        paramFloat = 1.0F / paramFloat;
        if (paramFloat >= 1.0F)
        {
          localObject = getParent();
          if ((localObject != null) && ((localObject instanceof ViewGroup))) {
            ((ViewGroup)getParent()).setClipChildren(false);
          }
        }
        localObject = this.b;
        ((TextView)localObject).setPivotX(((TextView)localObject).getWidth());
        this.b.setPivotY(0.0F);
        this.b.setScaleX(paramFloat);
        this.b.setScaleY(paramFloat);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mSupplyLogo setScale ");
          ((StringBuilder)localObject).append(this.b.getScaleX());
          QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct
 * JD-Core Version:    0.7.0.1
 */