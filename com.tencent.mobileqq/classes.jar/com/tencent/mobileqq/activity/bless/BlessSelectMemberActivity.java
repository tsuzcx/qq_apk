package com.tencent.mobileqq.activity.bless;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlessSelectMemberActivity
  extends SelectMemberActivity
  implements Handler.Callback
{
  private static boolean A = false;
  private static MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  public static String a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static String b;
  private static AtomicBoolean b;
  private static long jdField_c_of_type_Long;
  private static long d;
  private static long e;
  private static long f;
  private static long g;
  private static int jdField_k_of_type_Int = 1;
  protected Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new BlessSelectMemberActivity.10(this);
  private BlessSelectMemberActivity.BlessPTVUploadTask jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask;
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new BlessSelectMemberActivity.11(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new BlessSelectMemberActivity.1(this);
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
  protected ArrayList<String> a;
  protected boolean a;
  private Dialog jdField_c_of_type_AndroidAppDialog = null;
  private long h = 0L;
  private String i = null;
  private String j;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int = 0;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int = 0;
  private String jdField_m_of_type_JavaLangString;
  private int jdField_n_of_type_Int;
  private String jdField_n_of_type_JavaLangString = null;
  
  static
  {
    jdField_c_of_type_Long = 60000L;
    jdField_d_of_type_Long = 60000L;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_e_of_type_Long = 0L;
    f = 0L;
    g = 0L;
  }
  
  public BlessSelectMemberActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a(int paramInt)
  {
    int i1 = 0;
    if ((paramInt == 15) || (paramInt == 16)) {
      i1 = 1;
    }
    while (paramInt != 32) {
      return i1;
    }
    return 2;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), 2131690800, 2131693573, new BlessSelectMemberActivity.8(paramContext), new BlessSelectMemberActivity.9()).show();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new BlessSelectMemberActivity.7(paramBoolean, paramContext), null).show();
  }
  
  private void g(String paramString)
  {
    if (!a())
    {
      e();
      return;
    }
    if (!paramString.equals(""))
    {
      this.jdField_a_of_type_Boolean = true;
      ChatActivityFacade.a(this.app, paramString, this.jdField_a_of_type_JavaUtilArrayList, null);
      return;
    }
    QLog.e("BlessSelectMemberActivity", 1, "Blesswords is null!");
    e();
  }
  
  private void u()
  {
    Object localObject = new EncodeVideoTask.ThumbInfo(this.jdField_l_of_type_JavaLangString, this.jdField_m_of_type_JavaLangString, null, 0, 0);
    String str = this.jdField_k_of_type_JavaLangString;
    if (this.jdField_n_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new EncodeVideoTask(this, str, bool, (EncodeVideoTask.ThumbInfo)localObject);
      ((EncodeVideoTask)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener);
      ((EncodeVideoTask)localObject).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[] { (Void)null });
      return;
    }
  }
  
  private void v()
  {
    boolean bool = true;
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
    MessageForBlessPTV localMessageForBlessPTV = (MessageForBlessPTV)localMessageForShortVideo;
    if (localMessageForBlessPTV != null)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_d_of_type_Int == 15)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 10) {
          localMessageForBlessPTV.needUpdateMsgTag = bool;
        }
      }
      else {
        this.app.getMessageFacade().a(this.app, localMessageForShortVideo, localMessageForBlessPTV.uinList, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(2, localMessageForBlessPTV.videoFileTime));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    QLog.i("BlessSelectMemberActivity", 2, "error case no ptv message in manager");
  }
  
  private void w()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_d_of_type_Int == 15)
      {
        localMessageForPic = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 10) {
          localMessageForPic.needUpdateMsgTag = bool;
        }
      }
      else
      {
        this.app.getMessageFacade().a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(3, 0));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        MessageForPic localMessageForPic;
        return;
        bool = false;
      }
    }
    QLog.i("BlessSelectMemberActivity", 2, "sendBlessPic failed!" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic + " ,uinList:" + this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void x()
  {
    if (this.jdField_m_of_type_Int == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_m_of_type_Int = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    if ((this.jdField_d_of_type_Int == 15) || (this.jdField_d_of_type_Int == 32))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (this.jdField_e_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          this.jdField_a_of_type_JavaUtilArrayList.add(localResultRecord.uin);
        }
      }
      d();
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_e_of_type_JavaUtilArrayList);
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    finish();
  }
  
  public void a(long paramLong)
  {
    long l1 = 300L;
    if (paramLong > 300L) {
      paramLong = l1;
    }
    for (;;)
    {
      l1 = paramLong;
      if (paramLong <= 0L) {
        l1 = 15L;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "setSendMsgOverloadDuration: " + l1);
      }
      jdField_e_of_type_Long = l1;
      return;
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755842);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558815);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new BlessSelectMemberActivity.5(this));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131379126).setOnClickListener(new BlessSelectMemberActivity.6(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      localObject = getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setAttributes(localLayoutParams);
      if (this.jdField_l_of_type_Int == 2)
      {
        localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373066);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131719049);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        if (QLog.isColorLevel()) {
          QLog.e("BlessSelectMemberActivity", 2, "showProgressDialog");
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
      ((TextView)localObject).setText(paramString);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i1 = (int)((System.currentTimeMillis() - this.h) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb result:" + paramBoolean + " ,type:" + this.jdField_l_of_type_Int + " ,cost:" + i1);
    }
    if (paramBoolean)
    {
      e();
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.BlessJsApiPlugin");
      localIntent.putExtra("callback", this.j);
      localIntent.putExtra("bless_type", this.jdField_l_of_type_Int);
      localIntent.putExtra("bless_num", this.jdField_a_of_type_JavaUtilArrayList.size());
      if ((this.jdField_l_of_type_Int == 1) && (!TextUtils.isEmpty(this.i))) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_l_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
      }
      for (;;)
      {
        sendBroadcast(localIntent);
        finish();
        return;
        if ((this.jdField_l_of_type_Int == 2) || (this.jdField_l_of_type_Int == 3))
        {
          Object localObject = new Intent("tencent.video.q2v.startUploadPTV");
          ((Intent)localObject).putExtra("broadcastType", 1);
          ((Intent)localObject).putExtra("recordType", this.jdField_l_of_type_Int);
          this.app.getApp().sendBroadcast((Intent)localObject);
          if ((this.jdField_l_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a() != null))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().uuid, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().md5);
            localIntent.putExtra("bless_ptv_url", (String)localObject);
            localIntent.putExtra("bless_ptv_uuid", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().uuid);
            localIntent.putExtra("bless_ptv_md5", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().md5);
            localIntent.putExtra("bless_ptv_nick", Base64Util.encodeToString(this.app.getCurrentNickname().getBytes(), 2));
            localIntent.putExtra("ptv_file_path", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().videoFileName);
            localIntent.putExtra("ptv_thumb_path", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().mThumbFilePath);
            if (QLog.isColorLevel()) {
              QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb ptvurl:" + (String)localObject);
            }
          }
        }
      }
    }
    QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.jdField_l_of_type_Int);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = (int)((System.currentTimeMillis() - this.h) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResult result:" + paramBoolean1 + " ,type:" + this.jdField_l_of_type_Int + " ,cost:" + i1);
    }
    if (paramBoolean1)
    {
      e();
      if ((this.jdField_l_of_type_Int == 1) && (!this.i.equals("")))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.i);
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c();
        b(paramBoolean2);
        ReportController.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_l_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
      }
      while ((this.jdField_l_of_type_Int != 2) && (this.jdField_l_of_type_Int != 3)) {
        return;
      }
      b(paramBoolean2);
      return;
    }
    QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.jdField_l_of_type_Int);
  }
  
  public boolean a()
  {
    if (jdField_e_of_type_Long > 0L)
    {
      long l1 = System.currentTimeMillis() - f;
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "send text overload=" + l1 / 1000L + " duration=" + jdField_e_of_type_Long);
      }
      if (l1 > jdField_e_of_type_Long * 1000L)
      {
        a(0L);
        f = 0L;
      }
    }
    else
    {
      return true;
    }
    a(this, 2131690746, true);
    return false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131165389));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131165384));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131165384));
  }
  
  public void b(String paramString)
  {
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).d(1056);
    ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    ((PicUploadInfo.Builder)localObject).d("0");
    ((PicUploadInfo.Builder)localObject).c(this.app.getCurrentAccountUin());
    ((PicUploadInfo.Builder)localObject).e(0);
    paramString = ((PicUploadInfo.Builder)localObject).a();
    paramString.b = false;
    localObject = PicBusiManager.a(2, 1056);
    ((PicReq)localObject).a(paramString);
    PicBusiManager.a((PicReq)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", this.jdField_l_of_type_Int);
    this.app.getApp().sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_JavaUtilArrayList, a(this.jdField_d_of_type_Int));
    if (this.jdField_d_of_type_Int == 32)
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra(MessageConstants.h, paramBoolean);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
      finish();
      QQToast.a(this, 2, 2131720646, 1).a();
    }
  }
  
  protected void c()
  {
    Object localObject = ((BlessManager)getAppInterface().getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a();
    boolean bool;
    if (localObject != null)
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).findProcessor(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
      if ((localIHttpCommunicatorListener != null) && (ShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)))
      {
        bool = ((BaseTransProcessor)localIHttpCommunicatorListener).isPause();
        int i1 = ((MessageForShortVideo)localObject).videoFileStatus;
        if ((bool) || (i1 == 1002) || (i1 == 1001)) {
          AioVideoTransFileController.d(this.app, ((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      localObject = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).findProcessor(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
      if ((localObject != null) && (C2CPicUploadProcessor.class.isInstance(localObject)))
      {
        bool = ((BaseTransProcessor)localObject).isPause();
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "stop pic upload, pause:" + bool);
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "cancel the uploadTask!");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask.cancel(true);
    }
  }
  
  protected void d()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.jdField_l_of_type_Int), "", "", "");
    if ((this.jdField_n_of_type_JavaLangString == null) || (this.jdField_c_of_type_AndroidAppDialog == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_d_of_type_Int == 15) {
        localStringBuilder.append(getString(2131690742));
      }
      for (;;)
      {
        localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        int i1 = 0;
        while ((i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i1 < 50))
        {
          Friends localFriends = ((FriendsManager)localObject).e((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          if (localFriends != null) {
            localStringBuilder.append(localFriends.getFriendNick()).append("、 ");
          }
          i1 += 1;
        }
        if (this.jdField_d_of_type_Int == 32) {
          localStringBuilder.append(getString(2131720645));
        }
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
        localStringBuilder.append(String.format(getString(2131690743), new Object[] { "", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
      }
      this.jdField_n_of_type_JavaLangString = localStringBuilder.toString();
      this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, -1, null, this.jdField_n_of_type_JavaLangString, 2131690800, 2131690741, new BlessSelectMemberActivity.2(this), new BlessSelectMemberActivity.3(this));
      if (this.jdField_l_of_type_Int == 2)
      {
        localObject = this.jdField_c_of_type_AndroidAppDialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
      Object localObject = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131365807);
      ((TextView)localObject).setMaxLines(4);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).post(new BlessSelectMemberActivity.4(this, (TextView)localObject, localStringBuilder));
    }
    if (!isFinishing()) {
      this.jdField_c_of_type_AndroidAppDialog.show();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_l_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_blesstype");
    this.i = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_blessword_content");
    this.jdField_n_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("encode_type", 0);
    this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("fake_id");
    this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
    this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_md5");
    this.j = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_web_callback");
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    x();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    jdField_k_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "";
    A = false;
    this.t = false;
    jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    paramBundle = new Intent("tencent.video.q2v.startUploadPTV");
    paramBundle.putExtra("broadcastType", 2);
    this.app.getApp().sendBroadcast(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(2);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "destroy the uploadTask!");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask.cancel(true);
    }
    try
    {
      if (this.jdField_m_of_type_Int == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_m_of_type_Int = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
      g = 0L;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
        }
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    d();
    ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      int i1 = getResources().getColor(2131165389);
      this.mSystemBarComp.setStatusColor(i1);
      this.mSystemBarComp.setStatusBarColor(i1);
    }
  }
  
  protected void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog");
        }
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
        jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(2);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  protected void f()
  {
    a(null);
    A = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.h = System.currentTimeMillis();
    jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(2, jdField_d_of_type_Long);
    if (this.jdField_l_of_type_Int == 1) {
      g(this.i);
    }
    do
    {
      do
      {
        return;
        if (this.jdField_l_of_type_Int != 2) {
          break;
        }
        if (!a())
        {
          e();
          return;
        }
        new BlessSelectMemberActivity.BlessPTVProcessTask(this.app, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask.getStatus() != AsyncTask.Status.FINISHED))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessSelectMemberActivity", 2, "There is still a running uploadTask!");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask.cancel(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask = new BlessSelectMemberActivity.BlessPTVUploadTask(this.app, this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessSelectMemberActivity$BlessPTVUploadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      } while (getIntent().getIntExtra("param_key_redbag_type", 0) != LocalMediaInfo.REDBAG_TYPE_GET);
      FlowCameraMqqAction.a("", "0X80088E4", this.jdField_a_of_type_JavaUtilArrayList.size(), "3");
      return;
    } while (this.jdField_l_of_type_Int != 3);
    if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString))
    {
      QQToast.a(this, 1, 2131698884, 1).a();
      e();
      finish();
      return;
    }
    b(this.jdField_l_of_type_JavaLangString);
  }
  
  public void finish()
  {
    super.finish();
    if ((this.jdField_d_of_type_Int == 15) || (this.jdField_d_of_type_Int == 32)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send video cannel!");
      }
      c();
      A = true;
      e();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send bless msg timeout!");
      }
      c();
      A = true;
      e();
      a(this, 2131719395);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage realStartEncode!");
      }
      u();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.g())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
      if ((localObject != null) && (((ArrayList)localObject).size() >= 0))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = localFriendsManager.e(str);
          if (localFriends != null) {
            localArrayList.add(a(str, localFriends.getFriendNick(), 0, "-1"));
          }
        }
        a(localArrayList, true);
        ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */