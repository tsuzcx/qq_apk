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

public class aucw
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aucx(this);
  aucz jdField_a_of_type_Aucz;
  audj jdField_a_of_type_Audj = new audj();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<aucy> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aucw(Context paramContext, QQAppInterface paramQQAppInterface, aucz paramaucz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aucz = paramaucz;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(audf paramaudf, List<aubf> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramaudf, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(audf paramaudf, List<aubf> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    aubf localaubf;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (aucy)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((aucy)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localaubf = (aubf)paramList.get(i);
      if (paramaudf.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new aucy(this);
      ((aucy)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localaubf.jdField_a_of_type_JavaLangString))
      {
        ((aucy)localObject2).jdField_a_of_type_JavaLangObject = localaubf.jdField_a_of_type_JavaLangString;
        ((aucy)localObject2).jdField_a_of_type_JavaLangString = localaubf.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localaubf.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramaudf.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new aucy(this);
            ((aucy)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new aucy(this);
          ((aucy)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localaubf.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (aubg)localaubf.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new aucy(this);
            ((aucy)localObject3).jdField_a_of_type_Int = 0;
            ((aucy)localObject3).jdField_a_of_type_JavaLangObject = ((aubg)localObject2).jdField_a_of_type_JavaLangObject;
            ((aucy)localObject3).jdField_a_of_type_JavaLangString = localaubf.jdField_a_of_type_JavaLangString;
            ((aucy)localObject3).jdField_b_of_type_Int = localaubf.jdField_a_of_type_Int;
            ((aucy)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localaubf.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new aucy(this);
              ((aucy)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localaubf.jdField_b_of_type_JavaLangString)) && (paramaudf.jdField_a_of_type_Int == 0))
      {
        localObject2 = localaubf.jdField_b_of_type_JavaLangString;
        localObject3 = localaubf.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new aucy(this);
          ((aucy)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new aucy(this);
          ((aucy)localObject2).jdField_a_of_type_Int = 4;
          ((aucy)localObject2).jdField_c_of_type_JavaLangString = localaubf.jdField_b_of_type_JavaLangString;
          ((aucy)localObject2).jdField_a_of_type_JavaLangString = localaubf.jdField_a_of_type_JavaLangString;
          ((aucy)localObject2).jdField_b_of_type_JavaLangString = localaubf.jdField_c_of_type_JavaLangString;
          ((aucy)localObject2).jdField_b_of_type_Int = localaubf.jdField_a_of_type_Int;
          ((aucy)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((aucy)localObject1).jdField_b_of_type_JavaLangString = localaubf.jdField_c_of_type_JavaLangString;
            ((aucy)localObject1).jdField_c_of_type_JavaLangString = localaubf.jdField_b_of_type_JavaLangString;
            ((aucy)localObject1).jdField_b_of_type_Int = localaubf.jdField_a_of_type_Int;
            ((aucy)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramaudf = new aucy(this);
      paramaudf.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramaudf);
      if (paramBoolean2)
      {
        paramaudf = new aucy(this);
        paramaudf.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramaudf);
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
    return ((aucy)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    aucy localaucy = (aucy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localaucy.jdField_a_of_type_Int == 0)
    {
      localObject = (audg)this.jdField_a_of_type_Audj.a(0);
      ((audg)localObject).a(paramViewGroup);
      localObject = ((audg)localObject).a(paramInt, paramView, paramViewGroup, this, localaucy);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localaucy);
      return localObject;
      localObject = paramView;
      if (localaucy.jdField_a_of_type_Int == 1) {
        localObject = ((audd)this.jdField_a_of_type_Audj.a(1)).a(paramInt, paramView, paramViewGroup, this, localaucy);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucw
 * JD-Core Version:    0.7.0.1
 */