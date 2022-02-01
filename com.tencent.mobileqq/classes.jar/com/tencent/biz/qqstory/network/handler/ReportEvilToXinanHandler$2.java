package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import org.json.JSONException;
import org.json.JSONObject;

class ReportEvilToXinanHandler$2
  implements Runnable
{
  ReportEvilToXinanHandler$2(ReportEvilToXinanHandler paramReportEvilToXinanHandler, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    int i;
    try
    {
      i = new JSONObject(this.a).getInt("rtn_code");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      i = -1;
    }
    int j;
    if (i == 0)
    {
      QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131910889), 0).show();
      if (this.b) {
        j = 1;
      } else {
        j = 2;
      }
      StoryReportor.a("play_video", "report_suc", j, 0, new String[] { this.c, "", "", this.d });
    }
    else
    {
      QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131910890), 0).show();
      if (this.b) {
        j = 1;
      } else {
        j = 2;
      }
      StoryReportor.a("play_video", "report_fail", j, 0, new String[] { this.c, "", "", this.d });
    }
    ReportEvilToXinanHandler.ReportToXinanEvent localReportToXinanEvent = new ReportEvilToXinanHandler.ReportToXinanEvent(new ErrorMessage(i, ""), this.d, this.e, this.c);
    StoryDispatcher.a().dispatch(localReportToXinanEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler.2
 * JD-Core Version:    0.7.0.1
 */