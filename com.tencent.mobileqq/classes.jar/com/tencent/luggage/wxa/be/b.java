package com.tencent.luggage.wxa.be;

import android.content.Context;
import com.tencent.luggage.wxa.kp.j;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends a
{
  private List<Runnable> d;
  
  public b(Context paramContext)
  {
    super(paramContext);
    com.tencent.luggage.wxa.f.e.a(paramContext.getApplicationContext());
  }
  
  public static void o()
  {
    j.a(new b.1());
  }
  
  public float a(float paramFloat)
  {
    return 0.0F;
  }
  
  protected a.a a(String paramString)
  {
    return super.a(paramString);
  }
  
  protected d a(Context paramContext, int paramInt1, int paramInt2)
  {
    return new e(paramContext);
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    paramString = getOperateCallBack();
    if (paramString == null) {
      return;
    }
    d locald = getRecordView();
    if (locald == null)
    {
      o.c("MicroMsg.AppBrandCameraViewLU", "listenFrameChange recordView null");
      paramString.a("camera illegal state", -1, -1, -1);
      return;
    }
    paramc = new b.2(this, paramc, locald, paramString);
    if (!this.b)
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      this.d.add(paramc);
      return;
    }
    paramc.run();
  }
  
  protected void l()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Runnable)((Iterator)localObject).next()).run();
    }
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.b
 * JD-Core Version:    0.7.0.1
 */