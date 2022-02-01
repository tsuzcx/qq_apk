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

public class ayib
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ayic(this);
  ayie jdField_a_of_type_Ayie;
  ayio jdField_a_of_type_Ayio = new ayio();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<ayid> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ayib(Context paramContext, QQAppInterface paramQQAppInterface, ayie paramayie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ayie = paramayie;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(ayik paramayik, List<aygk> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramayik, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(ayik paramayik, List<aygk> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    aygk localaygk;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (ayid)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((ayid)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localaygk = (aygk)paramList.get(i);
      if (paramayik.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new ayid(this);
      ((ayid)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localaygk.jdField_a_of_type_JavaLangString))
      {
        ((ayid)localObject2).jdField_a_of_type_JavaLangObject = localaygk.jdField_a_of_type_JavaLangString;
        ((ayid)localObject2).jdField_a_of_type_JavaLangString = localaygk.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localaygk.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramayik.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new ayid(this);
            ((ayid)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new ayid(this);
          ((ayid)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localaygk.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (aygl)localaygk.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new ayid(this);
            ((ayid)localObject3).jdField_a_of_type_Int = 0;
            ((ayid)localObject3).jdField_a_of_type_JavaLangObject = ((aygl)localObject2).jdField_a_of_type_JavaLangObject;
            ((ayid)localObject3).jdField_a_of_type_JavaLangString = localaygk.jdField_a_of_type_JavaLangString;
            ((ayid)localObject3).jdField_b_of_type_Int = localaygk.jdField_a_of_type_Int;
            ((ayid)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localaygk.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new ayid(this);
              ((ayid)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localaygk.jdField_b_of_type_JavaLangString)) && (paramayik.jdField_a_of_type_Int == 0))
      {
        localObject2 = localaygk.jdField_b_of_type_JavaLangString;
        localObject3 = localaygk.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new ayid(this);
          ((ayid)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new ayid(this);
          ((ayid)localObject2).jdField_a_of_type_Int = 4;
          ((ayid)localObject2).jdField_c_of_type_JavaLangString = localaygk.jdField_b_of_type_JavaLangString;
          ((ayid)localObject2).jdField_a_of_type_JavaLangString = localaygk.jdField_a_of_type_JavaLangString;
          ((ayid)localObject2).jdField_b_of_type_JavaLangString = localaygk.jdField_c_of_type_JavaLangString;
          ((ayid)localObject2).jdField_b_of_type_Int = localaygk.jdField_a_of_type_Int;
          ((ayid)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((ayid)localObject1).jdField_b_of_type_JavaLangString = localaygk.jdField_c_of_type_JavaLangString;
            ((ayid)localObject1).jdField_c_of_type_JavaLangString = localaygk.jdField_b_of_type_JavaLangString;
            ((ayid)localObject1).jdField_b_of_type_Int = localaygk.jdField_a_of_type_Int;
            ((ayid)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramayik = new ayid(this);
      paramayik.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramayik);
      if (paramBoolean2)
      {
        paramayik = new ayid(this);
        paramayik.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramayik);
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
    return ((ayid)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
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
    ayid localayid = (ayid)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localayid.jdField_a_of_type_Int == 0)
    {
      localObject = (ayil)this.jdField_a_of_type_Ayio.a(0);
      ((ayil)localObject).a(paramViewGroup);
      localObject = ((ayil)localObject).a(paramInt, paramView, paramViewGroup, this, localayid);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localayid);
      paramView = (View)localObject;
      break;
      localObject = paramView;
      if (localayid.jdField_a_of_type_Int == 1) {
        localObject = ((ayii)this.jdField_a_of_type_Ayio.a(1)).a(paramInt, paramView, paramViewGroup, this, localayid);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayib
 * JD-Core Version:    0.7.0.1
 */