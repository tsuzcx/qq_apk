import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class andy
  implements nbs
{
  andy(andw paramandw, andz paramandz, ArrayList paramArrayList, andv paramandv) {}
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline package finish, code = " + paramInt + "param1" + paramString);
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.jdField_a_of_type_Andz != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Andv);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
          {
            this.jdField_a_of_type_Andz.a(true);
            this.jdField_a_of_type_Andz.a(4, true);
            this.jdField_a_of_type_Andw.a();
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
                  if (((paramString.length() == 0) || (!paramString.getJSONObject(0).has("bid"))) || (this.jdField_a_of_type_Andz != null))
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Andv);
                    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
                    {
                      this.jdField_a_of_type_Andz.a(true);
                      this.jdField_a_of_type_Andz.a(4, true);
                      this.jdField_a_of_type_Andw.a();
                      return;
                    }
                  }
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                }
              }
            } while (this.jdField_a_of_type_Andz == null);
            this.jdField_a_of_type_Andz.a(false);
            this.jdField_a_of_type_Andz.a(4, false);
            this.jdField_a_of_type_Andw.a();
            return;
            paramString = this.jdField_a_of_type_Andz;
          } while (paramString == null);
          return;
          if (paramInt != 7) {
            break;
          }
        } while (this.jdField_a_of_type_Andz == null);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Andv);
      } while (this.jdField_a_of_type_JavaUtilArrayList.size() != 0);
      this.jdField_a_of_type_Andz.a(true);
      this.jdField_a_of_type_Andz.a(4, true);
      this.jdField_a_of_type_Andw.a();
      return;
    } while (this.jdField_a_of_type_Andz == null);
    this.jdField_a_of_type_Andz.a(false);
    this.jdField_a_of_type_Andz.a(4, false);
    this.jdField_a_of_type_Andw.a();
  }
  
  public void progress(int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline progress  = " + paramInt);
    if (this.jdField_a_of_type_Andz != null) {
      this.jdField_a_of_type_Andz.a(andw.a(this.jdField_a_of_type_Andw, 0L, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andy
 * JD-Core Version:    0.7.0.1
 */