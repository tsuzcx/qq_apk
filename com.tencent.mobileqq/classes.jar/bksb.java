import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class bksb
  implements FFmpegExecuteResponseCallback
{
  bksb(bkrw parambkrw, long paramLong1, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt, String paramString2, long paramLong2) {}
  
  public void onFailure(String paramString)
  {
    paramString = paramString.split("\n");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      QLog.w("VideoJsPlugin", 1, "onFailure: " + str);
      i += 1;
    }
    if (this.jdField_a_of_type_JavaLangString.contains("-vf"))
    {
      bkrw.a(this.jdField_a_of_type_Bkrw, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, false);
      return;
    }
    paramString = ((IMiniAppFileManager)bkrw.a(this.jdField_a_of_type_Bkrw).getManager(IMiniAppFileManager.class)).getWxFilePath(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    bkrw.a(this.jdField_a_of_type_Bkrw, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.fileSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress finish " + paramBoolean + " " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
  
  public void onProgress(String paramString)
  {
    if ((paramString.length() < 90) || (paramString.length() > 150)) {}
    for (;;)
    {
      return;
      paramString = new Scanner(paramString).findWithinHorizon(bkrw.a(), 0);
      if (paramString != null)
      {
        paramString = paramString.split(":");
        if (paramString.length > 2) {
          try
          {
            int i = Integer.parseInt(paramString[0]);
            int j = Integer.parseInt(paramString[1]);
            double d = Double.parseDouble(paramString[2]);
            i = (int)((float)(TimeUnit.HOURS.toMillis(i) + TimeUnit.MINUTES.toMillis(j) + (1000.0D * d)) * 100.0F / (float)this.jdField_b_of_type_Long);
            if (i < 100)
            {
              bkrw.a(this.jdField_a_of_type_Bkrw, anvx.a(2131715662) + i + "%");
              return;
            }
          }
          catch (NumberFormatException paramString) {}
        }
      }
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress success " + paramString + " " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_JavaLangString.contains("-vf"))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      paramString.mediaWidth /= this.jdField_a_of_type_Int;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      paramString.mediaHeight /= this.jdField_a_of_type_Int;
    }
    paramString = ((IMiniAppFileManager)bkrw.a(this.jdField_a_of_type_Bkrw).getManager(IMiniAppFileManager.class)).getWxFilePath(this.jdField_b_of_type_JavaLangString);
    bkrw.a(this.jdField_a_of_type_Bkrw, paramString, new File(this.jdField_b_of_type_JavaLangString).length(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksb
 * JD-Core Version:    0.7.0.1
 */