package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.net.MalformedURLException;
import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ApolloNewActionFloatViewController
{
  private static int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ApolloPanel jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel;
  private ApolloPanelManager jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager;
  private ApolloManagerServiceImpl jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl;
  
  public ApolloNewActionFloatViewController(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ApolloPanel paramApolloPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel = paramApolloPanel;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.getContext();
    this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl = ((ApolloManagerServiceImpl)paramBaseChatPie.a.getRuntimeService(IApolloManagerService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanelManager = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloPanelManager();
  }
  
  private Drawable a(ApolloActionData paramApolloActionData)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject3 = null;
    Resources localResources;
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      if (paramApolloActionData == null) {
        return null;
      }
      localResources = ((Context)localObject1).getResources();
      try
      {
        localObject1 = localResources.getDrawable(2130837970);
        try
        {
          Drawable localDrawable = localResources.getDrawable(2130843910);
        }
        catch (OutOfMemoryError localOutOfMemoryError1) {}catch (Exception localException1) {}
        QLog.e("[cmshow]ApolloNewActionFloatViewController", 1, "[getNewActionStaticDrawable] exception=", localException2);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localObject1 = null;
        QLog.e("[cmshow]ApolloNewActionFloatViewController", 1, "[getNewActionStaticDrawable] error=", localOutOfMemoryError2);
      }
      catch (Exception localException2)
      {
        localObject1 = null;
      }
      localObject2 = null;
      if (paramApolloActionData.status == 0) {
        return localObject1;
      }
      str = Integer.toString(1);
    }
    try
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramApolloActionData.actionId);
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(paramApolloActionData.actionName);
      localObject4 = new URL("apollo_pic", null, ((StringBuilder)localObject4).toString());
      localObject3 = localObject4;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject4;
      label156:
      break label156;
    }
    QLog.e("[cmshow]ApolloNewActionFloatViewController", 1, new Object[] { "[getNewActionStaticDrawable] get url exception=", null });
    if (localObject3 == null) {
      return localObject1;
    }
    localObject4 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localObject2;
    ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.b(90.0F, localResources);
    ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight;
    ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = false;
    localObject1 = URLDrawable.getDrawable(localObject3, (URLDrawable.URLDrawableOptions)localObject4);
    if (((URLDrawable)localObject1).getStatus() != 1)
    {
      ((URLDrawable)localObject1).setTag(paramApolloActionData);
      ((URLDrawable)localObject1).addHeader("apollo_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentUin());
      ((URLDrawable)localObject1).addHeader("apollo_tasks", str);
    }
    return localObject1;
    return null;
  }
  
  @NotNull
  private View.OnClickListener a()
  {
    return new ApolloNewActionFloatViewController.6(this);
  }
  
  @NotNull
  private View.OnClickListener a(int paramInt1, ApolloActionData paramApolloActionData, int paramInt2, String paramString1, String paramString2)
  {
    return new ApolloNewActionFloatViewController.5(this, paramApolloActionData, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  private RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558610, null);
    localRelativeLayout.setId(2131362785);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.getHeight() - this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.a().getHeight();
    if (i < AIOUtils.b(213.0F, (Resources)localObject))
    {
      LinearLayout localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131365146);
      int j = (int)((Resources)localObject).getDimension(2131296500);
      int k = (int)((Resources)localObject).getDimension(2131296501);
      localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
      double d = i - j - k;
      Double.isNaN(d);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(0.1D * d));
      localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localRelativeLayout.findViewById(2131365142)).getLayoutParams();
      Double.isNaN(d);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(d * 0.2D));
    }
    return localRelativeLayout;
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, Bundle paramBundle, ApolloMainInfo paramApolloMainInfo, int paramInt2, String paramString1, String paramString2, Button paramButton)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 4) {
            return;
          }
          paramButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690040));
          paramButton.setOnClickListener(new ApolloNewActionFloatViewController.4(this, paramApolloActionData, paramInt2, paramString1, paramString2));
          return;
        }
        paramButton.setText(HardCodeUtil.a(2131700691));
        paramButton.setOnClickListener(new ApolloNewActionFloatViewController.3(this, paramApolloActionData, paramBundle, paramInt2, paramString1, paramString2));
        return;
      }
      paramButton.setText(HardCodeUtil.a(2131700702));
      paramButton.setOnClickListener(new ApolloNewActionFloatViewController.2(this, paramBundle, paramApolloActionData, paramInt2, paramString1, paramString2));
      return;
    }
    paramButton.setText(HardCodeUtil.a(2131700692));
    paramButton.setOnClickListener(new ApolloNewActionFloatViewController.1(this, paramApolloMainInfo, paramApolloActionData, paramInt2, paramString1, paramString2));
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt, ImageView paramImageView, TextView paramTextView)
  {
    switch (paramInt)
    {
    case 24: 
    case 26: 
    default: 
      return;
    case 28: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838537);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690042));
      return;
    case 27: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838537);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690042));
      return;
    case 25: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838510);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131700698));
      return;
    case 23: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838509);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131700689));
      paramImageView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380019);
      paramImageView.setVisibility(0);
      paramImageView.setText(String.valueOf(paramApolloActionData.currencyNum));
      return;
    case 22: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838508);
      paramTextView.setTextColor(Color.parseColor("#FFFF8444"));
      paramTextView.setText(paramApolloActionData.extraWording);
      return;
    case 21: 
      paramImageView.setVisibility(8);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131700687));
      return;
    }
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(Color.parseColor("#FF777777"));
    paramTextView.setText(HardCodeUtil.a(2131700697));
  }
  
  private void a(ApolloActionData paramApolloActionData, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "cmshow", "Apollo", paramString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
    }
  }
  
  private void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(2, 2131362805);
    this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
  }
  
  private void c()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setRepeatCount(0);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView]");
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localObject != null) && (((RelativeLayout)localObject).getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView] remove");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.findViewById(2131362785);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView] remove by id");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel.removeView((View)localObject);
    }
  }
  
  public void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, new Object[] { "[showNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject1 != null) && (((BaseChatPie)localObject1).a != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      if (paramApolloActionData == null) {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getApp();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("apollo_sp");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentUin());
      Object localObject3 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
      Object localObject4 = String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramInt3) });
      Object localObject5 = ((SharedPreferences)localObject3).getString((String)localObject4, "");
      localObject2 = null;
      String str = String.format("{\"operateObjectID\":%d}", new Object[] { Integer.valueOf(paramApolloActionData.actionId) });
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        paramInt3 = i;
        localObject1 = localObject2;
        try
        {
          localObject5 = new JSONObject((String)localObject5);
          paramInt3 = i;
          localObject1 = localObject2;
          i = ((JSONObject)localObject5).getInt("adId");
          paramInt3 = i;
          localObject1 = localObject2;
          localObject2 = ((JSONObject)localObject5).getString("traceInfo");
          paramInt3 = i;
          localObject1 = localObject2;
          ApolloTianshuReportUtil.a(101, String.valueOf(i), (String)localObject2, str);
          paramInt3 = i;
          localObject1 = localObject2;
          ((SharedPreferences)localObject3).edit().remove((String)localObject4).commit();
          paramInt3 = i;
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[cmshow]ApolloNewActionFloatViewController", 1, "realshowNewActionFloatView Exception:", localThrowable);
        }
      }
      else
      {
        QLog.e("[cmshow]ApolloNewActionFloatViewController", 1, "realshowNewActionFloatView no tianshu action data");
        localObject1 = null;
        paramInt3 = 0;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = a();
      ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368624)).setOnClickListener(a());
      localObject3 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368610);
      ApolloMainInfo localApolloMainInfo = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentUin());
      localApolloMainInfo.mAction = paramApolloActionData;
      ((ImageView)localObject3).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380009)).setText(paramApolloActionData.actionName);
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380008)).setText(paramApolloActionData.description);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364002)).setOnClickListener(a(jdField_a_of_type_Int, paramApolloActionData, paramInt3, (String)localObject1, str));
      localObject3 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368359);
      localObject4 = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380028);
      ((TextView)localObject4).setMaxLines(1);
      a(paramApolloActionData, paramInt2, (ImageView)localObject3, (TextView)localObject4);
      a(paramApolloActionData, paramInt1, paramBundle, localApolloMainInfo, paramInt3, (String)localObject1, str, (Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363841));
      b();
      c();
      a(paramApolloActionData, "action_flame_view");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController
 * JD-Core Version:    0.7.0.1
 */