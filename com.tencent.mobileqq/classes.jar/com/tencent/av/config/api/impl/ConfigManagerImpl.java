package com.tencent.av.config.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.config.api.IConfigManager;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.avcore.config.ConfigInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ConfigManagerImpl
  implements IConfigManager
{
  private static final String TAG = "ConfigManagerImpl";
  private BroadcastReceiver mBroadcastReceiver = null;
  private IConfigParser mConfigBaseParser = null;
  private int mVersion = 0;
  
  public IConfigParser getConfigParser(Context paramContext)
  {
    if (this.mConfigBaseParser == null) {
      try
      {
        if (this.mConfigBaseParser == null)
        {
          String str = ConfigInfo.getSharpConfigPayloadFromFile(paramContext);
          this.mVersion = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
          paramContext = (IConfigParser)QRoute.api(IConfigParser.class);
          paramContext.setData(str);
          this.mConfigBaseParser = paramContext;
          paramContext = new StringBuilder();
          paramContext.append("getParser, Version[");
          paramContext.append(this.mVersion);
          paramContext.append("], data[\n");
          paramContext.append(str);
          paramContext.append("\n]");
          QLog.w("ConfigManagerImpl", 1, paramContext.toString());
        }
      }
      finally {}
    }
    return this.mConfigBaseParser;
  }
  
  public void onCreate(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    localIntentFilter.addAction("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
    paramContext.registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
  
  public void onDestroy(Context paramContext)
  {
    BroadcastReceiver localBroadcastReceiver = this.mBroadcastReceiver;
    if (localBroadcastReceiver != null)
    {
      paramContext.unregisterReceiver(localBroadcastReceiver);
      this.mBroadcastReceiver = null;
    }
  }
  
  void reload(Context paramContext)
  {
    if (this.mConfigBaseParser == null) {
      return;
    }
    int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
    if ((this.mVersion != i) || (this.mConfigBaseParser.isEmpty())) {
      try
      {
        paramContext = new StringBuilder();
        paramContext.append("reload, Version[");
        paramContext.append(this.mVersion);
        paramContext.append("->");
        paramContext.append(i);
        paramContext.append("]");
        QLog.w("ConfigManagerImpl", 1, paramContext.toString());
        this.mConfigBaseParser = null;
        this.mVersion = 0;
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.impl.ConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */