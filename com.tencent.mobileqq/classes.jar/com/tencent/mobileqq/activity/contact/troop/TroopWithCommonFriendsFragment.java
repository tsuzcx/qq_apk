package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopWithCommonFriendsFragment
  extends IphoneTitleBarFragment
  implements DecodeTaskCompletionListener
{
  protected static String a = "";
  static int jdField_c_of_type_Int;
  protected int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopWithCommonFriendsFragment.3(this);
  public View a;
  protected TroopList a;
  protected BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected IFaceDecoder a;
  private IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new TroopWithCommonFriendsFragment.6(this);
  protected TroopInfoManager a;
  private CommonAdapter jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter;
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopWithCommonFriendsFragment.7(this);
  private OverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected List<CommonTroopData> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new TroopWithCommonFriendsFragment.8(this);
  protected int b;
  View.OnClickListener b;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new TroopWithCommonFriendsFragment.5(this);
  
  public TroopWithCommonFriendsFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopList = new TroopList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopWithCommonFriendsFragment.4(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter = new TroopWithCommonFriendsFragment.2(this, getActivity(), 2131559868);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(2131561510);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
    if (paramInt == 1) {
      ReportController.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    } else if (paramInt == 2) {
      ReportController.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
    }
    ReportController.b(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
    PublicFragmentActivity.a(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject != null) && ((localObject instanceof TroopCommonHolder)))
        {
          localObject = (TroopCommonHolder)localObject;
          String str = ((TroopCommonHolder)localObject).jdField_b_of_type_JavaLangString;
          if ((localObject != null) && (paramString.equals(str)))
          {
            ((TroopCommonHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131365014));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.addOnScrollListener(new TroopWithCommonFriendsFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559867, paramViewGroup, false);
    paramViewGroup = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368582);
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
      localURLDrawable.restartDownload();
    }
    paramViewGroup.setImageDrawable(localURLDrawable);
  }
  
  private void a(TroopCommonHolder paramTroopCommonHolder)
  {
    if (paramTroopCommonHolder == null) {
      return;
    }
    Object localObject = paramTroopCommonHolder.jdField_b_of_type_JavaLangString;
    if (localObject != null)
    {
      localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, (String)localObject, 4);
      paramTroopCommonHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void a(ViewHolder paramViewHolder, CommonTroopData paramCommonTroopData, int paramInt)
  {
    TroopCommonHolder localTroopCommonHolder = (TroopCommonHolder)paramViewHolder;
    if ((paramCommonTroopData != null) && (!paramCommonTroopData.jdField_a_of_type_JavaLangString.isEmpty()))
    {
      if (paramCommonTroopData.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
        return;
      }
      localTroopCommonHolder.jdField_a_of_type_Long = paramInt;
      localTroopCommonHolder.jdField_a_of_type_JavaLangString = paramCommonTroopData.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname;
      localTroopCommonHolder.jdField_a_of_type_Int = paramCommonTroopData.jdField_a_of_type_Int;
      localTroopCommonHolder.jdField_b_of_type_JavaLangString = paramCommonTroopData.jdField_a_of_type_JavaLangString;
      if (localTroopCommonHolder.jdField_a_of_type_JavaLangString.isEmpty()) {
        localTroopCommonHolder.jdField_a_of_type_JavaLangString = localTroopCommonHolder.jdField_b_of_type_JavaLangString;
      }
      paramInt = localTroopCommonHolder.jdField_a_of_type_Int;
      paramCommonTroopData = getString(2131699472);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramCommonTroopData);
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append(getString(2131699471));
      paramCommonTroopData = ((StringBuilder)localObject).toString();
      localObject = getString(2131699469);
      String str = getString(2131699470);
      if (TroopWithCommonFriendsHelper.a(jdField_a_of_type_JavaLangString, localTroopCommonHolder.jdField_b_of_type_JavaLangString))
      {
        localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755552);
        localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
        localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setText(str);
        localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131756341);
      }
      localTroopCommonHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopCommonHolder.jdField_a_of_type_JavaLangString);
      localTroopCommonHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramCommonTroopData);
      localTroopCommonHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
      localTroopCommonHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(paramViewHolder);
      localTroopCommonHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramViewHolder);
      localTroopCommonHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
      localTroopCommonHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localTroopCommonHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(localTroopCommonHolder);
    }
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    }
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  public String a(long paramLong)
  {
    Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_JavaUtilList = TroopWithCommonFriendsHelper.a((ArrayList)TroopWithCommonFriendsHelper.a(jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.mContentView);
    a(paramViewGroup);
    a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterCommonAdapter.a(this.jdField_a_of_type_JavaUtilList);
    if (jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      TroopWithCommonFriendsHelper.a(Long.parseLong(jdField_a_of_type_JavaLangString), 2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561523;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    String str1 = getString(2131699473);
    if (!jdField_a_of_type_JavaLangString.isEmpty())
    {
      str1 = a(Long.parseLong(jdField_a_of_type_JavaLangString));
      String str2 = getString(2131699475);
      String str3 = getString(2131699474);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      localStringBuilder.append(str3);
      str1 = localStringBuilder.toString();
    }
    setTitle(str1);
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView, paramString, paramBitmap);
    }
  }
  
  public void onDestroy()
  {
    c();
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeHandler(getClass());
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment
 * JD-Core Version:    0.7.0.1
 */