package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.widget.FormMutiItem;

class AddContactsView$10$1
  implements Runnable
{
  AddContactsView$10$1(AddContactsView.10 param10) {}
  
  public void run()
  {
    String str2 = this.a.a.toString();
    String str1 = str2;
    if (str2.endsWith("、")) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    if (this.a.this$0.a != null)
    {
      if (!str1.equals(AddContactsView.g())) {
        return;
      }
      this.a.this$0.a.setSecondLineVisible(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.10.1
 * JD-Core Version:    0.7.0.1
 */