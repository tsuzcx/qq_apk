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

public class atte
  implements atsz, Manager
{
  public Handler a;
  public attl a;
  public bdwa a;
  public QQAppInterface a;
  public HashMap<Long, Boolean> a;
  ConcurrentHashMap<String, atto> a;
  
  @SuppressLint({"UseSparseArrays"})
  public atte(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = a(this);
    this.jdField_a_of_type_Attl = new attl();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bdwa = ((bdvx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
  }
  
  public static Handler a(atsz paramatsz)
  {
    return new attj(paramatsz);
  }
  
  attb a(String paramString, int paramInt, boolean paramBoolean)
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
    if ((paramString instanceof attb)) {}
    for (paramString = (attb)paramString;; paramString = null)
    {
      if ((paramString == null) || (paramBoolean) || (!paramString.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
        }
        ((atto)localObject).jdField_a_of_type_Boolean = paramBoolean;
        localObject = new attb((atto)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        BaseApplicationImpl.sImageCache.put(str, localObject);
        ((attb)localObject).a(paramInt);
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
  
  public atto a(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      localObject = null;
    }
    atto localatto;
    do
    {
      return localObject;
      localatto = (atto)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = localatto;
    } while (localatto != null);
    return b(paramString);
  }
  
  @SuppressLint({"InlinedApi"})
  void a(afrf paramafrf, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramafrf.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramafrf = (RelativeLayout.LayoutParams)paramafrf.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    paramafrf.width = i;
    paramafrf.height = j;
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
        paramMessage = (attk)paramMessage.obj;
        paramMessage.jdField_a_of_type_Afrf.jdField_e_of_type_Int = paramMessage.jdField_a_of_type_Int;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.jdField_a_of_type_Int != 1);
      c(paramMessage);
      return;
      paramMessage = (attk)paramMessage.obj;
      paramMessage.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (attk)paramMessage.obj;
      paramMessage.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_Afrf.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846584);
      return;
      paramMessage = (attk)paramMessage.obj;
    } while (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_Afrf.jdField_a_of_type_Long);
    paramMessage.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramMessage.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessage.jdField_a_of_type_Afrf.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
  }
  
  void a(attk paramattk)
  {
    if ((paramattk != null) && (paramattk.jdField_a_of_type_Afrf != null) && (paramattk.jdField_a_of_type_Long == paramattk.jdField_a_of_type_Afrf.jdField_a_of_type_Long) && (paramattk.jdField_a_of_type_Atti != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramattk.jdField_a_of_type_Atti.a(true);
    }
  }
  
  public void a(String paramString, afrf paramafrf, long paramLong, boolean paramBoolean1, boolean paramBoolean2, atti paramatti)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramafrf == null)) {
      if (paramatti != null) {
        paramatti.a(true);
      }
    }
    for (;;)
    {
      return;
      a(paramafrf, paramBoolean2);
      attk localattk = new attk(this);
      localattk.jdField_a_of_type_Atti = paramatti;
      localattk.jdField_a_of_type_JavaLangString = paramafrf.jdField_a_of_type_Aptm.a.epId;
      localattk.jdField_a_of_type_Afrf = paramafrf;
      localattk.jdField_a_of_type_Long = paramLong;
      localattk.jdField_a_of_type_Boolean = paramBoolean1;
      localattk.b = attl.b(paramString);
      if (localattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        localattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetImageView == null) {
        localattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = attl.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + localattk.b + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramafrf.jdField_e_of_type_Int = i;
      switch (i)
      {
      }
      while ((localattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PngFrameManager.1(this, localattk), 1000L);
        return;
        a(localattk);
        continue;
        c(localattk);
        continue;
        b(localattk);
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
    //   3: getfield 61	atte:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 58	java/util/HashMap
    //   13: dup
    //   14: invokespecial 59	java/util/HashMap:<init>	()V
    //   17: putfield 61	atte:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   20: aload_0
    //   21: getfield 61	atte:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: lload_1
    //   25: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 356	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 358	java/lang/Boolean
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: getfield 46	atte:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   41: ifnull +29 -> 70
    //   44: aload_0
    //   45: getfield 46	atte:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   48: new 360	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: invokespecial 363	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5:<init>	(Latte;J)V
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
    //   0	82	0	this	atte
    //   0	82	1	paramLong	long
    //   65	7	3	bool	boolean
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   20	64	75	finally
  }
  
  public atto b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    atto localatto;
    do
    {
      return localObject;
      localatto = this.jdField_a_of_type_Attl.a(paramString);
      localObject = localatto;
    } while (localatto == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localatto);
    return localatto;
  }
  
  void b(attk paramattk)
  {
    paramattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramattk.jdField_a_of_type_Afrf.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846583);
    ThreadManager.post(new PngFrameManager.2(this, paramattk), 5, null, true);
  }
  
  void c(attk paramattk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + paramattk);
    }
    if (new File(apro.z.replace("[epId]", paramattk.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramattk);
      return;
    }
    int i = bdee.a(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramattk);
      return;
    }
    paramattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramattk.jdField_a_of_type_Afrf.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846583);
    e(paramattk);
  }
  
  void d(attk paramattk)
  {
    String str = apro.q.replace("[epId]", paramattk.jdField_a_of_type_JavaLangString).replace("[eId]", paramattk.jdField_a_of_type_Afrf.jdField_a_of_type_Aptm.a.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramattk.jdField_a_of_type_JavaLangObject = localBitmap;
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, paramattk).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramattk.jdField_a_of_type_Afrf.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846583);
    ThreadManager.post(new PngFrameManager.3(this, str, paramattk), 5, null, true);
  }
  
  void e(attk paramattk)
  {
    ThreadManager.post(new PngFrameManager.4(this, paramattk), 5, null, true);
  }
  
  void f(attk paramattk)
  {
    Object localObject = a(paramattk.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (!((atto)localObject).a())) {}
    do
    {
      return;
      localObject = a(paramattk.jdField_a_of_type_JavaLangString, paramattk.b, paramattk.jdField_a_of_type_Boolean);
      if ((paramattk.jdField_a_of_type_Afrf != null) && (paramattk.jdField_a_of_type_Afrf.jdField_a_of_type_Long == paramattk.jdField_a_of_type_Long)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramattk.jdField_a_of_type_Afrf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramattk.jdField_a_of_type_Afrf.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(226, paramattk).sendToTarget();
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
    this.jdField_a_of_type_Bdwa = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atte
 * JD-Core Version:    0.7.0.1
 */