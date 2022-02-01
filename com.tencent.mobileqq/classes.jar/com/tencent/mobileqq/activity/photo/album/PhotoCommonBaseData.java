package com.tencent.mobileqq.activity.photo.album;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.queryMedia.ICursor.FilterListener;
import com.tencent.mobileqq.activity.photo.album.queryMedia.MediaQueryHelper;
import com.tencent.mobileqq.activity.photo.album.queryMedia.MediaQueryHelper.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class PhotoCommonBaseData<O extends OtherCommonData>
{
  public static final String FROM_PHOTO_LIST = "FROM_PHOTO_LIST";
  public static final String FROM_QZONE_PHOTO_LIST = "FROM_QZONE_PHOTO_LIST";
  public static final String FROM_WHERE_KEY = "FROM_WHERE";
  public static final int MAX_RECENT_PHOTO_NUM = -1;
  public static final String MY_UIN = "peak.myUin";
  public static final String NEED_NEW_PHOTO_COMMON_DATA = "NEED_NEW_PHOTO_COMMON_DATA";
  public static final String TAG = "AlbumModule";
  public static final int TYPE_SLIDESHOW = 1;
  private static volatile int holdLogicNumber = 0;
  private static volatile PhotoCommonBaseData instance;
  public String albumId;
  public String albumName;
  public HashMap<String, LocalMediaInfo> allMediaInfoHashMap = new HashMap();
  public int currentQualityType = 0;
  public MediaFileFilter filter;
  ICursor.FilterListener filterListener;
  public boolean filterVideoGif = false;
  public LocalMediaInfo firstRecentInfo;
  public LocalMediaInfo firstVideoInfo;
  public boolean isShowQzoneAlbum = false;
  public boolean mIsAwlaysShowNumber = false;
  public boolean mIsDisableTroopAlbum = false;
  public MediaQueryHelper mMediaQueryHelper;
  private O mOtherCommonData = null;
  public int maxSelectNum = 1;
  public ArrayList<String> mediaPathsList = new ArrayList();
  public String myUin;
  public boolean needMediaInfo = false;
  public int recentCount = -1;
  public int recentCountLimit = -1;
  public ArrayList<Integer> selectedIndex = new ArrayList();
  public HashMap<String, LocalMediaInfo> selectedMediaInfoHashMap = new HashMap();
  public ArrayList<String> selectedPhotoList = new ArrayList();
  public int showMediaType;
  public int videoCount = -1;
  public long videoDurationLimit = 9223372036854775807L;
  public long videoSizeLimit = 9223372036854775807L;
  
  public static PhotoCommonBaseData getInstance()
  {
    return getInstance(false);
  }
  
  static <O extends OtherCommonData> PhotoCommonBaseData<O> getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      instance = new PhotoCommonBaseData();
      return instance;
    }
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new PhotoCommonBaseData();
      }
      return instance;
    }
    finally {}
  }
  
  public void addHoldNember()
  {
    try
    {
      holdLogicNumber += 1;
      return;
    }
    finally {}
  }
  
  protected O bindCommonData(O paramO)
  {
    if (this.mOtherCommonData == null) {}
    try
    {
      if (this.mOtherCommonData == null) {
        this.mOtherCommonData = paramO;
      }
      return this.mOtherCommonData;
    }
    finally {}
  }
  
  /* Error */
  protected O bindCommonData(java.lang.Class<O> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	com/tencent/mobileqq/activity/photo/album/PhotoCommonBaseData:mOtherCommonData	Lcom/tencent/mobileqq/activity/photo/album/OtherCommonData;
    //   4: ifnonnull +29 -> 33
    //   7: ldc 136
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 79	com/tencent/mobileqq/activity/photo/album/PhotoCommonBaseData:mOtherCommonData	Lcom/tencent/mobileqq/activity/photo/album/OtherCommonData;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +14 -> 30
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 148	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   24: checkcast 136	com/tencent/mobileqq/activity/photo/album/OtherCommonData
    //   27: putfield 79	com/tencent/mobileqq/activity/photo/album/PhotoCommonBaseData:mOtherCommonData	Lcom/tencent/mobileqq/activity/photo/album/OtherCommonData;
    //   30: ldc 136
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 79	com/tencent/mobileqq/activity/photo/album/PhotoCommonBaseData:mOtherCommonData	Lcom/tencent/mobileqq/activity/photo/album/OtherCommonData;
    //   37: areturn
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 151	java/lang/IllegalAccessException:printStackTrace	()V
    //   43: goto -13 -> 30
    //   46: astore_1
    //   47: ldc 136
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 152	java/lang/InstantiationException:printStackTrace	()V
    //   57: goto -27 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	PhotoCommonBaseData
    //   0	60	1	paramClass	java.lang.Class<O>
    //   14	2	2	localOtherCommonData	OtherCommonData
    // Exception table:
    //   from	to	target	type
    //   19	30	38	java/lang/IllegalAccessException
    //   10	15	46	finally
    //   19	30	46	finally
    //   30	33	46	finally
    //   39	43	46	finally
    //   47	50	46	finally
    //   53	57	46	finally
    //   19	30	52	java/lang/InstantiationException
  }
  
  public boolean containNetImage()
  {
    Iterator localIterator = this.selectedPhotoList.iterator();
    while (localIterator.hasNext()) {
      if (QAlbumUtil.isNetUrl((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  void createFilterListener()
  {
    if (this.filterListener == null) {
      this.filterListener = new PhotoCommonBaseData.1(this);
    }
  }
  
  void createMediaQueryHelper(Context paramContext)
  {
    boolean bool1 = true;
    if (this.mMediaQueryHelper != null) {
      this.mMediaQueryHelper.close();
    }
    boolean bool2;
    if (this.filter != null)
    {
      bool2 = this.filter.showImage();
      bool1 = this.filter.showVideo();
    }
    for (;;)
    {
      createFilterListener();
      MediaQueryHelper.Builder localBuilder = new MediaQueryHelper.Builder().setAlbumId(this.albumId).setEachCount(50).needImage(bool2).needVideo(bool1).setListener(this.filterListener);
      if ((this.recentCountLimit > 0) && ("$RecentAlbumId".equals(this.albumId))) {
        localBuilder.setLimit(this.recentCountLimit);
      }
      this.mMediaQueryHelper = localBuilder.build(paramContext);
      return;
      bool2 = true;
    }
  }
  
  public void releaseCommonData()
  {
    try
    {
      holdLogicNumber -= 1;
      if (holdLogicNumber == 0)
      {
        if (this.mMediaQueryHelper != null) {
          this.mMediaQueryHelper.close();
        }
        instance = null;
        this.mOtherCommonData = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData
 * JD-Core Version:    0.7.0.1
 */