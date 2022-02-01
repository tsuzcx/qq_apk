package com.tencent.luggage.wxa.fs;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class b$c
  implements Runnable
{
  b$c(boolean paramBoolean) {}
  
  public final void run()
  {
    Context localContext = r.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DebugIP已设置为");
    localStringBuilder.append(this.a);
    localStringBuilder.append("，重启APP生效");
    Toast.makeText(localContext, (CharSequence)localStringBuilder.toString(), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fs.b.c
 * JD-Core Version:    0.7.0.1
 */