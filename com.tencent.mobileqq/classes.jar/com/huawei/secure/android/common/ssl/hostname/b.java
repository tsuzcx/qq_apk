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
  private static final Pattern aa = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  private static final String[] ab = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org" };
  
  static
  {
    Arrays.sort(ab);
  }
  
  public static final void a(String paramString, X509Certificate paramX509Certificate, boolean paramBoolean)
  {
    String[] arrayOfString = getCNs(paramX509Certificate);
    paramX509Certificate = getDNSSubjectAlts(paramX509Certificate);
    g.b("", "cn is : " + Arrays.toString(arrayOfString));
    g.b("", "san is : " + Arrays.toString(paramX509Certificate));
    verify(paramString, arrayOfString, paramX509Certificate, paramBoolean);
  }
  
  public static boolean acceptableCountryWildcard(String paramString)
  {
    int i = paramString.length();
    if ((i >= 7) && (i <= 9) && (paramString.charAt(i - 3) == '.')) {
      paramString = paramString.substring(2, i - 3);
    }
    return Arrays.binarySearch(ab, paramString) < 0;
  }
  
  public static int countDots(String paramString)
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
  
  public static String[] getCNs(X509Certificate paramX509Certificate)
  {
    paramX509Certificate = new a(paramX509Certificate.getSubjectX500Principal()).a("cn");
    if (!paramX509Certificate.isEmpty())
    {
      String[] arrayOfString = new String[paramX509Certificate.size()];
      paramX509Certificate.toArray(arrayOfString);
      return arrayOfString;
    }
    return null;
  }
  
  public static String[] getDNSSubjectAlts(X509Certificate paramX509Certificate)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
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
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      for (;;)
      {
        g.a("", "Error parsing certificate.", paramX509Certificate);
        paramX509Certificate = null;
      }
      if (!localLinkedList.isEmpty())
      {
        paramX509Certificate = new String[localLinkedList.size()];
        localLinkedList.toArray(paramX509Certificate);
        return paramX509Certificate;
      }
    }
    return null;
  }
  
  private static boolean isIPv4Address(String paramString)
  {
    return aa.matcher(paramString).matches();
  }
  
  public static final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean)
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
    if (((LinkedList)localObject).isEmpty()) {
      throw new SSLException("Certificate for <" + paramString + "> doesn't contain CN or DNS subjectAlt");
    }
    paramArrayOfString1 = new StringBuffer();
    paramArrayOfString2 = paramString.trim().toLowerCase(Locale.ENGLISH);
    localObject = ((LinkedList)localObject).iterator();
    boolean bool2 = false;
    boolean bool1 = bool2;
    String str;
    if (((Iterator)localObject).hasNext())
    {
      str = ((String)((Iterator)localObject).next()).toLowerCase(Locale.ENGLISH);
      paramArrayOfString1.append(" <");
      paramArrayOfString1.append(str);
      paramArrayOfString1.append('>');
      if (((Iterator)localObject).hasNext()) {
        paramArrayOfString1.append(" OR");
      }
      if ((!str.startsWith("*.")) || (str.indexOf('.', 2) == -1) || (!acceptableCountryWildcard(str)) || (isIPv4Address(paramString))) {
        break label356;
      }
      i = 1;
      label255:
      if (i == 0) {
        break label368;
      }
      bool2 = paramArrayOfString2.endsWith(str.substring(1));
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramBoolean)
        {
          if (countDots(paramArrayOfString2) != countDots(str)) {
            break label362;
          }
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      if (bool1) {
        return;
      }
      throw new SSLException("hostname in certificate didn't match: <" + paramString + "> !=" + paramArrayOfString1);
      label356:
      i = 0;
      break label255;
      label362:
      bool1 = false;
      continue;
      label368:
      bool1 = paramArrayOfString2.equals(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.hostname.b
 * JD-Core Version:    0.7.0.1
 */