package com.tencent.biz.pubaccount.util.api;

import com.tencent.image.NativeGifImage;
import java.io.File;

public class IPublicAccountGifPlayTimeHttpDownloader$LooperGifImage
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private IPublicAccountGifPlayTimeHttpDownloader.OnPlayFinish jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$OnPlayFinish;
  
  public IPublicAccountGifPlayTimeHttpDownloader$LooperGifImage(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$OnPlayFinish = null;
  }
  
  public void a(IPublicAccountGifPlayTimeHttpDownloader.OnPlayFinish paramOnPlayFinish)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$OnPlayFinish = paramOnPlayFinish;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$OnPlayFinish != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$OnPlayFinish.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage
 * JD-Core Version:    0.7.0.1
 */