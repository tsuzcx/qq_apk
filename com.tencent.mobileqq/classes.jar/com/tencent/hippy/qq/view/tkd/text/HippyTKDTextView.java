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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    String str2 = this.mContentDescription;
    String str1 = str2;
    if (str2 == null)
    {
      if ((this.mLayout != null) && (this.mLayout.getText() != null)) {
        return this.mLayout.getText().toString();
      }
      str1 = null;
    }
    return str1;
  }
  
  public void hippySwitchSkin()
  {
    Object localObject = this.mColors;
    if (localObject != null) {
      setColors((HippyArray)localObject);
    }
    if ((this.mEmojiEnable) && (this.mLayout != null))
    {
      localObject = (Spanned)this.mLayout.getText();
      localObject = (ImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ImageSpan.class);
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        Drawable localDrawable = localObject[i].getDrawable();
        int j;
        if (!ThemeUtil.isNowThemeIsNight(null, false, "")) {
          j = 255;
        } else {
          j = 100;
        }
        localDrawable.setAlpha(j);
        i += 1;
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
    paramLayout = this.mColors;
    if (paramLayout != null) {
      setColors(paramLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.text.HippyTKDTextView
 * JD-Core Version:    0.7.0.1
 */