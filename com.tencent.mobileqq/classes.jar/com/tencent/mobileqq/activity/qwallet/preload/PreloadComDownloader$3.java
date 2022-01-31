package com.tencent.mobileqq.activity.qwallet.preload;

import aizz;
import android.os.Bundle;
import bead;
import beae;
import beaj;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(aizz paramaizz, DownloadParam paramDownloadParam, bead parambead, Bundle paramBundle) {}
  
  public void run()
  {
    beae localbeae = new beae(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePath));
    localbeae.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localbeae.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (aizz.a(this.this$0) != null) {
      aizz.a(this.this$0).a(localbeae, this.jdField_a_of_type_Bead, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */