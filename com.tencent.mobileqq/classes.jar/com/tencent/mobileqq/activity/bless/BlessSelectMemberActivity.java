package com.tencent.mobileqq.activity.bless;

import aaod;
import afaz;
import afbb;
import afbh;
import afbi;
import afbj;
import afbk;
import afbl;
import afbm;
import afbn;
import afbo;
import afbp;
import afbq;
import afbr;
import afbs;
import ahub;
import aigl;
import aigq;
import aigr;
import ajxn;
import akav;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.AsyncTask;
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
import auml;
import aunj;
import aunt;
import auoc;
import axad;
import axqw;
import ayoz;
import aypj;
import ayvu;
import ayvv;
import bbca;
import bbcv;
import bbmi;
import bcpw;
import bfmt;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  private static boolean A;
  private static bfmt jdField_a_of_type_Bfmt;
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
  private afbs jdField_a_of_type_Afbs;
  private aigq jdField_a_of_type_Aigq = new afbj(this);
  private akav jdField_a_of_type_Akav = new afbh(this);
  public Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new afbi(this);
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  protected ArrayList<String> a;
  public boolean a;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  private long h;
  private String i;
  private String j;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int = 0;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int;
  private String jdField_m_of_type_JavaLangString;
  private int jdField_n_of_type_Int;
  private String jdField_n_of_type_JavaLangString;
  
  static
  {
    jdField_c_of_type_Long = 60000L;
    jdField_d_of_type_Long = 60000L;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
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
    bbcv.a(paramContext, 232, null, paramContext.getString(paramInt), 2131690596, 2131693703, new afbp(paramContext), new afbq()).show();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    bbcv.a(paramContext, 232, null, paramContext.getString(paramInt), new afbo(paramBoolean, paramContext), null).show();
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
      aaod.a(this.app, paramString, this.jdField_a_of_type_JavaUtilArrayList, null);
      return;
    }
    QLog.e("BlessSelectMemberActivity", 1, "Blesswords is null!");
    e();
  }
  
  private void u()
  {
    Object localObject = new aigr(this.jdField_l_of_type_JavaLangString, this.jdField_m_of_type_JavaLangString, null, 0, 0);
    String str = this.jdField_k_of_type_JavaLangString;
    if (this.jdField_n_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new aigl(this, str, bool, (aigr)localObject);
      ((aigl)localObject).a(this.jdField_a_of_type_Aigq);
      ((aigl)localObject).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[] { (Void)null });
      return;
    }
  }
  
  private void v()
  {
    boolean bool = true;
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_Afaz.a();
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
        this.app.a().a(this.app, localMessageForShortVideo, localMessageForBlessPTV.uinList, this.jdField_a_of_type_Afaz.a(2, localMessageForBlessPTV.videoFileTime));
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
        this.app.a().a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Afaz.a(3, 0));
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
          this.jdField_a_of_type_JavaUtilArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755791);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558644);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new afbm(this));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131377064).setOnClickListener(new afbn(this));
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
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131719280);
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
        axqw.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_l_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
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
          if ((this.jdField_l_of_type_Int == 2) && (this.jdField_a_of_type_Afaz.a() != null))
          {
            localObject = this.jdField_a_of_type_Afaz.a(this.jdField_a_of_type_Afaz.a().uuid, this.jdField_a_of_type_Afaz.a().md5);
            localIntent.putExtra("bless_ptv_url", (String)localObject);
            localIntent.putExtra("bless_ptv_uuid", this.jdField_a_of_type_Afaz.a().uuid);
            localIntent.putExtra("bless_ptv_md5", this.jdField_a_of_type_Afaz.a().md5);
            localIntent.putExtra("bless_ptv_nick", bbca.encodeToString(this.app.getCurrentNickname().getBytes(), 2));
            localIntent.putExtra("ptv_file_path", this.jdField_a_of_type_Afaz.a().videoFileName);
            localIntent.putExtra("ptv_thumb_path", this.jdField_a_of_type_Afaz.a().mThumbFilePath);
            if (QLog.isColorLevel()) {
              QLog.i("BlessSelectMemberActivity", 2, "onSendMessageResultForWeb ptvurl:" + (String)localObject);
            }
          }
        }
      }
    }
    QLog.e("BlessSelectMemberActivity", 1, "Send blessword failed! blessType:" + this.jdField_l_of_type_Int);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
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
        this.jdField_a_of_type_Afaz.a(this.i);
        this.jdField_a_of_type_Afaz.c();
        b(paramBoolean2);
        axqw.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_l_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
      }
      for (;;)
      {
        Properties localProperties = new Properties();
        localProperties.setProperty("bless_param_type", "" + this.jdField_l_of_type_Int);
        localProperties.setProperty("bless_param_entrance_type", "" + this.jdField_d_of_type_Int);
        localProperties.setProperty("bless_param_uinlist_size", "" + this.jdField_a_of_type_JavaUtilArrayList.size());
        if (g > 0L) {
          localProperties.setProperty("bless_param_wait_time", "" + g);
        }
        afbb.a("bless_event_send_result", localProperties, i1);
        return;
        if ((this.jdField_l_of_type_Int == 2) || (this.jdField_l_of_type_Int == 3)) {
          b(paramBoolean2);
        }
      }
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
    a(this, 2131690521, true);
    return false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131165306));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131165300));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131165300));
  }
  
  public void b(String paramString)
  {
    Object localObject = new auoc();
    ((auoc)localObject).a(paramString);
    ((auoc)localObject).d(1006);
    ((auoc)localObject).c(ayvu.jdField_d_of_type_Int);
    ((auoc)localObject).d("0");
    ((auoc)localObject).c(this.app.getCurrentAccountUin());
    ((auoc)localObject).e(0);
    paramString = ((auoc)localObject).a();
    paramString.g = true;
    paramString.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)new auml(this.app).a(paramString));
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isBlessPic = true;
    }
    paramString.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    localObject = aunj.a(2, 1006);
    ((aunt)localObject).a(paramString);
    aunj.a((aunt)localObject, this.app);
  }
  
  public void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", this.jdField_l_of_type_Int);
    this.app.getApp().sendBroadcast(localIntent);
    this.jdField_a_of_type_Afaz.a(this.jdField_a_of_type_JavaUtilArrayList, a(this.jdField_d_of_type_Int));
    if (this.jdField_d_of_type_Int == 32)
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra(axad.h, paramBoolean);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
      finish();
      bcpw.a(this, 2, 2131720853, 1).a();
      return;
    }
    localIntent = new Intent(this, BlessResultActivity.class);
    localIntent.putExtra("param_method", this.jdField_l_of_type_Int);
    localIntent.putExtra("param_count", this.jdField_a_of_type_JavaUtilArrayList.size());
    if ((this.jdField_l_of_type_Int == 2) && (this.jdField_a_of_type_Afaz.a() != null))
    {
      localIntent.putExtra("param_snap_path", this.jdField_a_of_type_Afaz.a().mThumbFilePath);
      localIntent.putExtra("param_ptv_path", this.jdField_a_of_type_Afaz.a().videoFileName);
      localIntent.putExtra("param_ptv_uuid", this.jdField_a_of_type_Afaz.a().uuid);
      localIntent.putExtra("param_ptv_md5", this.jdField_a_of_type_Afaz.a().md5);
      localIntent.putExtra(axad.h, paramBoolean);
    }
    startActivity(localIntent);
    finish();
  }
  
  protected void c()
  {
    Object localObject = ((afaz)getAppInterface().getManager(138)).a();
    boolean bool;
    if (localObject != null)
    {
      bbmi localbbmi = this.app.a().a(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
      if ((localbbmi != null) && (ShortVideoUploadProcessor.class.isInstance(localbbmi)))
      {
        bool = ((ayoz)localbbmi).d();
        int i1 = ((MessageForShortVideo)localObject).videoFileStatus;
        if ((bool) || (i1 == 1002) || (i1 == 1001)) {
          this.app.a().d(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
      if ((localObject != null) && (aypj.class.isInstance(localObject)))
      {
        bool = ((ayoz)localObject).d();
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "stop pic upload, pause:" + bool);
        }
      }
    }
    if ((this.jdField_a_of_type_Afbs != null) && (this.jdField_a_of_type_Afbs.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "cancel the uploadTask!");
      }
      this.jdField_a_of_type_Afbs.cancel(true);
    }
  }
  
  protected void d()
  {
    axqw.b(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.jdField_l_of_type_Int), "", "", "");
    if ((this.jdField_n_of_type_JavaLangString == null) || (this.jdField_c_of_type_AndroidAppDialog == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_d_of_type_Int == 15) {
        localStringBuilder.append(getString(2131690517));
      }
      for (;;)
      {
        localObject = (ajxn)this.app.getManager(51);
        int i1 = 0;
        while ((i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i1 < 50))
        {
          Friends localFriends = ((ajxn)localObject).e((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1));
          if (localFriends != null) {
            localStringBuilder.append(localFriends.getFriendNick()).append("、 ");
          }
          i1 += 1;
        }
        if (this.jdField_d_of_type_Int == 32) {
          localStringBuilder.append(getString(2131720852));
        }
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
        localStringBuilder.append(String.format(getString(2131690518), new Object[] { "", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
      }
      this.jdField_n_of_type_JavaLangString = localStringBuilder.toString();
      this.jdField_c_of_type_AndroidAppDialog = bbcv.a(this, -1, null, this.jdField_n_of_type_JavaLangString, 2131690596, 2131690515, new afbk(this), new afbl(this));
      if (this.jdField_l_of_type_Int == 2)
      {
        localObject = this.jdField_c_of_type_AndroidAppDialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
      Object localObject = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131365147);
      ((TextView)localObject).setMaxLines(4);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).post(new BlessSelectMemberActivity.4(this, (TextView)localObject, localStringBuilder));
    }
    if (!isFinishing()) {
      this.jdField_c_of_type_AndroidAppDialog.show();
    }
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
    addObserver(this.jdField_a_of_type_Akav);
    x();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    jdField_k_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "";
    A = false;
    this.t = false;
    jdField_a_of_type_Bfmt = new bfmt(this);
    paramBundle = new Intent("tencent.video.q2v.startUploadPTV");
    paramBundle.putExtra("broadcastType", 2);
    this.app.getApp().sendBroadcast(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Akav);
    if (jdField_a_of_type_Bfmt != null) {
      jdField_a_of_type_Bfmt.removeMessages(2);
    }
    if ((this.jdField_a_of_type_Afbs != null) && (this.jdField_a_of_type_Afbs.getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "destroy the uploadTask!");
      }
      this.jdField_a_of_type_Afbs.cancel(true);
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
      int i1 = getResources().getColor(2131165306);
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
      if (jdField_a_of_type_Bfmt != null) {
        jdField_a_of_type_Bfmt.removeMessages(2);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  public void f()
  {
    a(null);
    A = false;
    this.jdField_a_of_type_Afaz.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.h = System.currentTimeMillis();
    jdField_a_of_type_Bfmt.sendEmptyMessageDelayed(2, jdField_d_of_type_Long);
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
        new afbr(this.app, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        if ((this.jdField_a_of_type_Afbs != null) && (this.jdField_a_of_type_Afbs.getStatus() != AsyncTask.Status.FINISHED))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessSelectMemberActivity", 2, "There is still a running uploadTask!");
          }
          this.jdField_a_of_type_Afbs.cancel(true);
        }
        this.jdField_a_of_type_Afbs = new afbs(this.app, this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
        this.jdField_a_of_type_Afbs.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      } while (getIntent().getIntExtra("param_key_redbag_type", 0) != LocalMediaInfo.REDBAG_TYPE_GET);
      ahub.a("", "0X80088E4", this.jdField_a_of_type_JavaUtilArrayList.size(), "3");
      return;
    } while (this.jdField_l_of_type_Int != 3);
    if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString))
    {
      bcpw.a(this, 1, 2131699060, 1).a();
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
      this.jdField_a_of_type_Afaz.b();
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
      a(this, 2131719593);
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
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_Afaz.g())
    {
      this.jdField_a_of_type_Afaz.a(false);
      Object localObject = this.jdField_a_of_type_Afaz.a();
      if ((localObject != null) && (((ArrayList)localObject).size() >= 0))
      {
        ajxn localajxn = (ajxn)this.app.getManager(51);
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = localajxn.e(str);
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