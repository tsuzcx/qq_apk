package com.tencent.biz.subscribe.comment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoView$3
  implements AdapterView.OnItemClickListener
{
  EmoView$3(EmoView paramEmoView, int paramInt) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 27)
    {
      if (EmoView.c(this.b) != null) {
        bool1 = EmoView.c(this.b).a();
      }
      if (!bool1) {
        EmoView.d(this.b).a();
      }
    }
    else
    {
      int i = (this.a - 1) * 27 + paramInt;
      if (i < 107)
      {
        String str = Patterns.e[EmoWindowAdapter.c[i]];
        bool1 = bool2;
        if (EmoView.c(this.b) != null) {
          bool1 = EmoView.c(this.b).a(str);
        }
        if (!bool1) {
          EmoView.d(this.b).a(str);
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoView.3
 * JD-Core Version:    0.7.0.1
 */