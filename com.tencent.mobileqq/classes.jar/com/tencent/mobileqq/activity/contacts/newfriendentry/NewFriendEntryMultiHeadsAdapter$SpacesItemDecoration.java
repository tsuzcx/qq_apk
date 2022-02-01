package com.tencent.mobileqq.activity.contacts.newfriendentry;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class NewFriendEntryMultiHeadsAdapter$SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public NewFriendEntryMultiHeadsAdapter$SpacesItemDecoration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.right = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.newfriendentry.NewFriendEntryMultiHeadsAdapter.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */