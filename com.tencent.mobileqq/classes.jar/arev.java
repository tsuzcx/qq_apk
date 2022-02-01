import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arev
  implements INetEngine.INetEngineListener
{
  private areu jdField_a_of_type_Areu = new areu();
  private arfa jdField_a_of_type_Arfa = new arfa();
  protected List<String> a;
  
  public arev()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(3);
  }
  
  public static final arev a()
  {
    return arex.a();
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.SDCARD_PATH);
    localStringBuilder.append("emoji");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("res");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    switch (paramInt)
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      localStringBuilder.append("sysface_res/gif");
      continue;
      localStringBuilder.append("sysface_res/static");
      continue;
      localStringBuilder.append("emoji_res");
    }
  }
  
  public static String b()
  {
    try
    {
      Object localObject = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/qq_emoticon_res");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath() + File.separator;
      return localObject;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "npe:", localNullPointerException);
    }
    return "/qq_emoticon_res";
  }
  
  protected int a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return 101;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return 103;
    }
    File localFile = new File(paramString1);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQSysAndEmojiResMgr", 2, "verifyResMD5 file not exist!");
      }
      return 102;
    }
    StringBuilder localStringBuilder = null;
    try
    {
      paramString1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString1));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("verifyResMD5 configMd5:").append(paramString2).append(", calMd5:").append(paramString1);
        QLog.d("QQSysAndEmojiResMgr", 2, localStringBuilder.toString());
      }
      if (paramString2.equalsIgnoreCase(paramString1)) {
        return 100;
      }
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      for (;;)
      {
        try
        {
          paramString1 = bjkf.a(localFile);
        }
        catch (Exception paramString1)
        {
          paramString1 = localStringBuilder;
        }
        return 104;
      }
    }
  }
  
  public QQSysAndEmojiResInfo a(int paramInt)
  {
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_Arfa;
        return localObject1;
      }
      finally {}
      if (paramInt != 2) {
        continue;
      }
      Object localObject1 = this.jdField_a_of_type_Areu;
    }
    throw new IllegalArgumentException("not support such type:" + paramInt);
  }
  
  protected List<arew> a()
  {
    aqbu localaqbu = (aqbu)apub.a().a(545);
    ArrayList localArrayList = new ArrayList(3);
    if ((!TextUtils.isEmpty(localaqbu.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localaqbu.b)) && (a(1, localaqbu.b))) {
      localArrayList.add(new arew(localaqbu.jdField_a_of_type_JavaLangString, localaqbu.b, 1));
    }
    if ((!TextUtils.isEmpty(localaqbu.c)) && (!TextUtils.isEmpty(localaqbu.d)) && (a(2, localaqbu.d))) {
      localArrayList.add(new arew(localaqbu.c, localaqbu.d, 2));
    }
    if ((!TextUtils.isEmpty(localaqbu.e)) && (!TextUtils.isEmpty(localaqbu.f)) && (a(3, localaqbu.f))) {
      localArrayList.add(new arew(localaqbu.e, localaqbu.f, 3));
    }
    return localArrayList;
  }
  
  public void a()
  {
    for (;;)
    {
      arew localarew;
      try
      {
        Iterator localIterator = a().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localarew = (arew)localIterator.next();
        String str = localarew.a();
        if (this.jdField_a_of_type_JavaUtilList.contains(str))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QQSysAndEmojiResMgr", 2, "alreary in download list!");
          continue;
        }
        this.jdField_a_of_type_JavaUtilList.add(str);
      }
      finally {}
      a(localarew);
    }
  }
  
  protected void a(arew paramarew)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramarew.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = (a() + paramarew.c);
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.setUserData(paramarew);
    try
    {
      paramarew = BaseApplicationImpl.getApplication().getRuntime();
      if (QQAppInterface.class.isInstance(paramarew)) {
        ((QQAppInterface)paramarew).getNetEngine(0).sendReq(localHttpNetReq);
      }
      return;
    }
    catch (Exception paramarew) {}
  }
  
  protected void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  protected boolean a(int paramInt, String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getSharedPreferences("qq_emoticon_sp", 4).getString("md5_type_" + paramInt, "");
    if (!str.equals(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "type:", Integer.valueOf(paramInt), " ,needDownload:", Boolean.valueOf(bool), " ,curr:", str, " ,new:", paramString });
      }
      return bool;
    }
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    try
    {
      npo.a(new File(paramString1), paramString2);
      return true;
    }
    catch (IOException paramString1)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "unzipFile error ", paramString1);
    }
    return false;
  }
  
  protected void b()
  {
    QQSysAndEmojiResInfo.a(b());
    this.jdField_a_of_type_Arfa.a();
    this.jdField_a_of_type_Areu.a();
  }
  
  protected boolean b(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_emoticon_sp", 4).edit();
    localEditor.putString("md5_type_" + paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "saveResItem:", Integer.valueOf(paramInt), " ,md5:", paramString });
    }
    return localEditor.commit();
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = paramNetResp.mReq;
    String str = ((NetReq)localObject).mOutPath;
    localObject = (arew)((NetReq)localObject).getUserData();
    if (localObject == null)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (paramNetResp.mResult == 0)
    {
      i = a(str, ((arew)localObject).b);
      if (i != 100) {
        break label263;
      }
      if (a(str, b()))
      {
        b(((arew)localObject).jdField_a_of_type_Int, ((arew)localObject).b);
        if (((arew)localObject).jdField_a_of_type_Int != 1) {
          break label223;
        }
        b();
      }
    }
    label263:
    for (;;)
    {
      a(str);
      str = ((arew)localObject).a();
      this.jdField_a_of_type_JavaUtilList.remove(str);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "onResp:", Integer.valueOf(paramNetResp.mResult), " ,type:", Integer.valueOf(((arew)localObject).jdField_a_of_type_Int), " ,cost:", Long.valueOf(System.currentTimeMillis() - l), " ,signature:", str.substring(str.lastIndexOf(47)) });
      return;
      label223:
      if (((arew)localObject).jdField_a_of_type_Int == 2)
      {
        a(1).d();
      }
      else if (((arew)localObject).jdField_a_of_type_Int == 3)
      {
        a(2).d();
        continue;
        QLog.e("QQSysAndEmojiResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arev
 * JD-Core Version:    0.7.0.1
 */