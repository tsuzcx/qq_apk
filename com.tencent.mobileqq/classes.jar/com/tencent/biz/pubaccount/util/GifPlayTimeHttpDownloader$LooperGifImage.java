package com.tencent.biz.pubaccount.util;

import com.tencent.image.NativeGifImage;
import java.io.File;

public class GifPlayTimeHttpDownloader$LooperGifImage
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private GifPlayTimeHttpDownloader.OnPlayFinish jdField_a_of_type_ComTencentBizPubaccountUtilGifPlayTimeHttpDownloader$OnPlayFinish;
  
  public GifPlayTimeHttpDownloader$LooperGifImage(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(GifPlayTimeHttpDownloader.OnPlayFinish paramOnPlayFinish)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilGifPlayTimeHttpDownloader$OnPlayFinish = paramOnPlayFinish;
  }
  
  protected void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilGifPlayTimeHttpDownloader$OnPlayFinish != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilGifPlayTimeHttpDownloader$OnPlayFinish.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.GifPlayTimeHttpDownloader.LooperGifImage
 * JD-Core Version:    0.7.0.1
 */