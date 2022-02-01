import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class arub
  extends artq
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private aruc[] jdField_a_of_type_ArrayOfAruc;
  protected int b;
  private List<List<aruc>> b;
  private int c;
  
  protected arub(arul paramarul, artr paramartr, Comparator<aruc> paramComparator, arvv paramarvv, arvq paramarvq)
  {
    super(paramarul, paramartr, paramComparator, paramarvv, paramarvq);
  }
  
  private int a(aruc paramaruc)
  {
    if ((paramaruc == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramaruc.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(aruc paramaruc, int paramInt1, int paramInt2)
  {
    if (paramaruc.e()) {
      this.jdField_a_of_type_Artr.a(paramaruc, this.jdField_a_of_type_Arul);
    }
    paramaruc.a(paramInt2, paramInt1, this.jdField_a_of_type_Arvv.a(), this.jdField_a_of_type_Arvq.a());
  }
  
  private void a(arvb paramarvb)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramarvb.a()))
    {
      this.c = paramarvb.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramarvb = new aruc[this.c];
      if (this.jdField_a_of_type_ArrayOfAruc != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfAruc, 0, paramarvb, 0, Math.min(paramarvb.length, this.jdField_a_of_type_ArrayOfAruc.length));
      }
      this.jdField_a_of_type_ArrayOfAruc = paramarvb;
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
    int j = this.jdField_a_of_type_Arul.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramarvb = ", ";; paramarvb = "")
      {
        localStringBuilder2.append(paramarvb);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    arwe.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<aruc>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aruj localaruj = (aruj)localIterator.next();
        localaruj.a();
        long l = this.jdField_a_of_type_Arvq.a();
        int k = (int)localaruj.b();
        b(localaruj);
        localaruj.c(l - (int)((localaruj.f() - k) / -localaruj.a()));
        localaruj.h(paramArrayOfInt[i]);
        localaruj.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(aruc paramaruc)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramaruc))
      {
        arwe.b("Danmaku_R2LWindow", new Object[] { paramaruc, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = arul.a().e();
    if (arwe.jdField_a_of_type_Int >= 5) {
      arwe.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    aruc localaruc;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localaruc = (aruc)localIterator.next();
        localIterator.remove();
        if ((localaruc.b(this.jdField_a_of_type_Arvq.a())) || (localaruc.a(this.jdField_a_of_type_Arvv.a())) || (a(localaruc)))
        {
          if (arwe.jdField_a_of_type_Int >= 5) {
            arwe.b("Danmaku_R2LWindow", new Object[] { localaruc, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localaruc);
        }
        else
        {
          if (!localaruc.b()) {
            artz.a(this.jdField_a_of_type_Arul, localaruc);
          }
          k = localaruc.b(this.c);
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
            arwe.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localaruc);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localaruc.a(this.c);
            break;
          }
          if (arwe.jdField_a_of_type_Int >= 5)
          {
            arwe.b("Danmaku_R2LWindow", new Object[] { localaruc, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfAruc[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfAruc[i1])
              {
                arwe.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfAruc[m] == null)
          {
            this.jdField_a_of_type_ArrayOfAruc[m] = localaruc;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localaruc);
            this.jdField_a_of_type_Int += 1;
            a(localaruc, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (arwe.jdField_a_of_type_Int >= 4) {
              arwe.b("Danmaku_R2LWindow", new Object[] { localaruc, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
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
        if (localaruc.a(j))
        {
          this.jdField_a_of_type_ArrayOfAruc[k] = localaruc;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localaruc);
          this.jdField_a_of_type_Int += 1;
          a(localaruc, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (arwe.jdField_a_of_type_Int >= 4) {
            arwe.b("Danmaku_R2LWindow", new Object[] { localaruc, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localaruc.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localaruc);
        if (arwe.jdField_a_of_type_Int >= 4) {
          arwe.b("Danmaku_R2LWindow", new Object[] { localaruc, " can not in window" });
        }
      }
      if ((localaruc.h()) && (m != 0)) {
        arwe.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localaruc);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfAruc[m].a())
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
      i1 = arwc.a(this.jdField_a_of_type_ArrayOfAruc[m], localaruc, this.jdField_a_of_type_Arvq.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfAruc[m] = localaruc;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localaruc);
          this.jdField_a_of_type_Int += 1;
          a(localaruc, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (arwe.jdField_a_of_type_Int >= 4) {
            arwe.b("Danmaku_R2LWindow", new Object[] { localaruc, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
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
        aruc localaruc = (aruc)localIterator.next();
        if ((localaruc.b(this.jdField_a_of_type_Arvq.a())) || (!localaruc.c()))
        {
          if (localaruc == this.jdField_a_of_type_ArrayOfAruc[i]) {
            this.jdField_a_of_type_ArrayOfAruc[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localaruc);
        }
      }
      i += 1;
    }
  }
  
  public aruc a(arvz paramarvz)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aruc localaruc = (aruc)localIterator.next();
        if ((localaruc.d()) && (localaruc.a(paramarvz.jdField_a_of_type_AndroidGraphicsPoint.x, paramarvz.jdField_a_of_type_AndroidGraphicsPoint.y, paramarvz.jdField_a_of_type_Int, paramarvz.jdField_a_of_type_Long)))
        {
          if (arwe.jdField_a_of_type_Int >= 5) {
            arwe.a("Danmaku_R2LWindow", new Object[] { "onClick:", localaruc, "[left:", Float.valueOf(localaruc.b()), ",top:", Float.valueOf(localaruc.c()), "]" });
          }
          return localaruc;
        }
      }
      i += 1;
    }
    arwe.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    arvb localarvb = arul.a();
    this.jdField_b_of_type_Int = localarvb.b();
    a(localarvb);
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
        aruc localaruc = (aruc)localIterator.next();
        localaruc.a(this.jdField_a_of_type_Arvq.c(), this.jdField_a_of_type_Arvq.a());
        if (!localaruc.c(this.jdField_a_of_type_Arvq.a())) {
          a(paramCanvas, localaruc);
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
      this.jdField_a_of_type_ArrayOfAruc[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aruc localaruc = (aruc)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localaruc);
      }
      i += 1;
    }
  }
  
  public void c(aruc paramaruc)
  {
    int j = a(paramaruc);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        aruc localaruc = (aruc)localIterator.next();
        j = i;
        if (localaruc == paramaruc) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localaruc.c();
          i = j;
        }
      }
    }
  }
  
  public void d(aruc paramaruc)
  {
    int i = a(paramaruc);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramaruc = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramaruc.hasNext()) {
        ((aruc)paramaruc.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arub
 * JD-Core Version:    0.7.0.1
 */