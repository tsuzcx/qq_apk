package com.tencent.mobileqq.activity.aio;

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
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;
import uix;

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
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      throw new IllegalArgumentException();
    }
  }
  
  protected void doOnDestroy()
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
        Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
        paramMessage = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
        this.jdField_a_of_type_AndroidOsBundle.putLong("res_share_id", l);
        this.jdField_a_of_type_AndroidOsBundle.putString("res_pkg_name", (String)localObject1);
        this.jdField_a_of_type_AndroidOsBundle.putString("res_detail_url", paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("MessageShareActivity", 2, "-->handleMessage--appid = " + l + ", pkgNmae = " + (String)localObject1);
        }
        paramMessage = new Intent(this, SplashActivity.class);
        paramMessage.putExtra("k_from_login", true);
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
        Object localObject2;
        if (i == 11)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), "shareToQQ" })));
          ((Intent)localObject2).setPackage((String)localObject1);
          paramMessage.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this, 0, (Intent)localObject2, 268435456));
          localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("video_url");
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            localObject1 = CGILoader.a((String)localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ReportController.b(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, CGILoader.a(j) + "", "", (String)localObject1, "");
            }
          }
        }
        localObject1 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
        if ((localObject1 != null) && (this.app != null))
        {
          if (!(localObject1 instanceof StructMsgForImageShare)) {
            break label525;
          }
          ThreadManager.post(new uix(this, (AbsStructMsg)localObject1, str, j), 8, null, false);
          label458:
          paramMessage.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject1).getBytes());
          if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_from_aio", false)) {
            break label557;
          }
          paramMessage = AIOUtils.a(paramMessage, new int[] { 2 });
          this.jdField_a_of_type_AndroidOsBundle.remove("share_from_aio");
        }
        for (;;)
        {
          paramMessage.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          startActivity(paramMessage);
          finish();
          break;
          label525:
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
          AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject1, str, j, (String)localObject2);
          break label458;
          label557:
          paramMessage = AIOUtils.a(paramMessage, null);
          paramMessage.putExtra("share_from_aio", true);
        }
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363381)).setText("处理失败");
        this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363380).setVisibility(4);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 800L);
        continue;
        finish();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(new View(this));
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624515);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130969181);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363381)).setText(2131436128);
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
        return;
      }
    }
    QLog.d("MessageShareActivity", 2, "getExtras() is null !!!!!");
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
      QLog.d("MessageShareActivity", 2, "doShare() cause exception !!!!!");
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 333L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity
 * JD-Core Version:    0.7.0.1
 */