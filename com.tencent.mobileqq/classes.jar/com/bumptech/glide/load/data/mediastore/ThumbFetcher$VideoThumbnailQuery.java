package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Video.Thumbnails;

class ThumbFetcher$VideoThumbnailQuery
  implements ThumbnailQuery
{
  private static final String[] b = { "_data" };
  private final ContentResolver a;
  
  ThumbFetcher$VideoThumbnailQuery(ContentResolver paramContentResolver)
  {
    this.a = paramContentResolver;
  }
  
  public Cursor a(Uri paramUri)
  {
    paramUri = paramUri.getLastPathSegment();
    return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[] { paramUri }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.mediastore.ThumbFetcher.VideoThumbnailQuery
 * JD-Core Version:    0.7.0.1
 */