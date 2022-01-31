import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel.1.1;

public class arkb
  extends zve
{
  arkb(arka paramarka) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity == null) {}
    while ((this.a.jdField_a_of_type_Arko == null) || (paramSession.uSessionID != arka.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    this.a.jdField_a_of_type_Arko.a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_Arkn != null) && (paramSession.uSessionID == arka.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        this.a.jdField_a_of_type_Arkn.a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((this.a.jdField_a_of_type_Arko == null) || (paramSession.uSessionID != arka.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      this.a.jdField_a_of_type_Arko.f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      this.a.jdField_a_of_type_Arko.f();
      return;
    }
    this.a.jdField_a_of_type_Arko.g();
  }
  
  public void b(Session paramSession)
  {
    if ((this.a.jdField_a_of_type_Arko != null) && (paramSession.uSessionID == arka.a(this.a))) {
      this.a.jdField_a_of_type_Arko.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkb
 * JD-Core Version:    0.7.0.1
 */