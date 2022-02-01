package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class OnlineDatingAction
  extends JumpAction
{
  public OnlineDatingAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = b();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("OnlineDatingAction", 1, localStringBuilder.toString());
      h_("OnlineDatingAction");
    }
    return false;
  }
  
  public boolean b()
  {
    String str7 = (String)this.f.get("roomid");
    String str6 = (String)this.f.get("fromid");
    boolean bool = TextUtils.isEmpty((CharSequence)this.f.get("vasname"));
    String str5 = "";
    String str2;
    if (!bool) {
      try
      {
        String str1 = URLDecoder.decode((String)this.f.get("vasname"), "utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        localUnsupportedEncodingException1.printStackTrace();
      }
    } else {
      str2 = "";
    }
    String str3 = str5;
    String str4;
    if (!TextUtils.isEmpty((CharSequence)this.f.get("userdata"))) {
      try
      {
        str3 = URLDecoder.decode((String)this.f.get("vasname"), "utf-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localUnsupportedEncodingException2.printStackTrace();
        str4 = str5;
      }
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(str7);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      for (;;)
      {
        localNumberFormatException1.printStackTrace();
      }
    }
    int i;
    try
    {
      i = Integer.parseInt(str6);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      localNumberFormatException2.printStackTrace();
      i = 0;
    }
    ((ODProxy)this.a.getManager(QQManagerFactory.ODPROXY_MGR)).a(this.b, l1, "launcher", str2, str4, i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.OnlineDatingAction
 * JD-Core Version:    0.7.0.1
 */