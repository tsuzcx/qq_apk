import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class blii
{
  private int jdField_a_of_type_Int;
  private blij jdField_a_of_type_Blij;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[0];
  private ArrayList<View>[] jdField_a_of_type_ArrayOfJavaUtilArrayList;
  private int b;
  
  public blii(AbsListView paramAbsListView) {}
  
  private void d()
  {
    int m = this.jdField_a_of_type_ArrayOfAndroidViewView.length;
    int n = this.b;
    ArrayList[] arrayOfArrayList = this.jdField_a_of_type_ArrayOfJavaUtilArrayList;
    int i = 0;
    while (i < n)
    {
      ArrayList localArrayList = arrayOfArrayList[i];
      int i1 = localArrayList.size();
      int j = i1 - 1;
      int k = 0;
      while (k < i1 - m)
      {
        AbsListView.access$4400(this.jdField_a_of_type_ComTencentWidgetAbsListView, (View)localArrayList.remove(j), false);
        k += 1;
        j -= 1;
      }
      i += 1;
    }
  }
  
  public View a(int paramInt)
  {
    paramInt -= this.jdField_a_of_type_Int;
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if ((paramInt >= 0) && (paramInt < arrayOfView.length))
    {
      View localView = arrayOfView[paramInt];
      arrayOfView[paramInt] = null;
      return localView;
    }
    return null;
  }
  
  public void a()
  {
    int i = 0;
    ArrayList localArrayList;
    int j;
    if (this.b == 1)
    {
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      j = localArrayList.size();
      while (i < j)
      {
        ((View)localArrayList.get(i)).forceLayout();
        i += 1;
      }
    }
    int k = this.b;
    i = 0;
    while (i < k)
    {
      localArrayList = this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i];
      int m = localArrayList.size();
      j = 0;
      while (j < m)
      {
        ((View)localArrayList.get(j)).forceLayout();
        j += 1;
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
    }
    ArrayList[] arrayOfArrayList = new ArrayList[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfArrayList[i] = new ArrayList();
      i += 1;
    }
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = arrayOfArrayList[0];
    this.jdField_a_of_type_ArrayOfJavaUtilArrayList = arrayOfArrayList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView.length < paramInt1) {
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[paramInt1];
    }
    this.jdField_a_of_type_Int = paramInt2;
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(paramInt2);
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams != null) && (localLayoutParams.jdField_a_of_type_Int != -2)) {
        arrayOfView[paramInt2] = localView;
      }
      paramInt2 += 1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {}
    for (;;)
    {
      return;
      int i = localLayoutParams.jdField_a_of_type_Int;
      if (!a(i))
      {
        if (i != -2) {
          AbsListView.access$4100(this.jdField_a_of_type_ComTencentWidgetAbsListView, paramView, false);
        }
      }
      else
      {
        localLayoutParams.b = paramInt;
        if (this.b == 1)
        {
          AbsListView.access$4200(this.jdField_a_of_type_ComTencentWidgetAbsListView, paramView);
          this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
        }
        while (this.jdField_a_of_type_Blij != null)
        {
          this.jdField_a_of_type_Blij.b(paramView);
          return;
          AbsListView.access$4200(this.jdField_a_of_type_ComTencentWidgetAbsListView, paramView);
          if (i < this.jdField_a_of_type_ArrayOfJavaUtilArrayList.length) {
            this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i].add(paramView);
          }
        }
      }
    }
  }
  
  public void a(List<View> paramList)
  {
    if (this.b == 1) {
      paramList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      return;
      int j = this.b;
      ArrayList[] arrayOfArrayList = this.jdField_a_of_type_ArrayOfJavaUtilArrayList;
      int i = 0;
      while (i < j)
      {
        paramList.addAll(arrayOfArrayList[i]);
        i += 1;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= 0;
  }
  
  public View b(int paramInt)
  {
    if (this.b == 1) {
      return AbsListView.retrieveFromScrap(this.jdField_a_of_type_JavaUtilArrayList, paramInt);
    }
    int i = this.jdField_a_of_type_ComTencentWidgetAbsListView.mAdapter.getItemViewType(paramInt);
    if ((i >= 0) && (this.jdField_a_of_type_ArrayOfJavaUtilArrayList != null) && (i < this.jdField_a_of_type_ArrayOfJavaUtilArrayList.length)) {
      return AbsListView.retrieveFromScrap(this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i], paramInt);
    }
    return null;
  }
  
  public void b()
  {
    ArrayList localArrayList;
    int j;
    if (this.b == 1)
    {
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        AbsListView.access$3900(this.jdField_a_of_type_ComTencentWidgetAbsListView, (View)localArrayList.remove(j - 1 - i), false);
        i += 1;
      }
    }
    int k = this.b;
    int i = 0;
    while (i < k)
    {
      localArrayList = this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i];
      int m = localArrayList.size();
      j = 0;
      while (j < m)
      {
        AbsListView.access$4000(this.jdField_a_of_type_ComTencentWidgetAbsListView, (View)localArrayList.remove(m - 1 - j), false);
        j += 1;
      }
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.b == 1)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      j = ((ArrayList)localObject1).size();
      i = 0;
      while (i < j)
      {
        ((View)((ArrayList)localObject1).get(i)).setDrawingCacheBackgroundColor(paramInt);
        i += 1;
      }
    }
    int k = this.b;
    int i = 0;
    while (i < k)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i];
      int m = ((ArrayList)localObject1).size();
      j = 0;
      while (j < m)
      {
        ((View)((ArrayList)localObject1).get(j)).setDrawingCacheBackgroundColor(paramInt);
        j += 1;
      }
      i += 1;
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = localObject1.length;
    i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setDrawingCacheBackgroundColor(paramInt);
      }
      i += 1;
    }
  }
  
  public void c()
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int i;
    int j;
    label25:
    Object localObject1;
    int k;
    label37:
    View localView;
    Object localObject2;
    int m;
    if (this.jdField_a_of_type_Blij != null)
    {
      i = 1;
      if (this.b <= 1) {
        break label128;
      }
      j = 1;
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      k = arrayOfView.length - 1;
      if (k < 0) {
        break label200;
      }
      localView = arrayOfView[k];
      localObject2 = localObject1;
      if (localView != null)
      {
        localObject2 = (AbsListView.LayoutParams)localView.getLayoutParams();
        m = ((AbsListView.LayoutParams)localObject2).jdField_a_of_type_Int;
        arrayOfView[k] = null;
        if (a(m)) {
          break label133;
        }
        localObject2 = localObject1;
        if (m != -2)
        {
          AbsListView.access$4300(this.jdField_a_of_type_ComTencentWidgetAbsListView, localView, false);
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      k -= 1;
      localObject1 = localObject2;
      break label37;
      i = 0;
      break;
      label128:
      j = 0;
      break label25;
      label133:
      if (j != 0) {
        localObject1 = this.jdField_a_of_type_ArrayOfJavaUtilArrayList[m];
      }
      AbsListView.access$4200(this.jdField_a_of_type_ComTencentWidgetAbsListView, localView);
      ((AbsListView.LayoutParams)localObject2).b = (this.jdField_a_of_type_Int + k);
      ((ArrayList)localObject1).add(localView);
      localObject2 = localObject1;
      if (i != 0)
      {
        this.jdField_a_of_type_Blij.b(localView);
        localObject2 = localObject1;
      }
    }
    label200:
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     blii
 * JD-Core Version:    0.7.0.1
 */