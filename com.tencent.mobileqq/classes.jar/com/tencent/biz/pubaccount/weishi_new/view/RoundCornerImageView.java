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
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.net.URL;

public class RoundCornerImageView
  extends KandianUrlImageView
{
  private int jdField_a_of_type_Int = 0;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString;
  private int b = 0;
  
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ImageRequest localImageRequest = this.mController.a();
    if (((localImageRequest == null) || (localImageRequest.a)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      setImageSrc(WeishiUtils.a(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      int j = getWidth() - getPaddingLeft() - getPaddingRight();
      int i = getHeight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      this.jdField_a_of_type_AndroidGraphicsRectF.left = getPaddingLeft();
      this.jdField_a_of_type_AndroidGraphicsRectF.top = getPaddingTop();
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (getPaddingLeft() + j);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (getPaddingTop() + (i - k - m));
      i = this.jdField_a_of_type_Int;
      if (i <= 0) {
        i = j / 30;
      }
      j = this.b;
      Path localPath;
      RectF localRectF;
      float f;
      if (j == 0)
      {
        localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        f = i;
        localPath.addRoundRect(localRectF, f, f, Path.Direction.CCW);
      }
      else if (j == 1)
      {
        f = i;
        localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        Path.Direction localDirection = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      }
      this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
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
    ImageRequest localImageRequest = this.mController.a();
    if (((localImageRequest == null) || (localImageRequest.a)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      setImageSrc(WeishiUtils.a(this.jdField_a_of_type_JavaLangString));
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
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    int i = this.mController.a().d;
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
      setImageResource(2131165740);
      return;
    }
    String str1 = paramURL.toString();
    String str2 = this.jdField_a_of_type_JavaLangString;
    if ((str2 != null) && (str2.equalsIgnoreCase(str1)))
    {
      WSLog.f("RoundCornerImageView", "[RoundCornerImageView.java][setImageSrc], current path unchanged ");
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = str1;
      WSLog.f("RoundCornerImageView", "[RoundCornerImageView.java][setImageSrc], current path changed ");
    }
    setImage(paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */