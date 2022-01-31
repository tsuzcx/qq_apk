package com.tencent.mobileqq.activity;

import aasb;
import aasc;
import aasd;
import aase;
import aasf;
import aasg;
import aash;
import abqm;
import aciy;
import ahri;
import aiaj;
import aiam;
import aian;
import ajjj;
import ajjy;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aphf;
import aphp;
import avrb;
import avwf;
import azwg;
import azwp;
import babr;
import bagn;
import bbmy;
import bemg;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xem;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private abqm jdField_a_of_type_Abqm = new aase(this);
  private aiaj jdField_a_of_type_Aiaj;
  private aiam jdField_a_of_type_Aiam = new aasg(this);
  private ajjj jdField_a_of_type_Ajjj;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avrb jdField_a_of_type_Avrb = new aasf(this);
  private azwg jdField_a_of_type_Azwg;
  private SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  private PinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
  private Map<String, ResultRecord> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private xem jdField_a_of_type_Xem;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView d;
  
  private String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  private void a()
  {
    c();
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131301184));
    Object localObject = LayoutInflater.from(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131309439));
    h();
    if (this.jdField_c_of_type_Boolean) {
      g();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 7)) {
        b();
      }
      return;
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131496760, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297934).setVisibility(8);
      localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131300167);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, aciy.a(12.0F, getResources())));
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView((View)localObject);
    }
  }
  
  private void a(int paramInt)
  {
    int i = 561243;
    if (paramInt == 11) {
      i = 561245;
    }
    for (;;)
    {
      ContactSearchComponentActivity.a(this, null, paramInt, 1, i);
      return;
      if (paramInt == 6) {
        i = 561244;
      } else if (paramInt == 16) {
        i = 561251;
      } else if (paramInt == 18) {
        i = 561252;
      }
    }
  }
  
  private void a(View paramView)
  {
    Object localObject = (aian)paramView.getTag();
    if (localObject != null)
    {
      localObject = ((aian)localObject).a;
      if ((localObject != null) && ((localObject instanceof Friends)))
      {
        localObject = (Friends)localObject;
        if (((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 6) && (this.jdField_a_of_type_Int != 7)) || (localObject == null)) {
          break label264;
        }
        if (this.jdField_b_of_type_Int != 2) {
          break label197;
        }
        if (this.jdField_a_of_type_Ajjj.a(((Friends)localObject).uin) == null) {
          break label121;
        }
        bbmy.a(this, getString(2131633716), 0).b(getTitleBarHeight());
      }
    }
    return;
    label121:
    if (this.app.c().equals(((Friends)localObject).uin))
    {
      bbmy.a(this, getString(2131625045), 0).b(getTitleBarHeight());
      return;
    }
    paramView = new Intent(this, QQSpecialFriendSettingActivity.class);
    paramView.putExtra("key_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("key_is_from_friendsforward_activity", true);
    startActivity(paramView);
    return;
    label197:
    paramView = new Intent();
    paramView.putExtras(getIntent().getExtras());
    paramView.putExtra("extra_choose_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("extra_choose_friend_name", ((Friends)localObject).name);
    paramView.putExtra("extraChooseFriendRemark", ((Friends)localObject).remark);
    setResult(-1, paramView);
    finish();
    return;
    label264:
    paramView = (TextView)paramView.findViewById(2131311221);
    if (paramView != null) {
      if (paramView.getText() != null) {
        paramView = paramView.getText().toString();
      }
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", ((Friends)localObject).uin);
      localBundle.putInt("uintype", 0);
      localBundle.putString("uinname", paramView);
      localBundle.putString("uinname", paramView);
      localBundle.putInt("chooseFriendFrom", bagn.b.intValue());
      if (getIntent() != null) {}
      for (boolean bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);; bool = false)
      {
        if (bool)
        {
          paramView = getIntent().getStringExtra("choose_friend_confirmTitle");
          localObject = getIntent().getStringExtra("choose_friend_confirmContent");
          localBundle.putBoolean("choose_friend_needConfirm", bool);
          localBundle.putString("choose_friend_confirmTitle", paramView);
          localBundle.putString("choose_friend_confirmContent", (String)localObject);
        }
        this.jdField_a_of_type_Aphp.a(aphf.b.intValue(), localBundle);
        return;
        paramView = null;
        break;
      }
      paramView = "Ta";
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
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramString, true);
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
    String str = a(paramResultRecord.jdField_a_of_type_JavaLangString, paramResultRecord.a());
    ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, false);
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 9)
    {
      j();
      return false;
    }
    ResultRecord.a(paramResultRecord).jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_JavaUtilMap.put(str, ResultRecord.a(paramResultRecord));
    f();
    paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, true);
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
      String str1 = this.app.getAccount();
      String str2 = this.app.getCurrentNickname();
      View localView = LayoutInflater.from(getActivity()).inflate(2131496724, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131302061);
      TextView localTextView = (TextView)localView.findViewById(2131311221);
      if (localImageView != null) {
        localImageView.setBackgroundDrawable(azwp.a(this.app, 3, str1));
      }
      if (localTextView != null) {
        localTextView.setText(str2);
      }
      localView.setOnClickListener(new aasb(this));
      if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView != null) {
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView(localView);
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131309736));
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mNeedStatusTrans))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309690));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638970));
    if (getIntent() != null)
    {
      String str = getIntent().getStringExtra("isForConfessDirectFriendsTitle");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302806));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.d = ((TextView)findViewById(2131302832));
      if (this.jdField_a_of_type_Int != 6) {
        break label429;
      }
      this.d.setVisibility(0);
      this.d.setText(ajjy.a(2131638969));
      this.d.setContentDescription(ajjy.a(2131638971));
      this.d.setOnClickListener(this);
    }
    for (;;)
    {
      this.d.setMaxWidth(aciy.a(260.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302816));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
      IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131638959));
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (getIntent().getIntExtra("forward_type", 2147483647) == 23)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638972));
        this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(aciy.a(120.0F, getResources()));
        break;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638962));
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(0);
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131625011);
      break;
      label429:
      if ((this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 5))
      {
        this.d.setVisibility(0);
        this.d.setText(2131625035);
        this.d.setContentDescription(ajjy.a(2131638968));
        this.d.setOnClickListener(this);
      }
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
    if (a(paramView.jdField_a_of_type_JavaLangString, paramView.a())) {
      a(paramView.jdField_a_of_type_JavaLangString, paramView.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_Aiaj.notifyDataSetChanged();
      return;
      a(paramView);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xem == null) {
      this.jdField_a_of_type_Xem = xem.a(this, ajjy.a(2131638960), "", 2131625035, 2131629116, new aasc(this), new aasd(this));
    }
    if (!this.jdField_a_of_type_Xem.isShowing())
    {
      this.jdField_a_of_type_Xem.show();
      b(this.jdField_a_of_type_Xem.getEditText());
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      this.d.setText(ajjy.a(2131638973));
      this.d.setClickable(false);
      this.d.setTextColor(855836698);
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.d.setContentDescription(this.d.getText());
      }
      return;
      this.d.setText(String.format(ajjy.a(2131638966), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      this.d.setClickable(true);
      this.d.setTextColor(getResources().getColor(2131101267));
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_Azwg = new azwg(this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_Azwg, this.jdField_a_of_type_Abqm);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams.height = aciy.a(29.0F, getResources());
    localLayoutParams.rightMargin = aciy.a(10.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      localLayoutParams.width = aciy.a(75.0F, getResources());
    }
    this.d.setLayoutParams(localLayoutParams);
    this.d.setPadding(aciy.a(7.0F, getResources()), 0, aciy.a(7.0F, getResources()), 0);
    this.d.setBackgroundResource(2130844284);
    this.d.setTextSize(1, 14.0F);
    this.d.setVisibility(0);
    this.d.setOnClickListener(this);
    f();
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.d.setContentDescription(this.d.getText());
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)super.findViewById(2131310050));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.setVisibility(8);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.b();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = babr.a(this, getString(2131633271), 0, 2131629260, null, new aash(this));
    }
    if (!isFinishing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Aphp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardFriendListActivity", 2, "forwardOption is null, return.");
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ForwardFriendListActivity", 2, "forward2MultiTargets map is empty !");
    return;
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort(localArrayList, new ahri());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.jdField_a_of_type_Aphp.a(aphf.a.intValue(), localBundle);
    this.jdField_a_of_type_Aphp.f();
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Ajjj == null) {
      this.jdField_a_of_type_Ajjj = ((ajjj)this.app.getManager(51));
    }
    if (!this.jdField_a_of_type_Ajjj.c()) {
      return false;
    }
    ArrayList localArrayList1 = this.jdField_a_of_type_Ajjj.e();
    ArrayList localArrayList2 = new ArrayList();
    Groups localGroups = new Groups();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      aiaj.a(1003);
      localGroups.group_id = aiaj.b();
      localGroups.group_name = ajjy.a(2131638965);
      localArrayList2.add(0, localGroups);
      localArrayList2.addAll(localArrayList1);
      if (this.jdField_a_of_type_Aiaj != null) {
        break label183;
      }
      this.jdField_a_of_type_Aiaj = new aiaj(this, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, this.app, localArrayList2, this.jdField_a_of_type_Aiam, this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Aiaj);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.a(0);
    }
    for (;;)
    {
      return true;
      aiaj.a(0);
      localGroups.group_id = aiaj.b();
      break;
      label183:
      this.jdField_a_of_type_Aiaj.a(localArrayList2, true);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (getIntent() != null) {
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
          avwf.a(paramIntent, this.jdField_a_of_type_Aphp);
          return;
        } while (paramIntent == null);
        paramIntent = paramIntent.getStringExtra("contactSearchResultUin");
        localObject = new Intent(this, QQSpecialFriendSettingActivity.class);
        ((Intent)localObject).putExtra("key_friend_uin", paramIntent);
        ((Intent)localObject).putExtra("key_is_from_friendsforward_activity", true);
        startActivity((Intent)localObject);
        return;
      } while (paramIntent == null);
      localObject = new Intent();
      ((Intent)localObject).putExtras(getIntent().getExtras());
      ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
      ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultName"));
      setResult(-1, (Intent)localObject);
      finish();
      return;
    } while (paramIntent == null);
    Object localObject = new Intent();
    ((Intent)localObject).putExtras(getIntent().getExtras());
    ((Intent)localObject).putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
    ((Intent)localObject).putExtra("extraChooseFriendRemark", paramIntent.getStringExtra("contactSearchResultName"));
    ((Intent)localObject).putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultNick"));
    setResult(-1, (Intent)localObject);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    setTheme(2131689611);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("extra_add_special_friend", 0);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("extra_choose_friend", 0);
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    super.setContentView(2131493499);
    if (!getIntent().getBooleanExtra("only_single_selection", true)) {
      bool = true;
    }
    this.jdField_c_of_type_Boolean = bool;
    a();
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aiaj != null)
    {
      this.jdField_a_of_type_Aiaj.b();
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter((bemg)null);
    }
    if (this.jdField_a_of_type_Xem != null) {
      this.jdField_a_of_type_Xem.dismiss();
    }
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.jdField_b_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4))
    {
      overridePendingTransition(2130771977, 2130771978);
      return;
    }
    overridePendingTransition(0, 2130771978);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8)
    {
      i();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()) {
      i();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300167: 
      if (this.jdField_a_of_type_Int == 1)
      {
        a(11);
        return;
      }
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 7))
      {
        a(16);
        return;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        a(18);
        return;
      }
      a(6);
      return;
    case 2131302804: 
      if (this.jdField_c_of_type_Boolean)
      {
        paramView = new Intent();
        paramView.putParcelableArrayListExtra("selected_target_list", new ArrayList(this.jdField_a_of_type_JavaUtilMap.values()));
        setResult(0, paramView);
      }
      finish();
      return;
    }
    if (this.jdField_a_of_type_Int == 6)
    {
      e();
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      k();
      return;
    }
    if (this.jdField_a_of_type_Aphp != null)
    {
      this.jdField_a_of_type_Aphp.a(false);
      com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
    }
    setResult(1);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity
 * JD-Core Version:    0.7.0.1
 */