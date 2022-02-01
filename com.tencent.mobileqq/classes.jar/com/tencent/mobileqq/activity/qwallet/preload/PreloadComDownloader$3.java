package com.tencent.mobileqq.activity.qwallet.preload;

import akrs;
import android.os.Bundle;
import bhhe;
import bhhf;
import bhhk;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(akrs paramakrs, DownloadParam paramDownloadParam, bhhe parambhhe, Bundle paramBundle) {}
  
  public void run()
  {
    bhhf localbhhf = new bhhf(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePath));
    localbhhf.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localbhhf.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (akrs.a(this.this$0) != null) {
      akrs.a(this.this$0).a(localbhhf, this.jdField_a_of_type_Bhhe, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */