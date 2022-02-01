package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ui.base.l;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class WxaProfileActivity$$special$$inlined$observable$3
  extends ObservableProperty<Integer>
{
  public WxaProfileActivity$$special$$inlined$observable$3(Object paramObject1, Object paramObject2, WxaProfileActivity paramWxaProfileActivity)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, Integer paramInteger1, Integer paramInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    int j = ((Number)paramInteger2).intValue();
    ((Number)paramInteger1).intValue();
    paramKProperty = (ImageView)l.a((View)WxaProfileActivity.e(this.b), "trading_guarantee_icon");
    int i;
    if (j == 1) {
      i = 0;
    } else {
      i = 8;
    }
    paramKProperty.setVisibility(i);
    paramKProperty = (TextView)l.a((View)WxaProfileActivity.e(this.b), "wxa_desc");
    paramInteger1 = paramKProperty.getLayoutParams();
    if (paramInteger1 != null)
    {
      paramInteger1 = (LinearLayout.LayoutParams)paramInteger1;
      if (j == 1) {
        i = l.a(this.b, 2131296336);
      } else {
        i = l.a(this.b, 2131296339);
      }
      paramInteger1.topMargin = i;
      paramKProperty.setLayoutParams((ViewGroup.LayoutParams)paramInteger1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity..special..inlined.observable.3
 * JD-Core Version:    0.7.0.1
 */