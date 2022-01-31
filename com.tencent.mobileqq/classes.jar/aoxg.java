import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class aoxg
  extends aowv
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private aoxh[] jdField_a_of_type_ArrayOfAoxh;
  protected int b;
  private List<List<aoxh>> b;
  private int c;
  
  protected aoxg(aoxq paramaoxq, aoww paramaoww, Comparator<aoxh> paramComparator, aoza paramaoza, aoyv paramaoyv)
  {
    super(paramaoxq, paramaoww, paramComparator, paramaoza, paramaoyv);
  }
  
  private int a(aoxh paramaoxh)
  {
    if ((paramaoxh == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramaoxh.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(aoxh paramaoxh, int paramInt1, int paramInt2)
  {
    if (paramaoxh.e()) {
      this.jdField_a_of_type_Aoww.a(paramaoxh, this.jdField_a_of_type_Aoxq);
    }
    paramaoxh.a(paramInt2, paramInt1, this.jdField_a_of_type_Aoza.a(), this.jdField_a_of_type_Aoyv.a());
  }
  
  private void a(aoyg paramaoyg)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramaoyg.a()))
    {
      this.c = paramaoyg.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramaoyg = new aoxh[this.c];
      if (this.jdField_a_of_type_ArrayOfAoxh != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfAoxh, 0, paramaoyg, 0, Math.min(paramaoyg.length, this.jdField_a_of_type_ArrayOfAoxh.length));
      }
      this.jdField_a_of_type_ArrayOfAoxh = paramaoyg;
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
    int j = this.jdField_a_of_type_Aoxq.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramaoyg = ", ";; paramaoyg = "")
      {
        localStringBuilder2.append(paramaoyg);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    aozj.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<aoxh>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aoxo localaoxo = (aoxo)localIterator.next();
        localaoxo.a();
        long l = this.jdField_a_of_type_Aoyv.a();
        int k = (int)localaoxo.b();
        b(localaoxo);
        localaoxo.c(l - (int)((localaoxo.f() - k) / -localaoxo.a()));
        localaoxo.h(paramArrayOfInt[i]);
        localaoxo.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(aoxh paramaoxh)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramaoxh))
      {
        aozj.b("Danmaku_R2LWindow", new Object[] { paramaoxh, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = aoxq.a().e();
    if (aozj.jdField_a_of_type_Int >= 5) {
      aozj.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    aoxh localaoxh;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localaoxh = (aoxh)localIterator.next();
        localIterator.remove();
        if ((localaoxh.b(this.jdField_a_of_type_Aoyv.a())) || (localaoxh.a(this.jdField_a_of_type_Aoza.a())) || (a(localaoxh)))
        {
          if (aozj.jdField_a_of_type_Int >= 5) {
            aozj.b("Danmaku_R2LWindow", new Object[] { localaoxh, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localaoxh);
        }
        else
        {
          if (!localaoxh.b()) {
            aoxe.a(this.jdField_a_of_type_Aoxq, localaoxh);
          }
          k = localaoxh.b(this.c);
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
            aozj.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localaoxh);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localaoxh.a(this.c);
            break;
          }
          if (aozj.jdField_a_of_type_Int >= 5)
          {
            aozj.b("Danmaku_R2LWindow", new Object[] { localaoxh, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfAoxh[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfAoxh[i1])
              {
                aozj.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfAoxh[m] == null)
          {
            this.jdField_a_of_type_ArrayOfAoxh[m] = localaoxh;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localaoxh);
            this.jdField_a_of_type_Int += 1;
            a(localaoxh, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (aozj.jdField_a_of_type_Int >= 4) {
              aozj.b("Danmaku_R2LWindow", new Object[] { localaoxh, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
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
        if (localaoxh.a(j))
        {
          this.jdField_a_of_type_ArrayOfAoxh[k] = localaoxh;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localaoxh);
          this.jdField_a_of_type_Int += 1;
          a(localaoxh, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (aozj.jdField_a_of_type_Int >= 4) {
            aozj.b("Danmaku_R2LWindow", new Object[] { localaoxh, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localaoxh.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localaoxh);
        if (aozj.jdField_a_of_type_Int >= 4) {
          aozj.b("Danmaku_R2LWindow", new Object[] { localaoxh, " can not in window" });
        }
      }
      if ((localaoxh.h()) && (m != 0)) {
        aozj.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localaoxh);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfAoxh[m].a())
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
      i1 = aozh.a(this.jdField_a_of_type_ArrayOfAoxh[m], localaoxh, this.jdField_a_of_type_Aoyv.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfAoxh[m] = localaoxh;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localaoxh);
          this.jdField_a_of_type_Int += 1;
          a(localaoxh, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (aozj.jdField_a_of_type_Int >= 4) {
            aozj.b("Danmaku_R2LWindow", new Object[] { localaoxh, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
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
        aoxh localaoxh = (aoxh)localIterator.next();
        if ((localaoxh.b(this.jdField_a_of_type_Aoyv.a())) || (!localaoxh.c()))
        {
          if (localaoxh == this.jdField_a_of_type_ArrayOfAoxh[i]) {
            this.jdField_a_of_type_ArrayOfAoxh[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localaoxh);
        }
      }
      i += 1;
    }
  }
  
  public aoxh a(aoze paramaoze)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aoxh localaoxh = (aoxh)localIterator.next();
        if ((localaoxh.d()) && (localaoxh.a(paramaoze.jdField_a_of_type_AndroidGraphicsPoint.x, paramaoze.jdField_a_of_type_AndroidGraphicsPoint.y, paramaoze.jdField_a_of_type_Int, paramaoze.jdField_a_of_type_Long)))
        {
          if (aozj.jdField_a_of_type_Int >= 5) {
            aozj.a("Danmaku_R2LWindow", new Object[] { "onClick:", localaoxh, "[left:", Float.valueOf(localaoxh.b()), ",top:", Float.valueOf(localaoxh.c()), "]" });
          }
          return localaoxh;
        }
      }
      i += 1;
    }
    aozj.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    aoyg localaoyg = aoxq.a();
    this.jdField_b_of_type_Int = localaoyg.b();
    a(localaoyg);
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
        aoxh localaoxh = (aoxh)localIterator.next();
        localaoxh.a(this.jdField_a_of_type_Aoyv.c(), this.jdField_a_of_type_Aoyv.a());
        if (!localaoxh.c(this.jdField_a_of_type_Aoyv.a())) {
          a(paramCanvas, localaoxh);
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
      this.jdField_a_of_type_ArrayOfAoxh[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aoxh localaoxh = (aoxh)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localaoxh);
      }
      i += 1;
    }
  }
  
  public void c(aoxh paramaoxh)
  {
    int j = a(paramaoxh);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        aoxh localaoxh = (aoxh)localIterator.next();
        j = i;
        if (localaoxh == paramaoxh) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localaoxh.c();
          i = j;
        }
      }
    }
  }
  
  public void d(aoxh paramaoxh)
  {
    int i = a(paramaoxh);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramaoxh = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramaoxh.hasNext()) {
        ((aoxh)paramaoxh.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxg
 * JD-Core Version:    0.7.0.1
 */