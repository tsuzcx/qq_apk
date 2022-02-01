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
import com.tencent.mobileqq.utils.ViewUtils;
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
  private static int h;
  private BaseChatPie a;
  private Context b;
  private SessionInfo c;
  private ApolloPanel d;
  private ApolloManagerServiceImpl e;
  private ApolloPanelManager f;
  private RelativeLayout g;
  
  public ApolloNewActionFloatViewController(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ApolloPanel paramApolloPanel)
  {
    this.a = paramBaseChatPie;
    this.c = paramSessionInfo;
    this.d = paramApolloPanel;
    this.b = this.d.getContext();
    this.e = ((ApolloManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all"));
    this.f = this.e.getApolloPanelManager();
  }
  
  private Drawable a(ApolloActionData paramApolloActionData)
  {
    Object localObject1 = this.b;
    Object localObject4 = null;
    Object localObject3;
    String str;
    if (localObject1 != null)
    {
      if (paramApolloActionData == null) {
        return null;
      }
      Object localObject2 = ((Context)localObject1).getResources();
      try
      {
        localObject1 = ((Resources)localObject2).getDrawable(2130837994);
        try
        {
          localObject2 = ((Resources)localObject2).getDrawable(2130844865);
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
      localObject3 = null;
      if (paramApolloActionData.status == 0) {
        return localObject1;
      }
      str = Integer.toString(1);
    }
    try
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramApolloActionData.actionId);
      ((StringBuilder)localObject5).append("_");
      ((StringBuilder)localObject5).append(paramApolloActionData.actionName);
      localObject5 = new URL("apollo_pic", null, ((StringBuilder)localObject5).toString());
      localObject4 = localObject5;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject5;
      label153:
      break label153;
    }
    QLog.e("[cmshow]ApolloNewActionFloatViewController", 1, new Object[] { "[getNewActionStaticDrawable] get url exception=", null });
    if (localObject4 == null) {
      return localObject1;
    }
    localObject5 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = localObject3;
    ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = ViewUtils.dip2px(90.0F);
    ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight;
    ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = false;
    localObject1 = URLDrawable.getDrawable(localObject4, (URLDrawable.URLDrawableOptions)localObject5);
    if (((URLDrawable)localObject1).getStatus() != 1)
    {
      ((URLDrawable)localObject1).setTag(paramApolloActionData);
      ((URLDrawable)localObject1).addHeader("apollo_uin", this.a.d.getCurrentUin());
      ((URLDrawable)localObject1).addHeader("apollo_tasks", str);
    }
    return localObject1;
    return null;
  }
  
  @NotNull
  private View.OnClickListener a(int paramInt1, ApolloActionData paramApolloActionData, int paramInt2, String paramString1, String paramString2)
  {
    return new ApolloNewActionFloatViewController.5(this, paramApolloActionData, paramInt1, paramInt2, paramString1, paramString2);
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
          paramButton.setText(this.b.getResources().getString(2131886690));
          paramButton.setOnClickListener(new ApolloNewActionFloatViewController.4(this, paramApolloActionData, paramInt2, paramString1, paramString2));
          return;
        }
        paramButton.setText(HardCodeUtil.a(2131898717));
        paramButton.setOnClickListener(new ApolloNewActionFloatViewController.3(this, paramApolloActionData, paramBundle, paramInt2, paramString1, paramString2));
        return;
      }
      paramButton.setText(HardCodeUtil.a(2131898728));
      paramButton.setOnClickListener(new ApolloNewActionFloatViewController.2(this, paramBundle, paramApolloActionData, paramInt2, paramString1, paramString2));
      return;
    }
    paramButton.setText(HardCodeUtil.a(2131898718));
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
      paramImageView.setImageResource(2130838596);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(this.b.getResources().getString(2131886692));
      return;
    case 27: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838596);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(this.b.getResources().getString(2131886692));
      return;
    case 25: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838574);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131898724));
      return;
    case 23: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838573);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131898716));
      paramImageView = (TextView)this.g.findViewById(2131448924);
      paramImageView.setVisibility(0);
      paramImageView.setText(String.valueOf(paramApolloActionData.currencyNum));
      return;
    case 22: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838572);
      paramTextView.setTextColor(Color.parseColor("#FFFF8444"));
      paramTextView.setText(paramApolloActionData.extraWording);
      return;
    case 21: 
      paramImageView.setVisibility(8);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(HardCodeUtil.a(2131898714));
      return;
    }
    paramImageView.setVisibility(8);
    paramTextView.setTextColor(Color.parseColor("#FF777777"));
    paramTextView.setText(HardCodeUtil.a(2131898723));
  }
  
  private void a(ApolloActionData paramApolloActionData, String paramString)
  {
    if (this.c != null) {
      VipUtils.a(this.a.d, "cmshow", "Apollo", paramString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.c.a), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
    }
  }
  
  private void c()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(2, 2131428491);
    this.d.addView(this.g, localLayoutParams);
  }
  
  @NotNull
  private View.OnClickListener d()
  {
    return new ApolloNewActionFloatViewController.6(this);
  }
  
  private RelativeLayout e()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.b).inflate(2131624174, null);
    localRelativeLayout.setId(2131428471);
    Object localObject = this.b.getResources();
    int i = this.d.getHeight() - this.d.getApolloTab().getHeight();
    if (i < ViewUtils.dip2px(213.0F))
    {
      LinearLayout localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131431295);
      int j = (int)((Resources)localObject).getDimension(2131296740);
      int k = (int)((Resources)localObject).getDimension(2131296741);
      localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
      double d1 = i - j - k;
      Double.isNaN(d1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(0.1D * d1));
      localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localRelativeLayout.findViewById(2131431290)).getLayoutParams();
      Double.isNaN(d1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(d1 * 0.2D));
    }
    return localRelativeLayout;
  }
  
  private void f()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setRepeatCount(0);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.g.startAnimation(localTranslateAnimation);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView]");
    }
    Object localObject = this.g;
    if ((localObject != null) && (((RelativeLayout)localObject).getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView] remove");
      }
      this.d.removeView(this.g);
      this.g = null;
    }
    localObject = this.d.findViewById(2131428471);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView] remove by id");
      }
      this.d.removeView((View)localObject);
    }
  }
  
  public void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, new Object[] { "[showNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((BaseChatPie)localObject1).d != null) && (this.b != null))
    {
      if (paramApolloActionData == null) {
        return;
      }
      localObject1 = this.a.d.getApp();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("apollo_sp");
      ((StringBuilder)localObject2).append(this.a.d.getCurrentUin());
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
      this.g = e();
      ((ImageView)this.g.findViewById(2131435536)).setOnClickListener(d());
      localObject3 = (ImageView)this.g.findViewById(2131435522);
      ApolloMainInfo localApolloMainInfo = new ApolloMainInfo(this.a.d.getCurrentUin());
      localApolloMainInfo.mAction = paramApolloActionData;
      ((ImageView)localObject3).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.g.findViewById(2131448912)).setText(paramApolloActionData.actionName);
      ((TextView)this.g.findViewById(2131448911)).setText(paramApolloActionData.description);
      ((Button)this.g.findViewById(2131429959)).setOnClickListener(a(h, paramApolloActionData, paramInt3, (String)localObject1, str));
      localObject3 = (ImageView)this.g.findViewById(2131435238);
      localObject4 = (TextView)this.g.findViewById(2131448933);
      ((TextView)localObject4).setMaxLines(1);
      a(paramApolloActionData, paramInt2, (ImageView)localObject3, (TextView)localObject4);
      a(paramApolloActionData, paramInt1, paramBundle, localApolloMainInfo, paramInt3, (String)localObject1, str, (Button)this.g.findViewById(2131429787));
      c();
      f();
      a(paramApolloActionData, "action_flame_view");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController
 * JD-Core Version:    0.7.0.1
 */