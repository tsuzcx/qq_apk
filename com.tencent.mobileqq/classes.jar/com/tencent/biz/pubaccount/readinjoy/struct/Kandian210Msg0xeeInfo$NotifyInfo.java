package com.tencent.biz.pubaccount.readinjoy.struct;

import java.io.Serializable;
import java.util.ArrayList;

public class Kandian210Msg0xeeInfo$NotifyInfo
  implements Serializable
{
  public long algorithmID;
  public int appPushType;
  public int arkEnable;
  public int commentLength;
  public String contextBrief;
  public long contextId;
  public String contextTitle;
  public int contextType;
  public int duration;
  public long endTime;
  public String extCookie;
  public String extInfo;
  public long folderStatus = 10L;
  public int fontSize;
  public String orangeWord;
  public Kandian210Msg0xeeInfo.OrdinaryPushInfo ordinaryPushInfo;
  public String pictureJumpURL;
  public ArrayList picturesURLList;
  public long sceneType;
  public int showLine;
  public Kandian210Msg0xeeInfo.SocialPushInfo socialPushInfo;
  public long strategyID;
  public int styleType;
  public Kandian210Msg0xeeInfo.UGCPushInfo ugcPushInfo;
  public long uin;
  public String userIconURL;
  public String username;
  public String videoBrief;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("NotifyInfo{\nappPushType=").append(this.appPushType).append("\n");
    if (this.ordinaryPushInfo != null)
    {
      str = this.ordinaryPushInfo.toString() + "\n";
      localStringBuilder = localStringBuilder.append(str);
      if (this.socialPushInfo == null) {
        break label494;
      }
      str = this.socialPushInfo.toString() + "\n";
      label97:
      localStringBuilder = localStringBuilder.append(str);
      if (this.ugcPushInfo == null) {
        break label500;
      }
    }
    label494:
    label500:
    for (String str = this.ugcPushInfo.toString() + "\n";; str = "")
    {
      return str + ", contextId=" + this.contextId + ", contextBrief='" + this.contextBrief + '\'' + ", contextTitle='" + this.contextTitle + '\'' + ", picturesURLList=" + this.picturesURLList + ", pictureJumpURL='" + this.pictureJumpURL + '\'' + ", orangeWord='" + this.orangeWord + '\'' + ", contextType='" + this.contextType + '\'' + ", videoBrief='" + this.videoBrief + '\'' + ", uin=" + this.uin + ", username='" + this.username + '\'' + ", userIconURL='" + this.userIconURL + '\'' + ", styleType=" + this.styleType + ", arkEnable=" + this.arkEnable + ", sceneType=" + this.sceneType + ", duration=" + this.duration + ", endTime=" + this.endTime + ", algorithmID=" + this.algorithmID + ", strategyID=" + this.strategyID + ", folderStatus=" + this.folderStatus + ", commentLength=" + this.commentLength + ", showLine=" + this.showLine + ", fontSize=" + this.fontSize + ", extInfo='" + this.extInfo + '\'' + ", extCookie='" + this.extCookie + '\'' + '}';
      str = "";
      break;
      str = "";
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo
 * JD-Core Version:    0.7.0.1
 */