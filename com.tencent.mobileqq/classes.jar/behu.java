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

public class behu
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  protected LayoutInflater a;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  List<behi> jdField_a_of_type_JavaUtilList;
  
  public behu(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public behi a(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (behi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      behi localbehi = (behi)localIterator.next();
      if (paramString.equals(localbehi.jdField_a_of_type_JavaLangString))
      {
        if (paramBoolean) {}
        for (int i = 2;; i = 4)
        {
          localbehi.jdField_a_of_type_Int = i;
          break;
        }
      }
    }
  }
  
  public void a(List<behi> paramList)
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
    behk localbehk;
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
        localbehk = behl.a().a(paramViewGroup.jdField_a_of_type_JavaLangString);
        if (localbehk == null) {
          break label106;
        }
      }
    }
    label100:
    label106:
    for (paramViewGroup = localbehk.b;; paramViewGroup = paramViewGroup.jdField_a_of_type_JavaLangString)
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
 * Qualified Name:     behu
 * JD-Core Version:    0.7.0.1
 */