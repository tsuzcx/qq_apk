import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.List;

public class awzz
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<PhoneContact> jdField_a_of_type_JavaUtilList;
  
  public awzz(Context paramContext, List<PhoneContact> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560874, null);
    axab localaxab = new axab(null);
    localaxab.a = ((TextView)paramViewGroup.findViewById(2131373493));
    localaxab.b = ((TextView)paramViewGroup.findViewById(2131373492));
    paramViewGroup.setTag(localaxab);
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (axab)paramView.getTag();
    PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramInt = localPhoneContact.type;
    paramView = null;
    if (paramInt == 0) {
      paramView = localPhoneContact.label;
    }
    paramView = (String)ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt, paramView);
    paramViewGroup.a.setText(paramView);
    paramViewGroup.b.setText(localPhoneContact.mobileNo);
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 20) {
      return 20;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    a(paramInt, localView, paramViewGroup);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awzz
 * JD-Core Version:    0.7.0.1
 */