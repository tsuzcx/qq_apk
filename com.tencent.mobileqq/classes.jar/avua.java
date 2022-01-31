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

public class avua
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avub(this);
  avud jdField_a_of_type_Avud;
  avun jdField_a_of_type_Avun = new avun();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<avuc> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public avua(Context paramContext, QQAppInterface paramQQAppInterface, avud paramavud)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Avud = paramavud;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(avuj paramavuj, List<avsj> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramavuj, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(avuj paramavuj, List<avsj> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    avsj localavsj;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (avuc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((avuc)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localavsj = (avsj)paramList.get(i);
      if (paramavuj.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new avuc(this);
      ((avuc)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localavsj.jdField_a_of_type_JavaLangString))
      {
        ((avuc)localObject2).jdField_a_of_type_JavaLangObject = localavsj.jdField_a_of_type_JavaLangString;
        ((avuc)localObject2).jdField_a_of_type_JavaLangString = localavsj.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localavsj.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramavuj.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new avuc(this);
            ((avuc)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new avuc(this);
          ((avuc)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localavsj.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (avsk)localavsj.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new avuc(this);
            ((avuc)localObject3).jdField_a_of_type_Int = 0;
            ((avuc)localObject3).jdField_a_of_type_JavaLangObject = ((avsk)localObject2).jdField_a_of_type_JavaLangObject;
            ((avuc)localObject3).jdField_a_of_type_JavaLangString = localavsj.jdField_a_of_type_JavaLangString;
            ((avuc)localObject3).jdField_b_of_type_Int = localavsj.jdField_a_of_type_Int;
            ((avuc)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localavsj.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new avuc(this);
              ((avuc)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localavsj.jdField_b_of_type_JavaLangString)) && (paramavuj.jdField_a_of_type_Int == 0))
      {
        localObject2 = localavsj.jdField_b_of_type_JavaLangString;
        localObject3 = localavsj.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new avuc(this);
          ((avuc)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new avuc(this);
          ((avuc)localObject2).jdField_a_of_type_Int = 4;
          ((avuc)localObject2).jdField_c_of_type_JavaLangString = localavsj.jdField_b_of_type_JavaLangString;
          ((avuc)localObject2).jdField_a_of_type_JavaLangString = localavsj.jdField_a_of_type_JavaLangString;
          ((avuc)localObject2).jdField_b_of_type_JavaLangString = localavsj.jdField_c_of_type_JavaLangString;
          ((avuc)localObject2).jdField_b_of_type_Int = localavsj.jdField_a_of_type_Int;
          ((avuc)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((avuc)localObject1).jdField_b_of_type_JavaLangString = localavsj.jdField_c_of_type_JavaLangString;
            ((avuc)localObject1).jdField_c_of_type_JavaLangString = localavsj.jdField_b_of_type_JavaLangString;
            ((avuc)localObject1).jdField_b_of_type_Int = localavsj.jdField_a_of_type_Int;
            ((avuc)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramavuj = new avuc(this);
      paramavuj.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramavuj);
      if (paramBoolean2)
      {
        paramavuj = new avuc(this);
        paramavuj.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramavuj);
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
    return ((avuc)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    avuc localavuc = (avuc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localavuc.jdField_a_of_type_Int == 0)
    {
      localObject = (avuk)this.jdField_a_of_type_Avun.a(0);
      ((avuk)localObject).a(paramViewGroup);
      localObject = ((avuk)localObject).a(paramInt, paramView, paramViewGroup, this, localavuc);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localavuc);
      return localObject;
      localObject = paramView;
      if (localavuc.jdField_a_of_type_Int == 1) {
        localObject = ((avuh)this.jdField_a_of_type_Avun.a(1)).a(paramInt, paramView, paramViewGroup, this, localavuc);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avua
 * JD-Core Version:    0.7.0.1
 */