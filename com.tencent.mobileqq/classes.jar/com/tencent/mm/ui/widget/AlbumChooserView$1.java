package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AlbumChooserView$1
  implements View.OnClickListener
{
  AlbumChooserView$1(AlbumChooserView paramAlbumChooserView) {}
  
  public void onClick(View paramView)
  {
    if (AlbumChooserView.a(this.a) != null) {
      AlbumChooserView.a(this.a).onAlbumChooserViewClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.AlbumChooserView.1
 * JD-Core Version:    0.7.0.1
 */