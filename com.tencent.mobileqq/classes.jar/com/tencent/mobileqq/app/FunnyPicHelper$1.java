package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class FunnyPicHelper$1
  extends DownloadListener
{
  FunnyPicHelper$1(String paramString, File paramFile, CustomEmotionData paramCustomEmotionData, boolean paramBoolean1, boolean paramBoolean2, IFavroamingDBManagerService paramIFavroamingDBManagerService, IPicDownloadListener paramIPicDownloadListener, List paramList1, List paramList2, Context paramContext, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    FunnyPicHelper.a(paramDownloadTask, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FunnyPicHelper.1
 * JD-Core Version:    0.7.0.1
 */