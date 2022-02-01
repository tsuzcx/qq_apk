package com.tencent.gamecenter.wadl.biz.listener;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import java.util.ArrayList;

public abstract interface WadlProxyServiceCallBackInterface
{
  public abstract void a(WadlResult paramWadlResult);
  
  public abstract void a(ArrayList<WadlResult> paramArrayList);
  
  public abstract void b(ArrayList<WadlResult> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
 * JD-Core Version:    0.7.0.1
 */