package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"}, k=3, mv={1, 1, 16})
final class WxaProfileActivity$onCreate$1
  implements MenuItem.OnMenuItemClickListener
{
  WxaProfileActivity$onCreate$1(WxaProfileActivity paramWxaProfileActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.a.onBackPressed();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.onCreate.1
 * JD-Core Version:    0.7.0.1
 */