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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bpua
  extends BaseAdapter
{
  protected Context a;
  protected bpub a;
  protected QQAppInterface a;
  protected ArrayList<bpuc> a;
  
  public bpua(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = xfe.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = bpuc.a(paramArrayList, paramArrayList1);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        bpuc localbpuc = (bpuc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localbpuc.jdField_a_of_type_Boolean) && (!localArrayList.contains(localbpuc.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          localArrayList.add(localbpuc.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(bpub parambpub)
  {
    this.jdField_a_of_type_Bpub = parambpub;
  }
  
  public void a(bpuc parambpuc)
  {
    if ((this.jdField_a_of_type_Bpub == null) || (this.jdField_a_of_type_Bpub.a(a(), parambpuc))) {
      if (parambpuc.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      parambpuc.jdField_a_of_type_Boolean = bool;
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Bpub != null) {
        this.jdField_a_of_type_Bpub.a(a());
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
    bpuc localbpuc = (bpuc)getItem(paramInt);
    TroopInfo localTroopInfo = localbpuc.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    ynb localynb;
    ImageView localImageView;
    Drawable localDrawable;
    if (paramView != null)
    {
      localynb = (ynb)paramView.getTag();
      localImageView = (ImageView)localynb.a(2131367631);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label168;
      }
      localImageView.setImageBitmap(bgmo.f());
      label69:
      ((TextView)localynb.a(2131367677)).setText(localTroopInfo.troopname);
      ((CheckBox)localynb.a(2131364471)).setChecked(localbpuc.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label178;
      }
      paramView.setBackgroundResource(2130839432);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560656, null);
      localynb = new ynb(paramView);
      paramView.setTag(localynb);
      break;
      label168:
      localImageView.setImageDrawable(localDrawable);
      break label69;
      label178:
      if (paramInt == 0) {
        paramView.setBackgroundResource(2130839448);
      } else if (paramInt == getCount() - 1) {
        paramView.setBackgroundResource(2130839439);
      } else {
        paramView.setBackgroundResource(2130839442);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpua
 * JD-Core Version:    0.7.0.1
 */