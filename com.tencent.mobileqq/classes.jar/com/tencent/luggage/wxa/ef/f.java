package com.tencent.luggage.wxa.ef;

import android.webkit.ConsoleMessage;
import com.tencent.luggage.wxa.ry.b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/wxa_ktx/WebkitUtils;", "", "()V", "println", "", "Landroid/webkit/ConsoleMessage;", "tag", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class f
{
  public static final f a = new f();
  
  @JvmStatic
  public static final void a(@Nullable ConsoleMessage paramConsoleMessage, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    if (paramConsoleMessage != null) {
      localObject = paramConsoleMessage.messageLevel();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    int j = g.a[localObject.ordinal()];
    int i = 5;
    if ((j != 1) && (j != 2) && (j != 3))
    {
      if (j != 4) {
        if (j == 5) {
          i = 6;
        } else {
          throw new NoWhenBranchMatchedException();
        }
      }
    }
    else {
      i = 3;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ConsoleMessage: message:");
    ((StringBuilder)localObject).append(paramConsoleMessage.message());
    ((StringBuilder)localObject).append(", sourceId:");
    ((StringBuilder)localObject).append(paramConsoleMessage.sourceId());
    ((StringBuilder)localObject).append(", lineNumber:");
    ((StringBuilder)localObject).append(paramConsoleMessage.lineNumber());
    b.a(i, paramString, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ef.f
 * JD-Core Version:    0.7.0.1
 */