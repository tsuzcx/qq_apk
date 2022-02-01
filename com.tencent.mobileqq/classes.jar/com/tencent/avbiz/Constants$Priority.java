package com.tencent.avbiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract interface Constants$Priority
{
  public static final HashMap<Long, List<HashSet<String>>> a;
  public static final HashSet<String> a;
  public static final List<HashSet<String>> a;
  public static final HashSet<String> b;
  public static final List<HashSet<String>> b;
  public static final HashSet<String> c;
  public static final HashSet<String> d;
  public static final HashSet<String> e;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet(Arrays.asList(new String[] { "系统通话" }));
    jdField_b_of_type_JavaUtilHashSet = new HashSet(Arrays.asList(new String[] { "音视频通话", "一起派对" }));
    c = new HashSet(Arrays.asList(new String[] { "ptt", "listen_together" }));
    d = new HashSet(Arrays.asList(new String[] { "voice_assistant", "开播啦鹅" }));
    jdField_a_of_type_JavaUtilList = new ArrayList(Arrays.asList(new HashSet[] { jdField_a_of_type_JavaUtilHashSet, jdField_b_of_type_JavaUtilHashSet, c, d }));
    e = new HashSet(Arrays.asList(new String[] { "音视频通话", "一起派对" }));
    jdField_b_of_type_JavaUtilList = new ArrayList(Arrays.asList(new HashSet[] { e }));
    jdField_a_of_type_JavaUtilHashMap = new Constants.Priority.1();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.Constants.Priority
 * JD-Core Version:    0.7.0.1
 */