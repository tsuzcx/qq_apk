package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;

final class RichTextUtils$1
  implements ViewTreeObserver.OnPreDrawListener
{
  RichTextUtils$1(TextView paramTextView, TruncateAttr paramTruncateAttr) {}
  
  public boolean onPreDraw()
  {
    this.val$tv.getViewTreeObserver().removeOnPreDrawListener(this);
    RichTextUtils.addEllipsis2Text(this.val$tv, this.val$truncateAttr);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils.1
 * JD-Core Version:    0.7.0.1
 */