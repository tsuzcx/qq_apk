package com.tencent.luggage.wxa.bq;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class e$5
  implements View.OnClickListener
{
  e$5(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, h paramh, boolean paramBoolean, a parama) {}
  
  public void onClick(View paramView)
  {
    e.b(this.e).a(this.a.getEditableText().toString(), this.b);
    e.a(this.e).a(this.a.getEditableText().toString(), this.b);
    if (!this.c) {
      this.d.j();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.e.5
 * JD-Core Version:    0.7.0.1
 */