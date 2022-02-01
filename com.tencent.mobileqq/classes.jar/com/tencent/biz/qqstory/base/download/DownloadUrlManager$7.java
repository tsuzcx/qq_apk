package com.tencent.biz.qqstory.base.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class DownloadUrlManager$7
  implements CmdTaskManger.CommandCallback<GetVideoFullInfoListRequest, GetVideoFullInfoListResponse>
{
  DownloadUrlManager$7(DownloadUrlManager paramDownloadUrlManager, String paramString, Object paramObject, AtomicBoolean paramAtomicBoolean1, AtomicBoolean paramAtomicBoolean2) {}
  
  public void a(@NonNull GetVideoFullInfoListRequest arg1, @Nullable GetVideoFullInfoListResponse paramGetVideoFullInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramGetVideoFullInfoListResponse != null))
    {
      SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url success , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
      ??? = (StoryManager)SuperManager.a(5);
      if (paramGetVideoFullInfoListResponse.a != null)
      {
        paramErrorMessage = paramGetVideoFullInfoListResponse.a.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramGetVideoFullInfoListResponse.a = ???.a(paramGetVideoFullInfoListResponse.a);
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager.c(this.jdField_a_of_type_JavaLangString, 0);
    }
    else
    {
      SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url fail , vid : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      try
      {
        if (!this.b.get()) {
          break label181;
        }
        this.jdField_a_of_type_JavaLangObject.notifyAll();
      }
      catch (Exception paramGetVideoFullInfoListResponse)
      {
        label174:
        label181:
        break label174;
      }
      SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary lock error");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager.7
 * JD-Core Version:    0.7.0.1
 */