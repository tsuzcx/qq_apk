package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentUtils$CommentReportR5Builder
{
  private CommentInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  
  public ReadInJoyCommentUtils$CommentReportR5Builder(ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo = paramCommentInfo;
  }
  
  private CommentReportR5Builder e(int paramInt)
  {
    int j = 1;
    int i = 1;
    if (paramInt == 1) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("puin_type", 1);
      return this;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject1;
      localJSONException.printStackTrace();
      return this;
    }
    if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      localJSONObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAccountLess == 0) {}
      for (paramInt = i;; paramInt = 2)
      {
        localJSONObject1.put("puin_type", paramInt);
        return this;
      }
    }
    if ((paramInt == 3) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      JSONObject localJSONObject2 = this.jdField_a_of_type_OrgJsonJSONObject;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAccountLess == 0) {}
      for (paramInt = j;; paramInt = 2)
      {
        localJSONObject2.put("puin_type", paramInt);
        return this;
      }
    }
    return this;
  }
  
  public CommentReportR5Builder a()
  {
    int i = 1;
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.authorSelection == 1) {}
        while (i > 0)
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("comment_type", i);
          return this;
          i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.awesome;
          if (i == 1) {
            i = 2;
          } else {
            i = 3;
          }
        }
      }
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public CommentReportR5Builder a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("entry", paramInt);
      return e(paramInt);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public CommentReportR5Builder a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("to_uin", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public String a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
          this.jdField_a_of_type_OrgJsonJSONObject.put("mp_article_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo != null)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.level != 1) {
            continue;
          }
          this.jdField_a_of_type_OrgJsonJSONObject.put("comment_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.commentId);
        }
        this.jdField_a_of_type_OrgJsonJSONObject.put("source", RIJTransMergeKanDianReport.a());
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode", RIJAppSetting.a());
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment_platform", 3);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      return this.jdField_a_of_type_OrgJsonJSONObject.toString();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.level == 2) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("sub_comment_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentCommentInfo.commentId);
      }
    }
  }
  
  public CommentReportR5Builder b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("area", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder c(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_level", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder d(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_icon_choose", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CommentReportR5Builder
 * JD-Core Version:    0.7.0.1
 */