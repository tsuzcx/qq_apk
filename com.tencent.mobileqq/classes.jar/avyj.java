import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class avyj
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avyk(this);
  avym jdField_a_of_type_Avym;
  avyw jdField_a_of_type_Avyw = new avyw();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<avyl> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public avyj(Context paramContext, QQAppInterface paramQQAppInterface, avym paramavym)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Avym = paramavym;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(avys paramavys, List<avws> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramavys, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(avys paramavys, List<avws> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    avws localavws;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (avyl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((avyl)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localavws = (avws)paramList.get(i);
      if (paramavys.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new avyl(this);
      ((avyl)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localavws.jdField_a_of_type_JavaLangString))
      {
        ((avyl)localObject2).jdField_a_of_type_JavaLangObject = localavws.jdField_a_of_type_JavaLangString;
        ((avyl)localObject2).jdField_a_of_type_JavaLangString = localavws.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localavws.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramavys.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new avyl(this);
            ((avyl)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new avyl(this);
          ((avyl)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localavws.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (avwt)localavws.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new avyl(this);
            ((avyl)localObject3).jdField_a_of_type_Int = 0;
            ((avyl)localObject3).jdField_a_of_type_JavaLangObject = ((avwt)localObject2).jdField_a_of_type_JavaLangObject;
            ((avyl)localObject3).jdField_a_of_type_JavaLangString = localavws.jdField_a_of_type_JavaLangString;
            ((avyl)localObject3).jdField_b_of_type_Int = localavws.jdField_a_of_type_Int;
            ((avyl)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localavws.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new avyl(this);
              ((avyl)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localavws.jdField_b_of_type_JavaLangString)) && (paramavys.jdField_a_of_type_Int == 0))
      {
        localObject2 = localavws.jdField_b_of_type_JavaLangString;
        localObject3 = localavws.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new avyl(this);
          ((avyl)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new avyl(this);
          ((avyl)localObject2).jdField_a_of_type_Int = 4;
          ((avyl)localObject2).jdField_c_of_type_JavaLangString = localavws.jdField_b_of_type_JavaLangString;
          ((avyl)localObject2).jdField_a_of_type_JavaLangString = localavws.jdField_a_of_type_JavaLangString;
          ((avyl)localObject2).jdField_b_of_type_JavaLangString = localavws.jdField_c_of_type_JavaLangString;
          ((avyl)localObject2).jdField_b_of_type_Int = localavws.jdField_a_of_type_Int;
          ((avyl)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((avyl)localObject1).jdField_b_of_type_JavaLangString = localavws.jdField_c_of_type_JavaLangString;
            ((avyl)localObject1).jdField_c_of_type_JavaLangString = localavws.jdField_b_of_type_JavaLangString;
            ((avyl)localObject1).jdField_b_of_type_Int = localavws.jdField_a_of_type_Int;
            ((avyl)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramavys = new avyl(this);
      paramavys.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramavys);
      if (paramBoolean2)
      {
        paramavys = new avyl(this);
        paramavys.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramavys);
      }
      super.notifyDataSetChanged();
      return;
      label666:
      localObject2 = null;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((avyl)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    avyl localavyl = (avyl)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localavyl.jdField_a_of_type_Int == 0)
    {
      localObject = (avyt)this.jdField_a_of_type_Avyw.a(0);
      ((avyt)localObject).a(paramViewGroup);
      localObject = ((avyt)localObject).a(paramInt, paramView, paramViewGroup, this, localavyl);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localavyl);
      return localObject;
      localObject = paramView;
      if (localavyl.jdField_a_of_type_Int == 1) {
        localObject = ((avyq)this.jdField_a_of_type_Avyw.a(1)).a(paramInt, paramView, paramViewGroup, this, localavyl);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyj
 * JD-Core Version:    0.7.0.1
 */