package com.tencent.biz.pubaccount;

import amsw;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout.StressState;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import oek;
import oey;
import oez;
import org.json.JSONArray;
import org.json.JSONObject;
import pvp;
import rwv;
import tfb;
import trv;

public class VideoInfo
  implements Parcelable, tfb
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new oek();
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
  public VideoFeedsStressFollowLayout.StressState a;
  public MessageForShortVideo a;
  public String a;
  public ArrayList<DislikeInfo> a;
  public HashSet<String> a;
  public oey a;
  public oez a;
  public pvp a;
  public trv a;
  public boolean a;
  private Object[] a;
  public int b;
  public long b;
  public String b;
  public ArrayList<String> b;
  public oey b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public ArrayList<VideoInfo> c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList<VideoInfo.RichTitleInfo> d;
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
  public int t;
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
    this.jdField_a_of_type_Trv = new trv();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_s_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState = VideoFeedsStressFollowLayout.StressState.Shrink;
  }
  
  public VideoInfo(Parcel paramParcel)
  {
    this.jdField_i_of_type_Int = 1;
    this.jdField_a_of_type_Trv = new trv();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_s_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState = VideoFeedsStressFollowLayout.StressState.Shrink;
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
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(DislikeInfo.CREATOR);
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label898;
      }
      bool1 = true;
      label260:
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_c_of_type_Long = paramParcel.readLong();
      this.jdField_l_of_type_JavaLangString = paramParcel.readString();
      this.jdField_f_of_type_Int = paramParcel.readInt();
      this.jdField_o_of_type_JavaLangString = paramParcel.readString();
      this.p = paramParcel.readString();
      this.jdField_q_of_type_JavaLangString = paramParcel.readString();
      this.jdField_r_of_type_JavaLangString = paramParcel.readString();
      this.jdField_d_of_type_Long = paramParcel.readLong();
      this.jdField_h_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramParcel.readParcelable(ArticleInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label903;
      }
      bool1 = true;
      label362:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_i_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
      this.jdField_b_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
      if (paramParcel.readByte() == 0) {
        break label908;
      }
      bool1 = true;
      label408:
      this.jdField_d_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label913;
      }
      bool1 = true;
      label422:
      this.jdField_e_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label918;
      }
      bool1 = true;
      label436:
      this.jdField_f_of_type_Boolean = bool1;
      this.jdField_j_of_type_Int = paramParcel.readInt();
      this.jdField_k_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)paramParcel.readParcelable(VideoInfo.TopBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = ((VideoInfo.InterruptedWeishiAd)paramParcel.readParcelable(VideoInfo.InterruptedWeishiAd.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)paramParcel.readParcelable(VideoInfo.DownloadBarInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = ((VideoInfo.ECommerceEntranceInfo)paramParcel.readParcelable(VideoInfo.ECommerceEntranceInfo.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label923;
      }
      bool1 = true;
      label530:
      this.jdField_s_of_type_Boolean = bool1;
      this.jdField_l_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_Long = paramParcel.readLong();
      this.jdField_q_of_type_Int = paramParcel.readInt();
      this.jdField_r_of_type_Int = paramParcel.readInt();
      this.jdField_s_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label928;
      }
      bool1 = true;
      label584:
      this.jdField_q_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label933;
      }
      bool1 = true;
      label598:
      this.jdField_r_of_type_Boolean = bool1;
      this.t = paramParcel.readInt();
      this.w = paramParcel.readString();
      this.x = paramParcel.readString();
      this.y = paramParcel.readString();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState = VideoFeedsStressFollowLayout.StressState.valueOf(paramParcel.readString());
      this.z = paramParcel.readString();
      this.jdField_e_of_type_Long = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label938;
      }
      bool1 = true;
      label671:
      this.jdField_g_of_type_Boolean = bool1;
      this.jdField_s_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readByte() != 0) {
        break label943;
      }
      bool1 = true;
      label693:
      this.jdField_h_of_type_Boolean = bool1;
      this.jdField_c_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(CREATOR);
      this.jdField_m_of_type_Int = paramParcel.readInt();
      this.jdField_n_of_type_Int = paramParcel.readInt();
      this.u = paramParcel.readString();
      this.jdField_o_of_type_Int = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label948;
      }
      bool1 = true;
      label751:
      this.jdField_k_of_type_Boolean = bool1;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = ((VideoInfo.LikeActionDownloadBar)paramParcel.readParcelable(VideoInfo.LikeActionDownloadBar.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = ((VideoColumnInfo)paramParcel.readParcelable(VideoColumnInfo.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = ((VideoInfo.SoftAdDownloadBarInfo)paramParcel.readParcelable(VideoInfo.SoftAdDownloadBarInfo.class.getClassLoader()));
      this.jdField_m_of_type_JavaLangString = paramParcel.readString();
      this.jdField_n_of_type_JavaLangString = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label953;
      }
      bool1 = true;
      label832:
      this.jdField_l_of_type_Boolean = bool1;
      this.v = paramParcel.readString();
      this.jdField_g_of_type_Int = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label958;
      }
      bool1 = true;
      label862:
      this.jdField_m_of_type_Boolean = bool1;
      this.jdField_d_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(VideoInfo.RichTitleInfo.CREATOR);
      if (paramParcel.readByte() == 0) {
        break label963;
      }
    }
    label898:
    label903:
    label908:
    label913:
    label918:
    label923:
    label928:
    label933:
    label938:
    label943:
    label948:
    label953:
    label958:
    label963:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_n_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label260;
      bool1 = false;
      break label362;
      bool1 = false;
      break label408;
      bool1 = false;
      break label422;
      bool1 = false;
      break label436;
      bool1 = false;
      break label530;
      bool1 = false;
      break label584;
      bool1 = false;
      break label598;
      bool1 = false;
      break label671;
      bool1 = false;
      break label693;
      bool1 = false;
      break label751;
      bool1 = false;
      break label832;
      bool1 = false;
      break label862;
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = rwv.a(paramActivity, b(), c());
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
    return rwv.a(paramActivity, this, paramInt);
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
      return ShortVideoUtils.getThumbUrl(ShortVideoUtils.getShortVideoThumbPicPath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, "jpg"));
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
    this.jdField_b_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    this.jdField_i_of_type_JavaLangString = paramVideoInfo.jdField_i_of_type_JavaLangString;
    this.jdField_e_of_type_Int = paramVideoInfo.jdField_e_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList = paramVideoInfo.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_j_of_type_JavaLangString = paramVideoInfo.jdField_j_of_type_JavaLangString;
    this.jdField_k_of_type_JavaLangString = paramVideoInfo.jdField_k_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramVideoInfo.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramVideoInfo.jdField_b_of_type_Boolean;
    this.jdField_c_of_type_Long = paramVideoInfo.jdField_c_of_type_Long;
    this.jdField_l_of_type_JavaLangString = paramVideoInfo.jdField_l_of_type_JavaLangString;
    this.jdField_f_of_type_Int = paramVideoInfo.jdField_f_of_type_Int;
    this.jdField_o_of_type_JavaLangString = paramVideoInfo.jdField_o_of_type_JavaLangString;
    this.p = paramVideoInfo.p;
    this.jdField_q_of_type_JavaLangString = paramVideoInfo.jdField_q_of_type_JavaLangString;
    this.jdField_r_of_type_JavaLangString = paramVideoInfo.jdField_r_of_type_JavaLangString;
    this.jdField_d_of_type_Long = paramVideoInfo.jdField_d_of_type_Long;
    this.jdField_h_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_c_of_type_Boolean = paramVideoInfo.jdField_c_of_type_Boolean;
    this.jdField_i_of_type_Int = paramVideoInfo.jdField_i_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    this.jdField_b_of_type_JavaUtilArrayList = paramVideoInfo.jdField_b_of_type_JavaUtilArrayList;
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
    this.jdField_q_of_type_Int = paramVideoInfo.jdField_q_of_type_Int;
    this.jdField_r_of_type_Int = paramVideoInfo.jdField_r_of_type_Int;
    this.jdField_s_of_type_Int = paramVideoInfo.jdField_s_of_type_Int;
    this.jdField_q_of_type_Boolean = paramVideoInfo.jdField_q_of_type_Boolean;
    this.jdField_r_of_type_Boolean = paramVideoInfo.jdField_r_of_type_Boolean;
    this.t = paramVideoInfo.t;
    this.w = paramVideoInfo.w;
    this.x = paramVideoInfo.x;
    this.y = paramVideoInfo.y;
    this.z = paramVideoInfo.z;
    this.jdField_e_of_type_Long = paramVideoInfo.jdField_e_of_type_Long;
    this.jdField_g_of_type_Boolean = paramVideoInfo.jdField_g_of_type_Boolean;
    this.jdField_s_of_type_JavaLangString = paramVideoInfo.jdField_s_of_type_JavaLangString;
    this.jdField_h_of_type_Boolean = paramVideoInfo.jdField_h_of_type_Boolean;
    this.jdField_n_of_type_Int = paramVideoInfo.jdField_n_of_type_Int;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = this.jdField_c_of_type_Long;
    }
    this.u = paramVideoInfo.u;
    this.jdField_o_of_type_Int = paramVideoInfo.jdField_o_of_type_Int;
    this.jdField_k_of_type_Boolean = paramVideoInfo.jdField_k_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo;
    this.jdField_m_of_type_JavaLangString = paramVideoInfo.jdField_m_of_type_JavaLangString;
    this.jdField_n_of_type_JavaLangString = paramVideoInfo.jdField_n_of_type_JavaLangString;
    this.jdField_l_of_type_Boolean = paramVideoInfo.jdField_l_of_type_Boolean;
    this.v = paramVideoInfo.v;
    this.jdField_g_of_type_Int = paramVideoInfo.jdField_g_of_type_Int;
    this.jdField_m_of_type_Boolean = paramVideoInfo.jdField_m_of_type_Boolean;
    this.jdField_d_of_type_JavaUtilArrayList = paramVideoInfo.jdField_d_of_type_JavaUtilArrayList;
    this.jdField_n_of_type_Boolean = paramVideoInfo.jdField_n_of_type_Boolean;
  }
  
  public void a(String paramString)
  {
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("rpt_biu_mutli_level");
      int i1 = 0;
      while (i1 < paramString.length())
      {
        VideoInfo.RichTitleInfo localRichTitleInfo = new VideoInfo.RichTitleInfo((JSONObject)paramString.get(i1));
        this.jdField_d_of_type_JavaUtilArrayList.add(localRichTitleInfo);
        i1 += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
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
      if (this.jdField_j_of_type_JavaLangString.equals(paramQQAppInterface.getCurrentUin())) {
        return true;
      }
      if (((amsw)paramQQAppInterface.getManager(51)).b(this.jdField_j_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public int[] a(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    int i1 = -1;
    paramInt = a(paramActivity, paramInt);
    int i2 = ViewUtils.dip2px(50.0F);
    switch (paramInt)
    {
    case 1: 
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      return new int[] { paramInt, i1 };
      int i3 = AIOUtils.dp2px(10.0F, paramActivity.getResources());
      i1 = i3;
      paramInt = i2;
      if (LiuHaiUtils.b())
      {
        paramInt = i2 + LiuHaiUtils.b(paramActivity);
        i1 = i3;
        continue;
        if (!paramBoolean)
        {
          int i4 = b(paramActivity);
          int i5 = rwv.b(paramActivity)[1];
          if (i5 < i4) {
            break;
          }
          i3 = AIOUtils.dp2px(10.0F, paramActivity.getResources());
          if (b(paramActivity))
          {
            i1 = i3;
            paramInt = i2;
            if ((i5 - i4) / 2 <= i2) {
              continue;
            }
            paramInt = (i5 - i4) / 2 + AIOUtils.dp2px(32.0F, paramActivity.getResources());
            i1 = i3;
            continue;
          }
          paramInt = (i5 - i4) / 2 + AIOUtils.dp2px(10.0F, paramActivity.getResources());
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
    paramInt = rwv.b(paramActivity)[1];
    i1 = rwv.b(paramActivity)[0];
    float f1 = b() / c();
    i1 = (int)(i1 * f1);
    if (i1 <= paramInt) {}
    for (i1 = (paramInt - i1) / 2 + AIOUtils.dp2px(16.0F, paramActivity.getResources());; i1 = AIOUtils.dp2px(16.0F, paramActivity.getResources()))
    {
      paramInt = AIOUtils.dp2px(16.0F, paramActivity.getResources());
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
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("VideoInfo[");
    localStringBuilder.append("busiType=").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder.append("width=").append(b()).append(", ");
    localStringBuilder.append("height=").append(c()).append(", ");
    Object localObject2;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject2 = localStringBuilder.append("msg=");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
      {
        localObject1 = "null ERROR";
        ((StringBuilder)localObject2).append((String)localObject1);
        label114:
        if (this.jdField_a_of_type_Int == 6)
        {
          localStringBuilder.append("video_url=").append(this.jdField_r_of_type_JavaLangString).append(", ");
          localStringBuilder.append("feedId=").append(this.jdField_d_of_type_Long).append(", ");
          localStringBuilder.append("feedType=").append(this.jdField_h_of_type_Int).append(", ");
          localObject2 = localStringBuilder.append("articleInfo.mArticleID=");
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
            break label916;
          }
        }
      }
    }
    label916:
    for (Object localObject1 = "articleInfo null";; localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID))
    {
      ((StringBuilder)localObject2).append(localObject1).append(", ");
      localStringBuilder.append("isAD=").append(this.jdField_c_of_type_Boolean).append(", ");
      localStringBuilder.append("adType=").append(this.jdField_i_of_type_Int).append(", ");
      localStringBuilder.append("recommendBarrageList=[");
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        break label930;
      }
      localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        localStringBuilder.append((String)((Iterator)localObject1).next()).append(", ");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.toLogString();
      break;
      localStringBuilder.append("vid=").append(this.jdField_a_of_type_JavaLangString).append(", ");
      localStringBuilder.append("articleID=").append(this.jdField_g_of_type_JavaLangString).append(", ");
      localStringBuilder.append("title=").append(this.jdField_c_of_type_JavaLangString).append(", ");
      localStringBuilder.append("duration=").append(this.jdField_d_of_type_Int).append(", ");
      localStringBuilder.append("coverUrl=").append(this.jdField_b_of_type_JavaLangString).append(", ");
      localStringBuilder.append("summary=").append(this.jdField_d_of_type_JavaLangString).append(", ");
      localStringBuilder.append("createTime=").append(this.jdField_e_of_type_JavaLangString).append(", ");
      localStringBuilder.append("createTimeStamp=").append(this.jdField_a_of_type_Long).append(", ");
      localStringBuilder.append("webUrl=").append(this.jdField_f_of_type_JavaLangString).append(", ");
      localStringBuilder.append("recommendReason=").append(this.jdField_h_of_type_JavaLangString).append(", ");
      localStringBuilder.append("accountUin=").append(this.jdField_j_of_type_JavaLangString).append(", ");
      localStringBuilder.append("accountName=").append(this.jdField_k_of_type_JavaLangString).append(", ");
      localStringBuilder.append("isVerified=").append(this.jdField_a_of_type_Boolean).append(", ");
      localStringBuilder.append("biuCount=").append(this.jdField_f_of_type_Int).append(", ");
      localStringBuilder.append("commentCount=").append(this.jdField_e_of_type_Int).append(", ");
      localStringBuilder.append("playCount=").append(this.jdField_r_of_type_Int).append(", ");
      localStringBuilder.append("likeCount=").append(this.jdField_s_of_type_Int).append(", ");
      localStringBuilder.append("isDianZan=").append(this.jdField_r_of_type_Boolean).append(", ");
      localStringBuilder.append("dianZanCount=").append(this.t).append(", ");
      localStringBuilder.append("thirdAction=").append(this.jdField_o_of_type_JavaLangString).append(", ");
      localStringBuilder.append("thirdIconUrl=").append(this.p).append(", ");
      localStringBuilder.append("xgFileSize=").append(this.jdField_b_of_type_Long).append(", ");
      localStringBuilder.append("articleSubsText").append(this.w).append(", ");
      localStringBuilder.append("articleSubsColor=").append(this.x).append(", ");
      localStringBuilder.append("isUgc=").append(this.jdField_b_of_type_Boolean).append(", ");
      localStringBuilder.append("isFollowed=").append(this.jdField_q_of_type_Boolean).append(", ");
      localStringBuilder.append("aioShareUrl=").append(this.jdField_m_of_type_JavaLangString).append(", ");
      localStringBuilder.append("qzoneShareUrl=").append(this.jdField_n_of_type_JavaLangString).append(", ");
      break label114;
    }
    label930:
    localStringBuilder.append("]").append(", ");
    localStringBuilder.append("topBarInfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo != null) {
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo.toString());
    }
    localStringBuilder.append("]").append(", ");
    localStringBuilder.append("interruptedWeishiAd=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) {
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.toString());
    }
    localStringBuilder.append("]").append(", ");
    localStringBuilder.append("commerceEntranceInfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo != null) {
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.toString());
    }
    localStringBuilder.append("]").append(", ");
    localStringBuilder.append("downloadBarinfo=[");
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo != null) {
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo.toString());
    }
    localStringBuilder.append("]").append(", ");
    if (this.jdField_d_of_type_JavaUtilArrayList != null)
    {
      localStringBuilder.append("richTitleInfo=[");
      localObject1 = this.jdField_d_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (VideoInfo.RichTitleInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          localStringBuilder.append(((VideoInfo.RichTitleInfo)localObject2).jdField_c_of_type_JavaLangString + " " + ((VideoInfo.RichTitleInfo)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
      localStringBuilder.append("]");
    }
    localStringBuilder.append("videoReportInfo=").append(this.y).append(", ");
    localStringBuilder.append("avatarJumpUrl=").append(this.z).append(", ");
    localStringBuilder.append("dynamicInsertTriggerSec=").append(this.jdField_n_of_type_Int).append(", ");
    localStringBuilder.append("videoLogoUrl=").append(this.u).append(", ");
    localStringBuilder.append("followCount=").append(this.jdField_o_of_type_Int).append(", ");
    localStringBuilder.append("isShowStressFollow=").append(this.jdField_k_of_type_Boolean).append(", ");
    localStringBuilder.append("likeActionDownloadBar=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar).append(", ");
    localStringBuilder.append("videoColumnInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).append(", ");
    localStringBuilder.append("columnId=").append(this.jdField_g_of_type_Int).append(", ");
    localStringBuilder.append("softAdDownloadBarInfo=").append(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).append(", ");
    localStringBuilder.append("wechatShareUrl=").append(this.v).append(", ");
    localStringBuilder.append("]");
    localStringBuilder.append("isUseGif=").append(this.jdField_g_of_type_Boolean).append(", ").append("gifUrl=").append(this.jdField_s_of_type_JavaLangString).append(", ").append("isShowCover=").append(this.jdField_h_of_type_Boolean).append("]");
    localStringBuilder.append("isForbidReprint=").append(this.jdField_l_of_type_Boolean);
    return localStringBuilder.toString();
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public String toString()
  {
    return "VideoInfo{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", coverUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", title='" + this.jdField_c_of_type_JavaLangString + '\'' + ", articleID='" + this.jdField_g_of_type_JavaLangString + '\'' + ", videoUrl='" + this.jdField_r_of_type_JavaLangString + '\'' + ", recommendSeq=" + this.jdField_e_of_type_Long + '}';
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
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 1;
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_b_of_type_Boolean) {
        break label767;
      }
      i1 = 1;
      label188:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeLong(this.jdField_c_of_type_Long);
      paramParcel.writeString(this.jdField_l_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_f_of_type_Int);
      paramParcel.writeString(this.jdField_o_of_type_JavaLangString);
      paramParcel.writeString(this.p);
      paramParcel.writeString(this.jdField_q_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_r_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeInt(this.jdField_h_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label772;
      }
      i1 = 1;
      label284:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, paramInt);
      paramParcel.writeStringList(this.jdField_b_of_type_JavaUtilArrayList);
      if (!this.jdField_d_of_type_Boolean) {
        break label777;
      }
      i1 = 1;
      label324:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_e_of_type_Boolean) {
        break label782;
      }
      i1 = 1;
      label339:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_f_of_type_Boolean) {
        break label787;
      }
      i1 = 1;
      label354:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo, paramInt);
      if (!this.jdField_s_of_type_Boolean) {
        break label792;
      }
      i1 = 1;
      label421:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.jdField_l_of_type_Int);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      paramParcel.writeInt(this.jdField_q_of_type_Int);
      paramParcel.writeInt(this.jdField_r_of_type_Int);
      paramParcel.writeInt(this.jdField_s_of_type_Int);
      if (!this.jdField_q_of_type_Boolean) {
        break label797;
      }
      i1 = 1;
      label476:
      paramParcel.writeByte((byte)i1);
      if (!this.jdField_r_of_type_Boolean) {
        break label802;
      }
      i1 = 1;
      label491:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeInt(this.t);
      paramParcel.writeString(this.w);
      paramParcel.writeString(this.x);
      paramParcel.writeString(this.y);
      paramParcel.writeString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout$StressState.name());
      paramParcel.writeString(this.z);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      if (!this.jdField_g_of_type_Boolean) {
        break label807;
      }
      i1 = 1;
      label565:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeString(this.jdField_s_of_type_JavaLangString);
      if (!this.jdField_h_of_type_Boolean) {
        break label812;
      }
      i1 = 0;
      label588:
      paramParcel.writeByte((byte)i1);
      paramParcel.writeTypedList(this.jdField_c_of_type_JavaUtilArrayList);
      paramParcel.writeInt(this.jdField_m_of_type_Int);
      paramParcel.writeInt(this.jdField_n_of_type_Int);
      paramParcel.writeString(this.u);
      paramParcel.writeInt(this.jdField_o_of_type_Int);
      if (!this.jdField_k_of_type_Boolean) {
        break label817;
      }
      i1 = 1;
      label643:
      paramParcel.writeInt(i1);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo, paramInt);
      paramParcel.writeString(this.jdField_m_of_type_JavaLangString);
      paramParcel.writeString(this.jdField_n_of_type_JavaLangString);
      if (!this.jdField_l_of_type_Boolean) {
        break label822;
      }
      paramInt = 1;
      label700:
      paramParcel.writeInt((byte)paramInt);
      paramParcel.writeString(this.v);
      paramParcel.writeInt(this.jdField_g_of_type_Int);
      if (!this.jdField_m_of_type_Boolean) {
        break label827;
      }
      paramInt = 1;
      label731:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeTypedList(this.jdField_d_of_type_JavaUtilArrayList);
      if (!this.jdField_n_of_type_Boolean) {
        break label832;
      }
    }
    label772:
    label777:
    label782:
    label787:
    label792:
    label797:
    label802:
    label807:
    label812:
    label817:
    label822:
    label827:
    label832:
    for (paramInt = i2;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      i1 = 0;
      break;
      label767:
      i1 = 0;
      break label188;
      i1 = 0;
      break label284;
      i1 = 0;
      break label324;
      i1 = 0;
      break label339;
      i1 = 0;
      break label354;
      i1 = 0;
      break label421;
      i1 = 0;
      break label476;
      i1 = 0;
      break label491;
      i1 = 0;
      break label565;
      i1 = 1;
      break label588;
      i1 = 0;
      break label643;
      paramInt = 0;
      break label700;
      paramInt = 0;
      break label731;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoInfo
 * JD-Core Version:    0.7.0.1
 */