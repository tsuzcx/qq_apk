import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.qphone.base.util.QLog;

public abstract class aniw
  extends anjf
{
  private static aniy a;
  public int a;
  protected Context a;
  protected SparseArray<View> a;
  
  public aniw(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramInt1);
    if (paramContext == null) {
      throw new IllegalArgumentException("Context MUST NOT be null!!!");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Aniy != null)
    {
      jdField_a_of_type_Aniy.a();
      jdField_a_of_type_Aniy = null;
    }
  }
  
  protected abstract int a(int paramInt);
  
  protected View a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, " createEmoticonPanelView, type=" + paramInt);
    }
    long l = System.currentTimeMillis();
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelViewBinder", 2, "[Performance] createEmoticonPanelView, type=" + paramInt + ",duration=" + (System.currentTimeMillis() - l));
      }
      return localObject;
      localObject = new EmoticonLinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
      ((EmoticonLinearLayout)localObject).setPanelViewType(paramInt);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        } while (localView == null);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
        paramInt = a(paramInt);
      } while (!a(paramInt));
      if (jdField_a_of_type_Aniy == null) {
        jdField_a_of_type_Aniy = new aniy();
      }
    } while (jdField_a_of_type_Aniy.a(paramInt, localView));
  }
  
  protected abstract void a(View paramView, int paramInt);
  
  public View b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, "getEmoticonPanelView, pageIndex=" + paramInt + ",viewBinder=" + this);
    }
    int i = a(paramInt);
    View localView1 = null;
    if (jdField_a_of_type_Aniy != null) {
      localView1 = jdField_a_of_type_Aniy.a(i);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = a(i);
    }
    if (localView2 != null)
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localView2);
      a(localView2, paramInt);
    }
    return localView2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aniw
 * JD-Core Version:    0.7.0.1
 */