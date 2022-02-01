package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

public class i
  implements Callable<AAIDResult>
{
  private Context a;
  
  public i(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public AAIDResult call()
  {
    if (this.a == null) {
      throw a.a(a.v);
    }
    String str = n.b(this.a);
    AAIDResult localAAIDResult = new AAIDResult();
    localAAIDResult.setId(str);
    return localAAIDResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.i
 * JD-Core Version:    0.7.0.1
 */