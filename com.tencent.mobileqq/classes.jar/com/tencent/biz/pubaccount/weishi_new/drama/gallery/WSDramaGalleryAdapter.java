package com.tencent.biz.pubaccount.weishi_new.drama.gallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaMiddlePart;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsSingleCheckAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSDramaGalleryAdapter
  extends WSAbsSingleCheckAdapter<WSDramaItemData, WSDramaGalleryHolder>
{
  private final String b;
  
  public WSDramaGalleryAdapter(WSDramaMiddlePart paramWSDramaMiddlePart, RecyclerView paramRecyclerView)
  {
    super(paramWSDramaMiddlePart.o(), paramRecyclerView);
    this.b = paramWSDramaMiddlePart.k();
  }
  
  public WSDramaGalleryHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WSDramaGalleryHolder(paramViewGroup, this.b, this);
  }
  
  public void a(WSDramaGalleryHolder paramWSDramaGalleryHolder, int paramInt)
  {
    paramWSDramaGalleryHolder.a((WSDramaItemData)getDataList().get(paramInt));
  }
  
  public void a(BaseViewHolder<WSDramaItemData> paramBaseViewHolder)
  {
    super.onViewAttachedToWindow(paramBaseViewHolder);
    paramBaseViewHolder.itemView.post(new WSDramaGalleryAdapter.1(this, paramBaseViewHolder));
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */