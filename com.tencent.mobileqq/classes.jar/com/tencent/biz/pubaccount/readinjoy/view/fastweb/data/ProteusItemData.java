package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusItemData
  extends BaseData
{
  public String U;
  public String V;
  public String W;
  public TemplateBean a;
  public PTSComposer.IPTSUpdateDataListener a;
  public PTSComposer a;
  public PTSItemData a;
  public JSONObject c;
  public boolean e = true;
  public int w = 0;
  public int x = -1;
  
  public ProteusItemData(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = new ProteusItemData.1(this);
  }
  
  public ProteusItemData(Parcel paramParcel)
  {
    super(paramParcel);
    this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = new ProteusItemData.1(this);
  }
  
  protected void a(JSONObject paramJSONObject) {}
  
  public String b()
  {
    if ((this.w == 3) && (this.c != null)) {
      return this.c.optString("mVideoVid");
    }
    return "";
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = null;
  }
  
  public void b(JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject);
      this.c = paramJSONObject;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ProteusItemData", 2, localException.getMessage());
      }
    }
  }
  
  public String c()
  {
    if ((this.w == 2) && (this.c != null)) {
      return this.c.optString("articleImageUrl");
    }
    return "";
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ProteusParser.getTemplateBean(TemplateFactory.a("native_article", true), this.c);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ProteusItemData", 1, localJSONException.getMessage());
    }
  }
  
  public void c(String paramString)
  {
    this.U = paramString;
  }
  
  public String d()
  {
    if ((this.w == 4) && (this.c != null)) {
      return this.c.optString("type");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */