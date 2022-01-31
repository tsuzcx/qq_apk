package com.tencent.mobileqq.apollo.lightGame;

import akuy;
import akuz;
import akvd;
import akvv;
import akwd;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import azri;
import bdin;
import bhtd;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CmGameLoadingFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private akuz jdField_a_of_type_Akuz;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bhtd jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameStartChecker jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker;
  private CmGameLoadingView jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView;
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public void a()
  {
    if ((this.c) && (this.d) && (this.e))
    {
      this.jdField_a_of_type_Bhtd.removeMessages(4);
      this.jdField_a_of_type_Bhtd.sendMessageDelayed(this.jdField_a_of_type_Bhtd.obtainMessage(4), 150L);
      this.c = false;
      this.d = false;
      this.e = false;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.b();
      this.jdField_a_of_type_Bhtd.sendMessageDelayed(this.jdField_a_of_type_Bhtd.obtainMessage(3), paramLong);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onGameUICreated]");
    this.jdField_a_of_type_Bhtd.removeMessages(2);
    this.jdField_a_of_type_Bhtd.sendMessageDelayed(this.jdField_a_of_type_Bhtd.obtainMessage(2), 600L);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.a();
    }
    this.e = true;
    a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.b(null, -10L);
        continue;
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
          continue;
          paramMessage = super.getActivity();
          if (paramMessage != null)
          {
            paramMessage.finish();
            continue;
            QLog.d("cmgame_process.CmGameLoadingFragment", 1, " restart ApolloGameActivity");
            if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mStartType = 3;
            }
            ApolloGameUtil.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
          }
        }
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().setSoftInputMode(17);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onBackEvent]");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      akvv.a().b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    long l;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
          akvv.a().b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        }
        paramView = super.getActivity();
        if (paramView != null) {
          paramView.finish();
        }
        paramView = akwd.a();
      } while ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (paramView == null));
      l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    } while (l <= 0L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
    localHashMap.put("param_isLoading", "1");
    localHashMap.put("param_gameProc", "0");
    azri.a(paramView.getApp()).a(paramView.getCurrentAccountUin(), "cmgame_click_to_close", true, l, 0L, localHashMap, "", false);
    QLog.d("CmGameStat", 1, new Object[] { "cmgame_click_to_close, main proc, duration=", Long.valueOf(l), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onCreateView]");
    paramBundle = super.getActivity();
    if (paramBundle == null) {
      return null;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = ((CmGameStartChecker.StartCheckParam)paramBundle.getIntent().getSerializableExtra("extra_startcheckparam"));
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 1)
      {
        this.jdField_a_of_type_Boolean = false;
        paramBundle.setRequestedOrientation(8);
        if (!this.jdField_a_of_type_Boolean) {
          break label604;
        }
        i = 1;
        label109:
        this.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView = CmGameLoadingView.a(paramBundle, this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView, new RelativeLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        paramViewGroup = akwd.a();
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker = new CmGameStartChecker(paramViewGroup);
        this.jdField_a_of_type_Akuz = new akuz(this, paramViewGroup);
        akvv.a().a(this, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        if (paramViewGroup != null)
        {
          if ((!bdin.d(paramBundle)) && (!akwd.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam))) {
            break label610;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.jdField_a_of_type_Akuz);
          if (!akwd.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)) {
            akvd.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, "android.subgame", new akuy(this));
          }
        }
        label266:
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enableMenu)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2131558833, null));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363543));
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          paramLayoutInflater = super.getResources();
          i = (int)paramLayoutInflater.getDimension(2131296411);
          int j = (int)paramLayoutInflater.getDimension(2131296410);
          paramLayoutInflater = new RelativeLayout.LayoutParams(-2, -2);
          paramLayoutInflater.addRule(11);
          paramLayoutInflater.addRule(10);
          paramLayoutInflater.rightMargin = j;
          paramLayoutInflater.topMargin = i;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, paramLayoutInflater);
        }
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        long l = this.jdField_a_of_type_Long - akwd.e;
        if ((l > 0L) && (paramViewGroup != null))
        {
          paramLayoutInflater = new HashMap();
          paramLayoutInflater.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
          paramLayoutInflater.put("param_src", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
          azri.a(BaseApplicationImpl.getContext()).a(paramViewGroup.getCurrentAccountUin(), "cmgame_main_proc_loading_time", true, l, 0L, paramLayoutInflater, "", false);
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_main_proc_loading_time, duration=", Long.valueOf(l), ", sOpenLoadingTs=", Long.valueOf(akwd.e), ", createTime=", Long.valueOf(this.jdField_a_of_type_Long), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
        }
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 2)
      {
        this.jdField_a_of_type_Boolean = false;
        paramBundle.setRequestedOrientation(0);
        break;
      }
      paramBundle.setRequestedOrientation(1);
      break;
      label604:
      i = 2;
      break label109;
      label610:
      QLog.w("cmgame_process.CmGameLoadingFragment", 1, "[onCreate] no net");
      this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(1, 1000L);
      akvv.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, -1L, null);
      break label266;
      QLog.e("cmgame_process.CmGameLoadingFragment", 1, "[onCreateView] mStartCheckParam null");
    }
  }
  
  public void onDestroyView()
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onDestroyView]");
    super.onDestroyView();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, "[onPause]");
    }
    this.c = true;
    this.d = false;
  }
  
  public void onResume()
  {
    QLog.d("cmgame_process.CmGameLoadingFragment", 1, "[onResume]");
    super.onResume();
    this.jdField_a_of_type_Bhtd.removeMessages(2);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.d = true;
    a();
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLoadingFragment", 2, "[onStop]");
    }
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingFragment
 * JD-Core Version:    0.7.0.1
 */