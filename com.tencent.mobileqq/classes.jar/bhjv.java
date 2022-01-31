import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.paster.CaptureComboNormalPaster.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class bhjv
  extends bhgn
  implements IEventReceiver
{
  public static HashMap<String, Drawable> a;
  private float jdField_a_of_type_Float;
  private bhjx jdField_a_of_type_Bhjx;
  public biox a;
  private final String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private String jdField_b_of_type_JavaLangString;
  private float c;
  int d = 2;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public bhjv(biox parambiox, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Biox = parambiox;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "create id=" + paramString1 + " name=" + paramString2);
    }
  }
  
  private static Drawable a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    new File(paramString).getName();
    URLDrawable localURLDrawable = baop.a(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
    if (localURLDrawable != null)
    {
      int i = localURLDrawable.getStatus();
      if (i == 1) {
        return localURLDrawable;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QComboNPaster", 2, "urlDrawable is not  SUCCESSED :" + i);
      }
      localURLDrawable.setURLDrawableListener(paramURLDrawableListener);
      if (i != 2) {
        break label107;
      }
      localURLDrawable.restartDownload();
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localURLDrawable);
      return null;
      label107:
      localURLDrawable.startDownload();
    }
    return localURLDrawable;
  }
  
  public static void a(biox parambiox, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, bhhl parambhhl)
  {
    if (parambhhl == null) {
      throw new IllegalStateException("applyNormalPaster listener is null!");
    }
    int i = parambiox.a(paramString);
    paramString = parambiox.a(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    try
    {
      vlm.d(parambiox.g);
      label43:
      if (QLog.isColorLevel()) {
        QLog.e("QComboNPaster", 2, "applyNormalPaster uriString error!");
      }
      for (;;)
      {
        return;
        paramString = Uri.parse(paramString).getPath();
        String str = new File(paramString).getName();
        bhjw localbhjw = new bhjw(str, paramString, parambiox, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, parambhhl, i);
        if (i != 1) {
          try
          {
            b(Drawable.createFromPath(paramString), str, paramString, parambiox, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, parambhhl, i);
            return;
          }
          catch (OutOfMemoryError parambiox)
          {
            urk.c("QComboNPaster", "createFromPath error", parambiox);
            return;
          }
        }
        File localFile = new File(paramString);
        try
        {
          if (!ApngDrawable.isApngFile(localFile))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QComboNPaster", 2, "applyNormalPaster isApngFile not valid path=" + paramString);
            return;
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          b(a(paramString, localbhjw), str, paramString, parambiox, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper, parambhhl, i);
          return;
        }
      }
    }
    catch (Exception parambiox)
    {
      break label43;
    }
  }
  
  private static void b(Drawable paramDrawable, String paramString1, String paramString2, biox parambiox, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, bhhl parambhhl, int paramInt3)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      int i = paramDrawable.getIntrinsicWidth();
      paramFloat3 = paramInt1 * paramFloat3 / i;
      if (QLog.isColorLevel()) {
        QLog.d("QComboNPaster", 2, "applyNormalPaster w=" + i + " scale=" + paramFloat3 + " px=" + paramFloat1 + " py=" + paramFloat2);
      }
      parambhhl.a(new bikj(parambiox.jdField_b_of_type_JavaLangString, paramString1, paramDrawable, paramInt3), paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, paramString2, paramSegmentKeeper);
      return;
    }
    urk.e("QComboNPaster", "can not create drawable from name:" + paramString1);
  }
  
  public float a()
  {
    float f = 1.0F;
    for (;;)
    {
      try
      {
        if (!baip.a(this.jdField_a_of_type_Biox.g))
        {
          a();
          return f;
        }
        if ((this.jdField_a_of_type_Biox.c != 100.0F) && (this.jdField_a_of_type_Biox.c > 0.0F))
        {
          f = this.jdField_a_of_type_Biox.d;
          int i = this.jdField_a_of_type_Biox.c;
          f = 1.0F * f / i;
        }
        else
        {
          f = 0.0F;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	bhjv:jdField_a_of_type_Biox	Lbiox;
    //   6: getfield 166	biox:g	Ljava/lang/String;
    //   9: invokestatic 255	baip:a	(Ljava/lang/String;)Z
    //   12: ifne +17 -> 29
    //   15: aload_0
    //   16: iconst_3
    //   17: putfield 33	bhjv:d	I
    //   20: aload_0
    //   21: getfield 33	bhjv:d	I
    //   24: istore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: aload_0
    //   30: getfield 39	bhjv:jdField_a_of_type_Biox	Lbiox;
    //   33: getfield 264	biox:jdField_b_of_type_Boolean	Z
    //   36: ifeq -16 -> 20
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 33	bhjv:d	I
    //   44: goto -24 -> 20
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	bhjv
    //   24	4	1	i	int
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	47	finally
    //   20	25	47	finally
    //   29	44	47	finally
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_Biox.a == null) || (this.jdField_a_of_type_Biox.a.size() == 0)) {
      this.jdField_a_of_type_Biox.a(this.jdField_a_of_type_Biox.a());
    }
    ThreadManager.excute(new CaptureComboNormalPaster.1(this, paramInt), 64, null, true);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "apply id=" + this.jdField_a_of_type_JavaLangString + " name=" + this.jdField_b_of_type_JavaLangString);
    }
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_Biox.a == null) || (this.jdField_a_of_type_Biox.a.size() == 0)) {
      this.jdField_a_of_type_Biox.a(this.jdField_a_of_type_Biox.a());
    }
    paramActivity = this.jdField_a_of_type_Biox.a(this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "unApply id=" + this.jdField_a_of_type_JavaLangString + " name=" + this.jdField_b_of_type_JavaLangString + "url=" + paramActivity);
    }
    if (TextUtils.isEmpty(paramActivity)) {}
    for (;;)
    {
      return;
      try
      {
        paramActivity = new File(Uri.parse(paramActivity).getPath()).getName();
        DoodleLayout localDoodleLayout = bhnz.a().a(paramInt);
        if (localDoodleLayout != null)
        {
          localDoodleLayout.a().a(this.jdField_a_of_type_Biox.jdField_b_of_type_JavaLangString, paramActivity);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public int b()
  {
    try
    {
      ((bikm)sqg.a(39)).a(this.jdField_a_of_type_JavaLangString, false);
      a();
      Dispatcher localDispatcher = sgi.a();
      bhjx localbhjx = new bhjx(this);
      this.jdField_a_of_type_Bhjx = localbhjx;
      localDispatcher.registerSubscriber(localbhjx);
      this.d = 1;
      if (QLog.isColorLevel()) {
        QLog.d("QComboNPaster", 2, "create mState=" + this.d + " id=" + this.jdField_a_of_type_JavaLangString);
      }
      int i = this.d;
      return i;
    }
    finally {}
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Biox.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean isValidate()
  {
    return this.d == 1;
  }
  
  public String toString()
  {
    return "NP@" + this.jdField_a_of_type_JavaLangString + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhjv
 * JD-Core Version:    0.7.0.1
 */