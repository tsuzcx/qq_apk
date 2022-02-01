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
    paramVarArgs = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramVarArgs.hasNext())
    {
      Object localObject = (StoryVideoItem)paramVarArgs.next();
      DownloadTask localDownloadTask = DownloadTask.a(((StoryVideoItem)localObject).mVid, 2);
      if (!TextUtils.isEmpty(localDownloadTask.c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localDownloadTask.c);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.b.add(localDownloadTask.c);
        paramJobContext.add(localDownloadTask);
      }
      localObject = DownloadTask.a(((StoryVideoItem)localObject).mVid, 1);
      if (!TextUtils.isEmpty(((DownloadTask)localObject).c))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((DownloadTask)localObject).c);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.b.add(((DownloadTask)localObject).c);
        paramJobContext.add(localObject);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader.a.a(paramJobContext, false);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader.2
 * JD-Core Version:    0.7.0.1
 */