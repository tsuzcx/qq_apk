import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class bomy
{
  public bonb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
      }
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("pendantMD5")) {
          break label142;
        }
        paramString = ((JSONObject)localObject).getString("pendantMD5");
        if (!((JSONObject)localObject).has("pendantUrl")) {
          break label136;
        }
        str = ((JSONObject)localObject).getString("pendantUrl");
        if (!((JSONObject)localObject).has("pendantName")) {
          break label130;
        }
        localObject = ((JSONObject)localObject).getString("pendantName");
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("ConfigSimplifier_PTV", 2, "zipMd5 or zipUrl empty return!");
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = new bonb((String)localObject, str, paramString);
      return paramString;
      label130:
      Object localObject = "";
      continue;
      label136:
      String str = "";
      continue;
      label142:
      paramString = "";
    }
  }
  
  public bonb a(String paramString1, String paramString2, String paramString3, bona parambona)
  {
    bonb localbonb = a(paramString1);
    if (localbonb == null) {
      paramString1 = null;
    }
    do
    {
      for (;;)
      {
        return paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSimplifier_PTV", 2, "parseConfigZip md5=" + localbonb.c + " url=" + localbonb.b + " name=" + localbonb.a);
        }
        try
        {
          paramString1 = paramString2 + File.separator;
          String str = paramString2 + File.separator + localbonb.a;
          File localFile = new File(paramString2, paramString3);
          if (localFile.exists())
          {
            localFile.delete();
            if (QLog.isColorLevel()) {
              QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip file.delete()");
            }
          }
          localObject = new File(str);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip filejson.delete()");
            }
          }
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).mCallback = new bomz(this, paramString2, paramString3, localbonb, paramString1, str, parambona);
          ((HttpNetReq)localObject).mReqUrl = localbonb.b;
          ((HttpNetReq)localObject).mHttpMethod = 0;
          ((HttpNetReq)localObject).mOutPath = localFile.getPath();
          ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        }
        catch (Exception paramString2)
        {
          try
          {
            Object localObject;
            paramString1 = BaseApplicationImpl.getApplication().getRuntime();
            if (QQAppInterface.class.isInstance(paramString1))
            {
              ((QQAppInterface)paramString1).getNetEngine(0).sendReq((NetReq)localObject);
              paramString1 = localbonb;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ConfigSimplifier", 2, "startDownloadFilterConfigZip, url: " + localbonb.b);
              return localbonb;
            }
            paramString1 = localbonb;
            if (bofz.a() == null) {
              continue;
            }
            bofz.a().getNetEngine(0).sendReq((NetReq)localObject);
            return localbonb;
          }
          catch (Exception paramString1) {}
          paramString2 = paramString2;
          paramString1 = localbonb;
        }
      }
    } while (!QLog.isColorLevel());
    paramString2.printStackTrace();
    return localbonb;
    return localbonb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomy
 * JD-Core Version:    0.7.0.1
 */