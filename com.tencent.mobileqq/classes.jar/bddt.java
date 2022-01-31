import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bddt
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  protected LayoutInflater a;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  List<bddh> jdField_a_of_type_JavaUtilList;
  
  public bddt(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public bddh a(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bddh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bddh localbddh = (bddh)localIterator.next();
      if (paramString.equals(localbddh.jdField_a_of_type_JavaLangString))
      {
        if (paramBoolean) {}
        for (int i = 2;; i = 4)
        {
          localbddh.jdField_a_of_type_Int = i;
          break;
        }
      }
    }
  }
  
  public void a(List<bddh> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool;
    label30:
    bddj localbddj;
    if (paramView != null)
    {
      paramView = (Switch)paramView;
      paramViewGroup = a(paramInt);
      if (paramViewGroup != null)
      {
        if (paramViewGroup.jdField_a_of_type_Int != 2) {
          break label97;
        }
        bool = true;
        paramView.setChecked(bool);
        paramView.setTag(paramViewGroup.jdField_a_of_type_JavaLangString);
        localbddj = bddk.a().a(paramViewGroup.jdField_a_of_type_JavaLangString);
        if (localbddj == null) {
          break label103;
        }
      }
    }
    label97:
    label103:
    for (paramViewGroup = localbddj.b;; paramViewGroup = paramViewGroup.jdField_a_of_type_JavaLangString)
    {
      paramView.setText(paramViewGroup);
      return paramView;
      paramView = new Switch(this.jdField_a_of_type_AndroidContentContext);
      paramView.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      break;
      bool = false;
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bddt
 * JD-Core Version:    0.7.0.1
 */