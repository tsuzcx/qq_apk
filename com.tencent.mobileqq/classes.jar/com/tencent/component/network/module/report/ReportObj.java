package com.tencent.component.network.module.report;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.component.network.Global;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.SDCardUtil;
import org.json.JSONObject;

public class ReportObj
{
  public static final int APP_ID_HEAD = 6;
  public static final int APP_ID_PHOTO = 0;
  public static final int APP_ID_QQ_QUN_PHOTO = 10;
  public static final int APP_ID_SOUND = 4;
  public static final int APP_ID_UPP = 8;
  public static final int APP_ID_VIDEO = 2;
  private static final String APP_TYPE_HEAD = "qzone_head";
  private static final String APP_TYPE_PHOTO = "photo";
  private static final String APP_TYPE_QQ_QUN_PHOTO = "groupphoto";
  private static final String APP_TYPE_SOUND = "qzone_sound";
  private static final String APP_TYPE_UPP = "upp";
  private static final String APP_TYPE_VIDEO = "qzone_video";
  public static boolean IS_CONNECT_USB = false;
  public static final int OP_DOWN = 1;
  public static final int OP_UP = 0;
  public static final String REPORT_REFER_QQ_QUN = "mqun";
  private static final String REPORT_URL = "https://expeva.store.qq.com/";
  public String domain;
  public long downloadTime;
  public long elapse;
  public long endTime;
  public StringBuilder errMsg;
  public ExtendData extend;
  public long fileSize;
  public int flow;
  public boolean isFromQzoneAlbum;
  public boolean isHttp2;
  public boolean isSucceed;
  public int networkType = 0;
  public String refer = "unknown";
  public int retCode = 0;
  public String serverIp;
  public long startTime;
  public int strategyId;
  public String terminal = "Android";
  public String version = "0.0.1";
  
  public ReportObj()
  {
    this.serverIp = "";
    this.fileSize = 0L;
    this.elapse = 0L;
    this.errMsg = new StringBuilder();
    this.extend = null;
    this.isSucceed = false;
  }
  
  public ReportObj(int paramInt1, int paramInt2, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt3, String paramString2, ExtendData paramExtendData)
  {
    String str = "";
    this.serverIp = "";
    this.fileSize = 0L;
    this.elapse = 0L;
    this.errMsg = new StringBuilder();
    this.extend = null;
    this.isSucceed = false;
    this.networkType = paramInt1;
    this.retCode = paramInt2;
    this.serverIp = paramString1;
    this.fileSize = paramLong1;
    this.startTime = paramLong2;
    this.endTime = paramLong3;
    this.elapse = (paramLong3 - paramLong2);
    this.flow = paramInt3;
    if (paramString2 == null) {
      paramString2 = str;
    }
    this.errMsg.append(paramString2);
    this.extend = paramExtendData;
  }
  
  public static String getReportUrl(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 6)
          {
            if (paramInt1 != 8)
            {
              if (paramInt1 != 10) {
                return "";
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("https://expeva.store.qq.com/");
              ((StringBuilder)localObject).append("groupphoto");
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("https://expeva.store.qq.com/");
              ((StringBuilder)localObject).append("upp");
              localObject = ((StringBuilder)localObject).toString();
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("https://expeva.store.qq.com/");
            ((StringBuilder)localObject).append("qzone_head");
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https://expeva.store.qq.com/");
          ((StringBuilder)localObject).append("qzone_sound");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://expeva.store.qq.com/");
        ((StringBuilder)localObject).append("qzone_video");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://expeva.store.qq.com/");
      ((StringBuilder)localObject).append("photo");
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("?");
    Object localObject = localStringBuilder.toString();
    if (paramInt2 == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("op=upload");
      return localStringBuilder.toString();
    }
    if (paramInt2 == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("op=down");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static String putAddress(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append('.');
    paramInt >>>= 8;
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append('.');
    paramInt >>>= 8;
    localStringBuffer.append(paramInt & 0xFF);
    localStringBuffer.append('.');
    localStringBuffer.append(paramInt >>> 8 & 0xFF);
    return localStringBuffer.toString();
  }
  
  protected String getRefer()
  {
    return this.refer;
  }
  
  public void init()
  {
    this.terminal = Config.getTerminal();
    this.version = Config.getVersion();
    this.refer = Config.getRefer();
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("size", this.fileSize);
        localJSONObject.put("delay", this.elapse);
        localJSONObject.put("network", this.networkType);
        localJSONObject.put("terminal", this.terminal);
        localJSONObject.put("terminalver", this.version);
        localJSONObject.put("refer", getRefer());
        localJSONObject.put("errcode", this.retCode);
        localJSONObject.put("uin", Config.getCurrentUin());
        localJSONObject.put("time", this.endTime / 1000L);
        localJSONObject.put("flow", this.flow);
        localJSONObject.put("sip", this.serverIp);
        if ((this.errMsg != null) && (this.errMsg.length() > 0))
        {
          localJSONObject.put("msg", this.errMsg.toString());
          if (this.extend == null) {
            this.extend = new ExtendData();
          }
          Object localObject2 = ((WifiManager)Global.getContext().getSystemService("wifi")).getDhcpInfo();
          Object localObject1 = "none";
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(putAddress(((DhcpInfo)localObject2).dns1));
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(putAddress(((DhcpInfo)localObject2).dns2));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject2 = this.extend;
          String str = Build.MODEL;
          int j = 0;
          ((ExtendData)localObject2).put(0, str);
          this.extend.put(1, Build.VERSION.RELEASE);
          localObject2 = this.extend;
          if (!SDCardUtil.isSDCardMounted()) {
            break label413;
          }
          i = 1;
          ((ExtendData)localObject2).put(2, String.valueOf(i));
          this.extend.put(3, SDCardUtil.getSDCardCapabilityForDisplay());
          this.extend.put(4, SDCardUtil.getSDCardRemainForDisplay());
          this.extend.put(6, (String)localObject1);
          localObject1 = this.extend;
          i = j;
          if (IS_CONNECT_USB) {
            i = 1;
          }
          ((ExtendData)localObject1).put(7, String.valueOf(i));
          localJSONObject.put("extend", this.extend.getExtendString());
          return localJSONObject;
        }
      }
      catch (Throwable localThrowable)
      {
        QDLog.e("BusinessReport", "to json error!", localThrowable);
      }
      return localJSONObject;
      label413:
      int i = 0;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("networkType = ");
    int i = this.networkType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          localStringBuilder.append("未知");
        } else {
          localStringBuilder.append("2G");
        }
      }
      else {
        localStringBuilder.append("3G");
      }
    }
    else {
      localStringBuilder.append("WIFI");
    }
    localStringBuilder.append(" retCode = ");
    localStringBuilder.append(this.retCode);
    localStringBuilder.append(" fileSize = ");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(" elapse = ");
    localStringBuilder.append(this.elapse);
    localStringBuilder.append(" errMsg = ");
    localStringBuilder.append(this.errMsg.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.report.ReportObj
 * JD-Core Version:    0.7.0.1
 */