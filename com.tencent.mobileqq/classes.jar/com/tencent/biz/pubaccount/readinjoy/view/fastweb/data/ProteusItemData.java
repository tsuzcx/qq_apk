package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import org.json.JSONObject;

public class ProteusItemData
  extends BaseData
{
  public String W;
  public String X;
  public String Y;
  public TemplateBean a;
  public PTSComposer a;
  public PTSItemData a;
  public JSONObject c;
  public boolean g = true;
  public int w = 0;
  public int x = -1;
  
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
    if ((this.w == 3) && (this.c != null)) {
      return this.c.optString("mVideoVid");
    }
    return "";
  }
  
  public String b()
  {
    if ((this.w == 2) && (this.c != null)) {
      return this.c.optString("articleImageUrl");
    }
    return "";
  }
  
  public String c()
  {
    if ((this.w == 4) && (this.c != null)) {
      return this.c.optString("type");
    }
    return "";
  }
  
  public void c(String paramString)
  {
    this.W = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */