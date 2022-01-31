package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import teg;
import vvg;
import vvh;

public class TagUserItem
  extends BaseUIItem
  implements teg
{
  public long tagId;
  public vvg tagItem;
  public String tagName;
  
  public void convertFrom(qqstory_struct.TagItem paramTagItem)
  {
    if (paramTagItem.has())
    {
      this.tagItem = new vvg(paramTagItem);
      this.tagId = this.tagItem.a.jdField_a_of_type_Long;
      this.tagName = this.tagItem.a.jdField_a_of_type_JavaLangString;
    }
  }
  
  public String getName()
  {
    return this.tagName;
  }
  
  public int getRelationType()
  {
    return 0;
  }
  
  public String getUnionId()
  {
    return String.valueOf(this.tagId);
  }
  
  public boolean isFriend()
  {
    return false;
  }
  
  public boolean isMe()
  {
    return false;
  }
  
  public boolean isSubscribe()
  {
    return false;
  }
  
  public boolean isSubscribeButNoFriend()
  {
    return false;
  }
  
  public boolean isVip()
  {
    return false;
  }
  
  public boolean isVipButNoFriend()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.TagUserItem
 * JD-Core Version:    0.7.0.1
 */