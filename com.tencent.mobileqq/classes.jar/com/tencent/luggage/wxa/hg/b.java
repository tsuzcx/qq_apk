package com.tencent.luggage.wxa.hg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

@TargetApi(8)
public class b
  implements a.b
{
  private Context a;
  private AudioManager b;
  private a.a c;
  private AudioManager.OnAudioFocusChangeListener d = new b.1(this);
  
  public b(Context paramContext)
  {
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = r.a();
    }
    this.a = localContext;
  }
  
  public void a(a.a parama)
  {
    this.c = parama;
  }
  
  public boolean a()
  {
    if (this.b == null)
    {
      localObject = this.a;
      if (localObject != null) {
        this.b = ((AudioManager)((Context)localObject).getSystemService("audio"));
      }
    }
    Object localObject = this.b;
    boolean bool;
    if ((localObject != null) && (1 == ((AudioManager)localObject).requestAudioFocus(this.d, 3, 2))) {
      bool = true;
    } else {
      bool = false;
    }
    o.h("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.d.hashCode()) });
    return bool;
  }
  
  public boolean b()
  {
    if (this.b == null)
    {
      localObject = this.a;
      if (localObject != null) {
        this.b = ((AudioManager)((Context)localObject).getSystemService("audio"));
      }
    }
    Object localObject = this.b;
    boolean bool;
    if ((localObject != null) && (1 == ((AudioManager)localObject).abandonAudioFocus(this.d))) {
      bool = true;
    } else {
      bool = false;
    }
    o.h("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.d.hashCode()) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hg.b
 * JD-Core Version:    0.7.0.1
 */