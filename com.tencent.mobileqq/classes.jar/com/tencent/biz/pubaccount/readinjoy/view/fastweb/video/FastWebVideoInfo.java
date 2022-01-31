package com.tencent.biz.pubaccount.readinjoy.view.fastweb.video;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import mol;

public class FastWebVideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new mol();
  public int a;
  public long a;
  public VideoAdInfo a;
  public ArticleInfo a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList a;
  public boolean a;
  private Object[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  
  public FastWebVideoInfo()
  {
    this.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
  }
  
  public FastWebVideoInfo(Parcel paramParcel)
  {
    this.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
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
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_i_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label327;
      }
    }
    label327:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
      this.p = paramParcel.readString();
      this.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(String.class.getClassLoader());
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(Context paramContext, Activity paramActivity)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = VideoFeedsHelper.a(paramContext, paramActivity, b(), c());
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
      localStringBuilder1.append("isAD=").append(this.jdField_a_of_type_Boolean).append(", ");
      localStringBuilder1.append("adType=").append(this.jdField_f_of_type_Int).append(", ");
      localStringBuilder1.append("recommendBarrageList=[");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label579;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder1.append((String)((Iterator)localObject).next()).append(", ");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.toLogString();
      break;
      localStringBuilder1.append("vid=").append(this.jdField_a_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("articleID=").append(this.jdField_g_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("title=").append(this.jdField_c_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("duration=").append(this.jdField_d_of_type_Int).append(", ");
      localStringBuilder1.append("coverUrl=").append(this.jdField_b_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("summary=").append(this.jdField_d_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("createTime=").append(this.e).append(", ");
      localStringBuilder1.append("createTimeStamp=").append(this.jdField_a_of_type_Long).append(", ");
      localStringBuilder1.append("webUrl=").append(this.jdField_f_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("recommendReason=").append(this.jdField_h_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("publicAccountUin=").append(this.jdField_i_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("accountName=").append(this.jdField_j_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("thirdName=").append(this.jdField_k_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("thirdAction=").append(this.l).append(", ");
      localStringBuilder1.append("thirdIconUrl=").append(this.m).append(", ");
      localStringBuilder1.append("XGFileSize=").append(this.jdField_b_of_type_Long).append(", ");
      localStringBuilder1.append("thirdUin=").append(this.n).append(", ");
      localStringBuilder1.append("thirdUinName=").append(this.o).append(", ");
      localStringBuilder1.append("video_url").append(this.p).append(", ");
    }
    label579:
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
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
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean);
  }
  
  public boolean a(Context paramContext, Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramContext, paramActivity);
    }
    return ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[0]).booleanValue();
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight;
    }
    return this.jdField_c_of_type_Int;
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
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    if (this.jdField_b_of_type_Boolean)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label280;
      }
    }
    label280:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, paramInt);
      paramParcel.writeString(this.p);
      paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo
 * JD-Core Version:    0.7.0.1
 */