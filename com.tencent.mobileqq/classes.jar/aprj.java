import android.util.SparseArray;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aprj
{
  private SparseArray<List<View>> a = new SparseArray();
  
  public View a(int paramInt)
  {
    List localList = (List)this.a.get(paramInt);
    if ((localList != null) && (localList.size() > 0)) {
      return (View)localList.remove(0);
    }
    return null;
  }
  
  public void a()
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      int k = this.a.keyAt(i);
      ((List)this.a.get(k)).clear();
      i += 1;
    }
    this.a.clear();
  }
  
  public boolean a(int paramInt, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewPool", 2, "[RecyleView] addRecyleView, type=" + paramInt + ", view=" + paramView);
    }
    if (paramView == null) {
      return false;
    }
    List localList = (List)this.a.get(paramInt);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList(3);
      this.a.put(paramInt, localObject);
    }
    if (((List)localObject).size() >= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.w("EmoticonPanelViewPool", 2, "Capacity full for type " + paramInt);
      }
      return false;
    }
    ((List)localObject).add(paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprj
 * JD-Core Version:    0.7.0.1
 */