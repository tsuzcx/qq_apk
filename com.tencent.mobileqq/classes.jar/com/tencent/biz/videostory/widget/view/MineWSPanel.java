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
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;
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
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ProfileWeishiComponent jdField_a_of_type_ComTencentMobileqqProfilecardBussinessWeishiProfileWeishiComponent;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public MineWSPanel(ProfileWeishiComponent paramProfileWeishiComponent)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessWeishiProfileWeishiComponent = paramProfileWeishiComponent;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramProfileWeishiComponent.getActivity();
    this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter = new MineWSAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessWeishiProfileWeishiComponent != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)))
    {
      QLog.i("MineWSPanel", 2, "setWeiShiPanelState isShow:" + paramBoolean);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    label138:
    label187:
    for (;;)
    {
      return;
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 1;
        VSReporter.a("weishi_share_prof", "entry_clk", i, 0, new String[0]);
        boolean bool = WeishiGuideUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportWeiShiProfileClick(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, bool, paramBoolean);
        if (bool) {
          break label138;
        }
        VSReporter.a("weishi_share_prof", "dl_clk", 0, 0, new String[0]);
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131706779), 0).a();
        ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).downloadWeishiWithDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewMineWSPanel$ProcessClickListener == null) {
          break label187;
        }
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewMineWSPanel$ProcessClickListener.processClickEvent();
        return;
        i = 2;
        break;
        if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
        {
          e();
          VSReporter.a("weishi_share_prof", "clk_ws", 1, 0, new String[0]);
        }
        else
        {
          d();
          VSReporter.a("weishi_share_prof", "clk_ws", 2, 0, new String[0]);
        }
      }
    }
  }
  
  private void d()
  {
    String str = "weishi://profile?person_id=";
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      str = "weishi://profile?person_id=" + this.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (str = str + "&logsour=2020020031";; str = str + "&logsour=2020020029")
    {
      ((IWSManager)QRoute.api(IWSManager.class)).openWeishi(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "biz_src_jc_gxl", str);
      return;
    }
  }
  
  private void e()
  {
    ((IWSManager)QRoute.api(IWSManager.class)).openWeishi(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "biz_src_jc_gxl", "weishi://camera?logsour=2020020030");
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
    QLog.i("MineWSPanel", 2, "requestWeiShiFeedListDataFromServer mUin=" + this.jdField_a_of_type_JavaLangString);
    if (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApplication().getApplicationContext())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest = new GetMineWSPersonalRequest(this.jdField_a_of_type_JavaLangString + "", 1);
    VSNetworkHelper.getInstance().sendRequest(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest, new MineWSPanel.PersonalResponseListener(this));
  }
  
  public void a(WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp, boolean paramBoolean)
  {
    if (paramstGetPersonalPageRsp == null) {
      QLog.i("MineWSPanel", 2, "rsp is null");
    }
    label210:
    for (;;)
    {
      return;
      int j = paramstGetPersonalPageRsp.feed_num.get();
      this.jdField_b_of_type_JavaLangString = paramstGetPersonalPageRsp.personid.get();
      QLog.i("MineWSPanel", 2, "[MineWSPanel.java][setData] feedNum:" + j + ", isFromDb:" + paramBoolean);
      int i;
      if (j > 0) {
        if (!paramBoolean)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            i = 1;
            VSReporter.a("weishi_share_prof", "entry_exp", i, 0, new String[0]);
          }
        }
        else
        {
          a(true);
          if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(j + HardCodeUtil.a(2131706780));
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {
          break label210;
        }
        paramstGetPersonalPageRsp = paramstGetPersonalPageRsp.feeds.get();
        if ((paramstGetPersonalPageRsp != null) && (paramstGetPersonalPageRsp.size() != 0)) {
          break label212;
        }
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        return;
        i = 2;
        break;
        a(false);
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        }
      }
    }
    label212:
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    QLog.i("MineWSPanel", 2, "setData(),mIsCurrentUser=" + this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter.a(paramstGetPersonalPageRsp, this.jdField_a_of_type_Boolean);
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371420));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368603);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371421));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371422));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131382023));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    localLinearLayoutManager.setRecycleChildrenOnDetach(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371856));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new MineWSPanel.1(this));
    this.jdField_a_of_type_ComTencentBizVideostoryAdapterMineWSAdapter.a(new MineWSPanel.2(this));
    ((IWSMinePanel)QRoute.api(IWSMinePanel.class)).reportProfileCardExposure(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
    QLog.i("MineWSPanel", 2, "[MineWSPanel.java][initUI] mIsCurrentUser:" + this.jdField_a_of_type_Boolean + ", mUin:" + this.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850695);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130846090);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel
 * JD-Core Version:    0.7.0.1
 */