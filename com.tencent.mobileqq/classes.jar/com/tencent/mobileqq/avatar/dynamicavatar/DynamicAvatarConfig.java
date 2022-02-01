package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class DynamicAvatarConfig
{
  public String a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public int j;
  public int k;
  public int l;
  public int m;
  public boolean n;
  public boolean o;
  
  public DynamicAvatarConfig()
  {
    a();
  }
  
  public void a()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.dynamic_avatar.name());
    this.a = ((String)localObject);
    this.b = true;
    try
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 11)
      {
        this.b = false;
        if (Integer.valueOf(localObject[0]).intValue() == 1) {
          this.c = true;
        } else {
          this.c = false;
        }
        if (this.c)
        {
          if (Integer.valueOf(localObject[1]).intValue() == 1) {
            this.d = true;
          } else {
            this.d = false;
          }
          if (Integer.valueOf(localObject[2]).intValue() == 1) {
            this.e = true;
          } else {
            this.e = false;
          }
          if (Integer.valueOf(localObject[3]).intValue() == 1) {
            this.f = true;
          } else {
            this.f = false;
          }
          if (Integer.valueOf(localObject[4]).intValue() == 1) {
            this.g = true;
          } else {
            this.g = false;
          }
          if (Integer.valueOf(localObject[5]).intValue() == 1) {
            this.h = true;
          } else {
            this.h = false;
          }
          if (Integer.valueOf(localObject[6]).intValue() == 1) {
            this.i = true;
          } else {
            this.i = false;
          }
          if (Integer.valueOf(localObject[11]).intValue() == 1) {
            this.n = true;
          } else {
            this.n = false;
          }
          if (Integer.valueOf(localObject[12]).intValue() == 1) {
            this.o = true;
          } else {
            this.o = false;
          }
        }
        else
        {
          this.d = false;
          this.e = false;
          this.f = false;
          this.g = false;
          this.h = false;
          this.i = false;
          this.n = false;
          this.o = false;
        }
        this.j = Integer.valueOf(localObject[7]).intValue();
        this.k = Integer.valueOf(localObject[8]).intValue();
        this.l = Integer.valueOf(localObject[9]).intValue();
        this.m = Integer.valueOf(localObject[10]).intValue();
      }
    }
    catch (Exception localException)
    {
      this.b = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("parse config exception:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("DynamicAvatarConfig", 2, localStringBuilder2.toString());
      }
    }
    if (this.b)
    {
      this.c = true;
      this.d = true;
      this.e = true;
      this.f = true;
      this.g = true;
      this.h = true;
      this.i = true;
      this.j = 8;
      this.k = 200;
      this.l = 18;
      this.m = 18;
      this.n = true;
      this.o = true;
      return;
    }
    if ((this.j <= 0) || (this.k <= 0))
    {
      this.c = false;
      this.d = false;
      this.e = false;
      this.f = false;
      this.g = false;
      this.h = false;
      this.i = false;
      this.n = false;
      this.o = false;
      if (QLog.isColorLevel()) {
        QLog.d("DynamicAvatarConfig", 2, "maxPlayingCount or maxPlayCountOneDay <= 0");
      }
    }
    StringBuilder localStringBuilder1;
    if (this.l <= 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("adjust samllSizeFPS:");
        localStringBuilder1.append(this.l);
        QLog.d("DynamicAvatarConfig", 2, localStringBuilder1.toString());
      }
      this.l = 18;
    }
    if (this.m <= 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("adjust bigSizeFPS:");
        localStringBuilder1.append(this.m);
        QLog.d("DynamicAvatarConfig", 2, localStringBuilder1.toString());
      }
      this.m = 18;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("dpcString:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",isPlayInAll:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",isPlayInMsgTab:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",isPlayInContacts:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",isPlayInNearList:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",isPlayInFriendProfile:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",isPlayInNearProfile:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",isPlayInTroopProfile:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",maxPlayingCount:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",maxPlayCountOneDay:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",bigSizeFPS:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(",smallSizeFPS:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(",isConvsPlayAfterKill:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(",isContactPlayAfterKill:");
    localStringBuilder.append(this.o);
    localStringBuilder.append(",isUseDefault:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarConfig
 * JD-Core Version:    0.7.0.1
 */