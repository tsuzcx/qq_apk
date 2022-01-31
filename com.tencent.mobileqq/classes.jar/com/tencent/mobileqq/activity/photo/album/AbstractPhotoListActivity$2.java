package com.tencent.mobileqq.activity.photo.album;

import aiqy;
import android.view.View;
import bhuw;
import com.tencent.widget.AdapterView;

class AbstractPhotoListActivity$2
  implements bhuw
{
  AbstractPhotoListActivity$2(AbstractPhotoListActivity paramAbstractPhotoListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    aiqy localaiqy = this.this$0.mPhotoListLogic.mPhotoCommonData;
    int i = this.this$0.photoListAdapter.getItemViewType(paramInt);
    if (this.this$0.mPhotoListLogic != null) {}
    switch (i)
    {
    default: 
      return;
    case 0: 
      if (this.this$0.mPhotoListData.isSingleMode)
      {
        this.this$0.mPhotoListLogic.caseSingleModeImage(paramAdapterView, paramView, paramInt, paramLong);
        return;
      }
      paramAdapterView = this.this$0.mPhotoListLogic.caseNoSingModeImage(paramAdapterView, paramView, paramInt, paramLong);
      this.this$0.mPhotoListLogic.startPhotoPreviewActivity(paramAdapterView);
      QAlbumUtil.anim(this.this$0, true, true);
      return;
    case 1: 
      this.this$0.mPhotoListLogic.caseVideo(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.this$0.mPhotoListLogic.caseCamera(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.2
 * JD-Core Version:    0.7.0.1
 */