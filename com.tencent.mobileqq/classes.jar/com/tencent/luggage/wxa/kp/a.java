package com.tencent.luggage.wxa.kp;

import android.util.SparseArray;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;

public class a
{
  private boolean a = true;
  private boolean b = true;
  private SparseArray<WeakReference<e>> c = new SparseArray();
  
  public static a a()
  {
    return a.a.a();
  }
  
  public e a(int paramInt)
  {
    int i = this.c.indexOfKey(paramInt);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      WeakReference localWeakReference = (WeakReference)this.c.get(paramInt);
      localObject1 = localObject2;
      if (localWeakReference != null) {
        localObject1 = (e)localWeakReference.get();
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt, e parame)
  {
    this.c.put(paramInt, new WeakReference(parame));
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if (this.c.indexOfKey(paramInt) >= 0)
    {
      Object localObject = (WeakReference)this.c.get(paramInt);
      if (localObject != null)
      {
        localObject = (e)((WeakReference)localObject).get();
        if (localObject != null) {
          ((e)localObject).g();
        } else {
          o.d("MicroMsg.AppBrandCameraMrg", "release a recycled camera instance");
        }
      }
      else
      {
        o.d("MicroMsg.AppBrandCameraMrg", "release client fail, weak reference not exist");
      }
      if (paramBoolean) {
        this.c.remove(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b(int paramInt)
  {
    return a(paramInt, true);
  }
  
  public int[] b()
  {
    Object localObject = this.c;
    int i = 0;
    if ((localObject != null) && (((SparseArray)localObject).size() != 0))
    {
      localObject = new int[this.c.size()];
      while (i < this.c.size())
      {
        localObject[i] = this.c.keyAt(i);
        i += 1;
      }
      return localObject;
    }
    return new int[0];
  }
  
  public boolean c()
  {
    if (!this.a) {
      o.d("MicroMsg.AppBrandCameraMrg", "no camera permission");
    }
    return this.a;
  }
  
  public boolean d()
  {
    if ((!this.a) || (!this.b)) {
      o.d("MicroMsg.AppBrandCameraMrg", "no all permission");
    }
    return (this.a) && (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.a
 * JD-Core Version:    0.7.0.1
 */