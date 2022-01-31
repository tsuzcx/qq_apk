package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

class Platform$JdkWithJettyBootPlatform
  extends Platform.JdkPlatform
{
  private final Class<?> clientProviderClass;
  private final Method getMethod;
  private final Method putMethod;
  private final Method removeMethod;
  private final Class<?> serverProviderClass;
  
  public Platform$JdkWithJettyBootPlatform(Class<?> paramClass1, Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass2, Class<?> paramClass3)
  {
    super(paramClass1);
    this.putMethod = paramMethod1;
    this.getMethod = paramMethod2;
    this.removeMethod = paramMethod3;
    this.clientProviderClass = paramClass2;
    this.serverProviderClass = paramClass3;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket)
  {
    try
    {
      this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError();
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label19:
      break label19;
    }
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    paramString = new ArrayList(paramList.size());
    int j = paramList.size();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = (Protocol)paramList.get(i);
      if (localObject == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        paramString.add(((Protocol)localObject).toString());
      }
    }
    try
    {
      paramList = Platform.class.getClassLoader();
      localObject = this.clientProviderClass;
      Class localClass = this.serverProviderClass;
      paramString = new Platform.JettyNegoProvider(paramString);
      paramString = Proxy.newProxyInstance(paramList, new Class[] { localObject, localClass }, paramString);
      this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError(paramSSLSocket);
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label147:
      break label147;
    }
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
      if ((!Platform.JettyNegoProvider.access$000(paramSSLSocket)) && (Platform.JettyNegoProvider.access$100(paramSSLSocket) == null))
      {
        Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
        return null;
      }
      if (Platform.JettyNegoProvider.access$000(paramSSLSocket)) {
        paramSSLSocket = null;
      } else {
        paramSSLSocket = Platform.JettyNegoProvider.access$100(paramSSLSocket);
      }
    }
    catch (IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError();
    }
    catch (InvocationTargetException paramSSLSocket)
    {
      label71:
      break label71;
    }
    return paramSSLSocket;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.Platform.JdkWithJettyBootPlatform
 * JD-Core Version:    0.7.0.1
 */