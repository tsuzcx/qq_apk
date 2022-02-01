import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.JpegExifReader;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.1;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.5;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.8;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.Manager;

public class beyh
  extends Observable
  implements Manager
{
  public static final String a;
  public static volatile boolean a;
  public static int b;
  public int a;
  private long jdField_a_of_type_Long;
  Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Handler jdField_a_of_type_AndroidOsHandler;
  bcrz jdField_a_of_type_Bcrz = new beyl(this);
  public beyw a;
  public bfip a;
  bfja jdField_a_of_type_Bfja = new beyk(this);
  protected bfjm a;
  bfks jdField_a_of_type_Bfks;
  bgod jdField_a_of_type_Bgod = new beyo(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public Comparator<beyv> a;
  HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  String jdField_b_of_type_JavaLangString;
  HashMap<String, List<beyv>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public volatile boolean b;
  private int jdField_c_of_type_Int;
  protected HashMap<String, List<MessageForDeliverGiftTips>> c;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = String.valueOf(10000L);
    jdField_b_of_type_Int = 9;
  }
  
  public beyh(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilComparator = new beyn(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(paramAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(beyv parambeyv)
  {
    int i = 0;
    Object localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(parambeyv.getFriendUin());
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.jdField_b_of_type_JavaUtilHashMap.put(parambeyv.getFriendUin(), localObject);
    }
    for (;;)
    {
      int j;
      try
      {
        ((List)localObject).add(parambeyv);
        int m = parambeyv.getLimitType();
        int k = -1;
        j = 0;
        if (i < ((List)localObject).size())
        {
          parambeyv = (beyv)((List)localObject).get(i);
          if ((parambeyv == null) || (parambeyv.getLimitType() != m)) {
            break label158;
          }
          if (k == -1)
          {
            k = i;
            break label164;
          }
        }
        else
        {
          if (j > a(m)) {
            ((List)localObject).remove(k);
          }
          return;
        }
      }
      finally {}
      break label164;
      label158:
      break label168;
      break;
      label164:
      j += 1;
      label168:
      i += 1;
    }
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && ((paramAppInterface instanceof BrowserAppInterface)))
    {
      h();
      return;
    }
    ThreadManager.post(new AIOAnimationControlManager.1(this), 8, null, true);
  }
  
  private void a(String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 4))
    {
      Object localObject = new File(bfcv.a(paramString, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()));
      Bundle localBundle = new Bundle();
      localBundle.putString("GiftAnimationId", paramString);
      localBundle.putString("TroopUin", paramMessageForDeliverGiftTips.frienduin);
      localBundle.putInt("GiftAnimationType", paramMessageForDeliverGiftTips.animationType);
      localBundle.putBoolean("GiftIsInteract", paramMessageForDeliverGiftTips.isInteract());
      localObject = new bgoe(bfcv.c(paramMessageForDeliverGiftTips), (File)localObject);
      ((bgoe)localObject).jdField_b_of_type_Int = 2;
      if ((paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
        ((MessageForTroopGift)paramMessageForDeliverGiftTips).isLoading = true;
      }
      a().a((bgoe)localObject, this.jdField_a_of_type_Bgod, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "start Download PackageId:" + bfcv.b(paramMessageForDeliverGiftTips));
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(2));
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString1);
    if ((paramString2 == null) || (localList == null)) {
      return;
    }
    int i = 0;
    label25:
    if (i < localList.size())
    {
      paramString1 = (beyv)localList.get(i);
      if (!(paramString1 instanceof MessageForDeliverGiftTips)) {
        break label87;
      }
      paramString1 = bfcv.b((MessageForDeliverGiftTips)paramString1);
    }
    for (;;)
    {
      if (paramString2.equals(paramString1)) {
        localList.remove(i);
      }
      i += 1;
      break label25;
      break;
      label87:
      if ((paramString1 instanceof MessageForTroopEffectPic)) {
        paramString1 = ((MessageForTroopEffectPic)paramString1).effectId + "";
      } else {
        paramString1 = "";
      }
    }
  }
  
  public static boolean a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Object paramObject)
  {
    if ((paramObject instanceof MessageForDeliverGiftTips))
    {
      if (((MessageForDeliverGiftTips)paramObject).isInteract()) {
        break label37;
      }
      paramBaseChatPie.playGiftAnimationPlayList(false);
    }
    for (;;)
    {
      if (akfd.a(paramObject, paramQQAppInterface)) {
        paramBaseChatPie.playGiftAnimationPlayList(false);
      }
      return false;
      label37:
      if (((paramBaseChatPie.getActivity() instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int != 2)) {
        return true;
      }
      ((beyh)paramQQAppInterface.getManager(223)).a(paramBaseChatPie);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(paramString1);
    if ((paramString2 == null) || (paramString1 == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramString1.size())
      {
        if (paramString2.equals(bfcv.b((MessageForDeliverGiftTips)paramString1.get(i)))) {
          paramString1.remove(i);
        }
        i += 1;
      }
    }
  }
  
  private void h()
  {
    Object localObject = new File(AppConstants.SDCARD_GIFT_SAVE);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    int j;
    int i;
    boolean bool;
    if (arrayOfFile != null)
    {
      j = 0;
      if (j < arrayOfFile.length) {
        if ((arrayOfFile[j].exists()) && (arrayOfFile[j].isDirectory()))
        {
          localObject = arrayOfFile[j].getName();
          if (!arrayOfFile[j].getName().endsWith("_HD")) {
            break label180;
          }
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 3);
          i = 0;
          bool = false;
        }
      }
    }
    for (;;)
    {
      label111:
      if (bfcv.a((String)localObject, i, bool))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Integer.valueOf(3));
        if (QLog.isColorLevel()) {
          QLog.d("AIOAnimationControlManager", 2, "Package Downloaded:" + arrayOfFile[j].getName());
        }
      }
      for (;;)
      {
        j += 1;
        break;
        label180:
        if (arrayOfFile[j].getName().endsWith("_V"))
        {
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          bool = false;
          break label111;
        }
        if (!arrayOfFile[j].getName().endsWith("_NEW")) {
          break label270;
        }
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 4);
        i = 1;
        bool = true;
        break label111;
        FileUtils.deleteDirectory(arrayOfFile[j].getAbsolutePath());
      }
      return;
      label270:
      i = 0;
      bool = false;
    }
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (1 == paramInt) {
      return akcv.a().a();
    }
    return 0;
  }
  
  public bgoj a()
  {
    return ((bgog)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(47)).a(1);
  }
  
  public void a()
  {
    int i = 0;
    Object localObject = new File(bfcv.a(0)).getParentFile();
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      if (localObject == null) {}
    }
    for (;;)
    {
      if (i < localObject.length)
      {
        if (localObject[i].exists())
        {
          String str = localObject[i].getName();
          try
          {
            str = str.substring(0, str.indexOf(".mp4"));
            if (bfcv.a(Integer.parseInt(str))) {
              this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(3));
            } else {
              localObject[i].delete();
            }
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label144;
            }
          }
          QLog.e("AIOAnimationControlManager", 2, "checkPicEffectPackageIdState: " + QLog.getStackTraceString(localException));
        }
      }
      else {
        return;
      }
      label144:
      i += 1;
    }
  }
  
  public void a(int paramInt, String paramString, MessageForTroopEffectPic paramMessageForTroopEffectPic)
  {
    paramMessageForTroopEffectPic = "" + paramInt;
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("" + paramInt)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageForTroopEffectPic)).intValue() == 4))
    {
      File localFile = new File(bfcv.a(paramInt));
      Bundle localBundle = new Bundle();
      localBundle.putString("GiftAnimationId", paramMessageForTroopEffectPic);
      localBundle.putString("TroopUin", paramString);
      paramString = new bgoe(bfcv.b(paramInt), localFile);
      paramString.jdField_b_of_type_Int = 2;
      a().a(paramString, this.jdField_a_of_type_Bgod, localBundle);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramMessageForTroopEffectPic, Integer.valueOf(2));
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bfip == null) {
      this.jdField_a_of_type_Bfip = new bfip(null, paramActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_a_of_type_Bfip.a(4);
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Bfip.a();
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  }
  
  public void a(SharedPreferences paramSharedPreferences)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("AIOAnimationControlManager_limit_gif_time", 0L);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("AIOAnimationControlManager_limit_gif_count", 0);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "set TroopChatPie ,troopUin:" + paramBaseChatPie.sessionInfo.curFriendUin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != paramBaseChatPie)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
      addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      this.jdField_a_of_type_Bfip = paramBaseChatPie.getGiftAnimationController();
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)) {
        break label114;
      }
      this.jdField_a_of_type_Bfip.a(1);
      this.jdField_a_of_type_Bfjm = ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a();
      this.jdField_a_of_type_Bfks = ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a();
    }
    label114:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahgz))
      {
        this.jdField_a_of_type_Bfip.a(4);
        return;
      }
    } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahik));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 10002)
    {
      this.jdField_a_of_type_Bfip.a(8);
      return;
    }
    this.jdField_a_of_type_Bfip.a(6);
  }
  
  public void a(String paramString)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.remove(paramString);
    if (localList != null) {
      localList.clear();
    }
    paramString = (List)this.jdField_c_of_type_JavaUtilHashMap.remove(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
  
  public void a(Observer paramObserver)
  {
    beyu.a().addObserver(paramObserver);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) && (this.jdField_a_of_type_AndroidAppActivity == null) && (!jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {}
    Object localObject3;
    Object localObject5;
    label397:
    label753:
    label891:
    String str;
    label875:
    do
    {
      Object localObject4;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  this.jdField_c_of_type_Boolean = paramBoolean;
                  if (!jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
                    break;
                  }
                  localObject1 = this.jdField_b_of_type_JavaLangString;
                  localObject3 = (List)this.jdField_c_of_type_JavaUtilHashMap.get(localObject1);
                  localObject4 = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject1);
                } while ((!b()) && (bfcv.a((List)localObject3)));
                if ((this.jdField_a_of_type_Bfjm == null) || (bfcv.a((List)localObject3))) {
                  break label397;
                }
              } while ((this.jdField_a_of_type_Bfjm.b()) && (this.jdField_a_of_type_Bfjm.a()));
              this.jdField_a_of_type_Int = 2;
              localObject5 = (MessageForDeliverGiftTips)((List)localObject3).get(0);
              localObject6 = bfcv.b((MessageForDeliverGiftTips)localObject5);
              if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() != 3)) {
                break;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getMagicfaceViewController() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getMagicfaceViewController().a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getMagicfaceViewController().a.a()))
              {
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AIOAnimationControlManager.5(this, paramBoolean), 500L);
                return;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {}
                for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;; localObject1 = this.jdField_b_of_type_JavaLangString) {
                  break;
                }
              }
            } while (((MessageForDeliverGiftTips)localObject5).interactState == 2);
            ((bfci)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(113)).a(((MessageForDeliverGiftTips)localObject5).frienduin, ((MessageForDeliverGiftTips)localObject5).interactId, ((MessageForDeliverGiftTips)localObject5).giftId, new beyp(this, (MessageForDeliverGiftTips)localObject5, (List)localObject3, paramBoolean, (List)localObject4, (String)localObject6));
            return;
            if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() == 4))
            {
              b((String)localObject1, (String)localObject6);
              this.jdField_a_of_type_Int = 1;
              a(paramBoolean);
              return;
            }
            this.jdField_a_of_type_Int = 3;
            return;
          } while ((this.jdField_a_of_type_Bfip == null) || (bfcv.a((List)localObject4)));
          this.jdField_a_of_type_Int = 2;
          localObject3 = (beyv)((List)localObject4).get(0);
          if (!(localObject3 instanceof MessageForDeliverGiftTips)) {
            break label1297;
          }
          localObject5 = (MessageForDeliverGiftTips)localObject3;
          if ((((MessageForDeliverGiftTips)localObject5).isToAll()) && (!((MessageForDeliverGiftTips)localObject5).hasFetchButFailed))
          {
            localObject3 = ((bfci)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(113)).a((String)localObject1, ((MessageForDeliverGiftTips)localObject5).bagId, new beyr(this, (MessageForDeliverGiftTips)localObject5, (String)localObject1, paramBoolean));
            if (localObject3 == null)
            {
              this.jdField_a_of_type_Int = 1;
              return;
            }
            if ((!((TroopGiftBagInfo)localObject3).hasGrab()) || (((TroopGiftBagInfo)localObject3).myGrabResult == null)) {
              break label753;
            }
            ((MessageForDeliverGiftTips)localObject5).showButton = false;
            ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject3).myGrabResult.jdField_a_of_type_JavaLangString;
            ((MessageForDeliverGiftTips)localObject5).resultType = 0;
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
              ((MessageForDeliverGiftTips)localObject5).senderName = ContactUtils.getTroopMemberName((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject1, "" + ((MessageForDeliverGiftTips)localObject5).senderUin);
            }
            localObject6 = bfcv.b((MessageForDeliverGiftTips)localObject5);
            if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() != 3)) {
              break label1241;
            }
            this.jdField_a_of_type_Bfip.a(this.jdField_a_of_type_Bcrz);
            if (QLog.isColorLevel()) {
              QLog.d("AIOAnimationControlManager", 2, "Playing! playMaigface id:" + bfcv.b((MessageForDeliverGiftTips)localObject5));
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getMagicfaceViewController() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getMagicfaceViewController().a == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getMagicfaceViewController().a.a())) {
              break;
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AIOAnimationControlManager.8(this, paramBoolean), 500L);
            return;
            if (((TroopGiftBagInfo)localObject3).myGrabResult != null)
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = false;
              ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject3).myGrabResult.jdField_a_of_type_JavaLangString;
              ((MessageForDeliverGiftTips)localObject5).resultType = 1;
            }
            else
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = true;
            }
          }
          if (betn.a().a()) {
            betn.a().b();
          }
          if (TextUtils.isEmpty(((MessageForDeliverGiftTips)localObject5).interactId)) {
            break;
          }
          ((List)localObject4).remove(localObject5);
        } while (this.jdField_a_of_type_Bfjm == null);
        this.jdField_a_of_type_Bfjm.a((MessageForDeliverGiftTips)localObject5, (String)localObject6, false, new beys(this, paramBoolean));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
        {
          localObject3 = "0";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
            break label1209;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
          bcef.b((QQAppInterface)localObject4, "P_CliOper", "Grp_flower", "", "cartoon", "show", 0, 0, (String)localObject1, (String)localObject6, (String)localObject3, "" + muk.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), (String)localObject1));
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder().append("Check isLimitGiftAnim: isEnterAIO:").append(paramBoolean).append(", isToMeGift:");
            if (((MessageForDeliverGiftTips)localObject5).receiverUin == this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin()) {
              break label1215;
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          QLog.d("AIOAnimationControlManager", 2, bool + ", count:" + this.jdField_c_of_type_Int + ", time:" + this.jdField_a_of_type_Long);
          if ((!paramBoolean) || (((MessageForDeliverGiftTips)localObject5).receiverUin == this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin()) || (!a(true))) {
            break label1220;
          }
          if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
            break;
          }
          localObject1 = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          localObject3 = ((QQAppInterface)localObject1).getProxyManager().a().getRecentList(false).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (RecentUser)((Iterator)localObject3).next();
            if (((RecentUser)localObject4).msgType == 7)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AIOAnimationControlManager", 2, "limitGiftAnim setRead RecentUser:" + localObject4);
              }
              ((QQAppInterface)localObject1).getMessageFacade().getTroopMessageManager().a(((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType(), true, false);
            }
          }
          break;
          localObject3 = "1";
          break label875;
          localObject4 = null;
          break label891;
        }
        this.jdField_a_of_type_Bfip.a((MessageForDeliverGiftTips)localObject5);
        this.jdField_a_of_type_Bfip.jdField_a_of_type_Bfja = this.jdField_a_of_type_Bfja;
        return;
        if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject6)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject6)).intValue() == 4))
        {
          a((String)localObject1, (String)localObject6);
          this.jdField_a_of_type_Int = 1;
          a(paramBoolean);
          return;
        }
        this.jdField_a_of_type_Int = 3;
        return;
        if ((localObject3 instanceof akfd))
        {
          localObject1 = (akfd)localObject3;
          this.jdField_a_of_type_Bfip.a((akfd)localObject1);
          ((akfd)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, new beyi(this, paramBoolean));
          ((List)localObject4).remove(localObject3);
          return;
        }
      } while ((!(localObject3 instanceof MessageForTroopEffectPic)) || (this.jdField_a_of_type_Bfks == null));
      localObject5 = (MessageForTroopEffectPic)localObject3;
      localObject3 = "" + ((MessageForTroopEffectPic)localObject5).effectId;
      if ((((MessageForTroopEffectPic)localObject5).effectId < 40003) || (((MessageForTroopEffectPic)localObject5).effectId > 40005)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject3, Integer.valueOf(3));
      }
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3)).intValue() != 3) || (!bfcv.a(((MessageForTroopEffectPic)localObject5).effectId))) {
        break;
      }
      Object localObject1 = ((MessageForTroopEffectPic)localObject5).getPicDownloadInfo();
      ((aydl)localObject1).e = "chatimg";
      Object localObject6 = ((aydl)localObject1).c();
      File localFile = new File((String)localObject6);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localObject3 = null;
      int i;
      switch (JpegExifReader.readOrientation((String)localObject6))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        i = 0;
      }
      for (;;)
      {
        localObject1 = localObject3;
        try
        {
          if (localFile.exists())
          {
            localObject1 = new BufferedInputStream(new FileInputStream(localFile), 2048);
            localOptions.inSampleSize = ((int)bfvo.a((InputStream)localObject1, 720, 1080));
            ((BufferedInputStream)localObject1).close();
            localObject6 = bfvo.a((String)localObject6, localOptions);
            localObject1 = localObject3;
            if (localObject6 != null)
            {
              localObject1 = new Matrix();
              ((Matrix)localObject1).reset();
              ((Matrix)localObject1).setRotate(i);
              localObject1 = Bitmap.createBitmap((Bitmap)localObject6, 0, 0, ((Bitmap)localObject6).getWidth(), ((Bitmap)localObject6).getHeight(), (Matrix)localObject1, true);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOAnimationControlManager", 2, "OOM: " + QLog.getStackTraceString(localOutOfMemoryError));
            }
            str = null;
          }
        }
        if ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie))) {
          break label1829;
        }
        localObject3 = (TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
        this.jdField_a_of_type_Bfks.a(((MessageForTroopEffectPic)localObject5).effectId, (Bitmap)localObject1, ((TroopChatPie)localObject3).jdField_c_of_type_Int, new beyj(this, paramBoolean));
        ((List)localObject4).remove(localObject5);
        return;
        i = 90;
        continue;
        i = 180;
        continue;
        i = 270;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof TroopChatPie)));
    label1209:
    label1215:
    label1220:
    label1241:
    this.jdField_a_of_type_Int = 3;
    label1297:
    label1829:
    this.jdField_a_of_type_Bfks.a((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (MessageForTroopEffectPic)localObject5, false);
    return;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3)).intValue() == 4))
    {
      a(str, (String)localObject3);
      this.jdField_a_of_type_Int = 1;
      a(paramBoolean);
      return;
    }
    a((MessageForTroopEffectPic)localObject5, false);
    this.jdField_a_of_type_Int = 3;
  }
  
  protected boolean a()
  {
    return jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a(beyv parambeyv, boolean paramBoolean)
  {
    if (parambeyv == null) {
      return false;
    }
    if (((parambeyv instanceof MessageForDeliverGiftTips)) && (!bfcv.a((MessageForDeliverGiftTips)parambeyv))) {
      return false;
    }
    a(parambeyv);
    if (paramBoolean)
    {
      setChanged();
      notifyObservers(parambeyv);
    }
    return true;
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!a()) {}
    do
    {
      return false;
      e();
    } while (!b(paramMessageForDeliverGiftTips));
    f();
    return true;
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean)
  {
    if (paramMessageForDeliverGiftTips == null) {}
    while (!bfcv.a(paramMessageForDeliverGiftTips)) {
      return false;
    }
    a(paramMessageForDeliverGiftTips);
    if (paramMessageForDeliverGiftTips.interactState == 2) {
      f();
    }
    for (;;)
    {
      return true;
      ((bfci)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(113)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.giftId, new beym(this, paramMessageForDeliverGiftTips, paramBoolean));
    }
  }
  
  public boolean a(MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    String str = "" + paramMessageForTroopEffectPic.effectId;
    if ((paramMessageForTroopEffectPic.effectId < 40003) || (paramMessageForTroopEffectPic.effectId > 40005))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(str, Integer.valueOf(3));
      if (paramBoolean) {
        return a(paramMessageForTroopEffectPic, false);
      }
      return false;
    }
    int i;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue() == 3)) {
      if (!bfcv.a(paramMessageForTroopEffectPic.effectId))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        FileUtils.deleteFile(bfcv.a(paramMessageForTroopEffectPic.effectId));
        a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "MessageForTroopEffectPic id:" + str + ",state:" + i);
      }
      if (!paramBoolean) {
        break;
      }
      return a(paramMessageForTroopEffectPic, false);
      i = 3;
      continue;
      a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
      i = 2;
    }
    return i == 2;
  }
  
  public boolean a(String paramString)
  {
    List localList = (List)this.jdField_c_of_type_JavaUtilHashMap.get(paramString);
    if ((localList != null) && (!localList.isEmpty())) {
      return true;
    }
    paramString = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    return (paramString != null) && (paramString.size() != 0);
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Long == 0L)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_Int = 1;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramBoolean))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("AIOAnimationControlManager_limit_gif_time", this.jdField_a_of_type_Long).apply();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("AIOAnimationControlManager_limit_gif_count", this.jdField_c_of_type_Int).apply();
      }
      return bool1;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 3600000L)
      {
        jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("AIOAnimationControlManager_limit_gif_count_MAX", jdField_b_of_type_Int);
        if (this.jdField_c_of_type_Int >= jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Int = 4;
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (paramBoolean)
          {
            this.jdField_c_of_type_Int += 1;
            bool1 = bool2;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (paramBoolean)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_c_of_type_Int = 1;
          bool1 = bool2;
        }
      }
    }
  }
  
  public long[] a(String paramString)
  {
    Object localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        beyv localbeyv = (beyv)((Iterator)localObject).next();
        if ((localbeyv instanceof MessageForDeliverGiftTips)) {
          paramString.add(Long.valueOf(((MessageForDeliverGiftTips)localbeyv).getId()));
        }
      }
    }
    localObject = new long[paramString.size()];
    int i = 0;
    while (i < paramString.size())
    {
      localObject[i] = ((Long)paramString.get(i)).longValue();
      i += 1;
    }
    return localObject;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;; localObject = this.jdField_b_of_type_JavaLangString)
    {
      localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
      if ((!this.jdField_b_of_type_Boolean) || (bfcv.a((List)localObject))) {
        break label135;
      }
      int j;
      for (int i = 0; i < ((List)localObject).size(); i = j + 1)
      {
        beyv localbeyv = (beyv)((List)localObject).get(i);
        j = i;
        if (localbeyv.isReaded())
        {
          j = i;
          if (localbeyv.getSenderUin() != this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin())
          {
            ((List)localObject).remove(i);
            j = i - 1;
          }
        }
      }
    }
    Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
    label135:
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(Observer paramObserver)
  {
    beyu.a().deleteObserver(paramObserver);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 4);
  }
  
  public boolean b(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!bfcv.a(paramMessageForDeliverGiftTips)) {
      return false;
    }
    String str = bfcv.b(paramMessageForDeliverGiftTips);
    int i;
    boolean bool;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue() == 3)) {
      if (!bfcv.a(str, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        FileUtils.deleteDirectory(bfcv.a(paramMessageForDeliverGiftTips));
        a(str, paramMessageForDeliverGiftTips);
        i = 2;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAnimationControlManager", 2, "giftRealAnimationId:" + bfcv.b(paramMessageForDeliverGiftTips) + ",state:" + i);
        }
        if ((a()) && (i != 3)) {
          break label188;
        }
        if (!paramMessageForDeliverGiftTips.isInteract()) {
          break label178;
        }
        bool = a(paramMessageForDeliverGiftTips, false);
      }
    }
    for (;;)
    {
      return bool;
      i = 3;
      break;
      a(str, paramMessageForDeliverGiftTips);
      i = 4;
      break;
      label178:
      bool = a(paramMessageForDeliverGiftTips, false);
      continue;
      label188:
      bool = false;
    }
  }
  
  public boolean b(String paramString)
  {
    return (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() != 3);
  }
  
  public void c()
  {
    deleteObservers();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "release TroopChatPie ,troopUin:" + this.jdField_b_of_type_JavaLangString);
    }
    beyu.a().deleteObservers();
    this.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_Bfip = null;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bfjm = null;
  }
  
  public void d()
  {
    beyu.a().deleteObservers();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Bfip = null;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "releaseAnimationList");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;; str = this.jdField_b_of_type_JavaLangString)
    {
      this.jdField_b_of_type_JavaUtilHashMap.remove(str);
      this.jdField_c_of_type_JavaUtilHashMap.remove(str);
      if (this.jdField_a_of_type_Bfip != null)
      {
        this.jdField_a_of_type_Bfip.c();
        this.jdField_a_of_type_Int = 1;
      }
      return;
    }
  }
  
  public void f()
  {
    a(false);
  }
  
  public void g()
  {
    if (betn.a().a()) {
      betn.a().b();
    }
    if ((this.jdField_a_of_type_Bfip != null) && (this.jdField_a_of_type_Bfip.a())) {
      this.jdField_a_of_type_Bfip.c();
    }
    if ((this.jdField_a_of_type_Bfjm != null) && (!this.jdField_a_of_type_Bfjm.a())) {
      this.jdField_a_of_type_Bfjm.a();
    }
    if (this.jdField_a_of_type_Bfks != null) {
      this.jdField_a_of_type_Bfks.a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void onDestroy()
  {
    beyu.a().deleteObservers();
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (QLog.isColorLevel())) {
      QLog.d("AIOAnimationControlManager", 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyh
 * JD-Core Version:    0.7.0.1
 */