import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class anfz
  extends anfo
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private anga[] jdField_a_of_type_ArrayOfAnga;
  protected int b;
  private List<List<anga>> b;
  private int c;
  
  protected anfz(angj paramangj, anfp paramanfp, Comparator<anga> paramComparator, anht paramanht, anho paramanho)
  {
    super(paramangj, paramanfp, paramComparator, paramanht, paramanho);
  }
  
  private int a(anga paramanga)
  {
    if ((paramanga == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramanga.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(anga paramanga, int paramInt1, int paramInt2)
  {
    if (paramanga.e()) {
      this.jdField_a_of_type_Anfp.a(paramanga, this.jdField_a_of_type_Angj);
    }
    paramanga.a(paramInt2, paramInt1, this.jdField_a_of_type_Anht.a(), this.jdField_a_of_type_Anho.a());
  }
  
  private void a(angz paramangz)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramangz.a()))
    {
      this.c = paramangz.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramangz = new anga[this.c];
      if (this.jdField_a_of_type_ArrayOfAnga != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfAnga, 0, paramangz, 0, Math.min(paramangz.length, this.jdField_a_of_type_ArrayOfAnga.length));
      }
      this.jdField_a_of_type_ArrayOfAnga = paramangz;
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
    int j = this.jdField_a_of_type_Angj.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramangz = ", ";; paramangz = "")
      {
        localStringBuilder2.append(paramangz);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    anic.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<anga>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        angh localangh = (angh)localIterator.next();
        localangh.a();
        long l = this.jdField_a_of_type_Anho.a();
        int k = (int)localangh.b();
        b(localangh);
        localangh.c(l - (int)((localangh.f() - k) / -localangh.a()));
        localangh.h(paramArrayOfInt[i]);
        localangh.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(anga paramanga)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramanga))
      {
        anic.b("Danmaku_R2LWindow", new Object[] { paramanga, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = angj.a().e();
    if (anic.jdField_a_of_type_Int >= 5) {
      anic.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    anga localanga;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localanga = (anga)localIterator.next();
        localIterator.remove();
        if ((localanga.b(this.jdField_a_of_type_Anho.a())) || (localanga.a(this.jdField_a_of_type_Anht.a())) || (a(localanga)))
        {
          if (anic.jdField_a_of_type_Int >= 5) {
            anic.b("Danmaku_R2LWindow", new Object[] { localanga, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localanga);
        }
        else
        {
          if (!localanga.b()) {
            anfx.a(this.jdField_a_of_type_Angj, localanga);
          }
          k = localanga.b(this.c);
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
            anic.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localanga);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localanga.a(this.c);
            break;
          }
          if (anic.jdField_a_of_type_Int >= 5)
          {
            anic.b("Danmaku_R2LWindow", new Object[] { localanga, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfAnga[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfAnga[i1])
              {
                anic.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfAnga[m] == null)
          {
            this.jdField_a_of_type_ArrayOfAnga[m] = localanga;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localanga);
            this.jdField_a_of_type_Int += 1;
            a(localanga, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (anic.jdField_a_of_type_Int >= 4) {
              anic.b("Danmaku_R2LWindow", new Object[] { localanga, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
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
        if (localanga.a(j))
        {
          this.jdField_a_of_type_ArrayOfAnga[k] = localanga;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localanga);
          this.jdField_a_of_type_Int += 1;
          a(localanga, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (anic.jdField_a_of_type_Int >= 4) {
            anic.b("Danmaku_R2LWindow", new Object[] { localanga, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localanga.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localanga);
        if (anic.jdField_a_of_type_Int >= 4) {
          anic.b("Danmaku_R2LWindow", new Object[] { localanga, " can not in window" });
        }
      }
      if ((localanga.h()) && (m != 0)) {
        anic.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localanga);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfAnga[m].a())
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
      i1 = ania.a(this.jdField_a_of_type_ArrayOfAnga[m], localanga, this.jdField_a_of_type_Anho.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfAnga[m] = localanga;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localanga);
          this.jdField_a_of_type_Int += 1;
          a(localanga, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (anic.jdField_a_of_type_Int >= 4) {
            anic.b("Danmaku_R2LWindow", new Object[] { localanga, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
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
        anga localanga = (anga)localIterator.next();
        if ((localanga.b(this.jdField_a_of_type_Anho.a())) || (!localanga.c()))
        {
          if (localanga == this.jdField_a_of_type_ArrayOfAnga[i]) {
            this.jdField_a_of_type_ArrayOfAnga[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localanga);
        }
      }
      i += 1;
    }
  }
  
  public anga a(anhx paramanhx)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        anga localanga = (anga)localIterator.next();
        if ((localanga.d()) && (localanga.a(paramanhx.jdField_a_of_type_AndroidGraphicsPoint.x, paramanhx.jdField_a_of_type_AndroidGraphicsPoint.y, paramanhx.jdField_a_of_type_Int, paramanhx.jdField_a_of_type_Long)))
        {
          if (anic.jdField_a_of_type_Int >= 5) {
            anic.a("Danmaku_R2LWindow", new Object[] { "onClick:", localanga, "[left:", Float.valueOf(localanga.b()), ",top:", Float.valueOf(localanga.c()), "]" });
          }
          return localanga;
        }
      }
      i += 1;
    }
    anic.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    angz localangz = angj.a();
    this.jdField_b_of_type_Int = localangz.b();
    a(localangz);
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
        anga localanga = (anga)localIterator.next();
        localanga.a(this.jdField_a_of_type_Anho.c(), this.jdField_a_of_type_Anho.a());
        if (!localanga.c(this.jdField_a_of_type_Anho.a())) {
          a(paramCanvas, localanga);
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
      this.jdField_a_of_type_ArrayOfAnga[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        anga localanga = (anga)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localanga);
      }
      i += 1;
    }
  }
  
  public void c(anga paramanga)
  {
    int j = a(paramanga);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        anga localanga = (anga)localIterator.next();
        j = i;
        if (localanga == paramanga) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localanga.c();
          i = j;
        }
      }
    }
  }
  
  public void d(anga paramanga)
  {
    int i = a(paramanga);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramanga = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramanga.hasNext()) {
        ((anga)paramanga.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfz
 * JD-Core Version:    0.7.0.1
 */