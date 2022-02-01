package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import com.tencent.magicbrush.e;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/MagicBrushView$Companion;", "", "()V", "DEFAULT_VIEW_TYPE", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "TAG", "", "touchEventHandler", "Lcom/tencent/magicbrush/handler/JsTouchEventHandler;", "checkAnimationHandler", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "viewType", "checkViewTypeValid", "createRendererViewByViewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "context", "Landroid/content/Context;", "getRendererViewOrDefault", "view", "attr", "Landroid/util/AttributeSet;", "getViewTypeByAttributeSet", "getVirtualElementByAttributeSet", "", "(Landroid/util/AttributeSet;)Ljava/lang/Integer;", "getVirtualElementIdOrZero", "virtualElementId", "(Ljava/lang/Integer;Landroid/util/AttributeSet;)I", "tryReconfigureBitmapIfNeed", "Landroid/graphics/Bitmap;", "bitmap", "width", "height", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class i$a
{
  private final Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2)) {
      return paramBitmap;
    }
    try
    {
      paramBitmap.reconfigure(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return paramBitmap;
    }
    catch (Exception paramBitmap) {}
    return null;
  }
  
  private final i.b a(Context paramContext, i.b paramb, AttributeSet paramAttributeSet)
  {
    if (paramb != null) {
      return paramb;
    }
    a locala = (a)this;
    paramAttributeSet = locala.a(paramAttributeSet);
    paramb = paramAttributeSet;
    if (paramAttributeSet == null) {
      paramb = i.a();
    }
    return locala.a(paramContext, paramb);
  }
  
  private final i.b a(Context paramContext, i.h paramh)
  {
    int i = j.a[paramh.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return (i.b)new h(paramContext);
      }
      throw ((Throwable)new Exception("invalid viewType"));
    }
    return (i.b)new g(paramContext);
  }
  
  private final i.h a(AttributeSet paramAttributeSet)
  {
    Object localObject1 = (i.h)null;
    Object localObject2 = localObject1;
    if (paramAttributeSet != null)
    {
      Iterator localIterator = ((Iterable)RangesKt.until(0, paramAttributeSet.getAttributeCount())).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        int i = ((IntIterator)localIterator).nextInt();
        if (Intrinsics.areEqual("viewType", paramAttributeSet.getAttributeName(i)))
        {
          localObject1 = paramAttributeSet.getAttributeValue(i);
          localObject2 = i.a;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "viewTypeName");
          ((a)localObject2).a((String)localObject1);
          if (Intrinsics.areEqual(localObject1, "SurfaceView")) {
            localObject1 = i.h.a;
          } else {
            localObject1 = i.h.b;
          }
        }
      }
    }
    return localObject2;
  }
  
  private final void a(e parame, i.h paramh)
  {
    if (paramh == i.h.b)
    {
      int i;
      if (parame.p().m() != a.b.c) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ViewType [");
      localStringBuilder.append(paramh);
      localStringBuilder.append("] can not work with RAF mode[");
      localStringBuilder.append(parame.p().m());
      localStringBuilder.append(']');
      throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
    }
  }
  
  private final void a(String paramString)
  {
    int i;
    if ((!Intrinsics.areEqual(paramString, "SurfaceView")) && (!Intrinsics.areEqual(paramString, "TextureView"))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    paramString = String.format("ViewType must be [SurfaceView|TextureView], but is [%s]", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(this, *args)");
    throw ((Throwable)new IllegalStateException(paramString.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.i.a
 * JD-Core Version:    0.7.0.1
 */