import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class bnps
  implements bdvw
{
  bnps(bcfe parambcfe, bnpt parambnpt) {}
  
  public void onResp(bdwt parambdwt)
  {
    bnzb.b("AEResDownload", "[onResp] start");
    bdws localbdws = parambdwt.jdField_a_of_type_Bdws;
    String str3 = (String)localbdws.a();
    bnzb.b("AEResDownload", "[onResp] key:" + str3);
    if (str3 == null)
    {
      bnzb.d("AEResDownload", "[onResp] key=null ");
      this.jdField_a_of_type_Bcfe.a("", -1, "");
      return;
    }
    try
    {
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break label767;
      }
      bnzb.b("AEResDownload", "[onResp] NetResp.ResultOk");
      localObject2 = (ShortVideoResourceManager.SVConfigItem)bnpr.a().get(str3);
      str4 = localbdws.c;
      bnzb.b("AEResDownload", "[onResp]filePath=" + str4 + ",resp.mResult=" + parambdwt.jdField_a_of_type_Int + ",mHttpCode=" + parambdwt.c + ",mErrCode=" + parambdwt.b + ",mErrDesc=" + parambdwt.jdField_a_of_type_JavaLangString);
      if ((!bcgg.a()) || (!((ShortVideoResourceManager.SVConfigItem)localObject2).check64BitReady())) {
        break label497;
      }
      String str2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).arm64v8a_md5;
      i = bnpy.a(str3, str2, str4);
      if (i != 0) {
        break label727;
      }
      bnzb.b("AEResDownload", "[onResp] verifyResource:success=");
      str1 = bnpy.a((String)localbdws.a());
      try
      {
        if (!bgmg.c(str4, str1)) {
          break label699;
        }
        localObject2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).name.substring(this.jdField_a_of_type_Bnpt.jdField_b_of_type_JavaLangString.length());
        str2 = str2 + '_' + (String)localObject2;
        str4 = bnpy.a();
        str4 = str4 + str2 + File.separator;
        File localFile = new File(str4);
        bool = localFile.mkdirs();
        bnzb.b("AEResDownload", "[onResp] unzipFile:[exists]mkOK=" + bool);
        if (localFile.exists()) {
          break label507;
        }
        bnzb.d("AEResDownload", "[onResp] unzipFile.exists=false[error]");
        this.jdField_a_of_type_Bcfe.a(str3, -118, str1);
        return;
      }
      catch (SecurityException localSecurityException1) {}
    }
    catch (SecurityException localSecurityException2)
    {
      for (;;)
      {
        Object localObject2;
        String str4;
        int i;
        boolean bool;
        String str1 = "";
      }
    }
    bnzb.a("AEResDownload", "[SecurityException]", localSecurityException1);
    i = -1;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bnpt.jdField_b_of_type_Boolean)
        {
          localObject1 = (beaw)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(193);
          if ((localObject1 != null) && (((beaw)localObject1).a()))
          {
            if (i != 0) {
              continue;
            }
            ((beaw)localObject1).a((String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("param_url"), parambdwt.jdField_a_of_type_Long);
          }
        }
      }
      catch (Throwable parambdwt)
      {
        Object localObject1;
        label497:
        label507:
        label767:
        bnzb.a("AEResDownload", "[onResp] isPredownload callback ERROR", parambdwt);
        label699:
        label727:
        continue;
      }
      this.jdField_a_of_type_Bcfe.a(str3, i, str1);
      return;
      localObject1 = ((ShortVideoResourceManager.SVConfigItem)localObject2).armv7a_md5;
      break;
      try
      {
        bgmg.a(str1, str4, false);
        bool = bnpy.a((String)localObject2, str4);
        bnzb.b("AEResDownload", "[onResp]  copyResFileToFinalDir copyOK=" + bool);
        if (!bool) {
          continue;
        }
        if (bnpy.a((String)localObject2)) {
          if (bnpy.a((String)localObject1, this.jdField_a_of_type_Bnpt))
          {
            bnzb.d("AEResDownload", "[onResp] copyResFileToFinalDir.SUCCESS");
            i = 0;
          }
          else
          {
            bnzb.d("AEResDownload", "[onResp] storeNewPendantUnzipPath.error");
            i = -118;
            bgmg.d(localbdws.c);
            bgmg.d(str1);
          }
        }
      }
      catch (IOException localIOException)
      {
        bnzb.a("AEResDownload", "[onResp] unzip.error:", localIOException);
        i = -118;
        bgmg.d(localbdws.c);
        bgmg.d(str1);
      }
      bnzb.d("AEResDownload", "[onResp] saveAEResUnzipFinalPath.error");
      i = -118;
      bgmg.d(localbdws.c);
      bgmg.d(str1);
      break label861;
      bnzb.d("AEResDownload", "[onResp] storeUnzipFinalPath.error");
      i = -118;
      bgmg.d(localbdws.c);
      bgmg.d(str1);
      break label861;
      i = -3;
      bnzb.d("AEResDownload", "[onResp] ShortVideoResourceStatus.RES_RENAME_VERIFY_ERROR");
      bgmg.d(localbdws.c);
      bgmg.d(str1);
      break label861;
      bnzb.d("AEResDownload", "[onResp] verifyResource.error:" + i);
      bgmg.d(localbdws.c);
      str1 = "";
      break label861;
      bnzb.d("AEResDownload", "[onResp] download.error:" + parambdwt.jdField_a_of_type_Int);
      bgmg.d(localbdws.c);
      i = parambdwt.jdField_a_of_type_Int;
      str1 = "";
      break label861;
      localIOException.a((String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("param_url"), -1L);
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    parambdws = (String)parambdws.a();
    if (parambdws == null)
    {
      bnzb.d("AEResDownload", "[onUpdateProgeress] key = null");
      return;
    }
    this.jdField_a_of_type_Bcfe.a(parambdws, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnps
 * JD-Core Version:    0.7.0.1
 */