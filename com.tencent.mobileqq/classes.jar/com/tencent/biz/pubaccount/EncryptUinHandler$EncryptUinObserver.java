package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

public abstract class EncryptUinHandler$EncryptUinObserver
  implements BusinessObserver
{
  protected abstract void a(boolean paramBoolean, List<EncryptUinInfo> paramList, Bundle paramBundle);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null) {}
    try
    {
      paramObject = (Bundle)paramObject;
      a(paramBoolean, paramObject.getParcelableArrayList("KEY_ENCRYPT_RESULT_LIST"), paramObject);
      return;
    }
    catch (Exception paramObject) {}
    a(false, null, new Bundle());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.EncryptUinHandler.EncryptUinObserver
 * JD-Core Version:    0.7.0.1
 */