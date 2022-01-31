import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer.2;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer.3;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import mqq.os.MqqHandler;

public class assa
{
  public int a;
  Paint a;
  public Typeface a;
  public asrz a;
  public assb a;
  public ArrayList<WeakReference<HiBoomTextView>> a;
  public Vector<String> a;
  public AtomicBoolean a;
  public int b;
  public AtomicBoolean b;
  public int c;
  public AtomicBoolean c;
  
  assa(int paramInt, @Nonnull asrz paramasrz)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Asrz = paramasrz;
    a(true);
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 58	java/io/BufferedInputStream
    //   5: dup
    //   6: new 60	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 63	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 66	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: invokestatic 72	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_0
    //   27: aload_1
    //   28: ifnull +9 -> 37
    //   31: aload_1
    //   32: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   35: aload_2
    //   36: astore_0
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: ldc 77
    //   42: iconst_1
    //   43: ldc 79
    //   45: aload_0
    //   46: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   49: aload_2
    //   50: areturn
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: astore_0
    //   56: ldc 77
    //   58: iconst_1
    //   59: ldc 79
    //   61: aload_2
    //   62: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_3
    //   66: astore_0
    //   67: aload_1
    //   68: ifnull -31 -> 37
    //   71: aload_1
    //   72: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: ldc 77
    //   80: iconst_1
    //   81: ldc 79
    //   83: aload_0
    //   84: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: astore_0
    //   94: ldc 77
    //   96: iconst_1
    //   97: ldc 79
    //   99: aload_2
    //   100: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_3
    //   104: astore_0
    //   105: aload_1
    //   106: ifnull -69 -> 37
    //   109: aload_1
    //   110: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: ldc 77
    //   118: iconst_1
    //   119: ldc 79
    //   121: aload_0
    //   122: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_0
    //   141: ldc 77
    //   143: iconst_1
    //   144: ldc 79
    //   146: aload_0
    //   147: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: goto -12 -> 138
    //   153: astore_1
    //   154: goto -24 -> 130
    //   157: astore_2
    //   158: goto -66 -> 92
    //   161: astore_2
    //   162: goto -108 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramString	String
    //   17	93	1	localBufferedInputStream	java.io.BufferedInputStream
    //   127	12	1	localObject1	Object
    //   153	1	1	localObject2	Object
    //   24	26	2	localBitmap	Bitmap
    //   51	11	2	localException1	Exception
    //   89	11	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   157	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   161	1	2	localException2	Exception
    //   1	103	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	35	39	java/io/IOException
    //   2	18	51	java/lang/Exception
    //   71	75	77	java/io/IOException
    //   2	18	89	java/lang/OutOfMemoryError
    //   109	113	115	java/io/IOException
    //   2	18	127	finally
    //   134	138	140	java/io/IOException
    //   20	25	153	finally
    //   56	65	153	finally
    //   94	103	153	finally
    //   20	25	157	java/lang/OutOfMemoryError
    //   20	25	161	java/lang/Exception
  }
  
  private void a(Canvas paramCanvas, String paramString, int paramInt1, int paramInt2, assc paramassc, asse paramasse, float paramFloat)
  {
    int i;
    Paint localPaint;
    Bitmap localBitmap;
    Canvas localCanvas;
    Object localObject2;
    Object localObject1;
    if (paramInt1 > paramInt2)
    {
      i = paramInt1;
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localPaint.setTextSize(i);
      localPaint.setColor(-16777216);
      if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
        localPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      }
      localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localObject2 = null;
      localObject1 = paramasse.jdField_b_of_type_ArrayOfInt;
      if ((localObject1 != null) && (localObject1[3] != 0)) {
        break label972;
      }
      if (!TextUtils.isEmpty(paramasse.jdField_b_of_type_JavaLangString)) {
        break label872;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramassc.d))
      {
        if ((!paramassc.d.startsWith("#")) || (paramassc.d.length() != 9)) {
          break label818;
        }
        localPaint.setColor(Color.parseColor(paramassc.d));
        localObject1 = localObject2;
      }
      label182:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1301;
      }
      localPaint.setColor(-16777216);
      localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject1);
      paramassc = (assc)localObject1;
      if (localObject1 != null)
      {
        if (((Bitmap)localObject1).getWidth() == i)
        {
          paramassc = (assc)localObject1;
          if (((Bitmap)localObject1).getHeight() == i) {}
        }
        else
        {
          paramassc = new Matrix();
          paramassc.setScale(i / ((Bitmap)localObject1).getWidth(), i / ((Bitmap)localObject1).getHeight());
          paramassc = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramassc, false);
        }
        localPaint.setShader(new BitmapShader(paramassc, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
      }
    }
    for (;;)
    {
      localCanvas.drawColor(Color.parseColor(paramasse.jdField_c_of_type_JavaLangString));
      localCanvas.drawText(paramString, 0.0F, (int)(i / 2.0F - (localPaint.descent() + localPaint.ascent()) / 2.0F), localPaint);
      localCanvas.save();
      if (paramassc != null) {
        paramassc.recycle();
      }
      if (paramasse.jdField_c_of_type_Int > 0)
      {
        paramassc = null;
        if (!TextUtils.isEmpty(paramasse.d))
        {
          localPaint.setShader(null);
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setStrokeJoin(Paint.Join.ROUND);
          localPaint.setStrokeCap(Paint.Cap.ROUND);
          localPaint.setStrokeWidth(paramasse.jdField_c_of_type_Int * paramFloat);
          if ((!paramasse.d.startsWith("#")) || (paramasse.d.length() != 9)) {
            break label1241;
          }
          localPaint.setColor(Color.parseColor(paramasse.d));
          label485:
          if (TextUtils.isEmpty(paramassc)) {
            break label1295;
          }
          localPaint.setColor(-16777216);
          localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(paramassc);
          paramassc = (assc)localObject1;
          if (localObject1 != null)
          {
            if (((Bitmap)localObject1).getWidth() == i)
            {
              paramassc = (assc)localObject1;
              if (((Bitmap)localObject1).getHeight() == i) {}
            }
            else
            {
              paramassc = new Matrix();
              paramassc.setScale(i / ((Bitmap)localObject1).getWidth(), i / ((Bitmap)localObject1).getHeight());
              paramassc = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramassc, false);
            }
            localPaint.setShader(new BitmapShader(paramassc, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
          }
        }
      }
      for (;;)
      {
        localCanvas.drawText(paramString, 0.0F, (int)(i / 2.0F - (localPaint.descent() + localPaint.ascent()) / 2.0F), localPaint);
        localCanvas.save();
        if (paramassc != null) {
          paramassc.recycle();
        }
        paramString = new Matrix();
        if ((localBitmap.getWidth() != paramInt1) || (localBitmap.getHeight() != paramInt2)) {
          paramString.postScale(paramInt1 / localBitmap.getWidth(), paramInt2 / localBitmap.getHeight());
        }
        paramString.postTranslate(paramasse.jdField_c_of_type_ArrayOfInt[0] * paramFloat - paramInt1 / 2, paramasse.jdField_c_of_type_ArrayOfInt[1] * paramFloat - paramInt2 / 2);
        paramString.postRotate(paramasse.jdField_b_of_type_Int, paramasse.jdField_c_of_type_ArrayOfInt[0] * paramFloat, paramasse.jdField_c_of_type_ArrayOfInt[1] * paramFloat);
        paramCanvas.drawBitmap(localBitmap, paramString, localPaint);
        paramCanvas.save();
        localBitmap.recycle();
        return;
        i = paramInt2;
        break;
        label818:
        localObject1 = this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + paramassc.d;
        break label182;
        label872:
        if ((paramasse.jdField_b_of_type_JavaLangString.startsWith("#")) && (paramasse.jdField_b_of_type_JavaLangString.length() == 9))
        {
          localPaint.setColor(Color.parseColor(paramasse.jdField_b_of_type_JavaLangString));
          localObject1 = localObject2;
          break label182;
        }
        localObject1 = this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + paramasse.jdField_b_of_type_JavaLangString;
        break label182;
        label972:
        paramassc = this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + paramasse.jdField_b_of_type_JavaLangString;
        paramassc = (Bitmap)BaseApplicationImpl.sImageCache.get(paramassc);
        if (paramassc == null) {
          break label1301;
        }
        int k = paramassc.getWidth();
        int j = paramassc.getHeight();
        double d;
        if (localObject1[3] == -1)
        {
          k = (int)(Math.random() * (k - paramInt1));
          d = Math.random();
        }
        for (localObject1 = Bitmap.createBitmap(paramassc, k, (int)((j - paramInt2) * d), paramInt1, paramInt2);; localObject1 = Bitmap.createBitmap(paramassc, localObject1[0], localObject1[1], localObject1[2], localObject1[3]))
        {
          paramassc = (assc)localObject1;
          if (localObject1 == null) {
            break;
          }
          if (((Bitmap)localObject1).getWidth() == i)
          {
            paramassc = (assc)localObject1;
            if (((Bitmap)localObject1).getHeight() == i) {}
          }
          else
          {
            paramassc = new Matrix();
            paramassc.setScale(i / ((Bitmap)localObject1).getWidth(), i / ((Bitmap)localObject1).getHeight());
            paramassc = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramassc, false);
          }
          localPaint.setShader(new BitmapShader(paramassc, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
          break;
        }
        label1241:
        paramassc = this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + paramasse.d;
        break label485;
        label1295:
        paramassc = null;
      }
      label1301:
      paramassc = null;
    }
  }
  
  private void a(List<String> paramList)
  {
    ThreadManager.post(new HiBoomFontDrawer.2(this, paramList), 8, null, true);
  }
  
  private boolean a(String paramString)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("#")))
    {
      paramString = this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + paramString;
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilVector.size()) {
        break label99;
      }
      if (!paramString.equals(this.jdField_a_of_type_JavaUtilVector.get(i))) {
        break label92;
      }
    }
    label92:
    label99:
    while (BaseApplicationImpl.sImageCache.get(paramString) != null)
    {
      return false;
      i += 1;
      break;
    }
    return true;
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new HiBoomFontDrawer.3(this));
  }
  
  private void b(Canvas paramCanvas, String paramString, int paramInt1, int paramInt2, assc paramassc, asse paramasse, float paramFloat)
  {
    Paint localPaint;
    float f1;
    float f2;
    if (paramInt1 > paramInt2)
    {
      localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localPaint.setTextSize(paramInt1);
      f1 = paramasse.jdField_c_of_type_ArrayOfInt[0] * paramFloat;
      f2 = paramasse.jdField_c_of_type_ArrayOfInt[1] * paramFloat;
      localPaint.setColor(Color.parseColor(paramasse.jdField_c_of_type_JavaLangString));
      paramCanvas.drawRect(f1 - paramInt1 / 2, f2 - paramInt1 / 2, f1 + paramInt1 / 2, f2 + paramInt1 / 2, localPaint);
      paramCanvas.save();
      if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
        localPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      }
      if (!TextUtils.isEmpty(paramasse.jdField_b_of_type_JavaLangString)) {
        break label396;
      }
      if ((!TextUtils.isEmpty(paramassc.d)) && (paramassc.d.startsWith("#")) && (paramassc.d.length() == 9)) {
        localPaint.setColor(Color.parseColor(paramassc.d));
      }
    }
    for (;;)
    {
      paramCanvas.drawText(paramString, f1 - paramInt1 / 2, paramInt1 / 2.0F - (localPaint.descent() + localPaint.ascent()) / 2.0F - paramInt1 / 2 + f2, localPaint);
      paramCanvas.save();
      if ((paramasse.jdField_c_of_type_Int > 0) && (!TextUtils.isEmpty(paramasse.d)))
      {
        localPaint.setShader(null);
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setStrokeJoin(Paint.Join.ROUND);
        localPaint.setStrokeCap(Paint.Cap.ROUND);
        localPaint.setStrokeWidth(paramasse.jdField_c_of_type_Int * paramFloat);
        if ((paramasse.d.startsWith("#")) && (paramasse.d.length() == 9)) {
          localPaint.setColor(Color.parseColor(paramasse.d));
        }
        paramCanvas.drawText(paramString, f1 - paramInt1 / 2, paramInt1 / 2.0F - (localPaint.descent() + localPaint.ascent()) / 2.0F - paramInt1 / 2 + f2, localPaint);
        paramCanvas.save();
      }
      return;
      paramInt1 = paramInt2;
      break;
      label396:
      if ((paramasse.jdField_b_of_type_JavaLangString.startsWith("#")) && (paramasse.jdField_b_of_type_JavaLangString.length() == 9)) {
        localPaint.setColor(Color.parseColor(paramasse.jdField_b_of_type_JavaLangString));
      }
    }
  }
  
  public int a(boolean paramBoolean)
  {
    Object localObject = new File(this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = 0;
        while (i < localObject.length)
        {
          if (localObject[i].endsWith(".hy")) {
            return 1;
          }
          if (localObject[i].endsWith(".fz")) {
            return 2;
          }
          if (localObject[i].endsWith(".hy3")) {
            return 3;
          }
          if (localObject[i].endsWith(".fz4")) {
            return 4;
          }
          i += 1;
        }
      }
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_Asrz.a(this.jdField_b_of_type_Int);
    }
    return -1;
  }
  
  public void a()
  {
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    b();
  }
  
  public void a(HiBoomTextView paramHiBoomTextView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramHiBoomTextView));
  }
  
  public void a(String paramString, int paramInt, Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new Exception("text is null!");
    }
    if (this.jdField_a_of_type_Assb == null) {
      throw new Exception("please init font first!");
    }
    Object localObject2 = null;
    int i = paramString.length();
    Object localObject3 = this.jdField_a_of_type_Assb.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject1 = (assc)((Iterator)localObject3).next();
    } while (((assc)localObject1).jdField_a_of_type_Int != i);
    if (localObject1 == null) {
      throw new Exception("hiboomStyle error!");
    }
    int j;
    label241:
    float f1;
    if (localObject1.jdField_a_of_type_ArrayOfInt[0] >= localObject1.jdField_a_of_type_ArrayOfInt[1])
    {
      j = localObject1.jdField_a_of_type_ArrayOfInt[1] * paramInt / localObject1.jdField_a_of_type_ArrayOfInt[0];
      i = paramInt;
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      }
      if (!TextUtils.isEmpty(((assc)localObject1).jdField_c_of_type_JavaLangString))
      {
        if ((!((assc)localObject1).jdField_c_of_type_JavaLangString.startsWith("#")) || (((assc)localObject1).jdField_c_of_type_JavaLangString.length() != 9)) {
          break label553;
        }
        paramCanvas.drawColor(Color.parseColor(((assc)localObject1).jdField_c_of_type_JavaLangString));
      }
      f1 = i / localObject1.jdField_a_of_type_ArrayOfInt[0];
      paramInt = 0;
      label257:
      if (paramInt >= ((assc)localObject1).b.size()) {
        break label737;
      }
      localObject2 = (asse)((assc)localObject1).b.get(paramInt);
      i = (int)(localObject2.jdField_a_of_type_ArrayOfInt[0] * f1);
      j = (int)(localObject2.jdField_a_of_type_ArrayOfInt[1] * f1);
      if ((localObject2.jdField_a_of_type_ArrayOfInt[0] != localObject2.jdField_a_of_type_ArrayOfInt[1]) || (((!TextUtils.isEmpty(((asse)localObject2).jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(((assc)localObject1).d)) || (!((assc)localObject1).d.startsWith("#")) || (((assc)localObject1).d.length() != 9)) && ((TextUtils.isEmpty(((asse)localObject2).jdField_b_of_type_JavaLangString)) || (!((asse)localObject2).jdField_b_of_type_JavaLangString.startsWith("#")) || (((asse)localObject2).jdField_b_of_type_JavaLangString.length() != 9) || ((((asse)localObject2).jdField_c_of_type_Int > 0) && ((((asse)localObject2).jdField_c_of_type_Int <= 0) || (TextUtils.isEmpty(((asse)localObject2).d)) || (!((asse)localObject2).d.startsWith("#")) || (((asse)localObject2).d.length() != 9))) || (((asse)localObject2).jdField_b_of_type_Int != 0)))) {
        break label691;
      }
      b(paramCanvas, paramString.charAt(((asse)localObject2).jdField_a_of_type_Int) + "", i, j, (assc)localObject1, (asse)localObject2, f1);
    }
    for (;;)
    {
      paramInt += 1;
      break label257;
      i = localObject1.jdField_a_of_type_ArrayOfInt[0] * paramInt / localObject1.jdField_a_of_type_ArrayOfInt[1];
      j = paramInt;
      break;
      label553:
      localObject2 = this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + ((assc)localObject1).jdField_c_of_type_JavaLangString;
      localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject2);
      if (localObject2 == null) {
        break label241;
      }
      localObject3 = new Matrix();
      if ((((Bitmap)localObject2).getWidth() != i) || (((Bitmap)localObject2).getHeight() != j)) {
        ((Matrix)localObject3).setScale(i / ((Bitmap)localObject2).getWidth(), j / ((Bitmap)localObject2).getHeight());
      }
      paramCanvas.drawBitmap((Bitmap)localObject2, (Matrix)localObject3, this.jdField_a_of_type_AndroidGraphicsPaint);
      break label241;
      label691:
      a(paramCanvas, paramString.charAt(((asse)localObject2).jdField_a_of_type_Int) + "", i, j, (assc)localObject1, (asse)localObject2, f1);
    }
    label737:
    if (((assc)localObject1).jdField_a_of_type_JavaUtilList != null)
    {
      paramString = ((assc)localObject1).jdField_a_of_type_JavaUtilList.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (assd)paramString.next();
        if (!TextUtils.isEmpty(((assd)localObject1).jdField_a_of_type_JavaLangString))
        {
          localObject2 = this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + ((assd)localObject1).jdField_a_of_type_JavaLangString;
          localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject2);
          localObject3 = new Matrix();
          float f2 = localObject1.jdField_a_of_type_ArrayOfInt[0] * f1;
          float f3 = localObject1.jdField_a_of_type_ArrayOfInt[1] * f1;
          if (localObject2 != null)
          {
            if ((((Bitmap)localObject2).getWidth() != f2) || (((Bitmap)localObject2).getHeight() != f3)) {
              ((Matrix)localObject3).postScale(f2 / ((Bitmap)localObject2).getWidth(), f3 / ((Bitmap)localObject2).getHeight());
            }
            ((Matrix)localObject3).postTranslate(localObject1.jdField_b_of_type_ArrayOfInt[0] * f1 - f2 / 2.0F, localObject1.jdField_b_of_type_ArrayOfInt[1] * f1 - f3 / 2.0F);
            ((Matrix)localObject3).postRotate(((assd)localObject1).jdField_a_of_type_Int, localObject1.jdField_b_of_type_ArrayOfInt[0] * f1, localObject1.jdField_b_of_type_ArrayOfInt[1] * f1);
            paramCanvas.drawBitmap((Bitmap)localObject2, (Matrix)localObject3, this.jdField_a_of_type_AndroidGraphicsPaint);
            paramCanvas.save();
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ThreadManager.getFileThreadHandler().post(new HiBoomFontDrawer.1(this, paramBoolean));
  }
  
  public boolean a(int paramInt)
  {
    ArrayList localArrayList = null;
    for (;;)
    {
      Object localObject3;
      boolean bool;
      try
      {
        localObject3 = this.jdField_a_of_type_Assb.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject1 = localArrayList;
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = (assc)((Iterator)localObject3).next();
          int i = ((assc)localObject1).jdField_a_of_type_Int;
          if (i != paramInt) {
            continue;
          }
        }
        if (localObject1 == null)
        {
          bool = false;
          return bool;
        }
        localArrayList = new ArrayList();
        if (a(((assc)localObject1).jdField_c_of_type_JavaLangString)) {
          localArrayList.add(this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + ((assc)localObject1).jdField_c_of_type_JavaLangString);
        }
        if (a(((assc)localObject1).d)) {
          localArrayList.add(this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + ((assc)localObject1).d);
        }
        localObject3 = ((assc)localObject1).jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          assd localassd = (assd)((Iterator)localObject3).next();
          if (!a(localassd.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + localassd.jdField_a_of_type_JavaLangString);
          continue;
        }
        localIterator = localObject2.b.iterator();
      }
      finally {}
      Iterator localIterator;
      while (localIterator.hasNext())
      {
        localObject3 = (asse)localIterator.next();
        if (a(((asse)localObject3).jdField_c_of_type_JavaLangString)) {
          localArrayList.add(this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + ((asse)localObject3).jdField_c_of_type_JavaLangString);
        }
        if (a(((asse)localObject3).jdField_b_of_type_JavaLangString)) {
          localArrayList.add(this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + ((asse)localObject3).jdField_b_of_type_JavaLangString);
        }
        if (a(((asse)localObject3).d)) {
          localArrayList.add(this.jdField_a_of_type_Asrz.a() + this.jdField_b_of_type_Int + File.separator + "images/" + ((asse)localObject3).d);
        }
      }
      if (localArrayList.size() == 0)
      {
        bool = true;
      }
      else
      {
        a(localArrayList);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assa
 * JD-Core Version:    0.7.0.1
 */