package com.tencent.mobileqq.activity.bless;

import Override;
import acvv;
import ahux;
import ahuz;
import ahvf;
import ahvg;
import ahvh;
import ahvi;
import ahvj;
import ahvk;
import ahvl;
import ahvm;
import ahvn;
import ahvo;
import ahvp;
import ahvq;
import akrx;
import amsw;
import amwl;
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
import ayck;
import aydj;
import ayds;
import ayec;
import bbkv;
import bcef;
import bfuc;
import bfur;
import bjmp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlessSelectMemberActivity
  extends SelectMemberActivity
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int = 1;
  private static long jdField_a_of_type_Long = 60000L;
  private static bjmp jdField_a_of_type_Bjmp;
  public static String a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static long jdField_b_of_type_Long = 60000L;
  public static String b;
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static boolean jdField_b_of_type_Boolean;
  private static long jdField_c_of_type_Long;
  private static long jdField_d_of_type_Long;
  private static long jdField_e_of_type_Long;
  private ahvq jdField_a_of_type_Ahvq;
  private amwl jdField_a_of_type_Amwl = new ahvf(this);
  public Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ahvg(this);
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new ahvh(this);
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  protected ArrayList<String> a;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String jdField_e_of_type_JavaLangString;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  private String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
  }
  
  public static int a(int paramInt)
  {
    int i = 0;
    if ((paramInt == 15) || (paramInt == 16)) {
      i = 1;
    }
    while (paramInt != 32) {
      return i;
    }
    return 2;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    bfur.a(paramContext, 232, null, paramContext.getString(paramInt), 2131690620, 2131693240, new ahvn(paramContext), new ahvo()).show();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    bfur.a(paramContext, 232, null, paramContext.getString(paramInt), new ahvm(paramBoolean, paramContext), null).show();
  }
  
  private void c(String paramString)
  {
    if (!a())
    {
      c();
      return;
    }
    if (!paramString.equals(""))
    {
      this.jdField_a_of_type_Boolean = true;
      acvv.a(this.app, paramString, this.jdField_a_of_type_JavaUtilArrayList, null);
      return;
    }
    QLog.e("BlessSelectMemberActivity", 1, "Blesswords is null!");
    c();
  }
  
  private void e()
  {
    Object localObject = new EncodeVideoTask.ThumbInfo(this.jdField_f_of_type_JavaLangString, this.g, null, 0, 0);
    String str = this.jdField_e_of_type_JavaLangString;
    if (this.jdField_d_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new EncodeVideoTask(this, str, bool, (EncodeVideoTask.ThumbInfo)localObject);
      ((EncodeVideoTask)localObject).setResultListener(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener);
      ((EncodeVideoTask)localObject).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[] { (Void)null });
      return;
    }
  }
  
  private void f()
  {
    boolean bool = true;
    MessageForShortVideo localMessageForShortVideo = this.mBlessManager.a();
    MessageForBlessPTV localMessageForBlessPTV = (MessageForBlessPTV)localMessageForShortVideo;
    if (localMessageForBlessPTV != null)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.mEntrance == 15)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 10) {
          localMessageForBlessPTV.needUpdateMsgTag = bool;
        }
      }
      else {
        this.app.getMessageFacade().sendBlessMsg(this.app, localMessageForShortVideo, localMessageForBlessPTV.uinList, this.mBlessManager.a(2, localMessageForBlessPTV.videoFileTime));
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
  
  private void g()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.mEntrance == 15)
      {
        localMessageForPic = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 10) {
          localMessageForPic.needUpdateMsgTag = bool;
        }
      }
      else
      {
        this.app.getMessageFacade().sendBlessMsg(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_JavaUtilArrayList, this.mBlessManager.a(3, 0));
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
  
  private void h()
  {
    if (this.jdField_c_of_type_Int == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_c_of_type_Int = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a()
  {
    Object localObject = ((ahux)getAppInterface().getManager(138)).a();
    boolean bool;
    if (localObject != null)
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = this.app.getTransFileController().findProcessor(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
      if ((localIHttpCommunicatorListener != null) && (ShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)))
      {
        bool = ((BaseTransProcessor)localIHttpCommunicatorListener).isPause();
        int i = ((MessageForShortVideo)localObject).videoFileStatus;
        if ((bool) || (i == 1002) || (i == 1001)) {
          this.app.getTransFileController().stopSendingShortVideo(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      localObject = this.app.getTransFileController().findProcessor(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
      if ((localObject != null) && (C2CPicUploadProcessor.class.isInstance(localObject)))
      {
        bool = ((BaseTransProcessor)localObject).isPause();
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "stop pic upload, pause:" + bool);
        }
      }
    }
    if ((this.jdField_a_of_type_Ahvq != null) && (this.jdField_a_of_type_Ahvq.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "cancel the uploadTask!");
      }
      this.jdField_a_of_type_Ahvq.cancel(true);
    }
  }
  
  public void a(long paramLong)
  {
    long l = 300L;
    if (paramLong > 300L) {
      paramLong = l;
    }
    for (;;)
    {
      l = paramLong;
      if (paramLong <= 0L) {
        l = 15L;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "setSendMsgOverloadDuration: " + l);
      }
      jdField_c_of_type_Long = l;
      return;
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755826);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558750);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new ahvk(this));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131378403).setOnClickListener(new ahvl(this));
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
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372546);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131718141);
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
    int i = (int)((System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb result:" + paramBoolean + " ,type:" + this.jdField_b_of_type_Int + " ,cost:" + i);
    }
    if (paramBoolean)
    {
      c();
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.BlessJsApiPlugin");
      localIntent.putExtra("callback", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("bless_type", this.jdField_b_of_type_Int);
      localIntent.putExtra("bless_num", this.jdField_a_of_type_JavaUtilArrayList.size());
      if ((this.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        bcef.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
      }
      for (;;)
      {
        sendBroadcast(localIntent);
        finish();
        return;
        if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 3))
        {
          Object localObject = new Intent("tencent.video.q2v.startUploadPTV");
          ((Intent)localObject).putExtra("broadcastType", 1);
          ((Intent)localObject).putExtra("recordType", this.jdField_b_of_type_Int);
          this.app.getApp().sendBroadcast((Intent)localObject);
          if ((this.jdField_b_of_type_Int == 2) && (this.mBlessManager.a() != null))
          {
            localObject = this.mBlessManager.a(this.mBlessManager.a().uuid, this.mBlessManager.a().md5);
            localIntent.putExtra("bless_ptv_url", (String)localObject);
            localIntent.putExtra("bless_ptv_uuid", this.mBlessManager.a().uuid);
            localIntent.putExtra("bless_ptv_md5", this.mBlessManager.a().md5);
            localIntent.putExtra("bless_ptv_nick", bfuc.encodeToString(this.app.getCurrentNickname().getBytes(), 2));
            localIntent.putExtra("ptv_file_path", this.mBlessManager.a().videoFileName);
            localIntent.putExtra("ptv_thumb_path", this.mBlessManager.a().mThumbFilePath);
            if (QLog.isColorLevel()) {
              QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb ptvurl:" + (String)localObject);
            }
          }
        }
      }
    }
    QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.jdField_b_of_type_Int);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = (int)((System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L);
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResult result:" + paramBoolean1 + " ,type:" + this.jdField_b_of_type_Int + " ,cost:" + i);
    }
    if (paramBoolean1)
    {
      c();
      if ((this.jdField_b_of_type_Int == 1) && (!this.jdField_c_of_type_JavaLangString.equals("")))
      {
        this.mBlessManager.a(this.jdField_c_of_type_JavaLangString);
        this.mBlessManager.c();
        b(paramBoolean2);
        bcef.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
      }
      for (;;)
      {
        Properties localProperties = new Properties();
        localProperties.setProperty("bless_param_type", "" + this.jdField_b_of_type_Int);
        localProperties.setProperty("bless_param_entrance_type", "" + this.mEntrance);
        localProperties.setProperty("bless_param_uinlist_size", "" + this.jdField_a_of_type_JavaUtilArrayList.size());
        if (jdField_e_of_type_Long > 0L) {
          localProperties.setProperty("bless_param_wait_time", "" + jdField_e_of_type_Long);
        }
        ahuz.a("bless_event_send_result", localProperties, i);
        return;
        if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 3)) {
          b(paramBoolean2);
        }
      }
    }
    QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.jdField_b_of_type_Int);
  }
  
  public boolean a()
  {
    if (jdField_c_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - jdField_d_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "send text overload=" + l / 1000L + " duration=" + jdField_c_of_type_Long);
      }
      if (l > jdField_c_of_type_Long * 1000L)
      {
        a(0L);
        jdField_d_of_type_Long = 0L;
      }
    }
    else
    {
      return true;
    }
    a(this, 2131690569, true);
    return false;
  }
  
  protected void b()
  {
    bcef.b(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.jdField_b_of_type_Int), "", "", "");
    if ((this.h == null) || (this.jdField_b_of_type_AndroidAppDialog == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.mEntrance == 15) {
        localStringBuilder.append(getString(2131690565));
      }
      for (;;)
      {
        localObject = (amsw)this.app.getManager(51);
        int i = 0;
        while ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < 50))
        {
          Friends localFriends = ((amsw)localObject).e((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          if (localFriends != null) {
            localStringBuilder.append(localFriends.getFriendNick()).append("、 ");
          }
          i += 1;
        }
        if (this.mEntrance == 32) {
          localStringBuilder.append(getString(2131719616));
        }
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
        localStringBuilder.append(String.format(getString(2131690566), new Object[] { "", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
      }
      this.h = localStringBuilder.toString();
      this.jdField_b_of_type_AndroidAppDialog = bfur.a(this, -1, null, this.h, 2131690620, 2131690564, new ahvi(this), new ahvj(this));
      if (this.jdField_b_of_type_Int == 2)
      {
        localObject = this.jdField_b_of_type_AndroidAppDialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
      Object localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365552);
      ((TextView)localObject).setMaxLines(4);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).post(new BlessSelectMemberActivity.4(this, (TextView)localObject, localStringBuilder));
    }
    if (!isFinishing()) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new ayec();
    ((ayec)localObject).a(paramString);
    ((ayec)localObject).d(1006);
    ((ayec)localObject).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    ((ayec)localObject).d("0");
    ((ayec)localObject).c(this.app.getCurrentAccountUin());
    ((ayec)localObject).e(0);
    paramString = ((ayec)localObject).a();
    paramString.g = true;
    paramString.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)new ayck(this.app).a(paramString));
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isBlessPic = true;
    }
    paramString.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    localObject = aydj.a(2, 1006);
    ((ayds)localObject).a(paramString);
    aydj.a((ayds)localObject, this.app);
  }
  
  public void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", this.jdField_b_of_type_Int);
    this.app.getApp().sendBroadcast(localIntent);
    this.mBlessManager.a(this.jdField_a_of_type_JavaUtilArrayList, a(this.mEntrance));
    if (this.mEntrance == 32)
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra(bbkv.h, paramBoolean);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
      finish();
      QQToast.a(this, 2, 2131719617, 1).a();
    }
  }
  
  public void c()
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
      if (jdField_a_of_type_Bjmp != null) {
        jdField_a_of_type_Bjmp.removeMessages(2);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  public void d()
  {
    a(null);
    jdField_b_of_type_Boolean = false;
    this.mBlessManager.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Bjmp.sendEmptyMessageDelayed(2, jdField_b_of_type_Long);
    if (this.jdField_b_of_type_Int == 1) {
      c(this.jdField_c_of_type_JavaLangString);
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
          c();
          return;
        }
        new ahvp(this.app, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        if ((this.jdField_a_of_type_Ahvq != null) && (this.jdField_a_of_type_Ahvq.getStatus() != AsyncTask.Status.FINISHED))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessSelectMemberActivity", 2, "There is still a running uploadTask!");
          }
          this.jdField_a_of_type_Ahvq.cancel(true);
        }
        this.jdField_a_of_type_Ahvq = new ahvq(this.app, this, this.jdField_a_of_type_JavaUtilArrayList, this.mEntrance);
        this.jdField_a_of_type_Ahvq.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      } while (getIntent().getIntExtra("param_key_redbag_type", 0) != LocalMediaInfo.REDBAG_TYPE_GET);
      akrx.a("", "0X80088E4", this.jdField_a_of_type_JavaUtilArrayList.size(), "3");
      return;
    } while (this.jdField_b_of_type_Int != 3);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      QQToast.a(this, 1, 2131698294, 1).a();
      c();
      finish();
      return;
    }
    b(this.jdField_f_of_type_JavaLangString);
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
    this.jdField_b_of_type_Int = this.mIntent.getExtras().getInt("param_blesstype");
    this.jdField_c_of_type_JavaLangString = this.mIntent.getExtras().getString("param_blessword_content");
    this.jdField_d_of_type_Int = this.mIntent.getIntExtra("encode_type", 0);
    this.jdField_e_of_type_JavaLangString = this.mIntent.getStringExtra("fake_id");
    this.jdField_f_of_type_JavaLangString = this.mIntent.getStringExtra("thumbfile_send_path");
    this.g = this.mIntent.getStringExtra("thumbfile_md5");
    this.jdField_d_of_type_JavaLangString = this.mIntent.getStringExtra("param_web_callback");
    addObserver(this.jdField_a_of_type_Amwl);
    h();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_Boolean = false;
    this.mIsNeedSendIsResumeBroadcast = false;
    jdField_a_of_type_Bjmp = new bjmp(this);
    paramBundle = new Intent("tencent.video.q2v.startUploadPTV");
    paramBundle.putExtra("broadcastType", 2);
    this.app.getApp().sendBroadcast(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Amwl);
    if (jdField_a_of_type_Bjmp != null) {
      jdField_a_of_type_Bjmp.removeMessages(2);
    }
    if ((this.jdField_a_of_type_Ahvq != null) && (this.jdField_a_of_type_Ahvq.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "destroy the uploadTask!");
      }
      this.jdField_a_of_type_Ahvq.cancel(true);
    }
    try
    {
      if (this.jdField_c_of_type_Int == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_c_of_type_Int = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
      jdField_e_of_type_Long = 0L;
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
    removeAllFriendResult();
    ((SelectMemberInnerFrame)this.mInnerFrameManager.getCurrentView()).f();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      int i = getResources().getColor(2131165383);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.mEntrance == 15) || (this.mEntrance == 32)) {
      this.mBlessManager.b();
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
      a();
      jdField_b_of_type_Boolean = true;
      c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send bless msg timeout!");
      }
      a();
      jdField_b_of_type_Boolean = true;
      c();
      a(this, 2131718484);
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage realStartEncode!");
      }
      e();
    }
  }
  
  public void initTitleBar()
  {
    super.initTitleBar();
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131165383));
    this.mTitle.setTextColor(-1);
    this.mLeftBackBtn.setTextColor(getResources().getColorStateList(2131165378));
    this.mRightBtn.setTextColor(getResources().getColorStateList(2131165378));
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
    if (this.mBlessManager.g())
    {
      this.mBlessManager.a(false);
      Object localObject = this.mBlessManager.a();
      if ((localObject != null) && (((ArrayList)localObject).size() >= 0))
      {
        amsw localamsw = (amsw)this.app.getManager(51);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = localamsw.e(str);
          if (localFriends != null) {
            localArrayList.add(constructAResultRecord(str, localFriends.getFriendNick(), 0, "-1"));
          }
        }
        addFriendResults(localArrayList, true);
        ((SelectMemberInnerFrame)this.mInnerFrameManager.getCurrentView()).f();
      }
    }
  }
  
  public void startCreateOrAdd()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    if ((this.mEntrance == 15) || (this.mEntrance == 32))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (this.mResultList.size() > 0)
      {
        Iterator localIterator = this.mResultList.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          this.jdField_a_of_type_JavaUtilArrayList.add(localResultRecord.uin);
        }
      }
      b();
      return;
    }
    this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
    setResult(-1, this.mIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */