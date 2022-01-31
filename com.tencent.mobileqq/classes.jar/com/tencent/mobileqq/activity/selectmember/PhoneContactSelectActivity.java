package com.tencent.mobileqq.activity.selectmember;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import xzf;
import xzg;
import xzl;
import xzm;
import xzn;
import xzo;
import xzp;
import xzq;

public class PhoneContactSelectActivity
  extends SelectMemberActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  public PstnObserver a;
  TipsBar jdField_a_of_type_ComTencentMobileqqWidgetTipsBar;
  public String a;
  Thread jdField_a_of_type_JavaLangThread = new xzq(this);
  public ArrayList a;
  public boolean a;
  int jdField_b_of_type_Int;
  TipsBar jdField_b_of_type_ComTencentMobileqqWidgetTipsBar;
  public ArrayList b;
  boolean jdField_b_of_type_Boolean;
  public ArrayList c;
  boolean c;
  public ArrayList d;
  boolean d;
  public ArrayList e;
  boolean e;
  
  public PhoneContactSelectActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = null;
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    if (paramActivity == null)
    {
      QLog.i("PhoneContactSelectActivity", 1, "=== openPhoneContactSelectActivity mActivity is null");
      return;
    }
    Intent localIntent = new Intent(paramActivity, PhoneContactSelectActivity.class);
    localIntent.putExtra("param_ui_flag", 0);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_entrance", 10);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131435092));
    localIntent.putExtra("param_done_button_highlight_wording", paramActivity.getString(2131436011));
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    paramActivity.startActivityForResult(localIntent, paramInt);
    paramActivity.overridePendingTransition(2131034132, 2131034133);
  }
  
  public static void a(Context paramContext, int paramInt1, ArrayList paramArrayList, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, PhoneContactSelectActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_ui_flag", 1);
    localIntent.putExtra("param_from", 1007);
    localIntent.putExtra("param_uin_divider_list", paramArrayList);
    localIntent.putExtra("param_title", paramContext.getString(2131438387));
    localIntent.putExtra("param_divider_title", paramContext.getString(paramInt2));
    localIntent.putExtra("param_entrance", 17);
    localIntent.putExtra("param_ip_pstn_enter_type", paramInt1);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    ((Activity)paramContext).startActivityForResult(localIntent, 110);
  }
  
  public static void a(Context paramContext, String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, PhoneContactSelectActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_phone_list", paramArrayList1);
    localIntent.putParcelableArrayListExtra("param_uin_selected_list", paramArrayList2);
    localIntent.putExtra("param_entrance", 18);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.putExtra("param_done_button_wording", paramContext.getString(2131435092));
    localIntent.putExtra("param_done_button_highlight_wording", paramContext.getString(2131436011));
    localIntent.putExtra("param_report_type", paramInt);
    localIntent.setFlags(603979776);
    ((Activity)paramContext).startActivityForResult(localIntent, 111);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((!paramString1.equals(paramString2)) && (!paramString1.equals("pstn" + paramString2)) && (!paramString2.equals("pstn" + paramString1))) {
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    Iterator localIterator = this.i.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((ResultRecord)localIterator.next()).jdField_a_of_type_Int == 5);
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ShowJoinDiscTips", false)) && (i != 0))
      {
        DialogUtil.b(this, 230, getString(2131429041), getString(2131433989), 2131429048, 2131429053, new xzm(this), new xzn(this)).show();
        return true;
      }
      return false;
    }
  }
  
  private boolean h()
  {
    boolean bool2 = true;
    if (this.i.size() == 0) {
      return false;
    }
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() <= this.i.size())
    {
      bool1 = bool2;
      if (this.jdField_c_of_type_JavaLangString != null)
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (bool1 = true; localIterator.hasNext(); bool1 = false)
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          bool1 = bool2;
          if (!this.i.contains(localResultRecord)) {
            break;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean i()
  {
    if (this.i.size() == 0) {}
    while (this.jdField_b_of_type_JavaUtilArrayList.size() != this.i.size()) {
      return false;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!localIterator.hasNext()) {
        return bool;
      }
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (!this.i.contains(localResultRecord)) {
        break;
      }
    }
    return bool;
  }
  
  protected ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.app.getManager(10);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.jdField_a_of_type_Int == 5)
      {
        if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
          localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
        }
        localArrayList.add(localResultRecord);
      }
      else if ((localResultRecord.jdField_a_of_type_Int == 4) && (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("+")))
      {
        localArrayList.add(localResultRecord);
      }
      else
      {
        PhoneContact localPhoneContact = localPhoneContactManager.a(localResultRecord.jdField_a_of_type_JavaLangString);
        if ((localPhoneContact != null) && (this.jdField_d_of_type_JavaUtilArrayList.contains(localPhoneContact.mobileNo))) {
          localArrayList.add(localResultRecord);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.i);
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
    }
    Object localObject2;
    ResultRecord localResultRecord;
    if (this.q)
    {
      localObject1 = this.jdField_f_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localResultRecord = new ResultRecord();
        localResultRecord.jdField_a_of_type_JavaLangString = ((String)localObject2);
        localResultRecord.jdField_a_of_type_Int = 0;
        localResultRecord.jdField_c_of_type_JavaLangString = "-1";
        this.i.add(localResultRecord);
      }
    }
    if (this.jdField_c_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResultRecord)((Iterator)localObject1).next();
        if (!this.i.contains(localObject2)) {
          this.i.add(localObject2);
        }
      }
    }
    int m = this.i.size();
    Object localObject1 = this.i.iterator();
    int k = 0;
    int j = 0;
    label244:
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ResultRecord)((Iterator)localObject1).next();
      if ((((ResultRecord)localObject2).jdField_a_of_type_Int == 5) || (((ResultRecord)localObject2).jdField_a_of_type_Int == 4) || (((ResultRecord)localObject2).jdField_a_of_type_Int == 0))
      {
        if ((((ResultRecord)localObject2).d == null) || (((ResultRecord)localObject2).d.equals("")) || (k != 0)) {
          break label1081;
        }
        i = 1;
      }
    }
    for (;;)
    {
      k = i;
      break label244;
      if (j == 0)
      {
        i = k;
        j = 1;
        continue;
        if (((this.jdField_d_of_type_Int == 0) && (m == 1) && (this.jdField_f_of_type_Int == 10)) || ((this.jdField_f_of_type_Int == 18) && (m == 1) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContactSelectActivity", 2, "start C2C audio");
          }
          localResultRecord = (ResultRecord)this.i.get(0);
          i = localResultRecord.jdField_a_of_type_Int;
          localObject2 = null;
          if (localResultRecord.jdField_a_of_type_Int == 0)
          {
            i = 0;
            localObject1 = localObject2;
          }
          for (;;)
          {
            if (k != 0) {
              break label610;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContactSelectActivity", 2, "start c2c call.");
            }
            if (!ChatActivityUtils.a(this.app, this, 0, localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.b, null, true, null, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, null, 9, true)) {
              break;
            }
            this.g = 2;
            finish();
            return;
            if (localResultRecord.jdField_a_of_type_Int == 1)
            {
              i = 1000;
              localObject1 = a(((ResultRecord)this.i.get(0)).jdField_c_of_type_JavaLangString);
            }
            else if (localResultRecord.jdField_a_of_type_Int == 2)
            {
              i = 1004;
              localObject1 = ((ResultRecord)this.i.get(0)).jdField_c_of_type_JavaLangString;
            }
            else if (localResultRecord.jdField_a_of_type_Int == 3)
            {
              i = 1021;
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = localObject2;
              if (localResultRecord.jdField_a_of_type_Int == 4)
              {
                i = 1006;
                localObject1 = localObject2;
              }
            }
          }
          label610:
          if ((k != 0) && ((!PstnUtils.a(this.app, 2)) || (PstnUtils.a(this.app, 1))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContactSelectActivity", 2, "start c2c call.");
            }
            localObject2 = localResultRecord.d;
            if (!ChatActivityUtils.a(this.app, this, i, localResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.b, (String)localObject2, true, (String)localObject1, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, null, 9, true)) {
              break;
            }
            if (this.jdField_e_of_type_Boolean) {
              ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 12, 0, "", "", "", "");
            }
            for (;;)
            {
              this.g = 2;
              finish();
              return;
              ReportController.b(this.app, "CliOper", "", "", "0X8006406", "0X8006406", 1, 0, "", "", "", "");
            }
          }
        }
        if (this.jdField_f_of_type_Int == 18)
        {
          if (i())
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("audioType", 2);
            ((Intent)localObject1).putExtra("uinType", 3000);
            ((Intent)localObject1).putExtra("roomId", this.jdField_c_of_type_JavaLangString);
            ((Intent)localObject1).putExtra("qqPhoneUserList", this.jdField_e_of_type_JavaUtilArrayList);
            ((Intent)localObject1).putExtra("from", 3);
            ((Intent)localObject1).putExtra("callType", 2);
            setResult(-1, (Intent)localObject1);
            finish();
            return;
          }
          if (h()) {}
          for (i = 2131433984;; i = 2131433986)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131558448));
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(i);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            this.jdField_a_of_type_JavaLangThread.setName("PhoneContactSelectActivity_addDiscussion");
            ThreadManager.postImmediately(this.jdField_a_of_type_JavaLangThread, null, false);
            return;
          }
        }
        if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 1) || (j != 0)) {
          if (this.jdField_d_of_type_Int != 0) {
            break label1074;
          }
        }
        label1074:
        for (i = 2131433984;; i = 2131433986)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131558448));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(i);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          this.jdField_a_of_type_JavaLangThread.setName("SelectMemberActivity_addDiscussion");
          ThreadManager.postImmediately(this.jdField_a_of_type_JavaLangThread, null, false);
          if (this.jdField_d_of_type_Int == 0) {
            break;
          }
          s();
          if (j != 0) {
            break;
          }
          finish();
          return;
        }
      }
      label1081:
      i = k;
    }
  }
  
  public void a(View paramView)
  {
    IContactSearchModel localIContactSearchModel = (IContactSearchModel)paramView.getTag(2131362079);
    if (localIContactSearchModel == null) {
      return;
    }
    paramView = localIContactSearchModel.a();
    Object localObject1 = localIContactSearchModel.a().toString();
    Object localObject2 = "";
    if ((localIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
      ((ContactSearchModelDiscussionMember)localIContactSearchModel).e();
    }
    Object localObject3;
    for (;;)
    {
      if ((localIContactSearchModel instanceof ContactSearchModelPhoneContact)) {
        if (a())
        {
          DialogUtil.a(this, PstnUtils.b(this.app, 2), PstnUtils.c(this.app, 2), PstnUtils.d(this.app, 2), new xzo(this), getString(2131429558), new xzp(this)).show();
          return;
          if ((localIContactSearchModel instanceof ContactSearchModelNewTroopMember)) {
            localObject3 = ((ContactSearchModelNewTroop)localIContactSearchModel).jdField_a_of_type_JavaLangString;
          }
        }
        else
        {
          localObject2 = ((ContactSearchModelPhoneContact)localIContactSearchModel).a;
          if (TextUtils.isEmpty(((PhoneContact)localObject2).uin))
          {
            localObject1 = "pstn" + ((PhoneContact)localObject2).mobileNo;
            paramView = ((PhoneContact)localObject2).mobileNo;
            localObject3 = ((PhoneContact)localObject2).name;
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (!a((String)((Iterator)localObject3).next(), paramView));
      }
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || ((this.jdField_f_of_type_JavaUtilArrayList != null) && (this.jdField_f_of_type_JavaUtilArrayList.contains(paramView))) || (a(paramView)) || (a(false)) || (b(paramView, (String)localObject1))) {
          break label804;
        }
        localObject3 = (ContactFriendInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
        if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 1) {
          if (((localIContactSearchModel instanceof ContactSearchModelDiscussionMember)) || ((localIContactSearchModel instanceof ContactSearchModelNewTroopMember))) {
            this.i.add(a(paramView, (String)localObject1, 2, ((ContactFriendInnerFrame)localObject3).a()));
          }
        }
        for (;;)
        {
          r();
          j();
          ((ContactFriendInnerFrame)localObject3).f();
          b(true);
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          return;
          if (((PhoneContact)localObject2).uin.equals("0"))
          {
            paramView = ((PhoneContact)localObject2).nationCode + ((PhoneContact)localObject2).mobileCode;
            localObject1 = paramView;
            break;
          }
          localObject1 = ((PhoneContact)localObject2).uin;
          paramView = ((PhoneContact)localObject2).mobileNo;
          break;
          if ((localIContactSearchModel instanceof ContactSearchModelFriend)) {
            this.i.add(a(paramView, (String)localObject1, 0, "-1"));
          } else if ((localIContactSearchModel instanceof ContactSearchModelPhoneContact)) {
            if ((paramView.startsWith("pstn")) && (b(paramView, (String)localObject1, 5, "-1")))
            {
              this.i.add(a(paramView, (String)localObject1, 5, "-1", (String)localObject2));
            }
            else if (paramView.startsWith("+"))
            {
              this.i.add(a(paramView, (String)localObject1, 4, "-1"));
            }
            else
            {
              this.i.add(a(paramView, (String)localObject1, 0, "-1"));
              continue;
              if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 2) {
                this.i.add(a(paramView, (String)localObject1, 1, ((ContactFriendInnerFrame)localObject3).a()));
              } else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 3) {
                this.i.add(a(paramView, (String)localObject1, 2, ((ContactFriendInnerFrame)localObject3).a()));
              } else if (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0) {
                if ((localIContactSearchModel instanceof ContactSearchModelPhoneContact))
                {
                  if (paramView.startsWith("pstn"))
                  {
                    if (b(paramView, (String)localObject1, 5, "-1")) {
                      this.i.add(a(paramView, (String)localObject1, 5, "-1", (String)localObject2));
                    }
                  }
                  else if (paramView.startsWith("+")) {
                    this.i.add(a(paramView, (String)localObject1, 4, "-1", (String)localObject2));
                  } else {
                    this.i.add(a(paramView, (String)localObject1, 0, "-1", (String)localObject2));
                  }
                }
                else if ((localIContactSearchModel instanceof ContactSearchModelFriend)) {
                  this.i.add(a(paramView, (String)localObject1, 0, "-1", (String)localObject2));
                }
              }
            }
          }
        }
      }
      label804:
      break;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_f_of_type_Int == 10)
    {
      if ((this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Int == 2)) {}
    }
    else {
      while (((this.jdField_f_of_type_Int == 17) || (this.jdField_f_of_type_Int == 20) || (this.jdField_f_of_type_Int == 19) || (this.jdField_f_of_type_Int == 18)) && (!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int != 2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.a(paramString))
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= this.i.size()) {
        break;
      }
      if (a(paramString, ((ResultRecord)this.i.get(i)).d)) {
        return true;
      }
      i += 1;
    }
  }
  
  protected void c()
  {
    setContentView(2130969162);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(this);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity$GridViewAdapter.a(this.jdField_b_of_type_JavaUtilArrayList);
      b(true);
      r();
      j();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = null;
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver = new xzf(this);
    if (this.app != null) {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallPstnObserver);
    }
  }
  
  protected void f()
  {
    super.f();
    this.h = true;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_ui_flag", 0);
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uin_selected_default_contact");
    this.jdField_c_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("param_uin_create_list");
    this.jdField_d_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_uin_divider_list");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_divider_title");
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_ip_pstn_enter_type", 2);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_no_answer_list_default_selected", true);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_show_none_friends_in_contact", true);
    this.jdField_e_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("param_phone_list");
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("param_uin_selected_list");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("NEED_CLOSE_WHEN_PSTN_CLOSE", false)) {
      e();
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      Object localObject = (PstnManager)this.app.getManager(142);
      if (localObject == null) {
        break label259;
      }
      localObject = ((PstnManager)localObject).a(this.app.getCurrentAccountUin());
      if (localObject == null) {
        break label253;
      }
      if ((((PstnCardInfo)localObject).pstn_ever_c2c_vip == 0) && (((PstnCardInfo)localObject).pstn_ever_multi_vip == 0) && (!PstnUtils.a(this.app, 2)) && (!PstnUtils.a(this.app, 1))) {
        this.jdField_a_of_type_Int = 2;
      }
    }
    return;
    label253:
    this.jdField_a_of_type_Int = 2;
    return;
    label259:
    this.jdField_a_of_type_Int = 2;
  }
  
  protected void g()
  {
    super.g();
    this.jdField_c_of_type_Boolean = PstnUtils.a(this.app, 1);
    this.jdField_d_of_type_Boolean = PstnUtils.a(this.app, 2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)findViewById(2131365457));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(this);
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)findViewById(2131365456));
      this.jdField_b_of_type_ComTencentMobileqqWidgetTipsBar.a(false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void h()
  {
    super.h();
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new xzg(this));
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new xzl(this));
  }
  
  protected boolean onBackEvent()
  {
    switch (this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a())
    {
    default: 
      return true;
    case 0: 
      finish();
      return true;
    case 1: 
      q();
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
      return true;
    }
    q();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131365458: 
    case 2131365459: 
    default: 
      return;
    }
    PstnUtils.a(this.app, this, 2, 1);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity
 * JD-Core Version:    0.7.0.1
 */