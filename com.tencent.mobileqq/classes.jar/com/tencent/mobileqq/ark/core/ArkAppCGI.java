package com.tencent.mobileqq.ark.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import com.tencent.mobileqq.ark.util.NetUtil;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class ArkAppCGI
  implements INetEngineListener
{
  static int a;
  private static final Pattern d = Pattern.compile("Last-Modified[ ]*=[ ]*\\[([^\\[\\]]+)\\]");
  private final ArkAppCenter b;
  private final ArrayList<ArkAppCGI.QueryTask> c = new ArrayList();
  
  public ArkAppCGI(ArkAppCenter paramArkAppCenter)
  {
    this.b = paramArkAppCenter;
  }
  
  private static String a()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ArkEnvironmentManager.getInstance().getCacheDirectory());
      ((StringBuilder)localObject1).append("/tmp");
      localObject1 = ((StringBuilder)localObject1).toString();
      new File((String)localObject1).mkdirs();
      long l = System.currentTimeMillis();
      int i = a + 1;
      a = i;
      localObject1 = String.format("%s/%s", new Object[] { localObject1, String.format("cgi_%d_%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }) });
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    Object localObject2;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      try
      {
        localObject1 = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
        paramArrayOfByte = ((JSONObject)localObject1).getString("retcode");
        if (!paramArrayOfByte.equalsIgnoreCase("0"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parseReply_QueryPackageNameByAppID, reply fail, ret=");
          ((StringBuilder)localObject1).append(paramArrayOfByte);
          QLog.i("ArkApp.ArkAppCGI", 1, ((StringBuilder)localObject1).toString());
          return null;
        }
        localObject2 = ((JSONObject)localObject1).getJSONObject("result");
        paramArrayOfByte = ((JSONObject)localObject2).getString("retcode");
        localObject1 = ((JSONObject)localObject2).getString("msg");
        localObject2 = ((JSONObject)localObject2).getString("apk_name");
        if (localObject2 != null) {
          if (((String)localObject2).length() > 0) {
            return localObject2;
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseReply_QueryPackageNameByAppID, packageName is empty, retcode=");
        ((StringBuilder)localObject2).append(paramArrayOfByte);
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ArkApp.ArkAppCGI", 1, ((StringBuilder)localObject2).toString());
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseReply_QueryPackageNameByAppID, Exception:");
        ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
        QLog.i("ArkApp.ArkAppCGI", 1, ((StringBuilder)localObject1).toString());
        return null;
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseReply_QueryPackageNameByAppID, Json Exception:");
        ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
        QLog.i("ArkApp.ArkAppCGI", 1, ((StringBuilder)localObject1).toString());
        return null;
      }
    }
    else
    {
      QLog.i("ArkApp.ArkAppCGI", 1, "parseReply_QueryPackageNameByAppID: replyBuf is empty");
      return null;
    }
    return localObject2;
  }
  
  private void a(ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new ArkAppCGI.2(this, paramQueryTask, paramBoolean, paramArrayOfByte));
  }
  
  private void a(ArkAppCGI.QueryTask_QueryPackageNameByAppID paramQueryTask_QueryPackageNameByAppID, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (!paramBoolean)
    {
      QLog.i("ArkApp.ArkAppCGI", 1, String.format("onQueryPackageNameByAppID: fail, url=%s", new Object[] { paramQueryTask_QueryPackageNameByAppID.a }));
      paramArrayOfByte = null;
    }
    else
    {
      localObject = a(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localObject == null)
      {
        QLog.i("ArkApp.ArkAppCGI", 1, String.format("onQueryPackageNameByAppID: parseReply fail, url=%s", new Object[] { paramQueryTask_QueryPackageNameByAppID.a }));
        paramArrayOfByte = (byte[])localObject;
      }
    }
    int i = 0;
    while (i < paramQueryTask_QueryPackageNameByAppID.e.size())
    {
      localObject = paramQueryTask_QueryPackageNameByAppID.d.get(i);
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramQueryTask_QueryPackageNameByAppID.e.get(i);
      if (localArkAppCGICallback != null)
      {
        if (paramArrayOfByte != null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, paramQueryTask_QueryPackageNameByAppID.j, localObject);
      }
      i += 1;
    }
  }
  
  private boolean a(String paramString, long paramLong, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        ArkAppCGI.QueryTask localQueryTask = (ArkAppCGI.QueryTask)localIterator.next();
        if ((localQueryTask.a.equalsIgnoreCase(paramString)) && (localQueryTask.g == paramLong))
        {
          localQueryTask.d.add(paramObject);
          localQueryTask.e.add(paramArkAppCGICallback);
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private int b(String paramString)
  {
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  final void a(ArkAppCGI.QueryTask paramQueryTask, ArkAppCGI.ITaskHttpResult arg2)
  {
    paramQueryTask.f = ???;
    synchronized (this.c)
    {
      this.c.add(paramQueryTask);
      ??? = this.b.d();
      if (??? == null)
      {
        QLog.i("ArkApp.ArkAppCGI", 1, "runTask_retry, app is null, return");
        return;
      }
      File localFile = new File(a());
      paramQueryTask.b = localFile;
      HashMap localHashMap = new HashMap();
      if (paramQueryTask.h != null) {
        localHashMap.put("Cookie", paramQueryTask.h);
      }
      if (paramQueryTask.i != null) {
        localHashMap.put("Referer", paramQueryTask.i);
      }
      NetUtil.a(???, paramQueryTask.a, localHashMap, localFile.toString(), new ArkAppCGI.1(this, paramQueryTask));
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ArkApp.ArkAppCGI", 1, "ArkSafe,doReport=null");
      return;
    }
    ArkAppSSO localArkAppSSO = this.b.k();
    if (localArkAppSSO == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArkSafe,doReport=");
    localStringBuilder.append(paramString);
    QLog.i("ArkApp.ArkAppCGI", 1, localStringBuilder.toString());
    localArkAppSSO.a("ArkAppReport.URLCheck", paramString, 10000, 0, new ArkAppCGI.4(this));
  }
  
  public void a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = this.b.d();
      if (localObject1 == null)
      {
        QLog.i("ArkApp.ArkAppCGI", 1, "queryPackageNameByAppID, app is null, return");
        return;
      }
      Object localObject2 = (TicketManager)((AppRuntime)localObject1).getManager(2);
      String str1 = ((TicketManager)localObject2).getPskey(((AppRuntime)localObject1).getCurrentAccountUin(), "connect.qq.com");
      if ((str1 != null) && (str1.length() > 0))
      {
        localObject2 = ((TicketManager)localObject2).getSkey(((AppRuntime)localObject1).getCurrentAccountUin());
        String str2 = String.format("https://cgi.connect.qq.com/qqconnectwebsite/v2/appinfo/apkname/get?appid=%s&token=%d", new Object[] { paramString, Integer.valueOf(b(str1)) });
        if (a(str2, -1L, paramObject, paramArkAppCGICallback)) {
          return;
        }
        ArkAppCGI.QueryTask_QueryPackageNameByAppID localQueryTask_QueryPackageNameByAppID = new ArkAppCGI.QueryTask_QueryPackageNameByAppID(null);
        for (localObject1 = ((AppRuntime)localObject1).getCurrentAccountUin(); ((String)localObject1).length() < 10; localObject1 = localStringBuilder.toString())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("0");
          localStringBuilder.append((String)localObject1);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("o");
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("p_uin=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("; p_skey=");
        localStringBuilder.append(str1);
        localStringBuilder.append("; uin=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("; skey=");
        localStringBuilder.append((String)localObject2);
        localQueryTask_QueryPackageNameByAppID.h = localStringBuilder.toString();
        localQueryTask_QueryPackageNameByAppID.a = str2;
        localQueryTask_QueryPackageNameByAppID.d.add(paramObject);
        localQueryTask_QueryPackageNameByAppID.e.add(paramArkAppCGICallback);
        localQueryTask_QueryPackageNameByAppID.j = paramString;
        localQueryTask_QueryPackageNameByAppID.i = "https://connect.qq.com";
        a(localQueryTask_QueryPackageNameByAppID, new ArkAppCGI.3(this));
        return;
      }
      QLog.i("ArkApp.ArkAppCGI", 1, "queryPackageNameByAppID, pskey is null, return");
      if (paramArkAppCGICallback != null) {
        paramArkAppCGICallback.a(false, null, paramString, paramObject);
      }
      return;
    }
    if (paramArkAppCGICallback != null) {
      paramArkAppCGICallback.a(false, null, paramString, paramObject);
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    ArkAppCGI.QueryTask localQueryTask = (ArkAppCGI.QueryTask)paramNetResp.mReq.getUserData();
    boolean bool1;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    SimpleDateFormat localSimpleDateFormat2 = null;
    boolean bool2 = bool1;
    Object localObject = localSimpleDateFormat2;
    SimpleDateFormat localSimpleDateFormat1;
    if (bool1) {
      try
      {
        localObject = localQueryTask.c.toByteArray();
        bool2 = bool1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.i("ArkApp.ArkAppCGI", 1, String.format("ArkAppCGI.onResp, out of memory, msg=%s", new Object[] { localOutOfMemoryError.getMessage() }));
        bool2 = false;
        localSimpleDateFormat1 = localSimpleDateFormat2;
      }
    }
    if (paramNetResp.mHttpCode == 304) {
      bool2 = true;
    }
    paramNetResp = (String)paramNetResp.mRespProperties.get("param_rspHeader");
    if (!TextUtils.isEmpty(paramNetResp))
    {
      paramNetResp = d.matcher(paramNetResp);
      if (!paramNetResp.find()) {}
    }
    try
    {
      paramNetResp = paramNetResp.group(1);
      localSimpleDateFormat2 = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
      localSimpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
      localQueryTask.g = localSimpleDateFormat2.parse(paramNetResp).getTime();
    }
    catch (ParseException paramNetResp)
    {
      label183:
      break label183;
    }
    QLog.i("ArkApp.ArkAppCGI", 1, String.format("lastModified time parse fail, url=%s", new Object[] { localQueryTask.a }));
    a(localQueryTask, bool2, localSimpleDateFormat1);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppCGI
 * JD-Core Version:    0.7.0.1
 */