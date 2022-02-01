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
  protected List<StoryAlbum.PicInfo> a()
  {
    Object localObject = super.a();
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      StoryAlbum.PicInfo localPicInfo = (StoryAlbum.PicInfo)((Iterator)localObject).next();
      if ((localPicInfo.jdField_b_of_type_Long >= ((SplitConfig.TimeSplitConfig)a()).jdField_a_of_type_Long) && (localPicInfo.jdField_b_of_type_Long <= ((SplitConfig.TimeSplitConfig)a()).jdField_b_of_type_Long)) {
        localArrayList.add(localPicInfo);
      }
    }
    return localArrayList;
  }
  
  protected List<StoryAlbum> a(@NonNull List<StoryAlbum.PicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new StoryAlbum(((SplitConfig.TimeSplitConfig)a()).jdField_a_of_type_Int, paramList);
    paramList.a(((SplitConfig.TimeSplitConfig)a()).jdField_a_of_type_Long, ((SplitConfig.TimeSplitConfig)a()).jdField_b_of_type_Long);
    paramList.a(a());
    paramList.b = ((SplitConfig.TimeSplitConfig)a()).c;
    Object localObject = StoryManager.a(QQStoryContext.a().a().createEntityManager(), StoryAlbumEntry.class, StoryAlbumEntry.class.getSimpleName(), "albumType=1 or albumType=6", null);
    if (localObject != null)
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", " there is an old time album : " + ((List)localObject).size());
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      StoryAlbumEntry localStoryAlbumEntry;
      if (((Iterator)localObject).hasNext())
      {
        localStoryAlbumEntry = (StoryAlbumEntry)((Iterator)localObject).next();
        if ((!TextUtils.equals(localStoryAlbumEntry.albumName, paramList.b)) || (localStoryAlbumEntry.startTime < ((SplitConfig.TimeSplitConfig)a()).jdField_a_of_type_Long) || (localStoryAlbumEntry.startTime > ((SplitConfig.TimeSplitConfig)a()).jdField_b_of_type_Long)) {}
      }
      else
      {
        try
        {
          paramList.b(StoryAlbum.a(localStoryAlbumEntry));
          paramList.a(localStoryAlbumEntry.getId());
          SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "time album  :" + paramList);
          if (paramList.b() >= ((SplitConfig.TimeSplitConfig)a()).jdField_b_of_type_Int) {
            break;
          }
          return null;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "old time album is not match :" + localStoryAlbumEntry.startTime);
    }
    localArrayList.add(paramList);
    return localArrayList;
  }
  
  public List<StoryAlbum> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.TimeSplitStrategy", "data is null");
      return null;
    }
    return a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.strategy.TimeSplitStrategy
 * JD-Core Version:    0.7.0.1
 */