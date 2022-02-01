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

public class avkv
  implements avkq, Manager
{
  public Handler a;
  public avlc a;
  public bgoj a;
  public QQAppInterface a;
  public HashMap<Long, Boolean> a;
  ConcurrentHashMap<String, avlf> a;
  
  @SuppressLint({"UseSparseArrays"})
  public avkv(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "PngFrameManager 【Constructor】  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = a(this);
    this.jdField_a_of_type_Avlc = new avlc();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bgoj = ((bgog)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(1);
  }
  
  public static Handler a(avkq paramavkq)
  {
    return new avla(paramavkq);
  }
  
  avks a(String paramString, int paramInt, boolean paramBoolean)
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
    if ((paramString instanceof avks)) {}
    for (paramString = (avks)paramString;; paramString = null)
    {
      if ((paramString == null) || (paramBoolean) || (!paramString.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PngFrameManager", 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
        }
        ((avlf)localObject).jdField_a_of_type_Boolean = paramBoolean;
        localObject = new avks((avlf)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        BaseApplicationImpl.sImageCache.put(str, localObject);
        ((avks)localObject).a(paramInt);
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
  
  public avlf a(String paramString)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      localObject = null;
    }
    avlf localavlf;
    do
    {
      return localObject;
      localavlf = (avlf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject = localavlf;
    } while (localavlf != null);
    return b(paramString);
  }
  
  @SuppressLint({"InlinedApi"})
  void a(agis paramagis, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramagis.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramagis = (RelativeLayout.LayoutParams)paramagis.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    paramagis.width = i;
    paramagis.height = j;
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
        paramMessage = (avlb)paramMessage.obj;
        paramMessage.jdField_a_of_type_Agis.jdField_e_of_type_Int = paramMessage.jdField_a_of_type_Int;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.jdField_a_of_type_Int != 1);
      c(paramMessage);
      return;
      paramMessage = (avlb)paramMessage.obj;
      paramMessage.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (avlb)paramMessage.obj;
      paramMessage.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_Agis.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847024);
      return;
      paramMessage = (avlb)paramMessage.obj;
    } while (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_Agis.jdField_a_of_type_Long);
    paramMessage.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramMessage.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessage.jdField_a_of_type_Agis.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
  }
  
  void a(avlb paramavlb)
  {
    if ((paramavlb != null) && (paramavlb.jdField_a_of_type_Agis != null) && (paramavlb.jdField_a_of_type_Long == paramavlb.jdField_a_of_type_Agis.jdField_a_of_type_Long) && (paramavlb.jdField_a_of_type_Avkz != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramavlb.jdField_a_of_type_Avkz.a(true);
    }
  }
  
  public void a(String paramString, agis paramagis, long paramLong, boolean paramBoolean1, boolean paramBoolean2, avkz paramavkz)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramagis == null)) {
      if (paramavkz != null) {
        paramavkz.a(true);
      }
    }
    for (;;)
    {
      return;
      a(paramagis, paramBoolean2);
      avlb localavlb = new avlb(this);
      localavlb.jdField_a_of_type_Avkz = paramavkz;
      localavlb.jdField_a_of_type_JavaLangString = paramagis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId;
      localavlb.jdField_a_of_type_Agis = paramagis;
      localavlb.jdField_a_of_type_Long = paramLong;
      localavlb.jdField_a_of_type_Boolean = paramBoolean1;
      localavlb.b = avlc.b(paramString);
      if (localavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        localavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (localavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetImageView == null) {
        localavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = avlc.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + localavlb.b + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramagis.jdField_e_of_type_Int = i;
      switch (i)
      {
      }
      while ((localavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PngFrameManager.1(this, localavlb), 1000L);
        return;
        a(localavlb);
        continue;
        c(localavlb);
        continue;
        b(localavlb);
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
    //   3: getfield 61	avkv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 58	java/util/HashMap
    //   13: dup
    //   14: invokespecial 59	java/util/HashMap:<init>	()V
    //   17: putfield 61	avkv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   20: aload_0
    //   21: getfield 61	avkv:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: lload_1
    //   25: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: invokevirtual 357	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 359	java/lang/Boolean
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: getfield 46	avkv:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   41: ifnull +29 -> 70
    //   44: aload_0
    //   45: getfield 46	avkv:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   48: new 361	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5
    //   51: dup
    //   52: aload_0
    //   53: lload_1
    //   54: invokespecial 364	com/tencent/mobileqq/magicface/drawable/PngFrameManager$5:<init>	(Lavkv;J)V
    //   57: ldc2_w 365
    //   60: invokevirtual 347	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
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
    //   0	82	0	this	avkv
    //   0	82	1	paramLong	long
    //   65	7	3	bool	boolean
    //   75	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   20	64	75	finally
  }
  
  public avlf b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    avlf localavlf;
    do
    {
      return localObject;
      localavlf = this.jdField_a_of_type_Avlc.a(paramString);
      localObject = localavlf;
    } while (localavlf == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localavlf);
    return localavlf;
  }
  
  void b(avlb paramavlb)
  {
    paramavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramavlb.jdField_a_of_type_Agis.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847023);
    ThreadManager.post(new PngFrameManager.2(this, paramavlb), 5, null, true);
  }
  
  void c(avlb paramavlb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onTypePngZip begins, param:" + paramavlb);
    }
    if (new File(EmoticonUtils.pngFramePath.replace("[epId]", paramavlb.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramavlb);
      return;
    }
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramavlb);
      return;
    }
    paramavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramavlb.jdField_a_of_type_Agis.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847023);
    e(paramavlb);
  }
  
  void d(avlb paramavlb)
  {
    String str = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", paramavlb.jdField_a_of_type_JavaLangString).replace("[eId]", paramavlb.jdField_a_of_type_Agis.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameManager", 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramavlb.jdField_a_of_type_JavaLangObject = localBitmap;
      try
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, paramavlb).sendToTarget();
        }
        return;
      }
      finally {}
    }
    paramavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramavlb.jdField_a_of_type_Agis.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847023);
    ThreadManager.post(new PngFrameManager.3(this, str, paramavlb), 5, null, true);
  }
  
  void e(avlb paramavlb)
  {
    ThreadManager.post(new PngFrameManager.4(this, paramavlb), 5, null, true);
  }
  
  void f(avlb paramavlb)
  {
    Object localObject = a(paramavlb.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (!((avlf)localObject).a())) {}
    do
    {
      return;
      localObject = a(paramavlb.jdField_a_of_type_JavaLangString, paramavlb.b, paramavlb.jdField_a_of_type_Boolean);
      if ((paramavlb.jdField_a_of_type_Agis != null) && (paramavlb.jdField_a_of_type_Agis.jdField_a_of_type_Long == paramavlb.jdField_a_of_type_Long)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PngFrameManager", 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramavlb.jdField_a_of_type_Agis.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramavlb.jdField_a_of_type_Agis.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(226, paramavlb).sendToTarget();
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
    this.jdField_a_of_type_Bgoj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkv
 * JD-Core Version:    0.7.0.1
 */