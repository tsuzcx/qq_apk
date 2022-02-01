package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class RecommendFriendAdapter$4
  extends SwipTextViewMenuBuilder
{
  RecommendFriendAdapter$4(RecommendFriendAdapter paramRecommendFriendAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if (paramArrayOfSwipRightMenuItem != null)
    {
      if (paramArrayOfSwipRightMenuItem.length <= 0) {
        return;
      }
      int i = paramArrayOfSwipRightMenuItem.length;
      paramInt = 0;
      if (i > 0)
      {
        paramArrayOfSwipRightMenuItem[0].menuId = 0;
        paramArrayOfSwipRightMenuItem[0].menuType = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].menuId = -1;
        paramArrayOfSwipRightMenuItem[paramInt].menuType = -1;
        paramInt += 1;
      }
    }
  }
  
  public View updateRightMenuItem(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener)
  {
    paramSwipRightMenuItem = super.updateRightMenuItem(paramInt, paramObject, paramSwipRightMenuItem, paramOnClickListener);
    if ((paramSwipRightMenuItem instanceof SimpleTextView)) {
      paramSwipRightMenuItem.setTag(paramObject);
    }
    return paramSwipRightMenuItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RecommendFriendAdapter.4
 * JD-Core Version:    0.7.0.1
 */