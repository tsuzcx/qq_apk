package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class NewFriendBaseBuilder$1
  extends SwipTextViewMenuBuilder
{
  NewFriendBaseBuilder$1(NewFriendBaseBuilder paramNewFriendBaseBuilder, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramInt = 1;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    for (;;)
    {
      return;
      int i = this.a.a();
      if ((paramArrayOfSwipRightMenuItem.length < 0) && ((i & 0xF) == 1))
      {
        paramArrayOfSwipRightMenuItem[0].b = 0;
        paramArrayOfSwipRightMenuItem[0].a = 0;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].b = -1;
        paramArrayOfSwipRightMenuItem[paramInt].a = -1;
        paramInt += 1;
        continue;
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder.1
 * JD-Core Version:    0.7.0.1
 */