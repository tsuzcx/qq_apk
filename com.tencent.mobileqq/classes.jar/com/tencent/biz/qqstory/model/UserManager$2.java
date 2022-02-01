package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.request.ConvertUinAndUnionIdRequest;
import com.tencent.biz.qqstory.network.response.ConvertUinAndUnionIdResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class UserManager$2
  implements CmdTaskManger.CommandCallback<ConvertUinAndUnionIdRequest, ConvertUinAndUnionIdResponse>
{
  UserManager$2(UserManager paramUserManager, QQUserUIItem.UserID paramUserID, boolean paramBoolean, long paramLong) {}
  
  public void a(ConvertUinAndUnionIdRequest arg1, ConvertUinAndUnionIdResponse paramConvertUinAndUnionIdResponse, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramConvertUinAndUnionIdResponse.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.d.a(???);
        this.a.a = ???.qq;
        this.a.b = ???.uid;
        if (this.b)
        {
          ??? = (StoryConfigManager)SuperManager.a(10);
          ???.d("qqstory_my_uin", this.a.a);
          ???.d("qqstory_my_union_id", this.a.b);
        }
      }
      SLog.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.a, Long.valueOf(l - this.c) });
    }
    else
    {
      SLog.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.c) });
    }
    synchronized (this.a)
    {
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.2
 * JD-Core Version:    0.7.0.1
 */