package com.tencent.mobileqq.app.parser;

import aeex;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import aoud;
import aupt;
import bdla;
import bdlq;
import bizc;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public final class JumpActivityHelper$4
  implements Runnable
{
  public JumpActivityHelper$4(Bundle paramBundle, JumpActivity paramJumpActivity) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getType();
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.a().booleanValue()) {
      bizc.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, null);
    }
    if ("cn.wps.moffice_eng".equals(localObject3)) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app, "CliOper", "", "", "0X8008810", "0X8008810", 0, 0, "", "", "", "");
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    bdlq.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app.getCurrentAccountUin(), "dl_share_frd");
    if (QLog.isColorLevel()) {
      QLog.d("JumpActivityHelper", 2, "forward form JumpActivity doShare type=" + (String)localObject2);
    }
    if ((((String)localObject2).startsWith("text")) && (!this.jdField_a_of_type_AndroidOsBundle.containsKey("android.intent.extra.STREAM")))
    {
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, ForwardRecentActivity.class);
      ((Intent)localObject2).putExtras(new Bundle());
      ((Intent)localObject2).putExtra("isFromShare", true);
      ((Intent)localObject2).putExtra("forward_from_jump", true);
      ((Intent)localObject2).putExtra("k_favorites", true);
      ((Intent)localObject2).putExtra("system_share", true);
      ((Intent)localObject2).putExtra("selection_mode", 2);
      ((Intent)localObject2).putExtra("forward_type", -1);
      ((Intent)localObject2).putExtra("forward_text", (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity((Intent)localObject2);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getScheme();
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals("geo"))) {
        break label1060;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("forward_type", -2);
      ((Intent)localObject1).setData(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getData());
      aupt.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, (Intent)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
      return;
      if (!((String)localObject2).startsWith("message")) {
        break;
      }
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtra("forward_type", -1);
      ((Intent)localObject1).putExtra("forward_text", (SpannableString)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.TEXT"));
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity((Intent)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
    }
    if (((String)localObject2).startsWith("image"))
    {
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_from_jump", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtra("system_share", true);
      ((Intent)localObject1).putExtra("selection_mode", 2);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("forward_type", 1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getAction().equals("android.intent.action.SEND"))
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
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
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity((Intent)localObject1);
        break;
        if ((localObject2 instanceof String))
        {
          ((Intent)localObject1).setData(Uri.parse((String)localObject2));
          break label610;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
        return;
        ((Intent)localObject1).putExtra("sendMultiple", true);
        ((Intent)localObject1).putExtra("forward_text", this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getString(2131691046));
      }
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getIntent().getAction();
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("isFromShare", true);
    ((Intent)localObject1).putExtra("forward_from_jump", true);
    ((Intent)localObject1).putExtra("forward_type", 0);
    ((Intent)localObject1).putExtra("system_share", true);
    ((Intent)localObject1).putExtra("selection_mode", 2);
    if (((String)localObject3).equals("android.intent.action.SEND"))
    {
      localObject3 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localObject3 != null) {
        if ((localObject3 instanceof Uri))
        {
          localObject3 = (Uri)localObject3;
          if (("text/x-vcard".equals(localObject2)) && ("content".equals(((Uri)localObject3).getScheme())))
          {
            ((Intent)localObject1).putExtra("sendMultiple", false);
            ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity;
            localObject2.getClass();
            new aeex((JumpActivity)localObject2, (Intent)localObject1).execute(new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getApplicationContext(), localObject3 });
            return;
          }
          localObject2 = ((Uri)localObject3).getPath();
          localObject3 = aoud.a((Uri)localObject3);
          if (localObject3 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
            return;
          }
          if ((ForwardUtils.backToFileScheme()) && ("file".equals(((Uri)localObject3).getScheme())))
          {
            QLog.d("JumpActivityHelper", 1, new Object[] { "doShare scheme uriPath=", localObject2 });
            if ((localObject2 != null) && (((String)localObject2).startsWith(ForwardUtils.getDataDataPath()))) {
              ((Intent)localObject1).putExtra("path_for_file_scheme", (String)localObject2);
            }
          }
          ((Intent)localObject1).setData((Uri)localObject3);
          label967:
          ((Intent)localObject1).putExtra("sendMultiple", false);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      aupt.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, (Intent)localObject1);
      break;
      if ((localObject3 instanceof String))
      {
        ((Intent)localObject1).setData(Uri.parse((String)localObject3));
        break label967;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
      return;
      ((Intent)localObject1).putExtra("sendMultiple", true);
      ((Intent)localObject1).putExtra("forward_text", this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.getString(2131691046));
    }
    label1060:
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActivityHelper.4
 * JD-Core Version:    0.7.0.1
 */