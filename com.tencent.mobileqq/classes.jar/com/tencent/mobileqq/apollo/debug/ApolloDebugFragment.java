package com.tencent.mobileqq.apollo.debug;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.screenshot.ApolloCoderResource;
import com.tencent.mobileqq.apollo.screenshot.ApolloCoderResource.Companion;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloDebugFragment
  extends QIphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  private FormSwitchItem A;
  private FormSwitchItem B;
  private FormSwitchItem C;
  private FormSwitchItem D;
  private FormSwitchItem E;
  private FormSwitchItem F;
  private FormSwitchItem G;
  private FormSwitchItem H;
  private FormSwitchItem I;
  private FormSwitchItem J;
  private FormSwitchItem K;
  private FormSwitchItem L;
  private FormSwitchItem M;
  private SharedPreferences a;
  private SharedPreferences b = null;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem w;
  private FormSwitchItem x;
  private FormSwitchItem y;
  private FormSwitchItem z;
  
  private void b()
  {
    ThreadManager.excute(new ApolloDebugFragment.3(this), 64, null, true);
  }
  
  protected int a()
  {
    return 2131624181;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4);
    this.a = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_test", 0);
    this.c = ((FormSwitchItem)this.t.findViewById(2131428459));
    this.c.setContentDescription("厘米秀内网环境代理");
    this.c.setChecked(((IApolloUtil)QRoute.api(IApolloUtil.class)).isApolloProxyEnable());
    this.c.setOnCheckedChangeListener(this);
    this.d = ((FormSwitchItem)this.t.findViewById(2131428417));
    this.d.setContentDescription("厘米秀动作素材删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    this.d.setChecked(paramLayoutInflater.exists() ^ true);
    this.d.setOnCheckedChangeListener(this);
    this.e = ((FormSwitchItem)this.t.findViewById(2131428481));
    this.e.setContentDescription("厘米秀脚本文件删除");
    paramLayoutInflater = new File(ApolloConstant.V);
    this.e.setChecked(paramLayoutInflater.exists() ^ true);
    this.e.setOnCheckedChangeListener(this);
    this.f = ((FormSwitchItem)this.t.findViewById(2131428432));
    this.f.setContentDescription("厘米秀表情缓存删除");
    paramLayoutInflater = new File(ApolloCoderResource.a.a());
    this.f.setChecked(paramLayoutInflater.exists() ^ true);
    this.f.setOnCheckedChangeListener(this);
    this.g = ((FormSwitchItem)this.t.findViewById(2131428443));
    this.g.setContentDescription("厘米秀装扮素材删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
    this.g.setChecked(paramLayoutInflater.exists() ^ true);
    this.g.setOnCheckedChangeListener(this);
    this.w = ((FormSwitchItem)this.t.findViewById(2131428479));
    this.w.setContentDescription("厘米秀角色素材删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
    this.w.setChecked(paramLayoutInflater.exists() ^ true);
    this.w.setOnCheckedChangeListener(this);
    this.x = ((FormSwitchItem)this.t.findViewById(2131428452));
    this.x.setContentDescription("厘米秀游戏资源包删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    this.x.setChecked(paramLayoutInflater.exists() ^ true);
    this.x.setOnCheckedChangeListener(this);
    this.y = ((FormSwitchItem)this.t.findViewById(2131428457));
    this.y.setContentDescription("厘米秀游戏资源校验和更新");
    this.y.setChecked(this.b.getBoolean("game_whitelist_verify_switch", true));
    this.y.setOnCheckedChangeListener(this);
    this.z = ((FormSwitchItem)this.t.findViewById(2131428492));
    this.z.setContentDescription("厘米秀3d表情包测试");
    this.z.setTag(Integer.valueOf(1));
    this.z.setChecked(this.a.getBoolean("test_3d_action", false));
    this.z.setOnCheckedChangeListener(this);
    this.A = ((FormSwitchItem)this.t.findViewById(2131428480));
    this.A.setContentDescription("厘米秀新角色测试");
    this.A.setChecked(this.a.getBoolean("test_new_role", false));
    this.A.setOnCheckedChangeListener(this);
    this.B = ((FormSwitchItem)this.t.findViewById(2131428482));
    this.B.setContentDescription("厘米秀抽屉页大人物");
    this.B.setChecked(this.a.getBoolean("test_settingme_size_big", false));
    this.B.setOnCheckedChangeListener(this);
    this.C = ((FormSwitchItem)this.t.findViewById(2131428476));
    this.C.setContentDescription("厘米秀新人物细眉毛");
    this.C.setChecked(this.a.getBoolean("test_role_eyebrow", false));
    this.C.setOnCheckedChangeListener(this);
    this.D = ((FormSwitchItem)this.t.findViewById(2131428478));
    this.D.setContentDescription("厘米秀新人物光头");
    this.D.setChecked(this.a.getBoolean("test_role_no_hair", false));
    this.D.setOnCheckedChangeListener(this);
    this.E = ((FormSwitchItem)this.t.findViewById(2131428477));
    this.E.setContentDescription("厘米秀新人物不显示睫毛");
    this.E.setChecked(this.a.getBoolean("test_role_no_eyelash", false));
    this.E.setOnCheckedChangeListener(this);
    this.F = ((FormSwitchItem)this.t.findViewById(2131428500));
    this.F.setChecked(this.a.getBoolean("test_ce_use_beta_res", false));
    this.F.setOnCheckedChangeListener(this);
    this.G = ((FormSwitchItem)this.t.findViewById(2131428494));
    this.G.setChecked(CMShowPlatform.a.b(Scene.AIO));
    this.G.setOnCheckedChangeListener(this);
    this.H = ((FormSwitchItem)this.t.findViewById(2131428495));
    this.H.setChecked(CMShowPlatform.a.b(Scene.AIO_BACKGROUND));
    this.H.setOnCheckedChangeListener(this);
    this.I = ((FormSwitchItem)this.t.findViewById(2131428496));
    this.I.setChecked(CMShowPlatform.a.b(Scene.DRAWER));
    this.I.setOnCheckedChangeListener(this);
    this.J = ((FormSwitchItem)this.t.findViewById(2131428497));
    this.J.setChecked(CMShowPlatform.a.b(Scene.FRIEND_CARD));
    this.J.setOnCheckedChangeListener(this);
    this.K = ((FormSwitchItem)this.t.findViewById(2131428498));
    this.K.setChecked(CMShowPlatform.a.b(Scene.MEME_PLAYER));
    this.K.setOnCheckedChangeListener(this);
    this.L = ((FormSwitchItem)this.t.findViewById(2131428499));
    this.L.setChecked(this.a.getBoolean("test_ce_meme_player_save_frame_callback", false));
    this.L.setOnCheckedChangeListener(this);
    this.M = ((FormSwitchItem)this.t.findViewById(2131428493));
    this.M.setChecked(this.a.getBoolean("test_ce_makeup", false));
    this.M.setOnCheckedChangeListener(this);
    ((TextView)this.t.findViewById(2131428501)).setOnClickListener(new ApolloDebugFragment.1(this));
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.equals(this.c.getSwitch()))
    {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).setApolloProxyEnable(paramBoolean);
      return;
    }
    if (paramCompoundButton.equals(this.d.getSwitch()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
        QQToast.makeText(getActivity(), HardCodeUtil.a(2131902200), 1).show();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "apolloResourceUpdate delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.e.getSwitch()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory(ApolloConstant.V);
        QQToast.makeText(getActivity(), HardCodeUtil.a(2131902184), 1).show();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "apolloScriptUpdate delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.f.getSwitch()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory(ApolloCoderResource.a.a());
        QQToast.makeText(getActivity(), 2131888420, 1).show();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "apolloApngCacheFile delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.g.getSwitch()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
        QQToast.makeText(getActivity(), HardCodeUtil.a(2131902189), 1).show();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "deleteDressItem delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.w.getSwitch()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
        QQToast.makeText(getActivity(), HardCodeUtil.a(2131902195), 1).show();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "deleteRoleItem delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.x.getSwitch()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
        QQToast.makeText(getActivity(), HardCodeUtil.a(2131902194), 1).show();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "deleteGameItem delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.y.getSwitch()))
    {
      this.b.edit().putBoolean("game_whitelist_verify_switch", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.z.getSwitch()))
    {
      this.a.edit().putBoolean("test_3d_action", paramBoolean).commit();
      FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      return;
    }
    if (paramCompoundButton.equals(this.A.getSwitch()))
    {
      this.a.edit().putBoolean("test_new_role", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.B.getSwitch()))
    {
      this.a.edit().putBoolean("test_settingme_size_big", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.C.getSwitch()))
    {
      this.a.edit().putBoolean("test_role_eyebrow", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.D.getSwitch()))
    {
      this.a.edit().putBoolean("test_role_no_hair", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.E.getSwitch()))
    {
      this.a.edit().putBoolean("test_role_no_eyelash", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.F.getSwitch()))
    {
      this.a.edit().putBoolean("test_ce_use_beta_res", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.G.getSwitch()))
    {
      this.a.edit().putBoolean(Scene.AIO.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.H.getSwitch()))
    {
      this.a.edit().putBoolean(Scene.AIO_BACKGROUND.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.J.getSwitch()))
    {
      this.a.edit().putBoolean(Scene.FRIEND_CARD.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.I.getSwitch()))
    {
      this.a.edit().putBoolean(Scene.DRAWER.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.K.getSwitch()))
    {
      this.a.edit().putBoolean(Scene.MEME_PLAYER.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.L.getSwitch()))
    {
      b();
      this.a.edit().putBoolean("test_ce_meme_player_save_frame_callback", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.M.getSwitch())) {
      this.a.edit().putBoolean("test_ce_makeup", paramBoolean).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.ApolloDebugFragment
 * JD-Core Version:    0.7.0.1
 */