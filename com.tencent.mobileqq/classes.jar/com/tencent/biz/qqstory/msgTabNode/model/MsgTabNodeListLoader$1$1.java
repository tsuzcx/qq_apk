package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MsgTabNodeListLoader$1$1
  implements Runnable
{
  MsgTabNodeListLoader$1$1(MsgTabNodeListLoader.1 param1, GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader$1.a.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
    }
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_JavaUtilList != null)
    {
      ??? = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (QQUserUIItem)((Iterator)???).next();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader$1.a.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      }
    }
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader$1.a.d)
    {
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader$1.a.d.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)((Iterator)localObject2).next()).a();
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.1.1
 * JD-Core Version:    0.7.0.1
 */