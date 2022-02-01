import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class bore
  implements beuq
{
  bore(bcxw parambcxw, borf paramborf) {}
  
  public void onResp(bevm parambevm)
  {
    bpam.b("AEResDownload", "[onResp] start");
    bevl localbevl = parambevm.jdField_a_of_type_Bevl;
    String str3 = (String)localbevl.a();
    bpam.b("AEResDownload", "[onResp] key:" + str3);
    if (str3 == null)
    {
      bpam.d("AEResDownload", "[onResp] key=null ");
      this.jdField_a_of_type_Bcxw.a("", -1, "");
      return;
    }
    try
    {
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label767;
      }
      bpam.b("AEResDownload", "[onResp] NetResp.ResultOk");
      localObject2 = (ShortVideoResourceManager.SVConfigItem)bord.a().get(str3);
      str4 = localbevl.c;
      bpam.b("AEResDownload", "[onResp]filePath=" + str4 + ",resp.mResult=" + parambevm.jdField_a_of_type_Int + ",mHttpCode=" + parambevm.c + ",mErrCode=" + parambevm.b + ",mErrDesc=" + parambevm.jdField_a_of_type_JavaLangString);
      if ((!bcyy.a()) || (!((ShortVideoResourceManager.SVConfigItem)localObject2).check64BitReady())) {
        break label497;
      }
      String str2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).arm64v8a_md5;
      i = bork.a(str3, str2, str4);
      if (i != 0) {
        break label727;
      }
      bpam.b("AEResDownload", "[onResp] verifyResource:success=");
      str1 = bork.a((String)localbevl.a());
      try
      {
        if (!bhmi.c(str4, str1)) {
          break label699;
        }
        localObject2 = ((ShortVideoResourceManager.SVConfigItem)localObject2).name.substring(this.jdField_a_of_type_Borf.jdField_b_of_type_JavaLangString.length());
        str2 = str2 + '_' + (String)localObject2;
        str4 = bork.a();
        str4 = str4 + str2 + File.separator;
        File localFile = new File(str4);
        bool = localFile.mkdirs();
        bpam.b("AEResDownload", "[onResp] unzipFile:[exists]mkOK=" + bool);
        if (localFile.exists()) {
          break label507;
        }
        bpam.d("AEResDownload", "[onResp] unzipFile.exists=false[error]");
        this.jdField_a_of_type_Bcxw.a(str3, -118, str1);
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
    bpam.a("AEResDownload", "[SecurityException]", localSecurityException1);
    i = -1;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Borf.jdField_b_of_type_Boolean)
        {
          localObject1 = (bezv)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(193);
          if ((localObject1 != null) && (((bezv)localObject1).a()))
          {
            if (i != 0) {
              continue;
            }
            ((bezv)localObject1).a((String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("param_url"), parambevm.jdField_a_of_type_Long);
          }
        }
      }
      catch (Throwable parambevm)
      {
        Object localObject1;
        label497:
        label507:
        label767:
        bpam.a("AEResDownload", "[onResp] isPredownload callback ERROR", parambevm);
        label699:
        label727:
        continue;
      }
      this.jdField_a_of_type_Bcxw.a(str3, i, str1);
      return;
      localObject1 = ((ShortVideoResourceManager.SVConfigItem)localObject2).armv7a_md5;
      break;
      try
      {
        bhmi.a(str1, str4, false);
        bool = bork.a((String)localObject2, str4);
        bpam.b("AEResDownload", "[onResp]  copyResFileToFinalDir copyOK=" + bool);
        if (!bool) {
          continue;
        }
        if (bork.a((String)localObject2)) {
          if (bork.a((String)localObject1, this.jdField_a_of_type_Borf))
          {
            bpam.d("AEResDownload", "[onResp] copyResFileToFinalDir.SUCCESS");
            i = 0;
          }
          else
          {
            bpam.d("AEResDownload", "[onResp] storeNewPendantUnzipPath.error");
            i = -118;
            bhmi.d(localbevl.c);
            bhmi.d(str1);
          }
        }
      }
      catch (IOException localIOException)
      {
        bpam.a("AEResDownload", "[onResp] unzip.error:", localIOException);
        i = -118;
        bhmi.d(localbevl.c);
        bhmi.d(str1);
      }
      bpam.d("AEResDownload", "[onResp] saveAEResUnzipFinalPath.error");
      i = -118;
      bhmi.d(localbevl.c);
      bhmi.d(str1);
      break label861;
      bpam.d("AEResDownload", "[onResp] storeUnzipFinalPath.error");
      i = -118;
      bhmi.d(localbevl.c);
      bhmi.d(str1);
      break label861;
      i = -3;
      bpam.d("AEResDownload", "[onResp] ShortVideoResourceStatus.RES_RENAME_VERIFY_ERROR");
      bhmi.d(localbevl.c);
      bhmi.d(str1);
      break label861;
      bpam.d("AEResDownload", "[onResp] verifyResource.error:" + i);
      bhmi.d(localbevl.c);
      str1 = "";
      break label861;
      bpam.d("AEResDownload", "[onResp] download.error:" + parambevm.jdField_a_of_type_Int);
      bhmi.d(localbevl.c);
      i = parambevm.jdField_a_of_type_Int;
      str1 = "";
      break label861;
      localIOException.a((String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("param_url"), -1L);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    parambevl = (String)parambevl.a();
    if (parambevl == null)
    {
      bpam.d("AEResDownload", "[onUpdateProgeress] key = null");
      return;
    }
    this.jdField_a_of_type_Bcxw.a(parambevl, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bore
 * JD-Core Version:    0.7.0.1
 */