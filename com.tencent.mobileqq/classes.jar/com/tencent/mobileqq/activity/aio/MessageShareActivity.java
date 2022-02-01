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
  protected final MqqHandler b = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  protected Bundle c = null;
  
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
    if (11 != this.c.getInt("forward_type", -1)) {
      return false;
    }
    return ForwardUtils.a(paramAbsStructMsg);
  }
  
  protected void a()
  {
    if (this.c != null) {
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
    Dialog localDialog = this.a;
    if (localDialog != null)
    {
      localDialog.dismiss();
      this.a = null;
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
      ((TextView)this.a.findViewById(2131440191)).setText(HardCodeUtil.a(2131904547));
      this.a.findViewById(2131440190).setVisibility(4);
      this.b.sendEmptyMessageDelayed(3, 800L);
      return true;
    }
    i = this.c.getInt("forward_type", -1);
    if ((i != 2) && (i != 11)) {
      return true;
    }
    long l = this.c.getLong("req_share_id");
    Object localObject2 = this.c.getString("pkg_name");
    paramMessage = this.c.getString("detail_url");
    this.c.putBoolean("isBack2Root", false);
    this.c.putLong("res_share_id", l);
    this.c.putString("res_pkg_name", (String)localObject2);
    this.c.putString("res_detail_url", paramMessage);
    QLog.d("MessageShareActivity", 1, new Object[] { "-->handleMessage--appid = ", Long.valueOf(l), ", pkgNmae = ", localObject2 });
    paramMessage = new Intent(this, SplashActivity.class);
    paramMessage.putExtra("k_from_login", true);
    Object localObject1 = this.c.getString("uin");
    int j = this.c.getInt("uintype");
    l = this.c.getLong("req_share_id");
    ArrayList localArrayList = this.c.getParcelableArrayList("forward_multi_target");
    Object localObject3;
    if (i == 11)
    {
      localObject3 = new Intent();
      ((Intent)localObject3).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), "shareToQQ" })));
      ((Intent)localObject3).setPackage((String)localObject2);
      paramMessage.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this, 0, (Intent)localObject3, 268435456));
      localObject2 = this.c.getString("video_url");
      localObject3 = this.c.getString("detail_url");
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
      {
        localObject2 = CGILoader.b((String)localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(CGILoader.a(j));
          ((StringBuilder)localObject3).append("");
          ReportController.b(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, ((StringBuilder)localObject3).toString(), "", (String)localObject2, "");
        }
      }
    }
    localObject2 = StructMsgFactory.a(this.c);
    if ((localObject2 != null) && (this.app != null))
    {
      if ((localObject2 instanceof StructMsgForImageShare))
      {
        ThreadManager.post(new MessageShareActivity.1(this, localArrayList, (AbsStructMsg)localObject2, (String)localObject1, j), 8, null, false);
      }
      else if (i == 11)
      {
        this.c.putBoolean("share_send_msg_by_server", true);
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
          localObject3 = this.c.getString("troop_uin");
          AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, (String)localObject1, j, (String)localObject3);
        }
      }
      paramMessage.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject2).getBytes());
      if (!this.c.getBoolean("share_from_aio", false))
      {
        paramMessage = AIOUtils.a(paramMessage, new int[] { 2 });
        this.c.remove("share_from_aio");
      }
      else
      {
        paramMessage = AIOUtils.a(paramMessage, null);
        paramMessage.putExtra("share_from_aio", true);
      }
      paramMessage.putExtras(this.c);
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
    this.a = new ReportDialog(this, 2131953338);
    this.a.setCancelable(false);
    this.a.setContentView(2131625585);
    ((TextView)this.a.findViewById(2131440191)).setText(2131892581);
    this.c = getIntent().getExtras();
    if (this.c != null) {
      try
      {
        handleMessage(this.b.obtainMessage(1));
        return;
      }
      catch (IllegalArgumentException paramBundle)
      {
        QLog.e("MessageShareActivity", 1, paramBundle, new Object[0]);
        AppSetting.j();
        return;
      }
    }
    QLog.d("MessageShareActivity", 1, "getExtras() is null !!!!!");
    this.a.show();
    handleMessage(this.b.obtainMessage(2));
  }
  
  public void run()
  {
    try
    {
      a();
      this.b.sendEmptyMessageDelayed(1, 333L);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageShareActivity", 1, "doShare() cause exception !!!!!", localException);
      this.b.sendEmptyMessageDelayed(2, 333L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity
 * JD-Core Version:    0.7.0.1
 */