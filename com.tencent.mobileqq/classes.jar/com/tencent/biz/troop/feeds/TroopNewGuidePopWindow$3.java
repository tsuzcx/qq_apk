package com.tencent.biz.troop.feeds;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.utils.DisplayUtils;

class TroopNewGuidePopWindow$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TroopNewGuidePopWindow$3(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.l.getMeasuredWidth();
    i = (int)(this.a.n.getMeasuredWidth() - i - DisplayUtils.a(this.a.a, 5.0F));
    this.a.k.setMaxWidth(i);
    this.a.k.setText(new ColorNickText(this.a.B.i, 16).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.3
 * JD-Core Version:    0.7.0.1
 */