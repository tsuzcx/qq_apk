package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class DynamicAvatarConfig
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  
  public DynamicAvatarConfig()
  {
    a();
  }
  
  public void a()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.dynamic_avatar.name());
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    this.jdField_a_of_type_Boolean = true;
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 11) {
          continue;
        }
        this.jdField_a_of_type_Boolean = false;
        if (Integer.valueOf(localObject[0]).intValue() != 1) {
          continue;
        }
        this.jdField_b_of_type_Boolean = true;
        if (!this.jdField_b_of_type_Boolean) {
          continue;
        }
        if (Integer.valueOf(localObject[1]).intValue() != 1) {
          continue;
        }
        this.jdField_c_of_type_Boolean = true;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DynamicAvatarConfig", 2, "parse config exception:" + localException.getMessage());
        continue;
        this.jdField_c_of_type_Boolean = false;
        continue;
        this.jdField_d_of_type_Boolean = false;
        continue;
        this.e = false;
        continue;
        this.f = false;
        continue;
        this.g = false;
        continue;
        this.h = false;
        continue;
        this.i = false;
        continue;
        this.j = false;
        continue;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        continue;
        if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0)) {
          continue;
        }
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DynamicAvatarConfig", 2, "maxPlayingCount or maxPlayCountOneDay <= 0");
        if (this.jdField_c_of_type_Int > 0) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DynamicAvatarConfig", 2, "adjust samllSizeFPS:" + this.jdField_c_of_type_Int);
        this.jdField_c_of_type_Int = 18;
        if (this.jdField_d_of_type_Int > 0) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DynamicAvatarConfig", 2, "adjust bigSizeFPS:" + this.jdField_d_of_type_Int);
        this.jdField_d_of_type_Int = 18;
      }
      if (Integer.valueOf(localObject[2]).intValue() != 1) {
        continue;
      }
      this.jdField_d_of_type_Boolean = true;
      if (Integer.valueOf(localObject[3]).intValue() != 1) {
        continue;
      }
      this.e = true;
      if (Integer.valueOf(localObject[4]).intValue() != 1) {
        continue;
      }
      this.f = true;
      if (Integer.valueOf(localObject[5]).intValue() != 1) {
        continue;
      }
      this.g = true;
      if (Integer.valueOf(localObject[6]).intValue() != 1) {
        continue;
      }
      this.h = true;
      if (Integer.valueOf(localObject[11]).intValue() != 1) {
        continue;
      }
      this.i = true;
      if (Integer.valueOf(localObject[12]).intValue() != 1) {
        continue;
      }
      this.j = true;
      this.jdField_a_of_type_Int = Integer.valueOf(localObject[7]).intValue();
      this.jdField_b_of_type_Int = Integer.valueOf(localObject[8]).intValue();
      this.jdField_c_of_type_Int = Integer.valueOf(localObject[9]).intValue();
      this.jdField_d_of_type_Int = Integer.valueOf(localObject[10]).intValue();
      if (!this.jdField_a_of_type_Boolean) {
        continue;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
      this.e = true;
      this.f = true;
      this.g = true;
      this.h = true;
      this.jdField_a_of_type_Int = 8;
      this.jdField_b_of_type_Int = 200;
      this.jdField_c_of_type_Int = 18;
      this.jdField_d_of_type_Int = 18;
      this.i = true;
      this.j = true;
      return;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("dpcString:").append(this.jdField_a_of_type_JavaLangString).append(",isPlayInAll:").append(this.jdField_b_of_type_Boolean).append(",isPlayInMsgTab:").append(this.jdField_c_of_type_Boolean).append(",isPlayInContacts:").append(this.jdField_d_of_type_Boolean).append(",isPlayInNearList:").append(this.e).append(",isPlayInFriendProfile:").append(this.f).append(",isPlayInNearProfile:").append(this.g).append(",isPlayInTroopProfile:").append(this.h).append(",maxPlayingCount:").append(this.jdField_a_of_type_Int).append(",maxPlayCountOneDay:").append(this.jdField_b_of_type_Int).append(",bigSizeFPS:").append(this.jdField_d_of_type_Int).append(",smallSizeFPS:").append(this.jdField_c_of_type_Int).append(",isConvsPlayAfterKill:").append(this.i).append(",isContactPlayAfterKill:").append(this.j).append(",isUseDefault:").append(this.jdField_a_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarConfig
 * JD-Core Version:    0.7.0.1
 */