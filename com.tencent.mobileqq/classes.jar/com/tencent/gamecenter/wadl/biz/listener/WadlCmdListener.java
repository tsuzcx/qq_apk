package com.tencent.gamecenter.wadl.biz.listener;

import android.content.Intent;
import java.util.HashSet;
import org.json.JSONObject;

public abstract interface WadlCmdListener
{
  public abstract HashSet<String> getFilterCmds();
  
  public abstract void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener
 * JD-Core Version:    0.7.0.1
 */