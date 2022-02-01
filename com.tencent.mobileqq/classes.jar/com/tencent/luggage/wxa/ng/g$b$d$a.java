package com.tencent.luggage.wxa.ng;

import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindSearchHeader$1$1"}, k=3, mv={1, 1, 16})
final class g$b$d$a
  implements Runnable
{
  g$b$d$a(g.b.d paramd) {}
  
  public final void run()
  {
    this.a.b.b().setVisibility(8);
    TextView localTextView = this.a.b.a();
    Object localObject;
    if (g.b(this.a.a.a))
    {
      localObject = (CharSequence)"暂无其他设备";
    }
    else
    {
      if (this.a.a.a.h().b().isEmpty()) {
        localObject = "暂无可连接设备";
      } else {
        localObject = "可连接设备";
      }
      localObject = (CharSequence)localObject;
    }
    localTextView.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.b.d.a
 * JD-Core Version:    0.7.0.1
 */