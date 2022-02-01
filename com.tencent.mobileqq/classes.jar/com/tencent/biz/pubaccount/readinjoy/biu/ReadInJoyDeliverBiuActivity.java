package com.tencent.biz.pubaccount.readinjoy.biu;

import Override;
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
import anvi;
import anvx;
import aoav;
import bcsc;
import bhcu;
import bisl;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import olh;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import owj;
import owk;
import owl;
import owm;
import own;
import owo;
import owp;
import pid;
import pkh;
import pki;
import ppe;
import pqu;
import pqw;
import prp;
import ptj;
import pvj;
import pvm;
import pvq;
import rjl;
import rqt;
import rqw;
import rqy;
import rrf;
import rrg;
import rrh;
import rri;
import rrp;
import rrq;
import rrr;
import rrs;
import rsh;
import rsj;
import rvy;
import tcf;
import tjt;
import tnt;
import tnv;
import tnw;
import uvp;

public class ReadInJoyDeliverBiuActivity
  extends ReadInJoyBaseDeliverActivity
{
  protected static String e;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private anvi jdField_a_of_type_Anvi = new owk(this);
  aoav jdField_a_of_type_Aoav;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  pvq jdField_a_of_type_Pvq = new owp(this);
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_b_of_type_ComTencentWidgetFixSizeImageView;
  private long jdField_c_of_type_Long;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_c_of_type_ComTencentWidgetFixSizeImageView;
  private long jdField_d_of_type_Long;
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
  private boolean jdField_s_of_type_Boolean;
  private int t = 3;
  private int u;
  private int v;
  private int w;
  
  static
  {
    jdField_e_of_type_JavaLangString = " //";
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
    rqw localrqw = new rqw();
    long l2 = 0L;
    Object localObject1;
    Object localObject2;
    int i1;
    long l1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
    {
      if ((this.jdField_l_of_type_Int == 23) || (this.jdField_p_of_type_Int == 24))
      {
        localObject1 = new rrp();
        ((rrp)localObject1).b = this.jdField_f_of_type_JavaLangString;
        ((rrp)localObject1).jdField_d_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
        ((rrp)localObject1).c = this.jdField_i_of_type_JavaLangString;
        ((rrp)localObject1).jdField_a_of_type_JavaLangString = getIntent().getStringExtra("arg_source_url");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp = ((rrp)localObject1);
      }
      if (this.jdField_p_of_type_Int == 24)
      {
        localObject1 = new rrf();
        localObject2 = new rrg();
        ((rrg)localObject2).a(new rrh(getIntent().getLongExtra("arg_now_anchor_uin", 0L)));
        ((rrg)localObject2).a(new rri(getIntent().getStringExtra("arg_now_live_vid")));
        ((rrf)localObject1).a((rrg)localObject2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrf = ((rrf)localObject1);
      }
      l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw != null)
      {
        localrqw.jdField_a_of_type_JavaLangLong = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaLangLong;
        localrqw.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b;
        i1 = paramArrayList.size() - 1;
        l1 = l2;
        if (i1 <= 0) {
          break label483;
        }
        localObject2 = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(i1);
        if ((((SocializeFeedsInfo.BiuCommentInfo)localObject2).mFeedId.longValue() == 0L) || (((SocializeFeedsInfo.BiuCommentInfo)localObject2).mOpType != 0)) {
          break label708;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.iterator();
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
        localrqw.jdField_a_of_type_JavaUtilList.add(localObject1);
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
        localrqw.jdField_a_of_type_JavaUtilList.add(paramArrayList.get(i1));
        i1 -= 1;
      }
      i1 = paramArrayList.size() - 1;
      for (;;)
      {
        l1 = l2;
        if (i1 <= 0) {
          break;
        }
        localrqw.jdField_a_of_type_JavaUtilList.add(paramArrayList.get(i1));
        i1 -= 1;
      }
      label483:
      if (this.jdField_s_of_type_Boolean)
      {
        pvj.a().a(pkh.a(), this.jdField_d_of_type_Long, localrqw, ((SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(0)).mBiuComment);
        return;
      }
      pvj.a().a(pkh.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, localrqw, l1, ((SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(0)).mBiuComment, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq, this.jdField_p_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.jdField_m_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_q_of_type_Boolean);
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
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.longValue() != 30L) {
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
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType != 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5)) && (!pqw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        break label76;
      }
      this.jdField_k_of_type_Int = 2;
    }
    label76:
    do
    {
      return;
      if ((b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null))
      {
        if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int))
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
  
  private boolean b()
  {
    return (ppe.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ppe.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rsh != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rsh.jdField_b_of_type_Long != 0L);
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
    return (ppe.g(paramArticleInfo)) || (ppe.i(paramArticleInfo)) || (ppe.j(paramArticleInfo)) || (ppe.k(paramArticleInfo)) || (paramArticleInfo.mFeedType == 25);
  }
  
  private boolean c()
  {
    return (this.jdField_k_of_type_Int == 5) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null);
  }
  
  private boolean d()
  {
    return (pki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp != null);
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject3 = "";
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", prp.jdField_a_of_type_Int);
        ((JSONObject)localObject2).put("kandian_mode", "" + pqu.a());
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
      olh.a(null, "", "0X8007EE9", "0X8007EE9", 0, 0, String.valueOf(i1), (String)localObject2, (String)localObject1, (String)localObject3, false);
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
      tjt.a((Context)localObject2, (String)localObject1, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.n);
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = pkh.a();
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
      pvj.a().a((List)localObject2);
      return;
    }
  }
  
  private boolean f()
  {
    return (b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ppe.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
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
    Object localObject = (RelativeLayout)findViewById(2131365167);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131368501);
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
    ((RelativeLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298725);
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
        QQText localQQText = new QQText(bcsc.b(new String(bhcu.decode(this.jdField_h_of_type_JavaLangString, 0))), 7, 16);
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
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int;
    if ((!ppe.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (a(i1)))
    {
      this.jdField_i_of_type_JavaLangString = ((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_d_of_type_JavaLangString;
      return;
    }
    if ((!ppe.p(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (b(i1)))
    {
      this.jdField_i_of_type_JavaLangString = ((rrr)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      return;
    }
    if (pki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Rqt.b;
      return;
    }
    if ((uvp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdImg)))
    {
      this.jdField_i_of_type_JavaLangString = ((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdImg;
      return;
    }
    this.jdField_i_of_type_JavaLangString = null;
  }
  
  private void q()
  {
    if ((b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ppe.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
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
      if ((ppe.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ppe.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        this.jdField_i_of_type_JavaLangString = ((rsj)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rsh.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString;
        break;
      }
      if ((pki.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp != null))
      {
        this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp.c;
        break;
      }
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
      break;
      label167:
      if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(BaseApplication.getContext().getResources().getDrawable(2130849351));
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
        if (!ppe.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          l1 = ((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_a_of_type_Long / 1000L;
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
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long;
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
      this.jdField_h_of_type_JavaLangString = ContactUtils.getBuddyName((QQAppInterface)pkh.a(), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rsh.jdField_b_of_type_Long), true);
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
      for (this.jdField_h_of_type_JavaLangString = anvx.a(2131712288);; this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
        return;
      }
    }
    if (this.jdField_k_of_type_Int == 5)
    {
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long;
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
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp.jdField_d_of_type_JavaLangString;
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
      QQText localQQText = new QQText(bcsc.b(new String(bhcu.decode(this.jdField_f_of_type_JavaLangString, 0))), 7, 16);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localQQText);
    }
  }
  
  private void u()
  {
    if ((b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ppe.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      if (!ppe.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        this.jdField_f_of_type_JavaLangString = ((rrs)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).jdField_e_of_type_JavaLangString;
        return;
      }
      if ((uvp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdTxt)))
      {
        this.jdField_f_of_type_JavaLangString = ((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdTxt;
        return;
      }
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaLangString;
      return;
    }
    if (ppe.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      if (!ppe.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
      {
        rsj localrsj = (rsj)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rsh.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_f_of_type_JavaLangString = (localrsj.c + localrsj.jdField_a_of_type_JavaLangString);
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
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp.b;
      return;
    }
    if (c())
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList == null))
    {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "initEditText: got null stuff");
      return;
    }
    if (this.jdField_o_of_type_Int <= 0)
    {
      this.jdField_o_of_type_Int = getResources().getDisplayMetrics().widthPixels;
      this.jdField_o_of_type_Int = (this.jdField_o_of_type_Int - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = new ArrayList();
    if (((List)localObject2).size() > 0)
    {
      i1 = localStringBuilder.length();
      localStringBuilder.append(jdField_e_of_type_JavaLangString);
      ((List)localObject1).add(new tnv(i1, jdField_e_of_type_JavaLangString.length() + i1, new tnw()));
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
          ((List)localObject1).add(new tnv(i2, str3.length() + i2, new BiuNicknameSpan(localBiuCommentInfo.mUin.toString(), localBiuCommentInfo.mFeedId.longValue(), str3)));
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
            ((List)localObject1).add(new tnv(i2, str3.length() + i2, new tnt(str4, 13421772)));
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
              ((List)localObject1).add(new tnv(i2, str3.length() + i2, new AtFriendsSpan(localBiuCommentInfo.mUin.toString(), localBiuCommentInfo.mFeedId.longValue(), str3)));
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
      localObject2 = (tnv)((Iterator)localObject1).next();
      localSpannableStringBuilder.setSpan(((tnv)localObject2).a(), ((tnv)localObject2).a(), ((tnv)localObject2).b(), 33);
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
      rrq localrrq;
      for (;;)
      {
        localObject = bcsc.b((String)localObject);
        if ((!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ppe.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (rjl.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label157;
        }
        localrrq = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq;
        if (pqw.a(localrrq)) {
          break;
        }
        localObject = new QQText((CharSequence)localObject, 7, 16);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          localObject = this.jdField_g_of_type_JavaLangString;
        }
      }
      localObject = new QQText(localrrq.jdField_a_of_type_Rqw.a(), 7, 16);
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
  
  public void a()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363637));
    this.jdField_f_of_type_Int = 178;
    this.jdField_f_of_type_Int = ViewUtils.dpToPx(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new owj(this);
    super.a();
    this.jdField_a_of_type_Bisl.a(new owl(this));
    this.v = ViewUtils.getScreenHeight();
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.v * 8 / 100);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131379001));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371803));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131368501));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372842));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372848));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131380850));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380873));
    getTitleBarView().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365507));
    if (this.jdField_s_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697208));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new owm(this));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
    }
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364699));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new own(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364892);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new owo(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376947);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379221));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363635));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363630));
    this.jdField_e_of_type_AndroidWidgetImageView.setRotation(-30.0F);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372311));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372313));
    this.jdField_g_of_type_AndroidWidgetImageView.setRotation(30.0F);
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372314));
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131366831));
    this.jdField_b_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131377243));
    this.jdField_c_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131363145));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363638));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363632));
    localObject = AnimationUtils.loadAnimation(this, 2130772190);
    this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = AnimationUtils.loadAnimation(this, 2130772191);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
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
    if (!SystemUtil.isFlyme())
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
      d(2131694989);
    }
    this.jdField_r_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    boolean bool = rvy.a(this.jdField_a_of_type_AndroidWidgetEditText, this.app.getCurrentAccountUin(), this.jdField_o_of_type_Boolean, true, localArrayList);
    QLog.d("biu_data_trace", 2, "onDeliver deliverList:\n" + localArrayList.toString());
    if ((!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) && (this.jdField_p_of_type_Int == 17)) {
      pvj.a().a(pkh.a(), this.jdField_l_of_type_JavaLangString, this.jdField_p_of_type_Int, ((SocializeFeedsInfo.BiuCommentInfo)localArrayList.get(0)).mBiuComment, localArrayList, this.jdField_q_of_type_Boolean);
    }
    for (;;)
    {
      e(bool);
      return true;
      if (this.jdField_l_of_type_Int == 21)
      {
        rqt localrqt = new rqt();
        localrqt.c = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
        localrqt.jdField_a_of_type_Long = getIntent().getLongExtra("arg_account_id", -1L);
        localrqt.jdField_a_of_type_Int = getIntent().getIntExtra("arg_account_type", -1);
        localrqt.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
        localrqt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
        pvj.a().a(this.app.getCurrentUin(), this.jdField_l_of_type_Int, c(), localArrayList, localrqt);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(getResources().getDrawable(2130849391));
    Intent localIntent = getIntent();
    this.jdField_l_of_type_Int = localIntent.getIntExtra("arg_from_type", 0);
    this.n = localIntent.getIntExtra("arg_biu_state", -1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localIntent.getParcelableExtra("arg_article_info"));
    this.jdField_k_of_type_JavaLangString = localIntent.getStringExtra("arg_nickname");
    this.jdField_p_of_type_Int = localIntent.getIntExtra("biu_src", 1);
    this.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("biu_rowkey");
    this.jdField_m_of_type_Int = localIntent.getIntExtra("feedsType", 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)localIntent.getSerializableExtra("arg_common_comment_info"));
    if (this.jdField_q_of_type_Boolean) {
      findViewById(2131364901).setVisibility(8);
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
    if (pid.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_e_of_type_JavaLangString;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (bmhv.l(this.app) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      w();
      pvm.a().a(this.jdField_a_of_type_Pvq);
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
    super.setContentView(2131560208);
    ptj.a.a(getActivity());
    addObserver(this.jdField_a_of_type_Anvi);
    m();
    a(2131717696);
    a();
    b();
    if (this.jdField_q_of_type_Boolean) {
      return true;
    }
    tcf.a(this, null);
    Object localObject = "";
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("folder_status", prp.jdField_a_of_type_Int);
        paramBundle.put("kandian_mode", "" + pqu.a());
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
      olh.a(null, "", "0X8007EE7", "0X8007EE7", 0, 0, String.valueOf(this.jdField_l_of_type_Int), str1, paramBundle, (String)localObject, false);
      a(getIntent().getExtras());
      return true;
      paramBundle.put("feeds_id", "0");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anvi);
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if (this.jdField_a_of_type_Aoav != null) {
      super.removeObserver(this.jdField_a_of_type_Aoav);
    }
    pvm.a().b(this.jdField_a_of_type_Pvq);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (isInMultiWindow())
    {
      QQToast.a(this, anvx.a(2131712448), 0).a();
      finish();
    }
  }
  
  public void e(int paramInt)
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
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130772192);
    localAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(this, 2130772193);
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
      ((JSONObject)localObject2).put("folder_status", prp.jdField_a_of_type_Int);
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
    olh.a(null, "", "0X8007EE8", "0X8007EE8", 0, 0, "", "", "", (String)localObject1, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity
 * JD-Core Version:    0.7.0.1
 */