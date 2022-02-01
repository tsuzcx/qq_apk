package com.tencent.mobileqq.activity.photo.album;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.querymedia.ICursor.FilterListener;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class PhotoCommonBaseData<O extends OtherCommonData>
{
  public static final String FROM_PHOTO_LIST = "FROM_PHOTO_LIST";
  public static final String FROM_QZONE_PHOTO_LIST = "FROM_QZONE_PHOTO_LIST";
  public static final String FROM_WHERE_KEY = "FROM_WHERE";
  public static final int MAX_RECENT_PHOTO_NUM = -1;
  public static final String NEED_NEW_PHOTO_COMMON_DATA = "NEED_NEW_PHOTO_COMMON_DATA";
  public static final String TAG = "QQAlbum";
  private static volatile int holdLogicNumber;
  private static volatile PhotoCommonBaseData instance;
  public String albumId;
  public String albumName;
  public HashMap<String, LocalMediaInfo> allMediaInfoHashMap = new HashMap();
  public String customSendBtnText = null;
  public MediaFileFilter filter;
  public ICursor.FilterListener filterListener;
  public LocalMediaInfo firstRecentInfo;
  public LocalMediaInfo firstVideoInfo;
  public boolean isShowQzoneAlbum = false;
  public boolean isSingleMode = false;
  public MediaQueryHelper mMediaQueryHelper;
  private O mOtherCommonData = null;
  public int maxSelectNum = 1;
  public ArrayList<String> mediaPathsList = new ArrayList();
  public int recentCount = -1;
  public int recentCountLimit = -1;
  public ArrayList<Integer> selectedIndex = new ArrayList();
  public HashMap<String, LocalMediaInfo> selectedMediaInfoHashMap = new HashMap();
  public ArrayList<String> selectedPhotoList = new ArrayList();
  public int showMediaType;
  public int videoCount = -1;
  
  public static PhotoCommonBaseData getInstance()
  {
    return getInstance(false);
  }
  
  public static <O extends OtherCommonData> PhotoCommonBaseData<O> getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      instance = new PhotoCommonBaseData();
      return instance;
    }
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new PhotoCommonBaseData();
        }
      }
      finally {}
    }
    return instance;
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
  
  public O bindCommonData(O paramO)
  {
    if (this.mOtherCommonData == null) {
      try
      {
        if (this.mOtherCommonData == null) {
          this.mOtherCommonData = paramO;
        }
      }
      finally {}
    }
    return this.mOtherCommonData;
  }
  
  protected O bindCommonData(Class<O> paramClass)
  {
    if (this.mOtherCommonData == null) {
      try
      {
        OtherCommonData localOtherCommonData = this.mOtherCommonData;
        if (localOtherCommonData == null) {
          try
          {
            this.mOtherCommonData = ((OtherCommonData)paramClass.newInstance());
          }
          catch (InstantiationException paramClass)
          {
            paramClass.printStackTrace();
          }
          catch (IllegalAccessException paramClass)
          {
            paramClass.printStackTrace();
          }
        }
      }
      finally {}
    }
    return this.mOtherCommonData;
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
  
  public void createFilterListener()
  {
    if (this.filterListener == null) {
      this.filterListener = new PhotoCommonBaseData.MyFilterListener(this);
    }
  }
  
  public void createMediaQueryHelper(Context paramContext)
  {
    Object localObject = this.mMediaQueryHelper;
    if (localObject != null) {
      ((MediaQueryHelper)localObject).close();
    }
    localObject = this.filter;
    boolean bool2 = true;
    boolean bool1;
    if (localObject != null)
    {
      bool2 = ((MediaFileFilter)localObject).showImage();
      bool1 = this.filter.showVideo();
    }
    else
    {
      bool1 = true;
    }
    createFilterListener();
    localObject = new MediaQueryHelper.Builder().setAlbumId(this.albumId).setEachCount(50).needImage(bool2).needVideo(bool1).setListener(this.filterListener);
    if ((this.recentCountLimit > 0) && ("$RecentAlbumId".equals(this.albumId))) {
      ((MediaQueryHelper.Builder)localObject).setLimit(this.recentCountLimit);
    }
    this.mMediaQueryHelper = ((MediaQueryHelper.Builder)localObject).build(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData
 * JD-Core Version:    0.7.0.1
 */