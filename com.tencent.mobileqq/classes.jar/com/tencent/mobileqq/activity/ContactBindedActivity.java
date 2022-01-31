package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import aavg;
import aavh;
import aavi;
import aavj;
import aavk;
import aavl;
import aimf;
import aimi;
import aimj;
import ajxl;
import ajya;
import akbn;
import akbt;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import askn;
import awna;
import awoe;
import awqw;
import axqy;
import baww;
import baxy;
import bbdj;
import bbef;
import bbgu;
import bcnf;
import bcql;
import bdio;
import bfos;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ContactBindedActivity
  extends IphoneTitleBarActivity
  implements aimj, akbt, Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, ViewStub.OnInflateListener, AdapterView.OnItemClickListener, awqw, bcnf, bfos
{
  public static final String[] a;
  public static final String[] b;
  public int a;
  private aavj jdField_a_of_type_Aavj;
  private aavl jdField_a_of_type_Aavl = new aavl(null);
  private aimf jdField_a_of_type_Aimf;
  private akbn jdField_a_of_type_Akbn;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private baxy jdField_a_of_type_Baxy;
  private bbgu jdField_a_of_type_Bbgu;
  PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public PhoneContact a;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  private CustomHorizontalScrollView jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList<PhoneContact> a;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  public Handler b;
  private View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList<PhoneContact> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean b;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View e;
  private View f;
  private View g;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "$", "★", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
  }
  
  public ContactBindedActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "startFromOtherPage requestCode: " + paramInt1 + "  fromPage:" + paramInt2);
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      if (paramInt2 == 1) {
        axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8009EC5", "0X8009EC5", 0, 0, "", "", "", "");
      }
      paramQQAppInterface = new Intent(localBaseActivity, ContactBindedActivity.class);
      paramQQAppInterface.putExtra("from_type", 0);
      paramQQAppInterface.putExtra("from_page", paramInt2);
      localBaseActivity.startActivityForResult(paramQQAppInterface, paramInt1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("check_permission_result");
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, String.format("startFromOther [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str }));
    }
    paramIntent = BaseActivity.sTopActivity;
    if (paramIntent != null)
    {
      axqy.b(paramQQAppInterface, "dc00898", "", "", "0X80077CF", "0X80077CF", 0, 0, "", "", "", "");
      axqy.b(paramQQAppInterface, "dc00898", "", "", "0X800796B", "0X800796B", 0, 0, "", "", "", "");
      paramQQAppInterface = new Intent(paramIntent, ContactBindedActivity.class);
      paramQQAppInterface.putExtra("from_type", 0);
      paramQQAppInterface.putExtra("kSrouce", paramInt1);
      paramQQAppInterface.putExtra("fromKeyForContactBind", paramInt2);
      paramIntent.startActivityForResult(paramQQAppInterface, 222);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<PhoneContact> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "startFromOther requestCode: " + paramInt + "  starList:" + paramArrayList);
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8007971", "0X8007971", 0, 0, "", "", "", "");
      paramQQAppInterface = new Intent(localBaseActivity, ContactBindedActivity.class);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        ArrayList localArrayList = new ArrayList(paramArrayList.size());
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(((PhoneContact)paramArrayList.next()).mobileNo);
        }
        paramQQAppInterface.putExtra("isBindAction", localArrayList);
      }
      paramQQAppInterface.putExtra("from_type", 1);
      localBaseActivity.startActivityForResult(paramQQAppInterface, paramInt);
    }
  }
  
  private void b(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() >= 100)
      {
        bcql.a(this, 1, 2131691061, 0).b(getTitleBarHeight());
        paramBoolean = false;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        this.jdField_a_of_type_Aimf.a(paramPhoneContact, paramBoolean);
        if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.e(this.jdField_b_of_type_JavaUtilArrayList);
        }
        if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
          break;
        }
        paramPhoneContact = getString(2131691059);
        label92:
        this.jdField_a_of_type_AndroidWidgetButton.setText(paramPhoneContact);
        paramPhoneContact = this.jdField_a_of_type_AndroidWidgetButton;
        paramBoolean = bool;
        if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
          paramBoolean = true;
        }
        paramPhoneContact.setEnabled(paramBoolean);
        a(true);
        return;
        this.jdField_b_of_type_JavaUtilArrayList.add(paramPhoneContact);
      }
    }
    int i = 0;
    label145:
    if (i < this.jdField_b_of_type_JavaUtilArrayList.size()) {
      if (!TextUtils.equals(((PhoneContact)this.jdField_b_of_type_JavaUtilArrayList.get(i)).unifiedCode, paramPhoneContact.unifiedCode)) {}
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList.remove(i);
      break;
      i += 1;
      break label145;
      paramPhoneContact = getString(2131691060, new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
      break label92;
      i = -1;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, Boolean.valueOf(paramBoolean)), 100L);
  }
  
  private void c(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (!this.jdField_a_of_type_Boolean) {
        break label297;
      }
      this.leftView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.f.setVisibility(0);
      if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
        break label268;
      }
      localObject = getString(2131691059);
      label68:
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.removeHeaderView(this.g);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = ContactSearchFragment.a(19, 524288, null, null, this);
        localObject = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject).add(2131375703, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
      label139:
      if (paramBoolean)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_Aimf.jdField_a_of_type_JavaUtilList.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.e(this.jdField_b_of_type_JavaUtilArrayList);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      paramBoolean = bool2;
      if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
        paramBoolean = true;
      }
      ((Button)localObject).setEnabled(paramBoolean);
      localObject = this.rightViewText;
      if (!this.jdField_a_of_type_Boolean) {
        break label370;
      }
    }
    label268:
    label297:
    label370:
    for (int i = 2131690596;; i = 2131691064)
    {
      ((TextView)localObject).setText(i);
      this.jdField_a_of_type_Aavj.notifyDataSetChanged();
      this.jdField_a_of_type_Aimf.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      a(true);
      return;
      bool1 = false;
      break;
      localObject = getString(2131691060, new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
      break label68;
      this.leftView.setVisibility(0);
      this.e.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.g);
      this.f.setVisibility(8);
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getWindowToken(), 0);
      break label139;
    }
  }
  
  private void e()
  {
    int j = 1;
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    Object localObject;
    int i;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() == 1)
    {
      localObject = (askn)this.app.getManager(11);
      i = 3006;
      if (((askn)localObject).h()) {
        break label168;
      }
      i = 3075;
    }
    for (;;)
    {
      localObject = (PhoneContact)this.jdField_b_of_type_JavaUtilArrayList.get(0);
      startActivityForResult(AddFriendLogicActivity.a(this, 2, ((PhoneContact)localObject).unifiedCode, null, i, j, ((PhoneContact)localObject).name, null, null, ajya.a(2131702464), null), 102);
      return;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 100) {
        break;
      }
      localObject = (askn)this.app.getManager(11);
      i = 3078;
      if (!((askn)localObject).h()) {
        i = 3079;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_b_of_type_JavaUtilArrayList, i, null, ajya.a(2131702467), null, this.jdField_b_of_type_Int), 101);
      return;
      label168:
      j = 13;
    }
  }
  
  public void a(aimi paramaimi)
  {
    if ((paramaimi.jdField_a_of_type_JavaUtilList.size() > 0) || (this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if ((paramaimi.jdField_a_of_type_JavaUtilList.size() > 10) && (!this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
      {
        axqy.b(this.app, "dc00898", "", "", "0X8007972", "0X8007972", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = true;
      }
      if ((paramaimi.jdField_a_of_type_JavaUtilList.size() <= 10) && (!this.jdField_c_of_type_Boolean)) {
        break label147;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aimf.a(paramaimi);
      this.jdField_a_of_type_Aimf.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      label147:
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (awoe)paramView.getTag(2131379213);
    if (paramView == null) {}
    do
    {
      return;
      paramView = ((awna)paramView).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    } while (paramView == null);
    b(paramView, true);
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (paramPhoneContact != null) {
      b(paramPhoneContact, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Aimf.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(this.jdField_b_of_type_JavaUtilArrayList.size());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = ((int)((this.jdField_b_of_type_JavaUtilArrayList.size() * 40 + this.jdField_b_of_type_JavaUtilArrayList.size() * 10) * this.mDensity));
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    c();
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
    }
    this.jdField_a_of_type_Aavj.notifyDataSetChanged();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    View localView = this.e;
    if (TextUtils.isEmpty(paramEditable)) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.a(paramEditable);
      }
      return;
    }
  }
  
  public void ag_()
  {
    b(false);
  }
  
  public void b()
  {
    b(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.mDensity * 40.0F));
    int j = (int)(this.mDensity * 10.0F);
    int i;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() < 5)
      {
        i = (int)((this.jdField_b_of_type_JavaUtilArrayList.size() * 40 + this.jdField_b_of_type_JavaUtilArrayList.size() * 10) * this.mDensity) + (int)(this.mDensity * 10.0F);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(i, 0, j, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      return;
      i = (int)(230.0F * this.mDensity);
      break;
      i = (int)(this.mDensity * 40.0F);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = null;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 101) && (paramInt2 == -1))
    {
      if (paramIntent.hasExtra("result"))
      {
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("result");
        if (!paramIntent.isEmpty())
        {
          localObject2 = new ArrayList();
          localObject3 = new ArrayList();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          localObject1 = (ajxl)this.app.getManager(51);
          localObject4 = paramIntent.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FriendListHandler.AddBatchPhoneFriendResult)((Iterator)localObject4).next();
            if (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 0)
            {
              ((ajxl)localObject1).a(((FriendListHandler.AddBatchPhoneFriendResult)localObject5).mobile, true);
              ((List)localObject2).add(localObject5);
            }
            else if (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 37)
            {
              localArrayList1.add(localObject5);
            }
            else if ((((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 32) || (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 33))
            {
              localArrayList2.add(localObject5);
            }
            else if (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).allowType == 2)
            {
              ((List)localObject3).add(localObject5);
            }
          }
          if (QLog.isColorLevel())
          {
            paramInt1 = paramIntent.size();
            paramInt2 = ((List)localObject2).size();
            i = ((List)localObject3).size();
            j = localArrayList1.size();
            k = localArrayList2.size();
            QLog.d("IphoneTitleBarActivity", 2, "doOnActivityResult, adds=" + ((List)localObject2).size() + ", needAnswers=" + ((List)localObject3).size() + ", security anti=" + localArrayList1.size() + ", upToLimits=" + localArrayList2.size() + ", others=" + (paramInt1 - paramInt2 - i - j - k));
          }
          paramIntent = "";
          localObject4 = new StringBuilder();
          if (!localArrayList1.isEmpty())
          {
            paramIntent = ajya.a(2131702472);
            ((StringBuilder)localObject4).append("部分好友添加失败，请稍后再试。");
          }
          for (;;)
          {
            if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()) || (!((List)localObject3).isEmpty()))
            {
              this.jdField_a_of_type_Bbgu = bbdj.a(this, 230, paramIntent, ((StringBuilder)localObject4).toString(), new aavg(this), null);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 900L);
            }
            ((List)localObject3).addAll((Collection)localObject2);
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            paramIntent = ((List)localObject3).iterator();
            while (paramIntent.hasNext())
            {
              localObject1 = (FriendListHandler.AddBatchPhoneFriendResult)paramIntent.next();
              localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (PhoneContact)((Iterator)localObject2).next();
                if (((FriendListHandler.AddBatchPhoneFriendResult)localObject1).mobile.equals(((PhoneContact)localObject3).unifiedCode)) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
                }
              }
            }
            if (!localArrayList2.isEmpty())
            {
              paramIntent = ajya.a(2131702475);
              ((StringBuilder)localObject4).append("好友已达上限，部分好友未添加。");
            }
            else if (!((List)localObject3).isEmpty())
            {
              paramIntent = getString(2131691063);
              if (((List)localObject3).size() == 1)
              {
                localObject1 = (FriendListHandler.AddBatchPhoneFriendResult)((List)localObject3).get(0);
                localObject5 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  localObject6 = (PhoneContact)((Iterator)localObject5).next();
                  if (((FriendListHandler.AddBatchPhoneFriendResult)localObject1).mobile.equals(((PhoneContact)localObject6).unifiedCode)) {
                    if (!TextUtils.isEmpty(((PhoneContact)localObject6).name)) {
                      break label769;
                    }
                  }
                }
                label769:
                for (localObject1 = ((PhoneContact)localObject6).nickName;; localObject1 = ((PhoneContact)localObject6).name)
                {
                  ((StringBuilder)localObject4).append(bdio.a((String)localObject1, 12, true)).append("的好友验证方式需要回答问题, 请单独添加。");
                  break;
                }
              }
              localObject5 = new ArrayList(((List)localObject3).size());
              localObject1 = ((List)localObject3).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject6 = (FriendListHandler.AddBatchPhoneFriendResult)((Iterator)localObject1).next();
                localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                while (localIterator.hasNext())
                {
                  localPhoneContact = (PhoneContact)localIterator.next();
                  if (((FriendListHandler.AddBatchPhoneFriendResult)localObject6).mobile.equals(localPhoneContact.unifiedCode)) {
                    ((List)localObject5).add(localPhoneContact);
                  }
                }
              }
              Collections.sort((List)localObject5, this.jdField_a_of_type_Aavl);
              paramInt1 = 0;
              if (paramInt1 < 2)
              {
                localObject1 = (PhoneContact)((List)localObject5).get(paramInt1);
                if (TextUtils.isEmpty(((PhoneContact)localObject1).name)) {}
                for (localObject1 = ((PhoneContact)localObject1).nickName;; localObject1 = ((PhoneContact)localObject1).name)
                {
                  ((StringBuilder)localObject4).append(bdio.a((String)localObject1, 12, true));
                  if (paramInt1 == 0) {
                    ((StringBuilder)localObject4).append("、");
                  }
                  paramInt1 += 1;
                  break;
                }
              }
              ((StringBuilder)localObject4).append("等").append(((List)localObject3).size()).append("位联系人的好友验证方式需要回答问题, 请单独添加。");
              if (this.jdField_b_of_type_Int == 0) {
                axqy.b(this.app, "dc00898", "", "", "0X8007970", "0X8007970", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
              } else {
                axqy.b(this.app, "dc00898", "", "", "0X8007977", "0X8007977", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString);
          this.jdField_c_of_type_Boolean = true;
        }
      }
      b(false);
      c(true);
      a(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4), 120L);
    }
    while ((paramInt1 != 102) || (paramInt2 != -1))
    {
      Object localObject2;
      Object localObject3;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      Object localObject1;
      Object localObject4;
      Object localObject5;
      int i;
      int j;
      int k;
      Object localObject6;
      Iterator localIterator;
      PhoneContact localPhoneContact;
      return;
    }
    if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_c_of_type_Boolean = true;
    }
    b(false);
    c(true);
    a(true);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4), 120L);
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setSoftInputMode(48);
    setContentView(2131560702);
    paramBundle = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = (ArrayList)paramBundle.getSerializableExtra("isBindAction");
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b((String)localObject2);
        if (localObject2 != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          continue;
          this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
        }
      }
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("from_type", 1);
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("from_page", -1);
      if (paramBundle.getIntExtra("fromKeyForContactBind", 0) == 1) {
        bcql.a(BaseApplication.getContext(), 2, 2131695017, 0);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mFlingHandler = new aavk(this, this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375493);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131376779));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368472));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694995);
    setTitle(getString(2131694995));
    setLeftViewName(2131690572);
    this.leftView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131375710);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375662));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131375674);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131375723));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_c_of_type_AndroidViewView.findViewById(2131375822));
    baww.a(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_Aavj = new aavj(this, this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Aavj);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_Baxy = new baxy(this, this.app);
    this.jdField_a_of_type_Baxy.a(this.jdField_a_of_type_Aavj);
    this.jdField_a_of_type_AndroidGraphicsBitmap = bbef.a();
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.e = findViewById(2131375703);
    this.f = findViewById(2131366335);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363587));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.g = LayoutInflater.from(this).inflate(2131562360, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.g.findViewById(2131363479).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.g.findViewById(2131365763));
    this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.g);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368073));
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_b_of_type_ArrayOfJavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365656);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      if ((paramBundle != null) && (TextUtils.isEmpty(paramBundle.mobileNo)) && (paramBundle.noBindUploadContacts == true)) {
        axqy.b(this.app, "dc00898", "", "", "0X80077CC", "0X80077CC", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h()) {
        axqy.b(this.app, "dc00898", "", "", "0X80077D2", "0X80077D2", 0, 0, "", "", "", "");
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a;
      if ((paramBundle == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
        paramBundle = new aimi();
      }
      this.jdField_a_of_type_Aimf = new aimf(this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, paramBundle.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Aimf.jdField_a_of_type_Aimj = this;
      this.jdField_a_of_type_Aimf.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aimf);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this);
      if (!paramBundle.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject1 = paramBundle;
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject1 = paramBundle;
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
          {
            long l1 = System.currentTimeMillis();
            paramBundle = aimf.a(paramBundle.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList, true);
            this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a = paramBundle;
            long l2 = System.currentTimeMillis();
            localObject1 = paramBundle;
            if (QLog.isColorLevel())
            {
              QLog.d("IphoneTitleBarActivity", 2, "constructHashStruct startTime=" + l1 + ", endTime=" + l2 + ", cost=" + String.valueOf(l2 - l1));
              localObject1 = paramBundle;
            }
          }
        }
        a((aimi)localObject1);
      }
      b(true);
      this.jdField_a_of_type_Akbn = ((akbn)this.app.getManager(34));
      this.jdField_a_of_type_Akbn.a(this);
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    }
    this.jdField_a_of_type_Akbn.b(this);
    if (this.jdField_a_of_type_Aimf != null) {
      this.jdField_a_of_type_Aimf.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2;
    Object localObject1;
    label102:
    int i;
    label137:
    PhoneContact localPhoneContact;
    switch (paramMessage.what)
    {
    case 5: 
    default: 
      return false;
    case 1: 
      localObject2 = (aimi)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a = ((aimi)localObject2);
      }
      if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.pinyinFirst)) {
          break label237;
        }
        localObject1 = "#";
        localObject1 = (List)((aimi)localObject2).jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          i = ((List)localObject1).size() - 1;
          if (i < 0) {
            break label517;
          }
          localPhoneContact = (PhoneContact)((List)localObject1).get(i);
          if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
            break label258;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        localPhoneContact = (PhoneContact)((List)localObject1).remove(i);
        ((List)localObject1).add(this.jdField_a_of_type_Int, localPhoneContact);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = null;
      a((aimi)localObject2);
      if (paramMessage.arg1 != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, true, 18);
      return false;
      label237:
      localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.pinyinFirst.charAt(0)).toUpperCase();
      break label102;
      label258:
      i -= 1;
      break label137;
      localObject1 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b());
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      label512:
      label515:
      for (;;)
      {
        label313:
        if (((Iterator)localObject2).hasNext())
        {
          localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
          i = 0;
          label337:
          if (i >= ((List)localObject1).size()) {
            break label512;
          }
          if (!TextUtils.equals(((PhoneContact)((List)localObject1).get(i)).unifiedCode, localPhoneContact.unifiedCode)) {}
        }
        for (;;)
        {
          if (i < 0) {
            break label515;
          }
          ((List)localObject1).remove(i);
          break label313;
          i += 1;
          break label337;
          localObject1 = aimf.a((List)localObject1, this.jdField_a_of_type_JavaUtilArrayList, false);
          localObject2 = this.jdField_a_of_type_AndroidOsHandler;
          if (((Boolean)paramMessage.obj).booleanValue()) {}
          for (i = 1;; i = 0)
          {
            Message.obtain((Handler)localObject2, 1, i, 0, localObject1).sendToTarget();
            return false;
            localObject1 = aimf.a((List)localObject1, this.jdField_a_of_type_JavaUtilArrayList, true);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.scrollTo(this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width, 0);
          return false;
          this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
          return false;
          if (this.jdField_a_of_type_Bbgu == null) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
          this.jdField_a_of_type_Bbgu.show();
          return false;
          i = -1;
        }
      }
      label517:
      i = -1;
    }
  }
  
  public void i_(int paramInt) {}
  
  public boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Int == 1) {
      axqy.b(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    label152:
    int i;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368429: 
      if (this.jdField_c_of_type_Int == 1) {
        axqy.b(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
      }
      finish();
      return;
    case 2131368457: 
      d();
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_b_of_type_Int != 0) {
          break label152;
        }
        axqy.b(this.app, "dc00898", "", "", "0X800796C", "0X800796C", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        c(true);
        return;
        axqy.b(this.app, "dc00898", "", "", "0X8007973", "0X8007973", 0, 0, "", "", "", "");
      }
    case 2131365763: 
      d();
      ContactSearchComponentActivity.a(this, null, 17, 524288, 561243);
      return;
    case 2131363587: 
      if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
      {
        if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          break label609;
        }
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        i = 0;
        while (paramView.hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)paramView.next();
          Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!TextUtils.equals(((PhoneContact)localIterator.next()).unifiedCode, localPhoneContact.unifiedCode));
          i += 1;
        }
      }
      break;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 0)
      {
        axqy.b(this.app, "dc00898", "", "", "0X800796D", "0X800796D", 0, 0, "", "", "", "");
        axqy.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), "", "", "");
        axqy.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 1, 0, String.valueOf(i), "", "", "");
        axqy.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 2, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size() - i), "", "", "");
      }
      for (;;)
      {
        e();
        return;
        axqy.b(this.app, "dc00898", "", "", "0X8007974", "0X8007974", 0, 0, "", "", "", "");
        axqy.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), "", "", "");
        axqy.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 1, 0, String.valueOf(i), "", "", "");
        axqy.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 2, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size() - i), "", "", "");
      }
      d();
      return;
      break;
      label609:
      i = 0;
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramViewStub = new aavh(this, 0.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    paramViewStub.setDuration(500L);
    paramViewStub.setInterpolator(new OvershootInterpolator());
    paramViewStub.setAnimationListener(new aavi(this));
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(paramViewStub);
    PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("has_contact_bind_act_show_new_guide_" + this.app.getCurrentAccountUin(), true).commit();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView.getTag() != null) {
      b((PhoneContact)paramView.getTag(), false);
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67)
    {
      if (paramKeyEvent.getAction() != 0) {
        break label29;
      }
      this.jdField_b_of_type_Boolean = TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText());
    }
    for (;;)
    {
      return false;
      label29:
      if ((paramKeyEvent.getAction() == 1) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_Aavj.a();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getWindowToken(), 0);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity
 * JD-Core Version:    0.7.0.1
 */