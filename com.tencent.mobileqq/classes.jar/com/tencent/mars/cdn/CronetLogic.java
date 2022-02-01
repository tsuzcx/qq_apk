package com.tencent.mars.cdn;

import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qz.o;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CronetLogic
{
  public static native void cancelCronetTask(String paramString);
  
  public static CronetLogic.CertVerifyResult convertToCronetResult(a parama)
  {
    CronetLogic.CertVerifyResult localCertVerifyResult = new CronetLogic.CertVerifyResult();
    localCertVerifyResult.status = parama.a();
    localCertVerifyResult.isIssuedByKnownRoot = parama.b();
    localCertVerifyResult.certificateChain = parama.d();
    return localCertVerifyResult;
  }
  
  public static Map<String, List<String>> getHeaderList(CronetLogic.ResponseHeader paramResponseHeader)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = getHeaderMap(paramResponseHeader).entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramResponseHeader = (Map.Entry)localIterator.next();
      String str1 = (String)paramResponseHeader.getKey();
      if ((str1 != null) && (!str1.isEmpty()))
      {
        String str2 = (String)paramResponseHeader.getValue();
        List localList = (List)localHashMap.get(str1);
        paramResponseHeader = localList;
        if (localList == null) {
          paramResponseHeader = new ArrayList();
        }
        paramResponseHeader.add(str2);
        localHashMap.put(str1, paramResponseHeader);
      }
    }
    return localHashMap;
  }
  
  public static Map<String, String> getHeaderMap(CronetLogic.ResponseHeader paramResponseHeader)
  {
    IdentityHashMap localIdentityHashMap = new IdentityHashMap();
    if ((paramResponseHeader != null) && (paramResponseHeader.headers != null))
    {
      paramResponseHeader = paramResponseHeader.headers;
      int j = paramResponseHeader.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramResponseHeader[i];
        if ((localObject != null) && (localObject.key != null) && (localObject.value != null)) {
          localIdentityHashMap.put(new String(localObject.key), localObject.value);
        }
        i += 1;
      }
    }
    return localIdentityHashMap;
  }
  
  public static String getSystemProperty(String paramString)
  {
    String str = System.getProperty(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("property ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" res ");
    localStringBuilder.append(str);
    o.e("cronet", localStringBuilder.toString());
    return str;
  }
  
  public static native CronetLogic.WebPageProfile getWebPagePerformanceWithURL(String paramString);
  
  public static void initializeNativeLib()
  {
    f.a("andromeda", CronetLogic.class.getClassLoader());
  }
  
  public static native void removeUserCert();
  
  public static native void setUserCertVerify(boolean paramBoolean);
  
  public static native CronetLogic.CronetHttpsCreateResult startCronetDefaultHttpTask(CronetLogic.CronetRequestParams paramCronetRequestParams, CronetLogic.CronetTaskCallback paramCronetTaskCallback);
  
  public static native CronetLogic.CronetHttpsCreateResult startCronetDownloadTask(CronetLogic.CronetRequestParams paramCronetRequestParams, CronetLogic.CronetTaskCallback paramCronetTaskCallback);
  
  public static native CronetLogic.CronetHttpsCreateResult startCronetHttpTask(CronetLogic.CronetRequestParams paramCronetRequestParams, CronetLogic.CronetTaskCallback paramCronetTaskCallback);
  
  public static CronetLogic.CertVerifyResult verifyCertWithUserCA(byte[][] paramArrayOfByte)
  {
    for (;;)
    {
      int j;
      try
      {
        o.d("cronet", "verifyCertWithUserCA");
        KeyStore localKeyStore = KeyStore.getInstance("AndroidCAStore");
        localKeyStore.load(null, null);
        Object localObject2 = new ArrayList();
        Object localObject1 = localKeyStore.aliases();
        Object localObject3;
        if (((Enumeration)localObject1).hasMoreElements())
        {
          localObject3 = (String)((Enumeration)localObject1).nextElement();
          if ((localObject3 == null) || (!((String)localObject3).startsWith("user:"))) {
            continue;
          }
          ((List)localObject2).add(localObject3);
          continue;
        }
        o.d("cronet", "alias list size %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        if (((List)localObject2).size() > 0)
        {
          localObject1 = new ArrayList();
          j = paramArrayOfByte.length;
          i = 0;
          if (i < j) {
            try
            {
              ((List)localObject1).add(b.a(paramArrayOfByte[i]));
              i += 1;
            }
            catch (CertificateException paramArrayOfByte)
            {
              o.b("cronet", paramArrayOfByte.getLocalizedMessage());
              return convertToCronetResult(new a(-5));
            }
          }
          paramArrayOfByte = ((List)localObject2).iterator();
          i = 0;
          j = i;
          if (paramArrayOfByte.hasNext())
          {
            localObject2 = (X509Certificate)localKeyStore.getCertificate((String)paramArrayOfByte.next());
            localObject3 = ((List)localObject1).iterator();
            j = i;
            if (!((Iterator)localObject3).hasNext()) {
              break label443;
            }
            X509Certificate localX509Certificate = (X509Certificate)((Iterator)localObject3).next();
            try
            {
              localX509Certificate.verify(((X509Certificate)localObject2).getPublicKey());
              o.d("cronet", "do user verify success");
              j = 1;
            }
            catch (Exception localException)
            {
              o.a("cronet", localException, "Exception: check user verify certificate", new Object[0]);
            }
            continue;
          }
          if (j != 0) {
            return convertToCronetResult(new a(0));
          }
          return convertToCronetResult(new a(-1));
        }
        o.b("cronet", "checkServerTrusted self check aliasList null");
        return convertToCronetResult(new a(-1));
      }
      catch (IOException paramArrayOfByte) {}catch (CertificateException paramArrayOfByte)
      {
        break label380;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        break label401;
      }
      catch (KeyStoreException paramArrayOfByte)
      {
        break label422;
      }
      o.b("cronet", paramArrayOfByte.getLocalizedMessage());
      return convertToCronetResult(new a(-1));
      label380:
      o.b("cronet", paramArrayOfByte.getLocalizedMessage());
      return convertToCronetResult(new a(-1));
      label401:
      o.b("cronet", paramArrayOfByte.getLocalizedMessage());
      return convertToCronetResult(new a(-1));
      label422:
      o.b("cronet", paramArrayOfByte.getLocalizedMessage());
      return convertToCronetResult(new a(-1));
      label443:
      int i = j;
      if (j == 0) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.CronetLogic
 * JD-Core Version:    0.7.0.1
 */