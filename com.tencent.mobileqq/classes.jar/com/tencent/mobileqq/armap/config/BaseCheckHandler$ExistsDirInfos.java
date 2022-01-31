package com.tencent.mobileqq.armap.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class BaseCheckHandler$ExistsDirInfos
  implements Serializable
{
  public List commonFileList;
  public List mapConfigFileList;
  public List mapDayFileList;
  public List mapNightFileList;
  public List openBoxFileList;
  public HashMap poiFileList;
  public HashMap poiLogoFileList;
  public List skyFileList;
  public HashMap treeFileList;
  public List wealthGodFileList;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("treeSkinMD5:").append(this.treeFileList).append("\nmapConfigFileList:").append(this.mapConfigFileList).append("\nmapDayFileList:").append(this.mapDayFileList).append("\nmapNightFileList:").append(this.mapNightFileList).append("\nskyFileList:").append(this.skyFileList).append("\ntreeFileList:").append(this.treeFileList).append("\ncommonFileList:").append(this.commonFileList).append("\npoiFileList:").append(this.poiFileList).append("\npoiLogoFileList:").append(this.poiLogoFileList).append("\nwealthGodFileList:").append(this.wealthGodFileList);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.BaseCheckHandler.ExistsDirInfos
 * JD-Core Version:    0.7.0.1
 */