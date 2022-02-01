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
import java.util.List;
import java.util.Set;

public class b
{
  private static final String TAG = "CertificateChainVerify";
  private static final int ak = 5;
  
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
        g.a("CertificateChainVerify", "exception", paramSslCertificate);
      }
    }
    return null;
  }
  
  public static boolean a(X509Certificate paramX509Certificate)
  {
    if (paramX509Certificate == null) {}
    while (paramX509Certificate.getBasicConstraints() == -1) {
      return false;
    }
    return paramX509Certificate.getKeyUsage()[5];
  }
  
  public static boolean a(X509Certificate paramX509Certificate, String paramString)
  {
    if (!paramString.equals(paramX509Certificate.getSubjectDN().getName()))
    {
      g.e("CertificateChainVerify", "verify: subject name is error");
      return false;
    }
    return true;
  }
  
  public static boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    PublicKey localPublicKey = paramX509Certificate1.getPublicKey();
    try
    {
      paramX509Certificate2.verify(localPublicKey);
      if (!a(new X509Certificate[] { paramX509Certificate1, paramX509Certificate2 }))
      {
        g.e("CertificateChainVerify", "verify: date not right");
        return false;
      }
    }
    catch (CertificateException paramX509Certificate1)
    {
      g.e("CertificateChainVerify", "verify: publickey CertificateException " + paramX509Certificate1.getMessage());
      return false;
    }
    catch (InvalidKeyException paramX509Certificate1)
    {
      g.e("CertificateChainVerify", "verify: publickey InvalidKeyException " + paramX509Certificate1.getMessage());
      return false;
    }
    catch (NoSuchAlgorithmException paramX509Certificate1)
    {
      g.e("CertificateChainVerify", "verify: publickey NoSuchAlgorithmException " + paramX509Certificate1.getMessage());
      return false;
    }
    catch (NoSuchProviderException paramX509Certificate1)
    {
      g.e("CertificateChainVerify", "verify: publickey NoSuchProviderException " + paramX509Certificate1.getMessage());
      return false;
    }
    catch (SignatureException paramX509Certificate1)
    {
      g.e("CertificateChainVerify", "verify: publickey SignatureException " + paramX509Certificate1.getMessage());
      return false;
    }
    return true;
  }
  
  public static boolean a(X509Certificate paramX509Certificate, X509Certificate[] paramArrayOfX509Certificate)
  {
    Object localObject1 = null;
    int i = 0;
    while (i < paramArrayOfX509Certificate.length)
    {
      localObject2 = paramArrayOfX509Certificate[i];
      localPrincipal = ((X509Certificate)localObject2).getIssuerDN();
      localObject2 = ((X509Certificate)localObject2).getSubjectDN();
      if (localObject1 != null)
      {
        if (localPrincipal.equals(localObject1))
        {
          localObject1 = paramArrayOfX509Certificate[(i - 1)].getPublicKey();
          paramArrayOfX509Certificate[i].verify((PublicKey)localObject1);
        }
      }
      else
      {
        i += 1;
        localObject1 = localObject2;
        continue;
      }
      g.e("CertificateChainVerify", "verify: principalIssuer not match");
    }
    while ((!a(paramX509Certificate, paramArrayOfX509Certificate[0])) || (!a(paramArrayOfX509Certificate)))
    {
      Object localObject2;
      Principal localPrincipal;
      return false;
    }
    return true;
  }
  
  public static boolean a(X509Certificate paramX509Certificate, X509Certificate[] paramArrayOfX509Certificate, X509CRL paramX509CRL, String paramString)
  {
    if (a(paramX509Certificate, paramArrayOfX509Certificate)) {}
    while ((a(paramArrayOfX509Certificate, paramX509CRL)) || (!a(paramArrayOfX509Certificate[(paramArrayOfX509Certificate.length - 1)], paramString)) || (!a(paramArrayOfX509Certificate))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(List<X509Certificate> paramList)
  {
    int i = 0;
    while (i < paramList.size() - 1)
    {
      if (!a((X509Certificate)paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(X509Certificate[] paramArrayOfX509Certificate)
  {
    Date localDate = new Date();
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    for (;;)
    {
      X509Certificate localX509Certificate;
      if (i < j) {
        localX509Certificate = paramArrayOfX509Certificate[i];
      }
      try
      {
        localX509Certificate.checkValidity(localDate);
        i += 1;
      }
      catch (CertificateExpiredException paramArrayOfX509Certificate)
      {
        g.e("CertificateChainVerify", "verifyCertificateDate: exception : " + paramArrayOfX509Certificate.getMessage());
        return false;
        return true;
      }
      catch (CertificateNotYetValidException paramArrayOfX509Certificate)
      {
        label37:
        break label37;
      }
    }
  }
  
  public static boolean a(X509Certificate[] paramArrayOfX509Certificate, X509CRL paramX509CRL)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfX509Certificate.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfX509Certificate[i].getSerialNumber());
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
            if (localArrayList.contains(((X509CRLEntry)paramArrayOfX509Certificate.next()).getSerialNumber()))
            {
              g.e("CertificateChainVerify", "verify: certificate revoked");
              return false;
            }
          }
        }
      }
      catch (Exception paramArrayOfX509Certificate)
      {
        g.e("CertificateChainVerify", "verify: revoked verify exception : " + paramArrayOfX509Certificate.getMessage());
        return false;
      }
    }
    return true;
  }
  
  public static X509Certificate d(String paramString)
  {
    try
    {
      paramString = (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(paramString.getBytes()));
      return paramString;
    }
    catch (CertificateException paramString)
    {
      g.e("CertificateChainVerify", "generateX509FromStr: CertificateException" + paramString.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.b
 * JD-Core Version:    0.7.0.1
 */