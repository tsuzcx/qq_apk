package com.tencent.mobileqq.app.message;

import android.annotation.SuppressLint;
import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class OnLinePushMsgTypeProcessorDispatcher
  implements ProcessorDispatcherInterface
{
  private static Map<Integer, Pair<String, Integer>> a;
  private static Object b = new Object();
  
  public static String a(int paramInt)
  {
    return (String)((Pair)a.get(Integer.valueOf(paramInt))).first;
  }
  
  public static Map<Integer, Pair<String, Integer>> a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null) {
          b();
        }
      }
    }
    return a;
  }
  
  public static int b(int paramInt)
  {
    return ((Integer)((Pair)a.get(Integer.valueOf(paramInt))).second).intValue();
  }
  
  @SuppressLint({"UseSparseArrays"})
  private static void b()
  {
    a = new HashMap();
    a.put(Integer.valueOf(193), Pair.create("video_processor", Integer.valueOf(9002)));
    a.put(Integer.valueOf(734), Pair.create("video_processor", Integer.valueOf(9003)));
    a.put(Integer.valueOf(524), Pair.create("discuss_update_processor", Integer.valueOf(9010)));
    a.put(Integer.valueOf(736), Pair.create("info_update_processor", Integer.valueOf(9011)));
    a.put(Integer.valueOf(526), Pair.create("slave_master_processor", Integer.valueOf(9012)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OnLinePushMsgTypeProcessorDispatcher
 * JD-Core Version:    0.7.0.1
 */