package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;

class ThumbFetcher$ImageThumbnailQuery
  implements ThumbnailQuery
{
  private static final String[] b = { "_data" };
  private final ContentResolver a;
  
  ThumbFetcher$ImageThumbnailQuery(ContentResolver paramContentResolver)
  {
    this.a = paramContentResolver;
  }
  
  public Cursor a(Uri paramUri)
  {
    paramUri = paramUri.getLastPathSegment();
    return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[] { paramUri }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.mediastore.ThumbFetcher.ImageThumbnailQuery
 * JD-Core Version:    0.7.0.1
 */