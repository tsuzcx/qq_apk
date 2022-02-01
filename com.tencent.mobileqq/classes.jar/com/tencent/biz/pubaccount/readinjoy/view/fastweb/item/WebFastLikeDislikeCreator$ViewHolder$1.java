package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.net.URLEncoder;

class WebFastLikeDislikeCreator$ViewHolder$1
  implements Runnable
{
  WebFastLikeDislikeCreator$ViewHolder$1(WebFastLikeDislikeCreator.ViewHolder paramViewHolder, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    String str3 = "https://post.mp.qq.com/jubao/index?";
    String str1 = str3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {}
    try
    {
      str1 = "https://post.mp.qq.com/jubao/index?" + "articleId=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "&puin=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID + "&url=" + URLEncoder.encode(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, "utf-8") + "&key=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "&type=7&_wv=3";
      ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastLikeDislikeCreator$ViewHolder.a.getContext(), str1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str2 = str3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */