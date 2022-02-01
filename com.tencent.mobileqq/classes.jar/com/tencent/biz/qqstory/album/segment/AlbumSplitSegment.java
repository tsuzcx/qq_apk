package com.tencent.biz.qqstory.album.segment;

import android.content.SharedPreferences;
import com.tencent.biz.qqstory.album.StoryScanManager;
import com.tencent.biz.qqstory.album.flter.BaseAlbumFilter;
import com.tencent.biz.qqstory.album.flter.IAlbumFilter.IAlbumFilterListener;
import com.tencent.biz.qqstory.album.flter.RecommendAlbumFilter;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlbumSplitSegment
  extends JobSegment<List<StoryAlbum.PicInfo>, List<StoryAlbum>>
  implements IAlbumFilter.IAlbumFilterListener
{
  private ScanInfo jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo;
  private ArrayList<StoryAlbum> jdField_a_of_type_JavaUtilArrayList;
  private List<BaseAlbumFilter> jdField_a_of_type_JavaUtilList;
  
  public AlbumSplitSegment(ScanInfo paramScanInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo = paramScanInfo;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private List<BaseAlbumFilter> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((StoryScanManager)SuperManager.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new RecommendAlbumFilter(i, this.jdField_a_of_type_ComTencentBizQqstoryAlbumSegmentScanInfo));
    return localArrayList;
  }
  
  private void a(List<StoryAlbum.PicInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      BaseAlbumFilter localBaseAlbumFilter = (BaseAlbumFilter)this.jdField_a_of_type_JavaUtilList.remove(0);
      localBaseAlbumFilter.a(paramList);
      localBaseAlbumFilter.a(this);
      return;
    }
    paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramList.hasNext()) {
      StoryScanManager.a((StoryAlbum)paramList.next(), 10);
    }
    notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(JobContext paramJobContext, List<StoryAlbum.PicInfo> paramList)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    StoryScanManager.b(paramList);
    this.jdField_a_of_type_JavaUtilList = a(((StoryAlbum.PicInfo)paramList.get(0)).b, ((StoryAlbum.PicInfo)paramList.get(paramList.size() - 1)).b);
    a(paramList);
  }
  
  public void a(List<StoryAlbum> paramList, List<StoryAlbum.PicInfo> paramList1)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        StoryAlbum localStoryAlbum = (StoryAlbum)localIterator.next();
        SLog.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "onFilterFinish album:" + localStoryAlbum.toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.AlbumSplitSegment
 * JD-Core Version:    0.7.0.1
 */