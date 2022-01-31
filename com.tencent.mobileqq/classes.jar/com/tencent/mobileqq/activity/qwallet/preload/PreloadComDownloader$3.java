package com.tencent.mobileqq.activity.qwallet.preload;

import agos;
import android.os.Bundle;
import batl;
import batm;
import batr;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(agos paramagos, DownloadParam paramDownloadParam, batl parambatl, Bundle paramBundle) {}
  
  public void run()
  {
    batm localbatm = new batm(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePath));
    localbatm.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localbatm.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (agos.a(this.this$0) != null) {
      agos.a(this.this$0).a(localbatm, this.jdField_a_of_type_Batl, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */