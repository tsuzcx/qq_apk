import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbtz
{
  public bbub a;
  private Comparator<bbud> a;
  public Vector<bbud> a;
  public AtomicBoolean a;
  public boolean a;
  
  public bbtz()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_JavaUtilComparator = new bbua(this);
  }
  
  public void a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject = paramString.optJSONArray("effectSwitch");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          if (((JSONArray)localObject).getJSONObject(0).optInt("androidSwitch") == 1)
          {
            bool = true;
            this.jdField_a_of_type_Boolean = bool;
          }
        }
        else
        {
          paramString = paramString.optJSONArray("grayMsgList");
          if ((paramString != null) && (paramString.length() > 0))
          {
            if (i < paramString.length())
            {
              localObject = paramString.getJSONObject(i);
              bbud localbbud = new bbud();
              localbbud.a((JSONObject)localObject);
              this.jdField_a_of_type_JavaUtilVector.add(localbbud);
              i += 1;
              continue;
            }
            Collections.sort(this.jdField_a_of_type_JavaUtilVector, this.jdField_a_of_type_JavaUtilComparator);
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Config", 2, "config mergeFromJSON enable = " + this.jdField_a_of_type_Boolean + " graytips: " + this.jdField_a_of_type_JavaUtilVector.size());
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TroopEnterEffect.Config", 1, "mergeFromJSON error: " + paramString.getMessage());
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtz
 * JD-Core Version:    0.7.0.1
 */