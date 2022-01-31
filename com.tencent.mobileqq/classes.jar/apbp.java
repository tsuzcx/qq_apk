import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class apbp
  extends apbe
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private apbq[] jdField_a_of_type_ArrayOfApbq;
  protected int b;
  private List<List<apbq>> b;
  private int c;
  
  protected apbp(apbz paramapbz, apbf paramapbf, Comparator<apbq> paramComparator, apdj paramapdj, apde paramapde)
  {
    super(paramapbz, paramapbf, paramComparator, paramapdj, paramapde);
  }
  
  private int a(apbq paramapbq)
  {
    if ((paramapbq == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramapbq.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(apbq paramapbq, int paramInt1, int paramInt2)
  {
    if (paramapbq.e()) {
      this.jdField_a_of_type_Apbf.a(paramapbq, this.jdField_a_of_type_Apbz);
    }
    paramapbq.a(paramInt2, paramInt1, this.jdField_a_of_type_Apdj.a(), this.jdField_a_of_type_Apde.a());
  }
  
  private void a(apcp paramapcp)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramapcp.a()))
    {
      this.c = paramapcp.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramapcp = new apbq[this.c];
      if (this.jdField_a_of_type_ArrayOfApbq != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfApbq, 0, paramapcp, 0, Math.min(paramapcp.length, this.jdField_a_of_type_ArrayOfApbq.length));
      }
      this.jdField_a_of_type_ArrayOfApbq = paramapcp;
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
    int j = this.jdField_a_of_type_Apbz.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramapcp = ", ";; paramapcp = "")
      {
        localStringBuilder2.append(paramapcp);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    apds.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<apbq>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        apbx localapbx = (apbx)localIterator.next();
        localapbx.a();
        long l = this.jdField_a_of_type_Apde.a();
        int k = (int)localapbx.b();
        b(localapbx);
        localapbx.c(l - (int)((localapbx.f() - k) / -localapbx.a()));
        localapbx.h(paramArrayOfInt[i]);
        localapbx.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(apbq paramapbq)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramapbq))
      {
        apds.b("Danmaku_R2LWindow", new Object[] { paramapbq, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = apbz.a().e();
    if (apds.jdField_a_of_type_Int >= 5) {
      apds.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    apbq localapbq;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localapbq = (apbq)localIterator.next();
        localIterator.remove();
        if ((localapbq.b(this.jdField_a_of_type_Apde.a())) || (localapbq.a(this.jdField_a_of_type_Apdj.a())) || (a(localapbq)))
        {
          if (apds.jdField_a_of_type_Int >= 5) {
            apds.b("Danmaku_R2LWindow", new Object[] { localapbq, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localapbq);
        }
        else
        {
          if (!localapbq.b()) {
            apbn.a(this.jdField_a_of_type_Apbz, localapbq);
          }
          k = localapbq.b(this.c);
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
            apds.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localapbq);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localapbq.a(this.c);
            break;
          }
          if (apds.jdField_a_of_type_Int >= 5)
          {
            apds.b("Danmaku_R2LWindow", new Object[] { localapbq, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfApbq[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfApbq[i1])
              {
                apds.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfApbq[m] == null)
          {
            this.jdField_a_of_type_ArrayOfApbq[m] = localapbq;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localapbq);
            this.jdField_a_of_type_Int += 1;
            a(localapbq, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (apds.jdField_a_of_type_Int >= 4) {
              apds.b("Danmaku_R2LWindow", new Object[] { localapbq, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
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
        if (localapbq.a(j))
        {
          this.jdField_a_of_type_ArrayOfApbq[k] = localapbq;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localapbq);
          this.jdField_a_of_type_Int += 1;
          a(localapbq, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (apds.jdField_a_of_type_Int >= 4) {
            apds.b("Danmaku_R2LWindow", new Object[] { localapbq, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localapbq.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localapbq);
        if (apds.jdField_a_of_type_Int >= 4) {
          apds.b("Danmaku_R2LWindow", new Object[] { localapbq, " can not in window" });
        }
      }
      if ((localapbq.h()) && (m != 0)) {
        apds.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localapbq);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfApbq[m].a())
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
      i1 = apdq.a(this.jdField_a_of_type_ArrayOfApbq[m], localapbq, this.jdField_a_of_type_Apde.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfApbq[m] = localapbq;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localapbq);
          this.jdField_a_of_type_Int += 1;
          a(localapbq, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (apds.jdField_a_of_type_Int >= 4) {
            apds.b("Danmaku_R2LWindow", new Object[] { localapbq, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
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
        apbq localapbq = (apbq)localIterator.next();
        if ((localapbq.b(this.jdField_a_of_type_Apde.a())) || (!localapbq.c()))
        {
          if (localapbq == this.jdField_a_of_type_ArrayOfApbq[i]) {
            this.jdField_a_of_type_ArrayOfApbq[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localapbq);
        }
      }
      i += 1;
    }
  }
  
  public apbq a(apdn paramapdn)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        apbq localapbq = (apbq)localIterator.next();
        if ((localapbq.d()) && (localapbq.a(paramapdn.jdField_a_of_type_AndroidGraphicsPoint.x, paramapdn.jdField_a_of_type_AndroidGraphicsPoint.y, paramapdn.jdField_a_of_type_Int, paramapdn.jdField_a_of_type_Long)))
        {
          if (apds.jdField_a_of_type_Int >= 5) {
            apds.a("Danmaku_R2LWindow", new Object[] { "onClick:", localapbq, "[left:", Float.valueOf(localapbq.b()), ",top:", Float.valueOf(localapbq.c()), "]" });
          }
          return localapbq;
        }
      }
      i += 1;
    }
    apds.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    apcp localapcp = apbz.a();
    this.jdField_b_of_type_Int = localapcp.b();
    a(localapcp);
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
        apbq localapbq = (apbq)localIterator.next();
        localapbq.a(this.jdField_a_of_type_Apde.c(), this.jdField_a_of_type_Apde.a());
        if (!localapbq.c(this.jdField_a_of_type_Apde.a())) {
          a(paramCanvas, localapbq);
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
      this.jdField_a_of_type_ArrayOfApbq[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        apbq localapbq = (apbq)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localapbq);
      }
      i += 1;
    }
  }
  
  public void c(apbq paramapbq)
  {
    int j = a(paramapbq);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        apbq localapbq = (apbq)localIterator.next();
        j = i;
        if (localapbq == paramapbq) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localapbq.c();
          i = j;
        }
      }
    }
  }
  
  public void d(apbq paramapbq)
  {
    int i = a(paramapbq);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramapbq = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramapbq.hasNext()) {
        ((apbq)paramapbq.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbp
 * JD-Core Version:    0.7.0.1
 */