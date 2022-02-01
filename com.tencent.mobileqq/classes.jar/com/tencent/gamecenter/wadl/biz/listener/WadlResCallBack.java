package com.tencent.gamecenter.wadl.biz.listener;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import java.util.ArrayList;

public abstract interface WadlResCallBack
{
  public abstract void b(WadlResult paramWadlResult);
  
  public abstract void c(ArrayList<WadlResult> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.listener.WadlResCallBack
 * JD-Core Version:    0.7.0.1
 */