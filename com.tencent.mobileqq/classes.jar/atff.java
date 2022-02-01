import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class atff
{
  private final int jdField_a_of_type_Int = 7;
  private ArrayList<atfg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b = -1;
  private int c = -1;
  private int d;
  private int e;
  
  public atff(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  private void a(ArrayList<asxk> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        a(new atfg((asxk)paramArrayList.get(i)));
        i += 1;
      }
    }
  }
  
  public ArrayList<atfg> a()
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
      int i1 = ((atfg)this.jdField_a_of_type_JavaUtilArrayList.get(j)).d();
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
        asxk localasxk = ((atfg)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a;
        if (localasxk != null) {
          localArrayList.add(new asxk(localasxk.jdField_a_of_type_Int, localasxk.jdField_a_of_type_JavaLangString, localasxk.b));
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
    atfg localatfg1;
    int k;
    atfg localatfg2;
    if (paramInt > 0)
    {
      for (i = -1; j < this.jdField_a_of_type_JavaUtilArrayList.size(); i = k)
      {
        localatfg1 = (atfg)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        localatfg1.a(localatfg1.a() + paramInt);
        m = localatfg1.a();
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
        localatfg1 = (atfg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localatfg1.a() > this.c)
        {
          localatfg2 = localatfg1.b();
          if (localatfg2 != null) {
            break label242;
          }
          QLog.e("RaceLine horserace", 2, "rightBro is null " + paramInt + "  index:" + this.b);
        }
        for (;;)
        {
          paramInt -= 1;
          break;
          label242:
          localatfg1.a(localatfg2.a() - localatfg1.c());
        }
      }
      paramInt = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      label271:
      if (paramInt > i)
      {
        localatfg1 = (atfg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localatfg1.a() > this.c)
        {
          localatfg2 = localatfg1.b();
          if (localatfg2 != null) {
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
        localatfg1.a(localatfg2.a() - localatfg1.c());
      }
    }
    j = 0;
    for (int i = -1; j < this.jdField_a_of_type_JavaUtilArrayList.size(); i = k)
    {
      localatfg1 = (atfg)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      localatfg1.a(localatfg1.a() + paramInt);
      k = localatfg1.a();
      int n = localatfg1.c() + k;
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
      localatfg1 = (atfg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localatfg1.a() + localatfg1.c() < 0)
      {
        localatfg2 = localatfg1.a();
        if (localatfg2 != null) {
          break label587;
        }
        QLog.e("RaceLine horserace", 2, "leftBro is null " + paramInt + "  index:" + this.b);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        label587:
        j = localatfg2.a();
        localatfg1.a(localatfg2.c() + j);
      }
    }
    label608:
    if (j < i)
    {
      localatfg1 = (atfg)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localatfg1.a() + localatfg1.c() < 0)
      {
        localatfg2 = localatfg1.a();
        if (localatfg2 != null) {
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
      paramInt = localatfg2.a();
      localatfg1.a(localatfg2.c() + paramInt);
    }
  }
  
  public void a(atfg paramatfg)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ((atfg)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(paramatfg);
      ((atfg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).b(paramatfg);
      paramatfg.b((atfg)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      paramatfg.a((atfg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramatfg);
      return;
      paramatfg.a(paramatfg);
      paramatfg.b(paramatfg);
    }
  }
  
  public void b()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      atfg localatfg1 = (atfg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = this.b;
      if (i == 0)
      {
        localatfg1.a(a() + 0);
        localatfg1.b(this.d * j + (j + 1) * this.e);
      }
      for (;;)
      {
        i += 1;
        break;
        atfg localatfg2 = (atfg)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
        int k = localatfg2.a();
        localatfg1.a(localatfg2.c() + k);
        localatfg1.b(this.d * j + (j + 1) * this.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atff
 * JD-Core Version:    0.7.0.1
 */