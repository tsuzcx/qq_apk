package com.tencent.biz.pubaccount;

import afur;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import anmw;
import bgtn;
import bqcd;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import obn;
import ocb;
import occ;
import omx;
import ryx;
import tkf;

public class VideoInfo
  implements Parcelable, tkf
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new obn();
  public String A;
  public String B;
  public String C;
  public int a;
  public long a;
  public VideoAdInfo a;
  public VideoInfo.AdTagInfo a;
  public VideoInfo.DownloadBarInfo a;
  public VideoInfo.ECommerceEntranceInfo a;
  public VideoInfo.InterruptedWeishiAd a;
  public VideoInfo.LikeActionDownloadBar a;
  public VideoInfo.SoftAdDownloadBarInfo a;
  public VideoInfo.TopBarInfo a;
  public AdvertisementInfo a;
  public ArticleInfo a;
  public VideoColumnInfo a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<VideoInfo.ChannelInfo> a;
  public HashSet<String> a;
  public ocb a;
  public occ a;
  public omx a;
  public boolean a;
  private Object[] a;
  public int b;
  public long b;
  public String b;
  public ArrayList<DislikeInfo> b;
  public ocb b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public ArrayList<String> c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList<VideoInfo> d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
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
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k;
  public String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
  public int n;
  public String n;
  public boolean n;
  public int o;
  public String o;
  public boolean o;
  public int p;
  public String p;
  public boolean p;
  public int q;
  public String q;
  public boolean q;
  public int r;
  public String r;
  public boolean r;
  public int s;
  public String s;
  private boolean s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public VideoInfo()
  {
    this.jdField_i_of_type_Int = 1;
    this.jdField_a_of_type_Omx = new omx();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_s_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
  }
  
  public VideoInfo(Parcel paramParcel)
  {
    this.jdField_i_of_type_Int = 1;
    this.jdField_a_of_type_Omx = new omx();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_s_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramParcel.readParcelable(MessageForShortVideo.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(VideoInfo.ChannelInfo.CREATOR);
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(DislikeInfo.CREATOR);
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label895;
      }
      bool1 = true;
      label264:
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_l_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_o_of_type_JavaLangString = paramParcel.readString();
      this.jdField_p_of_type_JavaLangString = paramParcel.readString();
      this.jdField_q_of_type_JavaLangString = paramParcel.readString();
      this.jdField_r_of_type_JavaLangString = paramParcel.readString();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.jdField_h_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramParcel.readParcelable(ArticleInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label900;
      }
      bool1 = true;
      label366:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_i_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
      this.jdField_c_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
      if (paramParcel.readByte() == 0) {
        break label905;
      }
      bool1 = true;
      label412:
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label910;
      }
      bool1 = true;
      label426:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label915;
      }
      bool1 = true;
      label440:
      this.jdField_f_of_type_Boolean = bool1;
      this.jdField_j_of_type_Int = paramParcel.readInt();
      this.jdField_k_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)paramParcel.readParcelable(VideoInfo.TopBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = ((VideoInfo.InterruptedWeishiAd)paramParcel.readParcelable(VideoInfo.InterruptedWeishiAd.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)paramParcel.readParcelable(VideoInfo.DownloadBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = ((VideoInfo.ECommerceEntranceInfo)paramParcel.readParcelable(VideoInfo.ECommerceEntranceInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label920;
      }
      bool1 = true;
      label534:
      this.jdField_s_of_type_Boolean = bool1;
      this.jdField_l_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Long = paramParcel.readLong();
      this.jdField_p_of_type_Int = paramParcel.readInt();
      this.jdField_q_of_type_Int = paramParcel.readInt();
      this.jdField_r_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label925;
      }
      bool1 = true;
      label588:
      this.jdField_q_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label930;
      }
      bool1 = true;
      label602:
      this.jdField_r_of_type_Boolean = bool1;
      this.jdField_s_of_type_Int = paramParcel.readInt();
      this.z = paramParcel.readString();
      this.A = paramParcel.readString();
      this.B = paramParcel.readString();
      this.C = paramParcel.readString();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label935;
      }
      bool1 = true;
      label664:
      this.jdField_g_of_type_Boolean = bool1;
      this.jdField_s_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() != 0) {
        break label940;
      }
      bool1 = true;
      label686:
      this.jdField_h_of_type_Boolean = bool1;
      this.jdField_d_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(CREATOR);
      this.jdField_m_of_type_Int = paramParcel.readInt();
      this.jdField_n_of_type_Int = paramParcel.readInt();
      this.u = paramParcel.readString();
      this.v = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = ((VideoInfo.LikeActionDownloadBar)paramParcel.readParcelable(VideoInfo.LikeActionDownloadBar.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = ((VideoColumnInfo)paramParcel.readParcelable(VideoColumnInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = ((VideoInfo.SoftAdDownloadBarInfo)paramParcel.readParcelable(VideoInfo.SoftAdDownloadBarInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label945;
      }
      bool1 = true;
      label794:
      this.jdField_k_of_type_Boolean = bool1;
      this.w = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label950;
      }
      bool1 = true;
      label816:
      this.jdField_l_of_type_Boolean = bool1;
      this.x = paramParcel.readString();
      this.jdField_m_of_type_JavaLangString = paramParcel.readString();
      this.jdField_n_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label955;
      }
      bool1 = true;
      label854:
      this.jdField_o_of_type_Boolean = bool1;
      this.y = paramParcel.readString();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label960;
      }
    }
    label900:
    label905:
    label910:
    label915:
    label920:
    label925:
    label930:
    label935:
    label940:
    label945:
    label950:
    label955:
    label960:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_p_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      label895:
      bool1 = false;
      break label264;
      bool1 = false;
      break label366;
      bool1 = false;
      break label412;
      bool1 = false;
      break label426;
      bool1 = false;
      break label440;
      bool1 = false;
      break label534;
      bool1 = false;
      break label588;
      bool1 = false;
      break label602;
      bool1 = false;
      break label664;
      bool1 = false;
      break label686;
      bool1 = false;
      break label794;
      bool1 = false;
      break label816;
      bool1 = false;
      break label854;
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = ryx.a(paramActivity, b(), c());
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder("VideoInfo innerInitVideoAreaHeightInfo() ");
      paramActivity.append("videoAreaHeightInfo[0]=").append(this.jdField_a_of_type_ArrayOfJavaLangObject[0]).append(", videoAreaHeightInfo[1]=").append(this.jdField_a_of_type_ArrayOfJavaLangObject[1]).append(", videoAreaHeightInfo[2]=").append(this.jdField_a_of_type_ArrayOfJavaLangObject[2]);
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramActivity.toString());
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime;
    }
    return this.jdField_d_of_type_Int;
  }
  
  public int a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity);
    }
    return ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue();
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    return ryx.a(paramActivity, this, paramInt);
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      return this.jdField_g_of_type_JavaLangString;
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
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = null;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Int = paramVideoInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    this.jdField_a_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramVideoInfo.jdField_c_of_type_Int;
    this.jdField_d_of_type_Int = paramVideoInfo.jdField_d_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramVideoInfo.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_JavaLangString = paramVideoInfo.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramVideoInfo.jdField_a_of_type_Long;
    this.jdField_f_of_type_JavaLangString = paramVideoInfo.jdField_f_of_type_JavaLangString;
    this.jdField_g_of_type_JavaLangString = paramVideoInfo.jdField_g_of_type_JavaLangString;
    this.jdField_h_of_type_JavaLangString = paramVideoInfo.jdField_h_of_type_JavaLangString;
    this.jdField_a_of_type_JavaUtilArrayList = paramVideoInfo.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_b_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    this.jdField_i_of_type_JavaLangString = paramVideoInfo.jdField_i_of_type_JavaLangString;
    this.jdField_e_of_type_Int = paramVideoInfo.jdField_e_of_type_Int;
    this.jdField_b_of_type_JavaUtilArrayList = paramVideoInfo.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_j_of_type_JavaLangString = paramVideoInfo.jdField_j_of_type_JavaLangString;
    this.jdField_k_of_type_JavaLangString = paramVideoInfo.jdField_k_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramVideoInfo.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramVideoInfo.jdField_b_of_type_Boolean;
    this.jdField_c_of_type_Long = paramVideoInfo.jdField_c_of_type_Long;
    this.jdField_l_of_type_JavaLangString = paramVideoInfo.jdField_l_of_type_JavaLangString;
    this.jdField_f_of_type_Int = paramVideoInfo.jdField_f_of_type_Int;
    this.jdField_o_of_type_JavaLangString = paramVideoInfo.jdField_o_of_type_JavaLangString;
    this.jdField_p_of_type_JavaLangString = paramVideoInfo.jdField_p_of_type_JavaLangString;
    this.jdField_q_of_type_JavaLangString = paramVideoInfo.jdField_q_of_type_JavaLangString;
    this.jdField_r_of_type_JavaLangString = paramVideoInfo.jdField_r_of_type_JavaLangString;
    this.jdField_d_of_type_Long = paramVideoInfo.jdField_d_of_type_Long;
    this.jdField_h_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_c_of_type_Boolean = paramVideoInfo.jdField_c_of_type_Boolean;
    this.jdField_i_of_type_Int = paramVideoInfo.jdField_i_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    this.jdField_c_of_type_JavaUtilArrayList = paramVideoInfo.jdField_c_of_type_JavaUtilArrayList;
    this.jdField_d_of_type_Boolean = paramVideoInfo.jdField_d_of_type_Boolean;
    this.jdField_e_of_type_Boolean = paramVideoInfo.jdField_e_of_type_Boolean;
    this.jdField_f_of_type_Boolean = paramVideoInfo.jdField_f_of_type_Boolean;
    this.jdField_j_of_type_Int = paramVideoInfo.jdField_j_of_type_Int;
    this.jdField_k_of_type_Int = paramVideoInfo.jdField_k_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
    this.jdField_s_of_type_Boolean = paramVideoInfo.jdField_s_of_type_Boolean;
    this.jdField_l_of_type_Int = paramVideoInfo.jdField_l_of_type_Int;
    this.jdField_f_of_type_Long = paramVideoInfo.jdField_f_of_type_Long;
    this.jdField_p_of_type_Int = paramVideoInfo.jdField_p_of_type_Int;
    this.jdField_q_of_type_Int = paramVideoInfo.jdField_q_of_type_Int;
    this.jdField_r_of_type_Int = paramVideoInfo.jdField_r_of_type_Int;
    this.jdField_q_of_type_Boolean = paramVideoInfo.jdField_q_of_type_Boolean;
    this.jdField_r_of_type_Boolean = paramVideoInfo.jdField_r_of_type_Boolean;
    this.jdField_s_of_type_Int = paramVideoInfo.jdField_s_of_type_Int;
    this.z = paramVideoInfo.z;
    this.A = paramVideoInfo.A;
    this.B = paramVideoInfo.B;
    this.C = paramVideoInfo.C;
    this.jdField_e_of_type_Long = paramVideoInfo.jdField_e_of_type_Long;
    this.jdField_g_of_type_Boolean = paramVideoInfo.jdField_g_of_type_Boolean;
    this.jdField_s_of_type_JavaLangString = paramVideoInfo.jdField_s_of_type_JavaLangString;
    this.jdField_h_of_type_Boolean = paramVideoInfo.jdField_h_of_type_Boolean;
    this.jdField_n_of_type_Int = paramVideoInfo.jdField_n_of_type_Int;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = this.jdField_c_of_type_Long;
    }
    this.u = paramVideoInfo.u;
    this.v = paramVideoInfo.v;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo;
    this.jdField_m_of_type_JavaLangString = paramVideoInfo.jdField_m_of_type_JavaLangString;
    this.jdField_n_of_type_JavaLangString = paramVideoInfo.jdField_n_of_type_JavaLangString;
    this.jdField_o_of_type_Boolean = paramVideoInfo.jdField_o_of_type_Boolean;
    this.y = paramVideoInfo.y;
    this.jdField_g_of_type_Int = paramVideoInfo.jdField_g_of_type_Int;
    this.jdField_p_of_type_Boolean = paramVideoInfo.jdField_p_of_type_Boolean;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null);
  }
  
  public boolean a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity);
    }
    return ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[0]).booleanValue();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) && (paramQQAppInterface != null))
    {
      if (this.jdField_j_of_type_JavaLangString.equals(paramQQAppInterface.c())) {
        return true;
      }
      if (((anmw)paramQQAppInterface.getManager(51)).b(this.jdField_j_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public int[] a(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    int i1 = -1;
    paramInt = a(paramActivity, paramInt);
    int i2 = bgtn.a(50.0F);
    switch (paramInt)
    {
    case 1: 
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      return new int[] { paramInt, i1 };
      int i3 = afur.a(10.0F, paramActivity.getResources());
      i1 = i3;
      paramInt = i2;
      if (bqcd.b())
      {
        paramInt = i2 + bqcd.b(paramActivity);
        i1 = i3;
        continue;
        if (!paramBoolean)
        {
          int i4 = b(paramActivity);
          int i5 = ryx.b(paramActivity)[1];
          if (i5 < i4) {
            break;
          }
          i3 = afur.a(10.0F, paramActivity.getResources());
          if (b(paramActivity))
          {
            i1 = i3;
            paramInt = i2;
            if ((i5 - i4) / 2 <= i2) {
              continue;
            }
            paramInt = (i5 - i4) / 2 + afur.a(32.0F, paramActivity.getResources());
            i1 = i3;
            continue;
          }
          paramInt = (i5 - i4) / 2 + afur.a(10.0F, paramActivity.getResources());
          i1 = i3;
          continue;
        }
        if (c() != 0) {
          break label228;
        }
        paramInt = -1;
      }
    }
    label228:
    paramInt = ryx.b(paramActivity)[1];
    i1 = ryx.b(paramActivity)[0];
    float f1 = b() / c();
    i1 = (int)(i1 * f1);
    if (i1 <= paramInt) {}
    for (i1 = (paramInt - i1) / 2 + afur.a(16.0F, paramActivity.getResources());; i1 = afur.a(16.0F, paramActivity.getResources()))
    {
      paramInt = afur.a(16.0F, paramActivity.getResources());
      break;
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity);
    }
    return ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue();
  }
  
  public String b()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    localStringBuilder1.append("VideoInfo[");
    localStringBuilder1.append("busiType=").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder1.append("width=").append(b()).append(", ");
    localStringBuilder1.append("height=").append(c()).append(", ");
    StringBuilder localStringBuilder2;
    if (this.jdField_a_of_type_Int == 0)
    {
      localStringBuilder2 = localStringBuilder1.append("msg=");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
      {
        localObject = "null ERROR";
        localStringBuilder2.append((String)localObject);
        label114:
        if (this.jdField_a_of_type_Int == 6)
        {
          localStringBuilder1.append("video_url=").append(this.jdField_r_of_type_JavaLangString).append(", ");
          localStringBuilder1.append("feedId=").append(this.jdField_d_of_type_Long).append(", ");
          localStringBuilder1.append("feedType=").append(this.jdField_h_of_type_Int).append(", ");
          localStringBuilder2 = localStringBuilder1.append("articleInfo.mArticleID=");
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
            break label916;
          }
        }
      }
    }
    label916:
    for (Object localObject = "articleInfo null";; localObject = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID))
    {
      localStringBuilder2.append(localObject).append(", ");
      localStringBuilder1.append("isAD=").append(this.jdField_c_of_type_Boolean).append(", ");
      localStringBuilder1.append("adType=").append(this.jdField_i_of_type_Int).append(", ");
      localStringBuilder1.append("recommendBarrageList=[");
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        break label930;
      }
      localObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
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
      localStringBuilder1.append("createTime=").append(this.jdField_e_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("createTimeStamp=").append(this.jdField_a_of_type_Long).append(", ");
      localStringBuilder1.append("webUrl=").append(this.jdField_f_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("recommendReason=").append(this.jdField_h_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("accountUin=").append(this.jdField_j_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("accountName=").append(this.jdField_k_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("isVerified=").append(this.jdField_a_of_type_Boolean).append(", ");
      localStringBuilder1.append("biuCount=").append(this.jdField_f_of_type_Int).append(", ");
      localStringBuilder1.append("commentCount=").append(this.jdField_e_of_type_Int).append(", ");
      localStringBuilder1.append("playCount=").append(this.jdField_q_of_type_Int).append(", ");
      localStringBuilder1.append("likeCount=").append(this.jdField_r_of_type_Int).append(", ");
      localStringBuilder1.append("isDianZan=").append(this.jdField_r_of_type_Boolean).append(", ");
      localStringBuilder1.append("dianZanCount=").append(this.jdField_s_of_type_Int).append(", ");
      localStringBuilder1.append("thirdAction=").append(this.jdField_o_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("thirdIconUrl=").append(this.jdField_p_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("xgFileSize=").append(this.jdField_b_of_type_Long).append(", ");
      localStringBuilder1.append("articleSubsText").append(this.z).append(", ");
      localStringBuilder1.append("articleSubsColor=").append(this.A).append(", ");
      localStringBuilder1.append("isUgc=").append(this.jdField_b_of_type_Boolean).append(", ");
      localStringBuilder1.append("isFollowed=").append(this.jdField_q_of_type_Boolean).append(", ");
      localStringBuilder1.append("aioShareUrl=").append(this.jdField_m_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("qzoneShareUrl=").append(this.jdField_n_of_type_JavaLangString).append(", ");
      break label114;
    }
    label930:
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("topBarInfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo != null) {
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo.toString());
    }
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("interruptedWeishiAd=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) {
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.toString());
    }
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("commerceEntranceInfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo != null) {
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.toString());
    }
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("downloadBarinfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo != null) {
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo.toString());
    }
    localStringBuilder1.append("]").append(", ");
    localStringBuilder1.append("videoReportInfo=").append(this.B).append(", ");
    localStringBuilder1.append("avatarJumpUrl=").append(this.C).append(", ");
    localStringBuilder1.append("dynamicInsertTriggerSec=").append(this.jdField_n_of_type_Int).append(", ");
    localStringBuilder1.append("videoLogoUrl=").append(this.u).append(", ");
    localStringBuilder1.append("vIconUrl=").append(this.v).append(", ");
    localStringBuilder1.append("likeActionDownloadBar=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar).append(", ");
    localStringBuilder1.append("videoColumnInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).append(", ");
    localStringBuilder1.append("columnId=").append(this.jdField_g_of_type_Int).append(", ");
    localStringBuilder1.append("softAdDownloadBarInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).append(", ");
    localStringBuilder1.append("redpacketId=").append(this.w).append(", ");
    localStringBuilder1.append("wechatShareUrl=").append(this.y).append(", ");
    localStringBuilder1.append("]");
    localStringBuilder1.append("isUseGif=").append(this.jdField_g_of_type_Boolean).append(", ").append("gifUrl=").append(this.jdField_s_of_type_JavaLangString).append(", ").append("isShowCover=").append(this.jdField_h_of_type_Boolean).append("]");
    localStringBuilder1.append("isForbidReprint=").append(this.jdField_o_of_type_Boolean);
    return localStringBuilder1.toString();
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public boolean b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity);
    }
    return ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[3]).booleanValue();
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight;
    }
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_s_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_i_of_type_Int == 1)) {
      return 3;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_i_of_type_Int == 2)) {
      return 4;
    }
    return 2;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i2 = 1;
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeTypedList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 1;
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_b_of_type_Boolean) {
        break label773;
      }
      i1 = 1;
      label196:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_p_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_q_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_r_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label778;
      }
      i1 = 1;
      label292:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, paramInt);
      paramParcel.writeStringList(this.jdField_c_of_type_JavaUtilArrayList);
      if (!this.jdField_d_of_type_Boolean) {
        break label783;
      }
      i1 = 1;
      label332:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_e_of_type_Boolean) {
        break label788;
      }
      i1 = 1;
      label347:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_f_of_type_Boolean) {
        break label793;
      }
      i1 = 1;
      label362:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt);
      if (!this.jdField_s_of_type_Boolean) {
        break label798;
      }
      i1 = 1;
      label429:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_l_of_type_Int);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      paramParcel.writeInt(this.jdField_p_of_type_Int);
      paramParcel.writeInt(this.jdField_q_of_type_Int);
      paramParcel.writeInt(this.jdField_r_of_type_Int);
      if (!this.jdField_q_of_type_Boolean) {
        break label803;
      }
      i1 = 1;
      label484:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_r_of_type_Boolean) {
        break label808;
      }
      i1 = 1;
      label499:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_s_of_type_Int);
      paramParcel.writeString(this.z);
      paramParcel.writeString(this.A);
      paramParcel.writeString(this.B);
      paramParcel.writeString(this.C);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      if (!this.jdField_g_of_type_Boolean) {
        break label813;
      }
      i1 = 1;
      label562:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeString(this.jdField_s_of_type_JavaLangString);
      if (!this.jdField_h_of_type_Boolean) {
        break label818;
      }
      i1 = 0;
      label585:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeTypedList(this.jdField_d_of_type_JavaUtilArrayList);
      paramParcel.writeInt(this.jdField_m_of_type_Int);
      paramParcel.writeInt(this.jdField_n_of_type_Int);
      paramParcel.writeString(this.u);
      paramParcel.writeString(this.v);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo, paramInt);
      if (!this.jdField_k_of_type_Boolean) {
        break label823;
      }
      paramInt = 1;
      label667:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.w);
      if (!this.jdField_l_of_type_Boolean) {
        break label828;
      }
      paramInt = 1;
      label690:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.x);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_n_of_type_JavaLangString);
      if (!this.jdField_o_of_type_Boolean) {
        break label833;
      }
      paramInt = 1;
      label729:
      paramParcel.writeInt((byte)paramInt);
      paramParcel.writeString(this.y);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      if (!this.jdField_p_of_type_Boolean) {
        break label838;
      }
    }
    label773:
    label778:
    label783:
    label788:
    label793:
    label798:
    label803:
    label808:
    label813:
    label818:
    label823:
    label828:
    label833:
    label838:
    for (paramInt = i2;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label196;
      i1 = 0;
      break label292;
      i1 = 0;
      break label332;
      i1 = 0;
      break label347;
      i1 = 0;
      break label362;
      i1 = 0;
      break label429;
      i1 = 0;
      break label484;
      i1 = 0;
      break label499;
      i1 = 0;
      break label562;
      i1 = 1;
      break label585;
      paramInt = 0;
      break label667;
      paramInt = 0;
      break label690;
      paramInt = 0;
      break label729;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo
 * JD-Core Version:    0.7.0.1
 */