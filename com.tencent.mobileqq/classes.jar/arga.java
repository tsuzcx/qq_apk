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

public class arga
  implements arfv, Manager
{
  public Handler a;
  public argh a;
  public batr a;
  public QQAppInterface a;
  public HashMap<Long, Boolean> a;
  ConcurrentHashMap<String, argk> a;
  
  @SuppressLint({"UseSparseArrays"})
  public arga(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = a(this);
    this.jdField_a_of_type_Argh = new argh();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Batr = ((bato)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
  }
  
  public static Handler a(arfv paramarfv)
  {
    return new argf(paramarfv);
  }
  
  arfx a(String paramString, int paramInt, boolean paramBoolean)
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
    if ((paramString instanceof arfx)) {}
    for (paramString = (arfx)paramString;; paramString = null)
    {
      if ((paramString == null) || (paramBoolean) || (!paramString.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
        }
        ((argk)localObject).jdField_a_of_type_Boolean = paramBoolean;
        localObject = new arfx((argk)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        BaseApplicationImpl.sImageCache.put(str, localObject);
        ((arfx)localObject).a(paramInt);
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
  
  public argk a(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      localObject = null;
    }
    argk localargk;
    do
    {
      return localObject;
      localargk = (argk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = localargk;
    } while (localargk != null);
    return b(paramString);
  }
  
  @SuppressLint({"InlinedApi"})
  void a(adjt paramadjt, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramadjt.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramadjt = (RelativeLayout.LayoutParams)paramadjt.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    paramadjt.width = i;
    paramadjt.height = j;
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
        paramMessage = (argg)paramMessage.obj;
        paramMessage.jdField_a_of_type_Adjt.jdField_e_of_type_Int = paramMessage.jdField_a_of_type_Int;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.jdField_a_of_type_Int != 1);
      c(paramMessage);
      return;
      paramMessage = (argg)paramMessage.obj;
      paramMessage.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (argg)paramMessage.obj;
      paramMessage.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_Adjt.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846018);
      return;
      paramMessage = (argg)paramMessage.obj;
    } while (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_Adjt.jdField_a_of_type_Long);
    paramMessage.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramMessage.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessage.jdField_a_of_type_Adjt.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
  }
  
  void a(argg paramargg)
  {
    if ((paramargg != null) && (paramargg.jdField_a_of_type_Adjt != null) && (paramargg.jdField_a_of_type_Long == paramargg.jdField_a_of_type_Adjt.jdField_a_of_type_Long) && (paramargg.jdField_a_of_type_Arge != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramargg.jdField_a_of_type_Arge.a(true);
    }
  }
  
  public void a(String paramString, adjt paramadjt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, arge paramarge)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramadjt == null)) {
      if (paramarge != null) {
        paramarge.a(true);
      }
    }
    for (;;)
    {
      return;
      a(paramadjt, paramBoolean2);
      argg localargg = new argg(this);
      localargg.jdField_a_of_type_Arge = paramarge;
      localargg.jdField_a_of_type_JavaLangString = paramadjt.jdField_a_of_type_Anla.a.epId;
      localargg.jdField_a_of_type_Adjt = paramadjt;
      localargg.jdField_a_of_type_Long = paramLong;
      localargg.jdField_a_of_type_Boolean = paramBoolean1;
      localargg.b = argh.b(paramString);
      if (localargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        localargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetImageView == null) {
        localargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = argh.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + localargg.b + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramadjt.jdField_e_of_type_Int = i;
      switch (i)
      {
      }
      while ((localargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PngFrameManager.1(this, localargg), 1000L);
        return;
        a(localargg);
        continue;
        c(localargg);
        continue;
        b(localargg);
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
    //   3: getfield 61	arga:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 58	java/util/HashMap
    //   13: dup
    //   14: invokespecial 59	java/util/HashMap:<init>	()V
    //   17: putfield 61	arga:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   20: aload_0
    //   21: getfield 61	arga:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: lload_1
    //   25: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 356	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 358	java/lang/Boolean
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: getfield 46	arga:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   41: ifnull +29 -> 70
    //   44: aload_0
    //   45: getfield 46	arga:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   48: new 360	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: invokespecial 363	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5:<init>	(Larga;J)V
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
    //   0	82	0	this	arga
    //   0	82	1	paramLong	long
    //   65	7	3	bool	boolean
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   20	64	75	finally
  }
  
  public argk b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    argk localargk;
    do
    {
      return localObject;
      localargk = this.jdField_a_of_type_Argh.a(paramString);
      localObject = localargk;
    } while (localargk == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localargk);
    return localargk;
  }
  
  void b(argg paramargg)
  {
    paramargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramargg.jdField_a_of_type_Adjt.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846017);
    ThreadManager.post(new PngFrameManager.2(this, paramargg), 5, null, true);
  }
  
  void c(argg paramargg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + paramargg);
    }
    if (new File(anjd.z.replace("[epId]", paramargg.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramargg);
      return;
    }
    int i = badq.a(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramargg);
      return;
    }
    paramargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramargg.jdField_a_of_type_Adjt.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846017);
    e(paramargg);
  }
  
  void d(argg paramargg)
  {
    String str = anjd.q.replace("[epId]", paramargg.jdField_a_of_type_JavaLangString).replace("[eId]", paramargg.jdField_a_of_type_Adjt.jdField_a_of_type_Anla.a.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramargg.jdField_a_of_type_JavaLangObject = localBitmap;
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, paramargg).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramargg.jdField_a_of_type_Adjt.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846017);
    ThreadManager.post(new PngFrameManager.3(this, str, paramargg), 5, null, true);
  }
  
  void e(argg paramargg)
  {
    ThreadManager.post(new PngFrameManager.4(this, paramargg), 5, null, true);
  }
  
  void f(argg paramargg)
  {
    Object localObject = a(paramargg.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (!((argk)localObject).a())) {}
    do
    {
      return;
      localObject = a(paramargg.jdField_a_of_type_JavaLangString, paramargg.b, paramargg.jdField_a_of_type_Boolean);
      if ((paramargg.jdField_a_of_type_Adjt != null) && (paramargg.jdField_a_of_type_Adjt.jdField_a_of_type_Long == paramargg.jdField_a_of_type_Long)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramargg.jdField_a_of_type_Adjt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramargg.jdField_a_of_type_Adjt.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(226, paramargg).sendToTarget();
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
    this.jdField_a_of_type_Batr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arga
 * JD-Core Version:    0.7.0.1
 */