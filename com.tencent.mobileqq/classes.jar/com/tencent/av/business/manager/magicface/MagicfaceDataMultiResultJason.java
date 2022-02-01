package com.tencent.av.business.manager.magicface;

public class MagicfaceDataMultiResultJason
{
  String divers_ani_hit;
  int divers_ani_hit_frame;
  String divers_ani_miss;
  int divers_ani_miss_frame;
  int divers_ani_start;
  int divers_hei = 0;
  int divers_wid = 0;
  int divers_x = 0;
  int divers_y = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MagicfaceDataMultiResultJason{divers_ani_id1='");
    localStringBuilder.append(this.divers_ani_hit);
    localStringBuilder.append('\'');
    localStringBuilder.append(", divers_ani_id2='");
    localStringBuilder.append(this.divers_ani_miss);
    localStringBuilder.append('\'');
    localStringBuilder.append(", divers_ani_start=");
    localStringBuilder.append(this.divers_ani_start);
    localStringBuilder.append(", divers_ani_hit_frame=");
    localStringBuilder.append(this.divers_ani_hit_frame);
    localStringBuilder.append(", divers_ani_miss_frame=");
    localStringBuilder.append(this.divers_ani_miss_frame);
    localStringBuilder.append(", divers_x=");
    localStringBuilder.append(this.divers_x);
    localStringBuilder.append(", divers_y=");
    localStringBuilder.append(this.divers_y);
    localStringBuilder.append(", divers_wid=");
    localStringBuilder.append(this.divers_wid);
    localStringBuilder.append(", divers_hei=");
    localStringBuilder.append(this.divers_hei);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceDataMultiResultJason
 * JD-Core Version:    0.7.0.1
 */