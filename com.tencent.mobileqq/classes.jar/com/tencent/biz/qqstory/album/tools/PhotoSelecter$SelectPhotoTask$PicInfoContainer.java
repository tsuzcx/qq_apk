package com.tencent.biz.qqstory.album.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.support.logging.SLog;

class PhotoSelecter$SelectPhotoTask$PicInfoContainer
  implements Comparable<PicInfoContainer>
{
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  StoryAlbum.PicInfo jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum$PicInfo;
  
  public int a(@NonNull PicInfoContainer paramPicInfoContainer)
  {
    return (int)(this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum$PicInfo.b - paramPicInfoContainer.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum$PicInfo.b);
  }
  
  public Bitmap a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentBizQqstoryAlbumModelStoryAlbum$PicInfo.a(paramContext, 1, localOptions);
        this.jdField_a_of_type_AndroidGraphicsBitmap = PhotoSimilar.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      catch (Exception paramContext)
      {
        SLog.c(PhotoSelecter.a, "get thumbnail failed!", paramContext);
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.PhotoSelecter.SelectPhotoTask.PicInfoContainer
 * JD-Core Version:    0.7.0.1
 */