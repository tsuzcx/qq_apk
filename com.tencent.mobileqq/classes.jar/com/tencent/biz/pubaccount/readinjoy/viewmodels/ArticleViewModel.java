package com.tencent.biz.pubaccount.readinjoy.viewmodels;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class ArticleViewModel
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  public int a;
  public long a;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private Observable<CharSequence> jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable = new Observable("");
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  public String a;
  private Observable<CharSequence> b = new Observable("");
  private Observable<CharSequence> c = new Observable("");
  
  private ArticleViewModel(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = BindViewHelper.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(Utils.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a(Utils.b(paramBaseArticleInfo, this));
    this.b.a(Utils.c(paramBaseArticleInfo, this));
  }
  
  public static ArticleViewModel a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new ArticleViewModel(paramBaseArticleInfo);
  }
  
  public BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public Observable<CharSequence> a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable;
  }
  
  public void a()
  {
    this.c.a(Utils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a(Utils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArticleViewModel", 1, "setCustomLinkTextColorSummary | linkedTextColor " + paramInt);
    this.c.a(Utils.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(Utils.b(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public Observable<CharSequence> b()
  {
    return this.b;
  }
  
  public Observable<CharSequence> c()
  {
    return this.c;
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("ArticleViewModel", 1, "[onLoadUserInfoFailed] uin=" + paramString1 + ", msg=" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleViewModel", 2, "[onLoadUserInfoSucceed] uin=" + paramString + " userInfo: " + paramReadInJoyUserInfo);
    }
    this.c.a(Utils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewmodelsObservable.a(Utils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.b.a(Utils.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel
 * JD-Core Version:    0.7.0.1
 */