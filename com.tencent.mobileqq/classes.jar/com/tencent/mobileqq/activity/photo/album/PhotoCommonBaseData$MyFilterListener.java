package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.querymedia.ICursor.FilterListener;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoCommonBaseData$MyFilterListener
  implements ICursor.FilterListener
{
  public PhotoCommonBaseData$MyFilterListener(PhotoCommonBaseData paramPhotoCommonBaseData) {}
  
  public boolean filterMedia(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo.mMediaType == 0)
    {
      if ((this.this$0.filter.imageMinHeight > 0) && (paramLocalMediaInfo.mediaHeight > 0) && (paramLocalMediaInfo.mediaHeight < this.this$0.filter.imageMinHeight)) {
        return true;
      }
      if ((this.this$0.filter.imageMinWidth > 0) && (paramLocalMediaInfo.mediaWidth > 0) && (paramLocalMediaInfo.mediaWidth < this.this$0.filter.imageMinWidth)) {
        return true;
      }
      if ((this.this$0.filter.imageMaxHeight > 0) && (paramLocalMediaInfo.mediaHeight > this.this$0.filter.imageMaxHeight)) {
        return true;
      }
      if ((this.this$0.filter.imageMaxWidth > 0) && (paramLocalMediaInfo.mediaWidth > this.this$0.filter.imageMaxWidth)) {
        return true;
      }
      if ((this.this$0.filter.imageMinSize > 0L) && (paramLocalMediaInfo.fileSize < this.this$0.filter.imageMinSize)) {
        return true;
      }
    }
    else if (paramLocalMediaInfo.mMediaType == 1)
    {
      if ((this.this$0.filter.videoMinHeight > 0) && (paramLocalMediaInfo.mediaHeight > 0) && (paramLocalMediaInfo.mediaHeight < this.this$0.filter.videoMinHeight)) {
        return true;
      }
      if ((this.this$0.filter.videoMinWidth > 0) && (paramLocalMediaInfo.mediaWidth > 0) && (paramLocalMediaInfo.mediaWidth < this.this$0.filter.videoMinWidth)) {
        return true;
      }
      if ((this.this$0.filter.videoMaxHeight > 0) && (paramLocalMediaInfo.mediaHeight > this.this$0.filter.videoMaxHeight)) {
        return true;
      }
      if ((this.this$0.filter.videoMaxWidth > 0) && (paramLocalMediaInfo.mediaWidth > this.this$0.filter.videoMaxWidth)) {
        return true;
      }
      if ((this.this$0.filter.videoMaxDuration > 0L) && (paramLocalMediaInfo.mDuration > this.this$0.filter.videoMaxDuration)) {
        return true;
      }
      if ((this.this$0.filter.videoSizeLimit > 0L) && (paramLocalMediaInfo.fileSize > this.this$0.filter.videoSizeLimit)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean needMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return false;
    }
    if (this.this$0.filter != null)
    {
      if ((this.this$0.filter.blockPaths != null) && (!this.this$0.filter.blockPaths.isEmpty()))
      {
        Iterator localIterator = this.this$0.filter.blockPaths.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramLocalMediaInfo.path.contains(str)) {
            return false;
          }
        }
      }
      if (this.this$0.filter.filter(paramLocalMediaInfo.mMimeType)) {
        return false;
      }
      if (filterMedia(paramLocalMediaInfo)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData.MyFilterListener
 * JD-Core Version:    0.7.0.1
 */