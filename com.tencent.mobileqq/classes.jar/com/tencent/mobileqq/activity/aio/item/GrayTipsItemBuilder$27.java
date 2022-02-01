package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class GrayTipsItemBuilder$27
  extends ClickableSpan
{
  GrayTipsItemBuilder$27(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.c instanceof Activity))
    {
      int k = this.a.d.a;
      int i = 1;
      int j = 0;
      if (k != 0) {
        if (this.a.d.a == 3000)
        {
          j = ((DiscussionManager)this.a.a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(this.a.d.b);
          i = 2;
        }
        else if (this.a.d.a == 1)
        {
          i = 3;
        }
        else
        {
          i = 0;
        }
      }
      paramView = new JSONObject();
      try
      {
        paramView.put("recv_uin", this.a.d.b);
        paramView.put("recv_nick", this.a.d.e);
        if (j > 0) {
          paramView.put("people_num", j);
        }
        paramView.put("recv_type", i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click HongBao:params=");
        ((StringBuilder)localObject).append(paramView.toString());
        QLog.d("GrayTipsItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("come_from", 2);
      ((Intent)localObject).putExtra("extra_data", paramView.toString());
      ((Intent)localObject).addFlags(536870912);
      paramView = new StringBuilder();
      paramView.append("groupType=");
      paramView.append(i);
      ((Intent)localObject).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", paramView.toString(), 0, null));
      RouteUtils.a(this.a.c, (Intent)localObject, "/qwallet/redpacket/sendhb");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.27
 * JD-Core Version:    0.7.0.1
 */