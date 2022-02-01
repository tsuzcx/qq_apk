package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class PlayingListPreloader$OnFileDownloadListener
  extends SimplePreloadListener
{
  public PlayingListPreloader$OnFileDownloadListener(PlayingListPreloader paramPlayingListPreloader)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, paramErrorMessage, paramDownloadTask);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, DownloadTask paramDownloadTask)
  {
    PlayingListPreloader.CurrentVid localCurrentVid = this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid;
    if (localCurrentVid == null) {
      return;
    }
    if (!TextUtils.equals(paramString, localCurrentVid.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (paramErrorMessage.isFail())
    {
      if (TextUtils.isEmpty(localCurrentVid.b))
      {
        paramErrorMessage = paramErrorMessage.errorMsg;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramErrorMessage.errorMsg);
        localStringBuilder.append(" | ");
        localStringBuilder.append(paramErrorMessage.errorMsg);
        paramErrorMessage = localStringBuilder.toString();
      }
      localCurrentVid.b = paramErrorMessage;
      localCurrentVid.jdField_a_of_type_Int = (paramInt + 1000);
    }
    if (paramDownloadTask.a.containsKey("handleCallback"))
    {
      if (localCurrentVid.jdField_a_of_type_Boolean) {
        return;
      }
      localCurrentVid.jdField_a_of_type_Boolean = true;
      if (this.a.a(paramString))
      {
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener != null) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener.a(paramString, paramDownloadTask.d, paramInt);
        }
      }
      else if (this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener.a(paramString, paramDownloadTask.d, localCurrentVid.a(), paramInt);
      }
    }
  }
  
  public void b(String paramString, int paramInt, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt, paramDownloadTask);
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener.b(paramString, paramDownloadTask.d, paramInt);
    }
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, new ErrorMessage(), paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnFileDownloadListener
 * JD-Core Version:    0.7.0.1
 */