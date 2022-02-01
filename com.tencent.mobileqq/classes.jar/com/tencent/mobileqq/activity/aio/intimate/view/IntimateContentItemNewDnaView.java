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
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo.DnaDetail;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntimateContentItemNewDnaView
  extends IntimateContentItemBaseView
{
  private boolean i = false;
  private RecyclerView j;
  private IntimateContentItemNewDnaView.FriendDnaRvAdapter k;
  private IntimateContentItemNewDnaView.FriendDnaRvItemListener l = new IntimateContentItemNewDnaView.1(this);
  
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
    ReportController.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramNewDnaInfo.a, 0, "", "", "", "");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a, paramNewDnaInfo.f, 2064, null);
  }
  
  private void a(Friends paramFriends, List<NewDnaInfo> paramList, NewDnaInfo paramNewDnaInfo)
  {
    NewDnaInfo.DnaDetail localDnaDetail = new NewDnaInfo.DnaDetail();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFriends.temper);
    ((StringBuilder)localObject).append("°");
    ((StringBuilder)localObject).append(paramFriends.weatherType);
    localDnaDetail.a = ((StringBuilder)localObject).toString();
    localDnaDetail.b = 0;
    localDnaDetail.c = localDnaDetail.a.getBytes().length;
    localObject = new NewDnaInfo.DnaDetail();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFriends.city);
    localStringBuilder.append(paramFriends.area);
    ((NewDnaInfo.DnaDetail)localObject).a = localStringBuilder.toString();
    ((NewDnaInfo.DnaDetail)localObject).b = 0;
    ((NewDnaInfo.DnaDetail)localObject).c = ((NewDnaInfo.DnaDetail)localObject).a.getBytes().length;
    paramFriends = new ArrayList();
    paramFriends.add(localDnaDetail);
    paramFriends.add(localObject);
    if (paramNewDnaInfo.d != null)
    {
      paramNewDnaInfo.d.clear();
      paramNewDnaInfo.d.addAll(paramFriends);
    }
    else
    {
      paramNewDnaInfo.d = paramFriends;
    }
    paramList.add(paramNewDnaInfo);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.makeText(getContext(), 1, paramString, 0).show();
    }
  }
  
  private void a(List<NewDnaInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Friends localFriends = ((FriendsManager)this.h.n().getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.h.k());
      ArrayList localArrayList = new ArrayList();
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NewDnaInfo localNewDnaInfo = (NewDnaInfo)paramList.next();
        if (localNewDnaInfo.a == 23)
        {
          String str1 = localSharedPreferences.getString("drawer_cur_temp", null);
          String str2 = localSharedPreferences.getString("drawer_cur_city", null);
          int m = localSharedPreferences.getInt("drawer_cur_adcode", 0);
          String str3 = localSharedPreferences.getString("drawer_cur_desc", null);
          if ((localFriends != null) && (((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).isWeatherInfoValid(localFriends)) && (!TextUtils.isEmpty(localFriends.adCode)) && (!TextUtils.isEmpty(localFriends.area)) && (!TextUtils.isEmpty(localFriends.city)) && (!TextUtils.isEmpty(localFriends.temper)) && (!TextUtils.isEmpty(localFriends.weatherType))) {
            a(localFriends, localArrayList, localNewDnaInfo);
          } else if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (m != 0) && (!TextUtils.isEmpty(str3))) {
            a(localArrayList, localNewDnaInfo, str1, str2, str3);
          }
        }
        else
        {
          localArrayList.add(localNewDnaInfo);
        }
      }
      paramList = this.k;
      if (paramList != null) {
        paramList.a(localArrayList);
      }
    }
  }
  
  private void a(List<NewDnaInfo> paramList, NewDnaInfo paramNewDnaInfo, String paramString1, String paramString2, String paramString3)
  {
    NewDnaInfo.DnaDetail localDnaDetail = new NewDnaInfo.DnaDetail();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("°");
    localStringBuilder.append(paramString3);
    localDnaDetail.a = localStringBuilder.toString();
    localDnaDetail.b = 0;
    localDnaDetail.c = localDnaDetail.a.getBytes().length;
    paramString1 = paramString2.split("-");
    if (paramString1.length == 2)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1[0]);
      paramString2.append(paramString1[1]);
      paramString2 = paramString2.toString();
    }
    paramString1 = new NewDnaInfo.DnaDetail();
    paramString1.a = paramString2;
    paramString1.b = 0;
    paramString1.c = paramString1.a.getBytes().length;
    paramString2 = new ArrayList();
    paramString2.add(localDnaDetail);
    paramString2.add(paramString1);
    if (paramNewDnaInfo.d != null)
    {
      paramNewDnaInfo.d.clear();
      paramNewDnaInfo.d.addAll(paramString2);
    }
    else
    {
      paramNewDnaInfo.d = paramString2;
    }
    paramList.add(paramNewDnaInfo);
  }
  
  private void b(NewDnaInfo paramNewDnaInfo)
  {
    if (WebViewComUtils.a(1000L))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramNewDnaInfo.a, 0, "", "", "", "");
      Friends localFriends = ((FriendsManager)this.h.n().getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.h.k());
      int m = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("drawer_cur_adcode", 0);
      if (m != 0) {
        paramNewDnaInfo = String.valueOf(m);
      } else {
        paramNewDnaInfo = "";
      }
      if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.adCode)))
      {
        ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(this.h.l(), this.h.n(), false, "", false, localFriends.adCode);
        return;
      }
      if (!TextUtils.isEmpty(paramNewDnaInfo))
      {
        ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(this.h.l(), this.h.n(), false, "", false, paramNewDnaInfo);
        return;
      }
      a(this.a.getString(2131890985));
    }
  }
  
  private void c(NewDnaInfo paramNewDnaInfo)
  {
    if (WebViewComUtils.a(1000L))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B569", "0X800B569", paramNewDnaInfo.a, 0, "", "", "", "");
      Intent localIntent = new Intent(this.a, QQTranslucentBrowserActivity.class);
      localIntent.putExtra("url", paramNewDnaInfo.c);
      localIntent.putExtra("flag_show_loading_dialog", true);
      localIntent.putExtra("flag_hide_float_bar", true);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.a.startActivity(localIntent);
    }
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
    boolean bool = FriendIntimateRelationshipConfProcessor.a().Z;
    int m;
    if ((this.d != null) && (this.d.newDnaInfos != null) && (this.d.newDnaInfos.size() > 0)) {
      m = 1;
    } else {
      m = 0;
    }
    return (bool) && (m != 0);
  }
  
  protected void b()
  {
    this.j = ((RecyclerView)LayoutInflater.from(this.a).inflate(2131625180, this, true).findViewById(2131433762));
    this.k = new IntimateContentItemNewDnaView.FriendDnaRvAdapter(this, null);
    IntimateContentItemNewDnaView.2 local2 = new IntimateContentItemNewDnaView.2(this, this.h.l(), 2);
    this.j.setLayoutManager(local2);
    this.j.setAdapter(this.k);
    this.i = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  protected void g()
  {
    RecyclerView localRecyclerView = this.j;
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutManager(null);
      this.j.removeAllViews();
      this.j.setAdapter(null);
      this.k = null;
      this.j = null;
      removeAllViews();
    }
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView
 * JD-Core Version:    0.7.0.1
 */