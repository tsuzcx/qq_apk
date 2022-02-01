package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.ViewTag;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.ResultRecord.DefaultComparator;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private InputDialog jdField_a_of_type_ComTencentBizWidgetsInputDialog;
  private ForwardSelectionFriendListAdapter.IForwardFriendListAdapterCallback jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter$IForwardFriendListAdapterCallback = new ForwardFriendListActivity.8(this);
  private ForwardSelectionFriendListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment;
  private ContactSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = new ForwardFriendListActivity.7(this);
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$ISelectedAndSearchBarCallback = new ForwardFriendListActivity.6(this);
  private SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar;
  private PinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
  private Map<String, ResultRecord> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView d;
  
  private String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    c();
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131367334));
    Object localObject = LayoutInflater.from(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131376483));
    h();
    if (this.jdField_c_of_type_Boolean)
    {
      g();
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131562770, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131363868).setVisibility(8);
      localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366333);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(12.0F, getResources())));
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView((View)localObject);
    }
    int i = this.jdField_a_of_type_Int;
    if ((i == 6) || (i == 7)) {
      b();
    }
  }
  
  private void a(int paramInt)
  {
    int i;
    if (paramInt == 11) {
      i = 21003;
    } else if (paramInt == 6) {
      i = 21002;
    } else if (paramInt == 16) {
      i = 21009;
    } else if (paramInt == 18) {
      i = 21010;
    } else {
      i = 21001;
    }
    ContactSearchComponentActivity.a(this, null, paramInt, 1, i);
  }
  
  private void a(View paramView)
  {
    Object localObject = (ForwardSelectionFriendListAdapter.ViewTag)paramView.getTag();
    if (localObject != null)
    {
      localObject = ((ForwardSelectionFriendListAdapter.ViewTag)localObject).a;
      if ((localObject != null) && ((localObject instanceof Friends)))
      {
        localObject = (Friends)localObject;
        int i = this.jdField_a_of_type_Int;
        boolean bool = false;
        if (((i == 1) || (i == 4) || (i == 3) || (i == 6) || (i == 7)) && (localObject != null))
        {
          if (this.jdField_b_of_type_Int == 2)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject).uin) != null)
            {
              QQToast.a(this, getString(2131699315), 0).b(getTitleBarHeight());
              return;
            }
            if (this.app.getCurrentUin().equals(((Friends)localObject).uin))
            {
              QQToast.a(this, getString(2131690737), 0).b(getTitleBarHeight());
              return;
            }
            paramView = new Intent(this, QQSpecialFriendSettingActivity.class);
            paramView.putExtra("key_friend_uin", ((Friends)localObject).uin);
            paramView.putExtra("key_is_from_friendsforward_activity", true);
            startActivity(paramView);
            return;
          }
          paramView = new Intent();
          paramView.putExtras(getIntent().getExtras());
          paramView.putExtra("extra_choose_friend_uin", ((Friends)localObject).uin);
          paramView.putExtra("extra_choose_friend_name", ((Friends)localObject).name);
          paramView.putExtra("extraChooseFriendRemark", ((Friends)localObject).remark);
          setResult(-1, paramView);
          finish();
          return;
        }
        paramView = (TextView)paramView.findViewById(2131378461);
        if (paramView != null)
        {
          if (paramView.getText() != null) {
            paramView = paramView.getText().toString();
          } else {
            paramView = null;
          }
        }
        else {
          paramView = "Ta";
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("uin", ((Friends)localObject).uin);
        localBundle.putInt("uintype", 0);
        localBundle.putString("uinname", paramView);
        localBundle.putString("uinname", paramView);
        localBundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.b.intValue());
        if (getIntent() != null) {
          bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
        }
        if (bool)
        {
          paramView = getIntent().getStringExtra("choose_friend_confirmTitle");
          localObject = getIntent().getStringExtra("choose_friend_confirmContent");
          localBundle.putBoolean("choose_friend_needConfirm", bool);
          localBundle.putString("choose_friend_confirmTitle", paramView);
          localBundle.putString("choose_friend_confirmContent", (String)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    f();
    paramString = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(paramString, true);
  }
  
  private void a(List<ResultRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ResultRecord)paramList.next());
      }
    }
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    String str = a(paramResultRecord.uin, paramResultRecord.getUinType());
    ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(paramResultRecord, false);
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 9)
    {
      j();
      return false;
    }
    ResultRecord.copyResultRecord(paramResultRecord).lastChooseTime = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_JavaUtilMap.put(str, ResultRecord.copyResultRecord(paramResultRecord));
    f();
    paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(paramResultRecord, true);
    return true;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(a(paramString, paramInt));
  }
  
  private void b()
  {
    if (this.app != null)
    {
      Object localObject = this.app.getAccount();
      String str = this.app.getCurrentNickname();
      View localView = LayoutInflater.from(getActivity()).inflate(2131562730, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131368343);
      TextView localTextView = (TextView)localView.findViewById(2131378461);
      if (localImageView != null) {
        localImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.app, 3, (String)localObject));
      }
      if (localTextView != null) {
        localTextView.setText(str);
      }
      localView.setOnClickListener(new ForwardFriendListActivity.1(this));
      localObject = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
      if (localObject != null) {
        ((PinnedHeaderExpandableListView)localObject).addHeaderView(localView);
      }
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ForwardFriendListActivity.4(this, paramView));
  }
  
  @TargetApi(14)
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376809));
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mNeedStatusTrans))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376752));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704858));
    if (getIntent() != null)
    {
      String str = getIntent().getStringExtra("isForConfessDirectFriendsTitle");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (getIntent().getIntExtra("forward_type", 2147483647) == 23)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704860));
        this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.b(120.0F, getResources()));
      }
      else if (this.jdField_a_of_type_Int == 4)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704850));
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690706);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369204));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d = ((TextView)findViewById(2131369233));
    int i = this.jdField_a_of_type_Int;
    if (i == 6)
    {
      this.d.setVisibility(0);
      this.d.setText(HardCodeUtil.a(2131704857));
      this.d.setContentDescription(HardCodeUtil.a(2131704859));
      this.d.setOnClickListener(this);
    }
    else if ((i != 4) && (i != 5))
    {
      this.d.setVisibility(0);
      this.d.setText(2131690728);
      this.d.setContentDescription(HardCodeUtil.a(2131704856));
      this.d.setOnClickListener(this);
    }
    this.d.setMaxWidth(AIOUtils.b(260.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369216));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
    if (AppSetting.d) {
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131704847));
    }
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ForwardFriendListActivity.5(this, paramView));
  }
  
  private void d()
  {
    a();
    if (this.jdField_c_of_type_Boolean) {
      a(getIntent().getParcelableArrayListExtra("selected_target_list"));
    }
  }
  
  private void d(View paramView)
  {
    paramView = ((ForwardRecentItemView)paramView).a;
    if (a(paramView.uin, paramView.getUinType())) {
      a(paramView.uin, paramView.getUinType());
    } else {
      a(paramView);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter.notifyDataSetChanged();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsInputDialog == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsInputDialog = InputDialog.a(this, HardCodeUtil.a(2131704848), "", 2131690728, 2131694583, new ForwardFriendListActivity.2(this), new ForwardFriendListActivity.3(this));
    }
    if (!this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.show();
      b(this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.getEditText());
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      this.d.setText(HardCodeUtil.a(2131704861));
      this.d.setClickable(false);
      this.d.setTextColor(855836698);
    }
    else
    {
      this.d.setText(String.format(HardCodeUtil.a(2131704854), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      this.d.setClickable(true);
      this.d.setTextColor(getResources().getColor(2131167063));
    }
    if (AppSetting.d)
    {
      TextView localTextView = this.d;
      localTextView.setContentDescription(localTextView.getText());
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(null, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$ISelectedAndSearchBarCallback);
    Object localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(29.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(10.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(75.0F, getResources());
    }
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setPadding(AIOUtils.b(7.0F, getResources()), 0, AIOUtils.b(7.0F, getResources()), 0);
    this.d.setBackgroundResource(2130845212);
    this.d.setTextSize(1, 14.0F);
    this.d.setVisibility(0);
    this.d.setOnClickListener(this);
    f();
    if (AppSetting.d)
    {
      localObject = this.d;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar = ((SelectedAndSearchBar)super.findViewById(2131377172));
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.setVisibility(8);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.b();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, getString(2131698940), 0, 2131694674, null, new ForwardFriendListActivity.9(this));
    }
    if (!isFinishing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardFriendListActivity", 2, "forwardOption is null, return.");
      }
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardFriendListActivity", 2, "forward2MultiTargets map is empty !");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort(localArrayList, new ResultRecord.DefaultComparator());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), localBundle);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.g();
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c()) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d();
    ArrayList localArrayList = new ArrayList();
    Groups localGroups = new Groups();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      ForwardSelectionFriendListAdapter.a(1003);
      localGroups.group_id = ForwardSelectionFriendListAdapter.a();
    }
    else
    {
      ForwardSelectionFriendListAdapter.a(0);
      localGroups.group_id = ForwardSelectionFriendListAdapter.a();
    }
    localGroups.group_name = HardCodeUtil.a(2131704853);
    localArrayList.add(0, localGroups);
    localArrayList.addAll((Collection)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter = new ForwardSelectionFriendListAdapter(this, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, this.app, localArrayList, this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter$IForwardFriendListAdapterCallback, this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.expandGroup(0);
      return true;
    }
    ((ForwardSelectionFriendListAdapter)localObject).a(localArrayList, true);
    return true;
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      Object localObject;
      if (paramInt1 != 21002)
      {
        if (paramInt1 != 21003)
        {
          if (paramInt1 != 21009)
          {
            if (paramInt1 != 21010) {
              return;
            }
            if (paramIntent != null)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtras(getIntent().getExtras());
              ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
              ((Intent)localObject).putExtra("extraChooseFriendRemark", paramIntent.getStringExtra("contactSearchResultName"));
              ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultNick"));
              setResult(-1, (Intent)localObject);
              finish();
            }
          }
          else if (paramIntent != null)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtras(getIntent().getExtras());
            ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
            ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultName"));
            setResult(-1, (Intent)localObject);
            finish();
          }
        }
        else if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("contactSearchResultUin");
          localObject = new Intent(this, QQSpecialFriendSettingActivity.class);
          ((Intent)localObject).putExtra("key_friend_uin", paramIntent);
          ((Intent)localObject).putExtra("key_is_from_friendsforward_activity", true);
          startActivity((Intent)localObject);
        }
      }
      else
      {
        localObject = getIntent();
        boolean bool = false;
        if (localObject != null) {
          bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
        }
        if (bool)
        {
          localObject = getIntent().getStringExtra("choose_friend_confirmTitle");
          String str = getIntent().getStringExtra("choose_friend_confirmContent");
          paramIntent.putExtra("choose_friend_needConfirm", bool);
          paramIntent.putExtra("choose_friend_confirmTitle", (String)localObject);
          paramIntent.putExtra("choose_friend_confirmContent", str);
        }
        SearchUtil.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755317);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("extra_add_special_friend", 0);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("extra_choose_friend", 0);
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    super.setContentView(2131559124);
    this.jdField_c_of_type_Boolean = (getIntent().getBooleanExtra("only_single_selection", true) ^ true);
    a();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
    if (localObject != null)
    {
      ((ForwardSelectionFriendListAdapter)localObject).c();
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter((PinnedHeaderExpandableListView.ExpandableListAdapter)null);
    }
    localObject = this.jdField_a_of_type_ComTencentBizWidgetsInputDialog;
    if (localObject != null) {
      ((InputDialog)localObject).dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.jdField_b_of_type_Int != 2) && (this.jdField_a_of_type_Int != 4))
    {
      overridePendingTransition(0, 2130771992);
      return;
    }
    overridePendingTransition(2130771991, 2130771992);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8)
    {
      i();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a()) {
      i();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131366333)
    {
      if (i != 2131369202)
      {
        if (i == 2131369233) {
          if (this.jdField_a_of_type_Int == 6)
          {
            e();
          }
          else if (this.jdField_c_of_type_Boolean)
          {
            k();
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(false);
              com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags.a = false;
            }
            setResult(1);
            finish();
          }
        }
      }
      else
      {
        if (this.jdField_c_of_type_Boolean)
        {
          Intent localIntent = new Intent();
          localIntent.putParcelableArrayListExtra("selected_target_list", new ArrayList(this.jdField_a_of_type_JavaUtilMap.values()));
          setResult(0, localIntent);
        }
        finish();
      }
    }
    else
    {
      i = this.jdField_a_of_type_Int;
      if (i == 1) {
        a(11);
      } else if ((i != 3) && (i != 6) && (i != 7))
      {
        if (i == 4) {
          a(18);
        } else {
          a(6);
        }
      }
      else {
        a(16);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity
 * JD-Core Version:    0.7.0.1
 */