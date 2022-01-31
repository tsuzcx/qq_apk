import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public abstract class anzd
  extends bemg
{
  private Context jdField_a_of_type_AndroidContentContext;
  protected anzh a;
  private ExpandableListView jdField_a_of_type_ComTencentWidgetExpandableListView;
  Object jdField_a_of_type_JavaLangObject;
  LinkedHashMap<String, List<Object>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public anzd(Context paramContext, Object paramObject)
  {
    if (paramObject != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 2131493281;
  }
  
  String a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    String str = null;
    return str;
  }
  
  protected List<Object> a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != paramInt) {
        i += 1;
      } else {
        return (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str);
      }
    }
    return null;
  }
  
  public void a(View paramView, int paramInt)
  {
    anzi localanzi = (anzi)paramView.getTag();
    if (localanzi == null)
    {
      localanzi = new anzi();
      localanzi.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131301599));
      paramView.findViewById(2131299071).setVisibility(8);
      paramView.findViewById(2131303013).setVisibility(8);
      localanzi.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131302936));
      paramView.setTag(localanzi);
    }
    for (;;)
    {
      paramView.setOnClickListener(new anzg(this, paramInt));
      localanzi.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      paramView = (String)getGroup(paramInt);
      localanzi.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
      localanzi.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      return;
    }
  }
  
  public void a(anzh paramanzh)
  {
    this.jdField_a_of_type_Anzh = paramanzh;
  }
  
  public void a(ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    List localList = a(paramInt1);
    if ((localList != null) && (localList.size() > 0) && (paramInt2 < localList.size())) {
      return localList.get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = a(paramInt);
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return a(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (anzi)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(new anze(this, paramInt));
      if (AppSetting.c) {
        paramViewGroup.setAccessibilityDelegate(new vsk(paramViewGroup, new anzf(this, paramInt)));
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
      localObject = (String)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493281, paramViewGroup, false);
      paramView = new anzi();
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131301599));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131302936));
      paramViewGroup.findViewById(2131299071).setVisibility(8);
      paramViewGroup.findViewById(2131303013).setVisibility(8);
      paramViewGroup.setTag(paramView);
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onGroupCollapsed(int paramInt)
  {
    super.onGroupCollapsed(paramInt);
    if (AppSetting.c)
    {
      String str = (String)getGroup(paramInt);
      QQAppInterface.f(str + ajjy.a(2131643820));
    }
  }
  
  public void onGroupExpanded(int paramInt)
  {
    super.onGroupExpanded(paramInt);
    if (AppSetting.c)
    {
      String str = (String)getGroup(paramInt);
      QQAppInterface.f(str + ajjy.a(2131643840));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzd
 * JD-Core Version:    0.7.0.1
 */