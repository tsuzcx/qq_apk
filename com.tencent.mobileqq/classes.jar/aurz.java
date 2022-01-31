import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import org.xmlpull.v1.XmlPullParser;

public class aurz
{
  public static int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("precover_config_version_" + paramString, 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("PRECOVER_SP_NAME", 0).getInt(paramString, paramInt);
  }
  
  public static Pair<aurq, List<PrecoverResource>> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverUtils", 2, "parseConfig, xmlContent is empty!");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverUtils", 2, "parseConfig, xmlContent=" + paramString);
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
        localObject1 = "";
        localObject2 = null;
        paramString = null;
        localObject4 = paramString;
        if (i == 1) {
          continue;
        }
        localObject6 = localObject2;
        localObject8 = paramString;
        localObject9 = localObject1;
        localObject7 = localObject2;
        localObject4 = paramString;
        localObject5 = localObject1;
        switch (i)
        {
        default: 
          localObject9 = localObject1;
          localObject8 = paramString;
          localObject6 = localObject2;
        case 1: 
          label173:
          paramString = localObject9;
          localObject2 = localObject6;
        }
      }
      catch (Exception paramString)
      {
        int i;
        Object localObject1;
        Object localObject2;
        Object localObject4;
        Object localObject6;
        Object localObject9;
        Object localObject7;
        Object localObject5;
        Object localObject3 = null;
        continue;
        continue;
        Object localObject8 = paramString;
        paramString = localException;
        continue;
      }
      localObject3 = localObject8;
      try
      {
        i = localXmlPullParser.next();
        localObject1 = paramString;
        paramString = (String)localObject8;
      }
      catch (Exception paramString) {}
      localObject6 = localObject2;
      localObject8 = paramString;
      localObject9 = localObject1;
      localObject3 = paramString;
      if (QLog.isColorLevel())
      {
        localObject3 = paramString;
        QLog.d("PrecoverUtils", 2, "parseConfig, START_DOCUMENT");
        localObject8 = paramString;
        paramString = (String)localObject1;
      }
    }
    localObject3 = paramString;
    localObject6 = localXmlPullParser.getName();
    localObject3 = paramString;
    if (QLog.isColorLevel())
    {
      localObject3 = paramString;
      QLog.d("PrecoverUtils", 2, "parseConfig, START_TAG, tag=" + (String)localObject6);
    }
    localObject3 = paramString;
    if ("PrecoverInfo".equalsIgnoreCase((String)localObject6))
    {
      localObject5 = localObject6;
      localObject4 = paramString;
      localObject7 = localObject2;
    }
    for (;;)
    {
      localObject6 = localObject7;
      localObject8 = localObject4;
      localObject9 = localObject5;
      localObject3 = localObject4;
      if (!QLog.isColorLevel()) {
        break label173;
      }
      localObject3 = localObject4;
      QLog.d("PrecoverUtils", 2, "parseConfig, START_TAG, tag=" + localXmlPullParser.getName());
      localObject6 = localObject7;
      localObject8 = localObject4;
      localObject9 = localObject5;
      break label173;
      QLog.d("PrecoverUtils", 1, new Object[] { "parseConfig, exception=", paramString.getMessage() });
      localObject4 = localObject3;
      if (QLog.isColorLevel())
      {
        paramString.printStackTrace();
        localObject4 = localObject3;
      }
      if ((localObject4 == null) || (!((aurq)localObject4).a()) || (localArrayList.size() <= 0)) {
        break;
      }
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (PrecoverResource)paramString.next();
        if (localObject1 != null) {
          ((PrecoverResource)localObject1).businessId = ((aurq)localObject4).a;
        }
      }
      localObject3 = paramString;
      if ("PrecoverRes".equalsIgnoreCase((String)localObject6))
      {
        localObject5 = localObject6;
        localObject7 = localObject2;
        localObject4 = paramString;
      }
      else
      {
        localObject3 = paramString;
        if ("PrecoverInfo".equalsIgnoreCase((String)localObject1))
        {
          localObject3 = paramString;
          if ("id".equalsIgnoreCase((String)localObject6))
          {
            localObject3 = paramString;
            paramString = new aurq();
          }
        }
      }
      try
      {
        paramString.a = localXmlPullParser.nextText();
        localObject7 = localObject2;
        localObject4 = paramString;
        localObject5 = localObject1;
      }
      catch (Exception localException)
      {
        localObject3 = paramString;
        paramString = localException;
      }
      localObject7 = localObject2;
      localObject4 = paramString;
      localObject5 = localObject1;
      localObject3 = paramString;
      if ("name".equalsIgnoreCase((String)localObject6)) {
        if (paramString != null)
        {
          localObject3 = paramString;
          paramString.b = localXmlPullParser.nextText();
          localObject7 = localObject2;
          localObject4 = paramString;
          localObject5 = localObject1;
        }
        else
        {
          localObject7 = localObject2;
          localObject4 = paramString;
          localObject5 = localObject1;
          localObject3 = paramString;
          if (QLog.isColorLevel())
          {
            localObject3 = paramString;
            QLog.d("PrecoverUtils", 2, "parseConfig, info == null!");
            localObject7 = localObject2;
            localObject4 = paramString;
            localObject5 = localObject1;
            continue;
            localObject7 = localObject2;
            localObject4 = paramString;
            localObject5 = localObject1;
            localObject3 = paramString;
            if ("PrecoverRes".equalsIgnoreCase((String)localObject1))
            {
              localObject3 = paramString;
              if ("ResId".equalsIgnoreCase((String)localObject6))
              {
                localObject3 = paramString;
                localObject7 = new PrecoverResource();
                localObject3 = paramString;
                ((PrecoverResource)localObject7).resId = localXmlPullParser.nextText();
                localObject4 = paramString;
                localObject5 = localObject1;
              }
              else
              {
                localObject3 = paramString;
                if ("url".equalsIgnoreCase((String)localObject6))
                {
                  if (localObject2 != null)
                  {
                    localObject3 = paramString;
                    localObject2.url = localXmlPullParser.nextText();
                    localObject7 = localObject2;
                    localObject4 = paramString;
                    localObject5 = localObject1;
                  }
                  else
                  {
                    localObject7 = localObject2;
                    localObject4 = paramString;
                    localObject5 = localObject1;
                    localObject3 = paramString;
                    if (QLog.isColorLevel())
                    {
                      localObject3 = paramString;
                      QLog.d("PrecoverUtils", 2, "parseConfig, tmpRes == null!");
                      localObject7 = localObject2;
                      localObject4 = paramString;
                      localObject5 = localObject1;
                    }
                  }
                }
                else
                {
                  localObject7 = localObject2;
                  localObject4 = paramString;
                  localObject5 = localObject1;
                  localObject3 = paramString;
                  if ("md5".equalsIgnoreCase((String)localObject6)) {
                    if (localObject2 != null)
                    {
                      localObject3 = paramString;
                      localObject2.md5 = localXmlPullParser.nextText();
                      localObject3 = paramString;
                      localArrayList.add(localObject2);
                      localObject7 = localObject2;
                      localObject4 = paramString;
                      localObject5 = localObject1;
                    }
                    else
                    {
                      localObject7 = localObject2;
                      localObject4 = paramString;
                      localObject5 = localObject1;
                      localObject3 = paramString;
                      if (QLog.isColorLevel())
                      {
                        localObject3 = paramString;
                        QLog.d("PrecoverUtils", 2, "parseConfig, tmpRes == null!");
                        localObject7 = localObject2;
                        localObject4 = paramString;
                        localObject5 = localObject1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return new Pair(localObject4, localArrayList);
  }
  
  public static String a()
  {
    if (bbay.a()) {
      return ajsf.aW + "pddata/prd/" + "res_precover";
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "res_precover";
  }
  
  public static String a(ConfigurationService.Content paramContent)
  {
    if (paramContent == null) {
      return null;
    }
    String str = "";
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramContent.compress.get() == 1)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        paramContent = new InflaterInputStream(new ByteArrayInputStream(paramContent.content.get().toByteArray()));
        byte[] arrayOfByte = new byte[256];
        for (;;)
        {
          int i = paramContent.read(arrayOfByte);
          if (-1 == i) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        if (paramContent != null) {
          break label130;
        }
      }
      catch (Throwable paramContent)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverUtils", 2, "uncompressConfigContent");
          paramContent.printStackTrace();
        }
        paramContent = null;
      }
      QLog.d("PrecoverUtils", 1, "uncompressConfigContent, uncompress failed");
      paramContent = str;
    }
    for (;;)
    {
      return paramContent;
      paramContent = localByteArrayOutputStream.toByteArray();
      break;
      try
      {
        label130:
        str = new String(paramContent, "UTF-8");
        paramContent = str;
      }
      catch (UnsupportedEncodingException paramContent)
      {
        if (QLog.isColorLevel()) {
          paramContent.printStackTrace();
        }
        QLog.d("PrecoverUtils", 1, "uncompressConfigContent, exception=" + paramContent.getMessage());
        paramContent = null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          localOutOfMemoryError.printStackTrace();
        }
        QLog.d("PrecoverUtils", 1, "uncompressConfigContent, oom=" + localOutOfMemoryError.getMessage());
        System.gc();
        try
        {
          paramContent = new String(paramContent, "UTF-8");
        }
        catch (Throwable paramContent)
        {
          paramContent = null;
        }
      }
      continue;
      paramContent = paramContent.content.get().toStringUtf8();
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a() + File.separator + paramString + File.separator;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return a(paramString1) + paramString2;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("precover_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("PRECOVER_SP_NAME", 0).edit().putLong(paramString, System.currentTimeMillis()).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface.getApp().getSharedPreferences("PRECOVER_SP_NAME", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (Math.abs(System.currentTimeMillis() - paramContext.getSharedPreferences("PRECOVER_SP_NAME", 0).getLong(paramString, -1L)) > 86400000L) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString1 = a(paramString1, paramString2);
    } while (TextUtils.isEmpty(paramString1));
    return new File(paramString1).exists();
  }
  
  public static String b(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("http://hb.url.cn/")) {
        return paramString.substring("http://hb.url.cn/".length());
      }
      str = paramString;
    } while (!paramString.startsWith("http://"));
    return paramString.substring("http://".length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurz
 * JD-Core Version:    0.7.0.1
 */