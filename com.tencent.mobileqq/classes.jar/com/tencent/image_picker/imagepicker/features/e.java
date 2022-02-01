package com.tencent.image_picker.imagepicker.features;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import java.io.File;
import java.util.List;

class e
  extends com.tencent.luggage.wxa.av.b<g>
{
  private a a;
  private com.tencent.luggage.wxa.at.b b;
  private Handler c = new Handler(Looper.getMainLooper());
  
  e(a parama)
  {
    this.a = parama;
  }
  
  private void a(Runnable paramRunnable)
  {
    this.c.post(new e.4(this, paramRunnable));
  }
  
  com.tencent.luggage.wxa.at.b a()
  {
    if (this.b == null) {
      this.b = new com.tencent.luggage.wxa.at.b();
    }
    return this.b;
  }
  
  void a(Activity paramActivity, com.tencent.luggage.wxa.av.a parama, int paramInt)
  {
    Context localContext = paramActivity.getApplicationContext();
    parama = a().a(paramActivity, parama);
    if (parama == null)
    {
      Toast.makeText(localContext, localContext.getString(2131918044), 1).show();
      return;
    }
    paramActivity.startActivityForResult(parama, paramInt);
  }
  
  void a(Context paramContext, Intent paramIntent, com.tencent.luggage.wxa.av.a parama)
  {
    a().a(paramContext, paramIntent, new e.3(this, parama));
  }
  
  void a(c paramc)
  {
    if (!f()) {
      return;
    }
    boolean bool1 = paramc.k();
    boolean bool2 = paramc.e();
    paramc = paramc.j();
    a(new e.1(this));
    this.a.a(bool1, bool2, paramc, new e.2(this));
  }
  
  void a(com.tencent.luggage.wxa.at.b paramb)
  {
    this.b = paramb;
  }
  
  void a(List<com.tencent.luggage.wxa.az.b> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j;
      for (int i = 0; i < paramList.size(); i = j + 1)
      {
        j = i;
        if (!new File(((com.tencent.luggage.wxa.az.b)paramList.get(i)).a()).exists())
        {
          paramList.remove(i);
          j = i - 1;
        }
      }
      ((g)d()).a(paramList);
    }
  }
  
  void b()
  {
    this.a.a();
  }
  
  void c()
  {
    a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.features.e
 * JD-Core Version:    0.7.0.1
 */