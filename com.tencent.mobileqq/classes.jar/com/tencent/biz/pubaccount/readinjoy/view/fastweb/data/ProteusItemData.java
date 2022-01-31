package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.pts.core.itemview.PTSItemData;
import org.json.JSONObject;

public class ProteusItemData
  extends BaseData
{
  public String W;
  public String X;
  public String Y;
  public TemplateBean a;
  public PTSItemData a;
  public JSONObject c;
  public boolean f = true;
  public int v = 0;
  public int w = -1;
  
  public ProteusItemData(int paramInt)
  {
    super(paramInt);
  }
  
  public ProteusItemData(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(String paramString)
  {
    this.W = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */