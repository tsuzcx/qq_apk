package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.mm.ui.base.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class WxaProfileActivity$$special$$inlined$observable$5
  extends ObservableProperty<Double>
{
  public WxaProfileActivity$$special$$inlined$observable$5(Object paramObject1, Object paramObject2, WxaProfileActivity paramWxaProfileActivity)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, Double paramDouble1, Double paramDouble2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    double d1 = ((Number)paramDouble2).doubleValue();
    ((Number)paramDouble1).doubleValue();
    paramKProperty = (RatingBar)WxaProfileActivity.e(this.b).findViewById(2131446286);
    paramDouble1 = (TextView)l.a((View)WxaProfileActivity.e(this.b), "star_not_enough");
    paramDouble2 = (LinearLayout)l.a((View)WxaProfileActivity.e(this.b), "star_layout");
    TextView localTextView = (TextView)l.a((View)WxaProfileActivity.e(this.b), "star_text");
    double d2 = 0;
    if (d1 > d2)
    {
      paramDouble1.setVisibility(8);
      paramDouble2.setVisibility(0);
      localTextView.setText((CharSequence)String.valueOf(d1));
      Intrinsics.checkExpressionValueIsNotNull(paramKProperty, "starBar");
      paramKProperty.setRating((float)d1);
      return;
    }
    if (d1 == d2)
    {
      paramDouble2.setVisibility(8);
      paramDouble1.setVisibility(0);
      return;
    }
    paramDouble2.setVisibility(8);
    paramDouble2.setVisibility(8);
    paramDouble1.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity..special..inlined.observable.5
 * JD-Core Version:    0.7.0.1
 */