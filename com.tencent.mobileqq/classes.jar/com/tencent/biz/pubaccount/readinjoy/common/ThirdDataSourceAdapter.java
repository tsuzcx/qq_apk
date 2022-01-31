package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;
import lle;

public class ThirdDataSourceAdapter
  extends AbsThirdDataSourceAdapter
{
  int jdField_a_of_type_Int = 2;
  private AbsThirdDataSourceAdapter.OnPreparedCallback jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private int b = 0;
  private int c = 0;
  
  public ThirdDataSourceAdapter(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getPlayType()
  {
    return this.c;
  }
  
  public int getStaus()
  {
    return this.b;
  }
  
  public String getURL()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback)
  {
    this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback = paramOnPreparedCallback;
    this.b = 1;
    paramOnPreparedCallback = ThirdVideoManager.a();
    lle locallle = new lle(this);
    if (this.jdField_a_of_type_Int == 2) {
      paramOnPreparedCallback.a(paramString, "PubAccountArticleCenter.GetUrlByVid", locallle);
    }
    while (this.jdField_a_of_type_Int != 4) {
      return;
    }
    paramOnPreparedCallback.a(paramString, "SQQShopAdSvr.GetUrlByVid", locallle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ThirdDataSourceAdapter
 * JD-Core Version:    0.7.0.1
 */