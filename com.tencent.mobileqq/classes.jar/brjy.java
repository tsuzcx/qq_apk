import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class brjy
{
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("AudioDataCache", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("AudioDataCache", 2, "[@] " + paramString);
  }
  
  public String a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    a("closeCache: path=" + this.b, null);
    String str = this.jdField_a_of_type_JavaLangString + this.b;
    if ((this.jdField_a_of_type_JavaIoFileOutputStream == null) || (paramRMVideoStateMgr != null)) {}
    try
    {
      paramRMVideoStateMgr.c();
      this.jdField_a_of_type_JavaIoFileOutputStream.close();
    }
    catch (IOException paramRMVideoStateMgr)
    {
      label74:
      break label74;
    }
    this.jdField_a_of_type_JavaIoFileOutputStream = null;
    this.b = null;
    return str;
  }
  
  public void a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    File localFile;
    try
    {
      a("initCache: oldpath=" + this.b + " mOutStream=" + this.jdField_a_of_type_JavaIoFileOutputStream, null);
      a(paramRMVideoStateMgr);
      this.b = brkv.a();
      paramRMVideoStateMgr = this.jdField_a_of_type_JavaLangString + this.b;
      localFile = new File(paramRMVideoStateMgr);
      if (localFile.exists()) {
        throw new RuntimeException("AudioDataCache: file exists| " + paramRMVideoStateMgr);
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
      a("initCache: newPath=" + this.b, null);
      return;
    }
    catch (FileNotFoundException paramRMVideoStateMgr)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
      }
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      bool = true;
      return bool;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      a("writeData: exp=", paramArrayOfByte);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brjy
 * JD-Core Version:    0.7.0.1
 */