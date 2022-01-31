package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class KandianRedDotInfo
  implements Serializable
{
  public static final String REDDOT_TYPE_MAIN_VIDEO_TAB = "kandian_video_tab_reddot_info";
  public long algorithmID;
  public ArrayList articleIDList = new ArrayList();
  public String cookie;
  public String extInfo;
  public long strategyID;
  public String type;
  
  public KandianRedDotInfo(String paramString)
  {
    this.type = paramString;
  }
  
  public static KandianRedDotInfo getRedDotFromDisk(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    return (KandianRedDotInfo)ReadInJoyUtils.a(paramAppRuntime, paramString, paramBoolean);
  }
  
  public boolean hasArticleID()
  {
    return (this.articleIDList != null) && (!this.articleIDList.isEmpty());
  }
  
  public void removeFromDiskAsync(boolean paramBoolean)
  {
    ReadInJoyUtils.a(this.type, paramBoolean);
  }
  
  public void saveToDiskAsync(boolean paramBoolean)
  {
    ReadInJoyUtils.a(this.type, this, true);
  }
  
  public String toString()
  {
    return "KandianRedDotInfo{type='" + this.type + '\'' + ", articleIDList=" + this.articleIDList + ", algorithmID=" + this.algorithmID + ", strategyID=" + this.strategyID + ", cookie='" + this.cookie + '\'' + ", extInfo='" + this.extInfo + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo
 * JD-Core Version:    0.7.0.1
 */