import android.graphics.Canvas;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class arem
  extends areb
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private aren[] jdField_a_of_type_ArrayOfAren;
  protected int b;
  private List<List<aren>> b;
  private int c;
  
  protected arem(arew paramarew, arec paramarec, Comparator<aren> paramComparator, argg paramargg, argb paramargb)
  {
    super(paramarew, paramarec, paramComparator, paramargg, paramargb);
  }
  
  private int a(aren paramaren)
  {
    if ((paramaren == null) || (this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_JavaUtilList == null)) {}
    int j;
    do
    {
      return -1;
      int i = 0;
      j = -1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramaren.c() == this.jdField_a_of_type_ArrayOfInt[i]) {
          j = i;
        }
        i += 1;
      }
    } while (this.jdField_b_of_type_JavaUtilList.size() <= j);
    return j;
  }
  
  private void a(aren paramaren, int paramInt1, int paramInt2)
  {
    if (paramaren.e()) {
      this.jdField_a_of_type_Arec.a(paramaren, this.jdField_a_of_type_Arew);
    }
    paramaren.a(paramInt2, paramInt1, this.jdField_a_of_type_Argg.a(), this.jdField_a_of_type_Argb.a());
  }
  
  private void a(arfm paramarfm)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.c != paramarfm.a()))
    {
      this.c = paramarfm.a();
      this.jdField_a_of_type_ArrayOfInt = new int[this.c];
      paramarfm = new aren[this.c];
      if (this.jdField_a_of_type_ArrayOfAren != null) {
        System.arraycopy(this.jdField_a_of_type_ArrayOfAren, 0, paramarfm, 0, Math.min(paramarfm.length, this.jdField_a_of_type_ArrayOfAren.length));
      }
      this.jdField_a_of_type_ArrayOfAren = paramarfm;
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
    int j = this.jdField_a_of_type_Arew.a();
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    int i = 0;
    if (i < this.c)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = (i * j + this.jdField_b_of_type_Int);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(this.jdField_a_of_type_ArrayOfInt[i]);
      if (i != this.c - 1) {}
      for (paramarfm = ", ";; paramarfm = "")
      {
        localStringBuilder2.append(paramarfm);
        i += 1;
        break;
      }
    }
    localStringBuilder1.append("]");
    argp.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(j), localStringBuilder1 });
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ArrayOfInt);
  }
  
  private void a(List<List<aren>> paramList, int[] paramArrayOfInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        areu localareu = (areu)localIterator.next();
        localareu.a();
        long l = this.jdField_a_of_type_Argb.a();
        int k = (int)localareu.b();
        b(localareu);
        localareu.c(l - (int)((localareu.f() - k) / -localareu.a()));
        localareu.h(paramArrayOfInt[i]);
        localareu.g(k);
      }
      i += 1;
    }
  }
  
  private boolean a(aren paramaren)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramaren))
      {
        argp.b("Danmaku_R2LWindow", new Object[] { paramaren, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    int i2 = arew.a().e();
    if (argp.jdField_a_of_type_Int >= 5) {
      argp.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilTreeSet.size()) });
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilTreeSet.iterator();
    int i = 0;
    aren localaren;
    int k;
    int j;
    int m;
    label252:
    int i1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localaren = (aren)localIterator.next();
        localIterator.remove();
        if ((localaren.b(this.jdField_a_of_type_Argb.a())) || (localaren.a(this.jdField_a_of_type_Argg.a())) || (a(localaren)))
        {
          if (argp.jdField_a_of_type_Int >= 5) {
            argp.b("Danmaku_R2LWindow", new Object[] { localaren, " is out side" });
          }
          this.jdField_a_of_type_JavaUtilList.add(localaren);
        }
        else
        {
          if (!localaren.b()) {
            arek.a(this.jdField_a_of_type_Arew, localaren);
          }
          k = localaren.b(this.c);
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
            argp.c("Danmaku_R2LWindow", "startLayout, startLine = " + j + ", maxLine = " + n + ", danmaku = " + localaren);
            k = j;
            j = m;
            if (k >= n) {
              break label1016;
            }
            m = k;
            while (m >= this.c) {
              m -= this.c;
            }
            j = localaren.a(this.c);
            break;
          }
          if (argp.jdField_a_of_type_Int >= 5)
          {
            argp.b("Danmaku_R2LWindow", new Object[] { localaren, " try layout" });
            i1 = 0;
            if (i1 < this.c)
            {
              StringBuilder localStringBuilder = new StringBuilder().append("row ").append(i1);
              if (this.jdField_a_of_type_ArrayOfAren[i1] == null) {}
              for (Object localObject = " null";; localObject = this.jdField_a_of_type_ArrayOfAren[i1])
              {
                argp.b("Danmaku_R2LWindow", localObject);
                i1 += 1;
                break;
              }
            }
          }
          if (this.jdField_a_of_type_ArrayOfAren[m] == null)
          {
            this.jdField_a_of_type_ArrayOfAren[m] = localaren;
            ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localaren);
            this.jdField_a_of_type_Int += 1;
            a(localaren, this.jdField_a_of_type_ArrayOfInt[m], i2);
            if (argp.jdField_a_of_type_Int >= 4) {
              argp.b("Danmaku_R2LWindow", new Object[] { localaren, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[m]) });
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
        if (localaren.a(j))
        {
          this.jdField_a_of_type_ArrayOfAren[k] = localaren;
          ((List)this.jdField_b_of_type_JavaUtilList.get(k)).add(localaren);
          this.jdField_a_of_type_Int += 1;
          a(localaren, this.jdField_a_of_type_ArrayOfInt[k], i2);
          if (argp.jdField_a_of_type_Int >= 4) {
            argp.b("Danmaku_R2LWindow", new Object[] { localaren, " layout success:", Integer.valueOf(k), ",top:", this.jdField_a_of_type_ArrayOfInt[k] + ", danmakuRepeatTime = " + localaren.e() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(localaren);
        if (argp.jdField_a_of_type_Int >= 4) {
          argp.b("Danmaku_R2LWindow", new Object[] { localaren, " can not in window" });
        }
      }
      if ((localaren.h()) && (m != 0)) {
        argp.b("Danmaku_R2LWindow", "must show danmaku layout success :" + localaren);
      }
      i = k;
      break;
      if (this.jdField_a_of_type_ArrayOfAren[m].a())
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
      i1 = argn.a(this.jdField_a_of_type_ArrayOfAren[m], localaren, this.jdField_a_of_type_Argb.a());
      if (i1 < j) {
        j = m;
      }
      for (i = i1;; i = i1)
      {
        if (i < 0)
        {
          this.jdField_a_of_type_ArrayOfAren[m] = localaren;
          ((List)this.jdField_b_of_type_JavaUtilList.get(m)).add(localaren);
          this.jdField_a_of_type_Int += 1;
          a(localaren, this.jdField_a_of_type_ArrayOfInt[m], i2);
          if (argp.jdField_a_of_type_Int >= 4) {
            argp.b("Danmaku_R2LWindow", new Object[] { localaren, " layout success:", Integer.valueOf(m), ",top:", this.jdField_a_of_type_ArrayOfInt[m] + ", hitTime = " + i });
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
        aren localaren = (aren)localIterator.next();
        if ((localaren.b(this.jdField_a_of_type_Argb.a())) || (!localaren.c()))
        {
          if (localaren == this.jdField_a_of_type_ArrayOfAren[i]) {
            this.jdField_a_of_type_ArrayOfAren[i] = null;
          }
          localIterator.remove();
          this.jdField_a_of_type_Int -= 1;
          this.jdField_a_of_type_JavaUtilList.add(localaren);
        }
      }
      i += 1;
    }
  }
  
  public aren a(argk paramargk)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aren localaren = (aren)localIterator.next();
        if ((localaren.d()) && (localaren.a(paramargk.jdField_a_of_type_AndroidGraphicsPoint.x, paramargk.jdField_a_of_type_AndroidGraphicsPoint.y, paramargk.jdField_a_of_type_Int, paramargk.jdField_a_of_type_Long)))
        {
          if (argp.jdField_a_of_type_Int >= 5) {
            argp.a("Danmaku_R2LWindow", new Object[] { "onClick:", localaren, "[left:", Float.valueOf(localaren.b()), ",top:", Float.valueOf(localaren.c()), "]" });
          }
          return localaren;
        }
      }
      i += 1;
    }
    argp.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    arfm localarfm = arew.a();
    this.jdField_b_of_type_Int = localarfm.b();
    a(localarfm);
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
        aren localaren = (aren)localIterator.next();
        localaren.a(this.jdField_a_of_type_Argb.c(), this.jdField_a_of_type_Argb.a());
        if (!localaren.c(this.jdField_a_of_type_Argb.a())) {
          a(paramCanvas, localaren);
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
      this.jdField_a_of_type_ArrayOfAren[i] = null;
      i += 1;
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        aren localaren = (aren)localIterator.next();
        localIterator.remove();
        this.jdField_a_of_type_Int -= 1;
        this.jdField_a_of_type_JavaUtilList.add(localaren);
      }
      i += 1;
    }
  }
  
  public void c(aren paramaren)
  {
    int j = a(paramaren);
    if (j < 0) {}
    for (;;)
    {
      return;
      int i = 0;
      Iterator localIterator = ((List)this.jdField_b_of_type_JavaUtilList.get(j)).iterator();
      while (localIterator.hasNext())
      {
        aren localaren = (aren)localIterator.next();
        j = i;
        if (localaren == paramaren) {
          j = 1;
        }
        i = j;
        if (j != 0)
        {
          localaren.c();
          i = j;
        }
      }
    }
  }
  
  public void d(aren paramaren)
  {
    int i = a(paramaren);
    if (i < 0) {}
    for (;;)
    {
      return;
      paramaren = ((List)this.jdField_b_of_type_JavaUtilList.get(i)).iterator();
      while (paramaren.hasNext()) {
        ((aren)paramaren.next()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arem
 * JD-Core Version:    0.7.0.1
 */