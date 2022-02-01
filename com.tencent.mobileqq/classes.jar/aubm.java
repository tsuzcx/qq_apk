import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel.1.1;

public class aubm
  extends absc
{
  aubm(aubl paramaubl) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = aubl.a(this.a).a();
    if (localFileManagerEntity == null) {}
    while ((aubl.c(this.a) == null) || (paramSession.uSessionID != aubl.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    aubl.d(this.a).a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = aubl.b(this.a).a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((aubl.a(this.a) != null) && (paramSession.uSessionID == aubl.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        aubl.b(this.a).a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((aubl.e(this.a) == null) || (paramSession.uSessionID != aubl.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      aubl.f(this.a).f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      aubl.i(this.a).f();
      return;
    }
    aubl.j(this.a).g();
  }
  
  public void b(Session paramSession)
  {
    if ((aubl.a(this.a) != null) && (paramSession.uSessionID == aubl.a(this.a))) {
      aubl.b(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubm
 * JD-Core Version:    0.7.0.1
 */