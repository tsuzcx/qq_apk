package com.tencent.mobileqq.activity.history.tendoc;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.aioapp.GroupUtil;
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
      if (paramArrayOfByte == null) {
        break label32;
      }
      paramArrayOfByte = (TencentDocItem)paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("TencentDocItem", 1, "decode failed", paramArrayOfByte);
        paramArrayOfByte = null;
      }
    }
    return paramArrayOfByte;
  }
  
  public String toString()
  {
    return "TencentDocItem{mTitle='" + this.mTitle + '\'' + ", mIcon='" + this.mIcon + '\'' + ", mDescription='" + this.mDescription + '\'' + ", mUrl='" + this.mUrl + '\'' + ", mRecord=" + this.mRecord + ", mSearchWords='" + this.mSearchWords + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TencentDocItem
 * JD-Core Version:    0.7.0.1
 */