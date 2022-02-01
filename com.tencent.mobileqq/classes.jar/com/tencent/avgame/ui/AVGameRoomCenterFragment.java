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
  private QBaseActivity b;
  private BaseAdapter c;
  private AVGameLobbyDataSource d;
  private TextView e;
  private ImageView f;
  private boolean g;
  private AVGameLobbyViewHolderContext h;
  private QQProgressDialog i;
  private boolean j;
  private boolean k = true;
  private RelativeLayout l;
  private int m = 0;
  private AvGameRoomListObserver n = new AVGameRoomCenterFragment.3(this);
  
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
  
  private String b(String paramString)
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
    ((StringBuilder)localObject).append(AppSetting.d());
    paramString = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("feedback jumpUrl=");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    return paramString;
  }
  
  private AVGameLobbySurvivalContentInfo c(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.d.a())
    {
      if (this.d.a(i1) != null)
      {
        Object localObject = this.d.a(i1);
        if ((localObject instanceof AVGameLobbySurvivalContentInfo))
        {
          localObject = (AVGameLobbySurvivalContentInfo)localObject;
          if (((AVGameLobbySurvivalContentInfo)localObject).f() == paramInt) {
            return localObject;
          }
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  private void h()
  {
    ((AppInterface)this.b.getAppRuntime()).addObserver(this.n);
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)((AppInterface)this.b.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a);
    if (this.k) {
      localAvGameRoomListHandler.a(this.b.getAppRuntime().getLongAccountUin(), null);
    } else {
      localAvGameRoomListHandler.a(this.b.getAppRuntime().getLongAccountUin(), "8.4.17");
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "initData start");
    }
  }
  
  private void i()
  {
    this.d = new AVGameLobbyDataSource();
    this.d.a(this.k);
    this.d.b();
    this.c = new BaseAdapter(this.h);
    this.c.a(this.d);
    AVGameLobbyOnClickListenerFactory localAVGameLobbyOnClickListenerFactory = new AVGameLobbyOnClickListenerFactory(this);
    this.c.a(1, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.b(1), new AVGameLobbyBannerCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(1)));
    this.c.a(4, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.b(2), new AVGameLobbyFixedContentCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(2)));
    this.c.a(5, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.b(3), new AVGameLobbySurvivalCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(3)));
    this.c.a(3, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.b(4), new AVGameLobbyCreateAndJoinCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(4)));
    this.c.a(6, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.b(8), new AVGameLobbyTitleViewHolder.Factory(), null));
    this.c.a(2, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.b(5), new AVGameLobbyCommonCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(5)));
    this.c.a(7, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.b(6), new AVGameLobbyRandomMatchCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(6)));
    this.c.a(8, new BaseAdapter.BaseViewConfig(localAVGameLobbyOnClickListenerFactory.b(7), new AVGameLobbyFeedbackCellViewHolder.Factory(), localAVGameLobbyOnClickListenerFactory.a(7)));
    this.d.c();
  }
  
  private void j()
  {
    if (this.i == null) {
      this.i = new QQProgressDialog(getQBaseActivity());
    }
    this.i.c(2131887338);
    if (this.i.isShowing()) {
      this.i.dismiss();
    }
    this.i.show();
  }
  
  private boolean k()
  {
    return AVGameUtil.a() == 0;
  }
  
  private void l()
  {
    this.l.setBackgroundDrawable(null);
    if (this.k) {
      return;
    }
    AVGameBaseData localAVGameBaseData = this.d.a(1);
    if ((localAVGameBaseData != null) && ((localAVGameBaseData instanceof AVGameLobbyCreateAndJoinContentInfo))) {
      ((AVGameLobbyCreateAndJoinContentInfo)localAVGameBaseData).e = true;
    }
  }
  
  public AppInterface a()
  {
    return (AppInterface)this.b.getAppRuntime();
  }
  
  public void a(int paramInt)
  {
    ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B012", "0X800B012", 0, 0, "", String.valueOf(paramInt), "", "");
    IAvGameManager localIAvGameManager = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if ((localIAvGameManager != null) && (localIAvGameManager.isAvGameRoomExistReEnterDialog(this.b))) {
      return;
    }
    AVGameJoinRoomFragment.a(this.b, null);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ((AvGameRoomListHandler)((AppInterface)this.b.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a)).a(paramInt, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "reservePKGame start");
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
    ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "survival_main_clk", "survival_main_clk", 0, 0, "", "", "", String.valueOf(paramInt));
  }
  
  public void b()
  {
    ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B694", "0X800B694", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(getQBaseActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", b("https://ti.qq.com/tucao/index.html?productId=280793&_wv=1"));
    getQBaseActivity().startActivity(localIntent);
  }
  
  public void b(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    IAvGameManager localIAvGameManager = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null)
    {
      int i1;
      if (localIAvGameManager.isAvGameRoomExist()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gameType:");
        localStringBuilder.append(paramInt);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B493", "0X800B493", i1, 0, String.valueOf(paramInt), "2", "", "");
      Object localObject = this.b;
      if (!paramBoolean) {
        i1 = 11;
      } else {
        i1 = 13;
      }
      localIAvGameManager.startStrangerMatchV2((Activity)localObject, paramInt, 1, i1);
    }
  }
  
  public void c()
  {
    ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B011", "0X800B011", 0, 0, "", "", "", "");
    Object localObject1 = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if (localObject1 != null)
    {
      Object localObject2 = this.b;
      int i1;
      if (this.k) {
        i1 = 8;
      } else {
        i1 = 12;
      }
      ((IAvGameManager)localObject1).createAvGameRoom((Activity)localObject2, i1, this.b.getAppRuntime().getCurrentAccountUin(), 0);
      if (((IAvGameManager)localObject1).isAvGameRoomExist()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      localObject2 = this.b.getAppRuntime();
      if (this.k) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800B011", "0X800B011", i1, 0, "", (String)localObject1, "", "");
      return;
    }
    QQToast.makeText(this.b, 2, 2131887404, 0).show();
  }
  
  public void c(int paramInt, boolean paramBoolean)
  {
    ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B691", "0X800B691", 0, 0, "", "", "", "");
    IAvGameManager localIAvGameManager = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null) {
      localIAvGameManager.startSurvivalGame(this.b, paramInt, paramBoolean, 2);
    }
  }
  
  public void d()
  {
    IAvGameManager localIAvGameManager = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if (localIAvGameManager != null)
    {
      int i1;
      if (localIAvGameManager.isAvGameRoomExist()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B493", "0X800B493", i1, 0, "0", "1", "", "");
      if (AVGameUtil.b() == 0)
      {
        localIAvGameManager.startStrangerMatch(this.b, 9);
        return;
      }
      localIAvGameManager.startStrangerMatchV2(this.b, 0, 0, 11);
    }
  }
  
  public boolean e()
  {
    Object localObject = (IQQActivateFriendService)this.b.getAppRuntime().getRuntimeService(IQQActivateFriendService.class, "");
    boolean bool;
    if (localObject == null) {
      bool = false;
    } else {
      bool = ((IQQActivateFriendService)localObject).getSwitchValue(true);
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRemindSwitch-> isSettingOpen:");
      localStringBuilder.append(bool);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "openQQRemind run");
    }
    QQNotifyUtils.a(getQBaseActivity(), "6ac7725e6d8354412b250277c07b5eed", null, "1e21f0aac11186123d5e9426293143e3", 100);
  }
  
  public void g()
  {
    if (!this.k) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B013", "0X800B013", 0, 0, "", (String)localObject, "", "");
    Object localObject = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if ((localObject != null) && (!TextUtils.isEmpty(((IAvGameManager)localObject).getAvGameRoomId())))
    {
      ((IAvGameManager)localObject).joinAvGameRoom(this.b, 4, ((IAvGameManager)localObject).getAvGameRoomId(), null);
      return;
    }
    if ((localObject != null) && (((IAvGameManager)localObject).isCurrentPkSurvivalEmptyRoom()))
    {
      AvGameLoadingActivity.a(false, getActivity(), null, ((IAvGameManager)localObject).getAvGameRoomId(), null, "", false, true, null);
      return;
    }
    QQToast.makeText(this.b, 2, 2131887405, 0).show();
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
        paramIntent = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQRemind-> retmsg=");
        localStringBuilder.append(str);
        localStringBuilder.append(", retcode=");
        localStringBuilder.append(paramInt1);
        QLog.d(paramIntent, 2, localStringBuilder.toString());
      }
      if ((paramInt1 == 0) || (paramInt1 == 5))
      {
        paramIntent = c(this.m);
        if (paramIntent == null) {
          return;
        }
        a(paramIntent.f(), paramIntent.i() ^ true);
        paramIntent.b(false);
        this.c.notifyDataSetChanged();
        ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B690", "0X800B690", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getQBaseActivity();
    this.h = new AVGameLobbyViewHolderContext();
    this.h.a((AppInterface)this.b.getAppRuntime());
    paramBundle = AvGameConfigUtil.a();
    this.g = paramBundle.k();
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("avGameConfBean:");
      localStringBuilder.append(paramBundle.toString());
      localStringBuilder.append("  avGameConfBean.isStrangerMatchShow：");
      localStringBuilder.append(paramBundle.k());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    AVGameLobbyFixedContentInfo.a(this.g);
    AsyncExitTask.a();
    this.k = k();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GameRoomViewLayoutParamsDef.a(getQBaseActivity(), false);
    h();
    i();
    paramViewGroup = paramLayoutInflater.inflate(2131624276, paramViewGroup, false);
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getQBaseActivity().getWindow());
    }
    this.l = ((RelativeLayout)paramViewGroup.findViewById(2131429115));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout.LayoutParams)this.l.getLayoutParams()).height = (ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()) + ViewUtils.dip2px(44.0F));
      this.l.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (RecyclerView)paramViewGroup.findViewById(2131429097);
    paramLayoutInflater.setLayoutManager(new GridLayoutManager(this.b, 3));
    paramLayoutInflater.setAdapter(this.c);
    this.c.notifyDataSetChanged();
    paramLayoutInflater = (AsyncImageView)paramViewGroup.findViewById(2131429076);
    paramLayoutInflater.setDefaultColorDrawable(0);
    paramLayoutInflater.setAsyncImage("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_bg2.png");
    this.e = ((TextView)paramViewGroup.findViewById(2131429075));
    this.e.setOnClickListener(new AVGameRoomCenterFragment.1(this));
    float f1 = getQBaseActivity().getResources().getDisplayMetrics().density;
    paramLayoutInflater = this.e;
    int i1 = (int)(f1 * 5.0F + 0.5F);
    BaseAIOUtils.a(paramLayoutInflater, i1, i1, i1, i1);
    this.f = ((ImageView)paramViewGroup.findViewById(2131429074));
    this.f.setOnClickListener(new AVGameRoomCenterFragment.2(this));
    AvGameManagerImpl.asyncPreloadAVGameProcess(this.b.getAppRuntime());
    paramBundle = this.b.getAppRuntime();
    if (this.k) {
      paramLayoutInflater = "1";
    } else {
      paramLayoutInflater = "2";
    }
    ReportController.b(paramBundle, "dc00898", "", "", "0X800B49D", "0X800B49D", 0, 0, "", paramLayoutInflater, "", "");
    if ((this.k) && (this.g)) {
      ReportController.b(this.b.getAppRuntime(), "dc00898", "", "", "0X800B49E", "0X800B49E", 0, 0, "0", "1", "", "");
    }
    ((ConfigHandler)((AppInterface)this.b.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).p();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((AppInterface)((QBaseActivity)localObject).getAppRuntime()).removeObserver(this.n);
      localObject = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    }
    else
    {
      localObject = null;
    }
    if (localObject != null) {
      ((IAvGameManager)localObject).setLobbyEntryStatus(false);
    }
    localObject = this.c;
    if (localObject != null) {
      ((BaseAdapter)localObject).a();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((AppInterface)((QBaseActivity)localObject).getAppRuntime()).removeObserver(this.n);
      localObject = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
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
    Object localObject = (IAvGameManager)this.b.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
    if ((localObject != null) && (((IAvGameManager)localObject).isAvGameRoomExist())) {
      this.e.setVisibility(0);
    } else {
      this.e.setVisibility(8);
    }
    if (localObject != null) {
      ((IAvGameManager)localObject).setLobbyEntryStatus(true);
    }
    if (this.j)
    {
      j();
      this.j = false;
      return;
    }
    localObject = this.i;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.i.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment
 * JD-Core Version:    0.7.0.1
 */