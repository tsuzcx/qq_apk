package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;

public class UtilsForComponent
{
  public static int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    label84:
    do
    {
      do
      {
        do
        {
          return 0;
          if ((paramArticleInfo.mPackInfoObj == null) || (!paramArticleInfo.mPackInfoObj.pack_type.has())) {
            break label84;
          }
          if (paramArticleInfo.mPackInfoObj.pack_type.get() != 2) {
            break;
          }
        } while (!paramArticleInfo.mPackInfoObj.msg_special_topic_info.has());
        return 1;
      } while ((paramArticleInfo.mPackInfoObj.pack_type.get() != 3) || (!paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()));
      return 2;
    } while ((paramArticleInfo.mSubscribeInfoObj == null) || (!paramArticleInfo.mSubscribeInfoObj.uint32_is_subscribed.has()) || (paramArticleInfo.mSubscribeInfoObj.uint32_is_subscribed.get() != 1));
    return 3;
  }
  
  public static Pair<Integer, Integer> a()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.562F)));
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt / 3600;
    int j = (paramInt - i * 60) / 60;
    paramInt %= 60;
    String str1;
    String str2;
    if (j >= 10)
    {
      str1 = String.valueOf(j);
      if (paramInt < 10) {
        break label104;
      }
      str2 = String.valueOf(paramInt);
      label44:
      if (i <= 0) {
        break label146;
      }
      if (i < 10) {
        break label125;
      }
    }
    label104:
    label125:
    for (String str3 = String.valueOf(i);; str3 = String.format("0%d", new Object[] { Integer.valueOf(i) }))
    {
      return String.format("%s:%s:%s", new Object[] { str3, str1, str2 });
      str1 = String.format("0%d", new Object[] { Integer.valueOf(j) });
      break;
      str2 = String.format("0%d", new Object[] { Integer.valueOf(paramInt) });
      break label44;
    }
    label146:
    return String.format("%s:%s", new Object[] { str1, str2 });
  }
  
  public static void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramContext, paramIReadInJoyModel, paramLayoutParams, null);
  }
  
  public static void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, ViewGroup.LayoutParams paramLayoutParams, View paramView)
  {
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if (localArticleInfo == null)
    {
      QLog.d("UtilsForComponent", 1, "configDividerHeight failed, articleInfo is null.");
      return;
    }
    paramLayoutParams.height = paramContext.getResources().getDimensionPixelSize(2131298824);
    int i = paramIReadInJoyModel.a();
    int j = paramIReadInJoyModel.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    if (paramIReadInJoyModel.e() == 56)
    {
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    if ((i == 29) || (i == 30) || (j == 29) || (j == 30))
    {
      paramLayoutParams.height = Utils.dp2px(5.0D);
      return;
    }
    if (i == 53)
    {
      paramLayoutParams.height = Utils.dp2px(0.5D);
      return;
    }
    if ((localArticleInfo.mChannelID == 0L) && ((i == 6) || (i == 128) || (i == 46))) {
      if (i == 6) {
        i = Utils.dp2px(13.0D);
      }
    }
    for (;;)
    {
      if ((paramLayoutParams instanceof LinearLayout.LayoutParams))
      {
        ((LinearLayout.LayoutParams)paramLayoutParams).topMargin = i;
        ((LinearLayout.LayoutParams)paramLayoutParams).leftMargin = Utils.dp2px(6.0D);
        ((LinearLayout.LayoutParams)paramLayoutParams).rightMargin = Utils.dp2px(6.0D);
      }
      paramLayoutParams.height = Utils.dp2px(0.5D);
      paramView.setBackgroundColor(Color.parseColor("#e5e5e5"));
      return;
      if (i == 46)
      {
        i = Utils.dp2px(8.0D);
      }
      else if (i == 128)
      {
        i = Utils.dp2px(0.0D);
        continue;
        if (ProteusSupportUtil.a(i, j, paramIReadInJoyModel.a()))
        {
          paramLayoutParams.height = Utils.dp2px(5.0D);
          return;
        }
        paramLayoutParams.height = Utils.dp2px(5.0D);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView)
  {
    paramContext = a();
    int i = ((Integer)paramContext.first).intValue();
    int j = ((Integer)paramContext.second).intValue();
    paramContext = paramKandianUrlImageView.getLayoutParams();
    paramContext.width = i;
    paramContext.height = j;
    paramKandianUrlImageView.setLayoutParams(paramContext);
    paramKandianUrlImageView.setPadding(0, 0, 0, 0);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, double paramDouble)
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = (int)(i / paramDouble);
    paramContext = new RelativeLayout.LayoutParams(i, j);
    paramContext.width = i;
    paramContext.height = j;
    paramContext.setMargins(0, 0, 0, 0);
    paramKandianUrlImageView.setLayoutParams(paramContext);
    paramKandianUrlImageView.setPadding(0, 0, 0, 0);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, boolean paramBoolean)
  {
    paramContext = b();
    int i = ((Integer)paramContext.first).intValue();
    int j = ((Integer)paramContext.second).intValue();
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    paramContext = localLayoutParams;
    if (localLayoutParams == null) {
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (paramContext = new LinearLayout.LayoutParams(i, j);; paramContext = new RelativeLayout.LayoutParams(i, j))
    {
      paramContext.width = i;
      paramContext.height = j;
      paramKandianUrlImageView.setLayoutParams(paramContext);
      paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
  }
  
  public static void a(IReadInJoyModel paramIReadInJoyModel, RingAvatarView paramRingAvatarView, ImageView paramImageView)
  {
    if ((paramRingAvatarView == null) || (paramImageView == null) || (paramIReadInJoyModel == null)) {}
    do
    {
      return;
      paramIReadInJoyModel = paramIReadInJoyModel.a();
    } while ((paramIReadInJoyModel == null) || (paramIReadInJoyModel.mSocialFeedInfo == null) || (paramIReadInJoyModel.mSocialFeedInfo.a == null));
    if (paramIReadInJoyModel.mSocialFeedInfo.a.a())
    {
      paramRingAvatarView.showStarRing();
      paramImageView.setVisibility(0);
      return;
    }
    paramRingAvatarView.showNormal();
    paramImageView.setVisibility(8);
  }
  
  public static void a(SocializeFeedsInfo.UGCFeedsInfo paramUGCFeedsInfo, ReadInJoyYAFolderTextView paramReadInJoyYAFolderTextView, CmpCtxt paramCmpCtxt, SpannableStringBuilder paramSpannableStringBuilder)
  {
    SpannableStringBuilder localSpannableStringBuilder = paramSpannableStringBuilder;
    if (paramSpannableStringBuilder == null) {
      localSpannableStringBuilder = new SpannableStringBuilder();
    }
    if (RIJFeedsType.a(paramUGCFeedsInfo))
    {
      List localList = paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = new ArrayList();
      int i = localList.size();
      paramSpannableStringBuilder = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).mBiuComment;
      int j;
      label130:
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
      long l;
      if ((!TextUtils.isEmpty(paramSpannableStringBuilder)) && ((paramSpannableStringBuilder.startsWith(":")) || (paramSpannableStringBuilder.startsWith("："))))
      {
        paramUGCFeedsInfo = paramSpannableStringBuilder.substring(1);
        localStringBuilder.append(paramUGCFeedsInfo);
        j = localStringBuilder.length();
        i -= 2;
        if (i < 0) {
          break label329;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.mUin.longValue();
        paramUGCFeedsInfo = ContactUtils.c((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l), true);
        paramSpannableStringBuilder = "@" + paramUGCFeedsInfo;
        paramUGCFeedsInfo = paramSpannableStringBuilder;
        if (localBiuCommentInfo.mOpType == 1) {
          paramUGCFeedsInfo = paramSpannableStringBuilder + " ";
        }
        if (localBiuCommentInfo.mBiuComment != null) {
          break label320;
        }
      }
      label320:
      for (paramSpannableStringBuilder = "";; paramSpannableStringBuilder = localBiuCommentInfo.mBiuComment)
      {
        localStringBuilder.append(paramUGCFeedsInfo).append(paramSpannableStringBuilder);
        paramSpannableStringBuilder = new ComponentHeaderNewSocial.BiuUserStruct();
        paramSpannableStringBuilder.jdField_a_of_type_Int = j;
        paramSpannableStringBuilder.b = (paramUGCFeedsInfo.length() + j);
        paramSpannableStringBuilder.jdField_a_of_type_Long = l;
        ((List)localObject).add(paramSpannableStringBuilder);
        j = localStringBuilder.length();
        i -= 1;
        break label130;
        paramUGCFeedsInfo = paramSpannableStringBuilder;
        if (paramSpannableStringBuilder != null) {
          break;
        }
        paramUGCFeedsInfo = "";
        break;
      }
      label329:
      paramUGCFeedsInfo = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      paramSpannableStringBuilder = ((List)localObject).iterator();
      while (paramSpannableStringBuilder.hasNext())
      {
        localObject = (ComponentHeaderNewSocial.BiuUserStruct)paramSpannableStringBuilder.next();
        paramUGCFeedsInfo.setSpan(new CommonBasicComponent.UserSpan(((ComponentHeaderNewSocial.BiuUserStruct)localObject).jdField_a_of_type_Long, -3355444, paramCmpCtxt), ((ComponentHeaderNewSocial.BiuUserStruct)localObject).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.BiuUserStruct)localObject).b, 17);
      }
      localSpannableStringBuilder.append(paramUGCFeedsInfo);
    }
    for (;;)
    {
      paramReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
      return;
      if (!TextUtils.isEmpty(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString)) {
        try
        {
          localSpannableStringBuilder.append(new QQText(EmotionCodecUtils.b(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString), 7, 16));
        }
        catch (Exception paramUGCFeedsInfo)
        {
          QLog.d("UtilsForComponent", 1, "parse bytes_comments failed ", paramUGCFeedsInfo);
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 5) || (paramInt == 7);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    if (paramArticleInfo == null) {
      return false;
    }
    if (paramArticleInfo.mFeedType == 1)
    {
      bool1 = bool2;
      if (!RIJItemViewType.i(paramArticleInfo)) {
        if (!RIJItemViewType.k(paramArticleInfo)) {
          break label36;
        }
      }
    }
    label36:
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static Pair<Integer, Integer> b()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - AIOUtils.a(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131298830)));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 27) || (paramInt == 28) || (paramInt == 33) || (paramInt == 35) || (paramInt == 43) || (paramInt == 44) || (paramInt == 45) || (paramInt == 49) || (paramInt == 62) || (paramInt == 63) || (paramInt == 94) || (paramInt == 95) || (paramInt == 112) || (paramInt == 113) || (paramInt == 114);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return (RIJItemViewType.b(paramArticleInfo) == 23) || (RIJItemViewType.c(paramArticleInfo) == 56);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 22) || (paramInt == 21) || (paramInt == 23) || (paramInt == 107) || (paramInt == 108) || (paramInt == 54) || (paramInt == 55) || (paramInt == 56);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent
 * JD-Core Version:    0.7.0.1
 */