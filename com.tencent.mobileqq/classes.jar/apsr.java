import android.util.Log;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class apsr
{
  public static int a;
  private static apsr jdField_a_of_type_Apsr;
  private Map<Integer, ArrayList<View>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  public static apsr a()
  {
    if (jdField_a_of_type_Apsr == null) {}
    try
    {
      if (jdField_a_of_type_Apsr == null) {
        jdField_a_of_type_Apsr = new apsr();
      }
      return jdField_a_of_type_Apsr;
    }
    finally {}
  }
  
  public View a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))))
    {
      Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (View)((ArrayList)localObject).remove(0);
        if (QLog.isColorLevel()) {
          Log.d("EmotionPanelViewPool", "getView from pool : paneyType = " + paramInt);
        }
        return localObject;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelViewPool", 2, "destory");
    }
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList != null) {
          localArrayList.clear();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList;
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
        localArrayList = new ArrayList();
        localArrayList.add(paramView);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localArrayList);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
      {
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        if ((localArrayList != null) && (!localArrayList.contains(paramView))) {
          localArrayList.add(0, paramView);
        }
      }
      while (QLog.isColorLevel())
      {
        Log.d("EmotionPanelViewPool", "relase view panelType = " + paramInt);
        return;
        localArrayList = new ArrayList();
        localArrayList.add(0, paramView);
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsr
 * JD-Core Version:    0.7.0.1
 */