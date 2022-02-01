package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import anni;
import bmqa;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;
import pmh;
import pvc;
import pyq;
import snh;
import sxx;
import teh;
import ube;

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
          localJSONObject.put("avatar_uin", this.jdField_c_of_type_JavaLangString);
          localJSONObject.put("nickname_text", this.jdField_b_of_type_JavaLangString);
          localJSONObject.put("timestamp_text", this.d);
          if (this.jdField_a_of_type_Long > 0L)
          {
            localJSONObject.put("read_amount_text", anni.a(2131715554) + bmqa.a(this.jdField_a_of_type_Long, 99990000L, "9999万+", ""));
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.bindShowFollowButton = false;
            }
            if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean))
            {
              if (!this.jdField_a_of_type_Boolean) {
                break label371;
              }
              localJSONObject.put("selected_status", "1");
              localJSONObject.put("button_status", anni.a(2131715556));
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.bindShowFollowButton = true;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.showFollowButtonType = BaseArticleInfo.TYPE_FOLLOWED_BUTTON;
            }
            pvc.a(localJSONObject, "ringUrl", this.f, "");
            pvc.a(localJSONObject, "liveStatusUrl", this.g, "");
            Object localObject1 = this.W;
            if (localObject1 != null) {
              try
              {
                localObject1 = new JSONObject(this.W);
                Iterator localIterator = ((JSONObject)localObject1).keys();
                if (localIterator == null) {
                  break label413;
                }
                if (!localIterator.hasNext()) {
                  break label413;
                }
                String str = (String)localIterator.next();
                localJSONObject.put(str, ((JSONObject)localObject1).opt(str));
                continue;
                localObject2 = teh.a("native_article", true);
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
            }
            if (localObject2 == null) {
              break label444;
            }
            Object localObject2 = ((teh)localObject2).getTemplateBean(localJSONObject);
            if (localObject2 == null) {
              break label449;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject2);
            this.jdField_c_of_type_OrgJsonJSONObject = localJSONObject;
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
      label371:
      localJSONObject.put("selected_status", "0");
      localJSONObject.put("button_status", anni.a(2131715557));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.bindShowFollowButton = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.showFollowButtonType = BaseArticleInfo.TYPE_UNFOLLOW_BUTTON;
      continue;
      label413:
      QLog.d("AuthorData", 2, "merge result: " + localJSONObject.toString());
      continue;
      label444:
      Object localObject3 = null;
      continue;
      label449:
      return;
      i = 0;
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
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
    pyq localpyq;
    long l;
    String str;
    sxx localsxx;
    if (!this.jdField_a_of_type_Boolean)
    {
      ube.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, ube.d);
      a(true);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
      {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localpyq = pmh.a().a();
        localObject = ((QQAppInterface)localObject).getAccount();
        l = a();
        str = this.jdField_a_of_type_JavaLangString;
        localsxx = new sxx(this);
        if (!snh.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          break label110;
        }
      }
    }
    label110:
    for (int i = 2;; i = 1)
    {
      localpyq.a((String)localObject, l, true, str, localsxx, i);
      return;
    }
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      boolean bool = pmh.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin());
      if (bool != this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = bool;
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData
 * JD-Core Version:    0.7.0.1
 */