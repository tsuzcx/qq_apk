package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.weishi_new.image.WSImageDownListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.net.URL;

public class RoundCornerImageView
  extends KandianUrlImageView
{
  private int a = 0;
  private Path b = new Path();
  private RectF c = new RectF();
  private int d = 0;
  private String e;
  
  public RoundCornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if ((getUrl() != null) && (this.mController != null) && ((this.mController.c() instanceof WSImageDownListener))) {
      ((WSImageDownListener)this.mController.c()).a();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ImageRequest localImageRequest = this.mController.b();
    if (((localImageRequest == null) || (localImageRequest.d)) && (!TextUtils.isEmpty(this.e))) {
      setImageSrc(WeishiUtils.c(this.e));
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a > 0)
    {
      this.b.reset();
      int j = getWidth() - getPaddingLeft() - getPaddingRight();
      int i = getHeight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      this.c.left = getPaddingLeft();
      this.c.top = getPaddingTop();
      this.c.right = (getPaddingLeft() + j);
      this.c.bottom = (getPaddingTop() + (i - k - m));
      i = this.a;
      if (i <= 0) {
        i = j / 30;
      }
      j = this.d;
      if (j != -1)
      {
        float f;
        Path localPath;
        RectF localRectF;
        if (j != 0)
        {
          Path.Direction localDirection;
          if (j != 1)
          {
            if (j != 2)
            {
              if (j == 3)
              {
                f = i;
                localPath = this.b;
                localRectF = this.c;
                localDirection = Path.Direction.CCW;
                localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, f, f, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
              }
            }
            else
            {
              f = i;
              localPath = this.b;
              localRectF = this.c;
              localDirection = Path.Direction.CCW;
              localPath.addRoundRect(localRectF, new float[] { f, f, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
            }
          }
          else
          {
            f = i;
            localPath = this.b;
            localRectF = this.c;
            localDirection = Path.Direction.CCW;
            localPath.addRoundRect(localRectF, new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
          }
        }
        else
        {
          localPath = this.b;
          localRectF = this.c;
          f = i;
          localPath.addRoundRect(localRectF, f, f, Path.Direction.CCW);
        }
      }
      else
      {
        this.b.addRoundRect(this.c, 0.0F, 0.0F, Path.Direction.CCW);
      }
      this.b.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.b);
    }
    a();
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      WSLog.d("RoundCornerImageView", paramCanvas.getMessage());
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    ImageRequest localImageRequest = this.mController.b();
    if (((localImageRequest == null) || (localImageRequest.d)) && (!TextUtils.isEmpty(this.e))) {
      setImageSrc(WeishiUtils.c(this.e));
    }
  }
  
  public void setCorner(int paramInt)
  {
    setCorner(paramInt, 0);
  }
  
  public void setCorner(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return;
    }
    this.d = paramInt2;
    this.a = paramInt1;
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    int i = this.mController.b().p;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cacheType=");
    localStringBuilder.append(i);
    WSLog.b("RoundCornerImageView", localStringBuilder.toString());
    if ((i != 0) && (i != 3))
    {
      setImageDrawable(paramDrawable);
      return;
    }
    super.setImageDrawable(paramDrawable, paramBoolean);
  }
  
  public void setImageSrc(URL paramURL)
  {
    if (paramURL == null)
    {
      setImageResource(2131166336);
      return;
    }
    String str1 = paramURL.toString();
    String str2 = this.e;
    if ((str2 != null) && (str2.equalsIgnoreCase(str1)))
    {
      WSLog.f("RoundCornerImageView", "[RoundCornerImageView.java][setImageSrc], current path unchanged ");
    }
    else
    {
      this.e = str1;
      WSLog.f("RoundCornerImageView", "[RoundCornerImageView.java][setImageSrc], current path changed ");
    }
    setImage(paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */