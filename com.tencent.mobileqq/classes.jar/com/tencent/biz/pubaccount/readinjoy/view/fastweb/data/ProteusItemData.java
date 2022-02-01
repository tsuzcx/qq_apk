package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import org.json.JSONObject;
import sov;

public class ProteusItemData
  extends BaseData
{
  public final String O = "ProteusItemData";
  public String P;
  public String Q;
  public String R;
  public TemplateBean a;
  public PTSComposer.IPTSUpdateDataListener a = new sov(this);
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
  
  public String a()
  {
    if ((this.u == 3) && (this.c != null)) {
      return this.c.optString("mVideoVid");
    }
    return "";
  }
  
  public String b()
  {
    if ((this.u == 2) && (this.c != null)) {
      return this.c.optString("articleImageUrl");
    }
    return "";
  }
  
  public String c()
  {
    if ((this.u == 4) && (this.c != null)) {
      return this.c.optString("type");
    }
    return "";
  }
  
  public void c(String paramString)
  {
    this.P = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */