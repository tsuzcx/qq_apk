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

public class bhvg
  extends bhuf
  implements View.OnClickListener
{
  private aatn jdField_a_of_type_Aatn;
  private final aato jdField_a_of_type_Aato;
  private final List<bhvh> jdField_a_of_type_JavaUtilList;
  
  public bhvg(Activity paramActivity, aato paramaato, aatn paramaatn, List<bhvh> paramList)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Aato = paramaato;
    this.jdField_a_of_type_Aatn = paramaatn;
    f();
  }
  
  private AuthorizationItem a(bhvh parambhvh, int paramInt, String paramString)
  {
    return new AuthorizationItem(getContext(), paramString, parambhvh, paramInt);
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559013, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131368482);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      if (j < k)
      {
        int i;
        if ((bhvh)this.jdField_a_of_type_JavaUtilList.get(j) != AuthorizationItem.d)
        {
          if (k != 1) {
            break label145;
          }
          i = 3;
        }
        for (;;)
        {
          localLinearLayout2.addView(a((bhvh)this.jdField_a_of_type_JavaUtilList.get(j), i, this.jdField_a_of_type_Aato.a(((bhvh)this.jdField_a_of_type_JavaUtilList.get(j)).b)));
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
    localLinearLayout1.findViewById(2131363521).setOnClickListener(this);
    localLinearLayout1.findViewById(2131363546).setOnClickListener(this);
    localLinearLayout1.findViewById(2131368813).setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368813: 
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to show authorize description");
      }
      paramView = new bhvd(getContext());
      localObject = paramView.getWindow();
      if (localObject != null) {
        ((Window)localObject).setWindowAnimations(2131755012);
      }
      paramView.show();
      return;
    case 2131363521: 
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      if (this.jdField_a_of_type_Aatn != null)
      {
        this.jdField_a_of_type_Aato.a = 2;
        this.jdField_a_of_type_Aatn.a(this.jdField_a_of_type_Aato);
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
      localObject = (bhvh)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aato.a(((bhvh)localObject).b)))
      {
        paramView.edit().putBoolean(((bhvh)localObject).b, true).apply();
        if (QLog.isColorLevel()) {
          QLog.d("ActionSheet", 2, "record " + ((bhvh)localObject).b + " authorize");
        }
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Aatn != null)
    {
      this.jdField_a_of_type_Aato.a = 0;
      this.jdField_a_of_type_Aatn.a(this.jdField_a_of_type_Aato);
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhvg
 * JD-Core Version:    0.7.0.1
 */