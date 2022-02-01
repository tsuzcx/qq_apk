package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.widget.Toast;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SecondaryMenuDelegate_GameCpuProfiler$b$1
  implements Runnable
{
  SecondaryMenuDelegate_GameCpuProfiler$b$1(SecondaryMenuDelegate_GameCpuProfiler.b paramb) {}
  
  public final void run()
  {
    Toast.makeText(this.a.b, (CharSequence)"start cpu profiling...", 1).show();
    o.d("MiroMsg.GameCpuProfile", "start cpu profiling...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.SecondaryMenuDelegate_GameCpuProfiler.b.1
 * JD-Core Version:    0.7.0.1
 */