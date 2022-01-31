import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apoa
  implements bapx
{
  private apny jdField_a_of_type_Apny = new apny();
  private apof jdField_a_of_type_Apof = new apof();
  protected List<String> a;
  
  public apoa()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(3);
  }
  
  public static final apoa a()
  {
    return apoc.a();
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(aljq.aX);
    localStringBuilder.append("emoji");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("res");
    localStringBuilder.append(File.separator);
    return bduw.a(localStringBuilder.toString());
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
          paramString1 = bhli.a(localFile);
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
        localObject1 = this.jdField_a_of_type_Apof;
        return localObject1;
      }
      finally {}
      if (paramInt != 2) {
        continue;
      }
      Object localObject1 = this.jdField_a_of_type_Apny;
    }
    throw new IllegalArgumentException("not support such type:" + paramInt);
  }
  
  protected List<apob> a()
  {
    aomm localaomm = (aomm)aogj.a().a(545);
    ArrayList localArrayList = new ArrayList(3);
    if ((!TextUtils.isEmpty(localaomm.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localaomm.b)) && (a(1, localaomm.b))) {
      localArrayList.add(new apob(localaomm.jdField_a_of_type_JavaLangString, localaomm.b, 1));
    }
    if ((!TextUtils.isEmpty(localaomm.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(localaomm.d)) && (a(2, localaomm.d))) {
      localArrayList.add(new apob(localaomm.jdField_c_of_type_JavaLangString, localaomm.d, 2));
    }
    if ((!TextUtils.isEmpty(localaomm.e)) && (!TextUtils.isEmpty(localaomm.f)) && (a(3, localaomm.f))) {
      localArrayList.add(new apob(localaomm.e, localaomm.f, 3));
    }
    return localArrayList;
  }
  
  public void a()
  {
    for (;;)
    {
      apob localapob;
      try
      {
        Iterator localIterator = a().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localapob = (apob)localIterator.next();
        String str = localapob.a();
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
      a(localapob);
    }
  }
  
  protected void a(apob paramapob)
  {
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = this;
    localbaps.jdField_a_of_type_JavaLangString = paramapob.jdField_a_of_type_JavaLangString;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_c_of_type_JavaLangString = (a() + paramapob.jdField_c_of_type_JavaLangString);
    localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
    localbaps.a(paramapob);
    try
    {
      paramapob = BaseApplicationImpl.getApplication().getRuntime();
      if (QQAppInterface.class.isInstance(paramapob)) {
        ((QQAppInterface)paramapob).getNetEngine(0).a(localbaps);
      }
      return;
    }
    catch (Exception paramapob) {}
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
      ndr.a(new File(paramString1), paramString2);
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
    this.jdField_a_of_type_Apof.a();
    this.jdField_a_of_type_Apny.a();
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
  
  public void onResp(baqw parambaqw)
  {
    Object localObject = parambaqw.jdField_a_of_type_Baqv;
    String str = ((baqv)localObject).jdField_c_of_type_JavaLangString;
    localObject = (apob)((baqv)localObject).a();
    if (localObject == null)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      i = a(str, ((apob)localObject).b);
      if (i != 100) {
        break label263;
      }
      if (a(str, b()))
      {
        b(((apob)localObject).jdField_a_of_type_Int, ((apob)localObject).b);
        if (((apob)localObject).jdField_a_of_type_Int != 1) {
          break label223;
        }
        b();
      }
    }
    label263:
    for (;;)
    {
      a(str);
      str = ((apob)localObject).a();
      this.jdField_a_of_type_JavaUtilList.remove(str);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "onResp:", Integer.valueOf(parambaqw.jdField_a_of_type_Int), " ,type:", Integer.valueOf(((apob)localObject).jdField_a_of_type_Int), " ,cost:", Long.valueOf(System.currentTimeMillis() - l), " ,signature:", str.substring(str.lastIndexOf(47)) });
      return;
      label223:
      if (((apob)localObject).jdField_a_of_type_Int == 2)
      {
        a(1).d();
      }
      else if (((apob)localObject).jdField_a_of_type_Int == 3)
      {
        a(2).d();
        continue;
        QLog.e("QQSysAndEmojiResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apoa
 * JD-Core Version:    0.7.0.1
 */