package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

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
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ApolloMainViewBinder
  extends ApolloViewBinder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OpenCallback jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ApolloMainViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext);
    this.c = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.f = 4;
  }
  
  public View a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setDivider(null);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setVerticalScrollBarEnabled(true);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setEdgeEffectEnabled(false);
            this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setSelector(2130851081);
          }
          return this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView;
        }
        return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558609, null);
      }
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558614, null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setDivider(null);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setVerticalScrollBarEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.setSelector(2130851081);
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView;
  }
  
  public ApolloInfo a(String paramString)
  {
    return new ApolloMainInfo(paramString);
  }
  
  public ArrayList<ApolloInfo> a(int paramInt)
  {
    int i = this.jdField_b_of_type_Int;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (i == 0)
    {
      localArrayList1 = localArrayList2;
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          return null;
        }
        i = a();
        localArrayList1 = localArrayList2;
        if (paramInt >= 0)
        {
          if (paramInt >= i) {
            return null;
          }
          localArrayList1 = localArrayList2;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView != null)
          {
            paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.getFirstVisiblePosition() * this.f;
            i = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListView.getLastVisiblePosition();
            int j = this.f;
            localArrayList2 = new ArrayList();
            for (;;)
            {
              localArrayList1 = localArrayList2;
              if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
                break;
              }
              localArrayList1 = localArrayList2;
              if (paramInt > (i + 1) * j - 1) {
                break;
              }
              localArrayList2.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
              paramInt += 1;
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    URLImageView localURLImageView1 = (URLImageView)paramView.findViewById(2131362754);
    URLImageView localURLImageView2 = (URLImageView)paramView.findViewById(2131362783);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362782));
    localURLImageView1.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131700684));
    }
    Object localObject = new ColorDrawable();
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", (Drawable)localObject, (Drawable)localObject);
    localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_buttom_man_v2.png", (Drawable)localObject, (Drawable)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView1.getLayoutParams();
    localLayoutParams.height = ((int)(XPanelContainer.jdField_a_of_type_Int - paramView.getResources().getDisplayMetrics().density * 85.0F));
    localLayoutParams.width = (localLayoutParams.height * 602 / 366);
    localLayoutParams.bottomMargin = ((int)(paramView.getResources().getDisplayMetrics().density * 5.0F));
    localURLImageView1.setBackgroundDrawable(localURLDrawable);
    localURLImageView2.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "state_open_show", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      paramInt = this.jdField_b_of_type_Int;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 3) {
            return;
          }
          b(paramView);
          return;
        }
        a(paramView);
        return;
      }
      c(paramView);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelListAdapter.a(paramBaseChatPie);
    }
  }
  
  public void a(List<ApolloInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
    if (paramView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375997));
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("panel is not jsonFail and panelView.class=");
        ((StringBuilder)localObject).append(paramView.getClass().getSimpleName());
        QLog.d("ApolloPanel", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ((TextView)localObject).setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369582));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369580));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369581));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131362782)
    {
      if (i != 2131375997) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback;
      if (localObject != null)
      {
        ((OpenCallback)localObject).e();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramView.setVisibility(4);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        i = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (HardCodeUtil.a(2131700684).equals(this.jdField_a_of_type_AndroidWidgetButton.getText())) {
          localObject = "openshop";
        } else {
          localObject = "open";
        }
        ApolloDtReportUtil.a("panel", "new_user_v2", (String)localObject, new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).f(i).a());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback;
      if (localObject == null) {
        return;
      }
      ((OpenCallback)localObject).m();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback != null)
      {
        paramView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)paramView.getParent()).findViewById(2131378780));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsOpenCallback.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloMainViewBinder
 * JD-Core Version:    0.7.0.1
 */