import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aqhe
  extends akwq
{
  public aqhe(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  protected void onGetAppletsSettingSwitch(boolean paramBoolean, List<akwz> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsSettingFragment", 2, "onGetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    if (paramBoolean)
    {
      HashSet localHashSet = new HashSet();
      if ((paramList != null) && (paramBoolean) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (akwz)paramList.next();
          Object localObject2;
          if ((((akwz)localObject1).jdField_a_of_type_JavaUtilList != null) && (((akwz)localObject1).jdField_a_of_type_JavaUtilList.size() > 0) && (((akwz)localObject1).jdField_a_of_type_JavaUtilList.get(0) != null) && (((AppletItem)((akwz)localObject1).jdField_a_of_type_JavaUtilList.get(0)).a() == 1L))
          {
            AppletsSettingFragment.a(this.a, (AppletItem)((akwz)localObject1).jdField_a_of_type_JavaUtilList.get(0));
            if (!TextUtils.isEmpty(AppletsSettingFragment.a(this.a).a()))
            {
              AppletsSettingFragment.a(this.a).setText(AppletsSettingFragment.a(this.a).a());
              this.a.a.e(AppletsSettingFragment.a(this.a).a());
            }
            localObject2 = AppletsSettingFragment.a(this.a);
            if (AppletsSettingFragment.a(this.a).b() == 1)
            {
              paramBoolean = true;
              label247:
              ((Switch)localObject2).setChecked(paramBoolean);
              localObject2 = this.a.a;
              if (AppletsSettingFragment.a(this.a).b() != 1) {
                break label333;
              }
            }
            label333:
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((ahjx)localObject2).a(paramBoolean);
              if (TextUtils.isEmpty(((akwz)localObject1).jdField_a_of_type_JavaLangString)) {
                break;
              }
              AppletsSettingFragment.b(this.a).setText(((akwz)localObject1).jdField_a_of_type_JavaLangString);
              this.a.a.a(((akwz)localObject1).jdField_a_of_type_JavaLangString);
              break;
              paramBoolean = false;
              break label247;
            }
          }
          if (!TextUtils.isEmpty(((akwz)localObject1).jdField_a_of_type_JavaLangString))
          {
            AppletsSettingFragment.c(this.a).setText(((akwz)localObject1).jdField_a_of_type_JavaLangString);
            this.a.a.b(((akwz)localObject1).jdField_a_of_type_JavaLangString);
          }
          if ((((akwz)localObject1).jdField_a_of_type_JavaUtilList != null) && (((akwz)localObject1).jdField_a_of_type_JavaUtilList.size() > 0))
          {
            AppletsSettingFragment.a(this.a).clear();
            localObject1 = ((akwz)localObject1).jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (AppletItem)((Iterator)localObject1).next();
              AppletsSettingFragment.a(this.a).put(AppletsSettingFragment.a(this.a, (AppletItem)localObject2), localObject2);
              if ((((AppletItem)localObject2).a() != 1L) && (((AppletItem)localObject2).b() != 1)) {
                localHashSet.add(String.valueOf(((AppletItem)localObject2).a()));
              }
            }
            AppletsSettingFragment.a(this.a, new ArrayList(AppletsSettingFragment.a(this.a).values()));
          }
        }
      }
      this.a.a.a(localHashSet);
      return;
    }
    this.a.a(2131690156);
  }
  
  protected void onSetAppletsSettingSwitch(boolean paramBoolean, List<AppletItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsSettingFragment", 2, "onSetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (AppletItem)paramList.next();
        this.a.a(false);
        if (!paramBoolean) {
          this.a.a(2131690157);
        }
        Object localObject2;
        int i;
        if (((AppletItem)localObject1).a() == 1L)
        {
          localObject2 = AppletsSettingFragment.a(this.a);
          if (paramBoolean)
          {
            i = ((AppletItem)localObject1).b();
            label112:
            ((AppletItem)localObject2).a(i);
            localObject1 = AppletsSettingFragment.a(this.a);
            if (AppletsSettingFragment.a(this.a).b() != 1) {
              break label216;
            }
            bool = true;
            label144:
            ((Switch)localObject1).setChecked(bool);
            if (this.a.a == null) {
              continue;
            }
            localObject1 = this.a.a;
            if (AppletsSettingFragment.a(this.a).b() != 1) {
              break label222;
            }
          }
          label216:
          label222:
          for (boolean bool = true;; bool = false)
          {
            ((ahjx)localObject1).a(bool);
            break;
            if (((AppletItem)localObject1).b() == 1)
            {
              i = 0;
              break label112;
            }
            i = 1;
            break label112;
            bool = false;
            break label144;
          }
        }
        else
        {
          localObject2 = AppletsSettingFragment.a(this.a, (AppletItem)localObject1);
          localObject2 = (AppletItem)AppletsSettingFragment.a(this.a).get(localObject2);
          if (localObject2 != null)
          {
            if (!paramBoolean) {
              break label347;
            }
            i = ((AppletItem)localObject1).b();
          }
          for (;;)
          {
            ((AppletItem)localObject2).a(i);
            AppletsSettingFragment.a(this.a);
            AppletsSettingFragment.a(this.a, new ArrayList(AppletsSettingFragment.a(this.a).values()));
            if (this.a.a == null) {
              break;
            }
            if (((AppletItem)localObject2).b() != 0) {
              break label366;
            }
            this.a.a.c(String.valueOf(((AppletItem)localObject2).a()));
            break;
            label347:
            if (((AppletItem)localObject1).b() == 1) {
              i = 0;
            } else {
              i = 1;
            }
          }
          label366:
          this.a.a.d(String.valueOf(((AppletItem)localObject2).a()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqhe
 * JD-Core Version:    0.7.0.1
 */