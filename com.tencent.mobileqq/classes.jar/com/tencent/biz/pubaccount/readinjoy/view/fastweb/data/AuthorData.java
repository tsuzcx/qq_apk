package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertUtil;
import com.tencent.biz.pubaccount.readinjoy.ktextension.JSONObjectExtensionsKt;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.FollowStatusObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class AuthorData
  extends ProteusItemData
{
  public long a;
  public ArticleInfo a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public AuthorData(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    super(25);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
  }
  
  private long a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (i != 0)
        {
          localJSONObject.put("style_ID", "ReadInjoy_article_relocated_header_cell");
          localJSONObject.put("avatar_url", this.jdField_a_of_type_JavaLangString);
          localJSONObject.put("avatar_uin", this.jdField_c_of_type_JavaLangString);
          localJSONObject.put("nickname_text", this.b);
          localJSONObject.put("timestamp_text", this.d);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) {
            localJSONObject.put("dt_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
          }
          localJSONObject.put("dt_puin", this.jdField_c_of_type_JavaLangString);
          FastWebPTSDataConverter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localJSONObject);
          a(paramBoolean1, paramBoolean2, localJSONObject);
          JSONObjectExtensionsKt.a(localJSONObject, "ringUrl", this.f, "");
          JSONObjectExtensionsKt.a(localJSONObject, "liveStatusUrl", this.g, "");
          Object localObject1 = this.U;
          if (localObject1 != null)
          {
            try
            {
              localObject1 = new JSONObject(this.U);
              Iterator localIterator = ((JSONObject)localObject1).keys();
              if (localIterator == null) {
                break label339;
              }
              if (!localIterator.hasNext()) {
                break label339;
              }
              String str = (String)localIterator.next();
              localJSONObject.put(str, ((JSONObject)localObject1).opt(str));
              continue;
              localObject2 = TemplateFactory.a("native_article", true);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
          else
          {
            if (localObject2 == null) {
              break label371;
            }
            Object localObject2 = ((TemplateFactory)localObject2).getTemplateBean(localJSONObject);
            if (localObject2 == null) {
              break label377;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject2);
            this.jdField_c_of_type_OrgJsonJSONObject = localJSONObject;
            QLog.d("AuthorData", 1, "bindAuthorData: " + this.jdField_c_of_type_OrgJsonJSONObject);
          }
        }
        else
        {
          localJSONObject.put("style_ID", "ReadInjoy_article_header_cell");
          continue;
        }
        QLog.d("AuthorData", 2, "merge result: " + localJSONObject.toString());
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return;
      }
      label339:
      continue;
      label371:
      Object localObject3 = null;
      continue;
      label377:
      return;
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, JSONObject paramJSONObject)
  {
    FastWebPTSDataConverter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramJSONObject, paramBoolean1);
    this.jdField_a_of_type_Boolean = paramBoolean1;
  }
  
  public void a()
  {
    a(FollowListInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin(), null), false);
  }
  
  public void a(FollowListInfoModule.FollowStatusObserver paramFollowStatusObserver)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      c(FollowListInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin(), paramFollowStatusObserver));
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
    a();
  }
  
  public void a(Map<Long, FollowingMember> paramMap)
  {
    boolean bool = true;
    int i = FastWebPTSUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin(), paramMap);
    if (i != -1) {
      if (i != 1) {
        break label30;
      }
    }
    for (;;)
    {
      c(bool);
      return;
      label30:
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(true);
      FastWebPTSUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, a(), this.jdField_a_of_type_JavaLangString, paramBoolean);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        RIJFeedsInsertUtil.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean) {
      a(paramBoolean, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData
 * JD-Core Version:    0.7.0.1
 */