package com.tencent.biz.bmqq.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class BmqqSegmentUtil
{
  public static final AtomicBoolean a = new AtomicBoolean(false);
  private static long[] b = { 2355000000L, 2880000000L, 2885000000L, 2850121000L, 2852200000L, 3001000000L, 3003000000L, 3003400000L, 3006000000L };
  private static long[] c = { 2355999999L, 2881999999L, 2885999999L, 2851999999L, 2854120999L, 3002999999L, 3003399999L, 3005999999L, 3008999999L };
  private static volatile long[] d = null;
  private static volatile long[] e = null;
  private static volatile long[] f = { 2852200000L };
  private static volatile long[] g = { 2852999999L };
  private static volatile long[] h = { 1496000000L };
  private static volatile long[] i = { 1497000000L };
  private static volatile long[] j = { 2852000000L, 3003000000L };
  private static volatile long[] k = { 2852199999L, 3003000000L };
  
  private static void a()
  {
    if ((d == null) || (e == null))
    {
      d = b;
      e = c;
    }
    if ((f == null) || (g == null))
    {
      f = new long[] { 2852200000L };
      g = new long[] { 2852999999L };
    }
  }
  
  private static void a(int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramArrayOfLong1 != null)
    {
      if (paramArrayOfLong2 == null) {
        return;
      }
      if (1 == paramInt) {
        try
        {
          d = paramArrayOfLong1;
          e = paramArrayOfLong2;
          return;
        }
        finally {}
      }
      if (2 == paramInt) {
        try
        {
          f = paramArrayOfLong1;
          g = paramArrayOfLong2;
          return;
        }
        finally {}
      }
      if (3 == paramInt) {
        try
        {
          h = paramArrayOfLong1;
          i = paramArrayOfLong2;
          return;
        }
        finally {}
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      str = SharedPreUtils.e(paramContext);
    }
    catch (Exception localException)
    {
      String str;
      label8:
      label68:
      break label8;
    }
    str = null;
    SharedPreUtils.f(paramContext, "");
    if (!TextUtils.isEmpty(str))
    {
      d(SecurityUtile.decode(str));
      a(str, true);
    }
    try
    {
      paramContext = (EqqDetailDataManager)BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
      if (paramContext != null) {
        a(paramContext.b(), false);
      }
    }
    catch (Exception paramContext)
    {
      break label68;
    }
    a.set(true);
  }
  
  private static void a(Element paramElement, int paramInt)
  {
    Object localObject = null;
    if (paramElement != null)
    {
      NodeList localNodeList = paramElement.getElementsByTagName("segment");
      int n = localNodeList.getLength();
      if (n > 0)
      {
        long[] arrayOfLong1 = new long[n];
        long[] arrayOfLong2 = new long[n];
        int m = 0;
        for (;;)
        {
          localObject = arrayOfLong1;
          paramElement = arrayOfLong2;
          if (m >= n) {
            break;
          }
          localObject = (Element)localNodeList.item(m);
          if (localObject != null)
          {
            paramElement = ((Element)localObject).getAttribute("start");
            localObject = ((Element)localObject).getAttribute("end");
          }
          try
          {
            long l1 = Long.valueOf(paramElement.trim()).longValue();
            long l2 = Long.valueOf(((String)localObject).trim()).longValue();
            arrayOfLong1[m] = l1;
            arrayOfLong2[m] = l2;
          }
          catch (NumberFormatException|Exception paramElement)
          {
            label129:
            break label129;
          }
          m += 1;
        }
      }
    }
    paramElement = null;
    a(paramInt, (long[])localObject, paramElement);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (!a(paramString)) {
      return false;
    }
    if ((!a.get()) && (paramContext != null)) {
      a(paramContext);
    }
    long l = Long.valueOf(paramString).longValue();
    if ((d == null) || (e == null)) {
      a();
    }
    int n;
    int m;
    if ((d != null) && (e != null) && (d.length == e.length))
    {
      n = d.length;
      m = 0;
      while (m < n)
      {
        if ((d[m] <= l) && (l <= e[m])) {
          return true;
        }
        m += 1;
      }
    }
    if (d != null)
    {
      m = d.length;
      paramContext = b;
      if (m != paramContext.length)
      {
        n = paramContext.length;
        m = 0;
        while (m < n)
        {
          if ((b[m] <= l) && (l <= c[m])) {
            return true;
          }
          m += 1;
        }
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException|Exception paramString) {}
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      String str = paramString.trim();
      if (!"".equals(str))
      {
        Object localObject2 = null;
        try
        {
          paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }
        catch (ParserConfigurationException paramString)
        {
          paramString.printStackTrace();
          paramString = null;
        }
        if (paramString != null)
        {
          Object localObject1 = str;
          if (paramBoolean) {
            localObject1 = SecurityUtile.decode(str);
          }
          localObject1 = new InputSource(new StringReader((String)localObject1));
          try
          {
            paramString = paramString.parse((InputSource)localObject1);
            paramBoolean = true;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
          }
          catch (SAXException paramString)
          {
            paramString.printStackTrace();
          }
          paramBoolean = false;
          paramString = localObject2;
          bool = paramBoolean;
          if (paramString == null) {
            return bool;
          }
          a((Element)paramString.getElementsByTagName("hrtx-uin-segment").item(0), 1);
          a((Element)paramString.getElementsByTagName("crm3-ext-uin-segment").item(0), 2);
          a((Element)paramString.getElementsByTagName("crm3-wx-map-uin-segment").item(0), 3);
          return paramBoolean;
        }
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if (!a(paramString)) {
      return false;
    }
    if (!a.get()) {
      a(paramContext);
    }
    long l = Long.valueOf(paramString).longValue();
    if ((f == null) || (g == null)) {
      a();
    }
    if ((f != null) && (g != null) && (f.length == g.length))
    {
      int n = f.length;
      int m = 0;
      while (m < n)
      {
        if ((f[m] <= l) && (l <= g[m])) {
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (!a(paramString)) {
      return false;
    }
    long l = Long.valueOf(paramString).longValue();
    if ((l >= 2355000000L) && (l <= 2355999999L)) {
      return true;
    }
    if ((l >= 2880000000L) && (l <= 2881999999L)) {
      return true;
    }
    if ((l >= 2885000000L) && (l <= 2885999999L)) {
      return true;
    }
    return (l >= 2850121000L) && (l <= 2854120999L);
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if (!a(paramString)) {
      return false;
    }
    if ((!a.get()) && (paramContext != null)) {
      a(paramContext);
    }
    if ((h != null) && (i != null) && (h.length == i.length))
    {
      int m = 0;
      while (m < h.length)
      {
        long l = Long.valueOf(paramString).longValue();
        if ((l >= h[m]) && (l <= i[m])) {
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
  
  public static boolean c(String paramString)
  {
    if (!a(paramString)) {
      return false;
    }
    if (!a.get()) {
      return false;
    }
    return a(null, paramString);
  }
  
  public static void d(String paramString)
  {
    if (a(paramString, false))
    {
      EqqDetailDataManager localEqqDetailDataManager = (EqqDetailDataManager)BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
      if (localEqqDetailDataManager != null)
      {
        if (TextUtils.isEmpty(paramString))
        {
          localEqqDetailDataManager.b("");
          return;
        }
        localEqqDetailDataManager.b(paramString);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BmqqSegmentUtil", 2, "EqqDetailDataManager is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.bmqq.util.BmqqSegmentUtil
 * JD-Core Version:    0.7.0.1
 */