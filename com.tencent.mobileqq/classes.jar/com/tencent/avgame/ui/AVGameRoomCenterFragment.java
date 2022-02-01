package com.tencent.avgame.ui;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
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
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

public class AVGameRoomCenterFragment
  extends PublicBaseFragment
{
  public static final String a;
  public int a;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AVGameRoomCenterFragment.3(this);
  private AVGameLobbyDataSource jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource;
  private AVGameLobbyViewHolderContext jdField_a_of_type_ComTencentAvgameGamelobbyRvAVGameLobbyViewHolderContext;
  private BaseAdapter jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = AVGameRoomCenterFragment.class.getName();
  }
  
  public AVGameRoomCenterFragment()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private AVGameLobbySurvivalContentInfo a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a())
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a(i) == null) {}
      Object localObject;
      do
      {
        do
        {
          i += 1;
          break;
          localObject = this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a(i);
        } while (!(localObject instanceof AVGameLobbySurvivalContentInfo));
        localObject = (AVGameLobbySurvivalContentInfo)localObject;
      } while (((AVGameLobbySurvivalContentInfo)localObject).d() != paramInt);
      return localObject;
    }
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("&manufacture=").append(Build.MANUFACTURER);
    paramString = Build.MODEL;
    if (paramString != null) {}
    for (paramString = paramString.replaceAll(" ", "_");; paramString = "")
    {
      localStringBuilder.append("&model=").append(paramString);
      localStringBuilder.append("&version=").append(Build.VERSION.SDK_INT);
      localStringBuilder.append("&appid=").append(AppSetting.a());
      paramString = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "feedback jumpUrl=" + paramString);
      }
      return paramString;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(paramString3, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramString4, paramOnClickListener2);
    localQQCustomDialog.show();
  }
  
  private boolean b()
  {
    return AVGameUtils.a() == 0;
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (this.c) {
      localAvGameRoomListHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin(), null);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initData start");
      }
      return;
      localAvGameRoomListHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin(), "8.4.17");
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
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(1, new BaseAdapter.BaseViewConfig(2131558781, new AVGameLobbyBannerCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(1)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(4, new BaseAdapter.BaseViewConfig(2131558785, new AVGameLobbyFixedContentCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(2)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(5, new BaseAdapter.BaseViewConfig(2131558788, new AVGameLobbySurvivalCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(3)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(3, new BaseAdapter.BaseViewConfig(2131558783, new AVGameLobbyCreateAndJoinCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(4)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(6, new BaseAdapter.BaseViewConfig(2131558787, new AVGameLobbyTitleViewHolder.Factory(), null));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(2, new BaseAdapter.BaseViewConfig(2131558782, new AVGameLobbyCommonCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(5)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(7, new BaseAdapter.BaseViewConfig(2131558786, new AVGameLobbyRandomMatchCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(6)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a(8, new BaseAdapter.BaseViewConfig(2131558784, new AVGameLobbyFeedbackCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(7)));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.b();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690502);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
    if (this.c) {}
    AVGameBaseData localAVGameBaseData;
    do
    {
      return;
      localAVGameBaseData = this.jdField_a_of_type_ComTencentAvgameGamelobbyDataAVGameLobbyDataSource.a(1);
    } while ((localAVGameBaseData == null) || (!(localAVGameBaseData instanceof AVGameLobbyCreateAndJoinContentInfo)));
    ((AVGameLobbyCreateAndJoinContentInfo)localAVGameBaseData).jdField_a_of_type_Boolean = true;
  }
  
  public void a()
  {
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B694", "0X800B694", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", a("https://ti.qq.com/tucao/index.html?productId=280793&_wv=1"));
    getActivity().startActivity(localIntent);
  }
  
  public void a(int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B012", "0X800B012", 0, 0, "", String.valueOf(paramInt), "", "");
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localAvGameManager != null) && (localAvGameManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))) {
      return;
    }
    AVGameJoinRoomFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ((AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER)).a(paramInt, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reservePKGame start");
    }
  }
  
  public boolean a()
  {
    IQQActivateFriendService localIQQActivateFriendService = (IQQActivateFriendService)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getRuntimeService(IQQActivateFriendService.class);
    if (localIQQActivateFriendService == null) {}
    for (boolean bool = false;; bool = localIQQActivateFriendService.getSwitchValue(true))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRemindSwitch-> isSettingOpen:" + bool);
      }
      return bool;
    }
  }
  
  public void b()
  {
    Object localObject = "1";
    if (!this.c) {
      localObject = "2";
    }
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B013", "0X800B013", 0, 0, "", (String)localObject, "", "");
    localObject = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localObject != null) && (!TextUtils.isEmpty(((AvGameManager)localObject).a())))
    {
      ((AvGameManager)localObject).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 4, ((AvGameManager)localObject).a(), null);
      return;
    }
    if ((localObject != null) && (((AvGameManager)localObject).b()))
    {
      AvGameLoadingActivity.a(false, getActivity(), null, ((AvGameManager)localObject).a(), null, "", false, true, null);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690567, 0).a();
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    FragmentActivity localFragmentActivity;
    if (localAvGameManager != null)
    {
      if (!localAvGameManager.a()) {
        break label126;
      }
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "gameType:" + paramInt);
      }
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B493", "0X800B493", i, 0, String.valueOf(paramInt), "2", "", "");
      localFragmentActivity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (paramBoolean) {
        break label131;
      }
    }
    label131:
    for (int i = 11;; i = 13)
    {
      localAvGameManager.a(localFragmentActivity, paramInt, 1, i);
      return;
      label126:
      i = 2;
      break;
    }
  }
  
  public void c()
  {
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B011", "0X800B011", 0, 0, "", "", "", "");
    Object localObject1 = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      int i;
      if (this.c)
      {
        i = 8;
        ((AvGameManager)localObject1).a((Activity)localObject2, i, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), 0);
        if (!((AvGameManager)localObject1).a()) {
          break label147;
        }
        i = 1;
        label95:
        localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
        if (!this.c) {
          break label152;
        }
      }
      label147:
      label152:
      for (localObject1 = "1";; localObject1 = "2")
      {
        ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800B011", "0X800B011", i, 0, "", (String)localObject1, "", "");
        return;
        i = 12;
        break;
        i = 2;
        break label95;
      }
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690566, 0).a();
  }
  
  public void c(int paramInt, boolean paramBoolean)
  {
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B691", "0X800B691", 0, 0, "", "", "", "");
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localAvGameManager != null) {
      localAvGameManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramBoolean, 2);
    }
  }
  
  public void d()
  {
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localAvGameManager != null) {
      if (!localAvGameManager.a()) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 2)
    {
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B493", "0X800B493", i, 0, "0", "1", "", "");
      if (AVGameUtils.b() != 0) {
        break;
      }
      localAvGameManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 9);
      return;
    }
    localAvGameManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, 0, 11);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "openQQRemind run");
    }
    QQNotifyUtils.a(getActivity(), "6ac7725e6d8354412b250277c07b5eed", null, "1e21f0aac11186123d5e9426293143e3", 100);
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
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QQRemind-> retmsg=" + str + ", retcode=" + paramInt1);
      }
      if ((paramInt1 == 0) || (paramInt1 == 5))
      {
        paramIntent = a(this.jdField_a_of_type_Int);
        if (paramIntent != null) {
          break label103;
        }
      }
    }
    return;
    label103:
    paramInt1 = paramIntent.d();
    if (!paramIntent.b()) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt1, bool);
      paramIntent.b(false);
      this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.notifyDataSetChanged();
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B690", "0X800B690", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvAVGameLobbyViewHolderContext = new AVGameLobbyViewHolderContext();
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvAVGameLobbyViewHolderContext.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    paramBundle = (AvGameConfBean)QConfigManager.a().a(642);
    this.jdField_a_of_type_Boolean = paramBundle.b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "avGameConfBean:" + paramBundle.toString() + "  avGameConfBean.isStrangerMatchShow：" + paramBundle.b());
    }
    AVGameLobbyFixedContentInfo.a(this.jdField_a_of_type_Boolean);
    AsyncExitTask.a();
    this.c = b();
    paramBundle = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (paramBundle != null) {
      paramBundle.a(true);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GameRoomViewLayoutParamsDef.a(getActivity());
    f();
    g();
    paramViewGroup = paramLayoutInflater.inflate(2131558760, paramViewGroup, false);
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131363309));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = (ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()) + AIOUtils.a(44.0F, getResources()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (RecyclerView)paramViewGroup.findViewById(2131363291);
    paramLayoutInflater.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 3));
    paramLayoutInflater.setAdapter(this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.notifyDataSetChanged();
    paramLayoutInflater = (AsyncImageView)paramViewGroup.findViewById(2131363270);
    paramLayoutInflater.setDefaultColorDrawable(0);
    paramLayoutInflater.setAsyncImage("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_bg2.png");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363269));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new AVGameRoomCenterFragment.1(this));
    float f = getActivity().getResources().getDisplayMetrics().density;
    AIOUtils.a(this.jdField_a_of_type_AndroidWidgetTextView, (int)(5.0F * f + 0.5F), (int)(5.0F * f + 0.5F), (int)(5.0F * f + 0.5F), (int)(f * 5.0F + 0.5F));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131363268));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AVGameRoomCenterFragment.2(this));
    AvGameManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    if (this.c) {}
    for (paramLayoutInflater = "1";; paramLayoutInflater = "2")
    {
      ReportController.b(paramBundle, "dc00898", "", "", "0X800B49D", "0X800B49D", 0, 0, "", paramLayoutInflater, "", "");
      if ((this.c) && (this.jdField_a_of_type_Boolean)) {
        ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B49E", "0X800B49E", 0, 0, "0", "1", "", "");
      }
      ((ConfigHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
      V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
      return paramViewGroup;
    }
  }
  
  public void onDestroy()
  {
    AvGameManager localAvGameManager = null;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
      localAvGameManager = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    }
    if (localAvGameManager != null) {
      localAvGameManager.a(false);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseAdapter.a();
    }
    super.onDestroy();
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
    AvGameManager localAvGameManager = (AvGameManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localAvGameManager != null) && (localAvGameManager.a()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!this.b) {
        break label72;
      }
      h();
      this.b = false;
    }
    label72:
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment
 * JD-Core Version:    0.7.0.1
 */