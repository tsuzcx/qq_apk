package com.tencent.comic.ui;

import android.widget.LinearLayout;

class ComicCancelRedPointPopDialog$1
  implements ComicHorizontalCenterScrollView.OnCustomScrollListener
{
  ComicCancelRedPointPopDialog$1(ComicCancelRedPointPopDialog paramComicCancelRedPointPopDialog) {}
  
  public void a(int paramInt)
  {
    if ((ComicCancelRedPointPopDialog.a(this.a) != null) && (ComicCancelRedPointPopDialog.a(this.a).getVisibility() == 8)) {
      ComicCancelRedPointPopDialog.a(this.a).setVisibility(0);
    }
    ComicCancelRedPointPopDialog localComicCancelRedPointPopDialog = this.a;
    ComicCancelRedPointPopDialog.b(localComicCancelRedPointPopDialog, ComicCancelRedPointPopDialog.a(localComicCancelRedPointPopDialog, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.ComicCancelRedPointPopDialog.1
 * JD-Core Version:    0.7.0.1
 */