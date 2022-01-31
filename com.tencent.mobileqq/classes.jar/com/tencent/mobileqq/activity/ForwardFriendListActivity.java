package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter;
import com.tencent.mobileqq.adapter.ForwardSelectionFriendListAdapter.ViewTag;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import sko;
import skp;
import skq;
import skr;
import sks;

public class ForwardFriendListActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private InputDialog jdField_a_of_type_ComTencentBizWidgetsInputDialog;
  private ForwardSelectionFriendListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private PinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  private void a()
  {
    c();
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView = ((PinnedHeaderExpandableListView)findViewById(2131364633));
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setContentBackground(2130838210);
    View localView = LayoutInflater.from(getActivity()).inflate(2130971469, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
    localView.findViewById(2131368254).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131368255);
    localEditText.setFocusable(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView(localView);
    if ((this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 7)) {
      b();
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
    this.jdField_a_of_type_AndroidOsHandler.post(new skr(this, paramView));
  }
  
  private void b()
  {
    if (this.app != null)
    {
      String str1 = this.app.getAccount();
      String str2 = this.app.getCurrentNickname();
      View localView = LayoutInflater.from(getActivity()).inflate(2130971439, this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView, false);
      ImageView localImageView = (ImageView)localView.findViewById(2131362701);
      TextView localTextView = (TextView)localView.findViewById(2131363873);
      if (localImageView != null) {
        localImageView.setBackgroundDrawable(FaceDrawable.a(this.app, 3, str1));
      }
      if (localTextView != null) {
        localTextView.setText(str2);
      }
      localView.setOnClickListener(new sko(this));
      if (this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView != null) {
        this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.addHeaderView(localView);
      }
    }
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new sks(this, paramView));
  }
  
  @TargetApi(14)
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362822));
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mNeedStatusTrans))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362844));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363363));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("好友");
    this.c = ((TextView)findViewById(2131363227));
    if (this.jdField_b_of_type_Int == 2)
    {
      this.c.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363455));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_Int != 6) {
        break label329;
      }
      this.d = ((TextView)findViewById(2131363410));
      this.d.setVisibility(0);
      this.d.setText("自定义");
      this.d.setContentDescription("自定义");
      this.d.setOnClickListener(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363456));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
      IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_AndroidWidgetTextView);
      return;
      this.c.setVisibility(0);
      this.c.setOnClickListener(this);
      if (getIntent().getIntExtra("forward_type", 2147483647) == 23)
      {
        this.c.setText("推荐联系人");
        this.c.setMaxWidth(AIOUtils.a(120.0F, getResources()));
        break;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        this.c.setText("取消");
        this.c.setBackgroundResource(0);
        break;
      }
      this.c.setText(2131433681);
      break;
      label329:
      if ((this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 5))
      {
        this.d = ((TextView)findViewById(2131363410));
        this.d.setVisibility(0);
        this.d.setText(2131432998);
        this.d.setContentDescription("取消");
        this.d.setOnClickListener(this);
      }
    }
  }
  
  private void d()
  {
    a();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsInputDialog == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsInputDialog = InputDialog.a(this, "标记好友名字", "", 2131432998, 2131432999, new skp(this), new skq(this));
    }
    if (!this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.show();
      a(this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.getEditText());
    }
  }
  
  protected boolean a()
  {
    int m = 0;
    int k = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e()) {
      return false;
    }
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d();
    ArrayList localArrayList2 = new ArrayList();
    int i;
    int j;
    label78:
    label122:
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Int == 1)
    {
      i = 1;
      if (this.jdField_a_of_type_Int != 4) {
        break label234;
      }
      j = 1;
      if ((i | j) != 0)
      {
        localObject = new Groups();
        if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
          break label239;
        }
        ForwardSelectionFriendListAdapter.a(1003);
        ((Groups)localObject).group_id = ForwardSelectionFriendListAdapter.b();
        ((Groups)localObject).group_name = "最近联系人";
        localArrayList2.add(0, localObject);
        localArrayList2.addAll(localArrayList1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null) {
        break label266;
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView;
      localQQAppInterface = this.app;
      if (this.jdField_a_of_type_Int != 1) {
        break label254;
      }
      i = 1;
      label179:
      j = k;
      if (this.jdField_a_of_type_Int == 4) {
        j = 1;
      }
      if ((j | i) == 0) {
        break label259;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter = new ForwardSelectionFriendListAdapter(this, (ExpandableListView)localObject, localQQAppInterface, localArrayList2, this);
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter);
      return true;
      i = 0;
      break;
      label234:
      j = 0;
      break label78;
      label239:
      ForwardSelectionFriendListAdapter.a(0);
      ((Groups)localObject).group_id = ForwardSelectionFriendListAdapter.b();
      break label122;
      label254:
      i = 0;
      break label179;
      label259:
      localArrayList2 = localArrayList1;
    }
    label266:
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter;
    if (this.jdField_a_of_type_Int == 1)
    {
      i = 1;
      label282:
      j = m;
      if (this.jdField_a_of_type_Int == 4) {
        j = 1;
      }
      if ((i | j) == 0) {
        break label317;
      }
    }
    for (;;)
    {
      ((ForwardSelectionFriendListAdapter)localObject).a(localArrayList2, true);
      break;
      i = 0;
      break label282;
      label317:
      localArrayList2 = localArrayList1;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
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
          SearchUtils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
          return;
        } while (paramIntent == null);
        paramIntent = paramIntent.getStringExtra("contactSearchResultUin");
        localIntent = new Intent(this, QQSpecialFriendSettingActivity.class);
        localIntent.putExtra("key_friend_uin", paramIntent);
        localIntent.putExtra("key_is_from_friendsforward_activity", true);
        startActivity(localIntent);
        return;
      } while (paramIntent == null);
      localIntent = new Intent();
      localIntent.putExtras(getIntent().getExtras());
      localIntent.putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
      localIntent.putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultName"));
      setResult(-1, localIntent);
      finish();
      return;
    } while (paramIntent == null);
    Intent localIntent = new Intent();
    localIntent.putExtras(getIntent().getExtras());
    localIntent.putExtra("extra_choose_friend_uin", paramIntent.getStringExtra("contactSearchResultUin"));
    localIntent.putExtra("extraChooseFriendRemark", paramIntent.getStringExtra("contactSearchResultName"));
    localIntent.putExtra("extra_choose_friend_name", paramIntent.getStringExtra("contactSearchResultNick"));
    setResult(-1, localIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_b_of_type_Int = getIntent().getIntExtra("extra_add_special_friend", 0);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("extra_choose_friend", 0);
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawable(null);
    super.setContentView(2130968999);
    a();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardSelectionFriendListAdapter.b();
      this.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setAdapter((PinnedHeaderExpandableListView.ExpandableListAdapter)null);
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsInputDialog != null) {
      this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.dismiss();
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.jdField_b_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4)) {
      overridePendingTransition(2131034121, 2131034122);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      localObject = (ForwardSelectionFriendListAdapter.ViewTag)paramView.getTag();
      if (localObject != null)
      {
        localObject = ((ForwardSelectionFriendListAdapter.ViewTag)localObject).a;
        if ((localObject != null) && ((localObject instanceof Friends)))
        {
          localObject = (Friends)localObject;
          if (((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 6) && (this.jdField_a_of_type_Int != 7)) || (localObject == null)) {
            break label386;
          }
          if (this.jdField_b_of_type_Int != 2) {
            break label319;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject).uin) == null) {
            break;
          }
          QQToast.a(this, getString(2131436881), 0).b(getTitleBarHeight());
        }
      }
      return;
    case 2131368255: 
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
    case 2131363227: 
      finish();
      return;
    case 2131363410: 
      if (this.jdField_a_of_type_Int == 6)
      {
        e();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(false);
        com.tencent.mobileqq.app.PhoneContactManagerImp.g = false;
      }
      setResult(1);
      finish();
      return;
    }
    paramView = new Intent(this, QQSpecialFriendSettingActivity.class);
    paramView.putExtra("key_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("key_is_from_friendsforward_activity", true);
    startActivity(paramView);
    return;
    label319:
    paramView = new Intent();
    paramView.putExtras(getIntent().getExtras());
    paramView.putExtra("extra_choose_friend_uin", ((Friends)localObject).uin);
    paramView.putExtra("extra_choose_friend_name", ((Friends)localObject).name);
    paramView.putExtra("extraChooseFriendRemark", ((Friends)localObject).remark);
    setResult(-1, paramView);
    finish();
    return;
    label386:
    paramView = (TextView)paramView.findViewById(2131363873);
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
      localBundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.b.intValue());
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), localBundle);
      return;
      paramView = null;
      continue;
      paramView = "Ta";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity
 * JD-Core Version:    0.7.0.1
 */