package com.tencent.biz.qqstory.takevideo.tag;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class TagItem
{
  public final int a;
  public final TagItem.TagInfoBase a;
  public final String a;
  
  public TagItem(qqstory_struct.TagItem paramTagItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase = new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)paramTagItem.base_info.get());
    this.jdField_a_of_type_Int = paramTagItem.join_count.get();
    this.jdField_a_of_type_JavaLangString = paramTagItem.wording.get();
  }
  
  public TagItem(TagItem.TagInfoBase paramTagInfoBase, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase = paramTagInfoBase;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public TagItem(TagItemEntry paramTagItemEntry)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase = new TagItem.TagInfoBase(paramTagItemEntry.id, paramTagItemEntry.name, paramTagItemEntry.desc, paramTagItemEntry.type);
    this.jdField_a_of_type_Int = paramTagItemEntry.joinCount;
    this.jdField_a_of_type_JavaLangString = paramTagItemEntry.wording;
  }
  
  public TagItemEntry a()
  {
    TagItemEntry localTagItemEntry = new TagItemEntry();
    localTagItemEntry.id = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.jdField_a_of_type_Long;
    localTagItemEntry.name = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.jdField_a_of_type_JavaLangString;
    localTagItemEntry.desc = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.b;
    localTagItemEntry.type = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.jdField_a_of_type_Int;
    localTagItemEntry.joinCount = this.jdField_a_of_type_Int;
    localTagItemEntry.wording = this.jdField_a_of_type_JavaLangString;
    return localTagItemEntry;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TagItem)paramObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase != null) {
        return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.equals(paramObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase);
      }
    } while (paramObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "TagItem{tagInfo=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagTagItem$TagInfoBase + ", joinCount=" + this.jdField_a_of_type_Int + ", wording='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tag.TagItem
 * JD-Core Version:    0.7.0.1
 */