package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class ApolloPanelListAdapter
  extends BaseAdapter
{
  private static int d;
  private static int e;
  private static int f;
  private static int g;
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ApolloInfo> jdField_a_of_type_JavaUtilList;
  private int b = 4;
  private int c;
  
  public ApolloPanelListAdapter(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(ApolloLinearLayout paramApolloLinearLayout, int paramInt)
  {
    if (paramApolloLinearLayout == null) {
      return;
    }
    paramApolloLinearLayout.a();
    paramApolloLinearLayout.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramApolloLinearLayout.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    paramApolloLinearLayout = (LinearLayout)paramApolloLinearLayout.getChildAt(0);
    Object localObject1 = (LinearLayout.LayoutParams)paramApolloLinearLayout.getLayoutParams();
    if (localObject1 != null)
    {
      if (paramInt == 0)
      {
        if (this.c == 4) {
          break label1186;
        }
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        label77:
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
      if (paramInt == getCount() - 1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      if ((paramInt > 0) && (paramInt < getCount() - 1))
      {
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
    }
    int k = this.b;
    int i = 0;
    label156:
    ApolloLinearLayout.ViewHolder localViewHolder;
    int m;
    Object localObject2;
    label361:
    int j;
    label481:
    float f1;
    label532:
    int n;
    if (i < this.b)
    {
      localObject1 = paramApolloLinearLayout.getChildAt(i);
      localViewHolder = (ApolloLinearLayout.ViewHolder)((View)localObject1).getTag();
      m = paramInt * k + i;
      if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1592;
      }
      ((View)localObject1).setVisibility(0);
      ApolloActionData localApolloActionData = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).mAction;
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m));
      if (this.c == 4) {
        localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838710);
      }
      if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mType != 1) {
        break label1195;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject2 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, localViewHolder.jdField_a_of_type_AndroidWidgetImageView).b(5).a();
        ((RedTouch)localObject2).a(((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("103100.103200"));
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838712);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = ((RedTouch)localObject2);
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
      if (this.c != 4) {
        localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mBinderType = 0;
      }
      if ((this.c != 2) && (!TextUtils.isEmpty(localApolloActionData.iconUrl)))
      {
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      if (TextUtils.isEmpty(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText)) {
        break label1523;
      }
      if (XPanelContainer.d != 0) {
        break label1300;
      }
      j = 1;
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localViewHolder.e.setVisibility(0);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText);
      if (j == 0) {
        break label1306;
      }
      f1 = 3.0F;
      n = AIOUtils.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = (RelativeLayout.LayoutParams)localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = n;
      ((RelativeLayout.LayoutParams)localObject2).width = (ApolloLinearLayout.c - n * 2);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.c - n * 3);
      localObject2 = (RelativeLayout.LayoutParams)localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if (j == 0) {
        break label1313;
      }
      f1 = 2.0F;
      label614:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
      localViewHolder.e.setBackgroundResource(2130838553);
      if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType != 1) {
        break label1378;
      }
      if (j == 0) {
        break label1320;
      }
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(8.0F);
      if (f == 0) {
        f = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      }
      ((RelativeLayout.LayoutParams)localObject2).width = f;
      label697:
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      localObject2 = localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (j == 0) {
        break label1516;
      }
      f1 = 3.0F;
      label732:
      ((RelativeLayout)localObject2).setPadding(0, 0, 0, AIOUtils.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
      label760:
      ApolloLinearLayout.setApolloActionIcon(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.iconType, localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction, localViewHolder);
      if ((localApolloActionData.personNum == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))) {
        localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localObject2 = (RelativeLayout)localObject1;
      if ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int != m)) {
        break label1565;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanelListAdapter", 2, new Object[] { "[updateView] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.jdField_a_of_type_Int), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId) });
      }
      if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
      {
        ((RelativeLayout)localObject2).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
        localViewHolder.jdField_a_of_type_AndroidViewView = null;
      }
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131363217);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131363217);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131363217);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131363217);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout.setId(2131362793);
      localRelativeLayout.setBackgroundDrawable(null);
      ((RelativeLayout)localObject2).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject3);
      localViewHolder.jdField_a_of_type_AndroidViewView = localRelativeLayout;
      localObject3 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject3).setImageResource(2130838707);
      ((ImageView)localObject3).setVisibility(8);
      localRelativeLayout.addView((View)localObject3, new RelativeLayout.LayoutParams(-1, -1));
      ((ImageView)localObject3).postDelayed(new ApolloPanelListAdapter.1(this, (ImageView)localObject3, localRelativeLayout, (RelativeLayout)localObject2, localViewHolder), 200L);
      this.jdField_a_of_type_Int = -1;
      label1103:
      ((View)localObject1).setContentDescription(localApolloActionData.actionName);
      if ((((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).mAction != null) && (((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).mAction.isForPlayerAction == 1)) {
        a(localViewHolder, (ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m));
      }
    }
    for (;;)
    {
      i += 1;
      break label156;
      break;
      label1186:
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      break label77;
      label1195:
      if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mType == 2)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838679);
        break label361;
      }
      if (((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).mAction.isForPlayerAction == 1) {
        QLog.i("ApolloPanelListAdapter", 4, "setBackgroundDrawable getview");
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).getPanelDrawable(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
      break label361;
      label1300:
      j = 0;
      break label481;
      label1306:
      f1 = 5.0F;
      break label532;
      label1313:
      f1 = 5.0F;
      break label614;
      label1320:
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.c - n * 2);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      if (d == 0) {
        d = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      }
      ((RelativeLayout.LayoutParams)localObject2).width = d;
      break label697;
      label1378:
      if (j != 0)
      {
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(7.0F);
        if (g == 0) {
          g = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
        }
        ((RelativeLayout.LayoutParams)localObject2).width = g;
        localObject2 = localViewHolder.jdField_c_of_type_AndroidWidgetTextView;
        if (j == 0) {
          break label1510;
        }
      }
      label1422:
      label1510:
      for (f1 = 7.0F;; f1 = 10.0F)
      {
        ((TextView)localObject2).setTextSize(f1);
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
        localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838554);
        break;
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        if (e == 0) {
          e = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
        }
        ((RelativeLayout.LayoutParams)localObject2).width = e;
        break label1422;
      }
      label1516:
      f1 = 9.0F;
      break label732;
      label1523:
      localViewHolder.e.setBackgroundDrawable(null);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localViewHolder.e.setVisibility(8);
      break label760;
      label1565:
      if (localViewHolder.jdField_a_of_type_AndroidViewView == null) {
        break label1103;
      }
      ((RelativeLayout)localObject2).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
      localViewHolder.jdField_a_of_type_AndroidViewView = null;
      break label1103;
      label1592:
      ((View)localObject1).setContentDescription(null);
      ((View)localObject1).setOnClickListener(null);
      ((View)localObject1).setVisibility(4);
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void a(ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo)
  {
    QLog.d("ApolloPanelListAdapter", 4, "ApolloPanelListAdapter handleCMSPlayerGetFrame : " + paramApolloInfo.toString());
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (localApolloManagerServiceImpl != null) {
      localApolloManagerServiceImpl.handleCMSPlayerGetFrame("ApolloPanelListAdapter", paramApolloInfo.mAction, new ApolloPanelListAdapter.FrameCallback(paramViewHolder, paramApolloInfo, this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  public void a(List<ApolloInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size() / this.b;
      i = j;
      if (this.jdField_a_of_type_JavaUtilList.size() % this.b != 0) {
        i = j + 1;
      }
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.b, 1);
    }
    for (;;)
    {
      a((ApolloLinearLayout)paramView, paramInt);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter
 * JD-Core Version:    0.7.0.1
 */