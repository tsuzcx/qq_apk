package com.tencent.av;

public class VideoPackageUtils$VideoPacket
{
  public String a;
  public String b;
  public long c = 0L;
  public int d = 0;
  public long e = 0L;
  public int f = 0;
  public int g = 0;
  public long h = 0L;
  public int i = 0;
  public boolean j = false;
  public int k = 0;
  public long l = 0L;
  
  public boolean a()
  {
    return this.d == 3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPacket{roomId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", bodyType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", fromuin=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", subServiceType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", business_flag=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", terminal_switch_flag =");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", u32AccountType =");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", uint64_group_uin =");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", str_from_nation =");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", str_from_mobile =");
    boolean bool;
    if (this.a != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoPackageUtils.VideoPacket
 * JD-Core Version:    0.7.0.1
 */