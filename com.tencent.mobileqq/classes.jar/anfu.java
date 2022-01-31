import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class anfu
  extends anfj
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private anfv[] jdField_a_of_type_ArrayOfAnfv;
  protected int b;
  private List<List<anfv>> b;
  private int c;
  
  protected anfu(ange paramange, anfk paramanfk, Comparator<anfv> paramComparator, anho paramanho, anhj paramanhj)
  {
    super(paramange, paramanfk, paramComparator, paramanho, paramanhj);
  }
  
  private int a(anfv paramanfv)
  {
    if ((paramanfv == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramanfv.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(anfv paramanfv, int paramInt1, int paramInt2)
  {
    if (paramanfv.e()) {
      this.jdField_a_of_type_Anfk.a(paramanfv, this.jdField_a_of_type_Ange);
    }
    paramanfv.a(paramInt2, paramInt1, this.jdField_a_of_type_Anho.a(), this.jdField_a_of_type_Anhj.a());
  }
  
  private void a(angu paramangu)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramangu.a()))
    {
      this.c = paramangu.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramangu = new anfv[this.c];
      if (this.jdField_a_of_type_ArrayOfAnfv != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfAnfv, 0, paramangu, 0, Math.min(paramangu.length, this.jdField_a_of_type_ArrayOfAnfv.length));
      }
      this.jdField_a_of_type_ArrayOfAnfv = paramangu;
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i < this.c) {
          while (i < this.c)
          {
            this.jdField_b_of_type_JavaUtilList.add(new LinkedList());
            i += 1;
          }
        }
        i -= 1;
        while (i >= this.c)
        {
          this.jdField_b_of_type_JavaUtilList.remove(i);
          i -= 1;
        }
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList(this.c);
      i = 0;
      while (i < this.c)
      {
        this.jdField_b_of_type_JavaUtilList.add(new LinkedList());
        i += 1;
      }
    }
    int j = this.jdField_a_of_type_Ange.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramangu = ", ";; paramangu = "")
      {
        localStringBuilder2.append(paramangu);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    anhx.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<anfv>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        angc localangc = (angc)localIterator.next();
        localangc.a();
        long l = this.jdField_a_of_type_Anhj.a();
        int k = (int)localangc.b();
        b(localangc);
        localangc.c(l - (int)((localangc.f() - k) / -localangc.a()));
        localangc.h(paramArrayOfInt[i]);
        localangc.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(anfv paramanfv)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramanfv))
      {
        anhx.b("Danmaku_R2LWindow", new Object[] { paramanfv, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = ange.a().e();
    if (anhx.jdField_a_of_type_Int >= 5) {
      anhx.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    anfv localanfv;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localanfv = (anfv)localIterator.next();
        localIterator.remove();
        if ((localanfv.b(this.jdField_a_of_type_Anhj.a())) || (localanfv.a(this.jdField_a_of_type_Anho.a())) || (a(localanfv)))
        {
          if (anhx.jdField_a_of_type_Int >= 5) {
            anhx.b("Danmaku_R2LWindow", new Object[] { localanfv, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localanfv);
        }
        else
        {
          if (!localanfv.b()) {
            anfs.a(this.jdField_a_of_type_Ange, localanfv);
          }
          k = localanfv.b(this.c);
          if (k >= 0)
          {
            j = k;
            m = 2147483647;
            if (k < 0) {
              break label295;
            }
          }
          label295:
          for (int n = j + 1;; n = this.c + j)
          {
            anhx.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localanfv);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localanfv.a(this.c);
            break;
          }
          if (anhx.jdField_a_of_type_Int >= 5)
          {
            anhx.b("Danmaku_R2LWindow", new Object[] { localanfv, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfAnfv[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfAnfv[i1])
              {
                anhx.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfAnfv[m] == null)
          {
            this.jdField_a_of_type_ArrayOfAnfv[m] = localanfv;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localanfv);
            this.jdField_a_of_type_Int += 1;
            a(localanfv, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (anhx.jdField_a_of_type_Int >= 4) {
              anhx.b("Danmaku_R2LWindow", new Object[] { localanfv, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
            }
            m = 1;
            k = i;
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      m = i;
      if (i == 0)
      {
        m = i;
        if (localanfv.a(j))
        {
          this.jdField_a_of_type_ArrayOfAnfv[k] = localanfv;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localanfv);
          this.jdField_a_of_type_Int += 1;
          a(localanfv, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (anhx.jdField_a_of_type_Int >= 4) {
            anhx.b("Danmaku_R2LWindow", new Object[] { localanfv, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localanfv.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localanfv);
        if (anhx.jdField_a_of_type_Int >= 4) {
          anhx.b("Danmaku_R2LWindow", new Object[] { localanfv, " can not in window" });
        }
      }
      if ((localanfv.h()) && (m != 0)) {
        anhx.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localanfv);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfAnfv[m].a())
      {
        m = i;
        i = j;
        j = m;
        label804:
        k += 1;
        m = i;
        i = j;
        j = m;
        break label252;
      }
      i1 = anhv.a(this.jdField_a_of_type_ArrayOfAnfv[m], localanfv, this.jdField_a_of_type_Anhj.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfAnfv[m] = localanfv;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localanfv);
          this.jdField_a_of_type_Int += 1;
          a(localanfv, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (anhx.jdField_a_of_type_Int >= 4) {
            anhx.b("Danmaku_R2LWindow", new Object[] { localanfv, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
          }
          k = 1;
          m = i;
          i = k;
          k = j;
          j = m;
          break;
          return;
        }
        break label804;
        i1 = j;
        j = i;
      }
      label1016:
      k = i;
      i = 0;
    }
  }
  
  private void f()
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        anfv localanfv = (anfv)localIterator.next();
        if ((localanfv.b(this.jdField_a_of_type_Anhj.a())) || (!localanfv.c()))
        {
          if (localanfv == this.jdField_a_of_type_ArrayOfAnfv[i]) {
            this.jdField_a_of_type_ArrayOfAnfv[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localanfv);
        }
      }
      i += 1;
    }
  }
  
  public anfv a(anhs paramanhs)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        anfv localanfv = (anfv)localIterator.next();
        if ((localanfv.d()) && (localanfv.a(paramanhs.jdField_a_of_type_AndroidGraphicsPoint.x, paramanhs.jdField_a_of_type_AndroidGraphicsPoint.y, paramanhs.jdField_a_of_type_Int, paramanhs.jdField_a_of_type_Long)))
        {
          if (anhx.jdField_a_of_type_Int >= 5) {
            anhx.a("Danmaku_R2LWindow", new Object[] { "onClick:", localanfv, "[left:", Float.valueOf(localanfv.b()), ",top:", Float.valueOf(localanfv.c()), "]" });
          }
          return localanfv;
        }
      }
      i += 1;
    }
    anhx.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    angu localangu = ange.a();
    this.jdField_b_of_type_Int = localangu.b();
    a(localangu);
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      int j = this.jdField_b_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        List localList = (List)this.jdField_b_of_type_JavaUtilList.get(i);
        if ((localList != null) && (localList.size() > 0)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void b()
  {
    e();
    f();
  }
  
  public void b(Canvas paramCanvas, long paramLong)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        anfv localanfv = (anfv)localIterator.next();
        localanfv.a(this.jdField_a_of_type_Anhj.c(), this.jdField_a_of_type_Anhj.a());
        if (!localanfv.c(this.jdField_a_of_type_Anhj.a())) {
          a(paramCanvas, localanfv);
        }
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int j = 0;
    int i = 0;
    while (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfAnfv[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        anfv localanfv = (anfv)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localanfv);
      }
      i += 1;
    }
  }
  
  public void c(anfv paramanfv)
  {
    int j = a(paramanfv);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        anfv localanfv = (anfv)localIterator.next();
        j = i;
        if (localanfv == paramanfv) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localanfv.c();
          i = j;
        }
      }
    }
  }
  
  public void d(anfv paramanfv)
  {
    int i = a(paramanfv);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramanfv = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramanfv.hasNext()) {
        ((anfv)paramanfv.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfu
 * JD-Core Version:    0.7.0.1
 */