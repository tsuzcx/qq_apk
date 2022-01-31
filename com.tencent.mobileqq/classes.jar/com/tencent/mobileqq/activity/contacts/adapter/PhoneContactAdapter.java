package com.tencent.mobileqq.activity.contacts.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.contacts.BuddyItemBuilder;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.ViewTag;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneContactAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private PhoneContactFragment jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPhoneContactFragment;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public PhoneContactAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, PhoneContactFragment paramPhoneContactFragment)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPhoneContactFragment = paramPhoneContactFragment;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return true;
    }
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()) || (i == 8))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f()) {
          break label79;
        }
        if (QLog.isColorLevel()) {
          QLog.d("contacts.PhoneContactAdapter", 2, "load data: no permission");
        }
      }
    }
    label79:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaUtilList.clear();
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      } while (localObject2 == null);
      if (QLog.isColorLevel()) {
        QLog.d("contacts.PhoneContactAdapter", 2, "load data:" + ((List)localObject2).size());
      }
      localObject1 = new ArrayList(((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (!localPhoneContact.isHiden) {
          ((List)localObject1).add(BuddyItemBuilder.a(1, localPhoneContact, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        }
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList.size() != 0));
    Object localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (QLog.isColorLevel()) {
      QLog.d("contacts.PhoneContactAdapter", 2, "needDoubleCheck onAppRunForeground");
    }
    if (localObject1 != null) {
      ((PhoneContactManagerImp)localObject1).b(true);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (a()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPhoneContactFragment.a())) {
      return 1;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (a())
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968808, null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838583);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131363817).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131363818).setVisibility(8);
        paramView = (SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363819);
        paramView.setText("通讯录");
        paramViewGroup = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
        paramViewGroup.leftMargin /= 2;
        paramView.setLayoutParams(paramViewGroup);
        ((SimpleTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363820)).setText("0");
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
    paramView = ((BuddyListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, this);
    if (paramView != null)
    {
      paramViewGroup = (BuddyListItem.ViewTag)paramView.getTag();
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(a(paramViewGroup.jdField_a_of_type_Int, paramViewGroup.jdField_a_of_type_JavaLangString)));
      }
      paramView.setOnClickListener(this);
    }
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof BuddyListItem.ViewTag)))
    {
      paramView = (BuddyListItem.ViewTag)paramView.getTag();
      if ((paramView.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        paramView = (PhoneContact)paramView.jdField_a_of_type_JavaLangObject;
        if (QLog.isColorLevel()) {
          QLog.d("contacts.PhoneContactAdapter", 2, "onItemClick:" + paramView.name + paramView.mobileCode + "--[" + paramView.detalStatusFlag + "] [" + paramView.iTermType + "]");
        }
        ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView.mobileCode, 34);
        localAllInOne.jdField_h_of_type_Int = 59;
        localAllInOne.jdField_h_of_type_JavaLangString = paramView.name;
        localAllInOne.j = 2;
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053DF", "0X80053DF", 0, 0, "1", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.PhoneContactAdapter
 * JD-Core Version:    0.7.0.1
 */