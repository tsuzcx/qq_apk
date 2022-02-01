package com.tencent.mobileqq.ark.api.silk;

import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

public class ArkSilkAudioPlayerHelper
{
  private static volatile ArrayList<WeakReference<ArkSilkAudioPlayerWrapper>> a = new ArrayList();
  
  public static void a()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      ArkSilkAudioPlayerWrapper localArkSilkAudioPlayerWrapper = (ArkSilkAudioPlayerWrapper)((WeakReference)localIterator.next()).get();
      if ((localArkSilkAudioPlayerWrapper != null) && (localArkSilkAudioPlayerWrapper.b()))
      {
        localArkSilkAudioPlayerWrapper.a(5);
        localArkSilkAudioPlayerWrapper.a();
      }
    }
  }
  
  public static void a(ArkSilkAudioPlayerWrapper paramArkSilkAudioPlayerWrapper)
  {
    a.add(new WeakReference(paramArkSilkAudioPlayerWrapper));
  }
  
  public static void b()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == null) {
        localIterator.remove();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerHelper
 * JD-Core Version:    0.7.0.1
 */