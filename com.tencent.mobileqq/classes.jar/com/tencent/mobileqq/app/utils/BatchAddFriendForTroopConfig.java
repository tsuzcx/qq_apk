package com.tencent.mobileqq.app.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class BatchAddFriendForTroopConfig
{
  private static final long[] a;
  public float a;
  public int a;
  public long a;
  public float b;
  public int b;
  public int c = 15;
  public int d = 2;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 10009L, 10010L, 10011L, 32L };
  }
  
  public BatchAddFriendForTroopConfig(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 100;
    this.jdField_a_of_type_Long = 1514736000L;
    this.jdField_a_of_type_Float = 0.01F;
    this.jdField_b_of_type_Float = 0.5F;
    a(SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), "batch_add_friend_for_troop_config"));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("BatchAddFriendForTroopConfig", 4, "update content is null!");
      }
    }
    for (;;)
    {
      return;
      for (;;)
      {
        try
        {
          paramString = new JSONObject(paramString);
          if (paramString.has("switchOn")) {
            this.jdField_a_of_type_Int = paramString.getInt("switchOn");
          }
          if (paramString.has("troopMemberNumLimit")) {
            this.jdField_b_of_type_Int = paramString.getInt("troopMemberNumLimit");
          }
          if (paramString.has("troopJoinDayLimit")) {
            this.c = paramString.getInt("troopJoinDayLimit");
          }
          if (paramString.has("commonFriendProportionLimit")) {
            this.jdField_a_of_type_Float = ((float)paramString.getDouble("commonFriendProportionLimit"));
          }
          if (paramString.has("troopJoinLine")) {
            str = paramString.getString("troopJoinLine");
          }
        }
        catch (Exception paramString)
        {
          String str;
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramString.printStackTrace();
          QLog.i("BatchAddFriendForTroopConfig", 2, "update exception ", paramString);
          continue;
        }
        try
        {
          this.jdField_a_of_type_Long = (new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str).getTime() / 1000L);
          if (paramString.has("nonFriendProportionLimit")) {
            this.jdField_b_of_type_Float = ((float)paramString.getDouble("nonFriendProportionLimit"));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("BatchAddFriendForTroopConfig", 2, String.format(Locale.getDefault(), "update {switchOn: %s, troopMemberNumLimit: %s, troopJoinDayLimit: %s, commonFriendProportionLimit:%s, troopJoinLine: %s, insertGrayTipLimit: %s, nonFriendProportionLimit: %s}", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Float.valueOf(this.jdField_a_of_type_Float), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.d), Float.valueOf(this.jdField_b_of_type_Float) }));
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {}
    for (;;)
    {
      return false;
      long[] arrayOfLong = jdField_a_of_type_ArrayOfLong;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        if (paramTroopInfo.dwGroupClassExt == l) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.BatchAddFriendForTroopConfig
 * JD-Core Version:    0.7.0.1
 */