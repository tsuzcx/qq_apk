package com.tencent.mobileqq.ark.API;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class ArkSilkAudioPlayerHelper
{
  private static volatile ArrayList<WeakReference<ArkSilkAudioPlayerWrapper>> a = new ArrayList();
  
  public static void a()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      ArkSilkAudioPlayerWrapper localArkSilkAudioPlayerWrapper = (ArkSilkAudioPlayerWrapper)((WeakReference)localIterator.next()).get();
      if ((localArkSilkAudioPlayerWrapper != null) && (localArkSilkAudioPlayerWrapper.a()))
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
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkSilkAudioPlayerHelper
 * JD-Core Version:    0.7.0.1
 */