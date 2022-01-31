import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bbvf
  implements azgl
{
  public bbvf(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
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
                if (this.a.jdField_a_of_type_Xez == null)
                {
                  this.a.jdField_a_of_type_Xez = new xez(this.a);
                  this.a.jdField_a_of_type_Xez.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131624920));
                  this.a.jdField_a_of_type_Xez.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131624919, new Object[] { this.a.e }), this.a);
                  this.a.jdField_a_of_type_Xez.a(this.a);
                }
                if (!this.a.jdField_a_of_type_Xez.isShowing()) {
                  this.a.jdField_a_of_type_Xez.show();
                }
                awqx.b(this.a.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
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
            BindGroupConfirmActivity.a(this.a, this.a.getActivity().getResources().getString(2131654570));
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupConfirmActivity", 2, "bindGroup onResult " + paramJSONObject.toString());
    return;
    label336:
    paramJSONObject = this.a.getActivity().getResources().getString(2131654570);
    switch (paramInt)
    {
    }
    for (;;)
    {
      BindGroupConfirmActivity.a(this.a, paramJSONObject);
      break;
      paramJSONObject = this.a.getActivity().getResources().getString(2131654573);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131654572);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131654568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbvf
 * JD-Core Version:    0.7.0.1
 */