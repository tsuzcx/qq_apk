package com.tencent.biz.qqstory.network.handler;

import amtj;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import org.json.JSONException;
import org.json.JSONObject;
import vli;
import wct;
import wcu;
import xwa;

public class ReportEvilToXinanHandler$2
  implements Runnable
{
  public ReportEvilToXinanHandler$2(wct paramwct, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    int i = -1;
    try
    {
      j = new JSONObject(this.jdField_a_of_type_JavaLangString).getInt("rtn_code");
      i = j;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        wcu localwcu;
        localJSONException.printStackTrace();
        continue;
        j = 2;
      }
      QQToast.a(BaseApplication.getContext(), amtj.a(2131712526), 0).a();
      if (!this.jdField_a_of_type_Boolean) {
        break label205;
      }
    }
    if (i == 0)
    {
      QQToast.a(BaseApplication.getContext(), amtj.a(2131712525), 0).a();
      if (this.jdField_a_of_type_Boolean)
      {
        j = 1;
        xwa.a("play_video", "report_suc", j, 0, new String[] { this.b, "", "", this.c });
        localwcu = new wcu(new ErrorMessage(i, ""), this.c, this.d, this.b);
        vli.a().dispatch(localwcu);
        return;
      }
    }
    label205:
    for (int j = 1;; j = 2)
    {
      xwa.a("play_video", "report_fail", j, 0, new String[] { this.b, "", "", this.c });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler.2
 * JD-Core Version:    0.7.0.1
 */