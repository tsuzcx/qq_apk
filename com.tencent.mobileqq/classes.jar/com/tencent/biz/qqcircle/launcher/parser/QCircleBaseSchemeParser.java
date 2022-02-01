package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import java.util.HashMap;

public abstract class QCircleBaseSchemeParser
{
  private String a(String paramString)
  {
    int i = paramString.hashCode();
    if (i != 1567)
    {
      if (i != 48690)
      {
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            break;
          case 57: 
            if (!paramString.equals("9")) {
              break;
            }
            i = 6;
            break;
          case 56: 
            if (!paramString.equals("8")) {
              break;
            }
            i = 2;
            break;
          case 55: 
            if (!paramString.equals("7")) {
              break;
            }
            i = 5;
            break;
          case 54: 
            if (!paramString.equals("6")) {
              break;
            }
            i = 4;
          }
          break;
        case 51: 
          if (!paramString.equals("3")) {
            break;
          }
          i = 3;
          break;
        case 50: 
          if (!paramString.equals("2")) {
            break;
          }
          i = 1;
          break;
        case 49: 
          if (!paramString.equals("1")) {
            break;
          }
          i = 0;
          break;
        }
      }
      else if (paramString.equals("123"))
      {
        i = 8;
        break label210;
      }
    }
    else if (paramString.equals("10"))
    {
      i = 7;
      break label210;
    }
    i = -1;
    switch (i)
    {
    default: 
      return paramString;
    case 8: 
      return "123";
    case 6: 
    case 7: 
      return "11";
    case 5: 
      return "6";
    case 4: 
      return "14";
    case 3: 
      return "1";
    case 1: 
    case 2: 
      label210:
      return "13";
    }
    return "12";
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return paramString1;
    }
    if (paramString2.contains("openmainpage")) {
      return "1";
    }
    if (paramString2.contains("opendetail")) {
      return "2";
    }
    if (paramString2.contains("opentag")) {}
    do
    {
      return "3";
      if (paramString2.contains("openpymk")) {
        return "4";
      }
    } while (paramString2.contains("opencirclesearch"));
    return paramString1;
  }
  
  private String b(String paramString)
  {
    int i = paramString.hashCode();
    String str = "5";
    if (i != 1598)
    {
      if (i != 1602)
      {
        switch (i)
        {
        default: 
          break;
        case 53: 
          if (!paramString.equals("5")) {
            break;
          }
          i = 2;
          break;
        case 52: 
          if (!paramString.equals("4")) {
            break;
          }
          i = 1;
          break;
        case 51: 
          if (!paramString.equals("3")) {
            break;
          }
          i = 0;
          break;
        }
      }
      else if (paramString.equals("24"))
      {
        i = 4;
        break label123;
      }
    }
    else if (paramString.equals("20"))
    {
      i = 3;
      break label123;
    }
    i = -1;
    label123:
    if (i != 0)
    {
      if (i != 1)
      {
        paramString = str;
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return "";
            }
            return "11";
          }
          return "12";
        }
      }
      else
      {
        return "4";
      }
    }
    else {
      paramString = "3";
    }
    return paramString;
  }
  
  private String c(String paramString)
  {
    int i = paramString.hashCode();
    String str = "4";
    if (i != 1598)
    {
      if (i != 1602)
      {
        switch (i)
        {
        default: 
          break;
        case 53: 
          if (!paramString.equals("5")) {
            break;
          }
          i = 2;
          break;
        case 52: 
          if (!paramString.equals("4")) {
            break;
          }
          i = 1;
          break;
        case 51: 
          if (!paramString.equals("3")) {
            break;
          }
          i = 0;
          break;
        }
      }
      else if (paramString.equals("24"))
      {
        i = 4;
        break label123;
      }
    }
    else if (paramString.equals("20"))
    {
      i = 3;
      break label123;
    }
    i = -1;
    label123:
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        paramString = str;
        if (i != 3)
        {
          paramString = str;
          if (i != 4) {
            return "";
          }
        }
      }
      else
      {
        return "1";
      }
    }
    else {
      paramString = "0";
    }
    return paramString;
  }
  
  private void c(QCircleInitBean paramQCircleInitBean, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    paramHashMap = (String)paramHashMap.get("xsj_main_entrance");
    boolean bool;
    if ((!"qzone".equals(paramHashMap)) && (!"qq_aio".equals(paramHashMap)) && (!"qq_profile".equals(paramHashMap)) && (!"wechat".equals(paramHashMap)) && (!"qq_searchbar_results".equals(paramHashMap))) {
      bool = false;
    } else {
      bool = true;
    }
    paramQCircleInitBean.setNeedShowGoHomeButton(bool);
  }
  
  public abstract void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean);
  
  protected void a(QCircleInitBean paramQCircleInitBean, HashMap<String, String> paramHashMap)
  {
    if ((paramQCircleInitBean != null) && (paramHashMap != null))
    {
      String str3 = (String)paramHashMap.get("key_jump_from");
      String str1 = (String)paramHashMap.get(QCircleReportFirstLogin.SHARE_CATEGORY);
      String str4 = (String)paramHashMap.get(QCircleReportFirstLogin.SHARE_ENTRANCE);
      String str2 = "";
      if ((str1 != null) && (str4 != null))
      {
        str2 = a(str4);
      }
      else if (str3 != null)
      {
        str2 = b(str3);
        str1 = c(str3);
      }
      else
      {
        str3 = (String)paramHashMap.get("from");
        if ("10".equals(str3))
        {
          str1 = "0";
          str2 = "10";
        }
        else if ("1".equals(str3))
        {
          str1 = a("", (String)paramHashMap.get("key_scheme"));
          str2 = "1";
        }
        else
        {
          str1 = "";
        }
      }
      if (("3".equals(str3)) || ("4".equals(str3)) || ("10".equals(str3)) || ((TextUtils.equals(str2, "6")) && (TextUtils.equals(str1, "1")))) {
        paramQCircleInitBean.setEnableSplash(true);
      }
      paramQCircleInitBean.setLaunchFrom(str2);
      paramQCircleInitBean.setLaunchId(str1);
      paramQCircleInitBean.setSchemeAttrs(paramHashMap);
      c(paramQCircleInitBean, paramHashMap);
      return;
    }
    QLog.e("QCircleBaseSchemeParser", 1, "parseLaunchFromParam failed!");
  }
  
  protected void a(QCircleSchemeBean paramQCircleSchemeBean, QCircleInitBean paramQCircleInitBean)
  {
    if (paramQCircleSchemeBean != null)
    {
      if (paramQCircleInitBean == null) {
        return;
      }
      paramQCircleInitBean.setAction(paramQCircleSchemeBean.getSchemeAction());
      paramQCircleInitBean.setSchemeAttrs(paramQCircleSchemeBean.getAttrs());
      paramQCircleInitBean.setSchemeBytes(paramQCircleSchemeBean.getByteAttrs());
    }
  }
  
  protected void b(QCircleInitBean paramQCircleInitBean, HashMap<String, String> paramHashMap)
  {
    if ((paramQCircleInitBean != null) && (paramHashMap != null))
    {
      if (paramHashMap.containsKey("pushid")) {
        paramQCircleInitBean.setLaunchId((String)paramHashMap.get("pushid"));
      }
      return;
    }
    QLog.e("QCircleBaseSchemeParser", 1, "parsePushIdParam failed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleBaseSchemeParser
 * JD-Core Version:    0.7.0.1
 */