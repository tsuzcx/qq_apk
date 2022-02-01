package com.tencent.mobileqq.activity.selectmember;

import ajxc;
import amsw;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bcef;
import bfur;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import lyc;
import muk;
import xwa;

class SelectMemberActivity$6
  implements View.OnClickListener
{
  SelectMemberActivity$6(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mIntent.getBooleanExtra("show_invite_entry", false)) {
      lyc.a(this.this$0.app, this.this$0, paramView, this.this$0.mIntent);
    }
    label101:
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.mEntrance == 11)
      {
        if (this.this$0.mInnerFrameManager.a() == 0) {
          bcef.b(this.this$0.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
        }
      }
      else if (this.this$0.mSubType == 3)
      {
        localObject2 = this.this$0.getIntent().getStringExtra("group_uin");
        localObject3 = muk.a(this.this$0.app, this.this$0.app.getCurrentAccountUin(), (String)localObject2) + "";
        if (!"发起视频".equals(this.this$0.mRightBtn.getText().toString())) {
          break label295;
        }
      }
      label295:
      for (localObject1 = "0";; localObject1 = "1")
      {
        bcef.b(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, "");
        if (this.this$0.mEntrance != 33) {
          break label302;
        }
        ajxc.a(this.this$0, this.this$0.mResultList);
        break;
        if (this.this$0.mInnerFrameManager.a() != 1) {
          break label101;
        }
        bcef.b(this.this$0.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
        break label101;
      }
      label302:
      if ((this.this$0.mEntrance == 32) && (this.this$0.mResultList.size() > this.this$0.mMaxSelectNumber))
      {
        localObject1 = MessageFormat.format(this.this$0.getString(2131718093), new Object[] { Integer.valueOf(this.this$0.mMaxSelectNumber) });
        QQToast.a(this.this$0, (CharSequence)localObject1, 0).b(this.this$0.mTitleBar.getHeight());
      }
      else if (!NetworkUtil.isNetSupport(this.this$0))
      {
        QQToast.a(this.this$0, this.this$0.getString(2131692035), 0).b(this.this$0.mTitleBar.getHeight());
      }
      else
      {
        if ((!this.this$0.mIsForbidOnlyChooseMySelf) || (this.this$0.mResultList.size() != 1) || (this.this$0.mResultList.get(0) == null)) {
          break;
        }
        localObject1 = (ResultRecord)this.this$0.mResultList.get(0);
        localObject2 = this.this$0.app.getCurrentUin();
        if ((localObject2 == null) || (((ResultRecord)localObject1).uin == null) || (!((String)localObject2).equals(((ResultRecord)localObject1).uin))) {
          break;
        }
        QQToast.a(this.this$0, this.this$0.getString(2131718091), 0).b(this.this$0.mTitleBar.getHeight());
      }
    }
    Object localObject1 = this.this$0.mResultList.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (((ResultRecord)((Iterator)localObject1).next()).type == 5);
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "right btn click entrance[" + this.this$0.mEntrance + "], uinType[" + this.this$0.mType + "], nopstn[" + bool + "]");
      }
      if (((this.this$0.mEntrance == 36) || (this.this$0.mEntrance == 11)) && (bool))
      {
        bfur.a(this.this$0, 230, this.this$0.getString(2131695219), this.this$0.getString(2131719057), 2131694952, 2131690952, new SelectMemberActivity.6.1(this), new SelectMemberActivity.6.2(this)).show();
        bcef.b(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
        break;
      }
      int i;
      if ((this.this$0.mEntrance == 12) && (this.this$0.mMaxSelectNumber == 1)) {
        if (this.this$0.mResultList.size() == 1)
        {
          localObject2 = (ResultRecord)this.this$0.mResultList.get(0);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("select_memeber_single_friend", true);
          ((Intent)localObject3).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject2).type);
          if ((((ResultRecord)localObject2).type == 0) && (((ResultRecord)localObject2).type != 1)) {
            break label1718;
          }
          i = 1000;
        }
      }
      for (localObject1 = this.this$0.getTroopCodeFromTroopUin(((ResultRecord)localObject2).groupUin);; localObject1 = null)
      {
        if (((ResultRecord)localObject2).type == 2)
        {
          localObject1 = ((ResultRecord)localObject2).groupUin;
          i = 1004;
        }
        label940:
        label1709:
        for (;;)
        {
          if (((ResultRecord)localObject2).type == 3) {
            i = 1021;
          }
          label1584:
          label1712:
          for (;;)
          {
            Object localObject4 = ((amsw)this.this$0.app.getManager(51)).e(((ResultRecord)localObject2).uin);
            int j = i;
            if (localObject4 != null)
            {
              j = i;
              if (((Friends)localObject4).isFriend()) {
                j = 0;
              }
            }
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("uin", ((ResultRecord)localObject2).uin);
            ((Bundle)localObject4).putInt("uintype", j);
            ((Bundle)localObject4).putString("uinname", ((ResultRecord)localObject2).name);
            ((Bundle)localObject4).putString("troop_uin", (String)localObject1);
            ((Intent)localObject3).putExtras((Bundle)localObject4);
            this.this$0.setResult(-1, (Intent)localObject3);
            this.this$0.finish();
            bcef.b(this.this$0.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
            label1095:
            if (this.this$0.mSubType == 1)
            {
              localObject1 = this.this$0.mResultList.iterator();
              i = 0;
              label1120:
              if (!((Iterator)localObject1).hasNext()) {
                break label1584;
              }
              localObject2 = (ResultRecord)((Iterator)localObject1).next();
              if ((((ResultRecord)localObject2).type != 1) && (((ResultRecord)localObject2).type != 2)) {
                break label1709;
              }
              i += 1;
            }
            for (;;)
            {
              break label1120;
              if (((ResultRecord)localObject2).type != 4) {
                break label1712;
              }
              i = 1006;
              break label940;
              this.this$0.startCreateOrAdd();
              break label1063;
              if (this.this$0.mEntrance == 23)
              {
                localObject1 = new Intent();
                localObject2 = new Bundle();
                localObject3 = new ArrayList();
                localObject4 = this.this$0.mResultList.iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject4).next();
                  if (localResultRecord.type == 1) {
                    ((ArrayList)localObject3).add(localResultRecord.uin);
                  }
                }
                ((Bundle)localObject2).putStringArrayList("troopMemList", (ArrayList)localObject3);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.this$0.setResult(-1, (Intent)localObject1);
                this.this$0.finish();
                break label1095;
              }
              if (this.this$0.mEntrance == 24)
              {
                localObject1 = new Intent();
                localObject2 = new Bundle();
                ((Bundle)localObject2).putParcelableArrayList("friendsSelected", this.this$0.mResultList);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.this$0.setResult(-1, (Intent)localObject1);
                if (this.this$0.isStoryNotSee) {
                  xwa.a("set_notsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
                for (;;)
                {
                  this.this$0.finish();
                  break;
                  xwa.a("set_notletsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
              }
              if (this.this$0.mEntrance == 37)
              {
                this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.mResultList);
                this.this$0.setResult(-1, this.this$0.mIntent);
                this.this$0.finish();
                break label1095;
              }
              if ((this.this$0.mType == 3000) && (this.this$0.mSubType == 0))
              {
                this.this$0.createNewTypeDiscussion();
                break label1095;
              }
              this.this$0.startCreateOrAdd();
              break label1095;
              break;
              if (i <= 0) {
                break;
              }
              localObject1 = ((TroopManager)this.this$0.app.getManager(52)).c(this.this$0.mGroupCode);
              if (localObject1 == null) {
                break;
              }
              localObject2 = this.this$0.app.getCurrentUin();
              if (((TroopInfo)localObject1).isTroopOwner((String)localObject2)) {
                j = 0;
              }
              for (;;)
              {
                bcef.b(this.this$0.app, "dc00899", "invite_friend", "", "friend_list", "invite_friend", 0, 0, this.this$0.mGroupCode, String.valueOf(j), String.valueOf(i), "");
                break;
                if (((TroopInfo)localObject1).isTroopAdmin((String)localObject2)) {
                  j = 1;
                } else {
                  j = 2;
                }
              }
            }
          }
        }
        label1063:
        label1718:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.6
 * JD-Core Version:    0.7.0.1
 */