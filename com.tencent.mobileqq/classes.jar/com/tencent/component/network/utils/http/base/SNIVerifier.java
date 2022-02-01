package com.tencent.component.network.utils.http.base;

import java.io.InputStream;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.security.auth.x500.X500Principal;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.conn.util.InetAddressUtils;

public class SNIVerifier
  implements X509HostnameVerifier
{
  private static final String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org" };
  
  static
  {
    Arrays.sort(BAD_COUNTRY_2LDS);
  }
  
  public static boolean acceptableCountryWildcard(String paramString)
  {
    paramString = paramString.split("\\.");
    int i = paramString.length;
    boolean bool = true;
    if (i == 3)
    {
      if (paramString[2].length() != 2) {
        return true;
      }
      if (Arrays.binarySearch(BAD_COUNTRY_2LDS, paramString[1]) < 0) {
        return true;
      }
      bool = false;
    }
    return bool;
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
    LinkedList localLinkedList = new LinkedList();
    paramX509Certificate = new StringTokenizer(paramX509Certificate.getSubjectX500Principal().toString(), ",");
    while (paramX509Certificate.hasMoreTokens())
    {
      String str = paramX509Certificate.nextToken().trim();
      if ((str.length() > 3) && (str.substring(0, 3).equalsIgnoreCase("CN="))) {
        localLinkedList.add(str.substring(3));
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
  
  public static String[] getDNSSubjectAlts(X509Certificate paramX509Certificate)
  {
    return getSubjectAlts(paramX509Certificate, null);
  }
  
  private static String[] getSubjectAlts(X509Certificate paramX509Certificate, String paramString)
  {
    int i;
    if (isIPAddress(paramString)) {
      i = 7;
    } else {
      i = 2;
    }
    paramString = new LinkedList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      label31:
      break label31;
    }
    paramX509Certificate = null;
    if (paramX509Certificate != null)
    {
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        List localList = (List)paramX509Certificate.next();
        if (((Integer)localList.get(0)).intValue() == i) {
          paramString.add((String)localList.get(1));
        }
      }
    }
    if (!paramString.isEmpty())
    {
      paramX509Certificate = new String[paramString.size()];
      paramString.toArray(paramX509Certificate);
      return paramX509Certificate;
    }
    return null;
  }
  
  private static boolean isIPAddress(String paramString)
  {
    return (paramString != null) && ((InetAddressUtils.isIPv4Address(paramString)) || (InetAddressUtils.isIPv6Address(paramString)));
  }
  
  public final void verify(String paramString, X509Certificate paramX509Certificate)
  {
    verify(paramString, getCNs(paramX509Certificate), getSubjectAlts(paramX509Certificate, paramString));
  }
  
  public final void verify(String paramString, SSLSocket paramSSLSocket)
  {
    if (paramString != null)
    {
      SniSSLSocketFactory.ensureSupportSNI(paramSSLSocket, paramString);
      SSLSession localSSLSession2 = paramSSLSocket.getSession();
      SSLSession localSSLSession1 = localSSLSession2;
      if (localSSLSession2 == null)
      {
        paramSSLSocket.getInputStream().available();
        localSSLSession2 = paramSSLSocket.getSession();
        localSSLSession1 = localSSLSession2;
        if (localSSLSession2 == null)
        {
          paramSSLSocket.startHandshake();
          localSSLSession1 = paramSSLSocket.getSession();
        }
      }
      verify(paramString, (X509Certificate)localSSLSession1.getPeerCertificates()[0]);
      return;
    }
    throw new NullPointerException("host to verify is null");
  }
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    verify(paramString, paramArrayOfString1, paramArrayOfString2, false);
  }
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean)
  {
    Object localObject1 = new LinkedList();
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0) && (paramArrayOfString1[0] != null)) {
      ((LinkedList)localObject1).add(paramArrayOfString1[0]);
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
          ((LinkedList)localObject1).add(paramArrayOfString1);
        }
        i += 1;
      }
    }
    if (!((LinkedList)localObject1).isEmpty())
    {
      paramArrayOfString1 = new StringBuilder();
      paramArrayOfString2 = paramString.trim().toLowerCase(Locale.US);
      localObject1 = ((LinkedList)localObject1).iterator();
      boolean bool2 = false;
      boolean bool1;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        String str1 = ((String)((Iterator)localObject1).next()).toLowerCase(Locale.US);
        paramArrayOfString1.append(" <");
        paramArrayOfString1.append(str1);
        paramArrayOfString1.append('>');
        if (((Iterator)localObject1).hasNext()) {
          paramArrayOfString1.append(" OR");
        }
        Object localObject2 = str1.split("\\.");
        if ((localObject2.length >= 3) && (localObject2[0].endsWith("*")) && (acceptableCountryWildcard(str1)) && (!isIPAddress(paramString))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          String str2 = localObject2[0];
          if (str2.length() > 1)
          {
            localObject2 = str2.substring(0, str2.length() - 1);
            str2 = str1.substring(str2.length());
            String str3 = paramArrayOfString2.substring(((String)localObject2).length());
            if ((paramArrayOfString2.startsWith((String)localObject2)) && (str3.endsWith(str2))) {
              bool1 = true;
            } else {
              bool1 = false;
            }
          }
          else
          {
            bool1 = paramArrayOfString2.endsWith(str1.substring(1));
          }
          bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (paramBoolean) {
              if (countDots(paramArrayOfString2) == countDots(str1)) {
                bool2 = true;
              } else {
                bool2 = false;
              }
            }
          }
          bool1 = bool2;
        }
        else
        {
          bool1 = paramArrayOfString2.equals(str1);
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
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return true;
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.base.SNIVerifier
 * JD-Core Version:    0.7.0.1
 */