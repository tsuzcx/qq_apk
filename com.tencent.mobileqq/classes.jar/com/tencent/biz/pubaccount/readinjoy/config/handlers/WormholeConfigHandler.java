package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WormholeConfigHandler
  extends SimpleConfigHandler
{
  private static void a(int paramInt)
  {
    QLog.d("WormholeConfigHandler", 0, "update wormhole value: " + paramInt);
    ReadInJoyHelper.a("wormhole_open", Integer.valueOf(paramInt));
  }
  
  public static boolean a()
  {
    return ((Integer)ReadInJoyHelper.a("wormhole_open", Integer.valueOf(0))).intValue() == 1;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("WormholeConfigHandler", 0, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    try
    {
      paramString = AladdinParseUtils.a(paramString);
      Iterator localIterator = paramString.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramString.get(str1);
        if (TextUtils.equals(str1, "open")) {
          a(Integer.parseInt(str2));
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.d("WormholeConfigHandler", 0, "parse wormhole error: " + paramString.getMessage());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.WormholeConfigHandler
 * JD-Core Version:    0.7.0.1
 */