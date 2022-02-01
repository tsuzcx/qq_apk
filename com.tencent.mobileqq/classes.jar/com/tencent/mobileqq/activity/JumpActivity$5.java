package com.tencent.mobileqq.activity;

import adnu;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import atky;
import bcef;
import bcev;
import bhoj;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class JumpActivity$5
  implements Runnable
{
  JumpActivity$5(JumpActivity paramJumpActivity, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject2 = this.a.getString("android.intent.extra.TEXT");
    Object localObject1 = this.this$0.getIntent().getType();
    Object localObject3 = this.a.getString("pkg_name");
    if (this.this$0.a().booleanValue()) {
      bhoj.a().a(this.this$0, null);
    }
    if ("cn.wps.moffice_eng".equals(localObject3)) {
      bcef.b(this.this$0.app, "CliOper", "", "", "0X8008810", "0X8008810", 0, 0, "", "", "", "");
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    bcev.a(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_share_frd");
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "forward form JumpActivity doShare type=" + (String)localObject1);
    }
    if ((((String)localObject1).startsWith("text")) && (!this.a.containsKey("android.intent.extra.STREAM")))
    {
      localObject1 = new Intent(this.this$0, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtra("system_share", true);
      ((Intent)localObject1).putExtra("selection_mode", 2);
      ((Intent)localObject1).putExtra("forward_type", -1);
      ((Intent)localObject1).putExtra("forward_text", (String)localObject2);
      this.this$0.startActivity((Intent)localObject1);
    }
    for (;;)
    {
      localObject1 = this.this$0.getIntent().getScheme();
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals("geo"))) {
        break label1057;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("forward_type", -2);
      ((Intent)localObject1).setData(this.this$0.getIntent().getData());
      atky.a(this.this$0, (Intent)localObject1);
      this.this$0.finish();
      return;
      if (!((String)localObject1).startsWith("message")) {
        break;
      }
      localObject1 = new Intent(this.this$0, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtra("forward_type", -1);
      ((Intent)localObject1).putExtra("forward_text", (SpannableString)this.a.get("android.intent.extra.TEXT"));
      this.this$0.startActivity((Intent)localObject1);
      this.this$0.finish();
    }
    if (((String)localObject1).startsWith("image"))
    {
      localObject1 = new Intent(this.this$0, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtra("system_share", true);
      ((Intent)localObject1).putExtra("selection_mode", 2);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("forward_type", 1);
      if (this.this$0.getIntent().getAction().equals("android.intent.action.SEND"))
      {
        localObject2 = this.a.get("android.intent.extra.STREAM");
        if (localObject2 != null) {
          if ((localObject2 instanceof Uri))
          {
            ((Intent)localObject1).setData((Uri)localObject2);
            label610:
            ((Intent)localObject1).putExtra("sendMultiple", false);
          }
        }
      }
      for (;;)
      {
        ((Intent)localObject1).putExtras(this.a);
        this.this$0.startActivity((Intent)localObject1);
        break;
        if ((localObject2 instanceof String))
        {
          ((Intent)localObject1).setData(Uri.parse((String)localObject2));
          break label610;
        }
        this.this$0.finish();
        return;
        this.this$0.finish();
        return;
        ((Intent)localObject1).putExtra("sendMultiple", true);
        ((Intent)localObject1).putExtra("forward_text", this.this$0.getString(2131690961));
      }
    }
    localObject3 = this.this$0.getIntent().getAction();
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("isFromShare", true);
    ((Intent)localObject2).putExtra("forward_from_jump", true);
    ((Intent)localObject2).putExtra("forward_type", 0);
    ((Intent)localObject2).putExtra("system_share", true);
    ((Intent)localObject2).putExtra("selection_mode", 2);
    if (((String)localObject3).equals("android.intent.action.SEND"))
    {
      localObject3 = this.a.get("android.intent.extra.STREAM");
      if (localObject3 != null) {
        if ((localObject3 instanceof Uri))
        {
          localObject3 = (Uri)localObject3;
          if (("text/x-vcard".equals(localObject1)) && ("content".equals(((Uri)localObject3).getScheme())))
          {
            ((Intent)localObject2).putExtra("sendMultiple", false);
            ((Intent)localObject2).putExtras(this.a);
            new adnu(this.this$0, (Intent)localObject2).execute(new Object[] { this.this$0.getApplicationContext(), localObject3 });
            return;
          }
          localObject1 = ((Uri)localObject3).getPath();
          localObject3 = JumpActivity.a(this.this$0, (Uri)localObject3);
          if (localObject3 == null)
          {
            this.this$0.finish();
            return;
          }
          if ((ForwardUtils.backToFileScheme()) && ("file".equals(((Uri)localObject3).getScheme())))
          {
            QLog.d("JumpAction", 1, new Object[] { "doShare scheme uriPath=", localObject1 });
            if ((localObject1 != null) && (((String)localObject1).startsWith(ForwardUtils.getDataDataPath()))) {
              ((Intent)localObject2).putExtra("path_for_file_scheme", (String)localObject1);
            }
          }
          ((Intent)localObject2).setData((Uri)localObject3);
          label964:
          ((Intent)localObject2).putExtra("sendMultiple", false);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtras(this.a);
      atky.a(this.this$0, (Intent)localObject2);
      break;
      if ((localObject3 instanceof String))
      {
        ((Intent)localObject2).setData(Uri.parse((String)localObject3));
        break label964;
      }
      this.this$0.finish();
      return;
      this.this$0.finish();
      return;
      ((Intent)localObject2).putExtra("sendMultiple", true);
      ((Intent)localObject2).putExtra("forward_text", this.this$0.getString(2131690961));
    }
    label1057:
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.5
 * JD-Core Version:    0.7.0.1
 */