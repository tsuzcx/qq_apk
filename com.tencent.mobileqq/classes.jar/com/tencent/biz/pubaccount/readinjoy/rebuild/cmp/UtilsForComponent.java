package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FriendRecommendInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SpecialTopicInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SubscribeInfo;

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
  
  public static Pair a()
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
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if (localArticleInfo == null)
    {
      QLog.d("UtilsForComponent", 1, "configDividerHeight failed, articleInfo is null.");
      return;
    }
    paramLayoutParams.height = paramContext.getResources().getDimensionPixelSize(2131559659);
    int i = paramIReadInJoyModel.a();
    int j = paramIReadInJoyModel.b();
    if (localArticleInfo.mChannelID == 70L)
    {
      paramLayoutParams.height = Utils.b(10.0D);
      return;
    }
    if (paramIReadInJoyModel.e() == 56)
    {
      paramLayoutParams.height = Utils.b(5.0D);
      return;
    }
    if ((i == 29) || (i == 30) || (j == 29) || (j == 30))
    {
      paramLayoutParams.height = Utils.b(5.0D);
      return;
    }
    if (ProteusSupportUtil.a(i, j))
    {
      paramLayoutParams.height = Utils.b(5.0D);
      return;
    }
    paramLayoutParams.height = Utils.b(5.0D);
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
  
  public static void a(SocializeFeedsInfo.UGCFeedsInfo paramUGCFeedsInfo, ReadInJoyYAFolderTextView paramReadInJoyYAFolderTextView, CmpCtxt paramCmpCtxt, SpannableStringBuilder paramSpannableStringBuilder)
  {
    SpannableStringBuilder localSpannableStringBuilder = paramSpannableStringBuilder;
    if (paramSpannableStringBuilder == null) {
      localSpannableStringBuilder = new SpannableStringBuilder();
    }
    if (ReadInJoyUtils.a(paramUGCFeedsInfo))
    {
      List localList = paramUGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = new ArrayList();
      int i = localList.size();
      paramSpannableStringBuilder = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).jdField_a_of_type_JavaLangString;
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
        l = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
        paramUGCFeedsInfo = ContactUtils.b((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l), true);
        paramSpannableStringBuilder = "@" + paramUGCFeedsInfo;
        paramUGCFeedsInfo = paramSpannableStringBuilder;
        if (localBiuCommentInfo.c == 1) {
          paramUGCFeedsInfo = paramSpannableStringBuilder + " ";
        }
        if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
          break label320;
        }
      }
      label320:
      for (paramSpannableStringBuilder = "";; paramSpannableStringBuilder = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
      {
        localStringBuilder.append(paramUGCFeedsInfo).append(paramSpannableStringBuilder);
        paramSpannableStringBuilder = new ComponentHeaderNewSocial.biuUserStruct();
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
        localObject = (ComponentHeaderNewSocial.biuUserStruct)paramSpannableStringBuilder.next();
        paramUGCFeedsInfo.setSpan(new CommonBasicComponent.UserSpan(((ComponentHeaderNewSocial.biuUserStruct)localObject).jdField_a_of_type_Long, -3355444, paramCmpCtxt), ((ComponentHeaderNewSocial.biuUserStruct)localObject).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.biuUserStruct)localObject).b, 17);
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
          localSpannableStringBuilder.append(new QQText(MessageUtils.b(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString), 7, 16));
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
      if (!ReadInJoyBaseAdapter.g(paramArticleInfo)) {
        if (!ReadInJoyBaseAdapter.i(paramArticleInfo)) {
          break label36;
        }
      }
    }
    label36:
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static Pair b()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - AIOUtils.a(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131559668)));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 27) || (paramInt == 28) || (paramInt == 33) || (paramInt == 35) || (paramInt == 43) || (paramInt == 44) || (paramInt == 45) || (paramInt == 49) || (paramInt == 62) || (paramInt == 63);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return (ReadInJoyBaseAdapter.a(paramArticleInfo) == 23) || (ReadInJoyBaseAdapter.b(paramArticleInfo) == 56);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 22) || (paramInt == 21) || (paramInt == 23) || (paramInt == 54) || (paramInt == 55) || (paramInt == 56);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent
 * JD-Core Version:    0.7.0.1
 */