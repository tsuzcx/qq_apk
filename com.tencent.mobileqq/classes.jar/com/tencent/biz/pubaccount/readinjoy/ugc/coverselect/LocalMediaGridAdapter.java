package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.pull2refresh.BaseAdapter;

public class LocalMediaGridAdapter
  extends BaseAdapter<AlbumUtils.LocalMediaInfo, LocalMediaGridAdapter.ImageHolder>
{
  private int jdField_a_of_type_Int = -1;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131167332));
  private LocalMediaGridAdapter.OnItemListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter$OnItemListener;
  
  public LocalMediaGridAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    AlbumUtils.LocalMediaInfo localLocalMediaInfo = (AlbumUtils.LocalMediaInfo)a(paramInt);
    if ((localLocalMediaInfo != null) && (localLocalMediaInfo.b)) {
      return 1;
    }
    return 0;
  }
  
  public LocalMediaGridAdapter.ImageHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new LocalMediaGridAdapter.ImageHolder(this, paramViewGroup, 2131560113);
    }
    return new LocalMediaGridAdapter.VideoHolder(this, paramViewGroup, 2131560114);
  }
  
  public void a(int paramInt)
  {
    AlbumUtils.LocalMediaInfo localLocalMediaInfo = (AlbumUtils.LocalMediaInfo)a(paramInt);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter$OnItemListener == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter$OnItemListener.a(paramInt, localLocalMediaInfo))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Int != paramInt) && (i != 0))
      {
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = paramInt;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter$OnItemListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter$OnItemListener.a((AlbumUtils.LocalMediaInfo)a(this.jdField_a_of_type_Int));
        }
        notifyItemChanged(i);
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public void a(LocalMediaGridAdapter.ImageHolder paramImageHolder, int paramInt)
  {
    paramImageHolder.a(paramInt, (AlbumUtils.LocalMediaInfo)a(paramInt));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter$OnItemListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter$OnItemListener.a(paramInt);
    }
  }
  
  public void a(LocalMediaGridAdapter.OnItemListener paramOnItemListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter$OnItemListener = paramOnItemListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.LocalMediaGridAdapter
 * JD-Core Version:    0.7.0.1
 */