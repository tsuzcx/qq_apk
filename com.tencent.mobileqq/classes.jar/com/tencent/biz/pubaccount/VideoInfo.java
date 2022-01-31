package com.tencent.biz.pubaccount;

import aciy;
import ajjj;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bgmq;
import bjeh;
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
import ned;
import ner;
import qcn;
import rik;

public class VideoInfo
  implements Parcelable, rik
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new ned();
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String L;
  public String M;
  public String N;
  public String O;
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
  public ner a;
  public boolean a;
  private Object[] a;
  public int b;
  public long b;
  public String b;
  public ArrayList<DislikeInfo> b;
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
  private boolean m;
  public int n;
  public String n;
  public int o;
  public String o;
  public int p;
  public String p;
  public int q;
  public String q;
  public int r;
  public String r;
  public int s;
  public String s;
  public int t;
  public String t;
  public int u;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public VideoInfo()
  {
    this.jdField_i_of_type_Int = 10;
    this.jdField_j_of_type_Int = 10;
    this.jdField_l_of_type_Int = 1;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_m_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
  }
  
  public VideoInfo(Parcel paramParcel)
  {
    this.jdField_i_of_type_Int = 10;
    this.jdField_j_of_type_Int = 10;
    this.jdField_l_of_type_Int = 1;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_m_of_type_Boolean = true;
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
        break label792;
      }
      bool1 = true;
      label265:
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_l_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.D = paramParcel.readString();
      this.E = paramParcel.readString();
      this.F = paramParcel.readString();
      this.G = paramParcel.readString();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.jdField_k_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramParcel.readParcelable(ArticleInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label797;
      }
      bool1 = true;
      label367:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_l_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
      this.jdField_c_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
      if (paramParcel.readByte() == 0) {
        break label802;
      }
      bool1 = true;
      label413:
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label807;
      }
      bool1 = true;
      label427:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label812;
      }
      bool1 = true;
      label441:
      this.jdField_f_of_type_Boolean = bool1;
      this.jdField_m_of_type_Int = paramParcel.readInt();
      this.n = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)paramParcel.readParcelable(VideoInfo.TopBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = ((VideoInfo.InterruptedWeishiAd)paramParcel.readParcelable(VideoInfo.InterruptedWeishiAd.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)paramParcel.readParcelable(VideoInfo.DownloadBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = ((VideoInfo.ECommerceEntranceInfo)paramParcel.readParcelable(VideoInfo.ECommerceEntranceInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label817;
      }
      bool1 = true;
      label535:
      this.jdField_m_of_type_Boolean = bool1;
      this.o = paramParcel.readInt();
      this.jdField_f_of_type_Long = paramParcel.readLong();
      this.r = paramParcel.readInt();
      this.s = paramParcel.readInt();
      this.t = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label822;
      }
      bool1 = true;
      label589:
      this.jdField_k_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label827;
      }
      bool1 = true;
      label603:
      this.jdField_l_of_type_Boolean = bool1;
      this.u = paramParcel.readInt();
      this.L = paramParcel.readString();
      this.M = paramParcel.readString();
      this.N = paramParcel.readString();
      this.O = paramParcel.readString();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label832;
      }
      bool1 = true;
      label665:
      this.jdField_g_of_type_Boolean = bool1;
      this.H = paramParcel.readString();
      if (paramParcel.readByte() != 0) {
        break label837;
      }
    }
    label792:
    label797:
    label802:
    label807:
    label812:
    label817:
    label822:
    label827:
    label832:
    label837:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_h_of_type_Boolean = bool1;
      this.jdField_d_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(CREATOR);
      this.p = paramParcel.readInt();
      this.q = paramParcel.readInt();
      this.J = paramParcel.readString();
      this.K = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = ((VideoInfo.LikeActionDownloadBar)paramParcel.readParcelable(VideoInfo.LikeActionDownloadBar.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = ((VideoColumnInfo)paramParcel.readParcelable(VideoColumnInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = ((VideoInfo.SoftAdDownloadBarInfo)paramParcel.readParcelable(VideoInfo.SoftAdDownloadBarInfo.class.getClassLoader()));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label265;
      bool1 = false;
      break label367;
      bool1 = false;
      break label413;
      bool1 = false;
      break label427;
      bool1 = false;
      break label441;
      bool1 = false;
      break label535;
      bool1 = false;
      break label589;
      bool1 = false;
      break label603;
      bool1 = false;
      break label665;
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = qcn.a(paramActivity, b(), c());
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
    this.D = paramVideoInfo.D;
    this.E = paramVideoInfo.E;
    this.F = paramVideoInfo.F;
    this.G = paramVideoInfo.G;
    this.jdField_d_of_type_Long = paramVideoInfo.jdField_d_of_type_Long;
    this.jdField_k_of_type_Int = paramVideoInfo.jdField_k_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_c_of_type_Boolean = paramVideoInfo.jdField_c_of_type_Boolean;
    this.jdField_l_of_type_Int = paramVideoInfo.jdField_l_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    this.jdField_c_of_type_JavaUtilArrayList = paramVideoInfo.jdField_c_of_type_JavaUtilArrayList;
    this.jdField_d_of_type_Boolean = paramVideoInfo.jdField_d_of_type_Boolean;
    this.jdField_e_of_type_Boolean = paramVideoInfo.jdField_e_of_type_Boolean;
    this.jdField_f_of_type_Boolean = paramVideoInfo.jdField_f_of_type_Boolean;
    this.jdField_m_of_type_Int = paramVideoInfo.jdField_m_of_type_Int;
    this.n = paramVideoInfo.n;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo;
    this.jdField_m_of_type_Boolean = paramVideoInfo.jdField_m_of_type_Boolean;
    this.o = paramVideoInfo.o;
    this.jdField_f_of_type_Long = paramVideoInfo.jdField_f_of_type_Long;
    this.r = paramVideoInfo.r;
    this.s = paramVideoInfo.s;
    this.t = paramVideoInfo.t;
    this.jdField_k_of_type_Boolean = paramVideoInfo.jdField_k_of_type_Boolean;
    this.jdField_l_of_type_Boolean = paramVideoInfo.jdField_l_of_type_Boolean;
    this.u = paramVideoInfo.u;
    this.L = paramVideoInfo.L;
    this.M = paramVideoInfo.M;
    this.N = paramVideoInfo.N;
    this.O = paramVideoInfo.O;
    this.jdField_e_of_type_Long = paramVideoInfo.jdField_e_of_type_Long;
    this.jdField_g_of_type_Boolean = paramVideoInfo.jdField_g_of_type_Boolean;
    this.H = paramVideoInfo.H;
    this.jdField_h_of_type_Boolean = paramVideoInfo.jdField_h_of_type_Boolean;
    this.q = paramVideoInfo.q;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = this.jdField_c_of_type_Long;
    }
    this.J = paramVideoInfo.J;
    this.K = paramVideoInfo.K;
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
      if (((ajjj)paramQQAppInterface.getManager(51)).b(this.jdField_j_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public int[] a(Activity paramActivity, boolean paramBoolean)
  {
    int i2 = -1;
    switch (c(paramActivity))
    {
    case 1: 
    default: 
      i1 = -1;
    }
    for (;;)
    {
      return new int[] { i1, i2 };
      int i4 = aciy.a(32.0F, paramActivity.getResources());
      int i3 = aciy.a(10.0F, paramActivity.getResources());
      i2 = i3;
      i1 = i4;
      if (bjeh.b())
      {
        i1 = i4 + bjeh.b(paramActivity);
        i2 = i3;
        continue;
        if (!paramBoolean)
        {
          i1 = b(paramActivity);
          i3 = qcn.b(paramActivity)[1];
          if (i3 < i1) {
            break;
          }
          i2 = aciy.a(10.0F, paramActivity.getResources());
          if (b(paramActivity))
          {
            i1 = (i3 - i1) / 2 + aciy.a(32.0F, paramActivity.getResources());
            continue;
          }
          i1 = (i3 - i1) / 2 + aciy.a(10.0F, paramActivity.getResources());
          continue;
        }
        if (c() != 0) {
          break label212;
        }
        i1 = -1;
      }
    }
    label212:
    int i1 = qcn.b(paramActivity)[1];
    i2 = qcn.b(paramActivity)[0];
    float f1 = b() / c();
    i2 = (int)(i2 * f1);
    if (i2 <= i1) {}
    for (i2 = (i1 - i2) / 2 + aciy.a(16.0F, paramActivity.getResources());; i2 = aciy.a(16.0F, paramActivity.getResources()))
    {
      i1 = aciy.a(16.0F, paramActivity.getResources());
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
          localStringBuilder1.append("video_url=").append(this.G).append(", ");
          localStringBuilder1.append("feedId=").append(this.jdField_d_of_type_Long).append(", ");
          localStringBuilder1.append("feedType=").append(this.jdField_k_of_type_Int).append(", ");
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
      localStringBuilder1.append("adType=").append(this.jdField_l_of_type_Int).append(", ");
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
      localStringBuilder1.append("playCount=").append(this.s).append(", ");
      localStringBuilder1.append("likeCount=").append(this.t).append(", ");
      localStringBuilder1.append("isDianZan=").append(this.jdField_l_of_type_Boolean).append(", ");
      localStringBuilder1.append("dianZanCount=").append(this.u).append(", ");
      localStringBuilder1.append("thirdAction=").append(this.D).append(", ");
      localStringBuilder1.append("thirdIconUrl=").append(this.E).append(", ");
      localStringBuilder1.append("XGFileSize=").append(this.jdField_b_of_type_Long).append(", ");
      localStringBuilder1.append("articleSubsText").append(this.L).append(", ");
      localStringBuilder1.append("articleSubsColor=").append(this.M).append(", ");
      localStringBuilder1.append("isUgc=").append(this.jdField_b_of_type_Boolean).append(", ");
      localStringBuilder1.append("isFollowed=").append(this.jdField_k_of_type_Boolean).append(", ");
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
    localStringBuilder1.append("videoReportInfo=").append(this.N).append(", ");
    localStringBuilder1.append("avatarJumpUrl=").append(this.O).append(", ");
    localStringBuilder1.append("dynamicInsertTriggerSec=").append(this.q).append(", ");
    localStringBuilder1.append("videoLogoUrl=").append(this.J).append(", ");
    localStringBuilder1.append("vIconUrl=").append(this.K).append(", ");
    localStringBuilder1.append("likeActionDownloadBar=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar).append(", ");
    localStringBuilder1.append("videoColumnInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).append(", ");
    localStringBuilder1.append("isColumnVideo()=").append(e()).append(", ");
    localStringBuilder1.append("softAdDownloadBarInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).append(", ");
    localStringBuilder1.append("]");
    localStringBuilder1.append("isUseGif=").append(this.jdField_g_of_type_Boolean).append(", ").append("gifUrl=").append(this.H).append(", ").append("isShowCover=").append(this.jdField_h_of_type_Boolean).append("]");
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
    int[] arrayOfInt = qcn.b(paramActivity);
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
    return this.H;
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
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_l_of_type_Int == 1)) {
      return 3;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_l_of_type_Int == 2)) {
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
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (bgmq.e());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i2 = 0;
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
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 1;
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_b_of_type_Boolean) {
        break label665;
      }
      i1 = 1;
      label196:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.D);
      paramParcel.writeString(this.E);
      paramParcel.writeString(this.F);
      paramParcel.writeString(this.G);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label670;
      }
      i1 = 1;
      label292:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_l_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, paramInt);
      paramParcel.writeStringList(this.jdField_c_of_type_JavaUtilArrayList);
      if (!this.jdField_d_of_type_Boolean) {
        break label675;
      }
      i1 = 1;
      label332:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_e_of_type_Boolean) {
        break label680;
      }
      i1 = 1;
      label347:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_f_of_type_Boolean) {
        break label685;
      }
      i1 = 1;
      label362:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_m_of_type_Int);
      paramParcel.writeInt(this.n);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt);
      if (!this.jdField_m_of_type_Boolean) {
        break label690;
      }
      i1 = 1;
      label429:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.o);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      paramParcel.writeInt(this.r);
      paramParcel.writeInt(this.s);
      paramParcel.writeInt(this.t);
      if (!this.jdField_k_of_type_Boolean) {
        break label695;
      }
      i1 = 1;
      label484:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_l_of_type_Boolean) {
        break label700;
      }
      i1 = 1;
      label499:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.u);
      paramParcel.writeString(this.L);
      paramParcel.writeString(this.M);
      paramParcel.writeString(this.N);
      paramParcel.writeString(this.O);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      if (!this.jdField_g_of_type_Boolean) {
        break label705;
      }
      i1 = 1;
      label562:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeString(this.H);
      if (!this.jdField_h_of_type_Boolean) {
        break label710;
      }
    }
    label665:
    label670:
    label675:
    label680:
    label685:
    label690:
    label695:
    label700:
    label705:
    label710:
    for (int i1 = i2;; i1 = 1)
    {
      paramParcel.writeByte((byte)i1);
      paramParcel.writeTypedList(this.jdField_d_of_type_JavaUtilArrayList);
      paramParcel.writeInt(this.p);
      paramParcel.writeInt(this.q);
      paramParcel.writeString(this.J);
      paramParcel.writeString(this.K);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo, paramInt);
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo
 * JD-Core Version:    0.7.0.1
 */