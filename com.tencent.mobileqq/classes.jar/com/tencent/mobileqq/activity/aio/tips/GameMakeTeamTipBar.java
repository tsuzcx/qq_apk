package com.tencent.mobileqq.activity.aio.tips;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameMakeTeamInfo.TeamInfo;

public class GameMakeTeamTipBar
  implements View.OnClickListener, TipsBarTask
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected BaseChatPie a;
  private GameMakeTeamTipBar.TeamInfoWrapper jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_b_of_type_ComTencentMobileqqWidgetRoundImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_c_of_type_ComTencentMobileqqWidgetRoundImageView;
  private RoundImageView d;
  
  public GameMakeTeamTipBar(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private GradientDrawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setGradientType(0);
    localGradientDrawable.setShape(1);
    int i = Color.parseColor("#FFD5B8");
    int j = Color.parseColor("#FDA05D");
    if (Build.VERSION.SDK_INT >= 16)
    {
      localGradientDrawable.setColors(new int[] { i, j });
      localGradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
      return localGradientDrawable;
    }
    localGradientDrawable.setColor(Color.parseColor("#FDA05D"));
    return localGradientDrawable;
  }
  
  private void a(GameMakeTeamTipBar.TeamInfoWrapper paramTeamInfoWrapper)
  {
    GameMakeTeamTipBar.TeamInfoWrapper localTeamInfoWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper;
    if (localTeamInfoWrapper == null)
    {
      b(paramTeamInfoWrapper);
      return;
    }
    if (!QQGamePubAIOHelper.a(localTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo).equals(QQGamePubAIOHelper.a(paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo)))
    {
      a(2);
      b(paramTeamInfoWrapper);
      return;
    }
    paramTeamInfoWrapper.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_Long;
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != BaseActivity.sTopActivity) {
      return;
    }
    paramImageView.setVisibility(0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramImageView.getContext().getResources().getDrawable(2130840405);
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private boolean a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper != null) && (paramTeamInfo.msg_seq.get().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.msg_seq.get())) && (paramTeamInfo.status.get() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.status.get()) && (paramTeamInfo.main_text.get().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.main_text.get())) && (paramTeamInfo.sub_text.get().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.sub_text.get())) && (paramTeamInfo.jump_url.get().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.jump_url.get())) && (paramTeamInfo.icons.get().size() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.get().size()))
    {
      int i = 0;
      while (i < paramTeamInfo.icons.get().size())
      {
        String str = (String)paramTeamInfo.icons.get().get(i);
        if ((str != null) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.get().get(i)))) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  private void b(GameMakeTeamTipBar.TeamInfoWrapper paramTeamInfoWrapper)
  {
    for (;;)
    {
      try
      {
        paramTeamInfoWrapper.jdField_a_of_type_Long = System.currentTimeMillis();
        HashMap localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(4), "8");
        localHashMap.put(Integer.valueOf(2), paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.team_id.get());
        localObject = paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
        }
        localHashMap.put(Integer.valueOf(6), localObject);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("groupid", paramTeamInfoWrapper.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("battletype", paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.sub_text.get().replace("|", "-"));
        if (TextUtils.isEmpty(paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get()))
        {
          localObject = "1";
          localJSONObject.put("roomtype", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.size());
          ((StringBuilder)localObject).append("");
          localJSONObject.put("roomnum", ((StringBuilder)localObject).toString());
          localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
          GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207623", paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.appid.get(), "100601", "1", "145", localHashMap);
          return;
        }
      }
      catch (Throwable paramTeamInfoWrapper)
      {
        QLog.e("GameMakeTeamTipBar", 1, paramTeamInfoWrapper, new Object[0]);
        return;
      }
      Object localObject = "2";
    }
  }
  
  @TargetApi(19)
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372292));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null)
    {
      ((QQBlurView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      ((QQBlurView)localObject).b((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        QLog.d("GameMakeTeamTipBar", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void e()
  {
    d();
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131372219);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131167028));
      ((View)localObject).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showBlurView() gone called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        QLog.d("GameMakeTeamTipBar", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
      return;
    }
    ((View)localObject).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() visibility called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      QLog.d("GameMakeTeamTipBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(4), "20");
        localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.team_id.get());
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
        }
        localHashMap.put(Integer.valueOf(6), localObject);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("groupid", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("battletype", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.sub_text.get().replace("|", "-"));
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get()))
        {
          localObject = "1";
          localJSONObject.put("roomtype", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.size());
          ((StringBuilder)localObject).append("");
          localJSONObject.put("roomnum", ((StringBuilder)localObject).toString());
          localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
          GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207624", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.appid.get(), "100601", "1", "145", localHashMap);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameMakeTeamTipBar", 1, localThrowable, new Object[0]);
        return;
      }
      String str = "2";
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()).inflate(2131559166, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public GameMakeTeamTipBar.TeamInfoWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initView..view:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidViewView);
      QLog.i("GameMakeTeamTipBar", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837913);
    e();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378974));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378973));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131378972).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376630));
    this.jdField_b_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376631));
    this.jdField_c_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376632));
    this.d = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376633));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366945));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379919));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376701));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper = null;
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper == null) {
          return;
        }
        long l = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_Long) / 1000L;
        HashMap localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(4), "18");
        localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.team_id.get());
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
        }
        localHashMap.put(Integer.valueOf(6), localObject);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("groupid", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("battletype", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.sub_text.get().replace("|", "-"));
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get()))
        {
          localObject = "1";
          localJSONObject.put("roomtype", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.size());
          ((StringBuilder)localObject).append("");
          localJSONObject.put("roomnum", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append("");
          localJSONObject.put("disapres", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("");
          localJSONObject.put("existtime", ((StringBuilder)localObject).toString());
          localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
          GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207698", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.appid.get(), "100601", "1", "145", localHashMap);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper = null;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameMakeTeamTipBar", 1, localThrowable, new Object[0]);
        return;
      }
      String str = "2";
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000)
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (paramVarArgs != null)
      {
        paramVarArgs.a();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("resumeBlurView called mBlurBgView = ");
          paramVarArgs.append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
          QLog.d("GameMakeTeamTipBar", 2, paramVarArgs.toString());
        }
      }
    }
    else if (paramInt == 1003)
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (paramVarArgs != null)
      {
        paramVarArgs.b();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("pauseBlurView called mBlurBgView = ");
          paramVarArgs.append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
          QLog.d("GameMakeTeamTipBar", 2, paramVarArgs.toString());
        }
      }
    }
    else if (paramInt == 1004)
    {
      c();
    }
  }
  
  public void a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo, SessionInfo paramSessionInfo)
  {
    try
    {
      if (!a(paramTeamInfo)) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTeamInfo.main_text.get());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramTeamInfo.sub_text.get());
      this.jdField_a_of_type_JavaLangString = paramTeamInfo.jump_url.get();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetRoundImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      Object localObject = paramTeamInfo.icons.get();
      int i = ((List)localObject).size();
      if ((i > 0) && (!TextUtils.isEmpty((CharSequence)((List)localObject).get(0))))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        a((String)((List)localObject).get(0), this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView);
      }
      if ((i > 1) && (!TextUtils.isEmpty((CharSequence)((List)localObject).get(1)))) {
        a((String)((List)localObject).get(1), this.jdField_b_of_type_ComTencentMobileqqWidgetRoundImageView);
      }
      if ((i > 2) && (!TextUtils.isEmpty((CharSequence)((List)localObject).get(2))))
      {
        a((String)((List)localObject).get(2), this.jdField_c_of_type_ComTencentMobileqqWidgetRoundImageView);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        if (i > 3)
        {
          this.d.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          localObject = this.jdField_c_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("+");
          localStringBuilder.append(i - 2);
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
        else
        {
          this.d.setVisibility(4);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
      paramTeamInfo = new GameMakeTeamTipBar.TeamInfoWrapper(paramTeamInfo, paramSessionInfo);
      a(paramTeamInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper = paramTeamInfo;
      return;
    }
    catch (Throwable paramTeamInfo)
    {
      throw new Exception(paramTeamInfo);
    }
  }
  
  public int[] a()
  {
    return new int[0];
  }
  
  public int b()
  {
    return 30;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper = null;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper = null;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372292));
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("destroyBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        QLog.d("GameMakeTeamTipBar", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) >= 500L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), QQBrowserActivity.class);
        localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
        localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().startActivity(localIntent);
        f();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GameMakeTeamTipBar
 * JD-Core Version:    0.7.0.1
 */