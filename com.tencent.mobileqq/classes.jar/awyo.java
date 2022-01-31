import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.voicechange.VoiceChange;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;

public class awyo
  implements awyr
{
  int jdField_a_of_type_Int;
  awyt jdField_a_of_type_Awyt;
  FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  String jdField_a_of_type_JavaLangString;
  public int b;
  
  public int a()
  {
    return this.b;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
      }
      if (this.jdField_a_of_type_Awyt != null)
      {
        this.jdField_a_of_type_Awyt.a();
        this.jdField_a_of_type_Awyt = null;
      }
      this.jdField_a_of_type_Int = 0;
      this.b = 0;
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("PttPreSendManager", 2, "PttPreVoiceChanger.close error");
    }
  }
  
  public void a(awyp paramawyp, awyq paramawyq)
  {
    if (((paramawyp instanceof SilkCodecWrapper)) || ((paramawyp instanceof AmrInputStreamWrapper))) {
      this.b += (int)QQRecorder.a(this.jdField_a_of_type_Int, 4, 2, paramawyq.jdField_a_of_type_Int);
    }
  }
  
  public boolean a(Context paramContext, String paramString1, int paramInt, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_Awyt = new awyt();
      if (paramInt != 0) {
        this.jdField_a_of_type_Awyt.a(new VoiceChange(paramContext, paramInt, paramString2));
      }
      if (paramRecorderParam.c == 0) {
        this.jdField_a_of_type_Awyt.a(new AmrInputStreamWrapper(paramContext));
      }
      for (;;)
      {
        this.jdField_a_of_type_Awyt.a(paramRecorderParam.jdField_a_of_type_Int, paramRecorderParam.b, paramRecorderParam.c);
        this.jdField_a_of_type_Int = paramRecorderParam.jdField_a_of_type_Int;
        this.jdField_a_of_type_Awyt.a(this);
        this.b = 0;
        this.jdField_a_of_type_JavaLangString = paramString1;
        paramContext = new File(this.jdField_a_of_type_JavaLangString);
        if (paramContext.exists()) {
          paramContext.delete();
        }
        paramContext.createNewFile();
        this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(paramContext);
        paramContext = bdml.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaIoFileOutputStream.write(paramContext, 0, paramContext.length);
        this.jdField_a_of_type_JavaIoFileOutputStream.flush();
        return true;
        this.jdField_a_of_type_Awyt.a(new SilkCodecWrapper(paramContext));
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Awyt != null)
      {
        paramArrayOfByte = this.jdField_a_of_type_Awyt.a(paramArrayOfByte, 0, paramInt);
        if (paramArrayOfByte != null) {
          this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.jdField_a_of_type_Int);
        }
      }
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isDevelopLevel()) {
        QLog.e("PttPreSendManager", 4, "handleSliceDataIfNeed exception !!!");
      }
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttPreSendManager", 2, "delete tempfile, path : " + this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public void b(awyp paramawyp, awyq paramawyq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awyo
 * JD-Core Version:    0.7.0.1
 */