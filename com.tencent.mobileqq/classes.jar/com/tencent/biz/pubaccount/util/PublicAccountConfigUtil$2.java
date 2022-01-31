package com.tencent.biz.pubaccount.util;

import com.tencent.commonsdk.cache.QQHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import rsp;
import rsq;

public final class PublicAccountConfigUtil$2
  extends QQHashMap<Integer, rsq>
{
  public PublicAccountConfigUtil$2(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void clearMemory()
  {
    clear();
    rsp.a().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.2
 * JD-Core Version:    0.7.0.1
 */