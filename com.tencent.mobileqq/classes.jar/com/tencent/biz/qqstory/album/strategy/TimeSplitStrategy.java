package com.tencent.biz.qqstory.album.strategy;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.album.model.StoryAlbum;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimeSplitStrategy
  extends AbstractSplitStrategy<SplitConfig.TimeSplitConfig>
{
  protected List<StoryAlbum> a(@NonNull List<StoryAlbum.PicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new StoryAlbum(((SplitConfig.TimeSplitConfig)a()).a, paramList);
    paramList.a(((SplitConfig.TimeSplitConfig)a()).g, ((SplitConfig.TimeSplitConfig)a()).h);
    paramList.a(a());
    paramList.f = ((SplitConfig.TimeSplitConfig)a()).i;
    Object localObject1 = StoryManager.a(QQStoryContext.a().d().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" there is an old time album : ");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", ((StringBuilder)localObject2).toString());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StoryAlbumEntry)((Iterator)localObject1).next();
        if ((TextUtils.equals(((StoryAlbumEntry)localObject2).albumName, paramList.f)) && (((StoryAlbumEntry)localObject2).startTime >= ((SplitConfig.TimeSplitConfig)a()).g) && (((StoryAlbumEntry)localObject2).startTime <= ((SplitConfig.TimeSplitConfig)a()).h)) {
          try
          {
            paramList.b(StoryAlbum.a((StoryAlbumEntry)localObject2));
            paramList.a(((StoryAlbumEntry)localObject2).getId());
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("old time album is not match :");
        localStringBuilder2.append(((StoryAlbumEntry)localObject2).startTime);
        SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", localStringBuilder2.toString());
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("time album  :");
    localStringBuilder1.append(paramList);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", localStringBuilder1.toString());
    if (paramList.c() < ((SplitConfig.TimeSplitConfig)a()).b) {
      return null;
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  protected List<StoryAlbum.PicInfo> b()
  {
    Object localObject = super.b();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)((Iterator)localObject).next();
      if ((localPicInfo.g >= ((SplitConfig.TimeSplitConfig)a()).g) && (localPicInfo.g <= ((SplitConfig.TimeSplitConfig)a()).h)) {
        localArrayList.add(localPicInfo);
      }
    }
    return localArrayList;
  }
  
  public List<StoryAlbum> c()
  {
    List localList = b();
    if ((localList != null) && (localList.size() != 0)) {
      return a(localList);
    }
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.TimeSplitStrategy
 * JD-Core Version:    0.7.0.1
 */