package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;
import com.tencent.mobileqq.kandian.biz.search.entity.WordItem;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;

class ClassificationSearchActivity$11
  implements OnTipClickListener
{
  ClassificationSearchActivity$11(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      Object localObject2 = null;
      Iterator localIterator = this.a.b.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (WordItem)localIterator.next();
      } while (!paramString.equals(((WordItem)localObject1).word));
      if ((localObject1 != null) && (((WordItem)localObject1).type == 2))
      {
        paramString = new Intent(this.a, QQBrowserActivity.class);
        paramString.putExtra("hide_operation_bar", true);
        paramString.putExtra("url", ((WordItem)localObject1).jumpUrl);
        paramString.putExtra("articalChannelId", 14);
        this.a.startActivity(paramString);
      }
      else
      {
        if (this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int)
        {
          this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
          if (!TextUtils.isEmpty(paramString.trim()))
          {
            this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
            ClassificationSearchActivity.a(this.a, paramString);
          }
        }
        else if (this.a.f == ClassificationSearchActivity.d)
        {
          this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
          this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
          ClassificationSearchActivity.a(this.a, paramString);
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramString, false);
        }
        if ((this.a.f != ClassificationSearchActivity.d) && (!TextUtils.isEmpty(paramString.trim()))) {
          this.a.a(paramString);
        }
      }
      if (localObject1 != null)
      {
        if (this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int) {
          paramString = "kan";
        } else if (this.a.f == ClassificationSearchActivity.d) {
          paramString = "quan";
        } else {
          paramString = "";
        }
        if (((WordItem)localObject1).type == 2)
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006818", "0X8006818", 0, 0, ((WordItem)localObject1).word, ((WordItem)localObject1).jumpUrl, paramString, "");
          return;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006818", "0X8006818", 0, 0, ((WordItem)localObject1).word, "0", paramString, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.11
 * JD-Core Version:    0.7.0.1
 */