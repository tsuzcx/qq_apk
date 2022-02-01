import com.tencent.TMG.utils.QLog;

public class bbcz
{
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueReporter", 0, String.format("reportFriendClueExpose source=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    bdla.b(null, "dc00898", "", "", "0X800B6B6", "0X800B6B6", paramInt, 0, "", "", "", "");
  }
  
  public static void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueReporter", 0, String.format("reportFriendClueClick source=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    bdla.b(null, "dc00898", "", "", "0X800B6B7", "0X800B6B7", paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcz
 * JD-Core Version:    0.7.0.1
 */