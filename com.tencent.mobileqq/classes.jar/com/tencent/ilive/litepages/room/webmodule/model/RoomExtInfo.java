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
    if (paramString1 != null)
    {
      this.programId = paramString1;
      if (paramString2 == null) {
        break label60;
      }
      label17:
      this.state = paramString2;
      if (paramString3 == null) {
        break label66;
      }
      label26:
      this.liveType = paramString3;
      if (paramString4 == null) {
        break label72;
      }
      label36:
      this.followStatus = paramString4;
      if (paramString5 == null) {
        break label79;
      }
    }
    for (;;)
    {
      this.anchorUid = paramString5;
      return;
      paramString1 = "";
      break;
      label60:
      paramString2 = "";
      break label17;
      label66:
      paramString3 = "";
      break label26;
      label72:
      paramString4 = "";
      break label36;
      label79:
      paramString5 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo
 * JD-Core Version:    0.7.0.1
 */