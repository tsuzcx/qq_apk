package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.IBatchGetVideoInfoCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MsgTabVideoPreloaderDataProvider$1
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  public void a()
  {
    QLog.e("MsgTabVideoPreloaderDataProvider", 1, new Object[] { "pull video info failed, vidList=", this.jdField_a_of_type_JavaUtilList });
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener.a(null, new Error());
    }
  }
  
  public void a(ArrayList<StoryVideoItem> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener.a(null, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.1
 * JD-Core Version:    0.7.0.1
 */