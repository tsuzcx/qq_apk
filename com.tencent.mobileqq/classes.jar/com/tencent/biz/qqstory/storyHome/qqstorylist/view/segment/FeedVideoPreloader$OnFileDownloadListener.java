package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.SimplePreloadListener;
import java.io.File;
import java.util.Map;

class FeedVideoPreloader$OnFileDownloadListener
  extends SimplePreloadListener
{
  public FeedVideoPreloader$OnFileDownloadListener(FeedVideoPreloader paramFeedVideoPreloader)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, paramErrorMessage, paramDownloadTask);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, DownloadTask paramDownloadTask)
  {
    FeedVideoPreloader.CurrentVid localCurrentVid = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$CurrentVid;
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
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener != null) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener.a(paramString, paramDownloadTask.d);
        }
      }
      else if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener.a(paramString, paramDownloadTask.d, localCurrentVid.a());
      }
    }
  }
  
  public void b(String paramString, int paramInt, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt, paramDownloadTask);
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader$OnVideoDownloadListener.b(paramString, paramDownloadTask.d);
    }
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, new ErrorMessage(), paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader.OnFileDownloadListener
 * JD-Core Version:    0.7.0.1
 */