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

public class bkmy
  extends BaseAdapter
{
  protected Context a;
  protected bkmz a;
  protected QQAppInterface a;
  protected ArrayList<bkna> a;
  
  public bkmy(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = tsr.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = bkna.a(paramArrayList, paramArrayList1);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        bkna localbkna = (bkna)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localbkna.jdField_a_of_type_Boolean) && (!localArrayList.contains(localbkna.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          localArrayList.add(localbkna.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(bkmz parambkmz)
  {
    this.jdField_a_of_type_Bkmz = parambkmz;
  }
  
  public void a(bkna parambkna)
  {
    if ((this.jdField_a_of_type_Bkmz == null) || (this.jdField_a_of_type_Bkmz.a(a(), parambkna))) {
      if (parambkna.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      parambkna.jdField_a_of_type_Boolean = bool;
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Bkmz != null) {
        this.jdField_a_of_type_Bkmz.a(a());
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
    bkna localbkna = (bkna)getItem(paramInt);
    TroopInfo localTroopInfo = localbkna.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    Object localObject;
    Drawable localDrawable;
    if (paramView != null)
    {
      localObject = (vap)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (ImageView)paramView.a(2131367185);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label154;
      }
      ((ImageView)localObject).setImageBitmap(bbef.f());
    }
    for (;;)
    {
      ((TextView)paramView.a(2131367230)).setText(localTroopInfo.troopname);
      ((CheckBox)paramView.a(2131364197)).setChecked(localbkna.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label164;
      }
      paramViewGroup.setBackgroundResource(2130839169);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560396, null);
      paramView = new vap(paramViewGroup);
      paramViewGroup.setTag(paramView);
      break;
      label154:
      ((ImageView)localObject).setImageDrawable(localDrawable);
    }
    label164:
    if (paramInt == 0)
    {
      paramViewGroup.setBackgroundResource(2130839185);
      return paramViewGroup;
    }
    if (paramInt == getCount() - 1)
    {
      paramViewGroup.setBackgroundResource(2130839176);
      return paramViewGroup;
    }
    paramViewGroup.setBackgroundResource(2130839179);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmy
 * JD-Core Version:    0.7.0.1
 */