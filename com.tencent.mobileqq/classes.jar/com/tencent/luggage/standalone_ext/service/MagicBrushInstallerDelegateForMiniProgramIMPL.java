package com.tencent.luggage.standalone_ext.service;

import android.content.Context;
import com.tencent.luggage.wxa.bk.a;
import com.tencent.luggage.wxa.bk.f;
import com.tencent.luggage.wxa.du.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/service/MagicBrushInstallerDelegateForMiniProgramIMPL;", "Lcom/tencent/luggage/standalone_ext/service/MagicBrushInstallerDelegateForMiniProgram;", "()V", "TAG", "", "mMagicBrushInstaller", "Lcom/tencent/luggage/game/boot/MagicBrushForMiniProgram;", "mpServiceLogic", "Lcom/tencent/luggage/standalone_ext/service/MPServiceLogic;", "beforeCleanup", "", "createMagicBrushIfNeed", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "getComponent", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "onJsRuntimeCreated", "postRuntimeReady", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class MagicBrushInstallerDelegateForMiniProgramIMPL
  implements e
{
  private String a = "";
  private f b;
  private d<?> c;
  
  private final void a(i parami)
  {
    if (((MagicBrushInstallerDelegateForMiniProgramIMPL)this).b != null) {
      return;
    }
    if (b() != null)
    {
      com.tencent.luggage.wxa.gi.b.a();
      Object localObject = b();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((c)localObject).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "getComponent()!!.context");
      this.b = new f((Context)localObject, parami);
      parami = this.b;
      if (parami == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMagicBrushInstaller");
      }
      parami.c();
      parami = this.b;
      if (parami == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMagicBrushInstaller");
      }
      parami = parami.b();
      localObject = b();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((c)localObject).getJsRuntime();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "getComponent()!!.jsRuntime");
      a.a(parami, (i)localObject);
      parami = this.b;
      if (parami == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMagicBrushInstaller");
      }
      parami.b().a((com.tencent.magicbrush.handler.b)new MagicBrushInstallerDelegateForMiniProgramIMPL.a(this));
      parami = b();
      if (parami == null) {
        Intrinsics.throwNpe();
      }
      if (parami.d())
      {
        parami = this.b;
        if (parami == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mMagicBrushInstaller");
        }
        localObject = b();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((c)localObject).i();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "getComponent()!!.runtime");
        parami.b((com.tencent.luggage.wxa.iu.d)localObject);
      }
    }
  }
  
  private final c b()
  {
    d locald = this.c;
    if (locald == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
    }
    return (c)locald.y();
  }
  
  public void a()
  {
    if (((MagicBrushInstallerDelegateForMiniProgramIMPL)this).b != null)
    {
      Object localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMagicBrushInstaller");
      }
      localObject = ((f)localObject).a();
      if (localObject != null) {
        ((com.tencent.magicbrush.e)localObject).a(null);
      }
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMagicBrushInstaller");
      }
      ((f)localObject).d();
    }
  }
  
  public void a(@NotNull d<?> paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "mpServiceLogic");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Luggage.MagicBrushInstallerDelegateForMiniProgramIMPL[");
    localStringBuilder.append(paramd.A());
    localStringBuilder.append('-');
    c localc = (c)paramd.y();
    if (localc == null) {
      Intrinsics.throwNpe();
    }
    localStringBuilder.append(localc.getComponentId());
    localStringBuilder.append(']');
    this.a = localStringBuilder.toString();
    this.c = paramd;
    paramd = (c)paramd.y();
    if (paramd == null) {
      Intrinsics.throwNpe();
    }
    paramd = paramd.getJsRuntime();
    if (paramd == null) {
      Intrinsics.throwNpe();
    }
    a(paramd);
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    if (((MagicBrushInstallerDelegateForMiniProgramIMPL)this).b != null)
    {
      f localf = this.b;
      if (localf == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMagicBrushInstaller");
      }
      localf.b(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.standalone_ext.service.MagicBrushInstallerDelegateForMiniProgramIMPL
 * JD-Core Version:    0.7.0.1
 */