package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class EffectPendantTools$DataReport
{
  static long jdField_a_of_type_Long;
  static String jdField_a_of_type_JavaLangString;
  private static String b = "actAVFunChatDecorate";
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface.a(2))
    {
      paramVideoAppInterface = (PendantItem)((EffectPendantTools)paramVideoAppInterface.a(2)).a();
      if ((paramVideoAppInterface != null) && (!TextUtils.isEmpty(paramVideoAppInterface.getId()))) {
        a(null);
      }
    }
  }
  
  static void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (!Utils.a(paramString, jdField_a_of_type_JavaLangString))
    {
      if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (jdField_a_of_type_Long != 0L))
      {
        long l2 = jdField_a_of_type_Long;
        a(jdField_a_of_type_JavaLangString, (l1 - l2) / 1000L);
      }
      jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Long = l1;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      long l = (System.currentTimeMillis() - paramLong) / 1000L;
      HashMap localHashMap = new HashMap();
      localHashMap.put("tempID", paramString);
      localHashMap.put("duration", l + "");
      UserAction.onUserAction(b, true, -1L, -1L, localHashMap, true);
      AVLog.c("EffectPendantTools", " ID: " + paramString + "  pendant time: " + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport
 * JD-Core Version:    0.7.0.1
 */