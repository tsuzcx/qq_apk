import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class ames
  implements View.OnClickListener
{
  public ames(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("show_invite_entry", false)) {
      lyr.a(this.a.app, this.a, paramView, this.a.jdField_a_of_type_AndroidContentIntent);
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
          bdll.b(this.a.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
        }
      }
      else if (this.a.b == 3)
      {
        localObject2 = this.a.getIntent().getStringExtra("group_uin");
        localObject3 = mvb.a(this.a.app, this.a.app.getCurrentAccountUin(), (String)localObject2) + "";
        if (!"发起视频".equals(this.a.jdField_e_of_type_AndroidWidgetTextView.getText().toString())) {
          break label295;
        }
      }
      label295:
      for (localObject1 = "0";; localObject1 = "1")
      {
        bdll.b(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, "");
        if (this.a.d != 33) {
          break label302;
        }
        akzk.a(this.a, this.a.jdField_e_of_type_JavaUtilArrayList);
        break;
        if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 1) {
          break label101;
        }
        bdll.b(this.a.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
        break label101;
      }
      label302:
      if ((this.a.d == 32) && (this.a.jdField_e_of_type_JavaUtilArrayList.size() > this.a.g))
      {
        localObject1 = MessageFormat.format(this.a.getString(2131717855), new Object[] { Integer.valueOf(this.a.g) });
        QQToast.a(this.a, (CharSequence)localObject1, 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      }
      else if (!bhnv.d(this.a))
      {
        QQToast.a(this.a, this.a.getString(2131691989), 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      }
      else
      {
        if ((!this.a.v) || (this.a.jdField_e_of_type_JavaUtilArrayList.size() != 1) || (this.a.jdField_e_of_type_JavaUtilArrayList.get(0) == null)) {
          break;
        }
        localObject1 = (ResultRecord)this.a.jdField_e_of_type_JavaUtilArrayList.get(0);
        localObject2 = this.a.app.c();
        if ((localObject2 == null) || (((ResultRecord)localObject1).jdField_a_of_type_JavaLangString == null) || (!((String)localObject2).equals(((ResultRecord)localObject1).jdField_a_of_type_JavaLangString))) {
          break;
        }
        QQToast.a(this.a, this.a.getString(2131717853), 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      }
    }
    Object localObject1 = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (((ResultRecord)((Iterator)localObject1).next()).jdField_a_of_type_Int == 5);
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "right btn click entrance[" + this.a.d + "], uinType[" + this.a.jdField_a_of_type_Int + "], nopstn[" + bool + "]");
      }
      if (((this.a.d == 36) || (this.a.d == 11)) && (bool))
      {
        bhlq.a(this.a, 230, this.a.getString(2131695081), this.a.getString(2131718808), 2131694814, 2131690912, new amet(this), new ameu(this)).show();
        bdll.b(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
        break;
      }
      int i;
      if ((this.a.d == 12) && (this.a.g == 1)) {
        if (this.a.jdField_e_of_type_JavaUtilArrayList.size() == 1)
        {
          localObject2 = (ResultRecord)this.a.jdField_e_of_type_JavaUtilArrayList.get(0);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("select_memeber_single_friend", true);
          ((Intent)localObject3).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject2).jdField_a_of_type_Int);
          if ((((ResultRecord)localObject2).jdField_a_of_type_Int == 0) && (((ResultRecord)localObject2).jdField_a_of_type_Int != 1)) {
            break label1716;
          }
          i = 1000;
        }
      }
      for (localObject1 = this.a.a(((ResultRecord)localObject2).jdField_c_of_type_JavaLangString);; localObject1 = null)
      {
        if (((ResultRecord)localObject2).jdField_a_of_type_Int == 2)
        {
          localObject1 = ((ResultRecord)localObject2).jdField_c_of_type_JavaLangString;
          i = 1004;
        }
        label938:
        label1707:
        for (;;)
        {
          if (((ResultRecord)localObject2).jdField_a_of_type_Int == 3) {
            i = 1021;
          }
          label1582:
          label1710:
          for (;;)
          {
            Object localObject4 = ((anyw)this.a.app.getManager(51)).e(((ResultRecord)localObject2).jdField_a_of_type_JavaLangString);
            int j = i;
            if (localObject4 != null)
            {
              j = i;
              if (((Friends)localObject4).isFriend()) {
                j = 0;
              }
            }
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("uin", ((ResultRecord)localObject2).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject4).putInt("uintype", j);
            ((Bundle)localObject4).putString("uinname", ((ResultRecord)localObject2).b);
            ((Bundle)localObject4).putString("troop_uin", (String)localObject1);
            ((Intent)localObject3).putExtras((Bundle)localObject4);
            this.a.setResult(-1, (Intent)localObject3);
            this.a.finish();
            bdll.b(this.a.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
            label1093:
            if (this.a.b == 1)
            {
              localObject1 = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
              i = 0;
              label1118:
              if (!((Iterator)localObject1).hasNext()) {
                break label1582;
              }
              localObject2 = (ResultRecord)((Iterator)localObject1).next();
              if ((((ResultRecord)localObject2).jdField_a_of_type_Int != 1) && (((ResultRecord)localObject2).jdField_a_of_type_Int != 2)) {
                break label1707;
              }
              i += 1;
            }
            for (;;)
            {
              break label1118;
              if (((ResultRecord)localObject2).jdField_a_of_type_Int != 4) {
                break label1710;
              }
              i = 1006;
              break label938;
              this.a.a();
              break label1061;
              if (this.a.d == 23)
              {
                localObject1 = new Intent();
                localObject2 = new Bundle();
                localObject3 = new ArrayList();
                localObject4 = this.a.jdField_e_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject4).next();
                  if (localResultRecord.jdField_a_of_type_Int == 1) {
                    ((ArrayList)localObject3).add(localResultRecord.jdField_a_of_type_JavaLangString);
                  }
                }
                ((Bundle)localObject2).putStringArrayList("troopMemList", (ArrayList)localObject3);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.a.setResult(-1, (Intent)localObject1);
                this.a.finish();
                break label1093;
              }
              if (this.a.d == 24)
              {
                localObject1 = new Intent();
                localObject2 = new Bundle();
                ((Bundle)localObject2).putParcelableArrayList("friendsSelected", this.a.jdField_e_of_type_JavaUtilArrayList);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.a.setResult(-1, (Intent)localObject1);
                if (this.a.s) {
                  yup.a("set_notsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
                for (;;)
                {
                  this.a.finish();
                  break;
                  yup.a("set_notletsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
              }
              if (this.a.d == 37)
              {
                this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.a.jdField_e_of_type_JavaUtilArrayList);
                this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
                this.a.finish();
                break label1093;
              }
              if ((this.a.jdField_a_of_type_Int == 3000) && (this.a.b == 0))
              {
                this.a.m();
                break label1093;
              }
              this.a.a();
              break label1093;
              break;
              if (i <= 0) {
                break;
              }
              localObject1 = ((TroopManager)this.a.app.getManager(52)).c(this.a.jdField_c_of_type_JavaLangString);
              if (localObject1 == null) {
                break;
              }
              localObject2 = this.a.app.c();
              if (((TroopInfo)localObject1).isTroopOwner((String)localObject2)) {
                j = 0;
              }
              for (;;)
              {
                bdll.b(this.a.app, "dc00899", "invite_friend", "", "friend_list", "invite_friend", 0, 0, this.a.jdField_c_of_type_JavaLangString, String.valueOf(j), String.valueOf(i), "");
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
        label1061:
        label1716:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ames
 * JD-Core Version:    0.7.0.1
 */