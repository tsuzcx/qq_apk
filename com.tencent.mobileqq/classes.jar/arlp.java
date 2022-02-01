import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arlp
  implements arae<String>, arkx
{
  static boolean jdField_a_of_type_Boolean = true;
  static boolean b = true;
  private long jdField_a_of_type_Long = 20971520L;
  private ExcitingTransferUploadChnConfigInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
  public String a;
  private boolean c;
  
  public arlp()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = 20971520L;
    this.c = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.c = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      if (paramJSONObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uMuliFileSizeLimit = paramJSONObject.getLong("mulifilesizelimit");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uMaxChannelNum = paramJSONObject.getInt("maxchannelnum");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uPieceSize = paramJSONObject.getInt("piecesize");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostTotalUseCount = paramJSONObject.getInt("maxeachhosttotalusecount");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostErrorCount = paramJSONObject.getInt("maxeachhosterrorcount");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostParallelUseCount = paramJSONObject.getInt("maxeachhostparallelusecount");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nConnectTimeout = paramJSONObject.getLong("connecttimeout");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nDataTimeout = paramJSONObject.getLong("datatimeout");
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nTotoalDataTimeout = paramJSONObject.getLong("totoaldatatimeout");
        this.jdField_a_of_type_Long = paramJSONObject.getLong("limitedsize");
      }
      for (;;)
      {
        QLog.i("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, "parse Exciting-C2C-Upload config: enable:" + this.c + " LimitedSize:" + this.jdField_a_of_type_Long + " " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.toString());
        return;
        this.jdField_a_of_type_Long = 20971520L;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ExcitingTransferUploadChnConfigInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo;
  }
  
  public void a(String paramString)
  {
    int k = 0;
    this.jdField_a_of_type_JavaLangString = paramString.toLowerCase();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.w("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
      a();
      return;
    }
    try
    {
      paramString = new JSONObject(this.jdField_a_of_type_JavaLangString);
      if (paramString.length() == 0)
      {
        QLog.w("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
        a();
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramString));
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
          localObject = paramString.optJSONObject((String)localObject).getJSONObject("upload");
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
        QLog.w("QFileExcitingC2CUploadConfigBean<FileAssistant>", 1, "configContent no Exciting-C2C-Upload config, use default value");
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
 * Qualified Name:     arlp
 * JD-Core Version:    0.7.0.1
 */