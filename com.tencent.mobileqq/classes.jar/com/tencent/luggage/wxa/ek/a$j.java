package com.tencent.luggage.wxa.ek;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.tencent.weui.base.preference.CheckBoxPreference;
import com.tencent.weui.base.preference.IPreferenceScreen;
import com.tencent.weui.base.preference.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "pref", "Landroid/preference/Preference;", "kotlin.jvm.PlatformType", "newValue", "", "onPreferenceChange"}, k=3, mv={1, 1, 16})
final class a$j
  implements Preference.OnPreferenceChangeListener
{
  a$j(a parama) {}
  
  public final boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (!a.b(this.a))
    {
      Intrinsics.checkExpressionValueIsNotNull(paramPreference, "pref");
      if ((paramPreference.isEnabled()) && (paramPreference.isSelectable()))
      {
        a.a(this.a, true);
        int i;
        if ((paramPreference instanceof CheckBoxPreference))
        {
          paramObject = (CheckBoxPreference)paramPreference;
          paramObject.setChecked(paramObject.isChecked());
          if (paramPreference.isPersistent())
          {
            SharedPreferences localSharedPreferences = a.c(this.a);
            if (localSharedPreferences == null) {
              Intrinsics.throwNpe();
            }
            localSharedPreferences.edit().putBoolean(paramObject.getKey(), paramObject.isChecked()).apply();
          }
          a.b(this.a, true);
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (paramPreference.getKey() != null)
        {
          paramObject = this.a;
          paramObject.a((IPreferenceScreen)a.d(paramObject), paramPreference);
        }
        if (i != 0)
        {
          paramPreference = a.d(this.a);
          if (paramPreference == null) {
            Intrinsics.throwNpe();
          }
          paramPreference.notifyDataSetChanged();
        }
        a.a(this.a, false);
        if (i != 0) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ek.a.j
 * JD-Core Version:    0.7.0.1
 */