package com.tencent.mobileqq.activity.aio;

import Override;
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
import anvx;
import bdla;
import bdny;
import bdof;
import bkyc;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
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
    this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this);
  }
  
  private void a(List<ResultRecord> paramList, Intent paramIntent, AbsStructMsg paramAbsStructMsg)
  {
    if (a(paramAbsStructMsg))
    {
      QLog.d("MessageShareActivity", 1, "onSDKShareEnd sdkLocalShare");
      ForwardUtils.sendCommentMsg(paramList, null, this, paramIntent.getStringExtra("share_msg_input_value"));
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
    return ForwardUtils.isImageLocalShare(paramAbsStructMsg);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      throw new IllegalArgumentException();
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
            localObject2 = bdny.a((String)localObject3);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              bdla.b(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, bdny.a(j) + "", "", (String)localObject2, "");
            }
          }
        }
        localObject2 = bdof.a(this.jdField_a_of_type_AndroidOsBundle);
        if ((localObject2 != null) && (this.app != null))
        {
          if (!(localObject2 instanceof StructMsgForImageShare)) {
            break label547;
          }
          ThreadManager.post(new MessageShareActivity.1(this, localArrayList, (AbsStructMsg)localObject2, (String)localObject1, j), 8, null, false);
          label462:
          paramMessage.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject2).getBytes());
          if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_from_aio", false)) {
            break label675;
          }
          paramMessage = AIOUtils.setOpenAIOIntent(paramMessage, new int[] { 2 });
          this.jdField_a_of_type_AndroidOsBundle.remove("share_from_aio");
          label511:
          paramMessage.putExtras(this.jdField_a_of_type_AndroidOsBundle);
          if ((localArrayList != null) && (!localArrayList.isEmpty())) {
            break label693;
          }
          startActivity(paramMessage);
        }
        for (;;)
        {
          finish();
          break;
          label547:
          if (i == 11)
          {
            this.jdField_a_of_type_AndroidOsBundle.putBoolean("share_send_msg_by_server", true);
            break label462;
          }
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (ResultRecord)((Iterator)localObject1).next();
              AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin);
            }
            break label462;
          }
          localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
          AbsShareMsg.sendSdkShareMessage(this.app, (AbsShareMsg)localObject2, (String)localObject1, j, (String)localObject3);
          break label462;
          label675:
          paramMessage = AIOUtils.setOpenAIOIntent(paramMessage, null);
          paramMessage.putExtra("share_from_aio", true);
          break label511;
          label693:
          a(localArrayList, paramMessage, (AbsStructMsg)localObject2);
        }
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372740)).setText(anvx.a(2131706134));
        this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372739).setVisibility(4);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3, 800L);
        continue;
        finish();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(new View(this));
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755829);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559607);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372740)).setText(2131694652);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MessageShareActivity
 * JD-Core Version:    0.7.0.1
 */