import android.graphics.Point;
import android.graphics.Rect;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class amoe
{
  public Rect a;
  public ArrayList<amoj> a;
  private boolean a;
  private Rect b;
  public ArrayList<Rect> b;
  public ArrayList<Rect> c = new ArrayList();
  public ArrayList<Rect> d = new ArrayList();
  public ArrayList<Rect> e = new ArrayList();
  public ArrayList<amoc> f = new ArrayList();
  public ArrayList<Rect> g = new ArrayList();
  
  public amoe()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
  }
  
  private Rect a()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      localObject = null;
    }
    Rect localRect;
    do
    {
      return localObject;
      Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new amof(this));
      localRect = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(amob.jdField_a_of_type_JavaUtilRandom.nextInt(Math.min(this.jdField_b_of_type_JavaUtilArrayList.size(), 3)));
      localObject = localRect;
    } while (!this.g.contains(localRect));
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localRect = (Rect)((Iterator)localObject).next();
      if (!this.g.contains(localRect)) {
        return localRect;
      }
    }
    return null;
  }
  
  private Rect a(amoj paramamoj, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramamoj.c;
    int i = j;
    if (paramamoj.jdField_a_of_type_Int >= 1) {
      i = Math.max(24, (int)(j * (0.95F - amob.jdField_a_of_type_JavaUtilRandom.nextInt(10) / 100.0F))) / 4 * 4;
    }
    Object localObject2 = null;
    j = 1;
    int n = 0;
    int m = i;
    Object localObject3 = localObject2;
    int k = j;
    Object localObject1;
    if (n < 10)
    {
      localObject3 = localObject2;
      k = j;
      if (m >= 24)
      {
        k = (int)(m * paramamoj.jdField_a_of_type_Float);
        localObject1 = localObject2;
        i = j;
        if (paramInt1 * paramInt2 >= m * k)
        {
          localObject3 = paramamoj.jdField_a_of_type_JavaUtilSet.iterator();
          i = j;
          localObject1 = localObject2;
          label142:
          if (((Iterator)localObject3).hasNext())
          {
            i = ((Integer)((Iterator)localObject3).next()).intValue();
            localObject1 = a(paramRect, paramInt1, paramInt2, k / i, m * i, paramInt3, paramInt4, m, 24);
            if (localObject1 == null) {
              break label214;
            }
          }
        }
        if (localObject1 != null) {
          paramRect = (Rect)localObject1;
        }
      }
    }
    for (;;)
    {
      if (paramRect == null)
      {
        return null;
        label214:
        break label142;
        localObject3 = localObject1;
        k = i;
        if (m <= 24) {
          break label324;
        }
        m = Math.max(24, (int)(m * (0.95F - amob.jdField_a_of_type_JavaUtilRandom.nextInt(6) / 100.0F))) / 4 * 4;
        n += 1;
        localObject2 = localObject1;
        j = i;
        break;
      }
      if ((paramRect != null) && (i > 0))
      {
        paramamoj = new amoc(paramamoj, -1, paramRect, m, true, i);
        a(paramamoj, paramRect);
        this.f.add(paramamoj);
        return paramRect;
      }
      return null;
      label324:
      paramRect = (Rect)localObject3;
      i = k;
    }
  }
  
  private Rect a(Rect paramRect)
  {
    boolean bool;
    int i;
    int j;
    int m;
    int k;
    label136:
    Object localObject;
    Rect localRect;
    if (this.jdField_a_of_type_Boolean)
    {
      bool = false;
      i = 0;
      j = 1;
      a(this.jdField_a_of_type_JavaUtilArrayList, bool);
      int n = this.jdField_a_of_type_AndroidGraphicsRect.width();
      int i1 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 2)
      {
        m = i1;
        k = n;
        if (this.f.size() < 1) {}
      }
      else
      {
        m = (int)(i1 * 0.85D);
        k = (int)(n * 0.85D);
      }
      m = Math.min(paramRect.width(), m);
      n = Math.min(paramRect.height(), k);
      if (this.jdField_a_of_type_Boolean)
      {
        k = amob.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_JavaUtilArrayList.size());
        if (k != 0)
        {
          localObject = (amoj)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          this.jdField_a_of_type_JavaUtilArrayList.set(0, this.jdField_a_of_type_JavaUtilArrayList.get(k));
          this.jdField_a_of_type_JavaUtilArrayList.set(k, localObject);
        }
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localRect = a((amoj)((Iterator)localObject).next(), paramRect, m, n, i, j);
        } while (localRect == null);
        return localRect;
      }
    }
    else if (!this.d.isEmpty())
    {
      localObject = this.d.iterator();
      j = -1;
      i = -1;
      label257:
      k = j;
      m = i;
      if (!((Iterator)localObject).hasNext()) {
        break label341;
      }
      localRect = (Rect)((Iterator)localObject).next();
      if (localRect.left == paramRect.right)
      {
        k = 1;
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break label257;
      if (localRect.top == paramRect.bottom)
      {
        i = j;
        j = 1;
        continue;
        k = -1;
        m = -1;
        label341:
        i = m;
        if (Math.abs(paramRect.top - this.jdField_a_of_type_AndroidGraphicsRect.top) > Math.abs(paramRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom)) {
          i = 1;
        }
        j = k;
        if (Math.abs(paramRect.left - this.jdField_a_of_type_AndroidGraphicsRect.left) > Math.abs(paramRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right)) {
          j = 1;
        }
        if (paramRect.width() < paramRect.height())
        {
          bool = true;
          k = i;
          i = j;
          j = k;
          break;
          k = amob.jdField_a_of_type_JavaUtilRandom.nextInt(Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), 3));
          break label136;
          return null;
        }
        bool = false;
        k = i;
        i = j;
        j = k;
        break;
      }
      k = i;
      i = j;
      j = k;
    }
  }
  
  private Rect a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt4 <= paramInt2) && (paramInt3 <= paramInt1)) {
      if (paramRect.width() - paramInt3 >= amob.jdField_a_of_type_Int + 8) {}
    }
    for (;;)
    {
      if (paramRect.height() - paramInt4 < amob.jdField_a_of_type_Int + 8) {}
      for (;;)
      {
        paramRect = new Rect(paramRect);
        if (paramInt6 == -1) {
          paramRect.bottom = (paramRect.top + paramInt2);
        }
        for (;;)
        {
          if (paramInt5 != -1) {
            break label575;
          }
          paramRect.right = (paramRect.left + paramInt1);
          return paramRect;
          this.jdField_b_of_type_AndroidGraphicsRect.set(paramRect);
          label118:
          Rect localRect;
          if (paramInt5 == -1)
          {
            this.jdField_b_of_type_AndroidGraphicsRect.left += paramInt3;
            if (!a(this.jdField_b_of_type_AndroidGraphicsRect, paramRect, paramInt8)) {
              break label252;
            }
            if (this.jdField_b_of_type_AndroidGraphicsRect.width() <= paramInt8 + 8) {
              break label630;
            }
            if (paramInt5 != -1) {
              break label254;
            }
            localRect = this.jdField_b_of_type_AndroidGraphicsRect;
            localRect.left += 8;
          }
          for (;;)
          {
            paramInt1 = paramInt3;
            if (a(this.jdField_b_of_type_AndroidGraphicsRect, paramRect, paramInt8)) {
              paramInt1 = paramInt3 + 8;
            }
            break;
            if (paramInt5 == 1)
            {
              this.jdField_b_of_type_AndroidGraphicsRect.right -= paramInt3;
              break label118;
            }
            this.jdField_b_of_type_AndroidGraphicsRect.right = (this.jdField_b_of_type_AndroidGraphicsRect.left + (this.jdField_b_of_type_AndroidGraphicsRect.width() - paramInt3) / 2);
            break label118;
            label252:
            break;
            label254:
            if (paramInt5 == 1)
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.right -= 8;
            }
            else
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.right -= 8;
            }
          }
          this.jdField_b_of_type_AndroidGraphicsRect.set(paramRect);
          if (paramInt6 == -1)
          {
            this.jdField_b_of_type_AndroidGraphicsRect.top += paramInt4;
            label335:
            if (!a(this.jdField_b_of_type_AndroidGraphicsRect, paramRect, paramInt8)) {
              break label474;
            }
            if (this.jdField_b_of_type_AndroidGraphicsRect.height() <= paramInt8 + 8) {
              break label624;
            }
            if (paramInt6 != -1) {
              break label476;
            }
            localRect = this.jdField_b_of_type_AndroidGraphicsRect;
            localRect.top += 8;
          }
          for (;;)
          {
            paramInt2 = paramInt4;
            if (a(this.jdField_b_of_type_AndroidGraphicsRect, paramRect, paramInt8)) {
              paramInt2 = paramInt4 + 8;
            }
            break;
            if (paramInt6 == 1)
            {
              this.jdField_b_of_type_AndroidGraphicsRect.bottom -= paramInt4;
              break label335;
            }
            this.jdField_b_of_type_AndroidGraphicsRect.bottom = (this.jdField_b_of_type_AndroidGraphicsRect.top + (this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_b_of_type_AndroidGraphicsRect.height()) / 2);
            break label335;
            label474:
            break;
            label476:
            if (paramInt6 == 1)
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.bottom -= 8;
            }
            else
            {
              localRect = this.jdField_b_of_type_AndroidGraphicsRect;
              localRect.bottom -= 8;
            }
          }
          if (paramInt6 == 1)
          {
            paramRect.top = (paramRect.bottom - paramInt2);
          }
          else
          {
            paramRect.top += (paramRect.height() - paramInt2) / 2;
            paramRect.bottom = (paramRect.top + paramInt2);
          }
        }
        label575:
        if (paramInt5 == 1)
        {
          paramRect.left = (paramRect.right - paramInt1);
          return paramRect;
        }
        paramRect.left += (paramRect.width() - paramInt1) / 2;
        paramRect.right = (paramRect.left + paramInt1);
        return paramRect;
        return null;
        label624:
        paramInt2 = paramInt4;
      }
      label630:
      paramInt1 = paramInt3;
    }
  }
  
  private Rect a(Rect paramRect, boolean paramBoolean)
  {
    int k = paramRect.width() * paramRect.height();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      amoc localamoc = (amoc)localIterator.next();
      int i = localamoc.jdField_a_of_type_AndroidGraphicsRect.width();
      int j = localamoc.jdField_a_of_type_AndroidGraphicsRect.height();
      if (((paramBoolean) || (k * 5 < i * j) || (k <= 576)) && (a(paramRect, localamoc.jdField_a_of_type_AndroidGraphicsRect)))
      {
        localamoc.jdField_a_of_type_AndroidGraphicsRect.union(paramRect);
        a(localamoc, localamoc.jdField_a_of_type_AndroidGraphicsRect);
        return paramRect;
      }
      if (paramBoolean)
      {
        Rect localRect = new Rect(paramRect);
        j = 0;
        if ((localRect.left <= localamoc.jdField_a_of_type_AndroidGraphicsRect.left) && (localRect.right >= localamoc.jdField_a_of_type_AndroidGraphicsRect.right))
        {
          localRect.left = localamoc.jdField_a_of_type_AndroidGraphicsRect.left;
          localRect.right = localamoc.jdField_a_of_type_AndroidGraphicsRect.right;
          i = 1;
        }
        while ((i != 0) && (a(localRect, localamoc.jdField_a_of_type_AndroidGraphicsRect)))
        {
          localamoc.jdField_a_of_type_AndroidGraphicsRect.union(localRect);
          a(localamoc, localamoc.jdField_a_of_type_AndroidGraphicsRect);
          return localRect;
          i = j;
          if (paramRect.top <= localamoc.jdField_a_of_type_AndroidGraphicsRect.top)
          {
            i = j;
            if (paramRect.bottom >= localamoc.jdField_a_of_type_AndroidGraphicsRect.bottom)
            {
              localRect.top = localamoc.jdField_a_of_type_AndroidGraphicsRect.top;
              localRect.bottom = localamoc.jdField_a_of_type_AndroidGraphicsRect.bottom;
              i = 1;
            }
          }
        }
      }
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.jdField_b_of_type_AndroidGraphicsRect.setEmpty();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(amoc paramamoc, Rect paramRect)
  {
    paramamoc.jdField_a_of_type_JavaUtilArrayList.clear();
    int i4 = paramamoc.e;
    int i5 = paramamoc.b;
    float f2 = paramamoc.jdField_a_of_type_Amoj.jdField_a_of_type_Float;
    int i3 = 0;
    int i;
    label75:
    int j;
    label97:
    int k;
    if (Math.abs(paramRect.left - this.jdField_a_of_type_AndroidGraphicsRect.left) <= 1)
    {
      m = 1;
      if (Math.abs(paramRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) > 1) {
        break label285;
      }
      i = 1;
      if (Math.abs(paramRect.top - this.jdField_a_of_type_AndroidGraphicsRect.top) > 1) {
        break label291;
      }
      j = 1;
      if (Math.abs(paramRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) > 1) {
        break label297;
      }
      k = 1;
    }
    label119:
    Object localObject1;
    Object localObject2;
    int n;
    int i1;
    int i2;
    for (;;)
    {
      if (!this.d.isEmpty())
      {
        localObject1 = this.d.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Rect)((Iterator)localObject1).next();
            n = i;
            if (Math.abs(((Rect)localObject2).left - paramRect.right) <= 1) {
              n = 1;
            }
            i1 = m;
            if (Math.abs(((Rect)localObject2).right - paramRect.left) <= 1) {
              i1 = 1;
            }
            i2 = k;
            if (Math.abs(((Rect)localObject2).top - paramRect.bottom) <= 1) {
              i2 = 1;
            }
            i = n;
            k = i2;
            m = i1;
            if (Math.abs(((Rect)localObject2).bottom - paramRect.top) <= 1)
            {
              j = 1;
              i = n;
              k = i2;
              m = i1;
              continue;
              m = 0;
              break;
              label285:
              i = 0;
              break label75;
              label291:
              j = 0;
              break label97;
              label297:
              k = 0;
              break label119;
            }
          }
        }
        n = m;
      }
    }
    for (int m = j;; m = j)
    {
      if ((n != 0) && (i != 0))
      {
        j = 1;
        n = 0;
      }
      for (;;)
      {
        if ((m != 0) && (k != 0))
        {
          k = 1;
          i1 = i3;
        }
        for (;;)
        {
          float f1 = 0.0F;
          i2 = paramamoc.jdField_a_of_type_Amoj.b / i4;
          f2 = paramRect.width() - i5 * f2 / i4;
          label393:
          label426:
          float f3;
          float f4;
          boolean bool;
          if (i2 <= 1)
          {
            i = (int)(f2 / 2.0F);
            j = i;
            f2 = paramRect.height() - i4 * i5;
            if (i4 > 1) {
              break label895;
            }
            k = (int)(f2 / 2.0F);
            m = k;
            f2 = 0.0F;
            f3 = Math.max(f1, 0.0F);
            i3 = Math.max(j, 0);
            Math.max(i, 0);
            f4 = Math.max(f2, 0.0F);
            i = Math.max(m, 0);
            Math.max(k, 0);
            bool = amob.jdField_a_of_type_JavaUtilRandom.nextBoolean();
            f1 = i + paramRect.top;
            i = 0;
          }
          for (;;)
          {
            if (i >= i4) {
              break label1032;
            }
            f2 = paramRect.left + i3;
            k = 0;
            label511:
            if (k < i2)
            {
              m = i * i2 + k;
              j = m;
              if (bool)
              {
                j = m;
                if (i2 == 2)
                {
                  j = m;
                  if (i4 > 2) {
                    if (k != 0) {
                      break label1000;
                    }
                  }
                }
              }
              for (j = i;; j = i4 + i)
              {
                localObject1 = (Pair)paramamoc.jdField_a_of_type_Amoj.jdField_a_of_type_JavaUtilArrayList.get(j);
                j = Math.round(f2);
                m = Math.round(f1);
                float f5 = i5;
                localObject2 = new amod(new Rect(j, m, Math.round(((Float)((Pair)localObject1).second).floatValue() * f5 + f2), Math.round(i5 + f1)), (String)((Pair)localObject1).first);
                paramamoc.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
                f5 = i5;
                float f6 = ((Float)((Pair)localObject1).second).floatValue();
                k += 1;
                f2 = f6 * f5 + f2 + f3;
                break label511;
                if ((n == 0) && (i == 0)) {
                  break label1055;
                }
                if (n != 0) {
                  i = -1;
                }
                for (;;)
                {
                  j = 0;
                  n = i;
                  break;
                  if (i != 0) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                }
                if ((m == 0) && (k == 0)) {
                  break label1045;
                }
                if (m != 0) {
                  i = -1;
                }
                for (;;)
                {
                  k = 0;
                  i1 = i;
                  break;
                  if (k != 0) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                }
                if (j != 0)
                {
                  i = 0;
                  f1 = (f2 - 0) / (i2 - 1);
                  j = 0;
                  break label393;
                }
                if (n == -1)
                {
                  j = 0;
                  f1 = (f2 - 0) / i2;
                  i = (int)f1;
                  break label393;
                }
                if (n == 1)
                {
                  i = 0;
                  f1 = (f2 - 0) / i2;
                  j = (int)f1;
                  break label393;
                }
                f1 = f2 / (i2 + 1);
                i = (int)f1;
                j = i;
                break label393;
                if (k != 0)
                {
                  k = 0;
                  f2 = (f2 - 0) / (i4 - 1);
                  m = 0;
                  break label426;
                }
                if (i1 == -1)
                {
                  m = 0;
                  f2 = (f2 - 0) / i4;
                  k = (int)f2;
                  break label426;
                }
                if (i1 == 1)
                {
                  k = 0;
                  f2 = (f2 - 0) / i4;
                  m = (int)f2;
                  break label426;
                }
                f2 /= (i4 + 1);
                k = (int)f2;
                m = k;
                break label426;
              }
            }
            label895:
            f2 = i5;
            label1000:
            i += 1;
            f1 = f2 + f1 + f4;
          }
          label1032:
          paramamoc.c = n;
          paramamoc.d = i1;
          return;
          label1045:
          k = 0;
          i1 = i3;
        }
        label1055:
        j = 0;
        n = 0;
      }
      n = m;
    }
  }
  
  private void a(Rect paramRect)
  {
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    Rect localRect1 = new Rect();
    i -= 1;
    while (i >= 0)
    {
      Rect localRect2 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      localRect1.set(paramRect);
      if (localRect1.intersect(localRect2)) {
        a(localRect2, localRect1, false);
      }
      i -= 1;
    }
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramRect1);
    if (paramBoolean) {
      this.e.add(paramRect2);
    }
    if (paramRect2.equals(paramRect1)) {
      return;
    }
    Point localPoint1 = new Point(paramRect1.left, paramRect1.top);
    Point localPoint2 = new Point(paramRect1.left, paramRect1.bottom);
    Point localPoint3 = new Point(paramRect1.right, paramRect1.top);
    Point localPoint4 = new Point(paramRect1.right, paramRect1.bottom);
    Point localPoint5 = new Point(paramRect2.left, paramRect2.top);
    Point localPoint6 = new Point(paramRect2.left, paramRect2.bottom);
    Point localPoint7 = new Point(paramRect2.right, paramRect2.top);
    Point localPoint8 = new Point(paramRect2.right, paramRect2.bottom);
    if ((localPoint1.equals(localPoint5)) && (localPoint2.equals(localPoint6)))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect2.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((localPoint1.equals(localPoint5)) && (localPoint3.equals(localPoint7)))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((localPoint4.equals(localPoint8)) && (localPoint3.equals(localPoint7)))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect2.bottom));
      return;
    }
    if ((localPoint2.equals(localPoint6)) && (localPoint4.equals(localPoint8)))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.right, paramRect2.top));
      return;
    }
    if (localPoint1.equals(localPoint5))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (localPoint3.equals(localPoint7))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (localPoint4.equals(localPoint8))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      return;
    }
    if (localPoint2.equals(localPoint6))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((paramRect1.left == paramRect2.left) && (paramRect1.right == paramRect2.right))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if ((paramRect1.top == paramRect2.top) && (paramRect1.bottom == paramRect2.bottom))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.left == paramRect2.left)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.top == paramRect2.top)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.right == paramRect2.right)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
      return;
    }
    if (paramRect1.bottom == paramRect2.bottom)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
      this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect1.right, paramRect2.top));
    this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect1.top, paramRect2.left, paramRect1.bottom));
    this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect2.right, paramRect1.top, paramRect1.right, paramRect1.bottom));
    this.jdField_b_of_type_JavaUtilArrayList.add(new Rect(paramRect1.left, paramRect2.bottom, paramRect1.right, paramRect1.bottom));
  }
  
  private void a(ArrayList<amoj> paramArrayList, boolean paramBoolean)
  {
    Collections.sort(paramArrayList, new amoi(this, paramBoolean, paramArrayList));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {}
    label21:
    label165:
    label172:
    label175:
    for (;;)
    {
      return;
      new Rect();
      int i = 0;
      Rect localRect1;
      Rect localRect2;
      if ((this.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (i < 100))
      {
        Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new amog(this));
        int k = this.jdField_b_of_type_JavaUtilArrayList.size();
        j = 0;
        localRect1 = null;
        localRect2 = null;
        label69:
        if (j >= k) {
          break label172;
        }
        localRect2 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(j);
        localRect1 = a(localRect2, paramBoolean);
        if (localRect1 == null) {
          break label165;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((j == 0) || (localRect2 == null) || (localRect1 == null)) {
          break label175;
        }
        if (localRect1.equals(localRect2)) {
          this.jdField_b_of_type_JavaUtilArrayList.remove(localRect2);
        }
        a(localRect1);
        b();
        this.c.add(localRect1);
        i += 1;
        break label21;
        break;
        j += 1;
        break label69;
      }
    }
  }
  
  private boolean a(amoj paramamoj, Rect paramRect, int paramInt)
  {
    Iterator localIterator = paramamoj.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((paramRect.width() + 8) * localInteger.intValue() >= paramamoj.jdField_a_of_type_Float * paramInt) && (paramRect.height() + 8 >= localInteger.intValue() * paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(Rect paramRect1, Rect paramRect2)
  {
    if ((paramRect1.contains(paramRect2)) || (paramRect2.contains(paramRect1))) {}
    while (((Math.abs(paramRect1.width() - paramRect2.width()) <= 2) && (Math.abs(paramRect1.left - paramRect2.left) <= 2) && (((paramRect1.top < paramRect2.top) && (paramRect1.bottom + 2 > paramRect2.top)) || ((paramRect2.top < paramRect1.top) && (paramRect2.bottom + 2 > paramRect1.top)))) || ((Math.abs(paramRect1.height() - paramRect2.height()) <= 2) && (Math.abs(paramRect1.top - paramRect2.top) <= 2) && (((paramRect1.left < paramRect2.left) && (paramRect1.right + 2 > paramRect2.left)) || ((paramRect2.left < paramRect1.left) && (2 + paramRect2.right > paramRect1.left))))) {
      return true;
    }
    return false;
  }
  
  private boolean a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((amoj)localIterator.next(), paramRect1, paramInt)) {
        return true;
      }
    }
    localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Rect localRect = (Rect)localIterator.next();
      if ((localRect != paramRect2) && (a(localRect, paramRect1))) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 1) {
      return;
    }
    int i = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    Rect localRect1 = null;
    label24:
    Rect localRect2;
    if (i >= 0)
    {
      localRect2 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      j = i - 1;
      label45:
      if (j < 0) {
        break label138;
      }
      localRect1 = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(j);
      if (!a(localRect2, localRect1)) {
        break label100;
      }
    }
    label138:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localRect1.union(localRect2);
        this.jdField_b_of_type_JavaUtilArrayList.remove(localRect2);
      }
      for (;;)
      {
        i -= 1;
        break label24;
        break;
        label100:
        j -= 1;
        break label45;
        if ((localRect2.width() <= 1) || (localRect2.height() <= 1)) {
          this.jdField_b_of_type_JavaUtilArrayList.remove(localRect2);
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    int i2 = 0;
    new Rect();
    label22:
    Object localObject2;
    int i;
    Object localObject1;
    int j;
    int k;
    Rect localRect;
    int m;
    int n;
    Object localObject3;
    int i1;
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (i2 < 200))
    {
      Collections.sort(this.jdField_b_of_type_JavaUtilArrayList, new amoh(this));
      int i4 = this.jdField_b_of_type_JavaUtilArrayList.size();
      localObject2 = null;
      i = 0;
      localObject1 = null;
      j = -1;
      k = amob.jdField_a_of_type_Int;
      int i3 = 0;
      while (i3 < i4)
      {
        localRect = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(i3);
        m = k;
        n = j;
        localObject3 = localObject1;
        i1 = i;
        if (localRect.width() >= amob.jdField_a_of_type_Int)
        {
          if (localRect.height() < amob.jdField_a_of_type_Int)
          {
            i1 = i;
            localObject3 = localObject1;
            n = j;
            m = k;
          }
        }
        else
        {
          label159:
          i3 += 1;
          localObject2 = localRect;
          k = m;
          j = n;
          localObject1 = localObject3;
          i = i1;
          continue;
        }
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator1.hasNext())
        {
          localObject3 = (amoj)localIterator1.next();
          Iterator localIterator2 = ((amoj)localObject3).jdField_a_of_type_JavaUtilSet.iterator();
          i1 = i;
          localObject2 = localObject1;
          n = j;
          m = k;
          label247:
          k = m;
          j = n;
          localObject1 = localObject2;
          i = i1;
          if (localIterator2.hasNext())
          {
            localObject1 = (Integer)localIterator2.next();
            if ((localRect.width() * ((Integer)localObject1).intValue() < ((amoj)localObject3).jdField_a_of_type_Float * amob.jdField_a_of_type_Int) || (localRect.height() < amob.jdField_a_of_type_Int * ((Integer)localObject1).intValue())) {
              break label639;
            }
            float f1 = ((amoj)localObject3).jdField_a_of_type_Float / ((Integer)localObject1).intValue();
            float f2 = ((Integer)localObject1).intValue();
            float f3 = Math.min(localRect.width() / f1, localRect.height() / f2) / 4.0F * 4.0F;
            float f4 = localRect.width();
            float f5 = localRect.height();
            float f6 = localRect.height();
            if ((localRect.width() - f1 * f3) * f6 + (f5 - f2 * f3) * f4 >= 2.147484E+009F) {
              break label639;
            }
            i = (int)f3;
            j = ((Integer)localObject1).intValue();
            k = 1;
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      m = i;
      n = j;
      localObject2 = localObject1;
      i1 = k;
      break label247;
      m = k;
      n = j;
      localObject3 = localObject1;
      i1 = i;
      if (i == 0) {
        break label159;
      }
      localObject2 = localRect;
      for (;;)
      {
        if ((i == 0) || (localObject2 == null) || (j <= 0) || (localObject1 == null)) {
          break label637;
        }
        this.jdField_b_of_type_JavaUtilArrayList.remove(localObject2);
        localRect = a(localObject2, localObject2.width(), localObject2.height(), (int)(k * ((amoj)localObject1).jdField_a_of_type_Float / j), k * j, -1, -1, k, amob.jdField_a_of_type_Int);
        if (localRect == null) {
          break;
        }
        a(localObject2, localRect, true);
        localObject1 = new amoc((amoj)localObject1, -1, localRect, k, false, j);
        a((amoc)localObject1, localRect);
        this.f.add(localObject1);
        a(localRect);
        b();
        i2 += 1;
        break label22;
        break;
      }
      label637:
      break;
      label639:
      i = m;
      j = n;
      localObject1 = localObject2;
      k = i1;
    }
  }
  
  public ArrayList<amoc> a(ArrayList<amoj> paramArrayList, Rect paramRect, ArrayList<Rect> paramArrayList1)
  {
    a();
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramRect == null)) {
      return this.f;
    }
    System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
    if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty())) {
      this.d.addAll(paramArrayList1);
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidGraphicsRect);
      if (i != 0)
      {
        paramArrayList = this.d.iterator();
        while (paramArrayList.hasNext())
        {
          paramRect = (Rect)paramArrayList.next();
          a(this.jdField_a_of_type_AndroidGraphicsRect, paramRect, true);
          a(paramRect);
          b();
        }
        this.jdField_a_of_type_Boolean = true;
        paramArrayList = (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        paramRect = a(paramArrayList);
        if (paramRect != null)
        {
          a(paramArrayList, paramRect, true);
          a(paramRect);
          b();
        }
        this.jdField_a_of_type_Boolean = false;
      }
      i = 0;
      int j = 0;
      if ((this.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (j < 200) && (i < 100))
      {
        j += 1;
        paramArrayList = a();
        if (paramArrayList != null) {}
      }
      else
      {
        a(false);
        amob.jdField_a_of_type_Int = 12;
        paramArrayList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        i = 1;
        label249:
        if (!paramArrayList.hasNext()) {
          break label341;
        }
        paramRect = (amoj)paramArrayList.next();
        paramRect.a();
        if (paramRect.b == 13) {
          break label365;
        }
        i = 0;
      }
      label341:
      label365:
      for (;;)
      {
        break label249;
        paramRect = a(paramArrayList);
        if (paramRect == null)
        {
          i += 1;
          this.g.add(paramArrayList);
          break;
        }
        this.g.clear();
        a(paramArrayList, paramRect, true);
        a(paramRect);
        b();
        break;
        if (i != 0) {
          amob.jdField_a_of_type_Int = 8;
        }
        c();
        a(true);
        return this.f;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amoe
 * JD-Core Version:    0.7.0.1
 */