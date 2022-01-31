package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.util.URLUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ndt;

public class AsyncFileDownloader
{
  protected AsyncFileDownloader.InnerAIOShortVideoDownloader a;
  protected AsyncFileDownloader.InnerBaseDownloader a;
  public String a;
  public List a;
  public Map a;
  
  public AsyncFileDownloader()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerBaseDownloader = new AsyncFileDownloader.InnerBaseDownloader(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerAIOShortVideoDownloader = new AsyncFileDownloader.InnerAIOShortVideoDownloader(this);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_JavaLangString);
      if (localDownloadTask != null) {
        localDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerDownloader.b(localDownloadTask);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(DownloadTask paramDownloadTask)
  {
    paramDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilMap.remove(paramDownloadTask.jdField_a_of_type_JavaLangString);
    if (paramDownloadTask != null)
    {
      paramDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerDownloader.b(paramDownloadTask);
      return true;
    }
    return false;
  }
  
  public boolean a(DownloadTask paramDownloadTask, AsyncFileDownloader.DownloadResult paramDownloadResult)
  {
    if (paramDownloadTask == null)
    {
      SLog.d("AsyncFileDownloader", "task is empty");
      return false;
    }
    if (TextUtils.isEmpty(paramDownloadTask.d))
    {
      if ((!TroopStoryUtil.a(paramDownloadTask.b)) || ((paramDownloadTask.jdField_a_of_type_Int != 2) && (paramDownloadTask.jdField_a_of_type_Int != 0))) {
        break label277;
      }
      QQStoryContext.a();
      localObject1 = TroopStoryUtil.a(QQStoryContext.a(), paramDownloadTask.b);
      if (!(localObject1 instanceof MessageForShortVideo)) {
        break label277;
      }
    }
    label277:
    for (Object localObject1 = (MessageForShortVideo)localObject1;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramDownloadResult != null) {
          paramDownloadResult.a(paramDownloadTask, new ErrorMessage(14, "ERR_URL_EMPTY"));
        }
        return false;
        localObject2 = null;
      }
      if (!NetworkUtils.a(QQStoryContext.a().a()))
      {
        if (paramDownloadResult != null) {
          paramDownloadResult.a(paramDownloadTask, new ErrorMessage(9004, "no net work"));
        }
        return false;
      }
      if (!b(paramDownloadTask))
      {
        if (paramDownloadResult != null) {
          paramDownloadResult.a(paramDownloadTask, new ErrorMessage(200, "ERR_VERIFY_ERROR"));
        }
        return false;
      }
      paramDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$DownloadResult = paramDownloadResult;
      paramDownloadTask.jdField_a_of_type_Long = System.currentTimeMillis();
      if (localObject2 != null) {
        paramDownloadTask.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = localObject2;
      }
      for (paramDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerDownloader = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerAIOShortVideoDownloader; !paramDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerDownloader.a(); paramDownloadTask.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerDownloader = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadAsyncFileDownloader$InnerBaseDownloader)
      {
        if (paramDownloadResult != null) {
          paramDownloadResult.a(paramDownloadTask, new ErrorMessage(15, "downloader not prepare"));
        }
        return false;
      }
      Bosses.get().postJob(new ndt(this, paramDownloadTask));
      return true;
    }
  }
  
  protected boolean b(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.d != null) && (paramDownloadTask.d.contains("qqstocdnd")))
    {
      String str = ((VideoServerInfoManager)SuperManager.a(4)).a();
      SLog.a("AsyncFileDownloader", "get url key:%s", str);
      if ((str == null) || (str.equals("00"))) {
        return false;
      }
      paramDownloadTask.d = URLUtil.a(paramDownloadTask.d, "authkey", str);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader
 * JD-Core Version:    0.7.0.1
 */