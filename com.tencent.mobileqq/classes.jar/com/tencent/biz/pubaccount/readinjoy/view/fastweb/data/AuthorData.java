package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import pfa;
import pnp;
import ppo;
import ppq;
import pra;
import qwb;
import sel;
import sot;
import srw;
import suz;
import ubg;

public class AuthorData
  extends ProteusItemData
{
  public long a;
  public ArticleInfo a;
  public String a;
  private boolean a;
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
          srw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localJSONObject);
          a(paramBoolean1, paramBoolean2, localJSONObject);
          pnp.a(localJSONObject, "ringUrl", this.f, "");
          pnp.a(localJSONObject, "liveStatusUrl", this.g, "");
          Object localObject1 = this.P;
          if (localObject1 != null)
          {
            try
            {
              localObject1 = new JSONObject(this.P);
              Iterator localIterator = ((JSONObject)localObject1).keys();
              if (localIterator == null) {
                break label277;
              }
              if (!localIterator.hasNext()) {
                break label277;
              }
              String str = (String)localIterator.next();
              localJSONObject.put(str, ((JSONObject)localObject1).opt(str));
              continue;
              localObject2 = suz.a("native_article", true);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
          else
          {
            if (localObject2 == null) {
              break label309;
            }
            Object localObject2 = ((suz)localObject2).getTemplateBean(localJSONObject);
            if (localObject2 == null) {
              break label315;
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
        QLog.d("AuthorData", 2, "merge result: " + localJSONObject.toString());
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return;
      }
      label277:
      continue;
      label309:
      Object localObject3 = null;
      continue;
      label315:
      return;
      i = 0;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, JSONObject paramJSONObject)
  {
    if ((!paramBoolean1) || (paramBoolean2))
    {
      srw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramJSONObject, paramBoolean1);
      this.jdField_a_of_type_Boolean = paramBoolean1;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a()
  {
    a(ppo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin(), null), false);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
    a();
  }
  
  public void a(Map<Long, qwb> paramMap)
  {
    String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin();
    if ((paramMap != null) && (!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str)))
    {
      paramMap = (qwb)paramMap.get(Long.valueOf(str));
      if (paramMap != null) {
        b(paramMap.a());
      }
    }
  }
  
  public void a(ppq paramppq)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      b(ppo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin(), paramppq));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }
  
  public void b()
  {
    Object localObject;
    pra localpra;
    long l;
    String str;
    sot localsot;
    if (!this.jdField_a_of_type_Boolean)
    {
      ubg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, ubg.d);
      a(true);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
      {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localpra = pfa.a().a();
        localObject = ((QQAppInterface)localObject).getAccount();
        l = a();
        str = this.jdField_a_of_type_JavaLangString;
        localsot = new sot(this);
        if (!sel.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          break label110;
        }
      }
    }
    label110:
    for (int i = 2;; i = 1)
    {
      localpra.a((String)localObject, l, true, str, localsot, i);
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
    if (paramBoolean != this.jdField_a_of_type_Boolean) {
      a(paramBoolean, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData
 * JD-Core Version:    0.7.0.1
 */