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
      ((StoryAlbum)paramJobContext.next()).a(this.a.toString());
    }
    StoryScanManager.b(paramList);
    StoryScanManager localStoryScanManager = (StoryScanManager)SuperManager.a(30);
    StoryAlbumConfig localStoryAlbumConfig = localStoryScanManager.g();
    paramJobContext = paramList;
    if (!this.a.c())
    {
      paramJobContext = paramList;
      if (paramList.size() > localStoryAlbumConfig.g())
      {
        paramJobContext = new StringBuilder();
        paramJobContext.append("we scan album=");
        paramJobContext.append(paramList.size());
        paramJobContext.append(" ,but we only need ");
        paramJobContext.append(localStoryAlbumConfig.g());
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.Album2DBSegment", paramJobContext.toString());
        paramJobContext = paramList.subList(0, localStoryAlbumConfig.g());
      }
    }
    if (localStoryScanManager.a(paramJobContext, this.a.c()))
    {
      long l2;
      for (long l1 = ((StoryAlbum)paramJobContext.get(0)).i(); i < paramJobContext.size(); l1 = l2)
      {
        long l3 = ((StoryAlbum)paramJobContext.get(i)).i();
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        i += 1;
      }
      this.a.a(((StoryAlbum)paramJobContext.get(0)).i());
      notifyResult(paramJobContext);
      return;
    }
    notifyError(new ErrorMessage(3, "save to db occur error!"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.Album2DBSegment
 * JD-Core Version:    0.7.0.1
 */