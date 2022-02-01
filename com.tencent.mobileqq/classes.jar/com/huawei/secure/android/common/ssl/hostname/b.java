package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.g;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;

public class b
{
  private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  private static final String[] b = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org" };
  
  static
  {
    Arrays.sort(b);
  }
  
  public static final void a(String paramString, X509Certificate paramX509Certificate, boolean paramBoolean)
  {
    String[] arrayOfString = a(paramX509Certificate);
    paramX509Certificate = b(paramX509Certificate);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cn is : ");
    localStringBuilder.append(Arrays.toString(arrayOfString));
    g.a("", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("san is : ");
    localStringBuilder.append(Arrays.toString(paramX509Certificate));
    g.a("", localStringBuilder.toString());
    a(paramString, arrayOfString, paramX509Certificate, paramBoolean);
  }
  
  public static final void a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean)
  {
    Object localObject = new LinkedList();
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0) && (paramArrayOfString1[0] != null)) {
      ((LinkedList)localObject).add(paramArrayOfString1[0]);
    }
    int i;
    if (paramArrayOfString2 != null)
    {
      int j = paramArrayOfString2.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfString1 = paramArrayOfString2[i];
        if (paramArrayOfString1 != null) {
          ((LinkedList)localObject).add(paramArrayOfString1);
        }
        i += 1;
      }
    }
    if (!((LinkedList)localObject).isEmpty())
    {
      paramArrayOfString1 = new StringBuffer();
      paramArrayOfString2 = paramString.trim().toLowerCase(Locale.ENGLISH);
      localObject = ((LinkedList)localObject).iterator();
      boolean bool2 = false;
      boolean bool1;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        String str = ((String)((Iterator)localObject).next()).toLowerCase(Locale.ENGLISH);
        paramArrayOfString1.append(" <");
        paramArrayOfString1.append(str);
        paramArrayOfString1.append('>');
        if (((Iterator)localObject).hasNext()) {
          paramArrayOfString1.append(" OR");
        }
        if ((str.startsWith("*.")) && (str.indexOf('.', 2) != -1) && (a(str)) && (!c(paramString))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          bool1 = paramArrayOfString2.endsWith(str.substring(1));
          if ((bool1) && (paramBoolean)) {
            if (b(paramArrayOfString2) == b(str)) {
              bool1 = true;
            } else {
              bool1 = false;
            }
          }
        }
        else
        {
          bool1 = paramArrayOfString2.equals(str);
        }
        bool2 = bool1;
      } while (!bool1);
      if (bool1) {
        return;
      }
      paramArrayOfString2 = new StringBuilder();
      paramArrayOfString2.append("hostname in certificate didn't match: <");
      paramArrayOfString2.append(paramString);
      paramArrayOfString2.append("> !=");
      paramArrayOfString2.append(paramArrayOfString1);
      throw new SSLException(paramArrayOfString2.toString());
    }
    paramArrayOfString1 = new StringBuilder();
    paramArrayOfString1.append("Certificate for <");
    paramArrayOfString1.append(paramString);
    paramArrayOfString1.append("> doesn't contain CN or DNS subjectAlt");
    paramString = new SSLException(paramArrayOfString1.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static boolean a(String paramString)
  {
    int i = paramString.length();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i >= 7)
    {
      bool1 = bool2;
      if (i <= 9)
      {
        i -= 3;
        bool1 = bool2;
        if (paramString.charAt(i) == '.')
        {
          paramString = paramString.substring(2, i);
          if (Arrays.binarySearch(b, paramString) < 0) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static String[] a(X509Certificate paramX509Certificate)
  {
    paramX509Certificate = new a(paramX509Certificate.getSubjectX500Principal()).b("cn");
    if (!paramX509Certificate.isEmpty())
    {
      String[] arrayOfString = new String[paramX509Certificate.size()];
      paramX509Certificate.toArray(arrayOfString);
      return arrayOfString;
    }
    return null;
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (paramString.charAt(i) == '.') {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static String[] b(X509Certificate paramX509Certificate)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      g.a("", "Error parsing certificate.", paramX509Certificate);
      paramX509Certificate = null;
    }
    if (paramX509Certificate != null)
    {
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        List localList = (List)paramX509Certificate.next();
        if (((Integer)localList.get(0)).intValue() == 2) {
          localLinkedList.add((String)localList.get(1));
        }
      }
    }
    if (!localLinkedList.isEmpty())
    {
      paramX509Certificate = new String[localLinkedList.size()];
      localLinkedList.toArray(paramX509Certificate);
      return paramX509Certificate;
    }
    return null;
  }
  
  private static boolean c(String paramString)
  {
    return a.matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.hostname.b
 * JD-Core Version:    0.7.0.1
 */