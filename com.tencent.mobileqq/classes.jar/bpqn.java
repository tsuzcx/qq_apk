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
public class bpqn
  extends bpli
{
  private static File jdField_a_of_type_JavaIoFile = new File(bpup.a(), "information_paster");
  private static String jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaIoFile.getPath() + File.separator;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bpqr a;
  private WeakReference<RelativeLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentLinkedQueue<bqpa> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public bpqn()
  {
    this.jdField_a_of_type_Bpqr = null;
    this.jdField_a_of_type_Bpqr = new bpqr(this);
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(bqpa parambqpa)
  {
    parambqpa = parambqpa.g + "_" + parambqpa.f + ".zip";
    return new File(jdField_a_of_type_JavaIoFile, parambqpa).getPath();
  }
  
  public static String b(bqpa parambqpa)
  {
    return jdField_a_of_type_JavaLangString + parambqpa.g + "_" + parambqpa.f + File.separator + parambqpa.g;
  }
  
  private boolean d(bqpa parambqpa)
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
        if (str.startsWith(parambqpa.g))
        {
          if (!str.endsWith(".zip")) {
            break label151;
          }
          bhmi.a(jdField_a_of_type_JavaIoFile + str, false);
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
        if (str.endsWith(parambqpa.f))
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
              bhmi.a(jdField_a_of_type_JavaLangString + str, false);
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
  
  public void a(bqpa parambqpa, bpqq parambpqq)
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "network is unavailable");
      }
      return;
    }
    ThreadManager.postImmediately(new QIMInformationPasterManager.1(this, parambqpa, parambpqq), null, true);
  }
  
  public void a(DoodleEmojiItem paramDoodleEmojiItem)
  {
    paramDoodleEmojiItem = paramDoodleEmojiItem.mInfoItemList.iterator();
    while (paramDoodleEmojiItem.hasNext())
    {
      bqpa localbqpa = (bqpa)paramDoodleEmojiItem.next();
      if ((localbqpa.b == 1) && (!a(localbqpa))) {
        a(localbqpa, new bpqp(this));
      }
    }
  }
  
  public void a(List<bqpa> paramList)
  {
    ThreadManager.postImmediately(new QIMInformationPasterManager.2(this, paramList), null, true);
  }
  
  public boolean a(bqpa parambqpa)
  {
    if (TextUtils.isEmpty(parambqpa.e)) {
      if (parambqpa.a != 7) {}
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
        } while (!d(parambqpa));
        localObject = b(parambqpa);
        if (QLog.isColorLevel()) {
          QLog.d("QIMInformationPasterManager", 2, "checkDir:" + (String)localObject);
        }
        localObject = new File((String)localObject);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      localObject = ((File)localObject).list();
    } while ((localObject == null) || (localObject.length != bqpb.a(parambqpa)));
    return true;
  }
  
  public void b() {}
  
  public boolean b(bqpa parambqpa)
  {
    return this.jdField_a_of_type_Bpqr.a(parambqpa.e);
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
  
  public boolean c(bqpa parambqpa)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + parambqpa.g + "_" + parambqpa.f);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "unzipDir:" + localFile.getAbsolutePath());
      }
      nof.a(new File(a(parambqpa)), localFile.getAbsolutePath() + File.separator);
      bool = true;
    }
    catch (Exception parambqpa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QIMInformationPasterManager", 2, parambqpa, new Object[0]);
    }
    return bool;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqn
 * JD-Core Version:    0.7.0.1
 */