import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.pcpush.MessageContent.MsgContent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bjpu
  implements DownloadListener
{
  protected static bjpu a;
  protected static List<bjpv> a;
  protected int a;
  protected Handler a;
  protected bjpt a;
  protected ConcurrentHashMap<String, bjpw> a;
  
  protected bjpu()
  {
    this.jdField_a_of_type_Int = 111;
    this.jdField_a_of_type_AndroidOsHandler = new bjpx(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_a_of_type_Bjpt = new bjpt();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    bjna.a().a(this);
  }
  
  public static bjpu a()
  {
    try
    {
      if (jdField_a_of_type_Bjpu == null) {
        jdField_a_of_type_Bjpu = new bjpu();
      }
      bjpu localbjpu = jdField_a_of_type_Bjpu;
      return localbjpu;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    bjko.c("PCPushProxy", "--> open key = " + paramString);
    Object localObject1 = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null)
    {
      bjko.e("PCPushProxy", "open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = " + paramString);
      return 1;
    }
    if (((bjpw)localObject1).jdField_b_of_type_Int != 1)
    {
      localObject2 = a(paramString);
      if ((localObject2 == null) || (((String)localObject2).trim().equals("")) || (!new File((String)localObject2).exists()))
      {
        bjko.e("PCPushProxy", "open fail, error : file not exist or be deleted, key = " + paramString);
        return 2;
      }
    }
    Object localObject2 = Message.obtain();
    ((Message)localObject2).what = 4;
    ((Message)localObject2).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
    paramString = bizw.a().a();
    if (paramString == null)
    {
      bjko.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    localObject2 = paramString.getPackageManager();
    if (localObject2 == null)
    {
      bjko.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    if (((bjpw)localObject1).jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getLaunchIntentForPackage(((bjpw)localObject1).jdField_d_of_type_JavaLangString);
        if (localObject2 == null)
        {
          bjko.c("PCPushProxy", "open fail, because package not found, package = " + ((bjpw)localObject1).jdField_d_of_type_JavaLangString);
          return 4;
        }
        ((Intent)localObject2).addFlags(268435456);
        paramString.startActivity((Intent)localObject2);
        bjko.c("PCPushProxy", "open success");
        return 0;
      }
      catch (Exception paramString)
      {
        bjko.a("PCPushProxy", "open fail, error : ", paramString);
        return 4;
      }
      localObject1 = bjna.a().a(((bjpw)localObject1).jdField_b_of_type_JavaLangString);
      if (localObject1 == null) {
        return 4;
      }
      localObject1 = bjps.a(paramString, new File(((DownloadInfo)localObject1).l));
      if (localObject1 != null)
      {
        localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 0);
        if ((localObject2 == null) || (((List)localObject2).size() == 0))
        {
          bjko.c("PCPushProxy", "open fail, error : OPEN_FAIL_NO_RESPONSE_APP");
          return 3;
        }
        paramString.startActivity((Intent)localObject1);
      }
    }
  }
  
  public bjpw a(byte[] paramArrayOfByte)
  {
    bjko.c("PCPushProxy", "--> parse");
    Object localObject = new MessageContent.MsgContent();
    try
    {
      ((MessageContent.MsgContent)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new bjpw();
      paramArrayOfByte.jdField_b_of_type_JavaLangString = String.valueOf(((MessageContent.MsgContent)localObject).appid.get());
      paramArrayOfByte.jdField_e_of_type_JavaLangString = ((MessageContent.MsgContent)localObject).appname.get();
      paramArrayOfByte.h = ((MessageContent.MsgContent)localObject).appsize.get();
      paramArrayOfByte.jdField_f_of_type_JavaLangString = ((MessageContent.MsgContent)localObject).appurl.get();
      paramArrayOfByte.jdField_b_of_type_Int = ((MessageContent.MsgContent)localObject).filetype.get();
      paramArrayOfByte.g = ((MessageContent.MsgContent)localObject).iconurl.get();
      paramArrayOfByte.jdField_d_of_type_JavaLangString = ((MessageContent.MsgContent)localObject).pkgname.get();
      paramArrayOfByte.i = ((MessageContent.MsgContent)localObject).source.get();
      paramArrayOfByte.j = ((MessageContent.MsgContent)localObject).srciconurl.get();
      paramArrayOfByte.jdField_a_of_type_Int = ((MessageContent.MsgContent)localObject).versioncode.get();
      paramArrayOfByte.jdField_c_of_type_JavaLangString = ((MessageContent.MsgContent)localObject).via.get();
      paramArrayOfByte.jdField_a_of_type_JavaLangString = b(paramArrayOfByte.jdField_f_of_type_JavaLangString);
      if (paramArrayOfByte.jdField_b_of_type_Int != 1)
      {
        paramArrayOfByte.jdField_b_of_type_JavaLangString = ("unapk" + SystemClock.currentThreadTimeMillis() + "#" + paramArrayOfByte.jdField_b_of_type_JavaLangString);
        paramArrayOfByte.jdField_d_of_type_JavaLangString = paramArrayOfByte.jdField_e_of_type_JavaLangString;
      }
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramArrayOfByte.jdField_a_of_type_JavaLangString);
      bjko.c("PCPushProxy", "add entry to mPkgEntryMap, hasKey = " + bool);
      if (!bool)
      {
        bjko.c("PCPushProxy", "add entry to mPkgEntryMap, key = " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfByte.jdField_a_of_type_JavaLangString, paramArrayOfByte);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = paramArrayOfByte.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected String a()
  {
    Object localObject = bizw.a().a();
    if (localObject != null)
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()) && (((NetworkInfo)localObject).isAvailable())) {
          return "ANDROIDQQ.PCPUSH.AUTO";
        }
      }
    }
    if (this.jdField_a_of_type_Int == 111) {
      return "ANDROIDQQ.PCPUSH.SINGLEDETAIL";
    }
    if (this.jdField_a_of_type_Int == 112) {
      return "ANDROIDQQ.PCPUSH.MUTIDETAIL";
    }
    if (this.jdField_a_of_type_Int == 113) {
      return "ANDROIDQQ.PCPUSH.UNREADPOP";
    }
    return "ANDROIDQQ.PCPUSH.AUTO";
  }
  
  public String a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return null;
    }
    bjpw localbjpw = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbjpw == null)
    {
      bjko.e("PCPushProxy", "getDownloadPath error because entry = null, key = " + paramString);
      return null;
    }
    paramString = bjna.a().a(localbjpw.jdField_b_of_type_JavaLangString);
    if (paramString != null) {
      return paramString.l;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bjpv parambjpv)
  {
    bjko.c("PCPushProxy", "registerDownloadLitener dataline register listeners");
    if (!jdField_a_of_type_JavaUtilList.contains(parambjpv)) {
      jdField_a_of_type_JavaUtilList.add(parambjpv);
    }
  }
  
  public void a(String paramString)
  {
    bjko.c("PCPushProxy", "--> pause key = " + paramString);
    bjpw localbjpw = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbjpw == null)
    {
      bjko.e("PCPushProxy", "pause error because entry = null, key = " + paramString);
      return;
    }
    paramString = new Bundle();
    paramString.putString(bjmy.jdField_b_of_type_JavaLangString, localbjpw.jdField_b_of_type_JavaLangString);
    paramString.putString(bjmy.j, localbjpw.jdField_f_of_type_JavaLangString);
    paramString.putString(bjmy.jdField_f_of_type_JavaLangString, localbjpw.jdField_d_of_type_JavaLangString);
    paramString.putString(bjmy.i, localbjpw.jdField_c_of_type_JavaLangString);
    paramString.putString(bjmy.l, localbjpw.jdField_e_of_type_JavaLangString);
    String str = bjmy.y;
    if (localbjpw.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(bjmy.k, 3);
      bjmu.a(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    bjko.c("PCPushProxy", "--> start key = " + paramString);
    if (!bjna.a().a().contains(this))
    {
      bjna.a().a(this);
      bjko.c("PCPushProxy", "PCPushProxy has not register, register download listener");
    }
    bjpw localbjpw = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    boolean bool1;
    if (localbjpw == null)
    {
      bjko.e("PCPushProxy", "start error because entry = null, key = " + paramString);
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (localbjpw.jdField_e_of_type_Int == 101);
      bool1 = bool2;
    } while (localbjpw.jdField_e_of_type_Int == 104);
    label273:
    int i;
    if (localbjpw.jdField_e_of_type_Int != 105)
    {
      if (!localbjpw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.")) {
        localbjpw.jdField_c_of_type_JavaLangString = (a() + "." + localbjpw.jdField_c_of_type_JavaLangString);
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString(bjmy.jdField_b_of_type_JavaLangString, localbjpw.jdField_b_of_type_JavaLangString);
      paramString.putString(bjmy.j, localbjpw.jdField_f_of_type_JavaLangString);
      paramString.putString(bjmy.jdField_f_of_type_JavaLangString, localbjpw.jdField_d_of_type_JavaLangString);
      paramString.putString(bjmy.i, localbjpw.jdField_c_of_type_JavaLangString);
      paramString.putString(bjmy.l, localbjpw.jdField_e_of_type_JavaLangString);
      String str = bjmy.y;
      if (localbjpw.jdField_b_of_type_Int != 1) {
        break label461;
      }
      bool1 = true;
      paramString.putBoolean(str, bool1);
      if (localbjpw.jdField_b_of_type_Int != 1) {
        break label471;
      }
      if (localbjpw.jdField_d_of_type_Int != 2) {
        break label466;
      }
      i = 12;
    }
    for (;;)
    {
      paramString.putInt(bjmy.k, i);
      bjmu.a(null, paramString, "5", null, 0);
      return true;
      if (localbjpw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
        i = "ANDROIDQQ.PCPUSH.AUTO".length();
      }
      for (;;)
      {
        localbjpw.jdField_c_of_type_JavaLangString = (a() + localbjpw.jdField_c_of_type_JavaLangString.substring(i));
        break;
        if (localbjpw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.SINGLEDETAIL".length();
        } else if (localbjpw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.MUTIDETAIL".length();
        } else if (localbjpw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
          i = "ANDROIDQQ.PCPUSH.UNREADPOP".length();
        } else {
          i = "ANDROIDQQ.PCPUSH".length();
        }
      }
      label461:
      bool1 = false;
      break label273;
      label466:
      i = 2;
      continue;
      label471:
      i = 2;
    }
  }
  
  protected String b(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    return "p" + paramString.hashCode();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
  }
  
  public void b(bjpv parambjpv)
  {
    if (jdField_a_of_type_JavaUtilList.contains(parambjpv)) {
      jdField_a_of_type_JavaUtilList.remove(parambjpv);
    }
  }
  
  public void b(String paramString)
  {
    bjko.c("PCPushProxy", "--> install key = " + paramString);
    bjpw localbjpw = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbjpw == null)
    {
      bjko.e("PCPushProxy", "install error because entry = null, key = " + paramString);
      return;
    }
    if (localbjpw.jdField_b_of_type_Int != 1)
    {
      bjko.e("PCPushProxy", "The file to be installing is not a apk file");
      return;
    }
    paramString = new Bundle();
    paramString.putString(bjmy.jdField_b_of_type_JavaLangString, localbjpw.jdField_b_of_type_JavaLangString);
    paramString.putString(bjmy.j, localbjpw.jdField_f_of_type_JavaLangString);
    paramString.putString(bjmy.jdField_f_of_type_JavaLangString, localbjpw.jdField_d_of_type_JavaLangString);
    paramString.putString(bjmy.i, localbjpw.jdField_c_of_type_JavaLangString);
    paramString.putString(bjmy.l, localbjpw.jdField_e_of_type_JavaLangString);
    String str = bjmy.y;
    if (localbjpw.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(bjmy.k, 5);
      bjmu.a(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public boolean b(String paramString)
  {
    bjko.c("PCPushProxy", "--> isInstalled key = " + paramString);
    bjpw localbjpw = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbjpw == null)
    {
      bjko.c("PCPushProxy", "--> key : " + paramString + " 's entry is not exist.");
      return false;
    }
    return bjlo.a(localbjpw.jdField_d_of_type_JavaLangString);
  }
  
  public void c(String paramString)
  {
    bjko.c("PCPushProxy", "--> delete key = " + paramString);
    Object localObject = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      bjko.e("PCPushProxy", "delete error because entry = null, key = " + paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bjmy.jdField_b_of_type_JavaLangString, ((bjpw)localObject).jdField_b_of_type_JavaLangString);
    localBundle.putString(bjmy.j, ((bjpw)localObject).jdField_f_of_type_JavaLangString);
    localBundle.putString(bjmy.jdField_f_of_type_JavaLangString, ((bjpw)localObject).jdField_d_of_type_JavaLangString);
    localBundle.putString(bjmy.i, ((bjpw)localObject).jdField_c_of_type_JavaLangString);
    localBundle.putString(bjmy.l, ((bjpw)localObject).jdField_e_of_type_JavaLangString);
    String str = bjmy.y;
    if (((bjpw)localObject).jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean(str, bool);
      localBundle.putInt(bjmy.k, 10);
      bjmu.a(null, localBundle, "5", null, 0);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      localObject = Message.obtain();
      ((Message)localObject).what = 3;
      ((Message)localObject).obj = paramString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    bjko.c("PCPushProxy", "--> installSucceed packageName = " + paramString2);
    paramString1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    if (localIterator.hasNext())
    {
      bjpw localbjpw = (bjpw)localIterator.next();
      if ((!paramString2.equals(localbjpw.jdField_d_of_type_JavaLangString)) || (localbjpw.jdField_c_of_type_Int != 0)) {
        break label136;
      }
      localbjpw.jdField_c_of_type_Int = 1;
      paramString1 = localbjpw;
    }
    label136:
    for (;;)
    {
      break;
      if (paramString1 == null) {}
      for (;;)
      {
        return;
        paramString2 = jdField_a_of_type_JavaUtilList.iterator();
        while (paramString2.hasNext()) {
          ((bjpv)paramString2.next()).a(6, paramString1.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    bjko.c("PCPushProxy", "--> onDownloadCancel info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bjpv)localIterator.next()).a(5, paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramDownloadInfo != null)
    {
      bjko.c("PCPushProxy", "--> onDownloadError info = " + paramDownloadInfo.toString() + " errorCode = " + paramInt1 + " errorMsg = " + paramString + " state = " + paramInt2);
      localObject = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      paramDownloadInfo = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (paramDownloadInfo == null)
      {
        bjko.e("PCPushProxy", "onDownloadError error because entry = null, key = " + (String)localObject);
        return;
      }
      paramDownloadInfo.jdField_e_of_type_Int = 105;
    }
    for (;;)
    {
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bjpv)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt1, paramString, paramInt2);
      }
      break;
      paramDownloadInfo = null;
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    bjko.c("PCPushProxy", "--> onDownloadFinish info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Object localObject = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      bjko.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((bjpw)localObject).jdField_e_of_type_Int = 102;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bjpv)((Iterator)localObject).next()).a(4, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    bjko.c("PCPushProxy", "--> onDownloadPause info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Object localObject = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      bjko.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((bjpw)localObject).jdField_e_of_type_Int = 105;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bjpv)((Iterator)localObject).next()).a(2, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bjko.c("PCPushProxy", "--> onDownloadUpdate infos = " + paramList.toString());
    ArrayList localArrayList = new ArrayList(10);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      String str = b(((DownloadInfo)localObject).jdField_d_of_type_JavaLangString);
      bjpw localbjpw = (bjpw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localbjpw == null)
      {
        bjko.e("PCPushProxy", "onDownloadUpdate error because entry = null, key = " + str);
      }
      else
      {
        int i = localbjpw.jdField_e_of_type_Int;
        switch (((DownloadInfo)localObject).a())
        {
        }
        for (;;)
        {
          localbjpw.jdField_f_of_type_Int = ((DownloadInfo)localObject).jdField_f_of_type_Int;
          if ((i == 101) || (localbjpw.jdField_e_of_type_Int != 101)) {
            break;
          }
          localObject = jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((bjpv)((Iterator)localObject).next()).a(1, str);
          }
          localbjpw.jdField_e_of_type_Int = 104;
          continue;
          localbjpw.jdField_e_of_type_Int = 101;
          continue;
          if (localbjpw.jdField_c_of_type_Int == 1)
          {
            localbjpw.jdField_e_of_type_Int = 103;
          }
          else
          {
            localbjpw.jdField_e_of_type_Int = 102;
            continue;
            localbjpw.jdField_e_of_type_Int = 105;
            continue;
            localbjpw.jdField_e_of_type_Int = 100;
          }
        }
        localArrayList.add(localbjpw);
      }
    }
    paramList = jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bjpv)paramList.next()).a(localArrayList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    bjko.c("PCPushProxy", "--> onDownloadWait info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bjpv)localIterator.next()).a(3, paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpu
 * JD-Core Version:    0.7.0.1
 */