import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView;
import com.tencent.mobileqq.doutu.DoutuManager.10;
import com.tencent.mobileqq.doutu.DoutuManager.3;
import com.tencent.mobileqq.doutu.DoutuManager.4;
import com.tencent.mobileqq.doutu.DoutuManager.5;
import com.tencent.mobileqq.doutu.DoutuManager.6;
import com.tencent.mobileqq.doutu.DoutuManager.7;
import com.tencent.mobileqq.doutu.DoutuManager.8;
import com.tencent.mobileqq.doutu.DoutuManager.9;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class apfp
  implements Manager
{
  public static final String a;
  public static volatile boolean a;
  private static long jdField_e_of_type_Long = 512000L;
  private static long jdField_f_of_type_Long = 500L;
  public int a;
  private long jdField_a_of_type_Long = 15L;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public LinearLayout a;
  public apfk a;
  private awbw jdField_a_of_type_Awbw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  public List<String> a;
  public ConcurrentHashMap<Long, apfo> a;
  public MqqHandler a;
  private int jdField_b_of_type_Int = 3;
  private long jdField_b_of_type_Long = 15L;
  private List<DoutuData> jdField_b_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, apfu>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean b;
  private volatile int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 1800L;
  private List<DoutuData> jdField_c_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, apft>> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private volatile int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long = 15L;
  private List<ChatMessage> jdField_d_of_type_JavaUtilList;
  private boolean jdField_d_of_type_Boolean = false;
  private volatile int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private volatile int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = bayb.a(aljq.aX + "DoutuRes" + File.separator);
  }
  
  public apfp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("DoutuManager", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private int a(List<ChatMessage> paramList, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramList.size() - paramInt < this.jdField_b_of_type_Int) {
      return -1;
    }
    int i = paramList.size() - 1;
    label27:
    int j;
    if (i >= this.jdField_b_of_type_Int + paramInt - 1)
    {
      j = i;
      label44:
      if (j <= i - this.jdField_b_of_type_Int + 1) {
        break label369;
      }
      long l1 = ((ChatMessage)paramList.get(j - 1)).time;
      long l2 = ((ChatMessage)paramList.get(j)).time;
      if ((l1 > 0L) && (l2 > 0L))
      {
        if (l2 - l1 <= this.jdField_a_of_type_Long) {
          break label243;
        }
        j = 0;
      }
    }
    for (;;)
    {
      label122:
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "checkDui hit，i = " + i);
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FA7", "0X8007FA7", 0, 0, "", "", "", "");
        a(paramSessionInfo, (ChatMessage)paramList.get(i));
        if (((ChatMessage)paramList.get(i)).isSend()) {
          break label364;
        }
      }
      label364:
      for (paramInt = i;; paramInt = -1)
      {
        if (i == paramList.size() - 1)
        {
          return paramInt;
          j = 0;
          break label122;
          label243:
          j -= 1;
          break label44;
        }
        j = i + 1;
        i = paramInt;
        paramInt = j;
        for (;;)
        {
          if ((paramInt >= paramList.size()) || (((ChatMessage)paramList.get(paramInt)).time - ((ChatMessage)paramList.get(paramInt - 1)).time > this.jdField_c_of_type_Long)) {
            return i;
          }
          a(paramSessionInfo, (ChatMessage)paramList.get(paramInt));
          if (!((ChatMessage)paramList.get(paramInt)).isSend()) {
            i = paramInt;
          }
          paramInt += 1;
        }
        i -= 1;
        break label27;
        break;
      }
      label369:
      j = 1;
    }
  }
  
  private String a(String paramString)
  {
    try
    {
      str1 = awiz.a(paramString);
      paramString = str1;
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str1;
      paramString = new File(paramString);
      bool = paramString.exists();
      if (!bool) {
        break label77;
      }
      for (;;)
      {
        try
        {
          paramString = bhli.a(paramString);
          if (paramString == null) {
            continue;
          }
        }
        catch (IOException paramString)
        {
          paramString = null;
          continue;
        }
        str2 = paramString;
        if (paramString != null) {
          break;
        }
        return "";
        paramString = "";
      }
    }
    finally
    {
      if (0 != 0) {
        break label75;
      }
      return "";
      label75:
      return null;
    }
    return str1;
    for (;;)
    {
      boolean bool;
      String str2;
      label77:
      paramString = null;
    }
  }
  
  private List<DoutuData> a()
  {
    List localList = null;
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "readDoutuDataFromDB ");
    }
    if (this.jdField_a_of_type_Awbw != null) {
      localList = this.jdField_a_of_type_Awbw.a(DoutuData.class, true, null, null, null, null, null, null);
    }
    return localList;
  }
  
  public static void a(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean) {
      bdiv.d(paramContext, true);
    }
  }
  
  public static void a(RelativeLayout paramRelativeLayout, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "doOnChatPieDestory");
    }
    paramQQAppInterface = (apfp)paramQQAppInterface.getManager(214);
    if (paramQQAppInterface != null)
    {
      if ((paramRelativeLayout != null) && (paramQQAppInterface.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
        paramRelativeLayout.removeView(paramQQAppInterface.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
      paramQQAppInterface.b();
      paramQQAppInterface.jdField_d_of_type_Int = 0;
      paramQQAppInterface.jdField_f_of_type_Int = 0;
      paramQQAppInterface.jdField_d_of_type_JavaUtilList = null;
      paramQQAppInterface.jdField_e_of_type_Int = 0;
    }
  }
  
  private void a(String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    try
    {
      bdcs.a(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DoutuManager", 2, "[unzip]", paramString);
    }
  }
  
  private void a(List<DoutuData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "persistDoutuData ");
    }
    ThreadManager.excute(new DoutuManager.9(this, paramList), 32, null, false);
  }
  
  private void a(List<ChatMessage> paramList, SessionInfo paramSessionInfo)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ChatMessage)((Iterator)localObject).next()).isDui = false;
    }
    localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if (a(localChatMessage)) {
        ((List)localObject).add(localChatMessage);
      }
    }
    if (((List)localObject).size() == 0) {
      return;
    }
    int i;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("handleDui , doutuList: \n");
      i = 0;
      while (i < ((List)localObject).size())
      {
        paramList.append("[Doutu]");
        paramList.append(" index = ");
        paramList.append(i);
        paramList.append(", time = " + ((ChatMessage)((List)localObject).get(i)).time);
        paramList.append(", isSend = " + ((ChatMessage)((List)localObject).get(i)).isSend());
        paramList.append(", shmsgseq = " + ((ChatMessage)((List)localObject).get(i)).shmsgseq);
        paramList.append(" ; \n");
        i += 1;
      }
      QLog.d("DoutuManager", 2, paramList.toString());
    }
    long l2 = a(paramSessionInfo);
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "handleDui ：recordDoutuTime = " + l2);
    }
    int j;
    int k;
    long l1;
    if (l2 > 0L)
    {
      j = -1;
      i = 0;
      k = 0;
      l1 = l2;
      for (;;)
      {
        if (i < ((List)localObject).size())
        {
          if (((ChatMessage)((List)localObject).get(i)).time <= 0L)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("DoutuManager", 2, "doutuList.get(i).time <= 0");
            return;
          }
          if (((ChatMessage)((List)localObject).get(i)).time < l2)
          {
            l1 = ((ChatMessage)((List)localObject).get(i)).time;
            label440:
            k = i;
            i += 1;
          }
          else if (((ChatMessage)((List)localObject).get(i)).time - l1 > this.jdField_c_of_type_Long)
          {
            j = -1;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "handleDui ：lastIndex = " + i);
      }
      if (i < ((List)localObject).size() - 1)
      {
        i = a((List)localObject, paramSessionInfo, i);
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "handleDui : checkResult = " + i);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "handleDui ： duiIndex = " + i);
        }
        if ((i < 0) || (i > ((List)localObject).size() - 1)) {
          break;
        }
        paramList = (ChatMessage)((List)localObject).get(((List)localObject).size() - 1);
        paramSessionInfo = (ChatMessage)((List)localObject).get(i);
        paramSessionInfo.isDui = true;
        if ((paramList.time > 0L) && (NetConnInfoCenter.getServerTime() - paramList.time > this.jdField_c_of_type_Long)) {
          if (QLog.isColorLevel()) {
            QLog.d("DoutuManager", 2, "handleDui ：too long for doutuKeepTime ,set Dui false ! NetConnInfoCenter.getServerTime() = " + NetConnInfoCenter.getServerTime() + ", lastMsg.time = " + paramList.time);
          }
        }
        for (paramSessionInfo.isDui = false;; paramSessionInfo.isDui = false)
        {
          do
          {
            if (paramSessionInfo.isDui)
            {
              if (i != this.jdField_d_of_type_Int)
              {
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008012", "0X8008012", 0, 0, "", "", "", "");
                this.jdField_d_of_type_Int = i;
              }
              if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
                ThreadManager.post(new DoutuManager.7(this), 5, null, true);
              }
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("DoutuManager", 2, "handleDui ： duiMsg.isDui = " + paramSessionInfo.isDui);
            return;
            a(paramSessionInfo, (ChatMessage)((List)localObject).get(i));
            long l3 = ((ChatMessage)((List)localObject).get(i)).time;
            l1 = l3;
            if (((ChatMessage)((List)localObject).get(i)).isSend()) {
              break label440;
            }
            j = i;
            l1 = l3;
            break label440;
          } while ((!paramSessionInfo.isFlowMessage) && (!paramSessionInfo.isSend()));
          if (QLog.isColorLevel()) {
            QLog.d("DoutuManager", 2, "handleDui ： duiMsg.isFlowMessage = " + paramSessionInfo.isFlowMessage + ", duiMsg.isSend() = " + paramSessionInfo.isSend());
          }
        }
        i = j;
      }
      i = k;
      continue;
      j = -1;
      i = 0;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (b(paramMessageRecord)) || (c(paramMessageRecord));
  }
  
  private boolean a(String paramString)
  {
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (!((File)localObject).isDirectory()) {
        ((File)localObject).delete();
      }
    }
    else {
      return false;
    }
    if (bdiv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkLocalResFiles : isDoutuResDamaged !");
      }
      bdcs.a(jdField_a_of_type_JavaLangString, false);
      return false;
    }
    if ((((File)localObject).listFiles() == null) || (((File)localObject).listFiles().length == 0))
    {
      bdcs.a(jdField_a_of_type_JavaLangString, false);
      return false;
    }
    localObject = new File(jdField_a_of_type_JavaLangString + "doutuResInfo");
    if ((((File)localObject).exists()) && (!((File)localObject).isDirectory()))
    {
      try
      {
        localObject = bdcs.b((File)localObject);
        if ((QLog.isColorLevel()) && (paramString != null) && (localObject != null)) {
          QLog.d("DoutuManager", 2, "checkLocalResFiles: md5Record = " + (String)localObject + ", md5 = " + paramString);
        }
        if ((localObject == null) || (paramString == null) || (((String)localObject).length() == 0) || (paramString.length() == 0) || (!paramString.equals(localObject)))
        {
          bdcs.a(jdField_a_of_type_JavaLangString, false);
          return false;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        bdcs.a(jdField_a_of_type_JavaLangString, false);
        return false;
      }
      return true;
    }
    bdcs.a(jdField_a_of_type_JavaLangString, false);
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label43:
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      bool2 = bool1;
    }
    catch (FileNotFoundException paramString1)
    {
      bool2 = false;
      paramString1 = null;
      break label43;
    }
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
  
  private int b(List<ChatMessage> paramList, SessionInfo paramSessionInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "checkCombo ，startIndex = " + paramInt);
    }
    int i = paramInt;
    int j = 0;
    int k = j;
    if (i <= paramList.size() - this.jdField_b_of_type_Int)
    {
      if (paramList.size() - paramInt < this.jdField_b_of_type_Int) {
        k = j;
      }
    }
    else {
      label77:
      return k;
    }
    k = i;
    label84:
    if (k < this.jdField_b_of_type_Int + i - 1)
    {
      long l1 = ((ChatMessage)paramList.get(k)).time;
      long l2 = ((ChatMessage)paramList.get(k + 1)).time;
      if ((l1 > 0L) && (l2 > 0L))
      {
        if (l2 - l1 <= this.jdField_b_of_type_Long) {
          break label360;
        }
        k = 0;
      }
    }
    for (;;)
    {
      label162:
      if (k != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "checkCombo hit ，i = " + i);
        }
        k = 3;
        a(paramSessionInfo, (ChatMessage)paramList.get(this.jdField_b_of_type_Int + i - 1), 3, i);
        if (this.jdField_b_of_type_Int + i == paramList.size()) {
          break label77;
        }
        int m = this.jdField_b_of_type_Int;
        k = 3;
        j = i;
        m += i;
        i = k;
        k = m;
        if (k < paramList.size()) {
          if (((ChatMessage)paramList.get(k)).time - ((ChatMessage)paramList.get(k - 1)).time > this.jdField_d_of_type_Long)
          {
            a(paramSessionInfo);
            j = k - 1;
            i = 0;
          }
        }
      }
      for (;;)
      {
        label273:
        k = i;
        i = j + 1;
        j = k;
        break;
        k = 0;
        break label162;
        label360:
        k += 1;
        break label84;
        i += 1;
        a(paramSessionInfo, (ChatMessage)paramList.get(k), i, j);
        j = k - 1;
        k += 1;
        break label273;
        continue;
        k = i;
        i = j;
        j = k;
      }
      k = 1;
    }
  }
  
  private void b(List<ChatMessage> paramList, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if (a(localChatMessage)) {
        localArrayList.add(localChatMessage);
      }
    }
    if (localArrayList.size() == 0) {}
    int i;
    long l2;
    long l3;
    boolean bool;
    long l1;
    int j;
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("handleCombo , doutuList: \n");
        i = 0;
        while (i < localArrayList.size())
        {
          paramList.append("[Doutu]");
          paramList.append(" index = ");
          paramList.append(i);
          paramList.append(", time = " + ((ChatMessage)localArrayList.get(i)).time);
          paramList.append(", isSend = " + ((ChatMessage)localArrayList.get(i)).isSend());
          paramList.append(", shmsgseq = " + ((ChatMessage)localArrayList.get(i)).shmsgseq);
          paramList.append(" ; \n");
          i += 1;
        }
        QLog.d("DoutuManager", 2, paramList.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "handleCombo, dirty = " + Integer.toHexString(paramInt));
      }
      if (((0xFFFF & paramInt) == 4) || ((0xFFFF & paramInt) == 6) || ((0xFFFF & paramInt) == 7))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "handleCombo, no new msg");
        }
        this.jdField_f_of_type_Int = localArrayList.size();
        this.jdField_d_of_type_JavaUtilList = localArrayList;
        return;
      }
      l2 = b(paramSessionInfo);
      i = a(paramSessionInfo);
      l3 = c(paramSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "handleCombo : recordComboTime = " + l2 + ", recordCombo = " + i + ", recordComboSeq = " + l3);
      }
      bool = false;
      paramInt = 0;
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "handleCombo : lastDoutuListSize = " + this.jdField_f_of_type_Int + ", doutuList.size() = " + localArrayList.size());
      }
      if (l2 <= 0L) {
        break label1964;
      }
      l1 = l2;
      paramInt = 0;
      j = 0;
      if (paramInt >= localArrayList.size()) {
        break label1954;
      }
      if (((ChatMessage)localArrayList.get(paramInt)).time > 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoutuManager", 2, "handleCombo : doutuList.get(i).time <= 0");
    return;
    if ((this.jdField_f_of_type_Int != 0) && (localArrayList.size() == this.jdField_f_of_type_Int)) {
      if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0))
      {
        l1 = ((ChatMessage)localArrayList.get(0)).shmsgseq;
        paramInt = 0;
        j = 0;
        while ((j < this.jdField_d_of_type_JavaUtilList.size()) && (((ChatMessage)this.jdField_d_of_type_JavaUtilList.get(j)).shmsgseq < l1))
        {
          paramInt += 1;
          j += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "handleCombo : offset = " + paramInt);
        }
        if ((paramInt > 0) && (localArrayList.size() - 1 - paramInt >= 0))
        {
          l1 = ((ChatMessage)localArrayList.get(localArrayList.size() - 1 - paramInt)).time;
          if (((ChatMessage)localArrayList.get(localArrayList.size() - 1)).time - l1 < this.jdField_d_of_type_Long)
          {
            j = localArrayList.size() - 1;
            i += paramInt;
            a(paramSessionInfo, (ChatMessage)localArrayList.get(j), i, j);
            bool = true;
            paramInt = j;
            label844:
            if (QLog.isColorLevel()) {
              QLog.d("DoutuManager", 2, "handleCombo(recordComboTime > 0) : combo = " + i);
            }
          }
        }
      }
    }
    label1954:
    label1964:
    for (;;)
    {
      if (paramInt < localArrayList.size() - 1)
      {
        paramInt = b(localArrayList, paramSessionInfo, paramInt);
        i = paramInt;
        if (QLog.isColorLevel())
        {
          QLog.d("DoutuManager", 2, "handleCombo : checkCombo = " + paramInt);
          i = paramInt;
        }
      }
      paramList = (ChatMessage)localArrayList.get(localArrayList.size() - 1);
      if ((paramList.time > 0L) && (NetConnInfoCenter.getServerTime() - paramList.time > this.jdField_d_of_type_Long))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "handleCombo ：too long for comboKeepTime ,set combo = 0 ! NetConnInfoCenter.getServerTime() = " + NetConnInfoCenter.getServerTime() + ", lastMsg.time = " + paramList.time);
        }
        a(paramSessionInfo);
      }
      for (paramInt = 0;; paramInt = i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "handleCombo ： combo = " + paramInt);
        }
        if ((this.jdField_f_of_type_Int != 0) && (localArrayList.size() > this.jdField_f_of_type_Int)) {
          bool = true;
        }
        for (;;)
        {
          if (paramInt > 0)
          {
            if (!DuiButtonImageView.jdField_a_of_type_Boolean) {
              ThreadManager.post(new DoutuManager.8(this), 5, null, true);
            }
            if (localArrayList.size() - 1 != this.jdField_e_of_type_Int)
            {
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008095", "0X8008095", 0, 0, "", "", "", "");
              this.jdField_e_of_type_Int = (localArrayList.size() - 1);
              if (paramInt == 3) {
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008094", "0X8008094", 0, 0, "", "", "", "");
              }
            }
          }
          if ((paramBaseChatPie != null) && (paramBaseChatPie.a != null))
          {
            l1 = this.jdField_d_of_type_Long - (NetConnInfoCenter.getServerTime() - paramList.time) + 1L;
            if (QLog.isColorLevel()) {
              QLog.d("DoutuManager", 2, "handleCombo ：delayTime = " + l1 + ", NetConnInfoCenter.getServerTime() = " + NetConnInfoCenter.getServerTime() + ", lastMsg.time = " + paramList.time);
            }
            if (paramInt == 0) {
              paramBaseChatPie.a.a(0L);
            }
          }
          for (;;)
          {
            this.jdField_f_of_type_Int = localArrayList.size();
            this.jdField_d_of_type_JavaUtilList = localArrayList;
            return;
            paramInt = localArrayList.size() - 1;
            i = 0;
            a(paramSessionInfo);
            bool = false;
            break label844;
            paramInt = localArrayList.size() - 1;
            a(paramSessionInfo, (ChatMessage)localArrayList.get(paramInt), i, paramInt);
            bool = false;
            break label844;
            if ((this.jdField_f_of_type_Int != 0) && (localArrayList.size() > this.jdField_f_of_type_Int))
            {
              l1 = ((ChatMessage)localArrayList.get(this.jdField_f_of_type_Int - 1)).time;
              if (((ChatMessage)localArrayList.get(localArrayList.size() - 1)).time - l1 < this.jdField_d_of_type_Long)
              {
                paramInt = localArrayList.size() - 1;
                i += localArrayList.size() - this.jdField_f_of_type_Int;
                a(paramSessionInfo, (ChatMessage)localArrayList.get(paramInt), i, paramInt);
                bool = false;
                break label844;
              }
              paramInt = localArrayList.size() - 1;
              i = 0;
              a(paramSessionInfo);
              bool = false;
              break label844;
            }
            if (((ChatMessage)localArrayList.get(paramInt)).time < l2) {
              l1 = ((ChatMessage)localArrayList.get(paramInt)).time;
            }
            for (;;)
            {
              j = paramInt;
              paramInt += 1;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("DoutuManager", 2, "handleCombo : recordComboSeq = " + l3 + ", i = " + paramInt + ", doutuList.get(i).shmsgseq = " + ((ChatMessage)localArrayList.get(paramInt)).shmsgseq);
              }
              if ((((ChatMessage)localArrayList.get(paramInt)).time == l2) && (l3 != 0L) && (((ChatMessage)localArrayList.get(paramInt)).shmsgseq != 0L) && (((ChatMessage)localArrayList.get(paramInt)).shmsgseq <= l3))
              {
                l1 = ((ChatMessage)localArrayList.get(paramInt)).time;
              }
              else
              {
                if (((ChatMessage)localArrayList.get(paramInt)).time - l1 > this.jdField_d_of_type_Long)
                {
                  a(paramSessionInfo);
                  i = 0;
                  bool = false;
                  break label844;
                }
                i += 1;
                a(paramSessionInfo, (ChatMessage)localArrayList.get(paramInt), i, paramInt);
                l1 = ((ChatMessage)localArrayList.get(paramInt)).time;
              }
            }
            paramBaseChatPie.a.b();
            paramList = new apga(paramList.senderuin, paramInt - 2, bool);
            paramBaseChatPie.a.a(paramList);
            paramBaseChatPie.a.a(l1 * 1000L);
            continue;
            if (paramBaseChatPie == null)
            {
              if (QLog.isColorLevel()) {
                QLog.e("DoutuManager", 2, "handleCombo:  chatPie is null");
              }
            }
            else if ((paramBaseChatPie.a == null) && (QLog.isColorLevel())) {
              QLog.e("DoutuManager", 2, "handleCombo:  chatPie.mComboUIManager is null");
            }
          }
        }
      }
      paramInt = j;
      bool = false;
      break label844;
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      PicMessageExtraData localPicMessageExtraData;
      do
      {
        return false;
        if ((paramMessageRecord instanceof MessageForMarketFace)) {
          return true;
        }
        if (!(paramMessageRecord instanceof MessageForPic)) {
          break;
        }
        paramMessageRecord = (MessageForPic)paramMessageRecord;
        localPicMessageExtraData = paramMessageRecord.picExtraData;
        if ((paramMessageRecord.imageType == 2000) || (paramMessageRecord.imageType == 3) || (paramMessageRecord.imageType == 4)) {
          return true;
        }
      } while ((localPicMessageExtraData == null) || ((localPicMessageExtraData.imageBizType != 1) && (localPicMessageExtraData.imageBizType != 3) && (!localPicMessageExtraData.isHotPics())));
      return true;
    } while ((!(paramMessageRecord instanceof MessageForStructing)) || (!((MessageForStructing)paramMessageRecord).isHotPicsStruct()));
    return true;
  }
  
  private static boolean c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if ((paramMessageRecord.size > 0L) && (paramMessageRecord.size < jdField_e_of_type_Long) && (paramMessageRecord.width > 0L) && (paramMessageRecord.width < jdField_f_of_type_Long) && (paramMessageRecord.height > 0L) && (paramMessageRecord.height < jdField_f_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean e()
  {
    if (!this.jdField_g_of_type_Boolean) {
      f();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "isComboOpen : " + this.jdField_d_of_type_Boolean + "isDoutuSettingOpen : " + this.jdField_f_of_type_Boolean);
    }
    return (this.jdField_d_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean);
  }
  
  private void f()
  {
    this.jdField_f_of_type_Boolean = bdiv.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_c_of_type_Boolean = bdiv.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_d_of_type_Boolean = bdiv.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_b_of_type_Boolean = bdiv.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    long l1 = bdiv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int i = bdiv.ap(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    long l2 = bdiv.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    long l3 = bdiv.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int j = bdiv.am(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (l1 > 0L) {
      this.jdField_a_of_type_Long = l1;
    }
    if (i > 0) {
      this.jdField_b_of_type_Int = i;
    }
    if (l2 > 0L) {
      this.jdField_b_of_type_Long = l2;
    }
    if (l3 > 0L) {
      this.jdField_d_of_type_Long = l3;
    }
    if (j > 0) {
      this.jdField_a_of_type_Int = j;
    }
    this.jdField_g_of_type_Boolean = true;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "preLoad, isDoutuOpen() = " + c() + ", doutuListPreload.size() = " + this.jdField_b_of_type_JavaUtilList.size());
    }
    if ((c()) && (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
      d();
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "dropPersistDoutuData ");
    }
    ThreadManager.excute(new DoutuManager.10(this), 32, null, false);
  }
  
  public int a(SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramSessionInfo = String.valueOf(paramSessionInfo.jdField_a_of_type_Int);
    if ((str == null) || (str.length() == 0) || (paramSessionInfo == null) || (paramSessionInfo.length() == 0)) {
      return 0;
    }
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) && (((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).get(paramSessionInfo) != null)) {
      return ((apft)((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).get(paramSessionInfo)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public long a(SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramSessionInfo = String.valueOf(paramSessionInfo.jdField_a_of_type_Int);
    if ((str == null) || (str.length() == 0) || (paramSessionInfo == null) || (paramSessionInfo.length() == 0)) {
      return 0L;
    }
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) && (((ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).get(paramSessionInfo) != null)) {
      return ((apfu)((ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).get(paramSessionInfo)).jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "initData ");
      }
      Object localObject1 = a();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.jdField_b_of_type_JavaUtilList.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          DoutuData localDoutuData = (DoutuData)((Iterator)localObject1).next();
          this.jdField_b_of_type_JavaUtilList.add(localDoutuData);
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) != null)
    {
      localObject = (apfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      ((apfo)localObject).jdField_a_of_type_Int += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("handleGetRecommendPicTimeOut key:").append(paramLong).append(", smartCount:");
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) == null) {
        break label203;
      }
    }
    label203:
    for (int i = ((apfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Int;; i = 0)
    {
      QLog.i("DoutuManager", 2, i);
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) != null) && (((apfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Int >= 1))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
        if ((this.jdField_a_of_type_Apfk != null) && (this.jdField_a_of_type_Apfk.jdField_a_of_type_Long == paramLong)) {
          ThreadManager.getUIHandler().post(new DoutuManager.6(this, paramLong));
        }
      }
      return;
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler, apfo paramapfo)
  {
    if (paramViewGroup == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : parentView is null.");
      }
      return;
    }
    finally {}
    Object localObject = (LinearLayout)paramViewGroup.findViewById(2131365411);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : doutuLayout != null.");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject);
      paramViewGroup = (DoutuEmotionHorizonListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365414);
      this.jdField_a_of_type_Apfk = ((apfk)paramViewGroup.getAdapter());
      if (this.jdField_a_of_type_Apfk == null)
      {
        this.jdField_a_of_type_Apfk = new apfk(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseActivity, paramSessionInfo, paramMqqHandler, this.jdField_b_of_type_Boolean, paramapfo, this.jdField_a_of_type_Int);
        paramViewGroup.setAdapter(this.jdField_a_of_type_Apfk);
      }
      c();
    }
    for (;;)
    {
      if ((this.jdField_g_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_g_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_g_of_type_Long >= 1000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : not frequency click.");
        }
        this.jdField_a_of_type_Apfk = new apfk(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseActivity, paramSessionInfo, paramMqqHandler, this.jdField_b_of_type_Boolean, paramapfo, this.jdField_a_of_type_Int);
        paramViewGroup.setAdapter(this.jdField_a_of_type_Apfk);
        if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
          break label818;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : doutuListPreload.size() > 0.");
        }
        this.jdField_c_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.clear();
        paramContext = this.jdField_b_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (paramContext.hasNext())
          {
            paramBaseActivity = (DoutuData)paramContext.next();
            if (this.jdField_c_of_type_JavaUtilList.size() < 20)
            {
              this.jdField_c_of_type_JavaUtilList.add(paramBaseActivity);
              if (!TextUtils.isEmpty(paramBaseActivity.pic_md5))
              {
                this.jdField_a_of_type_JavaUtilList.add(paramBaseActivity.pic_md5);
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : doutuLayout == null.");
                }
                this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(paramContext, 2131558568, null));
                localObject = (DoutuEmotionHorizonListView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365414);
                this.jdField_a_of_type_Apfk = new apfk(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseActivity, paramSessionInfo, paramMqqHandler, this.jdField_b_of_type_Boolean, paramapfo, this.jdField_a_of_type_Int);
                ((DoutuEmotionHorizonListView)localObject).setAdapter(this.jdField_a_of_type_Apfk);
                ((DoutuEmotionHorizonListView)localObject).setOnScrollStateChangedListener(new apfq(this));
                ((DoutuEmotionHorizonListView)localObject).setTouchListener(new apfs(this, paramMqqHandler));
                RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                localLayoutParams.addRule(2, 2131368333);
                localLayoutParams.addRule(11);
                paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
                paramViewGroup = (ViewGroup)localObject;
                break;
              }
            }
          }
        }
        if (this.jdField_a_of_type_Apfk != null)
        {
          this.jdField_a_of_type_Apfk.jdField_b_of_type_JavaUtilList = new ArrayList();
          this.jdField_a_of_type_Apfk.jdField_b_of_type_JavaUtilList.addAll(this.jdField_c_of_type_JavaUtilList);
        }
        this.jdField_b_of_type_JavaUtilList.clear();
        h();
        label568:
        if (this.jdField_a_of_type_Apfk != null)
        {
          this.jdField_a_of_type_Apfk.a();
          this.jdField_a_of_type_Apfk.notifyDataSetChanged();
        }
        this.jdField_g_of_type_Long = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramBaseActivity = new StringBuilder().append("showDoutuEmotionLayout isSmartSwitchNew:").append(this.jdField_b_of_type_Boolean).append(", defaultCount:").append(this.jdField_a_of_type_Int).append(", ");
          if (paramapfo == null) {
            break label856;
          }
        }
      }
    }
    label818:
    label856:
    for (paramContext = paramapfo.toString();; paramContext = "")
    {
      QLog.d("DoutuManager", 2, paramContext);
      if ((paramapfo != null) && (paramapfo.a()) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Apfk != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(this.jdField_a_of_type_Apfk.jdField_a_of_type_Long), new apfo(this.jdField_a_of_type_Apfk.jdField_a_of_type_Long, 0));
        a(paramapfo, paramSessionInfo, this.jdField_a_of_type_Apfk.jdField_a_of_type_Long);
      }
      if (Build.VERSION.SDK_INT >= 14) {
        paramViewGroup.setScrollX(0);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FA9", "0X8007FA9", 0, 0, "", "", "", "");
      if (paramMqqHandler == null) {
        break;
      }
      paramMqqHandler.removeMessages(80);
      paramMqqHandler.sendEmptyMessageDelayed(80, 5000L);
      break;
      if (this.jdField_c_of_type_Int != 0) {
        break label568;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "showDoutuEmotionLayout : status == STATUS_GETTING_DOUTU_IDEL.");
      }
      this.jdField_c_of_type_JavaUtilList.clear();
      d();
      break label568;
    }
  }
  
  public void a(apfo paramapfo, SessionInfo paramSessionInfo, long paramLong)
  {
    ThreadManager.post(new DoutuManager.4(this, paramapfo, paramLong, paramSessionInfo), 5, null, true);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramSessionInfo = String.valueOf(paramSessionInfo.jdField_a_of_type_Int);
    if ((str == null) || (str.length() == 0) || (paramSessionInfo == null) || (paramSessionInfo.length() == 0)) {}
    while (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) == null) {
      return;
    }
    ((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).remove(paramSessionInfo);
  }
  
  public void a(SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramChatMessage.time;
      l2 = paramChatMessage.shmsgseq;
      paramChatMessage = paramSessionInfo.jdField_a_of_type_JavaLangString;
      paramSessionInfo = String.valueOf(paramSessionInfo.jdField_a_of_type_Int);
    } while ((paramChatMessage == null) || (paramChatMessage.length() == 0) || (paramSessionInfo == null) || (paramSessionInfo.length() == 0));
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramChatMessage) != null)
    {
      ((ConcurrentHashMap)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramChatMessage)).put(paramSessionInfo, new apfu(this, l1, l2));
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.put(paramSessionInfo, new apfu(this, l1, l2));
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramChatMessage, localConcurrentHashMap);
  }
  
  public void a(SessionInfo paramSessionInfo, ChatMessage paramChatMessage, int paramInt1, int paramInt2)
  {
    long l1 = paramChatMessage.time;
    long l2 = paramChatMessage.shmsgseq;
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramSessionInfo = String.valueOf(paramSessionInfo.jdField_a_of_type_Int);
    if ((str == null) || (str.length() == 0) || (paramSessionInfo == null) || (paramSessionInfo.length() == 0)) {
      return;
    }
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null)
    {
      ((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).put(paramSessionInfo, new apft(this, l1, l2, paramChatMessage.senderuin, paramInt1, paramInt2));
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.put(paramSessionInfo, new apft(this, l1, l2, paramChatMessage.senderuin, paramInt1, paramInt2));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localConcurrentHashMap);
  }
  
  public void a(List<ChatMessage> paramList, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramSessionInfo == null)) {
      break label17;
    }
    label17:
    while (bdal.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (c()) {
      a(paramList, paramSessionInfo);
    }
    while (e())
    {
      b(paramList, paramSessionInfo, paramBaseChatPie, paramInt);
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((ChatMessage)localIterator.next()).isDui = false;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    bdiv.h(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramBoolean);
    if (paramBoolean) {
      DuiButtonImageView.a();
    }
  }
  
  public void a(boolean paramBoolean, List<DoutuData> paramList)
  {
    DoutuData localDoutuData;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "handleGetDoutuList : isSuccess = " + paramBoolean);
      }
      if ((!paramBoolean) || (paramList == null) || (paramList.size() <= 0)) {
        break label497;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "handleGetDoutuList : dataList.size() = " + paramList.size());
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localDoutuData = (DoutuData)paramList.next();
        this.jdField_b_of_type_JavaUtilList.add(localDoutuData);
      }
      a(this.jdField_b_of_type_JavaUtilList);
    }
    finally {}
    if ((this.jdField_a_of_type_Apfk != null) && (this.jdField_c_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "add data to doutuListShowing");
      }
      paramList = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramList.hasNext())
      {
        localDoutuData = (DoutuData)paramList.next();
        if (this.jdField_c_of_type_JavaUtilList.size() < 20)
        {
          this.jdField_c_of_type_JavaUtilList.add(localDoutuData);
          if (!TextUtils.isEmpty(localDoutuData.pic_md5)) {
            this.jdField_a_of_type_JavaUtilList.add(localDoutuData.pic_md5);
          }
        }
      }
      this.jdField_a_of_type_Apfk.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_Apfk.jdField_b_of_type_JavaUtilList.addAll(this.jdField_c_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList.clear();
      h();
      this.jdField_a_of_type_Apfk.a();
      if (this.jdField_a_of_type_Apfk.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_Apfk.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(81);
      }
    }
    int i;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if ((i < 9) && (i < this.jdField_b_of_type_JavaUtilList.size()))
      {
        localDoutuData = (DoutuData)this.jdField_b_of_type_JavaUtilList.get(i);
        if (localDoutuData == null) {}
      }
      else
      {
        label497:
        label505:
        for (;;)
        {
          try
          {
            paramList = localDoutuData.thumb_down_url;
            if (!paramList.startsWith("https")) {
              break label505;
            }
            paramList = paramList.replaceFirst("https", "http");
            paramList = new URL(paramList);
          }
          catch (MalformedURLException paramList)
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions;
            QLog.e("DoutuManager", 1, "getView url exception e = " + paramList.getMessage());
            paramList = null;
            continue;
          }
          if (paramList == null) {
            break;
          }
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mExtraInfo = localDoutuData;
          URLDrawable.getDrawable(paramList, localURLDrawableOptions).startDownload();
          break;
          this.jdField_c_of_type_Int = 0;
          return;
        }
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, List<DoutuData> paramList, long paramLong)
  {
    boolean bool = true;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) != null)
    {
      localObject = (apfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      ((apfo)localObject).jdField_a_of_type_Int += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("handleGetRecommendPicList isSuccess:").append(paramBoolean).append(", key:").append(paramLong).append(", type:, responseCount:");
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) == null) {
        break label268;
      }
      i = ((apfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Int;
      localObject = ((StringBuilder)localObject).append(i).append(", size:");
      if (paramList != null) {
        break label274;
      }
    }
    DoutuData localDoutuData;
    label268:
    label274:
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("DoutuManager", 2, i);
      localObject = new ArrayList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label285;
      }
      i = 0;
      while (i < paramList.size())
      {
        localDoutuData = (DoutuData)paramList.get(i);
        if ((!TextUtils.isEmpty(localDoutuData.pic_md5)) && (!this.jdField_a_of_type_JavaUtilList.contains(localDoutuData.pic_md5)))
        {
          ((List)localObject).add(localDoutuData);
          this.jdField_a_of_type_JavaUtilList.add(localDoutuData.pic_md5);
        }
        i += 1;
      }
      i = 0;
      break;
    }
    label285:
    if (((List)localObject).size() >= 0)
    {
      i = 0;
      if (i < ((List)localObject).size())
      {
        localDoutuData = (DoutuData)((List)localObject).get(i);
        if (localDoutuData == null) {}
      }
    }
    label533:
    for (;;)
    {
      try
      {
        paramList = localDoutuData.thumb_down_url;
        if (!paramList.startsWith("https")) {
          break label533;
        }
        paramList = paramList.replaceFirst("https", "http");
        paramList = new URL(paramList);
      }
      catch (MalformedURLException paramList)
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        QLog.e("DoutuManager", 1, "getView url exception e = " + paramList.getMessage());
        paramList = null;
        continue;
      }
      if (paramList != null)
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = localDoutuData;
        URLDrawable.getDrawable(paramList, localURLDrawableOptions).startDownload();
      }
      i += 1;
      break;
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong)) != null) && (((apfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_Int >= 1)) {}
      for (;;)
      {
        if ((this.jdField_a_of_type_Apfk != null) && (this.jdField_a_of_type_Apfk.jdField_a_of_type_Long == paramLong)) {
          ThreadManager.getUIHandler().post(new DoutuManager.5(this, paramBoolean, (List)localObject, bool, paramLong));
        }
        if (bool) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
        }
        return;
        bool = false;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean3, int paramInt)
  {
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Boolean = paramBoolean3;
    if (paramLong1 > 0L) {
      this.jdField_a_of_type_Long = paramLong1;
    }
    if (paramLong2 > 0L) {
      this.jdField_b_of_type_Long = paramLong2;
    }
    if (paramLong3 > 0L) {
      this.jdField_d_of_type_Long = paramLong3;
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_g_of_type_Boolean) {
      f();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "isDoutuConfigOpen : " + this.jdField_c_of_type_Boolean + ", isComboOpen : " + this.jdField_d_of_type_Boolean);
    }
    return (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean);
  }
  
  public long b(SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramSessionInfo = String.valueOf(paramSessionInfo.jdField_a_of_type_Int);
    if ((str == null) || (str.length() == 0) || (paramSessionInfo == null) || (paramSessionInfo.length() == 0)) {
      return 0L;
    }
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) && (((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).get(paramSessionInfo) != null)) {
      return ((apft)((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).get(paramSessionInfo)).jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "hideDoutuEmotionLayout.");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      c();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_Apfk = null;
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      g();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "doOnLogin, isFirstLogin = " + paramBoolean);
    }
    a();
    if ((bdee.a(BaseApplication.getContext())) && (!paramBoolean)) {
      e();
    }
  }
  
  public boolean b()
  {
    if (!this.jdField_g_of_type_Boolean) {
      f();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "isDoutuSettingOpen : " + this.jdField_f_of_type_Boolean);
    }
    return this.jdField_f_of_type_Boolean;
  }
  
  public long c(SessionInfo paramSessionInfo)
  {
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramSessionInfo = String.valueOf(paramSessionInfo.jdField_a_of_type_Int);
    if ((str == null) || (str.length() == 0) || (paramSessionInfo == null) || (paramSessionInfo.length() == 0)) {
      return 0L;
    }
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) && (((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).get(paramSessionInfo) != null)) {
      return ((apft)((ConcurrentHashMap)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).get(paramSessionInfo)).jdField_b_of_type_Long;
    }
    return 0L;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Apfk == null) {}
    while ((this.jdField_a_of_type_Apfk.jdField_a_of_type_JavaUtilHashMap == null) && (this.jdField_a_of_type_Apfk.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData == null)) {
      return;
    }
    Object localObject1 = new apfv();
    ((apfv)localObject1).jdField_a_of_type_JavaLangString = "dc03631";
    localObject1.getClass();
    Object localObject2 = new apfw((apfv)localObject1);
    ((apfw)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
    if (this.jdField_a_of_type_Apfk.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData != null)
    {
      ((apfw)localObject2).d = this.jdField_a_of_type_Apfk.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_md5;
      ((apfw)localObject2).e = this.jdField_a_of_type_Apfk.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_down_url;
    }
    if (this.jdField_a_of_type_Apfk.jdField_a_of_type_Apfo != null)
    {
      ((apfw)localObject2).c = this.jdField_a_of_type_Apfk.jdField_a_of_type_Apfo.c;
      ((apfw)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Apfk.jdField_a_of_type_Apfo.jdField_b_of_type_JavaLangString;
    }
    if ((this.jdField_a_of_type_Apfk.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_Apfk.jdField_a_of_type_JavaUtilHashMap.size() > 0))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_Apfk.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList1.add(str);
        localArrayList2.add(this.jdField_a_of_type_Apfk.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
      ((apfw)localObject2).jdField_a_of_type_JavaUtilArrayList = localArrayList1;
      ((apfw)localObject2).jdField_b_of_type_JavaUtilArrayList = localArrayList2;
    }
    int i;
    if (this.jdField_a_of_type_Apfk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      i = this.jdField_a_of_type_Apfk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (i != 0) {
        break label401;
      }
      ((apfw)localObject2).f = "c2c";
    }
    for (;;)
    {
      ((apfw)localObject2).h = this.jdField_a_of_type_Apfk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      ((apfw)localObject2).g = "android";
      ((apfv)localObject1).jdField_a_of_type_Apfw = ((apfw)localObject2);
      localObject1 = ((apfv)localObject1).a();
      localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), apfx.class);
      ((NewIntent)localObject2).putExtra("KEY_CMD", 5);
      ((NewIntent)localObject2).putExtra("key_report_content", ((JSONObject)localObject1).toString());
      this.jdField_a_of_type_Apfk.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData = null;
      this.jdField_a_of_type_Apfk.jdField_a_of_type_JavaUtilHashMap = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
      return;
      label401:
      if (i == 1) {
        ((apfw)localObject2).f = "group";
      } else if (i == 3000) {
        ((apfw)localObject2).f = "discuss";
      } else {
        ((apfw)localObject2).f = "other";
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    if (!this.jdField_g_of_type_Boolean) {
      f();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoutuManager", 2, "isDoutuOpen : " + this.jdField_c_of_type_Boolean + "isDoutuSettingOpen : " + this.jdField_f_of_type_Boolean + ", duiDuration : " + this.jdField_a_of_type_Long + ", duiTimes :" + this.jdField_b_of_type_Int);
    }
    return (this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean);
  }
  
  public void d()
  {
    ThreadManager.post(new DoutuManager.3(this), 5, null, true);
  }
  
  public boolean d()
  {
    return a(bdiv.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
  }
  
  public void e()
  {
    if (jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : isLoadingRes = true");
      }
      return;
    }
    jdField_a_of_type_Boolean = true;
    if ((!c()) && (!e()))
    {
      jdField_a_of_type_Boolean = false;
      return;
    }
    String str1 = bdiv.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str2 = bdiv.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((QLog.isColorLevel()) && (str1 != null) && (str2 != null)) {
      QLog.d("DoutuManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + str2);
    }
    if ((str1 == null) || (str1.length() == 0) || (str2 == null) || (str2.length() == 0))
    {
      jdField_a_of_type_Boolean = false;
      return;
    }
    if (!a(str1))
    {
      String str3 = jdField_a_of_type_JavaLangString + "DoutuRes.zip";
      bdvv localbdvv = new bdvv(str2, new File(str3));
      localbdvv.n = true;
      bdwa localbdwa = ((bdvx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "checkAndDownloadRes : [download] startDownload: " + str2 + " path=" + str3);
      }
      localbdwa.a(localbdvv, new apfr(this, str2, str3, str1), null);
      return;
    }
    DuiButtonImageView.a();
    jdField_a_of_type_Boolean = false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_Apfk = null;
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      }
    }
    catch (Exception localException)
    {
      label40:
      break label40;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_MqqOsMqqHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfp
 * JD-Core Version:    0.7.0.1
 */