import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class bgrj
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1;
  bfpc jdField_a_of_type_Bfpc = null;
  bgrm jdField_a_of_type_Bgrm = null;
  List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  AppRuntime jdField_a_of_type_MqqAppAppRuntime = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public bgrj(Activity paramActivity, bgrm parambgrm, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bgrm = parambgrm;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(paramActivity, null));
    if ((this.jdField_a_of_type_Int & 0x10) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131691961, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(16));
    }
    if ((this.jdField_a_of_type_Int & 0x20) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131698132, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(32));
    }
    if ((this.jdField_a_of_type_Int & 0x1) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131692753, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    }
    if ((this.jdField_a_of_type_Int & 0x80) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131698095, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(128));
    }
    if ((this.jdField_a_of_type_Int & 0x100) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131698119, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(256));
    }
    if ((this.jdField_a_of_type_Int & 0x40) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131698145, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(64));
    }
    if ((this.jdField_a_of_type_Int & 0x2) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131691309, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
    }
    if ((this.jdField_a_of_type_Int & 0x4) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131692324, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
    }
    if ((this.jdField_a_of_type_Int & 0x8) != 0)
    {
      this.jdField_a_of_type_Bfpc.a(2131692874, 5);
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
    }
    this.jdField_a_of_type_Bfpc.c(2131690596);
    this.jdField_a_of_type_Bfpc.setOnDismissListener(new bgrk(this));
    this.jdField_a_of_type_Bfpc.a(new bgrl(this));
  }
  
  private void b()
  {
    bgqi.a(this.jdField_a_of_type_MqqAppAppRuntime, "User_Forward", this.jdField_b_of_type_Int, 0, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfpc != null)
    {
      if (!this.jdField_a_of_type_Bfpc.isShowing()) {
        break label44;
      }
      this.jdField_a_of_type_Bfpc.dismiss();
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfpc = null;
      return;
      label44:
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bfpc.a(paramString, 5);
    this.jdField_b_of_type_JavaUtilList.add(paramString);
  }
  
  public boolean a(Integer paramInteger)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramInteger);
  }
  
  public boolean a(Integer paramInteger1, Integer paramInteger2, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (TextUtils.isEmpty(paramString))) {}
    int i;
    do
    {
      return false;
      i = this.jdField_a_of_type_JavaUtilList.indexOf(paramInteger1);
    } while (i == -1);
    this.jdField_a_of_type_JavaUtilList.set(i, paramInteger2);
    this.jdField_a_of_type_Bfpc.a(i, paramString);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Bfpc != null) && (!this.jdField_a_of_type_Bfpc.isShowing()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bfpc.show();
      this.jdField_a_of_type_Bgrm.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrj
 * JD-Core Version:    0.7.0.1
 */