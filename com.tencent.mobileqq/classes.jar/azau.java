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

public class azau
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new azav(this);
  azax jdField_a_of_type_Azax;
  azbh jdField_a_of_type_Azbh = new azbh();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<azaw> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public azau(Context paramContext, QQAppInterface paramQQAppInterface, azax paramazax)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Azax = paramazax;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(azbd paramazbd, List<ayzd> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramazbd, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(azbd paramazbd, List<ayzd> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    ayzd localayzd;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (azaw)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((azaw)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localayzd = (ayzd)paramList.get(i);
      if (paramazbd.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new azaw(this);
      ((azaw)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localayzd.jdField_a_of_type_JavaLangString))
      {
        ((azaw)localObject2).jdField_a_of_type_JavaLangObject = localayzd.jdField_a_of_type_JavaLangString;
        ((azaw)localObject2).jdField_a_of_type_JavaLangString = localayzd.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localayzd.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramazbd.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new azaw(this);
            ((azaw)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new azaw(this);
          ((azaw)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localayzd.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (ayze)localayzd.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new azaw(this);
            ((azaw)localObject3).jdField_a_of_type_Int = 0;
            ((azaw)localObject3).jdField_a_of_type_JavaLangObject = ((ayze)localObject2).jdField_a_of_type_JavaLangObject;
            ((azaw)localObject3).jdField_a_of_type_JavaLangString = localayzd.jdField_a_of_type_JavaLangString;
            ((azaw)localObject3).jdField_b_of_type_Int = localayzd.jdField_a_of_type_Int;
            ((azaw)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localayzd.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new azaw(this);
              ((azaw)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localayzd.jdField_b_of_type_JavaLangString)) && (paramazbd.jdField_a_of_type_Int == 0))
      {
        localObject2 = localayzd.jdField_b_of_type_JavaLangString;
        localObject3 = localayzd.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new azaw(this);
          ((azaw)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new azaw(this);
          ((azaw)localObject2).jdField_a_of_type_Int = 4;
          ((azaw)localObject2).jdField_c_of_type_JavaLangString = localayzd.jdField_b_of_type_JavaLangString;
          ((azaw)localObject2).jdField_a_of_type_JavaLangString = localayzd.jdField_a_of_type_JavaLangString;
          ((azaw)localObject2).jdField_b_of_type_JavaLangString = localayzd.jdField_c_of_type_JavaLangString;
          ((azaw)localObject2).jdField_b_of_type_Int = localayzd.jdField_a_of_type_Int;
          ((azaw)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((azaw)localObject1).jdField_b_of_type_JavaLangString = localayzd.jdField_c_of_type_JavaLangString;
            ((azaw)localObject1).jdField_c_of_type_JavaLangString = localayzd.jdField_b_of_type_JavaLangString;
            ((azaw)localObject1).jdField_b_of_type_Int = localayzd.jdField_a_of_type_Int;
            ((azaw)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramazbd = new azaw(this);
      paramazbd.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramazbd);
      if (paramBoolean2)
      {
        paramazbd = new azaw(this);
        paramazbd.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramazbd);
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
    return ((azaw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
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
    azaw localazaw = (azaw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localazaw.jdField_a_of_type_Int == 0)
    {
      localObject = (azbe)this.jdField_a_of_type_Azbh.a(0);
      ((azbe)localObject).a(paramViewGroup);
      localObject = ((azbe)localObject).a(paramInt, paramView, paramViewGroup, this, localazaw);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localazaw);
      paramView = (View)localObject;
      break;
      localObject = paramView;
      if (localazaw.jdField_a_of_type_Int == 1) {
        localObject = ((azbb)this.jdField_a_of_type_Azbh.a(1)).a(paramInt, paramView, paramViewGroup, this, localazaw);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azau
 * JD-Core Version:    0.7.0.1
 */