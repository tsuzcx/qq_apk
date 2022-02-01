package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SecondaryMenuDelegate_GameCpuProfiler$c$2
  implements Runnable
{
  SecondaryMenuDelegate_GameCpuProfiler$c$2(SecondaryMenuDelegate_GameCpuProfiler.c paramc) {}
  
  public final void run()
  {
    Object localObject = this.a.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.b);
    localStringBuilder.append(" export failed!");
    Toast.makeText((Context)localObject, (CharSequence)localStringBuilder.toString(), 1).show();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append(" export failed!");
    o.b("MiroMsg.GameCpuProfile", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.SecondaryMenuDelegate_GameCpuProfiler.c.2
 * JD-Core Version:    0.7.0.1
 */