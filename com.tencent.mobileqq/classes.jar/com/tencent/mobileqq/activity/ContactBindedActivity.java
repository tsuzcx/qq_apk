package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.ContactBindedAdapter;
import com.tencent.mobileqq.adapter.ContactBindedAdapter.SelectedListener;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactBindedData;
import com.tencent.mobileqq.phonecontact.util.ContactBindUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ContactBindedActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, ViewStub.OnInflateListener, AdapterView.OnItemClickListener, ContactBindedAdapter.SelectedListener, INewFriendListener, ContactSearchResultPresenter.OnActionListener, IndexView.OnIndexChangedListener, AbsListView.OnScrollListener
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
  private ContactBindedActivity.PinyinCharComparator jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$PinyinCharComparator = new ContactBindedActivity.PinyinCharComparator(null);
  private ContactBindedAdapter jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  public PhoneContact a;
  private INewFriendService jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService;
  IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment = null;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private CustomHorizontalScrollView jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  public ArrayList<PhoneContact> a;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  public Handler b;
  private View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList<PhoneContact> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean b;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
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
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("check_permission_result");
    } else {
      paramIntent = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, String.format("startFromOther [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
    }
    paramIntent = BaseActivity.sTopActivity;
    if (paramIntent != null)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80077CF", "0X80077CF", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800796B", "0X800796B", 0, 0, "", "", "", "");
      paramQQAppInterface = new Intent(paramIntent, ContactBindedActivity.class);
      paramQQAppInterface.putExtra("from_type", 0);
      paramQQAppInterface.putExtra("kSrouce", paramInt1);
      paramQQAppInterface.putExtra("fromKeyForContactBind", paramInt2);
      paramIntent.startActivityForResult(paramQQAppInterface, 222);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<PhoneContact> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startFromOther requestCode: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  starList:");
      ((StringBuilder)localObject).append(paramArrayList);
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007971", "0X8007971", 0, 0, "", "", "", "");
      paramQQAppInterface = new Intent((Context)localObject, ContactBindedActivity.class);
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
      ((Activity)localObject).startActivityForResult(paramQQAppInterface, paramInt);
    }
  }
  
  private void b(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() >= 100)
      {
        QQToast.a(this, 1, 2131691086, 0).b(getTitleBarHeight());
        paramBoolean = false;
      }
      else
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(paramPhoneContact);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
    else
    {
      int k = -1;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
          break;
        }
        if (TextUtils.equals(((PhoneContact)this.jdField_b_of_type_JavaUtilArrayList.get(i)).unifiedCode, paramPhoneContact.unifiedCode))
        {
          j = i;
          break;
        }
        i += 1;
      }
      this.jdField_b_of_type_JavaUtilArrayList.remove(j);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a(paramPhoneContact, paramBoolean);
    paramPhoneContact = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment;
    if (paramPhoneContact != null) {
      paramPhoneContact.e(this.jdField_b_of_type_JavaUtilArrayList);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      paramPhoneContact = getString(2131691084);
    } else {
      paramPhoneContact = getString(2131691085, new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(paramPhoneContact);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.jdField_b_of_type_JavaUtilArrayList.isEmpty() ^ true);
    a(true);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
    Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(2, Boolean.valueOf(paramBoolean)), 100L);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean ^= true;
    if (this.jdField_a_of_type_Boolean)
    {
      this.leftView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.f.setVisibility(0);
      if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
        localObject = getString(2131691084);
      } else {
        localObject = getString(2131691085, new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.removeHeaderView(this.g);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment = ContactSearchFragment.a(19, 524288, null, null, this);
        localObject = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject).add(2131377050, this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
    }
    else
    {
      this.leftView.setVisibility(0);
      this.e.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.g);
      this.f.setVisibility(8);
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getWindowToken(), 0);
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.jdField_a_of_type_JavaUtilList.clear();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment;
    if (localObject != null) {
      ((ContactSearchFragment)localObject).e(this.jdField_b_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.jdField_b_of_type_JavaUtilArrayList.isEmpty() ^ true);
    localObject = this.rightViewText;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131690728;
    } else {
      i = 2131691088;
    }
    ((TextView)localObject).setText(i);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    a(true);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    int i;
    Object localObject;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() == 1)
    {
      int j;
      if (!((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload())
      {
        i = 3075;
        j = 1;
      }
      else
      {
        i = 3006;
        j = 13;
      }
      localObject = (PhoneContact)this.jdField_b_of_type_JavaUtilArrayList.get(0);
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 2, ((PhoneContact)localObject).unifiedCode, null, i, j, ((PhoneContact)localObject).name, null, null, HardCodeUtil.a(2131702627), null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, (Intent)localObject, 102);
      return;
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 100)
    {
      if (!((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
        i = 3079;
      } else {
        i = 3078;
      }
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startMultiAddContact(this, this.jdField_b_of_type_JavaUtilArrayList, i, null, HardCodeUtil.a(2131702630), null, this.jdField_b_of_type_Int);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, (Intent)localObject, 101);
    }
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (paramPhoneContact != null) {
      b(paramPhoneContact, paramBoolean);
    }
  }
  
  public void a(ContactBindedData paramContactBindedData)
  {
    if ((paramContactBindedData.jdField_a_of_type_JavaUtilList.size() <= 0) && (!this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if ((paramContactBindedData.jdField_a_of_type_JavaUtilList.size() > 10) && (!this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8007972", "0X8007972", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = true;
    }
    if ((paramContactBindedData.jdField_a_of_type_JavaUtilList.size() <= 10) && (!this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a(paramContactBindedData);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.notifyDataSetChanged();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter.notifyDataSetChanged();
  }
  
  public void ac_()
  {
    b(false);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    Object localObject = this.e;
    int i;
    if (TextUtils.isEmpty(paramEditable)) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment;
    if (localObject != null) {
      ((ContactSearchFragment)localObject).a(paramEditable);
    }
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
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() < 5) {
        i = (int)((this.jdField_b_of_type_JavaUtilArrayList.size() * 40 + this.jdField_b_of_type_JavaUtilArrayList.size() * 10) * this.mDensity) + (int)(this.mDensity * 10.0F);
      } else {
        i = (int)(this.mDensity * 230.0F);
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      i = (int)(this.mDensity * 40.0F);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(i, 0, j, 0);
    this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
  }
  
  public void d()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
          Object localObject2 = new ArrayList();
          Object localObject3 = new ArrayList();
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          Object localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          Object localObject4 = paramIntent.iterator();
          Object localObject5;
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (AddBatchPhoneFriendResult)((Iterator)localObject4).next();
            if (((AddBatchPhoneFriendResult)localObject5).sendResult == 0)
            {
              ((FriendsManager)localObject1).a(((AddBatchPhoneFriendResult)localObject5).mobile, true);
              ((List)localObject2).add(localObject5);
            }
            else if (((AddBatchPhoneFriendResult)localObject5).sendResult == 37)
            {
              localArrayList1.add(localObject5);
            }
            else if ((((AddBatchPhoneFriendResult)localObject5).sendResult != 32) && (((AddBatchPhoneFriendResult)localObject5).sendResult != 33))
            {
              if (((AddBatchPhoneFriendResult)localObject5).allowType == 2) {
                ((List)localObject3).add(localObject5);
              }
            }
            else
            {
              localArrayList2.add(localObject5);
            }
          }
          if (QLog.isColorLevel())
          {
            paramInt1 = paramIntent.size();
            paramInt2 = ((List)localObject2).size();
            int i = ((List)localObject3).size();
            int j = localArrayList1.size();
            int k = localArrayList2.size();
            paramIntent = new StringBuilder();
            paramIntent.append("doOnActivityResult, adds=");
            paramIntent.append(((List)localObject2).size());
            paramIntent.append(", needAnswers=");
            paramIntent.append(((List)localObject3).size());
            paramIntent.append(", security anti=");
            paramIntent.append(localArrayList1.size());
            paramIntent.append(", upToLimits=");
            paramIntent.append(localArrayList2.size());
            paramIntent.append(", others=");
            paramIntent.append(paramInt1 - paramInt2 - i - j - k);
            QLog.d("IphoneTitleBarActivity", 2, paramIntent.toString());
          }
          localObject4 = new StringBuilder();
          if (!localArrayList1.isEmpty())
          {
            paramIntent = HardCodeUtil.a(2131702635);
            ((StringBuilder)localObject4).append("部分好友添加失败，请稍后再试。");
          }
          else if (!localArrayList2.isEmpty())
          {
            paramIntent = HardCodeUtil.a(2131702638);
            ((StringBuilder)localObject4).append("好友已达上限，部分好友未添加。");
          }
          else if (!((List)localObject3).isEmpty())
          {
            localObject1 = getString(2131691087);
            Object localObject6;
            if (((List)localObject3).size() == 1)
            {
              localObject5 = (AddBatchPhoneFriendResult)((List)localObject3).get(0);
              localObject6 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
              do
              {
                paramIntent = (Intent)localObject1;
                if (!((Iterator)localObject6).hasNext()) {
                  break;
                }
                paramIntent = (PhoneContact)((Iterator)localObject6).next();
              } while (!((AddBatchPhoneFriendResult)localObject5).mobile.equals(paramIntent.unifiedCode));
              if (TextUtils.isEmpty(paramIntent.name)) {
                paramIntent = paramIntent.nickName;
              } else {
                paramIntent = paramIntent.name;
              }
              ((StringBuilder)localObject4).append(StringAddition.a(paramIntent, 12, true));
              ((StringBuilder)localObject4).append("的好友验证方式需要回答问题, 请单独添加。");
              paramIntent = (Intent)localObject1;
            }
            else
            {
              localObject5 = new ArrayList(((List)localObject3).size());
              paramIntent = ((List)localObject3).iterator();
              while (paramIntent.hasNext())
              {
                localObject6 = (AddBatchPhoneFriendResult)paramIntent.next();
                Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                while (localIterator.hasNext())
                {
                  PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
                  if (((AddBatchPhoneFriendResult)localObject6).mobile.equals(localPhoneContact.unifiedCode)) {
                    ((List)localObject5).add(localPhoneContact);
                  }
                }
              }
              Collections.sort((List)localObject5, this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$PinyinCharComparator);
              paramInt1 = 0;
              while (paramInt1 < 2)
              {
                paramIntent = (PhoneContact)((List)localObject5).get(paramInt1);
                if (TextUtils.isEmpty(paramIntent.name)) {
                  paramIntent = paramIntent.nickName;
                } else {
                  paramIntent = paramIntent.name;
                }
                ((StringBuilder)localObject4).append(StringAddition.a(paramIntent, 12, true));
                if (paramInt1 == 0) {
                  ((StringBuilder)localObject4).append("、");
                }
                paramInt1 += 1;
              }
              ((StringBuilder)localObject4).append("等");
              ((StringBuilder)localObject4).append(((List)localObject3).size());
              ((StringBuilder)localObject4).append("位联系人的好友验证方式需要回答问题, 请单独添加。");
              if (this.jdField_b_of_type_Int == 0)
              {
                ReportController.b(this.app, "dc00898", "", "", "0X8007970", "0X8007970", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
                paramIntent = (Intent)localObject1;
              }
              else
              {
                ReportController.b(this.app, "dc00898", "", "", "0X8007977", "0X8007977", 0, 0, String.valueOf(((List)localObject3).size()), "", "", "");
                paramIntent = (Intent)localObject1;
              }
            }
          }
          else
          {
            paramIntent = "";
          }
          if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()) || (!((List)localObject3).isEmpty()))
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, paramIntent, ((StringBuilder)localObject4).toString(), new ContactBindedActivity.1(this), null);
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
            localObject1 = (AddBatchPhoneFriendResult)paramIntent.next();
            localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (PhoneContact)((Iterator)localObject2).next();
              if (((AddBatchPhoneFriendResult)localObject1).mobile.equals(((PhoneContact)localObject3).unifiedCode)) {
                this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
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
      paramIntent = this.jdField_a_of_type_AndroidOsHandler;
      paramIntent.sendMessageDelayed(paramIntent.obtainMessage(4), 120L);
      return;
    }
    if ((paramInt1 == 102) && (paramInt2 == -1))
    {
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
      paramIntent = this.jdField_a_of_type_AndroidOsHandler;
      paramIntent.sendMessageDelayed(paramIntent.obtainMessage(4), 120L);
    }
  }
  
  @TargetApi(9)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setSoftInputMode(48);
    setContentView(2131561024);
    paramBundle = getIntent();
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, ""));
    Object localObject2;
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
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.queryPhoneContactByMobile((String)localObject2);
        if (localObject2 != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          continue;
          this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.generateRandomList();
        }
      }
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("from_type", 1);
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("from_page", -1);
      if (paramBundle.getIntExtra("fromKeyForContactBind", 0) == 1) {
        QQToast.a(BaseApplication.getContext(), 2, 2131694764, 0);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mFlingHandler = new ContactBindedActivity.CustomFlingHandler(this, this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376809);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131378198));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694737);
    setTitle(getString(2131694737));
    setLeftViewName(2131690706);
    this.leftView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131377057);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomHorizontalScrollView = ((CustomHorizontalScrollView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377006));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131377017);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131377068));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377178));
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter);
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.e = findViewById(2131377050);
    this.f = findViewById(2131366925);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363978));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.g = LayoutInflater.from(this).inflate(2131562770, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.g.findViewById(2131363868).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.g.findViewById(2131366333));
    this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.g);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368760));
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_b_of_type_ArrayOfJavaLangString);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(jdField_a_of_type_ArrayOfJavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366219);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindInfo();
    if ((paramBundle != null) && (TextUtils.isEmpty(paramBundle.mobileNo)) && (paramBundle.noBindUploadContacts == true)) {
      ReportController.b(this.app, "dc00898", "", "", "0X80077CC", "0X80077CC", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.isBindedIgnoreUpload()) {
      ReportController.b(this.app, "dc00898", "", "", "0X80077D2", "0X80077D2", 0, 0, "", "", "", "");
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getContactBoundDataCache();
    if ((paramBundle == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      paramBundle = new ContactBindedData();
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter = new ContactBindedAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, paramBundle.jdField_a_of_type_JavaUtilList);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter;
    ((ContactBindedAdapter)localObject1).jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter$SelectedListener = this;
    ((ContactBindedAdapter)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetIndexView = this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter((ListAdapter)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this);
    if (!paramBundle.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      localObject1 = paramBundle;
      if (localObject2 != null)
      {
        localObject1 = paramBundle;
        if (!((ArrayList)localObject2).isEmpty())
        {
          long l1 = System.currentTimeMillis();
          paramBundle = ContactBindUtils.a(paramBundle.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList, true);
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.setContactBoundDataCache(paramBundle);
          long l2 = System.currentTimeMillis();
          localObject1 = paramBundle;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("constructHashStruct startTime=");
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append(", endTime=");
            ((StringBuilder)localObject1).append(l2);
            ((StringBuilder)localObject1).append(", cost=");
            ((StringBuilder)localObject1).append(String.valueOf(l2 - l1));
            QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject1).toString());
            localObject1 = paramBundle;
          }
        }
      }
      a((ContactBindedData)localObject1);
    }
    b(true);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService = ((INewFriendService)this.app.getRuntimeService(INewFriendService.class));
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService.addListener(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    }
    localObject = this.jdField_b_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService.removeListener(this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter;
    if (localObject != null) {
      ((ContactBindedAdapter)localObject).c();
    }
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.clearRecommendBadge();
  }
  
  public void g_(int paramInt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onAction(View paramView)
  {
    paramView = (IContactSearchModel)paramView.getTag(2131380884);
    if (paramView == null) {
      return;
    }
    paramView = ((ContactSearchModelPhoneContact)paramView).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    if (paramView != null) {
      b(paramView, true);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Int == 1) {
      ReportController.b(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131379926: 
      d();
      break;
    case 2131369233: 
      d();
      if (!this.jdField_a_of_type_Boolean) {
        if (this.jdField_b_of_type_Int == 0) {
          ReportController.b(this.app, "dc00898", "", "", "0X800796C", "0X800796C", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.app, "dc00898", "", "", "0X8007973", "0X8007973", 0, 0, "", "", "", "");
        }
      }
      c(true);
      break;
    case 2131369202: 
      if (this.jdField_c_of_type_Int == 1) {
        ReportController.b(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
      }
      finish();
      break;
    case 2131366333: 
      d();
      ContactSearchComponentActivity.a(this, null, 17, 524288, 21001);
      break;
    case 2131363978: 
      if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())
      {
        int k = 0;
        int i = 0;
        int j = k;
        if (!this.jdField_c_of_type_Boolean)
        {
          Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
          j = k;
          if (localObject != null)
          {
            j = k;
            if (!((ArrayList)localObject).isEmpty())
            {
              localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              for (;;)
              {
                j = i;
                if (!((Iterator)localObject).hasNext()) {
                  break label350;
                }
                PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject).next();
                Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                if (localIterator.hasNext())
                {
                  if (!TextUtils.equals(((PhoneContact)localIterator.next()).unifiedCode, localPhoneContact.unifiedCode)) {
                    break;
                  }
                  i += 1;
                }
              }
            }
          }
        }
        label350:
        if (this.jdField_b_of_type_Int == 0)
        {
          ReportController.b(this.app, "dc00898", "", "", "0X800796D", "0X800796D", 0, 0, "", "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 1, 0, String.valueOf(j), "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 2, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size() - j), "", "", "");
        }
        else
        {
          ReportController.b(this.app, "dc00898", "", "", "0X8007974", "0X8007974", 0, 0, "", "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 0, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 1, 0, String.valueOf(j), "", "", "");
          ReportController.b(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 2, 0, String.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size() - j), "", "", "");
        }
      }
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAdapterContactBindedAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramViewStub = new ContactBindedActivity.2(this, 0.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    paramViewStub.setDuration(500L);
    paramViewStub.setInterpolator(new OvershootInterpolator());
    paramViewStub.setAnimationListener(new ContactBindedActivity.3(this));
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(paramViewStub);
    paramViewStub = PreferenceManager.getDefaultSharedPreferences(this).edit();
    paramView = new StringBuilder();
    paramView.append("has_contact_bind_act_show_new_guide_");
    paramView.append(this.app.getCurrentAccountUin());
    paramViewStub.putBoolean(paramView.toString(), true).commit();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView.getTag() != null) {
      b((PhoneContact)paramView.getTag(), false);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67) {
      if (paramKeyEvent.getAction() == 0) {
        this.jdField_b_of_type_Boolean = TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText());
      } else if ((paramKeyEvent.getAction() == 1) && (this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity$AddedAdapter.a();
      }
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ContactBindedActivity
 * JD-Core Version:    0.7.0.1
 */