import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class ampn
  extends ampc
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private ampo[] jdField_a_of_type_ArrayOfAmpo;
  protected int b;
  private List<List<ampo>> b;
  private int c;
  
  protected ampn(ampx paramampx, ampd paramampd, Comparator<ampo> paramComparator, amrh paramamrh, amrc paramamrc)
  {
    super(paramampx, paramampd, paramComparator, paramamrh, paramamrc);
  }
  
  private int a(ampo paramampo)
  {
    if ((paramampo == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramampo.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(ampo paramampo, int paramInt1, int paramInt2)
  {
    if (paramampo.e()) {
      this.jdField_a_of_type_Ampd.a(paramampo, this.jdField_a_of_type_Ampx);
    }
    paramampo.a(paramInt2, paramInt1, this.jdField_a_of_type_Amrh.a(), this.jdField_a_of_type_Amrc.a());
  }
  
  private void a(amqn paramamqn)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramamqn.a()))
    {
      this.c = paramamqn.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramamqn = new ampo[this.c];
      if (this.jdField_a_of_type_ArrayOfAmpo != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfAmpo, 0, paramamqn, 0, Math.min(paramamqn.length, this.jdField_a_of_type_ArrayOfAmpo.length));
      }
      this.jdField_a_of_type_ArrayOfAmpo = paramamqn;
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
    int j = this.jdField_a_of_type_Ampx.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramamqn = ", ";; paramamqn = "")
      {
        localStringBuilder2.append(paramamqn);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    amrq.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<ampo>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        ampv localampv = (ampv)localIterator.next();
        localampv.a();
        long l = this.jdField_a_of_type_Amrc.a();
        int k = (int)localampv.b();
        b(localampv);
        localampv.c(l - (int)((localampv.f() - k) / -localampv.a()));
        localampv.h(paramArrayOfInt[i]);
        localampv.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(ampo paramampo)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramampo))
      {
        amrq.b("Danmaku_R2LWindow", new Object[] { paramampo, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = ampx.a().e();
    if (amrq.jdField_a_of_type_Int >= 5) {
      amrq.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    ampo localampo;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localampo = (ampo)localIterator.next();
        localIterator.remove();
        if ((localampo.b(this.jdField_a_of_type_Amrc.a())) || (localampo.a(this.jdField_a_of_type_Amrh.a())) || (a(localampo)))
        {
          if (amrq.jdField_a_of_type_Int >= 5) {
            amrq.b("Danmaku_R2LWindow", new Object[] { localampo, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localampo);
        }
        else
        {
          if (!localampo.b()) {
            ampl.a(this.jdField_a_of_type_Ampx, localampo);
          }
          k = localampo.b(this.c);
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
            amrq.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localampo);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localampo.a(this.c);
            break;
          }
          if (amrq.jdField_a_of_type_Int >= 5)
          {
            amrq.b("Danmaku_R2LWindow", new Object[] { localampo, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfAmpo[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfAmpo[i1])
              {
                amrq.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfAmpo[m] == null)
          {
            this.jdField_a_of_type_ArrayOfAmpo[m] = localampo;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localampo);
            this.jdField_a_of_type_Int += 1;
            a(localampo, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (amrq.jdField_a_of_type_Int >= 4) {
              amrq.b("Danmaku_R2LWindow", new Object[] { localampo, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
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
        if (localampo.a(j))
        {
          this.jdField_a_of_type_ArrayOfAmpo[k] = localampo;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localampo);
          this.jdField_a_of_type_Int += 1;
          a(localampo, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (amrq.jdField_a_of_type_Int >= 4) {
            amrq.b("Danmaku_R2LWindow", new Object[] { localampo, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localampo.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localampo);
        if (amrq.jdField_a_of_type_Int >= 4) {
          amrq.b("Danmaku_R2LWindow", new Object[] { localampo, " can not in window" });
        }
      }
      if ((localampo.h()) && (m != 0)) {
        amrq.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localampo);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfAmpo[m].a())
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
      i1 = amro.a(this.jdField_a_of_type_ArrayOfAmpo[m], localampo, this.jdField_a_of_type_Amrc.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfAmpo[m] = localampo;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localampo);
          this.jdField_a_of_type_Int += 1;
          a(localampo, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (amrq.jdField_a_of_type_Int >= 4) {
            amrq.b("Danmaku_R2LWindow", new Object[] { localampo, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
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
        ampo localampo = (ampo)localIterator.next();
        if ((localampo.b(this.jdField_a_of_type_Amrc.a())) || (!localampo.c()))
        {
          if (localampo == this.jdField_a_of_type_ArrayOfAmpo[i]) {
            this.jdField_a_of_type_ArrayOfAmpo[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localampo);
        }
      }
      i += 1;
    }
  }
  
  public ampo a(amrl paramamrl)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        ampo localampo = (ampo)localIterator.next();
        if ((localampo.d()) && (localampo.a(paramamrl.jdField_a_of_type_AndroidGraphicsPoint.x, paramamrl.jdField_a_of_type_AndroidGraphicsPoint.y, paramamrl.jdField_a_of_type_Int, paramamrl.jdField_a_of_type_Long)))
        {
          if (amrq.jdField_a_of_type_Int >= 5) {
            amrq.a("Danmaku_R2LWindow", new Object[] { "onClick:", localampo, "[left:", Float.valueOf(localampo.b()), ",top:", Float.valueOf(localampo.c()), "]" });
          }
          return localampo;
        }
      }
      i += 1;
    }
    amrq.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    amqn localamqn = ampx.a();
    this.jdField_b_of_type_Int = localamqn.b();
    a(localamqn);
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
        ampo localampo = (ampo)localIterator.next();
        localampo.a(this.jdField_a_of_type_Amrc.c(), this.jdField_a_of_type_Amrc.a());
        if (!localampo.c(this.jdField_a_of_type_Amrc.a())) {
          a(paramCanvas, localampo);
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
      this.jdField_a_of_type_ArrayOfAmpo[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        ampo localampo = (ampo)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localampo);
      }
      i += 1;
    }
  }
  
  public void c(ampo paramampo)
  {
    int j = a(paramampo);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        ampo localampo = (ampo)localIterator.next();
        j = i;
        if (localampo == paramampo) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localampo.c();
          i = j;
        }
      }
    }
  }
  
  public void d(ampo paramampo)
  {
    int i = a(paramampo);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramampo = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramampo.hasNext()) {
        ((ampo)paramampo.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ampn
 * JD-Core Version:    0.7.0.1
 */