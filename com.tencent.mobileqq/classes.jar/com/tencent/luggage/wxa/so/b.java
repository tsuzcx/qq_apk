package com.tencent.luggage.wxa.so;

import android.annotation.SuppressLint;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLObjectFactory;", "", "()V", "TAG", "", "allocatedFramebuffer", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLFrameBufferObject;", "Lkotlin/collections/HashMap;", "allocatedTexture", "Lcom/tencent/wmpf/samelayer/recordview/globject/LuggageGLTextureObject;", "newFrameBuffer", "scene", "", "newTexture", "sampler2D", "", "printAllocatedGLObjectInfo", "", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static final String b = "MicroMsg.GLObjectFactory";
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, WeakReference<c>> c = new HashMap();
  private static final HashMap<Integer, WeakReference<a>> d = new HashMap();
  
  @JvmStatic
  @NotNull
  public static final c a(boolean paramBoolean, long paramLong)
  {
    c localc = new c(paramBoolean, paramLong);
    ((Map)c).put(Integer.valueOf(localc.hashCode()), new WeakReference(localc));
    return localc;
  }
  
  @NotNull
  public final a a(long paramLong)
  {
    a locala = new a(paramLong);
    ((Map)d).put(Integer.valueOf(locala.hashCode()), new WeakReference(locala));
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.so.b
 * JD-Core Version:    0.7.0.1
 */