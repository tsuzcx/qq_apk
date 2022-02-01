package com.tencent.mobileqq.adapter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;

class RecommendFriendAdapter$1
  implements IIconListener
{
  RecommendFriendAdapter$1(RecommendFriendAdapter paramRecommendFriendAdapter) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == 200) && (paramBitmap != null)) {
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RecommendFriendAdapter.1
 * JD-Core Version:    0.7.0.1
 */