import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class arrk
  extends arqz
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private arrl[] jdField_a_of_type_ArrayOfArrl;
  protected int b;
  private List<List<arrl>> b;
  private int c;
  
  protected arrk(arru paramarru, arra paramarra, Comparator<arrl> paramComparator, arte paramarte, arsz paramarsz)
  {
    super(paramarru, paramarra, paramComparator, paramarte, paramarsz);
  }
  
  private int a(arrl paramarrl)
  {
    if ((paramarrl == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramarrl.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(arrl paramarrl, int paramInt1, int paramInt2)
  {
    if (paramarrl.e()) {
      this.jdField_a_of_type_Arra.a(paramarrl, this.jdField_a_of_type_Arru);
    }
    paramarrl.a(paramInt2, paramInt1, this.jdField_a_of_type_Arte.a(), this.jdField_a_of_type_Arsz.a());
  }
  
  private void a(arsk paramarsk)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramarsk.a()))
    {
      this.c = paramarsk.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramarsk = new arrl[this.c];
      if (this.jdField_a_of_type_ArrayOfArrl != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfArrl, 0, paramarsk, 0, Math.min(paramarsk.length, this.jdField_a_of_type_ArrayOfArrl.length));
      }
      this.jdField_a_of_type_ArrayOfArrl = paramarsk;
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
    int j = this.jdField_a_of_type_Arru.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramarsk = ", ";; paramarsk = "")
      {
        localStringBuilder2.append(paramarsk);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    artm.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<arrl>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        arrs localarrs = (arrs)localIterator.next();
        localarrs.a();
        long l = this.jdField_a_of_type_Arsz.a();
        int k = (int)localarrs.b();
        b(localarrs);
        localarrs.c(l - (int)((localarrs.f() - k) / -localarrs.a()));
        localarrs.h(paramArrayOfInt[i]);
        localarrs.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(arrl paramarrl)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramarrl))
      {
        artm.b("Danmaku_R2LWindow", new Object[] { paramarrl, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = arru.a().e();
    if (artm.jdField_a_of_type_Int >= 5) {
      artm.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    arrl localarrl;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localarrl = (arrl)localIterator.next();
        localIterator.remove();
        if ((localarrl.b(this.jdField_a_of_type_Arsz.a())) || (localarrl.a(this.jdField_a_of_type_Arte.a())) || (a(localarrl)))
        {
          if (artm.jdField_a_of_type_Int >= 5) {
            artm.b("Danmaku_R2LWindow", new Object[] { localarrl, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localarrl);
        }
        else
        {
          if (!localarrl.b()) {
            arri.a(this.jdField_a_of_type_Arru, localarrl);
          }
          k = localarrl.b(this.c);
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
            artm.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localarrl);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localarrl.a(this.c);
            break;
          }
          if (artm.jdField_a_of_type_Int >= 5)
          {
            artm.b("Danmaku_R2LWindow", new Object[] { localarrl, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfArrl[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfArrl[i1])
              {
                artm.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfArrl[m] == null)
          {
            this.jdField_a_of_type_ArrayOfArrl[m] = localarrl;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localarrl);
            this.jdField_a_of_type_Int += 1;
            a(localarrl, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (artm.jdField_a_of_type_Int >= 4) {
              artm.b("Danmaku_R2LWindow", new Object[] { localarrl, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
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
        if (localarrl.a(j))
        {
          this.jdField_a_of_type_ArrayOfArrl[k] = localarrl;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localarrl);
          this.jdField_a_of_type_Int += 1;
          a(localarrl, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (artm.jdField_a_of_type_Int >= 4) {
            artm.b("Danmaku_R2LWindow", new Object[] { localarrl, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localarrl.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localarrl);
        if (artm.jdField_a_of_type_Int >= 4) {
          artm.b("Danmaku_R2LWindow", new Object[] { localarrl, " can not in window" });
        }
      }
      if ((localarrl.h()) && (m != 0)) {
        artm.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localarrl);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfArrl[m].a())
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
      i1 = artl.a(this.jdField_a_of_type_ArrayOfArrl[m], localarrl, this.jdField_a_of_type_Arsz.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfArrl[m] = localarrl;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localarrl);
          this.jdField_a_of_type_Int += 1;
          a(localarrl, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (artm.jdField_a_of_type_Int >= 4) {
            artm.b("Danmaku_R2LWindow", new Object[] { localarrl, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
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
        arrl localarrl = (arrl)localIterator.next();
        if ((localarrl.b(this.jdField_a_of_type_Arsz.a())) || (!localarrl.c()))
        {
          if (localarrl == this.jdField_a_of_type_ArrayOfArrl[i]) {
            this.jdField_a_of_type_ArrayOfArrl[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localarrl);
        }
      }
      i += 1;
    }
  }
  
  public arrl a(arti paramarti)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        arrl localarrl = (arrl)localIterator.next();
        if ((localarrl.d()) && (localarrl.a(paramarti.jdField_a_of_type_AndroidGraphicsPoint.x, paramarti.jdField_a_of_type_AndroidGraphicsPoint.y, paramarti.jdField_a_of_type_Int, paramarti.jdField_a_of_type_Long)))
        {
          if (artm.jdField_a_of_type_Int >= 5) {
            artm.a("Danmaku_R2LWindow", new Object[] { "onClick:", localarrl, "[left:", Float.valueOf(localarrl.b()), ",top:", Float.valueOf(localarrl.c()), "]" });
          }
          return localarrl;
        }
      }
      i += 1;
    }
    artm.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    arsk localarsk = arru.a();
    this.jdField_b_of_type_Int = localarsk.b();
    a(localarsk);
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
        arrl localarrl = (arrl)localIterator.next();
        localarrl.a(this.jdField_a_of_type_Arsz.c(), this.jdField_a_of_type_Arsz.a());
        if (!localarrl.c(this.jdField_a_of_type_Arsz.a())) {
          a(paramCanvas, localarrl);
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
      this.jdField_a_of_type_ArrayOfArrl[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        arrl localarrl = (arrl)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localarrl);
      }
      i += 1;
    }
  }
  
  public void c(arrl paramarrl)
  {
    int j = a(paramarrl);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        arrl localarrl = (arrl)localIterator.next();
        j = i;
        if (localarrl == paramarrl) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localarrl.c();
          i = j;
        }
      }
    }
  }
  
  public void d(arrl paramarrl)
  {
    int i = a(paramarrl);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramarrl = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramarrl.hasNext()) {
        ((arrl)paramarrl.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrk
 * JD-Core Version:    0.7.0.1
 */