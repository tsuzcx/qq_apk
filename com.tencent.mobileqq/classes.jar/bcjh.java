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

public class bcjh
  implements bcgn
{
  protected static bcjh a;
  protected static List<bcji> a;
  protected int a;
  protected Handler a;
  protected bcjg a;
  protected ConcurrentHashMap<String, bcjj> a;
  
  protected bcjh()
  {
    this.jdField_a_of_type_Int = 111;
    this.jdField_a_of_type_AndroidOsHandler = new bcjk(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
    jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.jdField_a_of_type_Bcjg = new bcjg();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    bcgo.a().a(this);
  }
  
  public static bcjh a()
  {
    try
    {
      if (jdField_a_of_type_Bcjh == null) {
        jdField_a_of_type_Bcjh = new bcjh();
      }
      bcjh localbcjh = jdField_a_of_type_Bcjh;
      return localbcjh;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    bcds.c("PCPushProxy", "--> open key = " + paramString);
    Object localObject1 = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null)
    {
      bcds.e("PCPushProxy", "open fail entry is null, error : OPEN_FAIL_KEY_NOT_EXISTS, key = " + paramString);
      return 1;
    }
    if (((bcjj)localObject1).jdField_b_of_type_Int != 1)
    {
      localObject2 = a(paramString);
      if ((localObject2 == null) || (((String)localObject2).trim().equals("")) || (!new File((String)localObject2).exists()))
      {
        bcds.e("PCPushProxy", "open fail, error : file not exist or be deleted, key = " + paramString);
        return 2;
      }
    }
    Object localObject2 = Message.obtain();
    ((Message)localObject2).what = 4;
    ((Message)localObject2).obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
    paramString = bbtm.a().a();
    if (paramString == null)
    {
      bcds.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    localObject2 = paramString.getPackageManager();
    if (localObject2 == null)
    {
      bcds.c("PCPushProxy", "open fail, error : OPEN_FAIL_OTHERS");
      return 4;
    }
    if (((bcjj)localObject1).jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getLaunchIntentForPackage(((bcjj)localObject1).jdField_d_of_type_JavaLangString);
        if (localObject2 == null)
        {
          bcds.c("PCPushProxy", "open fail, because package not found, package = " + ((bcjj)localObject1).jdField_d_of_type_JavaLangString);
          return 4;
        }
        ((Intent)localObject2).addFlags(268435456);
        paramString.startActivity((Intent)localObject2);
        bcds.c("PCPushProxy", "open success");
        return 0;
      }
      catch (Exception paramString)
      {
        bcds.a("PCPushProxy", "open fail, error : ", paramString);
        return 4;
      }
      localObject1 = bcgo.a().a(((bcjj)localObject1).jdField_b_of_type_JavaLangString);
      if (localObject1 == null) {
        return 4;
      }
      localObject1 = bcjf.a(paramString, new File(((DownloadInfo)localObject1).l));
      if (localObject1 != null)
      {
        localObject2 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, 0);
        if ((localObject2 == null) || (((List)localObject2).size() == 0))
        {
          bcds.c("PCPushProxy", "open fail, error : OPEN_FAIL_NO_RESPONSE_APP");
          return 3;
        }
        paramString.startActivity((Intent)localObject1);
      }
    }
  }
  
  public bcjj a(byte[] paramArrayOfByte)
  {
    bcds.c("PCPushProxy", "--> parse");
    Object localObject = new MessageContent.MsgContent();
    try
    {
      ((MessageContent.MsgContent)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new bcjj();
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
      bcds.c("PCPushProxy", "add entry to mPkgEntryMap, hasKey = " + bool);
      if (!bool)
      {
        bcds.c("PCPushProxy", "add entry to mPkgEntryMap, key = " + paramArrayOfByte.jdField_a_of_type_JavaLangString);
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
    Object localObject = bbtm.a().a();
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
    bcjj localbcjj = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbcjj == null)
    {
      bcds.e("PCPushProxy", "getDownloadPath error because entry = null, key = " + paramString);
      return null;
    }
    paramString = bcgo.a().a(localbcjj.jdField_b_of_type_JavaLangString);
    if (paramString != null) {
      return paramString.l;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bcji parambcji)
  {
    bcds.c("PCPushProxy", "registerDownloadLitener dataline register listeners");
    if (!jdField_a_of_type_JavaUtilList.contains(parambcji)) {
      jdField_a_of_type_JavaUtilList.add(parambcji);
    }
  }
  
  public void a(String paramString)
  {
    bcds.c("PCPushProxy", "--> pause key = " + paramString);
    bcjj localbcjj = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbcjj == null)
    {
      bcds.e("PCPushProxy", "pause error because entry = null, key = " + paramString);
      return;
    }
    paramString = new Bundle();
    paramString.putString(bcgl.jdField_b_of_type_JavaLangString, localbcjj.jdField_b_of_type_JavaLangString);
    paramString.putString(bcgl.j, localbcjj.jdField_f_of_type_JavaLangString);
    paramString.putString(bcgl.jdField_f_of_type_JavaLangString, localbcjj.jdField_d_of_type_JavaLangString);
    paramString.putString(bcgl.i, localbcjj.jdField_c_of_type_JavaLangString);
    paramString.putString(bcgl.l, localbcjj.jdField_e_of_type_JavaLangString);
    String str = bcgl.y;
    if (localbcjj.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(bcgl.k, 3);
      bcgh.a(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    bcds.c("PCPushProxy", "--> start key = " + paramString);
    if (!bcgo.a().a().contains(this))
    {
      bcgo.a().a(this);
      bcds.c("PCPushProxy", "PCPushProxy has not register, register download listener");
    }
    bcjj localbcjj = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    boolean bool1;
    if (localbcjj == null)
    {
      bcds.e("PCPushProxy", "start error because entry = null, key = " + paramString);
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (localbcjj.jdField_e_of_type_Int == 101);
      bool1 = bool2;
    } while (localbcjj.jdField_e_of_type_Int == 104);
    label273:
    int i;
    if (localbcjj.jdField_e_of_type_Int != 105)
    {
      if (!localbcjj.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.")) {
        localbcjj.jdField_c_of_type_JavaLangString = (a() + "." + localbcjj.jdField_c_of_type_JavaLangString);
      }
    }
    else
    {
      paramString = new Bundle();
      paramString.putString(bcgl.jdField_b_of_type_JavaLangString, localbcjj.jdField_b_of_type_JavaLangString);
      paramString.putString(bcgl.j, localbcjj.jdField_f_of_type_JavaLangString);
      paramString.putString(bcgl.jdField_f_of_type_JavaLangString, localbcjj.jdField_d_of_type_JavaLangString);
      paramString.putString(bcgl.i, localbcjj.jdField_c_of_type_JavaLangString);
      paramString.putString(bcgl.l, localbcjj.jdField_e_of_type_JavaLangString);
      String str = bcgl.y;
      if (localbcjj.jdField_b_of_type_Int != 1) {
        break label461;
      }
      bool1 = true;
      paramString.putBoolean(str, bool1);
      if (localbcjj.jdField_b_of_type_Int != 1) {
        break label471;
      }
      if (localbcjj.jdField_d_of_type_Int != 2) {
        break label466;
      }
      i = 12;
    }
    for (;;)
    {
      paramString.putInt(bcgl.k, i);
      bcgh.a(null, paramString, "5", null, 0);
      return true;
      if (localbcjj.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.AUTO.")) {
        i = "ANDROIDQQ.PCPUSH.AUTO".length();
      }
      for (;;)
      {
        localbcjj.jdField_c_of_type_JavaLangString = (a() + localbcjj.jdField_c_of_type_JavaLangString.substring(i));
        break;
        if (localbcjj.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.SINGLEDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.SINGLEDETAIL".length();
        } else if (localbcjj.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.MUTIDETAIL.")) {
          i = "ANDROIDQQ.PCPUSH.MUTIDETAIL".length();
        } else if (localbcjj.jdField_c_of_type_JavaLangString.startsWith("ANDROIDQQ.PCPUSH.UNREADPOP.")) {
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
  
  public void b(bcji parambcji)
  {
    if (jdField_a_of_type_JavaUtilList.contains(parambcji)) {
      jdField_a_of_type_JavaUtilList.remove(parambcji);
    }
  }
  
  public void b(String paramString)
  {
    bcds.c("PCPushProxy", "--> install key = " + paramString);
    bcjj localbcjj = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbcjj == null)
    {
      bcds.e("PCPushProxy", "install error because entry = null, key = " + paramString);
      return;
    }
    if (localbcjj.jdField_b_of_type_Int != 1)
    {
      bcds.e("PCPushProxy", "The file to be installing is not a apk file");
      return;
    }
    paramString = new Bundle();
    paramString.putString(bcgl.jdField_b_of_type_JavaLangString, localbcjj.jdField_b_of_type_JavaLangString);
    paramString.putString(bcgl.j, localbcjj.jdField_f_of_type_JavaLangString);
    paramString.putString(bcgl.jdField_f_of_type_JavaLangString, localbcjj.jdField_d_of_type_JavaLangString);
    paramString.putString(bcgl.i, localbcjj.jdField_c_of_type_JavaLangString);
    paramString.putString(bcgl.l, localbcjj.jdField_e_of_type_JavaLangString);
    String str = bcgl.y;
    if (localbcjj.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.putBoolean(str, bool);
      paramString.putInt(bcgl.k, 5);
      bcgh.a(null, paramString, "5", null, 0);
      return;
    }
  }
  
  public boolean b(String paramString)
  {
    bcds.c("PCPushProxy", "--> isInstalled key = " + paramString);
    bcjj localbcjj = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localbcjj == null)
    {
      bcds.c("PCPushProxy", "--> key : " + paramString + " 's entry is not exist.");
      return false;
    }
    return bcev.a(localbcjj.jdField_d_of_type_JavaLangString);
  }
  
  public void c(String paramString)
  {
    bcds.c("PCPushProxy", "--> delete key = " + paramString);
    Object localObject = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      bcds.e("PCPushProxy", "delete error because entry = null, key = " + paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bcgl.jdField_b_of_type_JavaLangString, ((bcjj)localObject).jdField_b_of_type_JavaLangString);
    localBundle.putString(bcgl.j, ((bcjj)localObject).jdField_f_of_type_JavaLangString);
    localBundle.putString(bcgl.jdField_f_of_type_JavaLangString, ((bcjj)localObject).jdField_d_of_type_JavaLangString);
    localBundle.putString(bcgl.i, ((bcjj)localObject).jdField_c_of_type_JavaLangString);
    localBundle.putString(bcgl.l, ((bcjj)localObject).jdField_e_of_type_JavaLangString);
    String str = bcgl.y;
    if (((bcjj)localObject).jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean(str, bool);
      localBundle.putInt(bcgl.k, 10);
      bcgh.a(null, localBundle, "5", null, 0);
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
    bcds.c("PCPushProxy", "--> installSucceed packageName = " + paramString2);
    paramString1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    if (localIterator.hasNext())
    {
      bcjj localbcjj = (bcjj)localIterator.next();
      if ((!paramString2.equals(localbcjj.jdField_d_of_type_JavaLangString)) || (localbcjj.jdField_c_of_type_Int != 0)) {
        break label136;
      }
      localbcjj.jdField_c_of_type_Int = 1;
      paramString1 = localbcjj;
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
          ((bcji)paramString2.next()).a(6, paramString1.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    bcds.c("PCPushProxy", "--> onDownloadCancel info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bcji)localIterator.next()).a(5, paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (paramDownloadInfo != null)
    {
      bcds.c("PCPushProxy", "--> onDownloadError info = " + paramDownloadInfo.toString() + " errorCode = " + paramInt1 + " errorMsg = " + paramString + " state = " + paramInt2);
      localObject = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
      paramDownloadInfo = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (paramDownloadInfo == null)
      {
        bcds.e("PCPushProxy", "onDownloadError error because entry = null, key = " + (String)localObject);
        return;
      }
      paramDownloadInfo.jdField_e_of_type_Int = 105;
    }
    for (;;)
    {
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bcji)((Iterator)localObject).next()).a(paramDownloadInfo, paramInt1, paramString, paramInt2);
      }
      break;
      paramDownloadInfo = null;
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    bcds.c("PCPushProxy", "--> onDownloadFinish info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Object localObject = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      bcds.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((bcjj)localObject).jdField_e_of_type_Int = 102;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bcji)((Iterator)localObject).next()).a(4, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    bcds.c("PCPushProxy", "--> onDownloadPause info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Object localObject = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramDownloadInfo);
    if (localObject == null) {
      bcds.e("PCPushProxy", "onDownloadPause error because entry = null, key = " + paramDownloadInfo);
    }
    for (;;)
    {
      return;
      ((bcjj)localObject).jdField_e_of_type_Int = 105;
      localObject = jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bcji)((Iterator)localObject).next()).a(2, paramDownloadInfo);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    bcds.c("PCPushProxy", "--> onDownloadUpdate infos = " + paramList.toString());
    ArrayList localArrayList = new ArrayList(10);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      String str = b(((DownloadInfo)localObject).jdField_d_of_type_JavaLangString);
      bcjj localbcjj = (bcjj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localbcjj == null)
      {
        bcds.e("PCPushProxy", "onDownloadUpdate error because entry = null, key = " + str);
      }
      else
      {
        int i = localbcjj.jdField_e_of_type_Int;
        switch (((DownloadInfo)localObject).a())
        {
        }
        for (;;)
        {
          localbcjj.jdField_f_of_type_Int = ((DownloadInfo)localObject).jdField_f_of_type_Int;
          if ((i == 101) || (localbcjj.jdField_e_of_type_Int != 101)) {
            break;
          }
          localObject = jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((bcji)((Iterator)localObject).next()).a(1, str);
          }
          localbcjj.jdField_e_of_type_Int = 104;
          continue;
          localbcjj.jdField_e_of_type_Int = 101;
          continue;
          if (localbcjj.jdField_c_of_type_Int == 1)
          {
            localbcjj.jdField_e_of_type_Int = 103;
          }
          else
          {
            localbcjj.jdField_e_of_type_Int = 102;
            continue;
            localbcjj.jdField_e_of_type_Int = 105;
            continue;
            localbcjj.jdField_e_of_type_Int = 100;
          }
        }
        localArrayList.add(localbcjj);
      }
    }
    paramList = jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext()) {
      ((bcji)paramList.next()).a(localArrayList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    bcds.c("PCPushProxy", "--> onDownloadWait info = " + paramDownloadInfo.toString());
    paramDownloadInfo = b(paramDownloadInfo.jdField_d_of_type_JavaLangString);
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bcji)localIterator.next()).a(3, paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcjh
 * JD-Core Version:    0.7.0.1
 */