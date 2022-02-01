package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicChannelDataModel
  extends Entity
{
  @notColumn
  public static final String TAG = "DynamicChannelDataModel";
  public int channelID;
  @notColumn
  public TemplateBean mTemplateBean;
  public String proteusData;
  public long recommendSeq;
  public String styleID;
  public String uniqueID;
  
  public static String getStyleIDFromProteusData(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2;
    }
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        str1 = new JSONObject(paramString).getString("style_ID");
      }
      QLog.d("DynamicChannelDataModel", 2, new Object[] { "getStyleIDFromProteusData, styleID = ", str1 });
      return str1;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.d("DynamicChannelDataModel", 2, "getStyleIDFromProteusData, e = ", paramString);
        str1 = str2;
      }
    }
  }
  
  public String toString()
  {
    return "uniqueID = " + this.uniqueID + ", channelID = " + this.channelID + ", styleID = " + this.styleID + ", recommendSeq = " + this.recommendSeq + ", proteusData = " + this.proteusData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel
 * JD-Core Version:    0.7.0.1
 */