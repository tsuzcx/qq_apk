package com.tencent.biz.qqstory.storyHome.square.model;

import com.tencent.biz.qqstory.database.SquareBannerEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.SquareBannerItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class SquareBannerItem
{
  public String a;
  public String b;
  public String c;
  
  public SquareBannerItem(SquareBannerEntry paramSquareBannerEntry)
  {
    this.a = paramSquareBannerEntry.bannerId;
    this.b = paramSquareBannerEntry.imageUrl;
    this.c = paramSquareBannerEntry.jumpTargetUrl;
  }
  
  public SquareBannerItem(qqstory_struct.SquareBannerItem paramSquareBannerItem)
  {
    this.a = paramSquareBannerItem.item_id.get().toStringUtf8();
    this.b = paramSquareBannerItem.image.get().toStringUtf8();
    this.c = paramSquareBannerItem.jump_target_action.get().toStringUtf8();
  }
  
  public SquareBannerEntry a()
  {
    SquareBannerEntry localSquareBannerEntry = new SquareBannerEntry();
    localSquareBannerEntry.bannerId = this.a;
    localSquareBannerEntry.imageUrl = this.b;
    localSquareBannerEntry.jumpTargetUrl = this.c;
    return localSquareBannerEntry;
  }
  
  public String toString()
  {
    return "SquareBannerItem{bannerId='" + this.a + '\'' + ", imgUrl='" + this.b + '\'' + ", jumpTargetUrl='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.model.SquareBannerItem
 * JD-Core Version:    0.7.0.1
 */