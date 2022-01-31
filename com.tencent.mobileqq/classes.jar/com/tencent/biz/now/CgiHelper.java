package com.tencent.biz.now;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.txproxy.HostInterface;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import knw;
import knx;
import org.json.JSONObject;

public class CgiHelper
{
  public static String a;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private CgiHelper.cigHelperCallback jdField_a_of_type_ComTencentBizNowCgiHelper$cigHelperCallback;
  private String b;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "CgiHelper";
  }
  
  private String a(String paramString1, boolean paramBoolean, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new URL(paramString1);
        Log.i(jdField_a_of_type_JavaLangString, " new URL 结束");
        paramString1 = paramString1.openConnection();
        Log.i(jdField_a_of_type_JavaLangString, "openConnection结束");
        if (paramString1 == null) {
          return "";
        }
        paramString1.setRequestProperty("Accept-Encoding", "identity");
        if ((paramBoolean) && (!TextUtils.isEmpty(paramString2))) {
          paramString1.setRequestProperty("Host", paramString2);
        }
        Log.i(jdField_a_of_type_JavaLangString, "getInputStream结束");
        if ((paramString1 instanceof HttpURLConnection)) {
          this.jdField_a_of_type_Int = ((HttpURLConnection)paramString1).getResponseCode();
        }
        Log.i(jdField_a_of_type_JavaLangString, "getResponseCode结束");
        paramString1.getContentEncoding();
        if ("gzip".equals(paramString1.getContentEncoding()))
        {
          paramString1 = new InputStreamReader(new GZIPInputStream(paramString1.getInputStream()));
          paramString1 = new BufferedReader(paramString1);
          paramString2 = new StringBuilder();
          String str = paramString1.readLine();
          if (str == null) {
            break;
          }
          paramString2.append(str);
          continue;
        }
        paramString1 = new InputStreamReader(paramString1.getInputStream());
      }
      catch (Exception paramString1)
      {
        Log.i(jdField_a_of_type_JavaLangString, "getHeaderFields结束");
        return "";
      }
    }
    paramString1 = paramString2.toString();
    return paramString1;
  }
  
  private void a(String paramString)
  {
    this.b = null;
    this.c = null;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.getInt("retcode") != 0)
      {
        Log.i(jdField_a_of_type_JavaLangString, "retcode != 0");
        return;
      }
      paramString = paramString.getJSONObject("result");
      if (paramString == null)
      {
        Log.i(jdField_a_of_type_JavaLangString, "result == null");
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    this.b = paramString.getString("vid");
    this.c = paramString.getString("recorded_share_url");
  }
  
  public static boolean a()
  {
    String str1 = System.getProperty("http.proxyHost");
    String str2 = System.getProperty("http.proxyPort");
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2));
  }
  
  public void a(long paramLong, CgiHelper.cigHelperCallback paramcigHelperCallback, HostInterface paramHostInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new knx(this);
    this.jdField_a_of_type_ComTencentBizNowCgiHelper$cigHelperCallback = paramcigHelperCallback;
    ThreadManager.executeOnNetWorkThread(new knw(this, paramLong, paramHostInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.now.CgiHelper
 * JD-Core Version:    0.7.0.1
 */