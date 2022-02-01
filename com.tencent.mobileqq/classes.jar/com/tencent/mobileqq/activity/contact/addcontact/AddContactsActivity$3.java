package com.tencent.mobileqq.activity.contact.addcontact;

import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.onNavStickyListener;

class AddContactsActivity$3
  implements TroopView.onNavStickyListener
{
  AddContactsActivity$3(AddContactsActivity paramAddContactsActivity) {}
  
  public void a(boolean paramBoolean)
  {
    AddContactsActivity.a(this.a, paramBoolean);
    ImageView localImageView = AddContactsActivity.a(this.a);
    int i;
    if (AddContactsActivity.a(this.a)) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.3
 * JD-Core Version:    0.7.0.1
 */