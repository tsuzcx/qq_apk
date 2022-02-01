package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private HashMap<String, HashSet<Integer>> a = new HashMap();
  
  public static a a()
  {
    return a.a.a();
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.a.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      String str = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (HashSet)((Map.Entry)localObject3).getValue();
      ((HashSet)localObject3).remove(Integer.valueOf(paramInt));
      if (((HashSet)localObject3).isEmpty())
      {
        ((HashSet)localObject1).add(str);
        TXCAudioEngine.getInstance().stopRemoteAudio(str);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("stopPlay, tinyId:");
        ((StringBuilder)localObject3).append(str);
        TXCLog.i("AudioPlayManager", ((StringBuilder)localObject3).toString());
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.a.remove(localObject2);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = (HashSet)this.a.get(paramString);
    if (localObject == null) {
      return;
    }
    ((HashSet)localObject).remove(Integer.valueOf(paramInt));
    if (((HashSet)localObject).isEmpty())
    {
      this.a.remove(paramString);
      TXCAudioEngine.getInstance().stopRemoteAudio(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopRemoteAudio. tinyId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", sessionId:");
      ((StringBuilder)localObject).append(paramInt);
      TXCLog.i("AudioPlayManager", ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignore stopRemoteAudio. because the same user is playing in other session. tinyId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", cur sessionId:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", other sessionId:");
    localStringBuilder.append(((Integer)((HashSet)localObject).iterator().next()).intValue());
    TXCLog.i("AudioPlayManager", localStringBuilder.toString());
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    HashSet localHashSet = (HashSet)this.a.get(paramString);
    Object localObject = localHashSet;
    if (localHashSet == null)
    {
      localObject = new HashSet();
      this.a.put(paramString, localObject);
    }
    ((HashSet)localObject).add(Integer.valueOf(paramInt));
    TXCAudioEngine.getInstance().startRemoteAudio(paramString, paramBoolean);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startRemoteAudio tinyId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", sessionId:");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("AudioPlayManager", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.a
 * JD-Core Version:    0.7.0.1
 */