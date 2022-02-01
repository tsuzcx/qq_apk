package com.tencent.mobileqq.activity.qwallet.preload;

import akaw;
import android.os.Bundle;
import bgod;
import bgoe;
import bgoj;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(akaw paramakaw, DownloadParam paramDownloadParam, bgod parambgod, Bundle paramBundle) {}
  
  public void run()
  {
    bgoe localbgoe = new bgoe(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePath));
    localbgoe.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localbgoe.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (akaw.a(this.this$0) != null) {
      akaw.a(this.this$0).a(localbgoe, this.jdField_a_of_type_Bgod, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */