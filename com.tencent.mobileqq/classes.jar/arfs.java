import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel.1.1;

public class arfs
  extends zqp
{
  arfs(arfr paramarfr) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Ardq.a();
    if (localFileManagerEntity == null) {}
    while ((this.a.jdField_a_of_type_Argf == null) || (paramSession.uSessionID != arfr.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    this.a.jdField_a_of_type_Argf.a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Ardq.a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_Arge != null) && (paramSession.uSessionID == arfr.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        this.a.jdField_a_of_type_Arge.a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((this.a.jdField_a_of_type_Argf == null) || (paramSession.uSessionID != arfr.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      this.a.jdField_a_of_type_Argf.f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      this.a.jdField_a_of_type_Argf.f();
      return;
    }
    this.a.jdField_a_of_type_Argf.g();
  }
  
  public void b(Session paramSession)
  {
    if ((this.a.jdField_a_of_type_Argf != null) && (paramSession.uSessionID == arfr.a(this.a))) {
      this.a.jdField_a_of_type_Argf.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfs
 * JD-Core Version:    0.7.0.1
 */