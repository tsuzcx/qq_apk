package com.tencent.mobileqq.apollo.api.ui.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter.ViewHolder;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
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
  private IApolloDaoManagerService jdField_a_of_type_ComTencentMobileqqApolloApiDataIApolloDaoManagerService;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CmShowEmotionAdapter.3(this);
  private List<ApolloInfo> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c = -1;
  
  public CmShowEmotionAdapter(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie)
  {
    super(paramIEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Int = 0;
    this.b = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiDataIApolloDaoManagerService = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all"));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    refreshPanelData();
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    int j = 0;
    Object localObject1 = AIOEmoticonUIHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    int i = paramViewGroup.getMeasuredHeight();
    boolean bool;
    if ((localObject1 != null) && (((EmoticonMainPanel)localObject1).getEmoController() != null))
    {
      localObject1 = (EmoticonPanelExtendHelper)((EmoticonMainPanel)localObject1).getEmoController().getHelper(1);
      if (localObject1 != null)
      {
        bool = ((EmoticonPanelExtendHelper)localObject1).isPanelOpen();
        i = ((EmoticonPanelExtendHelper)localObject1).getOriginPanelHeight() - (int)this.mContext.getResources().getDimension(2131296984);
      }
    }
    for (;;)
    {
      localObject1 = new LinearLayout(this.mContext);
      ((LinearLayout)localObject1).setOrientation(1);
      int k = ViewUtils.a(46.0F);
      int m = ViewUtils.a(16.0F);
      int n = ViewUtils.a(14.0F);
      int i1 = i - k - m - n;
      int i2 = (int)(i1 / 316.0F * 520.0F);
      if (bool) {
        j = (paramViewGroup.getMeasuredHeight() - i) / 2;
      }
      Object localObject2 = new Space(this.mContext);
      paramViewGroup = new Space(this.mContext);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, j);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams1);
      localObject2 = new URLImageView(this.mContext);
      ((URLImageView)localObject2).setId(2131362804);
      Object localObject3 = new LinearLayout.LayoutParams(i2, i1);
      ((LinearLayout.LayoutParams)localObject3).topMargin = m;
      ((LinearLayout.LayoutParams)localObject3).bottomMargin = n;
      ((LinearLayout.LayoutParams)localObject3).gravity = 1;
      ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new Button(this.mContext);
      ((Button)localObject3).setId(2131362838);
      ((Button)localObject3).setText(2131690119);
      ((Button)localObject3).setBackgroundResource(2130838711);
      ((Button)localObject3).setTextSize(22.0F);
      ((Button)localObject3).setTextColor(-1);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, k);
      i = ViewUtils.a(12.0F);
      localLayoutParams2.leftMargin = i;
      localLayoutParams2.rightMargin = i;
      ((LinearLayout)localObject1).addView((View)localObject3, localLayoutParams2);
      ((LinearLayout)localObject1).addView(paramViewGroup, localLayoutParams1);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject1);
      paramViewGroup = new ColorDrawable();
      ((URLImageView)localObject2).setBackgroundDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/panel_open_cover_v3.png", paramViewGroup, paramViewGroup));
      ((Button)localObject3).setOnClickListener(new CmShowEmotionAdapter.1(this));
      ApolloDtReportUtil.a("aio", "emojicmtab2d", "expose", null);
      return this.jdField_a_of_type_AndroidViewViewGroup;
      bool = false;
    }
  }
  
  private void a()
  {
    QLog.i("CmShowEmotionAdapter", 4, "openCmShow");
    ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("guide_open_cmshow", 0, new CmShowEmotionAdapter.2(this));
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    ApolloDtReportUtil.a("aio", "emojicmtab2d", "click", null);
  }
  
  private void a(ApolloLinearLayout paramApolloLinearLayout, int paramInt)
  {
    if (paramApolloLinearLayout == null) {}
    Object localObject1;
    label89:
    int k;
    do
    {
      return;
      paramApolloLinearLayout.a();
      paramApolloLinearLayout.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramApolloLinearLayout.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      paramApolloLinearLayout.setOnSendListener(new CmShowEmotionAdapter.4(this));
      paramApolloLinearLayout = (LinearLayout)paramApolloLinearLayout.getChildAt(0);
      localObject1 = (LinearLayout.LayoutParams)paramApolloLinearLayout.getLayoutParams();
      if (localObject1 != null)
      {
        if (paramInt == 0)
        {
          if (this.jdField_a_of_type_Int == 4) {
            break;
          }
          ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(16.0F, this.mContext.getResources());
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        }
        if (paramInt == getCount() - 1) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(16.0F, this.mContext.getResources());
        }
        if ((paramInt > 0) && (paramInt < getCount() - 1))
        {
          ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(10.0F, this.mContext.getResources());
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        }
      }
      k = this.b;
    } while (this.jdField_a_of_type_JavaUtilList == null);
    int i = 0;
    label176:
    ApolloLinearLayout.ViewHolder localViewHolder;
    int j;
    label494:
    float f1;
    label546:
    int n;
    Object localObject2;
    if (i < this.b)
    {
      localObject1 = paramApolloLinearLayout.getChildAt(i);
      localViewHolder = (ApolloLinearLayout.ViewHolder)((View)localObject1).getTag();
      int m = paramInt * k + i;
      if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1502;
      }
      ((View)localObject1).setVisibility(0);
      ApolloActionData localApolloActionData = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).mAction;
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m));
      if (this.jdField_a_of_type_Int == 4) {
        localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838710);
      }
      if (((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).mAction.isForPlayerAction == 1) {
        QLog.i("CmShowEmotionAdapter", 4, "setBackgroundDrawable getview");
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).getPanelDrawable(this.mContext, this.mContext.getResources().getDisplayMetrics().density));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localApolloActionData.actionName);
      if (this.jdField_a_of_type_Int != 4) {
        localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mBinderType = 0;
      }
      if ((this.jdField_a_of_type_Int != 2) && (!TextUtils.isEmpty(localApolloActionData.iconUrl)))
      {
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(String.valueOf(localApolloActionData.iconUrl.hashCode()), null, localApolloActionData.iconUrl, true));
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      if (TextUtils.isEmpty(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText)) {
        break label1433;
      }
      if (XPanelContainer.d != 0) {
        break label1209;
      }
      j = 1;
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localViewHolder.e.setVisibility(0);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mActionText);
      if (j == 0) {
        break label1215;
      }
      f1 = 3.0F;
      n = AIOUtils.a(f1, this.mContext.getResources());
      localObject2 = (RelativeLayout.LayoutParams)localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = n;
      ((RelativeLayout.LayoutParams)localObject2).width = (ApolloLinearLayout.c - n * 2);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.c - n * 3);
      localObject2 = (RelativeLayout.LayoutParams)localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if (j == 0) {
        break label1222;
      }
      f1 = 2.0F;
      label628:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(f1, this.mContext.getResources());
      localViewHolder.e.setBackgroundResource(2130838553);
      if (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mTextType != 1) {
        break label1286;
      }
      if (j == 0) {
        break label1229;
      }
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(8.0F);
      if (f == 0) {
        f = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      }
      ((RelativeLayout.LayoutParams)localObject2).width = f;
      label711:
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      localObject2 = localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (j == 0) {
        break label1426;
      }
      f1 = 3.0F;
      label747:
      ((RelativeLayout)localObject2).setPadding(0, 0, 0, AIOUtils.a(f1, this.mContext.getResources()));
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxLines(3);
      label775:
      ApolloLinearLayout.setApolloActionIcon(localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.iconType, localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction, localViewHolder);
      if ((localApolloActionData.personNum == 1) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))) {
        localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localObject2 = (RelativeLayout)localObject1;
      if ((this.c == -1) || (this.c != m)) {
        break label1475;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmShowEmotionAdapter", 2, new Object[] { "[updateView] highlight item, start animation, mHighlightItemIndex=", Integer.valueOf(this.c), ", name=", localApolloActionData.actionName, ",id=", Integer.valueOf(localApolloActionData.actionId) });
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
      RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
      localRelativeLayout.setId(2131362793);
      localRelativeLayout.setBackgroundDrawable(null);
      ((RelativeLayout)localObject2).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject3);
      localViewHolder.jdField_a_of_type_AndroidViewView = localRelativeLayout;
      localObject3 = new ImageView(this.mContext);
      ((ImageView)localObject3).setImageResource(2130838707);
      ((ImageView)localObject3).setVisibility(8);
      localRelativeLayout.addView((View)localObject3, new RelativeLayout.LayoutParams(-1, -1));
      ((ImageView)localObject3).postDelayed(new CmShowEmotionAdapter.5(this, (ImageView)localObject3, localRelativeLayout, (RelativeLayout)localObject2, localViewHolder), 200L);
      this.c = -1;
      label1117:
      ((View)localObject1).setContentDescription(localApolloActionData.actionName);
      if ((((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).mAction != null) && (((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m)).mAction.isForPlayerAction == 1)) {
        a(localViewHolder, (ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(m));
      }
    }
    for (;;)
    {
      i += 1;
      break label176;
      break;
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      break label89;
      label1209:
      j = 0;
      break label494;
      label1215:
      f1 = 5.0F;
      break label546;
      label1222:
      f1 = 5.0F;
      break label628;
      label1229:
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxHeight(ApolloLinearLayout.c - n * 2);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      if (d == 0) {
        d = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
      }
      ((RelativeLayout.LayoutParams)localObject2).width = d;
      break label711;
      label1286:
      if (j != 0)
      {
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextSize(7.0F);
        if (g == 0) {
          g = ApolloBarrageUtil.a(localViewHolder.jdField_c_of_type_AndroidWidgetTextView.getPaint());
        }
        ((RelativeLayout.LayoutParams)localObject2).width = g;
        label1330:
        localObject2 = localViewHolder.jdField_c_of_type_AndroidWidgetTextView;
        if (j == 0) {
          break label1419;
        }
      }
      label1419:
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
        break label1330;
      }
      label1426:
      f1 = 9.0F;
      break label747;
      label1433:
      localViewHolder.e.setBackgroundDrawable(null);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localViewHolder.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localViewHolder.e.setVisibility(8);
      break label775;
      label1475:
      if (localViewHolder.jdField_a_of_type_AndroidViewView == null) {
        break label1117;
      }
      ((RelativeLayout)localObject2).removeView(localViewHolder.jdField_a_of_type_AndroidViewView);
      localViewHolder.jdField_a_of_type_AndroidViewView = null;
      break label1117;
      label1502:
      ((View)localObject1).setContentDescription(null);
      ((View)localObject1).setOnClickListener(null);
      ((View)localObject1).setVisibility(4);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      ApolloDtReportUtil.a("panel", paramString1, paramString2, new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    QLog.i("CmShowEmotionAdapter", 1, "updateOpenCmShowStatus " + paramBoolean + ", " + paramInt);
    if (!paramBoolean)
    {
      QQToast.a(this.mContext, 1, "开启2D厘米秀失败！", 0).b(0);
      a("panel_tips", "fail");
      return;
    }
    QQToast.a(this.mContext, 2, "开启2D厘米秀成功！", 0).b(0);
    a("panel_tips", "success");
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    refreshPanelData();
    notifyDataSetChanged();
  }
  
  private boolean a()
  {
    return ((ApolloManagerServiceImpl)this.app.getService(IApolloManagerService.class)).getApolloUserStatus((QQAppInterface)this.app.getQQAppInterface()) == 1;
  }
  
  public void a(ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo)
  {
    QLog.d("CmShowEmotionAdapter", 4, "handleCMSPlayerGetFrame : " + paramApolloInfo.toString());
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.app.getAppRuntime().getRuntimeService(IApolloManagerService.class, "all");
    if (localIApolloManagerService != null) {
      localIApolloManagerService.handleCMSPlayerGetFrame("CmShowEmotionAdapter", paramApolloInfo.mAction, new CmShowEmotionAdapter.6(this, paramViewHolder, paramApolloInfo));
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (a())
    {
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
    return 1;
  }
  
  public View getEmotionView(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (a())
    {
      if ((paramView != null) && (paramView.getTag() != null)) {
        break label106;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmShowEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      paramView = new ApolloLinearLayout(this.mContext, null, this.jdField_a_of_type_Int, this.columnNum, 1);
      paramView.setPanelType(1);
    }
    label106:
    for (;;)
    {
      a((ApolloLinearLayout)paramView, paramInt);
      paramView.setTag(paramViewHolder);
      return paramView;
      return a(paramViewGroup);
    }
  }
  
  public BaseEmotionAdapter.ViewHolder newHolder()
  {
    return new CmShowEmotionAdapter.CmShowEmotionViewHolder();
  }
  
  public void refreshPanelData()
  {
    String str = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataIApolloDaoManagerService.getPackageInfoBySession(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((localObject1 == null) || (((List)localObject1).size() < 1))
    {
      QLog.e("CmShowEmotionAdapter", 4, "refreshPanelData : packageList is empty!");
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ApolloActionPackage)((Iterator)localObject1).next();
      List localList1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataIApolloDaoManagerService.getActionByPackageId(((ApolloActionPackage)localObject2).packageId);
      List localList2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiDataIApolloDaoManagerService.getPackageActionDataById(((ApolloActionPackage)localObject2).packageId);
      if ((localList1 == null) || (localList1.size() < 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmShowEmotionAdapter", 4, "refreshPanelData : actionPackageDatas is empty! packageId = " + ((ApolloActionPackage)localObject2).packageId);
        }
      }
      else if ((localList2 == null) || (localList2.size() < 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmShowEmotionAdapter", 4, "refreshPanelData : actionInfoList is empty! packageId = " + ((ApolloActionPackage)localObject2).packageId);
        }
      }
      else
      {
        int j = localList1.size();
        int i = 0;
        while (i < j)
        {
          localObject2 = new ApolloMainInfo(str);
          ((ApolloInfo)localObject2).mAction = ((ApolloActionData)localList1.get(i));
          if ((((ApolloInfo)localObject2).mAction != null) && (((ApolloInfo)localObject2).mAction.isForPlayerAction == 1))
          {
            ((ApolloInfo)localObject2).mActionText = ((ApolloActionPackageData)localList2.get(i)).text;
            ((ApolloInfo)localObject2).mTextType = ((ApolloActionPackageData)localList2.get(i)).textType;
            ((ApolloInfo)localObject2).iconType = ApolloPanelUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ApolloInfo)localObject2, ((ApolloInfo)localObject2).mAction);
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
          i += 1;
        }
      }
    }
    QLog.d("CmShowEmotionAdapter", 4, "refreshPanelData : mActionList size = " + this.jdField_a_of_type_JavaUtilList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.impl.CmShowEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */