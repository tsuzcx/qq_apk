package com.tencent.luggage.scanner.qbar;

import android.content.Context;
import com.tencent.luggage.scanner.camera.ScanUtil;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LuggageFileDecodeQueue
{
  private static LuggageFileDecodeQueue a = new LuggageFileDecodeQueue();
  private Map<Long, String> b = new HashMap();
  private Map<Long, LuggageFileDecodeQueue.FileDecodeCallBack> c = new HashMap();
  private Map<String, List<Long>> d = new HashMap();
  private Object e = new Object();
  private a f = new a("LuggageFileDecodeQueue");
  private ExecutorService g = Executors.newSingleThreadExecutor();
  
  public static LuggageFileDecodeQueue getInstance()
  {
    return a;
  }
  
  public void addDecodeTask(Context paramContext, long paramLong, String paramString, LuggageFileDecodeQueue.FileDecodeCallBack paramFileDecodeCallBack)
  {
    addDecodeTask(paramContext, paramLong, paramString, paramFileDecodeCallBack, new int[] { 1, 2, 4, 5 });
  }
  
  public void addDecodeTask(Context paramContext, long paramLong, String paramString, LuggageFileDecodeQueue.FileDecodeCallBack paramFileDecodeCallBack, int[] paramArrayOfInt)
  {
    synchronized (this.e)
    {
      if (this.b.size() < 5)
      {
        o.d("LuggageFileDecodeQueue", String.format("submit decode task %d", new Object[] { Long.valueOf(paramLong) }));
        this.b.put(Long.valueOf(paramLong), paramString);
        if (paramFileDecodeCallBack != null) {
          this.c.put(Long.valueOf(paramLong), paramFileDecodeCallBack);
        }
        if (!this.d.containsKey(paramString))
        {
          this.d.put(paramString, new ArrayList());
          this.g.execute(new LuggageFileDecodeQueue.a(this, paramString, ScanUtil.getAiModeParam(paramContext), paramArrayOfInt));
        }
        ((List)this.d.get(paramString)).add(Long.valueOf(paramLong));
      }
      else
      {
        o.c("LuggageFileDecodeQueue", "too many files are waiting!");
        paramFileDecodeCallBack.afterDecode(paramLong, null, null);
      }
      return;
    }
  }
  
  public void cancelDecodeTask(long paramLong)
  {
    synchronized (this.e)
    {
      if (this.b.containsKey(Long.valueOf(paramLong)))
      {
        String str = (String)this.b.get(Long.valueOf(paramLong));
        if (this.d.containsKey(str))
        {
          ((List)this.d.get(str)).remove(Long.valueOf(paramLong));
          if (((List)this.d.get(str)).isEmpty()) {
            this.d.remove(str);
          }
        }
        this.b.remove(Long.valueOf(paramLong));
        this.c.remove(Long.valueOf(paramLong));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.LuggageFileDecodeQueue
 * JD-Core Version:    0.7.0.1
 */