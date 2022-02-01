import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.ImgInfo;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.ReqBody;
import com.tencent.pb.icebreakhotpic.IcebreakHotPic.RspBody;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class bbdh
  implements Handler.Callback, aqwi, Manager
{
  public static final String a;
  private float jdField_a_of_type_Float = 7.0F;
  public int a;
  anvi jdField_a_of_type_Anvi = new bbdi(this);
  private aofu jdField_a_of_type_Aofu = new bbdj(this);
  private bkyc jdField_a_of_type_Bkyc = new bkyc(ThreadManager.getFileThreadLooper(), this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<bbdl> jdField_a_of_type_JavaLangRefWeakReference;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  private int jdField_b_of_type_Int = 100;
  private String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  private WeakReference<bbdg> jdField_b_of_type_JavaLangRefWeakReference;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 50;
  private String jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
  private Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private volatile String jdField_d_of_type_JavaLangString;
  private Set<String> jdField_d_of_type_JavaUtilSet = new HashSet();
  private final ConcurrentHashMap<String, Integer> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131705173);
  }
  
  public bbdh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 60;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a("breaking_ice_config", this);
    this.jdField_a_of_type_Bkyc.sendEmptyMessage(0);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anvi, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Aofu, true);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramBoolean1)
    {
      bool1 = bool2;
      if (paramConcurrentHashMap.containsValue(Integer.valueOf(0)))
      {
        Iterator localIterator = paramConcurrentHashMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Integer)((Map.Entry)localIterator.next()).getValue()).intValue() == 0) {
            localIterator.remove();
          }
        }
        bool1 = true;
      }
    }
    paramBoolean1 = bool1;
    if (!paramBoolean2)
    {
      paramBoolean1 = bool1;
      if (paramConcurrentHashMap.containsValue(Integer.valueOf(1)))
      {
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        while (paramConcurrentHashMap.hasNext()) {
          if (((Integer)((Map.Entry)paramConcurrentHashMap.next()).getValue()).intValue() == 0) {
            paramConcurrentHashMap.remove();
          }
        }
        paramBoolean1 = true;
      }
    }
    return paramBoolean1;
  }
  
  private Object[] a(boolean paramBoolean, String paramString)
  {
    boolean bool10 = false;
    bool5 = false;
    boolean bool9 = false;
    bool4 = false;
    String str5 = jdField_a_of_type_JavaLangString;
    String str4 = jdField_a_of_type_JavaLangString;
    float f3 = 7.0F;
    boolean bool8 = false;
    bool3 = false;
    int i4 = 100;
    int i3 = 50;
    int i2 = 60;
    bool7 = false;
    Object localObject2 = paramString;
    if (!paramBoolean) {
      localObject2 = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "breaking_ice_config");
    }
    bool6 = bool7;
    i1 = i2;
    n = i3;
    m = i4;
    f2 = f3;
    str3 = str4;
    String str2 = str5;
    i = i2;
    j = i3;
    k = i4;
    paramBoolean = bool8;
    f1 = f3;
    paramString = str4;
    str1 = str5;
    bool1 = bool9;
    bool2 = bool10;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = i2;
        j = i3;
        k = i4;
        paramBoolean = bool8;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool9;
        bool2 = bool10;
        localObject2 = new JSONObject((String)localObject2);
        i = i2;
        j = i3;
        k = i4;
        paramBoolean = bool8;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool9;
        bool2 = bool10;
        bool5 = ((JSONObject)localObject2).optBoolean("switchNewFrd", false);
        i = i2;
        j = i3;
        k = i4;
        paramBoolean = bool8;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool9;
        bool2 = bool5;
        bool4 = ((JSONObject)localObject2).optBoolean("switchOldFrd", false);
        i = i2;
        j = i3;
        k = i4;
        paramBoolean = bool8;
        f1 = f3;
        paramString = str4;
        str1 = str5;
        bool1 = bool4;
        bool2 = bool5;
        str2 = ((JSONObject)localObject2).optString("tipNewFrd", jdField_a_of_type_JavaLangString);
        i = i2;
        j = i3;
        k = i4;
        paramBoolean = bool8;
        f1 = f3;
        paramString = str4;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        str3 = ((JSONObject)localObject2).optString("tipOldFrd", jdField_a_of_type_JavaLangString);
        i = i2;
        j = i3;
        k = i4;
        paramBoolean = bool8;
        f1 = f3;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        f2 = (float)((JSONObject)localObject2).optDouble("daysOldFrd", 7.0D);
        i = i2;
        j = i3;
        k = i4;
        paramBoolean = bool8;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        bool3 = ((JSONObject)localObject2).optBoolean("switchTroop", false);
        i = i2;
        j = i3;
        k = i4;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        m = ((JSONObject)localObject2).optInt("troopNumberCount", 100);
        i = i2;
        j = i3;
        k = m;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        n = ((JSONObject)localObject2).optInt("troopNumberNotFirendRate", 50);
        i = i2;
        j = n;
        k = m;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        i1 = ((JSONObject)localObject2).optInt("showDuration", 60);
        i = i1;
        j = n;
        k = m;
        paramBoolean = bool3;
        f1 = f2;
        paramString = str3;
        str1 = str2;
        bool1 = bool4;
        bool2 = bool5;
        bool6 = ((JSONObject)localObject2).optBoolean("switchNewFrdMiniCard", false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        bool6 = bool7;
        i1 = i;
        n = j;
        m = k;
        bool3 = paramBoolean;
        f2 = f1;
        str3 = paramString;
        Object localObject1 = str1;
        bool4 = bool1;
        bool5 = bool2;
      }
    }
    return new Object[] { Boolean.valueOf(bool5), Boolean.valueOf(bool4), str2, str3, Float.valueOf(f2), Boolean.valueOf(bool3), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool6) };
  }
  
  private void g()
  {
    Object[] arrayOfObject = a(false, null);
    Object localObject1 = FileUtils.readObject(String.format("%s_%s", new Object[] { "break_ice_map", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    ??? = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_c2c", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    ??? = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_troop", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    ??? = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_match_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    ??? = FileUtils.readObject(String.format("%s_%s", new Object[] { "entered_qcircle_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((localObject1 != null) && ((localObject1 instanceof ConcurrentHashMap))) {}
    Object localObject7;
    for (localObject1 = (ConcurrentHashMap)localObject1;; localObject7 = null)
    {
      if (localObject1 == null) {
        localObject1 = new ConcurrentHashMap();
      }
      for (;;)
      {
        for (;;)
        {
          if (??? != null) {}
          synchronized (this.jdField_a_of_type_JavaUtilSet)
          {
            this.jdField_a_of_type_JavaUtilSet.addAll((Set)???);
            if (??? != null) {}
            synchronized (this.jdField_b_of_type_JavaUtilSet)
            {
              this.jdField_b_of_type_JavaUtilSet.addAll((Set)???);
              if (??? != null) {}
              synchronized (this.jdField_c_of_type_JavaUtilSet)
              {
                this.jdField_c_of_type_JavaUtilSet.addAll((Set)???);
                if (??? != null) {}
                synchronized (this.jdField_d_of_type_JavaUtilSet)
                {
                  this.jdField_d_of_type_JavaUtilSet.addAll((Set)???);
                  a(((Boolean)arrayOfObject[0]).booleanValue(), ((Boolean)arrayOfObject[1]).booleanValue(), (ConcurrentHashMap)localObject1);
                }
              }
            }
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            if (!this.jdField_b_of_type_Boolean)
            {
              if (localObject1 != null) {
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll((Map)localObject1);
              }
              this.jdField_c_of_type_Boolean = ((Boolean)arrayOfObject[0]).booleanValue();
              this.jdField_d_of_type_Boolean = ((Boolean)arrayOfObject[1]).booleanValue();
              this.jdField_b_of_type_JavaLangString = ((String)arrayOfObject[2]);
              this.jdField_c_of_type_JavaLangString = ((String)arrayOfObject[3]);
              this.jdField_a_of_type_Float = ((Float)arrayOfObject[4]).floatValue();
              this.e = ((Boolean)arrayOfObject[5]).booleanValue();
              this.jdField_b_of_type_Int = ((Integer)arrayOfObject[6]).intValue();
              this.jdField_c_of_type_Int = ((Integer)arrayOfObject[7]).intValue();
              this.jdField_a_of_type_Int = ((Integer)arrayOfObject[8]).intValue();
              this.f = ((Boolean)arrayOfObject[9]).booleanValue();
              this.jdField_b_of_type_Boolean = true;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("init IceBreak Config: mSwitchNewFrd: ").append(this.jdField_c_of_type_Boolean).append(",mSwitchOldFrd: ").append(this.jdField_d_of_type_Boolean).append(",mTipNewFrd: ").append(this.jdField_b_of_type_JavaLangString).append(",mTipOldFrd: ").append(this.jdField_c_of_type_JavaLangString).append(",mDaysOldFrd: ").append(this.jdField_a_of_type_Float).append(",switchTroop: ").append(this.e).append(",troopMemberMinCount: ").append(this.jdField_b_of_type_Int).append(",troopMemberNotFriendRate: ").append(this.jdField_c_of_type_Int).append(",showDuration: ").append(this.jdField_a_of_type_Int).append(",mSwitchNewFrdMiniCard: ").append(this.f);
            QLog.d("IceBreak.Mng", 2, ((StringBuilder)localObject1).toString());
            return;
            localObject2 = finally;
            throw localObject2;
            localObject3 = finally;
            throw localObject3;
            localObject4 = finally;
            throw localObject4;
            localObject5 = finally;
            throw localObject5;
          }
        }
      }
    }
  }
  
  private void h()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "break_ice_map", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localConcurrentHashMap);
  }
  
  private void m(String paramString)
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).c(paramString);
    if (localTroopInfo == null)
    {
      QLog.i("IceBreak.HotPic", 1, "troop info is null.");
      return;
    }
    int i;
    int j;
    if (localTroopInfo.wMemberNum < this.jdField_b_of_type_Int)
    {
      Object localObject2 = ((TroopManager)localObject1).b(paramString);
      if ((localObject2 == null) || (((List)localObject2).size() <= 1))
      {
        if (localObject2 == null) {}
        for (i = 0;; i = ((List)localObject2).size())
        {
          QLog.i("IceBreak.HotPic", 1, "troop member size: " + i);
          this.jdField_d_of_type_JavaLangString = paramString;
          ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).o(paramString);
          return;
        }
      }
      j = ((List)localObject2).size();
      localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      label186:
      if (((Iterator)localObject2).hasNext())
      {
        String str2 = ((TroopMemberInfo)((Iterator)localObject2).next()).memberuin;
        if ((TextUtils.isEmpty(str2)) || (str2.equals(str1)) || (((anvk)localObject1).b(str2))) {
          break label321;
        }
        i += 1;
      }
    }
    label321:
    for (;;)
    {
      break label186;
      QLog.i("IceBreak.HotPic", 1, "noFriendCount: " + i + " total count: " + localTroopInfo.wMemberNum);
      if (1.0F * i / (j - 1) <= this.jdField_c_of_type_Int / 100.0F) {
        break;
      }
      f(paramString);
      return;
      f(paramString);
      return;
    }
  }
  
  public float a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_a_of_type_Float;
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = -1;
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (paramInt == 1)
    {
      paramString = (Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString == null) {
        paramInt = -1;
      }
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return paramInt;
            paramInt = paramString.intValue();
          }
          if (!bbdk.d(paramInt)) {
            break;
          }
          paramString = (Integer)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          paramInt = i;
        } while (paramString == null);
        return paramString.intValue();
        if (!bbdk.e(paramInt)) {
          break;
        }
        paramString = (Integer)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        paramInt = i;
      } while (paramString == null);
      return paramString.intValue();
      paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      paramInt = i;
    } while (paramString == null);
    return paramString.intValue();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "removeAllEnteredMatchChat ");
    }
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_c_of_type_JavaUtilSet.isEmpty())
    {
      this.jdField_c_of_type_JavaUtilSet.clear();
      d();
    }
  }
  
  public void a(bbdg parambbdg)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parambbdg);
  }
  
  public void a(bbdl parambbdl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbdl);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aqwh paramaqwh)
  {
    if ((paramaqwh != null) && ("breaking_ice_config".equals(paramString)))
    {
      if (!this.jdField_b_of_type_Boolean) {
        g();
      }
      paramQQAppInterface = a(true, paramaqwh.jdField_a_of_type_JavaLangString);
      boolean bool1 = ((Boolean)paramQQAppInterface[0]).booleanValue();
      boolean bool2 = ((Boolean)paramQQAppInterface[1]).booleanValue();
      this.jdField_b_of_type_JavaLangString = ((String)paramQQAppInterface[2]);
      this.jdField_c_of_type_JavaLangString = ((String)paramQQAppInterface[3]);
      this.jdField_a_of_type_Float = ((Float)paramQQAppInterface[4]).floatValue();
      this.e = ((Boolean)paramQQAppInterface[5]).booleanValue();
      this.jdField_b_of_type_Int = ((Integer)paramQQAppInterface[6]).intValue();
      this.jdField_c_of_type_Int = ((Integer)paramQQAppInterface[7]).intValue();
      this.jdField_a_of_type_Int = ((Integer)paramQQAppInterface[8]).intValue();
      this.f = ((Boolean)paramQQAppInterface[9]).booleanValue();
      if ((bool1 != this.jdField_c_of_type_Boolean) || (bool2 != this.jdField_d_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = ((Boolean)paramQQAppInterface[0]).booleanValue();
        this.jdField_d_of_type_Boolean = ((Boolean)paramQQAppInterface[1]).booleanValue();
        paramQQAppInterface = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        paramQQAppInterface.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
        if (a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean, paramQQAppInterface))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramQQAppInterface);
          if (this.jdField_a_of_type_Bkyc.hasMessages(1)) {
            this.jdField_a_of_type_Bkyc.removeMessages(1);
          }
          this.jdField_a_of_type_Bkyc.sendEmptyMessage(1);
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("onGetConfig: mSwitchNewFrd: ").append(this.jdField_c_of_type_Boolean).append(",mSwitchOldFrd: ").append(this.jdField_d_of_type_Boolean).append(",mTipNewFrd: ").append(this.jdField_b_of_type_JavaLangString).append(",mTipOldFrd: ").append(this.jdField_c_of_type_JavaLangString).append(",mDaysOldFrd: ").append(this.jdField_a_of_type_Float).append(",switchTroop: ").append(this.e).append(",troopMemberMinCount: ").append(this.jdField_b_of_type_Int).append(",troopMemberNotFriendRate: ").append(this.jdField_c_of_type_Int).append(",showDuration: ").append(this.jdField_a_of_type_Int).append(",mSwitchNewFrdMiniCard: ").append(this.f);
        QLog.d("IceBreak.Mng", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.HotPic", 2, "removeEnteredMatchChat " + paramString);
    }
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.jdField_c_of_type_JavaUtilSet.contains(paramString))
    {
      this.jdField_c_of_type_JavaUtilSet.remove(paramString);
      d();
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreak.Mng", 2, String.format("request HotPicList fromUin: %s, termType: %s, aioType: %s, toUin: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    }
    try
    {
      IcebreakHotPic.ReqBody localReqBody = new IcebreakHotPic.ReqBody();
      localReqBody.setHasFlag(true);
      String str = paramString1 + SystemClock.uptimeMillis();
      localReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
      localReqBody.uint64_src_uin.set(Long.parseLong(paramString1));
      localReqBody.uint32_src_term.set(paramInt1);
      localReqBody.uint32_aio_type.set(paramInt2);
      localReqBody.uint64_to_uin.set(Long.parseLong(paramString2));
      localReqBody.str_client_ver.set("8.4.10");
      paramString1 = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (paramString1 != null) {
        localReqBody.uint32_age.set(paramString1.age);
      }
      for (;;)
      {
        paramString1 = localReqBody.toByteArray();
        paramString2 = ByteBuffer.allocate(paramString1.length + 4);
        paramString2.putInt(paramString1.length + 4).put(paramString1);
        paramString1 = paramString2.array();
        paramString2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), aiiu.class);
        paramString2.putExtra("key_body", paramString1);
        paramString2.putExtra("key_cmd", "BreakIceSvr.Pull");
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.Mng", 2, "request HotPicList, sessionId = " + str);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
        return;
        localReqBody.uint32_age.set(0);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("IceBreak.Mng", 1, "request HotPicList exception", paramString1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!a(paramBoolean)) {}
    label55:
    label186:
    for (;;)
    {
      return;
      Object localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
      boolean bool;
      int i;
      if ((localObject != null) && (((Friends)localObject).isFriend()))
      {
        bool = true;
        if (!bool) {
          break label179;
        }
        if (!paramBoolean) {
          break label174;
        }
        i = 0;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(i));
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          localObject = (bbdl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            ((bbdl)localObject).a(paramString, false);
          }
        }
        if (this.jdField_a_of_type_Bkyc.hasMessages(1)) {
          this.jdField_a_of_type_Bkyc.removeMessages(1);
        }
        this.jdField_a_of_type_Bkyc.sendEmptyMessage(1);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label186;
        }
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "addToBreakingIceList uin: %s, ret: %s", new Object[] { paramString, Boolean.valueOf(bool) }));
        return;
        bool = false;
        break;
        i = 1;
        break label55;
        e(paramString);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new IcebreakHotPic.RspBody();
      ((IcebreakHotPic.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (((IcebreakHotPic.RspBody)localObject).int32_result.get() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse response code error,result:" + ((IcebreakHotPic.RspBody)localObject).int32_result.get() + " message : " + ((IcebreakHotPic.RspBody)localObject).bytes_fail_msg.get());
        }
      }
      else
      {
        paramArrayOfByte = ((IcebreakHotPic.RspBody)localObject).rpt_msg_img_info.get();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse imgInfos is null or empty");
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("IceBreak.HotPic", 2, bkym.a(paramArrayOfByte));
        return;
        int j = ((IcebreakHotPic.RspBody)localObject).int32_img_num.get();
        localObject = new ArrayList();
        int i = 0;
        while (i < paramArrayOfByte.size())
        {
          IcebreakHotPic.ImgInfo localImgInfo = (IcebreakHotPic.ImgInfo)paramArrayOfByte.get(i);
          aiig localaiig = new aiig();
          localaiig.f(i);
          localaiig.c(localImgInfo.uint64_img_size.get());
          localaiig.a(localImgInfo.uint32_img_width.get());
          localaiig.b(localImgInfo.uint32_img_height.get());
          localaiig.e(localImgInfo.bytes_img_md5.get().toStringUtf8());
          localaiig.c(localImgInfo.bytes_img_down_url.get().toStringUtf8());
          localaiig.b(localImgInfo.bytes_img_word.get().toStringUtf8());
          localaiig.d(localImgInfo.uint64_thumb_size.get());
          localaiig.d(localImgInfo.uint32_thumb_img_height.get());
          localaiig.c(localImgInfo.uint32_thumb_img_width.get());
          localaiig.d(localImgInfo.bytes_thumb_down_url.get().toStringUtf8());
          localaiig.f(localImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
          ((List)localObject).add(localaiig);
          i += 1;
        }
        ThreadManager.getUIHandler().post(new IceBreakingMng.2(this, (List)localObject, j));
        if (QLog.isColorLevel()) {
          QLog.d("IceBreak.HotPic", 2, "handleGetIceBreakHotPicResponse staticImageNum:" + j + "dateList: " + localObject);
        }
      }
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.jdField_a_of_type_Boolean) {
      this.f = true;
    }
    return this.f;
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
    }
    if (paramBoolean) {
      return this.jdField_c_of_type_Boolean;
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_a_of_type_JavaUtilSet);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_c2c", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void b(bbdl parambbdl)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == parambbdl)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_c_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_c_of_type_JavaUtilSet)
      {
        this.jdField_c_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_b_of_type_JavaUtilSet);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_troop", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void c(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_d_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_d_of_type_JavaUtilSet)
      {
        this.jdField_d_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean c(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_c_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void d()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_c_of_type_JavaUtilSet);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_match_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void d(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    return this.jdField_d_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void e()
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.jdField_d_of_type_JavaUtilSet);
    FileUtils.writeObject(String.format("%s_%s", new Object[] { "entered_qcircle_chat", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }), localHashSet);
  }
  
  public void e(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    if (!this.jdField_b_of_type_JavaUtilSet.contains(paramString)) {
      synchronized (this.jdField_b_of_type_JavaUtilSet)
      {
        this.jdField_b_of_type_JavaUtilSet.add(paramString);
        return;
      }
    }
  }
  
  public boolean e(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        bbdl localbbdl = (bbdl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localbbdl != null) {
          localbbdl.b(paramString, false);
        }
      }
      if (this.jdField_a_of_type_Bkyc.hasMessages(1)) {
        this.jdField_a_of_type_Bkyc.removeMessages(1);
      }
      this.jdField_a_of_type_Bkyc.sendEmptyMessage(1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "removeFromBreakingIceList uin: %s , ret:%s", new Object[] { paramString, localObject }));
    }
    return localObject != null;
  }
  
  public void f()
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  public void f(String paramString)
  {
    QLog.i("IceBreak.Mng", 1, "insertTroopToBreakingIceMap troopUin: " + paramString);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bbdl localbbdl = (bbdl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbbdl != null) {
        localbbdl.a(paramString, true);
      }
    }
  }
  
  public boolean f(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    boolean bool2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    boolean bool1 = bool2;
    if (bool2)
    {
      paramString = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
      if ((paramString != null) && (paramString.isFriend())) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void g(String paramString)
  {
    QLog.i("IceBreak.Mng", 1, "removeTroopFromBreakingIceMap troopUin: " + paramString);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bbdl localbbdl = (bbdl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbbdl != null) {
        localbbdl.b(paramString, true);
      }
    }
  }
  
  public void h(String paramString)
  {
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bbdl localbbdl = (bbdl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbbdl != null) {
        localbbdl.b(paramString, false);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      h();
      continue;
      g();
    }
  }
  
  public void i(String paramString)
  {
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bbdl localbbdl = (bbdl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbbdl != null) {
        localbbdl.b(paramString, false);
      }
    }
  }
  
  public void j(String paramString)
  {
    if (c(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat enter " + paramString);
      }
    }
    bbdl localbbdl;
    do
    {
      do
      {
        do
        {
          return;
          if (((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).e()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat switch is off");
        return;
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      localbbdl = (bbdl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbbdl == null);
    localbbdl.a(paramString, false);
  }
  
  public void k(String paramString)
  {
    if (d(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("IceBreak.Mng", 2, "checkNeedShowIceBreakMatchChat enter " + paramString);
      }
    }
    bbdl localbbdl;
    do
    {
      do
      {
        return;
        this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      localbbdl = (bbdl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbbdl == null);
    localbbdl.a(paramString, false);
  }
  
  public void l(String paramString)
  {
    if (!aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "checkNeedShowIceBreakForTroop emotionRec switch is off");
      }
    }
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      return;
      if (b(paramString))
      {
        QLog.i("IceBreak.HotPic", 1, "entered toop.");
        return;
      }
      if (!this.e)
      {
        QLog.i("IceBreak.HotPic", 1, "troop switch is off.");
        return;
      }
      localTroopMemberInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((localTroopMemberInfo == null) || (localTroopMemberInfo.last_active_time == localTroopMemberInfo.join_time))
      {
        QLog.i("IceBreak.HotPic", 1, "troop member info is null.");
        this.jdField_d_of_type_JavaLangString = paramString;
        ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Long.valueOf(paramString).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue(), true);
        return;
      }
      QLog.i("IceBreak.HotPic", 1, "last_active_time: " + localTroopMemberInfo.last_active_time + " join_time: " + localTroopMemberInfo.join_time);
    } while (localTroopMemberInfo.last_active_time > localTroopMemberInfo.join_time);
    m(paramString);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bkyc.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdh
 * JD-Core Version:    0.7.0.1
 */