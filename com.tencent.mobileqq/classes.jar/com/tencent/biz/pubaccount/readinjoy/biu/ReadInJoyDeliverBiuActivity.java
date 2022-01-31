package com.tencent.biz.pubaccount.readinjoy.biu;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.UserBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.biuGuide.SSOBiuGuide.ReqBody;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import lis;
import lit;
import liu;
import liv;
import lix;
import liy;
import liz;
import lja;
import ljb;
import ljc;
import ljd;
import lje;
import ljf;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDeliverBiuActivity
  extends ReadInJoyBaseDeliverActivity
{
  protected static String c;
  private long jdField_a_of_type_Long;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lje(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new liv(this);
  PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_b_of_type_ComTencentWidgetFixSizeImageView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_c_of_type_ComTencentWidgetFixSizeImageView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private String jdField_e_of_type_JavaLangString;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private String jdField_f_of_type_JavaLangString;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private String jdField_g_of_type_JavaLangString;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString = "1920*1080;1280*720;1812*1080;1208*720;1280*760;1184*720;1794*1080;1776*1080;1800*1080;2960*1440;2560*1440";
  private int k = 1;
  private int l;
  private int m;
  private int n = 5000;
  private int o = 1;
  private int p = 2;
  private int q = 3;
  private int r;
  private int s;
  private int t;
  
  static
  {
    jdField_c_of_type_JavaLangString = " //";
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == null)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getHeight();
  }
  
  private SpannableString a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.l <= 0)
    {
      this.l = getResources().getDisplayMetrics().widthPixels;
      this.l = (this.l - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight());
    }
    SpannableString localSpannableString = new SpannableString(paramString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ReadInJoyBaseDeliverActivity.UserBiuInfo localUserBiuInfo = (ReadInJoyBaseDeliverActivity.UserBiuInfo)localIterator.next();
      for (;;)
      {
        try
        {
          paramString = ReadInJoyUserInfoModule.a(Long.parseLong(localUserBiuInfo.jdField_a_of_type_JavaLangString), null);
          if (paramString == null) {
            break label211;
          }
          paramString = paramString.nick;
          if (localUserBiuInfo.jdField_d_of_type_Int != 1) {
            break label220;
          }
          localSpannableString.setSpan(new AtFriendsSpan(localUserBiuInfo.jdField_a_of_type_JavaLangString, localUserBiuInfo.jdField_a_of_type_Long, "@" + paramString + " ", getApplicationContext(), this.jdField_a_of_type_AndroidWidgetEditText.getPaint(), this.l), localUserBiuInfo.jdField_a_of_type_Int, localUserBiuInfo.jdField_b_of_type_Int, 33);
        }
        catch (NumberFormatException paramString)
        {
          QLog.d("ReadInJoyDeliverBiuActivity", 2, paramString.getMessage());
        }
        break;
        label211:
        paramString = localUserBiuInfo.jdField_a_of_type_JavaLangString;
      }
      label220:
      localSpannableString.setSpan(new BiuNicknameSpan(localUserBiuInfo.jdField_a_of_type_JavaLangString, localUserBiuInfo.jdField_a_of_type_Long, "@" + paramString, getApplicationContext(), this.jdField_a_of_type_AndroidWidgetEditText.getPaint(), this.l), localUserBiuInfo.jdField_a_of_type_Int, localUserBiuInfo.jdField_b_of_type_Int, 33);
    }
    return localSpannableString;
  }
  
  private ArrayList a()
  {
    Object localObject2 = this.app.getCurrentAccountUin();
    Object localObject1 = new HashSet();
    ArrayList localArrayList = new ArrayList();
    localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject2, 4);
    if (localObject2 != null)
    {
      localObject1 = ((SharedPreferences)localObject2).getStringSet("readinjoy_deliver_biu_guide_uin", (Set)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((Set)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            try
            {
              l1 = Long.parseLong((String)localObject2);
              localArrayList.add(Long.valueOf(l1));
            }
            catch (Exception localException)
            {
              for (;;)
              {
                long l1 = -1L;
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private ArrayList a(ArrayList paramArrayList)
  {
    int i5 = 0;
    ArrayList localArrayList = new ArrayList();
    int i6 = paramArrayList.size();
    int[] arrayOfInt = new int[3];
    Random localRandom = new Random();
    int i1 = 0;
    int i3 = 0;
    int i2 = i5;
    if (i3 < 3)
    {
      int i7 = localRandom.nextInt(i6);
      int i4 = 0;
      for (;;)
      {
        i2 = i1;
        if (i4 < i3)
        {
          if (arrayOfInt[i4] == i7) {
            i2 = 1;
          }
        }
        else
        {
          i1 = i2;
          if (i2 != 0) {
            break;
          }
          arrayOfInt[i3] = i7;
          i3 += 1;
          i1 = i2;
          break;
        }
        i4 += 1;
        i1 = 0;
      }
    }
    while (i2 < 3)
    {
      i1 = arrayOfInt[i2];
      if (i1 < paramArrayList.size()) {
        localArrayList.add(paramArrayList.get(i1));
      }
      i2 += 1;
    }
    return localArrayList;
  }
  
  private void a(ArrayList paramArrayList)
  {
    ThreadManager.post(new lit(this, paramArrayList), 5, null, true);
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
    return (ReadInJoyBaseAdapter.f(paramArticleInfo)) || (ReadInJoyBaseAdapter.g(paramArticleInfo)) || (ReadInJoyBaseAdapter.h(paramArticleInfo)) || (ReadInJoyBaseAdapter.i(paramArticleInfo));
  }
  
  private int b()
  {
    int i1 = 0;
    Object localObject = this.app.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject, 4);
    if (localObject != null) {
      i1 = ((SharedPreferences)localObject).getInt("readinjoy_deliver_biu_numbers", 0);
    }
    return i1;
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 3) || (paramInt == 2)) {
      bool = true;
    }
    return bool;
  }
  
  private String c()
  {
    String str = "";
    Object localObject = this.app.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject, 4);
    if (localObject != null) {
      str = ((SharedPreferences)localObject).getString("readinjoy_deliver_biu_guide_time", "");
    }
    return str;
  }
  
  private void c(String paramString)
  {
    ThreadManager.post(new liu(this, paramString), 5, null, true);
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void f(boolean paramBoolean)
  {
    if ((this.jdField_j_of_type_Int == 18) || (this.jdField_j_of_type_Int == 17))
    {
      if (this.jdField_j_of_type_Int == 18)
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
      FastWebShareUtils.a((Context)localObject2, (String)localObject1, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
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
  
  private void j()
  {
    Object localObject = getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject).widthPixels;
    int i2 = ((DisplayMetrics)localObject).heightPixels;
    localObject = String.valueOf(i2) + "*" + String.valueOf(i1);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "current resolution = " + (String)localObject);
    }
    if (!this.jdField_j_of_type_JavaLangString.contains((CharSequence)localObject))
    {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, AIOUtils.a(27.0F, getResources()), 0, 0);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, AIOUtils.a(47.0F, getResources()), 0, 0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      e(false);
      if (b() > 6)
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        PublicAccountReportUtils.a(null, "", "0X800875F", "0X800875F", 0, 0, "3", "", "", a(), false);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      PublicAccountReportUtils.a(null, "", "0X800875F", "0X800875F", 0, 0, "2", "", "", a(), false);
      return;
    }
    if (b() > 6)
    {
      e(false);
      PublicAccountReportUtils.a(null, "", "0X800875F", "0X800875F", 0, 0, "3", "", "", a(), false);
      return;
    }
    if (ReadInJoyHelper.s(this.app) == 0)
    {
      e(true);
      o();
      k();
      return;
    }
    e(false);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, AIOUtils.a(50.0F, getResources()), 0, 0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    PublicAccountReportUtils.a(null, "", "0X800875F", "0X800875F", 0, 0, "2", "", "", a(), false);
  }
  
  private void k()
  {
    ArrayList localArrayList = a();
    Object localObject;
    if (localArrayList.size() >= 3)
    {
      localObject = localArrayList;
      if (localArrayList.size() > 3) {
        localObject = a(localArrayList);
      }
      int i1 = 0;
      while (i1 < ((ArrayList)localObject).size())
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[i1] = String.valueOf(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_a_of_type_ArrayOfJavaLangString[0]));
      this.jdField_b_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_a_of_type_ArrayOfJavaLangString[1]));
      this.jdField_c_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(FaceDrawable.a(this.app, 1, this.jdField_a_of_type_ArrayOfJavaLangString[2]));
      PublicAccountReportUtils.a(null, "", "0X800875F", "0X800875F", 0, 0, "1", "", "", a(), false);
    }
    for (;;)
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      if (!c().equals(localObject))
      {
        i();
        this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new ljc(this);
        super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
        c((String)localObject);
      }
      return;
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_i_of_type_AndroidWidgetImageView.setVisibility(0);
      PublicAccountReportUtils.a(null, "", "0X800875F", "0X800875F", 0, 0, "2", "", "", a(), false);
    }
  }
  
  private void l()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(jdField_c_of_type_JavaLangString);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        ReadInJoyBaseDeliverActivity.UserBiuInfo localUserBiuInfo = (ReadInJoyBaseDeliverActivity.UserBiuInfo)localIterator.next();
        for (;;)
        {
          try
          {
            Object localObject = ReadInJoyUserInfoModule.a(Long.parseLong(localUserBiuInfo.jdField_a_of_type_JavaLangString), null);
            if (localObject == null) {
              break label168;
            }
            localObject = ((ReadInJoyUserInfo)localObject).nick;
            localUserBiuInfo.a(this.app);
            localUserBiuInfo.jdField_a_of_type_Int = localStringBuilder.length();
            localStringBuilder.append("@").append((String)localObject);
            if (localUserBiuInfo.jdField_d_of_type_Int == 1) {
              localStringBuilder.append(" ");
            }
            localUserBiuInfo.jdField_b_of_type_Int = localStringBuilder.length();
            localStringBuilder.append(localUserBiuInfo.jdField_b_of_type_JavaLangCharSequence);
            localUserBiuInfo.jdField_c_of_type_Int = localStringBuilder.length();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            QLog.d("ReadInJoyDeliverBiuActivity", 2, localNumberFormatException.getMessage());
          }
          break;
          label168:
          String str = localUserBiuInfo.jdField_a_of_type_JavaLangString;
        }
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(a(localStringBuilder.toString()));
    }
  }
  
  private void n()
  {
    ThreadManager.post(new ljf(this), 5, null, true);
  }
  
  private void o()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(1400L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidWidgetImageView, "rotation", new float[] { -30.0F, 0.0F }).setDuration(300L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(200L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, -AIOUtils.a(24.5F, getResources()) }).setDuration(500L);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "translationY", new float[] { -AIOUtils.a(24.5F, getResources()), -AIOUtils.a(23.5F, getResources()) }).setDuration(100L);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "translationY", new float[] { -AIOUtils.a(23.5F, getResources()), -AIOUtils.a(24.5F, getResources()) }).setDuration(100L);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(700L);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "rotation", new float[] { 30.0F, 30.0F }).setDuration(300L);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "rotation", new float[] { 30.0F, 0.0F }).setDuration(400L);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, 30.0F }).setDuration(500L);
    ObjectAnimator localObjectAnimator11 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "rotation", new float[] { 30.0F, 0.0F }).setDuration(500L);
    ObjectAnimator localObjectAnimator12 = ObjectAnimator.ofFloat(this.jdField_h_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, AIOUtils.a(1.5F, getResources()) }).setDuration(500L);
    ObjectAnimator localObjectAnimator13 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F }).setDuration(1400L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator2).after(localObjectAnimator1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator3).with(localObjectAnimator1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator4).with(localObjectAnimator1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator5).after(localObjectAnimator4);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator6).after(localObjectAnimator5);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator7).with(localObjectAnimator1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator8).with(localObjectAnimator1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator9).after(localObjectAnimator8);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator10).after(localObjectAnimator9);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator11).after(localObjectAnimator10);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator12).with(localObjectAnimator1);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator13);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void p()
  {
    Object localObject1 = "";
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      localObject1 = this.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = MessageUtils.b((String)localObject1);
        if ((a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!UtilsForComponent.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
        {
          localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
          if (!ReadInJoyUtils.a((SocializeFeedsInfo.UGCFeedsInfo)localObject3))
          {
            localObject1 = new QQText((CharSequence)localObject1, 7, 16);
            this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            return;
            if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
              continue;
            }
            localObject1 = this.jdField_e_of_type_JavaLangString;
            continue;
          }
          List localList = ((SocializeFeedsInfo.UGCFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList;
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
          int i1 = localList.size();
          localObject3 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i1 - 1)).jdField_a_of_type_JavaLangString;
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || ((!((String)localObject3).startsWith(":")) && (!((String)localObject3).startsWith("：")))) {
            break label476;
          }
          localObject1 = ((String)localObject3).substring(1);
          localSpannableStringBuilder.append((CharSequence)localObject1);
          int i2 = localSpannableStringBuilder.length();
          i1 -= 2;
          if (i1 >= 0)
          {
            SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i1);
            long l1 = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
            localObject1 = ReadInJoyUserInfoModule.a(l1, null);
            if (localObject1 != null)
            {
              localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
              localObject3 = "@" + (String)localObject1;
              localObject1 = localObject3;
              if (localBiuCommentInfo.jdField_c_of_type_Int == 1) {
                localObject1 = (String)localObject3 + " ";
              }
              if (localBiuCommentInfo.jdField_a_of_type_JavaLangString == null)
              {
                localObject3 = "";
                localSpannableStringBuilder.append((CharSequence)localObject1).append((CharSequence)localObject3);
                localSpannableStringBuilder.setSpan(new lix(this), i2, ((String)localObject1).length() + i2, 17);
                i2 = localSpannableStringBuilder.length();
                i1 -= 1;
              }
            }
            else
            {
              localObject1 = String.valueOf(l1);
              continue;
            }
            localObject3 = localBiuCommentInfo.jdField_a_of_type_JavaLangString;
            continue;
          }
          localObject1 = new QQText(localSpannableStringBuilder, 7, 16);
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoyDeliverBiuActivity", 2, localException.toString());
        return;
      }
      Object localObject2 = new QQText(localException, 7, 16);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      return;
      label476:
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  protected void a()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367069));
    this.jdField_f_of_type_Int = 178;
    this.jdField_f_of_type_Int = ViewUtils.b(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new lis(this);
    super.a();
    this.s = ViewUtils.c();
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.s * 8 / 100);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131363397));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362759));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)findViewById(2131361846));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367070));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366890));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367071));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367072));
    getTitleBarView().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366977));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new liy(this));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("" + this.jdField_c_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362873));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new liz(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365625);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new lja(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131362845);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367057));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367065));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367073));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367066));
    this.jdField_e_of_type_AndroidWidgetImageView.setRotation(-30.0F);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367068));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367067));
    this.jdField_g_of_type_AndroidWidgetImageView.setRotation(30.0F);
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367074));
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131367064));
    this.jdField_b_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131367062));
    this.jdField_c_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131367037));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367053));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367058));
    j();
    localObject = AnimationUtils.loadAnimation(this, 2131034277);
    this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = AnimationUtils.loadAnimation(this, 2131034278);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    ThreadManager.getUIHandler().postDelayed(new ljb(this), 250L);
  }
  
  protected void a(int paramInt)
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
    l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = l1 - this.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onDeliver!Time now=" + l1 + ", last=" + this.jdField_b_of_type_Long + ", diff=" + l2);
    }
    if (l2 <= 2000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "deliver too fast(<=2000), return!");
      }
      return false;
    }
    if (!super.a()) {
      return false;
    }
    a(2131430109, 2131438891, this.n);
    Object localObject4 = new ArrayList();
    bool = a((ArrayList)localObject4);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder("onDeliver deliverList:\n");
      localObject3 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((StringBuilder)localObject1).append(((ReadInJoyBaseDeliverActivity.UserBiuInfo)((Iterator)localObject3).next()).toString()).append("\n");
      }
      QLog.d("biu_data_trace", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (this.m == 17))
    {
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_i_of_type_JavaLangString, this.m, ((ReadInJoyBaseDeliverActivity.UserBiuInfo)((ArrayList)localObject4).get(0)).jdField_b_of_type_JavaLangCharSequence.toString(), (ArrayList)localObject4);
      localObject4 = "";
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
        ((JSONObject)localObject1).put("kandian_mode", "" + ReadInJoyUtils.e());
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          continue;
        }
        ((JSONObject)localObject1).put("feeds_id", "" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
        localObject1 = ((JSONObject)localObject1).toString();
        localObject4 = localObject1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject5;
        Object localObject6;
        String str1;
        String str2;
        localJSONException.printStackTrace();
        continue;
        localObject3 = String.valueOf(this.jdField_a_of_type_Long);
        continue;
        if (!bool) {
          continue;
        }
        int i1 = 1;
        continue;
        i1 = 2;
        continue;
        continue;
        l1 = 0L;
        continue;
        Object localObject2 = null;
        continue;
        continue;
      }
      if (this.jdField_a_of_type_Long >= 0L) {
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
      PublicAccountReportUtils.a(null, "", "0X8007EE9", "0X8007EE9", 0, 0, String.valueOf(i1), (String)localObject3, (String)localObject1, (String)localObject4, false);
      return true;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (((ArrayList)localObject4).size() <= 0)) {
        break;
      }
      localObject5 = new SocializeFeedsInfo();
      localObject5.getClass();
      ((SocializeFeedsInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo((SocializeFeedsInfo)localObject5);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)
      {
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) {
          continue;
        }
        ((SocializeFeedsInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong;
        ((SocializeFeedsInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b;
        i1 = ((ArrayList)localObject4).size() - 1;
        if (i1 > 0)
        {
          localObject6 = (ReadInJoyBaseDeliverActivity.UserBiuInfo)((ArrayList)localObject4).get(i1);
          if ((((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject6).jdField_a_of_type_Long == 0L) || (((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject6).jdField_d_of_type_Int != 0)) {
            continue;
          }
          localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localObject1 = (SocializeFeedsInfo.BiuCommentInfo)((Iterator)localObject3).next();
          if (((SocializeFeedsInfo.BiuCommentInfo)localObject1).b.longValue() != ((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject6).jdField_a_of_type_Long) {
            continue;
          }
          if (localObject1 == null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo;
            localObject1.getClass();
            localObject3 = new SocializeFeedsInfo.BiuCommentInfo((SocializeFeedsInfo)localObject1);
            try
            {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject3).jdField_a_of_type_JavaLangLong = Long.valueOf(((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject6).jdField_a_of_type_JavaLangString);
              if (((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject6).jdField_b_of_type_JavaLangCharSequence == null)
              {
                localObject1 = "";
                ((SocializeFeedsInfo.BiuCommentInfo)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
                ((SocializeFeedsInfo.BiuCommentInfo)localObject3).jdField_c_of_type_Int = ((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject6).jdField_d_of_type_Int;
                ((SocializeFeedsInfo.BiuCommentInfo)localObject3).b = Long.valueOf(0L);
                localObject1 = localObject3;
                ((SocializeFeedsInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject1);
                i1 -= 1;
              }
            }
            catch (Exception localException1)
            {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject3).jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
              continue;
              str1 = ((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject6).jdField_b_of_type_JavaLangCharSequence.toString();
              continue;
            }
          }
          str1.jdField_a_of_type_JavaLangString = ((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject6).jdField_b_of_type_JavaLangCharSequence.toString();
          continue;
        }
        ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, ((SocializeFeedsInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo, l1, ((ReadInJoyBaseDeliverActivity.UserBiuInfo)((ArrayList)localObject4).get(0)).jdField_b_of_type_JavaLangCharSequence.toString(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq, this.m, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, this.k, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
        break;
      }
      i1 = ((ArrayList)localObject4).size() - 1;
      if (i1 <= 0) {
        continue;
      }
      localObject3 = (ReadInJoyBaseDeliverActivity.UserBiuInfo)((ArrayList)localObject4).get(i1);
      localObject5.getClass();
      localObject6 = new SocializeFeedsInfo.BiuCommentInfo((SocializeFeedsInfo)localObject5);
      try
      {
        ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_a_of_type_JavaLangLong = Long.valueOf(((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject3).jdField_a_of_type_JavaLangString);
        if (((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject3).jdField_b_of_type_JavaLangCharSequence == null)
        {
          str1 = "";
          ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_a_of_type_JavaLangString = str1;
          ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_c_of_type_Int = ((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject3).jdField_d_of_type_Int;
          ((SocializeFeedsInfo.BiuCommentInfo)localObject6).b = Long.valueOf(0L);
          ((SocializeFeedsInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject6);
          i1 -= 1;
        }
      }
      catch (Exception localException2)
      {
        ((SocializeFeedsInfo.BiuCommentInfo)localObject6).jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
        continue;
        str2 = ((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject3).jdField_b_of_type_JavaLangCharSequence.toString();
        continue;
      }
      str2.put("feeds_id", "0");
    }
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_JavaLangString = "：";
    this.jdField_b_of_type_JavaLangString = "0X800865F";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(getResources().getDrawable(2130845490));
    Object localObject1 = getIntent();
    this.jdField_j_of_type_Int = ((Intent)localObject1).getIntExtra("arg_from_type", 0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Intent)localObject1).getParcelableExtra("arg_article_info"));
    this.m = ((Intent)localObject1).getIntExtra("biu_src", 1);
    this.jdField_i_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("biu_rowkey");
    this.k = ((Intent)localObject1).getIntExtra("feedsType", 1);
    label270:
    label325:
    Object localObject4;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      this.jdField_i_of_type_Int = ((Intent)localObject1).getIntExtra("arg_type", -1);
      int i1;
      if (this.jdField_i_of_type_Int == -1)
      {
        this.jdField_i_of_type_Int = 1;
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          this.jdField_i_of_type_Int = 2;
        }
      }
      else
      {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
        if ((!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ReadInJoyBaseAdapter.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label735;
        }
        if (ReadInJoyBaseAdapter.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          break label715;
        }
        this.jdField_d_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_e_of_type_JavaLangString;
        p();
        if ((!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ReadInJoyBaseAdapter.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label860;
        }
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long;
        if (l1 != 0L) {
          break label849;
        }
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
        if ((!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ReadInJoyBaseAdapter.m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break label1067;
        }
        i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int;
        if ((ReadInJoyBaseAdapter.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (!a(i1))) {
          break label1011;
        }
        this.jdField_g_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_d_of_type_JavaLangString;
        label403:
        if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          break label1131;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        label422:
        if (this.jdField_i_of_type_Int == 2) {
          if ((!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (ReadInJoyBaseAdapter.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
            break label1167;
          }
        }
      }
      label1167:
      for (long l1 = ((SocializeFeedsInfo.UGCVideoInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_a_of_type_Long / 1000L;; l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mVideoDuration)
      {
        for (;;)
        {
          this.jdField_h_of_type_JavaLangString = String.format("%02d:%02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) });
          if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
          }
          Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo;
          if (localObject2 == null) {
            break label1282;
          }
          if (((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) {
            break label1179;
          }
          i1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.size() - 1;
          while (i1 >= 0)
          {
            localObject4 = (SocializeFeedsInfo.BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.get(i1);
            localObject4 = new ReadInJoyBaseDeliverActivity.UserBiuInfo(this, String.valueOf(((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_a_of_type_JavaLangLong), ((SocializeFeedsInfo.BiuCommentInfo)localObject4).b.longValue(), ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_a_of_type_JavaLangString, ((SocializeFeedsInfo.BiuCommentInfo)localObject4).jdField_c_of_type_Int);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
            i1 -= 1;
          }
          if ((!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
            break;
          }
          if (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int))
          {
            this.jdField_i_of_type_Int = 2;
            break;
          }
          this.jdField_i_of_type_Int = 1;
          break;
          label715:
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString;
          break label270;
          label735:
          if (ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
          {
            if (!ReadInJoyBaseAdapter.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
            {
              localObject2 = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
              this.jdField_d_of_type_JavaLangString = (((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_c_of_type_JavaLangString + ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_a_of_type_JavaLangString);
              break label270;
            }
            this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
            break label270;
          }
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
          this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary;
          break label270;
          label849:
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(l1);
          break label325;
          label860:
          if ((ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_Long != 0L))
          {
            this.jdField_f_of_type_JavaLangString = ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_Long), true);
            if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_f_of_type_JavaLangString);
              break label325;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
            break label325;
          }
          this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
          if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_f_of_type_JavaLangString);
            break label325;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setVisibility(8);
          break label325;
          label1011:
          if ((!ReadInJoyBaseAdapter.n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (b(i1)))
          {
            this.jdField_g_of_type_JavaLangString = ((SocializeFeedsInfo.UGCPicInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_JavaLangString;
            break label403;
          }
          this.jdField_g_of_type_JavaLangString = null;
          break label403;
          label1067:
          if ((ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
          {
            this.jdField_g_of_type_JavaLangString = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString;
            break label403;
          }
          this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
          break label403;
          try
          {
            label1131:
            localObject2 = new URL(this.jdField_g_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a((URL)localObject2);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        break label422;
      }
      label1179:
      if ((!ReadInJoyBaseAdapter.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyBaseAdapter.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyUtils.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyUtils.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (!ReadInJoyUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new ReadInJoyBaseDeliverActivity.UserBiuInfo(this, String.valueOf(localException2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), 0L, localException2.jdField_a_of_type_JavaLangString));
      }
    }
    label1282:
    Object localObject3;
    if ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (this.m == 17))
    {
      String str = ((Intent)localObject1).getStringExtra("arg_title");
      localObject4 = ((Intent)localObject1).getStringExtra("arg_src");
      localObject3 = ((Intent)localObject1).getStringExtra("arg_cover");
      localObject1 = str;
      if (TextUtils.isEmpty(str)) {
        localObject1 = this.jdField_d_of_type_JavaLangString;
      }
      this.jdField_d_of_type_JavaLangString = ((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1529;
      }
      localObject1 = this.jdField_e_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = ((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label1536;
      }
      localObject1 = this.jdField_g_of_type_JavaLangString;
      label1389:
      this.jdField_g_of_type_JavaLangString = ((String)localObject1);
      localObject3 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label1543;
      }
      localObject1 = "";
      label1413:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label1552;
      }
      localObject1 = "";
      label1438:
      ((ReadInJoyNickNameTextView)localObject3).setText((CharSequence)localObject1);
      if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        break label1561;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    }
    label1536:
    label1543:
    label1552:
    label1561:
    for (;;)
    {
      label1464:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder("initData mUserBiuInfoList:\n");
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1597;
            }
            ((StringBuilder)localObject1).append(((ReadInJoyBaseDeliverActivity.UserBiuInfo)((Iterator)localObject3).next()).toString()).append("\n");
            continue;
            label1529:
            localObject1 = localObject4;
            break;
            localObject1 = localObject3;
            break label1389;
            localObject1 = this.jdField_d_of_type_JavaLangString;
            break label1413;
            localObject1 = this.jdField_e_of_type_JavaLangString;
            break label1438;
            try
            {
              localObject1 = new URL(this.jdField_g_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a((URL)localObject1);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
          break label1464;
        }
        label1597:
        QLog.d("biu_data_trace", 2, localException1.toString());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          QLog.d("biu_data_trace", 2, "initData mFromType:" + this.jdField_j_of_type_Int + ",biuSrc:" + this.m + ",feedstype:" + this.k + ",mArticleID:" + this.jdField_a_of_type_Long + ",mTitle" + this.jdField_d_of_type_JavaLangString + ",FeedId:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId + ",innerUniqueID" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        }
      }
    }
    if (ReadInJoyHelper.r(this.app) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      m();
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_h_of_type_Int = this.jdField_a_of_type_Int;
    b(0);
    super.a(true, paramInt, false, 0L);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    f(false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969592);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(2131438885);
    a();
    b();
    Object localObject = "";
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
        paramBundle.put("kandian_mode", "" + ReadInJoyUtils.e());
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (!a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
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
        String str1 = String.valueOf(this.jdField_a_of_type_Long);
        continue;
        continue;
      }
      if (this.jdField_a_of_type_Long >= 0L) {
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
      PublicAccountReportUtils.a(null, "", "0X8007EE7", "0X8007EE7", 0, 0, String.valueOf(this.jdField_j_of_type_Int), str1, paramBundle, (String)localObject, false);
      return true;
      paramBundle.put("feeds_id", "0");
    }
  }
  
  protected void doOnDestroy()
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
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (isInMultiWindow())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
    }
  }
  
  protected void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onEmotionBtn!");
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
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
    PublicAccountReportUtils.a(null, "", "0X8007EE8", "0X8007EE8", 0, 0, "", "", "", (String)localObject1, false);
    super.f();
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    ActivityLeakSolution.a(this);
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2131034279);
    localAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(this, 2131034280);
    localAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    ThreadManager.getUIHandler().postDelayed(new ljd(this), 300L);
  }
  
  public void i()
  {
    if (this.app == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "getGuideFriends");
    SSOBiuGuide.ReqBody localReqBody = new SSOBiuGuide.ReqBody();
    localReqBody.uint32_want_count.set(10);
    localReqBody.uint64_uin.set(ReadInJoyUtils.a());
    localNewIntent.putExtra("data", localReqBody.toByteArray());
    PublicAccountServlet.a(localNewIntent);
    this.app.startServlet(localNewIntent);
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_b_of_type_Boolean) && ((!this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Int != -1)))
    {
      c(this.q);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity
 * JD-Core Version:    0.7.0.1
 */