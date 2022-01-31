package com.tencent.biz.pubaccount.util;

import com.tencent.commonsdk.cache.QQHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

final class PublicAccountConfigUtil$2
  extends QQHashMap
{
  PublicAccountConfigUtil$2(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void clearMemory()
  {
    clear();
    PublicAccountConfigUtil.a().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.2
 * JD-Core Version:    0.7.0.1
 */