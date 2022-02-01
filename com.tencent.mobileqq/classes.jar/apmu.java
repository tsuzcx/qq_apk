import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class apmu
  implements nuw
{
  apmu(apms paramapms, apmv paramapmv, ArrayList paramArrayList, apmr paramapmr) {}
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline package finish, code = " + paramInt + "param1" + paramString);
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.jdField_a_of_type_Apmv != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Apmr);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
          {
            this.jdField_a_of_type_Apmv.a(true);
            this.jdField_a_of_type_Apmv.a(4, true);
            this.jdField_a_of_type_Apms.a();
          }
        }
      }
    }
    label244:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                try
                {
                  paramString = new JSONObject(paramString);
                  if (!paramString.has("data")) {
                    break label244;
                  }
                  paramString = paramString.getJSONArray("data");
                  if (((paramString.length() == 0) || (!paramString.getJSONObject(0).has("bid"))) || (this.jdField_a_of_type_Apmv != null))
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Apmr);
                    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
                    {
                      this.jdField_a_of_type_Apmv.a(true);
                      this.jdField_a_of_type_Apmv.a(4, true);
                      this.jdField_a_of_type_Apms.a();
                      return;
                    }
                  }
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                }
              }
            } while (this.jdField_a_of_type_Apmv == null);
            this.jdField_a_of_type_Apmv.a(false);
            this.jdField_a_of_type_Apmv.a(4, false);
            this.jdField_a_of_type_Apms.a();
            return;
            paramString = this.jdField_a_of_type_Apmv;
          } while (paramString == null);
          return;
          if (paramInt != 7) {
            break;
          }
        } while (this.jdField_a_of_type_Apmv == null);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Apmr);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() != 0);
      this.jdField_a_of_type_Apmv.a(true);
      this.jdField_a_of_type_Apmv.a(4, true);
      this.jdField_a_of_type_Apms.a();
      return;
    } while (this.jdField_a_of_type_Apmv == null);
    this.jdField_a_of_type_Apmv.a(false);
    this.jdField_a_of_type_Apmv.a(4, false);
    this.jdField_a_of_type_Apms.a();
  }
  
  public void progress(int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline progress  = " + paramInt);
    if (this.jdField_a_of_type_Apmv != null) {
      this.jdField_a_of_type_Apmv.a(apms.a(this.jdField_a_of_type_Apms, 0L, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmu
 * JD-Core Version:    0.7.0.1
 */