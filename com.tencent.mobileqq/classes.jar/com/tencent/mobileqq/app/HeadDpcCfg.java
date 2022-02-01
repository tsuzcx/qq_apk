package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class HeadDpcCfg
{
  private static final String a = DPCNames.headDpcCfg.name();
  private static HeadDpcCfg c;
  private int b = 1;
  private DPCObserver d = new HeadDpcCfg.1(this);
  
  private HeadDpcCfg()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.d);
    b();
  }
  
  public static HeadDpcCfg a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new HeadDpcCfg();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void b()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(a);
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length >= 1) {
        try
        {
          this.b = Integer.valueOf(arrayOfString[0]).intValue();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadConfig exception :");
          localStringBuilder.append(localException.getMessage());
          QLog.d("HeadDpcCfg", 1, localStringBuilder.toString());
          this.b = 1;
        }
      }
    }
    else
    {
      this.b = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HeadDpcCfg", 2, String.format("loadConfig, mDualStackPrefIpv6: %s, dpc=%s", new Object[] { Integer.valueOf(this.b), str }));
    }
  }
  
  public boolean c()
  {
    QLog.d("HeadDpcCfg", 1, String.format("preferIpv6 mDualStackPrefIpv6=%d", new Object[] { Integer.valueOf(this.b) }));
    return this.b != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HeadDpcCfg
 * JD-Core Version:    0.7.0.1
 */