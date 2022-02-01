import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class arro
  extends arpe<CustomEmotionData>
{
  private boolean a;
  
  public arro(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private int a(List<CustomEmotionData> paramList)
  {
    int j;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 1;
      j = i;
      if (!paramList.hasNext()) {
        break label55;
      }
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList.next();
      if (i >= localCustomEmotionData.emoId) {
        break label57;
      }
      i = localCustomEmotionData.emoId;
    }
    label55:
    label57:
    for (;;)
    {
      break;
      j = 1;
      return j;
    }
  }
  
  private int a(List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2)
  {
    int i = 0;
    if (paramList1 != null)
    {
      i = paramList1.size() - 1;
      while (i >= 0)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList1.get(i);
        if ((localCustomEmotionData != null) && (!paramList2.contains(localCustomEmotionData))) {
          paramList1.remove(i);
        }
        i -= 1;
      }
      i = paramList1.size();
    }
    return i;
  }
  
  private CustomEmotionData a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    CustomEmotionData localCustomEmotionData = null;
    Object localObject = localCustomEmotionData;
    if (paramString1 != null)
    {
      localObject = localCustomEmotionData;
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label36;
        }
        localObject = localCustomEmotionData;
      }
    }
    label36:
    String str1;
    arrw localarrw;
    String str2;
    do
    {
      do
      {
        do
        {
          return localObject;
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localarrw = new arrw(paramString1);
          localObject = localCustomEmotionData;
        } while (TextUtils.isEmpty(localarrw.jdField_a_of_type_JavaLangString));
        str2 = localarrw.c;
        localObject = localCustomEmotionData;
      } while (str2 == null);
      localObject = localCustomEmotionData;
    } while ("".equals(str2));
    localCustomEmotionData = new CustomEmotionData();
    if (str2.equals("1"))
    {
      localCustomEmotionData.isMarkFace = true;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = localarrw.e;
      localCustomEmotionData.eId = localarrw.f;
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.url = arrm.a(paramString1, paramString2, str1);
      localCustomEmotionData.emoId = paramInt;
      localCustomEmotionData.isAPNG = paramBoolean;
      localCustomEmotionData.checkMarketFace("createCustomEmotionDataByResId");
    }
    while (!str2.equals("0"))
    {
      localObject = localCustomEmotionData;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavroamingDBManager", 2, "createCustomEmotionDataByResIdList : emotionData = " + localCustomEmotionData + ", emotion name:" + paramString1);
      return localCustomEmotionData;
    }
    localObject = localarrw.f;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!((String)localObject).contains("qto@")) {
        break label397;
      }
      localObject = ((String)localObject).replace("qto@", "qto_");
      localCustomEmotionData.eId = ((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "download funnyPic name.original->" + (String)localObject);
      }
    }
    for (;;)
    {
      localCustomEmotionData.isMarkFace = false;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = arrm.a(paramString1);
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.md5 = localarrw.jdField_d_of_type_JavaLangString;
      localCustomEmotionData.url = arrm.a(paramString1, paramString2, str1);
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.emoId = paramInt;
      break;
      label397:
      if (((String)localObject).contains("diydoutu@"))
      {
        localCustomEmotionData.eId = localarrw.e;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingDBManager", 2, "download diyemoji name.original->" + paramString1);
        }
      }
    }
  }
  
  @NotNull
  private List<CustomEmotionData> a(List<CustomEmotionData> paramList)
  {
    Object localObject = paramList;
    if (paramList.size() > arrm.b) {
      localObject = paramList.subList(0, arrm.b);
    }
    int i = 0;
    if (i < ((List)localObject).size())
    {
      paramList = (CustomEmotionData)((List)localObject).get(i);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "local emo: " + paramList);
      }
      if (i <= arrm.a) {
        if (paramList.RomaingType != null) {
          if (paramList.RomaingType.equals("overflow_downloaded")) {
            paramList.RomaingType = "isUpdate";
          }
        }
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramList.url)) && (paramList.url.startsWith("http://"))) {
          paramList.url = paramList.url.replace("http://", "https://");
        }
        i += 1;
        break;
        if ((!paramList.RomaingType.equals("isUpdate")) && (!paramList.RomaingType.equals("init")) && (!paramList.RomaingType.equals("needUpload")) && (!paramList.RomaingType.equals("failed")))
        {
          paramList.RomaingType = "needDownload";
          continue;
          paramList.RomaingType = "needDownload";
          continue;
          if (i <= arrm.b) {
            if (paramList.RomaingType != null)
            {
              if (paramList.RomaingType.equals("isUpdate")) {
                paramList.RomaingType = "overflow_downloaded";
              } else if ((!paramList.RomaingType.equals("overflow_downloaded")) && (!paramList.RomaingType.equals("init")) && (!paramList.RomaingType.equals("needUpload")) && (!paramList.RomaingType.equals("failed"))) {
                paramList.RomaingType = "overflow";
              }
            }
            else {
              paramList.RomaingType = "overflow";
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private void a(List<String> paramList, String paramString, List<Integer> paramList1, int paramInt, List<CustomEmotionData> paramList2, List<CustomEmotionData> paramList3)
  {
    if (paramList != null)
    {
      List localList = a();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      if (paramInt < paramList.size())
      {
        String str = (String)paramList.get(paramInt);
        CustomEmotionData localCustomEmotionData2 = a(localList, str);
        boolean bool1;
        label107:
        CustomEmotionData localCustomEmotionData1;
        if (localCustomEmotionData2 == null)
        {
          boolean bool2 = false;
          bool1 = bool2;
          if (paramList1 != null)
          {
            bool1 = bool2;
            if (paramInt <= paramList1.size())
            {
              if (((Integer)paramList1.get(paramInt)).intValue() != 2) {
                break label151;
              }
              bool1 = true;
            }
          }
          j = i + 1;
          localCustomEmotionData1 = a(str, paramString, "needDownload", j, bool1);
        }
        for (;;)
        {
          paramList3.add(localCustomEmotionData1);
          paramInt += 1;
          i = j;
          break;
          label151:
          bool1 = false;
          break label107;
          localCustomEmotionData1 = localCustomEmotionData2;
          j = i;
          if (paramList2 != null)
          {
            if ("init".equals(localCustomEmotionData2.RomaingType)) {
              localCustomEmotionData2.RomaingType = "isUpdate";
            }
            if ((TextUtils.isEmpty(localCustomEmotionData2.url)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("FavroamingDBManager", 2, "url is null because of old db data exception, fix it");
              }
              localCustomEmotionData2.url = arrm.a(str, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            paramList2.remove(localCustomEmotionData2);
            localCustomEmotionData1 = localCustomEmotionData2;
            j = i;
          }
        }
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "localNew=" + paramList2.size());
      }
      paramList3.addAll(paramList2);
    }
  }
  
  private void d(List<String> paramList)
  {
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CustomEmotionData localCustomEmotionData = a(localList, (String)paramList.next());
        if (localCustomEmotionData != null) {
          localArrayList.add(localCustomEmotionData);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "deleDatas=" + localArrayList.size());
      }
      a(localArrayList);
    }
  }
  
  public arpg<CustomEmotionData> a()
  {
    return (arrp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103);
  }
  
  public arxg a(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData.isMarkFace)
    {
      localObject1 = new asbq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((asbq)localObject1).jdField_c_of_type_Int = 6;
      localObject2 = paramCustomEmotionData.eId;
      String str = paramCustomEmotionData.emoPath;
      ((asbq)localObject1).jdField_c_of_type_Boolean = paramCustomEmotionData.isAPNG;
      ((asbq)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(str, (String)localObject2);
      ((asbq)localObject1).jdField_d_of_type_Int = 2;
      ((asbq)localObject1).jdField_a_of_type_JavaLangString = paramCustomEmotionData.RomaingType;
      ((asbq)localObject1).jdField_g_of_type_Int = paramCustomEmotionData.emoId;
      return localObject1;
    }
    Object localObject1 = ((arss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141)).a();
    Object localObject2 = new asaz();
    ((asaz)localObject2).jdField_c_of_type_Int = 4;
    ((asaz)localObject2).e = a(paramCustomEmotionData);
    ((asaz)localObject2).jdField_d_of_type_Int = 2;
    ((asaz)localObject2).jdField_d_of_type_JavaLangString = paramCustomEmotionData.eId;
    ((asaz)localObject2).f = paramCustomEmotionData.url;
    if (localObject1 != null) {
      ((asaz)localObject2).jdField_a_of_type_JavaLangString = asaz.a((Map)localObject1, paramCustomEmotionData.md5);
    }
    ((asaz)localObject2).h = paramCustomEmotionData.RomaingType;
    ((asaz)localObject2).jdField_g_of_type_Int = paramCustomEmotionData.emoId;
    ((asaz)localObject2).jdField_g_of_type_JavaLangString = paramCustomEmotionData.resid;
    return localObject2;
  }
  
  public CustomEmotionData a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateUpload.");
    }
    CustomEmotionData localCustomEmotionData = a(a(), paramString);
    if (localCustomEmotionData != null)
    {
      localCustomEmotionData.resid = paramString;
      localCustomEmotionData.RomaingType = "isUpdate";
      b(localCustomEmotionData);
    }
    return localCustomEmotionData;
  }
  
  public CustomEmotionData a(List<CustomEmotionData> paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramList == null) || (paramList.size() < 1)) {
      return null;
    }
    int j = paramList.size();
    int i = 0;
    CustomEmotionData localCustomEmotionData;
    for (;;)
    {
      if (i < j)
      {
        localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        if ((localCustomEmotionData == null) || ((localCustomEmotionData.RomaingType != null) && (localCustomEmotionData.RomaingType.equals("needUpload"))) || ((localCustomEmotionData.RomaingType != null) && (localCustomEmotionData.RomaingType.equals("failed")))) {
          label98:
          i += 1;
        } else if ((!TextUtils.isEmpty(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(paramString))) {
          paramList = localCustomEmotionData;
        }
      }
    }
    for (;;)
    {
      label131:
      return paramList;
      Object localObject = new arrw(paramString);
      if (!((arrw)localObject).a())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FavroamingDBManager", 2, "res id is not valid:" + paramString);
        return null;
      }
      if (localCustomEmotionData.isMarkFace)
      {
        str = ((arrw)localObject).e;
        localObject = ((arrw)localObject).f;
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!str.equals(localCustomEmotionData.emoPath)) || (!((String)localObject).equals(localCustomEmotionData.eId))) {
          break label98;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        continue;
      }
      localObject = ((arrw)localObject).jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label98;
      }
      if (!TextUtils.isEmpty(localCustomEmotionData.md5)) {}
      for (String str = localCustomEmotionData.md5;; str = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath)))
      {
        localCustomEmotionData.md5 = str;
        if (!((String)localObject).equals(str)) {
          break;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        break label131;
      }
      paramList = null;
    }
  }
  
  public Class a()
  {
    return CustomEmotionData.class;
  }
  
  public String a(CustomEmotionData paramCustomEmotionData)
  {
    Object localObject1;
    if (paramCustomEmotionData == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) {
        return paramCustomEmotionData.emoPath;
      }
      localObject1 = anhk.bl;
      localObject2 = (arss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      if ((localObject2 != null) && (((arss)localObject2).a(paramCustomEmotionData)))
      {
        if ((!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) && (paramCustomEmotionData.emoPath.startsWith(anhk.bl))) {
          return paramCustomEmotionData.emoPath;
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.md5)) {
          return ((arss)localObject2).a(paramCustomEmotionData.md5);
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.resid)) {
          return (String)localObject1 + aopp.a(paramCustomEmotionData.resid);
        }
        return (String)localObject1 + paramCustomEmotionData.url.substring(paramCustomEmotionData.url.lastIndexOf("/") + 1);
      }
      if ((paramCustomEmotionData.url != null) && (paramCustomEmotionData.url.contains("qto_"))) {
        return (String)localObject1 + anmz.a(paramCustomEmotionData.url);
      }
      if (TextUtils.isEmpty(anmz.a(paramCustomEmotionData.eId))) {
        break;
      }
      localObject2 = (String)localObject1 + paramCustomEmotionData.eId;
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("FavroamingDBManager", 2, "emotion is FunnyPic path download from server->" + paramCustomEmotionData.eId);
    return localObject2;
    return (String)localObject1 + paramCustomEmotionData.resid;
  }
  
  public List<CustomEmotionData> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label112;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
        if (localCustomEmotionData != null) {
          localArrayList.add(localCustomEmotionData);
        }
      }
      if (!QLog.isColorLevel()) {
        break label108;
      }
    }
    finally {}
    QLog.d("FavroamingDBManager", 2, "getEmoticonDataList from cache: data size = " + localList.size());
    for (;;)
    {
      label108:
      return localList;
      label112:
      List localList1 = d();
    }
  }
  
  public List<String> a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return null;
      } while ((paramList1 != null) && (paramList1.size() < 1));
      localArrayList = new ArrayList();
      if (paramList1 != null) {
        localArrayList.addAll(paramList1);
      }
      if (paramList2 != null) {
        localArrayList.addAll(paramList2);
      }
      paramList2 = a("isUpdate");
    } while (paramList2 == null);
    paramList1 = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      String str = (String)paramList2.next();
      if (!localArrayList.contains(str)) {
        paramList1.add(str);
      }
    }
    return paramList1;
  }
  
  public List<CustomEmotionData> a(List<String> paramList1, List<String> paramList2, String paramString, List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a(paramList1, paramList2);
    if ((localList != null) && (localList.size() > 0))
    {
      localArrayList.addAll(localList);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "localUpdatedNotInServerList=" + localList.size());
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      localArrayList.addAll(paramList1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-1.");
    }
    d(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-2.");
    }
    paramList1 = a();
    int i = a(paramList1);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-3.");
    }
    localArrayList = new ArrayList();
    a(paramList2, paramString, paramList, i, paramList1, localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingDBManager", 1, "mergeSize=" + localArrayList.size());
    }
    paramList2 = a(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
    }
    paramString = a();
    i = 0;
    if (paramString != null)
    {
      i = paramString.size();
      a(paramString);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList2);
    a(paramList2, 1);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
    }
    paramString = (anlh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
    if (paramList2.size() > 0) {
      paramString.a(paramList2, 2);
    }
    int j = a(paramList1, paramList2);
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingDBManager", 2, "updateFavEmotionsInLocalEx final cache size: " + paramList2.size() + ",delete size:" + i + ",upload size:" + j);
    }
    return paramList1;
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {}
    while (!"needDel".equals(paramCustomEmotionData.RomaingType)) {
      return false;
    }
    if (paramInt <= arrm.a) {}
    for (Object localObject = "isUpdate";; localObject = "overflow_downloaded")
    {
      paramCustomEmotionData.RomaingType = ((String)localObject);
      b(paramCustomEmotionData);
      localObject = (arrp)a();
      if (localObject != null) {
        ((arrp)localObject).d(paramCustomEmotionData);
      }
      return true;
    }
  }
  
  public List<arxg> b()
  {
    bgso.a("AIO_EmoticonPanel_Refresh", null);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from getFavEmotionInfoShowedInPanel.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      Object localObject1;
      Object localObject2;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          localObject1 = (CustomEmotionData)localList.get(i);
          if ("needDel".equals(((CustomEmotionData)localObject1).RomaingType))
          {
            QLog.d("FavroamingDBManager", 1, "data need delete, do not need display -> resId:" + ((CustomEmotionData)localObject1).resid);
          }
          else
          {
            localObject2 = a((CustomEmotionData)localObject1);
            if ((localObject2 instanceof asbq))
            {
              localObject2 = (asbq)localObject2;
              if (((asbq)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPanel oom");
        bgso.a(null, "AIO_EmoticonPanel_Refresh");
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "getFavEmotionInfoShowedInPanel, display size:" + localArrayList.size());
      }
      return localArrayList;
      QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + ((CustomEmotionData)localObject1).toString());
      break label322;
      if ((localObject2 instanceof asaz))
      {
        localObject1 = (asaz)localObject2;
        if ((TextUtils.isEmpty(((asaz)localObject1).e)) && (TextUtils.isEmpty(((asaz)localObject1).f))) {
          QLog.e("FavroamingDBManager", 1, "path and url is null! " + ((asaz)localObject1).toString());
        } else {
          localArrayList.add(localObject1);
        }
      }
      label322:
      i -= 1;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      arrn.a(false, 8, 0);
    }
  }
  
  public void b(List<CustomEmotionData> paramList)
  {
    if (paramList == null) {
      return;
    }
    a(paramList);
  }
  
  protected List<arxg> c()
  {
    Map localMap = ((arss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141)).a();
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from syncGetCustomEmotionInfoShowedInPreview.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      CustomEmotionData localCustomEmotionData;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          localCustomEmotionData = (CustomEmotionData)localList.get(i);
          if (!"isUpdate".equals(localCustomEmotionData.RomaingType))
          {
            QLog.d("FavroamingDBManager", 1, "data need hidden, do not need display -> resId:" + localCustomEmotionData.resid);
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            localObject = new asbq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((asbq)localObject).jdField_c_of_type_Int = 6;
            String str1 = localCustomEmotionData.eId;
            String str2 = localCustomEmotionData.emoPath;
            ((asbq)localObject).jdField_c_of_type_Boolean = localCustomEmotionData.isAPNG;
            ((asbq)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(str2, str1);
            ((asbq)localObject).jdField_d_of_type_Int = 2;
            if (((asbq)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPreview oom");
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "syncGetCustomEmotionInfoShowedInPreview, display size:" + localArrayList.size());
      }
      return localArrayList;
      QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + localCustomEmotionData.toString());
      break label471;
      Object localObject = new asaz();
      ((asaz)localObject).jdField_c_of_type_Int = 4;
      ((asaz)localObject).e = a(localCustomEmotionData);
      ((asaz)localObject).jdField_d_of_type_Int = 2;
      ((asaz)localObject).jdField_d_of_type_JavaLangString = localCustomEmotionData.eId;
      ((asaz)localObject).f = localCustomEmotionData.url;
      ((asaz)localObject).jdField_a_of_type_JavaLangString = asaz.a(localOutOfMemoryError, localCustomEmotionData.md5);
      ((asaz)localObject).h = localCustomEmotionData.RomaingType;
      ((asaz)localObject).jdField_g_of_type_Int = localCustomEmotionData.emoId;
      ((asaz)localObject).jdField_g_of_type_JavaLangString = localCustomEmotionData.resid;
      if ((TextUtils.isEmpty(((asaz)localObject).e)) && (TextUtils.isEmpty(((asaz)localObject).f))) {
        QLog.e("FavroamingDBManager", 1, "path and url is null! " + ((asaz)localObject).toString());
      } else {
        localArrayList.add(localObject);
      }
      label471:
      i -= 1;
    }
  }
  
  public void c(List<String> paramList)
  {
    if (paramList == null) {}
    List localList;
    do
    {
      return;
      localList = b("needDel");
    } while (localList == null);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      int j = 0;
      while (j < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        if ((localCustomEmotionData.resid != null) && (!"".equals(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(str)))
        {
          b(localCustomEmotionData, 4);
          localArrayList.add(localCustomEmotionData);
        }
        j += 1;
      }
      i += 1;
    }
    a(localArrayList, 4);
  }
  
  /* Error */
  public List<CustomEmotionData> d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: new 258	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 259	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 64	arro:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: ifnonnull +10 -> 29
    //   22: aload 8
    //   24: astore 9
    //   26: aload 9
    //   28: areturn
    //   29: aload_0
    //   30: getfield 64	arro:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 494	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   36: invokevirtual 500	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   39: astore 11
    //   41: aload 11
    //   43: ifnull +379 -> 422
    //   46: aload 11
    //   48: aload_0
    //   49: invokevirtual 502	arro:a	()Ljava/lang/Class;
    //   52: iconst_0
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 508	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   62: astore 9
    //   64: ldc_w 510
    //   67: aload_0
    //   68: getfield 64	arro:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   71: invokevirtual 512	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   74: invokestatic 515	aopp:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: iconst_1
    //   78: if_icmpge +335 -> 413
    //   81: aload 11
    //   83: invokevirtual 519	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   86: astore 10
    //   88: aload 9
    //   90: ifnonnull +156 -> 246
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: iconst_1
    //   97: isub
    //   98: istore 5
    //   100: iconst_0
    //   101: istore_1
    //   102: iload 5
    //   104: iconst_m1
    //   105: if_icmple +271 -> 376
    //   108: iload_1
    //   109: istore_2
    //   110: iload_1
    //   111: istore 4
    //   113: aload 9
    //   115: iload 5
    //   117: invokeinterface 46 2 0
    //   122: checkcast 31	com/tencent/mobileqq/data/CustomEmotionData
    //   125: astore 8
    //   127: iload_1
    //   128: istore_2
    //   129: iload_1
    //   130: istore 4
    //   132: aload 8
    //   134: getfield 105	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   137: new 143	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   144: getstatic 355	anhk:bl	Ljava/lang/String;
    //   147: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 8
    //   152: getfield 114	com/tencent/mobileqq/data/CustomEmotionData:resid	Ljava/lang/String;
    //   155: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +93 -> 257
    //   167: iload_1
    //   168: istore_2
    //   169: iload_1
    //   170: istore 4
    //   172: aload 8
    //   174: new 143	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   181: getstatic 355	anhk:bl	Ljava/lang/String;
    //   184: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 8
    //   189: getfield 114	com/tencent/mobileqq/data/CustomEmotionData:resid	Ljava/lang/String;
    //   192: invokestatic 362	aopp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   195: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: putfield 105	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   204: iload_1
    //   205: istore_3
    //   206: iload_1
    //   207: ifne +15 -> 222
    //   210: iload_1
    //   211: istore_2
    //   212: iload_1
    //   213: istore 4
    //   215: aload 10
    //   217: invokevirtual 524	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   220: iconst_1
    //   221: istore_3
    //   222: iload_3
    //   223: istore_2
    //   224: iload_3
    //   225: istore 4
    //   227: aload 11
    //   229: aload 8
    //   231: invokevirtual 528	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   234: pop
    //   235: iload_3
    //   236: istore_1
    //   237: iload 5
    //   239: iconst_1
    //   240: isub
    //   241: istore 5
    //   243: goto -141 -> 102
    //   246: aload 9
    //   248: invokeinterface 42 1 0
    //   253: istore_1
    //   254: goto -159 -> 95
    //   257: iload_1
    //   258: istore_2
    //   259: iload_1
    //   260: istore 4
    //   262: aload 8
    //   264: getfield 105	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   267: new 143	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   274: getstatic 355	anhk:bl	Ljava/lang/String;
    //   277: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 8
    //   282: getfield 99	com/tencent/mobileqq/data/CustomEmotionData:uin	Ljava/lang/String;
    //   285: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 530
    //   291: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokevirtual 533	java/lang/String:matches	(Ljava/lang/String;)Z
    //   300: ifeq +399 -> 699
    //   303: iload_1
    //   304: istore_2
    //   305: iload_1
    //   306: istore 4
    //   308: aload 8
    //   310: getfield 99	com/tencent/mobileqq/data/CustomEmotionData:uin	Ljava/lang/String;
    //   313: astore 12
    //   315: iload_1
    //   316: istore_2
    //   317: iload_1
    //   318: istore 4
    //   320: aload 8
    //   322: aload 8
    //   324: getfield 105	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   327: aload 12
    //   329: aload 12
    //   331: invokestatic 362	aopp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   334: invokevirtual 174	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   337: putfield 105	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   340: iload_1
    //   341: istore_3
    //   342: iload_1
    //   343: ifne +15 -> 358
    //   346: iload_1
    //   347: istore_2
    //   348: iload_1
    //   349: istore 4
    //   351: aload 10
    //   353: invokevirtual 524	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   356: iconst_1
    //   357: istore_3
    //   358: iload_3
    //   359: istore_2
    //   360: iload_3
    //   361: istore 4
    //   363: aload 11
    //   365: aload 8
    //   367: invokevirtual 528	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   370: pop
    //   371: iload_3
    //   372: istore_1
    //   373: goto -136 -> 237
    //   376: iload_1
    //   377: ifeq +13 -> 390
    //   380: iload_1
    //   381: istore_2
    //   382: iload_1
    //   383: istore 4
    //   385: aload 10
    //   387: invokevirtual 536	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   390: iload_1
    //   391: ifeq +8 -> 399
    //   394: aload 10
    //   396: invokevirtual 539	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   399: ldc_w 510
    //   402: aload_0
    //   403: getfield 64	arro:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   406: invokevirtual 512	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   409: iconst_1
    //   410: invokestatic 542	aopp:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   413: aload 11
    //   415: invokevirtual 545	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   418: aload 9
    //   420: astore 8
    //   422: iload 7
    //   424: istore_2
    //   425: aload 8
    //   427: ifnull +182 -> 609
    //   430: iload 7
    //   432: istore_2
    //   433: aload 8
    //   435: invokeinterface 42 1 0
    //   440: ifle +169 -> 609
    //   443: new 258	java/util/ArrayList
    //   446: dup
    //   447: invokespecial 259	java/util/ArrayList:<init>	()V
    //   450: astore 9
    //   452: aload 8
    //   454: invokeinterface 19 1 0
    //   459: astore 10
    //   461: iload 6
    //   463: istore_1
    //   464: iload_1
    //   465: istore_2
    //   466: aload 10
    //   468: invokeinterface 25 1 0
    //   473: ifeq +136 -> 609
    //   476: aload 10
    //   478: invokeinterface 29 1 0
    //   483: checkcast 31	com/tencent/mobileqq/data/CustomEmotionData
    //   486: astore 11
    //   488: aload 11
    //   490: getfield 117	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   493: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifeq +74 -> 570
    //   499: aload 11
    //   501: ldc 214
    //   503: putfield 117	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   506: aload 9
    //   508: aload 11
    //   510: invokeinterface 241 2 0
    //   515: pop
    //   516: iconst_1
    //   517: istore_1
    //   518: aload_0
    //   519: aload 11
    //   521: iconst_1
    //   522: invokevirtual 489	arro:b	(Lcom/tencent/mobileqq/data/CustomEmotionBase;I)V
    //   525: goto -61 -> 464
    //   528: astore 8
    //   530: iconst_0
    //   531: istore 4
    //   533: iload 4
    //   535: istore_2
    //   536: aload 8
    //   538: invokevirtual 548	java/lang/Exception:printStackTrace	()V
    //   541: iload 4
    //   543: ifeq -144 -> 399
    //   546: aload 10
    //   548: invokevirtual 539	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   551: goto -152 -> 399
    //   554: astore 8
    //   556: iconst_0
    //   557: istore_2
    //   558: iload_2
    //   559: ifeq +8 -> 567
    //   562: aload 10
    //   564: invokevirtual 539	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   567: aload 8
    //   569: athrow
    //   570: aload 11
    //   572: getfield 117	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   575: ldc 216
    //   577: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   580: ifeq -62 -> 518
    //   583: aload 11
    //   585: ldc 218
    //   587: putfield 117	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   590: aload 9
    //   592: aload 11
    //   594: invokeinterface 241 2 0
    //   599: pop
    //   600: aload_0
    //   601: invokevirtual 550	arro:b	()V
    //   604: iconst_1
    //   605: istore_1
    //   606: goto -88 -> 518
    //   609: aload_0
    //   610: invokevirtual 552	arro:a	()V
    //   613: iload_2
    //   614: ifeq +10 -> 624
    //   617: aload_0
    //   618: aload 8
    //   620: iconst_2
    //   621: invokevirtual 419	arro:a	(Ljava/util/List;I)V
    //   624: aload 8
    //   626: ifnonnull +67 -> 693
    //   629: new 258	java/util/ArrayList
    //   632: dup
    //   633: invokespecial 259	java/util/ArrayList:<init>	()V
    //   636: astore 8
    //   638: aload 8
    //   640: astore 9
    //   642: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq -619 -> 26
    //   648: ldc 141
    //   650: iconst_2
    //   651: new 143	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 554
    //   661: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 8
    //   666: invokeinterface 42 1 0
    //   671: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   680: aload 8
    //   682: areturn
    //   683: astore 8
    //   685: goto -127 -> 558
    //   688: astore 8
    //   690: goto -157 -> 533
    //   693: goto -55 -> 638
    //   696: goto -459 -> 237
    //   699: iload 5
    //   701: ifne -5 -> 696
    //   704: goto -328 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	arro
    //   94	512	1	i	int
    //   109	505	2	j	int
    //   205	167	3	k	int
    //   111	431	4	m	int
    //   98	602	5	n	int
    //   4	458	6	i1	int
    //   1	430	7	i2	int
    //   13	440	8	localObject1	Object
    //   528	9	8	localException1	java.lang.Exception
    //   554	71	8	localList	List
    //   636	45	8	localArrayList	ArrayList
    //   683	1	8	localObject2	Object
    //   688	1	8	localException2	java.lang.Exception
    //   24	617	9	localObject3	Object
    //   86	477	10	localObject4	Object
    //   39	554	11	localObject5	Object
    //   313	17	12	str	String
    // Exception table:
    //   from	to	target	type
    //   246	254	528	java/lang/Exception
    //   246	254	554	finally
    //   113	127	683	finally
    //   132	167	683	finally
    //   172	204	683	finally
    //   215	220	683	finally
    //   227	235	683	finally
    //   262	303	683	finally
    //   308	315	683	finally
    //   320	340	683	finally
    //   351	356	683	finally
    //   363	371	683	finally
    //   385	390	683	finally
    //   536	541	683	finally
    //   113	127	688	java/lang/Exception
    //   132	167	688	java/lang/Exception
    //   172	204	688	java/lang/Exception
    //   215	220	688	java/lang/Exception
    //   227	235	688	java/lang/Exception
    //   262	303	688	java/lang/Exception
    //   308	315	688	java/lang/Exception
    //   320	340	688	java/lang/Exception
    //   351	356	688	java/lang/Exception
    //   363	371	688	java/lang/Exception
    //   385	390	688	java/lang/Exception
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    arrn.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arro
 * JD-Core Version:    0.7.0.1
 */