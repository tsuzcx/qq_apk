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
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences = null;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  private FormSwitchItem j;
  private FormSwitchItem k;
  private FormSwitchItem l;
  private FormSwitchItem m;
  private FormSwitchItem n;
  private FormSwitchItem o;
  private FormSwitchItem p;
  private FormSwitchItem q;
  private FormSwitchItem r;
  private FormSwitchItem s;
  private FormSwitchItem t;
  private FormSwitchItem u;
  
  private void a()
  {
    ThreadManager.excute(new ApolloDebugFragment.2(this), 64, null, true);
  }
  
  protected int a()
  {
    return 2131558617;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_test", 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362773));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("厘米秀内网环境代理");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((IApolloUtil)QRoute.api(IApolloUtil.class)).isApolloProxyEnable());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362731));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("厘米秀动作素材删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramLayoutInflater.exists() ^ true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.c = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362794));
    this.c.setContentDescription("厘米秀脚本文件删除");
    paramLayoutInflater = new File(ApolloConstant.N);
    this.c.setChecked(paramLayoutInflater.exists() ^ true);
    this.c.setOnCheckedChangeListener(this);
    this.d = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362746));
    this.d.setContentDescription("厘米秀表情缓存删除");
    paramLayoutInflater = new File(ApolloCoderResource.a.a());
    this.d.setChecked(paramLayoutInflater.exists() ^ true);
    this.d.setOnCheckedChangeListener(this);
    this.e = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362757));
    this.e.setContentDescription("厘米秀装扮素材删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
    this.e.setChecked(paramLayoutInflater.exists() ^ true);
    this.e.setOnCheckedChangeListener(this);
    this.f = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362792));
    this.f.setContentDescription("厘米秀角色素材删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
    this.f.setChecked(paramLayoutInflater.exists() ^ true);
    this.f.setOnCheckedChangeListener(this);
    this.g = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362766));
    this.g.setContentDescription("厘米秀游戏资源包删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    this.g.setChecked(paramLayoutInflater.exists() ^ true);
    this.g.setOnCheckedChangeListener(this);
    this.h = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362771));
    this.h.setContentDescription("厘米秀游戏资源校验和更新");
    this.h.setChecked(this.jdField_b_of_type_AndroidContentSharedPreferences.getBoolean("game_whitelist_verify_switch", true));
    this.h.setOnCheckedChangeListener(this);
    this.i = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362806));
    this.i.setContentDescription("厘米秀3d表情包测试");
    this.i.setTag(Integer.valueOf(1));
    this.i.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_3d_action", false));
    this.i.setOnCheckedChangeListener(this);
    this.j = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362793));
    this.j.setContentDescription("厘米秀新角色测试");
    this.j.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_new_role", false));
    this.j.setOnCheckedChangeListener(this);
    this.k = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362796));
    this.k.setContentDescription("厘米秀抽屉页大人物");
    this.k.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_settingme_size_big", false));
    this.k.setOnCheckedChangeListener(this);
    this.l = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362789));
    this.l.setContentDescription("厘米秀新人物细眉毛");
    this.l.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_role_eyebrow", false));
    this.l.setOnCheckedChangeListener(this);
    this.m = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362791));
    this.m.setContentDescription("厘米秀新人物光头");
    this.m.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_role_no_hair", false));
    this.m.setOnCheckedChangeListener(this);
    this.n = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362790));
    this.n.setContentDescription("厘米秀新人物不显示睫毛");
    this.n.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_role_no_eyelash", false));
    this.n.setOnCheckedChangeListener(this);
    this.o = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362809));
    this.o.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(Scene.AIO.debugConfigKey(), false));
    this.o.setOnCheckedChangeListener(this);
    this.p = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362810));
    this.p.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(Scene.AIO_BACKGROUND.debugConfigKey(), false));
    this.p.setOnCheckedChangeListener(this);
    this.q = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362811));
    this.q.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(Scene.DRAWER.debugConfigKey(), true));
    this.q.setOnCheckedChangeListener(this);
    this.r = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362812));
    this.r.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(Scene.FRIEND_CARD.debugConfigKey(), false));
    this.r.setOnCheckedChangeListener(this);
    this.s = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362813));
    this.s.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(Scene.MEME_PLAYER.debugConfigKey(), false));
    this.s.setOnCheckedChangeListener(this);
    this.t = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362807));
    this.t.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_ce_makeup", false));
    this.t.setOnCheckedChangeListener(this);
    this.u = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362808));
    this.u.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_ce_offscreen_world", true));
    this.u.setOnCheckedChangeListener(this);
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362814)).setOnClickListener(new ApolloDebugFragment.1(this));
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.equals(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).setApolloProxyEnable(paramBoolean);
      return;
    }
    if (paramCompoundButton.equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
        QQToast.a(getActivity(), HardCodeUtil.a(2131704284), 1).a();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "apolloResourceUpdate delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.c.a()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory(ApolloConstant.N);
        QQToast.a(getActivity(), HardCodeUtil.a(2131704266), 1).a();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "apolloScriptUpdate delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.d.a()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory(ApolloCoderResource.a.a());
        QQToast.a(getActivity(), 2131691462, 1).a();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "apolloApngCacheFile delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.e.a()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
        QQToast.a(getActivity(), HardCodeUtil.a(2131704271), 1).a();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "deleteDressItem delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.f.a()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
        QQToast.a(getActivity(), HardCodeUtil.a(2131704278), 1).a();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "deleteRoleItem delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.g.a()))
    {
      if (!paramBoolean) {
        return;
      }
      try
      {
        FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
        QQToast.a(getActivity(), HardCodeUtil.a(2131704277), 1).a();
        return;
      }
      catch (Exception paramCompoundButton)
      {
        QLog.e("IphoneTitleBarFragment", 1, "deleteGameItem delete e:", paramCompoundButton);
        return;
      }
    }
    if (paramCompoundButton.equals(this.h.a()))
    {
      this.jdField_b_of_type_AndroidContentSharedPreferences.edit().putBoolean("game_whitelist_verify_switch", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.i.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_3d_action", paramBoolean).commit();
      FileUtils.deleteDirectory("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      return;
    }
    if (paramCompoundButton.equals(this.j.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_new_role", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.k.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_settingme_size_big", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.l.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_role_eyebrow", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.m.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_role_no_hair", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.n.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_role_no_eyelash", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.o.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(Scene.AIO.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.p.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(Scene.AIO_BACKGROUND.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.r.a()))
    {
      a();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(Scene.FRIEND_CARD.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.q.a()))
    {
      a();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(Scene.DRAWER.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.s.a()))
    {
      a();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(Scene.MEME_PLAYER.debugConfigKey(), paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.t.a()))
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_ce_makeup", paramBoolean).commit();
      return;
    }
    if (paramCompoundButton.equals(this.u.a())) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_ce_offscreen_world", paramBoolean).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.ApolloDebugFragment
 * JD-Core Version:    0.7.0.1
 */