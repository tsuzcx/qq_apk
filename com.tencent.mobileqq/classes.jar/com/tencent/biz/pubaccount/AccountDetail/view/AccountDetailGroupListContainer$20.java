package com.tencent.biz.pubaccount.accountdetail.view;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x487.oidb_0x487.GroupList;
import tencent.im.oidb.cmd0x487.oidb_0x487.RspBody;

class AccountDetailGroupListContainer$20
  extends ProtoUtils.TroopProtocolObserver
{
  AccountDetailGroupListContainer$20(AccountDetailGroupListContainer paramAccountDetailGroupListContainer) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onResult, errorCode=");
      paramBundle.append(paramInt);
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, paramBundle.toString());
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      int i;
      try
      {
        paramBundle = new oidb_0x487.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        int k = paramBundle.uint32_result.get();
        paramArrayOfByte = "";
        paramInt = 0;
        boolean bool = false;
        if (k == 0)
        {
          ArrayList localArrayList = new ArrayList();
          if (!paramBundle.msg_groups.has()) {
            break label517;
          }
          Object localObject1 = paramBundle.msg_groups.get();
          if (localObject1 == null) {
            break label517;
          }
          int j = ((List)localObject1).size();
          i = 0;
          paramInt = j;
          if (i < j)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((oidb_0x487.GroupList)((List)localObject1).get(i)).uint64_groupcode.get());
            ((StringBuilder)localObject2).append("");
            localObject2 = ((StringBuilder)localObject2).toString();
            ((oidb_0x487.GroupList)((List)localObject1).get(i)).bytes_group_name.get().toStringUtf8();
            localArrayList.add(localObject2);
            if (localArrayList.size() < 3) {
              break label508;
            }
            paramInt = j;
          }
          this.a.p.clear();
          this.a.p.addAll(localArrayList);
          if (paramBundle.uint32_privilege_flag.has())
          {
            localObject1 = this.a;
            if (paramBundle.uint32_privilege_flag.get() == 1) {
              bool = true;
            }
            ((AccountDetailGroupListContainer)localObject1).q = bool;
          }
          localObject1 = (TroopBindPublicAccountMgr)this.a.b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
          Object localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("mIsAbleBindTroop", this.a.q);
          ((Bundle)localObject2).putStringArrayList("mBindedTroopUins", localArrayList);
          ((TroopBindPublicAccountMgr)localObject1).a(this.a.g, (Bundle)localObject2);
          this.a.e();
        }
        if (QLog.isColorLevel())
        {
          if (paramBundle.bytes_errmsg.has()) {
            paramArrayOfByte = paramBundle.bytes_errmsg.get().toStringUtf8();
          }
          paramBundle = new StringBuilder();
          paramBundle.append("onResult, ret=");
          paramBundle.append(k);
          paramBundle.append(",");
          paramBundle.append(paramInt);
          paramBundle.append(",");
          paramBundle.append(paramArrayOfByte);
          paramBundle.append(",");
          paramBundle.append(this.a.q);
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, paramBundle.toString());
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("getBindedTroops, exception=");
          paramBundle.append(paramArrayOfByte.toString());
          QLog.e("PubAccountMoreInfoActivity.bindTroop", 2, paramBundle.toString());
        }
      }
      return;
      label508:
      i += 1;
      continue;
      label517:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.20
 * JD-Core Version:    0.7.0.1
 */