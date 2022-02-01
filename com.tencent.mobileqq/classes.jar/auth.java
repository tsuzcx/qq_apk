import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel.1.1;

public class auth
  extends abwg
{
  auth(autg paramautg) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = autg.a(this.a).a();
    if (localFileManagerEntity == null) {}
    while ((autg.c(this.a) == null) || (paramSession.uSessionID != autg.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    autg.d(this.a).a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = autg.b(this.a).a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((autg.a(this.a) != null) && (paramSession.uSessionID == autg.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        autg.b(this.a).a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((autg.e(this.a) == null) || (paramSession.uSessionID != autg.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      autg.f(this.a).f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      autg.i(this.a).f();
      return;
    }
    autg.j(this.a).g();
  }
  
  public void b(Session paramSession)
  {
    if ((autg.a(this.a) != null) && (paramSession.uSessionID == autg.a(this.a))) {
      autg.b(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auth
 * JD-Core Version:    0.7.0.1
 */