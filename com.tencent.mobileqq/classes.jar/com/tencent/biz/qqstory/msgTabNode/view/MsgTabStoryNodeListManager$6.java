package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.widget.ARMapHongBaoListView;

class MsgTabStoryNodeListManager$6
  extends RecyclerView.OnScrollListener
{
  boolean a = false;
  
  MsgTabStoryNodeListManager$6(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    if (paramInt == 0)
    {
      if ((paramRecyclerView.findLastCompletelyVisibleItemPosition() == paramRecyclerView.getItemCount() - 1) && (this.a)) {
        this.b.k.d();
      }
    }
    else {
      MsgTabStoryNodeListManager.b(this.b);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.a = true;
    } else {
      this.a = false;
    }
    if (this.b.n.isDirty()) {
      this.b.n.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.6
 * JD-Core Version:    0.7.0.1
 */