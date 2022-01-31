package com.tencent.biz.qqstory.channel;

import com.tencent.biz.qqstory.app.QQStoryContext;
import nbk;

public class CmdTaskManger
{
  public static volatile CmdTaskManger a;
  
  public static CmdTaskManger a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        CmdTaskManger localCmdTaskManger2 = a;
        localObject = localCmdTaskManger2;
        if (localCmdTaskManger2 == null)
        {
          localObject = new CmdTaskManger();
          a = (CmdTaskManger)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localCmdTaskManger1;
  }
  
  public void a(NetworkRequest paramNetworkRequest, CmdTaskManger.CommandCallback paramCommandCallback)
  {
    paramNetworkRequest = new nbk(paramNetworkRequest);
    paramNetworkRequest.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback = paramCommandCallback;
    paramNetworkRequest.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest.a(paramNetworkRequest);
    QQStoryContext.a().a().a(paramNetworkRequest.jdField_a_of_type_ComTencentBizQqstoryChannelNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.CmdTaskManger
 * JD-Core Version:    0.7.0.1
 */