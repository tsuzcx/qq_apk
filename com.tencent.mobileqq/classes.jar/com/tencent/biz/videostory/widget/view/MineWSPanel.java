package com.tencent.biz.videostory.widget.view;

import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.biz.pubaccount.weishi_new.api.IWSMinePanel;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetMineWSPersonalRequest;
import com.tencent.biz.videostory.adapter.MineWSAdapter;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MineWSPanel
  implements IEventReceiver
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GetMineWSPersonalRequest jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest;
  private MineWSAdapter jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter;
  private MineWSPanel.ProcessClickListener jdField_a_of_type_ComTencentBizVideostoryWidgetViewMineWSPanel$ProcessClickListener;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private ProfileWeishiComponent jdField_a_of_type_ComTencentMobileqqProfilecardBussinessWeishiProfileWeishiComponent;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public MineWSPanel(ProfileWeishiComponent paramProfileWeishiComponent)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessWeishiProfileWeishiComponent = paramProfileWeishiComponent;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramProfileWeishiComponent.getActivity();
    this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter = new MineWSAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).isProfileCardActivity(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessWeishiProfileWeishiComponent != null) && (bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWeiShiPanelState isShow:");
      localStringBuilder.append(paramBoolean);
      QLog.i("MineWSPanel", 2, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessWeishiProfileWeishiComponent.initOrRefreshWeiShiPanel(paramBoolean);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.i("MineWSPanel", 2, "response is null");
      return;
    }
    ThreadManager.excute(new MineWSPanel.3(this, paramArrayOfByte), 32, null, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    } else {
      i = 2;
    }
    VSReporter.a("weishi_share_prof", "entry_clk", i, 0, new String[0]);
    boolean bool = WeishiGuideUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportWeiShiProfileClick(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, bool, paramBoolean);
    if (!bool)
    {
      VSReporter.a("weishi_share_prof", "dl_clk", 0, 0, new String[0]);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, HardCodeUtil.a(2131706801), 0).a();
      ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).downloadWeishiWithDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_Boolean);
    }
    else if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      e();
      VSReporter.a("weishi_share_prof", "clk_ws", 1, 0, new String[0]);
    }
    else
    {
      d();
      VSReporter.a("weishi_share_prof", "clk_ws", 2, 0, new String[0]);
    }
    MineWSPanel.ProcessClickListener localProcessClickListener = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewMineWSPanel$ProcessClickListener;
    if (localProcessClickListener != null) {
      localProcessClickListener.processClickEvent();
    }
  }
  
  private void d()
  {
    boolean bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
    Object localObject = "weishi://profile?person_id=";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("weishi://profile?person_id=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&logsour=2020020031");
      localObject = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("&logsour=2020020029");
      localObject = localStringBuilder.toString();
    }
    ((IWSManager)QRoute.api(IWSManager.class)).openWeishi(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "biz_src_jc_gxl", (String)localObject);
  }
  
  private void e()
  {
    ((IWSManager)QRoute.api(IWSManager.class)).openWeishi(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "biz_src_jc_gxl", "weishi://camera?logsour=2020020030");
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestWeiShiFeedListDataFromServer mUin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("MineWSPanel", 2, localStringBuilder.toString());
    if (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getApplication().getApplicationContext())) {
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("");
    this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest = new GetMineWSPersonalRequest(localStringBuilder.toString(), 1);
    VSNetworkHelper.getInstance().sendRequest(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest, new MineWSPanel.PersonalResponseListener(this));
  }
  
  public void a(WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp, boolean paramBoolean)
  {
    if (paramstGetPersonalPageRsp == null)
    {
      QLog.i("MineWSPanel", 2, "rsp is null");
      return;
    }
    int j = paramstGetPersonalPageRsp.feed_num.get();
    this.jdField_b_of_type_JavaLangString = paramstGetPersonalPageRsp.personid.get();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MineWSPanel.java][setData] feedNum:");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(", isFromDb:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("MineWSPanel", 2, ((StringBuilder)localObject).toString());
    if (j > 0)
    {
      if (!paramBoolean)
      {
        int i;
        if (this.jdField_a_of_type_Boolean) {
          i = 1;
        } else {
          i = 2;
        }
        VSReporter.a("weishi_share_prof", "entry_exp", i, 0, new String[0]);
      }
      a(true);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append(HardCodeUtil.a(2131706802));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    else
    {
      a(false);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setText("");
      }
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      paramstGetPersonalPageRsp = paramstGetPersonalPageRsp.feeds.get();
      if ((paramstGetPersonalPageRsp != null) && (paramstGetPersonalPageRsp.size() != 0))
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setData(),mIsCurrentUser=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.i("MineWSPanel", 2, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter.a(paramstGetPersonalPageRsp, this.jdField_a_of_type_Boolean);
        return;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371042));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368343);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371043));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371044));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131381228));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    localLinearLayoutManager.setRecycleChildrenOnDetach(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371478));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new MineWSPanel.1(this));
    this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter.a(new MineWSPanel.2(this));
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileCardExposure(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
    paramView = new StringBuilder();
    paramView.append("[MineWSPanel.java][initUI] mIsCurrentUser:");
    paramView.append(this.jdField_a_of_type_Boolean);
    paramView.append(", mUin:");
    paramView.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("MineWSPanel", 2, paramView.toString());
  }
  
  public void a(MineWSPanel.ProcessClickListener paramProcessClickListener)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewMineWSPanel$ProcessClickListener = paramProcessClickListener;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.i("MineWSPanel", 2, "mMineWeiShiIcon is null");
      return;
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850621);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845967);
  }
  
  public void c()
  {
    ThreadManager.excute(new MineWSPanel.4(this), 32, null, true);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel
 * JD-Core Version:    0.7.0.1
 */