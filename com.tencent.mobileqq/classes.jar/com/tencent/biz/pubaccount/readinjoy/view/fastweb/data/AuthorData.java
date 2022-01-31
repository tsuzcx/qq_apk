package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import ajya;
import bhvy;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;
import osg;
import pbu;
import ram;
import rjx;
import rpr;

public class AuthorData
  extends ProteusItemData
{
  public long a;
  public ArticleInfo a;
  public String a;
  public boolean a;
  public String b;
  private boolean b;
  public String c;
  public String d;
  public String e;
  
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
  
  public void a()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())) {}
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        if (i != 0)
        {
          localJSONObject.put("style_ID", "ReadInjoy_article_relocated_header_cell");
          localJSONObject.put("avatar_url", this.jdField_a_of_type_JavaLangString);
          localJSONObject.put("avatar_uin", this.c);
          localJSONObject.put("nickname_text", this.jdField_b_of_type_JavaLangString);
          localJSONObject.put("timestamp_text", this.d);
          if (this.jdField_a_of_type_Long > 0L)
          {
            localJSONObject.put("read_amount_text", ajya.a(2131716893) + bhvy.a(this.jdField_a_of_type_Long, 99990000L, "9999万+", ""));
            if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean))
            {
              if (!this.jdField_a_of_type_Boolean) {
                break label314;
              }
              localJSONObject.put("selected_status", "1");
              localJSONObject.put("button_status", ajya.a(2131716895));
            }
            Object localObject1 = this.V;
            if (localObject1 != null) {
              try
              {
                localObject1 = new JSONObject(this.V);
                Iterator localIterator = ((JSONObject)localObject1).keys();
                if (localIterator == null) {
                  break label338;
                }
                if (!localIterator.hasNext()) {
                  break label338;
                }
                String str = (String)localIterator.next();
                localJSONObject.put(str, ((JSONObject)localObject1).opt(str));
                continue;
                localObject2 = rpr.a("native_article", true);
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
            }
            if (localObject2 == null) {
              break label369;
            }
            Object localObject2 = ((rpr)localObject2).getTemplateBean(localJSONObject);
            if (localObject2 == null) {
              break label374;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject2);
            this.jdField_b_of_type_OrgJsonJSONObject = localJSONObject;
          }
        }
        else
        {
          localJSONObject.put("style_ID", "ReadInjoy_article_header_cell");
          continue;
        }
        localJSONObject.put("read_amount_text", "0");
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return;
      }
      continue;
      label314:
      localJSONObject.put("selected_status", "0");
      localJSONObject.put("button_status", ajya.a(2131716896));
      continue;
      label338:
      QLog.d("AuthorData", 2, "merge result: " + localJSONObject.toString());
      continue;
      label369:
      Object localObject3 = null;
      continue;
      label374:
      return;
      i = 0;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  public void b()
  {
    Object localObject;
    pbu localpbu;
    long l;
    rjx localrjx;
    if (!this.jdField_a_of_type_Boolean)
    {
      a(true);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
      {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localpbu = osg.a().a();
        localObject = ((QQAppInterface)localObject).getAccount();
        l = a();
        localrjx = new rjx(this);
        if (!ram.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          break label92;
        }
      }
    }
    label92:
    for (int i = 2;; i = 1)
    {
      localpbu.a((String)localObject, l, true, localrjx, i);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      boolean bool = osg.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin());
      if (bool != this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = bool;
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData
 * JD-Core Version:    0.7.0.1
 */