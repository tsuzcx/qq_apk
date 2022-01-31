import com.tencent.ark.open.delegate.IArkDelegateSetup;
import java.util.ArrayList;

final class anrd
  extends IArkDelegateSetup
{
  public ArrayList<String> onGetPredownloadApp()
  {
    return null;
  }
  
  public void reportEvent(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    azpl.a(null, paramString1, paramString2, paramString3, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString4, paramString5);
  }
  
  public void setupArkEnvironment(boolean paramBoolean)
  {
    anqy.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrd
 * JD-Core Version:    0.7.0.1
 */