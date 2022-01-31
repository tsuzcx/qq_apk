package com.tencent.biz.qqstory.network.handler;

import ajyc;
import bcpw;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import org.json.JSONException;
import org.json.JSONObject;
import ste;
import tky;
import tkz;
import vel;

public class ReportEvilToXinanHandler$2
  implements Runnable
{
  public ReportEvilToXinanHandler$2(tky paramtky, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {}
  
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
        tkz localtkz;
        localJSONException.printStackTrace();
        continue;
        j = 2;
      }
      bcpw.a(BaseApplication.getContext(), ajyc.a(2131713411), 0).a();
      if (!this.jdField_a_of_type_Boolean) {
        break label205;
      }
    }
    if (i == 0)
    {
      bcpw.a(BaseApplication.getContext(), ajyc.a(2131713410), 0).a();
      if (this.jdField_a_of_type_Boolean)
      {
        j = 1;
        vel.a("play_video", "report_suc", j, 0, new String[] { this.b, "", "", this.c });
        localtkz = new tkz(new ErrorMessage(i, ""), this.c, this.d, this.b);
        ste.a().dispatch(localtkz);
        return;
      }
    }
    label205:
    for (int j = 1;; j = 2)
    {
      vel.a("play_video", "report_fail", j, 0, new String[] { this.b, "", "", this.c });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler.2
 * JD-Core Version:    0.7.0.1
 */