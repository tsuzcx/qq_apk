package com.tencent.biz.pubaccount.util;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AccountNotMatchException;
import mys;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class PubAccountHttpDownloader
  extends HttpDownloader
{
  private BaseApplicationImpl a;
  
  public PubAccountHttpDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public static URL a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, null);
  }
  
  public static URL a(String paramString, int paramInt, Object paramObject)
  {
    String str;
    for (;;)
    {
      try
      {
        if ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
          return new URL(paramString);
        }
        paramString = paramString + "?busiType=" + paramInt;
        if (paramObject != null) {
          continue;
        }
      }
      catch (MalformedURLException paramObject)
      {
        paramString = null;
        continue;
        continue;
      }
      paramString = new URL("pubaccountimage", null, paramString);
      str = paramString;
      try
      {
        if (!QLog.isColorLevel()) {
          return str;
        }
        QLog.d("PubAccountHttpDownloader", 2, "<--generateURL urlString =" + paramString.toString());
        return paramString;
      }
      catch (MalformedURLException paramObject) {}
      str = paramString;
      if (!QLog.isColorLevel()) {
        return str;
      }
      QLog.e("PubAccountHttpDownloader", 2, "<--generateURL urlString", paramObject);
      return paramString;
      if (!(paramObject instanceof String)) {
        continue;
      }
      paramString = paramString + "&puin=" + paramObject;
    }
    return str;
  }
  
  private void a(String paramString, long paramLong)
  {
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    for (String[] arrayOfString = { "param_WIFIPublicPlatDownloadFlow", "param_WIFIFlow", "param_Flow" };; arrayOfString = new String[] { "param_XGPublicPlatDownloadFlow", "param_XGFlow", "param_Flow" }) {
      try
      {
        ((QQAppInterface)this.a.getAppRuntime(paramString)).sendAppDataIncerment(paramString, arrayOfString, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountHttpDownloader", 2, "param_PublicPlatDownloadFlow fileSize: " + paramLong);
        }
        return;
      }
      catch (AccountNotMatchException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject1 = paramDownloadParams.urlStr;
    if (!paramDownloadParams.urlStr.startsWith("http")) {
      localObject1 = paramDownloadParams.url.getFile();
    }
    int i = ((String)localObject1).lastIndexOf("?busiType");
    Object localObject3 = new HashMap();
    Object localObject4;
    int j;
    PubAccountHttpDownloader.PubAccoutImageReporter localPubAccoutImageReporter;
    int k;
    if (i != -1)
    {
      localObject4 = ((String)localObject1).substring(i + 1);
      localObject1 = ((String)localObject1).substring(0, i);
      localObject4 = ((String)localObject4).split("&");
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        localPubAccoutImageReporter = localObject4[i];
        k = localPubAccoutImageReporter.indexOf('=');
        ((Map)localObject3).put(localPubAccoutImageReporter.substring(0, k), localPubAccoutImageReporter.substring(k + 1));
        i += 1;
      }
      localObject4 = (String)((Map)localObject3).get("busiType");
      if (localObject4 != null) {
        i = Integer.parseInt((String)localObject4);
      }
    }
    for (;;)
    {
      paramDownloadParams.url = new URL((String)localObject1);
      paramDownloadParams.urlStr = ((String)localObject1);
      localPubAccoutImageReporter = new PubAccountHttpDownloader.PubAccoutImageReporter(this.a, i);
      localPubAccoutImageReporter.a(paramDownloadParams, (Map)localObject3);
      if (paramDownloadParams.headers != null)
      {
        localObject3 = paramDownloadParams.headers;
        j = localObject3.length;
        i = 0;
        localObject1 = null;
        while (i < j)
        {
          localObject4 = localObject3[i];
          if ("my_uin".equals(((Header)localObject4).getName())) {
            localObject1 = ((Header)localObject4).getValue();
          }
          i += 1;
        }
      }
      label533:
      for (localObject4 = localObject1;; localObject4 = null)
      {
        mys localmys = new mys(this, paramOutputStream);
        k = 3;
        j = 0;
        localObject1 = null;
        i = k - 1;
        if (k > 0) {
          j += 1;
        }
        label426:
        label570:
        for (;;)
        {
          Object localObject2;
          try
          {
            localPubAccoutImageReporter.a();
            localObject3 = super.a(localmys, paramDownloadParams, localPubAccoutImageReporter.a(paramURLDrawableHandler));
            if (localObject3 != null) {
              break label570;
            }
            i = -1;
            if ((i == -1) || (i == 0))
            {
              localPubAccoutImageReporter.a(j, paramDownloadParams);
              localObject1 = localObject3;
              k = i;
              break;
            }
            try
            {
              Thread.sleep(5L);
              localObject1 = localObject3;
            }
            catch (InterruptedException localInterruptedException1)
            {
              localInterruptedException1.printStackTrace();
              localObject2 = localObject3;
            }
            continue;
            if (i != 0) {
              break label533;
            }
          }
          catch (IOException localIOException)
          {
            if (!localIOException.getMessage().contains(" response error! response code: ")) {
              break label456;
            }
            if (i != 0) {
              break label470;
            }
            throw localIOException;
          }
          finally
          {
            if (i == -1) {}
          }
          localPubAccoutImageReporter.a(j, paramDownloadParams);
          for (;;)
          {
            for (;;)
            {
              throw paramOutputStream;
              label456:
              localPubAccoutImageReporter.a(-1, localIOException.getMessage());
              break label426;
              try
              {
                label470:
                ((FileOutputStream)paramOutputStream).getChannel().truncate(0L);
                if ((i == -1) || (i == 0)) {
                  localPubAccoutImageReporter.a(j, paramDownloadParams);
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                  continue;
                  try
                  {
                    Thread.sleep(5L);
                  }
                  catch (InterruptedException localInterruptedException2)
                  {
                    localInterruptedException2.printStackTrace();
                  }
                }
              }
            }
            break;
            try
            {
              Thread.sleep(5L);
            }
            catch (InterruptedException paramDownloadParams)
            {
              paramDownloadParams.printStackTrace();
            }
          }
          if (localObject4 != null) {
            a((String)localObject4, localmys.a);
          }
          return localObject2;
        }
      }
      i = -1;
      continue;
      i = -1;
    }
  }
  
  public void a(HttpResponse paramHttpResponse, String paramString, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramURLDrawableHandler instanceof PubAccountHttpDownloader.PubAccoutImageReporter.WrapURLDrawableHandler))
    {
      paramURLDrawableHandler = ((PubAccountHttpDownloader.PubAccoutImageReporter.WrapURLDrawableHandler)paramURLDrawableHandler).a();
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.a(paramHttpResponse, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PubAccountHttpDownloader
 * JD-Core Version:    0.7.0.1
 */