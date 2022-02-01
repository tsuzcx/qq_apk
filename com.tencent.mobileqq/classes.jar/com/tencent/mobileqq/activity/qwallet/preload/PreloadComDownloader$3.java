package com.tencent.mobileqq.activity.qwallet.preload;

import akwp;
import android.os.Bundle;
import bhyn;
import bhyo;
import bhyt;
import com.tencent.util.Pair;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PreloadComDownloader$3
  implements Runnable
{
  public PreloadComDownloader$3(akwp paramakwp, DownloadParam paramDownloadParam, bhyn parambhyn, Bundle paramBundle) {}
  
  public void run()
  {
    bhyo localbhyo = new bhyo(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePath));
    localbhyo.f = "QwalletPreload";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.headers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (localPair != null) {
          localbhyo.a((String)localPair.first, (String)localPair.second);
        }
      }
    }
    if (akwp.a(this.this$0) != null) {
      akwp.a(this.this$0).a(localbhyo, this.jdField_a_of_type_Bhyn, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader.3
 * JD-Core Version:    0.7.0.1
 */