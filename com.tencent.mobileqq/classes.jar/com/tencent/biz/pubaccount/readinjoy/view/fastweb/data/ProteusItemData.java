package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import org.json.JSONObject;

public class ProteusItemData
  extends BaseData
{
  public String V;
  public TemplateBean a;
  public float b = -1000.0F;
  public JSONObject b;
  public boolean f = true;
  public int s = 0;
  public int t = -1;
  
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
    this.V = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData
 * JD-Core Version:    0.7.0.1
 */