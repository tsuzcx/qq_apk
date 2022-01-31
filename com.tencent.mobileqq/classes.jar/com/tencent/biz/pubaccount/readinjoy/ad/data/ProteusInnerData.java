package com.tencent.biz.pubaccount.readinjoy.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.regex.Pattern;
import nyk;
import oad;
import oal;
import oas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rpu;
import sfd;

public class ProteusInnerData
  extends AdData
{
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  public nyk a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private int u = 1;
  private int v = 1;
  
  public ProteusInnerData()
  {
    super(22);
    this.jdField_a_of_type_Int = -1;
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    if (oal.a(this)) {
      return oad.a(localJSONObject, this);
    }
    if (this.u == 2) {
      return b(localJSONObject);
    }
    if (this.u == 1) {
      return a(localJSONObject);
    }
    return c(localJSONObject);
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_large_pic_cell");
      if (!TextUtils.isEmpty(this.j))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.j);
        paramJSONObject.put("id_ad_title", localObject);
      }
      if (!TextUtils.isEmpty(this.l))
      {
        localObject = sfd.a(this.l, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_inner_imge", localJSONObject);
      }
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(this.L))
      {
        ((JSONObject)localObject).put("text", this.L);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProteusInnerData", 2, "detail ad inner largeStyle Pic adInconText:" + this.L);
      }
      paramJSONObject.put("id_ad_banner_inner_large_root", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", this);
      if (this.jdField_a_of_type_Boolean)
      {
        paramJSONObject.put("id_operate_edit_area", localObject);
        return paramJSONObject;
      }
      paramJSONObject.put("id_operate_app_area", localObject);
      paramJSONObject.put("id_view_AdDownloadView", localObject);
      if (!TextUtils.isEmpty(this.I))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.I);
        paramJSONObject.put("id_app_name", localObject);
        return paramJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pop_sheet");
    try
    {
      Object localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("formContent").optJSONArray("items");
      paramJSONObject = ((JSONObject)localObject1).optJSONObject("formContent").optJSONObject("submitButton");
      localObject2 = ((JSONArray)localObject2).optJSONObject(0);
      int i = ((JSONObject)localObject2).optInt("regexType");
      localObject1 = ((JSONObject)localObject1).optJSONObject("formContent").getJSONObject("formRegex").getString("" + i);
      this.jdField_a_of_type_Nyk = new nyk(this, ((JSONObject)localObject2).optInt("regexType"), ((JSONObject)localObject2).optString("name"), ((JSONObject)localObject2).optString("placeholder"), paramJSONObject.optString("text"), (JSONObject)localObject2, Pattern.compile((String)localObject1));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private JSONObject b(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_small_pic_cell");
      Object localObject;
      if (!TextUtils.isEmpty(this.j))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.j);
        paramJSONObject.put("id_inner_title", localObject);
      }
      if (!TextUtils.isEmpty(this.l))
      {
        localObject = sfd.a(this.l, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_inner_small_img", localJSONObject);
      }
      if (!TextUtils.isEmpty(this.L))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.L);
        paramJSONObject.put("id_inner_ad_name", localObject);
      }
      if (!TextUtils.isEmpty(this.I))
      {
        localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.L)) {
          break label262;
        }
        ((JSONObject)localObject).put("text", oas.a(this.I, 16));
      }
      for (;;)
      {
        paramJSONObject.put("id_inner_name", localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 2, "detail ad inner smallStyle Pic adInconText:" + this.L);
        }
        paramJSONObject.put("id_ad_banner_inner_small_root", new JSONObject());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", this);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        paramJSONObject.put("id_operate_edit_area", localObject);
        return paramJSONObject;
        label262:
        ((JSONObject)localObject).put("text", oas.a(this.I, 12));
      }
      paramJSONObject.put("id_view_AdDownloadView", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return paramJSONObject;
    }
    return paramJSONObject;
  }
  
  private JSONObject c(JSONObject paramJSONObject)
  {
    paramJSONObject = b(paramJSONObject);
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_recommend_small_pic_cell");
      return paramJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject;
  }
  
  public void a()
  {
    localObject3 = null;
    this.jdField_b_of_type_OrgJsonJSONObject = a();
    try
    {
      rpu localrpu = rpu.a("native_article", true);
      localObject1 = localObject3;
      if (localrpu != null) {
        localObject1 = localrpu.getTemplateBean(this.jdField_b_of_type_OrgJsonJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        localJSONException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject1);
    }
  }
  
  public boolean a()
  {
    return this.u == 1;
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramJSONObject, paramInt);
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pop_sheet");
      Object localObject = paramJSONObject.optString("inner_ad");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 1, "fillSpecialData->inner_ad:" + (String)localObject);
        }
        for (;;)
        {
          try
          {
            localObject = new JSONObject((String)localObject);
            this.v = ((JSONObject)localObject).optInt("pos_type");
            this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("para_pos");
            a("para_pos", Integer.valueOf(this.jdField_a_of_type_Int));
            if ((((JSONObject)localObject).optInt("has_sheet") == 1) && (!this.c))
            {
              bool = true;
              this.jdField_a_of_type_Boolean = bool;
              this.P = ((JSONObject)localObject).optString("cash_tag");
              paramInt = ((JSONObject)localObject).optInt("style");
              i = paramInt;
            }
          }
          catch (Exception paramJSONObject)
          {
            boolean bool;
            paramInt = 0;
          }
          try
          {
            if (this.jdField_a_of_type_Boolean)
            {
              a(paramJSONObject);
              i = paramInt;
            }
            if ((this.v != 2) && ((this.v != 1) || (this.jdField_a_of_type_Int <= 0))) {
              break;
            }
            if ((i == 2) || (i == 1) || (i == 3)) {
              this.u = i;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProteusInnerData", 1, "fillSpecialData->" + this);
            }
            return true;
          }
          catch (Exception paramJSONObject)
          {
            break label266;
          }
          bool = false;
          continue;
          label266:
          paramJSONObject.printStackTrace();
          int i = paramInt;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ProteusInnerData", 1, "fillSpecialData->check available fail");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ProteusInnerData", 1, "fillSpecialData->inner_ad empty");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ProteusInnerData", 1, "fillSpecialData->jsonObject null");
    }
    return false;
  }
  
  public boolean b()
  {
    return this.u == 2;
  }
  
  public boolean c()
  {
    return this.v == 2;
  }
  
  public String toString()
  {
    return "ProteusInnerData[formId:" + this.jdField_b_of_type_Int + ",  style:" + this.u + ",  pos_type:" + this.v + ",  para_pos:" + this.jdField_a_of_type_Int + ",\n formItem:" + this.jdField_a_of_type_Nyk + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData
 * JD-Core Version:    0.7.0.1
 */