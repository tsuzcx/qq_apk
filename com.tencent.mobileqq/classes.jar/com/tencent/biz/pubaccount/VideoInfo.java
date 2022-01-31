package com.tencent.biz.pubaccount;

import aepi;
import alto;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bdoo;
import bkbq;
import bnle;
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
import nsj;
import nsx;
import nsy;
import rdm;
import slk;

public class VideoInfo
  implements Parcelable, slk
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new nsj();
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
  public nsx a;
  public nsy a;
  public boolean a;
  private Object[] a;
  public int b;
  public long b;
  public String b;
  public ArrayList<DislikeInfo> b;
  public nsx b;
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
  private boolean q;
  public int r;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public VideoInfo()
  {
    this.jdField_h_of_type_Int = 1;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_q_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
  }
  
  public VideoInfo(Parcel paramParcel)
  {
    this.jdField_h_of_type_Int = 1;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_q_of_type_Boolean = true;
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
        break label824;
      }
      bool1 = true;
      label253:
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_l_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_m_of_type_JavaLangString = paramParcel.readString();
      this.n = paramParcel.readString();
      this.jdField_o_of_type_JavaLangString = paramParcel.readString();
      this.jdField_p_of_type_JavaLangString = paramParcel.readString();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramParcel.readParcelable(ArticleInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label829;
      }
      bool1 = true;
      label355:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_h_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
      this.jdField_c_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
      if (paramParcel.readByte() == 0) {
        break label834;
      }
      bool1 = true;
      label401:
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label839;
      }
      bool1 = true;
      label415:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label844;
      }
      bool1 = true;
      label429:
      this.jdField_f_of_type_Boolean = bool1;
      this.jdField_i_of_type_Int = paramParcel.readInt();
      this.jdField_j_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)paramParcel.readParcelable(VideoInfo.TopBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = ((VideoInfo.InterruptedWeishiAd)paramParcel.readParcelable(VideoInfo.InterruptedWeishiAd.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)paramParcel.readParcelable(VideoInfo.DownloadBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = ((VideoInfo.ECommerceEntranceInfo)paramParcel.readParcelable(VideoInfo.ECommerceEntranceInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label849;
      }
      bool1 = true;
      label523:
      this.jdField_q_of_type_Boolean = bool1;
      this.jdField_k_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Long = paramParcel.readLong();
      this.jdField_o_of_type_Int = paramParcel.readInt();
      this.jdField_p_of_type_Int = paramParcel.readInt();
      this.jdField_q_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label854;
      }
      bool1 = true;
      label577:
      this.jdField_o_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label859;
      }
      bool1 = true;
      label591:
      this.jdField_p_of_type_Boolean = bool1;
      this.r = paramParcel.readInt();
      this.w = paramParcel.readString();
      this.x = paramParcel.readString();
      this.y = paramParcel.readString();
      this.z = paramParcel.readString();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label864;
      }
      bool1 = true;
      label653:
      this.jdField_g_of_type_Boolean = bool1;
      this.jdField_q_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() != 0) {
        break label869;
      }
      bool1 = true;
      label675:
      this.jdField_h_of_type_Boolean = bool1;
      this.jdField_d_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(CREATOR);
      this.jdField_l_of_type_Int = paramParcel.readInt();
      this.jdField_m_of_type_Int = paramParcel.readInt();
      this.s = paramParcel.readString();
      this.t = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = ((VideoInfo.LikeActionDownloadBar)paramParcel.readParcelable(VideoInfo.LikeActionDownloadBar.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = ((VideoColumnInfo)paramParcel.readParcelable(VideoColumnInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = ((VideoInfo.SoftAdDownloadBarInfo)paramParcel.readParcelable(VideoInfo.SoftAdDownloadBarInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label874;
      }
      bool1 = true;
      label783:
      this.jdField_k_of_type_Boolean = bool1;
      this.u = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label879;
      }
    }
    label824:
    label829:
    label834:
    label839:
    label844:
    label849:
    label854:
    label859:
    label864:
    label869:
    label874:
    label879:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_l_of_type_Boolean = bool1;
      this.v = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label253;
      bool1 = false;
      break label355;
      bool1 = false;
      break label401;
      bool1 = false;
      break label415;
      bool1 = false;
      break label429;
      bool1 = false;
      break label523;
      bool1 = false;
      break label577;
      bool1 = false;
      break label591;
      bool1 = false;
      break label653;
      bool1 = false;
      break label675;
      bool1 = false;
      break label783;
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = rdm.a(paramActivity, b(), c());
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
    this.jdField_m_of_type_JavaLangString = paramVideoInfo.jdField_m_of_type_JavaLangString;
    this.n = paramVideoInfo.n;
    this.jdField_o_of_type_JavaLangString = paramVideoInfo.jdField_o_of_type_JavaLangString;
    this.jdField_p_of_type_JavaLangString = paramVideoInfo.jdField_p_of_type_JavaLangString;
    this.jdField_d_of_type_Long = paramVideoInfo.jdField_d_of_type_Long;
    this.jdField_g_of_type_Int = paramVideoInfo.jdField_g_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_c_of_type_Boolean = paramVideoInfo.jdField_c_of_type_Boolean;
    this.jdField_h_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    this.jdField_c_of_type_JavaUtilArrayList = paramVideoInfo.jdField_c_of_type_JavaUtilArrayList;
    this.jdField_d_of_type_Boolean = paramVideoInfo.jdField_d_of_type_Boolean;
    this.jdField_e_of_type_Boolean = paramVideoInfo.jdField_e_of_type_Boolean;
    this.jdField_f_of_type_Boolean = paramVideoInfo.jdField_f_of_type_Boolean;
    this.jdField_i_of_type_Int = paramVideoInfo.jdField_i_of_type_Int;
    this.jdField_j_of_type_Int = paramVideoInfo.jdField_j_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
    this.jdField_q_of_type_Boolean = paramVideoInfo.jdField_q_of_type_Boolean;
    this.jdField_k_of_type_Int = paramVideoInfo.jdField_k_of_type_Int;
    this.jdField_f_of_type_Long = paramVideoInfo.jdField_f_of_type_Long;
    this.jdField_o_of_type_Int = paramVideoInfo.jdField_o_of_type_Int;
    this.jdField_p_of_type_Int = paramVideoInfo.jdField_p_of_type_Int;
    this.jdField_q_of_type_Int = paramVideoInfo.jdField_q_of_type_Int;
    this.jdField_o_of_type_Boolean = paramVideoInfo.jdField_o_of_type_Boolean;
    this.jdField_p_of_type_Boolean = paramVideoInfo.jdField_p_of_type_Boolean;
    this.r = paramVideoInfo.r;
    this.w = paramVideoInfo.w;
    this.x = paramVideoInfo.x;
    this.y = paramVideoInfo.y;
    this.z = paramVideoInfo.z;
    this.jdField_e_of_type_Long = paramVideoInfo.jdField_e_of_type_Long;
    this.jdField_g_of_type_Boolean = paramVideoInfo.jdField_g_of_type_Boolean;
    this.jdField_q_of_type_JavaLangString = paramVideoInfo.jdField_q_of_type_JavaLangString;
    this.jdField_h_of_type_Boolean = paramVideoInfo.jdField_h_of_type_Boolean;
    this.jdField_m_of_type_Int = paramVideoInfo.jdField_m_of_type_Int;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = this.jdField_c_of_type_Long;
    }
    this.s = paramVideoInfo.s;
    this.t = paramVideoInfo.t;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo;
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
      if (((alto)paramQQAppInterface.getManager(51)).b(this.jdField_j_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public int[] a(Activity paramActivity, boolean paramBoolean)
  {
    int i2 = -1;
    int i1 = c(paramActivity);
    int i3 = bdoo.a(50.0F);
    switch (i1)
    {
    case 1: 
    default: 
      i1 = -1;
    }
    for (;;)
    {
      return new int[] { i1, i2 };
      int i4 = aepi.a(10.0F, paramActivity.getResources());
      i2 = i4;
      i1 = i3;
      if (bnle.b())
      {
        i1 = i3 + bnle.b(paramActivity);
        i2 = i4;
        continue;
        if (!paramBoolean)
        {
          int i5 = b(paramActivity);
          int i6 = rdm.b(paramActivity)[1];
          if (i6 < i5) {
            break;
          }
          i4 = aepi.a(10.0F, paramActivity.getResources());
          if (b(paramActivity))
          {
            i2 = i4;
            i1 = i3;
            if ((i6 - i5) / 2 <= i3) {
              continue;
            }
            i1 = (i6 - i5) / 2 + aepi.a(32.0F, paramActivity.getResources());
            i2 = i4;
            continue;
          }
          i1 = (i6 - i5) / 2 + aepi.a(10.0F, paramActivity.getResources());
          i2 = i4;
          continue;
        }
        if (c() != 0) {
          break label240;
        }
        i1 = -1;
      }
    }
    label240:
    i1 = rdm.b(paramActivity)[1];
    i2 = rdm.b(paramActivity)[0];
    float f1 = b() / c();
    i2 = (int)(i2 * f1);
    if (i2 <= i1) {}
    for (i2 = (i1 - i2) / 2 + aepi.a(16.0F, paramActivity.getResources());; i2 = aepi.a(16.0F, paramActivity.getResources()))
    {
      i1 = aepi.a(16.0F, paramActivity.getResources());
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
          localStringBuilder1.append("video_url=").append(this.jdField_p_of_type_JavaLangString).append(", ");
          localStringBuilder1.append("feedId=").append(this.jdField_d_of_type_Long).append(", ");
          localStringBuilder1.append("feedType=").append(this.jdField_g_of_type_Int).append(", ");
          localStringBuilder2 = localStringBuilder1.append("articleInfo.mArticleID=");
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
            break label874;
          }
        }
      }
    }
    label874:
    for (Object localObject = "articleInfo null";; localObject = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID))
    {
      localStringBuilder2.append(localObject).append(", ");
      localStringBuilder1.append("isAD=").append(this.jdField_c_of_type_Boolean).append(", ");
      localStringBuilder1.append("adType=").append(this.jdField_h_of_type_Int).append(", ");
      localStringBuilder1.append("recommendBarrageList=[");
      if (this.jdField_c_of_type_JavaUtilArrayList == null) {
        break label888;
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
      localStringBuilder1.append("playCount=").append(this.jdField_p_of_type_Int).append(", ");
      localStringBuilder1.append("likeCount=").append(this.jdField_q_of_type_Int).append(", ");
      localStringBuilder1.append("isDianZan=").append(this.jdField_p_of_type_Boolean).append(", ");
      localStringBuilder1.append("dianZanCount=").append(this.r).append(", ");
      localStringBuilder1.append("thirdAction=").append(this.jdField_m_of_type_JavaLangString).append(", ");
      localStringBuilder1.append("thirdIconUrl=").append(this.n).append(", ");
      localStringBuilder1.append("XGFileSize=").append(this.jdField_b_of_type_Long).append(", ");
      localStringBuilder1.append("articleSubsText").append(this.w).append(", ");
      localStringBuilder1.append("articleSubsColor=").append(this.x).append(", ");
      localStringBuilder1.append("isUgc=").append(this.jdField_b_of_type_Boolean).append(", ");
      localStringBuilder1.append("isFollowed=").append(this.jdField_o_of_type_Boolean).append(", ");
      break label114;
    }
    label888:
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
    localStringBuilder1.append("videoReportInfo=").append(this.y).append(", ");
    localStringBuilder1.append("avatarJumpUrl=").append(this.z).append(", ");
    localStringBuilder1.append("dynamicInsertTriggerSec=").append(this.jdField_m_of_type_Int).append(", ");
    localStringBuilder1.append("videoLogoUrl=").append(this.s).append(", ");
    localStringBuilder1.append("vIconUrl=").append(this.t).append(", ");
    localStringBuilder1.append("likeActionDownloadBar=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar).append(", ");
    localStringBuilder1.append("videoColumnInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).append(", ");
    localStringBuilder1.append("isColumnVideo()=").append(e()).append(", ");
    localStringBuilder1.append("softAdDownloadBarInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).append(", ");
    localStringBuilder1.append("redpacketId=").append(this.u).append(", ");
    localStringBuilder1.append("]");
    localStringBuilder1.append("isUseGif=").append(this.jdField_g_of_type_Boolean).append(", ").append("gifUrl=").append(this.jdField_q_of_type_JavaLangString).append(", ").append("isShowCover=").append(this.jdField_h_of_type_Boolean).append("]");
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
  
  public int c(Activity paramActivity)
  {
    int[] arrayOfInt = rdm.b(paramActivity);
    if (paramActivity == null) {}
    int i2;
    do
    {
      do
      {
        do
        {
          return 0;
          if (!this.jdField_c_of_type_Boolean) {
            break;
          }
        } while ((!b(paramActivity)) || (arrayOfInt[0] == 0) || (arrayOfInt[1] / arrayOfInt[0] <= 1.777778F));
        return 2;
      } while ((!a(paramActivity)) || (b() <= 0) || (c() <= 0));
      int i1 = (int)(b() / c() * arrayOfInt[1]);
      i2 = (int)(c() / b() * arrayOfInt[0]);
      if ((i1 > arrayOfInt[0]) && (i1 / arrayOfInt[0] <= 1.22D)) {
        return 2;
      }
    } while ((i2 <= arrayOfInt[1]) || (i2 / arrayOfInt[1] > 1.22D));
    return 2;
  }
  
  public String c()
  {
    return this.jdField_q_of_type_JavaLangString;
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
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 1)) {
      return 3;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2)) {
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
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_e_of_type_Int == 0) && (bkbq.e());
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
        break label711;
      }
      i1 = 1;
      label196:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeString(this.n);
      paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_p_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label716;
      }
      i1 = 1;
      label292:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, paramInt);
      paramParcel.writeStringList(this.jdField_c_of_type_JavaUtilArrayList);
      if (!this.jdField_d_of_type_Boolean) {
        break label721;
      }
      i1 = 1;
      label332:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_e_of_type_Boolean) {
        break label726;
      }
      i1 = 1;
      label347:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_f_of_type_Boolean) {
        break label731;
      }
      i1 = 1;
      label362:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt);
      if (!this.jdField_q_of_type_Boolean) {
        break label736;
      }
      i1 = 1;
      label429:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      paramParcel.writeInt(this.jdField_o_of_type_Int);
      paramParcel.writeInt(this.jdField_p_of_type_Int);
      paramParcel.writeInt(this.jdField_q_of_type_Int);
      if (!this.jdField_o_of_type_Boolean) {
        break label741;
      }
      i1 = 1;
      label484:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_p_of_type_Boolean) {
        break label746;
      }
      i1 = 1;
      label499:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.r);
      paramParcel.writeString(this.w);
      paramParcel.writeString(this.x);
      paramParcel.writeString(this.y);
      paramParcel.writeString(this.z);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      if (!this.jdField_g_of_type_Boolean) {
        break label751;
      }
      i1 = 1;
      label562:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeString(this.jdField_q_of_type_JavaLangString);
      if (!this.jdField_h_of_type_Boolean) {
        break label756;
      }
      i1 = 0;
      label585:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeTypedList(this.jdField_d_of_type_JavaUtilArrayList);
      paramParcel.writeInt(this.jdField_l_of_type_Int);
      paramParcel.writeInt(this.jdField_m_of_type_Int);
      paramParcel.writeString(this.s);
      paramParcel.writeString(this.t);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo, paramInt);
      if (!this.jdField_k_of_type_Boolean) {
        break label761;
      }
      paramInt = 1;
      label667:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.u);
      if (!this.jdField_l_of_type_Boolean) {
        break label766;
      }
    }
    label711:
    label716:
    label721:
    label726:
    label731:
    label736:
    label741:
    label746:
    label751:
    label756:
    label761:
    label766:
    for (paramInt = i2;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.v);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo
 * JD-Core Version:    0.7.0.1
 */