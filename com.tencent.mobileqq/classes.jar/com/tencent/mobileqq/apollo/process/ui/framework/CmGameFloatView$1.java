package com.tencent.mobileqq.apollo.process.ui.framework;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.apollo.api.model.CmGamePushItem;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.CmGameDebugManager;
import com.tencent.mobileqq.apollo.game.OnGameMenuListener;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.util.WeakReference;
import org.json.JSONObject;

class CmGameFloatView$1
  implements ActionSheet.OnButtonClickListener
{
  CmGameFloatView$1(CmGameFloatView paramCmGameFloatView) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    CmGameFloatView.a(this.a).dismiss();
    switch (CmGameFloatView.a(this.a).get(paramInt))
    {
    case 4: 
    case 7: 
    case 8: 
    default: 
      return;
    case 0: 
      if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a()))
      {
        QLog.d("cmframe_CmGameFloatView", 1, "pack up game");
        this.a.f();
        if (this.a.jdField_a_of_type_ComTencentMobileqqApolloGameOnGameMenuListener != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqApolloGameOnGameMenuListener.c();
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || ((this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter != 0) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter != 1) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter != 7))) {
          break label1088;
        }
      }
      break;
    }
    label291:
    label1082:
    label1088:
    for (paramInt = 0;; paramInt = 1)
    {
      int i;
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
      {
        i = this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
        label212:
        if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
          break label291;
        }
      }
      for (paramView = String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);; paramView = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "miniature_game", i, paramInt, new String[] { paramView });
        return;
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a();
        if ((paramView == null) || (paramView.isFinishing())) {
          break;
        }
        paramView.finish();
        break;
        i = 0;
        break label212;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {}
      try
      {
        paramView = new JSONObject();
        paramView.put("gameId", this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
        paramView.put("isSelectFriend", 1);
        paramView.put("gameMode", this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameMode);
        paramView.put("roomId", this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId);
        this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.b(paramView.toString());
        if (this.a.jdField_a_of_type_ComTencentMobileqqApolloGameOnGameMenuListener != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqApolloGameOnGameMenuListener.b();
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
        {
          paramView = String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
          VipUtils.a(null, "cmshow", "Apollo", "clk_share", 0, 0, new String[] { paramView });
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          QLog.e("cmframe_CmGameFloatView", 1, "share game error, e=", paramView);
          continue;
          paramView = "";
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
      {
        paramInt = this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
        if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
          break label631;
        }
      }
      label631:
      for (paramView = String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);; paramView = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "about_game", paramInt, 0, new String[] { paramView });
        paramView = new Intent();
        paramView.putExtra("extra_startcheckparam", this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        PublicFragmentActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.a(), paramView, ApolloGameInfoFragment.class, 10000);
        if (this.a.jdField_a_of_type_ComTencentMobileqqApolloGameOnGameMenuListener == null) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqApolloGameOnGameMenuListener.d();
        return;
        paramInt = 0;
        break label518;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
        break;
      }
      ApolloGameUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, null);
      VipUtils.a(null, "cmshow", "Apollo", "clk_create_shortcut", 0, 0, new String[] { String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId) });
      return;
      this.a.b();
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem == null)) {
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red == 1)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red = 0;
        CmGameFloatView.a(this.a).setVisibility(8);
        if (CmGameFloatView.a(this.a) != null) {
          CmGameFloatView.a(this.a).updateButton(CmGameFloatView.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content, 0);
        }
        paramView = new Bundle();
        paramView.putSerializable("CmGamePushItem", this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem);
        QIPCClientHelper.getInstance().callServer("cm_game_module", "action_update_game_push", paramView, null);
      }
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.url;
      Activity localActivity = (Activity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((!TextUtils.isEmpty(paramView)) && (localActivity != null)) {
        CmGameUtil.b(localActivity, paramView);
      }
      for (paramInt = 0;; paramInt = 1)
      {
        VipUtils.a(null, "cmshow", "Apollo", "clk_promote", this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src, paramInt, new String[] { String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.msg_id });
        return;
      }
      paramView = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
      boolean bool2 = paramView.getBoolean("game_debug_tool_switch", true);
      paramView = paramView.edit();
      if (!bool2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        paramView.putBoolean("game_debug_tool_switch", bool1).commit();
        if (this.a.jdField_a_of_type_MqqUtilWeakReference == null) {
          break;
        }
        paramView = (Activity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if ((paramView == null) || (!(paramView instanceof ApolloGameActivity))) {
          break;
        }
        paramView = (ApolloGameActivity)paramView;
        if ((bool2) || (!CmGameDebugManager.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam))) {
          break label1082;
        }
        paramView.b(true);
        return;
      }
      paramView.b(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView.1
 * JD-Core Version:    0.7.0.1
 */