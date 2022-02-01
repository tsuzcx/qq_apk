package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class c$2
  implements View.OnClickListener
{
  c$2(c paramc, ArrayList paramArrayList, c.a parama, b paramb) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      if ((((c.c)this.a.get(i)).b == 2) || (((c.c)this.a.get(i)).b == 3)) {
        localArrayList.add(((c.c)this.a.get(i)).a);
      }
      i += 1;
    }
    o.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
    this.b.a(2, localArrayList);
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c.2
 * JD-Core Version:    0.7.0.1
 */