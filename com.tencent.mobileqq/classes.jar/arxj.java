import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class arxj
{
  int jdField_a_of_type_Int;
  arxg jdField_a_of_type_Arxg;
  arxi jdField_a_of_type_Arxi;
  public String a;
  List<arxg> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  arxg jdField_b_of_type_Arxg;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  arxg jdField_c_of_type_Arxg;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  arxg jdField_d_of_type_Arxg;
  boolean jdField_d_of_type_Boolean;
  arxg jdField_e_of_type_Arxg;
  boolean jdField_e_of_type_Boolean;
  arxg jdField_f_of_type_Arxg;
  boolean jdField_f_of_type_Boolean;
  
  public arxj()
  {
    this.jdField_a_of_type_JavaLangString = "init";
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int j = 1;
    int i = 0;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonLinearLayout", 2, "getRealIndex, position:" + paramInt + ",pageTotalNum:" + this.jdField_d_of_type_Int + ",page:" + this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean) {
      if ((paramInt + 1) % this.jdField_d_of_type_Int == 0) {
        paramInt = -1;
      }
    }
    int m;
    label237:
    label242:
    do
    {
      do
      {
        return paramInt;
        return paramInt + this.jdField_c_of_type_Int * (this.jdField_d_of_type_Int - 1);
        if (this.jdField_e_of_type_Boolean)
        {
          if ((paramInt == 0) && (this.jdField_c_of_type_Int == 0)) {
            return -5;
          }
          if (this.jdField_f_of_type_Boolean) {
            i = 1;
          }
          if ((paramInt == 1) && (this.jdField_c_of_type_Int == 0) && (this.jdField_f_of_type_Boolean)) {
            return -6;
          }
          if (this.jdField_c_of_type_Int == 0) {
            return paramInt - 1 - i;
          }
          return this.jdField_d_of_type_Int - 1 + (this.jdField_c_of_type_Int - 1) * this.jdField_d_of_type_Int + paramInt - i;
        }
        m = this.jdField_a_of_type_JavaUtilList.size();
        if (this.jdField_d_of_type_Boolean)
        {
          i = 1;
          if (!this.jdField_c_of_type_Boolean) {
            break label237;
          }
        }
        for (;;)
        {
          if (this.jdField_c_of_type_Int + paramInt != 0) {
            break label270;
          }
          if (!this.jdField_d_of_type_Boolean) {
            break label242;
          }
          return -4;
          i = 0;
          break;
          j = 0;
        }
        paramInt = k;
      } while (this.jdField_a_of_type_JavaUtilList.size() != 0);
      paramInt = k;
    } while (!this.jdField_c_of_type_Boolean);
    return -2;
    label270:
    if (this.jdField_c_of_type_Int * this.jdField_d_of_type_Int + paramInt == i + (m - 1) + j)
    {
      if (this.jdField_c_of_type_Boolean) {
        return -2;
      }
      return this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    if (this.jdField_d_of_type_Boolean) {
      return this.jdField_c_of_type_Int * this.jdField_d_of_type_Int + paramInt - 1;
    }
    return paramInt + this.jdField_c_of_type_Int * this.jdField_d_of_type_Int;
  }
  
  public arxg a(int paramInt)
  {
    paramInt = a(paramInt);
    if (paramInt == -1) {
      return this.jdField_a_of_type_Arxg;
    }
    if (paramInt == -2) {
      return this.jdField_c_of_type_Arxg;
    }
    if (paramInt == -3) {
      return this.jdField_b_of_type_Arxg;
    }
    if (paramInt == -4) {
      return this.jdField_d_of_type_Arxg;
    }
    if (paramInt == -5) {
      return this.jdField_e_of_type_Arxg;
    }
    if (paramInt == -6) {
      return this.jdField_f_of_type_Arxg;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (arxg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arxi != null) {
      this.jdField_a_of_type_Arxi.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = (paramInt2 * paramInt1);
    this.jdField_a_of_type_Arxi.a(paramInt1, paramInt2);
  }
  
  public abstract void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup);
  
  public void a(arxg paramarxg)
  {
    this.jdField_a_of_type_Arxg = paramarxg;
  }
  
  public void a(arxi paramarxi)
  {
    this.jdField_a_of_type_Arxi = paramarxi;
  }
  
  public void a(List<arxg> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxj
 * JD-Core Version:    0.7.0.1
 */