package com.tencent.biz.pubaccount.util;

import com.tencent.commonsdk.cache.QQHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import usu;
import usv;

public final class PublicAccountConfigUtil$1
  extends QQHashMap<Integer, usv>
{
  public PublicAccountConfigUtil$1(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void clearMemory()
  {
    clear();
    usu.a().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.1
 * JD-Core Version:    0.7.0.1
 */