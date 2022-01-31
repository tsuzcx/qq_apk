import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.util.List;
import mqq.os.MqqHandler;

public class aoal
  implements Runnable
{
  public aoal(FaceListPage paramFaceListPage) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject = FaceListPage.a(this.a);
    if (localObject == null) {}
    while (!(localObject instanceof NormalFacePackage)) {
      return;
    }
    NormalFacePackage localNormalFacePackage = (NormalFacePackage)localObject;
    if ((localNormalFacePackage.a != null) && (!localNormalFacePackage.a.isEmpty())) {
      SLog.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (!TextUtils.isEmpty(localNormalFacePackage.g)))
      {
        SLog.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
        localObject = localNormalFacePackage.a();
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new aoam(this, localNormalFacePackage, (List)localObject, bool1));
        return;
        bool1 = false;
        continue;
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoal
 * JD-Core Version:    0.7.0.1
 */