package com.tencent.mobileqq.activity.aio;

import actn;
import ajyc;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import axqw;
import axur;
import axuy;
import bfmt;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
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
    this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this);
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
    if (11 != this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1)) {}
    while ((!ForwardUtils.a(paramAbsStructMsg)) && (!ForwardUtils.b(paramAbsStructMsg))) {
      return false;
    }
    return true;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      throw new IllegalArgumentException();
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1);
      switch (i)
      {
      default: 
        break;
      case 2: 
      case 11: 
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
            localObject2 = axur.a((String)localObject3);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              axqw.b(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, axur.a(j) + "", "", (String)localObject2, "");
            }
          }
        }
        boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_msg_by_server_enable_entry", false);
        localObject2 = axuy.a(this.jdField_a_of_type_AndroidOsBundle);
        if ((localObject2 != null) && (this.app != null))
        {
          if (!(localObject2 instanceof StructMsgForImageShare)) {
            break label569;
          }
          ThreadManager.post(new MessageShareActivity.1(this, localArrayList, (AbsStructMsg)localObject2, (String)localObject1, j), 8, null, false);
          label475:
          paramMessage.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject2).getBytes());
          if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_from_aio", false)) {
            break label702;
          }
          paramMessage = actn.a(paramMessage, new int[] { 2 });
          this.jdField_a_of_type_AndroidOsBundle.remove("share_from_aio");
        }
        for (;;)
        {
          paramMessage.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          if ((localArrayList == null) || (localArrayList.isEmpty())) {
            startActivity(paramMessage);
          }
          a(localArrayList, paramMessage, (AbsStructMsg)localObject2);
          finish();
          break;
          label569:
          if ((bool) && (i == 11))
          {
            this.jdField_a_of_type_AndroidOsBundle.putBoolean("share_send_msg_by_server", true);
            break label475;
          }
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (ResultRecord)((Iterator)localObject1).next();
              AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, ((ResultRecord)localObject3).a, ((ResultRecord)localObject3).a(), ((ResultRecord)localObject3).c);
            }
            break label475;
          }
          localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
          AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, (String)localObject1, j, (String)localObject3);
          break label475;
          label702:
          paramMessage = actn.a(paramMessage, null);
          paramMessage.putExtra("share_from_aio", true);
        }
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557)).setText(ajyc.a(2131706660));
        this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371556).setVisibility(4);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 800L);
        continue;
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(new View(this));
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755791);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559386);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557)).setText(2131695125);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      try
      {
        handleMessage(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1));
        return;
      }
      catch (IllegalArgumentException paramBundle)
      {
        do
        {
          QLog.e("MessageShareActivity", 1, paramBundle, new Object[0]);
        } while (!AppSetting.b());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity
 * JD-Core Version:    0.7.0.1
 */