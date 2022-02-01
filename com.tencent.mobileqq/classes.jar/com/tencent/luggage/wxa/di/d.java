package com.tencent.luggage.wxa.di;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.ui.a;
import com.tencent.weui.base.preference.CheckBoxPreference;

public class d
  extends CheckBoxPreference
{
  public d(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    setLayoutResource(2131625201);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    paramViewGroup.findViewById(2131444798).setVisibility(8);
    LinearLayout localLinearLayout = (LinearLayout)paramViewGroup.findViewById(2131431322);
    localLinearLayout.setOrientation(1);
    localLinearLayout.removeAllViews();
    View.inflate(getContext(), 2131625459, localLinearLayout);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, a.a(getContext(), 1));
    View localView = new View(getContext());
    localView.setBackgroundColor(getContext().getResources().getColor(2131166390));
    localLinearLayout.addView(localView, localLayoutParams);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.di.d
 * JD-Core Version:    0.7.0.1
 */