package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SecondaryMenuDelegate_GameCpuProfiler$c$1
  implements Runnable
{
  SecondaryMenuDelegate_GameCpuProfiler$c$1(SecondaryMenuDelegate_GameCpuProfiler.c paramc, String paramString) {}
  
  public final void run()
  {
    Object localObject = this.a.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(" exported.");
    Toast.makeText((Context)localObject, (CharSequence)localStringBuilder.toString(), 1).show();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" exported.");
    o.d("MiroMsg.GameCpuProfile", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.SecondaryMenuDelegate_GameCpuProfiler.c.1
 * JD-Core Version:    0.7.0.1
 */