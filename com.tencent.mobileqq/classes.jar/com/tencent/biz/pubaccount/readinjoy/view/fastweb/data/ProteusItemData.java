package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import org.json.JSONObject;
import tgg;

public class ProteusItemData
  extends BaseData
{
  public final String S = "ProteusItemData";
  public String T;
  public String U;
  public String V;
  public TemplateBean a;
  public PTSComposer.IPTSUpdateDataListener a = new tgg(this);
  public PTSComposer a;
  public PTSItemData a;
  public JSONObject c;
  public boolean e = true;
  public int u = 0;
  public int v = -1;
  
  public ProteusItemData(int paramInt)
  {
    super(paramInt);
  }
  
  public ProteusItemData(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public String b()
  {
    if ((this.u == 3) && (this.c != null)) {
      return this.c.optString("mVideoVid");
    }
    return "";
  }
  
  public String c()
  {
    if ((this.u == 2) && (this.c != null)) {
      return this.c.optString("articleImageUrl");
    }
    return "";
  }
  
  public void c(String paramString)
  {
    this.T = paramString;
  }
  
  public String d()
  {
    if ((this.u == 4) && (this.c != null)) {
      return this.c.optString("type");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */