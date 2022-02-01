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
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class anqe
  extends anqh
  implements View.OnClickListener
{
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anmm jdField_a_of_type_Anmm;
  boolean jdField_a_of_type_Boolean = false;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public anqe(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
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
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setSelector(2130850739);
      }
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView = new ApolloPanelListView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setDivider(null);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setVerticalScrollBarEnabled(true);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.setSelector(2130850739);
      }
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView;
    case 1: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558690, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558685, null);
  }
  
  public annl a(String paramString)
  {
    return new annm(paramString);
  }
  
  public ArrayList<annl> a(int paramInt)
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
    this.jdField_a_of_type_Anmm = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      URLImageView localURLImageView1 = (URLImageView)paramView.findViewById(2131362773);
      URLImageView localURLImageView2 = (URLImageView)paramView.findViewById(2131362807);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362806));
      localURLImageView1.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131699965));
      }
      Object localObject = new ColorDrawable();
      URLDrawable localURLDrawable = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", (Drawable)localObject, (Drawable)localObject);
      localObject = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_buttom_man_v2.png", (Drawable)localObject, (Drawable)localObject);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView1.getLayoutParams();
      localLayoutParams.height = ((int)(XPanelContainer.a - 85.0F * paramView.getResources().getDisplayMetrics().density));
      localLayoutParams.width = (localLayoutParams.height * 602 / 366);
      localLayoutParams.bottomMargin = ((int)(5.0F * paramView.getResources().getDisplayMetrics().density));
      localURLImageView1.setBackgroundDrawable(localURLDrawable);
      localURLImageView2.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "state_open_show", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[0]);
  }
  
  public void a(View paramView, int paramInt)
  {
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
  
  public void a(anmm paramanmm)
  {
    this.jdField_a_of_type_Anmm = paramanmm;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    if (this.jdField_a_of_type_Anpk != null) {
      this.jdField_a_of_type_Anpk.a(paramBaseChatPie);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376110));
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "panel is not jsonFail and panelView.class=" + paramView.getClass().getSimpleName());
    return;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369624));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369622));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369623));
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
  
  public void c_(List<annl> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
      if (this.jdField_a_of_type_Anmm != null)
      {
        this.jdField_a_of_type_Anmm.d();
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Anmm.b();
        }
        else if (this.jdField_a_of_type_Anmm != null)
        {
          paramView.setClickable(false);
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)paramView.getParent()).findViewById(2131378997));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_Anmm.a();
          continue;
          if (this.jdField_a_of_type_Anmm != null)
          {
            this.jdField_a_of_type_Anmm.c();
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            paramView.setVisibility(4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqe
 * JD-Core Version:    0.7.0.1
 */