import android.text.Editable;
import android.text.TextUtils;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import java.util.List;

public class ayfu
  implements ayca
{
  public ayfu(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int m = 1;
    int i = this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length() <= 0) {
      break label37;
    }
    label37:
    while ((paramInt1 <= 0) && (paramInt2 <= 0)) {
      return;
    }
    int j = this.a.jdField_a_of_type_Aycg.b.length();
    int k = this.a.jdField_a_of_type_Aycg.a.length();
    int n = this.a.jdField_a_of_type_Aycg.c.length() + (j + k);
    if ((paramInt1 < this.a.J.length() + n) && (paramInt2 < this.a.J.length() + n))
    {
      if (TroopBarPublishActivity.a(this.a).size() > 1)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.clearFocus();
        beex.b(this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
      return;
    }
    if (paramInt1 < 0) {
      if (paramInt2 > this.a.J.length() + n)
      {
        paramInt1 = paramInt2;
        label203:
        if (paramInt1 <= i) {
          break label439;
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
      return;
      paramInt1 = this.a.J.length() + n;
      break label203;
      if (paramInt2 < 0) {
        if (paramInt1 > this.a.J.length() + n) {
          label258:
          if (paramInt1 <= i) {
            break label434;
          }
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
        return;
        paramInt1 = this.a.J.length() + n;
        break label258;
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_Aycg.b)) {
          break;
        }
        k = 0;
        j = paramInt1;
        if (paramInt1 < this.a.J.length() + n)
        {
          j = n + this.a.J.length();
          k = 1;
        }
        if (paramInt2 < this.a.J.length() + n)
        {
          paramInt1 = n + this.a.J.length();
          k = 1;
        }
        for (;;)
        {
          paramInt2 = j;
          if (j > i)
          {
            k = 1;
            paramInt2 = i;
          }
          if (paramInt1 > i) {
            k = m;
          }
          while (k != 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(paramInt2, i);
            return;
            i = paramInt1;
          }
          break;
          paramInt1 = paramInt2;
        }
        label434:
        i = paramInt1;
      }
      label439:
      i = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayfu
 * JD-Core Version:    0.7.0.1
 */