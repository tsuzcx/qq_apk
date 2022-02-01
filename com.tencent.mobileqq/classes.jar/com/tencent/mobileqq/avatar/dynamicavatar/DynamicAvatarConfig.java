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
    try
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 11)
      {
        this.jdField_a_of_type_Boolean = false;
        if (Integer.valueOf(localObject[0]).intValue() == 1) {
          this.jdField_b_of_type_Boolean = true;
        } else {
          this.jdField_b_of_type_Boolean = false;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (Integer.valueOf(localObject[1]).intValue() == 1) {
            this.jdField_c_of_type_Boolean = true;
          } else {
            this.jdField_c_of_type_Boolean = false;
          }
          if (Integer.valueOf(localObject[2]).intValue() == 1) {
            this.jdField_d_of_type_Boolean = true;
          } else {
            this.jdField_d_of_type_Boolean = false;
          }
          if (Integer.valueOf(localObject[3]).intValue() == 1) {
            this.e = true;
          } else {
            this.e = false;
          }
          if (Integer.valueOf(localObject[4]).intValue() == 1) {
            this.f = true;
          } else {
            this.f = false;
          }
          if (Integer.valueOf(localObject[5]).intValue() == 1) {
            this.g = true;
          } else {
            this.g = false;
          }
          if (Integer.valueOf(localObject[6]).intValue() == 1) {
            this.h = true;
          } else {
            this.h = false;
          }
          if (Integer.valueOf(localObject[11]).intValue() == 1) {
            this.i = true;
          } else {
            this.i = false;
          }
          if (Integer.valueOf(localObject[12]).intValue() == 1) {
            this.j = true;
          } else {
            this.j = false;
          }
        }
        else
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_d_of_type_Boolean = false;
          this.e = false;
          this.f = false;
          this.g = false;
          this.h = false;
          this.i = false;
          this.j = false;
        }
        this.jdField_a_of_type_Int = Integer.valueOf(localObject[7]).intValue();
        this.jdField_b_of_type_Int = Integer.valueOf(localObject[8]).intValue();
        this.jdField_c_of_type_Int = Integer.valueOf(localObject[9]).intValue();
        this.jdField_d_of_type_Int = Integer.valueOf(localObject[10]).intValue();
      }
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("parse config exception:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("DynamicAvatarConfig", 2, localStringBuilder2.toString());
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
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
    }
    if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      this.f = false;
      this.g = false;
      this.h = false;
      this.i = false;
      this.j = false;
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAvatarConfig", 2, "maxPlayingCount or maxPlayCountOneDay <= 0");
      }
    }
    StringBuilder localStringBuilder1;
    if (this.jdField_c_of_type_Int <= 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("adjust samllSizeFPS:");
        localStringBuilder1.append(this.jdField_c_of_type_Int);
        QLog.d("DynamicAvatarConfig", 2, localStringBuilder1.toString());
      }
      this.jdField_c_of_type_Int = 18;
    }
    if (this.jdField_d_of_type_Int <= 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("adjust bigSizeFPS:");
        localStringBuilder1.append(this.jdField_d_of_type_Int);
        QLog.d("DynamicAvatarConfig", 2, localStringBuilder1.toString());
      }
      this.jdField_d_of_type_Int = 18;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("dpcString:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",isPlayInAll:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(",isPlayInMsgTab:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(",isPlayInContacts:");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(",isPlayInNearList:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",isPlayInFriendProfile:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",isPlayInNearProfile:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",isPlayInTroopProfile:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",maxPlayingCount:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",maxPlayCountOneDay:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",bigSizeFPS:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(",smallSizeFPS:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",isConvsPlayAfterKill:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",isContactPlayAfterKill:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",isUseDefault:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarConfig
 * JD-Core Version:    0.7.0.1
 */