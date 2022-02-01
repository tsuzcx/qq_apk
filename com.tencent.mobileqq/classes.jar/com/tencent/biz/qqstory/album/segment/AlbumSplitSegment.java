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
  private List<BaseAlbumFilter> a;
  private ArrayList<StoryAlbum> b;
  private ScanInfo c;
  
  private List<BaseAlbumFilter> a(long paramLong1, long paramLong2)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt("kmeans_interval_txt", 1);
    ArrayList localArrayList = new ArrayList();
    List localList = ((StoryScanManager)SuperManager.a(30)).a(paramLong1, paramLong2);
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    localArrayList.add(new RecommendAlbumFilter(i, this.c));
    return localArrayList;
  }
  
  private void a(List<StoryAlbum.PicInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && (this.a.size() > 0))
    {
      BaseAlbumFilter localBaseAlbumFilter = (BaseAlbumFilter)this.a.remove(0);
      localBaseAlbumFilter.a(paramList);
      localBaseAlbumFilter.a(this);
      return;
    }
    paramList = this.b.iterator();
    while (paramList.hasNext()) {
      StoryScanManager.a((StoryAlbum)paramList.next(), 10);
    }
    notifyResult(this.b);
  }
  
  protected void a(JobContext paramJobContext, List<StoryAlbum.PicInfo> paramList)
  {
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", "start runSegment piccount=%d", new Object[] { Integer.valueOf(paramList.size()) });
    if (paramList.isEmpty())
    {
      notifyResult(this.b);
      return;
    }
    StoryScanManager.c(paramList);
    this.a = a(((StoryAlbum.PicInfo)paramList.get(0)).g, ((StoryAlbum.PicInfo)paramList.get(paramList.size() - 1)).g);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFilterFinish album:");
        localStringBuilder.append(localStoryAlbum.toString());
        SLog.b("Q.qqstory.recommendAlbum.logic.StoryScanManager.AlbumSplitSegment", localStringBuilder.toString());
      }
      this.b.addAll(paramList);
    }
    a(paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.AlbumSplitSegment
 * JD-Core Version:    0.7.0.1
 */