package com.tencent.biz.qqstory.takevideo.tag;

import android.text.TextUtils;
import com.tencent.biz.qqstory.database.TagEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class TagItem$TagInfoBase
{
  public final long a;
  public final String b;
  public final String c;
  public final int d;
  public volatile long e;
  
  public TagItem$TagInfoBase(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
  }
  
  public TagItem$TagInfoBase(TagEntry paramTagEntry)
  {
    this.a = paramTagEntry.id;
    this.b = paramTagEntry.name;
    this.c = paramTagEntry.desc;
    this.d = paramTagEntry.type;
  }
  
  public TagItem$TagInfoBase(qqstory_struct.TagInfoBase paramTagInfoBase)
  {
    this.a = paramTagInfoBase.tag_id.get();
    this.b = paramTagInfoBase.tag_name.get();
    this.c = paramTagInfoBase.tag_desc.get();
    this.d = paramTagInfoBase.tag_type.get();
  }
  
  public static boolean a(TagInfoBase paramTagInfoBase)
  {
    return (paramTagInfoBase != null) && (Math.abs(System.currentTimeMillis() - paramTagInfoBase.e) < 60000L);
  }
  
  public TagEntry a()
  {
    return new TagEntry();
  }
  
  public qqstory_struct.TagInfoBase b()
  {
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(this.a);
    localTagInfoBase.tag_name.set(this.b);
    if (!TextUtils.isEmpty(this.c)) {
      localTagInfoBase.tag_desc.set(this.c);
    }
    localTagInfoBase.tag_type.set(this.d);
    return localTagInfoBase;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (TagInfoBase)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      return this.d == paramObject.d;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.a;
    return (int)(l ^ l >>> 32) * 31 + this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TagInfoBase{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase
 * JD-Core Version:    0.7.0.1
 */