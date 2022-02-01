package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import bcsa;
import begp;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oih;
import pnq;
import pql;
import qxe;
import qxf;
import qxg;
import qxh;
import qxi;
import qxj;
import qxk;
import qxl;
import qxm;
import qxn;
import qxr;
import qxs;
import qxt;
import qxv;
import qxw;
import qxy;
import qxz;
import qya;
import qyg;
import qyj;
import qyk;
import qyl;
import qyp;
import qzb;
import qzd;
import swl;
import swn;
import sws;
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
  public AdvertisementInfo a;
  public String a;
  public List<qxt> a;
  public oih a;
  public qxr a;
  public qxs a;
  public qxt a;
  public qxv a;
  public qxw a;
  public qxy a;
  public qxz a;
  public qya a;
  public qyg a;
  public qyj a;
  public qyk a;
  public qyl a;
  public qyp a;
  public qzb a;
  public articlesummary.ColumnTopicInfo a;
  public articlesummary.TopicEntranceInfo a;
  public boolean a;
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
    this.jdField_a_of_type_Qxt = new qxt(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public static SpannableStringBuilder a(int paramInt, ArticleInfo paramArticleInfo, String paramString, pql parampql, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
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
        localObject = ReadInJoyUserInfoModule.a(l1, parampql);
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
      localArrayList.add(new swn(n, n + ((String)localObject).length(), new sws(l1, paramString, paramArticleInfo, paramInt)));
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
        localArrayList.add(new swn(n, str1.length() + n, new swl(str2, 13421772)));
        break;
      }
      localObject = ReadInJoyUserInfoModule.a();
      break label178;
    }
    label449:
    paramArticleInfo = new SpannableStringBuilder(new begp(localStringBuilder, 3, 16));
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      parampql = (swn)paramString.next();
      paramArticleInfo.setSpan(parampql.a(), parampql.a(), parampql.b(), 17);
    }
    return paramArticleInfo;
  }
  
  public static SpannableStringBuilder a(ArticleInfo paramArticleInfo, String paramString, pql parampql, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    return a(-15504151, paramArticleInfo, paramString, parampql, paramList);
  }
  
  public static SocializeFeedsInfo.BiuCommentInfo a(articlesummary.BiuOneLevelItem paramBiuOneLevelItem)
  {
    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
    localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(pnq.a(paramBiuOneLevelItem.uint64_uin));
    localBiuCommentInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(pnq.a(paramBiuOneLevelItem.uint64_feeds_id));
    localBiuCommentInfo.jdField_a_of_type_Int = pnq.a(paramBiuOneLevelItem.uint32_biu_time);
    localBiuCommentInfo.jdField_b_of_type_Int = pnq.a(paramBiuOneLevelItem.feeds_type);
    localBiuCommentInfo.jdField_c_of_type_Int = pnq.a(paramBiuOneLevelItem.op_type);
    if ((paramBiuOneLevelItem.bytes_biu_comments.has()) && (paramBiuOneLevelItem.bytes_biu_comments.get() != null)) {}
    try
    {
      String str = new String(paramBiuOneLevelItem.bytes_biu_comments.get().toByteArray(), "utf-8");
      localBiuCommentInfo.jdField_b_of_type_JavaLangString = str;
      localBiuCommentInfo.jdField_a_of_type_JavaLangString = bcsa.b(str);
      if ((paramBiuOneLevelItem.msg_jump_info.has()) && (paramBiuOneLevelItem.msg_jump_info.get() != null))
      {
        paramBiuOneLevelItem = (articlesummary.JumpInfo)paramBiuOneLevelItem.msg_jump_info.get();
        localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(pnq.a(paramBiuOneLevelItem.uint64_id), paramBiuOneLevelItem.bytes_wording.get().toStringUtf8(), paramBiuOneLevelItem.bytes_jump_url.get().toStringUtf8());
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
    localSocializeFeedsInfo.jdField_a_of_type_Long = pnq.a(paramSocializeFeedsInfo.uint64_feeds_id);
    qxt.a(localSocializeFeedsInfo.jdField_a_of_type_Qxt, paramSocializeFeedsInfo);
    localSocializeFeedsInfo.jdField_a_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_feeds_style);
    localSocializeFeedsInfo.jdField_b_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_like_count);
    localSocializeFeedsInfo.jdField_d_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_comments_count);
    localSocializeFeedsInfo.jdField_e_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_biu_time);
    localSocializeFeedsInfo.jdField_c_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_myself_like_status);
    localSocializeFeedsInfo.i = pnq.a(paramSocializeFeedsInfo.uint32_follow_counts);
    localSocializeFeedsInfo.h = pnq.a(paramSocializeFeedsInfo.uint32_follow_status);
    localSocializeFeedsInfo.jdField_a_of_type_Qyk = qyk.a((feeds_info.ShareWebPageInfo)paramSocializeFeedsInfo.share_web_page_info.get());
    QLog.d("SocializeFeedsInfo", 1, "create SocialFeedsInfo, feedsID : " + localSocializeFeedsInfo.jdField_a_of_type_Long + ", followCnt : " + localSocializeFeedsInfo.i + ", followStatus : " + localSocializeFeedsInfo.h + ", masterUin : " + localSocializeFeedsInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long + ", followStatusHas : " + paramSocializeFeedsInfo.uint32_follow_status.has());
    Object localObject;
    if ((paramSocializeFeedsInfo.rpt_recommend_list.has()) && (paramSocializeFeedsInfo.rpt_recommend_list.get() != null))
    {
      localObject = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      if (((Iterator)localObject).hasNext())
      {
        articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = (articlesummary.SocializeFeedsInfoUser)((Iterator)localObject).next();
        localSocializeFeedsInfo.getClass();
        qxt localqxt = new qxt(localSocializeFeedsInfo);
        long l1;
        if ((localSocializeFeedsInfoUser.has()) && (localSocializeFeedsInfoUser.get() != null))
        {
          l1 = pnq.a(localSocializeFeedsInfoUser.uint64_uin);
          label338:
          localqxt.jdField_a_of_type_Long = l1;
          if ((!localSocializeFeedsInfoUser.has()) || (localSocializeFeedsInfoUser.get() == null)) {
            break label396;
          }
        }
        label396:
        for (int m = pnq.a(localSocializeFeedsInfoUser.enum_uin_type);; m = 0)
        {
          localqxt.jdField_a_of_type_Int = m;
          localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localqxt);
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
      localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = bcsa.b((String)localObject);
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
        localSocializeFeedsInfo.jdField_f_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_biu_count);
        localSocializeFeedsInfo.jdField_g_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_myself_biu_status);
        localSocializeFeedsInfo.jdField_a_of_type_Qxr = ((qxr)pnq.a(paramSocializeFeedsInfo.msg_biu_mutli_level, localSocializeFeedsInfo.jdField_a_of_type_Qxr, new qxe(localSocializeFeedsInfo)));
        localSocializeFeedsInfo.jdField_a_of_type_Qxv = ((qxv)pnq.a(paramSocializeFeedsInfo.game_live_info, localSocializeFeedsInfo.jdField_a_of_type_Qxv, new qxg()));
        localSocializeFeedsInfo.jdField_b_of_type_Long = pnq.a(paramSocializeFeedsInfo.uint64_article_id, localSocializeFeedsInfo.jdField_b_of_type_Long);
        localSocializeFeedsInfo.jdField_a_of_type_Qyl = ((qyl)pnq.a(paramSocializeFeedsInfo.msg_ugc_topic_feeds_info, localSocializeFeedsInfo.jdField_a_of_type_Qyl, new qxh(localSocializeFeedsInfo)));
        localSocializeFeedsInfo.jdField_a_of_type_Qyg = ((qyg)pnq.a(paramSocializeFeedsInfo.msg_pgc_topic_feeds_info, localSocializeFeedsInfo.jdField_a_of_type_Qyg, new qxi()));
        if (paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has())
        {
          localSocializeFeedsInfo.jdField_a_of_type_Qzb = qzb.a((articlesummary.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get());
          QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.topicRecommendFeedsInfo = ", localSocializeFeedsInfo.jdField_a_of_type_Qzb });
        }
        if (paramSocializeFeedsInfo.bytes_recommend_account_reason.has())
        {
          localSocializeFeedsInfo.jdField_d_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_recommend_account_reason.get().toStringUtf8();
          QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.mRecommendAccountReason = ", localSocializeFeedsInfo.jdField_d_of_type_JavaLangString });
        }
        localSocializeFeedsInfo.jdField_a_of_type_Qyp = ((qyp)pnq.a(paramSocializeFeedsInfo.wenda_info, localSocializeFeedsInfo.jdField_a_of_type_Qyp, new qxj()));
        localSocializeFeedsInfo.j = pnq.a(paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted);
        localSocializeFeedsInfo.jdField_a_of_type_Qxw = ((qxw)pnq.a(paramSocializeFeedsInfo.icon_wording_info, localSocializeFeedsInfo.jdField_a_of_type_Qxw, new qxk()));
        localSocializeFeedsInfo.k = pnq.a(paramSocializeFeedsInfo.uint32_feed_status, localSocializeFeedsInfo.k);
        localSocializeFeedsInfo.jdField_e_of_type_JavaLangString = pnq.a(paramSocializeFeedsInfo.bytes_private_status_title, localSocializeFeedsInfo.jdField_e_of_type_JavaLangString);
        localSocializeFeedsInfo.jdField_a_of_type_Qxy = ((qxy)pnq.a(paramSocializeFeedsInfo.location_info, localSocializeFeedsInfo.jdField_a_of_type_Qxy, new qxl()));
        if (paramSocializeFeedsInfo.uint32_is_jump_recommend_page.has())
        {
          localSocializeFeedsInfo.l = pnq.a(paramSocializeFeedsInfo.uint32_is_jump_recommend_page);
          localSocializeFeedsInfo.jdField_f_of_type_JavaLangString = pnq.a(paramSocializeFeedsInfo.bytes_jump_recommend_url, localSocializeFeedsInfo.jdField_f_of_type_JavaLangString);
          if (paramSocializeFeedsInfo.bytes_jump_recommend_prompt.has()) {
            localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_jump_recommend_prompt.get().toStringUtf8();
          }
          localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = pnq.a(paramSocializeFeedsInfo.bytes_jump_recommend_prompt, localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
          QLog.d("SocializeFeedsInfo", 1, "parse jumpchannel " + localSocializeFeedsInfo.l + "  " + localSocializeFeedsInfo.jdField_f_of_type_JavaLangString + "  " + localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
        }
        if (paramSocializeFeedsInfo.visible_info.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qyj = ((qyj)pnq.a(paramSocializeFeedsInfo.visible_info.visible_show_info, localSocializeFeedsInfo.jdField_a_of_type_Qyj, new qxm()));
        }
        if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.has())) {
          a(localSocializeFeedsInfo, ((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.get());
        }
        localSocializeFeedsInfo.jdField_a_of_type_Qxs = ((qxs)pnq.a(paramSocializeFeedsInfo.buluo_info, localSocializeFeedsInfo.jdField_a_of_type_Qxs, new qxn()));
        localSocializeFeedsInfo.jdField_a_of_type_Qxz = ((qxz)pnq.a(paramSocializeFeedsInfo.long_content_info, localSocializeFeedsInfo.jdField_a_of_type_Qxz, new qxf()));
        localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo = ((articlesummary.ColumnTopicInfo)pnq.a(paramSocializeFeedsInfo.msg_column_topic_info, localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo));
        localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo = ((articlesummary.TopicEntranceInfo)pnq.a(paramSocializeFeedsInfo.msg_topic_entrance_info, localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo));
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
      paramSocializeFeedsInfo.jdField_a_of_type_Oih = new oih();
      if (paramList.bytes_jump_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oih.jdField_c_of_type_JavaLangString = paramList.bytes_jump_url.get().toStringUtf8();
      }
      if (paramList.uint32_is_jump.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oih.jdField_b_of_type_Int = paramList.uint32_is_jump.get();
      }
      if (paramList.uint32_medal_type.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oih.jdField_a_of_type_Int = paramList.uint32_medal_type.get();
      }
      if (paramList.uint64_medal_id.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oih.jdField_a_of_type_Long = paramList.uint64_medal_id.get();
      }
      if (paramList.bytes_medal_name.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oih.jdField_a_of_type_JavaLangString = paramList.bytes_medal_name.get().toStringUtf8();
      }
      if (paramList.bytes_medal_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oih.jdField_b_of_type_JavaLangString = paramList.bytes_medal_url.get().toStringUtf8();
      }
      if (paramList.uint32_pic_width.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Oih.jdField_c_of_type_Int = paramList.uint32_pic_width.get();
      }
    } while (!paramList.uint32_pic_height.has());
    paramSocializeFeedsInfo.jdField_a_of_type_Oih.jdField_d_of_type_Int = paramList.uint32_pic_height.get();
  }
  
  public SocializeFeedsInfo a()
  {
    try
    {
      localSocializeFeedsInfo1 = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo1.jdField_a_of_type_Qxt = this.jdField_a_of_type_Qxt.a();
        localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          qxt localqxt = (qxt)localIterator.next();
          localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList.add(localqxt.a());
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
    } while (this.jdField_a_of_type_Qxr == null);
    localSocializeFeedsInfo1.jdField_a_of_type_Qxr = this.jdField_a_of_type_Qxr.a();
    return localSocializeFeedsInfo1;
  }
  
  public qxr a(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    qxr localqxr = new qxr();
    localqxr.jdField_a_of_type_JavaLangLong = Long.valueOf(pnq.a(paramBiuMultiLevel.uint64_origin_feeds_id));
    localqxr.jdField_b_of_type_JavaLangLong = Long.valueOf(pnq.a(paramBiuMultiLevel.uint64_origin_feeds_type));
    if ((paramBiuMultiLevel.rpt_biu_mutli_level.has()) && (paramBiuMultiLevel.rpt_biu_mutli_level.get() != null))
    {
      paramBiuMultiLevel = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
      while (paramBiuMultiLevel.hasNext())
      {
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)paramBiuMultiLevel.next();
        localqxr.jdField_a_of_type_JavaUtilList.add(a(localBiuOneLevelItem));
      }
    }
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "convertPb2BiuInfo, mFeedsId =  ", Long.valueOf(this.jdField_a_of_type_Long), ", mOriFeedType = ", localqxr.jdField_b_of_type_JavaLangLong });
    return localqxr;
  }
  
  public void a(oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null) {
      return;
    }
    this.jdField_b_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_like_count);
    this.jdField_d_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_comments_count);
    this.jdField_c_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_myself_like_status);
    this.jdField_f_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_biu_count);
    this.jdField_g_of_type_Int = pnq.a(paramSocializeFeedsInfo.uint32_myself_biu_status);
    if (paramSocializeFeedsInfo.uint32_follow_count.has()) {
      this.i = pnq.a(paramSocializeFeedsInfo.uint32_follow_count);
    }
    if (paramSocializeFeedsInfo.uint32_follow_status.has()) {
      this.h = pnq.a(paramSocializeFeedsInfo.uint32_follow_status);
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
        qxt localqxt = new qxt(this);
        if ((((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).has()) && (((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).get() != null)) {}
        for (long l1 = pnq.a(((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).uint64_uin);; l1 = 0L)
        {
          localqxt.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_JavaUtilList.add(localqxt);
          break;
        }
      }
    }
    if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (this.jdField_a_of_type_Qzb != null) && (this.jdField_a_of_type_Qzb.a != null))
    {
      paramSocializeFeedsInfo = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
      if (paramSocializeFeedsInfo.msg_topic_recommend_info.has())
      {
        paramSocializeFeedsInfo = paramSocializeFeedsInfo.msg_topic_recommend_info.get();
        int m = 0;
        while ((m < paramSocializeFeedsInfo.size()) && (m < this.jdField_a_of_type_Qzb.a.size()))
        {
          localObject1 = (oidb_cmd0x8c8.TopicRecommendInfo)paramSocializeFeedsInfo.get(m);
          localObject2 = (qzd)this.jdField_a_of_type_Qzb.a.get(m);
          if (((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.has()) {
            ((qzd)localObject2).jdField_b_of_type_Int = ((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.get();
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
    ((articlesummary.SocializeFeedsInfoUser)localObject1).uint64_uin.set(this.jdField_a_of_type_Qxt.jdField_a_of_type_Long);
    ((articlesummary.SocializeFeedsInfoUser)localObject1).enum_uin_type.set(this.jdField_a_of_type_Qxt.jdField_a_of_type_Int);
    ((articlesummary.SocializeFeedsInfoUser)localObject1).uint32_star_style.set(this.jdField_a_of_type_Qxt.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Qxt.jdField_a_of_type_JavaLangString)) {
      ((articlesummary.SocializeFeedsInfoUser)localObject1).bytes_person_desc.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qxt.jdField_a_of_type_JavaLangString));
    }
    ((articlesummary.SocializeFeedsInfoUser)localObject1).uint32_is_real_user.set(this.jdField_a_of_type_Qxt.jdField_c_of_type_Int);
    localSocializeFeedsInfo.msg_master_uin.set((MessageMicro)localObject1);
    localSocializeFeedsInfo.uint32_follow_counts.set(this.i);
    localSocializeFeedsInfo.uint32_follow_status.set(this.h);
    if (this.jdField_a_of_type_Qyk != null) {
      localSocializeFeedsInfo.share_web_page_info.set(this.jdField_a_of_type_Qyk.a());
    }
    localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (qxt)((Iterator)localObject2).next();
      articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new articlesummary.SocializeFeedsInfoUser();
      localSocializeFeedsInfoUser.uint64_uin.set(((qxt)localObject3).jdField_a_of_type_Long);
      localSocializeFeedsInfoUser.enum_uin_type.set(((qxt)localObject3).jdField_a_of_type_Int);
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
      if (this.jdField_a_of_type_Qxr != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.jdField_a_of_type_Qxr.a());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("SocializeFeedsInfo", 1, "merge info failed ", localException);
        continue;
        String str = this.jdField_a_of_type_Qxy.jdField_a_of_type_JavaLangString;
        continue;
        str = this.jdField_a_of_type_Qxy.jdField_b_of_type_JavaLangString;
      }
    }
    if (this.jdField_a_of_type_Qxv != null) {
      localSocializeFeedsInfo.game_live_info.set(qxv.a(this.jdField_a_of_type_Qxv));
    }
    localSocializeFeedsInfo.uint64_article_id.set(this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Qyl != null) {
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(qyl.a(this.jdField_a_of_type_Qyl));
    }
    if (this.jdField_a_of_type_Qyg != null) {
      localSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(qyg.a(this.jdField_a_of_type_Qyg));
    }
    if (this.jdField_a_of_type_Qzb != null) {
      localSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.jdField_a_of_type_Qzb.a());
    }
    if (this.jdField_d_of_type_JavaLangString != null) {
      localSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_Qyp != null) {
      localSocializeFeedsInfo.wenda_info.set(this.jdField_a_of_type_Qyp.a());
    }
    localSocializeFeedsInfo.uint32_is_origin_feeds_deleted.set(this.j);
    if (this.jdField_a_of_type_Qxw != null) {
      localSocializeFeedsInfo.icon_wording_info.set(this.jdField_a_of_type_Qxw.a());
    }
    if (this.jdField_a_of_type_Qxy != null)
    {
      localObject2 = new feeds_info.LocationInfo();
      localObject3 = ((feeds_info.LocationInfo)localObject2).bytes_name;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Qxy.jdField_a_of_type_JavaLangString))
      {
        localObject1 = "";
        ((PBBytesField)localObject3).set(ByteStringMicro.copyFromUtf8((String)localObject1));
        ((feeds_info.LocationInfo)localObject2).uint32_longitude.set(this.jdField_a_of_type_Qxy.jdField_a_of_type_Int);
        ((feeds_info.LocationInfo)localObject2).uint32_latitude.set(this.jdField_a_of_type_Qxy.jdField_b_of_type_Int);
        localObject3 = ((feeds_info.LocationInfo)localObject2).bytes_icon_url;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Qxy.jdField_b_of_type_JavaLangString)) {
          break label1225;
        }
        localObject1 = "";
        ((PBBytesField)localObject3).set(ByteStringMicro.copyFromUtf8((String)localObject1));
        localSocializeFeedsInfo.location_info.set((MessageMicro)localObject2);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Qyj != null)
      {
        localObject1 = new feeds_info.VisibleInfo();
        localObject2 = new feeds_info.VisibleShowInfo();
        ((feeds_info.VisibleShowInfo)localObject2).uint32_visible_type.set(this.jdField_a_of_type_Qyj.jdField_a_of_type_Int);
        ((feeds_info.VisibleShowInfo)localObject2).uint64_feed_id.set(this.jdField_a_of_type_Qyj.jdField_b_of_type_Long);
        ((feeds_info.VisibleShowInfo)localObject2).uint64_who.set(this.jdField_a_of_type_Qyj.jdField_a_of_type_Long);
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
      if (this.jdField_a_of_type_Oih != null)
      {
        localObject1 = new ArrayList();
        localObject2 = new oidb_cmd0xb57.MedalInfo();
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint32_pic_width.set(this.jdField_a_of_type_Oih.jdField_c_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint32_pic_height.set(this.jdField_a_of_type_Oih.jdField_d_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject2).bytes_medal_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Oih.jdField_b_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint64_medal_id.set(this.jdField_a_of_type_Oih.jdField_a_of_type_Long);
        ((oidb_cmd0xb57.MedalInfo)localObject2).bytes_medal_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Oih.jdField_a_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint32_is_jump.set(this.jdField_a_of_type_Oih.jdField_b_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject2).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Oih.jdField_c_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject2).uint32_medal_type.set(this.jdField_a_of_type_Oih.jdField_a_of_type_Int);
        ((List)localObject1).add(localObject2);
        localSocializeFeedsInfo.msg_master_uin.rpt_msg_medal_info.set((List)localObject1);
      }
      if (this.jdField_a_of_type_Qxs != null)
      {
        localObject1 = new articlesummary.BuluoInfo();
        ((articlesummary.BuluoInfo)localObject1).bytes_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qxs.jdField_a_of_type_JavaLangString));
        ((articlesummary.BuluoInfo)localObject1).bytes_head_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qxs.jdField_d_of_type_JavaLangString));
        ((articlesummary.BuluoInfo)localObject1).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qxs.jdField_b_of_type_JavaLangString));
        ((articlesummary.BuluoInfo)localObject1).bytes_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qxs.jdField_c_of_type_JavaLangString));
        ((articlesummary.BuluoInfo)localObject1).uint64_buluo_id.set(this.jdField_a_of_type_Qxs.jdField_a_of_type_Long);
        localSocializeFeedsInfo.buluo_info.set((MessageMicro)localObject1);
      }
      if (this.jdField_a_of_type_Qxz != null)
      {
        localObject1 = this.jdField_a_of_type_Qxz.a();
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
    return (this.jdField_a_of_type_Qyj != null) && (this.jdField_a_of_type_Qyj.jdField_a_of_type_Int != 0);
  }
  
  public String toString()
  {
    return "SocializeFeedsInfo{mFeedStyle=" + this.jdField_a_of_type_Int + ", mRecommUinList=" + this.jdField_a_of_type_JavaUtilList + ", mLikeCount=" + this.jdField_b_of_type_Int + ", mLikeStatus=" + this.jdField_c_of_type_Int + ", mCommentCount=" + this.jdField_d_of_type_Int + ", mBiuTime=" + this.jdField_e_of_type_Int + ", mCommentWording='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRecommReason='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mRecommendAccountReason='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mMasterUser.uin='" + this.jdField_a_of_type_Qxt.jdField_a_of_type_Long + '\'' + ", mMasterUser.type='" + this.jdField_a_of_type_Qxt.jdField_a_of_type_Int + '\'' + ", mMasterUser.starType='" + this.jdField_a_of_type_Qxt.jdField_b_of_type_Int + '\'' + ", mBiuCount='" + this.jdField_f_of_type_Int + '\'' + ", mBiuStatus='" + this.jdField_g_of_type_Int + '\'' + ", mBiuInfo='" + this.jdField_a_of_type_Qxr + '\'' + ", mFollowStatus='" + this.h + '\'' + ", mFollowCnt='" + this.i + '\'' + ", mIsOriginFeedsDeleted='" + this.j + '\'' + ", mFeedStatus='" + this.k + '\'' + ", mPrivateStatusTitle='" + this.jdField_e_of_type_JavaLangString + '\'' + ", mIs_jump_recommend_page='" + this.l + '\'' + ", mJump_recommend__url='" + this.jdField_f_of_type_JavaLangString + '\'' + ", mJump_recommend__prompt='" + this.jdField_g_of_type_JavaLangString + '\'' + ", mPGCFeedsInfo=" + this.jdField_a_of_type_Qyg + ", mUGCFeedsInfo=" + this.jdField_a_of_type_Qyl + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */