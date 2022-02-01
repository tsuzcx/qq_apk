package com.tencent.mobileqq.apollo.aio.panel;

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
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
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
        if (this.c != 4) {
          ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        } else {
          ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        }
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
      if (paramInt == getCount() - 1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      if ((paramInt > 0) && (paramInt < getCount() - 1))
      {
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
    }
    int m = this.b;
    int i = 0;
    while (i < this.b)
    {
      localObject1 = paramApolloLinearLayout.getChildAt(i);
      ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)((View)localObject1).getTag();
      int k = paramInt * m + i;
      if (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((View)localObject1).setVisibility(0);
        ApolloActionData localApolloActionData = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k)).mAction;
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k));
        if (this.c == 4) {
          localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838555);
        }
        Object localObject3;
        Object localObject4;
        if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mType == 1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            localObject2 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, localViewHolder.jdField_a_of_type_AndroidWidgetImageView).b(5).a();
            ((RedTouch)localObject2).a(((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103200"));
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838557);
            localViewHolder.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = ((RedTouch)localObject2);
          }
        }
        else if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mType == 2)
        {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838518);
        }
        else
        {
          if (((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k)).mAction.isForPlayerAction == 1) {
            QLog.i("[cmshow]ApolloPanelListAdapter", 4, "setBackgroundDrawable getview");
          }
          localObject2 = localViewHolder.jdField_a_of_type_AndroidWidgetImageView;
          localObject3 = (ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k);
          localObject4 = this.jdField_a_of_type_AndroidContentContext;
          ((ImageView)localObject2).setBackgroundDrawable(((ApolloInfo)localObject3).getPanelDrawable((Context)localObject4, ((Context)localObject4).getResources().getDisplayMetrics().density));
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
        if (this.c != 4) {
          localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mBinderType = 0;
        }
        if ((this.c != 2) && (!TextUtils.isEmpty(localApolloActionData.iconUrl)))
        {
          localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
          localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText))
        {
          if (XPanelContainer.d == 0) {
            j = 1;
          } else {
            j = 0;
          }
          localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          localViewHolder.e.setVisibility(0);
          localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText);
          float f1;
          if (j != 0) {
            f1 = 3.0F;
          } else {
            f1 = 5.0F;
          }
          int n = AIOUtils.b(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
          localObject2 = (RelativeLayout.LayoutParams)localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).topMargin = n;
          int i1 = ApolloLinearLayout.jdField_a_of_type_Int;
          int i2 = n * 2;
          ((RelativeLayout.LayoutParams)localObject2).width = (i1 - i2);
          localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.jdField_a_of_type_Int - n * 3);
          localObject2 = (RelativeLayout.LayoutParams)localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
          if (j != 0) {
            f1 = 2.0F;
          } else {
            f1 = 5.0F;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(f1, this.jdField_a_of_type_AndroidContentContext.getResources());
          localViewHolder.e.setBackgroundResource(2130838395);
          if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mTextType == 1)
          {
            if (j != 0)
            {
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(8.0F);
              if (f == 0) {
                f = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject2).width = f;
            }
            else
            {
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.jdField_a_of_type_Int - i2);
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
              if (d == 0) {
                d = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject2).width = d;
            }
            localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-4473925);
            localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
          }
          else
          {
            if (j != 0)
            {
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(7.0F);
              if (g == 0) {
                g = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject2).width = g;
            }
            else
            {
              localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
              if (e == 0) {
                e = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
              }
              ((RelativeLayout.LayoutParams)localObject2).width = e;
            }
            localObject2 = localViewHolder.jdField_c_of_type_AndroidWidgetTextView;
            if (j != 0) {
              f1 = 7.0F;
            } else {
              f1 = 10.0F;
            }
            ((TextView)localObject2).setTextSize(f1);
            localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
            localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838396);
          }
          localObject2 = localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout;
          if (j != 0) {
            f1 = 3.0F;
          } else {
            f1 = 9.0F;
          }
          ((RelativeLayout)localObject2).setPadding(0, 0, 0, AIOUtils.b(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
        }
        else
        {
          localViewHolder.e.setBackgroundDrawable(null);
          localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localViewHolder.e.setVisibility(8);
        }
        ApolloLinearLayout.setApolloActionIcon(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.iconType, localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction, localViewHolder);
        if ((localApolloActionData.personNum == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))) {
          localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        Object localObject2 = (RelativeLayout)localObject1;
        int j = this.jdField_a_of_type_Int;
        if ((j != -1) && (j == k))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanelListAdapter", 2, new Object[] { "[updateView] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.jdField_a_of_type_Int), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId) });
          }
          if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
          {
            ((RelativeLayout)localObject2).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
            localViewHolder.jdField_a_of_type_AndroidViewView = null;
          }
          localObject4 = new RelativeLayout.LayoutParams(-1, -1);
          ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131363156);
          ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131363156);
          ((RelativeLayout.LayoutParams)localObject4).addRule(6, 2131363156);
          ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131363156);
          localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          ((RelativeLayout)localObject3).setId(2131362743);
          ((RelativeLayout)localObject3).setBackgroundDrawable(null);
          ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          localViewHolder.jdField_a_of_type_AndroidViewView = ((View)localObject3);
          localObject4 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject4).setImageResource(2130838552);
          ((ImageView)localObject4).setVisibility(8);
          ((RelativeLayout)localObject3).addView((View)localObject4, new RelativeLayout.LayoutParams(-1, -1));
          ((ImageView)localObject4).postDelayed(new ApolloPanelListAdapter.1(this, (ImageView)localObject4, (RelativeLayout)localObject3, (RelativeLayout)localObject2, localViewHolder), 200L);
          this.jdField_a_of_type_Int = -1;
        }
        else if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout)localObject2).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
          localViewHolder.jdField_a_of_type_AndroidViewView = null;
        }
        ((View)localObject1).setContentDescription(localApolloActionData.actionName);
        if ((((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k)).mAction != null) && (((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k)).mAction.isForPlayerAction == 1)) {
          a(localViewHolder, (ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k));
        }
      }
      else
      {
        ((View)localObject1).setContentDescription(null);
        ((View)localObject1).setOnClickListener(null);
        ((View)localObject1).setVisibility(4);
      }
      i += 1;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ApolloPanelListAdapter handleCMSPlayerGetFrame : ");
    ((StringBuilder)localObject).append(paramApolloInfo.toString());
    QLog.d("[cmshow]ApolloPanelListAdapter", 4, ((StringBuilder)localObject).toString());
    localObject = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (localObject != null) {
      ((ApolloManagerServiceImpl)localObject).handleCMSPlayerGetFrame("ApolloPanelListAdapter", paramApolloInfo.mAction, new ApolloPanelListAdapter.FrameCallback(paramViewHolder, paramApolloInfo, this.jdField_a_of_type_AndroidContentContext));
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localList != null)
    {
      int j = localList.size() / this.b;
      i = j;
      if (this.jdField_a_of_type_JavaUtilList.size() % this.b != 0) {
        return j + 1;
      }
    }
    else
    {
      i = 0;
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
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.b, 1);
    }
    a((ApolloLinearLayout)paramViewGroup, paramInt);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter
 * JD-Core Version:    0.7.0.1
 */