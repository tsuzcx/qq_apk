import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;

public class aune
{
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = ayui.a(paramInt2);
    return ayui.a(ayui.b(paramInt1), ayui.c(paramInt3), str, "L");
  }
  
  public static void a(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof aunh))
    {
      paramObject = (aunh)paramObject;
      ayui.c(paramObject.b, true, 1, paramObject.a, paramString1, paramString2);
      return;
    }
    if ((paramObject instanceof MessageForPic))
    {
      paramObject = (MessageForPic)paramObject;
      ayui.c(paramObject.istroop, true, 1, paramObject.localUUID, paramString1, paramString2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step:").append(paramString1);
    localStringBuilder.append("    \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.L." + paramObject, 2, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramString4, 1);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramInt == 1) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" \tstep:");
        localStringBuilder.append(paramString3);
        localStringBuilder.append(" \tcont:");
        localStringBuilder.append(paramString4);
        QLog.d(paramString1, 2, localStringBuilder.toString());
      }
    }
    while (paramInt != 2) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" \tstep:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" \tcont:");
    localStringBuilder.append(paramString4);
    QLog.e(paramString1, 1, localStringBuilder.toString());
  }
  
  public static void b(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof aunh))
    {
      paramObject = (aunh)paramObject;
      ayui.b(paramObject.b, true, 1, paramObject.a, paramString1, paramString2, null);
      return;
    }
    if ((paramObject instanceof MessageForPic))
    {
      paramObject = (MessageForPic)paramObject;
      ayui.b(paramObject.istroop, true, 1, paramObject.localUUID, paramString1, paramString2, null);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step:").append(paramString1);
    localStringBuilder.append("    \tcontent:").append(paramString2);
    QLog.e("Q.richmedia.L." + paramObject, 2, localStringBuilder.toString());
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramString4, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aune
 * JD-Core Version:    0.7.0.1
 */