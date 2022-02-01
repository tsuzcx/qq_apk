package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbstractPhotoListActivity$OnItemClickListener
  implements View.OnClickListener
{
  public int position;
  
  AbstractPhotoListActivity$OnItemClickListener(AbstractPhotoListActivity paramAbstractPhotoListActivity) {}
  
  public void onClick(View paramView)
  {
    int i = this.this$0.photoListAdapter.getItemViewType(this.position);
    if (this.this$0.mPhotoListLogic != null) {
      switch (i)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.mPhotoListData.isSingleMode)
      {
        this.this$0.mPhotoListLogic.caseSingleModeImage(paramView, this.position);
      }
      else
      {
        Intent localIntent = this.this$0.mPhotoListLogic.caseNoSingModeImage(paramView, this.position);
        this.this$0.mPhotoListLogic.startPhotoPreviewActivity(localIntent);
        QAlbumUtil.anim(this.this$0, true, true);
        continue;
        this.this$0.mPhotoListLogic.caseVideo(paramView, this.position);
        continue;
        this.this$0.mPhotoListLogic.caseCamera(paramView, this.position);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.OnItemClickListener
 * JD-Core Version:    0.7.0.1
 */