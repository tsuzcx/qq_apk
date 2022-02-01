package com.tencent.mobileqq.apollo.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.screenshot.ApolloCoderResource;
import com.tencent.mobileqq.apollo.screenshot.ApolloCoderResource.Companion;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  
  public int a()
  {
    return 2131558718;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4);
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_test", 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362829));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("厘米秀内网环境代理");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((IApolloUtil)QRoute.api(IApolloUtil.class)).isApolloProxyEnable());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362781));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("厘米秀动作素材删除");
    paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
    paramViewGroup = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (!paramLayoutInflater.exists())
    {
      bool = true;
      paramViewGroup.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.c = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362850));
      this.c.setContentDescription("厘米秀脚本文件删除");
      paramLayoutInflater = new File(ApolloConstant.I);
      paramViewGroup = this.c;
      if (paramLayoutInflater.exists()) {
        break label857;
      }
      bool = true;
      label201:
      paramViewGroup.setChecked(bool);
      this.c.setOnCheckedChangeListener(this);
      this.d = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362796));
      this.d.setContentDescription("厘米秀表情缓存删除");
      paramLayoutInflater = new File(ApolloCoderResource.a.a());
      paramViewGroup = this.d;
      if (paramLayoutInflater.exists()) {
        break label863;
      }
      bool = true;
      label269:
      paramViewGroup.setChecked(bool);
      this.d.setOnCheckedChangeListener(this);
      this.e = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362807));
      this.e.setContentDescription("厘米秀装扮素材删除");
      paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
      paramViewGroup = this.e;
      if (paramLayoutInflater.exists()) {
        break label869;
      }
      bool = true;
      label333:
      paramViewGroup.setChecked(bool);
      this.e.setOnCheckedChangeListener(this);
      this.f = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362848));
      this.f.setContentDescription("厘米秀角色素材删除");
      paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      paramViewGroup = this.f;
      if (paramLayoutInflater.exists()) {
        break label875;
      }
      bool = true;
      label397:
      paramViewGroup.setChecked(bool);
      this.f.setOnCheckedChangeListener(this);
      this.g = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362816));
      this.g.setContentDescription("厘米秀游戏资源包删除");
      paramLayoutInflater = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      paramViewGroup = this.g;
      if (paramLayoutInflater.exists()) {
        break label881;
      }
    }
    label857:
    label863:
    label869:
    label875:
    label881:
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.setChecked(bool);
      this.g.setOnCheckedChangeListener(this);
      this.h = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362821));
      this.h.setContentDescription("厘米秀游戏资源校验和更新");
      this.h.setChecked(this.jdField_b_of_type_AndroidContentSharedPreferences.getBoolean("game_whitelist_verify_switch", true));
      this.h.setOnCheckedChangeListener(this);
      this.i = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362862));
      this.i.setContentDescription("厘米秀3d表情包测试");
      this.i.setTag(Integer.valueOf(1));
      this.i.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_3d_action", false));
      this.i.setOnCheckedChangeListener(this);
      this.j = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362849));
      this.j.setContentDescription("厘米秀新角色测试");
      this.j.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_new_role", false));
      this.j.setOnCheckedChangeListener(this);
      this.k = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362852));
      this.k.setContentDescription("厘米秀抽屉页大人物");
      this.k.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_settingme_size_big", false));
      this.k.setOnCheckedChangeListener(this);
      this.l = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362845));
      this.l.setContentDescription("厘米秀新人物细眉毛");
      this.l.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_role_eyebrow", false));
      this.l.setOnCheckedChangeListener(this);
      this.m = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362847));
      this.m.setContentDescription("厘米秀新人物光头");
      this.m.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_role_no_hair", false));
      this.m.setOnCheckedChangeListener(this);
      this.n = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131362846));
      this.n.setContentDescription("厘米秀新人物不显示睫毛");
      this.n.setChecked(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("test_role_no_eyelash", false));
      this.n.setOnCheckedChangeListener(this);
      return;
      bool = false;
      break;
      bool = false;
      break label201;
      bool = false;
      break label269;
      bool = false;
      break label333;
      bool = false;
      break label397;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.equals(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).setApolloProxyEnable(paramBoolean);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramCompoundButton.equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
      {
        if (paramBoolean) {
          try
          {
            FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
            QQToast.a(getActivity(), HardCodeUtil.a(2131704194), 1).a();
          }
          catch (Exception localException1)
          {
            QLog.e("IphoneTitleBarFragment", 1, "apolloResourceUpdate delete e:", localException1);
          }
        }
      }
      else if (paramCompoundButton.equals(this.c.a()))
      {
        if (paramBoolean) {
          try
          {
            FileUtils.a(ApolloConstant.I);
            QQToast.a(getActivity(), HardCodeUtil.a(2131704176), 1).a();
          }
          catch (Exception localException2)
          {
            QLog.e("IphoneTitleBarFragment", 1, "apolloScriptUpdate delete e:", localException2);
          }
        }
      }
      else if (paramCompoundButton.equals(this.d.a()))
      {
        if (paramBoolean) {
          try
          {
            FileUtils.a(ApolloCoderResource.a.a());
            QQToast.a(getActivity(), 2131691541, 1).a();
          }
          catch (Exception localException3)
          {
            QLog.e("IphoneTitleBarFragment", 1, "apolloApngCacheFile delete e:", localException3);
          }
        }
      }
      else if (paramCompoundButton.equals(this.e.a()))
      {
        if (paramBoolean) {
          try
          {
            FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
            QQToast.a(getActivity(), HardCodeUtil.a(2131704181), 1).a();
          }
          catch (Exception localException4)
          {
            QLog.e("IphoneTitleBarFragment", 1, "deleteDressItem delete e:", localException4);
          }
        }
      }
      else if (paramCompoundButton.equals(this.f.a()))
      {
        if (paramBoolean) {
          try
          {
            FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
            QQToast.a(getActivity(), HardCodeUtil.a(2131704188), 1).a();
          }
          catch (Exception localException5)
          {
            QLog.e("IphoneTitleBarFragment", 1, "deleteRoleItem delete e:", localException5);
          }
        }
      }
      else if (paramCompoundButton.equals(this.g.a()))
      {
        if (paramBoolean) {
          try
          {
            FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
            QQToast.a(getActivity(), HardCodeUtil.a(2131704187), 1).a();
          }
          catch (Exception localException6)
          {
            QLog.e("IphoneTitleBarFragment", 1, "deleteGameItem delete e:", localException6);
          }
        }
      }
      else if (paramCompoundButton.equals(this.h.a()))
      {
        this.jdField_b_of_type_AndroidContentSharedPreferences.edit().putBoolean("game_whitelist_verify_switch", paramBoolean).commit();
      }
      else if (paramCompoundButton.equals(this.i.a()))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_3d_action", paramBoolean).commit();
        FileUtils.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/");
      }
      else if (paramCompoundButton.equals(this.j.a()))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_new_role", paramBoolean).commit();
      }
      else if (paramCompoundButton.equals(this.k.a()))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_settingme_size_big", paramBoolean).commit();
      }
      else if (paramCompoundButton.equals(this.l.a()))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_role_eyebrow", paramBoolean).commit();
      }
      else if (paramCompoundButton.equals(this.m.a()))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_role_no_hair", paramBoolean).commit();
      }
      else if (paramCompoundButton.equals(this.n.a()))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("test_role_no_eyelash", paramBoolean).commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.ApolloDebugFragment
 * JD-Core Version:    0.7.0.1
 */