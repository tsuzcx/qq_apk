import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class asvt
{
  private final int jdField_a_of_type_Int = 7;
  private ArrayList<asvu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b = -1;
  private int c = -1;
  private int d;
  private int e;
  
  public asvt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
  }
  
  private int a()
  {
    switch (this.b)
    {
    default: 
      return 0;
    case 0: 
      return -30;
    case 1: 
      return -80;
    case 2: 
      return -10;
    }
    return -60;
  }
  
  private void a(ArrayList<asnt> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        a(new asvu((asnt)paramArrayList.get(i)));
        i += 1;
      }
    }
  }
  
  public ArrayList<asvu> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    int m = 0;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      QLog.e("RaceLine horserace", 2, "一个都没有，没法复制啊大哥");
      return;
    }
    int j = 0;
    int i = 0;
    for (int k = 0; j < this.jdField_a_of_type_JavaUtilArrayList.size(); k = n)
    {
      int i1 = ((asvu)this.jdField_a_of_type_JavaUtilArrayList.get(j)).d();
      n = k + i1;
      k = i;
      if (i < i1) {
        k = i1;
      }
      j += 1;
      i = k;
    }
    int n = this.c + i;
    float f2 = 0.0F;
    float f1;
    if (k < n)
    {
      f1 = n / k;
      if (f1 <= 7.0F) {
        break label306;
      }
      f1 = 7.0F;
    }
    label306:
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      j = 0;
      for (;;)
      {
        k = m;
        if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        asnt localasnt = ((asvu)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a;
        if (localasnt != null) {
          localArrayList.add(new asnt(localasnt.jdField_a_of_type_Int, localasnt.jdField_a_of_type_JavaLangString, localasnt.b));
        }
        j += 1;
      }
      for (;;)
      {
        f2 = f1;
        if (k >= f1) {
          break;
        }
        a(localArrayList);
        k += 1;
      }
      QLog.d("RaceLine horserace", 2, "finalWid: " + n + " parent: " + this.c + " maxTagwid:" + i + " copyTime : " + f2);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    int m = 0;
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)
    {
      QLog.e("RaceLine horserace", 2, "tag 数量连2个都没有，不滑了哦～嘤嘤嘤嘤嘤～");
      return;
    }
    if ((this.c == -1) || (this.c < 10))
    {
      QLog.e("RaceLine horserace", 2, "mParentWidth err num");
      return;
    }
    asvu localasvu1;
    int k;
    asvu localasvu2;
    if (paramInt > 0)
    {
      for (i = -1; j < this.jdField_a_of_type_JavaUtilArrayList.size(); i = k)
      {
        localasvu1 = (asvu)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        localasvu1.a(localasvu1.a() + paramInt);
        m = localasvu1.a();
        k = i;
        if (m > 0)
        {
          k = i;
          if (m < this.c)
          {
            k = i;
            if (i == -1) {
              k = j;
            }
          }
        }
        j += 1;
      }
      if (i == -1)
      {
        QLog.e("RaceLine horserace", 2, "SubIndex out of range");
        return;
      }
      paramInt = i;
      if (paramInt >= 0)
      {
        localasvu1 = (asvu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localasvu1.a() > this.c)
        {
          localasvu2 = localasvu1.b();
          if (localasvu2 != null) {
            break label242;
          }
          QLog.e("RaceLine horserace", 2, "rightBro is null " + paramInt + "  index:" + this.b);
        }
        for (;;)
        {
          paramInt -= 1;
          break;
          label242:
          localasvu1.a(localasvu2.a() - localasvu1.c());
        }
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      label271:
      if (paramInt > i)
      {
        localasvu1 = (asvu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localasvu1.a() > this.c)
        {
          localasvu2 = localasvu1.b();
          if (localasvu2 != null) {
            break label357;
          }
          QLog.e("RaceLine horserace", 2, "rightBro is null " + paramInt + "  index:" + this.b);
        }
      }
      for (;;)
      {
        paramInt -= 1;
        break label271;
        break;
        label357:
        localasvu1.a(localasvu2.a() - localasvu1.c());
      }
    }
    j = 0;
    for (int i = -1; j < this.jdField_a_of_type_JavaUtilArrayList.size(); i = k)
    {
      localasvu1 = (asvu)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      localasvu1.a(localasvu1.a() + paramInt);
      k = localasvu1.a();
      int n = localasvu1.c() + k;
      k = i;
      if (n > 0)
      {
        k = i;
        if (n < this.c)
        {
          k = i;
          if (i == -1) {
            k = j;
          }
        }
      }
      j += 1;
    }
    if (i == -1)
    {
      QLog.e("RaceLine horserace", 2, "SubIndex out of range");
      return;
    }
    paramInt = i;
    j = m;
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localasvu1 = (asvu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localasvu1.a() + localasvu1.c() < 0)
      {
        localasvu2 = localasvu1.a();
        if (localasvu2 != null) {
          break label587;
        }
        QLog.e("RaceLine horserace", 2, "leftBro is null " + paramInt + "  index:" + this.b);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        label587:
        j = localasvu2.a();
        localasvu1.a(localasvu2.c() + j);
      }
    }
    label608:
    if (j < i)
    {
      localasvu1 = (asvu)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localasvu1.a() + localasvu1.c() < 0)
      {
        localasvu2 = localasvu1.a();
        if (localasvu2 != null) {
          break label696;
        }
        QLog.e("RaceLine horserace", 2, "leftBro is null " + j + "  index:" + this.b);
      }
    }
    for (;;)
    {
      j += 1;
      break label608;
      break;
      label696:
      paramInt = localasvu2.a();
      localasvu1.a(localasvu2.c() + paramInt);
    }
  }
  
  public void a(asvu paramasvu)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ((asvu)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(paramasvu);
      ((asvu)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).b(paramasvu);
      paramasvu.b((asvu)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      paramasvu.a((asvu)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramasvu);
      return;
      paramasvu.a(paramasvu);
      paramasvu.b(paramasvu);
    }
  }
  
  public void b()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      asvu localasvu1 = (asvu)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = this.b;
      if (i == 0)
      {
        localasvu1.a(a() + 0);
        localasvu1.b(this.d * j + (j + 1) * this.e);
      }
      for (;;)
      {
        i += 1;
        break;
        asvu localasvu2 = (asvu)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
        int k = localasvu2.a();
        localasvu1.a(localasvu2.c() + k);
        localasvu1.b(this.d * j + (j + 1) * this.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvt
 * JD-Core Version:    0.7.0.1
 */