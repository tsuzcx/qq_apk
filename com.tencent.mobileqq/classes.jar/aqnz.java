import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class aqnz
  extends aqno
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private aqoa[] jdField_a_of_type_ArrayOfAqoa;
  protected int b;
  private List<List<aqoa>> b;
  private int c;
  
  protected aqnz(aqoj paramaqoj, aqnp paramaqnp, Comparator<aqoa> paramComparator, aqpt paramaqpt, aqpo paramaqpo)
  {
    super(paramaqoj, paramaqnp, paramComparator, paramaqpt, paramaqpo);
  }
  
  private int a(aqoa paramaqoa)
  {
    if ((paramaqoa == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramaqoa.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(aqoa paramaqoa, int paramInt1, int paramInt2)
  {
    if (paramaqoa.e()) {
      this.jdField_a_of_type_Aqnp.a(paramaqoa, this.jdField_a_of_type_Aqoj);
    }
    paramaqoa.a(paramInt2, paramInt1, this.jdField_a_of_type_Aqpt.a(), this.jdField_a_of_type_Aqpo.a());
  }
  
  private void a(aqoz paramaqoz)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramaqoz.a()))
    {
      this.c = paramaqoz.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramaqoz = new aqoa[this.c];
      if (this.jdField_a_of_type_ArrayOfAqoa != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfAqoa, 0, paramaqoz, 0, Math.min(paramaqoz.length, this.jdField_a_of_type_ArrayOfAqoa.length));
      }
      this.jdField_a_of_type_ArrayOfAqoa = paramaqoz;
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
    int j = this.jdField_a_of_type_Aqoj.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramaqoz = ", ";; paramaqoz = "")
      {
        localStringBuilder2.append(paramaqoz);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    aqqb.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<aqoa>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aqoh localaqoh = (aqoh)localIterator.next();
        localaqoh.a();
        long l = this.jdField_a_of_type_Aqpo.a();
        int k = (int)localaqoh.b();
        b(localaqoh);
        localaqoh.c(l - (int)((localaqoh.f() - k) / -localaqoh.a()));
        localaqoh.h(paramArrayOfInt[i]);
        localaqoh.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(aqoa paramaqoa)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramaqoa))
      {
        aqqb.b("Danmaku_R2LWindow", new Object[] { paramaqoa, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = aqoj.a().e();
    if (aqqb.jdField_a_of_type_Int >= 5) {
      aqqb.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    aqoa localaqoa;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localaqoa = (aqoa)localIterator.next();
        localIterator.remove();
        if ((localaqoa.b(this.jdField_a_of_type_Aqpo.a())) || (localaqoa.a(this.jdField_a_of_type_Aqpt.a())) || (a(localaqoa)))
        {
          if (aqqb.jdField_a_of_type_Int >= 5) {
            aqqb.b("Danmaku_R2LWindow", new Object[] { localaqoa, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localaqoa);
        }
        else
        {
          if (!localaqoa.b()) {
            aqnx.a(this.jdField_a_of_type_Aqoj, localaqoa);
          }
          k = localaqoa.b(this.c);
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
            aqqb.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localaqoa);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localaqoa.a(this.c);
            break;
          }
          if (aqqb.jdField_a_of_type_Int >= 5)
          {
            aqqb.b("Danmaku_R2LWindow", new Object[] { localaqoa, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfAqoa[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfAqoa[i1])
              {
                aqqb.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfAqoa[m] == null)
          {
            this.jdField_a_of_type_ArrayOfAqoa[m] = localaqoa;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localaqoa);
            this.jdField_a_of_type_Int += 1;
            a(localaqoa, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (aqqb.jdField_a_of_type_Int >= 4) {
              aqqb.b("Danmaku_R2LWindow", new Object[] { localaqoa, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
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
        if (localaqoa.a(j))
        {
          this.jdField_a_of_type_ArrayOfAqoa[k] = localaqoa;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localaqoa);
          this.jdField_a_of_type_Int += 1;
          a(localaqoa, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (aqqb.jdField_a_of_type_Int >= 4) {
            aqqb.b("Danmaku_R2LWindow", new Object[] { localaqoa, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localaqoa.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localaqoa);
        if (aqqb.jdField_a_of_type_Int >= 4) {
          aqqb.b("Danmaku_R2LWindow", new Object[] { localaqoa, " can not in window" });
        }
      }
      if ((localaqoa.h()) && (m != 0)) {
        aqqb.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localaqoa);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfAqoa[m].a())
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
      i1 = aqqa.a(this.jdField_a_of_type_ArrayOfAqoa[m], localaqoa, this.jdField_a_of_type_Aqpo.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfAqoa[m] = localaqoa;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localaqoa);
          this.jdField_a_of_type_Int += 1;
          a(localaqoa, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (aqqb.jdField_a_of_type_Int >= 4) {
            aqqb.b("Danmaku_R2LWindow", new Object[] { localaqoa, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
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
        aqoa localaqoa = (aqoa)localIterator.next();
        if ((localaqoa.b(this.jdField_a_of_type_Aqpo.a())) || (!localaqoa.c()))
        {
          if (localaqoa == this.jdField_a_of_type_ArrayOfAqoa[i]) {
            this.jdField_a_of_type_ArrayOfAqoa[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localaqoa);
        }
      }
      i += 1;
    }
  }
  
  public aqoa a(aqpx paramaqpx)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aqoa localaqoa = (aqoa)localIterator.next();
        if ((localaqoa.d()) && (localaqoa.a(paramaqpx.jdField_a_of_type_AndroidGraphicsPoint.x, paramaqpx.jdField_a_of_type_AndroidGraphicsPoint.y, paramaqpx.jdField_a_of_type_Int, paramaqpx.jdField_a_of_type_Long)))
        {
          if (aqqb.jdField_a_of_type_Int >= 5) {
            aqqb.a("Danmaku_R2LWindow", new Object[] { "onClick:", localaqoa, "[left:", Float.valueOf(localaqoa.b()), ",top:", Float.valueOf(localaqoa.c()), "]" });
          }
          return localaqoa;
        }
      }
      i += 1;
    }
    aqqb.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    aqoz localaqoz = aqoj.a();
    this.jdField_b_of_type_Int = localaqoz.b();
    a(localaqoz);
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
        aqoa localaqoa = (aqoa)localIterator.next();
        localaqoa.a(this.jdField_a_of_type_Aqpo.c(), this.jdField_a_of_type_Aqpo.a());
        if (!localaqoa.c(this.jdField_a_of_type_Aqpo.a())) {
          a(paramCanvas, localaqoa);
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
      this.jdField_a_of_type_ArrayOfAqoa[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aqoa localaqoa = (aqoa)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localaqoa);
      }
      i += 1;
    }
  }
  
  public void c(aqoa paramaqoa)
  {
    int j = a(paramaqoa);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        aqoa localaqoa = (aqoa)localIterator.next();
        j = i;
        if (localaqoa == paramaqoa) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localaqoa.c();
          i = j;
        }
      }
    }
  }
  
  public void d(aqoa paramaqoa)
  {
    int i = a(paramaqoa);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramaqoa = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramaqoa.hasNext()) {
        ((aqoa)paramaqoa.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnz
 * JD-Core Version:    0.7.0.1
 */