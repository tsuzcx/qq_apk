import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel.1.1;

public class aujw
  extends abib
{
  aujw(aujv paramaujv) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = aujv.a(this.a).a();
    if (localFileManagerEntity == null) {}
    while ((aujv.c(this.a) == null) || (paramSession.uSessionID != aujv.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    aujv.d(this.a).a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = aujv.b(this.a).a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((aujv.a(this.a) != null) && (paramSession.uSessionID == aujv.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        aujv.b(this.a).a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((aujv.e(this.a) == null) || (paramSession.uSessionID != aujv.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      aujv.f(this.a).f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      aujv.i(this.a).f();
      return;
    }
    aujv.j(this.a).g();
  }
  
  public void b(Session paramSession)
  {
    if ((aujv.a(this.a) != null) && (paramSession.uSessionID == aujv.a(this.a))) {
      aujv.b(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujw
 * JD-Core Version:    0.7.0.1
 */