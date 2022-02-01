package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enable", "", "height", "", "hideCapsuleHomeButton", "activityAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "closeWhenClickEmptyArea", "bgShapeConf", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;", "forceLightMode", "closeWhenClickEmptyAreaConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "(ZIZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$BackgroundShapeConfig;ZLcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;)V", "isEnable", "()Z", "describeContents", "performCloseHalfScreen", "activity", "Landroid/app/Activity;", "toAnimationRes", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "style", "toBuilder", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$Builder;", "writeToParcel", "", "flags", "ActivityAnimationStyle", "BackgroundShapeConfig", "Builder", "CloseWhenClickEmptyAreaConfig", "Companion", "data-model_release"}, k=1, mv={1, 1, 16})
public final class p
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<p> CREATOR = (Parcelable.Creator)new p.e();
  @JvmField
  @NotNull
  public static final p h = new p(false, 0, false, null, false, null, false, null, 248, null);
  public static final p.d i = new p.d(null);
  @JvmField
  public final int a;
  @JvmField
  public final boolean b;
  @JvmField
  @NotNull
  public final p.a c;
  @JvmField
  public final boolean d;
  @JvmField
  @NotNull
  public final p.b e;
  @JvmField
  public final boolean f;
  @JvmField
  @NotNull
  public final p.c g;
  private final boolean j;
  
  public p(@NotNull Parcel paramParcel)
  {
    this(bool1, k, bool2, (p.a)localObject1, bool3, (p.b)localObject2, bool4, (p.c)paramParcel);
  }
  
  public p(boolean paramBoolean1, int paramInt, boolean paramBoolean2, @NotNull p.a parama, boolean paramBoolean3, @NotNull p.b paramb, boolean paramBoolean4, @NotNull p.c paramc)
  {
    this.a = paramInt;
    this.b = paramBoolean2;
    this.c = parama;
    this.d = paramBoolean3;
    this.e = paramb;
    this.f = paramBoolean4;
    this.g = paramc;
    this.j = paramBoolean1;
  }
  
  @JvmName(name="isEnable")
  public final boolean a()
  {
    return (this.j) && (this.a > 0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.p
 * JD-Core Version:    0.7.0.1
 */