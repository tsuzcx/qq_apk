package com.tencent.biz.qqstory.album.segment;

import android.content.Context;
import com.tencent.biz.qqstory.album.ScanTask;
import com.tencent.biz.qqstory.album.StoryAlbumConfig;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GalleryScanSegment
  extends JobSegment<Integer, List<StoryAlbum.PicInfo>>
{
  private Context a;
  private ScanInfo b;
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "start GalleryScanSegment");
    paramInteger = (StoryConfigManager)SuperManager.a(10);
    paramJobContext = new ScanTask();
    Object localObject = Long.valueOf(-1L);
    long l2 = ((Long)paramInteger.c("key_last_pic_scan_time", localObject)).longValue();
    long l1 = ((Long)paramInteger.c("key_last_date_album_time", localObject)).longValue();
    if ((l2 != -1L) && (l1 != -1L))
    {
      this.b.a(true);
      paramInteger = paramJobContext.a(this.a, l2 + 1L, true, 10);
      if (paramInteger.isEmpty())
      {
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "No new picture scanned.");
        notifyResult(paramInteger);
        return;
      }
    }
    else
    {
      paramInteger = new StringBuilder();
      paramInteger.append("It is not inc scan :");
      paramInteger.append(true);
      paramInteger.append(",lastPicScanTime");
      paramInteger.append(l2);
      paramInteger.append(" ,lastDateAlbumTime=");
      paramInteger.append(l1);
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", paramInteger.toString());
      this.b.a(false);
      l1 = -1L;
    }
    paramInteger = ((StoryScanManager)SuperManager.a(30)).g();
    if (this.b.c()) {
      paramJobContext = paramJobContext.a(this.a, l1 + 1L, true, paramInteger.a(true));
    } else {
      paramJobContext = paramJobContext.a(this.a, l1, false, paramInteger.a(false));
    }
    if ((paramJobContext != null) && (!paramJobContext.isEmpty()))
    {
      StoryScanManager.c(paramJobContext);
      this.b.b(((StoryAlbum.PicInfo)paramJobContext.get(paramJobContext.size() - 1)).i);
      paramInteger = paramJobContext.iterator();
      while (paramInteger.hasNext()) {
        SLog.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "scan pic result=%s", (StoryAlbum.PicInfo)paramInteger.next());
      }
      paramInteger = new ArrayList();
      for (int i = 0; i < paramJobContext.size() - 1; i = j)
      {
        j = i + 1;
        if (((StoryAlbum.PicInfo)paramJobContext.get(j)).g - ((StoryAlbum.PicInfo)paramJobContext.get(i)).g > 2L) {
          paramInteger.add(paramJobContext.get(i));
        }
      }
      paramInteger.add(paramJobContext.get(paramJobContext.size() - 1));
      i = paramJobContext.size() - paramInteger.size();
      l2 = ((StoryAlbum.PicInfo)paramJobContext.get(0)).g;
      if (paramJobContext.size() > 1) {
        l1 = ((StoryAlbum.PicInfo)paramJobContext.get(paramJobContext.size() - 1)).g;
      } else {
        l1 = l2;
      }
      int j = paramInteger.size();
      l1 -= l2;
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "filter the similar last=%d repeatPicCount=%d time span=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l1) });
      paramJobContext = new StringBuilder();
      paramJobContext.append("");
      paramJobContext.append(i);
      paramJobContext = paramJobContext.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("");
      StoryReportor.a("video_shoot_slides", "same_reject", 0, 0, new String[] { paramJobContext, ((StringBuilder)localObject).toString() });
      notifyResult(paramInteger);
      return;
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "No picture scanned in your phone");
    notifyResult(paramJobContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.GalleryScanSegment
 * JD-Core Version:    0.7.0.1
 */