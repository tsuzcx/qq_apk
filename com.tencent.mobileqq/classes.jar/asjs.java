import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.VasEmojiManager.1;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
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

public class asjs
{
  public static HashMap<String, asiz> a;
  public asih a;
  private bhyn a;
  public QQAppInterface a;
  public ConcurrentHashMap<String, Bundle> a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public asjs(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Bhyn = new asjt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    this.jdField_a_of_type_Asih = ((asih)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER));
  }
  
  public static String a(String paramString)
  {
    int i = "bqmall.android.h5magic.".length();
    return paramString.substring(i, paramString.indexOf('.', i));
  }
  
  private String a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    File localFile = new File(EmoticonUtils.emoticonJsonFilePath.replace("[epId]", paramString1));
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
    FileUtils.deleteDirectory(paramString2);
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
    asih localasih = a();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramBundle.putSerializable("emoticonList", paramArrayList);
    localasih.b(localArrayList, localHashMap, paramEmoticonPackage, paramBundle);
    int i = localasih.a(paramEmoticonPackage, paramArrayList, localArrayList, localHashMap, paramBundle, 6);
    if (i != 0)
    {
      QLog.e("VasEmojiManager", 1, "downloadOthers error : " + i);
      return;
    }
    paramArrayList = new bhyo(localArrayList, localHashMap, "vipEmoticonKey_" + paramEmoticonPackage.epId);
    paramArrayList.n = true;
    if (localArrayList.size() == 0)
    {
      paramArrayList.a(paramBundle);
      paramArrayList.a(3);
      this.jdField_a_of_type_Bhyn.onDone(paramArrayList);
    }
    for (;;)
    {
      localasih.b(paramEmoticonPackage, paramBoolean);
      return;
      localasih.a().a(paramArrayList, this.jdField_a_of_type_Bhyn, paramBundle);
    }
  }
  
  public static void a(String paramString)
  {
    paramString = a(paramString);
    VasQuickUpdateEngine.safeDeleteFile(new File(EmoticonUtils.emoticonPackageFolderPath.replace("[epId]", paramString)));
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
            asiz localasiz = new asiz();
            localasiz.jdField_a_of_type_JavaLangString = localJSONObject.getString("leftText");
            localasiz.b = localJSONObject.getString("linkText");
            localasiz.c = localJSONObject.getString("type");
            localHashMap.put(str, localasiz);
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
        str2 = EmoticonUtils.H5MagicRootPath.replace("[epId]", str1);
        localObject = str2.replace("h5magic", "tmp_unzip");
        FileUtils.uncompressZip(paramString, (String)localObject, false);
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
          asjh localasjh;
          QLog.e("VasEmojiManager", 1, "", paramString);
          bool = false;
        }
      }
      return bool;
    }
    finally {}
    FileUtils.uncompressZip(paramString, str3, false);
    localArrayList = new ArrayList();
    localasjh = new asjh();
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
        paramString = FileUtils.fileToBytes((File)localObject);
        paramString = asiw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, asih.c, paramString, localArrayList, localasjh);
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
        if ((!localasjh.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
        {
          int i = 0;
          localasjh.jdField_a_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.d("VasEmojiManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
          }
          paramString.a(paramEmoticonPackage.epId, localArrayList, localasjh);
          int j = i + 1;
          if (!localasjh.jdField_a_of_type_Boolean)
          {
            i = j;
            if (j < 3) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasEmojiManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localasjh.jdField_a_of_type_Boolean);
          }
          if (!localasjh.jdField_a_of_type_Boolean)
          {
            QLog.e("VasEmojiManager", 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localasjh.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localasjh.jdField_a_of_type_Int);
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
    return EmoticonUtils.H5MagicZipPath.replace("[epId]", paramString);
  }
  
  public asih a()
  {
    return this.jdField_a_of_type_Asih;
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
    localBundle.putBoolean("isUpdate", EmoticonUtils.emoticonPkgNeedUpdate(paramEmoticonPackage));
    localBundle.putLong("vas_download_start", System.currentTimeMillis());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonPackage.epId, localBundle);
    a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEmoticonPackage.epId, new asjr(paramEmoticonPackage.epId, null));
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
      EmoticonPackage localEmoticonPackage = ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(str);
      localObject1 = localEmoticonPackage;
      if (localEmoticonPackage == null)
      {
        localObject1 = new EmoticonPackage();
        ((EmoticonPackage)localObject1).name = anvx.a(2131715400);
        ((EmoticonPackage)localObject1).epId = str;
        ((EmoticonPackage)localObject1).jobType = 5;
        ((EmoticonPackage)localObject1).type = 1;
        ((EmoticonPackage)localObject1).aio = true;
        ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
      }
      ((Bundle)localObject2).putSerializable("emoticonPackage", (Serializable)localObject1);
      ((Bundle)localObject2).putBoolean("newPkgAdd", false);
      ((Bundle)localObject2).putBoolean("wifiAutoDownload", false);
      ((Bundle)localObject2).putBoolean("isUpdate", EmoticonUtils.emoticonPkgNeedUpdate((EmoticonPackage)localObject1));
      ((Bundle)localObject2).putLong("vas_download_start", System.currentTimeMillis());
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
      if ((paramInt != 0) || (!a(b(paramString), (Bundle)localObject1, (EmoticonPackage)localObject2))) {
        asih.jdField_a_of_type_Asig.a((EmoticonPackage)localObject2, paramInt, 8, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      return;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    paramString = a(paramString);
    asjr localasjr = (asjr)a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localasjr != null) {
      localasjr.a((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    paramString = (Bundle)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null)
    {
      paramString = (EmoticonPackage)paramString.getSerializable("emoticonPackage");
      asih.jdField_a_of_type_Asig.b(paramString, (int)paramLong1, (int)paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjs
 * JD-Core Version:    0.7.0.1
 */