package com.tencent.luggage.wxa.nf;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.luggage.wxa.fx.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/media/AudioManager;", "invoke"}, k=3, mv={1, 1, 16})
final class b$d
  extends Lambda
  implements Function0<AudioManager>
{
  b$d(b paramb)
  {
    super(0);
  }
  
  @Nullable
  public final AudioManager a()
  {
    return (AudioManager)b.b(this.a).b().getSystemService("audio");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.b.d
 * JD-Core Version:    0.7.0.1
 */