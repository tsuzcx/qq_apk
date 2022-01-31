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

public class aucu
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aucv(this);
  aucx jdField_a_of_type_Aucx;
  audh jdField_a_of_type_Audh = new audh();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<aucw> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aucu(Context paramContext, QQAppInterface paramQQAppInterface, aucx paramaucx)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aucx = paramaucx;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(audd paramaudd, List<aubd> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramaudd, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(audd paramaudd, List<aubd> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    aubd localaubd;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (aucw)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((aucw)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localaubd = (aubd)paramList.get(i);
      if (paramaudd.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new aucw(this);
      ((aucw)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localaubd.jdField_a_of_type_JavaLangString))
      {
        ((aucw)localObject2).jdField_a_of_type_JavaLangObject = localaubd.jdField_a_of_type_JavaLangString;
        ((aucw)localObject2).jdField_a_of_type_JavaLangString = localaubd.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localaubd.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramaudd.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new aucw(this);
            ((aucw)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new aucw(this);
          ((aucw)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localaubd.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (aube)localaubd.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new aucw(this);
            ((aucw)localObject3).jdField_a_of_type_Int = 0;
            ((aucw)localObject3).jdField_a_of_type_JavaLangObject = ((aube)localObject2).jdField_a_of_type_JavaLangObject;
            ((aucw)localObject3).jdField_a_of_type_JavaLangString = localaubd.jdField_a_of_type_JavaLangString;
            ((aucw)localObject3).jdField_b_of_type_Int = localaubd.jdField_a_of_type_Int;
            ((aucw)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localaubd.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new aucw(this);
              ((aucw)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localaubd.jdField_b_of_type_JavaLangString)) && (paramaudd.jdField_a_of_type_Int == 0))
      {
        localObject2 = localaubd.jdField_b_of_type_JavaLangString;
        localObject3 = localaubd.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new aucw(this);
          ((aucw)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new aucw(this);
          ((aucw)localObject2).jdField_a_of_type_Int = 4;
          ((aucw)localObject2).jdField_c_of_type_JavaLangString = localaubd.jdField_b_of_type_JavaLangString;
          ((aucw)localObject2).jdField_a_of_type_JavaLangString = localaubd.jdField_a_of_type_JavaLangString;
          ((aucw)localObject2).jdField_b_of_type_JavaLangString = localaubd.jdField_c_of_type_JavaLangString;
          ((aucw)localObject2).jdField_b_of_type_Int = localaubd.jdField_a_of_type_Int;
          ((aucw)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((aucw)localObject1).jdField_b_of_type_JavaLangString = localaubd.jdField_c_of_type_JavaLangString;
            ((aucw)localObject1).jdField_c_of_type_JavaLangString = localaubd.jdField_b_of_type_JavaLangString;
            ((aucw)localObject1).jdField_b_of_type_Int = localaubd.jdField_a_of_type_Int;
            ((aucw)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramaudd = new aucw(this);
      paramaudd.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramaudd);
      if (paramBoolean2)
      {
        paramaudd = new aucw(this);
        paramaudd.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramaudd);
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
    return ((aucw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    aucw localaucw = (aucw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localaucw.jdField_a_of_type_Int == 0)
    {
      localObject = (aude)this.jdField_a_of_type_Audh.a(0);
      ((aude)localObject).a(paramViewGroup);
      localObject = ((aude)localObject).a(paramInt, paramView, paramViewGroup, this, localaucw);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localaucw);
      return localObject;
      localObject = paramView;
      if (localaucw.jdField_a_of_type_Int == 1) {
        localObject = ((audb)this.jdField_a_of_type_Audh.a(1)).a(paramInt, paramView, paramViewGroup, this, localaucw);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucu
 * JD-Core Version:    0.7.0.1
 */