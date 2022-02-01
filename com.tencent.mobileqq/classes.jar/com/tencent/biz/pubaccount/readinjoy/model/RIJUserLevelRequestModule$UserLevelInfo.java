package com.tencent.biz.pubaccount.readinjoy.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class RIJUserLevelRequestModule$UserLevelInfo
  implements Serializable
{
  public int currentOpType;
  public String errorDialogContent;
  public String errorDialogTitle;
  public String jumpUrl;
  public long level;
  public Map<Integer, Boolean> opesAllowedMap = new HashMap();
  public long uin;
  
  public String toString()
  {
    return "UserLevelInfo{uin=" + this.uin + ", level=" + this.level + ", jumpUrl='" + this.jumpUrl + '\'' + ", opesAllowed=" + this.opesAllowedMap + ", currentOpType=" + this.currentOpType + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo
 * JD-Core Version:    0.7.0.1
 */