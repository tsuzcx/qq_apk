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
  public AIOGalleryAdapter.GalleryImageStruct.GalleryUrlImageView a;
  public ImageView b;
  private TextView d;
  private TextView e;
  private LinearLayout.LayoutParams f;
  
  public AIOGalleryAdapter$GalleryImageStruct(AIOGalleryAdapter paramAIOGalleryAdapter, Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = new AIOGalleryAdapter.GalleryImageStruct.GalleryUrlImageView(this, paramContext);
    this.a.setId(2131435357);
    this.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
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
    addView(this.a, localLayoutParams);
    this.b = new ImageView(paramContext);
    this.b.setId(2131440624);
    this.b.setImageResource(2130838024);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    addView(this.b, localLayoutParams);
    this.d = new TextView(paramContext);
    this.d.setText(2131892725);
    this.d.setClickable(false);
    this.d.setTextSize(DisplayUtil.b(paramAIOGalleryAdapter.a, 30.4F));
    this.d.setTextColor(Color.parseColor("#a6a6a6"));
    this.d.setVisibility(8);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(12);
    paramContext.addRule(14, -1);
    paramContext.bottomMargin = DisplayUtil.b(paramAIOGalleryAdapter.a, 40.0F);
    addView(this.d, paramContext);
    if (paramInt == 1) {
      setTag(2131296433, Boolean.valueOf(true));
    }
    if (getLayoutParams() == null) {
      setLayoutParams(new Gallery.LayoutParams(-1, -1));
    }
  }
  
  public Bitmap a(Rect paramRect, Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    return this.a.a(paramRect, paramMatrix, paramInt1, paramInt2);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(" AIOGalleryAdapter", 2, "resume");
    }
    this.b.setVisibility(8);
    Object localObject2 = this.c.a(paramInt);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject2).a;
    }
    if ((localObject1 != null) && (((AIOShortVideoData)localObject1).c(0) != null) && (AIOGalleryAdapter.b(this.c) == paramInt) && (AIOGalleryAdapter.c(this.c) != null))
    {
      setImageDrawable(AIOGalleryAdapter.c(this.c));
      int i = AIOGalleryAdapter.c(this.c).getPlayState();
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
          AIOGalleryAdapter.c(this.c).replay();
        }
      }
      else {
        AIOGalleryAdapter.c(this.c).resumeVideo();
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
        localObject2 = ((AIOShortVideoData)localObject1).c(1);
        if (localObject2 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("resume,  mIsmute =  ");
            ((StringBuilder)localObject3).append(this.c.e);
            QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = this.c;
          AIOGalleryAdapter.a((AIOGalleryAdapter)localObject3, paramInt, this, (AIOShortVideoData)localObject1, (File)localObject2, ((AIOGalleryAdapter)localObject3).e);
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
      if ((localObject1 != null) && ((((AIOShortVideoData)localObject1).e) || (((AIOShortVideoData)localObject1).f)))
      {
        setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066));
        this.c.a(paramInt, false);
        if (QLog.isColorLevel()) {
          QLog.i(" AIOGalleryAdapter", 2, "getView(): MEDIA_FILE_ERROR");
        }
      }
      else
      {
        setImageDrawable(URLDrawableHelperConstants.a);
        if (localObject1 != null) {
          this.c.b.a(((AIOShortVideoData)localObject1).L, ((AIOShortVideoData)localObject1).M, 1);
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
      TextView localTextView = new TextView(this.c.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131898318));
      localStringBuilder.append(paramString);
      localTextView.setText(localStringBuilder.toString());
      localTextView.setClickable(false);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setTextColor(Color.parseColor("#777777"));
      localTextView.setVisibility(0);
      localTextView.setPadding(0, AIOUtils.b(10.0F, this.c.a.getResources()), AIOUtils.b(10.0F, this.c.a.getResources()), 0);
      this.e = localTextView;
      paramString = new LinearLayout.LayoutParams(-2, -2);
      paramString.gravity = 5;
      this.f = paramString;
      addView(localTextView, 1, paramString);
    }
  }
  
  public boolean a()
  {
    return this.a.e;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      localObject = new Rect();
      this.b.getGlobalVisibleRect((Rect)localObject);
      if (((Rect)localObject).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.b.setVisibility(0);
    Drawable localDrawable = this.a.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof URLDrawable))) {
      ((URLDrawable)localDrawable).pauseVideo();
    }
  }
  
  public void b(int paramInt)
  {
    URLDrawable localURLDrawable;
    if ((getDrawable() instanceof URLDrawable)) {
      localURLDrawable = (URLDrawable)getDrawable();
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
      b();
      return;
    }
    a(paramInt);
  }
  
  public void c()
  {
    this.d.setVisibility(0);
  }
  
  public URLDrawable getDecoding()
  {
    return this.a.a;
  }
  
  public Drawable getDrawable()
  {
    return this.a.getDrawable();
  }
  
  public AIORichMediaInfo getImageInfo()
  {
    return this.a.d;
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    this.a.setAdjustViewBounds(paramBoolean);
  }
  
  public void setCenterBtnVisiable(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void setDecodingDrawble(URLDrawable paramURLDrawable)
  {
    this.a.setDecodingDrawble(paramURLDrawable);
  }
  
  public void setIgnoreLayout(boolean paramBoolean)
  {
    this.a.e = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
  
  public void setImageInfo(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.a.d = paramAIORichMediaInfo;
  }
  
  public void setOriginalImage(boolean paramBoolean)
  {
    this.a.e = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.a.c = paramInt;
  }
  
  public void setScaleY(float paramFloat)
  {
    super.setScaleY(paramFloat);
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof ProGallery)) && (((ProGallery)localObject).mIsLayoutScale))
    {
      localObject = this.e;
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
        localObject = this.e;
        ((TextView)localObject).setPivotX(((TextView)localObject).getWidth());
        this.e.setPivotY(0.0F);
        this.e.setScaleX(paramFloat);
        this.e.setScaleY(paramFloat);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mSupplyLogo setScale ");
          ((StringBuilder)localObject).append(this.e.getScaleX());
          QLog.d(" AIOGalleryAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct
 * JD-Core Version:    0.7.0.1
 */