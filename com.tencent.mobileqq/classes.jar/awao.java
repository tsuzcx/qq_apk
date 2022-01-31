import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.InetAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class awao
  implements baug
{
  private static int jdField_a_of_type_Int = 3;
  static bauf jdField_a_of_type_Bauf = new awap();
  private baue jdField_a_of_type_Baue;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<awaq> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public awao(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a()
  {
    if (bdep.a()) {
      return alof.aX + "OlympicRes/";
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "OlympicRes/";
  }
  
  public static String a(String paramString)
  {
    String str = a() + paramString + "_dir" + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("OlympicResources", 2, "getUncompressedZipFileDir ,md = " + paramString + ",dir = " + str);
    }
    return str;
  }
  
  private void a(String paramString1, String paramString2, Object paramObject, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicResources", 2, "retry.url" + paramString1 + ",md5=" + paramString2 + ",userData=" + paramObject + ",retryCount=" + paramInt1);
    }
    if (this.jdField_a_of_type_Baue == null) {
      this.jdField_a_of_type_Baue = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    }
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_JavaLangString = paramString1;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.c = paramString3;
    localbaub.e = 1;
    localbaub.a(new Object[] { paramString2, paramObject, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    localbaub.jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
    this.jdField_a_of_type_Baue.a(localbaub);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(a() + paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OlympicResources", 2, "isNeedDownload ,md = " + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || (this.jdField_a_of_type_JavaUtilSet.contains(paramString1))) {}
    for (;;)
    {
      return false;
      try
      {
        String str = a();
        paramString2 = new File(str + paramString1 + paramString2);
        if (!paramString2.exists())
        {
          this.jdField_a_of_type_JavaUtilSet.add(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("OlympicResources", 2, "isNeedDownload. file not exist,md = " + paramString1 + ",file = " + paramString2.getAbsolutePath());
          }
          return true;
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OlympicResources", 2, "isNeedDownload.exception happen.e=" + paramString1.getMessage());
        }
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  public void a(awaq paramawaq)
  {
    if (paramawaq == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramawaq)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramawaq);
  }
  
  public boolean a(String paramString1, String paramString2, Object paramObject, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicResources", 2, "downLoad.url" + paramString1 + ",md5=" + paramString2 + ",userData=" + paramObject);
    }
    if ((paramObject != null) && ((paramObject instanceof String)) && ("mp4".equals(paramObject))) {}
    String str2;
    for (String str1 = ".mp4";; str2 = "")
    {
      if (!a(paramString2, str1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OlympicResources", 2, "downLoad.not need to download.md5=" + paramString2 + ",url=" + paramString1);
        }
        if ((paramObject != null) && ((paramObject instanceof String[])))
        {
          paramString1 = (String[])paramObject;
          paramObject = paramString1[0];
          if ((paramObject != null) && ("shuayishua_anim".equals(paramObject)))
          {
            str1 = a(paramString2);
            localObject = str1 + "pullfire";
            String str3 = str1 + "takefire";
            String str4 = str1 + "firestart";
            String str5 = str1 + "fire";
            if ((bdhb.a((String)localObject)) && (bdhb.a(str3)) && (bdhb.a(str4)) && (bdhb.a(str5))) {}
          }
        }
        try
        {
          localObject = new File(str1);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
          bdhb.a(a() + paramString2, str1, false);
          if (QLog.isColorLevel()) {
            QLog.d("OlympicResources", 2, "re un compressZip shuayishua_anim success.destDir=" + str1);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("OlympicResources", 2, "re un compressZip shuayishua_anim failed: " + localException.getMessage());
            }
          }
        }
        if ((paramObject != null) && ("ActConfig".equals(paramObject)))
        {
          paramString1 = paramString1[1];
          if ((paramString1 != null) && ("TorchAnim".equals(paramString1)))
          {
            paramString1 = a(paramString2);
            if (bdhb.a(paramString1 + "fire")) {}
          }
        }
        try
        {
          paramObject = new File(paramString1);
          if (paramObject.exists()) {
            paramObject.delete();
          }
          bdhb.a(a() + paramString2, paramString1, false);
          if (QLog.isColorLevel()) {
            QLog.d("OlympicResources", 2, "re un compressZip TorchAnim success.destDir=" + paramString1);
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("OlympicResources", 2, "re un compressZip TorchAnim failed: " + paramString1.getMessage());
            }
          }
        }
        return false;
      }
      if (paramBoolean2)
      {
        localObject = (OlympicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(167);
        if (localObject != null)
        {
          if (!((OlympicManager)localObject).b(paramString1))
          {
            awci.b("OlympicResources", new Object[] { "download, checkLimit == false, url=", paramString1 });
            return true;
          }
          ((OlympicManager)localObject).a(paramString1, 1, false);
        }
      }
      if (this.jdField_a_of_type_Baue == null) {
        this.jdField_a_of_type_Baue = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
      }
      Object localObject = new baub();
      ((baub)localObject).jdField_a_of_type_Baug = this;
      ((baub)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((baub)localObject).jdField_a_of_type_Int = 0;
      ((baub)localObject).c = (a() + paramString2 + localException);
      ((baub)localObject).e = 1;
      ((baub)localObject).a(new Object[] { paramString2, paramObject, Integer.valueOf(0), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt) });
      ((baub)localObject).jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
      this.jdField_a_of_type_Baue.a((bave)localObject);
      return true;
    }
  }
  
  public void b(awaq paramawaq)
  {
    if (paramawaq == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramawaq);
  }
  
  public void onResp(bavf parambavf)
  {
    boolean bool1;
    baub localbaub;
    Object localObject2;
    Object localObject1;
    int i;
    String str1;
    label57:
    Object localObject4;
    Object localObject5;
    int k;
    boolean bool2;
    int j;
    long l;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localbaub = (baub)parambavf.jdField_a_of_type_Bave;
      localObject2 = new File(localbaub.c);
      localObject1 = localbaub.a();
      i = parambavf.b;
      if (parambavf.jdField_a_of_type_JavaLangString != null) {
        break label636;
      }
      str1 = "0";
      if ((localObject1 == null) || (!(localObject1 instanceof Object[]))) {
        break label888;
      }
      localObject1 = (Object[])localObject1;
      localObject4 = (String)localObject1[0];
      localObject5 = localObject1[1];
      k = ((Integer)localObject1[2]).intValue();
      bool2 = ((Boolean)localObject1[3]).booleanValue();
      j = ((Integer)localObject1[4]).intValue();
      if (!bool1) {
        break label662;
      }
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
      }
      localObject1 = awni.a(((File)localObject2).getAbsolutePath());
      if (((String)localObject4).equals(localObject1)) {
        break label645;
      }
      ((File)localObject2).delete();
      bool1 = false;
      QLog.i("OlympicResources", 1, "onResp.md5 verify fail.md5=" + (String)localObject4 + ",calMD5=" + (String)localObject1);
      l = 0L;
      i = -6103066;
      localObject1 = null;
    }
    for (;;)
    {
      label241:
      HashMap localHashMap;
      label267:
      String str2;
      Object localObject3;
      if ((j == 1) || (j == 2))
      {
        if (j == 1)
        {
          localObject2 = "olympic_down_shua";
          if (i != 0) {
            break label807;
          }
          j = 1;
          localHashMap = new HashMap();
          localHashMap.put("param_FailCode", String.valueOf(i));
          localHashMap.put("url", awci.a(localbaub.jdField_a_of_type_JavaLangString));
          localHashMap.put("err_desc", str1);
          str2 = "0";
          localObject3 = str2;
          if (parambavf.jdField_a_of_type_JavaUtilHashMap != null)
          {
            localObject3 = str2;
            if (parambavf.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")) {
              localObject3 = (String)parambavf.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
            }
          }
          localHashMap.put("netresp_param_reason", localObject3);
          str2 = "0";
          if (j == 0) {
            break label812;
          }
          localHashMap.put("file_size", String.valueOf(l));
          localHashMap.put("cdn_ip", "0");
          azri.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject2, true, 0L, l, localHashMap, "", false);
          awci.b("OlympicResources", new Object[] { "onResp report Download, reportKey=", localObject2, ", errcode=", Integer.valueOf(i), ", url=", localbaub.jdField_a_of_type_JavaLangString });
        }
      }
      else
      {
        localObject3 = localObject1;
        localObject2 = localObject5;
        localObject1 = localObject4;
        label499:
        if (QLog.isColorLevel()) {
          QLog.i("OlympicResources", 2, "onResp.url=" + localbaub.jdField_a_of_type_JavaLangString + ", result=" + parambavf.jdField_a_of_type_Int + ", errCode=" + i + ",md5 = " + (String)localObject1);
        }
        j = 0;
        for (;;)
        {
          if (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            localObject4 = (awaq)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localObject4 != null) {
              ((awaq)localObject4).a(localbaub.jdField_a_of_type_JavaLangString, (String)localObject1, localObject2, i, (String)localObject3);
            }
            j += 1;
            continue;
            bool1 = false;
            break;
            label636:
            str1 = parambavf.jdField_a_of_type_JavaLangString;
            break label57;
            label645:
            localObject1 = ((File)localObject2).getAbsolutePath();
            l = ((File)localObject2).length();
            break label241;
            label662:
            if ((localObject2 != null) && (((File)localObject2).exists())) {
              ((File)localObject2).delete();
            }
            if ((k >= jdField_a_of_type_Int) || (!bool2)) {
              break label1015;
            }
            if (QLog.isColorLevel()) {
              QLog.i("OlympicResources", 2, "onResp.retry.url=" + localbaub.jdField_a_of_type_JavaLangString + ",md5=" + (String)localObject4 + ", result=" + parambavf.jdField_a_of_type_Int + ", errCode=" + i + ",retryCount=" + k);
            }
            a(localbaub.jdField_a_of_type_JavaLangString, (String)localObject4, localObject5, k + 1, bool2, j, localbaub.c);
          }
        }
      }
      label807:
      label812:
      label888:
      while (bool1)
      {
        for (;;)
        {
          return;
          localObject2 = "olympic_down_act";
          break;
          j = 0;
          break label267;
          try
          {
            localObject3 = InetAddress.getByName("hb.url.cn").getHostAddress();
            localHashMap.put("cdn_ip", localObject3);
            azri.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject2, false, 0L, 0L, localHashMap, "", false);
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localObject3 = str2;
              if (QLog.isColorLevel())
              {
                localThrowable.printStackTrace();
                localObject3 = str2;
              }
            }
          }
        }
        ((File)localObject2).delete();
        azri.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "olympic_down_null", bool1, 0L, 0L, null, "", false);
        localObject3 = null;
        localObject2 = null;
        localObject1 = null;
        break label499;
      }
      QLog.i("OlympicResources", 1, "onResp.url=" + localbaub.jdField_a_of_type_JavaLangString + ", result=" + parambavf.jdField_a_of_type_Int + ", errCode=" + i + ",md5 = " + (String)localObject1 + ", errDesc=" + str1);
      return;
      label1015:
      localObject1 = null;
      l = 0L;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    Object localObject = null;
    if ((parambave == null) || (!(parambave instanceof baub))) {
      return;
    }
    String str = ((baub)parambave).jdField_a_of_type_JavaLangString;
    parambave = parambave.a();
    if ((parambave != null) && ((parambave instanceof Object[])))
    {
      localObject = (Object[])parambave;
      parambave = (String)localObject[0];
      localObject = localObject[1];
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OlympicResources", 2, "onUpdateProgeress.url=" + str + ", md5=" + parambave + ", userData=" + localObject + ",curOffset=" + paramLong1 + ",totalLen=" + paramLong2);
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        awaq localawaq = (awaq)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localawaq != null) {
          localawaq.a(str, parambave, localObject, paramLong1, paramLong2);
        }
        i += 1;
      }
      break;
      parambave = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awao
 * JD-Core Version:    0.7.0.1
 */