package com.tencent.biz.qqstory.album.segment;

import com.tencent.biz.qqstory.album.StoryAlbumConfig;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Iterator;
import java.util.List;

public class Album2DBSegment
  extends JobSegment<List<StoryAlbum>, List<StoryAlbum>>
{
  private ScanInfo a;
  
  public Album2DBSegment(ScanInfo paramScanInfo)
  {
    this.a = paramScanInfo;
  }
  
  protected void a(JobContext paramJobContext, List<StoryAlbum> paramList)
  {
    int i = 1;
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(paramList);
      return;
    }
    paramJobContext = paramList.iterator();
    while (paramJobContext.hasNext()) {
      ((StoryAlbum)paramJobContext.next()).a(this.a);
    }
    StoryScanManager.a(paramList);
    StoryScanManager localStoryScanManager = (StoryScanManager)SuperManager.a(30);
    StoryAlbumConfig localStoryAlbumConfig = localStoryScanManager.a();
    paramJobContext = paramList;
    if (!this.a.a())
    {
      paramJobContext = paramList;
      if (paramList.size() > localStoryAlbumConfig.a())
      {
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", "we scan album=" + paramList.size() + " ,but we only need " + localStoryAlbumConfig.a());
        paramJobContext = paramList.subList(0, localStoryAlbumConfig.a());
      }
    }
    if (localStoryScanManager.a(paramJobContext, this.a.a()))
    {
      long l2;
      for (long l1 = ((StoryAlbum)paramJobContext.get(0)).e(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((StoryAlbum)paramJobContext.get(i)).e();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((StoryAlbum)paramJobContext.get(0)).e());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.Album2DBSegment
 * JD-Core Version:    0.7.0.1
 */