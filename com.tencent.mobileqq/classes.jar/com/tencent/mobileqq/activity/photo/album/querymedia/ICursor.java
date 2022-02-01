package com.tencent.mobileqq.activity.photo.album.querymedia;

import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class ICursor
{
  protected static final String[] BASE_COLUMS;
  private static final int INDEX_DATA_PATH = 1;
  private static final int INDEX_DATE_ADDED = 3;
  private static final int INDEX_DATE_MODIFIED = 4;
  private static final int INDEX_HEIGHT;
  private static final int INDEX_ID = 0;
  private static final int INDEX_MIME_TYPE = 2;
  private static final int INDEX_SIZE = 5;
  private static final int INDEX_WIDTH;
  public static final String ORDER_BY_DATE_MODIFIED = "date_modified DESC, date_added DESC";
  protected static final int SUB_START_INDEX;
  protected static final String[] WIDTH_HEIGHT_COLUMS;
  String mAlbumId;
  protected ArrayList<String> mColums;
  protected Cursor mCursor;
  ICursor.FilterListener mListener;
  protected String mSelector = "";
  
  static
  {
    int j = 6;
    BASE_COLUMS = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "_size" };
    WIDTH_HEIGHT_COLUMS = new String[] { "width", "height" };
    if (Build.VERSION.SDK_INT >= 16) {
      i = BASE_COLUMS.length + WIDTH_HEIGHT_COLUMS.length;
    } else {
      i = BASE_COLUMS.length;
    }
    SUB_START_INDEX = i;
    int i = Build.VERSION.SDK_INT;
    int k = -1;
    if (i >= 16) {
      i = j;
    } else {
      i = -1;
    }
    INDEX_WIDTH = i;
    i = k;
    if (Build.VERSION.SDK_INT >= 16) {
      i = 7;
    }
    INDEX_HEIGHT = i;
  }
  
  ICursor(Context paramContext, String paramString)
  {
    this.mAlbumId = paramString;
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals("$RecentAlbumId")) && (!paramString.equals("$VideoAlbumId")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bucket_id='");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'");
      this.mSelector = localStringBuilder.toString();
    }
    init();
    try
    {
      this.mCursor = createCursor(paramContext.getApplicationContext());
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("createCursor error:");
        paramString.append(paramContext.getMessage());
        QLog.i("QQAlbum", 2, paramString.toString());
      }
      this.mCursor = null;
    }
  }
  
  void close()
  {
    Cursor localCursor = this.mCursor;
    if ((localCursor != null) && (!localCursor.isClosed())) {
      this.mCursor.close();
    }
  }
  
  abstract Cursor createCursor(Context paramContext);
  
  int getCount()
  {
    Cursor localCursor = this.mCursor;
    if ((localCursor != null) && (!localCursor.isClosed())) {
      return this.mCursor.getCount();
    }
    return 0;
  }
  
  protected void init()
  {
    this.mColums = new ArrayList();
    this.mColums.addAll(Arrays.asList(BASE_COLUMS));
    if (Build.VERSION.SDK_INT >= 16) {
      this.mColums.addAll(Arrays.asList(WIDTH_HEIGHT_COLUMS));
    }
  }
  
  protected LocalMediaInfo makeMediaInfo()
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    Cursor localCursor = this.mCursor;
    if ((localCursor != null) && (!localCursor.isClosed()))
    {
      localLocalMediaInfo._id = this.mCursor.getLong(0);
      localLocalMediaInfo.path = this.mCursor.getString(1);
      localLocalMediaInfo.mMimeType = this.mCursor.getString(2);
      localLocalMediaInfo.addedDate = this.mCursor.getLong(3);
      localLocalMediaInfo.modifiedDate = this.mCursor.getLong(4);
      localLocalMediaInfo.fileSize = this.mCursor.getLong(5);
      if (Build.VERSION.SDK_INT >= 16)
      {
        localLocalMediaInfo.mediaWidth = this.mCursor.getInt(INDEX_WIDTH);
        localLocalMediaInfo.mediaHeight = this.mCursor.getInt(INDEX_HEIGHT);
      }
    }
    return localLocalMediaInfo;
  }
  
  boolean moveToPosition(int paramInt)
  {
    Cursor localCursor = this.mCursor;
    if ((localCursor != null) && (!localCursor.isClosed())) {
      return this.mCursor.moveToPosition(paramInt);
    }
    return false;
  }
  
  public boolean needMedia(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return false;
    }
    boolean bool2 = needMediaInfo(paramLocalMediaInfo);
    boolean bool1 = bool2;
    if (bool2)
    {
      ICursor.FilterListener localFilterListener = this.mListener;
      bool1 = bool2;
      if (localFilterListener != null) {
        bool1 = localFilterListener.needMediaInfo(paramLocalMediaInfo);
      }
    }
    return bool1;
  }
  
  protected boolean needMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo = paramLocalMediaInfo.path;
    if ((!TextUtils.isEmpty(paramLocalMediaInfo)) && (new File(paramLocalMediaInfo).exists())) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file not exists:");
      if (paramLocalMediaInfo == null) {
        paramLocalMediaInfo = "null";
      }
      localStringBuilder.append(paramLocalMediaInfo);
      QLog.i("QQAlbum", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void setListener(ICursor.FilterListener paramFilterListener)
  {
    this.mListener = paramFilterListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
 * JD-Core Version:    0.7.0.1
 */