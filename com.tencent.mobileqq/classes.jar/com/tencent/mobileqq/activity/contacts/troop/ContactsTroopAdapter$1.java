package com.tencent.mobileqq.activity.contacts.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

class ContactsTroopAdapter$1
  extends SwipTextViewMenuBuilder
{
  ContactsTroopAdapter$1(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    this.a.a(paramInt, paramArrayOfSwipRightMenuItem, paramObject);
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
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.1
 * JD-Core Version:    0.7.0.1
 */