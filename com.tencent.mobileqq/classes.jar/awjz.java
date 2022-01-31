import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class awjz
{
  public int a;
  public CompressInfo a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  
  public awjz(PresendPicMgr paramPresendPicMgr, CompressInfo paramCompressInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public String a()
  {
    return "__" + UUID.randomUUID().toString();
  }
  
  public void a()
  {
    awiw.a("PresendPicMgr", "PresendReq.compressAndUploadPic", "call start,current PresendReq is " + this);
    long l = System.nanoTime();
    if (this.jdField_a_of_type_Boolean)
    {
      awiw.a("PresendPicMgr", "compressAndUploadPic ", "PresendStatus: srcPah:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c + ",destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + " ,canceled:true, peakCompress:false, peakUpload:false");
      return;
    }
    awkj.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
    awiw.a("PresendPicMgr", "compressAndUploadPic ", "PresendStatus: srcPah:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c + ",destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + ",canceled:false,peakCompress:true,peakUpload:false");
    l = (System.nanoTime() - l) / 1000000L;
    awiw.a("PresendPicMgr", "PresendReq.compressAndUploadPic", "Process peak,[#]compress, cost= " + l);
    b();
    awiw.a("PresendPicMgr", "PresendReq.compressAndUploadPic", "call end,current PresendReq is " + this);
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        awiw.a("PresendPicMgr", "PresendReq.cancel", "current PresendReq is " + this);
        this.jdField_a_of_type_Boolean = true;
        boolean bool = this.jdField_b_of_type_Boolean;
        if (bool) {
          try
          {
            awiw.a("PresendPicMgr", "PresendReq.cancel", "call cancelUpload");
            PresendPicMgr.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr).a(this.jdField_a_of_type_JavaLangString, paramInt);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
            continue;
          }
        }
        awiw.a("PresendPicMgr", "PresendReq.cancel", "mIsUpload is false,no need to call cancelUpload");
      }
      finally {}
    }
  }
  
  public void b()
  {
    try
    {
      awiw.a("PresendPicMgr", "PresendReq.uploadPic", "current PresendReq is " + this);
      if (this.jdField_a_of_type_Boolean) {
        awiw.a("PresendPicMgr", "uploadPic ", "PresendStatus: srcPah:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c + ",destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + " ,canceled:true, peakCompress:true, peakUpload:false");
      }
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString == null)
        {
          awiw.b("PresendPicMgr", "PresendReq.uploadPic", "mCompressInfo.destPath == null! ");
          continue;
        }
        try
        {
          PresendPicMgr.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgr).a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          this.jdField_b_of_type_Boolean = true;
          awiw.a("PresendPicMgr", "uploadPic ", "PresendStatus: srcPah:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c + ",destPath:" + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString + ",uuid:" + this.jdField_a_of_type_JavaLangString + " ,canceled:false, peakCompress:true, peakUpload:true");
          awiw.a("PresendPicMgr", "PresendReq.uploadPic", "call end");
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PresendPicMgr", 2, localRemoteException.getMessage(), localRemoteException);
            }
          }
        }
      }
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nPresendReq");
    localStringBuilder.append("\n|-").append("localUUID:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n|-").append("mIsCancel:").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n|-").append("mIsUpload:").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\n|-").append("mCompressInfo:").append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjz
 * JD-Core Version:    0.7.0.1
 */