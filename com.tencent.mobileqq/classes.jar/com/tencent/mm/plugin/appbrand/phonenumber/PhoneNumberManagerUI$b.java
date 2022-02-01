package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"}, k=3, mv={1, 1, 16})
final class PhoneNumberManagerUI$b
  implements MenuItem.OnMenuItemClickListener
{
  PhoneNumberManagerUI$b(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = PhoneNumberManagerUI.a(this.a);
    if (paramMenuItem != null) {
      paramMenuItem.e();
    }
    PhoneNumberManagerUI.a(this.a, false);
    PhoneNumberManagerUI.b(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI.b
 * JD-Core Version:    0.7.0.1
 */