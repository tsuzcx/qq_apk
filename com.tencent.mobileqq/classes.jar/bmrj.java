import android.os.Build.VERSION;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bmrj
  implements bcmt
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int b;
  
  bmrj(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    if (paramInt2 > 0) {}
    for (this.jdField_b_of_type_Int = paramInt2;; this.jdField_b_of_type_Int = 30)
    {
      this.jdField_a_of_type_JavaLangThrowable = null;
      if (paramString != null) {
        break;
      }
      throw new IllegalArgumentException("null == outputFilePath");
    }
  }
  
  public bcmu a(int paramInt1, int paramInt2)
  {
    int i = 0;
    bcmu localbcmu = new bcmu();
    int k;
    Object localObject;
    if (paramInt1 <= paramInt2)
    {
      k = paramInt2;
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localbcmu.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.lvcc.name(), "640|640|384|768|30");
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label431;
      }
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 4)) {
        break label431;
      }
    }
    label431:
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localObject[1]).intValue();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        paramInt1 = 0;
        paramInt2 = 0;
        i = 0;
      }
      try
      {
        paramInt2 = Integer.valueOf(localObject[2]).intValue();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          label344:
          int n;
          paramInt1 = 0;
          paramInt2 = 0;
        }
      }
      try
      {
        paramInt1 = Integer.valueOf(localObject[3]).intValue();
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        paramInt1 = 0;
        break label344;
      }
      try
      {
        m = Integer.valueOf(localObject[4]).intValue();
        j = i;
        i = paramInt2;
        paramInt2 = m;
        m = j;
        if (j <= 0) {
          m = 640;
        }
        j = i;
        if (i <= 0) {
          j = 384;
        }
        i = paramInt1;
        if (paramInt1 <= 0) {
          i = 768;
        }
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          paramInt1 = 30;
        }
        localbcmu.jdField_a_of_type_Float = (m / k);
        localbcmu.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * localbcmu.jdField_a_of_type_Float * localbcmu.jdField_a_of_type_Float + 0.5F));
        if (localbcmu.jdField_a_of_type_Int <= i * 1024) {
          break label382;
        }
        localbcmu.jdField_a_of_type_Int = (i * 1024);
        paramInt2 = paramInt1;
        if (this.jdField_b_of_type_Int <= paramInt1) {
          paramInt2 = this.jdField_b_of_type_Int;
        }
        localbcmu.jdField_b_of_type_Int = paramInt2;
        localbcmu.jdField_b_of_type_Boolean = a();
        if (QLog.isColorLevel()) {
          QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localbcmu.jdField_b_of_type_Boolean);
        }
        return localbcmu;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        break label344;
      }
      k = paramInt1;
      break;
      if (QLog.isColorLevel()) {
        QLog.e("TroopHomeworkHelper", 2, "getEncodeConfig -> get DpcConfig Erro", localNumberFormatException1);
      }
      n = 0;
      int j = paramInt2;
      int m = i;
      paramInt2 = n;
      i = j;
      j = m;
      continue;
      label382:
      if (localbcmu.jdField_a_of_type_Int < j * 1024)
      {
        localbcmu.jdField_a_of_type_Int = (j * 1024);
        continue;
        paramInt2 = 0;
        paramInt1 = 0;
        j = 0;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onSuccessed");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopHomeworkHelper", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrj
 * JD-Core Version:    0.7.0.1
 */