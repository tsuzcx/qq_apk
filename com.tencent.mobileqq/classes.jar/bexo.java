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

public class bexo
  extends beqz
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
    localObject = new File(bhzb.a(paramOutputStream, str));
    if (((File)localObject).exists()) {
      return localObject;
    }
    if (paramDownloadParams.useSharpPImage)
    {
      localObject = new File(blem.a((File)localObject));
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return a(paramURLDrawableHandler, paramOutputStream, str, paramDownloadParams.useSharpPImage);
  }
  
  public File a(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = a(Integer.parseInt(paramString1), paramString2);
    paramString2 = new File(bhzb.a(paramString1, paramString2));
    bihu localbihu = new bihu(str, paramString2);
    localbihu.k = paramBoolean;
    if (paramAppRuntime != null)
    {
      if (bihw.a(localbihu, paramAppRuntime) != 0) {
        break label102;
      }
      if ((!paramString2.exists()) || (SignatureManager.a(paramString2.getAbsolutePath()))) {
        break label88;
      }
      paramString2.delete();
    }
    for (;;)
    {
      return new File(antf.ba);
      label88:
      if (SharpPUtil.isSharpPFile(paramString2)) {
        return blem.a(paramString2);
      }
      return paramString2;
      label102:
      biaa.a(null, "individual_v2_signature_download_fail", "" + localbihu.a, "error code = " + localbihu.a + " errorMsg = " + localbihu.b + "url = " + str, null, 0.0F);
      bhzz.a("individual_v2_signature_download_fail", "tlpId:" + paramString1 + " errCode:" + localbihu.a + " errMsg:" + localbihu.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexo
 * JD-Core Version:    0.7.0.1
 */