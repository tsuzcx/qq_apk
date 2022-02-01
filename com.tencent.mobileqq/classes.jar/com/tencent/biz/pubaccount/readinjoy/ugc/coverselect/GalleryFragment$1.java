package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.PageLoadManager.QueryProvider;
import java.util.List;

class GalleryFragment$1
  implements PageLoadManager.QueryProvider<AlbumUtils.LocalMediaInfo>
{
  GalleryFragment$1(GalleryFragment paramGalleryFragment) {}
  
  public List<AlbumUtils.LocalMediaInfo> a(int paramInt1, int paramInt2)
  {
    return AlbumUtils.b(paramInt1, paramInt2);
  }
  
  public void a(List<AlbumUtils.LocalMediaInfo> paramList, boolean paramBoolean)
  {
    GalleryFragment.a(this.a).addAll(paramList);
    GalleryFragment.a(this.a).notifyDataSetChanged();
    if (GalleryFragment.a(this.a).isEmpty())
    {
      GalleryFragment.a(this.a).setVisibility(0);
      return;
    }
    GalleryFragment.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.GalleryFragment.1
 * JD-Core Version:    0.7.0.1
 */