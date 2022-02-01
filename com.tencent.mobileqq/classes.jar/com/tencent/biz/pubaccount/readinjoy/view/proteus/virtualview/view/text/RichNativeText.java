package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.text.SpannableStringBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import org.json.JSONArray;

public class RichNativeText
  extends NativeText
{
  private static final String TAG = "RichNativeText";
  private Object richData;
  
  public RichNativeText(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mTextSize = Utils.dp2px(16.0D);
  }
  
  private void setRichText()
  {
    if ((this.richData instanceof JSONArray))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      RichTextParser.parse(this.mNative, localSpannableStringBuilder, this.richData);
      setRealText(localSpannableStringBuilder);
      this.mNative.setTruncateAttr(RichTextParser.getTruncate());
    }
  }
  
  public boolean onClick()
  {
    if (this.mNative.isHyperLinkClick())
    {
      this.mNative.setHyperLinkClick(false);
      return true;
    }
    return super.onClick();
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    setRichText();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt == 66)
    {
      if ((paramObject instanceof JSONArray)) {
        this.richData = paramObject;
      }
      return true;
    }
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText
 * JD-Core Version:    0.7.0.1
 */