package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.business.MsfServletProxy;
import com.tencent.av.screenshare.ScreenShareHandler;
import com.tencent.av.wtogether.WTogetherHandler;

public class BusinessHandlerFactory
{
  public static final String a = AudioTransClientInterfaceHandlerExtend.class.getName();
  public static final String b = AudioTransClientInfoHandlerExtend.class.getName();
  public static final String c = WTogetherHandler.class.getName();
  public static final String d = ScreenShareHandler.class.getName();
  
  public void a(MsfServletProxy paramMsfServletProxy)
  {
    paramMsfServletProxy.a("TransInfoCreate.CreateSession", new String[] { b });
    paramMsfServletProxy.a("TransInfo.JoinSession", new String[] { a });
    paramMsfServletProxy.a("TransInfo.ExitSession", new String[] { a });
    paramMsfServletProxy.a("TransInfo.ChangeSession", new String[] { a });
    paramMsfServletProxy.a("TransInfo.RawData", new String[] { a });
    String[] arrayOfString = WTogetherHandler.a();
    int j;
    int i;
    String str;
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          paramMsfServletProxy.a(str, new String[] { c }, true);
        }
        i += 1;
      }
    }
    arrayOfString = ScreenShareHandler.a();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          paramMsfServletProxy.a(str, new String[] { d }, true);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.BusinessHandlerFactory
 * JD-Core Version:    0.7.0.1
 */