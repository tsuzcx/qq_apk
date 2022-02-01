package com.tencent.mobileqq.app;

import android.os.Bundle;

public class SecSvcObserver
  implements BusinessObserver
{
  protected void a(int paramInt, Bundle paramBundle) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(int paramInt, Bundle paramBundle) {}
  
  protected void b(int paramInt, String paramString) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    Bundle localBundle = null;
    Object localObject1 = null;
    int i = -1;
    switch (paramInt)
    {
    default: 
      return;
    case 10: 
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 9: 
      a(paramObject);
      return;
    case 8: 
      localBundle = (Bundle)paramObject;
      paramObject = localObject1;
      if (localBundle != null)
      {
        i = localBundle.getInt("ret_code", -1);
        paramObject = localBundle.getString("err_msg");
      }
      b(i, paramObject);
      return;
    case 7: 
      localObject1 = (Bundle)paramObject;
      paramObject = localObject2;
      if (localObject1 != null)
      {
        i = ((Bundle)localObject1).getInt("ret_code", -1);
        paramObject = ((Bundle)localObject1).getString("err_msg");
      }
      a(i, paramObject);
      return;
    case 6: 
      b(paramBoolean, (Bundle)paramObject);
      return;
    case 5: 
      a(paramBoolean, (Bundle)paramObject);
      return;
    case 4: 
      if (paramBoolean)
      {
        localObject1 = (Bundle)paramObject;
        if (localObject1 != null)
        {
          i = ((Bundle)localObject1).getInt("index");
          paramObject = ((Bundle)localObject1).getByteArray("target_desc");
          localObject1 = ((Bundle)localObject1).getString("target_name");
          break label238;
        }
      }
      localObject1 = null;
      paramObject = localBundle;
      a(paramBoolean, i, paramObject, (String)localObject1);
      return;
    case 3: 
      paramInt = 0;
      if (paramBoolean)
      {
        paramObject = (Bundle)paramObject;
        if (paramObject != null)
        {
          paramInt = paramObject.getInt("status");
          paramObject = paramObject.getString("wording");
          break label284;
        }
      }
      paramObject = "";
      a(paramBoolean, paramInt, paramObject);
      return;
    case 2: 
      label238:
      b(paramInt, (Bundle)paramObject);
      label284:
      return;
    }
    a(paramInt, (Bundle)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcObserver
 * JD-Core Version:    0.7.0.1
 */