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

public class blae
  extends bkzi
  implements View.OnClickListener
{
  private acit jdField_a_of_type_Acit;
  private final aciu jdField_a_of_type_Aciu;
  private final List<blaf> jdField_a_of_type_JavaUtilList;
  
  public blae(Activity paramActivity, aciu paramaciu, acit paramacit, List<blaf> paramList)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Aciu = paramaciu;
    this.jdField_a_of_type_Acit = paramacit;
    f();
  }
  
  private AuthorizationItem a(blaf paramblaf, int paramInt, String paramString)
  {
    return new AuthorizationItem(getContext(), paramString, paramblaf, paramInt);
  }
  
  private void f()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559116, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131369048);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      if (j < k)
      {
        int i;
        if ((blaf)this.jdField_a_of_type_JavaUtilList.get(j) != AuthorizationItem.d)
        {
          if (k != 1) {
            break label145;
          }
          i = 3;
        }
        for (;;)
        {
          localLinearLayout2.addView(a((blaf)this.jdField_a_of_type_JavaUtilList.get(j), i, this.jdField_a_of_type_Aciu.a(((blaf)this.jdField_a_of_type_JavaUtilList.get(j)).b)));
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
    localLinearLayout1.findViewById(2131363844).setOnClickListener(this);
    localLinearLayout1.findViewById(2131363869).setOnClickListener(this);
    localLinearLayout1.findViewById(2131369435).setOnClickListener(this);
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
      Object localObject1 = new blab(getContext());
      Object localObject2 = ((blab)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setWindowAnimations(2131755013);
      }
      ((blab)localObject1).show();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      if (this.jdField_a_of_type_Acit != null)
      {
        this.jdField_a_of_type_Aciu.a = 2;
        this.jdField_a_of_type_Acit.a(this.jdField_a_of_type_Aciu);
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
        localObject2 = (blaf)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Aciu.a(((blaf)localObject2).b)))
        {
          ((SharedPreferences)localObject1).edit().putBoolean(((blaf)localObject2).b, true).apply();
          if (QLog.isColorLevel()) {
            QLog.d("ActionSheet", 2, "record " + ((blaf)localObject2).b + " authorize");
          }
        }
        i += 1;
      }
      if (this.jdField_a_of_type_Acit != null)
      {
        this.jdField_a_of_type_Aciu.a = 0;
        this.jdField_a_of_type_Acit.a(this.jdField_a_of_type_Aciu);
      }
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blae
 * JD-Core Version:    0.7.0.1
 */