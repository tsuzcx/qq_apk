package com.tencent.mobileqq.activity.photo.album;

import aimj;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PhotoCommonBaseData
{
  public static final String FROM_PHOTO_LIST = "FROM_PHOTO_LIST";
  public static final String FROM_QZONE_PHOTO_LIST = "FROM_QZONE_PHOTO_LIST";
  public static final String FROM_WHERE_KEY = "FROM_WHERE";
  public static final int MAX_RECENT_PHOTO_NUM = 100;
  public static final String MY_UIN = "peak.myUin";
  public static final String NEED_NEW_PHOTO_COMMON_DATA = "NEED_NEW_PHOTO_COMMON_DATA";
  public static final String TAG = "AlbumModule";
  public static final int TYPE_SLIDESHOW = 1;
  private static volatile int holdLogicNumber = 0;
  static volatile aimj instance;
  public String albumId;
  public String albumName;
  public HashMap<String, LocalMediaInfo> allMediaInfoHashMap = new HashMap();
  public int currentQualityType = 0;
  public boolean isShowQzoneAlbum = false;
  public boolean mIsAwlaysShowNumber = false;
  public boolean mIsDisableTroopAlbum = false;
  public int maxSelectNum = 1;
  public ArrayList<String> mediaPathsList = new ArrayList();
  public String myUin;
  public boolean needMediaInfo = false;
  public ArrayList<Integer> selectedIndex = new ArrayList();
  public HashMap<String, LocalMediaInfo> selectedMediaInfoHashMap = new HashMap();
  public ArrayList<String> selectedPhotoList = new ArrayList();
  public long videoDurationLimit;
  public long videoSizeLimit;
  
  public static aimj getInstance()
  {
    return getInstance(false);
  }
  
  static aimj getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      instance = new aimj();
      return instance;
    }
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new aimj();
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
  
  public int getSelectedVideoNum()
  {
    Iterator localIterator = this.selectedMediaInfoHashMap.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (QAlbumUtil.getMediaType((LocalMediaInfo)((Map.Entry)localIterator.next()).getValue()) != 1) {
        break label57;
      }
      i += 1;
    }
    label57:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public void releaseCommonData()
  {
    try
    {
      holdLogicNumber -= 1;
      if (holdLogicNumber == 0) {
        instance = null;
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