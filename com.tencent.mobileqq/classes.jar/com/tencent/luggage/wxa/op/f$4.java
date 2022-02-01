package com.tencent.luggage.wxa.op;

import android.media.AudioManager;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.lp.b.a;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.lp.j.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.mm.plugin.appbrand.widget.e;

class f$4
  implements j.a
{
  f$4(f paramf) {}
  
  private void a(String paramString)
  {
    if (f.x(this.a))
    {
      o.e(f.a(this.a), paramString);
      f.z(this.a).abandonAudioFocus(f.y(this.a));
      f.i(this.a, false);
    }
    f.g(this.a, true);
  }
  
  private void a(boolean paramBoolean)
  {
    f.j(this.a).post(new f.4.6(this, paramBoolean));
  }
  
  public void a(@NonNull j paramj)
  {
    paramj = paramj.a();
    String str = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoading, key: ");
    localStringBuilder.append(paramj);
    o.d(str, localStringBuilder.toString());
    if ((f.q(this.a) != null) && (f.q(this.a).equals(paramj)) && (f.j(this.a) != null)) {
      f.j(this.a).post(new f.4.1(this));
    }
  }
  
  public void a(@NonNull j paramj, float paramFloat)
  {
    paramj = paramj.a();
    if ((f.q(this.a) != null) && (f.q(this.a).equals(paramj)) && (f.d(this.a) != null) && (f.j(this.a) != null))
    {
      boolean bool = f.d(this.a).c;
      f.j(this.a).post(new f.4.4(this, bool, paramFloat));
    }
  }
  
  public void a(@NonNull j paramj, boolean paramBoolean)
  {
    String str2 = paramj.a();
    String str1 = f.a(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlay, key: ");
    ((StringBuilder)localObject).append(str2);
    o.d(str1, ((StringBuilder)localObject).toString());
    if (f.w(this.a))
    {
      o.d(f.a(this.a), "onPlay, runtime paused");
      return;
    }
    str1 = null;
    localObject = paramj.b();
    if (localObject != null)
    {
      f.a(this.a, ((Integer)localObject).intValue(), str2);
      paramj = f.b(this.a, ((Integer)localObject).intValue(), str2);
    }
    else
    {
      o.c(f.a(this.a), "onPlay, pageViewId is null");
      paramj = str1;
    }
    if ((f.e(this.a) != null) && (paramj != null) && (paramj.b != null) && (b.a.a != paramj.b)) {
      f.e(this.a).a(paramj.h, paramj.b);
    }
    if ((f.v(this.a)) && (f.q(this.a) != null) && (f.q(this.a).equals(str2)) && (f.j(this.a) != null))
    {
      o.d(f.a(this.a), "processTransferFromOnPlay for other video is playing");
      a(paramBoolean);
      return;
    }
    if ((f.q(this.a) != null) && (f.q(this.a).equals(str2)))
    {
      o.d(f.a(this.a), "onPlay, mark pip video play");
      com.tencent.luggage.wxa.rz.f.a.a(new f.4.3(this));
      f.g(this.a, false);
      if (!f.x(this.a))
      {
        o.e(f.a(this.a), "onPlay, requestAudioFocus");
        f.z(this.a).requestAudioFocus(f.y(this.a), 3, 1);
        f.i(this.a, true);
      }
      return;
    }
    if (localObject != null) {
      f.a(this.a, ((Integer)localObject).intValue(), str2, "onPlay");
    }
    if (((!f.c(this.a)) || (!f.u(this.a))) && (f.q(this.a) != null) && (f.j(this.a) != null)) {
      a(paramBoolean);
    }
  }
  
  public void b(@NonNull j paramj)
  {
    String str1 = paramj.a();
    String str2 = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadEnd, key: ");
    localStringBuilder.append(str1);
    o.d(str2, localStringBuilder.toString());
    if ((f.q(this.a) != null) && (f.q(this.a).equals(str1)) && (f.j(this.a) != null))
    {
      f.j(this.a).post(new f.4.2(this));
      paramj.f();
    }
  }
  
  public void c(@NonNull j paramj)
  {
    String str = paramj.a();
    Object localObject = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPause, key: ");
    localStringBuilder.append(str);
    o.d((String)localObject, localStringBuilder.toString());
    if (f.w(this.a))
    {
      o.d(f.a(this.a), "onPause, runtime paused");
      return;
    }
    if ((f.q(this.a) != null) && (f.q(this.a).equals(str)))
    {
      if (f.A(this.a))
      {
        paramj = f.a(this.a);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPause, key: ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(", mPipVideoPausedByMyself: true");
        o.d(paramj, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = f.a(this.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause, start key: ");
      localStringBuilder.append(str);
      o.d((String)localObject, localStringBuilder.toString());
      paramj.f();
      return;
    }
    paramj = paramj.b();
    if (paramj == null)
    {
      o.c(f.a(this.a), "onPause, pageViewId is null");
      return;
    }
    f.b(this.a, paramj.intValue(), str, "onPause");
  }
  
  public void d(@NonNull j paramj)
  {
    paramj = paramj.a();
    String str = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError, key: ");
    localStringBuilder.append(paramj);
    o.d(str, localStringBuilder.toString());
  }
  
  public void e(@NonNull j paramj)
  {
    String str1 = paramj.a();
    String str2 = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop, key: ");
    localStringBuilder.append(str1);
    o.d(str2, localStringBuilder.toString());
    if ((f.q(this.a) != null) && (f.q(this.a).equals(str1)) && (f.j(this.a) != null)) {
      a("onStop, abandonAudioFocus");
    }
    paramj = paramj.b();
    if (paramj != null)
    {
      f.c(this.a, paramj.intValue(), str1);
      if ((f.q(this.a) == null) || (!f.q(this.a).equals(str1))) {
        f.b(this.a, paramj.intValue(), str1, "onStop");
      }
    }
    else
    {
      o.c(f.a(this.a), "onStop, pageViewId is null");
    }
  }
  
  public void f(@NonNull j paramj)
  {
    paramj = paramj.a();
    String str = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayEndSoon, key: ");
    localStringBuilder.append(paramj);
    o.e(str, localStringBuilder.toString());
  }
  
  public void g(@NonNull j paramj)
  {
    String str1 = paramj.a();
    String str2 = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayEnd, key: ");
    localStringBuilder.append(str1);
    o.d(str2, localStringBuilder.toString());
    if ((f.q(this.a) != null) && (f.q(this.a).equals(str1)) && (f.j(this.a) != null)) {
      a("onPlayEnd, abandonAudioFocus");
    }
    paramj = paramj.b();
    if (paramj != null)
    {
      f.c(this.a, paramj.intValue(), str1);
      if ((f.q(this.a) == null) || (!f.q(this.a).equals(str1))) {
        f.b(this.a, paramj.intValue(), str1, "onPlayEnd");
      }
    }
    else
    {
      o.c(f.a(this.a), "onPlayEnd, pageViewId is null");
    }
    if (f.l(this.a) != null) {
      com.tencent.luggage.wxa.rz.f.a.a(new f.4.5(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.4
 * JD-Core Version:    0.7.0.1
 */