package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Space;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter.ViewHolder;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelExtendHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class CmShowEmotionAdapter
  extends BaseEmotionAdapter
{
  private static int d;
  private static int e;
  private static int f;
  private static int g;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private IApolloDaoManagerService jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiIApolloDaoManagerService;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CmShowEmotionAdapter.3(this);
  private List<ApolloInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  private int c = -1;
  
  public CmShowEmotionAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Int = 0;
    this.b = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiIApolloDaoManagerService = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all"));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    refreshPanelData();
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getMeasuredHeight();
    Object localObject1 = AIOEmoticonUIHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b());
    int j = 0;
    if ((localObject1 != null) && (((IEmoticonMainPanel)localObject1).getEmoController() != null))
    {
      localObject1 = (IEmoticonPanelExtendHelper)((IEmoticonMainPanel)localObject1).getEmoController().getHelper(1);
      if (localObject1 != null)
      {
        bool = ((IEmoticonPanelExtendHelper)localObject1).isPanelOpen();
        i = ((IEmoticonPanelExtendHelper)localObject1).getOriginPanelHeight() - (int)this.mContext.getResources().getDimension(2131296966);
        break label94;
      }
    }
    boolean bool = false;
    label94:
    localObject1 = new LinearLayout(this.mContext);
    ((LinearLayout)localObject1).setOrientation(1);
    int k = ViewUtils.a(46.0F);
    int m = ViewUtils.a(16.0F);
    int n = ViewUtils.a(14.0F);
    if (bool) {
      j = (paramViewGroup.getMeasuredHeight() - i) / 2;
    }
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, j);
    ((LinearLayout)localObject1).addView(new Space(this.mContext), localLayoutParams1);
    paramViewGroup = new URLImageView(this.mContext);
    paramViewGroup.setId(2131362754);
    i = i - k - m - n;
    Object localObject2 = new LinearLayout.LayoutParams((int)(i / 316.0F * 520.0F), i);
    ((LinearLayout.LayoutParams)localObject2).topMargin = m;
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = n;
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    ((LinearLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new Button(this.mContext);
    ((Button)localObject2).setId(2131362782);
    ((Button)localObject2).setText(2131690036);
    ((Button)localObject2).setBackgroundResource(2130838556);
    ((Button)localObject2).setTextSize(22.0F);
    ((Button)localObject2).setTextColor(-1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, k);
    i = ViewUtils.a(12.0F);
    localLayoutParams2.leftMargin = i;
    localLayoutParams2.rightMargin = i;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams2);
    ((LinearLayout)localObject1).addView(new Space(this.mContext), localLayoutParams1);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject1);
    localObject1 = new ColorDrawable();
    paramViewGroup.setBackgroundDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", (Drawable)localObject1, (Drawable)localObject1));
    ((Button)localObject2).setOnClickListener(new CmShowEmotionAdapter.1(this));
    ApolloDtReportUtil.a("aio", "emojicmtab2d", "expose", new DtReportParamsBuilder().h(EmoticonPanelCmShowHelper.a()).a());
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  private void a(ApolloLinearLayout paramApolloLinearLayout, int paramInt)
  {
    if (paramApolloLinearLayout == null) {
      return;
    }
    paramApolloLinearLayout.a();
    paramApolloLinearLayout.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramApolloLinearLayout.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    paramApolloLinearLayout.setOnSendListener(new CmShowEmotionAdapter.4(this));
    paramApolloLinearLayout = (LinearLayout)paramApolloLinearLayout.getChildAt(0);
    Object localObject1 = (LinearLayout.LayoutParams)paramApolloLinearLayout.getLayoutParams();
    if (localObject1 != null)
    {
      if (paramInt == 0)
      {
        if (this.jdField_a_of_type_Int != 4) {
          ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(16.0F, this.mContext.getResources());
        } else {
          ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        }
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
      if (paramInt == getCount() - 1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(16.0F, this.mContext.getResources());
      }
      if ((paramInt > 0) && (paramInt < getCount() - 1))
      {
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(10.0F, this.mContext.getResources());
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      }
    }
    int m = this.b;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.b)
      {
        localObject1 = paramApolloLinearLayout.getChildAt(i);
        ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)((View)localObject1).getTag();
        int k = paramInt * m + i;
        if (k < this.jdField_a_of_type_JavaUtilList.size())
        {
          ((View)localObject1).setVisibility(0);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k));
          if (this.jdField_a_of_type_Int == 4) {
            localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838555);
          }
          if (((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k)).mAction.isForPlayerAction == 1) {
            QLog.i("[cmshow]CmShowEmotionAdapter", 4, "setBackgroundDrawable getview");
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k)).getPanelDrawable(this.mContext, this.mContext.getResources().getDisplayMetrics().density));
          ApolloActionData localApolloActionData = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(k)).mAction;
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
          if (this.jdField_a_of_type_Int != 4) {
            localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mBinderType = 0;
          }
          if ((this.jdField_a_of_type_Int != 2) && (!TextUtils.isEmpty(localApolloActionData.iconUrl)))
          {
            localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
            localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          }
          if (!TextUtils.isEmpty(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText))
          {
            localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            localViewHolder.e.setVisibility(0);
            localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mActionText);
            if (XPanelContainer.d == 0) {
              j = 1;
            } else {
              j = 0;
            }
            float f1;
            if (j != 0) {
              f1 = 3.0F;
            } else {
              f1 = 5.0F;
            }
            int n = AIOUtils.b(f1, this.mContext.getResources());
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
            ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(f1, this.mContext.getResources());
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
            ((RelativeLayout)localObject2).setPadding(0, 0, 0, AIOUtils.b(f1, this.mContext.getResources()));
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
          int j = this.c;
          if ((j != -1) && (j == k))
          {
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]CmShowEmotionAdapter", 2, new Object[] { "[updateView] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.c), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId) });
            }
            if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
            {
              ((RelativeLayout)localObject2).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
              localViewHolder.jdField_a_of_type_AndroidViewView = null;
            }
            Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131363156);
            ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131363156);
            ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131363156);
            ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131363156);
            RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
            localRelativeLayout.setId(2131362743);
            localRelativeLayout.setBackgroundDrawable(null);
            ((RelativeLayout)localObject2).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject3);
            localViewHolder.jdField_a_of_type_AndroidViewView = localRelativeLayout;
            localObject3 = new ImageView(this.mContext);
            ((ImageView)localObject3).setImageResource(2130838552);
            ((ImageView)localObject3).setVisibility(8);
            localRelativeLayout.addView((View)localObject3, new RelativeLayout.LayoutParams(-1, -1));
            ((ImageView)localObject3).postDelayed(new CmShowEmotionAdapter.5(this, (ImageView)localObject3, localRelativeLayout, (RelativeLayout)localObject2, localViewHolder), 200L);
            this.c = -1;
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
  }
  
  private void a(String paramString1, String paramString2)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      ApolloDtReportUtil.a("panel", paramString1, paramString2, new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateOpenCmShowStatus ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("[cmshow]CmShowEmotionAdapter", 1, ((StringBuilder)localObject).toString());
    if (!paramBoolean)
    {
      QQToast.a(this.mContext, 1, "开启2D厘米秀失败！", 0).b(0);
      a("panel_tips", "fail");
      return;
    }
    QQToast.a(this.mContext, 2, "开启2D厘米秀成功！", 0).b(0);
    a("panel_tips", "success");
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
    refreshPanelData();
    notifyDataSetChanged();
  }
  
  private boolean a()
  {
    return ((ApolloManagerServiceImpl)this.app.getService(IApolloManagerService.class)).getApolloUserStatus() == 1;
  }
  
  private void b()
  {
    QLog.i("[cmshow]CmShowEmotionAdapter", 4, "openCmShow");
    ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("guide_open_cmshow", 0, new CmShowEmotionAdapter.2(this));
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    ApolloDtReportUtil.a("aio", "emojicmtab2d", "click", new DtReportParamsBuilder().h(EmoticonPanelCmShowHelper.a()).a());
  }
  
  public void a()
  {
    boolean bool = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CmShowEmotionAdapter.onShow ");
      localStringBuilder.append(bool);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("[cmshow]CmShowEmotionAdapter", 2, localStringBuilder.toString());
    }
    if (((bool) && (this.jdField_a_of_type_Boolean)) || ((!bool) && (!this.jdField_a_of_type_Boolean))) {
      notifyDataSetChanged();
    }
  }
  
  public void a(ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleCMSPlayerGetFrame : ");
    ((StringBuilder)localObject).append(paramApolloInfo.toString());
    QLog.d("[cmshow]CmShowEmotionAdapter", 4, ((StringBuilder)localObject).toString());
    localObject = (ApolloManagerServiceImpl)this.app.getAppRuntime().getRuntimeService(IApolloManagerService.class, "all");
    if (localObject != null) {
      ((ApolloManagerServiceImpl)localObject).handleCMSPlayerGetFrame("[cmshow]CmShowEmotionAdapter", paramApolloInfo.mAction, new CmShowEmotionAdapter.6(this, paramViewHolder, paramApolloInfo));
    }
  }
  
  public int getCount()
  {
    int i;
    if (a())
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
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
        return 0;
      }
    }
    else
    {
      i = 1;
    }
    return i;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (a())
    {
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("getEmotionView position = ");
          paramView.append(paramInt);
          paramView.append("; view from inflater");
          QLog.d("[cmshow]CmShowEmotionAdapter", 2, paramView.toString());
        }
        paramViewGroup = new ApolloLinearLayout(this.mContext, null, this.jdField_a_of_type_Int, this.columnNum, 1);
        paramViewGroup.setPanelType(1);
      }
      a((ApolloLinearLayout)paramViewGroup, paramInt);
      paramViewGroup.setTag(paramViewHolder);
      this.jdField_a_of_type_Boolean = false;
      return paramViewGroup;
    }
    paramViewHolder = a(paramViewGroup);
    this.jdField_a_of_type_Boolean = true;
    return paramViewHolder;
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new CmShowEmotionAdapter.CmShowEmotionViewHolder();
  }
  
  public void refreshPanelData()
  {
    String str = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject1 != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiIApolloDaoManagerService.getPackageInfoBySession(((SessionInfo)localObject1).jdField_a_of_type_Int);
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((List)localObject1).size() >= 1))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ApolloActionPackage)((Iterator)localObject1).next();
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiIApolloDaoManagerService.getActionByPackageId(((ApolloActionPackage)localObject2).packageId);
        List localList = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiIApolloDaoManagerService.getPackageActionDataById(((ApolloActionPackage)localObject2).packageId);
        if ((localObject3 != null) && (((List)localObject3).size() >= 1))
        {
          if ((localList != null) && (localList.size() >= 1))
          {
            int j = ((List)localObject3).size();
            int i = 0;
            while (i < j)
            {
              localObject2 = new ApolloMainInfo(str);
              ((ApolloInfo)localObject2).mAction = ((ApolloActionData)((List)localObject3).get(i));
              if ((((ApolloInfo)localObject2).mAction != null) && (((ApolloInfo)localObject2).mAction.isForPlayerAction == 1))
              {
                ((ApolloInfo)localObject2).mActionText = ((ApolloActionPackageData)localList.get(i)).text;
                ((ApolloInfo)localObject2).mTextType = ((ApolloActionPackageData)localList.get(i)).textType;
                ((ApolloInfo)localObject2).iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), (ApolloInfo)localObject2, ((ApolloInfo)localObject2).mAction);
                this.jdField_a_of_type_JavaUtilList.add(localObject2);
              }
              i += 1;
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("refreshPanelData : actionInfoList is empty! packageId = ");
            ((StringBuilder)localObject3).append(((ApolloActionPackage)localObject2).packageId);
            QLog.d("[cmshow]CmShowEmotionAdapter", 4, ((StringBuilder)localObject3).toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("refreshPanelData : actionPackageDatas is empty! packageId = ");
          ((StringBuilder)localObject3).append(((ApolloActionPackage)localObject2).packageId);
          QLog.d("[cmshow]CmShowEmotionAdapter", 4, ((StringBuilder)localObject3).toString());
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshPanelData : mActionList size = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("[cmshow]CmShowEmotionAdapter", 4, ((StringBuilder)localObject1).toString());
      return;
    }
    QLog.e("[cmshow]CmShowEmotionAdapter", 4, "refreshPanelData : packageList is empty!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */