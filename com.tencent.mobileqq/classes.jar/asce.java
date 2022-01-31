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

public class asce
  implements asbz, Manager
{
  public Handler a;
  public ascl a;
  public bbwz a;
  public QQAppInterface a;
  public HashMap<Long, Boolean> a;
  ConcurrentHashMap<String, asco> a;
  
  @SuppressLint({"UseSparseArrays"})
  public asce(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = a(this);
    this.jdField_a_of_type_Ascl = new ascl();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bbwz = ((bbww)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
  }
  
  public static Handler a(asbz paramasbz)
  {
    return new ascj(paramasbz);
  }
  
  ascb a(String paramString, int paramInt, boolean paramBoolean)
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
    if ((paramString instanceof ascb)) {}
    for (paramString = (ascb)paramString;; paramString = null)
    {
      if ((paramString == null) || (paramBoolean) || (!paramString.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
        }
        ((asco)localObject).jdField_a_of_type_Boolean = paramBoolean;
        localObject = new ascb((asco)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        BaseApplicationImpl.sImageCache.put(str, localObject);
        ((ascb)localObject).a(paramInt);
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
  
  public asco a(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      localObject = null;
    }
    asco localasco;
    do
    {
      return localObject;
      localasco = (asco)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = localasco;
    } while (localasco != null);
    return b(paramString);
  }
  
  @SuppressLint({"InlinedApi"})
  void a(adus paramadus, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramadus.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramadus = (RelativeLayout.LayoutParams)paramadus.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    paramadus.width = i;
    paramadus.height = j;
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
        paramMessage = (asck)paramMessage.obj;
        paramMessage.jdField_a_of_type_Adus.jdField_e_of_type_Int = paramMessage.jdField_a_of_type_Int;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.jdField_a_of_type_Int != 1);
      c(paramMessage);
      return;
      paramMessage = (asck)paramMessage.obj;
      paramMessage.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (asck)paramMessage.obj;
      paramMessage.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_Adus.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846205);
      return;
      paramMessage = (asck)paramMessage.obj;
    } while (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_Adus.jdField_a_of_type_Long);
    paramMessage.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramMessage.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessage.jdField_a_of_type_Adus.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
  }
  
  void a(asck paramasck)
  {
    if ((paramasck != null) && (paramasck.jdField_a_of_type_Adus != null) && (paramasck.jdField_a_of_type_Long == paramasck.jdField_a_of_type_Adus.jdField_a_of_type_Long) && (paramasck.jdField_a_of_type_Asci != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramasck.jdField_a_of_type_Asci.a(true);
    }
  }
  
  public void a(String paramString, adus paramadus, long paramLong, boolean paramBoolean1, boolean paramBoolean2, asci paramasci)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramadus == null)) {
      if (paramasci != null) {
        paramasci.a(true);
      }
    }
    for (;;)
    {
      return;
      a(paramadus, paramBoolean2);
      asck localasck = new asck(this);
      localasck.jdField_a_of_type_Asci = paramasci;
      localasck.jdField_a_of_type_JavaLangString = paramadus.jdField_a_of_type_Aobp.a.epId;
      localasck.jdField_a_of_type_Adus = paramadus;
      localasck.jdField_a_of_type_Long = paramLong;
      localasck.jdField_a_of_type_Boolean = paramBoolean1;
      localasck.b = ascl.b(paramString);
      if (localasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        localasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetImageView == null) {
        localasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = ascl.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + localasck.b + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramadus.jdField_e_of_type_Int = i;
      switch (i)
      {
      }
      while ((localasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PngFrameManager.1(this, localasck), 1000L);
        return;
        a(localasck);
        continue;
        c(localasck);
        continue;
        b(localasck);
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
    //   3: getfield 61	asce:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 58	java/util/HashMap
    //   13: dup
    //   14: invokespecial 59	java/util/HashMap:<init>	()V
    //   17: putfield 61	asce:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   20: aload_0
    //   21: getfield 61	asce:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: lload_1
    //   25: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 356	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 358	java/lang/Boolean
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: getfield 46	asce:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   41: ifnull +29 -> 70
    //   44: aload_0
    //   45: getfield 46	asce:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   48: new 360	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: invokespecial 363	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5:<init>	(Lasce;J)V
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
    //   0	82	0	this	asce
    //   0	82	1	paramLong	long
    //   65	7	3	bool	boolean
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   20	64	75	finally
  }
  
  public asco b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    asco localasco;
    do
    {
      return localObject;
      localasco = this.jdField_a_of_type_Ascl.a(paramString);
      localObject = localasco;
    } while (localasco == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localasco);
    return localasco;
  }
  
  void b(asck paramasck)
  {
    paramasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramasck.jdField_a_of_type_Adus.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846204);
    ThreadManager.post(new PngFrameManager.2(this, paramasck), 5, null, true);
  }
  
  void c(asck paramasck)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + paramasck);
    }
    if (new File(anzr.z.replace("[epId]", paramasck.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramasck);
      return;
    }
    int i = bbfj.a(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramasck);
      return;
    }
    paramasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramasck.jdField_a_of_type_Adus.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846204);
    e(paramasck);
  }
  
  void d(asck paramasck)
  {
    String str = anzr.q.replace("[epId]", paramasck.jdField_a_of_type_JavaLangString).replace("[eId]", paramasck.jdField_a_of_type_Adus.jdField_a_of_type_Aobp.a.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramasck.jdField_a_of_type_JavaLangObject = localBitmap;
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, paramasck).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramasck.jdField_a_of_type_Adus.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846204);
    ThreadManager.post(new PngFrameManager.3(this, str, paramasck), 5, null, true);
  }
  
  void e(asck paramasck)
  {
    ThreadManager.post(new PngFrameManager.4(this, paramasck), 5, null, true);
  }
  
  void f(asck paramasck)
  {
    Object localObject = a(paramasck.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (!((asco)localObject).a())) {}
    do
    {
      return;
      localObject = a(paramasck.jdField_a_of_type_JavaLangString, paramasck.b, paramasck.jdField_a_of_type_Boolean);
      if ((paramasck.jdField_a_of_type_Adus != null) && (paramasck.jdField_a_of_type_Adus.jdField_a_of_type_Long == paramasck.jdField_a_of_type_Long)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramasck.jdField_a_of_type_Adus.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramasck.jdField_a_of_type_Adus.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(226, paramasck).sendToTarget();
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
    this.jdField_a_of_type_Bbwz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asce
 * JD-Core Version:    0.7.0.1
 */