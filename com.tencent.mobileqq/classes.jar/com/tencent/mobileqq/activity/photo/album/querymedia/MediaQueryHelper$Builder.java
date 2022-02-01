package com.tencent.mobileqq.activity.photo.album.querymedia;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class MediaQueryHelper$Builder
{
  String albumId;
  List<ICursor> cursors = null;
  int eachCount = 300;
  int limit = -1;
  ICursor.FilterListener listener = null;
  boolean needImage = true;
  boolean needVideo = true;
  
  public MediaQueryHelper build()
  {
    return build(null);
  }
  
  public MediaQueryHelper build(Context paramContext)
  {
    if ((this.cursors == null) && (paramContext != null) && (MediaQueryHelper.isHasStorageReadAndWritePermission(paramContext)))
    {
      this.cursors = new ArrayList();
      String str = this.albumId;
      if ((str != null) && (str.equals("$VideoAlbumId"))) {
        this.needImage = false;
      }
      if (this.needImage) {
        this.cursors.add(new ImageCursor(paramContext, this.albumId));
      }
      if (this.needVideo) {
        this.cursors.add(new VideoCursor(paramContext, this.albumId));
      }
    }
    if (this.cursors == null) {
      this.cursors = new ArrayList();
    }
    paramContext = new MediaQueryHelper(null);
    paramContext.setListener(this.listener);
    MediaQueryHelper.access$200(paramContext, this.cursors, this.limit, this.eachCount);
    return paramContext;
  }
  
  public Builder needImage(boolean paramBoolean)
  {
    this.needImage = paramBoolean;
    return this;
  }
  
  public Builder needVideo(boolean paramBoolean)
  {
    this.needVideo = paramBoolean;
    return this;
  }
  
  public Builder setAlbumId(String paramString)
  {
    this.albumId = paramString;
    return this;
  }
  
  public Builder setCursors(List<ICursor> paramList)
  {
    this.cursors = paramList;
    return this;
  }
  
  public Builder setEachCount(int paramInt)
  {
    this.eachCount = paramInt;
    return this;
  }
  
  public Builder setLimit(int paramInt)
  {
    this.limit = paramInt;
    return this;
  }
  
  public Builder setListener(ICursor.FilterListener paramFilterListener)
  {
    this.listener = paramFilterListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper.Builder
 * JD-Core Version:    0.7.0.1
 */