import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;
import org.apache.http.Header;

public class batj
  extends bame
{
  private static String a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://gxh.vip.qq.com/xydata/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.url.getFile();
    paramOutputStream = paramURLDrawableHandler;
    if (paramURLDrawableHandler.startsWith(File.separator)) {
      paramOutputStream = paramURLDrawableHandler.substring(1);
    }
    String str = paramDownloadParams.url.getHost();
    Object localObject = paramDownloadParams.getHeader("my_uin");
    paramURLDrawableHandler = null;
    if (localObject != null) {
      paramURLDrawableHandler = ((Header)localObject).getValue();
    }
    paramURLDrawableHandler = BaseApplicationImpl.sApplication.getAppRuntime(paramURLDrawableHandler);
    localObject = new File(bdpk.a(paramOutputStream, str));
    if (((File)localObject).exists()) {
      return localObject;
    }
    if (paramDownloadParams.useSharpPImage)
    {
      localObject = new File(bhlt.a((File)localObject));
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return a(paramURLDrawableHandler, paramOutputStream, str, paramDownloadParams.useSharpPImage);
  }
  
  public File a(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = a(Integer.parseInt(paramString1), paramString2);
    paramString2 = new File(bdpk.a(paramString1, paramString2));
    bdvv localbdvv = new bdvv(str, paramString2);
    localbdvv.k = paramBoolean;
    if (paramAppRuntime != null)
    {
      if (bdvx.a(localbdvv, paramAppRuntime) != 0) {
        break label102;
      }
      if ((!paramString2.exists()) || (SignatureManager.a(paramString2.getAbsolutePath()))) {
        break label88;
      }
      paramString2.delete();
    }
    for (;;)
    {
      return new File(aljq.aX);
      label88:
      if (SharpPUtil.isSharpPFile(paramString2)) {
        return bhlt.a(paramString2);
      }
      return paramString2;
      label102:
      bdqk.a(null, "individual_v2_signature_download_fail", "" + localbdvv.a, "error code = " + localbdvv.a + " errorMsg = " + localbdvv.b + "url = " + str, null, 0.0F);
      bdqj.a("individual_v2_signature_download_fail", "tlpId:" + paramString1 + " errCode:" + localbdvv.a + " errMsg:" + localbdvv.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batj
 * JD-Core Version:    0.7.0.1
 */