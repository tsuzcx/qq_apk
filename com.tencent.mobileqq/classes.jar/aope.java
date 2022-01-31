import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aope
  implements aoga<String>, aoos
{
  static boolean jdField_a_of_type_Boolean = true;
  static boolean b = true;
  private long jdField_a_of_type_Long = 20971520L;
  private ExcitingTransferDownloadConfig jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig = new ExcitingTransferDownloadConfig();
  public String a;
  private boolean c;
  
  public aope()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = 20971520L;
    this.c = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig = new ExcitingTransferDownloadConfig();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.c = paramJSONObject.getBoolean("enableaqq");
        paramJSONObject = paramJSONObject.getJSONObject("config");
        if (paramJSONObject == null) {
          break label221;
        }
        if (paramJSONObject.has("oneslicesize"))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.mSliceSize = paramJSONObject.getLong("oneslicesize");
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uMaxParrallelSlice = paramJSONObject.getInt("maxparrallelslice");
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uMaxWaitingSlice = paramJSONObject.getInt("maxtotalwaitingslice");
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uNotifyIntervals = paramJSONObject.getInt("notifyintervals");
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uSpeedDuration = paramJSONObject.getInt("speedduration");
          this.jdField_a_of_type_Long = paramJSONObject.getInt("limitedsize");
          if (paramJSONObject.has("slicenum"))
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uSliceNum = paramJSONObject.getInt("slicenum");
            QLog.i("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "parse Exciting-C2C-Download config: enable:" + this.c + " LimitedSize:" + this.jdField_a_of_type_Long + " " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.toString());
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.mSliceSize = 524288L;
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uSliceNum = 10;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
        return;
      }
      continue;
      label221:
      this.jdField_a_of_type_Long = 20971520L;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig = new ExcitingTransferDownloadConfig();
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ExcitingTransferDownloadConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig;
  }
  
  public void a(String paramString)
  {
    int k = 0;
    this.jdField_a_of_type_JavaLangString = paramString.toLowerCase();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
      a();
      return;
    }
    try
    {
      paramString = new JSONObject(this.jdField_a_of_type_JavaLangString);
      if (paramString.length() == 0)
      {
        QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
        a();
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramString));
      return;
    }
    JSONArray localJSONArray = paramString.names();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < localJSONArray.length())
      {
        Object localObject = localJSONArray.getString(i).trim();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = paramString.optJSONObject((String)localObject).getJSONObject("download");
          if (localObject != null)
          {
            a((JSONObject)localObject);
            j = 1;
          }
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent no Exciting-C2C-Download config, use default value");
        a();
        return;
      }
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aope
 * JD-Core Version:    0.7.0.1
 */