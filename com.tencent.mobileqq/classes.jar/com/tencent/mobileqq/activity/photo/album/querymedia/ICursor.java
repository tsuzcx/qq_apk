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
    int j = -1;
    BASE_COLUMS = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "_size" };
    WIDTH_HEIGHT_COLUMS = new String[] { "width", "height" };
    if (Build.VERSION.SDK_INT >= 16)
    {
      i = BASE_COLUMS.length + WIDTH_HEIGHT_COLUMS.length;
      SUB_START_INDEX = i;
      if (Build.VERSION.SDK_INT < 16) {
        break label120;
      }
    }
    label120:
    for (int i = 6;; i = -1)
    {
      INDEX_WIDTH = i;
      i = j;
      if (Build.VERSION.SDK_INT >= 16) {
        i = 7;
      }
      INDEX_HEIGHT = i;
      return;
      i = BASE_COLUMS.length;
      break;
    }
  }
  
  ICursor(Context paramContext, String paramString)
  {
    this.mAlbumId = paramString;
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals("$RecentAlbumId")) && (!paramString.equals("$VideoAlbumId"))) {
      this.mSelector = ("bucket_id='" + paramString + "'");
    }
    init();
    try
    {
      this.mCursor = createCursor(paramContext.getApplicationContext());
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MediaQuery", 2, "createCursor error:" + paramContext.getMessage());
      }
      this.mCursor = null;
    }
  }
  
  void close()
  {
    if ((this.mCursor != null) && (!this.mCursor.isClosed())) {
      this.mCursor.close();
    }
  }
  
  abstract Cursor createCursor(Context paramContext);
  
  int getCount()
  {
    if ((this.mCursor != null) && (!this.mCursor.isClosed())) {
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
    if ((this.mCursor != null) && (!this.mCursor.isClosed()))
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
    if ((this.mCursor != null) && (!this.mCursor.isClosed())) {
      return this.mCursor.moveToPosition(paramInt);
    }
    return false;
  }
  
  public boolean needMedia(LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool1;
    if (paramLocalMediaInfo == null) {
      bool1 = false;
    }
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        bool2 = needMediaInfo(paramLocalMediaInfo);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (this.mListener == null);
    return this.mListener.needMediaInfo(paramLocalMediaInfo);
  }
  
  protected boolean needMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo = paramLocalMediaInfo.path;
    if ((TextUtils.isEmpty(paramLocalMediaInfo)) || (!new File(paramLocalMediaInfo).exists()))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("file not exists:");
        if (paramLocalMediaInfo == null) {
          break label65;
        }
      }
      for (;;)
      {
        QLog.i("MediaQuery", 2, paramLocalMediaInfo);
        return false;
        label65:
        paramLocalMediaInfo = "null";
      }
    }
    return true;
  }
  
  public void setListener(ICursor.FilterListener paramFilterListener)
  {
    this.mListener = paramFilterListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
 * JD-Core Version:    0.7.0.1
 */