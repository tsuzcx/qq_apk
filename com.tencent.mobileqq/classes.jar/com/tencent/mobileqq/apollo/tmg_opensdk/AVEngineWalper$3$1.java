package com.tencent.mobileqq.apollo.tmg_opensdk;

import algt;
import algw;
import alhb;
import android.text.TextUtils;
import bgkw;
import com.tencent.TMG.sdk.AVCustomSpearEngineCtrl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class AVEngineWalper$3$1
  implements Runnable
{
  public AVEngineWalper$3$1(algw paramalgw, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject1 = new JSONTokener(new String(this.jdField_a_of_type_ArrayOfByte));
    if ((this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_AndroidContentContext == null) || (alhb.a(this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_AndroidContentContext) == null) || (alhb.a(this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_AndroidContentContext).a() == null)) {
      if (this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_Bgkw != null) {
        this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_Bgkw.b(1, "context is null !!!!");
      }
    }
    AVCustomSpearEngineCtrl localAVCustomSpearEngineCtrl;
    do
    {
      return;
      localAVCustomSpearEngineCtrl = alhb.a(this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_AndroidContentContext).a();
      if (localAVCustomSpearEngineCtrl != null) {
        break;
      }
    } while (this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_Bgkw == null);
    this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_Bgkw.b(1, "get spearEngineCtrl failed!!!!");
    return;
    for (;;)
    {
      int i;
      try
      {
        localObject1 = (JSONObject)((JSONTokener)localObject1).nextValue();
        if ((localObject1 == null) || (TextUtils.isEmpty(((JSONObject)localObject1).toString()))) {
          QLog.e("AVEngineWalper", 1, "Json is invalid!!");
        }
        localObject1 = (JSONObject)((JSONObject)localObject1).get("data");
        if (localObject1 != null)
        {
          JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("conf");
          if (localJSONArray != null)
          {
            int j = localJSONArray.length();
            i = 0;
            if (i < j)
            {
              Object localObject2 = (JSONObject)localJSONArray.get(i);
              String str = localJSONArray.getString(i);
              if ((localObject2 == null) || (str == null)) {
                break label414;
              }
              localObject2 = ((JSONObject)localObject2).getString("role");
              if (localObject2 == null) {
                break label414;
              }
              localAVCustomSpearEngineCtrl.addParamByRole((String)localObject2, str);
              QLog.e("AVEngineWalper", 1, "Add Role mAppID=" + this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_JavaLangString + ", roleName=" + (String)localObject2 + ", strRoleConf=" + str);
              break label414;
            }
          }
          localAVCustomSpearEngineCtrl.setSpearEngineScence(((JSONObject)localObject1).getInt("scheme"));
        }
        this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.a(this.jdField_a_of_type_Algw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Algw.jdField_a_of_type_Boolean, this.jdField_a_of_type_Algw.b);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_Bgkw == null) {
        break;
      }
      this.jdField_a_of_type_Algw.jdField_a_of_type_Algt.jdField_a_of_type_Bgkw.b(1, "spearEngineCtrl addParamByRole failed!!!!");
      return;
      label414:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper.3.1
 * JD-Core Version:    0.7.0.1
 */