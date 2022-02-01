import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.1;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.2;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(16)
public class bojy
  extends bogb
{
  private static File jdField_a_of_type_JavaIoFile = new File(bonn.a(), "information_paster");
  private static String jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bokc a;
  private WeakReference<RelativeLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentLinkedQueue<bpba> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bojy()
  {
    this.jdField_a_of_type_Bokc = null;
    this.jdField_a_of_type_Bokc = new bokc(this);
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(bpba parambpba)
  {
    parambpba = parambpba.g + "_" + parambpba.f + ".zip";
    return new File(jdField_a_of_type_JavaIoFile, parambpba).getPath();
  }
  
  public static String b(bpba parambpba)
  {
    return jdField_a_of_type_JavaLangString + parambpba.g + "_" + parambpba.f + File.separator + parambpba.g;
  }
  
  private boolean d(bpba parambpba)
  {
    if (jdField_a_of_type_JavaIoFile != null)
    {
      int i;
      boolean bool1;
      label44:
      String str;
      if (!jdField_a_of_type_JavaIoFile.exists())
      {
        jdField_a_of_type_JavaIoFile.mkdirs();
        String[] arrayOfString = jdField_a_of_type_JavaIoFile.list();
        if (arrayOfString == null) {
          break label229;
        }
        int j = arrayOfString.length;
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i >= j) {
          break label232;
        }
        str = arrayOfString[i];
        bool2 = bool1;
        if (str.startsWith(parambpba.g))
        {
          if (!str.endsWith(".zip")) {
            break label151;
          }
          FileUtils.delete(jdField_a_of_type_JavaIoFile + str, false);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        break label44;
        if (jdField_a_of_type_JavaIoFile.isDirectory()) {
          break;
        }
        jdField_a_of_type_JavaIoFile.delete();
        jdField_a_of_type_JavaIoFile.mkdirs();
        break;
        label151:
        if (str.endsWith(parambpba.f))
        {
          bool2 = true;
        }
        else
        {
          bool2 = bool1;
          if (!str.endsWith("png"))
          {
            bool2 = bool1;
            if (!str.endsWith("tmp"))
            {
              FileUtils.delete(jdField_a_of_type_JavaLangString + str, false);
              bool2 = bool1;
            }
          }
        }
      }
      label229:
      boolean bool2 = false;
      label232:
      return bool2;
    }
    return false;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localRelativeLayout != null)
      {
        localRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      }
    }
  }
  
  public void a(bpba parambpba, bokb parambokb)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
      return;
    }
    ThreadManager.postImmediately(new QIMInformationPasterManager.1(this, parambpba, parambokb), null, true);
  }
  
  public void a(DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramDoodleEmojiItem = paramDoodleEmojiItem.mInfoItemList.iterator();
    while (paramDoodleEmojiItem.hasNext())
    {
      bpba localbpba = (bpba)paramDoodleEmojiItem.next();
      if ((localbpba.b == 1) && (!a(localbpba))) {
        a(localbpba, new boka(this));
      }
    }
  }
  
  public void a(List<bpba> paramList)
  {
    ThreadManager.postImmediately(new QIMInformationPasterManager.2(this, paramList), null, true);
  }
  
  public boolean a(bpba parambpba)
  {
    if (TextUtils.isEmpty(parambpba.e)) {
      if (parambpba.a != 7) {}
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          return true;
        } while (!d(parambpba));
        localObject = b(parambpba);
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, "checkDir:" + (String)localObject);
        }
        localObject = new File((String)localObject);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = ((File)localObject).list();
    } while ((localObject == null) || (localObject.length != bpbb.a(parambpba)));
    return true;
  }
  
  public boolean b(bpba parambpba)
  {
    return this.jdField_a_of_type_Bokc.a(parambpba.e);
  }
  
  public boolean c(bpba parambpba)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + parambpba.g + "_" + parambpba.f);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "unzipDir:" + localFile.getAbsolutePath());
      }
      nwp.a(new File(a(parambpba)), localFile.getAbsolutePath() + File.separator);
      bool = true;
    }
    catch (Exception parambpba)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QIMInformationPasterManager", 2, parambpba, new Object[0]);
    }
    return bool;
    return false;
  }
  
  public void onDestroy() {}
  
  public void onInit()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojy
 * JD-Core Version:    0.7.0.1
 */