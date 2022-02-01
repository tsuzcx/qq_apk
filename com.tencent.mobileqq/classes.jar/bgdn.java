import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import java.util.Vector;

class bgdn
  extends VasQuickUpdateManager.CallBacker
{
  bgdn(bgdk parambgdk) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if (paramLong == 27L)
    {
      paramInt2 = Integer.parseInt(paramString1.substring("groupnickitem.".length(), paramString1.length()));
      bgdk.a(this.a).removeElement(Integer.valueOf(paramInt2));
      if (paramInt1 == 0) {
        this.a.a(paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdn
 * JD-Core Version:    0.7.0.1
 */