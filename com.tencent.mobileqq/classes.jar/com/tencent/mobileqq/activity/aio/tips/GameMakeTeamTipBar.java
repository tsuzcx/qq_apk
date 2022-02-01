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
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper == null)
    {
      b(paramTeamInfoWrapper);
      return;
    }
    if (!QQGamePubAIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo).equals(QQGamePubAIOHelper.a(paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo)))
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
    Drawable localDrawable = paramImageView.getContext().getResources().getDrawable(2130840535);
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private boolean a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper != null) && (paramTeamInfo.msg_seq.get().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.msg_seq.get())) && (paramTeamInfo.status.get() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.status.get()) && (paramTeamInfo.main_text.get().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.main_text.get())) && (paramTeamInfo.sub_text.get().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.sub_text.get())) && (paramTeamInfo.jump_url.get().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.jump_url.get())) && (paramTeamInfo.icons.get().size() == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.get().size()))
    {
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < paramTeamInfo.icons.get().size())
        {
          String str = (String)paramTeamInfo.icons.get().get(i);
          if ((str != null) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.get().get(i)))) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private void b(GameMakeTeamTipBar.TeamInfoWrapper paramTeamInfoWrapper)
  {
    try
    {
      paramTeamInfoWrapper.jdField_a_of_type_Long = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(4), "8");
      localHashMap.put(Integer.valueOf(2), paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.team_id.get());
      JSONObject localJSONObject;
      if (paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get() == null)
      {
        str = "";
        localHashMap.put(Integer.valueOf(6), str);
        localJSONObject = new JSONObject();
        localJSONObject.put("groupid", paramTeamInfoWrapper.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("battletype", paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.sub_text.get().replace("|", "-"));
        if (!TextUtils.isEmpty(paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get())) {
          break label261;
        }
      }
      label261:
      for (String str = "1";; str = "2")
      {
        localJSONObject.put("roomtype", str);
        localJSONObject.put("roomnum", paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.size() + "");
        localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
        GameCenterUtils.a(CmGameUtil.a(), "1006", "207623", paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.appid.get(), "100601", "1", "145", localHashMap);
        return;
        str = paramTeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
        break;
      }
      return;
    }
    catch (Throwable paramTeamInfoWrapper)
    {
      QLog.e("GameMakeTeamTipBar", 1, paramTeamInfoWrapper, new Object[0]);
    }
  }
  
  @TargetApi(19)
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372715));
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("GameMakeTeamTipBar", 2, "initBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
  }
  
  private void e()
  {
    d();
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131372638);
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) || (ThemeUtil.isSimpleDayTheme(false)))
    {
      localView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("GameMakeTeamTipBar", 2, "showBlurView() visibility called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      return;
    }
    localView.setBackgroundColor(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131167005));
    localView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("GameMakeTeamTipBar", 2, "showBlurView() gone called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
  }
  
  private void f()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(4), "20");
      localHashMap.put(Integer.valueOf(2), this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.team_id.get());
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get() == null)
      {
        str = "";
        localHashMap.put(Integer.valueOf(6), str);
        localJSONObject = new JSONObject();
        localJSONObject.put("groupid", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("battletype", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.sub_text.get().replace("|", "-"));
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get())) {
          break label273;
        }
      }
      label273:
      for (String str = "1";; str = "2")
      {
        localJSONObject.put("roomtype", str);
        localJSONObject.put("roomnum", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.size() + "");
        localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
        GameCenterUtils.a(CmGameUtil.a(), "1006", "207624", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.appid.get(), "100601", "1", "145", localHashMap);
        return;
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
        break;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameMakeTeamTipBar", 1, localThrowable, new Object[0]);
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()).inflate(2131559292, null);
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
    if (QLog.isColorLevel()) {
      QLog.i("GameMakeTeamTipBar", 1, "initView..view:" + this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838066);
    e();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379630));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379629));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131379628).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377149));
    this.jdField_b_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377150));
    this.jdField_c_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377151));
    this.d = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377152));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367108));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380638));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377243));
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
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get() == null)
        {
          String str1 = "";
          localHashMap.put(Integer.valueOf(6), str1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("groupid", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("battletype", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.sub_text.get().replace("|", "-"));
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get())) {
            break label391;
          }
          str1 = "1";
          localJSONObject.put("roomtype", str1);
          localJSONObject.put("roomnum", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.icons.size() + "");
          localJSONObject.put("disapres", paramInt + "");
          localJSONObject.put("existtime", l + "");
          localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
          GameCenterUtils.a(CmGameUtil.a(), "1006", "207698", this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.appid.get(), "100601", "1", "145", localHashMap);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper = null;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameMakeTeamTipBar", 1, localThrowable, new Object[0]);
        return;
      }
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper.jdField_a_of_type_TencentImQqgameQQGameMakeTeamInfo$TeamInfo.subscribe_id.get();
      continue;
      label391:
      str2 = "2";
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
        if (QLog.isColorLevel()) {
          QLog.d("GameMakeTeamTipBar", 2, "resumeBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 1003) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
      } while (!QLog.isColorLevel());
      QLog.d("GameMakeTeamTipBar", 2, "pauseBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      return;
    } while (paramInt != 1004);
    c();
  }
  
  public void a(QQGameMakeTeamInfo.TeamInfo paramTeamInfo, SessionInfo paramSessionInfo)
  {
    for (;;)
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
        List localList = paramTeamInfo.icons.get();
        int i = localList.size();
        if ((i > 0) && (!TextUtils.isEmpty((CharSequence)localList.get(0))))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          a((String)localList.get(0), this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView);
        }
        if ((i > 1) && (!TextUtils.isEmpty((CharSequence)localList.get(1)))) {
          a((String)localList.get(1), this.jdField_b_of_type_ComTencentMobileqqWidgetRoundImageView);
        }
        if ((i > 2) && (!TextUtils.isEmpty((CharSequence)localList.get(2))))
        {
          a((String)localList.get(2), this.jdField_c_of_type_ComTencentMobileqqWidgetRoundImageView);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          if (i > 3)
          {
            this.d.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setText("+" + (i - 2));
          }
        }
        else
        {
          paramTeamInfo = new GameMakeTeamTipBar.TeamInfoWrapper(paramTeamInfo, paramSessionInfo);
          a(paramTeamInfo);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsGameMakeTeamTipBar$TeamInfoWrapper = paramTeamInfo;
          return;
        }
      }
      catch (Throwable paramTeamInfo)
      {
        throw new Exception(paramTeamInfo);
      }
      this.d.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372715));
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      if (QLog.isColorLevel()) {
        QLog.d("GameMakeTeamTipBar", 2, "destroyBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GameMakeTeamTipBar
 * JD-Core Version:    0.7.0.1
 */