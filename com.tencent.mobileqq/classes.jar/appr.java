import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.pb.mqqcomic.MqqComicPb.ComicFavorEmotIcons;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class appr
  implements Handler.Callback, Manager
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private appq jdField_a_of_type_Appq;
  private awgf jdField_a_of_type_Awgf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Map<String, VipComicFavorEmoStructMsgInfo> jdField_a_of_type_JavaUtilMap;
  
  public appr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Appq = ((appq)paramQQAppInterface.a(80));
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(91000);
  }
  
  private void b(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    if ((paramVipComicFavorEmoStructMsgInfo != null) && (this.jdField_a_of_type_Awgf != null) && (this.jdField_a_of_type_Awgf.a()) && (!TextUtils.isEmpty(paramVipComicFavorEmoStructMsgInfo.picMd5)))
    {
      if (paramVipComicFavorEmoStructMsgInfo.getStatus() != 1000) {
        paramVipComicFavorEmoStructMsgInfo.setStatus(1000);
      }
      paramVipComicFavorEmoStructMsgInfo.picMd5 = paramVipComicFavorEmoStructMsgInfo.picMd5.toUpperCase();
      this.jdField_a_of_type_Awgf.b(paramVipComicFavorEmoStructMsgInfo);
    }
  }
  
  private void c(List<VipComicFavorEmoStructMsgInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(91002);
      ((Message)localObject).obj = paramList;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (VipComicFavorEmoStructMsgInfo)paramList.next();
        if (!TextUtils.isEmpty(((VipComicFavorEmoStructMsgInfo)localObject).picMd5)) {
          this.jdField_a_of_type_JavaUtilMap.put(((VipComicFavorEmoStructMsgInfo)localObject).picMd5.toUpperCase(), localObject);
        }
      }
    }
  }
  
  public VipComicFavorEmoStructMsgInfo a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (VipComicFavorEmoStructMsgInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString.toUpperCase());
    }
    return null;
  }
  
  public String a(String paramString)
  {
    String str = amqy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramString)) {
      return alof.bi + str + "-" + paramString.toUpperCase() + ".jpg";
    }
    return alof.bi + str + "-" + paramString + ".jpg";
  }
  
  public List<VipComicFavorEmoStructMsgInfo> a(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)((Iterator)localObject).next();
        if (localVipComicFavorEmoStructMsgInfo.status == paramInt) {
          localArrayList.add(localVipComicFavorEmoStructMsgInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public List<CustomEmotionData> a(List<CustomEmotionData> paramList)
  {
    Object localObject = (apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqManager", 2, "Call getEmoticonDataList from getEmoticonList.");
    }
    localObject = ((apon)localObject).a();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return new ArrayList();
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
      if ((!"needDel".equals(localCustomEmotionData.RomaingType)) && (paramList != null)) {
        paramList.add(localCustomEmotionData);
      }
    }
    return localObject;
  }
  
  public Map<String, VipComicFavorEmoStructMsgInfo> a()
  {
    HashMap localHashMap = null;
    if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      localHashMap = new HashMap();
      localHashMap.putAll(this.jdField_a_of_type_JavaUtilMap);
    }
    return localHashMap;
  }
  
  public void a()
  {
    List localList = a(1);
    a(localList, false);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqManager", 2, "uploadInitComicEmoStructMsgInfo , comicFavorEmoStructMsgInfoList = " + localList);
    }
  }
  
  public void a(Context paramContext, List<CustomEmotionData> paramList, Map<String, VipComicFavorEmoStructMsgInfo> paramMap, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.isEmpty()) || (paramMap == null) || (paramMap.isEmpty())) {
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onDone(new ArrayList(), paramList);
      }
    }
    label169:
    label333:
    do
    {
      awgf localawgf;
      do
      {
        return;
        localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (!bdin.g(paramContext)) {
          break label587;
        }
        paramContext = ((beag)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
        if (paramContext != null) {
          break;
        }
      } while (paramIPicDownloadListener == null);
      paramIPicDownloadListener.onDone(new ArrayList(), paramList);
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
      AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
      apon localapon = (apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
      int i = 0;
      CustomEmotionData localCustomEmotionData;
      Object localObject;
      if (i < paramList.size())
      {
        localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        localObject = (VipComicFavorEmoStructMsgInfo)paramMap.get(localCustomEmotionData.md5);
        if (!TextUtils.isEmpty(localCustomEmotionData.url)) {
          break label295;
        }
        localArrayList2.add(localCustomEmotionData);
        localapon.a(localCustomEmotionData);
        localawgf.b((awge)localObject);
        localAtomicInteger1.decrementAndGet();
        if (paramIPicDownloadListener != null) {
          paramIPicDownloadListener.onFileDone(localCustomEmotionData, false);
        }
      }
      for (;;)
      {
        if ((localAtomicInteger1.get() == 0) && (paramIPicDownloadListener != null)) {
          paramIPicDownloadListener.onDone(localArrayList1, localArrayList2);
        }
        for (;;)
        {
          i += 1;
          break label169;
          break;
          if (paramContext.a(localCustomEmotionData.url) == null) {
            break label333;
          }
          localapon.a(localCustomEmotionData);
          localawgf.b((awge)localObject);
          localAtomicInteger1.decrementAndGet();
        }
        File localFile = new File(a(localCustomEmotionData.md5));
        if (localFile.exists())
        {
          localAtomicInteger1.decrementAndGet();
          localCustomEmotionData.emoPath = localFile.getAbsolutePath();
          if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
            localCustomEmotionData.RomaingType = "isUpdate";
          }
          if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath)))
          {
            localObject = SecUtil.getFileMd5(localCustomEmotionData.emoPath);
            if (!localCustomEmotionData.md5.equals(localObject)) {
              QLog.i("VipComicMqqManager", 2, "init = " + localCustomEmotionData.md5 + " , compute = " + (String)localObject);
            }
          }
          localapon.b(localCustomEmotionData);
          localArrayList1.add(localCustomEmotionData);
          if (paramIPicDownloadListener != null) {
            paramIPicDownloadListener.onFileDone(localCustomEmotionData, true);
          }
        }
        else
        {
          beae localbeae = new beae(localCustomEmotionData.url, localFile);
          localbeae.p = true;
          localbeae.f = "comic_emoticon";
          localbeae.b = 3;
          paramContext.a(localbeae, new apps(this, localFile, localCustomEmotionData, localapon, localArrayList1, paramIPicDownloadListener, localArrayList2, localawgf, (VipComicFavorEmoStructMsgInfo)localObject, localAtomicInteger2, localAtomicInteger1), null);
        }
      }
    } while (paramIPicDownloadListener == null);
    label295:
    label587:
    paramIPicDownloadListener.onDone(new ArrayList(), paramList);
  }
  
  public void a(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(91001);
    localMessage.obj = paramVipComicFavorEmoStructMsgInfo;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    this.jdField_a_of_type_JavaUtilMap.put(paramVipComicFavorEmoStructMsgInfo.picMd5, paramVipComicFavorEmoStructMsgInfo);
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Map localMap = a();
      if ((localMap != null) && (localMap.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = ((String)localIterator.next()).toUpperCase();
          if (localMap.get(str) != null) {
            localArrayList.add(str);
          }
        }
      }
      if ((this.jdField_a_of_type_Appq != null) && (localArrayList.size() > 0))
      {
        this.jdField_a_of_type_Appq.b(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicMqqManager", 2, "delComicStructMsgInfo , delList = " + paramList);
        }
      }
    }
  }
  
  public void a(List<VipComicFavorEmoStructMsgInfo> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramBoolean) {
        c(paramList);
      }
      if (this.jdField_a_of_type_Appq != null)
      {
        ArrayList localArrayList = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)localIterator.next();
          MqqComicPb.ComicFavorEmotIcons localComicFavorEmotIcons = new MqqComicPb.ComicFavorEmotIcons();
          localComicFavorEmotIcons.md5.set(localVipComicFavorEmoStructMsgInfo.picMd5);
          localComicFavorEmotIcons.info.set(localVipComicFavorEmoStructMsgInfo.actionData);
          localArrayList.add(localComicFavorEmotIcons);
        }
        this.jdField_a_of_type_Appq.a(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicMqqManager", 2, "setMyComicEmoticon,isNeedSaveDb =" + paramBoolean + " , favorEmoStructMsgInfoList = " + paramList);
        }
      }
    }
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData)
  {
    return (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)) && (a(paramCustomEmotionData.md5) != null);
  }
  
  public void b(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(91003);
      ((Message)localObject).obj = paramList;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        ((VipComicFavorEmoStructMsgInfo)this.jdField_a_of_type_JavaUtilMap.get(((String)localObject).toUpperCase())).status = 2;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    String[] arrayOfString = null;
    Object localObject = null;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 91000: 
      if ((this.jdField_a_of_type_Awgf == null) || (!this.jdField_a_of_type_Awgf.a())) {
        break;
      }
    }
    try
    {
      paramMessage = this.jdField_a_of_type_Awgf.a(VipComicFavorEmoStructMsgInfo.class, true, null, null, null, null, null, null);
      if (paramMessage != null)
      {
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject = (VipComicFavorEmoStructMsgInfo)paramMessage.next();
          if (!TextUtils.isEmpty(((VipComicFavorEmoStructMsgInfo)localObject).picMd5)) {
            this.jdField_a_of_type_JavaUtilMap.put(((VipComicFavorEmoStructMsgInfo)localObject).picMd5.toUpperCase(), localObject);
          }
        }
      }
      return true;
      if ((paramMessage.obj instanceof VipComicFavorEmoStructMsgInfo)) {
        b((VipComicFavorEmoStructMsgInfo)paramMessage.obj);
      }
      return true;
      try
      {
        paramMessage = (List)paramMessage.obj;
        if ((this.jdField_a_of_type_Awgf == null) || (!this.jdField_a_of_type_Awgf.a()) || (paramMessage == null) || (paramMessage.size() <= 0)) {}
      }
      catch (Exception paramMessage)
      {
        try
        {
          this.jdField_a_of_type_Awgf.a().a();
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext()) {
            b((VipComicFavorEmoStructMsgInfo)paramMessage.next());
          }
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          for (;;)
          {
            return true;
            paramMessage = paramMessage;
            paramMessage = null;
            break;
            this.jdField_a_of_type_Awgf.a().c();
            this.jdField_a_of_type_Awgf.a().b();
          }
        }
        finally
        {
          this.jdField_a_of_type_Awgf.a().b();
        }
      }
      try
      {
        paramMessage = (List)paramMessage.obj;
        if ((this.jdField_a_of_type_Awgf != null) && (this.jdField_a_of_type_Awgf.a()) && (paramMessage != null) && (paramMessage.size() > 0)) {}
        try
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("status", Integer.valueOf(2));
          arrayOfString = new String[paramMessage.size()];
          StringBuilder localStringBuilder = new StringBuilder(" ( ");
          while (i < paramMessage.size())
          {
            localStringBuilder.append(" ? ");
            if (i != paramMessage.size() - 1) {
              localStringBuilder.append(",");
            }
            arrayOfString[i] = SecurityUtile.a(((String)paramMessage.get(i)).toUpperCase());
            i += 1;
          }
          localStringBuilder.append(" ) ");
          paramMessage = "picMd5 in " + localStringBuilder.toString();
          this.jdField_a_of_type_Awgf.a(VipComicFavorEmoStructMsgInfo.class.getSimpleName(), (ContentValues)localObject, paramMessage, arrayOfString);
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage.printStackTrace();
          }
        }
        return true;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          paramMessage = arrayOfString;
        }
      }
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        paramMessage = (Message)localObject;
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Appq = null;
    if (this.jdField_a_of_type_Awgf != null) {
      this.jdField_a_of_type_Awgf.a();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appr
 * JD-Core Version:    0.7.0.1
 */