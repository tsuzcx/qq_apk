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

public class ayul
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ayum(this);
  ayuo jdField_a_of_type_Ayuo;
  ayuy jdField_a_of_type_Ayuy = new ayuy();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<ayun> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ayul(Context paramContext, QQAppInterface paramQQAppInterface, ayuo paramayuo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ayuo = paramayuo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(ayuu paramayuu, List<aysu> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramayuu, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(ayuu paramayuu, List<aysu> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    aysu localaysu;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (ayun)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((ayun)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localaysu = (aysu)paramList.get(i);
      if (paramayuu.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new ayun(this);
      ((ayun)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localaysu.jdField_a_of_type_JavaLangString))
      {
        ((ayun)localObject2).jdField_a_of_type_JavaLangObject = localaysu.jdField_a_of_type_JavaLangString;
        ((ayun)localObject2).jdField_a_of_type_JavaLangString = localaysu.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localaysu.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramayuu.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new ayun(this);
            ((ayun)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new ayun(this);
          ((ayun)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localaysu.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (aysv)localaysu.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new ayun(this);
            ((ayun)localObject3).jdField_a_of_type_Int = 0;
            ((ayun)localObject3).jdField_a_of_type_JavaLangObject = ((aysv)localObject2).jdField_a_of_type_JavaLangObject;
            ((ayun)localObject3).jdField_a_of_type_JavaLangString = localaysu.jdField_a_of_type_JavaLangString;
            ((ayun)localObject3).jdField_b_of_type_Int = localaysu.jdField_a_of_type_Int;
            ((ayun)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localaysu.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new ayun(this);
              ((ayun)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localaysu.jdField_b_of_type_JavaLangString)) && (paramayuu.jdField_a_of_type_Int == 0))
      {
        localObject2 = localaysu.jdField_b_of_type_JavaLangString;
        localObject3 = localaysu.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new ayun(this);
          ((ayun)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new ayun(this);
          ((ayun)localObject2).jdField_a_of_type_Int = 4;
          ((ayun)localObject2).jdField_c_of_type_JavaLangString = localaysu.jdField_b_of_type_JavaLangString;
          ((ayun)localObject2).jdField_a_of_type_JavaLangString = localaysu.jdField_a_of_type_JavaLangString;
          ((ayun)localObject2).jdField_b_of_type_JavaLangString = localaysu.jdField_c_of_type_JavaLangString;
          ((ayun)localObject2).jdField_b_of_type_Int = localaysu.jdField_a_of_type_Int;
          ((ayun)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((ayun)localObject1).jdField_b_of_type_JavaLangString = localaysu.jdField_c_of_type_JavaLangString;
            ((ayun)localObject1).jdField_c_of_type_JavaLangString = localaysu.jdField_b_of_type_JavaLangString;
            ((ayun)localObject1).jdField_b_of_type_Int = localaysu.jdField_a_of_type_Int;
            ((ayun)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramayuu = new ayun(this);
      paramayuu.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramayuu);
      if (paramBoolean2)
      {
        paramayuu = new ayun(this);
        paramayuu.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramayuu);
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
    return ((ayun)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
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
    ayun localayun = (ayun)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localayun.jdField_a_of_type_Int == 0)
    {
      localObject = (ayuv)this.jdField_a_of_type_Ayuy.a(0);
      ((ayuv)localObject).a(paramViewGroup);
      localObject = ((ayuv)localObject).a(paramInt, paramView, paramViewGroup, this, localayun);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localayun);
      paramView = (View)localObject;
      break;
      localObject = paramView;
      if (localayun.jdField_a_of_type_Int == 1) {
        localObject = ((ayus)this.jdField_a_of_type_Ayuy.a(1)).a(paramInt, paramView, paramViewGroup, this, localayun);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayul
 * JD-Core Version:    0.7.0.1
 */