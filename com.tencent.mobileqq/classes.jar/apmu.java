import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel.1.1;

public class apmu
  extends ybw
{
  apmu(apmt paramapmt) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Apkt.a();
    if (localFileManagerEntity == null) {}
    while ((this.a.jdField_a_of_type_Apnf == null) || (paramSession.uSessionID != apmt.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    this.a.jdField_a_of_type_Apnf.a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Apkt.a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_Apne != null) && (paramSession.uSessionID == apmt.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        this.a.jdField_a_of_type_Apne.a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((this.a.jdField_a_of_type_Apnf == null) || (paramSession.uSessionID != apmt.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      this.a.jdField_a_of_type_Apnf.f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      this.a.jdField_a_of_type_Apnf.f();
      return;
    }
    this.a.jdField_a_of_type_Apnf.g();
  }
  
  public void b(Session paramSession)
  {
    if ((this.a.jdField_a_of_type_Apnf != null) && (paramSession.uSessionID == apmt.a(this.a))) {
      this.a.jdField_a_of_type_Apnf.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmu
 * JD-Core Version:    0.7.0.1
 */