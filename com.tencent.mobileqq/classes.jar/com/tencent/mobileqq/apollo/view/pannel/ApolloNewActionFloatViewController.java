package com.tencent.mobileqq.apollo.view.pannel;

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
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
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
  private static int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ApolloPanelManager jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager;
  private ApolloManagerServiceImpl jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl;
  private ApolloPanel jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel;
  
  public ApolloNewActionFloatViewController(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ApolloPanel paramApolloPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel = paramApolloPanel;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext();
    this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl = ((ApolloManagerServiceImpl)paramBaseChatPie.a.getRuntimeService(IApolloManagerService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloPanelManager = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloPanelManager();
  }
  
  private Drawable a(ApolloActionData paramApolloActionData)
  {
    Object localObject5 = null;
    Object localObject4;
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramApolloActionData == null)) {
      localObject4 = null;
    }
    label106:
    do
    {
      Resources localResources;
      do
      {
        return localObject4;
        localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        try
        {
          localObject1 = localResources.getDrawable(2130838121);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Drawable localDrawable;
            String str;
            localObject1 = null;
            QLog.e("ApolloNewActionFloatViewController", 1, "[getNewActionStaticDrawable] exception=", localException1);
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            Object localObject1 = null;
            QLog.e("ApolloNewActionFloatViewController", 1, "[getNewActionStaticDrawable] error=", localOutOfMemoryError1);
            Object localObject3 = null;
          }
        }
        for (;;)
        {
          try
          {
            localDrawable = localResources.getDrawable(2130843990);
            localObject4 = localObject1;
            if (paramApolloActionData.status == 0) {
              break;
            }
            str = Integer.toString(1);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            break label229;
          }
          catch (Exception localException2)
          {
            break label212;
          }
          try
          {
            localObject4 = new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName);
            localObject5 = localObject4;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            QLog.e("ApolloNewActionFloatViewController", 1, new Object[] { "[getNewActionStaticDrawable] get url exception=", null });
            break label106;
          }
        }
        localObject4 = localObject1;
      } while (localObject5 == null);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.a(90.0F, localResources);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight;
      ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = false;
      localObject1 = URLDrawable.getDrawable(localObject5, (URLDrawable.URLDrawableOptions)localObject4);
      localObject4 = localObject1;
    } while (((URLDrawable)localObject1).getStatus() == 1);
    ((URLDrawable)localObject1).setTag(paramApolloActionData);
    ((URLDrawable)localObject1).addHeader("apollo_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentUin());
    ((URLDrawable)localObject1).addHeader("apollo_tasks", str);
    return localObject1;
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
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558711, null);
    localRelativeLayout.setId(2131362841);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getHeight() - this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a().getHeight();
    if (i < AIOUtils.a(213.0F, localResources))
    {
      LinearLayout localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131365270);
      i = i - (int)localResources.getDimension(2131296521) - (int)localResources.getDimension(2131296522);
      ((RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams()).bottomMargin = ((int)(i * 0.1D));
      ((RelativeLayout.LayoutParams)((RelativeLayout)localRelativeLayout.findViewById(2131365265)).getLayoutParams()).bottomMargin = ((int)(i * 0.2D));
    }
    return localRelativeLayout;
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, Bundle paramBundle, ApolloMainInfo paramApolloMainInfo, int paramInt2, String paramString1, String paramString2, Button paramButton)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 0: 
      paramButton.setText(HardCodeUtil.a(2131700551));
      paramButton.setOnClickListener(new ApolloNewActionFloatViewController.1(this, paramApolloMainInfo, paramApolloActionData, paramInt2, paramString1, paramString2));
      return;
    case 1: 
      paramButton.setText(HardCodeUtil.a(2131700561));
      paramButton.setOnClickListener(new ApolloNewActionFloatViewController.2(this, paramBundle, paramApolloActionData, paramInt2, paramString1, paramString2));
      return;
    case 2: 
      paramButton.setText(HardCodeUtil.a(2131700550));
      paramButton.setOnClickListener(new ApolloNewActionFloatViewController.3(this, paramApolloActionData, paramBundle, paramInt2, paramString1, paramString2));
      return;
    }
    paramButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690123));
    paramButton.setOnClickListener(new ApolloNewActionFloatViewController.4(this, paramApolloActionData, paramInt2, paramString1, paramString2));
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt, ImageView paramImageView, TextView paramTextView)
  {
    switch (paramInt)
    {
    case 24: 
    case 26: 
    default: 
      return;
    case 20: 
      paramImageView.setVisibility(8);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131700556));
      return;
    case 21: 
      paramImageView.setVisibility(8);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131700546));
      return;
    case 22: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838669);
      paramTextView.setTextColor(Color.parseColor("#FFFF8444"));
      paramTextView.setText(paramApolloActionData.extraWording);
      return;
    case 23: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838670);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131700548));
      paramImageView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380751);
      paramImageView.setVisibility(0);
      paramImageView.setText(String.valueOf(paramApolloActionData.currencyNum));
      return;
    case 25: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838671);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131700557));
      return;
    case 28: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838692);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690125));
      return;
    }
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130838692);
    paramTextView.setVisibility(0);
    paramTextView.setTextColor(Color.parseColor("#FF777777"));
    paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690125));
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
    localLayoutParams.addRule(2, 2131362861);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
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
      QLog.d("ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView]");
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView] remove");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.findViewById(2131362841);
    if (localView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView] remove by id");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.removeView(localView);
    }
  }
  
  public void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloNewActionFloatViewController", 2, new Object[] { "[showNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramApolloActionData == null)) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentUin(), 0);
    Object localObject4 = String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramInt3) });
    Object localObject5 = ((SharedPreferences)localObject3).getString((String)localObject4, "");
    int i = 0;
    paramInt3 = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    String str = String.format("{\"operateObjectID\":%d}", new Object[] { Integer.valueOf(paramApolloActionData.actionId) });
    if (!TextUtils.isEmpty((CharSequence)localObject5))
    {
      paramInt3 = i;
      localObject1 = localObject2;
    }
    for (;;)
    {
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
        localObject1 = localObject2;
        paramInt3 = i;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloNewActionFloatViewController", 1, "realshowNewActionFloatView Exception:", localThrowable);
        continue;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = a();
      ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368898)).setOnClickListener(a());
      localObject3 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368885);
      localObject2 = new ApolloMainInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.getCurrentUin());
      ((ApolloMainInfo)localObject2).mAction = paramApolloActionData;
      ((ImageView)localObject3).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380741)).setText(paramApolloActionData.actionName);
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380740)).setText(paramApolloActionData.description);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364080)).setOnClickListener(a(jdField_a_of_type_Int, paramApolloActionData, paramInt3, localObject1, str));
      localObject3 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368621);
      localObject4 = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380763);
      ((TextView)localObject4).setMaxLines(1);
      a(paramApolloActionData, paramInt2, (ImageView)localObject3, (TextView)localObject4);
      a(paramApolloActionData, paramInt1, paramBundle, (ApolloMainInfo)localObject2, paramInt3, localObject1, str, (Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363913));
      b();
      c();
      a(paramApolloActionData, "action_flame_view");
      return;
      QLog.e("ApolloNewActionFloatViewController", 1, "realshowNewActionFloatView no tianshu action data");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloNewActionFloatViewController
 * JD-Core Version:    0.7.0.1
 */