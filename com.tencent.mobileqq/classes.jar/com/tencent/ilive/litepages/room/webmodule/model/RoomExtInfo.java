package com.tencent.ilive.litepages.room.webmodule.model;

public class RoomExtInfo
{
  public String anchorUid;
  public String followStatus;
  public String liveType;
  public String programId;
  public String state;
  
  public RoomExtInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    this.programId = paramString1;
    if (paramString2 == null) {
      paramString2 = "";
    }
    this.state = paramString2;
    if (paramString3 == null) {
      paramString3 = "";
    }
    this.liveType = paramString3;
    if (paramString4 == null) {
      paramString4 = "";
    }
    this.followStatus = paramString4;
    if (paramString5 == null) {
      paramString5 = "";
    }
    this.anchorUid = paramString5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo
 * JD-Core Version:    0.7.0.1
 */