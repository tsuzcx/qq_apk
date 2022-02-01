package com.tencent.luggage.wxa.di;

import android.annotation.SuppressLint;
import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.af;

public class b
  extends Preference
{
  private boolean a = false;
  private String b;
  private TextView c;
  private CheckBox d;
  
  public b(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(2131625201);
  }
  
  public void a(int paramInt)
  {
    this.b = getContext().getString(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    CheckBox localCheckBox = this.d;
    if (localCheckBox != null) {
      localCheckBox.setChecked(paramBoolean);
    }
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void onBindView(View paramView)
  {
    this.d = ((CheckBox)paramView.findViewById(2131430688));
    CheckBox localCheckBox = this.d;
    if (localCheckBox != null) {
      localCheckBox.setChecked(this.a);
    }
    this.c = ((TextView)paramView.findViewById(2131428882));
    if ((this.c != null) && (!af.c(this.b))) {
      this.c.setText(this.b);
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131445147);
    localViewGroup.removeAllViews();
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131625199, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.di.b
 * JD-Core Version:    0.7.0.1
 */