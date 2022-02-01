package com.tencent.biz;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;

class PoiMapActivity$10
  implements View.OnKeyListener
{
  PoiMapActivity$10(PoiMapActivity paramPoiMapActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      paramView = ((TextView)paramView).getText().toString();
      if (!TextUtils.isEmpty(paramView)) {
        this.a.a(paramView);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.10
 * JD-Core Version:    0.7.0.1
 */