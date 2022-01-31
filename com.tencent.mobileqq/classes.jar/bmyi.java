import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bmyi
  extends BaseAdapter
{
  protected Context a;
  protected bmyj a;
  protected QQAppInterface a;
  protected ArrayList<bmyk> a;
  
  public bmyi(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = vhj.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = bmyk.a(paramArrayList, paramArrayList1);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        bmyk localbmyk = (bmyk)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localbmyk.jdField_a_of_type_Boolean) && (!localArrayList.contains(localbmyk.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          localArrayList.add(localbmyk.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(bmyj parambmyj)
  {
    this.jdField_a_of_type_Bmyj = parambmyj;
  }
  
  public void a(bmyk parambmyk)
  {
    if ((this.jdField_a_of_type_Bmyj == null) || (this.jdField_a_of_type_Bmyj.a(a(), parambmyk))) {
      if (parambmyk.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      parambmyk.jdField_a_of_type_Boolean = bool;
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Bmyj != null) {
        this.jdField_a_of_type_Bmyj.a(a());
      }
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bmyk localbmyk = (bmyk)getItem(paramInt);
    TroopInfo localTroopInfo = localbmyk.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    Object localObject;
    Drawable localDrawable;
    if (paramView != null)
    {
      localObject = (wph)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (ImageView)paramView.a(2131367315);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label154;
      }
      ((ImageView)localObject).setImageBitmap(bdda.f());
    }
    for (;;)
    {
      ((TextView)paramView.a(2131367360)).setText(localTroopInfo.troopname);
      ((CheckBox)paramView.a(2131364259)).setChecked(localbmyk.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label164;
      }
      paramViewGroup.setBackgroundResource(2130839253);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560504, null);
      paramView = new wph(paramViewGroup);
      paramViewGroup.setTag(paramView);
      break;
      label154:
      ((ImageView)localObject).setImageDrawable(localDrawable);
    }
    label164:
    if (paramInt == 0)
    {
      paramViewGroup.setBackgroundResource(2130839269);
      return paramViewGroup;
    }
    if (paramInt == getCount() - 1)
    {
      paramViewGroup.setBackgroundResource(2130839260);
      return paramViewGroup;
    }
    paramViewGroup.setBackgroundResource(2130839263);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyi
 * JD-Core Version:    0.7.0.1
 */