package com.tencent.mobileqq.activity.bless;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.AioPicOperator;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import wks;
import wkt;
import wku;
import wkw;
import wkx;
import wky;
import wkz;
import wla;
import wlb;
import wlc;
import wld;
import wle;

public class BlessSelectMemberActivity
  extends SelectMemberActivity
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int = 1;
  private static MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  public static String a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public static String b;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static boolean jdField_b_of_type_Boolean;
  private static long jdField_c_of_type_Long = 60000L;
  private static long d = 60000L;
  private static long e;
  private static long f;
  private static long g;
  public Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new wkt(this);
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new wku(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new wks(this);
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  public ArrayList a;
  private wle jdField_a_of_type_Wle;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private long h;
  private String i;
  private String j;
  private String k;
  private String l;
  private int jdField_m_of_type_Int = -1;
  private String jdField_m_of_type_JavaLangString;
  private int n;
  private int o;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
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
    DialogUtil.b(paramContext, 232, null, paramContext.getString(paramInt), 2131433029, 2131433031, new wlc(paramContext), new wld()).show();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new wlb(paramBoolean, paramContext), null).show();
  }
  
  private void f(String paramString)
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
  
  private void t()
  {
    Object localObject = new EncodeVideoTask.ThumbInfo(this.k, this.l, null, 0, 0);
    String str = this.j;
    if (this.o == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new EncodeVideoTask(this, str, bool, (EncodeVideoTask.ThumbInfo)localObject);
      ((EncodeVideoTask)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener);
      ((EncodeVideoTask)localObject).execute(new Void[0]);
      return;
    }
  }
  
  private void u()
  {
    boolean bool = true;
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
    MessageForBlessPTV localMessageForBlessPTV = (MessageForBlessPTV)localMessageForShortVideo;
    if (localMessageForBlessPTV != null)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_f_of_type_Int == 15)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < 10) {
          localMessageForBlessPTV.needUpdateMsgTag = bool;
        }
      }
      else {
        this.app.a().a(this.app, localMessageForShortVideo, localMessageForBlessPTV.uinList, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(2, localMessageForBlessPTV.videoFileTime));
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
  
  private void v()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_f_of_type_Int == 15)
      {
        localMessageForPic = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < 10) {
          localMessageForPic.needUpdateMsgTag = bool;
        }
      }
      else
      {
        this.app.a().a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(3, 0));
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
  
  private void w()
  {
    if (this.n == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.n = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void W_()
  {
    Object localObject = ((BlessManager)getAppInterface().getManager(137)).a();
    boolean bool;
    if (localObject != null)
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = this.app.a().a(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
      if ((localIHttpCommunicatorListener != null) && (ShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)))
      {
        bool = ((BaseTransProcessor)localIHttpCommunicatorListener).b();
        int i1 = ((MessageForShortVideo)localObject).videoFileStatus;
        if ((bool) || (i1 == 1002) || (i1 == 1001)) {
          this.app.a().c(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
      if ((localObject != null) && (C2CPicUploadProcessor.class.isInstance(localObject)))
      {
        bool = ((BaseTransProcessor)localObject).b();
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "stop pic upload, pause:" + bool);
        }
      }
    }
    if ((this.jdField_a_of_type_Wle != null) && (this.jdField_a_of_type_Wle.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "cancel the uploadTask!");
      }
      this.jdField_a_of_type_Wle.cancel(true);
    }
  }
  
  protected void X_()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.jdField_b_of_type_Int), "", "", "");
    if ((this.jdField_m_of_type_JavaLangString == null) || (this.jdField_c_of_type_AndroidAppDialog == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_f_of_type_Int == 15) {
        localStringBuilder.append(getString(2131438283));
      }
      for (;;)
      {
        localObject = (FriendsManager)this.app.getManager(50);
        int i1 = 0;
        while ((i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i1 < 50))
        {
          Friends localFriends = ((FriendsManager)localObject).c((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          if (localFriends != null) {
            localStringBuilder.append(localFriends.getFriendNick()).append("、 ");
          }
          i1 += 1;
        }
        if (this.jdField_f_of_type_Int == 32) {
          localStringBuilder.append(getString(2131438269));
        }
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
        localStringBuilder.append(String.format(getString(2131438284), new Object[] { "", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
      }
      this.jdField_m_of_type_JavaLangString = localStringBuilder.toString();
      this.jdField_c_of_type_AndroidAppDialog = DialogUtil.b(this, -1, null, this.jdField_m_of_type_JavaLangString, 2131433029, 2131438285, new wkw(this), new wkx(this));
      if (this.jdField_b_of_type_Int == 2)
      {
        localObject = this.jdField_c_of_type_AndroidAppDialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
      Object localObject = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131362781);
      ((TextView)localObject).setMaxLines(4);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).post(new wky(this, (TextView)localObject, localStringBuilder));
    }
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  public void Y_()
  {
    a(null);
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.h = System.currentTimeMillis();
    jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(2, d);
    if (this.jdField_b_of_type_Int == 1) {
      ChatActivityFacade.a(this.app, this.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    }
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_Int != 2) {
          break;
        }
        if (!a())
        {
          e();
          return;
        }
        new BlessSelectMemberActivity.BlessPTVProcessTask(this.app, this).execute(new Void[0]);
        if ((this.jdField_a_of_type_Wle != null) && (this.jdField_a_of_type_Wle.getStatus() != AsyncTask.Status.FINISHED))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessSelectMemberActivity", 2, "There is still a running uploadTask!");
          }
          this.jdField_a_of_type_Wle.cancel(true);
        }
        this.jdField_a_of_type_Wle = new wle(this.app, this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_f_of_type_Int);
        this.jdField_a_of_type_Wle.execute(new Void[0]);
      } while (getIntent().getIntExtra("param_key_redbag_type", 0) != LocalMediaInfo.REDBAG_TYPE_GET);
      FlowCameraMqqAction.a("", "0X80088E4", this.jdField_a_of_type_JavaUtilArrayList.size(), "3");
      return;
    } while (this.jdField_b_of_type_Int != 3);
    if (TextUtils.isEmpty(this.k))
    {
      QQToast.a(this, 1, 2131438834, 1).a();
      e();
      finish();
      return;
    }
    b(this.k);
  }
  
  protected void a()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    if ((this.jdField_f_of_type_Int == 15) || (this.jdField_f_of_type_Int == 32))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (this.jdField_i_of_type_JavaUtilArrayList.size() > 0)
      {
        Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          this.jdField_a_of_type_JavaUtilArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
        }
      }
      X_();
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.jdField_i_of_type_JavaUtilArrayList);
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624516);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130968719);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new wkz(this));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363419).setOnClickListener(new wla(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      localObject = getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setAttributes(localLayoutParams);
      if (this.jdField_b_of_type_Int == 2)
      {
        localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363418);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131434592);
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
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", this.jdField_b_of_type_Int);
    this.app.getApp().sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_JavaUtilArrayList, a(this.jdField_f_of_type_Int));
    if (this.jdField_f_of_type_Int == 32)
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra(MessageConstants.h, paramBoolean);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
      finish();
      QQToast.a(this, 2, 2131438267, 1).a();
      return;
    }
    localIntent = new Intent(this, BlessResultActivity.class);
    localIntent.putExtra("param_method", this.jdField_b_of_type_Int);
    localIntent.putExtra("param_count", this.jdField_a_of_type_JavaUtilArrayList.size());
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a() != null))
    {
      localIntent.putExtra("param_snap_path", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().mThumbFilePath);
      localIntent.putExtra("param_ptv_path", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().videoFileName);
      localIntent.putExtra("param_ptv_uuid", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().uuid);
      localIntent.putExtra("param_ptv_md5", this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().md5);
      localIntent.putExtra(MessageConstants.h, paramBoolean);
    }
    startActivity(localIntent);
    finish();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = (int)((System.currentTimeMillis() - this.h) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResult result:" + paramBoolean1 + " ,type:" + this.jdField_b_of_type_Int + " ,cost:" + i1);
    }
    if (paramBoolean1)
    {
      e();
      if ((this.jdField_b_of_type_Int == 1) && (!this.jdField_i_of_type_JavaLangString.equals("")))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(this.jdField_i_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
        a(paramBoolean2);
        ReportController.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
      }
      for (;;)
      {
        Properties localProperties = new Properties();
        localProperties.setProperty("bless_param_type", "" + this.jdField_b_of_type_Int);
        localProperties.setProperty("bless_param_entrance_type", "" + this.jdField_f_of_type_Int);
        localProperties.setProperty("bless_param_uinlist_size", "" + this.jdField_a_of_type_JavaUtilArrayList.size());
        if (g > 0L) {
          localProperties.setProperty("bless_param_wait_time", "" + g);
        }
        BlessMtaReport.a("bless_event_send_result", localProperties, i1);
        return;
        if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 3)) {
          a(paramBoolean2);
        }
      }
    }
    QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.jdField_b_of_type_Int);
  }
  
  public boolean a()
  {
    if (jdField_e_of_type_Long > 0L)
    {
      long l1 = System.currentTimeMillis() - jdField_f_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "send text overload=" + l1 / 1000L + " duration=" + jdField_e_of_type_Long);
      }
      if (l1 > jdField_e_of_type_Long * 1000L)
      {
        a(0L);
        jdField_f_of_type_Long = 0L;
      }
    }
    else
    {
      return true;
    }
    a(this, 2131438305, true);
    return false;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131493304));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494031));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494031));
  }
  
  public void b(String paramString)
  {
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).d(1006);
    ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.d);
    ((PicUploadInfo.Builder)localObject).d("0");
    ((PicUploadInfo.Builder)localObject).c(this.app.getCurrentAccountUin());
    ((PicUploadInfo.Builder)localObject).e(0);
    paramString = ((PicUploadInfo.Builder)localObject).a();
    paramString.f = true;
    paramString.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)new AioPicOperator(this.app).a(paramString));
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isBlessPic = true;
    }
    paramString.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    localObject = PicBusiManager.a(2, 1006);
    ((PicReq)localObject).a(paramString);
    PicBusiManager.a((PicReq)localObject, this.app);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_blesstype");
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("param_blessword_content");
    this.jdField_m_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_blessword_index");
    this.o = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("encode_type", 0);
    this.j = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("fake_id");
    this.k = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
    this.l = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_md5");
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    w();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_Boolean = false;
    this.w = false;
    jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    paramBundle = new Intent("tencent.video.q2v.startUploadPTV");
    paramBundle.putExtra("broadcastType", 2);
    this.app.getApp().sendBroadcast(paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(2);
    }
    if ((this.jdField_a_of_type_Wle != null) && (this.jdField_a_of_type_Wle.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "destroy the uploadTask!");
      }
      this.jdField_a_of_type_Wle.cancel(true);
    }
    try
    {
      if (this.n == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.n = 0;
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
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    c();
    ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      int i1 = getResources().getColor(2131493304);
      this.mSystemBarComp.setStatusColor(i1);
      this.mSystemBarComp.setStatusBarColor(i1);
    }
  }
  
  public void e()
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
  
  public void finish()
  {
    super.finish();
    if ((this.jdField_f_of_type_Int == 15) || (this.jdField_f_of_type_Int == 32)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
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
      W_();
      jdField_b_of_type_Boolean = true;
      e();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send bless msg timeout!");
      }
      W_();
      jdField_b_of_type_Boolean = true;
      e();
      a(this, 2131437395);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage realStartEncode!");
      }
      t();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.g())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
      if ((localObject != null) && (((ArrayList)localObject).size() >= 0))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = localFriendsManager.c(str);
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