package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import lbq;

public class VideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new lbq();
  public int a;
  public long a;
  public VideoAdInfo a;
  public VideoInfo.InterruptedWeishiAd a;
  public VideoInfo.TopBarInfo a;
  public ArticleInfo a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList a;
  public HashSet a;
  public boolean a;
  private Object[] a;
  public int b;
  public long b;
  public String b;
  public ArrayList b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public ArrayList c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  private boolean i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n;
  public int o;
  public String o;
  public String p;
  public String q;
  
  public VideoInfo()
  {
    this.jdField_h_of_type_Int = 1;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_n_of_type_Int = -1;
  }
  
  public VideoInfo(Parcel paramParcel)
  {
    this.jdField_h_of_type_Int = 1;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_n_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramParcel.readParcelable(MessageForShortVideo.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.g = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.j = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_l_of_type_JavaLangString = paramParcel.readString();
      this.jdField_m_of_type_JavaLangString = paramParcel.readString();
      this.jdField_b_of_type_Long = paramParcel.readLong();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.jdField_k_of_type_Int = paramParcel.readInt();
      this.jdField_l_of_type_Int = paramParcel.readInt();
      this.jdField_m_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label379;
      }
      bool1 = true;
      label261:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_h_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
      this.jdField_n_of_type_JavaLangString = paramParcel.readString();
      this.jdField_c_of_type_JavaUtilArrayList = paramParcel.readArrayList(String.class.getClassLoader());
      if (paramParcel.readByte() == 0) {
        break label384;
      }
    }
    label384:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_h_of_type_Boolean = bool1;
      this.jdField_o_of_type_Int = paramParcel.readInt();
      this.jdField_o_of_type_JavaLangString = paramParcel.readString();
      this.p = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)paramParcel.readParcelable(VideoInfo.TopBarInfo.class.getClassLoader()));
      this.q = paramParcel.readString();
      return;
      bool1 = false;
      break;
      label379:
      bool1 = false;
      break label261;
    }
  }
  
  private void a(Context paramContext, Activity paramActivity)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = VideoFeedsHelper.a(paramContext, paramActivity, b(), c(), this.jdField_i_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoInfo innerInitVideoAreaHeightInfo() videoAreaHeightInfo[0]=" + this.jdField_a_of_type_ArrayOfJavaLangObject[0] + ", videoAreaHeightInfo[1]" + this.jdField_a_of_type_ArrayOfJavaLangObject[1] + ", videoAreaHeightInfo[2]=" + this.jdField_a_of_type_ArrayOfJavaLangObject[2]);
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime;
    }
    return this.jdField_d_of_type_Int;
  }
  
  public int a(Context paramContext, Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramContext, paramActivity);
    }
    return ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue();
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public URL a()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return ShortVideoUtils.a(ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, "jpg"));
    }
    try
    {
      URL localURL = new URL(this.jdField_b_of_type_JavaLangString);
      return localURL;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.g);
  }
  
  public boolean a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity, paramActivity);
    }
    return ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[0]).booleanValue();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.j)) && (paramQQAppInterface != null))
    {
      if (this.j.equals(paramQQAppInterface.c())) {
        return true;
      }
      if (((FriendsManager)paramQQAppInterface.getManager(50)).b(this.j)) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    localStringBuilder1.append("VideoInfo[");
    localStringBuilder1.append("busiType=").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder1.append("width=").append(b()).append(", ");
    localStringBuilder1.append("height=").append(c()).append(", ");
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      StringBuilder localStringBuilder2 = localStringBuilder1.append("msg=");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
      {
        localObject = "null ERROR";
        localStringBuilder2.append((String)localObject);
      }
    }
    for (;;)
    {
      localStringBuilder1.append("isAD=").append(this.jdField_c_of_type_Boolean).append(", ");
      localStringBuilder1.append("adType=").append(this.jdField_h_of_type_Int).append(", ");
      localStringBuilder1.append("recommendBarrageList=[").append(", ");
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        break label609;
      }
      localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder1.append((String)((Iterator)localObject).next()).append(", ");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.toLogString();
      break;
      localStringBuilder1.append("vid=").append(this.jdField_a_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("articleID=").append(this.g).append(", ");
      localStringBuilder1.append("title=").append(this.jdField_c_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("duration=").append(this.jdField_d_of_type_Int).append(", ");
      localStringBuilder1.append("coverUrl=").append(this.jdField_b_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("summary=").append(this.jdField_d_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("createTime=").append(this.e).append(", ");
      localStringBuilder1.append("createTimeStamp=").append(this.jdField_a_of_type_Long).append(", ");
      localStringBuilder1.append("webUrl=").append(this.jdField_f_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("recommendReason=").append(this.jdField_h_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("accountUin=").append(this.j).append(", ");
      localStringBuilder1.append("accountName=").append(this.jdField_k_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("isVerified=").append(this.jdField_a_of_type_Boolean).append(", ");
      localStringBuilder1.append("biuCount=").append(this.jdField_f_of_type_Int).append(", ");
      localStringBuilder1.append("thirdAction=").append(this.jdField_l_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("thirdIconUrl=").append(this.jdField_m_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("XGFileSize=").append(this.jdField_b_of_type_Long).append(", ");
      localStringBuilder1.append("video_url").append(this.jdField_n_of_type_JavaLangString).append(", ");
    }
    label609:
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("isWeishi=").append(this.jdField_f_of_type_Boolean).append(", ");
    localStringBuilder1.append("appJumpTipsDisplayTimePosition=").append(this.jdField_i_of_type_Int).append(", ");
    localStringBuilder1.append("videoReportInfo=").append(this.q).append(", ");
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != 7;
  }
  
  public boolean b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity, paramActivity);
    }
    return ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[2]).booleanValue();
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight;
    }
    return this.jdField_c_of_type_Int;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.a());
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 1)) {
      return 3;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2)) {
      return 4;
    }
    return 2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_b_of_type_Long);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeInt(this.jdField_l_of_type_Int);
      paramParcel.writeInt(this.jdField_m_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break label319;
      }
      b1 = 1;
      label219:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, paramInt);
      paramParcel.writeString(this.jdField_n_of_type_JavaLangString);
      paramParcel.writeStringList(this.jdField_c_of_type_JavaUtilArrayList);
      if (!this.jdField_h_of_type_Boolean) {
        break label324;
      }
    }
    label319:
    label324:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.jdField_o_of_type_Int);
      paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
      paramParcel.writeString(this.p);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo, paramInt);
      paramParcel.writeString(this.q);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label219;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo
 * JD-Core Version:    0.7.0.1
 */