package com.tencent.common.danmaku.core;

import android.util.SparseArray;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.util.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DanmakuFactory
{
  private DanmakuContext a;
  private final SparseArray<BlockingQueue<BaseDanmaku>> b = new SparseArray();
  private final BlockingQueue<BaseDanmaku> c = new LinkedBlockingQueue();
  
  public DanmakuFactory(DanmakuContext paramDanmakuContext)
  {
    this.a = paramDanmakuContext;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public BaseDanmaku a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.b.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (BaseDanmaku)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.a.b(paramInt);
      Logger.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    else
    {
      Logger.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
    ((BaseDanmaku)localObject).j();
    ((BaseDanmaku)localObject).a(paramObject);
    return localObject;
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    int i = paramBaseDanmaku.q();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.b.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.b.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramBaseDanmaku);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuFactory
 * JD-Core Version:    0.7.0.1
 */