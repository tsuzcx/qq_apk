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
  public static final AtomicBoolean a;
  private static long[] a;
  private static long[] b;
  private static volatile long[] c;
  private static volatile long[] d;
  private static volatile long[] e;
  private static volatile long[] f;
  private static volatile long[] g;
  private static volatile long[] h;
  private static volatile long[] i;
  private static volatile long[] j;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 2355000000L, 2880000000L, 2885000000L, 2850121000L, 2852200000L, 3001000000L, 3003000000L, 3003400000L, 3006000000L };
    b = new long[] { 2355999999L, 2881999999L, 2885999999L, 2851999999L, 2854120999L, 3002999999L, 3003399999L, 3005999999L, 3008999999L };
    c = null;
    d = null;
    e = new long[] { 2852200000L };
    f = new long[] { 2852999999L };
    g = new long[] { 1496000000L };
    h = new long[] { 1497000000L };
    i = new long[] { 2852000000L, 3003000000L };
    j = new long[] { 2852199999L, 3003000000L };
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private static void a()
  {
    if ((c == null) || (d == null))
    {
      c = jdField_a_of_type_ArrayOfLong;
      d = b;
    }
    if ((e == null) || (f == null))
    {
      e = new long[] { 2852200000L };
      f = new long[] { 2852999999L };
    }
  }
  
  private static void a(int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null)) {}
    do
    {
      return;
      if (1 == paramInt) {
        try
        {
          c = paramArrayOfLong1;
          d = paramArrayOfLong2;
          return;
        }
        finally {}
      }
      if (2 == paramInt) {
        try
        {
          e = paramArrayOfLong1;
          f = paramArrayOfLong2;
          return;
        }
        finally {}
      }
    } while (3 != paramInt);
    try
    {
      g = paramArrayOfLong1;
      h = paramArrayOfLong2;
      return;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = null;
    try
    {
      String str = SharedPreUtils.c(paramContext);
      localObject = str;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    SharedPreUtils.c(paramContext, "");
    if (!TextUtils.isEmpty(localObject))
    {
      a(SecurityUtile.decode(localObject));
      a(localObject, true);
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
      try
      {
        paramContext = (EqqDetailDataManager)BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
        if (paramContext != null) {
          a(paramContext.a(), false);
        }
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static void a(String paramString)
  {
    EqqDetailDataManager localEqqDetailDataManager;
    if (a(paramString, false))
    {
      localEqqDetailDataManager = (EqqDetailDataManager)BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
      if (localEqqDetailDataManager == null) {
        break label48;
      }
      if (!TextUtils.isEmpty(paramString)) {
        break label42;
      }
      localEqqDetailDataManager.a("");
    }
    label42:
    label48:
    while (!QLog.isColorLevel())
    {
      return;
      localEqqDetailDataManager.a(paramString);
      return;
    }
    QLog.d("BmqqSegmentUtil", 2, "EqqDetailDataManager is null");
  }
  
  private static void a(Element paramElement, int paramInt)
  {
    Object localObject1 = null;
    NodeList localNodeList;
    if (paramElement != null)
    {
      localNodeList = paramElement.getElementsByTagName("segment");
      int m = localNodeList.getLength();
      if (m > 0)
      {
        localObject1 = new long[m];
        paramElement = new long[m];
        int k = 0;
        while (k < m)
        {
          Object localObject2 = (Element)localNodeList.item(k);
          String str;
          if (localObject2 != null)
          {
            str = ((Element)localObject2).getAttribute("start");
            localObject2 = ((Element)localObject2).getAttribute("end");
          }
          try
          {
            long l1 = Long.valueOf(str.trim()).longValue();
            long l2 = Long.valueOf(((String)localObject2).trim()).longValue();
            localObject1[k] = l1;
            paramElement[k] = l2;
          }
          catch (Exception localException)
          {
            break label122;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label122:
            break label122;
          }
          k += 1;
        }
      }
    }
    for (;;)
    {
      a(paramInt, (long[])localObject1, paramElement);
      return;
      localNodeList = null;
      paramElement = (Element)localObject1;
      localObject1 = localNodeList;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (!a(paramString)) {}
    for (;;)
    {
      return false;
      if ((!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramContext != null)) {
        a(paramContext);
      }
      long l = Long.valueOf(paramString).longValue();
      if ((c == null) || (d == null)) {
        a();
      }
      int m;
      int k;
      if ((c != null) && (d != null) && (c.length == d.length))
      {
        m = c.length;
        k = 0;
        while (k < m)
        {
          if ((c[k] <= l) && (l <= d[k])) {
            return true;
          }
          k += 1;
        }
      }
      if ((c != null) && (c.length != jdField_a_of_type_ArrayOfLong.length))
      {
        m = jdField_a_of_type_ArrayOfLong.length;
        k = 0;
        while (k < m)
        {
          if ((jdField_a_of_type_ArrayOfLong[k] <= l) && (l <= b[k])) {
            return true;
          }
          k += 1;
        }
      }
    }
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
    catch (NumberFormatException paramString)
    {
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramString != null)
    {
      String str = paramString.trim();
      if ("".equals(str)) {
        return true;
      }
      try
      {
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder();
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
          catch (SAXException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              paramBoolean = false;
              paramString = localObject2;
            }
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              paramBoolean = false;
              paramString = localObject2;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              paramBoolean = false;
              paramString = localObject2;
            }
          }
          if (paramString != null)
          {
            a((Element)paramString.getElementsByTagName("hrtx-uin-segment").item(0), 1);
            a((Element)paramString.getElementsByTagName("crm3-ext-uin-segment").item(0), 2);
            a((Element)paramString.getElementsByTagName("crm3-wx-map-uin-segment").item(0), 3);
          }
          return paramBoolean;
        }
      }
      catch (ParserConfigurationException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
    return true;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if (!a(paramString)) {}
    for (;;)
    {
      return false;
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a(paramContext);
      }
      long l = Long.valueOf(paramString).longValue();
      if ((e == null) || (f == null)) {
        a();
      }
      if ((e != null) && (f != null) && (e.length == f.length))
      {
        int m = e.length;
        int k = 0;
        while (k < m)
        {
          if ((e[k] <= l) && (l <= f[k])) {
            return true;
          }
          k += 1;
        }
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    if (!a(paramString)) {}
    while (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    return a(null, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.bmqq.util.BmqqSegmentUtil
 * JD-Core Version:    0.7.0.1
 */