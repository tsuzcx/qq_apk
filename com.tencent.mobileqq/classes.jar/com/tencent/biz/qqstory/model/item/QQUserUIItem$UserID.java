package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserId;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class QQUserUIItem$UserID
  implements Copyable
{
  public String a;
  public String b;
  
  public QQUserUIItem$UserID(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public boolean a()
  {
    return (QQStoryContext.a().b(this.b)) || (QQStoryContext.a().c(this.a));
  }
  
  public qqstory_struct.UserId b()
  {
    qqstory_struct.UserId localUserId = new qqstory_struct.UserId();
    if (!TextUtils.isEmpty(this.a)) {
      localUserId.uid.set(Long.valueOf(this.a).longValue());
    }
    localUserId.union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localUserId;
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof UserID))
    {
      paramObject = (UserID)paramObject;
      this.a = paramObject.a;
      this.b = paramObject.b;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserID{qq=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID
 * JD-Core Version:    0.7.0.1
 */