package com.tencent.avgame.ui;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.api.impl.AvGameManagerImpl;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.gamelobby.IAVGameRoomCenterFragment;
import com.tencent.avgame.gamelobby.data.AVGameBaseData;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCreateAndJoinContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbyDataSource;
import com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyBannerCellViewHolder.Factory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyCommonCellViewHolder.Factory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyCreateAndJoinCellViewHolder.Factory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyFeedbackCellViewHolder.Factory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyFixedContentCellViewHolder.Factory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyRandomMatchCellViewHolder.Factory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbySurvivalCellViewHolder.Factory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyTitleViewHolder.Factory;
import com.tencent.avgame.gamelobby.rv.AVGameLobbyViewHolderContext;
import com.tencent.avgame.gamelobby.rv.BaseAdapter;
import com.tencent.avgame.gamelobby.rv.BaseAdapter.BaseViewConfig;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.qav.AsyncExitTask;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

public class AVGameRoomCenterFragment
  extends QPublicBaseFragment
  implements IAVGameRoomCenterFragment
{
  public static final String a = "com.tencent.avgame.ui.AVGameRoomCenterFragment";
  private int jdField_a_of_type_Int = 0;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AVGameRoomCenterFragment.3(this);
  private AVGameLobbyDataSource jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource;
  private AVGameLobbyViewHolderContext jdField_a_of_type_ComTencentAvgameGamelobbyRvAVGameLobbyViewHolderContext;
  private BaseAdapter jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  private AVGameLobbySurvivalContentInfo a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a())
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a(i) != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a(i);
        if ((localObject instanceof AVGameLobbySurvivalContentInfo))
        {
          localObject = (AVGameLobbySurvivalContentInfo)localObject;
          if (((AVGameLobbySurvivalContentInfo)localObject).d() == paramInt) {
            return localObject;
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  private String a(String paramString)
  {
    Object localObject = new StringBuilder(paramString);
    ((StringBuilder)localObject).append("&manufacture=");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    paramString = Build.MODEL;
    if (paramString != null) {
      paramString = paramString.replaceAll(" ", "_");
    } else {
      paramString = "";
    }
    ((StringBuilder)localObject).append("&model=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&version=");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject).append("&appid=");
    ((StringBuilder)localObject).append(AppSetting.a());
    paramString = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("feedback jumpUrl=");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    return paramString;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getQBaseActivity(), 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(paramString3, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramString4, paramOnClickListener2);
    localQQCustomDialog.show();
  }
  
  private boolean b()
  {
    return AVGameUtil.a() == 0;
  }
  
  private void f()
  {
    ((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString);
    if (this.c) {
      localAvGameRoomListHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getLongAccountUin(), null);
    } else {
      localAvGameRoomListHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getLongAccountUin(), "8.4.17");
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initData start");
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource = new AVGameLobbyDataSource();
    this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a(this.c);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a();
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter = new BaseAdapter(this.jdField_a_of_type_ComTencentAvgameGamelobbyRvAVGameLobbyViewHolderContext);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource);
    AVGameLobbyOnClickListenerFactory localAVGameLobbyOnClickListenerFactory = new AVGameLobbyOnClickListenerFactory(this);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(1, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.a(1), new AVGameLobbyBannerCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(1)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(4, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.a(2), new AVGameLobbyFixedContentCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(2)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(5, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.a(3), new AVGameLobbySurvivalCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(3)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(3, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.a(4), new AVGameLobbyCreateAndJoinCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(4)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(6, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.a(8), new AVGameLobbyTitleViewHolder.Factory(), null));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(2, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.a(5), new AVGameLobbyCommonCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(5)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(7, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.a(6), new AVGameLobbyRandomMatchCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(6)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(8, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.a(7), new AVGameLobbyFeedbackCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(7)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.b();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getQBaseActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690427);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
    if (this.c) {
      return;
    }
    AVGameBaseData localAVGameBaseData = this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a(1);
    if ((localAVGameBaseData != null) && ((localAVGameBaseData instanceof AVGameLobbyCreateAndJoinContentInfo))) {
      ((AVGameLobbyCreateAndJoinContentInfo)localAVGameBaseData).jdField_a_of_type_Boolean = true;
    }
  }
  
  public AppInterface a()
  {
    return (AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
  }
  
  public void a()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B694", "0X800B694", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(getQBaseActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", a("https://ti.qq.com/tucao/index.html?productId=280793&_wv=1"));
    getQBaseActivity().startActivity(localIntent);
  }
  
  public void a(int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B012", "0X800B012", 0, 0, "", String.valueOf(paramInt), "", "");
    IAvGameManager localIAvGameManager = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if ((localIAvGameManager != null) && (localIAvGameManager.isAvGameRoomExistReEnterDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))) {
      return;
    }
    AVGameJoinRoomFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, null);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ((AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString)).a(paramInt, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reservePKGame start");
    }
  }
  
  public void a(String paramString)
  {
    paramString = JumpParser.a((BaseQQAppInterface)a(), getActivity(), paramString);
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "survival_main_clk", "survival_main_clk", 0, 0, "", "", "", String.valueOf(paramInt));
  }
  
  public boolean a()
  {
    Object localObject = (IQQActivateFriendService)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IQQActivateFriendService.class, "");
    boolean bool;
    if (localObject == null) {
      bool = false;
    } else {
      bool = ((IQQActivateFriendService)localObject).getSwitchValue(true);
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRemindSwitch-> isSettingOpen:");
      localStringBuilder.append(bool);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void b()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B011", "0X800B011", 0, 0, "", "", "", "");
    Object localObject1 = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      int i;
      if (this.c) {
        i = 8;
      } else {
        i = 12;
      }
      ((IAvGameManager)localObject1).createAvGameRoom((Activity)localObject2, i, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getCurrentAccountUin(), 0);
      if (((IAvGameManager)localObject1).isAvGameRoomExist()) {
        i = 1;
      } else {
        i = 2;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
      if (this.c) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800B011", "0X800B011", i, 0, "", (String)localObject1, "", "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, 2131690493, 0).a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    IAvGameManager localIAvGameManager = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null)
    {
      int i;
      if (localIAvGameManager.isAvGameRoomExist()) {
        i = 1;
      } else {
        i = 2;
      }
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gameType:");
        localStringBuilder.append(paramInt);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B493", "0X800B493", i, 0, String.valueOf(paramInt), "2", "", "");
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (!paramBoolean) {
        i = 11;
      } else {
        i = 13;
      }
      localIAvGameManager.startStrangerMatchV2((Activity)localObject, paramInt, 1, i);
    }
  }
  
  public void c()
  {
    IAvGameManager localIAvGameManager = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null)
    {
      int i;
      if (localIAvGameManager.isAvGameRoomExist()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B493", "0X800B493", i, 0, "0", "1", "", "");
      if (AVGameUtil.b() == 0)
      {
        localIAvGameManager.startStrangerMatch(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 9);
        return;
      }
      localIAvGameManager.startStrangerMatchV2(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0, 0, 11);
    }
  }
  
  public void c(int paramInt, boolean paramBoolean)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B691", "0X800B691", 0, 0, "", "", "", "");
    IAvGameManager localIAvGameManager = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null) {
      localIAvGameManager.startSurvivalGame(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramInt, paramBoolean, 2);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "openQQRemind run");
    }
    QQNotifyUtils.a(getQBaseActivity(), "6ac7725e6d8354412b250277c07b5eed", null, "1e21f0aac11186123d5e9426293143e3", 100);
  }
  
  public void e()
  {
    if (!this.c) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B013", "0X800B013", 0, 0, "", (String)localObject, "", "");
    Object localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if ((localObject != null) && (!TextUtils.isEmpty(((IAvGameManager)localObject).getAvGameRoomId())))
    {
      ((IAvGameManager)localObject).joinAvGameRoom(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 4, ((IAvGameManager)localObject).getAvGameRoomId(), null);
      return;
    }
    if ((localObject != null) && (((IAvGameManager)localObject).isCurrentPkSurvivalEmptyRoom()))
    {
      AvGameLoadingActivity.a(false, getActivity(), null, ((IAvGameManager)localObject).getAvGameRoomId(), null, "", false, true, null);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, 2131690494, 0).a();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("msg");
      paramInt1 = paramIntent.getIntExtra("errorCode", -1);
      if (QLog.isColorLevel())
      {
        paramIntent = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQRemind-> retmsg=");
        localStringBuilder.append(str);
        localStringBuilder.append(", retcode=");
        localStringBuilder.append(paramInt1);
        QLog.d(paramIntent, 2, localStringBuilder.toString());
      }
      if ((paramInt1 == 0) || (paramInt1 == 5))
      {
        paramIntent = a(this.jdField_a_of_type_Int);
        if (paramIntent == null) {
          return;
        }
        a(paramIntent.d(), paramIntent.b() ^ true);
        paramIntent.b(false);
        this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.notifyDataSetChanged();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B690", "0X800B690", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvAVGameLobbyViewHolderContext = new AVGameLobbyViewHolderContext();
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvAVGameLobbyViewHolderContext.a((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
    paramBundle = AvGameConfigUtil.a();
    this.jdField_a_of_type_Boolean = paramBundle.b();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("avGameConfBean:");
      localStringBuilder.append(paramBundle.toString());
      localStringBuilder.append("  avGameConfBean.isStrangerMatchShow：");
      localStringBuilder.append(paramBundle.b());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    AVGameLobbyFixedContentInfo.a(this.jdField_a_of_type_Boolean);
    AsyncExitTask.a();
    this.c = b();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GameRoomViewLayoutParamsDef.a(getQBaseActivity(), false);
    f();
    g();
    paramViewGroup = paramLayoutInflater.inflate(2131558659, paramViewGroup, false);
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getQBaseActivity().getWindow());
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131363241));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = (ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()) + ViewUtils.a(44.0F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (RecyclerView)paramViewGroup.findViewById(2131363223);
    paramLayoutInflater.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 3));
    paramLayoutInflater.setAdapter(this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.notifyDataSetChanged();
    paramLayoutInflater = (AsyncImageView)paramViewGroup.findViewById(2131363202);
    paramLayoutInflater.setDefaultColorDrawable(0);
    paramLayoutInflater.setAsyncImage("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_bg2.png");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363201));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new AVGameRoomCenterFragment.1(this));
    float f = getQBaseActivity().getResources().getDisplayMetrics().density;
    paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetTextView;
    int i = (int)(f * 5.0F + 0.5F);
    BaseAIOUtils.a(paramLayoutInflater, i, i, i, i);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131363200));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AVGameRoomCenterFragment.2(this));
    AvGameManagerImpl.asyncPreloadAVGameProcess(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    if (this.c) {
      paramLayoutInflater = "1";
    } else {
      paramLayoutInflater = "2";
    }
    ReportController.b(paramBundle, "dc00898", "", "", "0X800B49D", "0X800B49D", 0, 0, "", paramLayoutInflater, "", "");
    if ((this.c) && (this.jdField_a_of_type_Boolean)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B49E", "0X800B49E", 0, 0, "0", "1", "", "");
    }
    ((ConfigHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject != null)
    {
      ((AppInterface)((QBaseActivity)localObject).getAppRuntime()).removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
      localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    }
    else
    {
      localObject = null;
    }
    if (localObject != null) {
      ((IAvGameManager)localObject).setLobbyEntryStatus(false);
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter;
    if (localObject != null) {
      ((BaseAdapter)localObject).a();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject != null)
    {
      ((AppInterface)((QBaseActivity)localObject).getAppRuntime()).removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
      localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    }
    else
    {
      localObject = null;
    }
    if (localObject != null) {
      ((IAvGameManager)localObject).setLobbyEntryStatus(false);
    }
    super.onFinish();
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.resumeAll();
    Object localObject = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if ((localObject != null) && (((IAvGameManager)localObject).isAvGameRoomExist())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (localObject != null) {
      ((IAvGameManager)localObject).setLobbyEntryStatus(true);
    }
    if (this.b)
    {
      h();
      this.b = false;
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment
 * JD-Core Version:    0.7.0.1
 */