package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.network.handler.UidToVidHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

class VidToVideoInfoPuller$3
  extends SimpleJob<Object>
{
  VidToVideoInfoPuller$3(VidToVideoInfoPuller paramVidToVideoInfoPuller, String paramString)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (StoryManager)SuperManager.a(5);
    if (!this.a.l)
    {
      if (this.a.h == 3) {
        paramJobContext = paramJobContext.h(this.a.j);
      } else {
        paramJobContext = paramJobContext.e(this.a.j);
      }
    }
    else {
      paramJobContext = null;
    }
    paramVarArgs = paramJobContext;
    if (paramJobContext == null) {
      paramVarArgs = new ArrayList();
    }
    if (paramVarArgs.size() > 0)
    {
      this.a.a(paramVarArgs);
      SLog.d("Q.qqstory.net:VidToVideoInfoPuller", String.format("Found %s vid list from local , pullType is %d , %s", new Object[] { this.a.j, Integer.valueOf(this.a.h), paramVarArgs }));
      return null;
    }
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", String.format("Cannot found %s vid list from local , pullType is %d , request from net", new Object[] { this.a.j, Integer.valueOf(this.a.h) }));
    if (this.a.c == null)
    {
      paramJobContext = this.a;
      paramJobContext.c = new VidToVideoInfoPuller.StoryVidListReceiver(paramJobContext);
      StoryDispatcher.a().registerSubscriber(this.a.c);
    }
    paramJobContext = new ArrayList();
    paramJobContext.add(this.a.j);
    paramVarArgs = this.a;
    paramVarArgs.b = new UidToVidHandler(paramJobContext, paramVarArgs.h);
    this.a.b.a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller.3
 * JD-Core Version:    0.7.0.1
 */