package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.commonsdk.cache.QQHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

final class PublicAccountConfigUtilImpl$2
  extends QQHashMap<Integer, IPublicAccountConfigUtil.PublicAccountConfigFolder>
{
  PublicAccountConfigUtilImpl$2(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void clearMemory()
  {
    clear();
    PublicAccountConfigUtilImpl.access$000().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl.2
 * JD-Core Version:    0.7.0.1
 */