package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;

public class MsgTabPlayPageLoader$MsgTabGroupId
  extends IDataProvider.GroupId
{
  public int a;
  public MsgTabNodeInfo a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public MsgTabPlayPageLoader$MsgTabGroupId(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  static MsgTabGroupId a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    MsgTabGroupId localMsgTabGroupId = new MsgTabGroupId(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    localMsgTabGroupId.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo = paramMsgTabNodeInfo;
    if (paramMsgTabNodeInfo.jdField_a_of_type_Int == 12)
    {
      localMsgTabGroupId.d = paramMsgTabNodeInfo.e;
      localMsgTabGroupId.c = paramMsgTabNodeInfo.i;
    }
    return localMsgTabGroupId;
  }
  
  public String a()
  {
    MsgTabNodeInfo localMsgTabNodeInfo = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
    if (localMsgTabNodeInfo != null) {
      return localMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    MsgTabNodeInfo localMsgTabNodeInfo = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
    return (localMsgTabNodeInfo != null) && (localMsgTabNodeInfo.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId
 * JD-Core Version:    0.7.0.1
 */