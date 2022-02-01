package com.tencent.luggage.wxa.gd;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.fy.c;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.i.a;
import com.tencent.luggage.wxa.nf.j;

final class f
  extends c<j, View>
{
  private i.a<j, View> a = new f.1(this);
  @NonNull
  private final d b;
  @NonNull
  private final e c;
  
  public f(@NonNull d paramd)
  {
    super(paramd);
    this.b = paramd;
    this.c = new e(paramd);
  }
  
  @NonNull
  public h a()
  {
    return this.c.a();
  }
  
  @NonNull
  public i.a<j, View> b()
  {
    return this.a;
  }
  
  @NonNull
  public com.tencent.luggage.wxa.lp.d c()
  {
    return this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.f
 * JD-Core Version:    0.7.0.1
 */