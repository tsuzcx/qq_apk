package com.tencent.biz.pubaccount.readinjoy.biu;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInjoyFeedsUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.AccountProfileInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.NowLiveInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.NowLiveInfo.MixInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.NowLiveInfo.MixInfo.AnchorInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.ShareWebPageInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyUserProtocolWidget;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.pubaccount.readinjoy.view.text.JumpSpan;
import com.tencent.biz.pubaccount.readinjoy.view.text.PositionalSpanStruct;
import com.tencent.biz.pubaccount.readinjoy.view.text.SeparatorSpan;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDeliverBiuActivity
  extends ReadInJoyBaseDeliverActivity
{
  protected static String e;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyDeliverBiuActivity.9(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ReadInJoyDeliverBiuActivity.13(this);
  PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_b_of_type_ComTencentWidgetFixSizeImageView;
  private long jdField_c_of_type_Long = 0L;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_c_of_type_ComTencentWidgetFixSizeImageView;
  private long jdField_d_of_type_Long = 0L;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private String jdField_f_of_type_JavaLangString;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private String jdField_g_of_type_JavaLangString;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private String jdField_h_of_type_JavaLangString;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private String jdField_i_of_type_JavaLangString;
  private String j;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int = 1;
  private String jdField_m_of_type_JavaLangString = "1920*1080;1280*720;1812*1080;1208*720;1280*760;1184*720;1794*1080;1776*1080;1800*1080;2960*1440;2560*1440";
  private int n = -1;
  private int o;
  private int p;
  private int jdField_q_of_type_Int = 5000;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int = 1;
  private boolean jdField_r_of_type_Boolean = true;
  private int jdField_s_of_type_Int = 2;
  private boolean jdField_s_of_type_Boolean = false;
  private int t = 3;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  
  static
  {
    jdField_e_of_type_JavaLangString = " //";
  }
  
  public ReadInJoyDeliverBiuActivity()
  {
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == null)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getHeight();
  }
  
  private String a(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private String a(SocializeFeedsInfo.BiuCommentInfo paramBiuCommentInfo)
  {
    Object localObject2 = this.jdField_k_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = paramBiuCommentInfo.mUin;
      paramBiuCommentInfo = ReadInJoyUserInfoModule.a(((Long)localObject2).longValue());
      localObject1 = paramBiuCommentInfo;
      if (ReadInJoyUserInfoModule.a().equalsIgnoreCase(paramBiuCommentInfo))
      {
        paramBiuCommentInfo = ReadInJoyUserInfoModule.a(((Long)localObject2).longValue(), null);
        if (paramBiuCommentInfo == null) {
          break label84;
        }
      }
    }
    label84:
    for (localObject1 = paramBiuCommentInfo.nick;; localObject1 = ReadInJoyUserInfoModule.a())
    {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "getBiuUserName : " + (String)localObject1);
      return localObject1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (((TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) || (this.jdField_p_of_type_Int != 17)) && (this.jdField_p_of_type_Int != 24)) {
      return;
    }
    String str2 = paramIntent.getStringExtra("arg_title");
    String str1 = paramIntent.getStringExtra("arg_src");
    Object localObject = paramIntent.getStringExtra("arg_cover");
    paramIntent = str2;
    if (TextUtils.isEmpty(str2)) {
      paramIntent = this.jdField_f_of_type_JavaLangString;
    }
    this.jdField_f_of_type_JavaLangString = paramIntent;
    if (TextUtils.isEmpty(str1))
    {
      paramIntent = this.jdField_h_of_type_JavaLangString;
      this.jdField_h_of_type_JavaLangString = paramIntent;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label207;
      }
      paramIntent = this.jdField_i_of_type_JavaLangString;
      label105:
      this.jdField_i_of_type_JavaLangString = paramIntent;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = new ArticleInfo();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label212;
      }
      paramIntent = "";
      label157:
      ((TextView)localObject).setText(paramIntent);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
      if (this.jdField_h_of_type_JavaLangString != null) {
        break label220;
      }
    }
    label207:
    label212:
    label220:
    for (paramIntent = "";; paramIntent = this.jdField_h_of_type_JavaLangString)
    {
      ((ReadInJoyNickNameTextView)localObject).setText(paramIntent);
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        break label228;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      return;
      paramIntent = str1;
      break;
      paramIntent = (Intent)localObject;
      break label105;
      paramIntent = this.jdField_f_of_type_JavaLangString;
      break label157;
    }
    try
    {
      label228:
      paramIntent = new URL(this.jdField_i_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(paramIntent);
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  private static void a(Bundle paramBundle)
  {
    if (paramBundle != null) {}
  }
  
  private void a(ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList)
  {
    SocializeFeedsInfo.BiuInfo localBiuInfo = new SocializeFeedsInfo.BiuInfo();
    long l2 = 0L;
    Object localObject1;
    Object localObject2;
    int i1;
    long l1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
    {
      if ((this.jdField_l_of_type_Int == 23) || (this.jdField_p_of_type_Int == 24))
      {
        localObject1 = new SocializeFeedsInfo.ShareWebPageInfo();
        ((SocializeFeedsInfo.ShareWebPageInfo)localObject1).b = this.jdField_f_of_type_JavaLangString;
        ((SocializeFeedsInfo.ShareWebPageInfo)localObject1).jdField_d_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
        ((SocializeFeedsInfo.ShareWebPageInfo)localObject1).c = this.jdField_i_of_type_JavaLangString;
        ((SocializeFeedsInfo.ShareWebPageInfo)localObject1).jdField_a_of_type_JavaLangString = getIntent().getStringExtra("arg_source_url");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo = ((SocializeFeedsInfo.ShareWebPageInfo)localObject1);
      }
      if (this.jdField_p_of_type_Int == 24)
      {
        localObject1 = new SocializeFeedsInfo.NowLiveInfo();
        localObject2 = new SocializeFeedsInfo.NowLiveInfo.MixInfo();
        ((SocializeFeedsInfo.NowLiveInfo.MixInfo)localObject2).a(new SocializeFeedsInfo.NowLiveInfo.MixInfo.AnchorInfo(getIntent().getLongExtra("arg_now_anchor_uin", 0L)));
        ((SocializeFeedsInfo.NowLiveInfo.MixInfo)localObject2).a(new SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo(getIntent().getStringExtra("arg_now_live_vid")));
        ((SocializeFeedsInfo.NowLiveInfo)localObject1).a((SocializeFeedsInfo.NowLiveInfo.MixInfo)localObject2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo = ((SocializeFeedsInfo.NowLiveInfo)localObject1);
      }
      l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null)
      {
        localBiuInfo.jdField_a_of_type_JavaLangLong = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong;
        localBiuInfo.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b;
        i1 = paramArrayList.size() - 1;
        l1 = l2;
        if (i1 <= 0) {
          break label483;
        }
        localObject2 = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(i1);
        if ((((SocializeFeedsInfo.BiuCommentInfo)localObject2).mFeedId.longValue() == 0L) || (((SocializeFeedsInfo.BiuCommentInfo)localObject2).mOpType != 0)) {
          break label708;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
        } while (!((SocializeFeedsInfo.BiuCommentInfo)localObject1).mFeedId.equals(((SocializeFeedsInfo.BiuCommentInfo)localObject2).mFeedId));
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        localObject1 = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(i1);
      }
      for (;;)
      {
        localBiuInfo.jdField_a_of_type_JavaUtilList.add(localObject1);
        i1 -= 1;
        break;
        ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mBiuComment = ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mBiuComment;
      }
      i1 = paramArrayList.size() - 1;
      for (;;)
      {
        l1 = l2;
        if (i1 <= 0) {
          break;
        }
        localBiuInfo.jdField_a_of_type_JavaUtilList.add(paramArrayList.get(i1));
        i1 -= 1;
      }
      i1 = paramArrayList.size() - 1;
      for (;;)
      {
        l1 = l2;
        if (i1 <= 0) {
          break;
        }
        localBiuInfo.jdField_a_of_type_JavaUtilList.add(paramArrayList.get(i1));
        i1 -= 1;
      }
      label483:
      if (this.jdField_s_of_type_Boolean)
      {
        ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_d_of_type_Long, localBiuInfo, ((SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(0)).mBiuComment);
        return;
      }
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, localBiuInfo, l1, ((SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(0)).mBiuComment, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq, this.jdField_p_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_m_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_q_of_type_Boolean);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "mFeedId:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId + " masterUin" + l1 + ", mArticleID:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + " mRecommendSeq: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq + " biuSrc:" + this.jdField_p_of_type_Int + " innerUniqueID" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + " feedstype:" + this.jdField_m_of_type_Int);
      this.jdField_c_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      return;
      label708:
      localObject1 = null;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 5) || (paramInt == 4) || (paramInt == 6)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.longValue() != 30L) {
      return false;
    }
    return true;
  }
  
  private void b(@NotNull Intent paramIntent)
  {
    this.jdField_k_of_type_Int = paramIntent.getIntExtra("arg_type", -1);
    if (this.jdField_k_of_type_Int == -1)
    {
      this.jdField_k_of_type_Int = 1;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType != 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5)) && (!RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        break label76;
      }
      this.jdField_k_of_type_Int = 2;
    }
    label76:
    do
    {
      return;
      if ((b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
      {
        if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int))
        {
          this.jdField_k_of_type_Int = 2;
          return;
        }
        this.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    this.jdField_k_of_type_Int = 5;
  }
  
  private void b(ArrayList<Long> paramArrayList)
  {
    ThreadManager.post(new ReadInJoyDeliverBiuActivity.11(this, paramArrayList), 5, null, true);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (RIJItemViewType.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!RIJItemViewType.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_Long != 0L);
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 3) || (paramInt == 2)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return (RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)) || (paramArticleInfo.mFeedType == 25);
  }
  
  private boolean c()
  {
    return (this.jdField_k_of_type_Int == 5) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null);
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (ReadInjoyFeedsUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo != null);
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject3 = "";
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("kandian_mode", "" + RIJAppSetting.a());
        if (!this.jdField_q_of_type_Boolean) {
          continue;
        }
        localObject1 = "1";
        ((JSONObject)localObject2).put("fast_biu", localObject1);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        ((JSONObject)localObject2).put("feeds_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
        localObject1 = getIntent().getExtras();
        if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("arg_forward"))) {
          continue;
        }
        i1 = 1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        String str;
        localJSONException.printStackTrace();
        continue;
        int i1 = 0;
        continue;
        i1 = 0;
        continue;
        Object localObject2 = String.valueOf(this.jdField_b_of_type_Long);
        continue;
        if (!paramBoolean) {
          continue;
        }
        i1 = 1;
        continue;
        i1 = 2;
        continue;
        continue;
        continue;
        if (i1 == 0) {
          continue;
        }
        i1 = 1;
        continue;
      }
      ((JSONObject)localObject2).put("outside", i1);
      localObject1 = ((JSONObject)localObject2).toString();
      localObject3 = localObject1;
      if (this.jdField_b_of_type_Long >= 0L) {
        continue;
      }
      localObject2 = "0";
      localObject1 = "0";
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        continue;
      }
      str = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId);
      localObject1 = str;
      if (str.equals("0")) {
        continue;
      }
      localObject2 = "0";
      localObject1 = str;
      if (!this.jdField_b_of_type_Boolean) {
        continue;
      }
      i1 = 3;
      if (!this.jdField_q_of_type_Boolean) {
        continue;
      }
      i1 = 1;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007EE9", "0X8007EE9", 0, 0, String.valueOf(i1), (String)localObject2, (String)localObject1, (String)localObject3, false);
      return;
      localObject1 = "0";
      continue;
      ((JSONObject)localObject2).put("feeds_id", "0");
    }
  }
  
  private boolean e()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = l1 - this.jdField_c_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onDeliver!Time now=" + l1 + ", last=" + this.jdField_c_of_type_Long + ", diff=" + l2);
    }
    if (l2 <= 2000L) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "deliver too fast(<=2000), return!");
      }
    }
    do
    {
      return false;
      if (super.a()) {
        break;
      }
    } while (!this.jdField_q_of_type_Boolean);
    finish();
    return false;
    return true;
  }
  
  private void f(boolean paramBoolean)
  {
    if ((this.jdField_l_of_type_Int == 18) || (this.jdField_l_of_type_Int == 17))
    {
      if (this.jdField_l_of_type_Int == 18)
      {
        localObject1 = "0X8008992";
        if (paramBoolean) {
          break label40;
        }
      }
    }
    else {
      return;
    }
    Object localObject1 = "0X800898D";
    label40:
    Object localObject2 = getApplicationContext();
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 11)
    {
      FastWebShareUtils.a((Context)localObject2, (String)localObject1, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.n);
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = ReadInJoyUtils.a();
      ((ReportInfo)localObject1).mSource = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      ((ReportInfo)localObject1).mSourceArticleId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
      ((ReportInfo)localObject1).mAlgorithmId = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mServerContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mInnerId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      ((ReportInfo)localObject1).mOperation = 25;
      ((ReportInfo)localObject1).mOpSource = 12;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      localObject2 = new ArrayList();
      ((List)localObject2).add(localObject1);
      ReadInJoyLogicEngine.a().a((List)localObject2);
      return;
    }
  }
  
  private boolean f()
  {
    return (b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!RIJItemViewType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
  }
  
  private void m()
  {
    boolean bool = true;
    this.jdField_q_of_type_Boolean = getIntent().getBooleanExtra("fast_biu_type", false);
    this.jdField_r_of_type_Boolean = getIntent().getBooleanExtra("should_show_dialog", true);
    this.jdField_s_of_type_Boolean = getIntent().getBooleanExtra("is_modified_biu", false);
    this.jdField_d_of_type_Long = getIntent().getLongExtra("modified_feeds_id", 0L);
    if (!this.jdField_q_of_type_Boolean) {}
    for (;;)
    {
      this.jdField_p_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private void n()
  {
    Object localObject = (RelativeLayout)findViewById(2131365304);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131368729);
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
    ((RelativeLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298813);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setMaxLines(2);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
    {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "commonCommentData is not null mcover:" + this.jdField_i_of_type_JavaLangString + "video duration: " + this.jdField_j_of_type_JavaLangString + "msource : " + this.jdField_h_of_type_JavaLangString + "mtitle" + this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuSourceName()))
      {
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuSourceName();
        QQText localQQText = new QQText(EmotionCodecUtils.b(new String(Base64Util.decode(this.jdField_h_of_type_JavaLangString, 0))), 7, 16);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localQQText);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuPicUrl()))
      {
        this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuPicUrl();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(new URL(this.jdField_i_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuDuration() != -1L)
      {
        long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuDuration();
        this.jdField_j_of_type_JavaLangString = String.format("%02d:%02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) });
        if (l1 != 0L)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
        }
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
      }
    }
  }
  
  private void p()
  {
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int;
    if ((!RIJItemViewType.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (a(i1)))
    {
      this.jdField_i_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_d_of_type_JavaLangString;
      return;
    }
    if ((!RIJItemViewType.p(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (b(i1)))
    {
      this.jdField_i_of_type_JavaLangString = ((SocializeFeedsInfo.UGCPicInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      return;
    }
    if (ReadInjoyFeedsUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$AccountProfileInfo.b;
      return;
    }
    if ((ReadinJoyActionUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdImg)))
    {
      this.jdField_i_of_type_JavaLangString = ((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdImg;
      return;
    }
    this.jdField_i_of_type_JavaLangString = null;
  }
  
  private void q()
  {
    if ((b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!RIJItemViewType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      p();
      if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) || (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        break label167;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    }
    for (;;)
    {
      r();
      return;
      if ((RIJItemViewType.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!RIJItemViewType.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        this.jdField_i_of_type_JavaLangString = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString;
        break;
      }
      if ((ReadInjoyFeedsUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo != null))
      {
        this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo.c;
        break;
      }
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
      break;
      label167:
      if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(BaseApplication.getContext().getResources().getDrawable(2130849735));
      }
      else
      {
        try
        {
          URL localURL = new URL(this.jdField_i_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(localURL);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void r()
  {
    if (this.jdField_k_of_type_Int == 2)
    {
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mVideoDuration;
      long l1 = l2;
      if (b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        l1 = l2;
        if (!RIJItemViewType.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          l1 = ((SocializeFeedsInfo.UGCVideoInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_a_of_type_Long / 1000L;
        }
      }
      this.jdField_j_of_type_JavaLangString = a(l1);
      if (l1 != 0L)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
      }
    }
  }
  
  private void s()
  {
    long l1;
    if (f())
    {
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long;
      if (l1 == 0L)
      {
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
      return;
    }
    if (b())
    {
      this.jdField_h_of_type_JavaLangString = ContactUtils.c((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_Long), true);
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
      return;
    }
    if (this.jdField_k_of_type_Int == 4)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary)) {}
      for (this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131712800);; this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
        return;
      }
    }
    if (this.jdField_k_of_type_Int == 5)
    {
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long;
      if (l1 == 0L)
      {
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
      return;
    }
    if (d())
    {
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
      return;
    }
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuTitle())))
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuTitle();
      QQText localQQText = new QQText(EmotionCodecUtils.b(new String(Base64Util.decode(this.jdField_f_of_type_JavaLangString, 0))), 7, 16);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localQQText);
    }
  }
  
  private void u()
  {
    if ((b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!RIJItemViewType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (!RIJItemViewType.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        this.jdField_f_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_e_of_type_JavaLangString;
        return;
      }
      if ((ReadinJoyActionUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdTxt)))
      {
        this.jdField_f_of_type_JavaLangString = ((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdTxt;
        return;
      }
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString;
      return;
    }
    if (RIJItemViewType.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      if (!RIJItemViewType.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_f_of_type_JavaLangString = (localTopicRecommendInfo.c + localTopicRecommendInfo.jdField_a_of_type_JavaLangString);
        return;
      }
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
      return;
    }
    if (this.jdField_k_of_type_Int == 4)
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
      return;
    }
    if (d())
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$ShareWebPageInfo.b;
      return;
    }
    if (c())
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString;
      return;
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
  }
  
  private void v()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList == null))
    {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "initEditText: got null stuff");
      return;
    }
    if (this.jdField_o_of_type_Int <= 0)
    {
      this.jdField_o_of_type_Int = getResources().getDisplayMetrics().widthPixels;
      this.jdField_o_of_type_Int = (this.jdField_o_of_type_Int - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = new ArrayList();
    if (((List)localObject2).size() > 0)
    {
      i1 = localStringBuilder.length();
      localStringBuilder.append(jdField_e_of_type_JavaLangString);
      ((List)localObject1).add(new PositionalSpanStruct(i1, jdField_e_of_type_JavaLangString.length() + i1, new SeparatorSpan()));
    }
    int i2 = localStringBuilder.length();
    int i1 = ((List)localObject2).size() - 1;
    if (i1 >= 0)
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)((List)localObject2).get(i1);
      switch (localBiuCommentInfo.mOpType)
      {
      }
      for (;;)
      {
        try
        {
          str1 = a(localBiuCommentInfo);
          str3 = "@" + str1;
          localStringBuilder.append(str3);
          if (localBiuCommentInfo.mBiuComment != null) {
            continue;
          }
          str1 = "";
          localStringBuilder.append(str1);
          ((List)localObject1).add(new PositionalSpanStruct(i2, str3.length() + i2, new BiuNicknameSpan(localBiuCommentInfo.mUin.toString(), localBiuCommentInfo.mFeedId.longValue(), str3)));
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          String str1;
          String str3;
          String str4;
          String str2;
          QLog.d("ReadInJoyDeliverBiuActivity", 2, localNumberFormatException2.getMessage());
          continue;
        }
        i2 = localStringBuilder.length();
        i1 -= 1;
        break;
        if (localBiuCommentInfo.jumpInfo != null)
        {
          str3 = localBiuCommentInfo.jumpInfo.getWording();
          str4 = localBiuCommentInfo.jumpInfo.getJumpUrl();
          if (localBiuCommentInfo.mBiuComment == null)
          {
            str1 = "";
            localStringBuilder.append(str3).append(str1);
            ((List)localObject1).add(new PositionalSpanStruct(i2, str3.length() + i2, new JumpSpan(str4, 13421772)));
          }
          else
          {
            str1 = localBiuCommentInfo.mBiuComment;
            continue;
            try
            {
              str1 = a(localBiuCommentInfo);
              str3 = "@" + str1 + " ";
              localStringBuilder.append(str3);
              if (localBiuCommentInfo.mBiuComment != null) {
                continue;
              }
              str1 = "";
              localStringBuilder.append(str1);
              ((List)localObject1).add(new PositionalSpanStruct(i2, str3.length() + i2, new AtFriendsSpan(localBiuCommentInfo.mUin.toString(), localBiuCommentInfo.mFeedId.longValue(), str3)));
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              QLog.e("ReadInJoyDeliverBiuActivity", 2, "initEditText: ", localNumberFormatException1);
            }
            continue;
            str2 = localBiuCommentInfo.mBiuComment;
            continue;
            str2 = localBiuCommentInfo.mBiuComment;
          }
        }
      }
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PositionalSpanStruct)((Iterator)localObject1).next();
      localSpannableStringBuilder.setSpan(((PositionalSpanStruct)localObject2).a(), ((PositionalSpanStruct)localObject2).a(), ((PositionalSpanStruct)localObject2).b(), 33);
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableStringBuilder);
  }
  
  private void x()
  {
    ThreadManager.post(new ReadInJoyDeliverBiuActivity.10(this), 5, null, true);
  }
  
  private void y()
  {
    Object localObject = "";
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      localObject = this.jdField_f_of_type_JavaLangString;
    }
    try
    {
      SocializeFeedsInfo.UGCFeedsInfo localUGCFeedsInfo;
      for (;;)
      {
        localObject = EmotionCodecUtils.b((String)localObject);
        if ((!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (RIJItemViewType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (UtilsForComponent.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label157;
        }
        localUGCFeedsInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
        if (RIJFeedsType.a(localUGCFeedsInfo)) {
          break;
        }
        localObject = new QQText((CharSequence)localObject, 7, 16);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          localObject = this.jdField_g_of_type_JavaLangString;
        }
      }
      localObject = new QQText(localUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a(), 7, 16);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyDeliverBiuActivity", 2, localException.toString());
      return;
    }
    label157:
    QQText localQQText = new QQText(localException, 7, 16);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localQQText);
  }
  
  public int a(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("biu_src", 1);
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      i1 = 100;
    }
    return i1;
  }
  
  public void a()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363728));
    this.jdField_f_of_type_Int = 178;
    this.jdField_f_of_type_Int = ViewUtils.b(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ReadInJoyDeliverBiuActivity.1(this);
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new ReadInJoyDeliverBiuActivity.2(this));
    this.v = ViewUtils.b();
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.v * 8 / 100);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131379432));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372115));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131368729));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373169));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373175));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131381298));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381321));
    getTitleBarView().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365668));
    if (this.jdField_s_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697462));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ReadInJoyDeliverBiuActivity.3(this));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
    }
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364815));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new ReadInJoyDeliverBiuActivity.4(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365029);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ReadInJoyDeliverBiuActivity.5(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377356);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379655));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363726));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363721));
    this.jdField_e_of_type_AndroidWidgetImageView.setRotation(-30.0F);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372621));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372623));
    this.jdField_g_of_type_AndroidWidgetImageView.setRotation(30.0F);
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372624));
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131367016));
    this.jdField_b_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131377663));
    this.jdField_c_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131363196));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363729));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363723));
    localObject = AnimationUtils.loadAnimation(this, 2130772205);
    this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = AnimationUtils.loadAnimation(this, 2130772206);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.6(this), 250L);
    if (getIntent().getIntExtra("arg_type", -1) == 4) {
      n();
    }
  }
  
  public void a(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.init();
        this.mSystemBarComp.setStatusBarColor(-872415232);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.init();
    if (!SystemUtil.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-872415232);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public boolean a()
  {
    if (!e()) {
      return false;
    }
    if (this.jdField_r_of_type_Boolean) {
      d(2131695228);
    }
    this.jdField_r_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    boolean bool = Utils.a(this.jdField_a_of_type_AndroidWidgetEditText, this.app.getCurrentAccountUin(), this.jdField_o_of_type_Boolean, true, localArrayList);
    QLog.d("biu_data_trace", 2, "onDeliver deliverList:\n" + localArrayList.toString());
    if ((!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) && (this.jdField_p_of_type_Int == 17)) {
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_l_of_type_JavaLangString, this.jdField_p_of_type_Int, ((SocializeFeedsInfo.BiuCommentInfo)localArrayList.get(0)).mBiuComment, localArrayList, this.jdField_q_of_type_Boolean);
    }
    for (;;)
    {
      e(bool);
      return true;
      if (this.jdField_l_of_type_Int == 21)
      {
        SocializeFeedsInfo.AccountProfileInfo localAccountProfileInfo = new SocializeFeedsInfo.AccountProfileInfo();
        localAccountProfileInfo.c = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
        localAccountProfileInfo.jdField_a_of_type_Long = getIntent().getLongExtra("arg_account_id", -1L);
        localAccountProfileInfo.jdField_a_of_type_Int = getIntent().getIntExtra("arg_account_type", -1);
        localAccountProfileInfo.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
        localAccountProfileInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
        ReadInJoyLogicEngine.a().a(this.app.getCurrentUin(), this.jdField_l_of_type_Int, c(), localArrayList, localAccountProfileInfo);
      }
      else if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!localArrayList.isEmpty()))
      {
        a(localArrayList);
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_d_of_type_JavaLangString = "0X800865F";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(getResources().getDrawable(2130849774));
    Intent localIntent = getIntent();
    this.jdField_l_of_type_Int = localIntent.getIntExtra("arg_from_type", 0);
    this.n = localIntent.getIntExtra("arg_biu_state", -1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localIntent.getParcelableExtra("arg_article_info"));
    this.jdField_k_of_type_JavaLangString = localIntent.getStringExtra("arg_nickname");
    this.jdField_p_of_type_Int = a(localIntent);
    this.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("biu_rowkey");
    this.jdField_m_of_type_Int = localIntent.getIntExtra("feedsType", 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)localIntent.getSerializableExtra("arg_common_comment_info"));
    if (this.jdField_q_of_type_Boolean) {
      findViewById(2131365038).setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      b(localIntent);
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      u();
      y();
      t();
      s();
      q();
      o();
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "mcover:" + this.jdField_i_of_type_JavaLangString + "video duration: " + this.jdField_j_of_type_JavaLangString + "msource : " + this.jdField_h_of_type_JavaLangString + "mtitle : " + this.jdField_f_of_type_JavaLangString);
    }
    a(localIntent);
    if (ArticleInfoHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_e_of_type_JavaLangString;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (ReadInJoyHelper.l(this.app) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      w();
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      if (this.jdField_q_of_type_Boolean) {
        a();
      }
      return;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    f(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560285);
    RIJDtReportHelper.a.a(getActivity());
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    m();
    a(2131718198);
    a();
    b();
    if (this.jdField_q_of_type_Boolean) {
      return true;
    }
    ReadInjoyUserProtocolWidget.a(this, null);
    Object localObject = "";
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
        paramBundle.put("kandian_mode", "" + RIJAppSetting.a());
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        paramBundle.put("feeds_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
        paramBundle = paramBundle.toString();
        localObject = paramBundle;
      }
      catch (JSONException paramBundle)
      {
        String str2;
        paramBundle.printStackTrace();
        continue;
        String str1 = String.valueOf(this.jdField_b_of_type_Long);
        continue;
        continue;
      }
      if (this.jdField_b_of_type_Long >= 0L) {
        continue;
      }
      str1 = "0";
      paramBundle = "0";
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        continue;
      }
      str2 = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId);
      paramBundle = str2;
      if (str2.equals("0")) {
        continue;
      }
      str1 = "0";
      paramBundle = str2;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007EE7", "0X8007EE7", 0, 0, String.valueOf(this.jdField_l_of_type_Int), str1, paramBundle, (String)localObject, false);
      a(getIntent().getExtras());
      return true;
      paramBundle.put("feeds_id", "0");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null) {
      super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131712953), 0).a();
      finish();
    }
  }
  
  protected void e(int paramInt)
  {
    this.jdField_j_of_type_Int = this.jdField_a_of_type_Int;
    b(0);
    super.a(true, paramInt, false, 0L);
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130772207);
    localAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(this, 2130772208);
    localAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.8(this), 300L);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onEmotionBtn!");
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007EE8", "0X8007EE8", 0, 0, "", "", "", (String)localObject1, false);
    super.g();
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_b_of_type_Boolean) && ((!this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Int != -1)))
    {
      e(this.t);
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity
 * JD-Core Version:    0.7.0.1
 */