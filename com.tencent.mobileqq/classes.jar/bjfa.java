import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.paster.CaptureComboInformationPaster.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

public class bjfa
  extends bjbw
  implements bkgc, IEventReceiver
{
  public static HashMap<String, Drawable> a;
  private float jdField_a_of_type_Float;
  private bjfc jdField_a_of_type_Bjfc;
  private bjfr jdField_a_of_type_Bjfr;
  bkga jdField_a_of_type_Bkga;
  private bkgd jdField_a_of_type_Bkgd;
  private final String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float;
  private String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int = 2;
  private String jdField_d_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public bjfa(bkga parambkga, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bkga = parambkga;
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat2;
    this.jdField_a_of_type_Bjfr = ((bjfr)bjav.a().c(12));
    this.jdField_a_of_type_Bkgd = this.jdField_a_of_type_Bkga.a(paramString3);
    this.jdField_c_of_type_JavaLangString = paramString1;
    if (this.jdField_a_of_type_Bkgd != null)
    {
      this.jdField_a_of_type_Bkgd.a(this);
      this.jdField_d_of_type_JavaLangString = ("CaptureComboInformationPaster_" + this.jdField_a_of_type_Bkgd.jdField_b_of_type_JavaLangString + "_" + this.jdField_a_of_type_Bkgd.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureComboInformationPaster", 2, "package id=" + paramString2 + " posterId=" + paramString3);
    }
  }
  
  private void a(Drawable paramDrawable, String paramString, int paramInt, bjcu parambjcu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureComboInformationPaster", 2, "applyApngInfoPaster w=" + paramDrawable.getIntrinsicWidth() + " px=" + this.jdField_b_of_type_Float + " py=" + this.jdField_c_of_type_Float + " scale=" + this.jdField_a_of_type_Float);
    }
    paramDrawable = new bkbv(this.jdField_a_of_type_Bkga.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, paramDrawable, paramInt);
    paramInt = blcq.jdField_a_of_type_Int;
    int i = blcq.b;
    float f1 = paramInt;
    float f2 = this.jdField_b_of_type_Float;
    float f3 = i;
    parambjcu.b(paramDrawable, f2 * f1, this.jdField_c_of_type_Float * f3, this.jdField_a_of_type_Float, paramString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  private void a(bkgd parambkgd, bjcu parambjcu)
  {
    int i = 7;
    Object localObject3 = null;
    Object localObject1 = bjfr.b(parambkgd);
    int j;
    if (parambkgd.jdField_a_of_type_Int == 8)
    {
      j = Calendar.getInstance().get(7) - 1;
      if (j != 0) {
        break label361;
      }
    }
    label279:
    label311:
    label323:
    label361:
    for (;;)
    {
      for (parambkgd = (String)localObject1 + File.separator + i + ".apng";; parambkgd = (String)localObject1 + File.separator + "city" + ".apng")
      {
        localObject1 = new File(parambkgd);
        try
        {
          if (ApngDrawable.isApngFile((File)localObject1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CaptureComboInformationPaster", 2, "applyNormalPaster isApngFile not valid path=" + parambkgd);
          }
          return;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          URLDrawable localURLDrawable = bbqz.a(BaseApplicationImpl.sApplication.getRuntime(), parambkgd, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
          Object localObject2 = localObject3;
          if (localURLDrawable == null) {
            break label279;
          }
          i = localURLDrawable.getStatus();
          if (i == 1) {
            break label323;
          }
          if (!QLog.isColorLevel()) {
            break label238;
          }
          QLog.e("CaptureComboInformationPaster", 2, "urlDrawable is not  SUCCESSED :" + i);
          localURLDrawable.setURLDrawableListener(new bjfb(this, parambkgd, localURLDrawable, parambjcu));
          jdField_a_of_type_JavaUtilHashMap.put(parambkgd, localURLDrawable);
          if (i != 2) {
            break label311;
          }
          localURLDrawable.restartDownload();
          localObject2 = localObject3;
          while (localObject2 != null)
          {
            localObject2.setBounds(0, 0, localObject2.getIntrinsicWidth(), localObject2.getIntrinsicHeight());
            a(localObject2, parambkgd, 1, parambjcu);
            return;
            localURLDrawable.startDownload();
            localObject2 = localObject3;
            continue;
            localObject2 = localURLDrawable;
          }
          ved.e("CaptureComboInformationPaster", "can not create drawable from name:" + this.jdField_a_of_type_Bkga.jdField_b_of_type_JavaLangString);
          return;
        }
      }
      label238:
      i = j;
    }
  }
  
  private void a(DoodleLayout paramDoodleLayout, bjcu parambjcu)
  {
    if (this.jdField_a_of_type_Bkgd.jdField_a_of_type_Int == 8)
    {
      if (paramDoodleLayout != null) {
        ThreadManager.excute(new CaptureComboInformationPaster.1(this, parambjcu), 16, null, true);
      }
      return;
    }
    int i = blcq.jdField_a_of_type_Int;
    int j = blcq.b;
    paramDoodleLayout = this.jdField_a_of_type_Bkgd;
    String str = this.jdField_d_of_type_JavaLangString;
    float f1 = i;
    float f2 = this.jdField_b_of_type_Float;
    float f3 = j;
    parambjcu.a(paramDoodleLayout, str, f2 * f1, this.jdField_c_of_type_Float * f3, this.jdField_a_of_type_Float);
  }
  
  /* Error */
  public float a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 275	bjfa:jdField_a_of_type_Bjfc	Lbjfc;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 275	bjfa:jdField_a_of_type_Bjfc	Lbjfc;
    //   13: invokevirtual 279	bjfc:a	()F
    //   16: fstore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: fload_1
    //   20: freturn
    //   21: fconst_1
    //   22: fstore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	bjfa
    //   16	7	1	f	float
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bkgd != null)
        {
          if (this.jdField_a_of_type_Bjfr.a(this.jdField_a_of_type_Bkgd)) {
            this.jdField_d_of_type_Int = 3;
          }
        }
        else
        {
          int i = this.jdField_d_of_type_Int;
          return i;
        }
        if (this.jdField_a_of_type_Bjfr.b(this.jdField_a_of_type_Bkgd)) {
          this.jdField_d_of_type_Int = 1;
        } else {
          this.jdField_d_of_type_Int = 2;
        }
      }
      finally {}
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = bjji.a().a(paramInt);
    if ((paramActivity != null) && (this.jdField_a_of_type_Bkgd != null))
    {
      bjcu localbjcu = paramActivity.a();
      if (localbjcu != null)
      {
        a(paramActivity, localbjcu);
        if (QLog.isColorLevel()) {
          QLog.d("CaptureComboInformationPaster", 2, "apply id=" + this.jdField_a_of_type_JavaLangString + " name=" + this.jdField_b_of_type_JavaLangString + " state=" + this.jdField_d_of_type_Int);
        }
      }
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = 2;
    super.a(paramInt);
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_Bkgd != null)
    {
      paramActivity = bjji.a().a(paramInt);
      if (paramActivity != null) {
        paramActivity.a().a(this.jdField_a_of_type_Bkga.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboInformationPaster", 2, "unApply id=" + this.jdField_a_of_type_JavaLangString + " name=" + this.jdField_b_of_type_JavaLangString + " state=" + this.jdField_d_of_type_Int);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboInformationPaster", 2, "unApply no item =" + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(0);
    }
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	bjfa:jdField_a_of_type_Bkgd	Lbkgd;
    //   6: ifnull +103 -> 109
    //   9: aload_0
    //   10: getfield 275	bjfa:jdField_a_of_type_Bjfc	Lbjfc;
    //   13: ifnonnull +15 -> 28
    //   16: aload_0
    //   17: new 277	bjfc
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 321	bjfc:<init>	(Lbjfa;)V
    //   25: putfield 275	bjfa:jdField_a_of_type_Bjfc	Lbjfc;
    //   28: aload_0
    //   29: getfield 61	bjfa:jdField_a_of_type_Bjfr	Lbjfr;
    //   32: aload_0
    //   33: getfield 68	bjfa:jdField_a_of_type_Bkgd	Lbkgd;
    //   36: aload_0
    //   37: getfield 275	bjfa:jdField_a_of_type_Bjfc	Lbjfc;
    //   40: invokevirtual 324	bjfr:a	(Lbkgd;Lbjfu;)V
    //   43: aload_0
    //   44: invokevirtual 326	bjfa:a	()V
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 37	bjfa:jdField_d_of_type_Int	I
    //   52: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +45 -> 100
    //   58: ldc 102
    //   60: iconst_2
    //   61: new 77	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 328
    //   71: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: getfield 37	bjfa:jdField_d_of_type_Int	I
    //   78: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: ldc_w 330
    //   84: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 39	bjfa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: getfield 37	bjfa:jdField_d_of_type_Int	I
    //   104: istore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: iload_1
    //   108: ireturn
    //   109: aload_0
    //   110: iconst_4
    //   111: invokevirtual 318	bjfa:a	(I)V
    //   114: goto -14 -> 100
    //   117: astore_2
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	bjfa
    //   104	4	1	i	int
    //   117	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	117	finally
    //   28	100	117	finally
    //   100	105	117	finally
    //   109	114	117	finally
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bkgd == null) || (this.jdField_a_of_type_Bkgd.jdField_a_of_type_Int != 7)) {}
    bjcb localbjcb;
    bjcq localbjcq;
    do
    {
      return;
      localbjcb = (bjcb)bjav.a(5);
      localbjcq = localbjcb.a(this.jdField_c_of_type_JavaLangString);
    } while (localbjcq == null);
    localbjcq.a();
    localbjcb.a(localbjcq);
  }
  
  public boolean isValidate()
  {
    return this.jdField_d_of_type_Int == 1;
  }
  
  public String toString()
  {
    return "NP@" + this.jdField_a_of_type_JavaLangString + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfa
 * JD-Core Version:    0.7.0.1
 */