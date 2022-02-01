package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

public class j
  implements Callable<AAIDResult>
{
  public Context a;
  
  public j(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public AAIDResult call()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = o.c((Context)localObject);
      AAIDResult localAAIDResult = new AAIDResult();
      localAAIDResult.setId((String)localObject);
      return localAAIDResult;
    }
    throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.j
 * JD-Core Version:    0.7.0.1
 */