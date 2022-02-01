package com.tencent.luggage.wxa.pq;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.luggage.wxa.pw.a.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class a$a
  implements View.OnClickListener
{
  View a;
  TextView b;
  TextView c;
  View d;
  View e;
  a.b f;
  
  a$a(a parama, View paramView)
  {
    this.a = paramView;
    this.b = ((TextView)paramView.findViewById(2131447463));
    this.c = ((TextView)paramView.findViewById(2131431322));
    this.d = paramView.findViewById(2131430806);
    this.e = paramView.findViewById(2131432003);
    paramView.setBackgroundResource(2130842529);
    paramView.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  void a(a.b paramb)
  {
    this.f = paramb;
    this.b.setText(paramb.b);
    this.c.setText(paramb.c);
    TextView localTextView = this.c;
    int i;
    if (af.c(paramb.c)) {
      i = 8;
    } else {
      i = 0;
    }
    localTextView.setVisibility(i);
  }
  
  public void onClick(View paramView)
  {
    if (this.f != null) {
      if (paramView.getId() == 2131430806)
      {
        this.g.remove(this.f);
        if (a.a(this.g) != null) {
          a.a(this.g).a(this.f.a, i.a.b);
        }
      }
      else if ((paramView == this.a) && (a.a(this.g) != null))
      {
        if (this.f != null) {
          a.a(this.g).a(this.f.a, i.a.c);
        }
        a.a(this.g, true);
        if (a.c(this.g) != null) {
          a.c(this.g).d();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.a.a
 * JD-Core Version:    0.7.0.1
 */