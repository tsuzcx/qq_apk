package com.tencent.mobileqq.activity.history.tendoc;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class TencentDocItem
  implements Serializable
{
  public static final String TAG = "TencentDocItem";
  private static final long serialVersionUID = 1L;
  public String mDescription;
  public String mIcon;
  public transient MessageRecord mRecord;
  public String mSearchWords;
  public String mTitle;
  public String mUrl;
  
  public static TencentDocItem decodeFromMsgData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = GroupUtil.a(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = (TencentDocItem)paramArrayOfByte;
        return paramArrayOfByte;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("TencentDocItem", 1, "decode failed", paramArrayOfByte);
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TencentDocItem{mTitle='");
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIcon='");
    localStringBuilder.append(this.mIcon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDescription='");
    localStringBuilder.append(this.mDescription);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUrl='");
    localStringBuilder.append(this.mUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRecord=");
    localStringBuilder.append(this.mRecord);
    localStringBuilder.append(", mSearchWords='");
    localStringBuilder.append(this.mSearchWords);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TencentDocItem
 * JD-Core Version:    0.7.0.1
 */