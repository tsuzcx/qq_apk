package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo.DnaDetail;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntimateContentItemNewDnaView
  extends IntimateContentItemBaseView
{
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private IntimateContentItemNewDnaView.FriendDnaRvAdapter jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView$FriendDnaRvAdapter;
  private IntimateContentItemNewDnaView.FriendDnaRvItemListener jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView$FriendDnaRvItemListener = new IntimateContentItemNewDnaView.1(this);
  private boolean d = false;
  
  public IntimateContentItemNewDnaView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemNewDnaView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemNewDnaView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(NewDnaInfo paramNewDnaInfo)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramNewDnaInfo.jdField_a_of_type_Int, 0, "", "", "", "");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramNewDnaInfo.d, 2064, null);
  }
  
  private void a(Friends paramFriends, List<NewDnaInfo> paramList, NewDnaInfo paramNewDnaInfo)
  {
    NewDnaInfo.DnaDetail localDnaDetail1 = new NewDnaInfo.DnaDetail();
    localDnaDetail1.jdField_a_of_type_JavaLangString = (paramFriends.temper + "°" + paramFriends.weatherType);
    localDnaDetail1.jdField_a_of_type_Int = 0;
    localDnaDetail1.b = localDnaDetail1.jdField_a_of_type_JavaLangString.getBytes().length;
    NewDnaInfo.DnaDetail localDnaDetail2 = new NewDnaInfo.DnaDetail();
    localDnaDetail2.jdField_a_of_type_JavaLangString = (paramFriends.city + paramFriends.area);
    localDnaDetail2.jdField_a_of_type_Int = 0;
    localDnaDetail2.b = localDnaDetail2.jdField_a_of_type_JavaLangString.getBytes().length;
    paramFriends = new ArrayList();
    paramFriends.add(localDnaDetail1);
    paramFriends.add(localDnaDetail2);
    if (paramNewDnaInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramNewDnaInfo.jdField_a_of_type_JavaUtilArrayList.clear();
      paramNewDnaInfo.jdField_a_of_type_JavaUtilArrayList.addAll(paramFriends);
    }
    for (;;)
    {
      paramList.add(paramNewDnaInfo);
      return;
      paramNewDnaInfo.jdField_a_of_type_JavaUtilArrayList = paramFriends;
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.a(getContext(), 1, paramString, 0).a();
    }
  }
  
  private void a(List<NewDnaInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      ArrayList localArrayList = new ArrayList();
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NewDnaInfo localNewDnaInfo = (NewDnaInfo)paramList.next();
        if (localNewDnaInfo.jdField_a_of_type_Int == 23)
        {
          String str1 = localSharedPreferences.getString("drawer_cur_temp", null);
          String str2 = localSharedPreferences.getString("drawer_cur_city", null);
          int i = localSharedPreferences.getInt("drawer_cur_adcode", 0);
          String str3 = localSharedPreferences.getString("drawer_cur_desc", null);
          if ((localFriends != null) && (OnlineStatusUtil.a(localFriends)) && (!TextUtils.isEmpty(localFriends.adCode)) && (!TextUtils.isEmpty(localFriends.area)) && (!TextUtils.isEmpty(localFriends.city)) && (!TextUtils.isEmpty(localFriends.temper)) && (!TextUtils.isEmpty(localFriends.weatherType))) {
            a(localFriends, localArrayList, localNewDnaInfo);
          } else if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (i != 0) && (!TextUtils.isEmpty(str3))) {
            a(localArrayList, localNewDnaInfo, str1, str2, str3);
          }
        }
        else
        {
          localArrayList.add(localNewDnaInfo);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView$FriendDnaRvAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView$FriendDnaRvAdapter.a(localArrayList);
      }
    }
  }
  
  private void a(List<NewDnaInfo> paramList, NewDnaInfo paramNewDnaInfo, String paramString1, String paramString2, String paramString3)
  {
    NewDnaInfo.DnaDetail localDnaDetail = new NewDnaInfo.DnaDetail();
    localDnaDetail.jdField_a_of_type_JavaLangString = (paramString1 + "°" + paramString3);
    localDnaDetail.jdField_a_of_type_Int = 0;
    localDnaDetail.b = localDnaDetail.jdField_a_of_type_JavaLangString.getBytes().length;
    paramString1 = paramString2.split("-");
    if (paramString1.length == 2) {
      paramString2 = paramString1[0] + paramString1[1];
    }
    paramString1 = new NewDnaInfo.DnaDetail();
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    paramString1.jdField_a_of_type_Int = 0;
    paramString1.b = paramString1.jdField_a_of_type_JavaLangString.getBytes().length;
    paramString2 = new ArrayList();
    paramString2.add(localDnaDetail);
    paramString2.add(paramString1);
    if (paramNewDnaInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramNewDnaInfo.jdField_a_of_type_JavaUtilArrayList.clear();
      paramNewDnaInfo.jdField_a_of_type_JavaUtilArrayList.addAll(paramString2);
    }
    for (;;)
    {
      paramList.add(paramNewDnaInfo);
      return;
      paramNewDnaInfo.jdField_a_of_type_JavaUtilArrayList = paramString2;
    }
  }
  
  private void b(NewDnaInfo paramNewDnaInfo)
  {
    if (QQBrowserActivity.checkNotFrequentlyThenEnter(1000L))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramNewDnaInfo.jdField_a_of_type_Int, 0, "", "", "", "");
      Friends localFriends = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a().getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a());
      int i = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("drawer_cur_adcode", 0);
      paramNewDnaInfo = "";
      if (i != 0) {
        paramNewDnaInfo = String.valueOf(i);
      }
      if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.adCode))) {
        WeatherWebPageHelperKt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), false, "", false, localFriends.adCode);
      }
    }
    else
    {
      return;
    }
    if (!TextUtils.isEmpty(paramNewDnaInfo))
    {
      WeatherWebPageHelperKt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), false, "", false, paramNewDnaInfo);
      return;
    }
    a(this.jdField_a_of_type_AndroidContentContext.getString(2131693481));
  }
  
  private void c(NewDnaInfo paramNewDnaInfo)
  {
    if (QQBrowserActivity.checkNotFrequentlyThenEnter(1000L))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramNewDnaInfo.jdField_a_of_type_Int, 0, "", "", "", "");
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQTranslucentBrowserActivity.class);
      localIntent.putExtra("url", paramNewDnaInfo.b);
      localIntent.putExtra("flag_show_loading_dialog", true);
      localIntent.putExtra("flag_hide_float_bar", true);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559384, this, true).findViewById(2131367547));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView$FriendDnaRvAdapter = new IntimateContentItemNewDnaView.FriendDnaRvAdapter(this, null);
    IntimateContentItemNewDnaView.2 local2 = new IntimateContentItemNewDnaView.2(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateBaseIntimateView.a(), 2);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(local2);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView$FriendDnaRvAdapter);
    this.d = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  protected void a(View paramView) {}
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    if ((paramIntimateInfo != null) && (paramIntimateInfo.newDnaInfos != null) && (paramIntimateInfo.newDnaInfos.size() > 0))
    {
      setVisibility(0);
      a(paramIntimateInfo.newDnaInfos);
      return;
    }
    setVisibility(8);
  }
  
  protected boolean a()
  {
    boolean bool = FriendIntimateRelationshipConfProcessor.a().d;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.newDnaInfos != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.newDnaInfos.size() > 0)) {}
    for (int i = 1; (bool) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView != null)
    {
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(null);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.removeAllViews();
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView$FriendDnaRvAdapter = null;
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = null;
      removeAllViews();
    }
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView
 * JD-Core Version:    0.7.0.1
 */