package com.tencent.mobileqq.activity.qwallet.emoj;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import vzo;

public class EmojiFragment$TempGridItemLayoutDecoration
  extends RecyclerView.ItemDecoration
{
  public Context mContext;
  public int mNumColumns;
  
  public EmojiFragment$TempGridItemLayoutDecoration(EmojiFragment paramEmojiFragment, Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mNumColumns = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = 0;
    paramView.measure(0, 0);
    int j = (paramRecyclerView.getMeasuredWidth() - paramView.getMeasuredWidth() * this.mNumColumns) / (this.mNumColumns + 1);
    if (QLog.isColorLevel()) {
      QLog.i("EmojiFragment", 2, "getItemOffsets getMeasuredWidth: " + paramView.getMeasuredWidth());
    }
    int k = paramRecyclerView.getChildAdapterPosition(paramView);
    int m = this.mNumColumns;
    int n = ((this.mNumColumns - 1) * j + j + j) / this.mNumColumns;
    if (k % this.mNumColumns == 0)
    {
      paramRect.left = j;
      this.this$0.availableRight = (n - j);
      paramRect.right = this.this$0.availableRight;
    }
    for (;;)
    {
      if (paramRecyclerView.getChildAdapterPosition(paramView) < this.mNumColumns) {
        i = 1;
      }
      if (i == 0) {
        paramRect.top = vzo.a(this.mContext, 11.0F);
      }
      return;
      if (k % this.mNumColumns == m - 1)
      {
        paramRect.right = j;
        paramRect.left = (n - j);
      }
      else
      {
        paramRect.left = (j - this.this$0.availableRight);
        this.this$0.availableRight = (n - (j - this.this$0.availableRight));
        paramRect.right = this.this$0.availableRight;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment.TempGridItemLayoutDecoration
 * JD-Core Version:    0.7.0.1
 */