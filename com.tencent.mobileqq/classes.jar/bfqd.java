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

public class bfqd
  extends bfpc
  implements View.OnClickListener
{
  private final List<bfqe> jdField_a_of_type_JavaUtilList;
  private yyz jdField_a_of_type_Yyz;
  private final yza jdField_a_of_type_Yza;
  
  public bfqd(Activity paramActivity, yza paramyza, yyz paramyyz, List<bfqe> paramList)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Yza = paramyza;
    this.jdField_a_of_type_Yyz = paramyyz;
    f();
  }
  
  private AuthorizationItem a(bfqe parambfqe, int paramInt, String paramString)
  {
    return new AuthorizationItem(getContext(), paramString, parambfqe, paramInt);
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131558977, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131368324);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      if (j < k)
      {
        int i;
        if ((bfqe)this.jdField_a_of_type_JavaUtilList.get(j) != AuthorizationItem.d)
        {
          if (k != 1) {
            break label145;
          }
          i = 3;
        }
        for (;;)
        {
          localLinearLayout2.addView(a((bfqe)this.jdField_a_of_type_JavaUtilList.get(j), i, this.jdField_a_of_type_Yza.a(((bfqe)this.jdField_a_of_type_JavaUtilList.get(j)).b)));
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
    localLinearLayout1.findViewById(2131363478).setOnClickListener(this);
    localLinearLayout1.findViewById(2131363503).setOnClickListener(this);
    localLinearLayout1.findViewById(2131368600).setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368600: 
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to show authorize description");
      }
      paramView = new bfqa(getContext());
      localObject = paramView.getWindow();
      if (localObject != null) {
        ((Window)localObject).setWindowAnimations(2131755010);
      }
      paramView.show();
      return;
    case 2131363478: 
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      if (this.jdField_a_of_type_Yyz != null)
      {
        this.jdField_a_of_type_Yza.a = 2;
        this.jdField_a_of_type_Yyz.a(this.jdField_a_of_type_Yza);
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
      localObject = (bfqe)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Yza.a(((bfqe)localObject).b)))
      {
        paramView.edit().putBoolean(((bfqe)localObject).b, true).apply();
        if (QLog.isColorLevel()) {
          QLog.d("ActionSheet", 2, "record " + ((bfqe)localObject).b + " authorize");
        }
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Yyz != null)
    {
      this.jdField_a_of_type_Yza.a = 0;
      this.jdField_a_of_type_Yyz.a(this.jdField_a_of_type_Yza);
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfqd
 * JD-Core Version:    0.7.0.1
 */