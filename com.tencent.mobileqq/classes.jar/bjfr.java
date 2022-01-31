import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
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
public class bjfr
  extends bjan
{
  private static File jdField_a_of_type_JavaIoFile = new File(bjjt.a(), "information_paster");
  private static String jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bjfv a;
  private WeakReference<RelativeLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentLinkedQueue<bkgd> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bjfr()
  {
    this.jdField_a_of_type_Bjfv = null;
    this.jdField_a_of_type_Bjfv = new bjfv(this);
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(bkgd parambkgd)
  {
    parambkgd = parambkgd.g + "_" + parambkgd.f + ".zip";
    return new File(jdField_a_of_type_JavaIoFile, parambkgd).getPath();
  }
  
  public static String b(bkgd parambkgd)
  {
    return jdField_a_of_type_JavaLangString + parambkgd.g + "_" + parambkgd.f + File.separator + parambkgd.g;
  }
  
  private boolean d(bkgd parambkgd)
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
        if (str.startsWith(parambkgd.g))
        {
          if (!str.endsWith(".zip")) {
            break label151;
          }
          bbdx.a(jdField_a_of_type_JavaIoFile + str, false);
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
        if (str.endsWith(parambkgd.f))
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
              bbdx.a(jdField_a_of_type_JavaLangString + str, false);
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
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public void a(bkgd parambkgd, bjfu parambjfu)
  {
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
      return;
    }
    ThreadManager.postImmediately(new QIMInformationPasterManager.1(this, parambkgd, parambjfu), null, true);
  }
  
  public void a(DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramDoodleEmojiItem = paramDoodleEmojiItem.mInfoItemList.iterator();
    while (paramDoodleEmojiItem.hasNext())
    {
      bkgd localbkgd = (bkgd)paramDoodleEmojiItem.next();
      if ((localbkgd.b == 1) && (!a(localbkgd))) {
        a(localbkgd, new bjft(this));
      }
    }
  }
  
  public void a(List<bkgd> paramList)
  {
    ThreadManager.postImmediately(new QIMInformationPasterManager.2(this, paramList), null, true);
  }
  
  public boolean a(bkgd parambkgd)
  {
    if (TextUtils.isEmpty(parambkgd.e)) {
      if (parambkgd.a != 7) {}
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
        } while (!d(parambkgd));
        localObject = b(parambkgd);
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, "checkDir:" + (String)localObject);
        }
        localObject = new File((String)localObject);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = ((File)localObject).list();
    } while ((localObject == null) || (localObject.length != bkge.a(parambkgd)));
    return true;
  }
  
  public void b() {}
  
  public boolean b(bkgd parambkgd)
  {
    return this.jdField_a_of_type_Bjfv.a(parambkgd.e);
  }
  
  public void c()
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
  
  public boolean c(bkgd parambkgd)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + parambkgd.g + "_" + parambkgd.f);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "unzipDir:" + localFile.getAbsolutePath());
      }
      nav.a(new File(a(parambkgd)), localFile.getAbsolutePath() + File.separator);
      bool = true;
    }
    catch (Exception parambkgd)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QIMInformationPasterManager", 2, parambkgd, new Object[0]);
    }
    return bool;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfr
 * JD-Core Version:    0.7.0.1
 */