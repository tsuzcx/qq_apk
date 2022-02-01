package com.tencent.biz.pubaccount.NativeAd.util;

import java.util.ArrayList;
import java.util.Iterator;
import nzj;
import tld;
import tqt;

public class ADBaseAppDownloadManager$1
  implements Runnable
{
  public ADBaseAppDownloadManager$1(nzj paramnzj, tqt paramtqt, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Iterator localIterator = nzj.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((tld)localIterator.next()).a(this.jdField_a_of_type_Tqt, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */