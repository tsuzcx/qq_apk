import android.util.SparseArray;
import cooperation.qzone.util.QZLog;

public class bhht
  extends SparseArray<bhhu>
{
  private long a;
  private long b;
  private long c;
  
  public bhht(long paramLong)
  {
    this.a = paramLong;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    if (this.b + this.c > this.a) {
      if (!paramBoolean) {}
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramInt >= size()) {
          break label150;
        }
        i = paramInt;
        removeAt(i);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localIndexOutOfBoundsException.printStackTrace();
        if ((a()) || (size() <= 0)) {
          continue;
        }
        if (!paramBoolean) {
          break label139;
        }
        i = j;
        removeAt(i);
        QZLog.e("PieceCacheList", "trimToSize: IndexOutOfBoundsException temp " + (size() - (36 - paramInt)));
        return;
      }
      if (paramInt < size())
      {
        i = size() - 1;
      }
      else
      {
        i = size();
        i -= 36 - paramInt;
        continue;
        label139:
        i = size() - 1;
        continue;
        return;
        label150:
        i = 0;
      }
    }
  }
  
  public void a(int paramInt, bhhu parambhhu)
  {
    if (parambhhu != null)
    {
      super.put(paramInt, parambhhu);
      this.b += parambhhu.c();
    }
  }
  
  public void a(int paramInt, bhhu parambhhu, boolean paramBoolean)
  {
    if (parambhhu != null) {}
    try
    {
      if (this.c == 0L)
      {
        this.c = parambhhu.c();
        if (this.a < this.c * 8L) {
          this.a = (this.c * 8L);
        }
      }
      a(paramInt, paramBoolean);
      a(paramInt, parambhhu);
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    if (this.c == 0L) {}
    while (this.a > this.c * 8L) {
      return false;
    }
    return true;
  }
  
  public void clear()
  {
    super.clear();
    this.b = 0L;
  }
  
  public void remove(int paramInt)
  {
    bhhu localbhhu = (bhhu)get(paramInt);
    if (localbhhu != null) {
      localbhhu.b();
    }
    super.remove(paramInt);
    this.b -= this.c;
  }
  
  public void removeAt(int paramInt)
  {
    bhhu localbhhu = (bhhu)valueAt(paramInt);
    if (localbhhu != null) {
      localbhhu.b();
    }
    super.removeAt(paramInt);
    this.b -= this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhht
 * JD-Core Version:    0.7.0.1
 */