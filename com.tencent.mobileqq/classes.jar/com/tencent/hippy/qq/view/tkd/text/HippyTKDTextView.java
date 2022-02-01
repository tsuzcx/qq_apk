package com.tencent.hippy.qq.view.tkd.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ImageSpan;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler.HippyQBCommonSkin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.views.text.HippyTextView;

public class HippyTKDTextView
  extends HippyTextView
  implements HippyTKDCommonBorderHandler.HippyQBCommonBorder, HippyTKDSkinHandler.HippyQBCommonSkin
{
  HippyArray mColors;
  String mContentDescription;
  boolean mEmojiEnable;
  HippyTKDSkinHandler mHippyTKDSkinHandler = new HippyTKDSkinHandler();
  Typeface mSpecTypeface;
  
  public HippyTKDTextView(Context paramContext)
  {
    super(paramContext);
    setFocusable(true);
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public String getContentDescription()
  {
    if (this.mContentDescription == null)
    {
      if ((this.mLayout != null) && (this.mLayout.getText() != null)) {
        return this.mLayout.getText().toString();
      }
      return null;
    }
    return this.mContentDescription;
  }
  
  public void hippySwitchSkin()
  {
    if (this.mColors != null) {
      setColors(this.mColors);
    }
    if ((this.mEmojiEnable) && (this.mLayout != null))
    {
      Object localObject = (Spanned)this.mLayout.getText();
      localObject = (ImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ImageSpan.class);
      int k = localObject.length;
      int i = 0;
      if (i < k)
      {
        Drawable localDrawable = localObject[i].getDrawable();
        if (!ThemeUtil.isNowThemeIsNight(null, false, "")) {}
        for (int j = 255;; j = 100)
        {
          localDrawable.setAlpha(j);
          i += 1;
          break;
        }
      }
    }
    this.mHippyTKDSkinHandler.switchSkin(this);
  }
  
  public void resetProps()
  {
    super.resetProps();
    this.mColors = null;
    this.mHippyTKDSkinHandler = new HippyTKDSkinHandler();
    this.mEmojiEnable = false;
    this.mContentDescription = null;
  }
  
  public void setBackgroundColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBackgroundColors(this, paramHippyArray);
  }
  
  public void setBorderBottomColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderBottomColors(this, paramHippyArray);
  }
  
  public void setBorderColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderColors(this, paramHippyArray);
  }
  
  public void setBorderLeftColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderLeftColors(this, paramHippyArray);
  }
  
  public void setBorderRightColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderRightColors(this, paramHippyArray);
  }
  
  public void setBorderTopColors(HippyArray paramHippyArray)
  {
    this.mHippyTKDSkinHandler.setBorderTopColors(this, paramHippyArray);
  }
  
  public void setColors(HippyArray paramHippyArray)
  {
    this.mColors = paramHippyArray;
    super.setTextColor(HippyTKDSkinHandler.getColor(paramHippyArray));
    postInvalidate();
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.mContentDescription = ((String)paramCharSequence);
    super.setContentDescription(paramCharSequence);
  }
  
  public void setEmojiEnable(boolean paramBoolean)
  {
    this.mEmojiEnable = paramBoolean;
  }
  
  public void setLayout(Layout paramLayout)
  {
    super.setLayout(paramLayout);
    if (this.mColors != null) {
      setColors(this.mColors);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.text.HippyTKDTextView
 * JD-Core Version:    0.7.0.1
 */