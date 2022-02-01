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
  public String a;
  public String b;
  public int c;
  public boolean d = true;
  public ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo e;
  public ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo f;
  public ArrayList<ExtSnsRelationChainChangePushInfo.ChangeInfoPair> g;
  
  public static ExtSnsRelationChainChangePushInfo a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    ExtSnsRelationChainChangePushInfo localExtSnsRelationChainChangePushInfo = new ExtSnsRelationChainChangePushInfo();
    localExtSnsRelationChainChangePushInfo.d = paramBoolean;
    localExtSnsRelationChainChangePushInfo.a = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localExtSnsRelationChainChangePushInfo.b = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localExtSnsRelationChainChangePushInfo.c = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localExtSnsRelationChainChangePushInfo.e = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localExtSnsRelationChainChangePushInfo.f = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localExtSnsRelationChainChangePushInfo.g = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        ExtSnsRelationChainChangePushInfo.ChangeInfoPair localChangeInfoPair = new ExtSnsRelationChainChangePushInfo.ChangeInfoPair();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localChangeInfoPair.a = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localChangeInfoPair.b = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localExtSnsRelationChainChangePushInfo.g.add(localChangeInfoPair);
        i += 1;
      }
    }
    return localExtSnsRelationChainChangePushInfo;
  }
  
  public ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo a()
  {
    if (this.c == 2)
    {
      localObject = this.e;
      if ((localObject != null) && (((ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo)localObject).b != null))
      {
        localObject = new ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo();
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).a = this.e.b.f;
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).b = this.e.b.h;
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).c = this.e.b.g;
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).d = this.e.b.l;
        break label193;
      }
    }
    else
    {
      localObject = this.f;
      if ((localObject != null) && (((ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo)localObject).b != null))
      {
        localObject = new ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo();
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).a = this.f.b.f;
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).b = this.f.b.h;
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).c = this.f.b.g;
        ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).d = this.f.b.l;
        break label193;
      }
    }
    Object localObject = null;
    label193:
    long l1 = b();
    long l2 = c();
    if ((l1 == 21L) && (localObject != null) && (l2 == 1L)) {
      ((ExtSnsRelationChainChangePushInfo.MutualMarkPushGrayTipInfo)localObject).d = 1;
    }
    return localObject;
  }
  
  public int b()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo;
    if (this.c == 2)
    {
      localRelationalChainPushInfo = this.e;
      if (localRelationalChainPushInfo != null) {
        return localRelationalChainPushInfo.a;
      }
    }
    else
    {
      localRelationalChainPushInfo = this.f;
      if (localRelationalChainPushInfo != null) {
        return localRelationalChainPushInfo.a;
      }
    }
    return 0;
  }
  
  public int c()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo;
    if (this.c == 2)
    {
      localRelationalChainPushInfo = this.e;
      if (localRelationalChainPushInfo != null) {
        return localRelationalChainPushInfo.a();
      }
    }
    else
    {
      localRelationalChainPushInfo = this.f;
      if (localRelationalChainPushInfo != null) {
        return localRelationalChainPushInfo.a();
      }
    }
    return 0;
  }
  
  public int d()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo;
    if (this.c == 2)
    {
      localRelationalChainPushInfo = this.e;
      if (localRelationalChainPushInfo != null) {
        return localRelationalChainPushInfo.b();
      }
    }
    else
    {
      localRelationalChainPushInfo = this.f;
      if (localRelationalChainPushInfo != null) {
        return localRelationalChainPushInfo.b();
      }
    }
    return 0;
  }
  
  public String e()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo = this.f;
    if ((localRelationalChainPushInfo != null) && (localRelationalChainPushInfo.b != null)) {
      return this.f.b.m;
    }
    return null;
  }
  
  public String f()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo = this.f;
    if ((localRelationalChainPushInfo != null) && (localRelationalChainPushInfo.b != null)) {
      return this.f.b.o;
    }
    return null;
  }
  
  public String g()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo = this.f;
    if ((localRelationalChainPushInfo != null) && (localRelationalChainPushInfo.b != null)) {
      return this.f.b.p;
    }
    return null;
  }
  
  public boolean h()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo = this.f;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localRelationalChainPushInfo != null)
    {
      bool1 = bool2;
      if (localRelationalChainPushInfo.b != null)
      {
        bool1 = bool2;
        if (this.f.b.s)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.f.b.o))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.f.b.p)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean i()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo = this.f;
    if ((localRelationalChainPushInfo != null) && (localRelationalChainPushInfo.b != null)) {
      return TextUtils.isEmpty(this.f.b.m) ^ true;
    }
    return false;
  }
  
  public int j()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo localRelationalChainPushInfo = this.f;
    if (localRelationalChainPushInfo != null) {
      return localRelationalChainPushInfo.a();
    }
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsRelationChainChangePushInfo{");
    localStringBuilder.append("selfUin:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("friendUin:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("changeType:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append("old:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ");
    localStringBuilder.append("now:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo
 * JD-Core Version:    0.7.0.1
 */