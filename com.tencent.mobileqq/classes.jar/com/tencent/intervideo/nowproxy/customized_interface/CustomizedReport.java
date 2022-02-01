package com.tencent.intervideo.nowproxy.customized_interface;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowEntryData;

public abstract class CustomizedReport
{
  public abstract void onNowEntry(Bundle paramBundle, NowEntryData paramNowEntryData);
  
  public abstract void onReport(Bundle paramBundle);
  
  public abstract void setNowEntryData(NowEntryData paramNowEntryData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport
 * JD-Core Version:    0.7.0.1
 */