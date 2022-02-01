package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.UnsupportedEncodingException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/BarrageConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "p0", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BarrageConfigHandler
  extends SimpleConfigHandler
{
  public static final BarrageConfigHandler.Companion a = new BarrageConfigHandler.Companion(null);
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    try
    {
      paramString = AladdinParseUtils.a(paramString);
      paramString = new GsonBuilder().create().toJson(paramString);
      if (paramString != null) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BarrageConfigHandler", 2, "onReceiveConfig configJson:" + paramString);
        }
        ReadInJoyHelper.n(paramString);
        break;
        paramString = "";
      }
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.e("BarrageConfigHandler", 2, "[PersonalHomePageConfigHandler]: onReceiveConfig Error in:" + paramString);
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.n("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.BarrageConfigHandler
 * JD-Core Version:    0.7.0.1
 */