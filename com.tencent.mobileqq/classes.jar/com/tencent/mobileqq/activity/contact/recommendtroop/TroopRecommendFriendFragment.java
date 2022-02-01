package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.ViewHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopRecommendFriendFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private CommonAdapter<RecommendMember> jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopRecommendFriendFragment.5(this);
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  private int c;
  
  private String a(String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager.b(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692700);
    }
    if (localFriendsManager.a(paramString, false)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699384);
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter = new TroopRecommendFriendFragment.2(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560052);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(2131561659);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(new TroopRecommendFriendFragment.3(this));
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivity.class, TroopRecommendFriendFragment.class);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376723);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131380020));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.addOnScrollListener(new TroopRecommendFriendFragment.1(this));
  }
  
  private void a(ViewHolder paramViewHolder, RecommendMember paramRecommendMember, int paramInt)
  {
    if ((paramViewHolder == null) || (paramRecommendMember == null)) {}
    Object localObject;
    do
    {
      return;
      ((MemberViewHolder)paramViewHolder).a = paramRecommendMember;
      localObject = (ImageView)paramViewHolder.a(2131361796);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramRecommendMember.jdField_a_of_type_JavaLangString));
      }
      localObject = (TextView)paramViewHolder.a(2131372288);
      if (localObject != null) {
        ((TextView)localObject).setText(paramRecommendMember.jdField_b_of_type_JavaLangString);
      }
      localObject = (TextView)paramViewHolder.a(2131371099);
      if (localObject != null) {
        ((TextView)localObject).setText(paramRecommendMember.c);
      }
      localObject = (TroopLabelLayout)paramViewHolder.a(2131379944);
      if (localObject != null) {
        ((TroopLabelLayout)localObject).a(paramRecommendMember.jdField_a_of_type_JavaUtilArrayList, paramRecommendMember.jdField_a_of_type_Int, paramRecommendMember.jdField_b_of_type_Int, 1);
      }
      localObject = (Button)paramViewHolder.a(2131376990);
      paramViewHolder = (TextView)paramViewHolder.a(2131377001);
    } while ((localObject == null) || (paramViewHolder == null));
    String str = a(paramRecommendMember.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(str))
    {
      paramViewHolder.setVisibility(8);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(2131689557);
      ((Button)localObject).setOnClickListener(new TroopRecommendFriendFragment.4(this, paramRecommendMember));
      return;
    }
    paramViewHolder.setVisibility(0);
    paramViewHolder.setText(str);
    ((Button)localObject).setVisibility(8);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "addFriend troopUin = " + paramString1 + ", memberUin =" + paramString2 + ", troopCode =" + paramString3);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    String str = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
    int i = this.jdField_b_of_type_Int;
    paramString2 = AddFriendLogicActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, paramString3, 3004, i, str, null, null, null, null);
    paramString2.putExtra("need_result_uin", true);
    paramString2.putExtra("troop_uin", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramString2, 11);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter);
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694459), 0).a();
      return;
    }
    c();
  }
  
  private void c()
  {
    TroopHandler localTroopHandler;
    String str;
    int i;
    byte[] arrayOfByte;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      localTroopHandler = this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
      str = this.jdField_a_of_type_JavaLangString;
      i = this.c;
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label55;
      }
    }
    label55:
    for (ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;; localArrayList = null)
    {
      localTroopHandler.a(str, 2, i, arrayOfByte, 50, localArrayList);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      c();
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    a(this.mContentView);
    a();
    b();
  }
  
  public int getContentLayoutId()
  {
    return 2131560024;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("troopUin");
    this.c = paramBundle.getIntExtra("grayType", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("grayTypeSubId", 0);
    paramBundle = paramBundle.getSerializableExtra("grayUinList");
    if ((paramBundle instanceof ArrayList)) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopRecommendFriendFragment", 2, "onCreate mSubId " + this.jdField_b_of_type_Int + " mTroopUin =" + this.jdField_a_of_type_JavaLangString + " mGrayTipType =" + this.c);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD50", "0X800AD50", 0, 0, "", "", "", "");
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131689577));
    return localView;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.notifyDataSetChanged();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */