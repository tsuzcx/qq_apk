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

public class apsj
  implements baug
{
  private apsh jdField_a_of_type_Apsh = new apsh();
  private apso jdField_a_of_type_Apso = new apso();
  protected List<String> a;
  
  public apsj()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(3);
  }
  
  public static final apsj a()
  {
    return apsl.a();
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(alof.aX);
    localStringBuilder.append("emoji");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("res");
    localStringBuilder.append(File.separator);
    return bdzf.a(localStringBuilder.toString());
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
          paramString1 = bhpp.a(localFile);
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
        localObject1 = this.jdField_a_of_type_Apso;
        return localObject1;
      }
      finally {}
      if (paramInt != 2) {
        continue;
      }
      Object localObject1 = this.jdField_a_of_type_Apsh;
    }
    throw new IllegalArgumentException("not support such type:" + paramInt);
  }
  
  protected List<apsk> a()
  {
    aoqv localaoqv = (aoqv)aoks.a().a(545);
    ArrayList localArrayList = new ArrayList(3);
    if ((!TextUtils.isEmpty(localaoqv.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localaoqv.b)) && (a(1, localaoqv.b))) {
      localArrayList.add(new apsk(localaoqv.jdField_a_of_type_JavaLangString, localaoqv.b, 1));
    }
    if ((!TextUtils.isEmpty(localaoqv.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(localaoqv.d)) && (a(2, localaoqv.d))) {
      localArrayList.add(new apsk(localaoqv.jdField_c_of_type_JavaLangString, localaoqv.d, 2));
    }
    if ((!TextUtils.isEmpty(localaoqv.e)) && (!TextUtils.isEmpty(localaoqv.f)) && (a(3, localaoqv.f))) {
      localArrayList.add(new apsk(localaoqv.e, localaoqv.f, 3));
    }
    return localArrayList;
  }
  
  public void a()
  {
    for (;;)
    {
      apsk localapsk;
      try
      {
        Iterator localIterator = a().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localapsk = (apsk)localIterator.next();
        String str = localapsk.a();
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
      a(localapsk);
    }
  }
  
  protected void a(apsk paramapsk)
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_JavaLangString = paramapsk.jdField_a_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_c_of_type_JavaLangString = (a() + paramapsk.jdField_c_of_type_JavaLangString);
    localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
    localbaub.a(paramapsk);
    try
    {
      paramapsk = BaseApplicationImpl.getApplication().getRuntime();
      if (QQAppInterface.class.isInstance(paramapsk)) {
        ((QQAppInterface)paramapsk).getNetEngine(0).a(localbaub);
      }
      return;
    }
    catch (Exception paramapsk) {}
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
    this.jdField_a_of_type_Apso.a();
    this.jdField_a_of_type_Apsh.a();
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
  
  public void onResp(bavf parambavf)
  {
    Object localObject = parambavf.jdField_a_of_type_Bave;
    String str = ((bave)localObject).jdField_c_of_type_JavaLangString;
    localObject = (apsk)((bave)localObject).a();
    if (localObject == null)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      i = a(str, ((apsk)localObject).b);
      if (i != 100) {
        break label263;
      }
      if (a(str, b()))
      {
        b(((apsk)localObject).jdField_a_of_type_Int, ((apsk)localObject).b);
        if (((apsk)localObject).jdField_a_of_type_Int != 1) {
          break label223;
        }
        b();
      }
    }
    label263:
    for (;;)
    {
      a(str);
      str = ((apsk)localObject).a();
      this.jdField_a_of_type_JavaUtilList.remove(str);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "onResp:", Integer.valueOf(parambavf.jdField_a_of_type_Int), " ,type:", Integer.valueOf(((apsk)localObject).jdField_a_of_type_Int), " ,cost:", Long.valueOf(System.currentTimeMillis() - l), " ,signature:", str.substring(str.lastIndexOf(47)) });
      return;
      label223:
      if (((apsk)localObject).jdField_a_of_type_Int == 2)
      {
        a(1).d();
      }
      else if (((apsk)localObject).jdField_a_of_type_Int == 3)
      {
        a(2).d();
        continue;
        QLog.e("QQSysAndEmojiResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsj
 * JD-Core Version:    0.7.0.1
 */