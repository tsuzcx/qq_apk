package com.tencent.mobileqq.activity.photo.album.queryMedia;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

public class ImageCursor
  extends ICursor
{
  private static final String[] IMAGE_COLUMS = { "orientation", "latitude", "longitude" };
  private static final int INDEX_LATITUDE = SUB_START_INDEX + 1;
  private static final int INDEX_LONGITUDE = SUB_START_INDEX + 2;
  private static final int INDEX_ORIENTATION = SUB_START_INDEX;
  
  public ImageCursor(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  Cursor createCursor(Context paramContext)
  {
    Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    return paramContext.getContentResolver().query(localUri, (String[])this.mColums.toArray(new String[0]), this.mSelector, null, "date_modified DESC, date_added DESC");
  }
  
  protected void init()
  {
    super.init();
    this.mColums.addAll(Arrays.asList(IMAGE_COLUMS));
  }
  
  protected LocalMediaInfo makeMediaInfo()
  {
    LocalMediaInfo localLocalMediaInfo = super.makeMediaInfo();
    if ((this.mCursor != null) && (!this.mCursor.isClosed()))
    {
      localLocalMediaInfo.mMediaType = 0;
      localLocalMediaInfo.orientation = this.mCursor.getInt(INDEX_ORIENTATION);
      localLocalMediaInfo.latitude = this.mCursor.getInt(INDEX_LATITUDE);
      localLocalMediaInfo.longitude = this.mCursor.getInt(INDEX_LONGITUDE);
    }
    if (("*/*".equals(localLocalMediaInfo.mMimeType)) || ("image/*".equals(localLocalMediaInfo.mMimeType)))
    {
      if ((!localLocalMediaInfo.path.contains(".jpg")) && (!localLocalMediaInfo.path.contains(".jpeg"))) {
        break label235;
      }
      localLocalMediaInfo.mMimeType = "image/jpeg";
    }
    for (;;)
    {
      if ((localLocalMediaInfo.mediaWidth <= 0) || (localLocalMediaInfo.mediaHeight <= 0))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        int[] arrayOfInt = new int[2];
        QAlbumBaseUtil.getWHByPath(localLocalMediaInfo.path, localOptions, arrayOfInt);
        localLocalMediaInfo.mediaWidth = arrayOfInt[0];
        localLocalMediaInfo.mediaHeight = arrayOfInt[1];
        if (((localLocalMediaInfo.mediaWidth <= 0) || (localLocalMediaInfo.mediaHeight <= 0)) && (QLog.isColorLevel())) {
          QLog.i("MediaQuery", 2, "image no size " + localLocalMediaInfo.path);
        }
      }
      return localLocalMediaInfo;
      label235:
      if (localLocalMediaInfo.path.contains(".gif")) {
        localLocalMediaInfo.mMimeType = "image/gif";
      } else if (localLocalMediaInfo.path.contains(".bmp")) {
        localLocalMediaInfo.mMimeType = "image/bmp";
      } else if (localLocalMediaInfo.path.contains(".png")) {
        localLocalMediaInfo.mMimeType = "image/png";
      }
    }
  }
  
  protected boolean needMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((!super.needMediaInfo(paramLocalMediaInfo)) || (paramLocalMediaInfo.mMimeType == null)) {
      return false;
    }
    return paramLocalMediaInfo.mMimeType.contains("image");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.queryMedia.ImageCursor
 * JD-Core Version:    0.7.0.1
 */