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
      i = new JSONObject(this.jdField_a_of_type_JavaLangString).getInt("rtn_code");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      i = -1;
    }
    int j;
    if (i == 0)
    {
      QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131713336), 0).a();
      if (this.jdField_a_of_type_Boolean) {
        j = 1;
      } else {
        j = 2;
      }
      StoryReportor.a("play_video", "report_suc", j, 0, new String[] { this.b, "", "", this.c });
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131713337), 0).a();
      if (this.jdField_a_of_type_Boolean) {
        j = 1;
      } else {
        j = 2;
      }
      StoryReportor.a("play_video", "report_fail", j, 0, new String[] { this.b, "", "", this.c });
    }
    ReportEvilToXinanHandler.ReportToXinanEvent localReportToXinanEvent = new ReportEvilToXinanHandler.ReportToXinanEvent(new ErrorMessage(i, ""), this.c, this.d, this.b);
    StoryDispatcher.a().dispatch(localReportToXinanEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler.2
 * JD-Core Version:    0.7.0.1
 */