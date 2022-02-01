package com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils.ConfigData;
import com.tencent.biz.pubaccount.util.ProteusReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.os.MqqHandler;

class StyleLoaderHelper$DummyCallback
  implements AsyncBack
{
  private final String jdField_a_of_type_JavaLangString;
  private final String b;
  
  public StyleLoaderHelper$DummyCallback(StyleLoaderHelper paramStyleLoaderHelper, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("TemplateFactory", 1, "loaded: bid : " + this.jdField_a_of_type_JavaLangString + " param " + paramString + " code : " + paramInt);
    if ((paramInt != 0) || (paramString == null)) {}
    try
    {
      QLog.d("TemplateFactory", 2, "下载离线样式包完成 : " + this.jdField_a_of_type_JavaLangString);
      OfflineUtils.a(StyleLoaderHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusLoadersStyleLoaderHelper));
      if ((paramString == null) && (OfflineUtils.a(this.jdField_a_of_type_JavaLangString).a))
      {
        QLog.d("TemplateFactory", 1, "加载离线包 : " + this.jdField_a_of_type_JavaLangString);
        ProteusReportUtil.a(2, StyleLoaderHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusLoadersStyleLoaderHelper));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusLoadersStyleLoaderHelper.b(this.jdField_a_of_type_JavaLangString);
        ReadInJoyHelper.a("kandian_pts_style_update", Boolean.valueOf(true));
        StyleConfigHelper.a().b();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("TemplateFactory", 1, "loaded: bid : " + this.jdField_a_of_type_JavaLangString, paramString);
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new StyleLoaderHelper.DummyCallback.1(this, paramString, paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.DummyCallback
 * JD-Core Version:    0.7.0.1
 */