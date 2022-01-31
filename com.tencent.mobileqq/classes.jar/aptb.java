import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.VasEmojiManager.1;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aptb
{
  public static HashMap<String, apsg> a;
  public apro a;
  private bead a;
  public QQAppInterface a;
  public ConcurrentHashMap<String, Bundle> a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public aptb(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Bead = new aptc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    this.jdField_a_of_type_Apro = ((apro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43));
  }
  
  public static String a(String paramString)
  {
    int i = "bqmall.android.h5magic.".length();
    return paramString.substring(i, paramString.indexOf('.', i));
  }
  
  private String a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    File localFile = new File(apvx.r.replace("[epId]", paramString1));
    boolean bool = true;
    if (localFile.exists()) {
      bool = localFile.delete();
    }
    if (!bool) {
      return "delete jsonFile failed.";
    }
    if (!paramFile.renameTo(localFile)) {
      return "rename tmpJsonFile failed.";
    }
    bdhb.a(paramString2);
    paramFile = new File(paramString2);
    if (paramFile.exists()) {
      return "delete h5magic failed.";
    }
    if (!new File(paramString3).renameTo(paramFile)) {
      return "rename tmpUnzipPath failed.";
    }
    a().a(paramString1, paramString2);
    return null;
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    apro localapro = a();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramBundle.putSerializable("emoticonList", paramArrayList);
    localapro.b(localArrayList, localHashMap, paramEmoticonPackage, paramBundle);
    int i = localapro.a(paramEmoticonPackage, paramArrayList, localArrayList, localHashMap, paramBundle, 6);
    if (i != 0)
    {
      QLog.e("VasEmojiManager", 1, "downloadOthers error : " + i);
      return;
    }
    paramArrayList = new beae(localArrayList, localHashMap, "vipEmoticonKey_" + paramEmoticonPackage.epId);
    paramArrayList.n = true;
    if (localArrayList.size() == 0)
    {
      paramArrayList.a(paramBundle);
      paramArrayList.a(3);
      this.jdField_a_of_type_Bead.onDone(paramArrayList);
    }
    for (;;)
    {
      localapro.b(paramEmoticonPackage, paramBoolean);
      return;
      localapro.a().a(paramArrayList, this.jdField_a_of_type_Bead, paramBundle);
    }
  }
  
  public static void a(String paramString)
  {
    paramString = a(paramString);
    VasQuickUpdateEngine.safeDeleteFile(new File(apvx.n.replace("[epId]", paramString)));
  }
  
  public static void a(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int i = paramJSONArray.length();
      for (;;)
      {
        if (i >= 0)
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.opt(i);
          if (localJSONObject != null) {}
          try
          {
            String str = localJSONObject.getString("id");
            apsg localapsg = new apsg();
            localapsg.jdField_a_of_type_JavaLangString = localJSONObject.getString("leftText");
            localapsg.b = localJSONObject.getString("linkText");
            localapsg.c = localJSONObject.getString("type");
            localHashMap.put(str, localapsg);
            i -= 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              QLog.e("VasEmojiManager", 1, "setMagicTips: ", localJSONException);
            }
          }
        }
      }
    }
    jdField_a_of_type_JavaUtilHashMap = localHashMap;
  }
  
  private boolean a(String paramString, Bundle paramBundle, EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    String str1;
    label125:
    try
    {
      bool = paramBundle.getBoolean("newPkgAdd");
      str1 = paramEmoticonPackage.epId;
      try
      {
        str2 = apvx.v.replace("[epId]", str1);
        localObject = str2.replace("h5magic", "tmp_unzip");
        bdhb.a(paramString, (String)localObject, false);
        paramString = (String)localObject + "h5.zip";
        str3 = (String)localObject + "h5magic";
        if (new File(paramString).exists()) {
          break label125;
        }
        QLog.e("VasEmojiManager", 1, "h5.zip is not exist");
        bool = false;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          String str2;
          Object localObject;
          String str3;
          ArrayList localArrayList;
          apsq localapsq;
          QLog.e("VasEmojiManager", 1, "", paramString);
          bool = false;
        }
      }
      return bool;
    }
    finally {}
    bdhb.a(paramString, str3, false);
    localArrayList = new ArrayList();
    localapsq = new apsq();
    localObject = new File((String)localObject + str1 + "_android.json");
    paramString = null;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          break label641;
        }
        paramString = bdhb.a((File)localObject);
        paramString = apsd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, apro.c, paramString, localArrayList, localapsq);
        if (paramString != null)
        {
          QLog.e("VasEmojiManager", 1, "parseJsonError: " + paramString);
          bool = false;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("VasEmojiManager", 1, "OutOfMemoryError e = " + paramString.getMessage());
        paramString = null;
        continue;
        if (paramEmoticonPackage.jobType != 5)
        {
          QLog.e("VasEmojiManager", 1, "not support jobType: " + paramEmoticonPackage.jobType);
          bool = false;
          break;
        }
        paramString = a();
        if ((!localapsq.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
        {
          int i = 0;
          localapsq.jdField_a_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.d("VasEmojiManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
          }
          paramString.a(paramEmoticonPackage.epId, localArrayList, localapsq);
          int j = i + 1;
          if (!localapsq.jdField_a_of_type_Boolean)
          {
            i = j;
            if (j < 3) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasEmojiManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localapsq.jdField_a_of_type_Boolean);
          }
          if (!localapsq.jdField_a_of_type_Boolean)
          {
            QLog.e("VasEmojiManager", 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localapsq.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localapsq.jdField_a_of_type_Int);
            bool = false;
            break;
          }
        }
        paramString = a(str1, str2, str3, (File)localObject);
        if (paramString != null)
        {
          QLog.e("VasEmojiManager", 1, "moveFiles error: " + paramString);
          bool = false;
          break;
        }
        a(paramEmoticonPackage, localArrayList, bool, paramBundle);
        bool = true;
      }
      break;
      label641:
      paramString = null;
    }
  }
  
  public static String b(String paramString)
  {
    paramString = a(paramString);
    return apvx.u.replace("[epId]", paramString);
  }
  
  public apro a()
  {
    return this.jdField_a_of_type_Apro;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = "bqmall.android.h5magic." + paramEmoticonPackage.epId + ".zip";
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramEmoticonPackage.epId)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean1);
    localBundle.putBoolean("wifiAutoDownload", paramBoolean2);
    localBundle.putBoolean("isUpdate", apvx.a(paramEmoticonPackage));
    localBundle.putLong("vas_download_start", System.currentTimeMillis());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonPackage.epId, localBundle);
    a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonPackage.epId, new apta(paramEmoticonPackage.epId, null));
    ThreadManager.post(new VasEmojiManager.1(this, str, paramEmoticonPackage), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt != 0) {
      QLog.e("VasEmojiManager", 1, "complete error: " + paramInt);
    }
    String str = a(paramString);
    Object localObject1 = (Bundle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new Bundle();
      EmoticonPackage localEmoticonPackage = ((aufn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(str);
      localObject1 = localEmoticonPackage;
      if (localEmoticonPackage == null)
      {
        localObject1 = new EmoticonPackage();
        ((EmoticonPackage)localObject1).name = alud.a(2131716432);
        ((EmoticonPackage)localObject1).epId = str;
        ((EmoticonPackage)localObject1).jobType = 5;
        ((EmoticonPackage)localObject1).type = 1;
        ((EmoticonPackage)localObject1).aio = true;
        ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
      }
      ((Bundle)localObject2).putSerializable("emoticonPackage", (Serializable)localObject1);
      ((Bundle)localObject2).putBoolean("newPkgAdd", false);
      ((Bundle)localObject2).putBoolean("wifiAutoDownload", false);
      ((Bundle)localObject2).putBoolean("isUpdate", apvx.a((EmoticonPackage)localObject1));
      ((Bundle)localObject2).putLong("vas_download_start", System.currentTimeMillis());
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
      if ((paramInt != 0) || (!a(b(paramString), (Bundle)localObject1, (EmoticonPackage)localObject2))) {
        apro.jdField_a_of_type_Aprn.a((EmoticonPackage)localObject2, paramInt, 8, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      return;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    paramString = a(paramString);
    apta localapta = (apta)a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localapta != null) {
      localapta.a((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    paramString = (Bundle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null)
    {
      paramString = (EmoticonPackage)paramString.getSerializable("emoticonPackage");
      apro.jdField_a_of_type_Aprn.b(paramString, (int)paramLong1, (int)paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptb
 * JD-Core Version:    0.7.0.1
 */