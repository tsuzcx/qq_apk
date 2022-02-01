package com.tencent.luggage.wxa.da;

import android.content.Intent;
import com.tencent.luggage.wxa.ew.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"marshallToIntent", "", "Lcom/tencent/luggage/struct/LaunchContainerAction;", "intent", "Landroid/content/Intent;", "key", "", "unmarshallFromIntent", "", "luggage-standalone-mode-ext_release"}, k=2, mv={1, 1, 16})
public final class g
{
  @JvmOverloads
  public static final void a(@NotNull b paramb, @NotNull Intent paramIntent, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$this$marshallToIntent");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    paramIntent.putExtra(paramString, paramb.b());
  }
  
  @JvmOverloads
  public static final boolean a(@NotNull b paramb, @NotNull Intent paramIntent)
  {
    return a(paramb, paramIntent, null, 2, null);
  }
  
  @JvmOverloads
  public static final boolean b(@NotNull b paramb, @NotNull Intent paramIntent, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$this$unmarshallFromIntent");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (!paramIntent.hasExtra(paramString)) {
      return false;
    }
    try
    {
      paramb.a(paramIntent.getByteArrayExtra(paramString));
      return true;
    }
    catch (Exception paramb) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.da.g
 * JD-Core Version:    0.7.0.1
 */