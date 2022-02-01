package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;

public class WadlAction
  extends JumpAction
{
  public WadlAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    if (!(this.a instanceof Activity)) {
      return true;
    }
    Object localObject1 = ((Activity)this.a).getIntent();
    if (localObject1 == null) {
      return true;
    }
    Object localObject2 = ((Intent)localObject1).getExtras();
    if (localObject2 == null) {
      return true;
    }
    localObject1 = ((Bundle)localObject2).getString("localAPKPath");
    localObject2 = ((Bundle)localObject2).getString("sourceId");
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("gamecenter installApk, pkgName=");
      ((StringBuilder)localObject3).append(this.e);
      ((StringBuilder)localObject3).append(",localAPKPath=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(",sourceId=");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("WadlAction", 1, ((StringBuilder)localObject3).toString());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = FileProvider7Helper.openApkIntent(this.a, (String)localObject1);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "biz_src_zf_games";
      }
      ((Intent)localObject3).putExtra("big_brother_source_key", (String)localObject1);
      this.a.startActivity((Intent)localObject3);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WadlAction
 * JD-Core Version:    0.7.0.1
 */