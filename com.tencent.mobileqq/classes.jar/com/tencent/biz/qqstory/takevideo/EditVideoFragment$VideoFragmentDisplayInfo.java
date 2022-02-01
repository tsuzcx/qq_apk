package com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;

class EditVideoFragment$VideoFragmentDisplayInfo
  extends VideoFragmentInfo
{
  public Bitmap a;
  public Bitmap b;
  
  public EditVideoFragment$VideoFragmentDisplayInfo(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public EditVideoFragment$VideoFragmentDisplayInfo(VideoFragmentInfo paramVideoFragmentInfo, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramVideoFragmentInfo.jdField_c_of_type_Int, paramVideoFragmentInfo.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFragment.VideoFragmentDisplayInfo
 * JD-Core Version:    0.7.0.1
 */