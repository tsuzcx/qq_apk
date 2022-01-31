import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anwm
  implements aysa
{
  private anwl jdField_a_of_type_Anwl = new anwl();
  private anwp jdField_a_of_type_Anwp = new anwp();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList(3);
  
  private static int a(String paramString1, String paramString2)
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
          paramString1 = bfjx.a(localFile);
        }
        catch (Exception paramString1)
        {
          paramString1 = localStringBuilder;
        }
        return 104;
      }
    }
  }
  
  public static final anwm a()
  {
    return anwo.a();
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(ajsf.aW);
    localStringBuilder.append("emoji");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("res");
    localStringBuilder.append(File.separator);
    return bbuv.a(localStringBuilder.toString());
  }
  
  private List<anwn> a()
  {
    amvi localamvi = (amvi)ampm.a().a(545);
    ArrayList localArrayList = new ArrayList(3);
    if ((!TextUtils.isEmpty(localamvi.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localamvi.b)) && (a(1, localamvi.b))) {
      localArrayList.add(new anwn(this, localamvi.jdField_a_of_type_JavaLangString, localamvi.b, 1));
    }
    if ((!TextUtils.isEmpty(localamvi.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(localamvi.d)) && (a(2, localamvi.d))) {
      localArrayList.add(new anwn(this, localamvi.jdField_c_of_type_JavaLangString, localamvi.d, 2));
    }
    if ((!TextUtils.isEmpty(localamvi.e)) && (!TextUtils.isEmpty(localamvi.f)) && (a(3, localamvi.f))) {
      localArrayList.add(new anwn(this, localamvi.e, localamvi.f, 3));
    }
    return localArrayList;
  }
  
  private void a(anwn paramanwn)
  {
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = this;
    localayrv.jdField_a_of_type_JavaLangString = paramanwn.jdField_a_of_type_JavaLangString;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.jdField_c_of_type_JavaLangString = (a() + paramanwn.jdField_c_of_type_JavaLangString);
    localayrv.jdField_c_of_type_Int = bbev.a(aysy.a().a());
    localayrv.a(paramanwn);
    try
    {
      paramanwn = BaseApplicationImpl.getApplication().getRuntime();
      if (QQAppInterface.class.isInstance(paramanwn)) {
        ((QQAppInterface)paramanwn).getNetEngine(0).a(localayrv);
      }
      return;
    }
    catch (Exception paramanwn) {}
  }
  
  private static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private boolean a(int paramInt, String paramString)
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
  
  public static String b()
  {
    File localFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/qq_emoticon_res");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator;
  }
  
  private void b()
  {
    QQSysAndEmojiBaseInfo.b();
    this.jdField_a_of_type_Anwp.a();
    this.jdField_a_of_type_Anwl.a();
  }
  
  private boolean b(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_emoticon_sp", 4).edit();
    localEditor.putString("md5_type_" + paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "saveResItem:", Integer.valueOf(paramInt), " ,md5:", paramString });
    }
    return localEditor.commit();
  }
  
  public QQSysAndEmojiBaseInfo a(int paramInt)
  {
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_Anwp;
        return localObject1;
      }
      finally {}
      if (paramInt != 2) {
        continue;
      }
      Object localObject1 = this.jdField_a_of_type_Anwl;
    }
    throw new IllegalArgumentException("not support such type:" + paramInt);
  }
  
  public void a()
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      anwn localanwn = (anwn)localIterator.next();
      String str = localanwn.a();
      if (this.jdField_a_of_type_JavaUtilList.contains(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSysAndEmojiResMgr", 2, "alreary in download list!");
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.add(str);
        a(localanwn);
      }
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    Object localObject = paramaysx.jdField_a_of_type_Aysw;
    String str = ((aysw)localObject).jdField_c_of_type_JavaLangString;
    localObject = (anwn)((aysw)localObject).a();
    if (localObject == null)
    {
      QLog.e("QQSysAndEmojiResMgr", 1, "DownloadResItem is null!");
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      i = a(str, ((anwn)localObject).b);
      if (i != 100) {
        break label240;
      }
    }
    for (;;)
    {
      try
      {
        nay.a(new File(str), b());
        b(((anwn)localObject).jdField_a_of_type_Int, ((anwn)localObject).b);
        if (((anwn)localObject).jdField_a_of_type_Int == 1) {
          b();
        }
        a(str);
        str = ((anwn)localObject).a();
        this.jdField_a_of_type_JavaUtilList.remove(str);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQSysAndEmojiResMgr", 2, new Object[] { "onResp:", Integer.valueOf(paramaysx.jdField_a_of_type_Int), " ,type:", Integer.valueOf(((anwn)localObject).jdField_a_of_type_Int), " ,cost:", Long.valueOf(System.currentTimeMillis() - l), " ,signature:", str.substring(str.lastIndexOf(47)) });
        return;
      }
      catch (IOException localIOException)
      {
        QLog.e("QQSysAndEmojiResMgr", 1, "onResp error ", localIOException);
        continue;
      }
      label240:
      QLog.e("QQSysAndEmojiResMgr", 1, new Object[] { "verifyResMD5 failed! ", Integer.valueOf(i) });
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anwm
 * JD-Core Version:    0.7.0.1
 */