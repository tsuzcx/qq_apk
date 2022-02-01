package com.tencent.mobileqq.activity;

import android.graphics.Paint;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;

class QQMapActivity$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QQMapActivity$1(QQMapActivity paramQQMapActivity) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.mTopLineLay.getWidth();
    if (i > 0)
    {
      int j = DisplayUtil.a(this.a, 10.0F);
      Object localObject = new Paint();
      ((Paint)localObject).setTextSize(DisplayUtil.a(this.a, 14.0F));
      ((Paint)localObject).setAntiAlias(true);
      int k = (int)(((Paint)localObject).measureText(this.a.mDistanceTxt.getText().toString()) + 1.0F);
      ((Paint)localObject).setTextSize(DisplayUtil.a(this.a, 20.0F));
      if (k + j + (int)(((Paint)localObject).measureText(this.a.mAddrTxt.getText().toString()) + 1.0F) > i)
      {
        localObject = this.a.mAddrTxt.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = (i - j - k);
        this.a.mAddrTxt.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.a.mTopLineLay.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.1
 * JD-Core Version:    0.7.0.1
 */