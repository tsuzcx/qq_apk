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
  private Context jdField_a_of_type_AndroidContentContext;
  private ScanInfo jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo;
  
  public GalleryScanSegment(Context paramContext, ScanInfo paramScanInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo = paramScanInfo;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "start GalleryScanSegment");
    paramInteger = (StoryConfigManager)SuperManager.a(10);
    paramJobContext = new ScanTask();
    long l2 = ((Long)paramInteger.b("key_last_pic_scan_time", Long.valueOf(-1L))).longValue();
    long l1 = ((Long)paramInteger.b("key_last_date_album_time", Long.valueOf(-1L))).longValue();
    if ((l2 != -1L) && (l1 != -1L))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a(true);
      paramInteger = paramJobContext.a(this.jdField_a_of_type_AndroidContentContext, 1L + l2, true, 10);
      if (paramInteger.isEmpty())
      {
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "No new picture scanned.");
        notifyResult(paramInteger);
        return;
      }
      paramInteger = ((StoryScanManager)SuperManager.a(30)).a();
      if (!this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a()) {
        break label255;
      }
    }
    label255:
    for (paramJobContext = paramJobContext.a(this.jdField_a_of_type_AndroidContentContext, l1 + 1L, true, paramInteger.a(true));; paramJobContext = paramJobContext.a(this.jdField_a_of_type_AndroidContentContext, l1, false, paramInteger.a(false)))
    {
      if ((paramJobContext != null) && (!paramJobContext.isEmpty())) {
        break label275;
      }
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "No picture scanned in your phone");
      notifyResult(paramJobContext);
      return;
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "It is not inc scan :" + true + ",lastPicScanTime" + l2 + " ,lastDateAlbumTime=" + l1);
      this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.a(false);
      l1 = -1L;
      break;
    }
    label275:
    StoryScanManager.b(paramJobContext);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo.b(((StoryAlbum.PicInfo)paramJobContext.get(paramJobContext.size() - 1)).d);
    paramInteger = paramJobContext.iterator();
    while (paramInteger.hasNext()) {
      SLog.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "scan pic result=%s", (StoryAlbum.PicInfo)paramInteger.next());
    }
    paramInteger = new ArrayList();
    int i = 0;
    while (i < paramJobContext.size() - 1)
    {
      if (((StoryAlbum.PicInfo)paramJobContext.get(i + 1)).b - ((StoryAlbum.PicInfo)paramJobContext.get(i)).b > 2L) {
        paramInteger.add(paramJobContext.get(i));
      }
      i += 1;
    }
    paramInteger.add(paramJobContext.get(paramJobContext.size() - 1));
    i = paramJobContext.size() - paramInteger.size();
    l2 = ((StoryAlbum.PicInfo)paramJobContext.get(0)).b;
    if (paramJobContext.size() > 1) {}
    for (l1 = ((StoryAlbum.PicInfo)paramJobContext.get(paramJobContext.size() - 1)).b;; l1 = l2)
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.GalleryScanSegment", "filter the similar last=%d repeatPicCount=%d time span=%d", new Object[] { Integer.valueOf(paramInteger.size()), Integer.valueOf(i), Long.valueOf(l1 - l2) });
      StoryReportor.a("video_shoot_slides", "same_reject", 0, 0, new String[] { "" + i, l1 - l2 + "" });
      notifyResult(paramInteger);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.GalleryScanSegment
 * JD-Core Version:    0.7.0.1
 */