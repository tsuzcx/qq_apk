import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bikj
  implements bfpo
{
  public bikj(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null) {
          try
          {
            paramJSONObject = (JSONObject)paramJSONObject.get("data");
            if (paramJSONObject != null)
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("key");
              if (paramJSONObject != null)
              {
                paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                paramBundle = (String)paramJSONObject.get("retMsg");
                if (paramInt != 0) {
                  break label336;
                }
                if (this.a.jdField_a_of_type_Abdx == null)
                {
                  this.a.jdField_a_of_type_Abdx = new abdx(this.a);
                  this.a.jdField_a_of_type_Abdx.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690511));
                  this.a.jdField_a_of_type_Abdx.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690510, new Object[] { this.a.e }), this.a);
                  this.a.jdField_a_of_type_Abdx.a(this.a);
                }
                if (!this.a.jdField_a_of_type_Abdx.isShowing()) {
                  this.a.jdField_a_of_type_Abdx.show();
                }
                bcst.b(this.a.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
                if (QLog.isColorLevel())
                {
                  QLog.i("BindGroupConfirmActivity", 2, "bindGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                  return;
                }
              }
            }
          }
          catch (Exception paramJSONObject)
          {
            BindGroupConfirmActivity.a(this.a, this.a.getActivity().getResources().getString(2131718764));
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupConfirmActivity", 2, "bindGroup onResult " + paramJSONObject.toString());
    return;
    label336:
    paramJSONObject = this.a.getActivity().getResources().getString(2131718764);
    switch (paramInt)
    {
    }
    for (;;)
    {
      BindGroupConfirmActivity.a(this.a, paramJSONObject);
      break;
      paramJSONObject = this.a.getActivity().getResources().getString(2131718767);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131718766);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131718762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bikj
 * JD-Core Version:    0.7.0.1
 */