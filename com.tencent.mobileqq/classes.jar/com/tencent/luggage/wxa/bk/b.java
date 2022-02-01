package com.tencent.luggage.wxa.bk;

import com.tencent.mm.appbrand.v8.BufferURLManager;
import com.tencent.mm.plugin.appbrand.jsruntime.w;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/game/boot/BufferURLManagerDelegate;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/IBufferURLManager;", "impl", "Lcom/tencent/mm/appbrand/v8/BufferURLManager;", "(Lcom/tencent/mm/appbrand/v8/BufferURLManager;)V", "getImpl", "()Lcom/tencent/mm/appbrand/v8/BufferURLManager;", "createBufferURL", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "getBuffer", "url", "revokeBufferURL", "", "luggage-wxa-game-ext_release"}, k=1, mv={1, 1, 16})
final class b
  implements w
{
  @NotNull
  private final BufferURLManager a;
  
  public b(@NotNull BufferURLManager paramBufferURLManager)
  {
    this.a = paramBufferURLManager;
  }
  
  @Nullable
  public ByteBuffer a(@Nullable String paramString)
  {
    return this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.b
 * JD-Core Version:    0.7.0.1
 */