package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import android.os.Bundle;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class b
{
  private static final String a = "b";
  private static final int b = 5;
  
  public static X509Certificate a(SslCertificate paramSslCertificate)
  {
    paramSslCertificate = SslCertificate.saveState(paramSslCertificate).getByteArray("x509-certificate");
    if (paramSslCertificate != null) {
      try
      {
        paramSslCertificate = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramSslCertificate));
        return paramSslCertificate;
      }
      catch (CertificateException paramSslCertificate)
      {
        g.a(a, "exception", paramSslCertificate);
      }
    }
    return null;
  }
  
  public static X509Certificate a(String paramString)
  {
    try
    {
      paramString = (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(paramString.getBytes()));
      return paramString;
    }
    catch (CertificateException paramString)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateX509FromStr: CertificateException");
      localStringBuilder.append(paramString.getMessage());
      g.b(str, localStringBuilder.toString());
    }
    return null;
  }
  
  public static boolean a(X509Certificate paramX509Certificate)
  {
    if (paramX509Certificate == null) {
      return false;
    }
    if (paramX509Certificate.getBasicConstraints() == -1) {
      return false;
    }
    return paramX509Certificate.getKeyUsage()[5];
  }
  
  public static boolean a(X509Certificate paramX509Certificate, String paramString)
  {
    if (!paramString.equals(paramX509Certificate.getSubjectDN().getName()))
    {
      g.b(a, "verify: subject name is error");
      return false;
    }
    return true;
  }
  
  public static boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    Object localObject = paramX509Certificate1.getPublicKey();
    try
    {
      paramX509Certificate2.verify((PublicKey)localObject);
      if (!b(new X509Certificate[] { paramX509Certificate1, paramX509Certificate2 }))
      {
        g.b(a, "verify: date not right");
        return false;
      }
      return true;
    }
    catch (Exception paramX509Certificate1)
    {
      paramX509Certificate2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verify: Exception ");
      ((StringBuilder)localObject).append(paramX509Certificate1.getMessage());
      g.b(paramX509Certificate2, ((StringBuilder)localObject).toString());
      return false;
    }
    catch (SignatureException paramX509Certificate1)
    {
      paramX509Certificate2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verify: publickey SignatureException ");
      ((StringBuilder)localObject).append(paramX509Certificate1.getMessage());
      g.b(paramX509Certificate2, ((StringBuilder)localObject).toString());
      return false;
    }
    catch (NoSuchProviderException paramX509Certificate1)
    {
      paramX509Certificate2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verify: publickey NoSuchProviderException ");
      ((StringBuilder)localObject).append(paramX509Certificate1.getMessage());
      g.b(paramX509Certificate2, ((StringBuilder)localObject).toString());
      return false;
    }
    catch (NoSuchAlgorithmException paramX509Certificate1)
    {
      paramX509Certificate2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verify: publickey NoSuchAlgorithmException ");
      ((StringBuilder)localObject).append(paramX509Certificate1.getMessage());
      g.b(paramX509Certificate2, ((StringBuilder)localObject).toString());
      return false;
    }
    catch (InvalidKeyException paramX509Certificate1)
    {
      paramX509Certificate2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verify: publickey InvalidKeyException ");
      ((StringBuilder)localObject).append(paramX509Certificate1.getMessage());
      g.b(paramX509Certificate2, ((StringBuilder)localObject).toString());
      return false;
    }
    catch (CertificateException paramX509Certificate1)
    {
      paramX509Certificate2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verify: publickey CertificateException ");
      ((StringBuilder)localObject).append(paramX509Certificate1.getMessage());
      g.b(paramX509Certificate2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public static boolean a(X509Certificate paramX509Certificate, X509Certificate[] paramArrayOfX509Certificate)
  {
    Object localObject1 = null;
    int i = 0;
    while (i < paramArrayOfX509Certificate.length)
    {
      Object localObject2 = paramArrayOfX509Certificate[i];
      Principal localPrincipal = ((X509Certificate)localObject2).getIssuerDN();
      localObject2 = ((X509Certificate)localObject2).getSubjectDN();
      if (localObject1 != null) {
        if (localPrincipal.equals(localObject1))
        {
          localObject1 = paramArrayOfX509Certificate[(i - 1)].getPublicKey();
          paramArrayOfX509Certificate[i].verify((PublicKey)localObject1);
        }
        else
        {
          g.b(a, "verify: principalIssuer not match");
          return false;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (!a(paramX509Certificate, paramArrayOfX509Certificate[0])) {
      return false;
    }
    if (!b(paramArrayOfX509Certificate)) {
      return false;
    }
    if (!a(paramX509Certificate)) {
      return false;
    }
    return a(paramArrayOfX509Certificate);
  }
  
  public static boolean a(X509Certificate paramX509Certificate, X509Certificate[] paramArrayOfX509Certificate, X509CRL paramX509CRL, String paramString)
  {
    if (a(paramX509Certificate, paramArrayOfX509Certificate)) {
      return false;
    }
    if (a(paramArrayOfX509Certificate, paramX509CRL)) {
      return false;
    }
    if (!a(paramArrayOfX509Certificate[(paramArrayOfX509Certificate.length - 1)], paramString)) {
      return false;
    }
    return b(paramArrayOfX509Certificate);
  }
  
  public static boolean a(X509Certificate[] paramArrayOfX509Certificate)
  {
    int i = 0;
    while (i < paramArrayOfX509Certificate.length - 1)
    {
      if (!a(paramArrayOfX509Certificate[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(X509Certificate[] paramArrayOfX509Certificate, X509CRL paramX509CRL)
  {
    Object localObject = new ArrayList();
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    while (i < j)
    {
      ((ArrayList)localObject).add(paramArrayOfX509Certificate[i].getSerialNumber());
      i += 1;
    }
    if (paramX509CRL != null) {
      try
      {
        paramArrayOfX509Certificate = paramX509CRL.getRevokedCertificates();
        if ((paramArrayOfX509Certificate != null) && (!paramArrayOfX509Certificate.isEmpty()))
        {
          paramArrayOfX509Certificate = paramArrayOfX509Certificate.iterator();
          while (paramArrayOfX509Certificate.hasNext()) {
            if (((ArrayList)localObject).contains(((X509CRLEntry)paramArrayOfX509Certificate.next()).getSerialNumber()))
            {
              g.b(a, "verify: certificate revoked");
              return false;
            }
          }
        }
      }
      catch (Exception paramArrayOfX509Certificate)
      {
        paramX509CRL = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("verify: revoked verify exception : ");
        ((StringBuilder)localObject).append(paramArrayOfX509Certificate.getMessage());
        g.b(paramX509CRL, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  public static boolean b(X509Certificate[] paramArrayOfX509Certificate)
  {
    Object localObject1 = new Date();
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label126;
      }
      localObject2 = paramArrayOfX509Certificate[i];
      try
      {
        ((X509Certificate)localObject2).checkValidity((Date)localObject1);
        i += 1;
      }
      catch (Exception paramArrayOfX509Certificate)
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("verifyCertificateDate : exception : ");
        ((StringBuilder)localObject2).append(paramArrayOfX509Certificate.getMessage());
        g.b((String)localObject1, ((StringBuilder)localObject2).toString());
        return false;
      }
      catch (CertificateNotYetValidException paramArrayOfX509Certificate) {}catch (CertificateExpiredException paramArrayOfX509Certificate) {}
    }
    localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("verifyCertificateDate: exception : ");
    ((StringBuilder)localObject2).append(paramArrayOfX509Certificate.getMessage());
    g.b((String)localObject1, ((StringBuilder)localObject2).toString());
    return false;
    label126:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.b
 * JD-Core Version:    0.7.0.1
 */