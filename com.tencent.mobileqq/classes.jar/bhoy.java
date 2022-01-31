import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.InflaterInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class bhoy
  extends alko
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private HashMap<String, bhoz> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bhoy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static Long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(14, 1);
    return Long.valueOf(new Timestamp(localCalendar.getTimeInMillis()).getTime());
  }
  
  private HashMap<String, bhoz> a()
  {
    int i = 0;
    for (;;)
    {
      HashMap localHashMap2;
      try
      {
        if (this.b) {
          break label414;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NCtr", 2, "[init]");
        }
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("config_prefile", 0);
        this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("config_should_limit_" + this.app.getAccount(), false);
        Object localObject2 = localSharedPreferences.getString("extra_limit_uins_" + this.app.getAccount(), "");
        if (QLog.isColorLevel()) {
          QLog.d("NCtr", 2, "LimitUins:[" + ((String)localObject2).toString() + "]");
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label409;
        }
        localObject2 = ((String)localObject2).split(",");
        localHashMap2 = new HashMap();
        int j = localObject2.length;
        if (i < j)
        {
          Object localObject3 = localObject2[i];
          Object localObject4 = localSharedPreferences.getString("extra_limit_entry_" + this.mApp.getAccount() + "_" + (String)localObject3, "");
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject3 = ((String)localObject4).split(",");
            localObject4 = new bhoz(this, localObject3[0], Integer.valueOf(localObject3[1]).intValue(), Integer.valueOf(localObject3[2]).intValue(), Long.valueOf(localObject3[3]).longValue(), Integer.valueOf(localObject3[4]).intValue());
            localHashMap2.put(localObject3[0], localObject4);
            if (QLog.isColorLevel()) {
              QLog.d("NCtr", 2, "LimitEntry:[" + ((bhoz)localObject4).toString() + "]");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("NCtr", 2, "LimitEntry is null [" + (String)localObject3 + "]");
          }
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap2;
      label409:
      this.b = true;
      label414:
      HashMap localHashMap1 = this.jdField_a_of_type_JavaUtilHashMap;
      return localHashMap1;
      i += 1;
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
    {
      bhoz localbhoz = (bhoz)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      paramContext = paramContext.getSharedPreferences("config_prefile", 0).edit();
      paramContext.putString("extra_limit_entry_" + this.mApp.getAccount() + "_" + paramString, localbhoz.toString());
      paramContext.apply();
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NCtr", 2, "[updateLimitEntrySP]" + paramString + " " + bool);
      }
      return;
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("config_prefile", 0).getInt("config_appid_" + paramString, 0);
  }
  
  public void a(String paramString)
  {
    int i = 0;
    Object localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("config_prefile", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("extra_limit_uins_" + paramString, "");
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).remove("config_version_" + paramString);
    ((SharedPreferences.Editor)localObject1).remove("config_appid_" + paramString);
    ((SharedPreferences.Editor)localObject1).remove("config_should_limit_" + paramString);
    ((SharedPreferences.Editor)localObject1).remove("extra_limit_uins__" + paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split(",");
      int j = localObject2.length;
      while (i < j)
      {
        String str = localObject2[i];
        ((SharedPreferences.Editor)localObject1).remove("extra_limit_entry_" + paramString + "_" + str);
        i += 1;
      }
    }
    ((SharedPreferences.Editor)localObject1).apply();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = paramString;
    localMessage.what = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    for (;;)
    {
      long l;
      try
      {
        if (!QLog.isColorLevel()) {
          break label523;
        }
        QLog.d("NCtr", 2, "shouldNotify uin " + paramString + " type " + paramInt);
      }
      finally {}
      Object localObject = a();
      boolean bool2 = bool3;
      if (this.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (localObject != null)
        {
          bool2 = bool3;
          if (((HashMap)localObject).containsKey(paramString))
          {
            l = a().longValue();
            localObject = (bhoz)((HashMap)localObject).get(paramString);
            if (QLog.isColorLevel()) {
              QLog.d("NCtr", 2, "todayBeginTime = " + new Date(l) + "----" + l + " ，entry.mBaseLineTime = " + new Date(((bhoz)localObject).jdField_a_of_type_Long) + "----" + ((bhoz)localObject).jdField_a_of_type_Long);
            }
            if (((bhoz)localObject).jdField_a_of_type_Long >= 1L) {
              continue;
            }
            if (((bhoz)localObject).b <= 0) {
              continue;
            }
            ((bhoz)localObject).jdField_a_of_type_Long = l;
            ((bhoz)localObject).c += 1;
            paramInt = 1;
            bool2 = bool1;
            if (paramInt != 0)
            {
              localObject = Message.obtain();
              ((Message)localObject).what = 1;
              ((Message)localObject).obj = paramString;
              this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
              bool2 = bool1;
            }
          }
        }
      }
      if (!bool2) {
        azmj.b(this.app, "dc00898", "", paramString, "0X8009995", "0X8009995", 0, 0, "" + System.currentTimeMillis(), "", "", "");
      }
      azmj.b(this.app, "dc00898", "", paramString, "0X8009996", "0X8009996", 0, 0, "" + System.currentTimeMillis(), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("NCtr", 2, "uin " + paramString + " shouldNotify is " + bool2);
      }
      label416:
      return bool2;
      paramInt = 0;
      bool1 = false;
      continue;
      if ((int)((l - ((bhoz)localObject).jdField_a_of_type_Long) / 86400000L) >= ((bhoz)localObject).jdField_a_of_type_Int)
      {
        ((bhoz)localObject).jdField_a_of_type_Long = l;
        ((bhoz)localObject).c = 0;
        paramInt = 1;
        if ((((bhoz)localObject).b > 0) && (((bhoz)localObject).c < ((bhoz)localObject).b))
        {
          ((bhoz)localObject).c += 1;
          paramInt = 1;
        }
        else
        {
          bool1 = false;
        }
      }
      else
      {
        paramInt = 0;
        continue;
        label523:
        do
        {
          bool2 = true;
          break label416;
          if ((paramInt == 7200) || (paramInt == 1008)) {
            break;
          }
        } while (paramInt != 7220);
      }
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NCtr", 1, "inflateConfigString fail", paramArrayOfByte);
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  public int b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("config_prefile", 0).getInt("config_version_" + paramString, 0);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1;
    HashMap localHashMap;
    Object localObject2;
    int m;
    boolean bool;
    int j;
    int k;
    int i;
    Object localObject3;
    label156:
    String str;
    for (;;)
    {
      try
      {
        localObject1 = a();
        if (localObject1 != null)
        {
          localObject1 = (HashMap)((HashMap)localObject1).clone();
          localHashMap = new HashMap();
          if (QLog.isColorLevel()) {
            QLog.i("NCtr", 1, "sourceString : " + paramString);
          }
          localObject2 = XmlPullParserFactory.newInstance().newPullParser();
          ((XmlPullParser)localObject2).setInput(new StringReader(paramString));
          m = ((XmlPullParser)localObject2).getEventType();
          bool = false;
          paramString = "";
          j = 0;
          k = 0;
          i = 50;
          if (m == 1) {
            break label915;
          }
          localObject3 = ((XmlPullParser)localObject2).getName();
        }
        switch (m)
        {
        case 0: 
          this.jdField_a_of_type_Boolean = bool;
          localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("config_prefile", 0).edit();
          localObject3 = this.mApp.getAccount();
          ((SharedPreferences.Editor)localObject2).putInt("config_version_" + (String)localObject3, paramInt1);
          ((SharedPreferences.Editor)localObject2).putInt("config_appid_" + (String)localObject3, paramInt2);
          ((SharedPreferences.Editor)localObject2).apply();
          ((SharedPreferences.Editor)localObject2).putBoolean("config_should_limit_" + (String)localObject3, bool);
          if ((localObject1 == null) || (((HashMap)localObject1).size() <= 0)) {
            break label648;
          }
          localObject1 = ((HashMap)localObject1).keySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label648;
          }
          str = (String)((Iterator)localObject1).next();
          ((SharedPreferences.Editor)localObject2).remove("extra_limit_entry_" + (String)localObject3 + "_" + paramString);
          continue;
          localObject1 = null;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NCtr", 1, "parse fail", paramString);
        }
        return;
      }
      continue;
      break label918;
      if (((String)localObject3).equalsIgnoreCase("body"))
      {
        if (Integer.valueOf(((XmlPullParser)localObject2).getAttributeValue(0)).intValue() != 1) {
          break label929;
        }
        bool = true;
        break label926;
      }
      if (((String)localObject3).equalsIgnoreCase("puin"))
      {
        paramString = ((XmlPullParser)localObject2).nextText();
        break label918;
      }
      if (((String)localObject3).equalsIgnoreCase("day"))
      {
        j = Integer.valueOf(((XmlPullParser)localObject2).nextText()).intValue();
        break label918;
      }
      if (!((String)localObject3).equalsIgnoreCase("enableTimes")) {
        break label918;
      }
      k = Integer.valueOf(((XmlPullParser)localObject2).nextText()).intValue();
      break label918;
      if (!((String)localObject3).equalsIgnoreCase("entry")) {
        break label918;
      }
      if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramString)))
      {
        localObject3 = (bhoz)((HashMap)localObject1).get(paramString);
        ((HashMap)localObject1).remove(paramString);
        if ((j == ((bhoz)localObject3).jdField_a_of_type_Int) && (k == ((bhoz)localObject3).b))
        {
          localHashMap.put(paramString, localObject3);
          break label935;
        }
        localHashMap.put(paramString, new bhoz(this, paramString, j, k, 0L, 0));
        break label935;
      }
      localHashMap.put(paramString, new bhoz(this, paramString, j, k, 0L, 0));
      break label935;
    }
    label648:
    label915:
    label918:
    label926:
    label929:
    label935:
    label951:
    for (;;)
    {
      m = ((XmlPullParser)localObject2).next();
      break;
      paramString = new StringBuilder();
      if (localHashMap.size() > 0)
      {
        localObject1 = localHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          bhoz localbhoz = (bhoz)localHashMap.get(str);
          ((SharedPreferences.Editor)localObject2).putString("extra_limit_entry_" + (String)localObject3 + "_" + str, localbhoz.toString());
          paramString.append(str).append(",");
          if (QLog.isColorLevel()) {
            QLog.d("NCtr", 2, "LimitEntry:[" + localbhoz.toString() + "]");
          }
        }
        ((SharedPreferences.Editor)localObject2).putString("extra_limit_uins_" + (String)localObject3, paramString.substring(0, paramString.length() - 1));
        if (QLog.isColorLevel()) {
          QLog.d("NCtr", 2, "LimitUins:[" + paramString.substring(0, paramString.length() - 1) + "].mShouldLimit" + this.jdField_a_of_type_Boolean);
        }
      }
      ((SharedPreferences.Editor)localObject2).apply();
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
      return;
      break label156;
      for (;;)
      {
        if (i > 0) {
          break label951;
        }
        break;
        for (;;)
        {
          break;
          bool = false;
        }
        paramString = "";
        j = 0;
        k = 0;
        i -= 1;
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
      return true;
      b((String)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      paramMessage = (String)paramMessage.obj;
      a(BaseApplicationImpl.getContext(), paramMessage);
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhoy
 * JD-Core Version:    0.7.0.1
 */