package com.tencent.biz.pubaccount;

import com.tencent.image.NativeGifImage;
import java.io.File;

public class LooperGifImage
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private LooperGifImage.OnPlayFinish jdField_a_of_type_ComTencentBizPubaccountLooperGifImage$OnPlayFinish;
  
  public LooperGifImage(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountLooperGifImage$OnPlayFinish = null;
  }
  
  public void a(LooperGifImage.OnPlayFinish paramOnPlayFinish)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountLooperGifImage$OnPlayFinish = paramOnPlayFinish;
  }
  
  protected void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      LooperGifImage.OnPlayFinish localOnPlayFinish = this.jdField_a_of_type_ComTencentBizPubaccountLooperGifImage$OnPlayFinish;
      if (localOnPlayFinish != null) {
        localOnPlayFinish.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.LooperGifImage
 * JD-Core Version:    0.7.0.1
 */