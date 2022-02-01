package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import com.tencent.mobileqq.api.IPhoneUnityInterface;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PhoneUnityProxy
  implements IPhoneUnityInterface
{
  @ConfigInject(configPath="Business/qqsafeblock-api/src/main/resources/Inject_SecurityBlockConfig.yml", version=1)
  protected static ArrayList<Class<? extends IPhoneUnityInterface>> a = new ArrayList();
  private IPhoneUnityInterface b;
  
  static
  {
    a.add(PhoneUnityImpl.class);
  }
  
  public PhoneUnityProxy()
  {
    try
    {
      this.b = ((IPhoneUnityInterface)((Class)a.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneUnityProxy", 1, "PhoneUnityProxy new instance error : ", localException);
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    return this.b.a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.PhoneUnityProxy
 * JD-Core Version:    0.7.0.1
 */