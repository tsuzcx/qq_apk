import cooperation.qzone.mobilereport.MobileReportManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopnick/shop/widget/ReportHelper;", "", "()V", "report", "", "moduleId", "", "itemId", "itemType", "actionId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhtm
{
  public static final bhtm a = new bhtm();
  
  @JvmStatic
  public static final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    MobileReportManager.getInstance().reportAction("DressVip", "3001146", String.valueOf(paramInt1), "", String.valueOf(paramInt2), String.valueOf(paramInt3), paramInt4, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtm
 * JD-Core Version:    0.7.0.1
 */