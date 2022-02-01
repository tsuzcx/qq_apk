package com.tencent.gamecenter.wadl.biz.listener;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import java.util.HashSet;

public abstract interface WadlTrpcListener
{
  public abstract HashSet<String> getFilterCmds();
  
  public abstract void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
 * JD-Core Version:    0.7.0.1
 */