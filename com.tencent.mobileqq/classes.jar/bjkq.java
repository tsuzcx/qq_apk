import android.content.Context;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class bjkq
{
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ShareProcessorUtil", 2, "reuseImageForAIO|oldCache=" + paramString1 + ",oldUrl=" + paramString2 + ",newUrl=" + paramString3);
    }
    if (paramString1 != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        if ((paramString1.equals(paramString3)) || (BaseApplicationImpl.sImageCache == null)) {
          break label193;
        }
        paramString1 = BaseApplicationImpl.sImageCache.get(paramString1);
        if (paramString1 == null) {
          break label193;
        }
        BaseApplicationImpl.sImageCache.put(paramString3, paramString1);
        bool = true;
      }
      catch (Exception paramString1)
      {
        String str;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      str = AbsDownloader.getFilePath(paramString3);
      if ((paramString2 != null) && (!paramString2.equals(paramString3)))
      {
        paramBoolean = FileUtils.copyFile(paramString1, str);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.share.ShareProcessorUtil", 2, "reuseImageForAIO|cache=" + bool + ",file=" + paramBoolean);
        return;
        paramString1 = AbsDownloader.getFilePath(paramString2);
        continue;
        QLog.d("Q.share.ShareProcessorUtil", 2, paramString1, new Object[0]);
      }
      else
      {
        paramBoolean = false;
        continue;
        label193:
        bool = false;
        if (paramBoolean) {
          paramString1 = paramString2;
        }
      }
    }
  }
  
  public static Object[] a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ShareProcessorUtil", 2, "getRichInfo|targetUrl=" + paramString1);
    }
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = Integer.valueOf(-1);
    arrayOfObject1[1] = null;
    arrayOfObject1[2] = null;
    arrayOfObject1[3] = null;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return arrayOfObject1;
    }
    for (;;)
    {
      try
      {
        paramContext = HttpUtil.openRequest(paramContext, String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { paramString2, URLEncoder.encode(paramString1) }), null, "GET", null, null, 5000, 5000);
        if (paramContext == null) {
          break;
        }
        i = paramContext.getStatusLine().getStatusCode();
        if (i == 200)
        {
          paramContext = HttpUtil.readHttpResponse(paramContext);
          if (QLog.isColorLevel()) {
            QLog.d("Q.share.ShareProcessorUtil", 2, "getRichInfo|result=" + paramContext);
          }
          if (TextUtils.isEmpty(paramContext)) {
            break label382;
          }
          paramString2 = new JSONObject(paramContext);
          if (!paramString2.has("ret")) {
            break label377;
          }
          i = paramString2.getInt("ret");
          if (!paramString2.has("title")) {
            break label372;
          }
          paramContext = paramString2.getString("title");
          if (!paramString2.has("abstract")) {
            break label367;
          }
          paramString1 = paramString2.getString("abstract");
          if (!paramString2.has("thumbUrl")) {
            break label362;
          }
          paramString2 = paramString2.getString("thumbUrl");
          if (i != 0) {
            QLog.w("Q.share.ShareProcessorUtil", 1, "getRichInfo|ret=" + i);
          }
          Object[] arrayOfObject2 = new Object[4];
          arrayOfObject2[0] = Integer.valueOf(i);
          arrayOfObject2[1] = paramContext;
          arrayOfObject2[2] = paramString1;
          arrayOfObject2[3] = paramString2;
          return arrayOfObject2;
        }
        QLog.w("Q.share.ShareProcessorUtil", 1, "getRichInfo|httpCode=" + i);
        return arrayOfObject1;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.share.ShareProcessorUtil", 2, paramContext, new Object[0]);
      return arrayOfObject1;
      label362:
      paramString2 = null;
      continue;
      label367:
      paramString1 = null;
      continue;
      label372:
      paramContext = null;
      continue;
      label377:
      int i = -1;
    }
    label382:
    paramContext = arrayOfObject1;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjkq
 * JD-Core Version:    0.7.0.1
 */