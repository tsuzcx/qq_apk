package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class ExtSnsRelationChainChangePushInfo
{
  public int a;
  public ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo a;
  public String a;
  public ArrayList<ExtSnsRelationChainChangePushInfo.ChangeInfoPair> a;
  public boolean a;
  public ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo b;
  public String b;
  
  public ExtSnsRelationChainChangePushInfo()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static ExtSnsRelationChainChangePushInfo a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    ExtSnsRelationChainChangePushInfo localExtSnsRelationChainChangePushInfo = new ExtSnsRelationChainChangePushInfo();
    localExtSnsRelationChainChangePushInfo.jdField_a_of_type_Boolean = paramBoolean;
    localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        ExtSnsRelationChainChangePushInfo.ChangeInfoPair localChangeInfoPair = new ExtSnsRelationChainChangePushInfo.ChangeInfoPair();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localChangeInfoPair.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localChangeInfoPair.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaUtilArrayList.add(localChangeInfoPair);
        i += 1;
      }
    }
    return localExtSnsRelationChainChangePushInfo;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo a()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)
        {
          localObject1 = new ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo();
          ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_a_of_type_JavaLangString;
          ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_e_of_type_Long;
          ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_b_of_type_JavaLangString;
          ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_b_of_type_Int;
        }
      }
    }
    for (;;)
    {
      long l1 = a();
      long l2 = b();
      if ((l1 == 21L) && (localObject1 != null) && (l2 == 1L)) {
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_a_of_type_Int = 1;
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)
        {
          localObject1 = new ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo();
          ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_a_of_type_JavaLangString;
          ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_e_of_type_Long;
          ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_b_of_type_JavaLangString;
          ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject1).jdField_a_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_b_of_type_Int;
        }
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_e_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.f)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.jdField_e_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.b();
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.b();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo != null)) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo.f;
    }
    return null;
  }
  
  public int d()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.a();
    }
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsRelationChainChangePushInfo{");
    localStringBuilder.append("selfUin:").append(this.jdField_a_of_type_JavaLangString).append(", ");
    localStringBuilder.append("friendUin:").append(this.jdField_b_of_type_JavaLangString).append(", ");
    localStringBuilder.append("changeType:").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder.append("old:").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo
 * JD-Core Version:    0.7.0.1
 */