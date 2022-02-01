import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class benl
  extends beny
  implements bens
{
  private CopyOnWriteArrayList<benm> a = new CopyOnWriteArrayList();
  
  public benl(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public int a()
  {
    return 0;
  }
  
  public benm a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (benm)this.a.get(paramInt);
  }
  
  public List<benm> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      benm localbenm = (benm)localIterator.next();
      if ((TextUtils.isEmpty(localbenm.a)) && (!TextUtils.isEmpty(localbenm.jdField_b_of_type_JavaLangString))) {
        localArrayList.add(localbenm);
      }
    }
    return localArrayList;
  }
  
  public JSONObject a()
  {
    return a(0);
  }
  
  public JSONObject a(int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject2 = ((benm)localIterator.next()).a(paramInt);
        if (localJSONObject2 != null) {
          localJSONArray.put(localJSONObject2);
        }
      }
      localJSONObject1.put("type", "calculation").put("imgs", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return localJSONObject1;
    }
    return localJSONObject1;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      benm localbenm = (benm)localIterator.next();
      int j = this.b.indexOf(Integer.valueOf(localbenm.jdField_b_of_type_Int));
      if (j <= i) {
        break label79;
      }
      i = j;
    }
    label79:
    for (;;)
    {
      break;
      this.g = ((Integer)this.b.get(i)).intValue();
      return;
    }
  }
  
  public void a(benm parambenm)
  {
    this.a.add(parambenm);
  }
  
  public void a(String paramString)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("imgs");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        benm localbenm = new benm();
        localbenm.a(localJSONObject);
        int j = this.a.indexOf(localbenm);
        if (j >= 0) {
          localbenm.copy(this.a.get(j));
        }
        localCopyOnWriteArrayList.add(localbenm);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArithmeticInfo", 2, "mergeData ,json = " + paramString);
      }
      this.a = localCopyOnWriteArrayList;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    super.a(paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a = new CopyOnWriteArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("imgs");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        benm localbenm = new benm();
        localbenm.a(localJSONObject);
        this.a.add(localbenm);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      benm localbenm = (benm)localIterator.next();
      if ((localbenm.jdField_b_of_type_Int != 3) && (localbenm.jdField_b_of_type_Int != 0)) {
        return false;
      }
    }
    return true;
  }
  
  public int b()
  {
    return 7;
  }
  
  public void b(benm parambenm)
  {
    this.a.remove(parambenm);
  }
  
  public int c()
  {
    return this.a.size();
  }
  
  public void c(benm parambenm)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      benm localbenm = (benm)localIterator.next();
      if (localbenm.equals(parambenm)) {
        localbenm.copy(parambenm);
      }
    }
  }
  
  public int d()
  {
    if (this.a.size() > 0) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benl
 * JD-Core Version:    0.7.0.1
 */