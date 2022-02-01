import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqlf
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static Hashtable<String, ArrayList<String>>[] jdField_a_of_type_ArrayOfJavaUtilHashtable;
  private static boolean[] jdField_a_of_type_ArrayOfBoolean;
  public static final String[][] a;
  private static String[] b;
  
  static
  {
    int i = 0;
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { "q_qlogo_cn_2g", "q_qlogo_cn_3g", "q_qlogo_cn_4g", "q_qlogo_cn_wifi" }, { "p_qlogo_cn_2g", "p_qlogo_cn_3g", "p_plogo_cn_4g", "p_plogo_cn_wifi" }, { "p_qpic_cn_2g", "p_qpic_cn_3g", "p_qpic_cn_4g", "p_qpic_cn_wifi" }, { "pgdt_gtimg_cn_2g", "pgdt_gtimg_cn_3g", "pgdt_gtimg_cn_4g", "pgdt_gtimg_cn_wifi" }, { "sqimg_qq_com_2g", "sqimg_qq_com_3g", "sqimg_qq_com_4g", "sqimg_qq_com_wifi" }, { "download_wegame_qq_com_2g", "download_wegame_qq_com_3g", "download_wegame_qq_com_4g", "download_wegame_qq_com_wifi" }, { "wfqqreader_3g_qq_cn_2g", "wfqqreader_3g_qq_cn_3g", "wfqqreader_3g_qq_cn_4g", "wfqqreader_3g_qq_cn_wifi" }, { "buluo_qq_com_2g", "buluo_qq_com_3g", "buluo_qq_com_4g", "buluo_qq_com_wifi" } };
    jdField_a_of_type_ArrayOfBoolean = new boolean[13];
    jdField_a_of_type_ArrayOfJavaLangString = new String[14];
    b = new String[14];
    jdField_a_of_type_ArrayOfJavaUtilHashtable = new Hashtable[11];
    while (i <= 7)
    {
      jdField_a_of_type_ArrayOfJavaUtilHashtable[i] = new Hashtable(4);
      i += 1;
    }
    i = 8;
    while (i < 11)
    {
      jdField_a_of_type_ArrayOfJavaUtilHashtable[i] = new Hashtable(3);
      i += 1;
    }
  }
  
  public static String a()
  {
    String str = String.valueOf(bgnt.a(BaseApplicationImpl.getApplication().getApplicationContext()));
    if ((str.equals(b[12])) && (!TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[12]))) {
      return jdField_a_of_type_ArrayOfJavaLangString[12];
    }
    Object localObject = bdud.a().a(12);
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
      return null;
    }
    localObject = (FileStorageServerListInfo)((ArrayList)localObject).get((int)(Math.random() * ((ArrayList)localObject).size() + 1.0D));
    if (localObject == null) {
      return null;
    }
    b[12] = str;
    jdField_a_of_type_ArrayOfJavaLangString[12] = ((FileStorageServerListInfo)localObject).sIP;
    return jdField_a_of_type_ArrayOfJavaLangString[12];
  }
  
  public static String a(int paramInt)
  {
    int i = bgnt.a(BaseApplicationImpl.getApplication().getApplicationContext());
    if (i == 1) {
      i = 3;
    }
    while ((jdField_a_of_type_Array2dOfJavaLangString[paramInt][i].equals(b[paramInt])) && (!TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[paramInt])))
    {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      if (i == 2)
      {
        i = 0;
      }
      else if (i == 3)
      {
        i = 1;
      }
      else if (i == 4)
      {
        i = 2;
      }
      else
      {
        QLog.i("PicIPManager", 1, "getIpList netType unknown netType=" + i);
        return null;
      }
    }
    int j;
    if (jdField_a_of_type_ArrayOfBoolean[paramInt] == 0)
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("QQHeadIPList", 4);
      if (localObject == null) {
        return null;
      }
      j = 0;
      while (j <= 3)
      {
        String str = ((SharedPreferences)localObject).getString(jdField_a_of_type_Array2dOfJavaLangString[paramInt][j], null);
        if (!TextUtils.isEmpty(str))
        {
          String[] arrayOfString = str.split("\\|");
          if ((arrayOfString != null) && (arrayOfString.length > 0))
          {
            ArrayList localArrayList = new ArrayList();
            int k = 0;
            while (k < arrayOfString.length)
            {
              localArrayList.add(arrayOfString[k]);
              k += 1;
            }
            jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].put(jdField_a_of_type_Array2dOfJavaLangString[paramInt][j], localArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.i("PicIPManager", 2, "getIpList array=" + str);
          }
        }
        j += 1;
      }
      jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
    }
    Object localObject = (ArrayList)jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].get(jdField_a_of_type_Array2dOfJavaLangString[paramInt][i]);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      j = (int)(Math.random() * ((ArrayList)localObject).size());
      jdField_a_of_type_ArrayOfJavaLangString[paramInt] = ((String)((ArrayList)localObject).get(j));
      b[paramInt] = jdField_a_of_type_Array2dOfJavaLangString[paramInt][i];
    }
    return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicIPManager", 2, "resetInitedFlag.");
    }
    int i = 0;
    while (i <= 7)
    {
      jdField_a_of_type_ArrayOfBoolean[i] = false;
      i += 1;
    }
  }
  
  public static void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList, QQAppInterface paramQQAppInterface)
  {
    int i = bgnt.a(BaseApplicationImpl.getApplication().getApplicationContext());
    int j;
    SharedPreferences localSharedPreferences;
    if (i == 1)
    {
      j = 3;
      if (QLog.isColorLevel()) {
        QLog.i("PicIPManager", 2, "saveQQHeadIpList netType=" + i);
      }
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("QQHeadIPList", 4);
      if (localSharedPreferences == null) {
        break label777;
      }
    }
    label777:
    for (Object localObject1 = localSharedPreferences.edit();; localObject1 = null)
    {
      i = 0;
      Object localObject2;
      for (;;)
      {
        if (i <= 7)
        {
          localObject2 = (ArrayList)jdField_a_of_type_ArrayOfJavaUtilHashtable[i].get(Integer.valueOf(j));
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
            ((ArrayList)localObject2).clear();
          }
          if (localObject1 != null) {
            ((SharedPreferences.Editor)localObject1).putString(jdField_a_of_type_Array2dOfJavaLangString[i][j], "");
          }
          jdField_a_of_type_ArrayOfJavaLangString[i] = null;
          b[i] = null;
          i += 1;
          continue;
          if (i == 2)
          {
            j = 0;
            break;
          }
          if (i == 3)
          {
            j = 1;
            break;
          }
          if (i == 4)
          {
            j = 2;
            break;
          }
          QLog.i("PicIPManager", 1, "saveQQHeadIpList netType unknown netType=" + i);
          return;
        }
      }
      if (localObject1 != null) {
        ((SharedPreferences.Editor)localObject1).commit();
      }
      if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.domainIpChannel != null) && (paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists != null))
      {
        paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.iterator();
        while (paramFileStoragePushFSSvcList.hasNext())
        {
          localObject1 = (DomainIpList)paramFileStoragePushFSSvcList.next();
          if ((((DomainIpList)localObject1).vIplist != null) && (((DomainIpList)localObject1).vIplist.size() != 0))
          {
            localObject2 = new StringBuilder();
            i = 0;
            while (i < ((DomainIpList)localObject1).vIplist.size())
            {
              ((StringBuilder)localObject2).append(bgnt.a(((DomainIpInfo)((DomainIpList)localObject1).vIplist.get(i)).uIp));
              if (i < ((DomainIpList)localObject1).vIplist.size() - 1) {
                ((StringBuilder)localObject2).append("|");
              }
              i += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.i("PicIPManager", 2, "saveQQHeadIpList.uDomain_type=" + ((DomainIpList)localObject1).uDomain_type + ".strBuilder=" + ((StringBuilder)localObject2).toString());
            }
            if (((DomainIpList)localObject1).uDomain_type == 8) {
              i = 0;
            }
            ArrayList localArrayList;
            for (;;)
            {
              if ((((DomainIpList)localObject1).vIplist == null) || (((DomainIpList)localObject1).vIplist.size() == 0)) {
                break label664;
              }
              localObject2 = new StringBuilder();
              localArrayList = new ArrayList();
              int k = 0;
              while (k < ((DomainIpList)localObject1).vIplist.size())
              {
                String str = bgnt.a(((DomainIpInfo)((DomainIpList)localObject1).vIplist.get(k)).uIp);
                localArrayList.add(str);
                ((StringBuilder)localObject2).append(str);
                if (k < ((DomainIpList)localObject1).vIplist.size() - 1) {
                  ((StringBuilder)localObject2).append("|");
                }
                k += 1;
              }
              if (((DomainIpList)localObject1).uDomain_type == 9)
              {
                i = 1;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 10)
              {
                i = 2;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 11)
              {
                i = 3;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 12)
              {
                i = 4;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 13)
              {
                i = 5;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 14)
              {
                i = 6;
              }
              else
              {
                if (((DomainIpList)localObject1).uDomain_type != 15) {
                  break;
                }
                i = 7;
              }
            }
            label664:
            continue;
            jdField_a_of_type_ArrayOfJavaUtilHashtable[i].put(jdField_a_of_type_Array2dOfJavaLangString[i][j], localArrayList);
            if (QLog.isColorLevel()) {
              QLog.i("PicIPManager", 2, "saveQQHeadIpList.sIpList=" + localArrayList + ",sb=" + ((StringBuilder)localObject2).toString());
            }
            if (localSharedPreferences != null) {
              localSharedPreferences.edit().putString(jdField_a_of_type_Array2dOfJavaLangString[i][j], ((StringBuilder)localObject2).toString()).commit();
            }
          }
        }
      }
      paramQQAppInterface.a().d();
      return;
    }
  }
  
  public static String b()
  {
    String str = String.valueOf(bgnt.a(BaseApplicationImpl.getApplication().getApplicationContext()));
    if ((str.equals(b[13])) && (!TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[13]))) {
      return jdField_a_of_type_ArrayOfJavaLangString[13];
    }
    Object localObject = bdud.a().a(14);
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
      return null;
    }
    localObject = (FileStorageServerListInfo)((ArrayList)localObject).get((int)(Math.random() * ((ArrayList)localObject).size() + 1.0D));
    if (localObject == null) {
      return null;
    }
    b[13] = str;
    jdField_a_of_type_ArrayOfJavaLangString[13] = ((FileStorageServerListInfo)localObject).sIP;
    return jdField_a_of_type_ArrayOfJavaLangString[13];
  }
  
  public static String b(int paramInt)
  {
    String str1 = String.valueOf(bgln.e());
    if ((str1.equals(b[paramInt])) && (!TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[paramInt]))) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    String str2;
    Object localObject1;
    if (jdField_a_of_type_ArrayOfBoolean[paramInt] == 0)
    {
      str2 = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadDirectIP");
      if (QLog.isColorLevel()) {
        QLog.i("PicIPManager", 2, "getQzoneIp " + str2);
      }
      if (TextUtils.isEmpty(str2)) {
        return null;
      }
      localObject1 = "";
      if (paramInt == 10) {
        localObject1 = ".*qzonestyle.gtimg.cn";
      }
      while (TextUtils.isEmpty((CharSequence)localObject1))
      {
        return null;
        if (paramInt == 8) {
          localObject1 = "ugc.qpic.cn";
        } else if (paramInt == 9) {
          localObject1 = "a[0-9].qpic.cn";
        } else if (paramInt == 11) {
          localObject1 = ".*qzs.qq.com";
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(str2).getJSONArray((String)localObject1);
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          str2 = ((JSONObject)localObject2).getString("apn");
          localObject2 = ((JSONObject)localObject2).getString("ip");
          ArrayList localArrayList2 = (ArrayList)jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].get(str2);
          if (localArrayList2 == null)
          {
            localArrayList2 = new ArrayList();
            localArrayList2.add(localObject2);
            jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].put(str2, localArrayList2);
          }
          else
          {
            localArrayList2.add(localObject2);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException.printStackTrace();
        }
      }
      for (;;)
      {
        ArrayList localArrayList1 = (ArrayList)jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].get(str1);
        if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
          break;
        }
        i = (int)(Math.random() * localArrayList1.size());
        jdField_a_of_type_ArrayOfJavaLangString[paramInt] = ((String)localArrayList1.get(i));
        b[paramInt] = str1;
        return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
        jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
      }
      return null;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqlf
 * JD-Core Version:    0.7.0.1
 */