package com.tencent.mobileqq.activity.qwallet.preload;

import ahbh;
import android.os.Bundle;
import bbwf;
import bbwg;
import bbwl;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(ahbh paramahbh, DownloadParam paramDownloadParam, bbwf parambbwf, Bundle paramBundle) {}
  
  public void run()
  {
    bbwg localbbwg = new bbwg(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePath));
    localbbwg.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localbbwg.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (ahbh.a(this.this$0) != null) {
      ahbh.a(this.this$0).a(localbbwg, this.jdField_a_of_type_Bbwf, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */