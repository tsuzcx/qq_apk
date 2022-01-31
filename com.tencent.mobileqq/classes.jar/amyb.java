import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class amyb
  implements ampc<String>, amxn
{
  private long jdField_a_of_type_Long = 20971520L;
  private ExcitingTransferDownloadConfig jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig = new ExcitingTransferDownloadConfig();
  private ExcitingTransferUploadChnConfigInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = 20971520L;
  private boolean jdField_b_of_type_Boolean;
  
  public amyb()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.mSliceSize = paramJSONObject.getLong("slicesize");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uMaxParrallelSlice = paramJSONObject.getInt("maxparrallelslice");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uMaxWaitingSlice = paramJSONObject.getInt("maxtotalwaitingslice");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uNotifyIntervals = paramJSONObject.getInt("notifyintervals");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig.uSpeedDuration = paramJSONObject.getInt("speedduration");
      this.jdField_a_of_type_Long = paramJSONObject.getInt("limitedsize");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("enableaqq");
      paramJSONObject = paramJSONObject.getJSONObject("config");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uMuliFileSizeLimit = paramJSONObject.getLong("mulifilesizelimit");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uMaxChannelNum = paramJSONObject.getInt("maxchannelnum");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.uPieceSize = paramJSONObject.getInt("piecesize");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostTotalUseCount = paramJSONObject.getInt("maxeachhosttotalusecount");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostErrorCount = paramJSONObject.getInt("maxeachhosterrorcount");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nMaxEachHostParallelUseCount = paramJSONObject.getInt("maxeachhostparallelusecount");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nConnectTimeout = paramJSONObject.getLong("connecttimeout");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nDataTimeout = paramJSONObject.getLong("datatimeout");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadChnConfigInfo.nTotoalDataTimeout = paramJSONObject.getLong("totoaldatatimeout");
      this.jdField_b_of_type_Long = paramJSONObject.getLong("limitedsize");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("QFileExcitingConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramJSONObject));
    }
  }
  
  public ExcitingTransferDownloadConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadConfig;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString.toLowerCase();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(this.jdField_a_of_type_JavaLangString);
        if (paramString.length() == 0) {
          return;
        }
        JSONArray localJSONArray = paramString.names();
        i = 0;
        if (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.getString(i).trim();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label115;
          }
          localObject = paramString.optJSONObject((String)localObject);
          ((JSONObject)localObject).names();
          a(((JSONObject)localObject).getJSONObject("download"));
          b(((JSONObject)localObject).getJSONObject("upload"));
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QFileExcitingConfigBean<FileAssistant>", 1, QLog.getStackTraceString(paramString));
      }
      return;
      label115:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyb
 * JD-Core Version:    0.7.0.1
 */