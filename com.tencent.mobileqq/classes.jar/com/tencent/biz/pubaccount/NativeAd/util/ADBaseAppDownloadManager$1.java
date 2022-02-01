package com.tencent.biz.pubaccount.NativeAd.util;

import java.util.ArrayList;
import java.util.Iterator;
import nxp;
import olv;
import orb;

public class ADBaseAppDownloadManager$1
  implements Runnable
{
  public ADBaseAppDownloadManager$1(nxp paramnxp, orb paramorb, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Iterator localIterator = nxp.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((olv)localIterator.next()).a(this.jdField_a_of_type_Orb, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */