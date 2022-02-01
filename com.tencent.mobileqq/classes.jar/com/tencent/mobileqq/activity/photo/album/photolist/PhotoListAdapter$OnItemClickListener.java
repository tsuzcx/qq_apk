package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoListAdapter$OnItemClickListener
  implements View.OnClickListener
{
  public int a;
  
  PhotoListAdapter$OnItemClickListener(PhotoListAdapter paramPhotoListAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = this.b.getItemViewType(this.a);
    if (this.b.g != null) {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.b.g.d(paramView, this.a);
          }
        }
        else {
          this.b.g.c(paramView, this.a);
        }
      }
      else if (this.b.c().isSingleMode)
      {
        this.b.g.a(paramView, this.a);
      }
      else
      {
        Intent localIntent = this.b.g.b(paramView, this.a);
        this.b.g.b(localIntent);
        QAlbumUtil.anim(this.b.f, true, true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter.OnItemClickListener
 * JD-Core Version:    0.7.0.1
 */