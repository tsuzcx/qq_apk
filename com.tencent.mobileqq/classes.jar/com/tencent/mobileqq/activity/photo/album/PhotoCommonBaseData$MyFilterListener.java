package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.querymedia.ICursor.FilterListener;
import java.util.ArrayList;
import java.util.Iterator;

class PhotoCommonBaseData$MyFilterListener
  implements ICursor.FilterListener
{
  private PhotoCommonBaseData$MyFilterListener(PhotoCommonBaseData paramPhotoCommonBaseData) {}
  
  private boolean filterMedia(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo.mMediaType == 0)
    {
      if ((this.this$0.filter.imageMinHeight > 0) && (paramLocalMediaInfo.mediaHeight < this.this$0.filter.imageMinHeight)) {}
      while (((this.this$0.filter.imageMinWidth > 0) && (paramLocalMediaInfo.mediaHeight < this.this$0.filter.imageMinWidth)) || ((this.this$0.filter.imageMinSize > 0L) && (paramLocalMediaInfo.fileSize < this.this$0.filter.imageMinSize))) {
        return true;
      }
    }
    while ((paramLocalMediaInfo.mMediaType != 1) || (this.this$0.filter.videoMaxDuration <= 0L) || (paramLocalMediaInfo.mDuration <= this.this$0.filter.videoMaxDuration)) {
      return false;
    }
    return true;
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