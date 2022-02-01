package com.tencent.luggage.wxa.oq;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.or.n;

class a$1
  implements d.b
{
  a$1(a parama) {}
  
  public ViewGroup a(@NonNull View paramView)
  {
    Activity localActivity;
    if ((this.a.a instanceof n)) {
      localActivity = ((n)this.a.a).u();
    } else {
      localActivity = null;
    }
    if (localActivity == null) {
      return (ViewGroup)paramView.getRootView();
    }
    return (ViewGroup)localActivity.getWindow().getDecorView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oq.a.1
 * JD-Core Version:    0.7.0.1
 */