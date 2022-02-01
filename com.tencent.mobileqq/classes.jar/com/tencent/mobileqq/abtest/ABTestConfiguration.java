package com.tencent.mobileqq.abtest;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ABTestConfiguration
{
  private static final List<ExpEntityInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static ExpEntityInfo a(@NonNull String paramString)
  {
    Object localObject = null;
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ExpEntityInfo localExpEntityInfo = (ExpEntityInfo)localIterator.next();
      if ((localExpEntityInfo != null) && (!TextUtils.isEmpty(localExpEntityInfo.getExpName())))
      {
        if (!localExpEntityInfo.getExpName().equals(paramString)) {
          break label62;
        }
        localObject = localExpEntityInfo;
      }
    }
    label62:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  public static String a(@NonNull String paramString)
  {
    return String.format("%s_A", new Object[] { paramString.trim() });
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    a(b("exp_qq_msg_marketface_recommendtab_2"));
    a(b("exp_qq_msg_marketface_gif_icon"));
    a(b("exp_qq_msg_marketface_input_icon"));
    a(b("exp_qq_qav_zimu_entrance_1215"));
    a(b("exp_qq_qav_redbag_entrance_1215"));
    a(b("exp_qq_qav_record_entrance_1215"));
    a(b("exp_qq_qav_shoot_entrance_1215"));
  }
  
  public static void a(@NonNull ExpEntityInfo paramExpEntityInfo)
  {
    if (a(paramExpEntityInfo.getExpName()) == null) {
      jdField_a_of_type_JavaUtilList.add(paramExpEntityInfo);
    }
  }
  
  public static ExpEntityInfo b(String paramString)
  {
    return new ExpEntityInfo(paramString, a(paramString), b(paramString));
  }
  
  public static String b(@NonNull String paramString)
  {
    return String.format("%s_B", new Object[] { paramString.trim() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.abtest.ABTestConfiguration
 * JD-Core Version:    0.7.0.1
 */