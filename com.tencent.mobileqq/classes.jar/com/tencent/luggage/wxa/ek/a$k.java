package com.tencent.luggage.wxa.ek;

import android.preference.Preference;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weui.base.preference.CheckBoxPreference;
import com.tencent.weui.base.preference.IPreferenceScreen;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/setting/ui/dialog/WxaSettingDialog$onShow$6", "Landroid/widget/AdapterView$OnItemClickListener;", "onItemClick", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$k
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(@NotNull AdapterView<?> paramAdapterView, @NotNull View paramView, int paramInt, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramAdapterView, "parent");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Object localObject = paramAdapterView.getAdapter().getItem(paramInt);
    if (localObject != null)
    {
      localObject = (Preference)localObject;
      if ((((Preference)localObject).isEnabled()) && (((Preference)localObject).isSelectable()) && (!(localObject instanceof CheckBoxPreference)) && (((Preference)localObject).getKey() != null))
      {
        a locala = this.a;
        locala.a((IPreferenceScreen)a.d(locala), (Preference)localObject);
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.preference.Preference");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ek.a.k
 * JD-Core Version:    0.7.0.1
 */