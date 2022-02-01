import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.1;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.2;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class awew
  implements awer, Manager
{
  public Handler a;
  public awfd a;
  public bhhk a;
  public QQAppInterface a;
  public HashMap<Long, Boolean> a;
  ConcurrentHashMap<String, awfg> a;
  
  @SuppressLint({"UseSparseArrays"})
  public awew(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = a(this);
    this.jdField_a_of_type_Awfd = new awfd();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bhhk = ((bhhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
  }
  
  public static Handler a(awer paramawer)
  {
    return new awfb(paramawer);
  }
  
  awet a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func getPngFrameDrawable begins,epId:" + paramString + ",pos:" + paramInt + ",showProcess:" + paramBoolean);
    }
    String str = "PngFrameManager_" + paramString + "_" + paramInt;
    Object localObject = a(paramString);
    if (localObject == null)
    {
      paramString = null;
      return paramString;
    }
    paramString = BaseApplicationImpl.sImageCache.get(str);
    if ((paramString instanceof awet)) {}
    for (paramString = (awet)paramString;; paramString = null)
    {
      if ((paramString == null) || (paramBoolean) || (!paramString.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
        }
        ((awfg)localObject).jdField_a_of_type_Boolean = paramBoolean;
        localObject = new awet((awfg)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        BaseApplicationImpl.sImageCache.put(str, localObject);
        ((awet)localObject).a(paramInt);
      }
      for (;;)
      {
        paramString = (String)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PngFrameManager", 2, "func getPngFrameDrawable ends");
        return localObject;
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, drawable exists in map,pos:" + paramInt);
          localObject = paramString;
        }
      }
    }
  }
  
  public awfg a(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      localObject = null;
    }
    awfg localawfg;
    do
    {
      return localObject;
      localawfg = (awfg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = localawfg;
    } while (localawfg != null);
    return b(paramString);
  }
  
  @SuppressLint({"InlinedApi"})
  void a(ahcu paramahcu, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramahcu.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramahcu = (RelativeLayout.LayoutParams)paramahcu.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    paramahcu.width = i;
    paramahcu.height = j;
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        paramMessage = (awfc)paramMessage.obj;
        paramMessage.jdField_a_of_type_Ahcu.jdField_e_of_type_Int = paramMessage.jdField_a_of_type_Int;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.jdField_a_of_type_Int != 1);
      c(paramMessage);
      return;
      paramMessage = (awfc)paramMessage.obj;
      paramMessage.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (awfc)paramMessage.obj;
      paramMessage.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_Ahcu.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847099);
      return;
      paramMessage = (awfc)paramMessage.obj;
    } while (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_Ahcu.jdField_a_of_type_Long);
    paramMessage.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramMessage.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessage.jdField_a_of_type_Ahcu.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
  }
  
  void a(awfc paramawfc)
  {
    if ((paramawfc != null) && (paramawfc.jdField_a_of_type_Ahcu != null) && (paramawfc.jdField_a_of_type_Long == paramawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_Long) && (paramawfc.jdField_a_of_type_Awfa != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramawfc.jdField_a_of_type_Awfa.a(true);
    }
  }
  
  public void a(String paramString, ahcu paramahcu, long paramLong, boolean paramBoolean1, boolean paramBoolean2, awfa paramawfa)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramahcu == null)) {
      if (paramawfa != null) {
        paramawfa.a(true);
      }
    }
    for (;;)
    {
      return;
      a(paramahcu, paramBoolean2);
      awfc localawfc = new awfc(this);
      localawfc.jdField_a_of_type_Awfa = paramawfa;
      localawfc.jdField_a_of_type_JavaLangString = paramahcu.jdField_a_of_type_Asbq.a.epId;
      localawfc.jdField_a_of_type_Ahcu = paramahcu;
      localawfc.jdField_a_of_type_Long = paramLong;
      localawfc.jdField_a_of_type_Boolean = paramBoolean1;
      localawfc.b = awfd.b(paramString);
      if (localawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        localawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetImageView == null) {
        localawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = awfd.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + localawfc.b + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramahcu.jdField_e_of_type_Int = i;
      switch (i)
      {
      }
      while ((localawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PngFrameManager.1(this, localawfc), 1000L);
        return;
        a(localawfc);
        continue;
        c(localawfc);
        continue;
        b(localawfc);
      }
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	awew:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 58	java/util/HashMap
    //   13: dup
    //   14: invokespecial 59	java/util/HashMap:<init>	()V
    //   17: putfield 61	awew:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   20: aload_0
    //   21: getfield 61	awew:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: lload_1
    //   25: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 356	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 358	java/lang/Boolean
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: getfield 46	awew:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   41: ifnull +29 -> 70
    //   44: aload_0
    //   45: getfield 46	awew:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   48: new 360	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: invokespecial 363	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5:<init>	(Lawew;J)V
    //   57: ldc2_w 364
    //   60: invokevirtual 346	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   63: pop
    //   64: iconst_1
    //   65: istore_3
    //   66: aload_0
    //   67: monitorexit
    //   68: iload_3
    //   69: ireturn
    //   70: iconst_0
    //   71: istore_3
    //   72: goto -6 -> 66
    //   75: astore 4
    //   77: aload_0
    //   78: monitorexit
    //   79: aload 4
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	awew
    //   0	82	1	paramLong	long
    //   65	7	3	bool	boolean
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   20	64	75	finally
  }
  
  public awfg b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    awfg localawfg;
    do
    {
      return localObject;
      localawfg = this.jdField_a_of_type_Awfd.a(paramString);
      localObject = localawfg;
    } while (localawfg == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localawfg);
    return localawfg;
  }
  
  void b(awfc paramawfc)
  {
    paramawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramawfc.jdField_a_of_type_Ahcu.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847098);
    ThreadManager.post(new PngFrameManager.2(this, paramawfc), 5, null, true);
  }
  
  void c(awfc paramawfc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + paramawfc);
    }
    if (new File(arze.z.replace("[epId]", paramawfc.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramawfc);
      return;
    }
    int i = bgnt.a(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramawfc);
      return;
    }
    paramawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramawfc.jdField_a_of_type_Ahcu.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847098);
    e(paramawfc);
  }
  
  void d(awfc paramawfc)
  {
    String str = arze.q.replace("[epId]", paramawfc.jdField_a_of_type_JavaLangString).replace("[eId]", paramawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_Asbq.a.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramawfc.jdField_a_of_type_JavaLangObject = localBitmap;
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, paramawfc).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramawfc.jdField_a_of_type_Ahcu.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847098);
    ThreadManager.post(new PngFrameManager.3(this, str, paramawfc), 5, null, true);
  }
  
  void e(awfc paramawfc)
  {
    ThreadManager.post(new PngFrameManager.4(this, paramawfc), 5, null, true);
  }
  
  void f(awfc paramawfc)
  {
    Object localObject = a(paramawfc.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (!((awfg)localObject).a())) {}
    do
    {
      return;
      localObject = a(paramawfc.jdField_a_of_type_JavaLangString, paramawfc.b, paramawfc.jdField_a_of_type_Boolean);
      if ((paramawfc.jdField_a_of_type_Ahcu != null) && (paramawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_Long == paramawfc.jdField_a_of_type_Long)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramawfc.jdField_a_of_type_Ahcu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramawfc.jdField_a_of_type_Ahcu.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(226, paramawfc).sendToTarget();
      }
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【onDestroy】  ");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Bhhk = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awew
 * JD-Core Version:    0.7.0.1
 */