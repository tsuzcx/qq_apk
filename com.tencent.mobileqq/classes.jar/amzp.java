import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class amzp
  implements nbs
{
  amzp(amzn paramamzn, amzq paramamzq, ArrayList paramArrayList, amzm paramamzm) {}
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline package finish, code = " + paramInt + "param1" + paramString);
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.jdField_a_of_type_Amzq != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Amzm);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
          {
            this.jdField_a_of_type_Amzq.a(true);
            this.jdField_a_of_type_Amzq.a(4, true);
            this.jdField_a_of_type_Amzn.a();
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
                  if (((paramString.length() == 0) || (!paramString.getJSONObject(0).has("bid"))) || (this.jdField_a_of_type_Amzq != null))
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Amzm);
                    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
                    {
                      this.jdField_a_of_type_Amzq.a(true);
                      this.jdField_a_of_type_Amzq.a(4, true);
                      this.jdField_a_of_type_Amzn.a();
                      return;
                    }
                  }
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                }
              }
            } while (this.jdField_a_of_type_Amzq == null);
            this.jdField_a_of_type_Amzq.a(false);
            this.jdField_a_of_type_Amzq.a(4, false);
            this.jdField_a_of_type_Amzn.a();
            return;
            paramString = this.jdField_a_of_type_Amzq;
          } while (paramString == null);
          return;
          if (paramInt != 7) {
            break;
          }
        } while (this.jdField_a_of_type_Amzq == null);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Amzm);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() != 0);
      this.jdField_a_of_type_Amzq.a(true);
      this.jdField_a_of_type_Amzq.a(4, true);
      this.jdField_a_of_type_Amzn.a();
      return;
    } while (this.jdField_a_of_type_Amzq == null);
    this.jdField_a_of_type_Amzq.a(false);
    this.jdField_a_of_type_Amzq.a(4, false);
    this.jdField_a_of_type_Amzn.a();
  }
  
  public void progress(int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline progress  = " + paramInt);
    if (this.jdField_a_of_type_Amzq != null) {
      this.jdField_a_of_type_Amzq.a(amzn.a(this.jdField_a_of_type_Amzn, 0L, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzp
 * JD-Core Version:    0.7.0.1
 */