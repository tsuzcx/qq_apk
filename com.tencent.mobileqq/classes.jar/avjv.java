import android.graphics.Paint;
import java.util.ArrayList;

public class avjv
{
  public long a;
  public avjw a;
  public String a;
  public ArrayList<avjx> a;
  public long b;
  public avjw b;
  public ArrayList<avjs> b;
  
  public avjv()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Avjw = new avjw();
    this.jdField_b_of_type_Avjw = new avjw();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public avjv a()
  {
    avjv localavjv = new avjv();
    localavjv.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localavjv.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    localavjv.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localavjv.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      localavjv.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    }
    localavjv.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    return localavjv;
  }
  
  public ArrayList<avjx> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int k = (int)paramPaint1.measureText(this.jdField_a_of_type_JavaLangString);
    int m = (int)paramPaint2.measureText(this.jdField_a_of_type_JavaLangString);
    int j = 0;
    int i = 0;
    if (k <= paramInt) {
      if (paramBoolean2)
      {
        paramInt = j;
        paramPaint1 = new avjx(this.jdField_a_of_type_JavaLangString, paramInt, i, m, k, this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramPaint1);
      }
    }
    String[] arrayOfString;
    int i6;
    do
    {
      return;
      i = paramInt - (int)paramPaint2.measureText(this.jdField_a_of_type_JavaLangString) >> 1;
      j = paramInt - k >> 1;
      paramInt = i;
      i = j;
      break;
      if (paramBoolean1)
      {
        paramPaint1 = new avjx(this.jdField_a_of_type_JavaLangString, 0, 0, m, k, this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramPaint1);
        return;
      }
      arrayOfString = avju.a(this.jdField_a_of_type_JavaLangString, paramPaint1, paramInt, paramInt);
      i6 = arrayOfString.length;
    } while (i6 <= 0);
    int n = 0;
    j = 0;
    i = 0;
    int i3 = 0;
    int i1 = 0;
    int i2 = 0;
    m = 0;
    k = 0;
    label198:
    label210:
    Object localObject;
    int i4;
    avjs localavjs;
    if (i3 < i6)
    {
      if (!paramBoolean2) {
        break label481;
      }
      localObject = null;
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        break label705;
      }
      n += arrayOfString[i3].length();
      localObject = new ArrayList();
      i4 = m;
      m = j;
      j = k;
      k = i4;
      if (m >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
        break label678;
      }
      localavjs = (avjs)this.jdField_b_of_type_JavaUtilArrayList.get(m);
      if ((i3 == 0) || (i != m)) {
        break label663;
      }
      k = n - arrayOfString[i3].length();
      i4 = localavjs.jdField_a_of_type_Int;
      j = k;
      k = i4 - k;
      label327:
      if ((localavjs.jdField_a_of_type_Int > n) || (localavjs.jdField_b_of_type_Int < n)) {
        break label573;
      }
      if (i3 != 0) {
        break label520;
      }
      ((ArrayList)localObject).add(new avjs(localavjs.jdField_a_of_type_Long, localavjs.jdField_b_of_type_Long, localavjs.jdField_a_of_type_Int, arrayOfString[i3].length()));
      label388:
      m += 1;
      i4 = m;
      i = n;
      n = k;
      k = i4;
    }
    for (;;)
    {
      localObject = new avjx(arrayOfString[i3], i1, i2, (ArrayList)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      int i5 = i3 + 1;
      i3 = k;
      i4 = m;
      m = j;
      k = n;
      j = i4;
      n = i;
      i = i3;
      i3 = i5;
      break label198;
      break;
      label481:
      i1 = (int)paramPaint2.measureText(arrayOfString[i3]);
      i2 = paramInt - (int)paramPaint1.measureText(arrayOfString[i3]) >> 1;
      i1 = paramInt - i1 >> 1;
      break label210;
      label520:
      i = localavjs.jdField_a_of_type_Int;
      i4 = arrayOfString[i3].length();
      ((ArrayList)localObject).add(new avjs(localavjs.jdField_a_of_type_Long, localavjs.jdField_b_of_type_Long, i - j - k, i4));
      break label388;
      label573:
      if (i3 == 0) {
        ((ArrayList)localObject).add(localavjs);
      }
      for (;;)
      {
        i4 = k;
        m += 1;
        k = j;
        j = i4;
        break;
        i4 = localavjs.jdField_a_of_type_Int;
        i5 = localavjs.jdField_b_of_type_Int;
        ((ArrayList)localObject).add(new avjs(localavjs.jdField_a_of_type_Long, localavjs.jdField_b_of_type_Long, i4 - j - k, i5 - j - k));
      }
      label663:
      i4 = j;
      j = k;
      k = i4;
      break label327;
      label678:
      i4 = k;
      i5 = j;
      k = i;
      i = n;
      j = i4;
      n = i5;
      continue;
      label705:
      i4 = k;
      i5 = j;
      k = i;
      i = n;
      j = m;
      n = i4;
      m = i5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjv
 * JD-Core Version:    0.7.0.1
 */