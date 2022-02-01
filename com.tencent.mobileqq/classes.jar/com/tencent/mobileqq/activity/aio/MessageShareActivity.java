package com.tencent.mobileqq.activity.aio;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class MessageShareActivity
  extends BaseActivity
  implements Handler.Callback, Runnable
{
  protected Dialog a;
  protected Bundle a;
  protected final MqqHandler a;
  
  public MessageShareActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsBundle = null;
  }
  
  private void a(List<ResultRecord> paramList, Intent paramIntent, AbsStructMsg paramAbsStructMsg)
  {
    if (a(paramAbsStructMsg))
    {
      QLog.d("MessageShareActivity", 1, "onSDKShareEnd sdkLocalShare");
      ForwardUtils.a(paramList, null, this, paramIntent.getStringExtra("share_msg_input_value"));
      paramIntent.putExtra("sdk_mult_share", true);
      paramIntent.putExtra("sdk_mult_share_for_local", true);
      paramIntent.putExtra("open_chatfragment", false);
      paramIntent.putExtra("fragment_id", 1);
      startActivity(paramIntent);
    }
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    if (11 != this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1)) {
      return false;
    }
    return ForwardUtils.a(paramAbsStructMsg);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null)
    {
      localDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        finish();
        return true;
      }
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646)).setText(HardCodeUtil.a(2131706696));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372645).setVisibility(4);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 800L);
      return true;
    }
    i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1);
    if ((i != 2) && (i != 11)) {
      return true;
    }
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    paramMessage = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    this.jdField_a_of_type_AndroidOsBundle.putLong("res_share_id", l);
    this.jdField_a_of_type_AndroidOsBundle.putString("res_pkg_name", (String)localObject2);
    this.jdField_a_of_type_AndroidOsBundle.putString("res_detail_url", paramMessage);
    QLog.d("MessageShareActivity", 1, new Object[] { "-->handleMessage--appid = ", Long.valueOf(l), ", pkgNmae = ", localObject2 });
    paramMessage = new Intent(this, SplashActivity.class);
    paramMessage.putExtra("k_from_login", true);
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    ArrayList localArrayList = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target");
    Object localObject3;
    if (i == 11)
    {
      localObject3 = new Intent();
      ((Intent)localObject3).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), "shareToQQ" })));
      ((Intent)localObject3).setPackage((String)localObject2);
      paramMessage.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this, 0, (Intent)localObject3, 268435456));
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("video_url");
      localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
      {
        localObject2 = CGILoader.a((String)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(CGILoader.a(j));
          ((StringBuilder)localObject3).append("");
          ReportController.b(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, ((StringBuilder)localObject3).toString(), "", (String)localObject2, "");
        }
      }
    }
    localObject2 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if ((localObject2 != null) && (this.app != null))
    {
      if ((localObject2 instanceof StructMsgForImageShare))
      {
        ThreadManager.post(new MessageShareActivity.1(this, localArrayList, (AbsStructMsg)localObject2, (String)localObject1, j), 8, null, false);
      }
      else if (i == 11)
      {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("share_send_msg_by_server", true);
      }
      else
      {
        if ((localArrayList != null) && (!localArrayList.isEmpty())) {
          localObject1 = localArrayList.iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject1).next();
          AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin);
          continue;
          localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
          AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, (String)localObject1, j, (String)localObject3);
        }
      }
      paramMessage.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject2).getBytes());
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_from_aio", false))
      {
        paramMessage = AIOUtils.a(paramMessage, new int[] { 2 });
        this.jdField_a_of_type_AndroidOsBundle.remove("share_from_aio");
      }
      else
      {
        paramMessage = AIOUtils.a(paramMessage, null);
        paramMessage.putExtra("share_from_aio", true);
      }
      paramMessage.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        a(localArrayList, paramMessage, (AbsStructMsg)localObject2);
      } else {
        startActivity(paramMessage);
      }
    }
    finish();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(new View(this));
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131756189);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646)).setText(2131694878);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      try
      {
        handleMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1));
        return;
      }
      catch (IllegalArgumentException paramBundle)
      {
        QLog.e("MessageShareActivity", 1, paramBundle, new Object[0]);
        AppSetting.b();
        return;
      }
    }
    QLog.d("MessageShareActivity", 1, "getExtras() is null !!!!!");
    this.jdField_a_of_type_AndroidAppDialog.show();
    handleMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(2));
  }
  
  public void run()
  {
    try
    {
      a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 333L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageShareActivity", 1, "doShare() cause exception !!!!!", localException);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 333L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity
 * JD-Core Version:    0.7.0.1
 */