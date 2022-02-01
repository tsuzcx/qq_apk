package com.tencent.hippy.qq.update.patch;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.tool.MD5;
import com.tencent.hippy.qq.update.tool.QarFile;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PatchUtil
{
  private static final String DST_TEMP_QAR_FILE_NAME = "dst_temp.qar";
  private static final String SRC_TEMP_QAR_FILE_NAME = "src_temp.qar";
  private static final String TAG = "HippyDiffUtil";
  
  public static PatchUtil.DiffResultCodes patch(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      paramString2 = new File(paramString2);
      if ((!paramString2.getParentFile().exists()) && (!paramString2.getParentFile().mkdirs()))
      {
        QLog.e("HippyDiffUtil", 1, "[patch] mkdirs error.");
        return PatchUtil.DiffResultCodes.CREATE_DST_DIR_FAILED;
      }
      File localFile1 = new File(paramString2.getParent(), "src_temp.qar");
      File localFile2 = new File(paramString2.getParent(), "dst_temp.qar");
      if ((localFile1.exists()) && (!localFile1.delete()))
      {
        QLog.e("HippyDiffUtil", 1, "[patch] delete oldTempQarFile failed.");
        return PatchUtil.DiffResultCodes.DELETE_TEMP_FILE_FAILED;
      }
      if ((localFile2.exists()) && (!localFile2.delete()))
      {
        QLog.e("HippyDiffUtil", 1, "[patch] delete newTempQarFile failed.");
        return PatchUtil.DiffResultCodes.DELETE_TEMP_FILE_FAILED;
      }
      paramString1 = new File(paramString1);
      QarFile localQarFile = new QarFile();
      if (!localQarFile.createQar(paramString1.getAbsolutePath(), localFile1.getAbsolutePath()))
      {
        QLog.e("HippyDiffUtil", 1, "[patch] create qar file of old version failed.");
        return PatchUtil.DiffResultCodes.CREATE_QAR_FILE_FAILED;
      }
      if (!BspatchUtil.a(localFile1.getAbsolutePath(), paramString3, localFile2.getAbsolutePath()))
      {
        QLog.e("HippyDiffUtil", 1, "[patch] patch failed.");
        return PatchUtil.DiffResultCodes.PATCH_FAILED;
      }
      if (!paramString4.equals(MD5.getFileMd5(localFile2.getAbsolutePath())))
      {
        QLog.e("HippyDiffUtil", 1, "[patch] md5 not correct.");
        return PatchUtil.DiffResultCodes.MD5_FAILED;
      }
      if ((paramString2.exists()) && (!paramString2.delete())) {
        return PatchUtil.DiffResultCodes.DELETE_TEMP_FILE_FAILED;
      }
      if (!localQarFile.restoreQar(localFile2.getAbsolutePath(), paramString2.getAbsolutePath()))
      {
        QLog.e("HippyDiffUtil", 1, "[patch] convert to zip file failed.");
        return PatchUtil.DiffResultCodes.CONVERT_ZIP_FILE_FAILED;
      }
      localFile1.delete();
      localFile2.delete();
      return PatchUtil.DiffResultCodes.SUCCESS;
    }
    return PatchUtil.DiffResultCodes.PARAMETERS_ERROR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.patch.PatchUtil
 * JD-Core Version:    0.7.0.1
 */