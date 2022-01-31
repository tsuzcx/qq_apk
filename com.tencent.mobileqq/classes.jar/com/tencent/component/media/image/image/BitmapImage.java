package com.tencent.component.media.image.image;

import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.utils.AssertUtils;

public class BitmapImage
  extends Image
{
  private final BitmapReference jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
  private final Image.MetaInfo jdField_a_of_type_ComTencentComponentMediaImageImageImage$MetaInfo = new Image.MetaInfo();
  
  public BitmapImage(BitmapReference paramBitmapReference)
  {
    if (paramBitmapReference != null) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.assertTrue(bool);
      this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference = paramBitmapReference;
      a();
      return;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageImage$MetaInfo.width = this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getWidth();
    this.jdField_a_of_type_ComTencentComponentMediaImageImageImage$MetaInfo.height = this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getHeight();
  }
  
  public BitmapReference getBitmap()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
  }
  
  public Image.MetaInfo getMetaInfo()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageImage$MetaInfo;
  }
  
  public boolean isRecycled()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.isRecycled();
  }
  
  public void recycle()
  {
    if (!this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.isRecycled()) {
      this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.release();
    }
  }
  
  public int size()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.isRecycled()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getAllocSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.image.BitmapImage
 * JD-Core Version:    0.7.0.1
 */