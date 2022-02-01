package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QavDoubleVideoSharpnessMangaer$5
  implements View.OnClickListener
{
  QavDoubleVideoSharpnessMangaer$5(QavDoubleVideoSharpnessMangaer paramQavDoubleVideoSharpnessMangaer) {}
  
  public void onClick(View paramView)
  {
    if (!QavDoubleVideoSharpnessMangaer.h(this.a))
    {
      this.a.c();
      QavDoubleVideoSharpnessMangaer.d(this.a).L.g(0L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.5
 * JD-Core Version:    0.7.0.1
 */