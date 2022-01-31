package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.adapter.ContactBindedAdapter.ContactBindedData;
import com.tencent.mobileqq.adapter.ContactBindedAdapter.SelectedListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.StringAddition;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import scj;
import sck;
import scl;
import scm;
import scn;

public class ContactBindedActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, ViewStub.OnInflateListener, AdapterView.OnItemClickListener, ContactBindedAdapter.SelectedListener, NewFriendManager.INewFriendListener, ContactSearchResultPresenter.OnActionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
{
  public static final String[] a;
  public static final String[] b;
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private ContactBindedActivity.AddedAdapter jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter;
  private ContactBindedAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public PhoneContact a;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private CustomHorizontalScrollView jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList a;
  private scn jdField_a_of_type_Scn = new scn(null);
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  public Handler b;
  private View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean b;
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
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80077CF", "0X80077CF", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800796B", "0X800796B", 0, 0, "", "", "", "");
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
      paramQQAppInterface = new Intent(localBaseActivity, ContactBindedActivity.class);
      paramQQAppInterface.putExtra("from_type", 0);
      localBaseActivity.startActivityForResult(paramQQAppInterface, paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList paramArrayList)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007971", "0X8007971", 0, 0, "", "", "", "");
      paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
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
        QQToast.a(this, 1, 2131433273, 0).b(getTitleBarHeight());
        paramBoolean = false;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a(paramPhoneContact, paramBoolean);
        if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment.e(this.jdField_b_of_type_JavaUtilArrayList);
        }
        if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
          break;
        }
        paramPhoneContact = getString(2131433270);
        label91:
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
    label144:
    if (i < this.jdField_b_of_type_JavaUtilArrayList.size()) {
      if (!TextUtils.equals(((PhoneContact)this.jdField_b_of_type_JavaUtilArrayList.get(i)).unifiedCode, paramPhoneContact.unifiedCode)) {}
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList.remove(i);
      break;
      i += 1;
      break label144;
      paramPhoneContact = getString(2131433271, new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
      break label91;
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
      localObject = getString(2131433270);
      label68:
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.removeHeaderView(this.g);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = ContactSearchFragment.a(19, 524288, null, null, this);
        localObject = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject).add(2131369890, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
      label139:
      if (paramBoolean)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.jdField_a_of_type_JavaUtilList.clear();
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
    for (int i = 2131432998;; i = 2131433272)
    {
      ((TextView)localObject).setText(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      a(true);
      return;
      bool1 = false;
      break;
      localObject = getString(2131433271, new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
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
      localObject = (PhoneContactManager)this.app.getManager(10);
      i = 3006;
      if (((PhoneContactManager)localObject).g()) {
        break label162;
      }
      i = 3075;
    }
    for (;;)
    {
      localObject = (PhoneContact)this.jdField_b_of_type_JavaUtilArrayList.get(0);
      startActivityForResult(AddFriendLogicActivity.a(this, 2, ((PhoneContact)localObject).unifiedCode, null, i, j, ((PhoneContact)localObject).name, null, null, "取消", null), 102);
      return;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 100) {
        break;
      }
      localObject = (PhoneContactManager)this.app.getManager(10);
      i = 3078;
      if (!((PhoneContactManager)localObject).g()) {
        i = 3079;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_b_of_type_JavaUtilArrayList, i, null, "取消", null, this.jdField_b_of_type_Int), 101);
      return;
      label162:
      j = 0;
    }
  }
  
  public void O_()
  {
    b(false);
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView)
  {
    paramView = (IContactSearchModel)paramView.getTag(2131362079);
    if (paramView == null) {}
    do
    {
      return;
      paramView = ((ContactSearchModelPhoneContact)paramView).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    } while (paramView == null);
    b(paramView, true);
  }
  
  public void a(ContactBindedAdapter.ContactBindedData paramContactBindedData)
  {
    if ((paramContactBindedData.jdField_a_of_type_JavaUtilList.size() > 0) || (this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if ((!PreferenceManager.getDefaultSharedPreferences(this).getBoolean("has_contact_bind_act_show_new_guide_" + this.app.getCurrentAccountUin(), false)) && (this.jdField_a_of_type_AndroidWidgetTextView == null) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 600L);
      }
      if ((paramContactBindedData.jdField_a_of_type_JavaUtilList.size() > 10) && (!this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8007972", "0X8007972", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = true;
      }
      if ((paramContactBindedData.jdField_a_of_type_JavaUtilList.size() <= 10) && (!this.jdField_c_of_type_Boolean)) {
        break label212;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a(paramContactBindedData);
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      label212:
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (paramPhoneContact != null) {
      b(paramPhoneContact, paramBoolean);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getWindowToken(), 0);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter.notifyDataSetChanged();
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
  
  public void b()
  {
    b(false);
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
          localObject1 = (FriendsManager)this.app.getManager(50);
          localObject4 = paramIntent.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FriendListHandler.AddBatchPhoneFriendResult)((Iterator)localObject4).next();
            if (((FriendListHandler.AddBatchPhoneFriendResult)localObject5).sendResult == 0)
            {
              ((FriendsManager)localObject1).a(((FriendListHandler.AddBatchPhoneFriendResult)localObject5).mobile, true);
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
            paramIntent = "部分好友添加失败";
            ((StringBuilder)localObject4).append("部分好友添加失败，请稍后再试。");
          }
          for (;;)
          {
            if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()) || (!((List)localObject3).isEmpty()))
            {
              this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, paramIntent, ((StringBuilder)localObject4).toString(), new scj(this), null);
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
              paramIntent = "好友已达上限";
              ((StringBuilder)localObject4).append("好友已达上限，部分好友未添加。");
            }
            else if (!((List)localObject3).isEmpty())
            {
              paramIntent = getString(2131433274);
              if (((List)localObject3).size() == 1)
              {
                localObject1 = (FriendListHandler.AddBatchPhoneFriendResult)((List)localObject3).get(0);
                localObject5 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  localObject6 = (PhoneContact)((Iterator)localObject5).next();
                  if (((FriendListHandler.AddBatchPhoneFriendResult)localObject1).mobile.equals(((PhoneContact)localObject6).unifiedCode)) {
                    if (!TextUtils.isEmpty(((PhoneContact)localObject6).name)) {
                      break label764;
                    }
                  }
                }
                label764:
                for (localObject1 = ((PhoneContact)localObject6).nickName;; localObject1 = ((PhoneContact)localObject6).name)
                {
                  ((StringBuilder)localObject4).append(StringAddition.a((String)localObject1, 12, true)).append("的好友验证方式需要回答问题, 请单独添加。");
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
              Collections.sort((List)localObject5, this.jdField_a_of_type_Scn);
              paramInt1 = 0;
              if (paramInt1 < 2)
              {
                localObject1 = (PhoneContact)((List)localObject5).get(paramInt1);
                if (TextUtils.isEmpty(((PhoneContact)localObject1).name)) {}
                for (localObject1 = ((PhoneContact)localObject1).nickName;; localObject1 = ((PhoneContact)localObject1).name)
                {
                  ((StringBuilder)localObject4).append(StringAddition.a((String)localObject1, 12, true));
                  if (paramInt1 == 0) {
                    ((StringBuilder)localObject4).append("、");
                  }
                  paramInt1 += 1;
                  break;
                }
              }
              ((StringBuilder)localObject4).append("等").append(((List)localObject3).size()).append("位联系人的好友验证方式需要回答问题, 请单独添加。");
              if (this.jdField_b_of_type_Int == 0) {
                ReportController.b(this.app, "dc00898", "", "", "0X8007970", "0X8007970", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
              } else {
                ReportController.b(this.app, "dc00898", "", "", "0X8007977", "0X8007977", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
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
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setSoftInputMode(48);
    setContentView(2130970275);
    paramBundle = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(10));
    Object localObject1;
    if (paramBundle != null)
    {
      localObject1 = (ArrayList)paramBundle.getSerializableExtra("isBindAction");
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b((String)localObject2);
          if (localObject2 != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
      }
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("from_type", 1);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mFlingHandler = new scm(this, this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131362822);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131369887));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363363));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131436809);
    setTitle(getString(2131436809));
    setLeftViewName(2131433681);
    this.leftView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131369886);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363746));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365442);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131364959));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365439));
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView, false);
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter = new ContactBindedActivity.AddedAdapter(this, this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter);
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.e = findViewById(2131369890);
    this.f = findViewById(2131369888);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369889));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.g = LayoutInflater.from(this).inflate(2130971469, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.g.findViewById(2131368254).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.g.findViewById(2131368255));
    this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.g);
    setRightButton(2131433272, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131365424));
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_b_of_type_ArrayOfJavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365253);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      if ((paramBundle != null) && (TextUtils.isEmpty(paramBundle.mobileNo)) && (paramBundle.noBindUploadContacts == true)) {
        ReportController.b(this.app, "dc00898", "", "", "0X80077CC", "0X80077CC", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g()) {
        ReportController.b(this.app, "dc00898", "", "", "0X80077D2", "0X80077D2", 0, 0, "", "", "", "");
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a;
      if ((paramBundle == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
        paramBundle = new ContactBindedAdapter.ContactBindedData();
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter = new ContactBindedAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, paramBundle.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter$SelectedListener = this;
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter);
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
            paramBundle = ContactBindedAdapter.a(paramBundle.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList, true);
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
        a((ContactBindedAdapter.ContactBindedData)localObject1);
      }
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.app.getManager(33));
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.a(this);
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.c();
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
    default: 
      return false;
    case 1: 
      localObject2 = (ContactBindedAdapter.ContactBindedData)paramMessage.obj;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a = ((ContactBindedAdapter.ContactBindedData)localObject2);
      }
      if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.pinyinFirst)) {
          break label235;
        }
        localObject1 = "#";
        localObject1 = (List)((ContactBindedAdapter.ContactBindedData)localObject2).jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          i = ((List)localObject1).size() - 1;
          if (i < 0) {
            break label546;
          }
          localPhoneContact = (PhoneContact)((List)localObject1).get(i);
          if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
            break label256;
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
      a((ContactBindedAdapter.ContactBindedData)localObject2);
      if (paramMessage.arg1 != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, true);
      return false;
      label235:
      localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.pinyinFirst.charAt(0)).toUpperCase();
      break label102;
      label256:
      i -= 1;
      break label137;
      localObject1 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b());
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      label541:
      label544:
      for (;;)
      {
        label311:
        if (((Iterator)localObject2).hasNext())
        {
          localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
          i = 0;
          label335:
          if (i >= ((List)localObject1).size()) {
            break label541;
          }
          if (!TextUtils.equals(((PhoneContact)((List)localObject1).get(i)).unifiedCode, localPhoneContact.unifiedCode)) {}
        }
        for (;;)
        {
          if (i < 0) {
            break label544;
          }
          ((List)localObject1).remove(i);
          break label311;
          i += 1;
          break label335;
          localObject1 = ContactBindedAdapter.a((List)localObject1, this.jdField_a_of_type_JavaUtilArrayList, false);
          localObject2 = this.jdField_a_of_type_AndroidOsHandler;
          if (((Boolean)paramMessage.obj).booleanValue()) {}
          for (i = 1;; i = 0)
          {
            Message.obtain((Handler)localObject2, 1, i, 0, localObject1).sendToTarget();
            return false;
            localObject1 = ContactBindedAdapter.a((List)localObject1, this.jdField_a_of_type_JavaUtilArrayList, true);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView.scrollTo(this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width, 0);
          return false;
          this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
          return false;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
          paramMessage = (ViewStub)findViewById(2131369891);
          paramMessage.setOnInflateListener(this);
          paramMessage.setVisibility(0);
          return false;
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          return false;
          i = -1;
        }
      }
      label546:
      i = -1;
    }
  }
  
  public void onClick(View paramView)
  {
    label115:
    int i;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363227: 
      finish();
      return;
    case 2131363410: 
      d();
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_b_of_type_Int != 0) {
          break label115;
        }
        ReportController.b(this.app, "dc00898", "", "", "0X800796C", "0X800796C", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        c(true);
        return;
        ReportController.b(this.app, "dc00898", "", "", "0X8007973", "0X8007973", 0, 0, "", "", "", "");
      }
    case 2131368255: 
      d();
      ContactSearchComponentActivity.a(this, null, 17, 524288, 561243);
      return;
    case 2131369889: 
      if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
      {
        if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          break label572;
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
        ReportController.b(this.app, "dc00898", "", "", "0X800796D", "0X800796D", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 1, 0, String.valueOf(i), "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 2, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size() - i), "", "", "");
      }
      for (;;)
      {
        e();
        return;
        ReportController.b(this.app, "dc00898", "", "", "0X8007974", "0X8007974", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 1, 0, String.valueOf(i), "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 2, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size() - i), "", "", "");
      }
      d();
      return;
      break;
      label572:
      i = 0;
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramViewStub = new sck(this, 0.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    paramViewStub.setDuration(500L);
    paramViewStub.setInterpolator(new OvershootInterpolator());
    paramViewStub.setAnimationListener(new scl(this));
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(paramViewStub);
    PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("has_contact_bind_act_show_new_guide_" + this.app.getCurrentAccountUin(), true).commit();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
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
        this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter.a();
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity
 * JD-Core Version:    0.7.0.1
 */