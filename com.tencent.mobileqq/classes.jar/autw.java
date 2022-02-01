import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class autw
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, blja
{
  private final auto jdField_a_of_type_Auto;
  private final autp jdField_a_of_type_Autp;
  private blir jdField_a_of_type_Blir;
  private final FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private final FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private final boolean jdField_a_of_type_Boolean;
  private final FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private final FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  public autw(auto paramauto, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Auto = paramauto;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Autp = new autp();
    paramauto = BaseApplicationImpl.sApplication;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramauto.getString(2131697517));
    this.jdField_a_of_type_JavaUtilList.add(paramauto.getString(2131697516));
    this.jdField_a_of_type_JavaUtilList.add(paramauto.getString(2131697518));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131377450));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131697519;
      ((FormSimpleItem)localObject).setLeftText(paramauto.getString(i));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(a()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131377449));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131377462));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Autp.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      b(false);
      localObject = (TextView)paramView.findViewById(2131377464);
      if (!this.jdField_a_of_type_Boolean) {
        break label333;
      }
    }
    label333:
    for (int i = 2131697522;; i = 2131697521)
    {
      ((TextView)localObject).setText(paramauto.getString(i));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131377447));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Autp.b);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      paramView.findViewById(2131377448).setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      }
      return;
      i = 2131697515;
      break;
    }
  }
  
  private int a()
  {
    int i = 1;
    if (this.jdField_a_of_type_Autp.jdField_a_of_type_Int == 1) {
      i = 0;
    }
    while (this.jdField_a_of_type_Autp.jdField_a_of_type_Int == 2) {
      return i;
    }
    return 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_Blir = ((blir)blji.b(this.jdField_a_of_type_Auto.a(), null));
      Object localObject = this.jdField_a_of_type_Blir;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 2131697519;; i = 2131697515)
      {
        ((blir)localObject).a(i);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.jdField_a_of_type_Blir.a(str, false);
        }
      }
      this.jdField_a_of_type_Blir.c(2131690580);
      this.jdField_a_of_type_Blir.a(this);
    }
    this.jdField_a_of_type_Blir.d();
    this.jdField_a_of_type_Blir.d(a());
    if (!this.jdField_a_of_type_Blir.isShowing()) {
      this.jdField_a_of_type_Blir.show();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    autp localautp = this.jdField_a_of_type_Autp;
    Object localObject;
    if (this.jdField_a_of_type_Autp.jdField_a_of_type_Boolean)
    {
      localObject = autq.a(6);
      localautp.jdField_a_of_type_JavaLangString = ((String)localObject);
      localFormSimpleItem.setRightText((CharSequence)localObject);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_a_of_type_Autp.jdField_a_of_type_Boolean) {
        break label104;
      }
      i = 0;
      label57:
      ((FormSimpleItem)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_Autp.jdField_a_of_type_Boolean) {
        break label110;
      }
    }
    label104:
    label110:
    for (int i = 2;; i = 3)
    {
      ((FormSwitchItem)localObject).setBgType(i);
      if (paramBoolean) {
        this.jdField_a_of_type_Auto.a();
      }
      return;
      localObject = "";
      break;
      i = 8;
      break label57;
    }
  }
  
  public autp a()
  {
    return this.jdField_a_of_type_Autp;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Blir != null)
    {
      this.jdField_a_of_type_Blir.e();
      this.jdField_a_of_type_Blir = null;
    }
  }
  
  public void a(View paramView, int paramInt, String paramString)
  {
    int i = 1;
    if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
      this.jdField_a_of_type_Blir.dismiss();
    }
    if (paramInt == 0)
    {
      paramInt = 1;
      if (paramInt == this.jdField_a_of_type_Autp.jdField_a_of_type_Int) {
        break label90;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Autp.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramString);
      if (i != 0) {
        this.jdField_a_of_type_Auto.a();
      }
      return;
      if (paramInt == 1)
      {
        paramInt = 2;
        break;
      }
      paramInt = 3;
      break;
      label90:
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(paramBoolean);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    boolean bool = true;
    if (paramCompoundButton.equals(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      if (this.jdField_a_of_type_Autp.jdField_a_of_type_Boolean != paramBoolean)
      {
        this.jdField_a_of_type_Autp.jdField_a_of_type_Boolean = paramBoolean;
        b(bool);
      }
    }
    while (!paramCompoundButton.equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = false;
      }
    }
    if (this.jdField_a_of_type_Autp.b != paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Autp.b = paramBoolean;
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_Auto.a();
      break;
      i = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autw
 * JD-Core Version:    0.7.0.1
 */