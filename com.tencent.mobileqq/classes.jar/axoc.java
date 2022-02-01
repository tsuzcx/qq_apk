import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class axoc
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new axod(this);
  axof jdField_a_of_type_Axof;
  axop jdField_a_of_type_Axop = new axop();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<axoe> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public axoc(Context paramContext, QQAppInterface paramQQAppInterface, axof paramaxof)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Axof = paramaxof;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(axol paramaxol, List<axml> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramaxol, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(axol paramaxol, List<axml> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    axml localaxml;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (axoe)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((axoe)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localaxml = (axml)paramList.get(i);
      if (paramaxol.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new axoe(this);
      ((axoe)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localaxml.jdField_a_of_type_JavaLangString))
      {
        ((axoe)localObject2).jdField_a_of_type_JavaLangObject = localaxml.jdField_a_of_type_JavaLangString;
        ((axoe)localObject2).jdField_a_of_type_JavaLangString = localaxml.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localaxml.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramaxol.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new axoe(this);
            ((axoe)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new axoe(this);
          ((axoe)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localaxml.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (axmm)localaxml.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new axoe(this);
            ((axoe)localObject3).jdField_a_of_type_Int = 0;
            ((axoe)localObject3).jdField_a_of_type_JavaLangObject = ((axmm)localObject2).jdField_a_of_type_JavaLangObject;
            ((axoe)localObject3).jdField_a_of_type_JavaLangString = localaxml.jdField_a_of_type_JavaLangString;
            ((axoe)localObject3).jdField_b_of_type_Int = localaxml.jdField_a_of_type_Int;
            ((axoe)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localaxml.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new axoe(this);
              ((axoe)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localaxml.jdField_b_of_type_JavaLangString)) && (paramaxol.jdField_a_of_type_Int == 0))
      {
        localObject2 = localaxml.jdField_b_of_type_JavaLangString;
        localObject3 = localaxml.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new axoe(this);
          ((axoe)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new axoe(this);
          ((axoe)localObject2).jdField_a_of_type_Int = 4;
          ((axoe)localObject2).jdField_c_of_type_JavaLangString = localaxml.jdField_b_of_type_JavaLangString;
          ((axoe)localObject2).jdField_a_of_type_JavaLangString = localaxml.jdField_a_of_type_JavaLangString;
          ((axoe)localObject2).jdField_b_of_type_JavaLangString = localaxml.jdField_c_of_type_JavaLangString;
          ((axoe)localObject2).jdField_b_of_type_Int = localaxml.jdField_a_of_type_Int;
          ((axoe)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((axoe)localObject1).jdField_b_of_type_JavaLangString = localaxml.jdField_c_of_type_JavaLangString;
            ((axoe)localObject1).jdField_c_of_type_JavaLangString = localaxml.jdField_b_of_type_JavaLangString;
            ((axoe)localObject1).jdField_b_of_type_Int = localaxml.jdField_a_of_type_Int;
            ((axoe)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramaxol = new axoe(this);
      paramaxol.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramaxol);
      if (paramBoolean2)
      {
        paramaxol = new axoe(this);
        paramaxol.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramaxol);
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
    return ((axoe)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      localObject = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    axoe localaxoe = (axoe)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localaxoe.jdField_a_of_type_Int == 0)
    {
      localObject = (axom)this.jdField_a_of_type_Axop.a(0);
      ((axom)localObject).a(paramViewGroup);
      localObject = ((axom)localObject).a(paramInt, paramView, paramViewGroup, this, localaxoe);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localaxoe);
      paramView = (View)localObject;
      break;
      localObject = paramView;
      if (localaxoe.jdField_a_of_type_Int == 1) {
        localObject = ((axoj)this.jdField_a_of_type_Axop.a(1)).a(paramInt, paramView, paramViewGroup, this, localaxoe);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axoc
 * JD-Core Version:    0.7.0.1
 */