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
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      if ((this.jdField_a_of_type_JavaLangObject instanceof BaseActivityData)) {
        return ((BaseActivityData)this.jdField_a_of_type_JavaLangObject).id;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof PopBannerData)) {
        return ((PopBannerData)this.jdField_a_of_type_JavaLangObject).id;
      }
      if ((this.jdField_a_of_type_JavaLangObject instanceof MsgTabBannerData)) {
        return ((MsgTabBannerData)this.jdField_a_of_type_JavaLangObject).id;
      }
    }
    return "";
  }
  
  public String toString()
  {
    return "PartyTask{entryId=" + a() + ", type=" + Party.b(this.jdField_a_of_type_Int) + ", time=" + TimeFormatterUtils.b(this.jdField_a_of_type_Long) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.Party.PartyTask
 * JD-Core Version:    0.7.0.1
 */