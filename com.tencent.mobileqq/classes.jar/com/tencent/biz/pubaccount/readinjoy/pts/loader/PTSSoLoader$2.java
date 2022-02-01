package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class PTSSoLoader$2
  implements OnLoadListener
{
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.i("PTSSoLoader", 1, "[onLoadResult], preload resCode = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSSoLoader.2
 * JD-Core Version:    0.7.0.1
 */