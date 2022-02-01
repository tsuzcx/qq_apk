import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfej
  extends bfew
  implements bfeq
{
  private CopyOnWriteArrayList<bfek> a = new CopyOnWriteArrayList();
  
  public bfej(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public int a()
  {
    return 0;
  }
  
  public bfek a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (bfek)this.a.get(paramInt);
  }
  
  public List<bfek> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bfek localbfek = (bfek)localIterator.next();
      if ((TextUtils.isEmpty(localbfek.a)) && (!TextUtils.isEmpty(localbfek.jdField_b_of_type_JavaLangString))) {
        localArrayList.add(localbfek);
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
        JSONObject localJSONObject2 = ((bfek)localIterator.next()).a(paramInt);
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
      bfek localbfek = (bfek)localIterator.next();
      int j = this.b.indexOf(Integer.valueOf(localbfek.jdField_b_of_type_Int));
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
  
  public void a(bfek parambfek)
  {
    this.a.add(parambfek);
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
        bfek localbfek = new bfek();
        localbfek.a(localJSONObject);
        int j = this.a.indexOf(localbfek);
        if (j >= 0) {
          localbfek.copy(this.a.get(j));
        }
        localCopyOnWriteArrayList.add(localbfek);
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
        bfek localbfek = new bfek();
        localbfek.a(localJSONObject);
        this.a.add(localbfek);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bfek localbfek = (bfek)localIterator.next();
      if ((localbfek.jdField_b_of_type_Int != 3) && (localbfek.jdField_b_of_type_Int != 0)) {
        return false;
      }
    }
    return true;
  }
  
  public int b()
  {
    return 7;
  }
  
  public void b(bfek parambfek)
  {
    this.a.remove(parambfek);
  }
  
  public int c()
  {
    return this.a.size();
  }
  
  public void c(bfek parambfek)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bfek localbfek = (bfek)localIterator.next();
      if (localbfek.equals(parambfek)) {
        localbfek.copy(parambfek);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfej
 * JD-Core Version:    0.7.0.1
 */