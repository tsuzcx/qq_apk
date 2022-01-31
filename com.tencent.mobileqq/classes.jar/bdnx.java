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

public class bdnx
  implements bdld
{
  protected static bdnx a;
  protected static List<bdny> a;
  protected int a;
  protected Handler a;
  protected bdnw a;
  protected ConcurrentHashMap<String, bdnz> a;
  
  protected bdnx()
  {
    this.jdField_a_of_type_Int = 111;
    this.jdField_a_of_type_AndroidOsHandler = new bdoa(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_a_of_type_Bdnw = new bdnw();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    bdle.a().a(this);
  }
  
  public static bdnx a()
  {
    try
    {
      if (jdField_a_of_type_Bdnx == null) {
        jdField_a_of_type_Bdnx = new bdnx();
      }
      bdnx localbdnx = jdField_a_of_type_Bdnx;
      return localbdnx;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    bdii.c("PCPushProxy", "--> open key = " + paramString);
    Object localObject1 = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null)
    {
      bdii.e("PCPushProxy", "open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = " + paramString);
      return 1;
    }
    if (((bdnz)localObject1).jdField_b_of_type_Int != 1)
    {
      localObject2 = a(paramString);
      if ((localObject2 == null) || (((String)localObject2).trim().equals("")) || (!new File((String)localObject2).exists()))
      {
        bdii.e("PCPushProxy", "open fail, error : file not exist or be deleted, key = " + paramString);
        return 2;
      }
    }
    Object localObject2 = Message.obtain();
    ((Message)localObject2).what = 4;
    ((Message)localObject2).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
    paramString = bcyb.a().a();
    if (paramString == null)
    {
      bdii.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    localObject2 = paramString.getPackageManager();
    if (localObject2 == null)
    {
      bdii.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    if (((bdnz)localObject1).jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getLaunchIntentForPackage(((bdnz)localObject1).jdField_d_of_type_JavaLangString);
        if (localObject2 == null)
        {
          bdii.c("PCPushProxy", "open fail, because package not found, package = " + ((bdnz)localObject1).jdField_d_of_type_JavaLangString);
          return 4;
        }
        ((Intent)localObject2).addFlags(268435456);
        paramString.startActivity((Intent)localObject2);
        bdii.c("PCPushProxy", "open success");
        return 0;
      }
      catch (Exception paramString)
      {
        bdii.a("PCPushProxy", "open fail, error : ", paramString);
        return 4;
      }
      localObject1 = bdle.a().a(((bdnz)localObject1).jdField_b_of_type_JavaLangString);
      if (localObject1 == null) {
        return 4;
      }
      localObject1 = bdnv.a(paramString, new File(((DownloadInfo)localObject1).l));
      if (localObject1 != null)
      {
        localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 0);
        if ((localObject2 == null) || (((List)localObject2).size() == 0))
        {
          bdii.c("PCPushProxy", "open fail, error : OPEN_FAIL_NO_RESPONSE_APP");
          return 3;
        }
        paramString.startActivity((Intent)localObject1);
      }
    }
  }
  
  public bdnz a(byte[] paramArrayOfByte)
  {
    bdii.c("PCPushProxy", "--> parse");
    Object localObject = new MessageContent.MsgContent();
    try
    {
      ((MessageContent.MsgContent)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new bdnz();
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
      bdii.c("PCPushProxy", "add entry to mPkgEntryMap, hasKey = " + bool);
      if (!bool)
      {
        bdii.c("PCPushProxy", "add entry to mPkgEntryMap, key = " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
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
    Object localObject = bcyb.a().a();
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
    bdnz localbdnz = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbdnz == null)
    {
      bdii.e("PCPushProxy", "getDownloadPath error because entry = null, key = " + paramString);
      return null;
    }
    paramString = bdle.a().a(localbdnz.jdField_b_of_type_JavaLangString);
    if (paramString != null) {
      return paramString.l;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bdny parambdny)
  {
    bdii.c("PCPushProxy", "registerDownloadLitener dataline register listeners");
    if (!jdField_a_of_type_JavaUtilList.contains(parambdny)) {
      jdField_a_of_type_JavaUtilList.add(parambdny);
    }
  }
  
  public void a(String paramString)
  {
    bdii.c("PCPushProxy", "--> pause key = " + paramString);
    bdnz localbdnz = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbdnz == null)
    {
      bdii.e("PCPushProxy", "pause error because entry = null, key = " + paramString);
      return;
    }
    paramString = new Bundle();
    paramString.putString(bdlb.jdField_b_of_type_JavaLangString, localbdnz.jdField_b_of_type_JavaLangString);
    paramString.putString(bdlb.j, localbdnz.jdField_f_of_type_JavaLangString);
    paramString.putString(bdlb.jdField_f_of_type_JavaLangString, localbdnz.jdField_d_of_type_JavaLangString);
    paramString.putString(bdlb.i, localbdnz.jdField_c_of_type_JavaLangString);
    paramString.putString(bdlb.l, localbdnz.jdField_e_of_type_JavaLangString);
    String str = bdlb.y;
    if (localbdnz.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(bdlb.k, 3);
      bdkx.a(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    bdii.c("PCPushProxy", "--> start key = " + paramString);
    if (!bdle.a().a().contains(this))
    {
      bdle.a().a(this);
      bdii.c("PCPushProxy", "PCPushProxy has not register, register download listener");
    }
    bdnz localbdnz = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    boolean bool1;
    if (localbdnz == null)
    {
      bdii.e("PCPushProxy", "start error because entry = null, key = " + paramString);
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (localbdnz.jdField_e_of_type_Int == 101);
      bool1 = bool2;
    } while (localbdnz.jdField_e_of_type_Int == 104);
    label273:
    int i;
    if (localbdnz.jdField_e_of_type_Int != 105)
    {
      if (!localbdnz.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.")) {
        localbdnz.jdField_c_of_type_JavaLangString = (a() + "." + localbdnz.jdField_c_of_type_JavaLangString);
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString(bdlb.jdField_b_of_type_JavaLangString, localbdnz.jdField_b_of_type_JavaLangString);
      paramString.putString(bdlb.j, localbdnz.jdField_f_of_type_JavaLangString);
      paramString.putString(bdlb.jdField_f_of_type_JavaLangString, localbdnz.jdField_d_of_type_JavaLangString);
      paramString.putString(bdlb.i, localbdnz.jdField_c_of_type_JavaLangString);
      paramString.putString(bdlb.l, localbdnz.jdField_e_of_type_JavaLangString);
      String str = bdlb.y;
      if (localbdnz.jdField_b_of_type_Int != 1) {
        break label461;
      }
      bool1 = true;
      paramString.putBoolean(str, bool1);
      if (localbdnz.jdField_b_of_type_Int != 1) {
        break label471;
      }
      if (localbdnz.jdField_d_of_type_Int != 2) {
        break label466;
      }
      i = 12;
    }
    for (;;)
    {
      paramString.putInt(bdlb.k, i);
      bdkx.a(null, paramString, "5", null, 0);
      return true;
      if (localbdnz.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
        i = "ANDROIDQQ.PCPUSH.AUTO".length();
      }
      for (;;)
      {
        localbdnz.jdField_c_of_type_JavaLangString = (a() + localbdnz.jdField_c_of_type_JavaLangString.substring(i));
        break;
        if (localbdnz.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.SINGLEDETAIL".length();
        } else if (localbdnz.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.MUTIDETAIL".length();
        } else if (localbdnz.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
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
  
  public void b(bdny parambdny)
  {
    if (jdField_a_of_type_JavaUtilList.contains(parambdny)) {
      jdField_a_of_type_JavaUtilList.remove(parambdny);
    }
  }
  
  public void b(String paramString)
  {
    bdii.c("PCPushProxy", "--> install key = " + paramString);
    bdnz localbdnz = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbdnz == null)
    {
      bdii.e("PCPushProxy", "install error because entry = null, key = " + paramString);
      return;
    }
    if (localbdnz.jdField_b_of_type_Int != 1)
    {
      bdii.e("PCPushProxy", "The file to be installing is not a apk file");
      return;
    }
    paramString = new Bundle();
    paramString.putString(bdlb.jdField_b_of_type_JavaLangString, localbdnz.jdField_b_of_type_JavaLangString);
    paramString.putString(bdlb.j, localbdnz.jdField_f_of_type_JavaLangString);
    paramString.putString(bdlb.jdField_f_of_type_JavaLangString, localbdnz.jdField_d_of_type_JavaLangString);
    paramString.putString(bdlb.i, localbdnz.jdField_c_of_type_JavaLangString);
    paramString.putString(bdlb.l, localbdnz.jdField_e_of_type_JavaLangString);
    String str = bdlb.y;
    if (localbdnz.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(bdlb.k, 5);
      bdkx.a(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public boolean b(String paramString)
  {
    bdii.c("PCPushProxy", "--> isInstalled key = " + paramString);
    bdnz localbdnz = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbdnz == null)
    {
      bdii.c("PCPushProxy", "--> key : " + paramString + " 's entry is not exist.");
      return false;
    }
    return bdjl.a(localbdnz.jdField_d_of_type_JavaLangString);
  }
  
  public void c(String paramString)
  {
    bdii.c("PCPushProxy", "--> delete key = " + paramString);
    Object localObject = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      bdii.e("PCPushProxy", "delete error because entry = null, key = " + paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bdlb.jdField_b_of_type_JavaLangString, ((bdnz)localObject).jdField_b_of_type_JavaLangString);
    localBundle.putString(bdlb.j, ((bdnz)localObject).jdField_f_of_type_JavaLangString);
    localBundle.putString(bdlb.jdField_f_of_type_JavaLangString, ((bdnz)localObject).jdField_d_of_type_JavaLangString);
    localBundle.putString(bdlb.i, ((bdnz)localObject).jdField_c_of_type_JavaLangString);
    localBundle.putString(bdlb.l, ((bdnz)localObject).jdField_e_of_type_JavaLangString);
    String str = bdlb.y;
    if (((bdnz)localObject).jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean(str, bool);
      localBundle.putInt(bdlb.k, 10);
      bdkx.a(null, localBundle, "5", null, 0);
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
    bdii.c("PCPushProxy", "--> installSucceed packageName = " + paramString2);
    paramString1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    if (localIterator.hasNext())
    {
      bdnz localbdnz = (bdnz)localIterator.next();
      if ((!paramString2.equals(localbdnz.jdField_d_of_type_JavaLangString)) || (localbdnz.jdField_c_of_type_Int != 0)) {
        break label136;
      }
      localbdnz.jdField_c_of_type_Int = 1;
      paramString1 = localbdnz;
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
          ((bdny)paramString2.next()).a(6, paramString1.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    bdii.c("PCPushProxy", "--> onDownloadCancel info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bdny)localIterator.next()).a(5, paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramDownloadInfo != null)
    {
      bdii.c("PCPushProxy", "--> onDownloadError info = " + paramDownloadInfo.toString() + " errorCode = " + paramInt1 + " errorMsg = " + paramString + " state = " + paramInt2);
      localObject = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      paramDownloadInfo = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (paramDownloadInfo == null)
      {
        bdii.e("PCPushProxy", "onDownloadError error because entry = null, key = " + (String)localObject);
        return;
      }
      paramDownloadInfo.jdField_e_of_type_Int = 105;
    }
    for (;;)
    {
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bdny)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt1, paramString, paramInt2);
      }
      break;
      paramDownloadInfo = null;
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    bdii.c("PCPushProxy", "--> onDownloadFinish info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Object localObject = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      bdii.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((bdnz)localObject).jdField_e_of_type_Int = 102;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bdny)((Iterator)localObject).next()).a(4, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    bdii.c("PCPushProxy", "--> onDownloadPause info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Object localObject = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      bdii.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((bdnz)localObject).jdField_e_of_type_Int = 105;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bdny)((Iterator)localObject).next()).a(2, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bdii.c("PCPushProxy", "--> onDownloadUpdate infos = " + paramList.toString());
    ArrayList localArrayList = new ArrayList(10);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      String str = b(((DownloadInfo)localObject).jdField_d_of_type_JavaLangString);
      bdnz localbdnz = (bdnz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localbdnz == null)
      {
        bdii.e("PCPushProxy", "onDownloadUpdate error because entry = null, key = " + str);
      }
      else
      {
        int i = localbdnz.jdField_e_of_type_Int;
        switch (((DownloadInfo)localObject).a())
        {
        }
        for (;;)
        {
          localbdnz.jdField_f_of_type_Int = ((DownloadInfo)localObject).jdField_f_of_type_Int;
          if ((i == 101) || (localbdnz.jdField_e_of_type_Int != 101)) {
            break;
          }
          localObject = jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((bdny)((Iterator)localObject).next()).a(1, str);
          }
          localbdnz.jdField_e_of_type_Int = 104;
          continue;
          localbdnz.jdField_e_of_type_Int = 101;
          continue;
          if (localbdnz.jdField_c_of_type_Int == 1)
          {
            localbdnz.jdField_e_of_type_Int = 103;
          }
          else
          {
            localbdnz.jdField_e_of_type_Int = 102;
            continue;
            localbdnz.jdField_e_of_type_Int = 105;
            continue;
            localbdnz.jdField_e_of_type_Int = 100;
          }
        }
        localArrayList.add(localbdnz);
      }
    }
    paramList = jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bdny)paramList.next()).a(localArrayList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    bdii.c("PCPushProxy", "--> onDownloadWait info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bdny)localIterator.next()).a(3, paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdnx
 * JD-Core Version:    0.7.0.1
 */