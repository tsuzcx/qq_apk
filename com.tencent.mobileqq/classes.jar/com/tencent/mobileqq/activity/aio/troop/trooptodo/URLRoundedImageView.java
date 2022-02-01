package com.tencent.mobileqq.activity.aio.troop.trooptodo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class URLRoundedImageView
  extends URLImageView
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  private Context d;
  
  public URLRoundedImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public URLRoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public URLRoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.URLRoundedImageView, paramInt, 0);
    this.a = paramContext.getDimensionPixelSize(2, 5);
    this.b = paramContext.getDimensionPixelSize(0, 0);
    this.c = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
  }
  
  public void setBackgroundURL(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setBackgroundResource(2130853398);
      QLog.w("URLRoundedImageView-TodoInfo", 4, "troop to do icon url is empty");
      return;
    }
    if (((getBackground() instanceof URLDrawable)) && (((URLDrawable)getBackground()).getURL().toString().equals(paramString))) {
      return;
    }
    Drawable localDrawable1 = ContextCompat.getDrawable(this.d, 2130853395);
    Drawable localDrawable2 = ContextCompat.getDrawable(this.d, 2130853398);
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localDrawable1, localDrawable2);
      paramString.setTag(URLDrawableDecodeHandler.b(this.b, this.c, this.a));
      paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
      setBackgroundDrawable(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      label112:
      break label112;
    }
    QLog.w("URLRoundedImageView-TodoInfo", 4, "troop to do icon url don't have protocol head");
    setBackgroundResource(2130853398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.troop.trooptodo.URLRoundedImageView
 * JD-Core Version:    0.7.0.1
 */