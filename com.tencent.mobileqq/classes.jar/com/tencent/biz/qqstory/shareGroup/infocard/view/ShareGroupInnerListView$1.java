package com.tencent.biz.qqstory.shareGroup.infocard.view;

import android.text.TextUtils;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;

class ShareGroupInnerListView$1
  implements LoadingMoreHelper.OnLoadMoreListener
{
  ShareGroupInnerListView$1(ShareGroupInnerListView paramShareGroupInnerListView) {}
  
  public boolean a(boolean paramBoolean)
  {
    if (this.a.d != null) {
      return this.a.d.b(this.a.a);
    }
    return false;
  }
  
  public void bx_()
  {
    if ((this.a.d != null) && (!TextUtils.isEmpty(this.a.a))) {
      this.a.d.b(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView.1
 * JD-Core Version:    0.7.0.1
 */