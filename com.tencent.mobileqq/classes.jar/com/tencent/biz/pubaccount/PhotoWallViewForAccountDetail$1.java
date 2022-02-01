package com.tencent.biz.pubaccount;

import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class PhotoWallViewForAccountDetail$1
  implements AdapterView.OnItemClickListener
{
  PhotoWallViewForAccountDetail$1(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (IPublicAccountConfigAttr.PaConfigInfo)this.a.c.get(paramInt);
    if (this.a.d == null) {
      return;
    }
    this.a.d.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.1
 * JD-Core Version:    0.7.0.1
 */