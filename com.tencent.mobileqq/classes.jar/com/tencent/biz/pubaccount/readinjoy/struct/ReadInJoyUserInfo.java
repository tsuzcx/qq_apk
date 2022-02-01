package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.LiveStatus;

public class ReadInJoyUserInfo
  extends Entity
{
  @notColumn
  private static final String TAG = "ReadInJoyUserInfo";
  public int accountLevel;
  public int accountType;
  public String authorizeDesc;
  public String decorationIcon;
  public int decorationId;
  public String decorationName;
  public int faceFlag;
  public int faceType;
  public String faceUrl;
  @notColumn
  public int isApproved = -1;
  public String largeIconUrl;
  public long lastUpdateTimeMilliSecond = 0L;
  public oidb_cmd0xb81.LiveStatus liveStatus;
  public String nick;
  public boolean readlTimeRead = false;
  @notColumn
  public boolean requestFlag = false;
  public String smallIconUrl;
  public int systemID;
  public long timestamp;
  public String uin;
  
  private String getLiveStatusString()
  {
    if (this.liveStatus != null) {
      return String.format("{uint32_liveing: %d, uint64_live_time: %d, uint32_source: %d, str_url: %s}", new Object[] { Integer.valueOf(this.liveStatus.uint32_liveing.get()), Long.valueOf(this.liveStatus.uint64_live_time.get()), Integer.valueOf(this.liveStatus.uint32_source.get()), this.liveStatus.str_url.get() });
    }
    return null;
  }
  
  public int getLiveSource()
  {
    if ((this.liveStatus != null) && (this.liveStatus.uint32_source.has())) {
      return this.liveStatus.uint32_source.get();
    }
    return 0;
  }
  
  public String getLiveUrl()
  {
    if (this.liveStatus != null) {
      return this.liveStatus.str_url.get();
    }
    return null;
  }
  
  public boolean isLiving()
  {
    return (this.liveStatus != null) && (this.liveStatus.uint32_liveing.has()) && (this.liveStatus.uint32_liveing.get() == 1);
  }
  
  public boolean isReadlTimeRead()
  {
    return this.readlTimeRead;
  }
  
  public String toString()
  {
    return "ReadInJoyUserInfo, accountType = " + this.accountType + '\n' + "uin = " + this.uin + '\n' + "nick = " + this.nick + '\n' + "faceType = " + this.faceType + '\n' + "timestamp = " + this.timestamp + '\n' + "faceFlag = " + this.faceFlag + '\n' + "faceUrl = " + this.faceUrl + '\n' + "systemID = " + this.systemID + '\n' + "requestFlag = " + this.requestFlag + '\n' + "accountLevel = " + this.accountLevel + '\n' + "smallIconUrl = " + this.smallIconUrl + '\n' + "largeIconUrl = " + this.largeIconUrl + '\n' + "authorizeDesc = " + this.authorizeDesc + '\n' + "readlTimeRead = " + this.readlTimeRead + '\n' + "liveStatus = " + getLiveStatusString() + '\n' + "decorationName='" + this.decorationName + '\n' + "decorationId=" + this.decorationId + '\n' + "decorationIcon='" + this.decorationIcon + '\n' + "updateTimeMilliSecond = " + this.lastUpdateTimeMilliSecond + '\n';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo
 * JD-Core Version:    0.7.0.1
 */