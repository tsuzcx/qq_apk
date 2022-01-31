package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import axau;
import aykk;
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
import ntz;
import pbg;
import qcd;
import qcg;
import qch;
import qci;
import qcj;
import qck;
import qcl;
import qcn;
import qco;
import qcp;
import qcv;
import qcw;
import qcx;
import qcy;
import qcz;
import qda;
import qdb;
import qdc;
import qde;
import qdq;
import qds;
import rrc;
import rre;
import rri;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;
import tencent.im.oidb.articlesummary.articlesummary.GalleryPGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
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
  public List<qci> a;
  public ntz a;
  public qcg a;
  public qch a;
  public qci a;
  public qck a;
  public qcl a;
  public qcn a;
  public qco a;
  public qcp a;
  public qcv a;
  public qcy a;
  public qcz a;
  public qda a;
  public qde a;
  public qdq a;
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
    this.jdField_a_of_type_Qci = new qci(this);
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
  
  public static SpannableStringBuilder a(ArticleInfo paramArticleInfo, String paramString, pbg parampbg, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
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
        localObject = ReadInJoyUserInfoModule.a(l1, parampbg);
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
      localArrayList.add(new rre(n, ((String)localObject).length() + n, new rri(l1, paramString, paramArticleInfo)));
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
        localArrayList.add(new rre(n, str1.length() + n, new rrc(str2, 13421772)));
        break;
      }
      localObject = ReadInJoyUserInfoModule.a();
      break label178;
    }
    label448:
    paramArticleInfo = new SpannableStringBuilder(new aykk(localStringBuilder, 7, 16));
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      parampbg = (rre)paramString.next();
      paramArticleInfo.setSpan(parampbg.a(), parampbg.a(), parampbg.b(), 17);
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
      localBiuCommentInfo.jdField_a_of_type_JavaLangString = axau.b(str);
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
    Object localObject1 = localSocializeFeedsInfo.jdField_a_of_type_Qci;
    long l1;
    label116:
    Object localObject3;
    label156:
    label207:
    Object localObject4;
    if (paramSocializeFeedsInfo.msg_master_uin.has())
    {
      l1 = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint64_uin);
      ((qci)localObject1).jdField_a_of_type_Long = l1;
      localObject1 = localSocializeFeedsInfo.jdField_a_of_type_Qci;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label564;
      }
      m = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).enum_uin_type);
      ((qci)localObject1).jdField_a_of_type_Int = m;
      localObject1 = localSocializeFeedsInfo.jdField_a_of_type_Qci;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label569;
      }
      m = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint32_star_style);
      ((qci)localObject1).jdField_b_of_type_Int = m;
      localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Qci;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label581;
      }
      if (!paramSocializeFeedsInfo.msg_master_uin.bytes_person_desc.has()) {
        break label574;
      }
      localObject1 = paramSocializeFeedsInfo.msg_master_uin.bytes_person_desc.get().toStringUtf8();
      ((qci)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
      localSocializeFeedsInfo.jdField_a_of_type_Int = a(paramSocializeFeedsInfo.uint32_feeds_style);
      localSocializeFeedsInfo.jdField_b_of_type_Int = a(paramSocializeFeedsInfo.uint32_like_count);
      localSocializeFeedsInfo.jdField_d_of_type_Int = a(paramSocializeFeedsInfo.uint32_comments_count);
      localSocializeFeedsInfo.jdField_e_of_type_Int = a(paramSocializeFeedsInfo.uint32_biu_time);
      localSocializeFeedsInfo.jdField_c_of_type_Int = a(paramSocializeFeedsInfo.uint32_myself_like_status);
      localSocializeFeedsInfo.i = a(paramSocializeFeedsInfo.uint32_follow_counts);
      localSocializeFeedsInfo.h = a(paramSocializeFeedsInfo.uint32_follow_status);
      localSocializeFeedsInfo.jdField_a_of_type_Qcz = qcz.a((feeds_info.ShareWebPageInfo)paramSocializeFeedsInfo.share_web_page_info.get());
      QLog.d("SocializeFeedsInfo", 1, "create SocialFeedsInfo, feedsID : " + localSocializeFeedsInfo.jdField_a_of_type_Long + ", followCnt : " + localSocializeFeedsInfo.i + ", followStatus : " + localSocializeFeedsInfo.h + ", masterUin : " + localSocializeFeedsInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long + ", followStatusHas : " + paramSocializeFeedsInfo.uint32_follow_status.has());
      if ((!paramSocializeFeedsInfo.rpt_recommend_list.has()) || (paramSocializeFeedsInfo.rpt_recommend_list.get() == null)) {
        break label598;
      }
      localObject1 = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      label442:
      if (!((Iterator)localObject1).hasNext()) {
        break label598;
      }
      localObject3 = (articlesummary.SocializeFeedsInfoUser)((Iterator)localObject1).next();
      localSocializeFeedsInfo.getClass();
      localObject4 = new qci(localSocializeFeedsInfo);
      if ((!((articlesummary.SocializeFeedsInfoUser)localObject3).has()) || (((articlesummary.SocializeFeedsInfoUser)localObject3).get() == null)) {
        break label588;
      }
      l1 = a(((articlesummary.SocializeFeedsInfoUser)localObject3).uint64_uin);
      label506:
      ((qci)localObject4).jdField_a_of_type_Long = l1;
      if ((!((articlesummary.SocializeFeedsInfoUser)localObject3).has()) || (((articlesummary.SocializeFeedsInfoUser)localObject3).get() == null)) {
        break label593;
      }
    }
    label564:
    label569:
    label574:
    label581:
    label588:
    label593:
    for (int m = a(((articlesummary.SocializeFeedsInfoUser)localObject3).enum_uin_type);; m = 0)
    {
      ((qci)localObject4).jdField_a_of_type_Int = m;
      localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localObject4);
      break label442;
      l1 = 0L;
      break;
      m = 0;
      break label116;
      m = 0;
      break label156;
      localObject1 = "";
      break label207;
      localObject1 = "";
      break label207;
      l1 = 0L;
      break label506;
    }
    label598:
    if ((paramSocializeFeedsInfo.bytes_comments.has()) && (paramSocializeFeedsInfo.bytes_comments.get() != null)) {}
    try
    {
      localObject1 = new String(paramSocializeFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      localSocializeFeedsInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = axau.b((String)localObject1);
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
          localSocializeFeedsInfo.jdField_a_of_type_Qcg = localSocializeFeedsInfo.a((articlesummary.BiuMultiLevel)paramSocializeFeedsInfo.msg_biu_mutli_level.get());
        }
        if (paramSocializeFeedsInfo.game_live_info.has())
        {
          localObject1 = (articlesummary.GameLiveInfo)paramSocializeFeedsInfo.game_live_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_Qck = new qck();
          if (((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qck.jdField_a_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).uint32_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qck.jdField_a_of_type_Int = ((articlesummary.GameLiveInfo)localObject1).uint32_status.get();
          }
          if (((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qck.jdField_b_of_type_Int = ((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.get();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_game_name.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qck.jdField_d_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_game_name.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_play_url.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qck.jdField_c_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_play_url.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qck.jdField_e_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qck.jdField_f_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_status.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qck.jdField_g_of_type_JavaLangString = ((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.get().toStringUtf8();
          }
        }
        if (paramSocializeFeedsInfo.uint64_article_id.has()) {
          localSocializeFeedsInfo.jdField_b_of_type_Long = paramSocializeFeedsInfo.uint64_article_id.get();
        }
        if (paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.has())
        {
          localObject1 = (articlesummary.UGCFeedsInfo)paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_Qda = new qda();
          if (((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int = ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long = ((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_b_of_type_Int = ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaLangString = ((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.get().toStringUtf8();
          }
          if ((((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.has()) && (((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.get() != null)) {
            localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcg = localSocializeFeedsInfo.a((articlesummary.BiuMultiLevel)((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.get());
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).account_profile.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcd = qcd.a((feeds_info.AccountProfile)((articlesummary.UGCFeedsInfo)localObject1).account_profile.get());
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).msg_ugc_pic_info_list.has())
          {
            localObject3 = ((articlesummary.UGCFeedsInfo)localObject1).msg_ugc_pic_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (articlesummary.UGCPicInfo)((Iterator)localObject3).next();
              localObject5 = new qdb();
              if (((articlesummary.UGCPicInfo)localObject4).bytes_pic_md5.has()) {
                ((qdb)localObject5).jdField_a_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).bytes_pic_url.has()) {
                ((qdb)localObject5).jdField_b_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).uint32_pic_height.has()) {
                ((qdb)localObject5).jdField_b_of_type_Int = ((articlesummary.UGCPicInfo)localObject4).uint32_pic_height.get();
              }
              if (((articlesummary.UGCPicInfo)localObject4).uint32_pic_width.has()) {
                ((qdb)localObject5).jdField_a_of_type_Int = ((articlesummary.UGCPicInfo)localObject4).uint32_pic_width.get();
              }
              if (((articlesummary.UGCPicInfo)localObject4).bytes_thumbnail_url.has()) {
                ((qdb)localObject5).jdField_c_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject4).bytes_thumbnail_url.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).is_animation.has()) {
                ((qdb)localObject5).jdField_c_of_type_Int = ((articlesummary.UGCPicInfo)localObject4).is_animation.get();
              }
              localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
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
            localObject5 = new qdc();
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_pic_md5.has()) {
              ((qdc)localObject5).jdField_c_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_pic_url.has()) {
              ((qdc)localObject5).jdField_d_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_pic_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_title.has()) {
              ((qdc)localObject5).jdField_e_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_title.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_uuid.has()) {
              ((qdc)localObject5).jdField_f_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_uuid.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_video_md5.has()) {
              ((qdc)localObject5).jdField_a_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_video_md5.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_video_url.has()) {
              ((qdc)localObject5).jdField_b_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_video_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_share_url.has()) {
              ((qdc)localObject5).h = ((articlesummary.UGCVideoInfo)localObject4).bytes_share_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_vid.has()) {
              ((qdc)localObject5).i = ((articlesummary.UGCVideoInfo)localObject4).bytes_vid.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_uniq_id.has()) {
              ((qdc)localObject5).jdField_g_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject4).bytes_uniq_id.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_busi_type.has()) {
              ((qdc)localObject5).jdField_f_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_busi_type.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_create_time.has()) {
              ((qdc)localObject5).jdField_e_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_create_time.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint64_duration.has()) {
              ((qdc)localObject5).jdField_a_of_type_Long = ((articlesummary.UGCVideoInfo)localObject4).uint64_duration.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_video_width.has()) {
              ((qdc)localObject5).jdField_a_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_video_width.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_video_height.has()) {
              ((qdc)localObject5).jdField_b_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_video_height.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_pic_width.has()) {
              ((qdc)localObject5).jdField_c_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_pic_width.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_pic_height.has()) {
              ((qdc)localObject5).jdField_d_of_type_Int = ((articlesummary.UGCVideoInfo)localObject4).uint32_pic_height.get();
            }
            localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
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
            localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_c_of_type_JavaUtilArrayList.add(localObject5);
          }
        }
        if (localException2.bytes_jump_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qda.jdField_c_of_type_JavaLangString = localException2.bytes_jump_url.get().toStringUtf8();
        }
        if (paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.has())
        {
          localObject2 = (articlesummary.PGCFeedsInfo)paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_Qcv = new qcv();
          if (((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString = ((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.get().toStringUtf8();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qcv.jdField_b_of_type_Int = ((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.get();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Int = ((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.get();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_article_type.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean = true;
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.has())
          {
            localObject3 = ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject6 = (articlesummary.PGCPicInfo)((Iterator)localObject3).next();
              localObject4 = new qcw();
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.has()) {
                ((qcw)localObject4).jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.has()) {
                ((qcw)localObject4).jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.has()) {
                ((qcw)localObject4).jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.has()) {
                ((qcw)localObject4).jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).is_animation.has()) {
                ((qcw)localObject4).jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject6).is_animation.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.has()) {
                ((qcw)localObject4).jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.has()) {
                ((qcw)localObject4).jdField_d_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.has()) {
                ((qcw)localObject4).jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).msg_video_info.has())
              {
                localObject5 = new qcx();
                localObject6 = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject6).msg_video_info.get();
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.has()) {
                  ((qcx)localObject5).jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.has()) {
                  ((qcx)localObject5).jdField_d_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_vid.has()) {
                  ((qcx)localObject5).jdField_e_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject6).bytes_vid.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).uint32_duration.has()) {
                  ((qcx)localObject5).jdField_a_of_type_Int = ((articlesummary.PGCVideoInfo)localObject6).uint32_duration.get();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).uint32_busi_type.has()) {
                  ((qcx)localObject5).jdField_b_of_type_Int = ((articlesummary.PGCVideoInfo)localObject6).uint32_busi_type.get();
                }
                ((qcw)localObject4).jdField_a_of_type_Qcx = ((qcx)localObject5);
              }
              localSocializeFeedsInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.add(localObject4);
            }
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.has())
          {
            localObject3 = ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (articlesummary.PGCVideoInfo)((Iterator)localObject3).next();
              localObject5 = new qcx();
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5.has()) {
                ((qcx)localObject5).jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url.has()) {
                ((qcx)localObject5).jdField_d_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5.has()) {
                ((qcx)localObject5).jdField_a_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_video_url.has()) {
                ((qcx)localObject5).jdField_b_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject4).bytes_video_url.get().toStringUtf8();
              }
              localSocializeFeedsInfo.jdField_a_of_type_Qcv.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
            }
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.has())
          {
            localSocializeFeedsInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj = new qcj();
            localObject2 = (articlesummary.GalleryPGCFeedsInfo)((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.get();
            if (((articlesummary.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.has()) {
              localSocializeFeedsInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_a_of_type_Long = ((articlesummary.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.get();
            }
          }
        }
        if (!paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) {
          break label4863;
        }
      }
    }
    localSocializeFeedsInfo.jdField_a_of_type_Qdq = qdq.a((articlesummary.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get());
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.topicRecommendFeedsInfo = ", localSocializeFeedsInfo.jdField_a_of_type_Qdq });
    if (paramSocializeFeedsInfo.bytes_recommend_account_reason.has())
    {
      localSocializeFeedsInfo.jdField_d_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_recommend_account_reason.get().toStringUtf8();
      QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.mRecommendAccountReason = ", localSocializeFeedsInfo.jdField_d_of_type_JavaLangString });
      label3149:
      if (paramSocializeFeedsInfo.wenda_info.has())
      {
        localSocializeFeedsInfo.jdField_a_of_type_Qde = new qde();
        localObject2 = (articlesummary.WendaInfo)paramSocializeFeedsInfo.wenda_info.get();
        if (((articlesummary.WendaInfo)localObject2).uint32_is_super_wenda.has())
        {
          if (((articlesummary.WendaInfo)localObject2).uint32_is_super_wenda.get() != 1) {
            break label4889;
          }
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_a_of_type_Boolean = true;
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_question_rowkey.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_a_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_question_rowkey.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_question_desc.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_b_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_question_desc.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_question_pic_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_c_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_question_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_wenda_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_d_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_wenda_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).uint32_follow_count.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_a_of_type_Int = ((articlesummary.WendaInfo)localObject2).uint32_follow_count.get();
        }
        if (((articlesummary.WendaInfo)localObject2).uint32_answer_count.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_b_of_type_Int = ((articlesummary.WendaInfo)localObject2).uint32_answer_count.get();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_icon_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_e_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_icon_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_answer_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_f_of_type_JavaLangString = ((articlesummary.WendaInfo)localObject2).bytes_answer_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_c_of_type_Int = ((articlesummary.WendaInfo)localObject2).channel_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.h = ((articlesummary.WendaInfo)localObject2).channel_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_second_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_d_of_type_Int = ((articlesummary.WendaInfo)localObject2).channel_second_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_second_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.i = ((articlesummary.WendaInfo)localObject2).channel_second_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).tag_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_a_of_type_JavaUtilList = ((articlesummary.WendaInfo)localObject2).tag_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).tag_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_b_of_type_JavaUtilList = ((articlesummary.WendaInfo)localObject2).tag_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).author_nick.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.j = ((articlesummary.WendaInfo)localObject2).author_nick.get();
        }
        if (((articlesummary.WendaInfo)localObject2).jump_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.k = ((articlesummary.WendaInfo)localObject2).jump_url.get();
        }
        if (((articlesummary.WendaInfo)localObject2).images_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_c_of_type_JavaUtilList = ((articlesummary.WendaInfo)localObject2).images_url.get();
        }
        if (((articlesummary.WendaInfo)localObject2).icon_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.l = ((articlesummary.WendaInfo)localObject2).icon_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).icon_color.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.m = ((articlesummary.WendaInfo)localObject2).icon_color.get();
        }
        if (((articlesummary.WendaInfo)localObject2).super_wenda_button_title.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_Qde.n = ((articlesummary.WendaInfo)localObject2).super_wenda_button_title.get();
        }
        if (((articlesummary.WendaInfo)localObject2).answer_detail.has())
        {
          localObject2 = (articlesummary.AnswerDetail)((articlesummary.WendaInfo)localObject2).answer_detail.get();
          localSocializeFeedsInfo.jdField_a_of_type_Qde.a((articlesummary.AnswerDetail)localObject2);
        }
      }
      label3215:
      localSocializeFeedsInfo.j = a(paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted);
      if (paramSocializeFeedsInfo.icon_wording_info.has())
      {
        localObject2 = new qcl();
        localObject3 = (feeds_info.IconWordingInfo)paramSocializeFeedsInfo.icon_wording_info.get();
        ((qcl)localObject2).jdField_a_of_type_Int = a(((feeds_info.IconWordingInfo)localObject3).uint32_type);
        if (((feeds_info.IconWordingInfo)localObject3).bytes_icon_url.has()) {
          ((qcl)localObject2).jdField_a_of_type_JavaLangString = ((feeds_info.IconWordingInfo)localObject3).bytes_icon_url.get().toStringUtf8();
        }
        if (((feeds_info.IconWordingInfo)localObject3).bytes_wording.has()) {
          ((qcl)localObject2).jdField_b_of_type_JavaLangString = ((feeds_info.IconWordingInfo)localObject3).bytes_wording.get().toStringUtf8();
        }
        if (((feeds_info.IconWordingInfo)localObject3).bytes_status_icon_url.has()) {
          ((qcl)localObject2).jdField_c_of_type_JavaLangString = ((feeds_info.IconWordingInfo)localObject3).bytes_status_icon_url.get().toStringUtf8();
        }
        ((qcl)localObject2).jdField_b_of_type_Int = a(((feeds_info.IconWordingInfo)localObject3).uint32_status);
        if (((feeds_info.IconWordingInfo)localObject3).bytes_status.has()) {
          ((qcl)localObject2).jdField_d_of_type_JavaLangString = ((feeds_info.IconWordingInfo)localObject3).bytes_status.get().toStringUtf8();
        }
        ((qcl)localObject2).jdField_c_of_type_Int = a(((feeds_info.IconWordingInfo)localObject3).uint32_icon_show_mode);
        localSocializeFeedsInfo.jdField_a_of_type_Qcl = ((qcl)localObject2);
      }
      if (paramSocializeFeedsInfo.uint32_feed_status.has()) {
        localSocializeFeedsInfo.k = paramSocializeFeedsInfo.uint32_feed_status.get();
      }
      if (paramSocializeFeedsInfo.bytes_private_status_title.has()) {
        localSocializeFeedsInfo.jdField_e_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_private_status_title.get().toStringUtf8();
      }
      if ((paramSocializeFeedsInfo.location_info.has()) && (paramSocializeFeedsInfo.location_info.get() != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_Qcn = new qcn();
        localObject3 = (feeds_info.LocationInfo)paramSocializeFeedsInfo.location_info.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_Qcn;
        if (!((feeds_info.LocationInfo)localObject3).bytes_name.has()) {
          break label4901;
        }
        localObject2 = ((feeds_info.LocationInfo)localObject3).bytes_name.get().toStringUtf8();
        label4126:
        ((qcn)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject2);
        localSocializeFeedsInfo.jdField_a_of_type_Qcn.jdField_a_of_type_Int = ((feeds_info.LocationInfo)localObject3).uint32_longitude.get();
        localSocializeFeedsInfo.jdField_a_of_type_Qcn.jdField_b_of_type_Int = ((feeds_info.LocationInfo)localObject3).uint32_latitude.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_Qcn;
        if (!((feeds_info.LocationInfo)localObject3).bytes_icon_url.has()) {
          break label4908;
        }
        localObject2 = ((feeds_info.LocationInfo)localObject3).bytes_icon_url.get().toStringUtf8();
        label4196:
        ((qcn)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject2);
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
        localSocializeFeedsInfo.jdField_a_of_type_Qcy = new qcy();
        localObject2 = (feeds_info.VisibleShowInfo)paramSocializeFeedsInfo.visible_info.visible_show_info.get();
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Qcy;
        if (!((feeds_info.VisibleShowInfo)localObject2).uint64_feed_id.has()) {
          break label4915;
        }
        l1 = ((feeds_info.VisibleShowInfo)localObject2).uint64_feed_id.get();
        label4411:
        ((qcy)localObject3).jdField_b_of_type_Long = l1;
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Qcy;
        m = n;
        if (((feeds_info.VisibleShowInfo)localObject2).uint32_visible_type.has()) {
          m = ((feeds_info.VisibleShowInfo)localObject2).uint32_visible_type.get();
        }
        ((qcy)localObject3).jdField_a_of_type_Int = m;
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_Qcy;
        l1 = l2;
        if (((feeds_info.VisibleShowInfo)localObject2).uint64_who.has()) {
          l1 = ((feeds_info.VisibleShowInfo)localObject2).uint64_who.get();
        }
        ((qcy)localObject3).jdField_a_of_type_Long = l1;
        QLog.d("SocializeFeedsInfo", 1, "feeds privacy | feedsid  " + localSocializeFeedsInfo.jdField_a_of_type_Qcy.jdField_b_of_type_Long + " | privacyType " + localSocializeFeedsInfo.jdField_a_of_type_Qcy.jdField_a_of_type_Int + " | privacySetUin " + localSocializeFeedsInfo.jdField_a_of_type_Qcy.jdField_a_of_type_Long);
      }
      if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.has())) {
        a(localSocializeFeedsInfo, ((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.get());
      }
      if ((paramSocializeFeedsInfo.buluo_info.has()) && (paramSocializeFeedsInfo.buluo_info.get() != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_Qch = new qch();
        localObject3 = (articlesummary.BuluoInfo)paramSocializeFeedsInfo.buluo_info.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_Qch;
        if (!((articlesummary.BuluoInfo)localObject3).bytes_wording.has()) {
          break label4920;
        }
        localObject2 = ((articlesummary.BuluoInfo)localObject3).bytes_wording.get().toStringUtf8();
        label4681:
        ((qch)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject2);
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_Qch;
        if (!((articlesummary.BuluoInfo)localObject3).bytes_head_url.has()) {
          break label4927;
        }
        localObject2 = ((articlesummary.BuluoInfo)localObject3).bytes_head_url.get().toStringUtf8();
        label4719:
        ((qch)localObject4).jdField_d_of_type_JavaLangString = ((String)localObject2);
        localSocializeFeedsInfo.jdField_a_of_type_Qch.jdField_a_of_type_Long = ((articlesummary.BuluoInfo)localObject3).uint64_buluo_id.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_Qch;
        if (!((articlesummary.BuluoInfo)localObject3).bytes_jump_url.has()) {
          break label4934;
        }
        localObject2 = ((articlesummary.BuluoInfo)localObject3).bytes_jump_url.get().toStringUtf8();
        label4773:
        ((qch)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject2);
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_Qch;
        if (!((articlesummary.BuluoInfo)localObject3).bytes_name.has()) {
          break label4941;
        }
      }
    }
    label4889:
    label4901:
    label4908:
    label4915:
    label4920:
    label4927:
    label4934:
    label4941:
    for (Object localObject2 = ((articlesummary.BuluoInfo)localObject3).bytes_name.get().toStringUtf8();; localObject2 = "")
    {
      ((qch)localObject4).jdField_c_of_type_JavaLangString = ((String)localObject2);
      if ((paramSocializeFeedsInfo.long_content_info.has()) && (paramSocializeFeedsInfo.long_content_info.get() != null)) {
        localSocializeFeedsInfo.jdField_a_of_type_Qco = new qco((articlesummary.LongContentInfo)paramSocializeFeedsInfo.long_content_info.get());
      }
      return localSocializeFeedsInfo;
      label4863:
      QLog.d("SocializeFeedsInfo", 1, "info.topicRecommendFeedsInfo is null.");
      break;
      QLog.d("SocializeFeedsInfo", 1, "info.mRecommendAccountReason is null.");
      break label3149;
      localSocializeFeedsInfo.jdField_a_of_type_Qde.jdField_a_of_type_Boolean = false;
      break label3215;
      localObject2 = "";
      break label4126;
      localObject2 = "";
      break label4196;
      l1 = 0L;
      break label4411;
      localObject2 = "";
      break label4681;
      localObject2 = "";
      break label4719;
      localObject2 = "";
      break label4773;
    }
  }
  
  private static void a(SocializeFeedsInfo paramSocializeFeedsInfo, List<oidb_cmd0xb57.MedalInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      paramList = (oidb_cmd0xb57.MedalInfo)paramList.get(0);
      paramSocializeFeedsInfo.jdField_a_of_type_Ntz = new ntz();
      if (paramList.bytes_jump_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Ntz.jdField_c_of_type_JavaLangString = paramList.bytes_jump_url.get().toStringUtf8();
      }
      if (paramList.uint32_is_jump.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Ntz.jdField_b_of_type_Int = paramList.uint32_is_jump.get();
      }
      if (paramList.uint32_medal_type.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Ntz.jdField_a_of_type_Int = paramList.uint32_medal_type.get();
      }
      if (paramList.uint64_medal_id.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Ntz.jdField_a_of_type_Long = paramList.uint64_medal_id.get();
      }
      if (paramList.bytes_medal_name.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Ntz.jdField_a_of_type_JavaLangString = paramList.bytes_medal_name.get().toStringUtf8();
      }
      if (paramList.bytes_medal_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Ntz.jdField_b_of_type_JavaLangString = paramList.bytes_medal_url.get().toStringUtf8();
      }
      if (paramList.uint32_pic_width.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_Ntz.jdField_c_of_type_Int = paramList.uint32_pic_width.get();
      }
    } while (!paramList.uint32_pic_height.has());
    paramSocializeFeedsInfo.jdField_a_of_type_Ntz.jdField_d_of_type_Int = paramList.uint32_pic_height.get();
  }
  
  public SocializeFeedsInfo a()
  {
    try
    {
      localSocializeFeedsInfo1 = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo1.jdField_a_of_type_Qci = this.jdField_a_of_type_Qci.a();
        localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          qci localqci = (qci)localIterator.next();
          localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList.add(localqci.a());
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
    } while (this.jdField_a_of_type_Qcg == null);
    localSocializeFeedsInfo1.jdField_a_of_type_Qcg = this.jdField_a_of_type_Qcg.a();
    return localSocializeFeedsInfo1;
  }
  
  public qcg a(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    qcg localqcg = new qcg();
    localqcg.jdField_a_of_type_JavaLangLong = Long.valueOf(a(paramBiuMultiLevel.uint64_origin_feeds_id));
    localqcg.jdField_b_of_type_JavaLangLong = Long.valueOf(a(paramBiuMultiLevel.uint64_origin_feeds_type));
    if ((paramBiuMultiLevel.rpt_biu_mutli_level.has()) && (paramBiuMultiLevel.rpt_biu_mutli_level.get() != null))
    {
      paramBiuMultiLevel = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
      while (paramBiuMultiLevel.hasNext())
      {
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)paramBiuMultiLevel.next();
        localqcg.jdField_a_of_type_JavaUtilList.add(a(localBiuOneLevelItem));
      }
    }
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "convertPb2BiuInfo, mFeedsId =  ", Long.valueOf(this.jdField_a_of_type_Long), ", mOriFeedType = ", localqcg.jdField_b_of_type_JavaLangLong });
    return localqcg;
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
        qci localqci = new qci(this);
        if ((((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).has()) && (((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).get() != null)) {}
        for (long l1 = a(((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).uint64_uin);; l1 = 0L)
        {
          localqci.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_JavaUtilList.add(localqci);
          break;
        }
      }
    }
    if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (this.jdField_a_of_type_Qdq != null) && (this.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramSocializeFeedsInfo = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
      if (paramSocializeFeedsInfo.msg_topic_recommend_info.has())
      {
        paramSocializeFeedsInfo = paramSocializeFeedsInfo.msg_topic_recommend_info.get();
        int m = 0;
        while ((m < paramSocializeFeedsInfo.size()) && (m < this.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject1 = (oidb_cmd0x8c8.TopicRecommendInfo)paramSocializeFeedsInfo.get(m);
          localObject2 = (qds)this.jdField_a_of_type_Qdq.jdField_a_of_type_JavaUtilArrayList.get(m);
          if (((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.has()) {
            ((qds)localObject2).jdField_b_of_type_Int = ((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.get();
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
    localSocializeFeedsInfoUser.uint64_uin.set(this.jdField_a_of_type_Qci.jdField_a_of_type_Long);
    localSocializeFeedsInfoUser.enum_uin_type.set(this.jdField_a_of_type_Qci.jdField_a_of_type_Int);
    localSocializeFeedsInfoUser.uint32_star_style.set(this.jdField_a_of_type_Qci.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Qci.jdField_a_of_type_JavaLangString)) {
      localSocializeFeedsInfoUser.bytes_person_desc.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qci.jdField_a_of_type_JavaLangString));
    }
    localSocializeFeedsInfo.msg_master_uin.set(localSocializeFeedsInfoUser);
    localSocializeFeedsInfo.uint32_follow_counts.set(this.i);
    localSocializeFeedsInfo.uint32_follow_status.set(this.h);
    if (this.jdField_a_of_type_Qcz != null) {
      localSocializeFeedsInfo.share_web_page_info.set(this.jdField_a_of_type_Qcz.a());
    }
    Object localObject1 = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (qci)((Iterator)localObject3).next();
      localObject5 = new articlesummary.SocializeFeedsInfoUser();
      ((articlesummary.SocializeFeedsInfoUser)localObject5).uint64_uin.set(((qci)localObject4).jdField_a_of_type_Long);
      ((articlesummary.SocializeFeedsInfoUser)localObject5).enum_uin_type.set(((qci)localObject4).jdField_a_of_type_Int);
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
      if (this.jdField_a_of_type_Qcg != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.jdField_a_of_type_Qcg.a());
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
      if ((this.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1424;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_Qda.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (qdc)((Iterator)localObject4).next();
        localObject6 = new articlesummary.UGCVideoInfo();
        ((articlesummary.UGCVideoInfo)localObject6).uint64_duration.set(((qdc)localObject5).jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(((qdc)localObject5).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qdc)localObject5).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qdc)localObject5).jdField_f_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_uuid.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qdc)localObject5).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qdc)localObject5).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qdc)localObject5).jdField_e_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_title.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qdc)localObject5).jdField_g_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).jdField_g_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qdc)localObject5).h)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_share_url.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).h));
        }
        if (!TextUtils.isEmpty(((qdc)localObject5).i)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_vid.set(ByteStringMicro.copyFromUtf8(((qdc)localObject5).i));
        }
        ((articlesummary.UGCVideoInfo)localObject6).uint32_create_time.set(((qdc)localObject5).jdField_e_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_busi_type.set(((qdc)localObject5).jdField_f_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_pic_height.set(((qdc)localObject5).jdField_d_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_pic_width.set(((qdc)localObject5).jdField_c_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_video_height.set(((qdc)localObject5).jdField_b_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_video_width.set(((qdc)localObject5).jdField_a_of_type_Int);
        ((List)localObject3).add(localObject6);
      }
      localException.msg_ugc_video_info_list.set((List)localObject3);
      if ((this.jdField_a_of_type_Qda.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Qda.jdField_c_of_type_JavaUtilArrayList.size() <= 0)) {
        break label1574;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_Qda.jdField_c_of_type_JavaUtilArrayList.iterator();
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
      if (this.jdField_a_of_type_Qda.jdField_a_of_type_Qcd == null) {
        break label1601;
      }
      localException.account_profile.set(this.jdField_a_of_type_Qda.jdField_a_of_type_Qcd.a());
      if (TextUtils.isEmpty(this.jdField_a_of_type_Qda.jdField_c_of_type_JavaLangString)) {
        break label1631;
      }
      localException.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qda.jdField_c_of_type_JavaLangString));
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(localException);
      if (this.jdField_a_of_type_Qcv == null) {
        break label2938;
      }
      localObject2 = new articlesummary.PGCFeedsInfo();
      if (TextUtils.isEmpty(this.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString)) {
        break label1684;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString));
      if (!this.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean) {
        break label1702;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_article_type.set(1);
      if (this.jdField_a_of_type_Qcv.jdField_b_of_type_Int == -1) {
        break label1727;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.set(this.jdField_a_of_type_Qcv.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Qcv.jdField_a_of_type_Int == -1) {
        break label1752;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.set(this.jdField_a_of_type_Qcv.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2245;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.iterator();
      Object localObject7;
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (qcw)((Iterator)localObject4).next();
        localObject6 = new articlesummary.PGCPicInfo();
        if (!TextUtils.isEmpty(((qcw)localObject5).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qcw)localObject5).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_b_of_type_JavaLangString));
        }
        ((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.set(((qcw)localObject5).jdField_b_of_type_Int);
        ((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.set(((qcw)localObject5).jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(((qcw)localObject5).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qcw)localObject5).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_d_of_type_JavaLangString));
        }
        if (((qcw)localObject5).jdField_a_of_type_Long != -1L) {
          ((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.set(((qcw)localObject5).jdField_a_of_type_Long);
        }
        if (((qcw)localObject5).jdField_a_of_type_Qcx != null)
        {
          localObject7 = new articlesummary.PGCVideoInfo();
          if (!TextUtils.isEmpty(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_e_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_vid.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_e_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_b_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_a_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_c_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_c_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_d_of_type_JavaLangString)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_d_of_type_JavaLangString));
          }
          ((articlesummary.PGCVideoInfo)localObject7).uint32_duration.set(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_a_of_type_Int);
          ((articlesummary.PGCVideoInfo)localObject7).uint32_busi_type.set(((qcw)localObject5).jdField_a_of_type_Qcx.jdField_b_of_type_Int);
          ((articlesummary.PGCPicInfo)localObject6).msg_video_info.set((MessageMicro)localObject7);
        }
        ((articlesummary.PGCPicInfo)localObject6).is_animation.set(((qcw)localObject5).jdField_c_of_type_Int);
        ((List)localObject3).add(localObject6);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.set((List)localObject3);
      if ((this.jdField_a_of_type_Qcv.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Qcv.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2450;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_Qcv.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (qcx)((Iterator)localObject4).next();
        localObject6 = new articlesummary.PGCVideoInfo();
        if (!TextUtils.isEmpty(((qcx)localObject5).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((qcx)localObject5).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qcx)localObject5).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((qcx)localObject5).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qcx)localObject5).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((qcx)localObject5).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qcx)localObject5).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((qcx)localObject5).jdField_d_of_type_JavaLangString));
        }
        ((List)localObject3).add(localObject6);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.set((List)localObject3);
      ((articlesummary.PGCFeedsInfo)localObject2).enum_pgc_feeds_type.set(this.jdField_a_of_type_Qcv.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj == null) {
        break label2930;
      }
      localObject3 = new articlesummary.GalleryPGCFeedsInfo();
      if (this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_a_of_type_Long == -1L) {
        break label2518;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_pic_count.set(this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_b_of_type_Long == -1L) {
        break label2553;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_source.set(this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.c == -1L) {
        break label2588;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_sub_source.set(this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.c);
      if (TextUtils.isEmpty(this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_a_of_type_JavaLangString)) {
        break label2625;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).bytes_gallery_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_a_of_type_JavaLangString));
      if ((this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label2921;
      }
      localObject4 = new ArrayList();
      localObject5 = this.jdField_a_of_type_Qcv.jdField_a_of_type_Qcj.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (qcw)((Iterator)localObject5).next();
        localObject7 = new articlesummary.PGCPicInfo();
        if (((qcw)localObject6).jdField_a_of_type_Int != -1) {
          ((articlesummary.PGCPicInfo)localObject7).uint32_pic_width.set(((qcw)localObject6).jdField_a_of_type_Int);
        }
        if (((qcw)localObject6).jdField_b_of_type_Int != -1) {
          ((articlesummary.PGCPicInfo)localObject7).uint32_pic_height.set(((qcw)localObject6).jdField_b_of_type_Int);
        }
        if (!TextUtils.isEmpty(((qcw)localObject6).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((qcw)localObject6).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qcw)localObject6).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((qcw)localObject6).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qcw)localObject6).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((qcw)localObject6).jdField_c_of_type_JavaLangString));
        }
        if (((qcw)localObject6).jdField_c_of_type_Int != -1) {
          ((articlesummary.PGCPicInfo)localObject7).is_animation.set(((qcw)localObject6).jdField_c_of_type_Int);
        }
        if (!TextUtils.isEmpty(((qcw)localObject6).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(((qcw)localObject6).jdField_d_of_type_JavaLangString));
        }
        if (((qcw)localObject6).jdField_a_of_type_Long != -1L) {
          ((articlesummary.PGCPicInfo)localObject7).uint64_gallery_index.set(((qcw)localObject6).jdField_a_of_type_Long);
        }
        ((List)localObject4).add(localObject7);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.set((MessageMicro)localObject3);
      localSocializeFeedsInfo.msg_pgc_topic_feeds_info.set((MessageMicro)localObject2);
      if (this.jdField_a_of_type_Qdq == null) {
        break label2959;
      }
      localSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.jdField_a_of_type_Qdq.a());
      if (this.jdField_d_of_type_JavaLangString == null) {
        break label2980;
      }
      localSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
      if (this.jdField_a_of_type_Qde == null) {
        break label3001;
      }
      localSocializeFeedsInfo.wenda_info.set(this.jdField_a_of_type_Qde.a());
      localSocializeFeedsInfo.uint32_is_origin_feeds_deleted.set(this.j);
      if (this.jdField_a_of_type_Qcl == null) {
        break label3033;
      }
      localSocializeFeedsInfo.icon_wording_info.set(this.jdField_a_of_type_Qcl.a());
      if (this.jdField_a_of_type_Qcn == null) {
        break label3152;
      }
    }
    if (this.jdField_a_of_type_Qck != null)
    {
      localObject1 = new articlesummary.GameLiveInfo();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qck.jdField_a_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qck.jdField_a_of_type_JavaLangString));
      }
      ((articlesummary.GameLiveInfo)localObject1).uint32_status.set(this.jdField_a_of_type_Qck.jdField_a_of_type_Int);
      ((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.set(this.jdField_a_of_type_Qck.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qck.jdField_d_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_game_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qck.jdField_d_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qck.jdField_c_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_play_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qck.jdField_c_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qck.jdField_e_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qck.jdField_e_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qck.jdField_f_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_status.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qck.jdField_f_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qck.jdField_g_of_type_JavaLangString)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qck.jdField_g_of_type_JavaLangString));
      }
      localSocializeFeedsInfo.game_live_info.set((MessageMicro)localObject1);
    }
    localSocializeFeedsInfo.uint64_article_id.set(this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Qda != null)
    {
      localObject1 = new articlesummary.UGCFeedsInfo();
      ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.set(this.jdField_a_of_type_Qda.jdField_a_of_type_Int);
      ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.set(this.jdField_a_of_type_Qda.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qda.jdField_a_of_type_JavaLangString)) {
        ((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qda.jdField_a_of_type_JavaLangString));
      }
      if (this.jdField_a_of_type_Qda.jdField_a_of_type_Qcg != null) {
        ((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.set(this.jdField_a_of_type_Qda.jdField_a_of_type_Qcg.a());
      }
      ((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.set(this.jdField_a_of_type_Qda.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject3 = new ArrayList();
        localObject4 = this.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (qdb)((Iterator)localObject4).next();
          localObject6 = new articlesummary.UGCPicInfo();
          ((articlesummary.UGCPicInfo)localObject6).uint32_pic_width.set(((qdb)localObject5).jdField_a_of_type_Int);
          ((articlesummary.UGCPicInfo)localObject6).uint32_pic_height.set(((qdb)localObject5).jdField_b_of_type_Int);
          if (!TextUtils.isEmpty(((qdb)localObject5).jdField_b_of_type_JavaLangString)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((qdb)localObject5).jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((qdb)localObject5).jdField_a_of_type_JavaLangString)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((qdb)localObject5).jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((qdb)localObject5).jdField_c_of_type_JavaLangString)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((qdb)localObject5).jdField_c_of_type_JavaLangString));
          }
          ((articlesummary.UGCPicInfo)localObject6).is_animation.set(((qdb)localObject5).jdField_c_of_type_Int);
          ((List)localObject3).add(localObject6);
        }
      }
    }
    label1424:
    label1574:
    label1601:
    label1631:
    label2553:
    label2938:
    localObject3 = new feeds_info.LocationInfo();
    label1684:
    label1702:
    label1727:
    label1752:
    label2921:
    label2930:
    Object localObject4 = ((feeds_info.LocationInfo)localObject3).bytes_name;
    label2245:
    label2518:
    label3033:
    if (TextUtils.isEmpty(this.jdField_a_of_type_Qcn.jdField_a_of_type_JavaLangString))
    {
      localObject2 = "";
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((feeds_info.LocationInfo)localObject3).uint32_longitude.set(this.jdField_a_of_type_Qcn.jdField_a_of_type_Int);
      ((feeds_info.LocationInfo)localObject3).uint32_latitude.set(this.jdField_a_of_type_Qcn.jdField_b_of_type_Int);
      localObject4 = ((feeds_info.LocationInfo)localObject3).bytes_icon_url;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qcn.jdField_b_of_type_JavaLangString)) {
        break label3645;
      }
    }
    label2450:
    label2588:
    label2625:
    for (Object localObject2 = "";; localObject2 = this.jdField_a_of_type_Qcn.jdField_b_of_type_JavaLangString)
    {
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localSocializeFeedsInfo.location_info.set((MessageMicro)localObject3);
      label3152:
      if (this.jdField_a_of_type_Qcy != null)
      {
        localObject2 = new feeds_info.VisibleInfo();
        localObject3 = new feeds_info.VisibleShowInfo();
        ((feeds_info.VisibleShowInfo)localObject3).uint32_visible_type.set(this.jdField_a_of_type_Qcy.jdField_a_of_type_Int);
        ((feeds_info.VisibleShowInfo)localObject3).uint64_feed_id.set(this.jdField_a_of_type_Qcy.jdField_b_of_type_Long);
        ((feeds_info.VisibleShowInfo)localObject3).uint64_who.set(this.jdField_a_of_type_Qcy.jdField_a_of_type_Long);
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
      if (this.jdField_a_of_type_Ntz != null)
      {
        localObject2 = new ArrayList();
        localObject3 = new oidb_cmd0xb57.MedalInfo();
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_pic_width.set(this.jdField_a_of_type_Ntz.jdField_d_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_pic_height.set(this.jdField_a_of_type_Ntz.jdField_c_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_medal_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Ntz.jdField_b_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint64_medal_id.set(this.jdField_a_of_type_Ntz.jdField_a_of_type_Long);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_medal_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Ntz.jdField_a_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_is_jump.set(this.jdField_a_of_type_Ntz.jdField_b_of_type_Int);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Ntz.jdField_c_of_type_JavaLangString));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_medal_type.set(this.jdField_a_of_type_Ntz.jdField_a_of_type_Int);
        ((List)localObject2).add(localObject3);
        localSocializeFeedsInfoUser.rpt_msg_medal_info.set((List)localObject2);
      }
      if ((localSocializeFeedsInfo.buluo_info.has()) && (localSocializeFeedsInfo.buluo_info.get() != null))
      {
        localObject2 = new feeds_info.BuluoInfo();
        ((feeds_info.BuluoInfo)localObject2).bytes_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qch.jdField_a_of_type_JavaLangString));
        ((feeds_info.BuluoInfo)localObject2).bytes_head_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qch.jdField_d_of_type_JavaLangString));
        ((feeds_info.BuluoInfo)localObject2).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qch.jdField_b_of_type_JavaLangString));
        ((feeds_info.BuluoInfo)localObject2).bytes_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qch.jdField_c_of_type_JavaLangString));
        ((feeds_info.BuluoInfo)localObject2).uint64_buluo_id.set(this.jdField_a_of_type_Qch.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Qco != null)
      {
        localObject2 = this.jdField_a_of_type_Qco.a();
        localSocializeFeedsInfo.long_content_info.set((MessageMicro)localObject2);
      }
      return localSocializeFeedsInfo.toByteArray();
      localObject2 = this.jdField_a_of_type_Qcn.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Qcy != null) && (this.jdField_a_of_type_Qcy.jdField_a_of_type_Int != 0);
  }
  
  public String toString()
  {
    return "SocializeFeedsInfo{mFeedStyle=" + this.jdField_a_of_type_Int + ", mRecommUinList=" + this.jdField_a_of_type_JavaUtilList + ", mLikeCount=" + this.jdField_b_of_type_Int + ", mLikeStatus=" + this.jdField_c_of_type_Int + ", mCommentCount=" + this.jdField_d_of_type_Int + ", mBiuTime=" + this.jdField_e_of_type_Int + ", mCommentWording='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mRecommReason='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mRecommendAccountReason='" + this.jdField_d_of_type_JavaLangString + '\'' + ", mMasterUser.uin='" + this.jdField_a_of_type_Qci.jdField_a_of_type_Long + '\'' + ", mMasterUser.type='" + this.jdField_a_of_type_Qci.jdField_a_of_type_Int + '\'' + ", mMasterUser.starType='" + this.jdField_a_of_type_Qci.jdField_b_of_type_Int + '\'' + ", mBiuCount='" + this.jdField_f_of_type_Int + '\'' + ", mBiuStatus='" + this.jdField_g_of_type_Int + '\'' + ", mBiuInfo='" + this.jdField_a_of_type_Qcg + '\'' + ", mFollowStatus='" + this.h + '\'' + ", mFollowCnt='" + this.i + '\'' + ", mIsOriginFeedsDeleted='" + this.j + '\'' + ", mFeedStatus='" + this.k + '\'' + ", mPrivateStatusTitle='" + this.jdField_e_of_type_JavaLangString + '\'' + ", mIs_jump_recommend_page='" + this.l + '\'' + ", mJump_recommend__url='" + this.jdField_f_of_type_JavaLangString + '\'' + ", mJump_recommend__prompt='" + this.jdField_g_of_type_JavaLangString + '\'' + ", mPGCFeedsInfo=" + this.jdField_a_of_type_Qcv + ", mUGCFeedsInfo=" + this.jdField_a_of_type_Qda + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */