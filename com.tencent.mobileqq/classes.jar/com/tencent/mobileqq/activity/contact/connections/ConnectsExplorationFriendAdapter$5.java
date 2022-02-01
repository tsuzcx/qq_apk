package com.tencent.mobileqq.activity.contact.connections;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class ConnectsExplorationFriendAdapter$5
  extends SwipTextViewMenuBuilder
{
  ConnectsExplorationFriendAdapter$5(ConnectsExplorationFriendAdapter paramConnectsExplorationFriendAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
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
      int j = paramArrayOfSwipRightMenuItem.length;
      int i = 0;
      paramInt = i;
      if (j > 0)
      {
        paramInt = i;
        if (!(paramObject instanceof ConnectsExplorationBanner))
        {
          paramArrayOfSwipRightMenuItem[0].menuId = 0;
          paramArrayOfSwipRightMenuItem[0].menuType = 0;
          paramInt = 1;
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.5
 * JD-Core Version:    0.7.0.1
 */