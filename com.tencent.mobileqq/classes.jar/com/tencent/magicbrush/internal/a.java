package com.tencent.magicbrush.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Point;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.tencent.luggage.wxa.d.d;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g.b;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.handler.glfont.i;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"logIfVerbose", "", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "message", "", "processAndAbortIfNeeded", "", "processAssetManagerOrThrow", "processDprWidthHeightOrThrow", "processImageHandler", "lib-magicbrush-nano_release"}, k=2, mv={1, 1, 13})
public final class a
{
  public static final void a(@NotNull f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "receiver$0");
    if (paramf.i() == null)
    {
      Object localObject = paramf.b();
      if (localObject != null) {
        localObject = ((Context)localObject).getAssets();
      } else {
        localObject = null;
      }
      paramf.a((AssetManager)localObject);
    }
    if (paramf.i() != null) {
      return;
    }
    throw ((Throwable)new IllegalStateException("AssetManager invalid. Either assetManager or context should be provided.".toString()));
  }
  
  public static final void a(@NotNull f paramf, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "receiver$0");
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    if (paramf.p()) {
      c.c.b("MagicBrush", paramString, new Object[0]);
    }
  }
  
  public static final void b(@NotNull f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "receiver$0");
    if ((paramf.e() <= 0) && (paramf.b() != null))
    {
      localObject1 = paramf.b();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      paramf.a(com.tencent.luggage.wxa.gk.b.a((Context)localObject1));
    }
    Object localObject1 = (Function0)new a.a(paramf);
    if (!((Boolean)((Function0)localObject1).invoke()).booleanValue()) {
      if (paramf.b() != null)
      {
        if (paramf.b() != null)
        {
          Object localObject2 = paramf.b();
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          localObject2 = com.tencent.luggage.wxa.gk.b.c((Context)localObject2);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "DisplayUtil.getDisplayLogicSize(context!!)");
          paramf.a(((Point)localObject2).x);
          paramf.b(((Point)localObject2).y);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("w/h invalid, use context automatically. ");
          ((StringBuilder)localObject2).append(paramf.f());
          ((StringBuilder)localObject2).append('/');
          ((StringBuilder)localObject2).append(paramf.g());
          a(paramf, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("w/h invalid. context invalid. ");
        ((StringBuilder)localObject1).append(paramf.f());
        ((StringBuilder)localObject1).append('/');
        ((StringBuilder)localObject1).append(paramf.g());
        throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString().toString()));
      }
    }
    if (((Boolean)((Function0)localObject1).invoke()).booleanValue()) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("dpr/w/h invalid. ");
    ((StringBuilder)localObject1).append(paramf.e());
    ((StringBuilder)localObject1).append('/');
    ((StringBuilder)localObject1).append(paramf.f());
    ((StringBuilder)localObject1).append('/');
    ((StringBuilder)localObject1).append(paramf.g());
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString().toString()));
  }
  
  public static final void c(@NotNull f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "receiver$0");
    if (!paramf.j().a())
    {
      if (paramf.j().e() != null) {
        return;
      }
      a(paramf, "ImageHandler invalid, BindingImage can not use. BE CAUTIOUS!");
      paramf = Unit.INSTANCE;
      return;
    }
    BaseImageDecodeService localBaseImageDecodeService = new BaseImageDecodeService();
    localBaseImageDecodeService.addImageStreamFetcher((d)new com.tencent.luggage.wxa.gj.b(), false);
    Object localObject1 = paramf.j().b();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = (d)localObject2;
      int j = ((List)localObject1).size();
      boolean bool = true;
      if (i != j - 1) {
        bool = false;
      }
      localBaseImageDecodeService.addImageStreamFetcher((d)localObject2, bool);
      i += 1;
    }
    if (paramf.j().c() != null) {
      localBaseImageDecodeService.setKvReportDelegate(paramf.j().c());
    }
    if (paramf.j().d() != null)
    {
      localObject1 = paramf.j().d();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localBaseImageDecodeService.setBitmapDecodeSlave((IImageDecodeService.a)localObject1);
    }
    paramf.j().a(localBaseImageDecodeService);
  }
  
  public static final boolean d(@NotNull f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "receiver$0");
    for (;;)
    {
      try
      {
        double d = paramf.n();
        if ((d >= 0.0D) && (d <= 1.0D))
        {
          i = 1;
          if (i != 0)
          {
            if (paramf.b() != null)
            {
              if (paramf.c() != null)
              {
                if (paramf.d() != null)
                {
                  a(paramf);
                  b(paramf);
                  if (paramf.h() == null)
                  {
                    a(paramf, "FileSystem invalid, BindingFileSystem can not use. BE CAUTIOUS!");
                    localObject = Unit.INSTANCE;
                  }
                  c(paramf);
                  if (paramf.l() != null) {
                    break;
                  }
                  paramf.a((IMBFontHandler)new i());
                  return true;
                }
                throw ((Throwable)new IllegalStateException("v8RawPointer invalid. Please define which JsEngine magicbrush should use.".toString()));
              }
              throw ((Throwable)new IllegalStateException("JsThreadHandler invalid.".toString()));
            }
            throw ((Throwable)new IllegalStateException("AndroidContext invalid.".toString()));
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("GcFactor must in [0, 1], but ");
          ((StringBuilder)localObject).append(paramf.n());
          throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
        }
      }
      catch (Exception localException)
      {
        if (!paramf.o()) {
          return false;
        }
        throw ((Throwable)localException);
      }
      int i = 0;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.internal.a
 * JD-Core Version:    0.7.0.1
 */