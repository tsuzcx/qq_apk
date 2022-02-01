package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class Face2FaceAddContactUtils
{
  public static void a(long paramLong, List<Face2FaceFriendInfo> paramList)
  {
    int j = (int)(SystemClock.elapsedRealtime() - paramLong) / 1000;
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext()) {
      if (((Face2FaceFriendInfo)paramList.next()).a()) {
        i += 1;
      }
    }
    paramList = new StringBuilder();
    paramList.append(i);
    paramList.append("");
    paramList = paramList.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    a("0X800AB63", paramList, localStringBuilder.toString(), "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" face2faceReport tValue = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" r2 = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" r3 = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" r4 =");
      localStringBuilder.append(paramString4);
      QLog.d("Face2FaceAddContactUtils", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface) {}
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.getPreferences().getBoolean("face2face_add_contact_guide_dialog", false) ^ true;
    }
    return false;
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putBoolean("face2face_add_contact_guide_dialog", true);
      paramQQAppInterface.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactUtils
 * JD-Core Version:    0.7.0.1
 */