package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class Party$PartyTask
{
  public int a;
  public long a;
  public Object a;
  
  public Party$PartyTask(int paramInt, long paramLong, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (localObject != null)
    {
      if ((localObject instanceof BaseActivityData)) {
        return ((BaseActivityData)localObject).id;
      }
      if ((localObject instanceof PopBannerData)) {
        return ((PopBannerData)localObject).id;
      }
      if ((localObject instanceof MsgTabBannerData)) {
        return ((MsgTabBannerData)localObject).id;
      }
    }
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PartyTask{entryId=");
    localStringBuilder.append(a());
    localStringBuilder.append(", type=");
    localStringBuilder.append(Party.b(this.jdField_a_of_type_Int));
    localStringBuilder.append(", time=");
    localStringBuilder.append(TimeFormatterUtils.b(this.jdField_a_of_type_Long));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.Party.PartyTask
 * JD-Core Version:    0.7.0.1
 */