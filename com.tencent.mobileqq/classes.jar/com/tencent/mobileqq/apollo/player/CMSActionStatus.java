package com.tencent.mobileqq.apollo.player;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "", "(Ljava/lang/String;I)V", "isEndState", "", "toReportErrorCode", "", "UNKNOWN", "START", "COMPLETE", "INTERRUPT", "ERROR_ACTION_RES_MISS", "ERROR_ACTION_PANEL_RES_MISS", "ERROR_SCRIPT_MISS", "ERROR_SURFACE_NOT_READY", "ERROR_BUILD_ACTION_JS", "ERROR_TIME_OUT", "ERROR_APNG_ENCODE_FAIL", "ERROR_APNG_RECORD_FRAME_EXCEED", "ERROR_APNG_RECORD_FRAME_OOM", "ERROR_ACTION_JSON_OUT_DATE", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum CMSActionStatus
{
  static
  {
    CMSActionStatus localCMSActionStatus1 = new CMSActionStatus("UNKNOWN", 0);
    UNKNOWN = localCMSActionStatus1;
    CMSActionStatus localCMSActionStatus2 = new CMSActionStatus("START", 1);
    START = localCMSActionStatus2;
    CMSActionStatus localCMSActionStatus3 = new CMSActionStatus("COMPLETE", 2);
    COMPLETE = localCMSActionStatus3;
    CMSActionStatus localCMSActionStatus4 = new CMSActionStatus("INTERRUPT", 3);
    INTERRUPT = localCMSActionStatus4;
    CMSActionStatus localCMSActionStatus5 = new CMSActionStatus("ERROR_ACTION_RES_MISS", 4);
    ERROR_ACTION_RES_MISS = localCMSActionStatus5;
    CMSActionStatus localCMSActionStatus6 = new CMSActionStatus("ERROR_ACTION_PANEL_RES_MISS", 5);
    ERROR_ACTION_PANEL_RES_MISS = localCMSActionStatus6;
    CMSActionStatus localCMSActionStatus7 = new CMSActionStatus("ERROR_SCRIPT_MISS", 6);
    ERROR_SCRIPT_MISS = localCMSActionStatus7;
    CMSActionStatus localCMSActionStatus8 = new CMSActionStatus("ERROR_SURFACE_NOT_READY", 7);
    ERROR_SURFACE_NOT_READY = localCMSActionStatus8;
    CMSActionStatus localCMSActionStatus9 = new CMSActionStatus("ERROR_BUILD_ACTION_JS", 8);
    ERROR_BUILD_ACTION_JS = localCMSActionStatus9;
    CMSActionStatus localCMSActionStatus10 = new CMSActionStatus("ERROR_TIME_OUT", 9);
    ERROR_TIME_OUT = localCMSActionStatus10;
    CMSActionStatus localCMSActionStatus11 = new CMSActionStatus("ERROR_APNG_ENCODE_FAIL", 10);
    ERROR_APNG_ENCODE_FAIL = localCMSActionStatus11;
    CMSActionStatus localCMSActionStatus12 = new CMSActionStatus("ERROR_APNG_RECORD_FRAME_EXCEED", 11);
    ERROR_APNG_RECORD_FRAME_EXCEED = localCMSActionStatus12;
    CMSActionStatus localCMSActionStatus13 = new CMSActionStatus("ERROR_APNG_RECORD_FRAME_OOM", 12);
    ERROR_APNG_RECORD_FRAME_OOM = localCMSActionStatus13;
    CMSActionStatus localCMSActionStatus14 = new CMSActionStatus("ERROR_ACTION_JSON_OUT_DATE", 13);
    ERROR_ACTION_JSON_OUT_DATE = localCMSActionStatus14;
    $VALUES = new CMSActionStatus[] { localCMSActionStatus1, localCMSActionStatus2, localCMSActionStatus3, localCMSActionStatus4, localCMSActionStatus5, localCMSActionStatus6, localCMSActionStatus7, localCMSActionStatus8, localCMSActionStatus9, localCMSActionStatus10, localCMSActionStatus11, localCMSActionStatus12, localCMSActionStatus13, localCMSActionStatus14 };
  }
  
  private CMSActionStatus() {}
  
  public final boolean isEndState()
  {
    switch (CMSActionStatus.WhenMappings.b[ordinal()])
    {
    default: 
      return true;
    }
    return false;
  }
  
  public final int toReportErrorCode()
  {
    switch (CMSActionStatus.WhenMappings.a[ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 1: 
    case 2: 
    case 3: 
      return 0;
    case 4: 
      return -13400;
    case 5: 
      return -13401;
    case 6: 
      return -13402;
    case 7: 
      return -13403;
    case 8: 
      return -13404;
    case 9: 
      return -13405;
    case 10: 
      return -13406;
    case 11: 
      return -13407;
    case 12: 
      return -13408;
    case 13: 
      return -13409;
    }
    return -13410;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSActionStatus
 * JD-Core Version:    0.7.0.1
 */