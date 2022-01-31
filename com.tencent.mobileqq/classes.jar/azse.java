import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class azse
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 404) {
      paramInt2 = 303;
    }
    do
    {
      return paramInt2;
      if ((paramInt2 - 400 >= 0) && (paramInt2 - 400 < 100)) {
        return 304;
      }
      if ((paramInt2 - 500 >= 0) && (paramInt2 - 500 < 100)) {
        return 305;
      }
      if (paramInt1 == 9024) {
        return 303;
      }
      if (paramInt1 == 9060) {
        return 304;
      }
      if (paramInt1 == 9061) {
        return 305;
      }
      if ((paramInt1 == 9052) || (paramInt1 == 9055) || (paramInt1 == 9053)) {
        break;
      }
      paramInt2 = paramInt1;
    } while (paramInt1 != 9054);
    return 307;
  }
  
  @Deprecated
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    if (paramItem == null) {
      return;
    }
    QQAppInterface localQQAppInterface = azsr.a();
    switch (paramInt1)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
    case 6: 
      bakx.a(localQQAppInterface, "upload", true, paramItem.transferBeginTime, paramItem.UploadIp, paramLong + "", apvd.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 10: 
      bakx.a(localQQAppInterface, "download", false, paramItem.transferBeginTime, paramItem.DownloadIp, paramLong + "", apvd.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 9: 
    case 11: 
      bakx.a(localQQAppInterface, "download", true, paramItem.transferBeginTime, paramItem.DownloadIp, paramLong + "", apvd.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    }
    bakx.a(localQQAppInterface, "upload", false, paramItem.transferBeginTime, paramItem.UploadIp, paramLong + "", apvd.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, azsf paramazsf)
  {
    if ((paramItem == null) || (paramazsf == null)) {}
    do
    {
      return;
      localObject = azsr.a();
    } while (localObject == null);
    Object localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str = azsr.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", String.valueOf(paramLong));
    localHashMap.put("param_self_uin", localObject);
    localHashMap.put("param_file_name", paramItem.FileName);
    localHashMap.put("param_suffix", apvd.a(paramItem.FileName));
    localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
    localHashMap.put("param_uuid", paramItem.FilePath);
    localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
    localHashMap.put("param_result", String.valueOf(0));
    localHashMap.put("param_sub_reason", String.valueOf(0));
    localHashMap.put("param_http_status_code", String.valueOf(paramazsf.jdField_e_of_type_Int));
    localHashMap.put("param_err_msg", "");
    localHashMap.put("param_flash_transfer", String.valueOf(paramazsf.jdField_a_of_type_Boolean));
    localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
    localHashMap.put("param_proxy_type", String.valueOf(paramazsf.jdField_b_of_type_Int));
    localHashMap.put("param_net_type", str);
    localHashMap.put("param_security_time", String.valueOf(paramazsf.jdField_f_of_type_Long));
    localHashMap.put("param_check_time", String.valueOf(paramazsf.jdField_g_of_type_Long));
    localHashMap.put("param_server_ip", String.valueOf(paramazsf.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_server_port", String.valueOf(paramazsf.jdField_a_of_type_Int));
    localHashMap.put("param_file_url", paramazsf.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_start_size", String.valueOf(paramazsf.jdField_a_of_type_Long));
    localHashMap.put("param_transfer_size", String.valueOf(paramazsf.jdField_b_of_type_Long));
    localHashMap.put("param_transfer_time", String.valueOf(paramazsf.jdField_c_of_type_Long));
    localHashMap.put("param_transfer_speed", String.valueOf(paramazsf.jdField_e_of_type_Long));
    localHashMap.put("param_fromType", String.valueOf(paramazsf.jdField_g_of_type_Int));
    paramLong = paramazsf.jdField_d_of_type_Long;
    long l = System.currentTimeMillis();
    if (paramazsf.jdField_d_of_type_Long == 0L) {
      paramLong = l;
    }
    if (paramLong < 1L) {}
    for (paramLong = 0L;; paramLong = l - paramLong)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      azst.c("TroopFileDataReporter", azst.jdField_a_of_type_Int, "[GroupSend]reportUploadSucInfo. reportType:actGroupFileUp params:" + localHashMap.toString());
      axrn.a(BaseApplication.getContext()).a((String)localObject, "actGroupFileUp", true, l, 1, localHashMap, "");
      return;
    }
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, String paramString, azsf paramazsf)
  {
    if ((paramItem == null) || (paramazsf == null)) {}
    do
    {
      return;
      localObject = azsr.a();
    } while (localObject == null);
    Object localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str = azsr.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", String.valueOf(paramLong));
    localHashMap.put("param_self_uin", localObject);
    localHashMap.put("param_file_name", paramItem.FileName);
    localHashMap.put("param_suffix", apvd.a(paramItem.FileName));
    localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
    localHashMap.put("param_uuid", paramItem.FilePath);
    localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
    localHashMap.put("param_result", String.valueOf(paramazsf.jdField_c_of_type_Int));
    localHashMap.put("param_sub_reason", String.valueOf(paramazsf.jdField_d_of_type_Int));
    localHashMap.put("param_http_status_code", String.valueOf(paramazsf.jdField_e_of_type_Int));
    localHashMap.put("param_server_return_code", String.valueOf(paramazsf.jdField_f_of_type_Int));
    localHashMap.put("param_err_msg", paramazsf.jdField_c_of_type_JavaLangString);
    localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
    localHashMap.put("param_proxy_type", String.valueOf(paramazsf.jdField_b_of_type_Int));
    localHashMap.put("param_net_type", str);
    localHashMap.put("param_security_time", String.valueOf(paramazsf.jdField_f_of_type_Long));
    localHashMap.put("param_check_time", String.valueOf(paramazsf.jdField_g_of_type_Long));
    localHashMap.put("param_server_ip", String.valueOf(paramazsf.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_server_port", String.valueOf(paramazsf.jdField_a_of_type_Int));
    localHashMap.put("param_file_url", paramazsf.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_start_size", String.valueOf(paramazsf.jdField_a_of_type_Long));
    localHashMap.put("param_transfer_size", String.valueOf(paramazsf.jdField_b_of_type_Long));
    localHashMap.put("param_transfer_time", String.valueOf(paramazsf.jdField_c_of_type_Long));
    localHashMap.put("param_transfer_speed", String.valueOf(paramazsf.jdField_e_of_type_Long));
    localHashMap.put("param_fromType", String.valueOf(paramazsf.jdField_g_of_type_Int));
    paramLong = paramazsf.jdField_d_of_type_Long;
    long l = System.currentTimeMillis();
    if (paramazsf.jdField_d_of_type_Long == 0L) {
      paramLong = l;
    }
    if (paramLong < 1L) {}
    for (paramLong = 0L;; paramLong = l - paramLong)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      azst.c("TroopFileDataReporter", azst.jdField_a_of_type_Int, "[GroupSend]reportUploadFailInfo. reportType:" + paramString + " params:" + localHashMap.toString());
      axrn.a(BaseApplication.getContext()).a((String)localObject, paramString, false, l, 1, localHashMap, "");
      return;
    }
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem, azsf paramazsf)
  {
    if ((paramItem == null) || (paramazsf == null)) {}
    do
    {
      return;
      localObject = azsr.a();
    } while (localObject == null);
    Object localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str = azsr.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", String.valueOf(paramLong));
    localHashMap.put("param_self_uin", localObject);
    localHashMap.put("param_file_name", paramItem.FileName);
    localHashMap.put("param_suffix", apvd.a(paramItem.FileName));
    localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
    localHashMap.put("param_uuid", paramItem.FilePath);
    localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
    localHashMap.put("param_life_left_second", String.valueOf(paramazsf.h));
    localHashMap.put("param_result", String.valueOf(0));
    localHashMap.put("param_sub_reason", String.valueOf(0));
    localHashMap.put("param_http_status_code", String.valueOf(paramazsf.jdField_e_of_type_Int));
    localHashMap.put("param_err_msg", "");
    localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
    localHashMap.put("param_proxy_type", String.valueOf(paramazsf.jdField_b_of_type_Int));
    localHashMap.put("param_net_type", str);
    localHashMap.put("param_security_time", String.valueOf(paramazsf.jdField_f_of_type_Long));
    localHashMap.put("param_server_ip", String.valueOf(paramazsf.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_server_port", String.valueOf(paramazsf.jdField_a_of_type_Int));
    localHashMap.put("param_file_url", paramazsf.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_start_size", String.valueOf(paramazsf.jdField_a_of_type_Long));
    localHashMap.put("param_transfer_size", String.valueOf(paramazsf.jdField_b_of_type_Long));
    localHashMap.put("param_transfer_time", String.valueOf(paramazsf.jdField_c_of_type_Long));
    localHashMap.put("param_transfer_speed", String.valueOf(paramazsf.jdField_e_of_type_Long));
    localHashMap.put("param_fromType", String.valueOf(paramazsf.jdField_g_of_type_Int));
    paramLong = paramazsf.jdField_d_of_type_Long;
    long l = System.currentTimeMillis();
    if (paramazsf.jdField_d_of_type_Long == 0L) {
      paramLong = l;
    }
    if (paramLong < 1L) {}
    for (paramLong = 0L;; paramLong = l - paramLong)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      azst.c("TroopFileDataReporter", azst.jdField_a_of_type_Int, "[GroupDownload]reportDownloadSucInfo. reportType:actGroupFileDown params:" + localHashMap.toString());
      axrn.a(BaseApplication.getContext()).a((String)localObject, "actGroupFileDown", true, l, 1, localHashMap, "");
      return;
    }
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem, String paramString, azsf paramazsf)
  {
    if ((paramItem == null) || (paramazsf == null)) {}
    do
    {
      return;
      localObject = azsr.a();
    } while (localObject == null);
    Object localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    String str = azsr.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_group_code", String.valueOf(paramLong));
    localHashMap.put("param_self_uin", localObject);
    localHashMap.put("param_file_name", paramItem.FileName);
    localHashMap.put("param_suffix", apvd.a(paramItem.FileName));
    localHashMap.put("param_file_size", String.valueOf(paramItem.ProgressTotal));
    localHashMap.put("param_uuid", paramItem.FilePath);
    localHashMap.put("param_store_type", String.valueOf(paramItem.BusId));
    localHashMap.put("param_life_left_second", String.valueOf(paramazsf.h));
    localHashMap.put("param_result", String.valueOf(paramazsf.jdField_c_of_type_Int));
    localHashMap.put("param_sub_reason", String.valueOf(paramazsf.jdField_d_of_type_Int));
    localHashMap.put("param_http_status_code", String.valueOf(paramazsf.jdField_e_of_type_Int));
    localHashMap.put("param_server_return_code", String.valueOf(paramazsf.jdField_f_of_type_Int));
    localHashMap.put("param_err_msg", paramazsf.jdField_c_of_type_JavaLangString);
    localHashMap.put("param_retry_count", String.valueOf(paramItem.retryTimes));
    localHashMap.put("param_proxy_type", String.valueOf(paramazsf.jdField_b_of_type_Int));
    localHashMap.put("param_net_type", str);
    localHashMap.put("param_security_time", String.valueOf(paramazsf.jdField_f_of_type_Long));
    localHashMap.put("param_server_ip", String.valueOf(paramazsf.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_server_port", String.valueOf(paramazsf.jdField_a_of_type_Int));
    localHashMap.put("param_file_url", paramazsf.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_start_size", String.valueOf(paramazsf.jdField_a_of_type_Long));
    localHashMap.put("param_transfer_size", String.valueOf(paramazsf.jdField_b_of_type_Long));
    localHashMap.put("param_transfer_time", String.valueOf(paramazsf.jdField_c_of_type_Long));
    localHashMap.put("param_transfer_speed", String.valueOf(paramazsf.jdField_e_of_type_Long));
    localHashMap.put("param_fromType", String.valueOf(paramazsf.jdField_g_of_type_Int));
    paramLong = paramazsf.jdField_d_of_type_Long;
    long l = System.currentTimeMillis();
    if (paramazsf.jdField_d_of_type_Long == 0L) {
      paramLong = l;
    }
    if (paramLong < 1L) {}
    for (paramLong = 0L;; paramLong = l - paramLong)
    {
      l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      azst.c("TroopFileDataReporter", azst.jdField_a_of_type_Int, "[GroupDownload]reportDownloadFailInfo. reportType:" + paramString + " params:" + localHashMap.toString());
      axrn.a(BaseApplication.getContext()).a((String)localObject, paramString, false, l, 1, localHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azse
 * JD-Core Version:    0.7.0.1
 */