import android.graphics.Paint;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awwm
{
  public int a;
  private awwo a;
  public ArrayList<awwo> a;
  @Deprecated
  public int b;
  public ArrayList<awwq> b;
  private int c;
  private int d;
  
  public awwm(int paramInt1, int paramInt2, ArrayList<awwo> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    return b(paramInt);
  }
  
  public List<awwo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Awwo = null;
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt)
  {
    a(paramPaint1, paramPaint2, paramInt, false, false);
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.c = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        awwo localawwo = (awwo)localIterator.next();
        localawwo.a(paramPaint1, paramPaint2, paramInt, paramBoolean1, paramBoolean2);
        this.c += localawwo.a();
        this.jdField_b_of_type_JavaUtilArrayList.addAll(localawwo.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(awwm paramawwm)
  {
    this.jdField_a_of_type_Int = paramawwm.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramawwm.jdField_b_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = paramawwm.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        awwo localawwo = (awwo)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localawwo.a());
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.c = paramawwm.b();
    Log.d("Lyric", "copy -> mType : " + this.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int b(int paramInt)
  {
    if (paramInt < 0)
    {
      Log.w("Lyric", "findLineNoByStartTime -> illegal time");
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      Log.w("Lyric", "findLineNoByStartTime -> lyric is empty");
      return -1;
    }
    if ((this.jdField_a_of_type_Awwo != null) && (this.jdField_a_of_type_Awwo.jdField_a_of_type_Long < paramInt) && (this.jdField_a_of_type_Awwo.jdField_a_of_type_Long + this.jdField_a_of_type_Awwo.b > paramInt)) {
      return this.d;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      awwo localawwo = (awwo)localArrayList.get(j);
      if (localawwo == null) {}
      while (localawwo.jdField_a_of_type_Long <= paramInt)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j == k) {}
      for (paramInt = k - 1;; paramInt = i)
      {
        this.d = paramInt;
        this.jdField_a_of_type_Awwo = ((awwo)localArrayList.get(paramInt));
        return paramInt;
      }
    }
  }
  
  public int c()
  {
    if (a()) {
      return 0;
    }
    awwo localawwo = (awwo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    long l = localawwo.jdField_a_of_type_Long;
    return (int)(localawwo.b + l);
  }
  
  public int c(int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      Log.w("Lyric", "findEndLineByStartTime -> illegal time");
      i = 0;
      return i;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null)
    {
      Log.w("Lyric", "findEndLineByStartTime -> sentence data not found");
      return -1;
    }
    int k = localArrayList.size();
    int j = 0;
    if (j < k)
    {
      awwo localawwo = (awwo)localArrayList.get(j);
      if (localawwo == null) {}
      while (paramInt > localawwo.jdField_a_of_type_Long)
      {
        j += 1;
        break;
      }
    }
    for (paramInt = j - 1;; paramInt = 0)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (j != k) {
        break;
      }
      return k - 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      awwo localawwo = (awwo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(localawwo.jdField_a_of_type_Long);
      localStringBuilder.append(":");
      localStringBuilder.append(localawwo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(":");
      localStringBuilder.append(localawwo.b + localawwo.jdField_a_of_type_Long);
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwm
 * JD-Core Version:    0.7.0.1
 */