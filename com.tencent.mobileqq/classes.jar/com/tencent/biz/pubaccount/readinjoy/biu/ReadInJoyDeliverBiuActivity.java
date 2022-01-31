package com.tencent.biz.pubaccount.readinjoy.biu;

import ajxj;
import ajya;
import akdn;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import axau;
import aykk;
import bbbm;
import bbco;
import bbcz;
import bbll;
import bcqf;
import bcql;
import bhvy;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import nol;
import odq;
import odr;
import ods;
import odt;
import odu;
import odv;
import odw;
import okz;
import onh;
import onp;
import org.json.JSONException;
import org.json.JSONObject;
import osg;
import osj;
import osm;
import pym;
import qcd;
import qcg;
import qci;
import qcp;
import qcq;
import qcr;
import qcs;
import qcz;
import qda;
import qdb;
import qdc;
import qdq;
import qds;
import qgo;
import ram;
import rfz;
import rmy;
import rrc;
import rre;
import rrf;
import shq;
import zzp;

public class ReadInJoyDeliverBiuActivity
  extends ReadInJoyBaseDeliverActivity
{
  protected static String e;
  private ajxj jdField_a_of_type_Ajxj = new odr(this);
  akdn jdField_a_of_type_Akdn;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  osm jdField_a_of_type_Osm = new odw(this);
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
  private String jdField_l_of_type_JavaLangString = "1920*1080;1280*720;1812*1080;1208*720;1280*760;1184*720;1794*1080;1776*1080;1800*1080;2960*1440;2560*1440";
  private int m = 1;
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
    String str = ReadInJoyUserInfoModule.a(paramLong);
    Object localObject = str;
    if (ReadInJoyUserInfoModule.a().equalsIgnoreCase(str))
    {
      localObject = ReadInJoyUserInfoModule.a(paramLong, null);
      if (localObject == null) {
        break label62;
      }
    }
    label62:
    for (localObject = ((ReadInJoyUserInfo)localObject).nick;; localObject = ReadInJoyUserInfoModule.a())
    {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "getBiuUserName : " + (String)localObject);
      return localObject;
    }
  }
  
  private static void a(Bundle paramBundle)
  {
    if (paramBundle != null) {}
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
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b.longValue() != 30L) {
      return false;
    }
    return true;
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
    return (ram.a(paramArticleInfo)) || (ram.i(paramArticleInfo)) || (ram.j(paramArticleInfo)) || (ram.k(paramArticleInfo)) || (paramArticleInfo.mFeedType == 25);
  }
  
  private void e(boolean paramBoolean)
  {
    if ((this.jdField_l_of_type_Int == 18) || (this.jdField_l_of_type_Int == 17))
    {
      if (this.jdField_l_of_type_Int == 18)
      {
        localObject1 = "0X8008992";
        if (paramBoolean) {
          break label38;
        }
      }
    }
    else {
      return;
    }
    Object localObject1 = "0X800898D";
    label38:
    Object localObject2 = getApplicationContext();
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 11)
    {
      rmy.a((Context)localObject2, (String)localObject1, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.n);
      localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = onh.a();
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
      osg.a().a((List)localObject2);
      return;
    }
  }
  
  private void n()
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
  
  private void o()
  {
    Object localObject = (RelativeLayout)findViewById(2131364701);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131367776);
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
    ((RelativeLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298535);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setMaxLines(2);
  }
  
  private void p()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList == null))
    {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "initEditText: got null stuff");
      return;
    }
    if (this.jdField_o_of_type_Int <= 0)
    {
      this.jdField_o_of_type_Int = getResources().getDisplayMetrics().widthPixels;
      this.jdField_o_of_type_Int = (this.jdField_o_of_type_Int - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = new ArrayList();
    if (((List)localObject2).size() > 0)
    {
      i1 = localStringBuilder.length();
      localStringBuilder.append(jdField_e_of_type_JavaLangString);
      ((List)localObject1).add(new rre(i1, jdField_e_of_type_JavaLangString.length() + i1, new rrf()));
    }
    int i2 = localStringBuilder.length();
    int i1 = ((List)localObject2).size() - 1;
    if (i1 >= 0)
    {
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)((List)localObject2).get(i1);
      switch (localBiuCommentInfo.jdField_c_of_type_Int)
      {
      }
      for (;;)
      {
        try
        {
          str1 = a(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue());
          str3 = "@" + str1;
          localStringBuilder.append(str3);
          if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
            continue;
          }
          str1 = "";
          localStringBuilder.append(str1);
          ((List)localObject1).add(new rre(i2, str3.length() + i2, new BiuNicknameSpan(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.toString(), localBiuCommentInfo.b.longValue(), str3)));
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
        if (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo != null)
        {
          str3 = localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a();
          str4 = localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b();
          if (localBiuCommentInfo.jdField_a_of_type_JavaLangString == null)
          {
            str1 = "";
            localStringBuilder.append(str3).append(str1);
            ((List)localObject1).add(new rre(i2, str3.length() + i2, new rrc(str4, 13421772)));
          }
          else
          {
            str1 = localBiuCommentInfo.jdField_a_of_type_JavaLangString;
            continue;
            try
            {
              str1 = a(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue());
              str3 = "@" + str1 + " ";
              localStringBuilder.append(str3);
              if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
                continue;
              }
              str1 = "";
              localStringBuilder.append(str1);
              ((List)localObject1).add(new rre(i2, str3.length() + i2, new AtFriendsSpan(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.toString(), localBiuCommentInfo.b.longValue(), str3)));
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              QLog.e("ReadInJoyDeliverBiuActivity", 2, "initEditText: ", localNumberFormatException1);
            }
            continue;
            str2 = localBiuCommentInfo.jdField_a_of_type_JavaLangString;
            continue;
            str2 = localBiuCommentInfo.jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(new aykk(localStringBuilder, 7, 16));
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (rre)((Iterator)localObject1).next();
      localSpannableStringBuilder.setSpan(((rre)localObject2).a(), ((rre)localObject2).a(), ((rre)localObject2).b(), 33);
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableStringBuilder);
  }
  
  private void r()
  {
    ThreadManager.post(new ReadInJoyDeliverBiuActivity.10(this), 5, null, true);
  }
  
  private void s()
  {
    Object localObject = "";
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      localObject = this.jdField_f_of_type_JavaLangString;
    }
    try
    {
      qda localqda;
      for (;;)
      {
        localObject = axau.b((String)localObject);
        if ((!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ram.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (pym.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label158;
        }
        localqda = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda;
        if (onh.a(localqda)) {
          break;
        }
        localObject = new aykk((CharSequence)localObject, 7, 16);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
        if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          localObject = this.jdField_g_of_type_JavaLangString;
        }
      }
      localObject = new aykk(localqda.jdField_a_of_type_Qcg.a(), 7, 16);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyDeliverBiuActivity", 2, localException.toString());
      return;
    }
    label158:
    aykk localaykk = new aykk(localException, 7, 16);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localaykk);
  }
  
  public void a()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363282));
    this.jdField_f_of_type_Int = 178;
    this.jdField_f_of_type_Int = bbll.b(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new odq(this);
    super.a();
    this.jdField_a_of_type_Bcqf.a(new ods(this));
    this.v = bbll.b();
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.v * 8 / 100);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131377350));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370647));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131367776));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131371663));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371668));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378941));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378961));
    getTitleBarView().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365013));
    if (this.jdField_s_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697721));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new odt(this));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
    }
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364258));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new odu(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364439);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new odv(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375493);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377556));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363279));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363274));
    this.jdField_e_of_type_AndroidWidgetImageView.setRotation(-30.0F);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371139));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371141));
    this.jdField_g_of_type_AndroidWidgetImageView.setRotation(30.0F);
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371142));
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131366287));
    this.jdField_b_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131375753));
    this.jdField_c_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131362938));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363289));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363276));
    localObject = AnimationUtils.loadAnimation(this, 2130772171);
    this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = AnimationUtils.loadAnimation(this, 2130772172);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.6(this), 250L);
    if (getIntent().getIntExtra("arg_type", -1) == 4) {
      o();
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bbbm.b()) && (!bbbm.d()))
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
    if (!bbbm.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-872415232);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public boolean a()
  {
    l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = l1 - this.jdField_c_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onDeliver!Time now=" + l1 + ", last=" + this.jdField_c_of_type_Long + ", diff=" + l2);
    }
    if (l2 <= 2000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "deliver too fast(<=2000), return!");
      }
      return false;
    }
    if (!super.a())
    {
      if (this.jdField_q_of_type_Boolean) {
        finish();
      }
      return false;
    }
    if (this.jdField_r_of_type_Boolean) {
      c(2131695575);
    }
    this.jdField_r_of_type_Boolean = true;
    localObject3 = new ArrayList();
    bool = qgo.a(this.jdField_a_of_type_AndroidWidgetEditText, this.app.getCurrentAccountUin(), this.jdField_o_of_type_Boolean, true, (List)localObject3);
    QLog.d("biu_data_trace", 2, "onDeliver deliverList:\n" + ((ArrayList)localObject3).toString());
    Object localObject4;
    if ((!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) && (this.jdField_p_of_type_Int == 17))
    {
      osg.a().a(onh.a(), this.jdField_k_of_type_JavaLangString, this.jdField_p_of_type_Int, ((SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(0)).jdField_a_of_type_JavaLangString, (ArrayList)localObject3, this.jdField_q_of_type_Boolean);
      localObject4 = "";
    }
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("folder_status", onh.jdField_d_of_type_Int);
        ((JSONObject)localObject3).put("kandian_mode", "" + onh.e());
        if (!this.jdField_q_of_type_Boolean) {
          continue;
        }
        localObject1 = "1";
        ((JSONObject)localObject3).put("fast_biu", localObject1);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        ((JSONObject)localObject3).put("feeds_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
        localObject1 = getIntent().getExtras();
        if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("arg_forward"))) {
          continue;
        }
        i1 = 1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        Object localObject5;
        Iterator localIterator;
        localJSONException.printStackTrace();
        continue;
        int i1 = 0;
        continue;
        i1 = 0;
        continue;
        localObject3 = String.valueOf(this.jdField_b_of_type_Long);
        continue;
        if (!bool) {
          continue;
        }
        i1 = 1;
        continue;
        i1 = 2;
        continue;
        continue;
        continue;
        l1 = 0L;
        continue;
        Object localObject2 = null;
        continue;
        if (i1 == 0) {
          continue;
        }
        i1 = 1;
        continue;
      }
      ((JSONObject)localObject3).put("outside", i1);
      localObject1 = ((JSONObject)localObject3).toString();
      localObject4 = localObject1;
      if (this.jdField_b_of_type_Long >= 0L) {
        continue;
      }
      localObject3 = "0";
      localObject1 = "0";
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
        continue;
      }
      localObject5 = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId);
      localObject1 = localObject5;
      if (((String)localObject5).equals("0")) {
        continue;
      }
      localObject3 = "0";
      localObject1 = localObject5;
      if (!this.jdField_b_of_type_Boolean) {
        continue;
      }
      i1 = 3;
      if (!this.jdField_q_of_type_Boolean) {
        continue;
      }
      i1 = 1;
      nol.a(null, "", "0X8007EE9", "0X8007EE9", 0, 0, String.valueOf(i1), (String)localObject3, (String)localObject1, (String)localObject4, false);
      return true;
      if (this.jdField_l_of_type_Int == 21)
      {
        localObject1 = new qcd();
        ((qcd)localObject1).c = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
        ((qcd)localObject1).jdField_a_of_type_Long = getIntent().getLongExtra("arg_account_id", -1L);
        ((qcd)localObject1).jdField_a_of_type_Int = getIntent().getIntExtra("arg_account_type", -1);
        ((qcd)localObject1).b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
        ((qcd)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
        osg.a().a(this.app.c(), this.jdField_l_of_type_Int, c(), (ArrayList)localObject3, (qcd)localObject1);
        break;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (((ArrayList)localObject3).size() <= 0)) {
        break;
      }
      localObject4 = new qcg();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
      {
        if ((this.jdField_l_of_type_Int == 23) || (this.jdField_p_of_type_Int == 24))
        {
          localObject1 = new qcz();
          ((qcz)localObject1).b = this.jdField_f_of_type_JavaLangString;
          ((qcz)localObject1).jdField_d_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
          ((qcz)localObject1).c = this.jdField_i_of_type_JavaLangString;
          ((qcz)localObject1).jdField_a_of_type_JavaLangString = getIntent().getStringExtra("arg_source_url");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz = ((qcz)localObject1);
        }
        if (this.jdField_p_of_type_Int == 24)
        {
          localObject1 = new qcp();
          localObject5 = new qcq();
          ((qcq)localObject5).a(new qcr(getIntent().getLongExtra("arg_now_anchor_uin", 0L)));
          ((qcq)localObject5).a(new qcs(getIntent().getStringExtra("arg_now_live_vid")));
          ((qcp)localObject1).a((qcq)localObject5);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcp = ((qcp)localObject1);
        }
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg != null)
        {
          ((qcg)localObject4).jdField_a_of_type_JavaLangLong = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaLangLong;
          ((qcg)localObject4).b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b;
          i1 = ((ArrayList)localObject3).size() - 1;
          if (i1 > 0)
          {
            localObject5 = (SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(i1);
            if ((((SocializeFeedsInfo.BiuCommentInfo)localObject5).b.longValue() == 0L) || (((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_c_of_type_Int != 0)) {
              continue;
            }
            localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.iterator();
            if (!localIterator.hasNext()) {
              continue;
            }
            localObject1 = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
            if (!((SocializeFeedsInfo.BiuCommentInfo)localObject1).b.equals(((SocializeFeedsInfo.BiuCommentInfo)localObject5).b)) {
              continue;
            }
            if (localObject1 == null)
            {
              localObject1 = (SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(i1);
              ((qcg)localObject4).jdField_a_of_type_JavaUtilList.add(localObject1);
              i1 -= 1;
              continue;
            }
            ((SocializeFeedsInfo.BiuCommentInfo)localObject1).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangString;
            continue;
          }
          if (!this.jdField_s_of_type_Boolean) {
            continue;
          }
          osg.a().a(onh.a(), this.jdField_d_of_type_Long, (qcg)localObject4, ((SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(0)).jdField_a_of_type_JavaLangString);
          break;
        }
        i1 = ((ArrayList)localObject3).size() - 1;
        if (i1 > 0)
        {
          ((qcg)localObject4).jdField_a_of_type_JavaUtilList.add(((ArrayList)localObject3).get(i1));
          i1 -= 1;
          continue;
        }
        continue;
      }
      i1 = ((ArrayList)localObject3).size() - 1;
      if (i1 <= 0) {
        continue;
      }
      ((qcg)localObject4).jdField_a_of_type_JavaUtilList.add(((ArrayList)localObject3).get(i1));
      i1 -= 1;
      continue;
      osg.a().a(onh.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, (qcg)localObject4, l1, ((SocializeFeedsInfo.BiuCommentInfo)((ArrayList)localObject3).get(0)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq, this.jdField_p_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.m, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_q_of_type_Boolean);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "mFeedId:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId + " masterUin" + l1 + ", mArticleID:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + " mRecommendSeq: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq + " biuSrc:" + this.jdField_p_of_type_Int + " innerUniqueID" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + " feedstype:" + this.m);
      this.jdField_c_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      break;
      localObject1 = "0";
      continue;
      ((JSONObject)localObject3).put("feeds_id", "0");
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_d_of_type_JavaLangString = "0X800865F";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(getResources().getDrawable(2130848398));
    Object localObject1 = getIntent();
    this.jdField_l_of_type_Int = ((Intent)localObject1).getIntExtra("arg_from_type", 0);
    this.n = ((Intent)localObject1).getIntExtra("arg_biu_state", -1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Intent)localObject1).getParcelableExtra("arg_article_info"));
    this.jdField_p_of_type_Int = ((Intent)localObject1).getIntExtra("biu_src", 1);
    this.jdField_k_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("biu_rowkey");
    this.m = ((Intent)localObject1).getIntExtra("feedsType", 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)((Intent)localObject1).getSerializableExtra("arg_common_comment_info"));
    if (this.jdField_q_of_type_Boolean) {
      findViewById(2131364448).setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      this.jdField_k_of_type_Int = ((Intent)localObject1).getIntExtra("arg_type", -1);
      if (this.jdField_k_of_type_Int == -1)
      {
        this.jdField_k_of_type_Int = 1;
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType != 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5)) && (!onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label1362;
        }
        this.jdField_k_of_type_Int = 2;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      label299:
      Object localObject2;
      long l1;
      label444:
      int i1;
      if ((b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ram.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        if (!ram.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
        {
          this.jdField_f_of_type_JavaLangString = ((qdc)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.b.get(0)).jdField_e_of_type_JavaLangString;
          s();
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuTitle())))
          {
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuTitle();
            localObject2 = new aykk(axau.b(new String(bbco.decode(this.jdField_f_of_type_JavaLangString, 0))), 7, 16);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          }
          if ((!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ram.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
            break label1734;
          }
          l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long;
          if (l1 != 0L) {
            break label1723;
          }
          this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
          if ((!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ram.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
            break label2196;
          }
          i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int;
          if ((ram.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (!a(i1))) {
            break label2064;
          }
          this.jdField_i_of_type_JavaLangString = ((qdc)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.b.get(0)).jdField_d_of_type_JavaLangString;
          label522:
          if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) || (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
            break label2305;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          label551:
          if (this.jdField_k_of_type_Int == 2)
          {
            if ((!b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ram.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
              break label2381;
            }
            l1 = ((qdc)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.b.get(0)).jdField_a_of_type_Long / 1000L;
            this.jdField_j_of_type_JavaLangString = String.format("%02d:%02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) });
            if (l1 != 0L)
            {
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
            }
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
          {
            QLog.d("ReadInJoyDeliverBiuActivity", 2, "commonCommentData is not null mcover:" + this.jdField_i_of_type_JavaLangString + "video duration: " + this.jdField_j_of_type_JavaLangString + "msource : " + this.jdField_h_of_type_JavaLangString + "mtitle" + this.jdField_f_of_type_JavaLangString);
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuSourceName()))
            {
              this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuSourceName();
              localObject2 = new aykk(axau.b(new String(bbco.decode(this.jdField_h_of_type_JavaLangString, 0))), 7, 16);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(0);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText((CharSequence)localObject2);
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuPicUrl()))
            {
              this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuPicUrl();
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
            }
          }
        }
      }
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(new URL(this.jdField_i_of_type_JavaLangString));
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuDuration() != -1L)
          {
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getBiuDuration();
            this.jdField_j_of_type_JavaLangString = String.format("%02d:%02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) });
            if (l1 != 0L)
            {
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
              this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
            }
          }
          QLog.d("ReadInJoyDeliverBiuActivity", 2, "mcover:" + this.jdField_i_of_type_JavaLangString + "video duration: " + this.jdField_j_of_type_JavaLangString + "msource : " + this.jdField_h_of_type_JavaLangString + "mtitle : " + this.jdField_f_of_type_JavaLangString);
          if (((!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) && (this.jdField_p_of_type_Int == 17)) || (this.jdField_p_of_type_Int == 24))
          {
            String str2 = ((Intent)localObject1).getStringExtra("arg_title");
            str1 = ((Intent)localObject1).getStringExtra("arg_src");
            localObject2 = ((Intent)localObject1).getStringExtra("arg_cover");
            localObject1 = str2;
            if (TextUtils.isEmpty(str2)) {
              localObject1 = this.jdField_f_of_type_JavaLangString;
            }
            this.jdField_f_of_type_JavaLangString = ((String)localObject1);
            if (!TextUtils.isEmpty(str1)) {
              break label2403;
            }
            localObject1 = this.jdField_h_of_type_JavaLangString;
            this.jdField_h_of_type_JavaLangString = ((String)localObject1);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label2410;
            }
            localObject1 = this.jdField_i_of_type_JavaLangString;
            this.jdField_i_of_type_JavaLangString = ((String)localObject1);
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = new ArticleInfo();
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
            }
            localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
            if (this.jdField_f_of_type_JavaLangString != null) {
              break label2417;
            }
            localObject1 = "";
            ((TextView)localObject2).setText((CharSequence)localObject1);
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
            if (this.jdField_h_of_type_JavaLangString != null) {
              break label2426;
            }
            localObject1 = "";
            ((ReadInJoyNickNameTextView)localObject2).setText((CharSequence)localObject1);
            if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
              break label2435;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          }
          if (okz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_e_of_type_JavaLangString;
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          if (bhvy.q(this.app) != 0) {
            break label2471;
          }
          bool = true;
          this.jdField_g_of_type_Boolean = bool;
          if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          q();
          osj.a().a(this.jdField_a_of_type_Osm);
          if (this.jdField_q_of_type_Boolean) {
            a();
          }
          return;
          label1362:
          if ((b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda != null))
          {
            if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int))
            {
              this.jdField_k_of_type_Int = 2;
              break;
            }
            this.jdField_k_of_type_Int = 1;
            break;
          }
          if (!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
            break;
          }
          this.jdField_k_of_type_Int = 5;
          break;
          if ((shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdTxt)))
          {
            this.jdField_f_of_type_JavaLangString = ((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdTxt;
            break label299;
          }
          this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaLangString;
          break label299;
          if (ram.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            if (!ram.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
            {
              localObject2 = (qds)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList.get(0);
              this.jdField_f_of_type_JavaLangString = (((qds)localObject2).c + ((qds)localObject2).jdField_a_of_type_JavaLangString);
              break label299;
            }
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
            break label299;
          }
          if (this.jdField_k_of_type_Int == 4)
          {
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
            break label299;
          }
          if ((onp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz != null))
          {
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz.b;
            break label299;
          }
          if ((this.jdField_k_of_type_Int == 5) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda != null))
          {
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaLangString;
            break label299;
          }
          this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
          this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
          break label299;
          label1723:
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
          break label444;
          label1734:
          if ((ram.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ram.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_b_of_type_Long != 0L))
          {
            this.jdField_h_of_type_JavaLangString = bbcz.b((QQAppInterface)onh.a(), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_b_of_type_Long), true);
            if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
              break label444;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
            break label444;
          }
          if (this.jdField_k_of_type_Int == 4)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary)) {}
            for (this.jdField_h_of_type_JavaLangString = ajya.a(2131712837);; this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
              break;
            }
          }
          if (this.jdField_k_of_type_Int == 5)
          {
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long;
            if (l1 == 0L)
            {
              this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
              break label444;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
            break label444;
          }
          if ((onp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz != null))
          {
            this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz.jdField_d_of_type_JavaLangString;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
            break label444;
          }
          this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
          if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
            break label444;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
          break label444;
          label2064:
          if ((!ram.p(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (b(i1)))
          {
            this.jdField_i_of_type_JavaLangString = ((qdb)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
            break label522;
          }
          if (onp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcd.b;
            break label522;
          }
          if ((shq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdImg)))
          {
            this.jdField_i_of_type_JavaLangString = ((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).mAdImg;
            break label522;
          }
          this.jdField_i_of_type_JavaLangString = null;
          break label522;
          label2196:
          if ((ram.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ram.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
          {
            this.jdField_i_of_type_JavaLangString = ((qds)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString;
            break label522;
          }
          if ((onp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz != null))
          {
            this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz.c;
            break label522;
          }
          this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
          break label522;
          label2305:
          if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(BaseApplication.getContext().getResources().getDrawable(2130848367));
            break label551;
          }
          try
          {
            localObject2 = new URL(this.jdField_i_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a((URL)localObject2);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        break label551;
        label2381:
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mVideoDuration;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          String str1;
          localMalformedURLException.printStackTrace();
          continue;
          label2403:
          localObject1 = str1;
          continue;
          label2410:
          localObject1 = localMalformedURLException;
          continue;
          label2417:
          localObject1 = this.jdField_f_of_type_JavaLangString;
          continue;
          label2426:
          localObject1 = this.jdField_h_of_type_JavaLangString;
          continue;
          try
          {
            label2435:
            localObject1 = new URL(this.jdField_i_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a((URL)localObject1);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
          continue;
          label2471:
          boolean bool = false;
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_j_of_type_Int = this.jdField_a_of_type_Int;
    b(0);
    super.a(true, paramInt, false, 0L);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    e(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559901);
    addObserver(this.jdField_a_of_type_Ajxj);
    n();
    a(2131718408);
    a();
    b();
    if (this.jdField_q_of_type_Boolean) {
      return true;
    }
    rfz.a(this, null);
    Object localObject = "";
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("folder_status", onh.jdField_d_of_type_Int);
        paramBundle.put("kandian_mode", "" + onh.e());
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
      nol.a(null, "", "0X8007EE7", "0X8007EE7", 0, 0, String.valueOf(this.jdField_l_of_type_Int), str1, paramBundle, (String)localObject, false);
      a(getIntent().getExtras());
      return true;
      paramBundle.put("feeds_id", "0");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Ajxj);
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if (this.jdField_a_of_type_Akdn != null) {
      super.removeObserver(this.jdField_a_of_type_Akdn);
    }
    osj.a().b(this.jdField_a_of_type_Osm);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (isInMultiWindow())
    {
      bcql.a(this, ajya.a(2131712997), 0).a();
      finish();
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    zzp.a(this);
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130772173);
    localAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(this, 2130772174);
    localAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.8(this), 300L);
    if (this.jdField_s_of_type_Boolean) {
      osj.a().d(false);
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onEmotionBtn!");
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", onh.jdField_d_of_type_Int);
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
    nol.a(null, "", "0X8007EE8", "0X8007EE8", 0, 0, "", "", "", (String)localObject1, false);
    super.h();
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_b_of_type_Boolean) && ((!this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Int != -1)))
    {
      d(this.t);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity
 * JD-Core Version:    0.7.0.1
 */