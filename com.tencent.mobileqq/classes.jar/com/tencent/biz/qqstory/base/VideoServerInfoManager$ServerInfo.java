package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.HexUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoServerInfoManager$ServerInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public byte[] f = new byte[1];
  public long g;
  
  public boolean a()
  {
    if (this.g > NetConnInfoCenter.getServerTimeMillis())
    {
      SLog.b("Q.qqstory.publish:VideoServerInfoManager", "server inf validate %s", this);
      return true;
    }
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "server inf invalidate %s", new Object[] { this });
    return false;
  }
  
  public boolean b()
  {
    return this.g <= NetConnInfoCenter.getServerTimeMillis() + 600000L;
  }
  
  public void c()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("t", this.g);
      localJSONObject.put("ak", HexUtil.bytes2HexStr(this.f));
      ((StoryConfigManager)SuperManager.a(10)).d("SP_KEY_AUTHKEY_SERVER_INFO", localJSONObject.toString());
      SLog.a("Q.qqstory.publish:VideoServerInfoManager", "save -> %s", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServerInfo{, userIp='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverIp1='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverIp2='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", backupServerIp1='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", backupServerIp2='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", expireTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("");
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.VideoServerInfoManager.ServerInfo
 * JD-Core Version:    0.7.0.1
 */