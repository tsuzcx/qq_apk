package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

class ReadinjoySPEventReport$CommonAttrBuilder
{
  private List<oidb_cmd0x80a.AttributeList> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ReadinjoySPEventReport$CommonAttrBuilder(List<oidb_cmd0x80a.AttributeList> paramList)
  {
    Object localObject;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilList = localObject;
    }
  }
  
  public CommonAttrBuilder a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("CommonAttrBulder", 1, "attr value is Empty ! id : " + paramInt + ", name : " + paramString1);
      return this;
    }
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(paramInt);
    localAttributeList.att_name.set(paramString1);
    localAttributeList.att_value.set(paramString2);
    this.jdField_a_of_type_JavaUtilList.add(localAttributeList);
    return this;
  }
  
  public CommonAttrBuilder a(int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramInt, paramString, ReadinjoySPEventReport.Utils.a(paramBoolean, "1", "0"));
  }
  
  public CommonAttrBuilder a(oidb_cmd0x80a.AttributeList paramAttributeList)
  {
    if (paramAttributeList != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramAttributeList);
    }
    return this;
  }
  
  public List<oidb_cmd0x80a.AttributeList> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.CommonAttrBuilder
 * JD-Core Version:    0.7.0.1
 */