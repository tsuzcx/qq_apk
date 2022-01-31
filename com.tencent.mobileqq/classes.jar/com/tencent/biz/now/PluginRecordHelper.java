package com.tencent.biz.now;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.NowUtil;
import com.tencent.txproxy.HostInterface;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import kqm;
import kqn;
import org.json.JSONObject;

public class PluginRecordHelper
{
  public static String a;
  protected int a;
  public long a;
  public Handler a;
  public PluginRecordHelper.cigHelperCallback a;
  public boolean a;
  protected int b;
  public String b;
  int c;
  public String c;
  protected String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "CgiHelper";
  }
  
  public PluginRecordHelper()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  private String a(String paramString1, boolean paramBoolean, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new URL(paramString1).openConnection();
        if (paramString1 == null) {
          return "";
        }
        paramString1.setUseCaches(false);
        paramString1.setRequestProperty("Accept-Encoding", "identity");
        if ((paramBoolean) && (!TextUtils.isEmpty(paramString2))) {
          paramString1.setRequestProperty("Host", paramString2);
        }
        paramString1.setConnectTimeout(3000);
        paramString1.setReadTimeout(3000);
        if ((paramString1 instanceof HttpURLConnection)) {
          this.jdField_a_of_type_Int = ((HttpURLConnection)paramString1).getResponseCode();
        }
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
        Log.i(jdField_a_of_type_JavaLangString, "exeption happen");
        this.jdField_b_of_type_Int = 1;
        this.d = paramString1.getMessage();
        return "";
      }
    }
    paramString1 = paramString2.toString();
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_b_of_type_Int = 2;
      this.d = "result is null!";
      return paramString1;
    }
    this.jdField_b_of_type_Int = 0;
    return paramString1;
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
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
    this.jdField_b_of_type_JavaLangString = paramString.getString("vid");
    this.jdField_c_of_type_JavaLangString = paramString.getString("recorded_share_url");
  }
  
  public static boolean b()
  {
    String str1 = System.getProperty("http.proxyHost");
    String str2 = System.getProperty("http.proxyPort");
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public String a(String paramString)
  {
    String str = "https://h5test.now.qq.com/h5/record.html?&_bid=2380&from=2";
    if (NowUtil.a()) {}
    for (;;)
    {
      return str + "&vid=" + paramString;
      str = "https://now.qq.com/h5/record.html?&_bid=2380&from=2";
    }
  }
  
  public void a(long paramLong, PluginRecordHelper.cigHelperCallback paramcigHelperCallback, HostInterface paramHostInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidOsHandler = new kqn(this);
    this.jdField_a_of_type_ComTencentBizNowPluginRecordHelper$cigHelperCallback = paramcigHelperCallback;
    this.jdField_b_of_type_Int = 0;
    this.d = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    ThreadManager.executeOnNetWorkThread(new kqm(this, paramLong, paramHostInterface));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.now.PluginRecordHelper
 * JD-Core Version:    0.7.0.1
 */