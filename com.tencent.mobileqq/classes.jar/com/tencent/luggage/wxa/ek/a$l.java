package com.tencent.luggage.wxa.ek;

import android.preference.Preference;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.ui.f;
import com.tencent.weui.base.preference.IPreferenceScreen;
import com.tencent.weui.base.preference.c;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/setting/ui/dialog/WxaSettingDialog$onShow$7", "Landroid/widget/AdapterView$OnItemLongClickListener;", "onItemLongClick", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$l
  implements AdapterView.OnItemLongClickListener
{
  public boolean onItemLongClick(@NotNull AdapterView<?> paramAdapterView, @NotNull View paramView, int paramInt, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramAdapterView, "parent");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramAdapterView = a.e(this.a);
    if (paramAdapterView == null) {
      Intrinsics.throwNpe();
    }
    if (paramInt < paramAdapterView.getHeaderViewsCount()) {
      return false;
    }
    paramAdapterView = a.e(this.a);
    if (paramAdapterView == null) {
      Intrinsics.throwNpe();
    }
    paramInt -= paramAdapterView.getHeaderViewsCount();
    paramAdapterView = a.d(this.a);
    if (paramAdapterView == null) {
      Intrinsics.throwNpe();
    }
    if (paramInt >= paramAdapterView.getCount())
    {
      paramAdapterView = a.d(this.a);
      if (paramAdapterView == null) {
        Intrinsics.throwNpe();
      }
      f.e("WMPF.WxaSettingDialog", "itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramAdapterView.getCount()) });
      return false;
    }
    paramAdapterView = a.d(this.a);
    if (paramAdapterView == null) {
      Intrinsics.throwNpe();
    }
    paramAdapterView = paramAdapterView.getItem(paramInt);
    if (paramAdapterView != null)
    {
      paramAdapterView = (Preference)paramAdapterView;
      paramView = this.a;
      return paramView.a((IPreferenceScreen)a.d(paramView), paramAdapterView, (View)a.e(this.a));
    }
    throw new TypeCastException("null cannot be cast to non-null type android.preference.Preference");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ek.a.l
 * JD-Core Version:    0.7.0.1
 */