package com.tencent.biz.qqstory.msgTabNode.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class MsgTabStoryVideoPreloader$2
  extends SimpleJob<Void>
{
  MsgTabStoryVideoPreloader$2(MsgTabStoryVideoPreloader paramMsgTabStoryVideoPreloader, String paramString, List paramList)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = new ArrayList();
    paramVarArgs = this.a.iterator();
    while (paramVarArgs.hasNext())
    {
      Object localObject1 = (StoryVideoItem)paramVarArgs.next();
      Object localObject2 = DownloadTask.a(((StoryVideoItem)localObject1).mVid, 2);
      if (!TextUtils.isEmpty(((DownloadTask)localObject2).e))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("download thumb url=");
          localStringBuilder.append(((DownloadTask)localObject2).e);
          QLog.i("MsgTabStoryVideoPreloader", 2, localStringBuilder.toString());
        }
        this.b.f.add(((DownloadTask)localObject2).e);
        paramJobContext.add(localObject2);
      }
      localObject1 = DownloadTask.a(((StoryVideoItem)localObject1).mVid, 1);
      if (!TextUtils.isEmpty(((DownloadTask)localObject1).e))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("download mask url=");
          ((StringBuilder)localObject2).append(((DownloadTask)localObject1).e);
          QLog.i("MsgTabStoryVideoPreloader", 2, ((StringBuilder)localObject2).toString());
        }
        this.b.f.add(((DownloadTask)localObject1).e);
        paramJobContext.add(localObject1);
      }
      this.b.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader.2
 * JD-Core Version:    0.7.0.1
 */