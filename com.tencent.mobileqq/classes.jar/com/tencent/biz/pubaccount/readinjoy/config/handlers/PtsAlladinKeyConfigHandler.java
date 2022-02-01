package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PtsAlladinKeyConfigHandler
  extends SimpleConfigHandler
{
  private static final Set<String> a = ;
  
  public static Set<String> a()
  {
    return a;
  }
  
  private static Set<String> b()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (String)ReadInJoyHelper.a("default_feeds_aladdin_keys", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localHashSet;
    }
    localObject = ((String)localObject).split("\\|");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(localObject[i]);
      i += 1;
    }
    return localHashSet;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("WhiteListBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = AladdinParseUtils.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("WhiteListBidConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      ReadInJoyHelper.a("default_feeds_aladdin_keys", str2);
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    QLog.d("WhiteListBidConfigHandler", 1, "[onWipeConfig]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.PtsAlladinKeyConfigHandler
 * JD-Core Version:    0.7.0.1
 */