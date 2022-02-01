package com.tencent.mobileqq.adapter;

import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class NewFriendMoreSysMsgAdapter$13
  extends SwipTextViewMenuBuilder
{
  NewFriendMoreSysMsgAdapter$13(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramInt = 0;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfSwipRightMenuItem.length < 0)
      {
        paramArrayOfSwipRightMenuItem[0].b = 0;
        paramArrayOfSwipRightMenuItem[0].a = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].b = -1;
        paramArrayOfSwipRightMenuItem[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.13
 * JD-Core Version:    0.7.0.1
 */