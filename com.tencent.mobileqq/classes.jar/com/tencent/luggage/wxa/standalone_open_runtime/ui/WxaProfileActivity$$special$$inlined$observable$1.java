package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.ui.base.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class WxaProfileActivity$$special$$inlined$observable$1
  extends ObservableProperty<String>
{
  public WxaProfileActivity$$special$$inlined$observable$1(Object paramObject1, Object paramObject2, WxaProfileActivity paramWxaProfileActivity)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, String paramString1, String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramKProperty = (String)paramString2;
    paramString1 = (String)paramString1;
    AppBrandSimpleImageLoader.instance().attach((ImageView)l.a((View)WxaProfileActivity.e(this.b), "wxa_icon"), paramKProperty, 2130842125, (AppBrandSimpleImageLoader.h)new WxaIconTransformation());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity..special..inlined.observable.1
 * JD-Core Version:    0.7.0.1
 */