import com.tencent.mobileqq.app.QQAppInterface;

public class bdcf
{
  public static final int[] a = { 1, 2, 3, 4 };
  
  public static final int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a.length)) {
      return a[paramInt];
    }
    return -1;
  }
  
  public static final String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "BUSID_INTIMATE_ANNIVERSARY";
    case 1: 
      return "BUSID_BASE_PROFILE";
    case 2: 
      return "BUSID_NICE_PICS";
    }
    return "BUSID_NEWFRD_MINI_CARD";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    bcef.b(paramQQAppInterface, "dc00898", "", paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, paramInt, 0, "0", "0", "", "");
  }
  
  public static final int b(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcf
 * JD-Core Version:    0.7.0.1
 */