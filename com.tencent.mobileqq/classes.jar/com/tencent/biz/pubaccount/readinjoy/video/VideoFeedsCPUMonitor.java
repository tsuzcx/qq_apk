package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.BroadcastReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoFeedsCPUMonitor
{
  private static int jdField_a_of_type_Int;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new VideoFeedsCPUMonitor.1();
  private static final String jdField_a_of_type_JavaLangString = VideoFeedsCPUMonitor.class.getSimpleName();
  private static Thread jdField_a_of_type_JavaLangThread;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static AtomicInteger b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    b = new AtomicInteger(0);
    jdField_a_of_type_Int = 5;
    jdField_a_of_type_JavaLangThread = null;
  }
  
  private static long b()
  {
    for (long l = 0L; jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1; l += 1L) {}
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor
 * JD-Core Version:    0.7.0.1
 */