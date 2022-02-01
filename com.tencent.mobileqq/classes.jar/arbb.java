import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.3;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.4;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.7;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.8;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class arbb
  extends aqys<CustomEmotionData>
{
  public int a;
  private amrn jdField_a_of_type_Amrn = new arbd(this);
  private aran jdField_a_of_type_Aran;
  public areo a;
  private arep jdField_a_of_type_Arep = new arbf(this);
  public TransFileController a;
  protected TransProcessorHandler a;
  WeakReference<TransferRequest> jdField_a_of_type_JavaLangRefWeakReference;
  protected Map<String, ArrayList<CustomEmotionData>> a;
  private ConcurrentHashMap<Integer, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public AtomicInteger a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  protected AtomicInteger b;
  private boolean b;
  
  public arbb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new arbc(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Areo = new arbe(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.getTransFileController();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      int i = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("fav_roaming_max" + this.jdField_a_of_type_JavaLangString, 144);
      if (i > 144) {
        aray.jdField_a_of_type_Int = i;
      }
    }
  }
  
  public static arbb a(QQAppInterface paramQQAppInterface)
  {
    return (arbb)paramQQAppInterface.getManager(103);
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return String.format(BaseApplicationImpl.getApplication().getString(2131691762), new Object[] { str });
  }
  
  private void a(String paramString, aran paramaran)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    Object localObject = (arba)localQQAppInterface.getManager(149);
    List localList = ((arba)localObject).a();
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
            ((arba)localObject).a(localCustomEmotionData, j);
            if (paramaran != null) {
              paramaran.a(0, str);
            }
          }
          while (paramaran == null) {
            return;
          }
          paramaran.a(1, str);
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
    paramString = new araj(localQQAppInterface, null, (CustomEmotionData)localObject, null, 2);
    paramString.a(paramaran);
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
        arbj localarbj = (arbj)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
        if (localarbj != null) {
          localarbj.onDownloadFinish(j);
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
    if ((paramList == null) || (paramList.size() == 0) || (!NetworkUtil.isNetSupport(BaseApplication.getContext()))) {
      return 0;
    }
    Object localObject = paramList;
    if (paramList.size() > aray.jdField_a_of_type_Int)
    {
      j = paramList.size() - aray.jdField_a_of_type_Int;
      localObject = paramList.subList(j, aray.jdField_a_of_type_Int + j);
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
  
  protected amqc<CustomEmotionData> a()
  {
    return (amrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(72);
  }
  
  protected aqyq<CustomEmotionData> a()
  {
    return (arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
  }
  
  public TransferRequest a(CustomEmotionData paramCustomEmotionData, ayeo paramayeo)
  {
    if (paramCustomEmotionData == null) {}
    while (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return null;
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_Boolean = true;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mFileType = 24;
    localTransferRequest.mCommandId = 9;
    localTransferRequest.mRichTag = "scbqmanyou";
    localTransferRequest.mSelfUin = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mPeerUin = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mIsUp = true;
    if (paramayeo != null) {
      localTransferRequest.mUpCallBack = paramayeo;
    }
    if (paramCustomEmotionData.isMarkFace)
    {
      b(paramCustomEmotionData, localTransferRequest);
      return localTransferRequest;
    }
    a(paramCustomEmotionData, localTransferRequest);
    return localTransferRequest;
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
  
  public void a(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    int j = 1;
    int i = 1;
    if ((paramCustomEmotionData == null) || (paramTransferRequest == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "uploadNoMarkFace " + paramCustomEmotionData);
    }
    cmd0x388.ExtensionExpRoamTryUp localExtensionExpRoamTryUp = new cmd0x388.ExtensionExpRoamTryUp();
    cmd0x388.ExpRoamPicInfo localExpRoamPicInfo = new cmd0x388.ExpRoamPicInfo();
    Object localObject = amsz.a(paramCustomEmotionData.emoPath);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("qto_")))
    {
      localObject = ((String)localObject).replace("qto_", "qto@");
      localExpRoamPicInfo.bytes_pic_id.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "upload FunnyPic name.replace->" + (String)localObject);
      }
      j = amsz.a(paramCustomEmotionData.eId);
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
        paramTransferRequest.mExtentionInfo = localExtensionExpRoamTryUp.toByteArray();
        paramTransferRequest.mUniseq = paramCustomEmotionData.emoId;
        paramTransferRequest.mLocalPath = paramCustomEmotionData.emoPath;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.transferAsync(paramTransferRequest);
        return;
        localObject = amre.a(paramCustomEmotionData.emoPath);
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
    amrm localamrm;
    do
    {
      return;
      localamrm = (amrm)a();
    } while (localamrm == null);
    localamrm.a(paramCustomEmotionData, paramString);
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
      Object localObject = (arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
      if ((localObject != null) && (paramBoolean))
      {
        if (!"needDownload".equals(paramCustomEmotionData.RomaingType)) {
          break label205;
        }
        paramCustomEmotionData.RomaingType = "isUpdate";
        if ("needDel".equals(paramCustomEmotionData.RomaingType)) {
          break label228;
        }
        ((arba)localObject).b(paramCustomEmotionData);
      }
      for (;;)
      {
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i) != null)
          {
            localObject = (arbj)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
            if (localObject != null) {
              ((arbj)localObject).onFileDone(paramCustomEmotionData, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
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
  
  protected void a(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramEmoticonPackage.epId);
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localArrayList.get(i);
        if (localCustomEmotionData != null) {
          a(localCustomEmotionData, false);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "downloadAIOEmoticon fail epId:" + paramEmoticonPackage.epId);
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, areb paramareb)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilMap.get(paramEmoticonPackage.epId);
    int i;
    CustomEmotionData localCustomEmotionData;
    Emoticon localEmoticon;
    if (localArrayList != null) {
      if (paramEmoticonPackage.jobType == 0)
      {
        i = 0;
        if (i >= localArrayList.size()) {
          break label366;
        }
        localCustomEmotionData = (CustomEmotionData)localArrayList.get(i);
        if (localCustomEmotionData == null) {}
        for (;;)
        {
          i += 1;
          break;
          localEmoticon = new Emoticon();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            break label100;
          }
          QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|app null");
          a(localCustomEmotionData, false);
        }
        label100:
        avsq localavsq = (avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
        if (localavsq == null) {
          break label367;
        }
        localEmoticon = localavsq.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
      }
    }
    label366:
    label367:
    for (;;)
    {
      if (localEmoticon == null)
      {
        QLog.i("FavroamingManager", 1, "downloadAIOEmoticon|cannot find emoticon: epId:" + paramEmoticonPackage.epId + "，eid=" + localCustomEmotionData.eId);
        localCustomEmotionData.RomaingType = "needDel";
        ((arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).b(localCustomEmotionData);
        a((CustomEmotionData)localArrayList.get(i), false);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "downloadAIOEmoticon|taskvalue:" + 14 + "，epid:" + localEmoticon.epId + "，eid=" + localEmoticon.eId);
      }
      if (paramareb.a(localEmoticon, 14))
      {
        a((CustomEmotionData)localArrayList.get(i), true);
        break;
      }
      a((CustomEmotionData)localArrayList.get(i), false);
      break;
      if ((paramEmoticonPackage.jobType == 3) || (paramEmoticonPackage.jobType == 5))
      {
        area.a().a(this.jdField_a_of_type_Areo);
        paramareb.a(paramEmoticonPackage, false);
      }
      return;
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, areb paramareb, ArrayList<Emoticon> paramArrayList, arfb paramarfb)
  {
    if ((!paramarfb.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
    {
      int i = 0;
      int j;
      do
      {
        paramarfb.jdField_a_of_type_JavaLangString = null;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
        }
        paramareb.a(paramEmoticonPackage.epId, paramArrayList, paramarfb);
        j = i + 1;
        if (paramarfb.jdField_a_of_type_Boolean) {
          break;
        }
        i = j;
      } while (j < 3);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + paramarfb.jdField_a_of_type_Boolean);
      }
    }
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
    area.a().a(this.jdField_a_of_type_Arep);
    ((areb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(paramString, areb.c, null, false);
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
  
  public void a(List<String> paramList, arbh paramarbh)
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
    ThreadManager.excute(new FavroamingManager.8(this, i, paramarbh, paramList), 64, null, true);
  }
  
  public TransferRequest b(CustomEmotionData paramCustomEmotionData, ayeo paramayeo)
  {
    return a(paramCustomEmotionData, paramayeo);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData)
  {
    paramCustomEmotionData.increaseExposeNum();
    a().b(paramCustomEmotionData);
  }
  
  public void b(CustomEmotionData paramCustomEmotionData, TransferRequest paramTransferRequest)
  {
    if ((paramCustomEmotionData == null) || (paramTransferRequest == null)) {
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
      paramTransferRequest.mExtentionInfo = localExtensionExpRoamTryUp.toByteArray();
      paramTransferRequest.mUniseq = paramCustomEmotionData.getId();
      paramCustomEmotionData = areb.a(paramCustomEmotionData.emoPath, paramCustomEmotionData.eId, false);
      paramTransferRequest.mLocalPath = paramCustomEmotionData[1];
      ThreadManager.post(new FavroamingManager.7(this, paramCustomEmotionData, paramTransferRequest), 5, null, true);
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
    amrm localamrm;
    do
    {
      return;
      localamrm = (amrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(72);
    } while (localamrm == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amrn);
    ThreadManager.excute(new FavroamingManager.3(this, localamrm), 128, null, true);
  }
  
  public void c(CustomEmotionData paramCustomEmotionData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramCustomEmotionData == null)) {
      return;
    }
    a().b(paramCustomEmotionData);
    ahns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
  }
  
  public void d()
  {
    int i = 0;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
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
      Object localObject1 = (arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
      localObject2 = ((arba)localObject1).b("needDownload");
      localObject3 = ((arba)localObject1).b("overflow");
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
      TransferRequest localTransferRequest = (TransferRequest)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localTransferRequest != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.stop(localTransferRequest);
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
        arbj localarbj = (arbj)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
        if (localarbj != null) {
          localarbj.onUploadFinish();
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
          arbj localarbj = (arbj)((WeakReference)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).get();
          if (localarbj != null) {
            localarbj.onSyncFinish();
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
    avsq localavsq;
    do
    {
      return;
      localObject = (arba)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
      localavsq = (avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      localObject = ((arba)localObject).a();
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
      Emoticon localEmoticon = localavsq.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
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
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amrn);
    area.a().b(this.jdField_a_of_type_Arep);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbb
 * JD-Core Version:    0.7.0.1
 */