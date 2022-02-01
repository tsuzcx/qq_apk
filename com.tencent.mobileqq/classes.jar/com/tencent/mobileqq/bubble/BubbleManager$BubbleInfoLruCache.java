package com.tencent.mobileqq.bubble;

import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class BubbleManager$BubbleInfoLruCache
  extends QQLruCache<Integer, BubbleInfo>
{
  public BubbleManager$BubbleInfoLruCache(BubbleManager paramBubbleManager, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void a()
  {
    Map localMap = snapshot();
    if (localMap != null)
    {
      Object localObject = localMap.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BubbleInfo)((Iterator)localObject).next()).a();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BubbleInfoLruCache cleared, size = ");
        ((StringBuilder)localObject).append(localMap.size());
        QLog.i("BubbleManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, BubbleInfo paramBubbleInfo1, BubbleInfo paramBubbleInfo2)
  {
    super.entryRemoved(paramBoolean, paramInteger, paramBubbleInfo1, paramBubbleInfo2);
    if (QLog.isColorLevel())
    {
      paramBubbleInfo2 = new StringBuilder();
      paramBubbleInfo2.append("entryRemoved key=");
      paramBubbleInfo2.append(paramInteger);
      QLog.d("BubbleManager", 2, paramBubbleInfo2.toString());
    }
    paramBubbleInfo1.a();
  }
  
  public boolean a(int paramInt)
  {
    return get(Integer.valueOf(paramInt)) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.BubbleInfoLruCache
 * JD-Core Version:    0.7.0.1
 */