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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.1;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.2;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.3;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.4;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class awra
  implements awqv, Manager
{
  public Handler a;
  public awrh a;
  public bhyt a;
  public QQAppInterface a;
  public HashMap<Long, Boolean> a;
  ConcurrentHashMap<String, awrk> a;
  
  @SuppressLint({"UseSparseArrays"})
  public awra(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = a(this);
    this.jdField_a_of_type_Awrh = new awrh();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bhyt = ((bhyq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public static Handler a(awqv paramawqv)
  {
    return new awrf(paramawqv);
  }
  
  awqx a(String paramString, int paramInt, boolean paramBoolean)
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
    if ((paramString instanceof awqx)) {}
    for (paramString = (awqx)paramString;; paramString = null)
    {
      if ((paramString == null) || (paramBoolean) || (!paramString.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
        }
        ((awrk)localObject).jdField_a_of_type_Boolean = paramBoolean;
        localObject = new awqx((awrk)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        BaseApplicationImpl.sImageCache.put(str, localObject);
        ((awqx)localObject).a(paramInt);
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
  
  public awrk a(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      localObject = null;
    }
    awrk localawrk;
    do
    {
      return localObject;
      localawrk = (awrk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = localawrk;
    } while (localawrk != null);
    return b(paramString);
  }
  
  @SuppressLint({"InlinedApi"})
  void a(ahbj paramahbj, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramahbj.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramahbj = (RelativeLayout.LayoutParams)paramahbj.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    paramahbj.width = i;
    paramahbj.height = j;
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
        paramMessage = (awrg)paramMessage.obj;
        paramMessage.jdField_a_of_type_Ahbj.jdField_e_of_type_Int = paramMessage.jdField_a_of_type_Int;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.jdField_a_of_type_Int != 1);
      c(paramMessage);
      return;
      paramMessage = (awrg)paramMessage.obj;
      paramMessage.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (awrg)paramMessage.obj;
      paramMessage.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_Ahbj.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847122);
      return;
      paramMessage = (awrg)paramMessage.obj;
    } while (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_Ahbj.jdField_a_of_type_Long);
    paramMessage.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramMessage.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessage.jdField_a_of_type_Ahbj.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
  }
  
  void a(awrg paramawrg)
  {
    if ((paramawrg != null) && (paramawrg.jdField_a_of_type_Ahbj != null) && (paramawrg.jdField_a_of_type_Long == paramawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_Long) && (paramawrg.jdField_a_of_type_Awre != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramawrg.jdField_a_of_type_Awre.a(true);
    }
  }
  
  public void a(String paramString, ahbj paramahbj, long paramLong, boolean paramBoolean1, boolean paramBoolean2, awre paramawre)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramahbj == null)) {
      if (paramawre != null) {
        paramawre.a(true);
      }
    }
    for (;;)
    {
      return;
      a(paramahbj, paramBoolean2);
      awrg localawrg = new awrg(this);
      localawrg.jdField_a_of_type_Awre = paramawre;
      localawrg.jdField_a_of_type_JavaLangString = paramahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
      localawrg.jdField_a_of_type_Ahbj = paramahbj;
      localawrg.jdField_a_of_type_Long = paramLong;
      localawrg.jdField_a_of_type_Boolean = paramBoolean1;
      localawrg.b = awrh.b(paramString);
      if (localawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        localawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetImageView == null) {
        localawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = awrh.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + localawrg.b + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramahbj.jdField_e_of_type_Int = i;
      switch (i)
      {
      }
      while ((localawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PngFrameManager.1(this, localawrg), 1000L);
        return;
        a(localawrg);
        continue;
        c(localawrg);
        continue;
        b(localawrg);
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
    //   3: getfield 61	awra:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 58	java/util/HashMap
    //   13: dup
    //   14: invokespecial 59	java/util/HashMap:<init>	()V
    //   17: putfield 61	awra:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   20: aload_0
    //   21: getfield 61	awra:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: lload_1
    //   25: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 362	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 364	java/lang/Boolean
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: getfield 46	awra:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   41: ifnull +29 -> 70
    //   44: aload_0
    //   45: getfield 46	awra:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   48: new 366	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: invokespecial 369	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5:<init>	(Lawra;J)V
    //   57: ldc2_w 370
    //   60: invokevirtual 352	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
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
    //   0	82	0	this	awra
    //   0	82	1	paramLong	long
    //   65	7	3	bool	boolean
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   20	64	75	finally
  }
  
  public awrk b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    awrk localawrk;
    do
    {
      return localObject;
      localawrk = this.jdField_a_of_type_Awrh.a(paramString);
      localObject = localawrk;
    } while (localawrk == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localawrk);
    return localawrk;
  }
  
  void b(awrg paramawrg)
  {
    paramawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramawrg.jdField_a_of_type_Ahbj.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847121);
    ThreadManager.post(new PngFrameManager.2(this, paramawrg), 5, null, true);
  }
  
  void c(awrg paramawrg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + paramawrg);
    }
    if (new File(EmoticonUtils.pngFramePath.replace("[epId]", paramawrg.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramawrg);
      return;
    }
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramawrg);
      return;
    }
    paramawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramawrg.jdField_a_of_type_Ahbj.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847121);
    e(paramawrg);
  }
  
  void d(awrg paramawrg)
  {
    String str = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", paramawrg.jdField_a_of_type_JavaLangString).replace("[eId]", paramawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramawrg.jdField_a_of_type_JavaLangObject = localBitmap;
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, paramawrg).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramawrg.jdField_a_of_type_Ahbj.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847121);
    ThreadManager.post(new PngFrameManager.3(this, str, paramawrg), 5, null, true);
  }
  
  void e(awrg paramawrg)
  {
    ThreadManager.post(new PngFrameManager.4(this, paramawrg), 5, null, true);
  }
  
  void f(awrg paramawrg)
  {
    Object localObject = a(paramawrg.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (!((awrk)localObject).a())) {}
    do
    {
      return;
      localObject = a(paramawrg.jdField_a_of_type_JavaLangString, paramawrg.b, paramawrg.jdField_a_of_type_Boolean);
      if ((paramawrg.jdField_a_of_type_Ahbj != null) && (paramawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_Long == paramawrg.jdField_a_of_type_Long)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramawrg.jdField_a_of_type_Ahbj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramawrg.jdField_a_of_type_Ahbj.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(226, paramawrg).sendToTarget();
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
    this.jdField_a_of_type_Bhyt = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awra
 * JD-Core Version:    0.7.0.1
 */