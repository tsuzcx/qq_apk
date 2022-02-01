package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class TeamWorkListAction
  extends JumpAction
{
  public TeamWorkListAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    try
    {
      Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
      String str;
      if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().q())) {
        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
      } else {
        str = TencentDocConvertConfigProcessor.a().q();
      }
      this.b.startActivity(localIntent.putExtra("url", str));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = c();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("TeamWorkListAction", 1, localStringBuilder.toString());
      h_("TeamWorkListAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.TeamWorkListAction
 * JD-Core Version:    0.7.0.1
 */