package com.tencent.biz.pubaccount.accountdetail.bean;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicInfo
{
  public MsgAttr a;
  public PictureAttr a;
  public VideoAttr a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("title")) {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("title");
    }
    if (paramJSONObject.has("video")) {
      this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("video");
    }
    if (paramJSONObject.has("picture")) {
      this.jdField_c_of_type_JavaLangString = paramJSONObject.getString("picture");
    }
    if (paramJSONObject.has("picture_attr")) {
      c(paramJSONObject.getJSONObject("picture_attr"));
    }
    if (paramJSONObject.has("video_attr")) {
      d(paramJSONObject.getJSONObject("video_attr"));
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr = new MsgAttr();
      if (paramJSONObject.has("articleid")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Long = paramJSONObject.getLong("articleid");
      }
      if (paramJSONObject.has("id")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_b_of_type_Long = paramJSONObject.getLong("id");
      }
      if (paramJSONObject.has("jumpurl")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("jumpurl");
      }
      if (paramJSONObject.has("msgtype")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Int = paramJSONObject.getInt("msgtype");
      }
      if (paramJSONObject.has("tasktype")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_b_of_type_Int = paramJSONObject.getInt("tasktype");
      }
      if (paramJSONObject.has("time")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.c = paramJSONObject.getLong("time");
      }
      if (paramJSONObject.has("uniqueid")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.d = paramJSONObject.getLong("uniqueid");
      }
      if (paramJSONObject.has("rowkey")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_b_of_type_JavaLangString = paramJSONObject.getString("rowkey");
      }
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr = new PictureAttr();
      if (paramJSONObject.has("cover")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("cover_orig")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.jdField_b_of_type_JavaLangString = paramJSONObject.getString("cover_orig");
      }
      if (paramJSONObject.has("large")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.jdField_a_of_type_Int = paramJSONObject.getInt("large");
      }
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr = null;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr = new VideoAttr();
      if (paramJSONObject.has("busitype")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_Int = paramJSONObject.getInt("busitype");
      }
      if (paramJSONObject.has("cover")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("cover");
      }
      if (paramJSONObject.has("cover_orig")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_d_of_type_JavaLangString = paramJSONObject.getString("cover_orig");
      }
      if (paramJSONObject.has("fulltime")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_Int = paramJSONObject.getInt("fulltime");
      }
      if (paramJSONObject.has("h5url")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_JavaLangString = paramJSONObject.getString("h5url");
      }
      if (paramJSONObject.has("preheight")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_Int = paramJSONObject.getInt("preheight");
      }
      if (paramJSONObject.has("prewidth")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_d_of_type_Int = paramJSONObject.getInt("prewidth");
      }
      if (paramJSONObject.has("vid")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vid");
      }
      if (paramJSONObject.has("large")) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.e = paramJSONObject.getInt("large");
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          localObject = paramString.getJSONObject("msg");
          if (((JSONObject)localObject).has("item"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("item");
            if (localObject == null)
            {
              i = 0;
              break label199;
            }
            int i = ((JSONArray)localObject).length();
            break label199;
            if (j < i)
            {
              JSONArray localJSONArray = ((JSONArray)localObject).getJSONArray(j);
              if (localJSONArray == null)
              {
                k = 0;
                break label204;
              }
              int k = localJSONArray.length();
              break label204;
              if (m >= k) {
                break label210;
              }
              a(localJSONArray.getJSONObject(m));
              m += 1;
              continue;
            }
          }
        }
        if (paramString.has("msg_attr"))
        {
          b(paramString.getJSONObject("msg_attr"));
          return;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("DynamicInfo Exception:");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.d("DynamicInfo", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
      label199:
      int j = 0;
      continue;
      label204:
      int m = 0;
      continue;
      label210:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo
 * JD-Core Version:    0.7.0.1
 */