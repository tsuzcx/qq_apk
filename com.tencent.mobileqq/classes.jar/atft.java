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

public class atft
  extends BaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atfu(this);
  atfw jdField_a_of_type_Atfw;
  atgg jdField_a_of_type_Atgg = new atgg();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  List<atfv> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public atft(Context paramContext, QQAppInterface paramQQAppInterface, atfw paramatfw)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atfw = paramatfw;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    super.notifyDataSetChanged();
  }
  
  public void a(atgc paramatgc, List<ateh> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramatgc, paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(atgc paramatgc, List<ateh> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    int i;
    label68:
    ateh localateh;
    Object localObject2;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (atfv)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        if (((atfv)localObject1).jdField_a_of_type_Int == 5) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
      }
      i = 0;
      localObject1 = null;
      if (i >= paramList.size()) {
        break label606;
      }
      localateh = (ateh)paramList.get(i);
      if (paramatgc.jdField_a_of_type_Int != 0) {
        break label666;
      }
      localObject2 = new atfv(this);
      ((atfv)localObject2).jdField_a_of_type_Int = 3;
      if (!TextUtils.isEmpty(localateh.jdField_a_of_type_JavaLangString))
      {
        ((atfv)localObject2).jdField_a_of_type_JavaLangObject = localateh.jdField_a_of_type_JavaLangString;
        ((atfv)localObject2).jdField_a_of_type_JavaLangString = localateh.jdField_a_of_type_JavaLangString;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Object localObject3;
      if (localateh.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        if ((paramatgc.jdField_a_of_type_Int == 0) && (paramBoolean3))
        {
          if (i != 0)
          {
            localObject3 = new atfv(this);
            ((atfv)localObject3).jdField_a_of_type_Int = 2;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new atfv(this);
          ((atfv)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        int j = 0;
        for (;;)
        {
          if (j < localateh.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = (atei)localateh.jdField_a_of_type_JavaUtilList.get(j);
            localObject3 = new atfv(this);
            ((atfv)localObject3).jdField_a_of_type_Int = 0;
            ((atfv)localObject3).jdField_a_of_type_JavaLangObject = ((atei)localObject2).jdField_a_of_type_JavaLangObject;
            ((atfv)localObject3).jdField_a_of_type_JavaLangString = localateh.jdField_a_of_type_JavaLangString;
            ((atfv)localObject3).jdField_b_of_type_Int = localateh.jdField_a_of_type_Int;
            ((atfv)localObject3).jdField_c_of_type_Int = j;
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
            if (j != localateh.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localObject2 = new atfv(this);
              ((atfv)localObject2).jdField_a_of_type_Int = 1;
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
            j += 1;
            continue;
            this.jdField_a_of_type_JavaUtilList.clear();
            break;
          }
        }
      }
      if ((!TextUtils.isEmpty(localateh.jdField_b_of_type_JavaLangString)) && (paramatgc.jdField_a_of_type_Int == 0))
      {
        localObject2 = localateh.jdField_b_of_type_JavaLangString;
        localObject3 = localateh.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new atfv(this);
          ((atfv)localObject2).jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          localObject2 = new atfv(this);
          ((atfv)localObject2).jdField_a_of_type_Int = 4;
          ((atfv)localObject2).jdField_c_of_type_JavaLangString = localateh.jdField_b_of_type_JavaLangString;
          ((atfv)localObject2).jdField_a_of_type_JavaLangString = localateh.jdField_a_of_type_JavaLangString;
          ((atfv)localObject2).jdField_b_of_type_JavaLangString = localateh.jdField_c_of_type_JavaLangString;
          ((atfv)localObject2).jdField_b_of_type_Int = localateh.jdField_a_of_type_Int;
          ((atfv)localObject2).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (localObject1 != null)
          {
            ((atfv)localObject1).jdField_b_of_type_JavaLangString = localateh.jdField_c_of_type_JavaLangString;
            ((atfv)localObject1).jdField_c_of_type_JavaLangString = localateh.jdField_b_of_type_JavaLangString;
            ((atfv)localObject1).jdField_b_of_type_Int = localateh.jdField_a_of_type_Int;
            ((atfv)localObject1).jdField_a_of_type_Boolean = true;
          }
        }
      }
      i += 1;
      break label68;
      label606:
      paramatgc = new atfv(this);
      paramatgc.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(paramatgc);
      if (paramBoolean2)
      {
        paramatgc = new atfv(this);
        paramatgc.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_JavaUtilList.add(paramatgc);
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
    return ((atfv)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    atfv localatfv = (atfv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localatfv.jdField_a_of_type_Int == 0)
    {
      localObject = (atgd)this.jdField_a_of_type_Atgg.a(0);
      ((atgd)localObject).a(paramViewGroup);
      localObject = ((atgd)localObject).a(paramInt, paramView, paramViewGroup, this, localatfv);
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      ((View)localObject).setTag(localatfv);
      return localObject;
      localObject = paramView;
      if (localatfv.jdField_a_of_type_Int == 1) {
        localObject = ((atga)this.jdField_a_of_type_Atgg.a(1)).a(paramInt, paramView, paramViewGroup, this, localatfv);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atft
 * JD-Core Version:    0.7.0.1
 */