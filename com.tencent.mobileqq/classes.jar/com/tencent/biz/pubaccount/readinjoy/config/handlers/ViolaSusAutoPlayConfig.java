package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ViolaSusAutoPlayConfig
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("ViolaSusAutoPlayConfig", 1, "[onReceiveConfig] " + paramString);
    for (;;)
    {
      String str1;
      try
      {
        paramString = AladdinParseUtils.a(paramString);
        Iterator localIterator = paramString.keySet().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          String str2 = (String)paramString.get(str1);
          if (!TextUtils.isEmpty(str2))
          {
            QLog.d("ViolaSusAutoPlayConfig", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
            if (!TextUtils.equals(str1, "autoplay_disable")) {
              continue;
            }
            ReadInJoyHelper.o(Integer.parseInt(str2));
          }
        }
        else
        {
          return true;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ViolaSusAutoPlayConfig", 2, "error in parse video_feeds_Type config: " + paramString.getMessage());
        }
      }
      QLog.d("ViolaSusAutoPlayConfig", 2, "key: " + str1 + " of value is null");
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.o(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaSusAutoPlayConfig
 * JD-Core Version:    0.7.0.1
 */