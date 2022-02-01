package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.LocalMediaGridAdapter;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.UniversalItemDecoration;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.UniversalItemDecoration.Decoration;
import com.tencent.mobileqq.util.DisplayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class SelectVideoFragment$2
  extends UniversalItemDecoration
{
  SelectVideoFragment$2(SelectVideoFragment paramSelectVideoFragment) {}
  
  @Nullable
  public UniversalItemDecoration.Decoration a(int paramInt, @NotNull RecyclerView paramRecyclerView)
  {
    return a(paramInt, SelectVideoFragment.a(this.a).getItemCount(), 3, DisplayUtil.a(SelectVideoFragment.a(this.a), 8.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment.2
 * JD-Core Version:    0.7.0.1
 */