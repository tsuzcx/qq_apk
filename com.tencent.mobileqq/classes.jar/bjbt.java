import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bjbt
  implements bghi
{
  public bjbt(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
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
                if (this.a.jdField_a_of_type_Aatx == null)
                {
                  this.a.jdField_a_of_type_Aatx = new aatx(this.a);
                  this.a.jdField_a_of_type_Aatx.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690621));
                  this.a.jdField_a_of_type_Aatx.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690620, new Object[] { this.a.e }), this.a);
                  this.a.jdField_a_of_type_Aatx.a(this.a);
                }
                if (!this.a.jdField_a_of_type_Aatx.isShowing()) {
                  this.a.jdField_a_of_type_Aatx.show();
                }
                bdla.b(this.a.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
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
            BindGroupConfirmActivity.a(this.a, this.a.getActivity().getResources().getString(2131719594));
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupConfirmActivity", 2, "bindGroup onResult " + paramJSONObject.toString());
    return;
    label336:
    paramJSONObject = this.a.getActivity().getResources().getString(2131719594);
    switch (paramInt)
    {
    }
    for (;;)
    {
      BindGroupConfirmActivity.a(this.a, paramJSONObject);
      break;
      paramJSONObject = this.a.getActivity().getResources().getString(2131719597);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131719596);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131719592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbt
 * JD-Core Version:    0.7.0.1
 */