package com.tencent.mobileqq.activity.qwallet.preload;

import aivk;
import android.os.Bundle;
import bdvu;
import bdvv;
import bdwa;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(aivk paramaivk, DownloadParam paramDownloadParam, bdvu parambdvu, Bundle paramBundle) {}
  
  public void run()
  {
    bdvv localbdvv = new bdvv(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePath));
    localbdvv.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localbdvv.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (aivk.a(this.this$0) != null) {
      aivk.a(this.this$0).a(localbdvv, this.jdField_a_of_type_Bdvu, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */