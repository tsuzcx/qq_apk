package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.widget.XListView;

class AddContactViewPagerTroopFragment$3
  implements AddContactFindTroopRTLW.onRefreshCallback
{
  AddContactViewPagerTroopFragment$3(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.a.jdField_b_of_type_Boolean) && (AddContactViewPagerTroopFragment.a(this.a) != null)) {
      AddContactViewPagerTroopFragment.b(this.a).a(this.a.b(), paramBoolean, null);
    }
    if (paramBoolean)
    {
      if (paramInt <= 0) {
        break label73;
      }
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    label73:
    Object localObject;
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", null);
      if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus())) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131689628);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131689632);
      this.a.c.setText(2131689629);
      this.a.c.setOnTouchListener(this.a.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.a.c.setOnClickListener(new AddContactViewPagerTroopFragment.3.1(this));
      localObject = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
    } while ((localObject == null) || (!(localObject instanceof ViewGroup)));
    ((ViewGroup)localObject).setBackgroundResource(2130839537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment.3
 * JD-Core Version:    0.7.0.1
 */