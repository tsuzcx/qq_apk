package com.tencent.luggage.standalone_ext.service;

import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.magicbrush.handler.b;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/standalone_ext/service/MagicBrushInstallerDelegateForMiniProgramIMPL$createMagicBrushIfNeed$2", "Lcom/tencent/magicbrush/handler/IMBInvokeHandler;", "getAsyncableJsApis", "", "", "()[Ljava/lang/String;", "invokeHandler", "api", "data", "callbackId", "", "isFromAsyncThread", "", "readWeAppFile", "Ljava/nio/ByteBuffer;", "path", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class MagicBrushInstallerDelegateForMiniProgramIMPL$a
  implements b
{
  @NotNull
  public String a(@NotNull String paramString1, @NotNull String paramString2, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "api");
    Intrinsics.checkParameterIsNotNull(paramString2, "data");
    try
    {
      c localc = MagicBrushInstallerDelegateForMiniProgramIMPL.a(this.a);
      if (localc != null)
      {
        paramString1 = localc.a(paramString1, paramString2, paramInt, paramBoolean);
        if (paramString1 != null) {
          return paramString1;
        }
      }
    }
    catch (Throwable paramString1)
    {
      com.tencent.luggage.wxa.qz.o.a(MagicBrushInstallerDelegateForMiniProgramIMPL.b(this.a), paramString1, "IMBInvokeHandler.invoke", new Object[0]);
      t.a((Runnable)new MagicBrushInstallerDelegateForMiniProgramIMPL.a.a(paramString1));
    }
    return "";
  }
  
  @Nullable
  public ByteBuffer a(@Nullable String paramString)
  {
    Object localObject1 = (CharSequence)paramString;
    int i;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2 = null;
    if (i != 0) {
      return null;
    }
    Object localObject3 = MagicBrushInstallerDelegateForMiniProgramIMPL.a(this.a);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((c)localObject3).getFileSystem();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject2 = new i();
        localObject1 = ((com.tencent.mm.plugin.appbrand.appstorage.o)localObject3).b(paramString, (i)localObject2);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "this.readFile(path, buffer)");
        if (f.a[localObject1.ordinal()] != 1)
        {
          localObject2 = MagicBrushInstallerDelegateForMiniProgramIMPL.b(this.a);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("readWeAppFile appId:");
          c localc = MagicBrushInstallerDelegateForMiniProgramIMPL.a(this.a);
          if (localc == null) {
            Intrinsics.throwNpe();
          }
          ((StringBuilder)localObject3).append(localc.getAppId());
          ((StringBuilder)localObject3).append(", path:");
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append(", failed:");
          ((StringBuilder)localObject3).append(localObject1);
          com.tencent.luggage.wxa.qz.o.b((String)localObject2, ((StringBuilder)localObject3).toString());
          return null;
        }
        localObject1 = p.a((ByteBuffer)((i)localObject2).a);
      }
    }
    return localObject1;
  }
  
  @NotNull
  public String[] a()
  {
    Object localObject = MagicBrushInstallerDelegateForMiniProgramIMPL.a(this.a);
    if (localObject != null)
    {
      localObject = ((c)localObject).O();
      if (localObject != null) {
        return localObject;
      }
    }
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.standalone_ext.service.MagicBrushInstallerDelegateForMiniProgramIMPL.a
 * JD-Core Version:    0.7.0.1
 */