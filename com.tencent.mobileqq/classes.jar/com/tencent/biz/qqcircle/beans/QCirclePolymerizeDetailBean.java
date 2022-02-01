package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class QCirclePolymerizeDetailBean
  extends QCircleInitBean
{
  private String mDstUin;
  private int mPageId = -1;
  private int mSourceType;
  private String mTransData;
  
  public String getDstUin()
  {
    if (this.mTransData == null) {
      return super.getUin();
    }
    String str = this.mDstUin;
    if ((str == null) || (TextUtils.isEmpty(str))) {
      try
      {
        this.mDstUin = new JSONObject(this.mTransData).getString("dstuin");
      }
      catch (Exception localException)
      {
        this.mDstUin = "";
        localException.printStackTrace();
      }
    }
    return this.mDstUin;
  }
  
  public long getGroupId()
  {
    try
    {
      if ((this.mSchemeAttrs != null) && (this.mSchemeAttrs.containsKey("xsj_share_from_group_id")))
      {
        String str = (String)this.mSchemeAttrs.get("xsj_share_from_group_id");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getGroupId:");
        localStringBuilder.append(str);
        QLog.d("QCirclePolymerizeDetailBean", 1, localStringBuilder.toString());
        long l = Long.parseLong(str);
        return l;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public int getPageId()
  {
    return this.mPageId;
  }
  
  public int getSourceType()
  {
    return this.mSourceType;
  }
  
  public String getTransData()
  {
    return this.mTransData;
  }
  
  public void setPageId(int paramInt)
  {
    this.mPageId = paramInt;
  }
  
  public void setSourceType(int paramInt)
  {
    this.mSourceType = paramInt;
  }
  
  public void setTransData(String paramString)
  {
    this.mTransData = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean
 * JD-Core Version:    0.7.0.1
 */