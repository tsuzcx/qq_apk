package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import bcsc;
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
import orr;
import qdv;
import qhl;
import rqj;
import rqk;
import rql;
import rqm;
import rqn;
import rqo;
import rqp;
import rqq;
import rqr;
import rqs;
import rqw;
import rqx;
import rqy;
import rra;
import rrb;
import rrd;
import rre;
import rrf;
import rrl;
import rro;
import rrp;
import rrq;
import rru;
import rsh;
import rsj;
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
import tnt;
import tnv;
import toa;

public class SocializeFeedsInfo
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public List<rqy> a;
  public orr a;
  public rqw a;
  public rqx a;
  public rqy a;
  public rra a;
  public rrb a;
  public rrd a;
  public rre a;
  public rrf a;
  public rrl a;
  public rro a;
  public rrp a;
  public rrq a;
  public rru a;
  public rsh a;
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
    this.jdField_a_of_type_Rqy = new rqy(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public static SpannableStringBuilder a(int paramInt, ArticleInfo paramArticleInfo, String paramString, qhl paramqhl, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramList.size();
    String str1 = ((SocializeFeedsInfo.BiuCommentInfo)paramList.get(m - 1)).mBiuComment;
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
      switch (localBiuCommentInfo.mOpType)
      {
      default: 
        l1 = localBiuCommentInfo.mUin.longValue();
        localObject = ReadInJoyUserInfoModule.a(l1, paramqhl);
        if (localObject != null)
        {
          localObject = ((ReadInJoyUserInfo)localObject).nick;
          label178:
          str1 = "@" + (String)localObject;
          localObject = str1;
          if (localBiuCommentInfo.mOpType == 1) {
            localObject = str1 + " ";
          }
          if (localBiuCommentInfo.mBiuComment != null) {
            break label439;
          }
        }
        break;
      }
    }
    label439:
    for (str1 = "";; str1 = localBiuCommentInfo.mBiuComment)
    {
      localStringBuilder.append((String)localObject).append(str1);
      localArrayList.add(new tnv(n, n + ((String)localObject).length(), new toa(l1, paramString, paramArticleInfo, paramInt)));
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
      } while (localBiuCommentInfo.jumpInfo == null);
      str1 = localBiuCommentInfo.jumpInfo.getWording();
      String str2 = localBiuCommentInfo.jumpInfo.getJumpUrl();
      if (localBiuCommentInfo.mBiuComment == null) {}
      for (localObject = "";; localObject = localBiuCommentInfo.mBiuComment)
      {
        localStringBuilder.append(str1).append((String)localObject);
        localArrayList.add(new tnv(n, str1.length() + n, new tnt(str2, 13421772)));
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
      paramqhl = (tnv)paramString.next();
      paramArticleInfo.setSpan(paramqhl.a(), paramqhl.a(), paramqhl.b(), 17);
    }
    return paramArticleInfo;
  }
  
  public static SpannableStringBuilder a(ArticleInfo paramArticleInfo, String paramString, qhl paramqhl, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    return a(-15504151, paramArticleInfo, paramString, paramqhl, paramList);
  }
  
  public static SocializeFeedsInfo.BiuCommentInfo a(articlesummary.BiuOneLevelItem paramBiuOneLevelItem)
  {
    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
    localBiuCommentInfo.mUin = Long.valueOf(qdv.a(paramBiuOneLevelItem.uint64_uin));
    localBiuCommentInfo.mFeedId = Long.valueOf(qdv.a(paramBiuOneLevelItem.uint64_feeds_id));
    localBiuCommentInfo.mBiuTime = qdv.a(paramBiuOneLevelItem.uint32_biu_time);
    localBiuCommentInfo.mFeedsType = qdv.a(paramBiuOneLevelItem.feeds_type);
    localBiuCommentInfo.mOpType = qdv.a(paramBiuOneLevelItem.op_type);
    if ((paramBiuOneLevelItem.bytes_biu_comments.has()) && (paramBiuOneLevelItem.bytes_biu_comments.get() != null)) {}
    try
    {
      String str = new String(paramBiuOneLevelItem.bytes_biu_comments.get().toByteArray(), "utf-8");
      localBiuCommentInfo.mOrigBiuComment = str;
      localBiuCommentInfo.mBiuComment = bcsc.b(str);
      if ((paramBiuOneLevelItem.msg_jump_info.has()) && (paramBiuOneLevelItem.msg_jump_info.get() != null))
      {
        paramBiuOneLevelItem = (articlesummary.JumpInfo)paramBiuOneLevelItem.msg_jump_info.get();
        localBiuCommentInfo.jumpInfo = new SocializeFeedsInfo.JumpInfo(qdv.a(paramBiuOneLevelItem.uint64_id), paramBiuOneLevelItem.bytes_wording.get().toStringUtf8(), paramBiuOneLevelItem.bytes_jump_url.get().toStringUtf8());
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
    localSocializeFeedsInfo.jdField_a_of_type_Long = qdv.a(paramSocializeFeedsInfo.uint64_feeds_id);
    rqy.a(localSocializeFeedsInfo.jdField_a_of_type_Rqy, paramSocializeFeedsInfo);
    localSocializeFeedsInfo.jdField_a_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_feeds_style);
    localSocializeFeedsInfo.jdField_b_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_like_count);
    localSocializeFeedsInfo.jdField_d_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_comments_count);
    localSocializeFeedsInfo.jdField_e_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_biu_time);
    localSocializeFeedsInfo.jdField_c_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_myself_like_status);
    localSocializeFeedsInfo.i = qdv.a(paramSocializeFeedsInfo.uint32_follow_counts);
    localSocializeFeedsInfo.h = qdv.a(paramSocializeFeedsInfo.uint32_follow_status);
    localSocializeFeedsInfo.jdField_a_of_type_Rrp = rrp.a((feeds_info.ShareWebPageInfo)paramSocializeFeedsInfo.share_web_page_info.get());
    QLog.d("SocializeFeedsInfo", 1, "create SocialFeedsInfo, feedsID : " + localSocializeFeedsInfo.jdField_a_of_type_Long + ", followCnt : " + localSocializeFeedsInfo.i + ", followStatus : " + localSocializeFeedsInfo.h + ", masterUin : " + localSocializeFeedsInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long + ", followStatusHas : " + paramSocializeFeedsInfo.uint32_follow_status.has());
    Object localObject;
    if ((paramSocializeFeedsInfo.rpt_recommend_list.has()) && (paramSocializeFeedsInfo.rpt_recommend_list.get() != null))
    {
      localObject = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      if (((Iterator)localObject).hasNext())
      {
        articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = (articlesummary.SocializeFeedsInfoUser)((Iterator)localObject).next();
        localSocializeFeedsInfo.getClass();
        rqy localrqy = new rqy(localSocializeFeedsInfo);
        long l1;
        if ((localSocializeFeedsInfoUser.has()) && (localSocializeFeedsInfoUser.get() != null))
        {
          l1 = qdv.a(localSocializeFeedsInfoUser.uint64_uin);
          label338:
          localrqy.jdField_a_of_type_Long = l1;
          if ((!localSocializeFeedsInfoUser.has()) || (localSocializeFeedsInfoUser.get() == null)) {
            break label396;
          }
        }
        label396:
        for (int m = qdv.a(localSocializeFeedsInfoUser.enum_uin_type);; m = 0)
        {
          localrqy.jdField_a_of_type_Int = m;
          localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localrqy);
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
      localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = bcsc.b((String)localObject);
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
        localSocializeFeedsInfo.jdField_f_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_biu_count);
        localSocializeFeedsInfo.jdField_g_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_myself_biu_status);
        localSocializeFeedsInfo.jdField_a_of_type_Rqw = ((rqw)qdv.a(paramSocializeFeedsInfo.msg_biu_mutli_level, localSocializeFeedsInfo.jdField_a_of_type_Rqw, new rqj(localSocializeFeedsInfo)));
        localSocializeFeedsInfo.jdField_a_of_type_Rra = ((rra)qdv.a(paramSocializeFeedsInfo.game_live_info, localSocializeFeedsInfo.jdField_a_of_type_Rra, new rql()));
        localSocializeFeedsInfo.jdField_b_of_type_Long = qdv.a(paramSocializeFeedsInfo.uint64_article_id, localSocializeFeedsInfo.jdField_b_of_type_Long);
        localSocializeFeedsInfo.jdField_a_of_type_Rrq = ((rrq)qdv.a(paramSocializeFeedsInfo.msg_ugc_topic_feeds_info, localSocializeFeedsInfo.jdField_a_of_type_Rrq, new rqm(localSocializeFeedsInfo)));
        localSocializeFeedsInfo.jdField_a_of_type_Rrl = ((rrl)qdv.a(paramSocializeFeedsInfo.msg_pgc_topic_feeds_info, localSocializeFeedsInfo.jdField_a_of_type_Rrl, new rqn()));
        if (paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has())
        {
          localSocializeFeedsInfo.jdField_a_of_type_Rsh = rsh.a((articlesummary.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get());
          QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.topicRecommendFeedsInfo = ", localSocializeFeedsInfo.jdField_a_of_type_Rsh });
        }
        if (paramSocializeFeedsInfo.bytes_recommend_account_reason.has())
        {
          localSocializeFeedsInfo.jdField_d_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_recommend_account_reason.get().toStringUtf8();
          QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.mRecommendAccountReason = ", localSocializeFeedsInfo.jdField_d_of_type_JavaLangString });
        }
        localSocializeFeedsInfo.jdField_a_of_type_Rru = ((rru)qdv.a(paramSocializeFeedsInfo.wenda_info, localSocializeFeedsInfo.jdField_a_of_type_Rru, new rqo()));
        localSocializeFeedsInfo.j = qdv.a(paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted);
        localSocializeFeedsInfo.jdField_a_of_type_Rrb = ((rrb)qdv.a(paramSocializeFeedsInfo.icon_wording_info, localSocializeFeedsInfo.jdField_a_of_type_Rrb, new rqp()));
        localSocializeFeedsInfo.k = qdv.a(paramSocializeFeedsInfo.uint32_feed_status, localSocializeFeedsInfo.k);
        localSocializeFeedsInfo.jdField_e_of_type_JavaLangString = qdv.a(paramSocializeFeedsInfo.bytes_private_status_title, localSocializeFeedsInfo.jdField_e_of_type_JavaLangString);
        localSocializeFeedsInfo.jdField_a_of_type_Rrd = ((rrd)qdv.a(paramSocializeFeedsInfo.location_info, localSocializeFeedsInfo.jdField_a_of_type_Rrd, new rqq()));
        if (paramSocializeFeedsInfo.uint32_is_jump_recommend_page.has())
        {
          localSocializeFeedsInfo.l = qdv.a(paramSocializeFeedsInfo.uint32_is_jump_recommend_page);
          localSocializeFeedsInfo.jdField_f_of_type_JavaLangString = qdv.a(paramSocializeFeedsInfo.bytes_jump_recommend_url, localSocializeFeedsInfo.jdField_f_of_type_JavaLangString);
          if (paramSocializeFeedsInfo.bytes_jump_recommend_prompt.has()) {
            localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_jump_recommend_prompt.get().toStringUtf8();
          }
          localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = qdv.a(paramSocializeFeedsInfo.bytes_jump_recommend_prompt, localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
          QLog.d("SocializeFeedsInfo", 1, "parse jumpchannel " + localSocializeFeedsInfo.l + "  " + localSocializeFeedsInfo.jdField_f_of_type_JavaLangString + "  " + localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
        }
        if (paramSocializeFeedsInfo.visible_info.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Rro = ((rro)qdv.a(paramSocializeFeedsInfo.visible_info.visible_show_info, localSocializeFeedsInfo.jdField_a_of_type_Rro, new rqr()));
        }
        if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.has())) {
          a(localSocializeFeedsInfo, ((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.get());
        }
        localSocializeFeedsInfo.jdField_a_of_type_Rqx = ((rqx)qdv.a(paramSocializeFeedsInfo.buluo_info, localSocializeFeedsInfo.jdField_a_of_type_Rqx, new rqs()));
        localSocializeFeedsInfo.jdField_a_of_type_Rre = ((rre)qdv.a(paramSocializeFeedsInfo.long_content_info, localSocializeFeedsInfo.jdField_a_of_type_Rre, new rqk()));
        localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo = ((articlesummary.ColumnTopicInfo)qdv.a(paramSocializeFeedsInfo.msg_column_topic_info, localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo));
        localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo = ((articlesummary.TopicEntranceInfo)qdv.a(paramSocializeFeedsInfo.msg_topic_entrance_info, localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo));
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
      paramSocializeFeedsInfo.jdField_a_of_type_Orr = new orr();
      if (paramList.bytes_jump_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Orr.jdField_c_of_type_JavaLangString = paramList.bytes_jump_url.get().toStringUtf8();
      }
      if (paramList.uint32_is_jump.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Orr.jdField_b_of_type_Int = paramList.uint32_is_jump.get();
      }
      if (paramList.uint32_medal_type.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Orr.jdField_a_of_type_Int = paramList.uint32_medal_type.get();
      }
      if (paramList.uint64_medal_id.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Orr.jdField_a_of_type_Long = paramList.uint64_medal_id.get();
      }
      if (paramList.bytes_medal_name.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Orr.jdField_a_of_type_JavaLangString = paramList.bytes_medal_name.get().toStringUtf8();
      }
      if (paramList.bytes_medal_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Orr.jdField_b_of_type_JavaLangString = paramList.bytes_medal_url.get().toStringUtf8();
      }
      if (paramList.uint32_pic_width.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Orr.jdField_c_of_type_Int = paramList.uint32_pic_width.get();
      }
    } while (!paramList.uint32_pic_height.has());
    paramSocializeFeedsInfo.jdField_a_of_type_Orr.jdField_d_of_type_Int = paramList.uint32_pic_height.get();
  }
  
  private void a(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_d_of_type_JavaLangString != null) {
      paramSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    }
    if (this.jdField_c_of_type_JavaLangString != null) {
      paramSocializeFeedsInfo.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      paramSocializeFeedsInfo.uint32_is_jump_recommend_page.set(this.l);
      paramSocializeFeedsInfo.bytes_jump_recommend_url.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
    }
    if (this.jdField_g_of_type_JavaLangString != null) {
      paramSocializeFeedsInfo.bytes_jump_recommend_prompt.set(ByteStringMicro.copyFromUtf8(this.jdField_g_of_type_JavaLangString));
    }
  }
  
  private void b(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null) {
      paramSocializeFeedsInfo.msg_column_topic_info.set(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo);
    }
    if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo != null) {
      paramSocializeFeedsInfo.msg_topic_entrance_info.set(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo);
    }
    if (this.jdField_a_of_type_Rsh != null) {
      paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.jdField_a_of_type_Rsh.a());
    }
  }
  
  private void c(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_Rrq != null) {
      paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(rrq.a(this.jdField_a_of_type_Rrq));
    }
    if (this.jdField_a_of_type_Rrl != null) {
      paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(rrl.a(this.jdField_a_of_type_Rrl));
    }
  }
  
  private void d(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    feeds_info.LocationInfo localLocationInfo;
    PBBytesField localPBBytesField;
    if (this.jdField_a_of_type_Rrd != null)
    {
      localLocationInfo = new feeds_info.LocationInfo();
      localPBBytesField = localLocationInfo.bytes_name;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Rrd.jdField_a_of_type_JavaLangString)) {
        break label114;
      }
      str = "";
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localLocationInfo.uint32_longitude.set(this.jdField_a_of_type_Rrd.jdField_a_of_type_Int);
      localLocationInfo.uint32_latitude.set(this.jdField_a_of_type_Rrd.jdField_b_of_type_Int);
      localPBBytesField = localLocationInfo.bytes_icon_url;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Rrd.jdField_b_of_type_JavaLangString)) {
        break label125;
      }
    }
    label114:
    label125:
    for (String str = "";; str = this.jdField_a_of_type_Rrd.jdField_b_of_type_JavaLangString)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      paramSocializeFeedsInfo.location_info.set(localLocationInfo);
      return;
      str = this.jdField_a_of_type_Rrd.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  private void e(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_Rro != null)
    {
      feeds_info.VisibleInfo localVisibleInfo = new feeds_info.VisibleInfo();
      feeds_info.VisibleShowInfo localVisibleShowInfo = new feeds_info.VisibleShowInfo();
      localVisibleShowInfo.uint32_visible_type.set(this.jdField_a_of_type_Rro.jdField_a_of_type_Int);
      localVisibleShowInfo.uint64_feed_id.set(this.jdField_a_of_type_Rro.jdField_b_of_type_Long);
      localVisibleShowInfo.uint64_who.set(this.jdField_a_of_type_Rro.jdField_a_of_type_Long);
      localVisibleInfo.visible_show_info.set(localVisibleShowInfo);
      paramSocializeFeedsInfo.visible_info.set(localVisibleInfo);
    }
  }
  
  private void f(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_Rqx != null)
    {
      articlesummary.BuluoInfo localBuluoInfo = new articlesummary.BuluoInfo();
      localBuluoInfo.bytes_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Rqx.jdField_a_of_type_JavaLangString));
      localBuluoInfo.bytes_head_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Rqx.jdField_d_of_type_JavaLangString));
      localBuluoInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Rqx.jdField_b_of_type_JavaLangString));
      localBuluoInfo.bytes_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Rqx.jdField_c_of_type_JavaLangString));
      localBuluoInfo.uint64_buluo_id.set(this.jdField_a_of_type_Rqx.jdField_a_of_type_Long);
      paramSocializeFeedsInfo.buluo_info.set(localBuluoInfo);
    }
  }
  
  private void g(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_Orr != null)
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0xb57.MedalInfo localMedalInfo = new oidb_cmd0xb57.MedalInfo();
      localMedalInfo.uint32_pic_width.set(this.jdField_a_of_type_Orr.jdField_c_of_type_Int);
      localMedalInfo.uint32_pic_height.set(this.jdField_a_of_type_Orr.jdField_d_of_type_Int);
      localMedalInfo.bytes_medal_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Orr.jdField_b_of_type_JavaLangString));
      localMedalInfo.uint64_medal_id.set(this.jdField_a_of_type_Orr.jdField_a_of_type_Long);
      localMedalInfo.bytes_medal_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Orr.jdField_a_of_type_JavaLangString));
      localMedalInfo.uint32_is_jump.set(this.jdField_a_of_type_Orr.jdField_b_of_type_Int);
      localMedalInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Orr.jdField_c_of_type_JavaLangString));
      localMedalInfo.uint32_medal_type.set(this.jdField_a_of_type_Orr.jdField_a_of_type_Int);
      localArrayList.add(localMedalInfo);
      paramSocializeFeedsInfo.msg_master_uin.rpt_msg_medal_info.set(localArrayList);
    }
  }
  
  private void h(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    paramSocializeFeedsInfo.uint64_feeds_id.set(this.jdField_a_of_type_Long);
    paramSocializeFeedsInfo.uint32_comments_count.set(this.jdField_d_of_type_Int);
    paramSocializeFeedsInfo.uint32_biu_time.set(this.jdField_e_of_type_Int);
    paramSocializeFeedsInfo.uint32_feeds_style.set(this.jdField_a_of_type_Int);
    paramSocializeFeedsInfo.uint32_like_count.set(this.jdField_b_of_type_Int);
    paramSocializeFeedsInfo.uint32_myself_like_status.set(this.jdField_c_of_type_Int);
    Object localObject = new articlesummary.SocializeFeedsInfoUser();
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint64_uin.set(this.jdField_a_of_type_Rqy.jdField_a_of_type_Long);
    ((articlesummary.SocializeFeedsInfoUser)localObject).enum_uin_type.set(this.jdField_a_of_type_Rqy.jdField_a_of_type_Int);
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint32_star_style.set(this.jdField_a_of_type_Rqy.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Rqy.jdField_a_of_type_JavaLangString)) {
      ((articlesummary.SocializeFeedsInfoUser)localObject).bytes_person_desc.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Rqy.jdField_a_of_type_JavaLangString));
    }
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint32_is_real_user.set(this.jdField_a_of_type_Rqy.jdField_c_of_type_Int);
    paramSocializeFeedsInfo.msg_master_uin.set((MessageMicro)localObject);
    paramSocializeFeedsInfo.uint32_follow_counts.set(this.i);
    paramSocializeFeedsInfo.uint32_follow_status.set(this.h);
    localObject = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      rqy localrqy = (rqy)localIterator.next();
      articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new articlesummary.SocializeFeedsInfoUser();
      localSocializeFeedsInfoUser.uint64_uin.set(localrqy.jdField_a_of_type_Long);
      localSocializeFeedsInfoUser.enum_uin_type.set(localrqy.jdField_a_of_type_Int);
      ((List)localObject).add(localSocializeFeedsInfoUser);
    }
    paramSocializeFeedsInfo.rpt_recommend_list.set((List)localObject);
    paramSocializeFeedsInfo.uint32_myself_biu_status.set(this.jdField_g_of_type_Int);
    paramSocializeFeedsInfo.uint32_biu_count.set(this.jdField_f_of_type_Int);
    paramSocializeFeedsInfo.uint64_article_id.set(this.jdField_b_of_type_Long);
    paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted.set(this.j);
    paramSocializeFeedsInfo.uint32_feed_status.set(this.k);
  }
  
  public SocializeFeedsInfo a()
  {
    try
    {
      localSocializeFeedsInfo1 = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo1.jdField_a_of_type_Rqy = this.jdField_a_of_type_Rqy.a();
        localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          rqy localrqy = (rqy)localIterator.next();
          localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList.add(localrqy.a());
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
    } while (this.jdField_a_of_type_Rqw == null);
    localSocializeFeedsInfo1.jdField_a_of_type_Rqw = this.jdField_a_of_type_Rqw.a();
    return localSocializeFeedsInfo1;
  }
  
  public rqw a(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    rqw localrqw = new rqw();
    localrqw.jdField_a_of_type_JavaLangLong = Long.valueOf(qdv.a(paramBiuMultiLevel.uint64_origin_feeds_id));
    localrqw.b = Long.valueOf(qdv.a(paramBiuMultiLevel.uint64_origin_feeds_type));
    if ((paramBiuMultiLevel.rpt_biu_mutli_level.has()) && (paramBiuMultiLevel.rpt_biu_mutli_level.get() != null))
    {
      paramBiuMultiLevel = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
      while (paramBiuMultiLevel.hasNext())
      {
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)paramBiuMultiLevel.next();
        localrqw.jdField_a_of_type_JavaUtilList.add(a(localBiuOneLevelItem));
      }
    }
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "convertPb2BiuInfo, mFeedsId =  ", Long.valueOf(this.jdField_a_of_type_Long), ", mOriFeedType = ", localrqw.b });
    return localrqw;
  }
  
  public void a(oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null) {
      return;
    }
    this.jdField_b_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_like_count);
    this.jdField_d_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_comments_count);
    this.jdField_c_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_myself_like_status);
    this.jdField_f_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_biu_count);
    this.jdField_g_of_type_Int = qdv.a(paramSocializeFeedsInfo.uint32_myself_biu_status);
    if (paramSocializeFeedsInfo.uint32_follow_count.has()) {
      this.i = qdv.a(paramSocializeFeedsInfo.uint32_follow_count);
    }
    if (paramSocializeFeedsInfo.uint32_follow_status.has()) {
      this.h = qdv.a(paramSocializeFeedsInfo.uint32_follow_status);
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
        rqy localrqy = new rqy(this);
        if ((((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).has()) && (((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).get() != null)) {}
        for (long l1 = qdv.a(((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).uint64_uin);; l1 = 0L)
        {
          localrqy.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_JavaUtilList.add(localrqy);
          break;
        }
      }
    }
    if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (this.jdField_a_of_type_Rsh != null) && (this.jdField_a_of_type_Rsh.a != null))
    {
      paramSocializeFeedsInfo = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
      if (paramSocializeFeedsInfo.msg_topic_recommend_info.has())
      {
        paramSocializeFeedsInfo = paramSocializeFeedsInfo.msg_topic_recommend_info.get();
        int m = 0;
        while ((m < paramSocializeFeedsInfo.size()) && (m < this.jdField_a_of_type_Rsh.a.size()))
        {
          localObject1 = (oidb_cmd0x8c8.TopicRecommendInfo)paramSocializeFeedsInfo.get(m);
          localObject2 = (rsj)this.jdField_a_of_type_Rsh.a.get(m);
          if (((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.has()) {
            ((rsj)localObject2).jdField_b_of_type_Int = ((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.get();
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
    h(localSocializeFeedsInfo);
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localSocializeFeedsInfo.bytes_private_status_title.set(ByteStringMicro.copyFromUtf8(this.jdField_e_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_Rre != null)
    {
      articlesummary.LongContentInfo localLongContentInfo = this.jdField_a_of_type_Rre.a();
      localSocializeFeedsInfo.long_content_info.set(localLongContentInfo);
    }
    if (this.jdField_a_of_type_Rrp != null) {
      localSocializeFeedsInfo.share_web_page_info.set(this.jdField_a_of_type_Rrp.a());
    }
    if (this.jdField_b_of_type_JavaLangString != null) {
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_Rru != null) {
      localSocializeFeedsInfo.wenda_info.set(this.jdField_a_of_type_Rru.a());
    }
    if (this.jdField_a_of_type_Rrb != null) {
      localSocializeFeedsInfo.icon_wording_info.set(this.jdField_a_of_type_Rrb.a());
    }
    try
    {
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        localSocializeFeedsInfo.msg_socialize_feeds_ext_info.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      }
      if (this.jdField_a_of_type_Rqw != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.jdField_a_of_type_Rqw.a());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("SocializeFeedsInfo", 1, "merge info failed ", localException);
      }
    }
    if (this.jdField_a_of_type_Rra != null) {
      localSocializeFeedsInfo.game_live_info.set(rra.a(this.jdField_a_of_type_Rra));
    }
    b(localSocializeFeedsInfo);
    c(localSocializeFeedsInfo);
    a(localSocializeFeedsInfo);
    d(localSocializeFeedsInfo);
    e(localSocializeFeedsInfo);
    g(localSocializeFeedsInfo);
    f(localSocializeFeedsInfo);
    return localSocializeFeedsInfo.toByteArray();
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Rro != null) && (this.jdField_a_of_type_Rro.jdField_a_of_type_Int != 0);
  }
  
  public String toString()
  {
    return "SocializeFeedsInfo{mFeedStyle=" + this.jdField_a_of_type_Int + ", mRecommUinList=" + this.jdField_a_of_type_JavaUtilList + ", mLikeCount=" + this.jdField_b_of_type_Int + ", mLikeStatus=" + this.jdField_c_of_type_Int + ", mCommentCount=" + this.jdField_d_of_type_Int + ", mBiuTime=" + this.jdField_e_of_type_Int + ", mCommentWording='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRecommReason='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mRecommendAccountReason='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mMasterUser.uin='" + this.jdField_a_of_type_Rqy.jdField_a_of_type_Long + '\'' + ", mMasterUser.type='" + this.jdField_a_of_type_Rqy.jdField_a_of_type_Int + '\'' + ", mMasterUser.starType='" + this.jdField_a_of_type_Rqy.jdField_b_of_type_Int + '\'' + ", mBiuCount='" + this.jdField_f_of_type_Int + '\'' + ", mBiuStatus='" + this.jdField_g_of_type_Int + '\'' + ", mBiuInfo='" + this.jdField_a_of_type_Rqw + '\'' + ", mFollowStatus='" + this.h + '\'' + ", mFollowCnt='" + this.i + '\'' + ", mIsOriginFeedsDeleted='" + this.j + '\'' + ", mFeedStatus='" + this.k + '\'' + ", mPrivateStatusTitle='" + this.jdField_e_of_type_JavaLangString + '\'' + ", mIs_jump_recommend_page='" + this.l + '\'' + ", mJump_recommend__url='" + this.jdField_f_of_type_JavaLangString + '\'' + ", mJump_recommend__prompt='" + this.jdField_g_of_type_JavaLangString + '\'' + ", mPGCFeedsInfo=" + this.jdField_a_of_type_Rrl + ", mUGCFeedsInfo=" + this.jdField_a_of_type_Rrq + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */