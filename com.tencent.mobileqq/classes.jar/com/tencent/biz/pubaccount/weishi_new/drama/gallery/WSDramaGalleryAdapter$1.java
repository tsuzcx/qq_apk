package com.tencent.biz.pubaccount.weishi_new.drama.gallery;

import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSCenterLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.widget.pull2refresh.BaseViewHolder;

class WSDramaGalleryAdapter$1
  implements Runnable
{
  WSDramaGalleryAdapter$1(WSDramaGalleryAdapter paramWSDramaGalleryAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public void run()
  {
    int i = this.this$0.a().findLastVisibleItemPosition();
    int j = this.a.getAdapterPosition();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSDramaGalleryAdapter.java][onViewAttachedToWindow] currPosition:");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(", lastVisibleItemPosition:");
    ((StringBuilder)localObject).append(i);
    WSLog.a("WSAbsSingleCheckAdapter-nel-log", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (((localObject instanceof WSDramaGalleryHolder)) && (j <= i))
    {
      localObject = (WSDramaGalleryHolder)localObject;
      ((WSDramaGalleryHolder)localObject).a((WSDramaGalleryHolder)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryAdapter.1
 * JD-Core Version:    0.7.0.1
 */