package com.tencent.mobileqq.apollo.api.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class ApolloGameData
  extends Entity
  implements Serializable
{
  public static final String TAG = "ApolloGameData";
  private static final long serialVersionUID = 1L;
  public int actionId;
  public long appId;
  public String developerName;
  public String gameAppPkgName;
  public String gameAppid;
  @unique
  public int gameId;
  public int hasOwnArk;
  public boolean isFeatured;
  public boolean isGameApp;
  @notColumn
  public boolean isSetting;
  public int isShow;
  @notColumn
  public long lastRequestOpenKey;
  public String listCoverUrl;
  public String logoUrl;
  public String maxVer;
  public String minVer;
  public String name;
  public int needOpenKey;
  public String officialAccountUin;
  @notColumn
  public String openKey;
  public int screenMode;
  @notColumn
  public int tagType;
  @notColumn
  public String tagUrl;
  public String toolUrl;
  @notColumn
  public int type;
  public int viewMode;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloGameData{");
    localStringBuffer.append("gameId=").append(this.gameId).append(",name:").append(this.name).append(",isShow:").append(this.isShow).append(",min:").append(this.minVer).append(",max:").append(this.maxVer).append(",viewMode:").append(this.viewMode);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloGameData
 * JD-Core Version:    0.7.0.1
 */