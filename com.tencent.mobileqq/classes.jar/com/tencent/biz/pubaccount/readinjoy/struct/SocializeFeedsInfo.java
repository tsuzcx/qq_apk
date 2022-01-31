package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import awbk;
import axkd;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nis;
import oqi;
import pqk;
import pqm;
import pqn;
import pqo;
import pqp;
import pqq;
import pqr;
import pqt;
import pqu;
import pqz;
import pra;
import prb;
import prc;
import prd;
import pre;
import prf;
import prg;
import pri;
import prv;
import prx;
import rer;
import ret;
import rev;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;
import tencent.im.oidb.articlesummary.articlesummary.GalleryPGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsExtInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.articlesummary.WendaInfo;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;
import tencent.im.oidb.articlesummary.feeds_info.BuluoInfo;
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
  public List<pqo> a;
  public nis a;
  public pqm a;
  public pqn a;
  public pqo a;
  public pqq a;
  public pqr a;
  public pqt a;
  public pqu a;
  public pqz a;
  public prc a;
  public prd a;
  public pre a;
  public pri a;
  public prv a;
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
    this.jdField_a_of_type_Pqo = new pqo(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  public static int a(PBEnumField paramPBEnumField)
  {
    if (paramPBEnumField.has()) {
      return paramPBEnumField.get();
    }
    return 0;
  }
  
  public static int a(PBUInt32Field paramPBUInt32Field)
  {
    if (paramPBUInt32Field.has()) {
      return paramPBUInt32Field.get();
    }
    return 0;
  }
  
  public static long a(PBUInt64Field paramPBUInt64Field)
  {
    if (paramPBUInt64Field.has()) {
      return paramPBUInt64Field.get();
    }
    return 0L;
  }
  
  public static SpannableStringBuilder a(ArticleInfo paramArticleInfo, String paramString, oqi paramoqi, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramList.size();
    String str1 = ((SocializeFeedsInfo.BiuCommentInfo)paramList.get(m - 1)).jdField_a_of_type_JavaLangString;
    Object localObject;
    int n;
    ArrayList localArrayList;
    label101:
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
        break label448;
      }
      localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramList.get(m);
      switch (localBiuCommentInfo.jdField_c_of_type_Int)
      {
      default: 
        l1 = localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue();
        localObject = ReadInJoyUserInfoModule.a(l1, paramoqi);
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
            break label438;
          }
        }
        break;
      }
    }
    label438:
    for (str1 = "";; str1 = localBiuCommentInfo.jdField_a_of_type_JavaLangString)
    {
      localStringBuilder.append((String)localObject).append(str1);
      localArrayList.add(new ret(n, ((String)localObject).length() + n, new rev(l1, paramString, paramArticleInfo)));
      do
      {
        n = localStringBuilder.length();
        m -= 1;
        break label101;
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
        localArrayList.add(new ret(n, str1.length() + n, new rer(str2, 13421772)));
        break;
      }
      localObject = ReadInJoyUserInfoModule.a();
      break label178;
    }
    label448:
    paramArticleInfo = new SpannableStringBuilder(new axkd(localStringBuilder, 7, 16));
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      paramoqi = (ret)paramString.next();
      paramArticleInfo.setSpan(paramoqi.a(), paramoqi.a(), paramoqi.b(), 17);
    }
    return paramArticleInfo;
  }
  
  public static SocializeFeedsInfo.BiuCommentInfo a(articlesummary.BiuOneLevelItem paramBiuOneLevelItem)
  {
    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
    localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(a(paramBiuOneLevelItem.uint64_uin));
    localBiuCommentInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(a(paramBiuOneLevelItem.uint64_feeds_id));
    localBiuCommentInfo.jdField_a_of_type_Int = a(paramBiuOneLevelItem.uint32_biu_time);
    localBiuCommentInfo.jdField_b_of_type_Int = a(paramBiuOneLevelItem.feeds_type);
    localBiuCommentInfo.jdField_c_of_type_Int = a(paramBiuOneLevelItem.op_type);
    if ((paramBiuOneLevelItem.bytes_biu_comments.has()) && (paramBiuOneLevelItem.bytes_biu_comments.get() != null)) {}
    try
    {
      String str = new String(paramBiuOneLevelItem.bytes_biu_comments.get().toByteArray(), "utf-8");
      localBiuCommentInfo.jdField_b_of_type_JavaLangString = str;
      localBiuCommentInfo.jdField_a_of_type_JavaLangString = awbk.b(str);
      if ((paramBiuOneLevelItem.msg_jump_info.has()) && (paramBiuOneLevelItem.msg_jump_info.get() != null))
      {
        paramBiuOneLevelItem = (articlesummary.JumpInfo)paramBiuOneLevelItem.msg_jump_info.get();
        localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(a(paramBiuOneLevelItem.uint64_id), paramBiuOneLevelItem.bytes_wording.get().toStringUtf8(), paramBiuOneLevelItem.bytes_jump_url.get().toStringUtf8());
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
    long l2 = 0L;
    int n = 0;
    if (paramSocializeFeedsInfo == null)
    {
      QLog.d("SocializeFeedsInfo", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.jdField_a_of_type_Long = a(paramSocializeFeedsInfo.uint64_feeds_id);
    Object localObject1 = localSocializeFeedsInfo.jdField_a_of_type_Pqo;
    long l1;
    label116:
    Object localObject3;
    label156:
    Object localObject4;
    if (paramSocializeFeedsInfo.msg_master_uin.has())
    {
      l1 = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint64_uin);
      ((pqo)localObject1).jdField_a_of_type_Long = l1;
      localObject1 = localSocializeFeedsInfo.jdField_a_of_type_Pqo;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label512;
      }
      m = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).enum_uin_type);
      ((pqo)localObject1).jdField_a_of_type_Int = m;
      localObject1 = localSocializeFeedsInfo.jdField_a_of_type_Pqo;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label517;
      }
      m = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint32_star_style);
      ((pqo)localObject1).jdField_b_of_type_Int = m;
      localSocializeFeedsInfo.jdField_a_of_type_Int = a(paramSocializeFeedsInfo.uint32_feeds_style);
      localSocializeFeedsInfo.jdField_b_of_type_Int = a(paramSocializeFeedsInfo.uint32_like_count);
      localSocializeFeedsInfo.jdField_d_of_type_Int = a(paramSocializeFeedsInfo.uint32_comments_count);
      localSocializeFeedsInfo.jdField_e_of_type_Int = a(paramSocializeFeedsInfo.uint32_biu_time);
      localSocializeFeedsInfo.jdField_c_of_type_Int = a(paramSocializeFeedsInfo.uint32_myself_like_status);
      localSocializeFeedsInfo.i = a(paramSocializeFeedsInfo.uint32_follow_counts);
      localSocializeFeedsInfo.h = a(paramSocializeFeedsInfo.uint32_follow_status);
      localSocializeFeedsInfo.jdField_a_of_type_Prd = prd.a((feeds_info.ShareWebPageInfo)paramSocializeFeedsInfo.share_web_page_info.get());
      QLog.d("SocializeFeedsInfo", 1, "create SocialFeedsInfo, feedsID : " + localSocializeFeedsInfo.jdField_a_of_type_Long + ", followCnt : " + localSocializeFeedsInfo.i + ", followStatus : " + localSocializeFeedsInfo.h + ", masterUin : " + localSocializeFeedsInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long + ", followStatusHas : " + paramSocializeFeedsInfo.uint32_follow_status.has());
      if ((!paramSocializeFeedsInfo.rpt_recommend_list.has()) || (paramSocializeFeedsInfo.rpt_recommend_list.get() == null)) {
        break label532;
      }
      localObject1 = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      label390:
      if (!((Iterator)localObject1).hasNext()) {
        break label532;
      }
      localObject3 = (articlesummary.SocializeFeedsInfoUser)((Iterator)localObject1).next();
      localSocializeFeedsInfo.getClass();
      localObject4 = new pqo(localSocializeFeedsInfo);
      if ((!((articlesummary.SocializeFeedsInfoUser)localObject3).has()) || (((articlesummary.SocializeFeedsInfoUser)localObject3).get() == null)) {
        break label522;
      }
      l1 = a(((articlesummary.SocializeFeedsInfoUser)localObject3).uint64_uin);
      label454:
      ((pqo)localObject4).jdField_a_of_type_Long = l1;
      if ((!((articlesummary.SocializeFeedsInfoUser)localObject3).has()) || (((articlesummary.SocializeFeedsInfoUser)localObject3).get() == null)) {
        break label527;
      }
    }
    label512:
    label517:
    label522:
    label527:
    for (int m = a(((articlesummary.SocializeFeedsInfoUser)localObject3).enum_uin_type);; m = 0)
    {
      ((pqo)localObject4).jdField_a_of_type_Int = m;
      localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localObject4);
      break label390;
      l1 = 0L;
      break;
      m = 0;
      break label116;
      m = 0;
      break label156;
      l1 = 0L;
      break label454;
    }
    label532:
    if ((paramSocializeFeedsInfo.bytes_comments.has()) && (paramSocializeFeedsInfo.bytes_comments.get() != null)) {}
    Object localObject2;
    try
    {
      localObject1 = new String(paramSocializeFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      localSocializeFeedsInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = awbk.b((String)localObject1);
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
        localSocializeFeedsInfo.jdField_f_of_type_Int = a(paramSocializeFeedsInfo.uint32_biu_count);
        localSocializeFeedsInfo.jdField_g_of_type_Int = a(paramSocializeFeedsInfo.uint32_myself_biu_status);
        if ((paramSocializeFeedsInfo.msg_biu_mutli_level.has()) && (paramSocializeFeedsInfo.msg_biu_mutli_level.get() != null)) {
          localSocializeFeedsInfo.jdField_a_of_type_Pqm = localSocializeFeedsInfo.a((articlesummary.BiuMultiLevel)paramSocializeFeedsInfo.msg_biu_mutli_level.get());
        }
        if (paramSocializeFeedsInfo.game_live_info.has())
        {
          localObject1 = (articlesummary.GameLiveInfo)paramSocializeFeedsInfo.game_live_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_Pqq = new pqq();
          if (((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqq.jdField_a_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).uint32_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqq.jdField_a_of_type_Int = ((articlesummary.GameLiveInfo)localObject1).uint32_status.get();
          }
          if (((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqq.jdField_b_of_type_Int = ((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.get();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_game_name.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqq.jdField_d_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_game_name.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_play_url.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqq.jdField_c_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_play_url.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqq.jdField_e_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqq.jdField_f_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_status.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqq.jdField_g_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.get().toStringUtf8();
          }
        }
        if (paramSocializeFeedsInfo.uint64_article_id.has()) {
          localSocializeFeedsInfo.jdField_b_of_type_Long = paramSocializeFeedsInfo.uint64_article_id.get();
        }
        if (paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.has())
        {
          localObject1 = (articlesummary.UGCFeedsInfo)paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_Pre = new pre();
          if (((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int = ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long = ((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_b_of_type_Int = ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaLangString = ((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.get().toStringUtf8();
          }
          if ((((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.has()) && (((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.get() != null)) {
            localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_a_of_type_Pqm = localSocializeFeedsInfo.a((articlesummary.BiuMultiLevel)((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.get());
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).account_profile.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_a_of_type_Pqk = pqk.a((feeds_info.AccountProfile)((articlesummary.UGCFeedsInfo)localObject1).account_profile.get());
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).msg_ugc_pic_info_list.has())
          {
            localObject3 = ((articlesummary.UGCFeedsInfo)localObject1).msg_ugc_pic_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (articlesummary.UGCPicInfo)((Iterator)localObject3).next();
              localObject5 = new prf();
              if (((articlesummary.UGCPicInfo)localObject4).bytes_pic_md5.has()) {
                ((prf)localObject5).jdField_a_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).bytes_pic_url.has()) {
                ((prf)localObject5).jdField_b_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).uint32_pic_height.has()) {
                ((prf)localObject5).jdField_b_of_type_Int = ((articlesummary.UGCPicInfo)localObject4).uint32_pic_height.get();
              }
              if (((articlesummary.UGCPicInfo)localObject4).uint32_pic_width.has()) {
                ((prf)localObject5).jdField_a_of_type_Int = ((articlesummary.UGCPicInfo)localObject4).uint32_pic_width.get();
              }
              if (((articlesummary.UGCPicInfo)localObject4).bytes_thumbnail_url.has()) {
                ((prf)localObject5).jdField_c_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject4).bytes_thumbnail_url.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).is_animation.has()) {
                ((prf)localObject5).jdField_c_of_type_Int = ((articlesummary.UGCPicInfo)localObject4).is_animation.get();
              }
              localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
              continue;
              localException1 = localException1;
              QLog.d("SocializeFeedsInfo", 1, "parse bytes_comments failed ", localException1);
            }
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject5;
        for (;;)
        {
          QLog.d("SocializeFeedsInfo", 1, "parse bytes_comments reason failed ", localException2);
        }
        if (localException2.msg_ugc_video_info_list.has())
        {
          localObject3 = localException2.msg_ugc_video_info_list.get().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (articlesummary.UGCVideoInfo)((Iterator)localObject3).next();
            localObject5 = new prg();
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_pic_md5.has()) {
              ((prg)localObject5).jdField_c_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_pic_url.has()) {
              ((prg)localObject5).jdField_d_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_pic_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_title.has()) {
              ((prg)localObject5).jdField_e_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_title.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_uuid.has()) {
              ((prg)localObject5).jdField_f_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_uuid.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_video_md5.has()) {
              ((prg)localObject5).jdField_a_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_video_md5.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_video_url.has()) {
              ((prg)localObject5).jdField_b_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_video_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_share_url.has()) {
              ((prg)localObject5).h = ((articlesummary.UGCVideoInfo)localObject4).bytes_share_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_vid.has()) {
              ((prg)localObject5).i = ((articlesummary.UGCVideoInfo)localObject4).bytes_vid.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_uniq_id.has()) {
              ((prg)localObject5).jdField_g_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_uniq_id.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_busi_type.has()) {
              ((prg)localObject5).jdField_f_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_busi_type.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_create_time.has()) {
              ((prg)localObject5).jdField_e_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_create_time.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint64_duration.has()) {
              ((prg)localObject5).jdField_a_of_type_Long = ((articlesummary.UGCVideoInfo)localObject4).uint64_duration.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_video_width.has()) {
              ((prg)localObject5).jdField_a_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_video_width.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_video_height.has()) {
              ((prg)localObject5).jdField_b_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_video_height.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_pic_width.has()) {
              ((prg)localObject5).jdField_c_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_pic_width.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_pic_height.has()) {
              ((prg)localObject5).jdField_d_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_pic_height.get();
            }
            localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
          }
        }
        if (localException2.msg_ugc_voice_info_list.has())
        {
          localObject3 = localException2.msg_ugc_voice_info_list.get().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (articlesummary.UGCVoiceInfo)((Iterator)localObject3).next();
            localObject5 = new SocializeFeedsInfo.UGCVoiceInfo();
            ((SocializeFeedsInfo.UGCVoiceInfo)localObject5).jdField_a_of_type_JavaLangString = ((articlesummary.UGCVoiceInfo)localObject4).bytes_voice_url.get().toStringUtf8();
            ((SocializeFeedsInfo.UGCVoiceInfo)localObject5).jdField_a_of_type_Int = ((articlesummary.UGCVoiceInfo)localObject4).uint32_duration.get();
            ((SocializeFeedsInfo.UGCVoiceInfo)localObject5).jdField_b_of_type_Int = ((articlesummary.UGCVoiceInfo)localObject4).uint32_file_size.get();
            localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_c_of_type_JavaUtilArrayList.add(localObject5);
          }
        }
        if (localException2.bytes_jump_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_c_of_type_JavaLangString = localException2.bytes_jump_url.get().toStringUtf8();
        }
        if (paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.has())
        {
          localObject2 = (articlesummary.PGCFeedsInfo)paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_Pqz = new pqz();
          if (((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString = ((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.get().toStringUtf8();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqz.jdField_b_of_type_Int = ((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.get();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqz.jdField_a_of_type_Int = ((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.get();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_article_type.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Pqz.jdField_a_of_type_Boolean = true;
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.has())
          {
            localObject3 = ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject6 = (articlesummary.PGCPicInfo)((Iterator)localObject3).next();
              localObject4 = new pra();
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.has()) {
                ((pra)localObject4).jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.has()) {
                ((pra)localObject4).jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.has()) {
                ((pra)localObject4).jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.has()) {
                ((pra)localObject4).jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).is_animation.has()) {
                ((pra)localObject4).jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject6).is_animation.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.has()) {
                ((pra)localObject4).jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.has()) {
                ((pra)localObject4).jdField_d_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.has()) {
                ((pra)localObject4).jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).msg_video_info.has())
              {
                localObject5 = new prb();
                localObject6 = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject6).msg_video_info.get();
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.has()) {
                  ((prb)localObject5).jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.has()) {
                  ((prb)localObject5).jdField_d_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_vid.has()) {
                  ((prb)localObject5).jdField_e_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject6).bytes_vid.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).uint32_duration.has()) {
                  ((prb)localObject5).jdField_a_of_type_Int = ((articlesummary.PGCVideoInfo)localObject6).uint32_duration.get();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).uint32_busi_type.has()) {
                  ((prb)localObject5).jdField_b_of_type_Int = ((articlesummary.PGCVideoInfo)localObject6).uint32_busi_type.get();
                }
                ((pra)localObject4).jdField_a_of_type_Prb = ((prb)localObject5);
              }
              localSocializeFeedsInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
            }
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.has())
          {
            localObject3 = ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (articlesummary.PGCVideoInfo)((Iterator)localObject3).next();
              localObject5 = new prb();
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5.has()) {
                ((prb)localObject5).jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url.has()) {
                ((prb)localObject5).jdField_d_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5.has()) {
                ((prb)localObject5).jdField_a_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_video_url.has()) {
                ((prb)localObject5).jdField_b_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject4).bytes_video_url.get().toStringUtf8();
              }
              localSocializeFeedsInfo.jdField_a_of_type_Pqz.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
            }
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.has())
          {
            localSocializeFeedsInfo.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp = new pqp();
            localObject2 = (articlesummary.GalleryPGCFeedsInfo)((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.get();
            if (((articlesummary.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.has()) {
              localSocializeFeedsInfo.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_a_of_type_Long = ((articlesummary.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.get();
            }
          }
        }
        if (!paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) {
          break label4747;
        }
      }
    }
    localSocializeFeedsInfo.jdField_a_of_type_Prv = prv.a((articlesummary.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get());
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.topicRecommendFeedsInfo = ", localSocializeFeedsInfo.jdField_a_of_type_Prv });
    if (paramSocializeFeedsInfo.bytes_recommend_account_reason.has())
    {
      localSocializeFeedsInfo.jdField_d_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_recommend_account_reason.get().toStringUtf8();
      QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.mRecommendAccountReason = ", localSocializeFeedsInfo.jdField_d_of_type_JavaLangString });
      label3083:
      if (paramSocializeFeedsInfo.wenda_info.has())
      {
        localSocializeFeedsInfo.jdField_a_of_type_Pri = new pri();
        localObject2 = (articlesummary.WendaInfo)paramSocializeFeedsInfo.wenda_info.get();
        if (((articlesummary.WendaInfo)localObject2).uint32_is_super_wenda.has())
        {
          if (((articlesummary.WendaInfo)localObject2).uint32_is_super_wenda.get() != 1) {
            break label4773;
          }
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_a_of_type_Boolean = true;
        }
        label3149:
        if (((articlesummary.WendaInfo)localObject2).bytes_question_rowkey.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_a_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_question_rowkey.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_question_desc.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_b_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_question_desc.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_question_pic_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_c_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_question_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_wenda_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_d_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_wenda_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).uint32_follow_count.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_a_of_type_Int = ((articlesummary.WendaInfo)localObject2).uint32_follow_count.get();
        }
        if (((articlesummary.WendaInfo)localObject2).uint32_answer_count.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_b_of_type_Int = ((articlesummary.WendaInfo)localObject2).uint32_answer_count.get();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_icon_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_e_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_icon_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_answer_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_f_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_answer_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_c_of_type_Int = ((articlesummary.WendaInfo)localObject2).channel_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.h = ((articlesummary.WendaInfo)localObject2).channel_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_second_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_d_of_type_Int = ((articlesummary.WendaInfo)localObject2).channel_second_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_second_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.i = ((articlesummary.WendaInfo)localObject2).channel_second_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).tag_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_a_of_type_JavaUtilList = ((articlesummary.WendaInfo)localObject2).tag_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).tag_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_b_of_type_JavaUtilList = ((articlesummary.WendaInfo)localObject2).tag_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).author_nick.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.j = ((articlesummary.WendaInfo)localObject2).author_nick.get();
        }
        if (((articlesummary.WendaInfo)localObject2).jump_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.k = ((articlesummary.WendaInfo)localObject2).jump_url.get();
        }
        if (((articlesummary.WendaInfo)localObject2).images_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_c_of_type_JavaUtilList = ((articlesummary.WendaInfo)localObject2).images_url.get();
        }
        if (((articlesummary.WendaInfo)localObject2).icon_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.l = ((articlesummary.WendaInfo)localObject2).icon_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).icon_color.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.m = ((articlesummary.WendaInfo)localObject2).icon_color.get();
        }
        if (((articlesummary.WendaInfo)localObject2).super_wenda_button_title.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Pri.n = ((articlesummary.WendaInfo)localObject2).super_wenda_button_title.get();
        }
        if (((articlesummary.WendaInfo)localObject2).answer_detail.has())
        {
          localObject2 = (articlesummary.AnswerDetail)((articlesummary.WendaInfo)localObject2).answer_detail.get();
          localSocializeFeedsInfo.jdField_a_of_type_Pri.a((articlesummary.AnswerDetail)localObject2);
        }
      }
      localSocializeFeedsInfo.j = a(paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted);
      if (paramSocializeFeedsInfo.icon_wording_info.has())
      {
        localObject2 = new pqr();
        localObject3 = (feeds_info.IconWordingInfo)paramSocializeFeedsInfo.icon_wording_info.get();
        ((pqr)localObject2).jdField_a_of_type_Int = a(((feeds_info.IconWordingInfo)localObject3).uint32_type);
        if (((feeds_info.IconWordingInfo)localObject3).bytes_icon_url.has()) {
          ((pqr)localObject2).jdField_a_of_type_JavaLangString = ((feeds_info.IconWordingInfo)localObject3).bytes_icon_url.get().toStringUtf8();
        }
        if (((feeds_info.IconWordingInfo)localObject3).bytes_wording.has()) {
          ((pqr)localObject2).jdField_b_of_type_JavaLangString = ((feeds_info.IconWordingInfo)localObject3).bytes_wording.get().toStringUtf8();
        }
        if (((feeds_info.IconWordingInfo)localObject3).bytes_status_icon_url.has()) {
          ((pqr)localObject2).jdField_c_of_type_JavaLangString = ((feeds_info.IconWordingInfo)localObject3).bytes_status_icon_url.get().toStringUtf8();
        }
        ((pqr)localObject2).jdField_b_of_type_Int = a(((feeds_info.IconWordingInfo)localObject3).uint32_status);
        if (((feeds_info.IconWordingInfo)localObject3).bytes_status.has()) {
          ((pqr)localObject2).jdField_d_of_type_JavaLangString = ((feeds_info.IconWordingInfo)localObject3).bytes_status.get().toStringUtf8();
        }
        ((pqr)localObject2).jdField_c_of_type_Int = a(((feeds_info.IconWordingInfo)localObject3).uint32_icon_show_mode);
        localSocializeFeedsInfo.jdField_a_of_type_Pqr = ((pqr)localObject2);
      }
      if (paramSocializeFeedsInfo.uint32_feed_status.has()) {
        localSocializeFeedsInfo.k = paramSocializeFeedsInfo.uint32_feed_status.get();
      }
      if (paramSocializeFeedsInfo.bytes_private_status_title.has()) {
        localSocializeFeedsInfo.jdField_e_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_private_status_title.get().toStringUtf8();
      }
      if ((paramSocializeFeedsInfo.location_info.has()) && (paramSocializeFeedsInfo.location_info.get() != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_Pqt = new pqt();
        localObject3 = (feeds_info.LocationInfo)paramSocializeFeedsInfo.location_info.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_Pqt;
        if (!((feeds_info.LocationInfo)localObject3).bytes_name.has()) {
          break label4785;
        }
        localObject2 = ((feeds_info.LocationInfo)localObject3).bytes_name.get().toStringUtf8();
        label4060:
        ((pqt)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject2);
        localSocializeFeedsInfo.jdField_a_of_type_Pqt.jdField_a_of_type_Int = ((feeds_info.LocationInfo)localObject3).uint32_longitude.get();
        localSocializeFeedsInfo.jdField_a_of_type_Pqt.jdField_b_of_type_Int = ((feeds_info.LocationInfo)localObject3).uint32_latitude.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_Pqt;
        if (!((feeds_info.LocationInfo)localObject3).bytes_icon_url.has()) {
          break label4792;
        }
        localObject2 = ((feeds_info.LocationInfo)localObject3).bytes_icon_url.get().toStringUtf8();
        label4130:
        ((pqt)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject2);
      }
      if (paramSocializeFeedsInfo.uint32_is_jump_recommend_page.has())
      {
        localSocializeFeedsInfo.l = a(paramSocializeFeedsInfo.uint32_is_jump_recommend_page);
        if (paramSocializeFeedsInfo.bytes_jump_recommend_url.has()) {
          localSocializeFeedsInfo.jdField_f_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_jump_recommend_url.get().toStringUtf8();
        }
        if (paramSocializeFeedsInfo.bytes_jump_recommend_prompt.has()) {
          localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_jump_recommend_prompt.get().toStringUtf8();
        }
        QLog.d("SocializeFeedsInfo", 1, "parse jumpchannel " + localSocializeFeedsInfo.l + "  " + localSocializeFeedsInfo.jdField_f_of_type_JavaLangString + "  " + localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
      }
      if ((paramSocializeFeedsInfo.visible_info.has()) && (paramSocializeFeedsInfo.visible_info.visible_show_info.has()))
      {
        localSocializeFeedsInfo.jdField_a_of_type_Prc = new prc();
        localObject2 = (feeds_info.VisibleShowInfo)paramSocializeFeedsInfo.visible_info.visible_show_info.get();
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Prc;
        if (!((feeds_info.VisibleShowInfo)localObject2).uint64_feed_id.has()) {
          break label4799;
        }
        l1 = ((feeds_info.VisibleShowInfo)localObject2).uint64_feed_id.get();
        label4345:
        ((prc)localObject3).jdField_b_of_type_Long = l1;
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Prc;
        m = n;
        if (((feeds_info.VisibleShowInfo)localObject2).uint32_visible_type.has()) {
          m = ((feeds_info.VisibleShowInfo)localObject2).uint32_visible_type.get();
        }
        ((prc)localObject3).jdField_a_of_type_Int = m;
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Prc;
        l1 = l2;
        if (((feeds_info.VisibleShowInfo)localObject2).uint64_who.has()) {
          l1 = ((feeds_info.VisibleShowInfo)localObject2).uint64_who.get();
        }
        ((prc)localObject3).jdField_a_of_type_Long = l1;
        QLog.d("SocializeFeedsInfo", 1, "feeds privacy | feedsid  " + localSocializeFeedsInfo.jdField_a_of_type_Prc.jdField_b_of_type_Long + " | privacyType " + localSocializeFeedsInfo.jdField_a_of_type_Prc.jdField_a_of_type_Int + " | privacySetUin " + localSocializeFeedsInfo.jdField_a_of_type_Prc.jdField_a_of_type_Long);
      }
      if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.has())) {
        a(localSocializeFeedsInfo, ((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.get());
      }
      if ((paramSocializeFeedsInfo.buluo_info.has()) && (paramSocializeFeedsInfo.buluo_info.get() != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_Pqn = new pqn();
        localObject2 = (articlesummary.BuluoInfo)paramSocializeFeedsInfo.buluo_info.get();
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Pqn;
        if (!((articlesummary.BuluoInfo)localObject2).bytes_wording.has()) {
          break label4804;
        }
        paramSocializeFeedsInfo = ((articlesummary.BuluoInfo)localObject2).bytes_wording.get().toStringUtf8();
        label4614:
        ((pqn)localObject3).jdField_a_of_type_JavaLangString = paramSocializeFeedsInfo;
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Pqn;
        if (!((articlesummary.BuluoInfo)localObject2).bytes_head_url.has()) {
          break label4810;
        }
        paramSocializeFeedsInfo = ((articlesummary.BuluoInfo)localObject2).bytes_head_url.get().toStringUtf8();
        label4650:
        ((pqn)localObject3).jdField_d_of_type_JavaLangString = paramSocializeFeedsInfo;
        localSocializeFeedsInfo.jdField_a_of_type_Pqn.jdField_a_of_type_Long = ((articlesummary.BuluoInfo)localObject2).uint64_buluo_id.get();
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Pqn;
        if (!((articlesummary.BuluoInfo)localObject2).bytes_jump_url.has()) {
          break label4816;
        }
        paramSocializeFeedsInfo = ((articlesummary.BuluoInfo)localObject2).bytes_jump_url.get().toStringUtf8();
        label4702:
        ((pqn)localObject3).jdField_b_of_type_JavaLangString = paramSocializeFeedsInfo;
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Pqn;
        if (!((articlesummary.BuluoInfo)localObject2).bytes_name.has()) {
          break label4822;
        }
      }
    }
    label4747:
    label4773:
    label4785:
    label4792:
    label4799:
    label4804:
    label4810:
    label4816:
    label4822:
    for (paramSocializeFeedsInfo = ((articlesummary.BuluoInfo)localObject2).bytes_name.get().toStringUtf8();; paramSocializeFeedsInfo = "")
    {
      ((pqn)localObject3).jdField_c_of_type_JavaLangString = paramSocializeFeedsInfo;
      return localSocializeFeedsInfo;
      QLog.d("SocializeFeedsInfo", 1, "info.topicRecommendFeedsInfo is null.");
      break;
      QLog.d("SocializeFeedsInfo", 1, "info.mRecommendAccountReason is null.");
      break label3083;
      localSocializeFeedsInfo.jdField_a_of_type_Pri.jdField_a_of_type_Boolean = false;
      break label3149;
      localObject2 = "";
      break label4060;
      localObject2 = "";
      break label4130;
      l1 = 0L;
      break label4345;
      paramSocializeFeedsInfo = "";
      break label4614;
      paramSocializeFeedsInfo = "";
      break label4650;
      paramSocializeFeedsInfo = "";
      break label4702;
    }
  }
  
  private static void a(SocializeFeedsInfo paramSocializeFeedsInfo, List<oidb_cmd0xb57.MedalInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      paramList = (oidb_cmd0xb57.MedalInfo)paramList.get(0);
      paramSocializeFeedsInfo.jdField_a_of_type_Nis = new nis();
      if (paramList.bytes_jump_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Nis.jdField_c_of_type_JavaLangString = paramList.bytes_jump_url.get().toStringUtf8();
      }
      if (paramList.uint32_is_jump.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Nis.jdField_b_of_type_Int = paramList.uint32_is_jump.get();
      }
      if (paramList.uint32_medal_type.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Nis.jdField_a_of_type_Int = paramList.uint32_medal_type.get();
      }
      if (paramList.uint64_medal_id.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Nis.jdField_a_of_type_Long = paramList.uint64_medal_id.get();
      }
      if (paramList.bytes_medal_name.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Nis.jdField_a_of_type_JavaLangString = paramList.bytes_medal_name.get().toStringUtf8();
      }
      if (paramList.bytes_medal_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Nis.jdField_b_of_type_JavaLangString = paramList.bytes_medal_url.get().toStringUtf8();
      }
      if (paramList.uint32_pic_width.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Nis.jdField_c_of_type_Int = paramList.uint32_pic_width.get();
      }
    } while (!paramList.uint32_pic_height.has());
    paramSocializeFeedsInfo.jdField_a_of_type_Nis.jdField_d_of_type_Int = paramList.uint32_pic_height.get();
  }
  
  public SocializeFeedsInfo a()
  {
    try
    {
      localSocializeFeedsInfo1 = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo1.jdField_a_of_type_Pqo = this.jdField_a_of_type_Pqo.a();
        localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          pqo localpqo = (pqo)localIterator.next();
          localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList.add(localpqo.a());
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
    } while (this.jdField_a_of_type_Pqm == null);
    localSocializeFeedsInfo1.jdField_a_of_type_Pqm = this.jdField_a_of_type_Pqm.a();
    return localSocializeFeedsInfo1;
  }
  
  public pqm a(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    pqm localpqm = new pqm();
    localpqm.jdField_a_of_type_JavaLangLong = Long.valueOf(a(paramBiuMultiLevel.uint64_origin_feeds_id));
    localpqm.jdField_b_of_type_JavaLangLong = Long.valueOf(a(paramBiuMultiLevel.uint64_origin_feeds_type));
    if ((paramBiuMultiLevel.rpt_biu_mutli_level.has()) && (paramBiuMultiLevel.rpt_biu_mutli_level.get() != null))
    {
      paramBiuMultiLevel = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
      while (paramBiuMultiLevel.hasNext())
      {
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)paramBiuMultiLevel.next();
        localpqm.jdField_a_of_type_JavaUtilList.add(a(localBiuOneLevelItem));
      }
    }
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "convertPb2BiuInfo, mFeedsId =  ", Long.valueOf(this.jdField_a_of_type_Long), ", mOriFeedType = ", localpqm.jdField_b_of_type_JavaLangLong });
    return localpqm;
  }
  
  public void a(oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null) {
      return;
    }
    this.jdField_b_of_type_Int = a(paramSocializeFeedsInfo.uint32_like_count);
    this.jdField_d_of_type_Int = a(paramSocializeFeedsInfo.uint32_comments_count);
    this.jdField_c_of_type_Int = a(paramSocializeFeedsInfo.uint32_myself_like_status);
    this.jdField_f_of_type_Int = a(paramSocializeFeedsInfo.uint32_biu_count);
    this.jdField_g_of_type_Int = a(paramSocializeFeedsInfo.uint32_myself_biu_status);
    if (paramSocializeFeedsInfo.uint32_follow_count.has()) {
      this.i = a(paramSocializeFeedsInfo.uint32_follow_count);
    }
    if (paramSocializeFeedsInfo.uint32_follow_status.has()) {
      this.h = a(paramSocializeFeedsInfo.uint32_follow_status);
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
        pqo localpqo = new pqo(this);
        if ((((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).has()) && (((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).get() != null)) {}
        for (long l1 = a(((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).uint64_uin);; l1 = 0L)
        {
          localpqo.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_JavaUtilList.add(localpqo);
          break;
        }
      }
    }
    if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (this.jdField_a_of_type_Prv != null) && (this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramSocializeFeedsInfo = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
      if (paramSocializeFeedsInfo.msg_topic_recommend_info.has())
      {
        paramSocializeFeedsInfo = paramSocializeFeedsInfo.msg_topic_recommend_info.get();
        int m = 0;
        while ((m < paramSocializeFeedsInfo.size()) && (m < this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject1 = (oidb_cmd0x8c8.TopicRecommendInfo)paramSocializeFeedsInfo.get(m);
          localObject2 = (prx)this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.get(m);
          if (((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.has()) {
            ((prx)localObject2).jdField_b_of_type_Int = ((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.get();
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
    articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new articlesummary.SocializeFeedsInfoUser();
    localSocializeFeedsInfoUser.uint64_uin.set(this.jdField_a_of_type_Pqo.jdField_a_of_type_Long);
    localSocializeFeedsInfoUser.enum_uin_type.set(this.jdField_a_of_type_Pqo.jdField_a_of_type_Int);
    localSocializeFeedsInfoUser.uint32_star_style.set(this.jdField_a_of_type_Pqo.jdField_b_of_type_Int);
    localSocializeFeedsInfo.msg_master_uin.set(localSocializeFeedsInfoUser);
    localSocializeFeedsInfo.uint32_follow_counts.set(this.i);
    localSocializeFeedsInfo.uint32_follow_status.set(this.h);
    if (this.jdField_a_of_type_Prd != null) {
      localSocializeFeedsInfo.share_web_page_info.set(this.jdField_a_of_type_Prd.a());
    }
    Object localObject1 = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (pqo)((Iterator)localObject3).next();
      localObject5 = new articlesummary.SocializeFeedsInfoUser();
      ((articlesummary.SocializeFeedsInfoUser)localObject5).uint64_uin.set(((pqo)localObject4).jdField_a_of_type_Long);
      ((articlesummary.SocializeFeedsInfoUser)localObject5).enum_uin_type.set(((pqo)localObject4).jdField_a_of_type_Int);
      ((List)localObject1).add(localObject5);
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
      if (this.jdField_a_of_type_Pqm != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.jdField_a_of_type_Pqm.a());
      }
    }
    catch (Exception localException)
    {
      Object localObject6;
      for (;;)
      {
        QLog.d("SocializeFeedsInfo", 1, "merge info failed ", localException);
      }
      localException.msg_ugc_pic_info_list.set((List)localObject3);
      if ((this.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1394;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_Pre.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (prg)((Iterator)localObject4).next();
        localObject6 = new articlesummary.UGCVideoInfo();
        ((articlesummary.UGCVideoInfo)localObject6).uint64_duration.set(((prg)localObject5).jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(((prg)localObject5).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prg)localObject5).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prg)localObject5).jdField_f_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_uuid.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prg)localObject5).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prg)localObject5).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prg)localObject5).jdField_e_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_title.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prg)localObject5).jdField_g_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).jdField_g_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prg)localObject5).h)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_share_url.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).h));
        }
        if (!TextUtils.isEmpty(((prg)localObject5).i)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_vid.set(ByteStringMicro.copyFromUtf8(((prg)localObject5).i));
        }
        ((articlesummary.UGCVideoInfo)localObject6).uint32_create_time.set(((prg)localObject5).jdField_e_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_busi_type.set(((prg)localObject5).jdField_f_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_pic_height.set(((prg)localObject5).jdField_d_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_pic_width.set(((prg)localObject5).jdField_c_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_video_height.set(((prg)localObject5).jdField_b_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_video_width.set(((prg)localObject5).jdField_a_of_type_Int);
        ((List)localObject3).add(localObject6);
      }
      localException.msg_ugc_video_info_list.set((List)localObject3);
      if ((this.jdField_a_of_type_Pre.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Pre.jdField_c_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1544;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_Pre.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (SocializeFeedsInfo.UGCVoiceInfo)((Iterator)localObject4).next();
        localObject6 = new articlesummary.UGCVoiceInfo();
        ((articlesummary.UGCVoiceInfo)localObject6).uint32_duration.set(((SocializeFeedsInfo.UGCVoiceInfo)localObject5).jdField_a_of_type_Int);
        ((articlesummary.UGCVoiceInfo)localObject6).uint32_file_size.set(((SocializeFeedsInfo.UGCVoiceInfo)localObject5).jdField_b_of_type_Int);
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVoiceInfo)localObject5).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCVoiceInfo)localObject6).bytes_voice_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVoiceInfo)localObject5).jdField_a_of_type_JavaLangString));
        }
        ((List)localObject3).add(localObject6);
      }
      localException.msg_ugc_voice_info_list.set((List)localObject3);
      if (this.jdField_a_of_type_Pre.jdField_a_of_type_Pqk == null) {
        break label1571;
      }
      localException.account_profile.set(this.jdField_a_of_type_Pre.jdField_a_of_type_Pqk.a());
      if (TextUtils.isEmpty(this.jdField_a_of_type_Pre.jdField_c_of_type_JavaLangString)) {
        break label1601;
      }
      localException.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pre.jdField_c_of_type_JavaLangString));
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(localException);
      if (this.jdField_a_of_type_Pqz == null) {
        break label2908;
      }
      localObject2 = new articlesummary.PGCFeedsInfo();
      if (TextUtils.isEmpty(this.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString)) {
        break label1654;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString));
      if (!this.jdField_a_of_type_Pqz.jdField_a_of_type_Boolean) {
        break label1672;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_article_type.set(1);
      if (this.jdField_a_of_type_Pqz.jdField_b_of_type_Int == -1) {
        break label1697;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.set(this.jdField_a_of_type_Pqz.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Pqz.jdField_a_of_type_Int == -1) {
        break label1722;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.set(this.jdField_a_of_type_Pqz.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2215;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject7;
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (pra)((Iterator)localObject4).next();
        localObject6 = new articlesummary.PGCPicInfo();
        if (!TextUtils.isEmpty(((pra)localObject5).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((pra)localObject5).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_b_of_type_JavaLangString));
        }
        ((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.set(((pra)localObject5).jdField_b_of_type_Int);
        ((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.set(((pra)localObject5).jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(((pra)localObject5).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((pra)localObject5).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_d_of_type_JavaLangString));
        }
        if (((pra)localObject5).jdField_a_of_type_Long != -1L) {
          ((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.set(((pra)localObject5).jdField_a_of_type_Long);
        }
        if (((pra)localObject5).jdField_a_of_type_Prb != null)
        {
          localObject7 = new articlesummary.PGCVideoInfo();
          if (!TextUtils.isEmpty(((pra)localObject5).jdField_a_of_type_Prb.jdField_e_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_vid.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_a_of_type_Prb.jdField_e_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((pra)localObject5).jdField_a_of_type_Prb.jdField_b_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_a_of_type_Prb.jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((pra)localObject5).jdField_a_of_type_Prb.jdField_a_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_a_of_type_Prb.jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((pra)localObject5).jdField_a_of_type_Prb.jdField_c_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_a_of_type_Prb.jdField_c_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((pra)localObject5).jdField_a_of_type_Prb.jdField_d_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((pra)localObject5).jdField_a_of_type_Prb.jdField_d_of_type_JavaLangString));
          }
          ((articlesummary.PGCVideoInfo)localObject7).uint32_duration.set(((pra)localObject5).jdField_a_of_type_Prb.jdField_a_of_type_Int);
          ((articlesummary.PGCVideoInfo)localObject7).uint32_busi_type.set(((pra)localObject5).jdField_a_of_type_Prb.jdField_b_of_type_Int);
          ((articlesummary.PGCPicInfo)localObject6).msg_video_info.set((MessageMicro)localObject7);
        }
        ((articlesummary.PGCPicInfo)localObject6).is_animation.set(((pra)localObject5).jdField_c_of_type_Int);
        ((List)localObject3).add(localObject6);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.set((List)localObject3);
      if ((this.jdField_a_of_type_Pqz.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Pqz.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2420;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_Pqz.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (prb)((Iterator)localObject4).next();
        localObject6 = new articlesummary.PGCVideoInfo();
        if (!TextUtils.isEmpty(((prb)localObject5).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((prb)localObject5).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prb)localObject5).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((prb)localObject5).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prb)localObject5).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((prb)localObject5).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((prb)localObject5).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((prb)localObject5).jdField_d_of_type_JavaLangString));
        }
        ((List)localObject3).add(localObject6);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.set((List)localObject3);
      ((articlesummary.PGCFeedsInfo)localObject2).enum_pgc_feeds_type.set(this.jdField_a_of_type_Pqz.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp == null) {
        break label2900;
      }
      localObject3 = new articlesummary.GalleryPGCFeedsInfo();
      if (this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_a_of_type_Long == -1L) {
        break label2488;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_pic_count.set(this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_b_of_type_Long == -1L) {
        break label2523;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_source.set(this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.c == -1L) {
        break label2558;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_sub_source.set(this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.c);
      if (TextUtils.isEmpty(this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_a_of_type_JavaLangString)) {
        break label2595;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).bytes_gallery_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_a_of_type_JavaLangString));
      if ((this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2891;
      }
      localObject4 = new ArrayList();
      localObject5 = this.jdField_a_of_type_Pqz.jdField_a_of_type_Pqp.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (pra)((Iterator)localObject5).next();
        localObject7 = new articlesummary.PGCPicInfo();
        if (((pra)localObject6).jdField_a_of_type_Int != -1) {
          ((articlesummary.PGCPicInfo)localObject7).uint32_pic_width.set(((pra)localObject6).jdField_a_of_type_Int);
        }
        if (((pra)localObject6).jdField_b_of_type_Int != -1) {
          ((articlesummary.PGCPicInfo)localObject7).uint32_pic_height.set(((pra)localObject6).jdField_b_of_type_Int);
        }
        if (!TextUtils.isEmpty(((pra)localObject6).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((pra)localObject6).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((pra)localObject6).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((pra)localObject6).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((pra)localObject6).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((pra)localObject6).jdField_c_of_type_JavaLangString));
        }
        if (((pra)localObject6).jdField_c_of_type_Int != -1) {
          ((articlesummary.PGCPicInfo)localObject7).is_animation.set(((pra)localObject6).jdField_c_of_type_Int);
        }
        if (!TextUtils.isEmpty(((pra)localObject6).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(((pra)localObject6).jdField_d_of_type_JavaLangString));
        }
        if (((pra)localObject6).jdField_a_of_type_Long != -1L) {
          ((articlesummary.PGCPicInfo)localObject7).uint64_gallery_index.set(((pra)localObject6).jdField_a_of_type_Long);
        }
        ((List)localObject4).add(localObject7);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.set((MessageMicro)localObject3);
      localSocializeFeedsInfo.msg_pgc_topic_feeds_info.set((MessageMicro)localObject2);
      if (this.jdField_a_of_type_Prv == null) {
        break label2929;
      }
      localSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.jdField_a_of_type_Prv.a());
      if (this.jdField_d_of_type_JavaLangString == null) {
        break label2950;
      }
      localSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
      if (this.jdField_a_of_type_Pri == null) {
        break label2971;
      }
      localSocializeFeedsInfo.wenda_info.set(this.jdField_a_of_type_Pri.a());
      localSocializeFeedsInfo.uint32_is_origin_feeds_deleted.set(this.j);
      if (this.jdField_a_of_type_Pqr == null) {
        break label3003;
      }
      localSocializeFeedsInfo.icon_wording_info.set(this.jdField_a_of_type_Pqr.a());
      if (this.jdField_a_of_type_Pqt == null) {
        break label3122;
      }
    }
    if (this.jdField_a_of_type_Pqq != null)
    {
      localObject1 = new articlesummary.GameLiveInfo();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pqq.jdField_a_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqq.jdField_a_of_type_JavaLangString));
      }
      ((articlesummary.GameLiveInfo)localObject1).uint32_status.set(this.jdField_a_of_type_Pqq.jdField_a_of_type_Int);
      ((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.set(this.jdField_a_of_type_Pqq.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pqq.jdField_d_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_game_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqq.jdField_d_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pqq.jdField_c_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_play_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqq.jdField_c_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pqq.jdField_e_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqq.jdField_e_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pqq.jdField_f_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_status.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqq.jdField_f_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pqq.jdField_g_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqq.jdField_g_of_type_JavaLangString));
      }
      localSocializeFeedsInfo.game_live_info.set((MessageMicro)localObject1);
    }
    localSocializeFeedsInfo.uint64_article_id.set(this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Pre != null)
    {
      localObject1 = new articlesummary.UGCFeedsInfo();
      ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.set(this.jdField_a_of_type_Pre.jdField_a_of_type_Int);
      ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.set(this.jdField_a_of_type_Pre.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pre.jdField_a_of_type_JavaLangString)) {
        ((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pre.jdField_a_of_type_JavaLangString));
      }
      if (this.jdField_a_of_type_Pre.jdField_a_of_type_Pqm != null) {
        ((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.set(this.jdField_a_of_type_Pre.jdField_a_of_type_Pqm.a());
      }
      ((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.set(this.jdField_a_of_type_Pre.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject3 = new ArrayList();
        localObject4 = this.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (prf)((Iterator)localObject4).next();
          localObject6 = new articlesummary.UGCPicInfo();
          ((articlesummary.UGCPicInfo)localObject6).uint32_pic_width.set(((prf)localObject5).jdField_a_of_type_Int);
          ((articlesummary.UGCPicInfo)localObject6).uint32_pic_height.set(((prf)localObject5).jdField_b_of_type_Int);
          if (!TextUtils.isEmpty(((prf)localObject5).jdField_b_of_type_JavaLangString)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((prf)localObject5).jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((prf)localObject5).jdField_a_of_type_JavaLangString)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((prf)localObject5).jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((prf)localObject5).jdField_c_of_type_JavaLangString)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((prf)localObject5).jdField_c_of_type_JavaLangString));
          }
          ((articlesummary.UGCPicInfo)localObject6).is_animation.set(((prf)localObject5).jdField_c_of_type_Int);
          ((List)localObject3).add(localObject6);
        }
      }
    }
    label1394:
    label1654:
    label2558:
    localObject3 = new feeds_info.LocationInfo();
    label1544:
    label1571:
    label1601:
    label2420:
    Object localObject4 = ((feeds_info.LocationInfo)localObject3).bytes_name;
    label1672:
    label1697:
    label1722:
    label2523:
    label2908:
    label2929:
    if (TextUtils.isEmpty(this.jdField_a_of_type_Pqt.jdField_a_of_type_JavaLangString))
    {
      localObject2 = "";
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((feeds_info.LocationInfo)localObject3).uint32_longitude.set(this.jdField_a_of_type_Pqt.jdField_a_of_type_Int);
      ((feeds_info.LocationInfo)localObject3).uint32_latitude.set(this.jdField_a_of_type_Pqt.jdField_b_of_type_Int);
      localObject4 = ((feeds_info.LocationInfo)localObject3).bytes_icon_url;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Pqt.jdField_b_of_type_JavaLangString)) {
        break label3592;
      }
    }
    label2215:
    label2488:
    label2891:
    label2900:
    for (Object localObject2 = "";; localObject2 = this.jdField_a_of_type_Pqt.jdField_b_of_type_JavaLangString)
    {
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localSocializeFeedsInfo.location_info.set((MessageMicro)localObject3);
      if (this.jdField_a_of_type_Prc != null)
      {
        localObject2 = new feeds_info.VisibleInfo();
        localObject3 = new feeds_info.VisibleShowInfo();
        ((feeds_info.VisibleShowInfo)localObject3).uint32_visible_type.set(this.jdField_a_of_type_Prc.jdField_a_of_type_Int);
        ((feeds_info.VisibleShowInfo)localObject3).uint64_feed_id.set(this.jdField_a_of_type_Prc.jdField_b_of_type_Long);
        ((feeds_info.VisibleShowInfo)localObject3).uint64_who.set(this.jdField_a_of_type_Prc.jdField_a_of_type_Long);
        ((feeds_info.VisibleInfo)localObject2).visible_show_info.set((MessageMicro)localObject3);
        localSocializeFeedsInfo.visible_info.set((MessageMicro)localObject2);
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
      if (this.jdField_a_of_type_Nis != null)
      {
        localObject2 = new ArrayList();
        localObject3 = new oidb_cmd0xb57.MedalInfo();
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_pic_width.set(this.jdField_a_of_type_Nis.jdField_d_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_pic_height.set(this.jdField_a_of_type_Nis.jdField_c_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_medal_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Nis.jdField_b_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint64_medal_id.set(this.jdField_a_of_type_Nis.jdField_a_of_type_Long);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_medal_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Nis.jdField_a_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_is_jump.set(this.jdField_a_of_type_Nis.jdField_b_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Nis.jdField_c_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_medal_type.set(this.jdField_a_of_type_Nis.jdField_a_of_type_Int);
        ((List)localObject2).add(localObject3);
        localSocializeFeedsInfoUser.rpt_msg_medal_info.set((List)localObject2);
      }
      if ((localSocializeFeedsInfo.buluo_info.has()) && (localSocializeFeedsInfo.buluo_info.get() != null))
      {
        localObject2 = new feeds_info.BuluoInfo();
        ((feeds_info.BuluoInfo)localObject2).bytes_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqn.jdField_a_of_type_JavaLangString));
        ((feeds_info.BuluoInfo)localObject2).bytes_head_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqn.jdField_d_of_type_JavaLangString));
        ((feeds_info.BuluoInfo)localObject2).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqn.jdField_b_of_type_JavaLangString));
        ((feeds_info.BuluoInfo)localObject2).bytes_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Pqn.jdField_c_of_type_JavaLangString));
        ((feeds_info.BuluoInfo)localObject2).uint64_buluo_id.set(this.jdField_a_of_type_Pqn.jdField_a_of_type_Long);
      }
      return localSocializeFeedsInfo.toByteArray();
      localObject2 = this.jdField_a_of_type_Pqt.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Prc != null) && (this.jdField_a_of_type_Prc.jdField_a_of_type_Int != 0);
  }
  
  public String toString()
  {
    return "SocializeFeedsInfo{mFeedStyle=" + this.jdField_a_of_type_Int + ", mRecommUinList=" + this.jdField_a_of_type_JavaUtilList + ", mLikeCount=" + this.jdField_b_of_type_Int + ", mLikeStatus=" + this.jdField_c_of_type_Int + ", mCommentCount=" + this.jdField_d_of_type_Int + ", mBiuTime=" + this.jdField_e_of_type_Int + ", mCommentWording='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRecommReason='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mRecommendAccountReason='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mMasterUser.uin='" + this.jdField_a_of_type_Pqo.jdField_a_of_type_Long + '\'' + ", mMasterUser.type='" + this.jdField_a_of_type_Pqo.jdField_a_of_type_Int + '\'' + ", mMasterUser.starType='" + this.jdField_a_of_type_Pqo.jdField_b_of_type_Int + '\'' + ", mBiuCount='" + this.jdField_f_of_type_Int + '\'' + ", mBiuStatus='" + this.jdField_g_of_type_Int + '\'' + ", mBiuInfo='" + this.jdField_a_of_type_Pqm + '\'' + ", mFollowStatus='" + this.h + '\'' + ", mFollowCnt='" + this.i + '\'' + ", mIsOriginFeedsDeleted='" + this.j + '\'' + ", mFeedStatus='" + this.k + '\'' + ", mPrivateStatusTitle='" + this.jdField_e_of_type_JavaLangString + '\'' + ", mIs_jump_recommend_page='" + this.l + '\'' + ", mJump_recommend__url='" + this.jdField_f_of_type_JavaLangString + '\'' + ", mJump_recommend__prompt='" + this.jdField_g_of_type_JavaLangString + '\'' + ", mPGCFeedsInfo=" + this.jdField_a_of_type_Pqz + ", mUGCFeedsInfo=" + this.jdField_a_of_type_Pre + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */