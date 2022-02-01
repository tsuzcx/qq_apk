package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.mobileqq.soload.DownSoLoader;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class PTSSoLoader$1
  implements OnLoadListener
{
  PTSSoLoader$1(PTSSoLoader paramPTSSoLoader, String paramString) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.i("PTSSoLoader", 1, "[onLoadResult], resCode = " + paramInt);
    if (paramInt == 0)
    {
      paramLoadExtResult = DownSoLoader.a(this.jdField_a_of_type_JavaLangString);
      QLog.i("PTSSoLoader", 1, "[onLoadResult], load so succeeded, name = " + this.jdField_a_of_type_JavaLangString + ", currentVersion = " + paramLoadExtResult);
      if (PTSSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSSoLoader, paramLoadExtResult, "1.1.4")) {
        PTSSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSSoLoader, true);
      }
    }
    PTSSoLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSSoLoader, this.jdField_a_of_type_JavaLangString, paramInt, DownSoLoader.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSSoLoader.1
 * JD-Core Version:    0.7.0.1
 */