package com.tencent.mobileqq.activity.contact.addcontact;

import android.widget.PopupWindow;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.mobileqq.widget.FormMutiItem;

class AddContactsView$2
  implements BounceScrollView.OnScrollChangedListener
{
  AddContactsView$2(AddContactsView paramAddContactsView) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.i != null) {
      if (paramInt2 >= this.a.i.getY() + this.a.i.getHeight() * 2 / 3)
      {
        if ((this.a.D != null) && (this.a.D.isShowing())) {
          AddContactsView.a(this.a, false);
        }
      }
      else {
        AddContactsView.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.2
 * JD-Core Version:    0.7.0.1
 */