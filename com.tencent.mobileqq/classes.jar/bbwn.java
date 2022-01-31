import android.content.Context;
import java.util.Calendar;
import java.util.Date;

public class bbwn
  implements aoed
{
  private final int jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilCalendar.getMaximum(1);
  private long jdField_a_of_type_Long;
  private Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  private final int b = this.jdField_a_of_type_JavaUtilCalendar.getMinimum(1);
  private final int c;
  
  public bbwn()
  {
    this.jdField_a_of_type_JavaUtilCalendar.add(5, 1);
    this.jdField_a_of_type_JavaUtilCalendar.set(11, 8);
    this.jdField_a_of_type_JavaUtilCalendar.set(12, 0);
    this.jdField_a_of_type_JavaUtilCalendar.set(13, 0);
    this.jdField_a_of_type_JavaUtilCalendar.set(14, 0);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.b);
    localCalendar.set(5, 0);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
    this.c = ((int)((this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis() - this.jdField_a_of_type_Long) / 86400000L));
  }
  
  public static int a(bbwo parambbwo, int paramInt)
  {
    return paramInt;
  }
  
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 8);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis() / 1000L;
  }
  
  public static long a(bbwo parambbwo, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((parambbwo != null) && ((parambbwo.a() instanceof bbwn)))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(a(parambbwo, paramInt1));
      localCalendar.set(11, a(parambbwo, paramInt2));
      localCalendar.set(12, b(parambbwo, paramInt3));
      return localCalendar.getTimeInMillis();
    }
    return 0L;
  }
  
  public static bbwo a(Context paramContext)
  {
    bbwn localbbwn = new bbwn();
    paramContext = new bbwo(paramContext, localbbwn);
    a(paramContext, localbbwn);
    return paramContext;
  }
  
  public static Date a(bbwo parambbwo, int paramInt)
  {
    if ((parambbwo != null) && ((parambbwo.a() instanceof bbwn)))
    {
      parambbwo = (bbwn)parambbwo.a();
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(parambbwo.jdField_a_of_type_Long + 86400000L * paramInt);
      return localCalendar.getTime();
    }
    return null;
  }
  
  public static void a(bbwo parambbwo, bbwn parambbwn)
  {
    if ((parambbwo != null) && (parambbwn != null))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.add(5, 1);
      localCalendar.set(11, 8);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      parambbwo.a(0, parambbwn.c);
      parambbwo.a(1, localCalendar.get(11));
      parambbwo.a(2, localCalendar.get(12));
    }
  }
  
  public static int b(bbwo parambbwo, int paramInt)
  {
    return paramInt;
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.jdField_a_of_type_Int - this.b + 1;
    case 1: 
      return 24;
    }
    return 60;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.jdField_a_of_type_Long + 86400000L * paramInt2);
      paramInt1 = this.jdField_a_of_type_JavaUtilCalendar.get(1);
      paramInt2 = this.jdField_a_of_type_JavaUtilCalendar.get(2);
      int i = this.jdField_a_of_type_JavaUtilCalendar.get(5);
      localStringBuilder.append(paramInt1).append("年").append(String.valueOf(paramInt2 + 1)).append("月").append(i).append("日");
      continue;
      localStringBuilder.append(paramInt2);
      this.jdField_a_of_type_JavaUtilCalendar.set(11, paramInt2);
      continue;
      localStringBuilder.append(paramInt2);
      this.jdField_a_of_type_JavaUtilCalendar.set(12, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwn
 * JD-Core Version:    0.7.0.1
 */