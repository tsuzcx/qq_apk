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
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class auye
  extends BaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private List<Friends> jdField_a_of_type_JavaUtilList;
  
  public auye(Context paramContext, FaceDecoder paramFaceDecoder, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
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
    auyd localauyd;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561511, paramViewGroup, false);
      localauyd = new auyd();
      localauyd.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377602));
      localauyd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377603));
      localauyd.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131377604));
      localauyd.jdField_a_of_type_ComTencentWidgetSwitch.setTag(localauyd);
      paramView.setTag(localauyd);
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
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localauyd = (auyd)paramView.getTag();
    }
    localauyd.jdField_a_of_type_JavaLangString = ((Friends)localObject).uin;
    localauyd.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
    localauyd.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(((Friends)localObject).isShield());
    localauyd.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
    localauyd.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = this;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, ((Friends)localObject).uin, 0);
    if (localBitmap == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(((Friends)localObject).uin, 1, true);
      }
      localauyd.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable((BitmapDrawable)bheg.a());
    }
    for (;;)
    {
      localObject = ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject).uin, 0);
      localauyd.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break;
      localauyd.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i;
    if (paramBoolean)
    {
      i = 1;
      bdla.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DD1", "0X8009DD1", 0, i, "0", "0", "", "");
      i = HttpUtil.getNetWorkType();
      if (i != -1) {
        break label165;
      }
      i = 2;
    }
    label165:
    for (;;)
    {
      localObject = (auyd)paramCompoundButton.getTag();
      boolean bool;
      if (i == 0)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131695849, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
        paramCompoundButton.setOnCheckedChangeListener(null);
        if (!paramBoolean)
        {
          bool = true;
          label99:
          paramCompoundButton.setChecked(bool);
          paramCompoundButton.setOnCheckedChangeListener(((auyd)localObject).jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        i = 2;
        break;
        bool = false;
        break label99;
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).changeFriendShieldFlag(Long.valueOf(((auyd)localObject).jdField_a_of_type_JavaLangString).longValue(), paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auye
 * JD-Core Version:    0.7.0.1
 */