import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.3;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.4;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.8;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x388.cmd0x388.ExpRoamPicInfo;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionExpRoamTryUp;

public class ansx
  extends anqt<CustomEmotionData>
{
  public int a;
  private ajvz jdField_a_of_type_Ajvz = new ansz(this);
  private ansj jdField_a_of_type_Ansj;
  public anwk a;
  private anwl jdField_a_of_type_Anwl = new antb(this);
  public ayvx a;
  protected aywb a;
  WeakReference<aywc> jdField_a_of_type_JavaLangRefWeakReference;
  protected Map<String, ArrayList<CustomEmotionData>> a;
  private ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicInteger a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  protected AtomicInteger b;
  private boolean b;
  
  public ansx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Aywb = new ansy(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Anwk = new anta(this);
    this.jdField_a_of_type_Ayvx = paramQQAppInterface.a();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      int i = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("fav_roaming_max" + this.jdField_a_of_type_JavaLangString, 144);
      if (i > 144) {
        ansu.jdField_a_of_type_Int = i;
      }
    }
  }
  
  public static ansx a(QQAppInterface paramQQAppInterface)
  {
    return (ansx)paramQQAppInterface.getManager(103);
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return String.format(BaseApplicationImpl.getApplication().getString(2131692003), new Object[] { str });
  }
  
  private void a(String paramString, ansj paramansj)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (answ)localQQAppInterface.getManager(149);
    List localList = ((answ)localObject).a();
    if (localList != null)
    {
      int j = 0;
      for (int i = 1;; i = k)
      {
        k = i;
        if (j >= localList.size()) {
          break;
        }
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int m = localCustomEmotionData.emoId;
        if ((str != null) && (str.equals(localCustomEmotionData.md5)))
        {
          if ("needDel".equals(localCustomEmotionData.RomaingType))
          {
            ((answ)localObject).a(localCustomEmotionData, j);
            if (paramansj != null) {
              paramansj.a(0, str);
            }
          }
          while (paramansj == null) {
            return;
          }
          paramansj.a(1, str);
          return;
        }
        k = i;
        if (i < m) {
          k = m;
        }
        j += 1;
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = localQQAppInterface.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    ((CustomEmotionData)localObject).eId = str;
    paramString = new ansf(localQQAppInterface, null, (CustomEmotionData)localObject, null, 2);
    paramString.a(paramansj);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(b((CustomEmotionData)localObject, paramString));
  }
  
  private void i()
  {
    int j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_Int = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
      {
        antf localantf = (antf)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
        if (localantf != null) {
          localantf.a(j);
        }
      }
      i += 1;
    }
    g();
  }
  
  protected int a()
  {
    return 9;
  }
  
  public int a(List<CustomEmotionData> paramList)
  {
    int i = 0;
    if ((paramList == null) || (paramList.size() == 0) || (!bbfj.d(BaseApplication.getContext()))) {
      return 0;
    }
    Object localObject = paramList;
    if (paramList.size() > ansu.jdField_a_of_type_Int)
    {
      j = paramList.size() - ansu.jdField_a_of_type_Int;
      localObject = paramList.subList(j, ansu.jdField_a_of_type_Int + j);
    }
    int k = ((List)localObject).size();
    int j = 0;
    if (j < k)
    {
      paramList = (CustomEmotionData)((List)localObject).get(j);
      if (("needDownload".equals(paramList.RomaingType)) || ("needDel".equals(paramList.RomaingType))) {
        break label161;
      }
      if (!"isUpdate".equals(paramList.RomaingType)) {}
    }
    label161:
    for (;;)
    {
      j += 1;
      break;
      a(paramList, null);
      i += 1;
      continue;
      this.jdField_b_of_type_Int = i;
      return i;
    }
  }
  
  protected ajul<CustomEmotionData> a()
  {
    return (ajvy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
  }
  
  protected anqr<CustomEmotionData> a()
  {
    return (answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
  }
  
  public aywc a(CustomEmotionData paramCustomEmotionData, auoq paramauoq)
  {
    if (paramCustomEmotionData == null) {}
    while (!bbfj.d(BaseApplication.getContext())) {
      return null;
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aywb != null) && (this.jdField_a_of_type_Ayvx != null))
    {
      this.jdField_a_of_type_Aywb.addFilter(new Class[] { ayou.class });
      this.jdField_a_of_type_Ayvx.a(this.jdField_a_of_type_Aywb);
      this.jdField_a_of_type_Boolean = true;
    }
    aywc localaywc = new aywc();
    localaywc.jdField_b_of_type_Int = 24;
    localaywc.jdField_c_of_type_Int = 9;
    localaywc.jdField_a_of_type_JavaLangString = "scbqmanyou";
    localaywc.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localaywc.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localaywc.jdField_a_of_type_Boolean = true;
    if (paramauoq != null) {
      localaywc.jdField_a_of_type_Auoq = paramauoq;
    }
    if (paramCustomEmotionData.isMarkFace)
    {
      b(paramCustomEmotionData, localaywc);
      return localaywc;
    }
    a(paramCustomEmotionData, localaywc);
    return localaywc;
  }
  
  public String a(Integer paramInteger)
  {
    if (paramInteger == null) {
      return a("");
    }
    return a((String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramInteger));
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseClickNum();
    a().b(paramCustomEmotionData);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, aywc paramaywc)
  {
    int j = 1;
    int i = 1;
    if ((paramCustomEmotionData == null) || (paramaywc == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadNoMarkFace " + paramCustomEmotionData);
    }
    cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
    cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
    Object localObject = ajxo.a(paramCustomEmotionData.emoPath);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("qto_")))
    {
      localObject = ((String)localObject).replace("qto_", "qto@");
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "upload FunnyPic name.replace->" + (String)localObject);
      }
      j = ajxo.a(paramCustomEmotionData.eId);
      if (j != 0) {
        break label352;
      }
    }
    for (;;)
    {
      localExpRoamPicInfo.uint32_pkg_id.set(i);
      for (;;)
      {
        localExpRoamPicInfo.uint32_shop_flag.set(0);
        localObject = new ArrayList();
        ((List)localObject).add(localExpRoamPicInfo);
        localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set((List)localObject);
        paramaywc.jdField_a_of_type_ArrayOfByte = localExtensionExpRoamTryUp.toByteArray();
        paramaywc.jdField_a_of_type_Long = paramCustomEmotionData.emoId;
        paramaywc.i = paramCustomEmotionData.emoPath;
        if (this.jdField_a_of_type_Ayvx == null) {
          break;
        }
        this.jdField_a_of_type_Ayvx.a(paramaywc);
        return;
        localObject = ajvl.a(paramCustomEmotionData.emoPath);
        if (!((String)localObject).equals("")) {
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
        }
        try
        {
          i = Integer.parseInt(paramCustomEmotionData.eId);
          localExpRoamPicInfo.uint32_pkg_id.set(i);
          continue;
          localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom("0".getBytes()));
          localExpRoamPicInfo.uint32_pkg_id.set(0);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
      label352:
      i = j;
    }
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramCustomEmotionData == null)) {}
    ajvy localajvy;
    do
    {
      return;
      localajvy = (ajvy)a();
    } while (localajvy == null);
    localajvy.a(paramCustomEmotionData, paramString);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    if ((paramCustomEmotionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i;
    label205:
    label228:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + ",isSuccess = " + paramBoolean + " , roamingType: " + paramCustomEmotionData.RomaingType);
      }
      Object localObject = (answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
      if ((localObject != null) && (paramBoolean))
      {
        if (!"needDownload".equals(paramCustomEmotionData.RomaingType)) {
          break label205;
        }
        paramCustomEmotionData.RomaingType = "isUpdate";
        if ("needDel".equals(paramCustomEmotionData.RomaingType)) {
          break label228;
        }
        ((answ)localObject).b(paramCustomEmotionData);
      }
      for (;;)
      {
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
          {
            localObject = (antf)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
            if (localObject != null) {
              ((antf)localObject).a(paramCustomEmotionData, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
            }
          }
          i += 1;
        }
        if (!"overflow".equals(paramCustomEmotionData.RomaingType)) {
          break;
        }
        paramCustomEmotionData.RomaingType = "overflow_downloaded";
        break;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "onFileDone, resId=" + paramCustomEmotionData.resid + " has been deleted");
        }
      }
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "market face : downloadCount: " + i + ",needDownloadCount: " + this.jdField_a_of_type_Int);
      }
    } while (i < this.jdField_a_of_type_Int);
    i();
  }
  
  public void a(Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramInteger);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    anvw.a().a(this.jdField_a_of_type_Anwl);
    ((anvx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(paramString, anvx.jdField_c_of_type_Int, null, false);
  }
  
  public void a(List<CustomEmotionData> paramList)
  {
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      int i;
      for (;;)
      {
        Object localObject;
        try
        {
          this.jdField_a_of_type_JavaUtilMap.clear();
          i = 0;
          if (i < paramList.size())
          {
            localObject = (CustomEmotionData)paramList.get(i);
            if (localObject == null) {
              break label219;
            }
            if (this.jdField_a_of_type_JavaUtilMap.containsKey(((CustomEmotionData)localObject).emoPath))
            {
              ((ArrayList)this.jdField_a_of_type_JavaUtilMap.get(((CustomEmotionData)localObject).emoPath)).add(localObject);
            }
            else
            {
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject);
              this.jdField_a_of_type_JavaUtilMap.put(((CustomEmotionData)localObject).emoPath, localArrayList);
            }
          }
        }
        finally {}
        try
        {
          paramList = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (paramList.hasNext())
          {
            localObject = (Map.Entry)paramList.next();
            if (localObject != null) {
              a((String)((Map.Entry)localObject).getKey());
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception paramList) {}
      }
      QLog.d("FavroamingManager", 2, "downMap exception=" + paramList.toString());
      break;
      label219:
      i += 1;
    }
  }
  
  public void a(List<String> paramList, antd paramantd)
  {
    if (paramList == null) {}
    int i;
    do
    {
      return;
      i = paramList.size();
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FavroamingManager", 2, "addCustomEmotions pathList is empty");
    return;
    this.jdField_b_of_type_Boolean = false;
    ThreadManager.excute(new FavroamingManager.8(this, i, paramantd, paramList), 64, null, true);
  }
  
  public aywc b(CustomEmotionData paramCustomEmotionData, auoq paramauoq)
  {
    return a(paramCustomEmotionData, paramauoq);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseExposeNum();
    a().b(paramCustomEmotionData);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData, aywc paramaywc)
  {
    if ((paramCustomEmotionData == null) || (paramaywc == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadMarkFace favEmoticon.epid=" + paramCustomEmotionData.emoPath + " and eid=" + paramCustomEmotionData.eId);
    }
    if (!paramCustomEmotionData.checkMarketFace("uploadMarkFace"))
    {
      QLog.e("FavroamingManager", 1, "uploadMarkFace: marketFace is invalid");
      return;
    }
    try
    {
      cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
      cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(paramCustomEmotionData.eId.getBytes()));
      localExpRoamPicInfo.uint32_pkg_id.set(Integer.parseInt(paramCustomEmotionData.emoPath));
      localExpRoamPicInfo.uint32_shop_flag.set(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localExpRoamPicInfo);
      localExtensionExpRoamTryUp.rpt_msg_exproam_pic_info.set(localArrayList);
      paramaywc.jdField_a_of_type_ArrayOfByte = localExtensionExpRoamTryUp.toByteArray();
      paramaywc.jdField_a_of_type_Long = paramCustomEmotionData.getId();
      paramCustomEmotionData = anvx.a(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId, false);
      paramaywc.i = paramCustomEmotionData[1];
      ThreadManager.post(new FavroamingManager.7(this, paramCustomEmotionData, paramaywc), 5, null, true);
      return;
    }
    catch (Exception paramCustomEmotionData)
    {
      QLog.e("FavroamingManager", 1, new Object[] { "uploadMarkFace error =", paramCustomEmotionData.getMessage() });
    }
  }
  
  public void b(List<CustomEmotionData> paramList)
  {
    if (paramList != null) {
      a(paramList);
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "downloadCount:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", needDownloadCount" + this.jdField_a_of_type_Int + "uploadCount:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", needUploadCount" + this.jdField_b_of_type_Int);
    }
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_b_of_type_Int);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    ajvy localajvy;
    do
    {
      return;
      localajvy = (ajvy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
    } while (localajvy == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvz);
    ThreadManager.excute(new FavroamingManager.3(this, localajvy), 128, null, true);
  }
  
  public void c(CustomEmotionData paramCustomEmotionData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramCustomEmotionData == null)) {
      return;
    }
    a().b(paramCustomEmotionData);
    aexb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
  }
  
  public void d()
  {
    int i = 0;
    if (!bbfj.d(BaseApplication.getContext())) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    Object localObject2;
    Object localObject3;
    label197:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      Object localObject1 = (answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
      localObject2 = ((answ)localObject1).b("needDownload");
      localObject3 = ((answ)localObject1).b("overflow");
      localObject1 = new ArrayList();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject3);
      }
      CustomEmotionData localCustomEmotionData;
      if (((List)localObject1).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        if (i >= ((List)localObject1).size()) {
          continue;
        }
        localCustomEmotionData = (CustomEmotionData)((List)localObject1).get(i);
        if (!localCustomEmotionData.isMarkFace) {
          break label197;
        }
        ((List)localObject3).add(localCustomEmotionData);
      }
      for (;;)
      {
        i += 1;
        break;
        g();
        return;
        ((List)localObject2).add(localCustomEmotionData);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    this.jdField_a_of_type_Int = ((List)localObject3).size();
    if (this.jdField_a_of_type_Int == 0) {
      g();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "markFace size: " + ((List)localObject3).size() + ", noMarkFace size:" + ((List)localObject2).size());
    }
    ThreadManager.getUIHandler().post(new FavroamingManager.4(this));
    a((List)localObject3);
  }
  
  public void d(CustomEmotionData paramCustomEmotionData)
  {
    b(paramCustomEmotionData, null);
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aywc localaywc = (aywc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaywc != null) {
        this.jdField_a_of_type_Ayvx.a(localaywc);
      }
    }
  }
  
  protected void f()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_b_of_type_Int = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
      {
        antf localantf = (antf)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
        if (localantf != null) {
          localantf.a();
        }
      }
      i += 1;
    }
    g();
  }
  
  protected void g()
  {
    if (b())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "------------end syncRoaming----------");
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
        {
          antf localantf = (antf)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
          if (localantf != null) {
            localantf.b();
          }
        }
        i += 1;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject;
    askf localaskf;
    do
    {
      return;
      localObject = (answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
      localaskf = (askf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      localObject = ((answ)localObject).a();
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = ((List)localObject).iterator();
    label68:
    CustomEmotionData localCustomEmotionData;
    String str;
    if (localIterator.hasNext())
    {
      localCustomEmotionData = (CustomEmotionData)localIterator.next();
      str = "";
      if (!localCustomEmotionData.isMarkFace) {
        break label163;
      }
      Emoticon localEmoticon = localaskf.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
      localObject = str;
      if (localEmoticon != null)
      {
        localObject = str;
        if (!TextUtils.isEmpty(localEmoticon.name)) {
          localObject = localEmoticon.name;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localCustomEmotionData.emoId), localObject);
      break label68;
      break;
      label163:
      if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {
        str = localCustomEmotionData.modifyWord;
      }
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) {
          localObject = localCustomEmotionData.ocrWord;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ayvx != null)
    {
      this.jdField_a_of_type_Ayvx.b(this.jdField_a_of_type_Aywb);
      this.jdField_a_of_type_Aywb = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvz);
    anvw.a().b(this.jdField_a_of_type_Anwl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansx
 * JD-Core Version:    0.7.0.1
 */