import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.4;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.7;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import mqq.os.MqqHandler;

public class ansm
{
  private static Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ansn(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  private ansk jdField_a_of_type_Ansk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(-2000), Integer.valueOf(-1035), Integer.valueOf(-2006) });
  private final List<Integer> b = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(3000) });
  
  static
  {
    ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
    localThreadPoolParams.poolThreadName = "groupemostore_pool";
    localThreadPoolParams.corePoolsize = 2;
    localThreadPoolParams.maxPooolSize = 2;
    localThreadPoolParams.priority = 5;
    localThreadPoolParams.queue = new LinkedBlockingQueue();
    localThreadPoolParams.keepAliveTime = 10;
    jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
  }
  
  public ansm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    this.jdField_a_of_type_Ansk = ((ansk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(259));
  }
  
  private String b(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      return ajsd.bh + akvt.a(str) + paramString + ".jpg";
    }
    return "";
  }
  
  public int a()
  {
    return (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - axlk.a(11.0F) * 2 - axlk.a(2.0F) * 2) / 3;
  }
  
  public int a(URLDrawable paramURLDrawable)
  {
    int j = -1;
    int i = j;
    String str;
    if (paramURLDrawable != null)
    {
      i = j;
      if (1 == paramURLDrawable.getStatus())
      {
        str = paramURLDrawable.getURL().toString();
        i = j;
        if (ayoi.b(str))
        {
          Object localObject = ayoi.a(str);
          str = null;
          if (localObject != null) {
            str = SecUtil.getFileMd5(((File)localObject).getAbsolutePath());
          }
          i = j;
          if (str != null)
          {
            i = j;
            if (!"".equals(str))
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              str = ajsd.bh + akvt.a((String)localObject) + str + ".jpg";
            }
          }
        }
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Emo.onUploadPic", 2, "addEmoticonToServer urldrawable status: " + paramURLDrawable.getStatus());
      }
      paramURLDrawable.saveTo(str);
      i = aehw.a(this.jdField_a_of_type_AndroidContentContext, str);
      return i;
    }
    catch (IOException paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.d("EmoticonFromGroup_Manager", 1, paramURLDrawable, new Object[0]);
    }
    return -1;
  }
  
  public long a(String paramString, int paramInt)
  {
    long l = 0L;
    SimpleDateFormat localSimpleDateFormat = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localSimpleDateFormat != null) {}
      try
      {
        l = localSimpleDateFormat.parse(paramString).getTime();
        return l;
      }
      catch (ParseException paramString)
      {
        paramString.printStackTrace();
      }
      localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      continue;
      localSimpleDateFormat = new SimpleDateFormat("MM月dd日");
      continue;
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    return 0L;
  }
  
  public Drawable a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (paramInt < 0)) {
      return null;
    }
    int i = paramInt * 2;
    paramInt *= 2;
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, paramInt, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, paramInt);
      paramDrawable.draw(localCanvas);
      return new BitmapDrawable(bbef.a((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()));
    }
  }
  
  public Drawable a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (65537 == paramInt1)
        {
          localURLDrawableOptions.mRequestWidth = paramInt2;
          localURLDrawableOptions.mRequestHeight = paramInt2;
          paramDrawable = new URL(paramEmoticonFromGroupEntity.thumbURL + "?noRound");
          if (paramDrawable != null)
          {
            paramDrawable = URLDrawable.getDrawable(paramDrawable, localURLDrawableOptions);
            if (paramEmoticonFromGroupEntity.msg == null) {
              break;
            }
            paramDrawable.setTag(paramEmoticonFromGroupEntity.msg);
            return paramDrawable;
          }
        }
        else
        {
          if (1 != paramInt1) {
            break label164;
          }
          if (paramEmoticonFromGroupEntity.gifImg) {
            localURLDrawableOptions.mPlayGifImage = true;
          }
          if (paramDrawable != null)
          {
            localURLDrawableOptions.mLoadingDrawable = paramDrawable;
            localURLDrawableOptions.mFailedDrawable = paramDrawable;
          }
          paramDrawable = new URL(paramEmoticonFromGroupEntity.bigURL);
          continue;
        }
        return null;
      }
      catch (MalformedURLException paramEmoticonFromGroupEntity)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_Manager", 2, "group emo new URL error!");
        }
        paramEmoticonFromGroupEntity.printStackTrace();
      }
      label164:
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "URLString get type error!");
      }
      paramDrawable = null;
    }
    return paramDrawable;
  }
  
  public EmoticonFromGroupEntity a(MessageRecord paramMessageRecord)
  {
    Object localObject = null;
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = new EmoticonFromGroupEntity();
    localEmoticonFromGroupEntity.troopUin = paramMessageRecord.frienduin;
    localEmoticonFromGroupEntity.fromType = paramMessageRecord.istroop;
    localEmoticonFromGroupEntity.timestamp = paramMessageRecord.time;
    localEmoticonFromGroupEntity.msgseq = paramMessageRecord.shmsgseq;
    MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
    boolean bool;
    if ((localMessageForPic.imageType == 3) || (localMessageForPic.imageType == 2000))
    {
      bool = true;
      localEmoticonFromGroupEntity.gifImg = bool;
      localEmoticonFromGroupEntity.md5 = localMessageForPic.md5;
      paramMessageRecord = aywm.a(localMessageForPic, 65537);
      if (paramMessageRecord != null) {
        break label154;
      }
      paramMessageRecord = null;
      label106:
      localEmoticonFromGroupEntity.thumbURL = paramMessageRecord;
      paramMessageRecord = aywm.a(localMessageForPic, 1);
      if (paramMessageRecord != null) {
        break label162;
      }
    }
    label154:
    label162:
    for (paramMessageRecord = localObject;; paramMessageRecord = paramMessageRecord.toString())
    {
      localEmoticonFromGroupEntity.bigURL = paramMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "addBaseInfoToEmoticonFromGroupEntity");
      }
      return localEmoticonFromGroupEntity;
      bool = false;
      break;
      paramMessageRecord = paramMessageRecord.toString();
      break label106;
    }
  }
  
  public MessageForPic a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramEmoticonFromGroupEntity.troopUin, paramEmoticonFromGroupEntity.fromType, paramEmoticonFromGroupEntity.msgseq);
    if (localObject1 != null)
    {
      if ((localObject1 instanceof MessageForPic)) {
        return (MessageForPic)localObject1;
      }
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localObject1;
        Iterator localIterator = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (MessageRecord)localIterator.next();
          if ((localObject2 instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localObject2;
            if (((MessageForPic)localObject2).md5.equals(paramEmoticonFromGroupEntity.md5))
            {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject2, (MessageForMixedMsg)localObject1);
              return localObject2;
            }
          }
        }
      }
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    String str = null;
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l);
    if (l >= paramLong)
    {
      l -= paramLong;
      int i;
      if (0L < l)
      {
        if (localTime1.year != localTime2.year) {
          break label226;
        }
        i = (int)Math.ceil(l / 86400000.0D) - 1;
        if (i == 0) {
          str = ajya.a(2131704055);
        }
      }
      else
      {
        return str;
      }
      if (1 == i) {
        return ajya.a(2131704046);
      }
      if (7 > i)
      {
        switch (localTime1.weekDay)
        {
        default: 
          return null;
        case 0: 
          return ajya.a(2131704067);
        case 1: 
          return ajya.a(2131704091);
        case 2: 
          return ajya.a(2131704054);
        case 3: 
          return ajya.a(2131704068);
        case 4: 
          return ajya.a(2131704050);
        case 5: 
          return ajya.a(2131704074);
        }
        return ajya.a(2131704082);
      }
      return a(paramLong, 1);
      label226:
      return a(paramLong, 0);
    }
    return a(paramLong, 0);
  }
  
  public String a(long paramLong, int paramInt)
  {
    String str = null;
    SimpleDateFormat localSimpleDateFormat;
    switch (paramInt)
    {
    default: 
      localSimpleDateFormat = null;
    }
    for (;;)
    {
      if (localSimpleDateFormat != null) {
        str = localSimpleDateFormat.format(new Date(paramLong));
      }
      return str;
      localSimpleDateFormat = new SimpleDateFormat("y年M月d日");
      continue;
      localSimpleDateFormat = new SimpleDateFormat("M月d日");
      continue;
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
  }
  
  public String a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()) && (ayoi.b(paramString)))
    {
      paramString = ayoi.a(paramString);
      if (paramString != null) {
        return SecUtil.getFileMd5(paramString.getAbsolutePath());
      }
    }
    return "";
  }
  
  public String a(String paramString1, int paramInt, String paramString2)
  {
    long l = a(paramString1, 2);
    return a(l) + paramString2 + "(" + paramInt + ")";
  }
  
  public List<EmoticonFromGroupEntity> a()
  {
    return this.jdField_a_of_type_Ansk.c();
  }
  
  public Map<String, List<EmoticonFromGroupEntity>> a(List<EmoticonFromGroupEntity> paramList)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = null;
    Object localObject = localEmoticonFromGroupEntity;
    if (paramList != null)
    {
      localObject = localEmoticonFromGroupEntity;
      if (!paramList.isEmpty())
      {
        localObject = new TreeMap(new anso(this));
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
          String str = b(localEmoticonFromGroupEntity.timestamp, 2);
          if (((Map)localObject).containsKey(str))
          {
            ((List)((Map)localObject).get(str)).add(localEmoticonFromGroupEntity);
          }
          else
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localEmoticonFromGroupEntity);
            ((Map)localObject).put(str, localArrayList);
          }
        }
      }
    }
    return localObject;
  }
  
  public void a()
  {
    ThreadManager.post(new EmoticonFromGroupManager.4(this), 5, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Manager", 2, "init mEmoManager.mCountOfSpare:" + this.jdField_a_of_type_Ansk.b);
    }
  }
  
  public void a(Context paramContext, MessageForPic paramMessageForPic, View paramView)
  {
    if (paramMessageForPic == null) {
      return;
    }
    paramView = xpu.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    localBundle.putBoolean("IS_APP_SHARE_PIC", true);
    localBundle.putBoolean("group.emo.big.preview", true);
    localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
    bgky.a(paramContext, localBundle, new AIOImageProviderService(paramMessageForPic.selfuin, null, -1, paramMessageForPic), aehw.a(paramMessageForPic), -1, -1);
  }
  
  public void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    this.jdField_a_of_type_Ansk.a(paramEmoticonFromGroupEntity, 2);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (a(paramMessageRecord)) {
      this.jdField_a_of_type_Ansk.b(paramMessageRecord);
    }
  }
  
  public void a(String paramString)
  {
    MqqHandler localMqqHandler;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null)
      {
        localObject = b();
        if (localObject != null) {
          break label41;
        }
        QLog.e("EmoticonFromGroup_Manager", 1, "save to WY, datas is null.");
      }
    }
    return;
    label41:
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (EmoticonFromGroupEntity)localIterator.next();
    } while (!paramString.equals(((EmoticonFromGroupEntity)localObject).md5));
    for (paramString = (String)localObject;; paramString = null)
    {
      if (paramString != null)
      {
        if (paramString.msg != null)
        {
          if ((ajyi.a(paramString.msg)) || (ajwb.a(paramString.msg))) {
            aptx.a(2131692669);
          }
        }
        else
        {
          QLog.e("EmoticonFromGroup_Manager.msgnull", 1, "save2WY msg is null.");
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString.msg, new anss(localMqqHandler));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("EmoticonFromGroup_Manager", 2, "save2WY, tarEmo is null.");
      return;
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if (!a()) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Ansk.a() >= 600) || (this.jdField_a_of_type_Ansk.b() >= 300))
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmoticonFromGroup_Manager", 1, "over max limit.");
        }
      }
      else
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramList.next();
          Integer localInteger = Integer.valueOf(localMessageRecord.msgtype);
          if ((this.jdField_a_of_type_JavaUtilList.contains(localInteger)) && (!ajwb.a(localMessageRecord)) && (!asyx.a(localMessageRecord)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonFromGroup_Manager", 2, "filterMessageByType type: " + localInteger);
            }
            this.jdField_a_of_type_Ansk.a(localMessageRecord);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.length >= 8)
        {
          bool1 = bool2;
          if ("0".equals(localObject[7])) {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (this.jdField_a_of_type_Ansk.b < 1)
    {
      if (300 == ansu.a) {
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131689689, 0).b(2131298865);
      }
      do
      {
        do
        {
          do
          {
            return false;
          } while (144 != ansu.a);
          paramEmoticonFromGroupEntity = new ansp(this, (BaseActivity)localObject);
        } while (localObject == null);
        paramEmoticonFromGroupEntity = bbdj.a((Context)localObject, 0, ajya.a(2131704071), ((BaseActivity)localObject).getString(2131689688), ajya.a(2131704069), ajya.a(2131704093), paramEmoticonFromGroupEntity, paramEmoticonFromGroupEntity);
      } while (paramEmoticonFromGroupEntity == null);
      paramEmoticonFromGroupEntity.show();
      return false;
    }
    localObject = this.jdField_a_of_type_Ansk;
    ((ansk)localObject).b -= 1;
    c(paramEmoticonFromGroupEntity);
    bcql.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131692027, 0).b(2131298865);
    return true;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (this.b.contains(Integer.valueOf(paramMessageRecord.istroop)))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramMessageRecord.msgtype))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    Object localObject = (answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "call getEmoticonDataList from EmoticonFromGroupManager.filterFavoriteEmoticonAfterDownload");
    }
    localObject = ((answ)localObject).a();
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        if ((TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(i)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)((List)localObject).get(i)).RomaingType))) {
          localArrayList.add(((List)localObject).get(i));
        }
        i += 1;
      }
    }
    boolean bool1 = bool2;
    if (!localArrayList.isEmpty())
    {
      localObject = localArrayList.iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.equals(((CustomEmotionData)((Iterator)localObject).next()).md5));
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "filterFavoriteEmoticonAfterDownload " + paramString);
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(List<CustomEmotionData> paramList, String paramString)
  {
    paramString = a(paramString);
    if (!paramList.isEmpty())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (paramString.equals(((CustomEmotionData)paramList.next()).md5))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_Manager", 2, "filter favorite true.");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public int b()
  {
    int k = 0;
    int j = 0;
    Object localObject = (answ)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "Call getEmoticonDataList from getFavEmoCount.");
    }
    localObject = ((answ)localObject).a();
    int i = k;
    if (localObject != null)
    {
      i = k;
      if (!((List)localObject).isEmpty()) {
        for (i = 0; j < ((List)localObject).size(); i = k)
        {
          if (!TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(j)).RomaingType))
          {
            k = i;
            if ("needDel".equals(((CustomEmotionData)((List)localObject).get(j)).RomaingType)) {}
          }
          else
          {
            k = i + 1;
          }
          j += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "emoCount: " + i);
    }
    return i;
  }
  
  public String b(long paramLong, int paramInt)
  {
    return a(1000L * paramLong, paramInt);
  }
  
  public List<EmoticonFromGroupEntity> b()
  {
    return this.jdField_a_of_type_Ansk.b();
  }
  
  public void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    this.jdField_a_of_type_Ansk.a(paramEmoticonFromGroupEntity);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord);
  }
  
  public void b(List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_a_of_type_Ansk.a(paramList, 2);
  }
  
  public boolean b(String paramString)
  {
    Iterator localIterator = b().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (EmoticonFromGroupEntity)localIterator.next();
    } while ((!paramString.equals(((EmoticonFromGroupEntity)localObject).md5)) || (((EmoticonFromGroupEntity)localObject).status == 0));
    for (paramString = (String)localObject;; paramString = null)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = paramString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      if (this.jdField_a_of_type_Ansk.b < 1) {}
      for (boolean bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_Manager", 2, "isSuccess: " + bool);
        }
        return bool;
      }
    }
  }
  
  public void c(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return;
    }
    URLDrawable localURLDrawable = (URLDrawable)a(paramEmoticonFromGroupEntity, 1, -1, null);
    if (localURLDrawable == null)
    {
      QLog.e("EmoticonFromGroup_Manager", 1, "get drawable failed: " + paramEmoticonFromGroupEntity);
      return;
    }
    if (1 != localURLDrawable.getStatus())
    {
      this.jdField_a_of_type_Ansk.jdField_a_of_type_JavaUtilList.add(localURLDrawable);
      localURLDrawable.setURLDrawableListener(new ansr(this, localURLDrawable));
      localURLDrawable.startDownload();
    }
    for (;;)
    {
      paramEmoticonFromGroupEntity.status = 0;
      return;
      this.jdField_a_of_type_Ansk.jdField_a_of_type_JavaUtilList.remove(localURLDrawable);
      jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new EmoticonFromGroupManager.7(this, localURLDrawable));
    }
  }
  
  public void c(List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_a_of_type_Ansk.a(paramList);
  }
  
  public void d(List<EmoticonFromGroupEntity> paramList)
  {
    if (!paramList.isEmpty()) {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131692027, 0).b(2131298865);
    }
    jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new EmoticonFromGroupManager.5(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansm
 * JD-Core Version:    0.7.0.1
 */