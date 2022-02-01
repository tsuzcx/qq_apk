package com.tencent.mobileqq.activity.qwallet.preload;

import aldd;
import android.os.Bundle;
import biht;
import bihu;
import bihz;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(aldd paramaldd, DownloadParam paramDownloadParam, biht parambiht, Bundle paramBundle) {}
  
  public void run()
  {
    bihu localbihu = new bihu(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePath));
    localbihu.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localbihu.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (aldd.a(this.this$0) != null) {
      aldd.a(this.this$0).a(localbihu, this.jdField_a_of_type_Biht, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */