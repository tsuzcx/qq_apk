package com.tencent.biz.qqcircle.immersive.manager;

import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QFSPictureReloadManager
{
  private static volatile QFSPictureReloadManager b;
  private ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap();
  
  public static QFSPictureReloadManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QFSPictureReloadManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, String paramString, Rect paramRect)
  {
    paramRect = new Option().setFromPreLoad(true).setPredecode(false).setUrl(paramString).setRequestWidth(paramRect.width()).setRequestHeight(paramRect.height()).setPriority(paramInt + 1);
    paramString = QCircleFeedPicLoader.g().getCacheKey(paramRect);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("PIC-QFSPictureReloadManager", 1, "[preloadImage] key should not is empty.");
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.containsKey(paramString))) {
      return;
    }
    QLog.d("PIC-QFSPictureReloadManager", 1, new Object[] { "[preloadImage] image preload key: ", paramString, " | feed id: ", c(paramStFeed) });
    QCircleFeedPicLoader.g().loadImage(paramRect, new QFSPictureReloadManager.1(this));
    paramStFeed = this.a;
    if (paramStFeed != null) {
      paramStFeed.put(paramString, Boolean.valueOf(false));
    }
  }
  
  private boolean a(FeedCloudMeta.StFeed paramStFeed)
  {
    boolean bool = false;
    if (paramStFeed == null) {
      return false;
    }
    if (paramStFeed.type.get() == 2) {
      bool = true;
    }
    return bool;
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    List localList = paramStFeed.images.get();
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      int i = 0;
      while (i < localList.size())
      {
        FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)localList.get(i);
        a(paramStFeed, i, localStImage.picUrl.get(), new Rect(0, 0, localStImage.width.get(), localStImage.height.get()));
        i += 1;
      }
    }
  }
  
  private Object c(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return "null";
    }
    return paramStFeed.id.get();
  }
  
  public void a(List<FeedBlockData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)paramList.next()).b();
        if (a(localStFeed)) {
          b(localStFeed);
        }
      }
    }
  }
  
  public void b()
  {
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if ((localConcurrentHashMap != null) && (!localConcurrentHashMap.isEmpty())) {
      this.a.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.manager.QFSPictureReloadManager
 * JD-Core Version:    0.7.0.1
 */