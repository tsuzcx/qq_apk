import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel.1.1;

public class atfp
  extends aasp
{
  atfp(atfo paramatfo) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = atfo.a(this.a).a();
    if (localFileManagerEntity == null) {}
    while ((atfo.c(this.a) == null) || (paramSession.uSessionID != atfo.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    atfo.d(this.a).a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = atfo.b(this.a).a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((atfo.a(this.a) != null) && (paramSession.uSessionID == atfo.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        atfo.b(this.a).a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((atfo.e(this.a) == null) || (paramSession.uSessionID != atfo.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      atfo.f(this.a).f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      atfo.i(this.a).f();
      return;
    }
    atfo.j(this.a).g();
  }
  
  public void b(Session paramSession)
  {
    if ((atfo.a(this.a) != null) && (paramSession.uSessionID == atfo.a(this.a))) {
      atfo.b(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atfp
 * JD-Core Version:    0.7.0.1
 */