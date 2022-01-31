import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.fts.FTSDatabase;

public class apri
  extends FTSDatabase
{
  public boolean a()
  {
    if ((Build.VERSION.SDK_INT < 18) && (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq"))) {
      akep.a = false;
    }
    boolean bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "FTSDatabaseV2");
    if (!bool) {
      akep.a = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apri
 * JD-Core Version:    0.7.0.1
 */