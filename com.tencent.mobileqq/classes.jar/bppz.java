import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bppz
  extends bpmr
  implements URLDrawable.URLDrawableListener
{
  private final float jdField_a_of_type_Float;
  bqpd jdField_a_of_type_Bqpd;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  String jdField_a_of_type_JavaLangString;
  private final float jdField_b_of_type_Float;
  private final String jdField_b_of_type_JavaLangString;
  private final float c;
  int d = 0;
  int e = 2;
  
  public bppz(bqpd parambqpd, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bqpd = parambqpd;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    if (QLog.isColorLevel()) {
      QLog.d("QCombo.LPaster", 2, "create id=" + paramString1 + " name=" + paramString2);
    }
  }
  
  private URLDrawable a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = beyq.a;
    localURLDrawableOptions.mLoadingDrawable = beyq.a;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    bqpe localbqpe = this.jdField_a_of_type_Bqpd.a(this.jdField_a_of_type_JavaLangString);
    if (localbqpe != null) {
      return URLDrawable.getDrawable(localbqpe.d, localURLDrawableOptions);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo.LPaster", 2, "createUrlDrawable no item =" + this.jdField_a_of_type_JavaLangString);
    }
    return null;
  }
  
  public float a()
  {
    return 1.0F;
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
          this.jdField_a_of_type_ComTencentImageURLDrawable = a();
        }
        if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
          break label129;
        }
        if (this.e != 3)
        {
          bqpe localbqpe = this.jdField_a_of_type_Bqpd.a(this.jdField_a_of_type_JavaLangString);
          if (localbqpe == null) {
            break label92;
          }
          if (beqz.a(localbqpe.d) == null) {
            this.e = 2;
          }
        }
        else
        {
          int i = this.e;
          return i;
        }
        this.e = 3;
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      finally {}
      label92:
      QLog.d("QCombo.LPaster", 2, "getState no item =" + this.jdField_a_of_type_JavaLangString);
      continue;
      label129:
      this.e = 2;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = bpue.a().a(paramInt);
    if (paramActivity != null)
    {
      a(this.jdField_a_of_type_Bqpd, this.jdField_a_of_type_JavaLangString, brkm.a, brkm.b, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c, paramActivity.a());
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "apply id=" + this.jdField_b_of_type_JavaLangString + " name=" + this.jdField_a_of_type_JavaLangString + " state=" + this.e);
      }
    }
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    paramActivity = this.jdField_a_of_type_Bqpd.a(this.jdField_a_of_type_JavaLangString);
    if (paramActivity != null)
    {
      DoodleLayout localDoodleLayout = bpue.a().a(paramInt);
      if (localDoodleLayout != null) {
        localDoodleLayout.a().a(this.jdField_a_of_type_Bqpd.jdField_b_of_type_JavaLangString, paramActivity.c);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "apply id=" + this.jdField_b_of_type_JavaLangString + " name=" + this.jdField_a_of_type_JavaLangString + " state=" + this.e);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "unApply no item =" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(bqpd parambqpd, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, bpnq parambpnq)
  {
    if (parambpnq == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QCombo.LPaster", 2, "try apply but no listener");
      }
    }
    do
    {
      return;
      parambqpd = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (parambqpd == null) {
        break;
      }
      parambqpd.setBounds(0, 0, parambqpd.getIntrinsicWidth(), parambqpd.getIntrinsicHeight());
      paramString = this.jdField_a_of_type_Bqpd.a(this.jdField_a_of_type_JavaLangString);
      if (paramString != null)
      {
        paramString.a = parambqpd;
        parambpnq.a(paramString, paramInt1 * paramFloat1, paramInt2 * paramFloat2, paramFloat3, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo.LPaster", 2, "applyLocationPaster no item =" + this.jdField_a_of_type_JavaLangString);
    return;
    yuk.e("QCombo.LPaster", "can create drawable from urldrawable:" + this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	bppz:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 111	bppz:a	()Lcom/tencent/image/URLDrawable;
    //   14: putfield 109	bppz:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   17: aload_0
    //   18: getfield 109	bppz:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   21: ifnull +86 -> 107
    //   24: aload_0
    //   25: getfield 109	bppz:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   28: invokevirtual 197	com/tencent/image/URLDrawable:getStatus	()I
    //   31: iconst_1
    //   32: if_icmpne +84 -> 116
    //   35: aload_0
    //   36: iconst_3
    //   37: putfield 25	bppz:e	I
    //   40: aload_0
    //   41: bipush 100
    //   43: putfield 23	bppz:d	I
    //   46: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +58 -> 107
    //   52: ldc 45
    //   54: iconst_2
    //   55: new 47	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   62: ldc 199
    //   64: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 27	bppz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 58
    //   76: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 29	bppz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 201
    //   88: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 109	bppz:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   95: invokevirtual 197	com/tencent/image/URLDrawable:getStatus	()I
    //   98: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_0
    //   108: getfield 25	bppz:e	I
    //   111: istore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: iload_1
    //   115: ireturn
    //   116: aload_0
    //   117: getfield 109	bppz:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   120: invokevirtual 119	com/tencent/image/URLDrawable:startDownload	()V
    //   123: aload_0
    //   124: getfield 109	bppz:jdField_a_of_type_ComTencentImageURLDrawable	Lcom/tencent/image/URLDrawable;
    //   127: aload_0
    //   128: invokevirtual 205	com/tencent/image/URLDrawable:setURLDrawableListener	(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 25	bppz:e	I
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 23	bppz:d	I
    //   141: aload_0
    //   142: invokevirtual 207	bppz:a	()V
    //   145: goto -99 -> 46
    //   148: astore_2
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_2
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	bppz
    //   111	4	1	i	int
    //   148	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	148	finally
    //   17	46	148	finally
    //   46	107	148	finally
    //   107	112	148	finally
    //   116	145	148	finally
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.d = 0;
    this.e = 2;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.d = 0;
    this.e = 2;
    a(4);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    this.d = paramInt;
    this.e = 1;
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.d = 100;
    this.e = 3;
    b();
  }
  
  public String toString()
  {
    return "LP@" + this.jdField_b_of_type_JavaLangString + "@" + this.jdField_a_of_type_JavaLangString + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppz
 * JD-Core Version:    0.7.0.1
 */