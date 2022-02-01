package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class AddContactTroopClassifyAdapter$SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  private int b;
  
  public AddContactTroopClassifyAdapter$SpacesItemDecoration(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.right = this.a;
    if (paramRecyclerView.getChildPosition(paramView) == 0) {
      paramRect.left = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactTroopClassifyAdapter.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */