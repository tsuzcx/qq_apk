import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqjm
  extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private baxk jdField_a_of_type_Baxk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<Friends> jdField_a_of_type_JavaUtilList;
  
  public aqjm(Context paramContext, baxk parambaxk, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_Baxk = parambaxk;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(Friends paramFriends)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramFriends == null)) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramFriends);
    notifyDataSetChanged();
  }
  
  public void a(List<Friends> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((Friends)localIterator.next()).uin.equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (Friends)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561096, paramViewGroup, false);
      paramViewGroup = new aqjl();
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131376062));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376063));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131376064));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setTag(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localObject = (Friends)getItem(paramInt);
      if (localObject != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShieldFriendsListActivity", 2, "friend == null,这种情况不应该出现的");
      }
      return paramView;
      paramViewGroup = (aqjl)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_JavaLangString = ((Friends)localObject).uin;
    paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
    paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(((Friends)localObject).isShield());
    paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
    paramViewGroup.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = this;
    Bitmap localBitmap = this.jdField_a_of_type_Baxk.a(1, ((Friends)localObject).uin, 0);
    if (localBitmap == null)
    {
      if (!this.jdField_a_of_type_Baxk.a()) {
        this.jdField_a_of_type_Baxk.a(((Friends)localObject).uin, 1, true);
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable((BitmapDrawable)bbdr.a());
    }
    for (;;)
    {
      localObject = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject).uin, 0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return paramView;
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i;
    if (paramBoolean)
    {
      i = 1;
      axqw.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DD1", "0X8009DD1", 0, i, "0", "0", "", "");
      i = nam.a();
      if (i != -1) {
        break label150;
      }
      i = 2;
    }
    label150:
    for (;;)
    {
      localObject = (aqjl)paramCompoundButton.getTag();
      if (i == 0)
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131696413, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
        paramCompoundButton.setOnCheckedChangeListener(null);
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          paramCompoundButton.setOnCheckedChangeListener(((aqjl)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
          return;
          i = 2;
          break;
        }
      }
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(Long.valueOf(((aqjl)localObject).jdField_a_of_type_JavaLangString).longValue(), paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjm
 * JD-Core Version:    0.7.0.1
 */