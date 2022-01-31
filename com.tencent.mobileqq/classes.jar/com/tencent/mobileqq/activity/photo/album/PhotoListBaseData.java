package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhotoListBaseData
{
  public static final String ALBUMLIST_ITEM_DURATION = "ALBUMLIST_ITEM_DURATION";
  public static final String ALBUMLIST_POSITION = "ALBUMLIST_POSITION";
  public static final float NOT_SELECTE_ALPHA = 0.3F;
  public static final String PHOTOLIST_START_POSITION = "PHOTOLIST_START_POSITION";
  public static final int PHOTO_POSITION_INVALID = -1;
  public static Map<String, LocalMediaInfo> newCaptureMediaInfo = new HashMap();
  public static int sPhotoListFirstPos = -1;
  public boolean backPressed = false;
  public HashSet<String> cancelPresendPathSet = new HashSet();
  public String currentPhotoPath;
  public String customSendBtnText = null;
  public MediaFileFilter filter;
  public long filterVideoDurationLimit;
  public boolean filterVideoGif = false;
  public boolean firstResume = true;
  public int gifSelectedCount = 0;
  public boolean hasShownMaxSelectToast = false;
  public boolean isRecodeLastAlbumPath = false;
  public boolean isShowCamera = false;
  public boolean isSingleMode = true;
  public boolean isSupportVideoCheckbox = false;
  public long lastTimeShowToast;
  public int maxVideoNum = 1;
  public boolean needQueryTask = true;
  public int photoListStartPos;
  public HashSet<String> presendPathSet = new HashSet();
  public int requestCode = 0;
  public LocalMediaInfo selectedVideoInfo = null;
  public boolean showCameraInVideo = false;
  public boolean showGifTypeIcon;
  public int showMediaType;
  public int videoSelectedCnt = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListBaseData
 * JD-Core Version:    0.7.0.1
 */