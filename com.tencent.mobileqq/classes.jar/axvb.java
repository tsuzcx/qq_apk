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

public class axvb
  extends axoa
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
    localObject = new File(baog.a(paramOutputStream, str));
    if (((File)localObject).exists()) {
      return localObject;
    }
    if (paramDownloadParams.useSharpPImage)
    {
      localObject = new File(becs.a((File)localObject));
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return a(paramURLDrawableHandler, paramOutputStream, str, paramDownloadParams.useSharpPImage);
  }
  
  public File a(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = a(Integer.parseInt(paramString1), paramString2);
    paramString2 = new File(baog.a(paramString1, paramString2));
    batm localbatm = new batm(str, paramString2);
    localbatm.k = paramBoolean;
    localbatm.p = false;
    if (paramAppRuntime != null)
    {
      if (bato.a(localbatm, paramAppRuntime) != 0) {
        break label108;
      }
      if ((!paramString2.exists()) || (SignatureManager.a(paramString2.getAbsolutePath()))) {
        break label94;
      }
      paramString2.delete();
    }
    for (;;)
    {
      return new File(ajed.aU);
      label94:
      if (SharpPUtil.isSharpPFile(paramString2)) {
        return becs.a(paramString2);
      }
      return paramString2;
      label108:
      bapf.a(null, "individual_v2_signature_download_fail", "" + localbatm.a, "error code = " + localbatm.a + " errorMsg = " + localbatm.b + "url = " + str, null, 0.0F);
      bape.a("individual_v2_signature_download_fail", "tlpId:" + paramString1 + " errCode:" + localbatm.a + " errMsg:" + localbatm.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvb
 * JD-Core Version:    0.7.0.1
 */