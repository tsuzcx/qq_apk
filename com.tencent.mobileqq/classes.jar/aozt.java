import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aozt
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, begx
{
  private final aozl jdField_a_of_type_Aozl;
  private final aozm jdField_a_of_type_Aozm;
  private begr jdField_a_of_type_Begr;
  private final FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private final FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private final boolean jdField_a_of_type_Boolean;
  private final FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private final FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  public aozt(aozl paramaozl, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aozl = paramaozl;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Aozm = new aozm();
    paramaozl = BaseApplicationImpl.sApplication;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramaozl.getString(2131632492));
    this.jdField_a_of_type_JavaUtilList.add(paramaozl.getString(2131632491));
    this.jdField_a_of_type_JavaUtilList.add(paramaozl.getString(2131632493));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131310198));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131632494;
      ((FormSimpleItem)localObject).setLeftText(paramaozl.getString(i));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(a()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131310197));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131310210));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Aozm.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      b(false);
      localObject = (TextView)paramView.findViewById(2131310212);
      if (!this.jdField_a_of_type_Boolean) {
        break label333;
      }
    }
    label333:
    for (int i = 2131632497;; i = 2131632496)
    {
      ((TextView)localObject).setText(paramaozl.getString(i));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131310195));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Aozm.b);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      paramView.findViewById(2131310196).setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      }
      return;
      i = 2131632490;
      break;
    }
  }
  
  private int a()
  {
    int i = 1;
    if (this.jdField_a_of_type_Aozm.jdField_a_of_type_Int == 1) {
      i = 0;
    }
    while (this.jdField_a_of_type_Aozm.jdField_a_of_type_Int == 2) {
      return i;
    }
    return 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = ((begr)behe.b(this.jdField_a_of_type_Aozl.a(), null));
      Object localObject = this.jdField_a_of_type_Begr;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 2131632494;; i = 2131632490)
      {
        ((begr)localObject).a(i);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.jdField_a_of_type_Begr.a(str, false);
        }
      }
      this.jdField_a_of_type_Begr.c(2131625035);
      this.jdField_a_of_type_Begr.a(this);
    }
    this.jdField_a_of_type_Begr.d();
    this.jdField_a_of_type_Begr.d(a());
    if (!this.jdField_a_of_type_Begr.isShowing()) {
      this.jdField_a_of_type_Begr.show();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    aozm localaozm = this.jdField_a_of_type_Aozm;
    Object localObject;
    if (this.jdField_a_of_type_Aozm.jdField_a_of_type_Boolean)
    {
      localObject = aozn.a(6);
      localaozm.jdField_a_of_type_JavaLangString = ((String)localObject);
      localFormSimpleItem.setRightText((CharSequence)localObject);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_a_of_type_Aozm.jdField_a_of_type_Boolean) {
        break label104;
      }
      i = 0;
      label57:
      ((FormSimpleItem)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_Aozm.jdField_a_of_type_Boolean) {
        break label110;
      }
    }
    label104:
    label110:
    for (int i = 2;; i = 3)
    {
      ((FormSwitchItem)localObject).setBgType(i);
      if (paramBoolean) {
        this.jdField_a_of_type_Aozl.a();
      }
      return;
      localObject = "";
      break;
      i = 8;
      break label57;
    }
  }
  
  public aozm a()
  {
    return this.jdField_a_of_type_Aozm;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Begr != null)
    {
      this.jdField_a_of_type_Begr.e();
      this.jdField_a_of_type_Begr = null;
    }
  }
  
  public void a(View paramView, int paramInt, String paramString)
  {
    int i = 1;
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
      this.jdField_a_of_type_Begr.dismiss();
    }
    if (paramInt == 0)
    {
      paramInt = 1;
      if (paramInt == this.jdField_a_of_type_Aozm.jdField_a_of_type_Int) {
        break label90;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aozm.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramString);
      if (i != 0) {
        this.jdField_a_of_type_Aozl.a();
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
      if (this.jdField_a_of_type_Aozm.jdField_a_of_type_Boolean != paramBoolean)
      {
        this.jdField_a_of_type_Aozm.jdField_a_of_type_Boolean = paramBoolean;
        b(bool);
      }
    }
    while (!paramCompoundButton.equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    if (this.jdField_a_of_type_Aozm.b != paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Aozm.b = paramBoolean;
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_Aozl.a();
      return;
      i = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozt
 * JD-Core Version:    0.7.0.1
 */