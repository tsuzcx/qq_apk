package com.tencent.av.utils.download;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.dataline.util.HttpUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpConnectionParams;

public class BaseDownloadAsyncTask
  extends AsyncTask<ArrayList<DownloadParams>, DownloadParams, Integer>
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new BaseDownloadAsyncTask.InnerHandler(null);
  private String jdField_a_of_type_JavaLangString = BaseDownloadAsyncTask.class.getSimpleName();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  boolean jdField_a_of_type_Boolean = false;
  
  private HttpGet a(DownloadParams paramDownloadParams, DownloadResult paramDownloadResult)
  {
    try
    {
      HttpGet localHttpGet = new HttpGet(paramDownloadParams.jdField_a_of_type_JavaLangString);
      paramDownloadResult = localHttpGet;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramDownloadResult.jdField_a_of_type_JavaLangString = localIllegalArgumentException.toString();
      paramDownloadResult = null;
    }
    if (paramDownloadResult != null)
    {
      if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
        paramDownloadResult.setHeader("Net-type", "Wifi");
      } else {
        paramDownloadResult.setHeader("Net-type", "gprs");
      }
      if (paramDownloadParams.jdField_a_of_type_JavaUtilHashMap != null)
      {
        paramDownloadParams = paramDownloadParams.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (paramDownloadParams.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramDownloadParams.next();
          paramDownloadResult.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
    return paramDownloadResult;
  }
  
  private boolean a(DownloadResult paramDownloadResult, HttpEntity paramHttpEntity, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    try
    {
      paramHttpEntity = paramHttpEntity.getContent();
    }
    catch (IOException paramHttpEntity)
    {
      paramDownloadResult.jdField_a_of_type_Int = 3;
      paramDownloadResult.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
      paramHttpEntity = null;
    }
    byte[] arrayOfByte2;
    if (paramHttpEntity == null) {
      i = 0;
    } else {
      arrayOfByte2 = new byte[2048];
    }
    int k;
    for (int i = 0;; i = k)
    {
      int j;
      try
      {
        j = paramHttpEntity.read(arrayOfByte2);
      }
      catch (IOException localIOException)
      {
        paramDownloadResult.jdField_a_of_type_Int = 3;
        paramDownloadResult.jdField_a_of_type_JavaLangString = localIOException.toString();
        j = 0;
      }
      if (j > 0)
      {
        k = i + j;
        if (k > paramInt) {
          i = k;
        }
      }
      else
      {
        if (paramHttpEntity != null) {
          try
          {
            paramHttpEntity.close();
          }
          catch (IOException paramHttpEntity)
          {
            paramHttpEntity.printStackTrace();
          }
        }
        boolean bool;
        if (i == paramInt) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool)
        {
          paramDownloadResult.jdField_a_of_type_ArrayOfByte = arrayOfByte1;
          paramDownloadResult.jdField_a_of_type_Long = paramInt;
          paramDownloadResult.jdField_a_of_type_Int = 0;
        }
        else
        {
          paramDownloadResult.jdField_a_of_type_Int = 3;
          if (i < paramInt)
          {
            paramHttpEntity = new StringBuilder();
            paramHttpEntity.append("ContentLength ");
            paramHttpEntity.append(paramInt);
            paramHttpEntity.append(" but read ");
            paramHttpEntity.append(i);
            paramDownloadResult.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
          }
          else
          {
            paramHttpEntity = new StringBuilder();
            paramHttpEntity.append("ContentLength ");
            paramHttpEntity.append(paramInt);
            paramHttpEntity.append(",but read ");
            paramHttpEntity.append(i);
            paramDownloadResult.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
          }
        }
        if (QLog.isColorLevel())
        {
          paramDownloadResult = this.jdField_a_of_type_JavaLangString;
          paramHttpEntity = new StringBuilder();
          paramHttpEntity.append("readContent done. isSucess = ");
          paramHttpEntity.append(bool);
          paramHttpEntity.append(",length=");
          paramHttpEntity.append(paramInt);
          QLog.d(paramDownloadResult, 2, paramHttpEntity.toString());
        }
        return bool;
      }
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, j);
    }
  }
  
  protected Integer a(ArrayList<DownloadParams>... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null))
    {
      Iterator localIterator = paramVarArgs[0].iterator();
      DownloadParams localDownloadParams;
      while (localIterator.hasNext())
      {
        localDownloadParams = (DownloadParams)localIterator.next();
        localDownloadParams.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult = new DownloadResult();
        localDownloadParams.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_a_of_type_Int = -1;
      }
      int n = 5000;
      int i = 60000;
      boolean bool;
      if (HttpUtil.a() != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = HttpUtil.a(false, this.jdField_a_of_type_Boolean, 5000, 60000);
      localIterator = paramVarArgs[0].iterator();
      paramVarArgs = "";
      int j = 0;
      while (localIterator.hasNext())
      {
        localDownloadParams = (DownloadParams)localIterator.next();
        int k = n;
        if (localDownloadParams.jdField_b_of_type_Int != n)
        {
          k = localDownloadParams.jdField_b_of_type_Int;
          HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), k);
        }
        int m = i;
        if (localDownloadParams.c != i)
        {
          m = localDownloadParams.c;
          HttpConnectionParams.setSoTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), m);
        }
        i = localDownloadParams.jdField_a_of_type_Int;
        if (isCancelled()) {
          break;
        }
        long l1 = System.currentTimeMillis();
        for (;;)
        {
          if (isCancelled())
          {
            n = i;
          }
          else
          {
            n = i;
            if (!a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient, localDownloadParams))
            {
              n = 3;
              try
              {
                for (;;)
                {
                  Thread.sleep(1000L);
                  if (n <= 0) {
                    break;
                  }
                  bool = NetworkUtil.isNetworkAvailable(BaseApplication.getContext());
                  if (bool) {
                    break;
                  }
                  n -= 1;
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
                n = i - 1;
                if (i > 0) {
                  i = n;
                }
              }
            }
          }
        }
        j += 1;
        long l2 = System.currentTimeMillis();
        localDownloadParams.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_b_of_type_Long = (l2 - l1);
        localDownloadParams.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult.jdField_b_of_type_Int = (localDownloadParams.jdField_a_of_type_Int - n);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramVarArgs);
        localStringBuilder.append(localDownloadParams.toString());
        localStringBuilder.append(", ");
        paramVarArgs = localStringBuilder.toString();
        b(localDownloadParams);
        jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new BaseDownloadAsyncTask.HYAsyncTaskResult(this, new DownloadParams[] { localDownloadParams })).sendToTarget();
        n = k;
        i = m;
      }
      if ((QLog.isColorLevel()) && (!paramVarArgs.equals(""))) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, paramVarArgs);
      }
      return Integer.valueOf(j);
    }
    return null;
  }
  
  public void a(DownloadParams paramDownloadParams) {}
  
  protected void a(Integer paramInteger)
  {
    paramInteger = this.jdField_a_of_type_OrgApacheHttpClientHttpClient;
    if (paramInteger != null)
    {
      ThreadManager.excute(new BaseDownloadAsyncTask.1(this, paramInteger), 16, null, false);
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
    }
  }
  
  protected boolean a(HttpClient paramHttpClient, DownloadParams paramDownloadParams)
  {
    DownloadResult localDownloadResult = paramDownloadParams.jdField_a_of_type_ComTencentAvUtilsDownloadDownloadResult;
    localDownloadResult.jdField_a_of_type_Int = -2;
    HttpGet localHttpGet = a(paramDownloadParams, localDownloadResult);
    if (localHttpGet != null)
    {
      paramDownloadParams = null;
      try
      {
        paramHttpClient = paramHttpClient.execute(localHttpGet);
      }
      catch (Exception paramHttpClient)
      {
        localDownloadResult.jdField_a_of_type_JavaLangString = paramHttpClient.toString();
        paramHttpClient = paramDownloadParams;
      }
      catch (IOException paramHttpClient)
      {
        localDownloadResult.jdField_a_of_type_JavaLangString = paramHttpClient.toString();
        paramHttpClient = paramDownloadParams;
      }
      if (paramHttpClient == null) {
        return false;
      }
      paramDownloadParams = paramHttpClient.getEntity();
      if (paramDownloadParams == null)
      {
        localDownloadResult.jdField_a_of_type_Int = 2;
      }
      else
      {
        paramHttpClient = paramHttpClient.getStatusLine();
        int i = paramHttpClient.getStatusCode();
        int j = (int)paramDownloadParams.getContentLength();
        if ((i != 200) && (i != 206))
        {
          localDownloadResult.jdField_a_of_type_Int = 2;
          localDownloadResult.jdField_a_of_type_JavaLangString = paramHttpClient.getReasonPhrase();
        }
        else if (j <= 0)
        {
          localDownloadResult.jdField_a_of_type_Int = 2;
          paramHttpClient = new StringBuilder();
          paramHttpClient.append("invalid contentLength ");
          paramHttpClient.append(j);
          localDownloadResult.jdField_a_of_type_JavaLangString = paramHttpClient.toString();
        }
        else
        {
          localDownloadResult.jdField_a_of_type_Boolean = a(localDownloadResult, paramDownloadParams, j);
        }
        if (localDownloadResult.jdField_a_of_type_Boolean) {}
      }
    }
    try
    {
      paramDownloadParams.getContent().close();
      label234:
      return localDownloadResult.jdField_a_of_type_Boolean;
    }
    catch (IOException|Exception paramHttpClient)
    {
      break label234;
    }
  }
  
  public void b(DownloadParams paramDownloadParams) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.download.BaseDownloadAsyncTask
 * JD-Core Version:    0.7.0.1
 */