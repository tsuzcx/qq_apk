import android.content.res.Resources;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ammb
  implements amnf
{
  public ammb(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a()
  {
    if ((this.a.i == 0) && (this.a.f > this.a.g) && (this.a.g != 0)) {
      bcpw.a(this.a, this.a.getResources().getString(2131691014), 0).b(this.a.getTitleBarHeight());
    }
    while ((this.a.jdField_a_of_type_Bfol == null) || (!this.a.jdField_a_of_type_Bfol.isShowing())) {
      return;
    }
    this.a.jdField_a_of_type_Bfol.dismiss();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onItemSelected|pickerType : " + this.a.i + ", column : " + paramInt1 + ", row : " + paramInt2);
    }
    int i;
    Object localObject;
    if (this.a.i == 0)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ajty.b.length) {}
      }
      else
      {
        i = 0;
      }
      switch (paramInt1)
      {
      default: 
        if ((this.a.f <= this.a.g) || (this.a.g == 0))
        {
          this.a.jdField_b_of_type_Int = this.a.f;
          this.a.jdField_c_of_type_Int = this.a.g;
        }
        localObject = this.a.jdField_a_of_type_Ajty.a(this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      }
    }
    do
    {
      return;
      this.a.f = i;
      break;
      this.a.g = i;
      break;
      if (this.a.i == 3)
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 < ajty.c.length) {}
        }
        else
        {
          paramInt1 = 0;
        }
        this.a.d = paramInt1;
        this.a.e.setRightText(ajty.c[paramInt1]);
        return;
      }
      switch (paramInt1)
      {
      }
      while (this.a.i == 1)
      {
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.a.jdField_a_of_type_Ajty.c(ConditionSearchFriendActivity.a(this.a)));
        return;
        if ((this.a.jdField_a_of_type_ArrayOfJavaLangObject.length > 0) && (this.a.jdField_a_of_type_ArrayOfJavaLangObject[0] != null) && (((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[0]).size() > 0))
        {
          if (paramInt2 >= 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 < ((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[0]).size()) {}
          }
          else
          {
            paramInt1 = 0;
          }
          this.a.jdField_a_of_type_ArrayOfInt[0] = paramInt1;
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0] = ((BaseAddress)((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[0]).get(paramInt1));
          this.a.jdField_a_of_type_ArrayOfJavaLangString[0] = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0].code;
          localObject = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0].getDataList();
          if (this.a.h > 1)
          {
            this.a.jdField_a_of_type_ArrayOfJavaLangObject[1] = localObject;
            this.a.jdField_a_of_type_ArrayOfInt[1] = 0;
            this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.a.jdField_a_of_type_ArrayOfJavaLangString[1] = "0";
            try
            {
              this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
              this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, 0);
              if (this.a.h <= 2) {
                continue;
              }
              this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = null;
              this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
              this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(2);
              this.a.jdField_a_of_type_ArrayOfJavaLangString[2] = "0";
              try
              {
                this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
                this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
              }
              catch (Exception localException1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ConditionSearchFriendActivity", 2, localException1, new Object[0]);
                }
              }
              if ((this.a.jdField_a_of_type_Bfol == null) || (!this.a.jdField_a_of_type_Bfol.isShowing())) {
                continue;
              }
              this.a.jdField_a_of_type_Bfol.dismiss();
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ConditionSearchFriendActivity", 2, localException2, new Object[0]);
                }
                if ((this.a.jdField_a_of_type_Bfol != null) && (this.a.jdField_a_of_type_Bfol.isShowing())) {
                  this.a.jdField_a_of_type_Bfol.dismiss();
                }
              }
            }
            if ((this.a.jdField_a_of_type_ArrayOfJavaLangObject.length > 1) && (this.a.jdField_a_of_type_ArrayOfJavaLangObject[1] != null) && (((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[1]).size() > 0))
            {
              if (paramInt2 >= 0)
              {
                paramInt1 = paramInt2;
                if (paramInt2 < ((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[1]).size()) {}
              }
              else
              {
                paramInt1 = 0;
              }
              this.a.jdField_a_of_type_ArrayOfInt[1] = paramInt1;
              this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = ((BaseAddress)((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[1]).get(paramInt1));
              this.a.jdField_a_of_type_ArrayOfJavaLangString[1] = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1].code;
              ArrayList localArrayList = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1].getDataList();
              if (this.a.h > 2)
              {
                this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = localArrayList;
                this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
                this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(2);
                this.a.jdField_a_of_type_ArrayOfJavaLangString[2] = "0";
                try
                {
                  this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
                  this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
                }
                catch (Exception localException3)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ConditionSearchFriendActivity", 2, localException3, new Object[0]);
                  }
                }
                if ((this.a.jdField_a_of_type_Bfol != null) && (this.a.jdField_a_of_type_Bfol.isShowing()))
                {
                  this.a.jdField_a_of_type_Bfol.dismiss();
                  continue;
                  if ((this.a.h > 2) && (this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] != null) && (((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[2]).size() > 0))
                  {
                    if (paramInt2 >= 0)
                    {
                      paramInt1 = paramInt2;
                      if (paramInt2 < ((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[2]).size()) {}
                    }
                    else
                    {
                      paramInt1 = 0;
                    }
                    this.a.jdField_a_of_type_ArrayOfInt[2] = paramInt1;
                    this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = ((BaseAddress)((List)this.a.jdField_a_of_type_ArrayOfJavaLangObject[2]).get(paramInt1));
                    this.a.jdField_a_of_type_ArrayOfJavaLangString[2] = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2].code;
                  }
                }
              }
            }
          }
        }
      }
    } while (this.a.i != 2);
    this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.a.jdField_a_of_type_Ajty.c(ConditionSearchFriendActivity.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ammb
 * JD-Core Version:    0.7.0.1
 */