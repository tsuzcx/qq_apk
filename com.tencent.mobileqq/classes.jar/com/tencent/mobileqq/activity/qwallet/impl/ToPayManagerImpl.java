package com.tencent.mobileqq.activity.qwallet.impl;

import Wallet.PfaFriend;
import Wallet.PfaFriendRqt;
import Wallet.PfaFriendRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.qwallet.IToPayManager;
import com.tencent.mobileqq.activity.qwallet.IToPayManager.TopayListener;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class ToPayManagerImpl
  implements IToPayManager
{
  private static final String TAG = "TopayManager";
  public static WeakReference<IToPayManager.TopayListener> gWeakListener;
  protected static WeakReference<QWalletPayProgressDialog> gWeakProgress;
  protected static int mBusinessSubType = 0;
  protected static int mBusinessType;
  public static PfaFriendRsp mData;
  protected static Handler mHandler = new ToPayManagerImpl.3(Looper.myLooper());
  public static int mLoadedFromFileState = -1;
  protected static QWalletAuthObserver mRecentListObserver = new QWalletAuthObserver(mHandler);
  
  static
  {
    mData = null;
    mBusinessType = 0;
  }
  
  public static ArrayList<PfaFriend> getRecentList()
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {}
    do
    {
      do
      {
        return null;
        localObject1 = localQQAppInterface.getProxyManager().a();
      } while (localObject1 == null);
      localObject2 = ((RecentUserProxy)localObject1).a(true);
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1006) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 1) && ((localRecentUser.getType() != 0) || (!CrmUtils.b(localQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000))
      {
        PfaFriend localPfaFriend = new PfaFriend();
        localPfaFriend.uin = localRecentUser.uin;
        ((ArrayList)localObject1).add(localPfaFriend);
      }
    }
    return localObject1;
  }
  
  private static void gotoAio(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    if (paramList1.size() == 1)
    {
      Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", (String)paramList1.get(0));
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uinname", (String)paramList2.get(0));
      localIntent.setFlags(335544320);
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
      if (paramList1.size() > 1)
      {
        paramList1 = new Intent(paramActivity, SplashActivity.class);
        paramList1.putExtra("tab_index", FrameControllerUtil.a);
        paramList1.setFlags(67108864);
        paramActivity.startActivity(paramList1);
      }
    }
  }
  
  protected static void notifyUi(boolean paramBoolean)
  {
    if (gWeakListener != null)
    {
      IToPayManager.TopayListener localTopayListener = (IToPayManager.TopayListener)gWeakListener.get();
      if (localTopayListener != null) {
        localTopayListener.b(paramBoolean);
      }
    }
  }
  
  protected static void onGetRecomendList(boolean paramBoolean1, PfaFriendRsp paramPfaFriendRsp, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && ((!paramBoolean1) || (paramPfaFriendRsp == null) || ((paramPfaFriendRsp != null) && (paramPfaFriendRsp.ret != 0)))) {
      return;
    }
    if ((!paramBoolean2) && (mData != null) && (paramPfaFriendRsp != null) && ((paramPfaFriendRsp.vecPfaMsg == null) || (paramPfaFriendRsp.vecPfaMsg.size() <= 0)))
    {
      mData.vecRec = paramPfaFriendRsp.vecRec;
      mData.use_default = paramPfaFriendRsp.use_default;
      mData.vecSpfaRec = paramPfaFriendRsp.vecSpfaRec;
      label85:
      if (paramBoolean2) {
        break label127;
      }
    }
    label127:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      notifyUi(paramBoolean1);
      if ((paramBoolean2) || (mData == null)) {
        break;
      }
      ThreadManager.getFileThreadHandler().post(new ToPayManagerImpl.2());
      return;
      mData = paramPfaFriendRsp;
      break label85;
    }
  }
  
  protected static void refreshFromNet(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.addObserver(mRecentListObserver);
    PfaFriendRqt localPfaFriendRqt = new PfaFriendRqt();
    localPfaFriendRqt.mqq_version = DeviceInfoUtil.a(BaseApplicationImpl.getContext());
    if (mData != null)
    {
      localPfaFriendRqt.pfa_msg_edition = mData.pfa_msg_edition;
      TicketManager localTicketManager = (TicketManager)localQQAppInterface.getManager(2);
      if (localTicketManager != null) {
        localPfaFriendRqt.skey = localTicketManager.getSkey(localQQAppInterface.getCurrentAccountUin());
      }
      localPfaFriendRqt.pfa_sub_type = 0;
      if (paramInt1 == 1)
      {
        if (paramInt2 != 1) {
          break label125;
        }
        localPfaFriendRqt.pfa_sub_type = 1;
      }
    }
    for (;;)
    {
      ((QWalletAuthHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a(localPfaFriendRqt);
      return;
      localPfaFriendRqt.pfa_msg_edition = "0";
      break;
      label125:
      if (paramInt2 == 2) {
        localPfaFriendRqt.pfa_sub_type = 2;
      }
    }
  }
  
  public static void sendTopay(BaseActivity paramBaseActivity, ArrayList<ResultRecord> paramArrayList, QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()) || (paramBaseActivity.getIntent() == null) || (paramBaseActivity.getIntent().getExtras() == null)) {}
    ResultReceiver localResultReceiver;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    label136:
    label174:
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramArrayList == null) || (paramArrayList.size() <= 0));
        localResultReceiver = (ResultReceiver)paramBaseActivity.getIntent().getParcelableExtra("aapay_result_recevier");
      } while (localResultReceiver == null);
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        localArrayList1.add(localResultRecord.uin);
        if (localResultRecord.phone == null)
        {
          paramArrayList = "";
          localArrayList2.add(paramArrayList);
          if (localResultRecord.name != null) {
            break label174;
          }
        }
        for (paramArrayList = "";; paramArrayList = localResultRecord.name)
        {
          localArrayList3.add(paramArrayList);
          break;
          paramArrayList = localResultRecord.phone;
          break label136;
        }
      }
    } while (localArrayList1.size() <= 0);
    paramArrayList = new Bundle();
    paramArrayList.putStringArrayList("choose_friend_uins", localArrayList1);
    paramArrayList.putStringArrayList("choose_friend_phones", localArrayList2);
    paramArrayList.putStringArrayList("choose_friend_names", localArrayList3);
    if (paramQQCustomDialogWtihInputAndChoose != null) {
      paramArrayList.putString("choose_friend_feedback", paramQQCustomDialogWtihInputAndChoose.getInputValue());
    }
    paramQQCustomDialogWtihInputAndChoose = new ToPayManagerImpl.5(null, new WeakReference(paramBaseActivity), localResultReceiver, localArrayList1, localArrayList3);
    showProgress(paramBaseActivity, true);
    paramBaseActivity = Parcel.obtain();
    paramQQCustomDialogWtihInputAndChoose.writeToParcel(paramBaseActivity, 0);
    paramBaseActivity.setDataPosition(0);
    paramQQCustomDialogWtihInputAndChoose = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramBaseActivity);
    paramBaseActivity.recycle();
    paramArrayList.putParcelable("callback", paramQQCustomDialogWtihInputAndChoose);
    localResultReceiver.send(0, paramArrayList);
  }
  
  private static void showBackDialogTip(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    ToPayManagerImpl.6 local6 = new ToPayManagerImpl.6(paramActivity);
    paramList1 = new ToPayManagerImpl.7(paramActivity, paramList1, paramList2);
    paramActivity = DialogUtil.a(paramActivity, 230, null, HardCodeUtil.a(2131714897), HardCodeUtil.a(2131714895), "留在QQ", paramList1, local6);
    paramActivity.setCancelable(false);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.show();
  }
  
  private static void showProgress(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing())) {}
    do
    {
      return;
      Object localObject = null;
      if (paramBoolean)
      {
        paramBaseActivity = new QWalletPayProgressDialog(paramBaseActivity);
        gWeakProgress = new WeakReference(paramBaseActivity);
        paramBaseActivity.show();
        return;
      }
      paramBaseActivity = localObject;
      if (gWeakProgress != null) {
        paramBaseActivity = (QWalletPayProgressDialog)gWeakProgress.get();
      }
    } while ((paramBaseActivity == null) || (!paramBaseActivity.isShowing()));
    paramBaseActivity.dismiss();
  }
  
  public HashMap<String, Object> getTopayList(IToPayManager.TopayListener paramTopayListener, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    gWeakListener = new WeakReference(paramTopayListener);
    if ((paramInt1 != mBusinessType) || (paramInt2 != mBusinessSubType))
    {
      mData = null;
      mLoadedFromFileState = -1;
      mBusinessType = paramInt1;
      mBusinessSubType = paramInt2;
    }
    paramTopayListener = new HashMap();
    if (mData == null)
    {
      paramTopayListener.put("recommend", getRecentList());
      if (mLoadedFromFileState == -1)
      {
        mLoadedFromFileState = 1;
        ThreadManager.getFileThreadHandler().post(new ToPayManagerImpl.1(this, paramInt1, paramInt2, paramBoolean));
        return paramTopayListener;
      }
    }
    else
    {
      if (mData.use_default != 1) {
        break label147;
      }
      paramTopayListener.put("recommend", getRecentList());
    }
    for (;;)
    {
      paramTopayListener.put("tips", mData.vecPfaMsg);
      if (!paramBoolean) {
        break;
      }
      refreshFromNet(paramInt1, paramInt2);
      return paramTopayListener;
      label147:
      paramTopayListener.put("recommend", mData.vecRec);
    }
  }
  
  public void removeObserver(AppRuntime paramAppRuntime)
  {
    mLoadedFromFileState = -1;
    mData = null;
    if (gWeakListener != null)
    {
      gWeakListener.clear();
      gWeakListener = null;
    }
    if (gWeakProgress != null)
    {
      gWeakProgress.clear();
      gWeakProgress = null;
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppRuntime).removeObserver(mRecentListObserver);
    }
  }
  
  public void topay(BaseActivity paramBaseActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()) || (paramBaseActivity.getIntent() == null) || (paramBaseActivity.getIntent().getExtras() == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = HardCodeUtil.a(2131714896);
    Object localObject1 = localObject2;
    int i;
    label60:
    ResultRecord localResultRecord;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      i = 0;
      if (i < paramArrayList.size())
      {
        localResultRecord = (ResultRecord)paramArrayList.get(i);
        localObject2 = localObject1;
        if (localResultRecord != null)
        {
          localObject2 = localObject1;
          if (localResultRecord.type == 0)
          {
            localObject2 = localObject1;
            if (localResultRecord.uin != null)
            {
              localArrayList.add(localResultRecord);
              if (TextUtils.isEmpty(localResultRecord.name)) {
                break label199;
              }
              localObject1 = (String)localObject1 + localResultRecord.name;
              label155:
              if (i >= paramArrayList.size() - 1) {
                break label390;
              }
            }
          }
        }
      }
    }
    label390:
    for (localObject2 = (String)localObject1 + "、";; localObject2 = localObject1)
    {
      i += 1;
      localObject1 = localObject2;
      break label60;
      label199:
      localObject1 = (String)localObject1 + localResultRecord.uin;
      break label155;
      if (localArrayList.size() <= 0)
      {
        QQToast.a(paramBaseActivity, paramBaseActivity.getString(2131719993), 0).a();
        return;
      }
      paramArrayList = new ToPayManagerImpl.4(this, new WeakReference(paramBaseActivity), localArrayList);
      if (!(paramBaseActivity instanceof SelectMemberActivity)) {
        break;
      }
      localObject2 = paramBaseActivity.getIntent().getExtras();
      paramBaseActivity = DialogUtils.a(paramBaseActivity, (String)localObject1, ((Bundle)localObject2).getString("choose_friend_content"), ((Bundle)localObject2).getString("choose_friend_subcontent"), ((SelectMemberActivity)paramBaseActivity).f, null, paramArrayList, paramArrayList, 36, false);
      ReportController.b(QWalletTools.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.windowshow", 0, 0, "", "", "", "");
      paramBaseActivity = paramBaseActivity.getTitleTextView();
      if (paramBaseActivity == null) {
        break;
      }
      paramBaseActivity.setSingleLine(false);
      paramBaseActivity.setMaxLines(2);
      paramBaseActivity.setEllipsize(TextUtils.TruncateAt.END);
      paramBaseActivity.setGravity(3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.impl.ToPayManagerImpl
 * JD-Core Version:    0.7.0.1
 */