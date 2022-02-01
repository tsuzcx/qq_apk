package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormMutiWithAvatarItem;
import java.util.ArrayList;

class AddContactsView$12$1
  implements Runnable
{
  AddContactsView$12$1(AddContactsView.12 param12, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((AddContactsView.b(this.c.this$0) != null) && (this.a != 0))
    {
      Object localObject1 = this.b;
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).isEmpty()) {
          return;
        }
        if ((this.c.this$0.h instanceof FormMutiWithAvatarItem))
        {
          localObject1 = (FormMutiWithAvatarItem)this.c.this$0.h;
          if (!((FormMutiWithAvatarItem)localObject1).b()) {
            ((FormMutiWithAvatarItem)localObject1).setOverloading();
          }
          if (this.a != 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.a);
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898093));
            ((FormMutiWithAvatarItem)localObject1).setPeopleText(((StringBuilder)localObject2).toString());
          }
          Object localObject2 = this.b;
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            localObject2 = new String[this.b.size()];
            int i = 0;
            while (i < this.b.size())
            {
              localObject2[i] = ((String)this.b.get(i));
              i += 1;
            }
            ((FormMutiWithAvatarItem)localObject1).setOverimgLayout(24, 24, (String[])localObject2, AddContactsView.b(this.c.this$0));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.12.1
 * JD-Core Version:    0.7.0.1
 */