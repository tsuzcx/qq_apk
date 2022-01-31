import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.tencent.qqmini.sdk.core.widget.FormSwitchItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class beil
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  protected LayoutInflater a;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  List<behz> jdField_a_of_type_JavaUtilList;
  
  public beil(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public behz a(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (behz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      behz localbehz = (behz)localIterator.next();
      if (paramString.equals(localbehz.jdField_a_of_type_JavaLangString))
      {
        if (paramBoolean) {}
        for (int i = 2;; i = 4)
        {
          localbehz.jdField_a_of_type_Int = i;
          break;
        }
      }
    }
  }
  
  public void a(List<behz> paramList)
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
    beib localbeib;
    if (paramView != null)
    {
      paramView = (FormSwitchItem)paramView;
      paramViewGroup = a(paramInt);
      if (paramViewGroup != null)
      {
        if (paramViewGroup.jdField_a_of_type_Int != 2) {
          break label100;
        }
        bool = true;
        paramView.setChecked(bool);
        paramView.a().setTag(paramViewGroup.jdField_a_of_type_JavaLangString);
        localbeib = beic.a().a(paramViewGroup.jdField_a_of_type_JavaLangString);
        if (localbeib == null) {
          break label106;
        }
      }
    }
    label100:
    label106:
    for (paramViewGroup = localbeib.b;; paramViewGroup = paramViewGroup.jdField_a_of_type_JavaLangString)
    {
      paramView.setText(paramViewGroup);
      return paramView;
      paramView = new FormSwitchItem(this.jdField_a_of_type_AndroidContentContext);
      paramView.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      break;
      bool = false;
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beil
 * JD-Core Version:    0.7.0.1
 */