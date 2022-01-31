import android.os.Handler;
import android.os.Looper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.DeviceFileModel.1.1;

public class apmq
  extends ybz
{
  apmq(apmp paramapmp) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Apkp.a();
    if (localFileManagerEntity == null) {}
    while ((this.a.jdField_a_of_type_Apnb == null) || (paramSession.uSessionID != apmp.a(this.a))) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    this.a.jdField_a_of_type_Apnb.a(paramFloat);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    FileManagerEntity localFileManagerEntity = this.a.jdField_a_of_type_Apkp.a();
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_Apna != null) && (paramSession.uSessionID == apmp.b(this.a)) && (paramBoolean))
      {
        localFileManagerEntity.strThumbPath = paramSession.strFilePathSrc;
        this.a.jdField_a_of_type_Apna.a(String.valueOf(localFileManagerEntity.nSessionId), paramSession.strFilePathSrc);
      }
    } while ((this.a.jdField_a_of_type_Apnb == null) || (paramSession.uSessionID != apmp.a(this.a)));
    if (paramBoolean)
    {
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
      this.a.jdField_a_of_type_Apnb.f();
      if (this.a.e() == 2)
      {
        new Handler(Looper.getMainLooper()).postDelayed(new DeviceFileModel.1.1(this), 1000L);
        return;
      }
      this.a.jdField_a_of_type_Apnb.f();
      return;
    }
    this.a.jdField_a_of_type_Apnb.g();
  }
  
  public void b(Session paramSession)
  {
    if ((this.a.jdField_a_of_type_Apnb != null) && (paramSession.uSessionID == apmp.a(this.a))) {
      this.a.jdField_a_of_type_Apnb.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmq
 * JD-Core Version:    0.7.0.1
 */