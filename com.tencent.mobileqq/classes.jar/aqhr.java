import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aqhr
  implements aqiw
{
  public aqhr(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public int a()
  {
    int j = 1;
    int i;
    if (this.a.i == 0) {
      i = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getColumnCount|pickerType : " + this.a.i + ", count : " + i);
      }
      return i;
      i = j;
      if (this.a.i != 3) {
        if (this.a.i != 1)
        {
          i = j;
          if (this.a.i != 2) {}
        }
        else
        {
          i = this.a.h;
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    int j = 0;
    int i;
    if (this.a.i == 0) {
      i = anjh.b.length - 17;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getRowCount|pickerType : " + this.a.i + ", column : " + paramInt + ", count : " + i);
      }
      return i;
      if (this.a.i == 3)
      {
        i = anjh.c.length;
      }
      else if (this.a.i != 1)
      {
        i = j;
        if (this.a.i != 2) {}
      }
      else
      {
        i = j;
        if (paramInt < this.a.h)
        {
          i = j;
          if (paramInt >= 0)
          {
            i = j;
            if (this.a.a[paramInt] != null) {
              i = ((List)this.a.a[paramInt]).size();
            }
          }
        }
      }
    }
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    int i;
    String str;
    if (this.a.i == 0)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < anjh.b.length) {}
      }
      else
      {
        i = 0;
      }
      paramInt2 = ConditionSearchFriendActivity.b(this.a, i);
      str = anjh.b[paramInt2];
      paramInt2 = i;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "getText|pickerType : " + this.a.i + ", column : " + paramInt1 + ", row : " + paramInt2 + ", result : " + str);
      }
      return str;
      if (this.a.i == 3)
      {
        if (paramInt2 >= 0)
        {
          i = paramInt2;
          if (paramInt2 < anjh.c.length) {}
        }
        else
        {
          i = 0;
        }
        str = anjh.c[i];
        paramInt2 = i;
      }
      else if (((this.a.i == 1) || (this.a.i == 2)) && (paramInt1 < this.a.a.length) && (this.a.a[paramInt1] != null) && (((List)this.a.a[paramInt1]).size() > 0))
      {
        if (paramInt2 >= 0)
        {
          i = paramInt2;
          if (paramInt2 < ((List)this.a.a[paramInt1]).size()) {}
        }
        else
        {
          i = 0;
        }
        if (((BaseAddress)((List)this.a.a[paramInt1]).get(i)).code.equals("0"))
        {
          str = ConditionSearchFriendActivity.a();
          paramInt2 = i;
        }
        else
        {
          str = ((BaseAddress)((List)this.a.a[paramInt1]).get(i)).name;
          paramInt2 = i;
        }
      }
      else
      {
        str = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhr
 * JD-Core Version:    0.7.0.1
 */