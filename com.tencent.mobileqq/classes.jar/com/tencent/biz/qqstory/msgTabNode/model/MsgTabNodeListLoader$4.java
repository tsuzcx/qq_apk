package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.StreamFunction;

class MsgTabNodeListLoader$4
  extends StreamFunction<MsgTabNodeInfo, MsgTabNodeInfo>
{
  int jdField_a_of_type_Int = 0;
  
  MsgTabNodeListLoader$4(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  protected void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] will fetch vidlist of uinion_id: %s", Integer.valueOf(i), paramMsgTabNodeInfo.a);
    notifyResult(paramMsgTabNodeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.4
 * JD-Core Version:    0.7.0.1
 */