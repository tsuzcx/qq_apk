import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationItem;
import java.util.List;

public class bhqz
  extends bhpy
  implements View.OnClickListener
{
  private aaoy jdField_a_of_type_Aaoy;
  private final aaoz jdField_a_of_type_Aaoz;
  private final List<bhra> jdField_a_of_type_JavaUtilList;
  
  public bhqz(Activity paramActivity, aaoz paramaaoz, aaoy paramaaoy, List<bhra> paramList)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Aaoz = paramaaoz;
    this.jdField_a_of_type_Aaoy = paramaaoy;
    f();
  }
  
  private AuthorizationItem a(bhra parambhra, int paramInt, String paramString)
  {
    return new AuthorizationItem(getContext(), paramString, parambhra, paramInt);
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559014, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131368471);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      if (j < k)
      {
        int i;
        if ((bhra)this.jdField_a_of_type_JavaUtilList.get(j) != AuthorizationItem.d)
        {
          if (k != 1) {
            break label145;
          }
          i = 3;
        }
        for (;;)
        {
          localLinearLayout2.addView(a((bhra)this.jdField_a_of_type_JavaUtilList.get(j), i, this.jdField_a_of_type_Aaoz.a(((bhra)this.jdField_a_of_type_JavaUtilList.get(j)).b)));
          j += 1;
          break;
          label145:
          if (k == 2)
          {
            if (j == 0) {
              i = 0;
            } else {
              i = 2;
            }
          }
          else if (j == 0) {
            i = 0;
          } else if (j < k - 1) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
    }
    a(localLinearLayout1);
    localLinearLayout1.findViewById(2131363519).setOnClickListener(this);
    localLinearLayout1.findViewById(2131363544).setOnClickListener(this);
    localLinearLayout1.findViewById(2131368798).setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368798: 
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to show authorize description");
      }
      paramView = new bhqw(getContext());
      localObject = paramView.getWindow();
      if (localObject != null) {
        ((Window)localObject).setWindowAnimations(2131755012);
      }
      paramView.show();
      return;
    case 2131363519: 
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      if (this.jdField_a_of_type_Aaoy != null)
      {
        this.jdField_a_of_type_Aaoz.a = 2;
        this.jdField_a_of_type_Aaoy.a(this.jdField_a_of_type_Aaoz);
      }
      dismiss();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActionSheet", 2, "onClick to confirm authorize user info");
    }
    paramView = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (bhra)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aaoz.a(((bhra)localObject).b)))
      {
        paramView.edit().putBoolean(((bhra)localObject).b, true).apply();
        if (QLog.isColorLevel()) {
          QLog.d("ActionSheet", 2, "record " + ((bhra)localObject).b + " authorize");
        }
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Aaoy != null)
    {
      this.jdField_a_of_type_Aaoz.a = 0;
      this.jdField_a_of_type_Aaoy.a(this.jdField_a_of_type_Aaoz);
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhqz
 * JD-Core Version:    0.7.0.1
 */