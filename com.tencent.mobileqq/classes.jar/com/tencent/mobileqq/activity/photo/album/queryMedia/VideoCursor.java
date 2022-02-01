package com.tencent.mobileqq.activity.photo.album.queryMedia;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import java.util.ArrayList;
import java.util.Arrays;

public class VideoCursor
  extends ICursor
{
  private static final int INDEX_DURATION = SUB_START_INDEX;
  private static final String[] VIDEO_COLUMS = { "duration" };
  
  public VideoCursor(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  Cursor createCursor(Context paramContext)
  {
    Uri localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    return paramContext.getContentResolver().query(localUri, (String[])this.mColums.toArray(new String[0]), this.mSelector, null, "date_modified DESC, date_added DESC");
  }
  
  protected void init()
  {
    super.init();
    this.mColums.addAll(Arrays.asList(VIDEO_COLUMS));
  }
  
  protected LocalMediaInfo makeMediaInfo()
  {
    LocalMediaInfo localLocalMediaInfo = super.makeMediaInfo();
    localLocalMediaInfo.mMediaType = 1;
    if ((this.mCursor != null) && (!this.mCursor.isClosed())) {
      localLocalMediaInfo.mDuration = this.mCursor.getInt(INDEX_DURATION);
    }
    QAlbumBaseUtil.fixVideoInfo(localLocalMediaInfo);
    return localLocalMediaInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.queryMedia.VideoCursor
 * JD-Core Version:    0.7.0.1
 */