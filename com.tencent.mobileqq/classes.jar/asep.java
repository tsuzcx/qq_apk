import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.fts.FTSDatabase;

public class asep
  extends FTSDatabase
{
  public boolean a()
  {
    if ((Build.VERSION.SDK_INT < 18) && (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq"))) {
      amjf.a = false;
    }
    boolean bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "FTSDatabaseV2");
    if (!bool) {
      amjf.a = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asep
 * JD-Core Version:    0.7.0.1
 */