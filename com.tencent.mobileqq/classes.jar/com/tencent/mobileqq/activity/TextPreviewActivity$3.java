package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.business.sougou.HightlightHotWordText;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.ContainerView;

class TextPreviewActivity$3
  implements WordMatchManager.MatchCallback
{
  TextPreviewActivity$3(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    HightlightHotWordText.a(this.a.app, this.a.h, paramArrayOfHotWordItem);
    paramArrayOfHotWordItem = ColorNickManager.a(this.a.h, this.a.i, 30, this.a.aa, 13);
    if (this.a.o.a(this.a))
    {
      this.a.ad = paramArrayOfHotWordItem;
      return;
    }
    TextPreviewActivity localTextPreviewActivity = this.a;
    localTextPreviewActivity.ad = null;
    localTextPreviewActivity.o.setText(paramArrayOfHotWordItem);
    this.a.ac = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */