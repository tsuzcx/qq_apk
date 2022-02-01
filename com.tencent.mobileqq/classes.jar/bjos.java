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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AuthorizationItem;
import java.util.List;

public class bjos
  extends bjnw
  implements View.OnClickListener
{
  private absu jdField_a_of_type_Absu;
  private final absv jdField_a_of_type_Absv;
  private final List<bjot> jdField_a_of_type_JavaUtilList;
  
  public bjos(Activity paramActivity, absv paramabsv, absu paramabsu, List<bjot> paramList)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Absv = paramabsv;
    this.jdField_a_of_type_Absu = paramabsu;
    f();
  }
  
  private AuthorizationItem a(bjot parambjot, int paramInt, String paramString)
  {
    return new AuthorizationItem(getContext(), paramString, parambjot, paramInt);
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559088, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131368890);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      if (j < k)
      {
        int i;
        if ((bjot)this.jdField_a_of_type_JavaUtilList.get(j) != AuthorizationItem.d)
        {
          if (k != 1) {
            break label145;
          }
          i = 3;
        }
        for (;;)
        {
          localLinearLayout2.addView(a((bjot)this.jdField_a_of_type_JavaUtilList.get(j), i, this.jdField_a_of_type_Absv.a(((bjot)this.jdField_a_of_type_JavaUtilList.get(j)).b)));
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
    localLinearLayout1.findViewById(2131363773).setOnClickListener(this);
    localLinearLayout1.findViewById(2131363797).setOnClickListener(this);
    localLinearLayout1.findViewById(2131369268).setOnClickListener(this);
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
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to show authorize description");
      }
      Object localObject1 = new bjop(getContext());
      Object localObject2 = ((bjop)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setWindowAnimations(2131755013);
      }
      ((bjop)localObject1).show();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      if (this.jdField_a_of_type_Absu != null)
      {
        this.jdField_a_of_type_Absv.a = 2;
        this.jdField_a_of_type_Absu.a(this.jdField_a_of_type_Absv);
      }
      dismiss();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to confirm authorize user info");
      }
      localObject1 = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = (bjot)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Absv.a(((bjot)localObject2).b)))
        {
          ((SharedPreferences)localObject1).edit().putBoolean(((bjot)localObject2).b, true).apply();
          if (QLog.isColorLevel()) {
            QLog.d("ActionSheet", 2, "record " + ((bjot)localObject2).b + " authorize");
          }
        }
        i += 1;
      }
      if (this.jdField_a_of_type_Absu != null)
      {
        this.jdField_a_of_type_Absv.a = 0;
        this.jdField_a_of_type_Absu.a(this.jdField_a_of_type_Absv);
      }
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjos
 * JD-Core Version:    0.7.0.1
 */