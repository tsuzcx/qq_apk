package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import bblk;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oju;
import psy;
import pwf;
import rec;
import red;
import ree;
import ref;
import reg;
import reh;
import rei;
import rej;
import rek;
import rel;
import rep;
import req;
import rer;
import ret;
import reu;
import rew;
import rex;
import rey;
import rfe;
import rfh;
import rfi;
import rfj;
import rfn;
import rga;
import rgc;
import tal;
import tan;
import tas;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsExtInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.WendaInfo;
import tencent.im.oidb.articlesummary.feeds_info.IconWordingInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfoUser;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendInfo;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo;

public class SocializeFeedsInfo
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public List<rer> a;
  public oju a;
  public rep a;
  public req a;
  public rer a;
  public ret a;
  public reu a;
  public rew a;
  public rex a;
  public rey a;
  public rfe a;
  public rfh a;
  public rfi a;
  public rfj a;
  public rfn a;
  public rga a;
  public articlesummary.ColumnTopicInfo a;
  public articlesummary.TopicEntranceInfo a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  
  public SocializeFeedsInfo()
  {
    this.jdField_a_of_type_Rer = new rer(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public static SpannableStringBuilder a(int paramInt, ArticleInfo paramArticleInfo, String paramString, pwf parampwf, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramList.size();
    String str1 = ((SocializeFeedsInfo.BiuCommentInfo)paramList.get(m - 1)).jdField_a_of_type_JavaLangString;
    Object localObject;
    int n;
    ArrayList localArrayList;
    label103:
    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
    long l1;
    if ((!TextUtils.isEmpty(str1)) && ((str1.startsWith(":")) || (str1.startsWith("："))))
    {
      localObject = str1.substring(1);
      localStringBuilder.append((String)localObject);
      n = localStringBuilder.length();
      localArrayList = new ArrayList();
      m -= 2;
      if (m < 0) {
        break label449;
      }
      localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramList.get(m);
      switch (localBiuCommentInfo.jdField_c_of_type_Int)
      {
      default: 
        l1 = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
        localObject = ReadInJoyUserInfoModule.a(l1, parampwf);
        if (localObject != null)
        {
          localObject = ((ReadInJoyUserInfo)localObject).nick;
          label178:
          str1 = "@" + (String)localObject;
          localObject = str1;
          if (localBiuCommentInfo.jdField_c_of_type_Int == 1) {
            localObject = str1 + " ";
          }
          if (localBiuCommentInfo.jdField_a_of_type_JavaLangString != null) {
            break label439;
          }
        }
        break;
      }
    }
    label439:
    for (str1 = "";; str1 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
    {
      localStringBuilder.append((String)localObject).append(str1);
      localArrayList.add(new tan(n, n + ((String)localObject).length(), new tas(l1, paramString, paramArticleInfo, paramInt)));
      do
      {
        n = localStringBuilder.length();
        m -= 1;
        break label103;
        localObject = str1;
        if (str1 != null) {
          break;
        }
        localObject = "";
        break;
      } while (localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo == null);
      str1 = localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.a();
      String str2 = localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo.b();
      if (localBiuCommentInfo.jdField_a_of_type_JavaLangString == null) {}
      for (localObject = "";; localObject = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
      {
        localStringBuilder.append(str1).append((String)localObject);
        localArrayList.add(new tan(n, str1.length() + n, new tal(str2, 13421772)));
        break;
      }
      localObject = ReadInJoyUserInfoModule.a();
      break label178;
    }
    label449:
    paramArticleInfo = new SpannableStringBuilder(new QQText(localStringBuilder, 3, 16));
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      parampwf = (tan)paramString.next();
      paramArticleInfo.setSpan(parampwf.a(), parampwf.a(), parampwf.b(), 17);
    }
    return paramArticleInfo;
  }
  
  public static SpannableStringBuilder a(ArticleInfo paramArticleInfo, String paramString, pwf parampwf, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    return a(-15504151, paramArticleInfo, paramString, parampwf, paramList);
  }
  
  public static SocializeFeedsInfo.BiuCommentInfo a(articlesummary.BiuOneLevelItem paramBiuOneLevelItem)
  {
    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
    localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(psy.a(paramBiuOneLevelItem.uint64_uin));
    localBiuCommentInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(psy.a(paramBiuOneLevelItem.uint64_feeds_id));
    localBiuCommentInfo.jdField_a_of_type_Int = psy.a(paramBiuOneLevelItem.uint32_biu_time);
    localBiuCommentInfo.jdField_b_of_type_Int = psy.a(paramBiuOneLevelItem.feeds_type);
    localBiuCommentInfo.jdField_c_of_type_Int = psy.a(paramBiuOneLevelItem.op_type);
    if ((paramBiuOneLevelItem.bytes_biu_comments.has()) && (paramBiuOneLevelItem.bytes_biu_comments.get() != null)) {}
    try
    {
      String str = new String(paramBiuOneLevelItem.bytes_biu_comments.get().toByteArray(), "utf-8");
      localBiuCommentInfo.jdField_b_of_type_JavaLangString = str;
      localBiuCommentInfo.jdField_a_of_type_JavaLangString = bblk.b(str);
      if ((paramBiuOneLevelItem.msg_jump_info.has()) && (paramBiuOneLevelItem.msg_jump_info.get() != null))
      {
        paramBiuOneLevelItem = (articlesummary.JumpInfo)paramBiuOneLevelItem.msg_jump_info.get();
        localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(psy.a(paramBiuOneLevelItem.uint64_id), paramBiuOneLevelItem.bytes_wording.get().toStringUtf8(), paramBiuOneLevelItem.bytes_jump_url.get().toStringUtf8());
      }
      return localBiuCommentInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("SocializeFeedsInfo", 1, "parse bytes_biu_comment failed ", localException);
      }
    }
  }
  
  public static SocializeFeedsInfo a(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null)
    {
      QLog.d("SocializeFeedsInfo", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.jdField_a_of_type_Long = psy.a(paramSocializeFeedsInfo.uint64_feeds_id);
    rer.a(localSocializeFeedsInfo.jdField_a_of_type_Rer, paramSocializeFeedsInfo);
    localSocializeFeedsInfo.jdField_a_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_feeds_style);
    localSocializeFeedsInfo.jdField_b_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_like_count);
    localSocializeFeedsInfo.jdField_d_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_comments_count);
    localSocializeFeedsInfo.jdField_e_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_biu_time);
    localSocializeFeedsInfo.jdField_c_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_myself_like_status);
    localSocializeFeedsInfo.i = psy.a(paramSocializeFeedsInfo.uint32_follow_counts);
    localSocializeFeedsInfo.h = psy.a(paramSocializeFeedsInfo.uint32_follow_status);
    localSocializeFeedsInfo.jdField_a_of_type_Rfi = rfi.a((feeds_info.ShareWebPageInfo)paramSocializeFeedsInfo.share_web_page_info.get());
    QLog.d("SocializeFeedsInfo", 1, "create SocialFeedsInfo, feedsID : " + localSocializeFeedsInfo.jdField_a_of_type_Long + ", followCnt : " + localSocializeFeedsInfo.i + ", followStatus : " + localSocializeFeedsInfo.h + ", masterUin : " + localSocializeFeedsInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long + ", followStatusHas : " + paramSocializeFeedsInfo.uint32_follow_status.has());
    Object localObject;
    if ((paramSocializeFeedsInfo.rpt_recommend_list.has()) && (paramSocializeFeedsInfo.rpt_recommend_list.get() != null))
    {
      localObject = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      if (((Iterator)localObject).hasNext())
      {
        articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = (articlesummary.SocializeFeedsInfoUser)((Iterator)localObject).next();
        localSocializeFeedsInfo.getClass();
        rer localrer = new rer(localSocializeFeedsInfo);
        long l1;
        if ((localSocializeFeedsInfoUser.has()) && (localSocializeFeedsInfoUser.get() != null))
        {
          l1 = psy.a(localSocializeFeedsInfoUser.uint64_uin);
          label338:
          localrer.jdField_a_of_type_Long = l1;
          if ((!localSocializeFeedsInfoUser.has()) || (localSocializeFeedsInfoUser.get() == null)) {
            break label396;
          }
        }
        label396:
        for (int m = psy.a(localSocializeFeedsInfoUser.enum_uin_type);; m = 0)
        {
          localrer.jdField_a_of_type_Int = m;
          localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localrer);
          break;
          l1 = 0L;
          break label338;
        }
      }
    }
    if ((paramSocializeFeedsInfo.bytes_comments.has()) && (paramSocializeFeedsInfo.bytes_comments.get() != null)) {}
    try
    {
      localObject = new String(paramSocializeFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      localSocializeFeedsInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
      localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = bblk.b((String)localObject);
      if ((!paramSocializeFeedsInfo.bytes_recommend_reason.has()) || (paramSocializeFeedsInfo.bytes_recommend_reason.get() == null)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        localSocializeFeedsInfo.jdField_c_of_type_JavaLangString = new String(paramSocializeFeedsInfo.bytes_recommend_reason.get().toByteArray(), "utf-8");
        if ((paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.has()) && (paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.get() != null)) {
          localSocializeFeedsInfo.jdField_a_of_type_ArrayOfByte = ((articlesummary.SocializeFeedsExtInfo)paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.get()).toByteArray();
        }
        localSocializeFeedsInfo.jdField_f_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_biu_count);
        localSocializeFeedsInfo.jdField_g_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_myself_biu_status);
        localSocializeFeedsInfo.jdField_a_of_type_Rep = ((rep)psy.a(paramSocializeFeedsInfo.msg_biu_mutli_level, localSocializeFeedsInfo.jdField_a_of_type_Rep, new rec(localSocializeFeedsInfo)));
        localSocializeFeedsInfo.jdField_a_of_type_Ret = ((ret)psy.a(paramSocializeFeedsInfo.game_live_info, localSocializeFeedsInfo.jdField_a_of_type_Ret, new ree()));
        localSocializeFeedsInfo.jdField_b_of_type_Long = psy.a(paramSocializeFeedsInfo.uint64_article_id, localSocializeFeedsInfo.jdField_b_of_type_Long);
        localSocializeFeedsInfo.jdField_a_of_type_Rfj = ((rfj)psy.a(paramSocializeFeedsInfo.msg_ugc_topic_feeds_info, localSocializeFeedsInfo.jdField_a_of_type_Rfj, new ref(localSocializeFeedsInfo)));
        localSocializeFeedsInfo.jdField_a_of_type_Rfe = ((rfe)psy.a(paramSocializeFeedsInfo.msg_pgc_topic_feeds_info, localSocializeFeedsInfo.jdField_a_of_type_Rfe, new reg()));
        if (paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has())
        {
          localSocializeFeedsInfo.jdField_a_of_type_Rga = rga.a((articlesummary.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get());
          QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.topicRecommendFeedsInfo = ", localSocializeFeedsInfo.jdField_a_of_type_Rga });
        }
        if (paramSocializeFeedsInfo.bytes_recommend_account_reason.has())
        {
          localSocializeFeedsInfo.jdField_d_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_recommend_account_reason.get().toStringUtf8();
          QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.mRecommendAccountReason = ", localSocializeFeedsInfo.jdField_d_of_type_JavaLangString });
        }
        localSocializeFeedsInfo.jdField_a_of_type_Rfn = ((rfn)psy.a(paramSocializeFeedsInfo.wenda_info, localSocializeFeedsInfo.jdField_a_of_type_Rfn, new reh()));
        localSocializeFeedsInfo.j = psy.a(paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted);
        localSocializeFeedsInfo.jdField_a_of_type_Reu = ((reu)psy.a(paramSocializeFeedsInfo.icon_wording_info, localSocializeFeedsInfo.jdField_a_of_type_Reu, new rei()));
        localSocializeFeedsInfo.k = psy.a(paramSocializeFeedsInfo.uint32_feed_status, localSocializeFeedsInfo.k);
        localSocializeFeedsInfo.jdField_e_of_type_JavaLangString = psy.a(paramSocializeFeedsInfo.bytes_private_status_title, localSocializeFeedsInfo.jdField_e_of_type_JavaLangString);
        localSocializeFeedsInfo.jdField_a_of_type_Rew = ((rew)psy.a(paramSocializeFeedsInfo.location_info, localSocializeFeedsInfo.jdField_a_of_type_Rew, new rej()));
        if (paramSocializeFeedsInfo.uint32_is_jump_recommend_page.has())
        {
          localSocializeFeedsInfo.l = psy.a(paramSocializeFeedsInfo.uint32_is_jump_recommend_page);
          localSocializeFeedsInfo.jdField_f_of_type_JavaLangString = psy.a(paramSocializeFeedsInfo.bytes_jump_recommend_url, localSocializeFeedsInfo.jdField_f_of_type_JavaLangString);
          if (paramSocializeFeedsInfo.bytes_jump_recommend_prompt.has()) {
            localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_jump_recommend_prompt.get().toStringUtf8();
          }
          localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = psy.a(paramSocializeFeedsInfo.bytes_jump_recommend_prompt, localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
          QLog.d("SocializeFeedsInfo", 1, "parse jumpchannel " + localSocializeFeedsInfo.l + "  " + localSocializeFeedsInfo.jdField_f_of_type_JavaLangString + "  " + localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
        }
        if (paramSocializeFeedsInfo.visible_info.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Rfh = ((rfh)psy.a(paramSocializeFeedsInfo.visible_info.visible_show_info, localSocializeFeedsInfo.jdField_a_of_type_Rfh, new rek()));
        }
        if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.has())) {
          a(localSocializeFeedsInfo, ((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.get());
        }
        localSocializeFeedsInfo.jdField_a_of_type_Req = ((req)psy.a(paramSocializeFeedsInfo.buluo_info, localSocializeFeedsInfo.jdField_a_of_type_Req, new rel()));
        localSocializeFeedsInfo.jdField_a_of_type_Rex = ((rex)psy.a(paramSocializeFeedsInfo.long_content_info, localSocializeFeedsInfo.jdField_a_of_type_Rex, new red()));
        localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo = ((articlesummary.ColumnTopicInfo)psy.a(paramSocializeFeedsInfo.msg_column_topic_info, localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo));
        localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo = ((articlesummary.TopicEntranceInfo)psy.a(paramSocializeFeedsInfo.msg_topic_entrance_info, localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo));
        return localSocializeFeedsInfo;
        localException1 = localException1;
        QLog.d("SocializeFeedsInfo", 1, "parse bytes_comments failed ", localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.d("SocializeFeedsInfo", 1, "parse bytes_comments reason failed ", localException2);
        }
      }
    }
  }
  
  private static void a(SocializeFeedsInfo paramSocializeFeedsInfo, List<oidb_cmd0xb57.MedalInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      paramList = (oidb_cmd0xb57.MedalInfo)paramList.get(0);
      paramSocializeFeedsInfo.jdField_a_of_type_Oju = new oju();
      if (paramList.bytes_jump_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oju.jdField_c_of_type_JavaLangString = paramList.bytes_jump_url.get().toStringUtf8();
      }
      if (paramList.uint32_is_jump.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oju.jdField_b_of_type_Int = paramList.uint32_is_jump.get();
      }
      if (paramList.uint32_medal_type.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oju.jdField_a_of_type_Int = paramList.uint32_medal_type.get();
      }
      if (paramList.uint64_medal_id.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oju.jdField_a_of_type_Long = paramList.uint64_medal_id.get();
      }
      if (paramList.bytes_medal_name.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oju.jdField_a_of_type_JavaLangString = paramList.bytes_medal_name.get().toStringUtf8();
      }
      if (paramList.bytes_medal_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oju.jdField_b_of_type_JavaLangString = paramList.bytes_medal_url.get().toStringUtf8();
      }
      if (paramList.uint32_pic_width.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oju.jdField_c_of_type_Int = paramList.uint32_pic_width.get();
      }
    } while (!paramList.uint32_pic_height.has());
    paramSocializeFeedsInfo.jdField_a_of_type_Oju.jdField_d_of_type_Int = paramList.uint32_pic_height.get();
  }
  
  public SocializeFeedsInfo a()
  {
    try
    {
      localSocializeFeedsInfo1 = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo1.jdField_a_of_type_Rer = this.jdField_a_of_type_Rer.a();
        localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          rer localrer = (rer)localIterator.next();
          localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList.add(localrer.a());
        }
        QLog.d("SocializeFeedsInfo", 1, "clone SocializeFeedsInfo failed ", localCloneNotSupportedException1);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1) {}
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      for (;;)
      {
        SocializeFeedsInfo localSocializeFeedsInfo2;
        SocializeFeedsInfo localSocializeFeedsInfo1 = null;
      }
    }
    localSocializeFeedsInfo2 = localSocializeFeedsInfo1;
    do
    {
      return localSocializeFeedsInfo2;
      localSocializeFeedsInfo2 = localSocializeFeedsInfo1;
    } while (this.jdField_a_of_type_Rep == null);
    localSocializeFeedsInfo1.jdField_a_of_type_Rep = this.jdField_a_of_type_Rep.a();
    return localSocializeFeedsInfo1;
  }
  
  public rep a(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    rep localrep = new rep();
    localrep.jdField_a_of_type_JavaLangLong = Long.valueOf(psy.a(paramBiuMultiLevel.uint64_origin_feeds_id));
    localrep.jdField_b_of_type_JavaLangLong = Long.valueOf(psy.a(paramBiuMultiLevel.uint64_origin_feeds_type));
    if ((paramBiuMultiLevel.rpt_biu_mutli_level.has()) && (paramBiuMultiLevel.rpt_biu_mutli_level.get() != null))
    {
      paramBiuMultiLevel = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
      while (paramBiuMultiLevel.hasNext())
      {
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)paramBiuMultiLevel.next();
        localrep.jdField_a_of_type_JavaUtilList.add(a(localBiuOneLevelItem));
      }
    }
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "convertPb2BiuInfo, mFeedsId =  ", Long.valueOf(this.jdField_a_of_type_Long), ", mOriFeedType = ", localrep.jdField_b_of_type_JavaLangLong });
    return localrep;
  }
  
  public void a(oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null) {
      return;
    }
    this.jdField_b_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_like_count);
    this.jdField_d_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_comments_count);
    this.jdField_c_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_myself_like_status);
    this.jdField_f_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_biu_count);
    this.jdField_g_of_type_Int = psy.a(paramSocializeFeedsInfo.uint32_myself_biu_status);
    if (paramSocializeFeedsInfo.uint32_follow_count.has()) {
      this.i = psy.a(paramSocializeFeedsInfo.uint32_follow_count);
    }
    if (paramSocializeFeedsInfo.uint32_follow_status.has()) {
      this.h = psy.a(paramSocializeFeedsInfo.uint32_follow_status);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1;
    Object localObject2;
    if ((paramSocializeFeedsInfo.rpt_recommend_list.has()) && (paramSocializeFeedsInfo.rpt_recommend_list.get() != null))
    {
      localObject1 = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0x8c8.SocializeFeedsInfoUser)((Iterator)localObject1).next();
        rer localrer = new rer(this);
        if ((((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).has()) && (((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).get() != null)) {}
        for (long l1 = psy.a(((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).uint64_uin);; l1 = 0L)
        {
          localrer.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_JavaUtilList.add(localrer);
          break;
        }
      }
    }
    if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (this.jdField_a_of_type_Rga != null) && (this.jdField_a_of_type_Rga.a != null))
    {
      paramSocializeFeedsInfo = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
      if (paramSocializeFeedsInfo.msg_topic_recommend_info.has())
      {
        paramSocializeFeedsInfo = paramSocializeFeedsInfo.msg_topic_recommend_info.get();
        int m = 0;
        while ((m < paramSocializeFeedsInfo.size()) && (m < this.jdField_a_of_type_Rga.a.size()))
        {
          localObject1 = (oidb_cmd0x8c8.TopicRecommendInfo)paramSocializeFeedsInfo.get(m);
          localObject2 = (rgc)this.jdField_a_of_type_Rga.a.get(m);
          if (((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.has()) {
            ((rgc)localObject2).jdField_b_of_type_Int = ((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.get();
          }
          m += 1;
        }
      }
    }
    QLog.d("SocializeFeedsInfo", 2, "8c8 update followStatus : " + this.h + ", followCnt : " + this.h + ", feedsID : " + this.jdField_a_of_type_Long);
  }
  
  public boolean a()
  {
    return this.k == 1;
  }
  
  public byte[] a()
  {
    articlesummary.SocializeFeedsInfo localSocializeFeedsInfo = new articlesummary.SocializeFeedsInfo();
    localSocializeFeedsInfo.uint64_feeds_id.set(this.jdField_a_of_type_Long);
    localSocializeFeedsInfo.uint32_comments_count.set(this.jdField_d_of_type_Int);
    localSocializeFeedsInfo.uint32_biu_time.set(this.jdField_e_of_type_Int);
    localSocializeFeedsInfo.uint32_feeds_style.set(this.jdField_a_of_type_Int);
    localSocializeFeedsInfo.uint32_like_count.set(this.jdField_b_of_type_Int);
    localSocializeFeedsInfo.uint32_myself_like_status.set(this.jdField_c_of_type_Int);
    Object localObject1 = new articlesummary.SocializeFeedsInfoUser();
    ((articlesummary.SocializeFeedsInfoUser)localObject1).uint64_uin.set(this.jdField_a_of_type_Rer.jdField_a_of_type_Long);
    ((articlesummary.SocializeFeedsInfoUser)localObject1).enum_uin_type.set(this.jdField_a_of_type_Rer.jdField_a_of_type_Int);
    ((articlesummary.SocializeFeedsInfoUser)localObject1).uint32_star_style.set(this.jdField_a_of_type_Rer.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Rer.jdField_a_of_type_JavaLangString)) {
      ((articlesummary.SocializeFeedsInfoUser)localObject1).bytes_person_desc.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Rer.jdField_a_of_type_JavaLangString));
    }
    ((articlesummary.SocializeFeedsInfoUser)localObject1).uint32_is_real_user.set(this.jdField_a_of_type_Rer.jdField_c_of_type_Int);
    localSocializeFeedsInfo.msg_master_uin.set((MessageMicro)localObject1);
    localSocializeFeedsInfo.uint32_follow_counts.set(this.i);
    localSocializeFeedsInfo.uint32_follow_status.set(this.h);
    if (this.jdField_a_of_type_Rfi != null) {
      localSocializeFeedsInfo.share_web_page_info.set(this.jdField_a_of_type_Rfi.a());
    }
    localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (rer)((Iterator)localObject2).next();
      articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new articlesummary.SocializeFeedsInfoUser();
      localSocializeFeedsInfoUser.uint64_uin.set(((rer)localObject3).jdField_a_of_type_Long);
      localSocializeFeedsInfoUser.enum_uin_type.set(((rer)localObject3).jdField_a_of_type_Int);
      ((List)localObject1).add(localSocializeFeedsInfoUser);
    }
    localSocializeFeedsInfo.rpt_recommend_list.set((List)localObject1);
    if (this.jdField_b_of_type_JavaLangString != null) {
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (this.jdField_c_of_type_JavaLangString != null) {
      localSocializeFeedsInfo.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    localSocializeFeedsInfo.uint32_myself_biu_status.set(this.jdField_g_of_type_Int);
    localSocializeFeedsInfo.uint32_biu_count.set(this.jdField_f_of_type_Int);
    try
    {
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        localSocializeFeedsInfo.msg_socialize_feeds_ext_info.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      }
      if (this.jdField_a_of_type_Rep != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.jdField_a_of_type_Rep.a());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("SocializeFeedsInfo", 1, "merge info failed ", localException);
        continue;
        String str = this.jdField_a_of_type_Rew.jdField_a_of_type_JavaLangString;
        continue;
        str = this.jdField_a_of_type_Rew.jdField_b_of_type_JavaLangString;
      }
    }
    if (this.jdField_a_of_type_Ret != null) {
      localSocializeFeedsInfo.game_live_info.set(ret.a(this.jdField_a_of_type_Ret));
    }
    localSocializeFeedsInfo.uint64_article_id.set(this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Rfj != null) {
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(rfj.a(this.jdField_a_of_type_Rfj));
    }
    if (this.jdField_a_of_type_Rfe != null) {
      localSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(rfe.a(this.jdField_a_of_type_Rfe));
    }
    if (this.jdField_a_of_type_Rga != null) {
      localSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.jdField_a_of_type_Rga.a());
    }
    if (this.jdField_d_of_type_JavaLangString != null) {
      localSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_Rfn != null) {
      localSocializeFeedsInfo.wenda_info.set(this.jdField_a_of_type_Rfn.a());
    }
    localSocializeFeedsInfo.uint32_is_origin_feeds_deleted.set(this.j);
    if (this.jdField_a_of_type_Reu != null) {
      localSocializeFeedsInfo.icon_wording_info.set(this.jdField_a_of_type_Reu.a());
    }
    if (this.jdField_a_of_type_Rew != null)
    {
      localObject2 = new feeds_info.LocationInfo();
      localObject3 = ((feeds_info.LocationInfo)localObject2).bytes_name;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Rew.jdField_a_of_type_JavaLangString))
      {
        localObject1 = "";
        ((PBBytesField)localObject3).set(ByteStringMicro.copyFromUtf8((String)localObject1));
        ((feeds_info.LocationInfo)localObject2).uint32_longitude.set(this.jdField_a_of_type_Rew.jdField_a_of_type_Int);
        ((feeds_info.LocationInfo)localObject2).uint32_latitude.set(this.jdField_a_of_type_Rew.jdField_b_of_type_Int);
        localObject3 = ((feeds_info.LocationInfo)localObject2).bytes_icon_url;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Rew.jdField_b_of_type_JavaLangString)) {
          break label1225;
        }
        localObject1 = "";
        ((PBBytesField)localObject3).set(ByteStringMicro.copyFromUtf8((String)localObject1));
        localSocializeFeedsInfo.location_info.set((MessageMicro)localObject2);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Rfh != null)
      {
        localObject1 = new feeds_info.VisibleInfo();
        localObject2 = new feeds_info.VisibleShowInfo();
        ((feeds_info.VisibleShowInfo)localObject2).uint32_visible_type.set(this.jdField_a_of_type_Rfh.jdField_a_of_type_Int);
        ((feeds_info.VisibleShowInfo)localObject2).uint64_feed_id.set(this.jdField_a_of_type_Rfh.jdField_b_of_type_Long);
        ((feeds_info.VisibleShowInfo)localObject2).uint64_who.set(this.jdField_a_of_type_Rfh.jdField_a_of_type_Long);
        ((feeds_info.VisibleInfo)localObject1).visible_show_info.set((MessageMicro)localObject2);
        localSocializeFeedsInfo.visible_info.set((MessageMicro)localObject1);
      }
      localSocializeFeedsInfo.uint32_feed_status.set(this.k);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        localSocializeFeedsInfo.bytes_private_status_title.set(ByteStringMicro.copyFromUtf8(this.jdField_e_of_type_JavaLangString));
      }
      if (this.jdField_f_of_type_JavaLangString != null)
      {
        localSocializeFeedsInfo.uint32_is_jump_recommend_page.set(this.l);
        localSocializeFeedsInfo.bytes_jump_recommend_url.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
      }
      if (this.jdField_g_of_type_JavaLangString != null) {
        localSocializeFeedsInfo.bytes_jump_recommend_prompt.set(ByteStringMicro.copyFromUtf8(this.jdField_g_of_type_JavaLangString));
      }
      if (this.jdField_a_of_type_Oju != null)
      {
        localObject1 = new ArrayList();
        localObject2 = new oidb_cmd0xb57.MedalInfo();
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint32_pic_width.set(this.jdField_a_of_type_Oju.jdField_c_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint32_pic_height.set(this.jdField_a_of_type_Oju.jdField_d_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject2).bytes_medal_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Oju.jdField_b_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint64_medal_id.set(this.jdField_a_of_type_Oju.jdField_a_of_type_Long);
        ((oidb_cmd0xb57.MedalInfo)localObject2).bytes_medal_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Oju.jdField_a_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint32_is_jump.set(this.jdField_a_of_type_Oju.jdField_b_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject2).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Oju.jdField_c_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint32_medal_type.set(this.jdField_a_of_type_Oju.jdField_a_of_type_Int);
        ((List)localObject1).add(localObject2);
        localSocializeFeedsInfo.msg_master_uin.rpt_msg_medal_info.set((List)localObject1);
      }
      if (this.jdField_a_of_type_Req != null)
      {
        localObject1 = new articlesummary.BuluoInfo();
        ((articlesummary.BuluoInfo)localObject1).bytes_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Req.jdField_a_of_type_JavaLangString));
        ((articlesummary.BuluoInfo)localObject1).bytes_head_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Req.jdField_d_of_type_JavaLangString));
        ((articlesummary.BuluoInfo)localObject1).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Req.jdField_b_of_type_JavaLangString));
        ((articlesummary.BuluoInfo)localObject1).bytes_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Req.jdField_c_of_type_JavaLangString));
        ((articlesummary.BuluoInfo)localObject1).uint64_buluo_id.set(this.jdField_a_of_type_Req.jdField_a_of_type_Long);
        localSocializeFeedsInfo.buluo_info.set((MessageMicro)localObject1);
      }
      if (this.jdField_a_of_type_Rex != null)
      {
        localObject1 = this.jdField_a_of_type_Rex.a();
        localSocializeFeedsInfo.long_content_info.set((MessageMicro)localObject1);
      }
      if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null) {
        localSocializeFeedsInfo.msg_column_topic_info.set(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo);
      }
      if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo != null) {
        localSocializeFeedsInfo.msg_topic_entrance_info.set(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo);
      }
      return localSocializeFeedsInfo.toByteArray();
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Rfh != null) && (this.jdField_a_of_type_Rfh.jdField_a_of_type_Int != 0);
  }
  
  public String toString()
  {
    return "SocializeFeedsInfo{mFeedStyle=" + this.jdField_a_of_type_Int + ", mRecommUinList=" + this.jdField_a_of_type_JavaUtilList + ", mLikeCount=" + this.jdField_b_of_type_Int + ", mLikeStatus=" + this.jdField_c_of_type_Int + ", mCommentCount=" + this.jdField_d_of_type_Int + ", mBiuTime=" + this.jdField_e_of_type_Int + ", mCommentWording='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRecommReason='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mRecommendAccountReason='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mMasterUser.uin='" + this.jdField_a_of_type_Rer.jdField_a_of_type_Long + '\'' + ", mMasterUser.type='" + this.jdField_a_of_type_Rer.jdField_a_of_type_Int + '\'' + ", mMasterUser.starType='" + this.jdField_a_of_type_Rer.jdField_b_of_type_Int + '\'' + ", mBiuCount='" + this.jdField_f_of_type_Int + '\'' + ", mBiuStatus='" + this.jdField_g_of_type_Int + '\'' + ", mBiuInfo='" + this.jdField_a_of_type_Rep + '\'' + ", mFollowStatus='" + this.h + '\'' + ", mFollowCnt='" + this.i + '\'' + ", mIsOriginFeedsDeleted='" + this.j + '\'' + ", mFeedStatus='" + this.k + '\'' + ", mPrivateStatusTitle='" + this.jdField_e_of_type_JavaLangString + '\'' + ", mIs_jump_recommend_page='" + this.l + '\'' + ", mJump_recommend__url='" + this.jdField_f_of_type_JavaLangString + '\'' + ", mJump_recommend__prompt='" + this.jdField_g_of_type_JavaLangString + '\'' + ", mPGCFeedsInfo=" + this.jdField_a_of_type_Rfe + ", mUGCFeedsInfo=" + this.jdField_a_of_type_Rfj + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */