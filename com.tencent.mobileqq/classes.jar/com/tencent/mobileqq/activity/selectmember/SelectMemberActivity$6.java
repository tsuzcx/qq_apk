package com.tencent.mobileqq.activity.selectmember;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.share.ShareChat;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.qwallet.IToPayManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

class SelectMemberActivity$6
  implements View.OnClickListener
{
  SelectMemberActivity$6(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("show_invite_entry", false)) {
      ShareChat.a(this.a.app, this.a, paramView, this.a.jdField_a_of_type_AndroidContentIntent);
    }
    label101:
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.d == 11)
      {
        if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
        }
      }
      else if (this.a.b == 3)
      {
        localObject2 = this.a.getIntent().getStringExtra("group_uin");
        localObject3 = TroopMemberUtil.a(this.a.app, this.a.app.getCurrentAccountUin(), (String)localObject2) + "";
        if (!"发起视频".equals(this.a.jdField_e_of_type_AndroidWidgetTextView.getText().toString())) {
          break label304;
        }
      }
      label304:
      for (localObject1 = "0";; localObject1 = "1")
      {
        ReportController.b(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, "");
        if (this.a.d != 33) {
          break label311;
        }
        SelectMemberActivity.a(this.a).topay(this.a, this.a.jdField_e_of_type_JavaUtilArrayList);
        break;
        if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 1) {
          break label101;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
        break label101;
      }
      label311:
      if (((this.a.d == 32) || (this.a.d == 43)) && (this.a.jdField_e_of_type_JavaUtilArrayList.size() > this.a.g))
      {
        localObject1 = MessageFormat.format(this.a.getString(2131719001), new Object[] { Integer.valueOf(this.a.g) });
        QQToast.a(this.a, (CharSequence)localObject1, 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      }
      else if (!NetworkUtil.d(this.a))
      {
        QQToast.a(this.a, this.a.getString(2131692257), 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      }
      else
      {
        if ((!this.a.v) || (this.a.jdField_e_of_type_JavaUtilArrayList.size() != 1) || (this.a.jdField_e_of_type_JavaUtilArrayList.get(0) == null)) {
          break;
        }
        localObject1 = (ResultRecord)this.a.jdField_e_of_type_JavaUtilArrayList.get(0);
        localObject2 = this.a.app.getCurrentUin();
        if ((localObject2 == null) || (((ResultRecord)localObject1).uin == null) || (!((String)localObject2).equals(((ResultRecord)localObject1).uin))) {
          break;
        }
        QQToast.a(this.a, this.a.getString(2131718999), 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      }
    }
    Object localObject1 = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (((ResultRecord)((Iterator)localObject1).next()).type == 5);
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "right btn click entrance[" + this.a.d + "], uinType[" + this.a.jdField_a_of_type_Int + "], nopstn[" + bool + "]");
      }
      if (((this.a.d == 36) || (this.a.d == 11)) && (bool))
      {
        DialogUtil.a(this.a, 230, this.a.getString(2131695677), this.a.getString(2131720026), 2131695411, 2131691144, new SelectMemberActivity.6.1(this), new SelectMemberActivity.6.2(this)).show();
        ReportController.b(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
        break;
      }
      int i;
      if ((this.a.d == 12) && (this.a.g == 1)) {
        if (this.a.jdField_e_of_type_JavaUtilArrayList.size() == 1)
        {
          localObject2 = (ResultRecord)this.a.jdField_e_of_type_JavaUtilArrayList.get(0);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("select_memeber_single_friend", true);
          ((Intent)localObject3).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject2).type);
          if ((((ResultRecord)localObject2).type == 0) && (((ResultRecord)localObject2).type != 1)) {
            break label1785;
          }
          i = 1000;
        }
      }
      for (localObject1 = this.a.a(((ResultRecord)localObject2).groupUin);; localObject1 = null)
      {
        if (((ResultRecord)localObject2).type == 2)
        {
          localObject1 = ((ResultRecord)localObject2).groupUin;
          i = 1004;
        }
        label960:
        label1756:
        for (;;)
        {
          if (((ResultRecord)localObject2).type == 3) {
            i = 1021;
          }
          label1116:
          label1776:
          label1779:
          for (;;)
          {
            Object localObject4 = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(((ResultRecord)localObject2).uin);
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
            this.a.setResult(-1, (Intent)localObject3);
            this.a.finish();
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
            if (this.a.b == 1)
            {
              localObject1 = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
              i = 0;
              label1141:
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (ResultRecord)((Iterator)localObject1).next();
                if ((((ResultRecord)localObject2).type != 1) && (((ResultRecord)localObject2).type != 2)) {
                  break label1776;
                }
                i += 1;
              }
            }
            for (;;)
            {
              break label1141;
              if (((ResultRecord)localObject2).type != 4) {
                break label1779;
              }
              i = 1006;
              break label960;
              this.a.a();
              break label1084;
              if (this.a.d == 23)
              {
                localObject1 = new Intent();
                localObject2 = new Bundle();
                localObject3 = new ArrayList();
                localObject4 = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject4).next();
                  if (localResultRecord.type == 1) {
                    ((ArrayList)localObject3).add(localResultRecord.uin);
                  }
                }
                ((Bundle)localObject2).putStringArrayList("troopMemList", (ArrayList)localObject3);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.a.setResult(-1, (Intent)localObject1);
                this.a.finish();
                break label1116;
              }
              if (this.a.d == 24)
              {
                localObject1 = new Intent();
                localObject2 = new Bundle();
                ((Bundle)localObject2).putParcelableArrayList("friendsSelected", this.a.jdField_e_of_type_JavaUtilArrayList);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.a.setResult(-1, (Intent)localObject1);
                if (this.a.s) {
                  StoryReportor.a("set_notsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
                for (;;)
                {
                  this.a.finish();
                  break;
                  StoryReportor.a("set_notletsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
              }
              if (this.a.d == 37)
              {
                this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.a.jdField_e_of_type_JavaUtilArrayList);
                this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
                this.a.finish();
                break label1116;
              }
              if ((this.a.jdField_a_of_type_Int == 3000) && (this.a.b == 0))
              {
                this.a.m();
                break label1116;
              }
              this.a.a();
              break label1116;
              if (i > 0)
              {
                localObject1 = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.a.jdField_c_of_type_JavaLangString);
                if (localObject1 != null)
                {
                  localObject2 = this.a.app.getCurrentUin();
                  if (!((TroopInfo)localObject1).isTroopOwner((String)localObject2)) {
                    break label1756;
                  }
                  j = 0;
                }
              }
              for (;;)
              {
                ReportController.b(this.a.app, "dc00899", "invite_friend", "", "friend_list", "invite_friend", 0, 0, this.a.jdField_c_of_type_JavaLangString, String.valueOf(j), String.valueOf(i), "");
                if (!QQGameTroopManager.b(this.a)) {
                  break;
                }
                QQGameTroopManager.a(this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_uin"), this.a.jdField_e_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("GAME_H5_SELECT_GAME_APPID"));
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
        label1084:
        label1785:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.6
 * JD-Core Version:    0.7.0.1
 */