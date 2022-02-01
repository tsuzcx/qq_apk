package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

public class BarrageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BarrageInfo> CREATOR = new BarrageInfo.1();
  public int a;
  public BarrageInfo.Sender a;
  public QQText a;
  public String a;
  public QQText b;
  public String b;
  public String c;
  public String d;
  
  public BarrageInfo() {}
  
  protected BarrageInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender = ((BarrageInfo.Sender)paramParcel.readParcelable(BarrageInfo.Sender.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  private static String a(String paramString)
  {
    if (paramString != null)
    {
      String str = paramString;
      StringBuilder localStringBuilder;
      try
      {
        if ("".equals(paramString)) {
          break label188;
        }
        str = paramString;
        paramString = paramString.replace("\r\n", " ").replace("\n", " ");
        str = paramString;
        localStringBuilder = new StringBuilder(paramString);
        for (;;)
        {
          str = paramString;
          if (localStringBuilder.length() <= 0) {
            break;
          }
          str = paramString;
          if (!Character.isWhitespace(localStringBuilder.charAt(0))) {
            break;
          }
          str = paramString;
          localStringBuilder.deleteCharAt(0);
        }
        return "";
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BarrageInfo", 2, "error. string: " + str + ", errorInfo: " + paramString.getMessage());
        }
        paramString = str;
        if (str != null) {
          return paramString;
        }
      }
      str = paramString;
      for (int i = localStringBuilder.length(); i > 0; i = localStringBuilder.length())
      {
        str = paramString;
        if (!Character.isWhitespace(localStringBuilder.charAt(i - 1))) {
          break;
        }
        str = paramString;
        localStringBuilder.deleteCharAt(i - 1);
        str = paramString;
      }
      str = paramString;
      paramString = localStringBuilder.toString();
      return paramString;
    }
    label188:
    paramString = "";
    return paramString;
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTextQQText = new QQText(EmotionCodecUtils.b(BarrageItemView.a.a(a(this.jdField_b_of_type_JavaLangString))), 7, 15);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender.jdField_b_of_type_JavaLangString))) {
      this.jdField_b_of_type_ComTencentMobileqqTextQQText = new QQText(EmotionCodecUtils.b(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender.jdField_b_of_type_JavaLangString)), 7, 15);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("BarrageInfo{id='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", type=").append(this.jdField_a_of_type_Int).append(", comment='").append(this.jdField_b_of_type_JavaLangString).append('\'').append(", commentCornerUrl='").append(this.c).append('\'').append(", sender=");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender != null) {}
    for (String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender.toString();; str = "null") {
      return str + ", uin=" + this.d + '\'' + '}';
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageInfo$Sender, paramInt);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo
 * JD-Core Version:    0.7.0.1
 */