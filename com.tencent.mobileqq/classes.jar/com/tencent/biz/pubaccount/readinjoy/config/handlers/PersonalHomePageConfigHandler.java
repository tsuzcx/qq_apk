package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/PersonalHomePageConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PersonalHomePageConfigHandler
  extends SimpleConfigHandler
{
  public static final PersonalHomePageConfigHandler.Companion a = new PersonalHomePageConfigHandler.Companion(null);
  
  public PersonalHomePageConfigHandler()
  {
    ReadInJoyHelper.e();
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    try
    {
      Object localObject = AladdinParseUtils.a(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "configs");
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ("personal_page_url".equals(localEntry.getKey()))
        {
          ReadInJoyHelper.g(URLDecoder.decode((String)localEntry.getValue(), "UTF-8"));
          ReadInJoyHelper.e();
          continue;
          return true;
        }
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.e("PersonalHomePageConfigHandler", 2, "[PersonalHomePageConfigHandler]: URLDecoder Error in:" + paramString);
    }
    for (;;)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("PersonalHomePageConfigHandler", 2, "onReceiveConfig: content=" + paramString);
      }
      Aladdin.getConfig(paramInt1).update(paramString);
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.g("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.PersonalHomePageConfigHandler
 * JD-Core Version:    0.7.0.1
 */