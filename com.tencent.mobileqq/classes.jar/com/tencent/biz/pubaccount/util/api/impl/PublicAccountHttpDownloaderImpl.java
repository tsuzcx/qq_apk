package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptBitmapFile;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptConfig;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.utils.IOUtils;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.dns.IpData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import com.tencent.util.URLUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.apache.http.Header;
import org.jetbrains.annotations.Nullable;

public class PublicAccountHttpDownloaderImpl
  extends HttpDownloader
  implements IPublicAccountHttpDownloader
{
  public static final String TAG = "PubAccountHttpDownloader";
  private BaseApplicationImpl application = BaseApplicationImpl.getApplication();
  
  public PublicAccountHttpDownloaderImpl()
  {
    this.mSupportInnerIp = RIJImageOptConfig.a.h();
  }
  
  private File getBitmapFile(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte != null) {
      return new RIJImageOptBitmapFile(paramArrayOfByte, paramLong);
    }
    return null;
  }
  
  private byte[] getByteArrayInputStream(InputStream paramInputStream, long paramLong)
  {
    return IOUtils.a(paramInputStream, (int)paramLong);
  }
  
  private String getNetIdentifier()
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str2 = String.valueOf(NetworkUtil.a(localContext));
    String str1 = str2;
    if (!StringUtil.a(str2))
    {
      str1 = str2;
      if (str2.equals(String.valueOf(1))) {
        str1 = PttIpSaver.a(localContext);
      }
    }
    return str1;
  }
  
  private void hook(URL paramURL)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = InnerDns.getInstance().reqSerAddrList(paramURL.getHost(), 1002);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
          break;
        }
        Object localObject2 = new ArrayList();
        localObject1 = InetAddress.getAllByName(paramURL.getHost());
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break;
        }
        int k = localObject1.length;
        int i = 0;
        HashMap localHashMap1;
        Object localObject3;
        if (i < k)
        {
          localHashMap1 = localObject1[i];
          localObject3 = new IpData();
          ((IpData)localObject3).mIp = localHashMap1.getHostAddress();
          ((IpData)localObject3).mPort = 80;
          if (IPAddressUtil.isIPv4LiteralAddress(((IpData)localObject3).mIp))
          {
            j = 1;
            ((IpData)localObject3).mType = j;
            ((ArrayList)localObject2).add(localObject3);
            i += 1;
          }
        }
        else
        {
          localObject2 = new DomainData(paramURL.getHost(), (ArrayList)localObject2);
          localHashMap1 = (HashMap)Reflect.on(InnerDns.getInstance()).get("mNetMap");
          localObject3 = getNetIdentifier();
          if (localHashMap1 != null)
          {
            if (localHashMap1.containsKey(localObject3)) {
              ((HashMap)localHashMap1.get(localObject3)).put(paramURL.getHost(), localObject2);
            }
          }
          else
          {
            QLog.d("PubAccountHttpDownloader", 1, "hook success: " + Arrays.toString((Object[])localObject1));
            return;
          }
          HashMap localHashMap2 = new HashMap();
          localHashMap2.put(paramURL.getHost(), localObject2);
          localHashMap1.put(localObject3, localHashMap2);
          continue;
        }
        int j = 28;
      }
      catch (Exception paramURL)
      {
        QLog.d("PubAccountHttpDownloader", 1, paramURL.getMessage());
        return;
      }
    }
  }
  
  private void saveFileInSingleThread(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    ThreadManager.getFileThreadHandler().post(new PublicAccountHttpDownloaderImpl.1(this, paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, paramInputStream, paramLong));
  }
  
  public void copyRespInfo(NetResp paramNetResp, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramURLDrawableHandler instanceof PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler))
    {
      PublicAccountHttpDownloaderImpl.PubAccoutImageReporter localPubAccoutImageReporter = ((PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler)paramURLDrawableHandler).a();
      if (localPubAccoutImageReporter != null)
      {
        localPubAccoutImageReporter.a(paramNetResp, paramNetResp.mErrDesc);
        ((PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler)paramURLDrawableHandler).a("image/" + PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.a(localPubAccoutImageReporter));
      }
    }
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    String str = paramDownloadParams.urlStr;
    if (str.startsWith("pubaccountimage")) {
      str = paramDownloadParams.url.getFile();
    }
    for (;;)
    {
      Object localObject1 = URLUtil.a(str);
      if (((Map)localObject1).get("busiType") != null) {}
      PublicAccountHttpDownloaderImpl.PubAccoutImageReporter localPubAccoutImageReporter;
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)((Map)localObject1).get("busiType"));
          paramDownloadParams.url = new URL(str);
          paramDownloadParams.urlStr = str;
          localPubAccoutImageReporter = new PublicAccountHttpDownloaderImpl.PubAccoutImageReporter(this, this.application, i);
          localPubAccoutImageReporter.a(paramDownloadParams, (Map)localObject1);
          if (paramDownloadParams.headers == null) {
            break;
          }
          localObject1 = paramDownloadParams.headers;
          j = localObject1.length;
          i = 0;
          if (i >= j) {
            break;
          }
          Object localObject3 = localObject1[i];
          if ("my_uin".equals(localObject3.getName())) {
            localObject3.getValue();
          }
          i += 1;
          continue;
          i = -1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("PubAccountHttpDownloader", 2, "urlString: " + str + "  busiType:" + (String)((Map)localObject1).get("busiType"), localNumberFormatException);
        }
      }
      PublicAccountHttpDownloaderImpl.CountOutputStreamWapper localCountOutputStreamWapper = new PublicAccountHttpDownloaderImpl.CountOutputStreamWapper(this, paramOutputStream);
      Object localObject4 = null;
      int j = 0;
      int k = 1;
      int i = k - 1;
      localObject1 = localObject4;
      Object localObject5;
      if (k > 0)
      {
        j += 1;
        localObject1 = localObject4;
        localObject5 = localObject4;
      }
      label778:
      label781:
      label788:
      for (;;)
      {
        try
        {
          localPubAccoutImageReporter.a();
          localObject1 = localObject4;
          localObject5 = localObject4;
          if (this.mSupportInnerIp)
          {
            localObject1 = localObject4;
            localObject5 = localObject4;
            if (RIJImageOptConfig.a.i())
            {
              localObject1 = localObject4;
              localObject5 = localObject4;
              hook(paramDownloadParams.url);
            }
          }
          localObject1 = localObject4;
          localObject5 = localObject4;
          localObject4 = super.downloadImage(localCountOutputStreamWapper, paramDownloadParams, localPubAccoutImageReporter.a(paramURLDrawableHandler));
          if (localObject4 != null)
          {
            localObject1 = localObject4;
            localObject5 = localObject4;
            boolean bool = localObject4 instanceof RIJImageOptBitmapFile;
            if (!bool) {
              break label788;
            }
          }
          i = -1;
          if (!this.isCancelled.get()) {
            continue;
          }
          localPubAccoutImageReporter.a(j, paramDownloadParams);
          localObject1 = localObject4;
        }
        catch (IOException localIOException)
        {
          localObject5 = localObject2;
          if (!localIOException.getMessage().contains(" response error! response code: ")) {
            continue;
          }
          if (i != 0) {
            continue;
          }
          localObject5 = localObject2;
          throw localIOException;
        }
        finally
        {
          if (!this.isCancelled.get()) {
            continue;
          }
          localPubAccoutImageReporter.a(j, paramDownloadParams);
          localObject2 = localObject5;
          continue;
          localObject5 = localObject2;
          localPubAccoutImageReporter.a(-1, localIOException.getMessage());
          continue;
          localObject5 = localObject2;
          try
          {
            ((FileOutputStream)paramOutputStream).getChannel().truncate(0L);
            if (this.isCancelled.get()) {
              localPubAccoutImageReporter.a(j, paramDownloadParams);
            }
          }
          catch (Exception localException)
          {
            localObject5 = localObject2;
            QLog.e("PubAccountHttpDownloader", 2, "urlString: " + str, localException);
            continue;
            if ((i == -1) || (i == 0))
            {
              if ((PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.a(localPubAccoutImageReporter) != 0) && (paramDownloadParams.retryCount != ImageRequest.g)) {
                break label778;
              }
              localPubAccoutImageReporter.a(j, paramDownloadParams);
              continue;
            }
            try
            {
              Thread.sleep(5L);
            }
            catch (InterruptedException localInterruptedException2)
            {
              localInterruptedException2.printStackTrace();
            }
          }
          continue;
          if ((i != -1) && (i != 0)) {
            continue;
          }
          if ((PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.a(localPubAccoutImageReporter) != 0) && (paramDownloadParams.retryCount != ImageRequest.g)) {
            continue;
          }
          localPubAccoutImageReporter.a(j, paramDownloadParams);
          throw paramOutputStream;
          try
          {
            Thread.sleep(5L);
          }
          catch (InterruptedException paramDownloadParams)
          {
            paramDownloadParams.printStackTrace();
          }
          continue;
        }
        if (this.isCancelled.get())
        {
          throw new IOException("cancelled");
          if ((i == -1) || (i == 0))
          {
            if ((PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.a(localPubAccoutImageReporter) != 0) && (paramDownloadParams.retryCount != ImageRequest.g)) {
              break label781;
            }
            localPubAccoutImageReporter.a(j, paramDownloadParams);
            localObject1 = localObject4;
            localObject4 = localObject1;
            k = i;
            break;
          }
          try
          {
            Thread.sleep(5L);
            localObject1 = localObject4;
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
            localObject2 = localObject4;
          }
          continue;
        }
        return localObject2;
        continue;
        Object localObject2 = localInterruptedException2;
      }
    }
  }
  
  @Nullable
  public File getDownloadFile(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    if (RIJImageOptConfig.a.d())
    {
      byte[] arrayOfByte = getByteArrayInputStream(paramInputStream, paramLong);
      QLog.d("PubAccountHttpDownloader", 1, "read into memory done");
      if (arrayOfByte != null)
      {
        saveFileInSingleThread(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, new ByteArrayInputStream(arrayOfByte), paramLong);
        return getBitmapFile(arrayOfByte, paramLong);
      }
    }
    return super.getDownloadFile(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramBoolean, paramInt2, paramInputStream, paramLong);
  }
  
  public HttpDownloader getHttpDownloader()
  {
    return this;
  }
  
  public boolean isCommitBimapFileAsyn(File paramFile)
  {
    return paramFile instanceof RIJImageOptBitmapFile;
  }
  
  public URL makeURL(String paramString, int paramInt)
  {
    return makeURL(paramString, paramInt, null);
  }
  
  public URL makeURL(String paramString, int paramInt, Object paramObject)
  {
    return makeURL(paramString, paramInt, paramObject, false);
  }
  
  public URL makeURL(String paramString, int paramInt, Object paramObject, boolean paramBoolean)
  {
    String str;
    for (;;)
    {
      try
      {
        if ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
          return new URL(paramString);
        }
        paramObject = URLUtil.a(paramString);
        if (!paramObject.containsKey("busiType")) {
          continue;
        }
        paramString = paramString.replace("busiType=" + (String)paramObject.get("busiType"), "busiType=" + paramInt);
        if (paramBoolean) {
          continue;
        }
        paramString = new URL("pubaccountimage", null, paramString);
        str = paramString;
        try
        {
          if (!QLog.isColorLevel()) {
            break label231;
          }
          QLog.d("PubAccountHttpDownloader", 2, "<--generateURL urlString =" + paramString.toString());
          return paramString;
        }
        catch (MalformedURLException paramObject) {}
      }
      catch (MalformedURLException paramObject)
      {
        paramString = null;
        continue;
      }
      str = paramString;
      if (!QLog.isColorLevel()) {
        break label231;
      }
      QLog.e("PubAccountHttpDownloader", 2, "<--generateURL urlString", paramObject);
      return paramString;
      paramString = URLUtil.a(paramString, "busiType", paramInt + "");
      continue;
      paramString = new URL(paramString);
    }
    label231:
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountHttpDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */