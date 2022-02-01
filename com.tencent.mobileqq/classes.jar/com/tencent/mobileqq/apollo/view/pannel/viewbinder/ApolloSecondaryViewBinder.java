package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ApolloSecondaryViewBinder
  extends ApolloViewBinder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private OpenCallback jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback;
  boolean jdField_a_of_type_Boolean = false;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ApolloSecondaryViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.c = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.f = 4;
  }
  
  public View a()
  {
    switch (this.jdField_b_of_type_Int)
    {
    case 2: 
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setDivider(null);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setVerticalScrollBarEnabled(true);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setSelector(2130851165);
      }
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setDivider(null);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setVerticalScrollBarEnabled(true);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setSelector(2130851165);
      }
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView;
    case 1: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558715, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558710, null);
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    if ((this.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    do
    {
      return null;
      i = a();
    } while ((paramInt < 0) || (paramInt >= i) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView == null));
    paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.getFirstVisiblePosition() * this.f;
    int i = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.getLastVisiblePosition();
    int j = this.f;
    ArrayList localArrayList = new ArrayList();
    while ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt <= (i + 1) * j - 1))
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      URLImageView localURLImageView1 = (URLImageView)paramView.findViewById(2131362804);
      URLImageView localURLImageView2 = (URLImageView)paramView.findViewById(2131362839);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362838));
      localURLImageView1.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131700543));
      }
      Object localObject = new ColorDrawable();
      URLDrawable localURLDrawable = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", (Drawable)localObject, (Drawable)localObject);
      localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_buttom_man_v2.png", (Drawable)localObject, (Drawable)localObject);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView1.getLayoutParams();
      localLayoutParams.height = ((int)(XPanelContainer.jdField_a_of_type_Int - 85.0F * paramView.getResources().getDisplayMetrics().density));
      localLayoutParams.width = (localLayoutParams.height * 602 / 366);
      localLayoutParams.bottomMargin = ((int)(5.0F * paramView.getResources().getDisplayMetrics().density));
      localURLImageView1.setBackgroundDrawable(localURLDrawable);
      localURLImageView2.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "state_open_show", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    }
    switch (this.jdField_b_of_type_Int)
    {
    case 2: 
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 0: 
      c(paramView);
      return;
    }
    b(paramView);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListAdapter.a(paramBaseChatPie);
    }
  }
  
  public void a(OpenCallback paramOpenCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback = paramOpenCallback;
  }
  
  public void a(List<ApolloInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376495));
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "panel is not jsonFail and panelView.class=" + paramView.getClass().getSimpleName());
    return;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369897));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369895));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369896));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i;
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        i = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (!HardCodeUtil.a(2131700543).equals(this.jdField_a_of_type_AndroidWidgetButton.getText())) {
          break label202;
        }
      }
      label202:
      for (String str = "openshop";; str = "open")
      {
        ApolloDtReportUtil.a("panel", "new_user_v2", str, new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).f(i).a());
        if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.d();
        if (!this.jdField_a_of_type_Boolean) {
          break label209;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.b();
        break;
      }
      label209:
      if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback != null)
      {
        paramView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)paramView.getParent()).findViewById(2131379428));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.a();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.c();
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          paramView.setVisibility(4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloSecondaryViewBinder
 * JD-Core Version:    0.7.0.1
 */