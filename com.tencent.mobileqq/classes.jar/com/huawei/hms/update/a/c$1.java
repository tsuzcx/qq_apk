package com.huawei.hms.update.a;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import java.io.File;

final class c$1
  implements b
{
  c$1(b paramb) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, File paramFile)
  {
    new Handler(Looper.getMainLooper()).post(new c.1.2(this, paramInt1, paramInt2, paramInt3, paramFile));
  }
  
  public void a(int paramInt, c paramc)
  {
    new Handler(Looper.getMainLooper()).post(new c.1.1(this, paramInt, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.a.c.1
 * JD-Core Version:    0.7.0.1
 */