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
import com.tencent.open.pcpush.MessageContent.MsgContent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bfmu
  implements bfka
{
  protected static bfmu a;
  protected static List<bfmv> a;
  protected int a;
  protected Handler a;
  protected bfmt a;
  protected ConcurrentHashMap<String, bfmw> a;
  
  protected bfmu()
  {
    this.jdField_a_of_type_Int = 111;
    this.jdField_a_of_type_AndroidOsHandler = new bfmx(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_a_of_type_Bfmt = new bfmt();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    bfkb.a().a(this);
  }
  
  public static bfmu a()
  {
    try
    {
      if (jdField_a_of_type_Bfmu == null) {
        jdField_a_of_type_Bfmu = new bfmu();
      }
      bfmu localbfmu = jdField_a_of_type_Bfmu;
      return localbfmu;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    bfhg.c("PCPushProxy", "--> open key = " + paramString);
    Object localObject1 = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null)
    {
      bfhg.e("PCPushProxy", "open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = " + paramString);
      return 1;
    }
    if (((bfmw)localObject1).jdField_b_of_type_Int != 1)
    {
      localObject2 = a(paramString);
      if ((localObject2 == null) || (((String)localObject2).trim().equals("")) || (!new File((String)localObject2).exists()))
      {
        bfhg.e("PCPushProxy", "open fail, error : file not exist or be deleted, key = " + paramString);
        return 2;
      }
    }
    Object localObject2 = Message.obtain();
    ((Message)localObject2).what = 4;
    ((Message)localObject2).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
    paramString = bexd.a().a();
    if (paramString == null)
    {
      bfhg.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    localObject2 = paramString.getPackageManager();
    if (localObject2 == null)
    {
      bfhg.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    if (((bfmw)localObject1).jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getLaunchIntentForPackage(((bfmw)localObject1).jdField_d_of_type_JavaLangString);
        if (localObject2 == null)
        {
          bfhg.c("PCPushProxy", "open fail, because package not found, package = " + ((bfmw)localObject1).jdField_d_of_type_JavaLangString);
          return 4;
        }
        ((Intent)localObject2).addFlags(268435456);
        paramString.startActivity((Intent)localObject2);
        bfhg.c("PCPushProxy", "open success");
        return 0;
      }
      catch (Exception paramString)
      {
        bfhg.a("PCPushProxy", "open fail, error : ", paramString);
        return 4;
      }
      localObject1 = bfkb.a().a(((bfmw)localObject1).jdField_b_of_type_JavaLangString);
      if (localObject1 == null) {
        return 4;
      }
      localObject1 = bfms.a(paramString, new File(((DownloadInfo)localObject1).l));
      if (localObject1 != null)
      {
        localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 0);
        if ((localObject2 == null) || (((List)localObject2).size() == 0))
        {
          bfhg.c("PCPushProxy", "open fail, error : OPEN_FAIL_NO_RESPONSE_APP");
          return 3;
        }
        paramString.startActivity((Intent)localObject1);
      }
    }
  }
  
  public bfmw a(byte[] paramArrayOfByte)
  {
    bfhg.c("PCPushProxy", "--> parse");
    Object localObject = new MessageContent.MsgContent();
    try
    {
      ((MessageContent.MsgContent)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new bfmw();
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
      bfhg.c("PCPushProxy", "add entry to mPkgEntryMap, hasKey = " + bool);
      if (!bool)
      {
        bfhg.c("PCPushProxy", "add entry to mPkgEntryMap, key = " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
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
    Object localObject = bexd.a().a();
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
    bfmw localbfmw = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbfmw == null)
    {
      bfhg.e("PCPushProxy", "getDownloadPath error because entry = null, key = " + paramString);
      return null;
    }
    paramString = bfkb.a().a(localbfmw.jdField_b_of_type_JavaLangString);
    if (paramString != null) {
      return paramString.l;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bfmv parambfmv)
  {
    bfhg.c("PCPushProxy", "registerDownloadLitener dataline register listeners");
    if (!jdField_a_of_type_JavaUtilList.contains(parambfmv)) {
      jdField_a_of_type_JavaUtilList.add(parambfmv);
    }
  }
  
  public void a(String paramString)
  {
    bfhg.c("PCPushProxy", "--> pause key = " + paramString);
    bfmw localbfmw = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbfmw == null)
    {
      bfhg.e("PCPushProxy", "pause error because entry = null, key = " + paramString);
      return;
    }
    paramString = new Bundle();
    paramString.putString(bfjy.jdField_b_of_type_JavaLangString, localbfmw.jdField_b_of_type_JavaLangString);
    paramString.putString(bfjy.j, localbfmw.jdField_f_of_type_JavaLangString);
    paramString.putString(bfjy.jdField_f_of_type_JavaLangString, localbfmw.jdField_d_of_type_JavaLangString);
    paramString.putString(bfjy.i, localbfmw.jdField_c_of_type_JavaLangString);
    paramString.putString(bfjy.l, localbfmw.jdField_e_of_type_JavaLangString);
    String str = bfjy.y;
    if (localbfmw.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(bfjy.k, 3);
      bfju.a(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    bfhg.c("PCPushProxy", "--> start key = " + paramString);
    if (!bfkb.a().a().contains(this))
    {
      bfkb.a().a(this);
      bfhg.c("PCPushProxy", "PCPushProxy has not register, register download listener");
    }
    bfmw localbfmw = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    boolean bool1;
    if (localbfmw == null)
    {
      bfhg.e("PCPushProxy", "start error because entry = null, key = " + paramString);
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (localbfmw.jdField_e_of_type_Int == 101);
      bool1 = bool2;
    } while (localbfmw.jdField_e_of_type_Int == 104);
    label273:
    int i;
    if (localbfmw.jdField_e_of_type_Int != 105)
    {
      if (!localbfmw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.")) {
        localbfmw.jdField_c_of_type_JavaLangString = (a() + "." + localbfmw.jdField_c_of_type_JavaLangString);
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString(bfjy.jdField_b_of_type_JavaLangString, localbfmw.jdField_b_of_type_JavaLangString);
      paramString.putString(bfjy.j, localbfmw.jdField_f_of_type_JavaLangString);
      paramString.putString(bfjy.jdField_f_of_type_JavaLangString, localbfmw.jdField_d_of_type_JavaLangString);
      paramString.putString(bfjy.i, localbfmw.jdField_c_of_type_JavaLangString);
      paramString.putString(bfjy.l, localbfmw.jdField_e_of_type_JavaLangString);
      String str = bfjy.y;
      if (localbfmw.jdField_b_of_type_Int != 1) {
        break label461;
      }
      bool1 = true;
      paramString.putBoolean(str, bool1);
      if (localbfmw.jdField_b_of_type_Int != 1) {
        break label471;
      }
      if (localbfmw.jdField_d_of_type_Int != 2) {
        break label466;
      }
      i = 12;
    }
    for (;;)
    {
      paramString.putInt(bfjy.k, i);
      bfju.a(null, paramString, "5", null, 0);
      return true;
      if (localbfmw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
        i = "ANDROIDQQ.PCPUSH.AUTO".length();
      }
      for (;;)
      {
        localbfmw.jdField_c_of_type_JavaLangString = (a() + localbfmw.jdField_c_of_type_JavaLangString.substring(i));
        break;
        if (localbfmw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.SINGLEDETAIL".length();
        } else if (localbfmw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.MUTIDETAIL".length();
        } else if (localbfmw.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
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
  
  public void b(bfmv parambfmv)
  {
    if (jdField_a_of_type_JavaUtilList.contains(parambfmv)) {
      jdField_a_of_type_JavaUtilList.remove(parambfmv);
    }
  }
  
  public void b(String paramString)
  {
    bfhg.c("PCPushProxy", "--> install key = " + paramString);
    bfmw localbfmw = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbfmw == null)
    {
      bfhg.e("PCPushProxy", "install error because entry = null, key = " + paramString);
      return;
    }
    if (localbfmw.jdField_b_of_type_Int != 1)
    {
      bfhg.e("PCPushProxy", "The file to be installing is not a apk file");
      return;
    }
    paramString = new Bundle();
    paramString.putString(bfjy.jdField_b_of_type_JavaLangString, localbfmw.jdField_b_of_type_JavaLangString);
    paramString.putString(bfjy.j, localbfmw.jdField_f_of_type_JavaLangString);
    paramString.putString(bfjy.jdField_f_of_type_JavaLangString, localbfmw.jdField_d_of_type_JavaLangString);
    paramString.putString(bfjy.i, localbfmw.jdField_c_of_type_JavaLangString);
    paramString.putString(bfjy.l, localbfmw.jdField_e_of_type_JavaLangString);
    String str = bfjy.y;
    if (localbfmw.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(bfjy.k, 5);
      bfju.a(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public boolean b(String paramString)
  {
    bfhg.c("PCPushProxy", "--> isInstalled key = " + paramString);
    bfmw localbfmw = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbfmw == null)
    {
      bfhg.c("PCPushProxy", "--> key : " + paramString + " 's entry is not exist.");
      return false;
    }
    return bfij.a(localbfmw.jdField_d_of_type_JavaLangString);
  }
  
  public void c(String paramString)
  {
    bfhg.c("PCPushProxy", "--> delete key = " + paramString);
    Object localObject = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      bfhg.e("PCPushProxy", "delete error because entry = null, key = " + paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bfjy.jdField_b_of_type_JavaLangString, ((bfmw)localObject).jdField_b_of_type_JavaLangString);
    localBundle.putString(bfjy.j, ((bfmw)localObject).jdField_f_of_type_JavaLangString);
    localBundle.putString(bfjy.jdField_f_of_type_JavaLangString, ((bfmw)localObject).jdField_d_of_type_JavaLangString);
    localBundle.putString(bfjy.i, ((bfmw)localObject).jdField_c_of_type_JavaLangString);
    localBundle.putString(bfjy.l, ((bfmw)localObject).jdField_e_of_type_JavaLangString);
    String str = bfjy.y;
    if (((bfmw)localObject).jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean(str, bool);
      localBundle.putInt(bfjy.k, 10);
      bfju.a(null, localBundle, "5", null, 0);
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
    bfhg.c("PCPushProxy", "--> installSucceed packageName = " + paramString2);
    paramString1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    if (localIterator.hasNext())
    {
      bfmw localbfmw = (bfmw)localIterator.next();
      if ((!paramString2.equals(localbfmw.jdField_d_of_type_JavaLangString)) || (localbfmw.jdField_c_of_type_Int != 0)) {
        break label136;
      }
      localbfmw.jdField_c_of_type_Int = 1;
      paramString1 = localbfmw;
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
          ((bfmv)paramString2.next()).a(6, paramString1.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    bfhg.c("PCPushProxy", "--> onDownloadCancel info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bfmv)localIterator.next()).a(5, paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramDownloadInfo != null)
    {
      bfhg.c("PCPushProxy", "--> onDownloadError info = " + paramDownloadInfo.toString() + " errorCode = " + paramInt1 + " errorMsg = " + paramString + " state = " + paramInt2);
      localObject = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      paramDownloadInfo = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (paramDownloadInfo == null)
      {
        bfhg.e("PCPushProxy", "onDownloadError error because entry = null, key = " + (String)localObject);
        return;
      }
      paramDownloadInfo.jdField_e_of_type_Int = 105;
    }
    for (;;)
    {
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bfmv)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt1, paramString, paramInt2);
      }
      break;
      paramDownloadInfo = null;
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    bfhg.c("PCPushProxy", "--> onDownloadFinish info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Object localObject = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      bfhg.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((bfmw)localObject).jdField_e_of_type_Int = 102;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bfmv)((Iterator)localObject).next()).a(4, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    bfhg.c("PCPushProxy", "--> onDownloadPause info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Object localObject = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      bfhg.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((bfmw)localObject).jdField_e_of_type_Int = 105;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bfmv)((Iterator)localObject).next()).a(2, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bfhg.c("PCPushProxy", "--> onDownloadUpdate infos = " + paramList.toString());
    ArrayList localArrayList = new ArrayList(10);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      String str = b(((DownloadInfo)localObject).jdField_d_of_type_JavaLangString);
      bfmw localbfmw = (bfmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localbfmw == null)
      {
        bfhg.e("PCPushProxy", "onDownloadUpdate error because entry = null, key = " + str);
      }
      else
      {
        int i = localbfmw.jdField_e_of_type_Int;
        switch (((DownloadInfo)localObject).a())
        {
        }
        for (;;)
        {
          localbfmw.jdField_f_of_type_Int = ((DownloadInfo)localObject).jdField_f_of_type_Int;
          if ((i == 101) || (localbfmw.jdField_e_of_type_Int != 101)) {
            break;
          }
          localObject = jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((bfmv)((Iterator)localObject).next()).a(1, str);
          }
          localbfmw.jdField_e_of_type_Int = 104;
          continue;
          localbfmw.jdField_e_of_type_Int = 101;
          continue;
          if (localbfmw.jdField_c_of_type_Int == 1)
          {
            localbfmw.jdField_e_of_type_Int = 103;
          }
          else
          {
            localbfmw.jdField_e_of_type_Int = 102;
            continue;
            localbfmw.jdField_e_of_type_Int = 105;
            continue;
            localbfmw.jdField_e_of_type_Int = 100;
          }
        }
        localArrayList.add(localbfmw);
      }
    }
    paramList = jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bfmv)paramList.next()).a(localArrayList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    bfhg.c("PCPushProxy", "--> onDownloadWait info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bfmv)localIterator.next()).a(3, paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfmu
 * JD-Core Version:    0.7.0.1
 */