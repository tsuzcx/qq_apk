package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.api.TroopRecommendObserver;
import com.tencent.mobileqq.troop.recommend.data.RecommendMember;
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
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CommonAdapter<RecommendMember> jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter;
  private ITroopRecommendHandler jdField_a_of_type_ComTencentMobileqqTroopRecommendApiITroopRecommendHandler;
  private final TroopRecommendObserver jdField_a_of_type_ComTencentMobileqqTroopRecommendApiTroopRecommendObserver = new TroopRecommendFriendFragment.5(this);
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
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692657);
    }
    if (localFriendsManager.a(paramString, false)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699489);
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter = new TroopRecommendFriendFragment.2(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131559922);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(2131561510);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(new TroopRecommendFriendFragment.3(this));
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivity.class, TroopRecommendFriendFragment.class);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376221);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131379349));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity(), 1, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.addOnScrollListener(new TroopRecommendFriendFragment.1(this));
  }
  
  private void a(ViewHolder paramViewHolder, RecommendMember paramRecommendMember, int paramInt)
  {
    if (paramViewHolder != null)
    {
      if (paramRecommendMember == null) {
        return;
      }
      ((MemberViewHolder)paramViewHolder).a = paramRecommendMember;
      Object localObject = (ImageView)paramViewHolder.a(2131361799);
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramRecommendMember.jdField_a_of_type_JavaLangString));
      }
      localObject = (TextView)paramViewHolder.a(2131371877);
      if (localObject != null) {
        ((TextView)localObject).setText(paramRecommendMember.jdField_b_of_type_JavaLangString);
      }
      localObject = (TextView)paramViewHolder.a(2131370723);
      if (localObject != null) {
        ((TextView)localObject).setText(paramRecommendMember.c);
      }
      localObject = (TroopLabelLayout)paramViewHolder.a(2131379273);
      if (localObject != null) {
        ((TroopLabelLayout)localObject).a(paramRecommendMember.jdField_a_of_type_JavaUtilArrayList, paramRecommendMember.jdField_a_of_type_Int, paramRecommendMember.jdField_b_of_type_Int, 1);
      }
      localObject = (Button)paramViewHolder.a(2131376477);
      paramViewHolder = (TextView)paramViewHolder.a(2131376485);
      if ((localObject != null) && (paramViewHolder != null))
      {
        String str = a(paramRecommendMember.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(str))
        {
          paramViewHolder.setVisibility(8);
          ((Button)localObject).setVisibility(0);
          ((Button)localObject).setText(2131689589);
          ((Button)localObject).setOnClickListener(new TroopRecommendFriendFragment.4(this, paramRecommendMember));
          return;
        }
        paramViewHolder.setVisibility(0);
        paramViewHolder.setText(str);
        ((Button)localObject).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addFriend troopUin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", memberUin =");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", troopCode =");
      ((StringBuilder)localObject).append(paramString3);
      QLog.i("TroopRecommendFriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      localObject = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      int i = this.jdField_b_of_type_Int;
      paramString2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, paramString3, 3004, i, (String)localObject, null, null, null, null);
      paramString2.putExtra("need_result_uin", true);
      paramString2.putExtra("troop_uin", paramString1);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString2, 11);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter);
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      QQToast.a(localBaseActivity, 1, localBaseActivity.getString(2131694424), 0).a();
      return;
    }
    c();
  }
  
  private void c()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null)
    {
      ITroopRecommendHandler localITroopRecommendHandler = this.jdField_a_of_type_ComTencentMobileqqTroopRecommendApiITroopRecommendHandler;
      int i = this.c;
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ArrayList localArrayList;
      if (arrayOfByte == null) {
        localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      } else {
        localArrayList = null;
      }
      localITroopRecommendHandler.a(str, 2, i, arrayOfByte, 50, localArrayList);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      c();
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRecommendApiTroopRecommendObserver);
    a(this.mContentView);
    a();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131559896;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqTroopRecommendApiITroopRecommendHandler = ((ITroopRecommendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("troopUin");
    this.c = paramBundle.getIntExtra("grayType", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("grayTypeSubId", 0);
    paramBundle = paramBundle.getSerializableExtra("grayUinList");
    if ((paramBundle instanceof ArrayList)) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramBundle);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate mSubId ");
      paramBundle.append(this.jdField_b_of_type_Int);
      paramBundle.append(" mTroopUin =");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(" mGrayTipType =");
      paramBundle.append(this.c);
      QLog.i("TroopRecommendFriendFragment", 2, paramBundle.toString());
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD50", "0X800AD50", 0, 0, "", "", "", "");
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131689609));
    return localView;
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRecommendApiTroopRecommendObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    CommonAdapter localCommonAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter;
    if (localCommonAdapter != null) {
      localCommonAdapter.notifyDataSetChanged();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */