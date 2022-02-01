package com.tencent.biz.qqstory.msgTabNode.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;
import java.util.Queue;

class MsgTabStoryVideoPreloader$1
  extends SimpleJob<Void>
{
  MsgTabStoryVideoPreloader$1(MsgTabStoryVideoPreloader paramMsgTabStoryVideoPreloader, String paramString, Context paramContext, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (!MsgTabStoryVideoPreloader.a(this.c, this.a))
    {
      QLog.i("MsgTabStoryVideoPreloader", 2, "当前网络状态, 不启动预下载");
      return null;
    }
    QLog.i("MsgTabStoryVideoPreloader", 2, "启动消息TAB节点预加载器");
    paramJobContext = MsgTabStoryVideoPreloader.a(this.c, this.b);
    if ((!paramJobContext.isEmpty()) && (this.c.b()))
    {
      MsgTabStoryVideoPreloader.a(this.c);
      MsgTabStoryVideoPreloader.a(this.c, paramJobContext);
      this.c.c();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader.1
 * JD-Core Version:    0.7.0.1
 */