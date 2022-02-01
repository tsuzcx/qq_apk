package com.tencent.mobileqq.activity.aio.photo;

import android.os.AsyncTask;
import android.os.Environment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class AIOImageListScene$ProcessTask
  extends AsyncTask<Integer, Integer, Integer>
{
  int jdField_a_of_type_Int;
  AIORichMediaInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  boolean jdField_a_of_type_Boolean = true;
  AIORichMediaInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo;
  
  public AIOImageListScene$ProcessTask(ArrayList<AIORichMediaInfo> paramArrayList)
  {
    Object localObject;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ((AIORichMediaInfo[])localObject.toArray(new AIORichMediaInfo[0]));
  }
  
  private int a(AIORichMediaInfo[] paramArrayOfAIORichMediaInfo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Integer... paramVarArgs)
  {
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_FAILED_SD_UNMOUNT");
      }
      return 23;
    }
    File localFile = new File(AppConstants.SDCARD_IMG_SAVE);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfAIORichMediaInfo.length)
    {
      Object localObject = paramArrayOfAIORichMediaInfo[paramInt1];
      if (!paramBoolean) {
        return 1;
      }
      int i;
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = (AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        publishProgress(new Integer[] { Integer.valueOf(paramInt2 * 100 / paramVarArgs.length + paramInt1 * 100 / paramVarArgs.length / paramArrayOfAIORichMediaInfo.length & 0xFFFF | paramInt3 << 16) });
        i = AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, null, (AIOImageData)localObject, localFile);
        if (i != 20) {
          return i;
        }
      }
      else if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = (AIOFilePicData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        publishProgress(new Integer[] { Integer.valueOf(paramInt2 * 100 / paramVarArgs.length + paramInt1 * 100 / paramVarArgs.length / paramArrayOfAIORichMediaInfo.length & 0xFFFF | paramInt3 << 16) });
        i = AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, null, (AIOFilePicData)localObject, localFile);
        if (i != 20) {
          return i;
        }
      }
      paramInt1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "SaveAllImage SAVE_COMPLETE");
    }
    return 20;
  }
  
  protected Integer a(Integer... paramVarArgs)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label560;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ProcessTask start:");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject).toString());
    }
    catch (Throwable paramVarArgs)
    {
      for (;;)
      {
        Object localObject;
        int k;
        int m;
        int i1;
        int n;
        String str;
        label362:
        continue;
        label560:
        int i = 0;
        int j = 0;
        continue;
        label567:
        i = 0;
        continue;
        label572:
        i += 1;
        continue;
        label579:
        if (k == 2) {
          i = 30;
        } else {
          i = 10;
        }
        label594:
        j += 1;
      }
    }
    if (j < paramVarArgs.length)
    {
      k = paramVarArgs[j].intValue();
      if (!this.jdField_a_of_type_Boolean) {
        return Integer.valueOf(1);
      }
      m = j * 100;
      i1 = m / paramVarArgs.length;
      n = k << 16;
      publishProgress(new Integer[] { Integer.valueOf(i1 & 0xFFFF | n) });
      if (k == 0) {
        break label567;
      }
      if (k != 1)
      {
        if (k == 2) {
          break label567;
        }
        break label594;
      }
      return Integer.valueOf(a(this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_Boolean, i1, j, k, paramVarArgs));
      if (i >= this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo.length) {
        break label579;
      }
      if (!this.jdField_a_of_type_Boolean) {
        return Integer.valueOf(1);
      }
      publishProgress(new Integer[] { Integer.valueOf(m / paramVarArgs.length + i * 100 / paramVarArgs.length / this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo.length & 0xFFFF | n) });
      ??? = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo[i];
      if (!AIOImageData.class.isInstance(???.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label572;
      }
      localObject = (AIOImageData)???.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      str = ((AIOImageData)localObject).jdField_b_of_type_JavaLangString;
      if ("I:N".equals(str)) {
        break label572;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo = ???;
      if ((this.jdField_a_of_type_Boolean) && ((str == null) || (!new File(str).exists())))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOImageData)localObject).jdField_f_of_type_Long, ((AIOImageData)localObject).jdField_f_of_type_Int, 2);
      }
    }
    try
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label362;
    }
    if (((AIOImageData)localObject).jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Download Failed @@, index: ");
        paramVarArgs.append(i);
        paramVarArgs.append(", downloadPath:");
        paramVarArgs.append(((AIOImageData)localObject).jdField_b_of_type_JavaLangString);
        QLog.d("AIOImageListScene", 2, paramVarArgs.toString());
      }
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo.length - i);
      return Integer.valueOf(11);
      throw paramVarArgs;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return Integer.valueOf(1);
    }
    if (((AIOImageData)localObject).a(2) == null)
    {
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Download Failed, index: ");
        paramVarArgs.append(i);
        paramVarArgs.append(", downloadPath:");
        paramVarArgs.append(((AIOImageData)localObject).jdField_b_of_type_JavaLangString);
        QLog.d("AIOImageListScene", 2, paramVarArgs.toString());
      }
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioPhotoAIORichMediaInfo.length - i);
      return Integer.valueOf(11);
      return Integer.valueOf(i);
      return Integer.valueOf(2);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.b(paramInteger.intValue(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene$ProcessTask = null;
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[(paramVarArgs.length - 1)].intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.c(i >> 16, 0xFFFF & i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.ProcessTask
 * JD-Core Version:    0.7.0.1
 */