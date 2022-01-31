import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;

@TargetApi(11)
public class azhg
  extends azfy
{
  public static double a;
  static azhg jdField_a_of_type_Azhg;
  private static ArrayList<Float> jdField_a_of_type_JavaUtilArrayList;
  public static String b;
  private static ArrayList<Float> jdField_b_of_type_JavaUtilArrayList;
  private static boolean jdField_d_of_type_Boolean;
  private static boolean e;
  public int a;
  public Camera a;
  aoai jdField_a_of_type_Aoai = aoai.a();
  azhi jdField_a_of_type_Azhi = new azhi(this);
  azhj jdField_a_of_type_Azhj;
  boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  azhj jdField_b_of_type_Azhj;
  boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int;
  int jdField_d_of_type_Int;
  
  static
  {
    if (!azhg.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      jdField_b_of_type_JavaLangString = "CameraControl";
      jdField_a_of_type_Double = 0.009999999776482582D;
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      return;
    }
  }
  
  public azhg()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static azhg a()
  {
    if (jdField_a_of_type_Azhg == null) {}
    try
    {
      if (jdField_a_of_type_Azhg == null) {
        jdField_a_of_type_Azhg = new azhg();
      }
      return jdField_a_of_type_Azhg;
    }
    finally {}
  }
  
  private azhj a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    azhj localazhj = new azhj();
    int i = j;
    if (paramList != null)
    {
      i = j;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        i = -1;
        if (paramList.hasNext())
        {
          Camera.Size localSize = (Camera.Size)paramList.next();
          if ((localSize == null) || (localSize.height != paramInt2) || (localSize.width < paramInt1) || ((i >= 0) && (localSize.width > i))) {
            break label225;
          }
          i = localSize.width;
        }
      }
    }
    label225:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localazhj.jdField_b_of_type_Int = paramInt2;
        localazhj.jdField_a_of_type_Int = i;
        if (localazhj.jdField_a_of_type_Int / 4 == localazhj.jdField_b_of_type_Int / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize[4:3]...");
          }
          return localazhj;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSize: RATIO_MUST_EQUAL=false");
        }
        return localazhj;
      }
      return null;
    }
  }
  
  private azhj a(List<Camera.Size> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] physicRatio=" + d1);
    }
    azhj localazhj = new azhj();
    Iterator localIterator;
    long l1;
    Camera.Size localSize;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize != null) && (localSize.width >= paramInt1) && (localSize.height >= paramInt2) && (localSize.width / localSize.height >= d1))
        {
          l2 = localSize.width * localSize.height;
          if (l2 < l1)
          {
            localazhj.jdField_a_of_type_Int = localSize.width;
            localazhj.jdField_b_of_type_Int = localSize.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localSize.width < localazhj.jdField_a_of_type_Int))
          {
            localazhj.jdField_a_of_type_Int = localSize.width;
            localazhj.jdField_b_of_type_Int = localSize.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localazhj.jdField_a_of_type_Int <= 0) || (localazhj.jdField_b_of_type_Int <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize != null) && (localSize.width / localSize.height >= d1))
        {
          l2 = localSize.width * localSize.height;
          if (l2 > l1)
          {
            localazhj.jdField_a_of_type_Int = localSize.width;
            localazhj.jdField_b_of_type_Int = localSize.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localSize.width < localazhj.jdField_a_of_type_Int))
          {
            localazhj.jdField_a_of_type_Int = localSize.width;
            localazhj.jdField_b_of_type_Int = localSize.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSize[self-adaption] cSize.width=" + localazhj.jdField_a_of_type_Int + "  cSize.height=" + localazhj.jdField_b_of_type_Int);
    }
    if ((localazhj.jdField_a_of_type_Int > 0) && (localazhj.jdField_b_of_type_Int > 0)) {
      return localazhj;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localazhj.jdField_a_of_type_Int = ((Camera.Size)paramList.get(0)).width;
      localazhj.jdField_b_of_type_Int = ((Camera.Size)paramList.get(0)).height;
      return localazhj;
    }
    return null;
  }
  
  private azhj a(List<Camera.Size> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramList = paramList.iterator();
    }
    label236:
    label879:
    label882:
    label885:
    label886:
    for (;;)
    {
      Object localObject3;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localObject3 = (Camera.Size)paramList.next();
        if (localObject3 == null) {
          continue;
        }
        i = Math.max(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
        j = Math.min(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
        if ((((Camera.Size)localObject3).height != paramInt2) || (i != paramInt1)) {
          break label349;
        }
        ((List)localObject1).add(new azhj(paramInt1, paramInt2));
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSizeV3 first: width=" + paramInt1 + "  height=" + paramInt2);
        }
      }
      float f1;
      float f2;
      if (((List)localObject1).size() == 0)
      {
        paramList = ((List)localObject2).iterator();
        f1 = 10000.0F;
        if (paramList.hasNext())
        {
          localObject3 = (azhj)paramList.next();
          if (localObject3 == null) {
            break label885;
          }
          paramInt1 = Math.max(((azhj)localObject3).jdField_a_of_type_Int, ((azhj)localObject3).jdField_b_of_type_Int);
          paramInt2 = Math.min(((azhj)localObject3).jdField_a_of_type_Int, ((azhj)localObject3).jdField_b_of_type_Int);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < jdField_a_of_type_Double) {
            ((List)localObject1).add(localObject3);
          }
          if (Math.abs(f3 - f2) >= f1) {
            break label885;
          }
          f1 = Math.abs(f3 - f2);
        }
      }
      for (;;)
      {
        break label236;
        if ((i <= paramInt5) || (i >= paramInt3) || (j <= paramInt6) || (j >= paramInt4)) {
          break label886;
        }
        ((List)localObject2).add(new azhj(i, j));
        break;
        f2 = f1;
        if (QLog.isColorLevel())
        {
          f2 = f1;
          if (localObject1 != null)
          {
            paramInt1 = 0;
            for (;;)
            {
              f2 = f1;
              if (paramInt1 >= ((List)localObject1).size()) {
                break;
              }
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSizeV2 secend: width=" + ((azhj)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int + " height=" + ((azhj)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int + " w/h=" + ((azhj)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int / ((azhj)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int);
              paramInt1 += 1;
            }
            f2 = 10000.0F;
          }
        }
        if (((List)localObject1).size() == 0)
        {
          paramList = ((List)localObject2).iterator();
          while (paramList.hasNext())
          {
            localObject2 = (azhj)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((azhj)localObject2).jdField_a_of_type_Int, ((azhj)localObject2).jdField_b_of_type_Int);
              paramInt2 = Math.min(((azhj)localObject2).jdField_a_of_type_Int, ((azhj)localObject2).jdField_b_of_type_Int);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < jdField_a_of_type_Double) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getHighVersionPreviewSizeV2 third: width=" + ((azhj)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int + " height=" + ((azhj)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int + " w/h=" + ((azhj)((List)localObject1).get(paramInt1)).jdField_a_of_type_Int / ((azhj)((List)localObject1).get(paramInt1)).jdField_b_of_type_Int);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (azhj)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label879;
          }
          localObject1 = (azhj)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((azhj)localObject1).jdField_a_of_type_Int * ((azhj)localObject1).jdField_b_of_type_Int <= paramList.jdField_a_of_type_Int * paramList.jdField_b_of_type_Int)) {
            break label882;
          }
          paramList = (List<Camera.Size>)localObject1;
        }
        for (;;)
        {
          break;
          localObject1 = null;
          return localObject1;
        }
      }
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "RM_CAMERA_OPEN_SUCCESS";
    case 1: 
      return "RM_CAMERA_USED_AV";
    case 2: 
      return "RM_CAMERA_COUNT_ZERO";
    case 3: 
      return "RM_CAMERA_OPEN_FAILED";
    }
    return "RM_CAMERA_GET_PARAM";
  }
  
  private static void a(ArrayList<Float> paramArrayList)
  {
    Object localObject = azhe.a().b();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        float f = localSize.width / localSize.height;
        if (!paramArrayList.contains(Float.valueOf(f))) {
          paramArrayList.add(Float.valueOf(f));
        }
      }
    }
  }
  
  private void a(List<int[]> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[listFpsRange=null]");
      }
      return;
    }
    int i = 0;
    label31:
    if (i < paramList.size())
    {
      int[] arrayOfInt = (int[])paramList.get(i);
      if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
        break label128;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[i=" + i + " fps[low]=" + arrayOfInt[0] + " fps[high]=" + arrayOfInt[1] + "]");
      }
    }
    for (;;)
    {
      i += 1;
      break label31;
      break;
      label128:
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "printFpsRange[i=" + i + " ele=null]");
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    float f1 = i / paramInt1;
    paramInt1 = Math.max(paramInt3, paramInt4);
    paramInt2 = Math.min(paramInt3, paramInt4);
    float f2 = paramInt1 / paramInt2;
    boolean bool = false;
    if (Math.abs(f2 - f1) > jdField_a_of_type_Double) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "needClip " + bool + " screenRatio" + f2 + " previewRatio" + f1);
    }
    return bool;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt4 / paramInt5 <= 1.0D) {}
    while (paramInt2 * paramInt5 / (paramInt5 * paramInt3 / paramInt4) < paramInt1) {
      return false;
    }
    return true;
  }
  
  private boolean a(ArrayList<Camera.Size> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayList.size())
      {
        Camera.Size localSize = (Camera.Size)paramArrayList.get(i);
        if ((localSize.width == paramInt1) && (localSize.height == paramInt2)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private int[] a(List<int[]> paramList)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    tmp11_7;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject2).next();
      if ((arrayOfInt2 == null) || (arrayOfInt2.length < 2) || (arrayOfInt2[1] < i)) {
        break label316;
      }
      i = arrayOfInt2[1];
    }
    label303:
    label316:
    for (;;)
    {
      break;
      if (i <= 0) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (int[])paramList.next();
        if ((localObject2 != null) && (localObject2.length >= 2) && (localObject2[1] == i)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      if (((ArrayList)localObject1).size() <= 0) {
        return null;
      }
      paramList = ((ArrayList)localObject1).iterator();
      int k = 0;
      int j = 2147483647;
      int m;
      if (paramList.hasNext())
      {
        localObject1 = (int[])paramList.next();
        if (localObject1[0] >= 15000)
        {
          m = localObject1[0] - 15000;
          label212:
          if (m >= j) {
            break label303;
          }
          j = localObject1[0];
        }
      }
      for (k = m;; k = m)
      {
        m = k;
        k = j;
        j = m;
        break;
        m = 15000 - localObject1[0];
        break label212;
        if (j != 2147483647)
        {
          arrayOfInt1[0] = k;
          arrayOfInt1[1] = i;
        }
        while ((arrayOfInt1[0] <= 0) || (arrayOfInt1[1] <= 0))
        {
          return null;
          arrayOfInt1[0] = i;
          arrayOfInt1[1] = i;
        }
        return arrayOfInt1;
        m = j;
        j = k;
      }
    }
  }
  
  private int[] a(List<int[]> paramList, int paramInt)
  {
    int[] arrayOfInt2 = a(paramList);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null) {
      arrayOfInt1 = b(paramList, paramInt);
    }
    return arrayOfInt1;
  }
  
  private int b(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = azhe.b();
    }
    do
    {
      do
      {
        return paramInt;
        paramInt = i;
      } while (!azhe.c());
      return azhe.a();
      paramInt = i;
    } while (!azhe.b());
    return azhe.b();
  }
  
  private int[] b(List<int[]> paramList, int paramInt)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = 2147483647;
    int[] tmp11_5 = tmp5_4;
    tmp11_5[1] = 2147483647;
    tmp11_5;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject).next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (arrayOfInt2[0] >= paramInt) && (arrayOfInt2[1] < arrayOfInt1[1]))
      {
        arrayOfInt1[0] = arrayOfInt2[0];
        arrayOfInt1[1] = arrayOfInt2[1];
      }
    }
    if ((arrayOfInt1[0] == 2147483647) || (arrayOfInt1[1] == 2147483647))
    {
      arrayOfInt1[1] = 0;
      arrayOfInt1[0] = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (int[])paramList.next();
        if ((localObject != null) && (localObject.length >= 2) && (localObject[0] <= paramInt) && (localObject[1] > arrayOfInt1[1]))
        {
          arrayOfInt1[0] = localObject[0];
          arrayOfInt1[1] = localObject[1];
        }
      }
    }
    if ((arrayOfInt1[0] != 2147483647) && (arrayOfInt1[1] != 2147483647)) {
      return arrayOfInt1;
    }
    return null;
  }
  
  private int c()
  {
    int i = ImageFormat.getBitsPerPixel(this.jdField_b_of_type_Int);
    float f = i * 1.0F / 8.0F;
    int j = (int)(this.jdField_a_of_type_Azhj.jdField_b_of_type_Int * this.jdField_a_of_type_Azhj.jdField_a_of_type_Int * f);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "startPreview getPreviewBufferSize:bitpixel=" + i + " byteNum=" + f + " bufSize=" + j);
    }
    return j;
  }
  
  private boolean c(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
      }
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != paramInt)) {
        this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == paramInt)) {
            break label81;
          }
          this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
          label81:
          if ((this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte.length == paramInt)) {
            continue;
          }
          this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e(jdField_b_of_type_JavaLangString, 2, "allocateFrame failed , size:" + paramInt + ", " + localOutOfMemoryError2.getMessage());
        }
      }
    }
    return true;
    return false;
  }
  
  private boolean h()
  {
    return !azhf.d(azhf.a);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if (ajpy.a()) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if (!azhe.a())
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed]hasCameras=false");
        }
        return 2;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[openCamera]Camera is opened, Camera object " + this.jdField_a_of_type_AndroidHardwareCamera);
        }
        return 5;
      }
      int j = 0;
      i = 0;
      label83:
      if (j < 10) {}
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_Int = b(paramInt);
          if (bhtb.c())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_b_of_type_JavaLangString, 2, "openCamera:currentCount= " + j);
            }
            bljn.b(jdField_b_of_type_JavaLangString, "【Real Old openCamera】:" + this.jdField_a_of_type_Int);
            bljn.b(jdField_b_of_type_JavaLangString, "【Real Old openCamera】:currentCount= " + j);
          }
          for (this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(this.jdField_a_of_type_Int);; this.jdField_a_of_type_AndroidHardwareCamera = Camera.open())
          {
            i = 0;
            if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
              break;
            }
            if (azhe.a().a(this.jdField_a_of_type_AndroidHardwareCamera)) {
              break label321;
            }
            if (QLog.isColorLevel()) {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed]bindCamera=false");
            }
            return 4;
          }
          try
          {
            Thread.sleep(300L);
            i = 3;
            break label83;
            this.jdField_a_of_type_Azhi = new azhi(this);
            this.jdField_b_of_type_Boolean = true;
            return 0;
          }
          catch (InterruptedException localInterruptedException)
          {
            break label316;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
        j += 1;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] openCamera[failed][RM_CAMERA_OPEN_FAILED]currentCount=" + j, localException);
        }
        if (j >= 10) {}
      }
    }
  }
  
  public Camera.Parameters a()
  {
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, localException, new Object[0]);
    }
    return null;
  }
  
  public azhj a()
  {
    return this.jdField_a_of_type_Azhj;
  }
  
  public azhj a(int paramInt)
  {
    Object localObject2 = azhe.a().a();
    int i;
    if ((QLog.isColorLevel()) && (localObject2 != null))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getStarPhotoPreviewSize[list]: width=" + ((Camera.Size)((List)localObject2).get(i)).width + " height=" + ((Camera.Size)((List)localObject2).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject2).get(i)).width / ((Camera.Size)((List)localObject2).get(i)).height);
        i += 1;
      }
    }
    Object localObject1 = new ArrayList();
    azhj localazhj = new azhj();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
        if ((localSize != null) && (localSize.height >= paramInt)) {
          ((List)localObject1).add(localSize);
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      for (paramInt = 2147483647; ((Iterator)localObject1).hasNext(); paramInt = i)
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        i = paramInt;
        if (((Camera.Size)localObject2).width < paramInt)
        {
          i = ((Camera.Size)localObject2).width;
          localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
          localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
        }
      }
    }
    if (localazhj.jdField_a_of_type_Int > 0) {
      return localazhj;
    }
    return null;
  }
  
  public azhj a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = azhe.a().a();
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      paramInt2 = 0;
      while (paramInt2 < ((List)localObject2).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[list]: width=" + ((Camera.Size)((List)localObject2).get(paramInt2)).width + " height=" + ((Camera.Size)((List)localObject2).get(paramInt2)).height + " w/h=" + ((Camera.Size)((List)localObject2).get(paramInt2)).width / ((Camera.Size)((List)localObject2).get(paramInt2)).height);
        paramInt2 += 1;
      }
    }
    double d1;
    Object localObject4;
    Object localObject3;
    azhj localazhj;
    Object localObject5;
    label259:
    if (ajpx.jdField_a_of_type_Int == 1)
    {
      if (!e)
      {
        a(jdField_b_of_type_JavaUtilArrayList);
        e = true;
      }
      localObject1 = jdField_b_of_type_JavaUtilArrayList;
      d1 = paramInt4 / paramInt3;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] physicRatio=" + d1);
      }
      localObject4 = new ArrayList(3);
      localObject3 = new ArrayList(3);
      localazhj = new azhj();
      localObject5 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label400;
      }
      Camera.Size localSize = (Camera.Size)((Iterator)localObject5).next();
      if (localSize != null)
      {
        double d2 = localSize.width / localSize.height;
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (localIterator.hasNext())
        {
          if (Math.abs(((Float)localIterator.next()).floatValue() - d2) > 0.009999999776482582D) {
            break label259;
          }
          if (d2 >= d1)
          {
            ((ArrayList)localObject4).add(localSize);
            continue;
            if (!d)
            {
              a(jdField_a_of_type_JavaUtilArrayList);
              d = true;
            }
            localObject1 = jdField_a_of_type_JavaUtilArrayList;
            break;
          }
          ((ArrayList)localObject3).add(localSize);
        }
      }
    }
    label400:
    int i = azfx.jdField_c_of_type_Int;
    int j = azfx.d;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] previewWidth=" + i + "previewHeight=" + j);
    }
    Object localObject1 = ((ArrayList)localObject4).iterator();
    paramInt2 = -1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject5 = (Camera.Size)((Iterator)localObject1).next();
      if ((localObject5 == null) || (((Camera.Size)localObject5).height != j) || (((Camera.Size)localObject5).width < i) || ((paramInt2 >= 0) && (((Camera.Size)localObject5).width > paramInt2))) {
        break label1402;
      }
      paramInt2 = ((Camera.Size)localObject5).width;
    }
    label1399:
    label1402:
    for (;;)
    {
      break;
      if (paramInt2 > 0)
      {
        localazhj.jdField_b_of_type_Int = j;
        localazhj.jdField_a_of_type_Int = paramInt2;
        if ((azhf.a()) && (a((ArrayList)localObject3, i, j))) {
          localazhj.jdField_a_of_type_Int = i;
        }
        return localazhj;
      }
      localObject1 = ((ArrayList)localObject3).iterator();
      long l1 = 9223372036854775807L;
      long l2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject5 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject5 != null) && (a(paramInt1, paramInt3, paramInt4, ((Camera.Size)localObject5).width, ((Camera.Size)localObject5).height)))
        {
          l2 = ((Camera.Size)localObject5).width * ((Camera.Size)localObject5).height;
          if (l2 < l1)
          {
            localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject5).width;
            localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject5).height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (((Camera.Size)localObject5).width < localazhj.jdField_a_of_type_Int))
          {
            localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject5).width;
            localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject5).height;
          }
        }
      }
      if ((localazhj.jdField_a_of_type_Int > 0) || (localazhj.jdField_b_of_type_Int > 0)) {
        return localazhj;
      }
      paramInt2 = azfx.g[1];
      i = azfx.h[1];
      localObject1 = ((ArrayList)localObject4).iterator();
      paramInt1 = -1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject5 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject5 == null) || (((Camera.Size)localObject5).height != i) || (((Camera.Size)localObject5).width < paramInt2) || ((paramInt1 >= 0) && (((Camera.Size)localObject5).width > paramInt1))) {
          break label1399;
        }
        paramInt1 = ((Camera.Size)localObject5).width;
      }
      for (;;)
      {
        break;
        if (paramInt1 > 0)
        {
          localazhj.jdField_b_of_type_Int = i;
          localazhj.jdField_a_of_type_Int = paramInt1;
          return localazhj;
        }
        if ((localazhj.jdField_a_of_type_Int <= 0) || (localazhj.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((ArrayList)localObject4).iterator();
          l1 = 9223372036854775807L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject4 != null)
            {
              l2 = ((Camera.Size)localObject4).width * ((Camera.Size)localObject4).height;
              if (l2 < l1)
              {
                localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject4).width;
                localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject4).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject4).width < localazhj.jdField_a_of_type_Int))
              {
                localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject4).width;
                localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject4).height;
              }
            }
          }
        }
        if ((localazhj.jdField_a_of_type_Int <= 0) || (localazhj.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((ArrayList)localObject3).iterator();
          l1 = 9223372036854775807L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Camera.Size)((Iterator)localObject1).next();
            if ((localObject3 != null) && (a(320, paramInt3, paramInt4, ((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height)))
            {
              l2 = ((Camera.Size)localObject3).width * ((Camera.Size)localObject3).height;
              if (l2 < l1)
              {
                localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
                localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject3).width < localazhj.jdField_a_of_type_Int))
              {
                localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject3).width;
                localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject3).height;
              }
            }
          }
        }
        if ((localazhj.jdField_a_of_type_Int <= 0) || (localazhj.jdField_b_of_type_Int <= 0))
        {
          localObject1 = ((List)localObject2).iterator();
          l1 = 0L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              l2 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
              if (l2 > l1)
              {
                localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject2).width < localazhj.jdField_a_of_type_Int))
              {
                localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
                localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getFullVideoPreviewSize[self-adaption] cSize.width=" + localazhj.jdField_a_of_type_Int + "  cSize.height=" + localazhj.jdField_b_of_type_Int);
        }
        if ((localazhj.jdField_a_of_type_Int > 0) && (localazhj.jdField_b_of_type_Int > 0)) {
          return localazhj;
        }
        return null;
      }
    }
  }
  
  public azhj a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Azhj == null)) {
      throw new AssertionError();
    }
    if (a() == null) {
      return null;
    }
    int i = Math.min(paramInt1, paramInt2);
    paramInt1 = Math.max(paramInt1, paramInt2);
    float f3 = paramInt1 / i;
    azhj localazhj = new azhj();
    Object localObject1 = azhe.a().b();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return null;
    }
    Object localObject2 = new azhj();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    float f1 = 10000.0F;
    while (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      if (localSize != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setPictureSize[list]: width=" + localSize.width + " height=" + localSize.height + " w/h=" + localSize.width / localSize.height);
        }
        float f4 = localSize.width / localSize.height;
        if (Math.abs(f4 - f3) <= jdField_a_of_type_Double) {
          localArrayList.add(localSize);
        }
        float f2 = f1;
        if (localSize.width >= paramInt1)
        {
          f2 = f1;
          if (f1 > Math.abs(f4 - f3))
          {
            f2 = Math.abs(f4 - f3);
            ((azhj)localObject2).jdField_a_of_type_Int = localSize.width;
            ((azhj)localObject2).jdField_b_of_type_Int = localSize.height;
          }
        }
        f1 = f2;
      }
    }
    if ((localArrayList.isEmpty()) && (((azhj)localObject2).jdField_a_of_type_Int >= paramInt1))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "getPictureSize: width=" + ((azhj)localObject2).jdField_a_of_type_Int + " height=" + ((azhj)localObject2).jdField_b_of_type_Int + " w/h=" + ((azhj)localObject2).jdField_a_of_type_Int / ((azhj)localObject2).jdField_b_of_type_Int);
      }
      return localObject2;
    }
    if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
    {
      localazhj.jdField_a_of_type_Int = ((Camera.Size)((List)localObject1).get(0)).width;
      localazhj.jdField_b_of_type_Int = ((Camera.Size)((List)localObject1).get(0)).height;
      return localazhj;
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    if (paramInt5 == -1)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        if (localazhj.jdField_a_of_type_Int < ((Camera.Size)localObject2).width)
        {
          localazhj.jdField_a_of_type_Int = ((Camera.Size)localObject2).width;
          localazhj.jdField_b_of_type_Int = ((Camera.Size)localObject2).height;
        }
      }
    }
    while (localazhj.jdField_a_of_type_Int == 0)
    {
      return null;
      localazhj = a(paramInt3, paramInt4, paramInt5, localArrayList);
    }
    return localazhj;
  }
  
  public azhj a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeV2: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = azhe.a().a();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    azhj localazhj = a((List)localObject, paramInt1, paramInt2);
    if (localazhj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localazhj;
      if (paramBoolean)
      {
        ajrw.a(2, paramInt1, paramInt2, localazhj.jdField_a_of_type_Int, localazhj.jdField_b_of_type_Int);
        localObject = localazhj;
      }
    }
    do
    {
      do
      {
        return localObject;
        localazhj = a((List)localObject, 960, 720);
        if (localazhj == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
        }
        localObject = localazhj;
      } while (!paramBoolean);
      ajrw.a(3, paramInt1, paramInt2, localazhj.jdField_a_of_type_Int, localazhj.jdField_b_of_type_Int);
      return localazhj;
      localazhj = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = localazhj;
    } while (!paramBoolean);
    if (localazhj == null)
    {
      paramInt3 = 0;
      if (localazhj != null) {
        break label379;
      }
    }
    label379:
    for (paramInt4 = j;; paramInt4 = localazhj.jdField_b_of_type_Int)
    {
      ajrw.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localazhj;
      paramInt3 = localazhj.jdField_a_of_type_Int;
      break;
    }
  }
  
  public azhj a(int paramInt1, int paramInt2, int paramInt3, List<Camera.Size> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    azhj localazhj = new azhj(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      paramInt2 = Math.abs(localSize.width - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label133;
      }
      localazhj.jdField_a_of_type_Int = localSize.width;
      localazhj.jdField_b_of_type_Int = localSize.height;
      paramInt1 = paramInt2;
    }
    label133:
    for (;;)
    {
      break;
      return localazhj;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "releasePreviewFrameBuffer");
    }
  }
  
  @TargetApi(14)
  public void a(Camera.FaceDetectionListener paramFaceDetectionListener)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setFaceDetectionListener(paramFaceDetectionListener);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "setFaceDetectionListener");
      }
      return;
    }
    catch (Exception paramFaceDetectionListener)
    {
      for (;;)
      {
        paramFaceDetectionListener.printStackTrace();
      }
    }
  }
  
  @TargetApi(17)
  public void a(File paramFile, Rect paramRect, ajwh paramajwh, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[takePicture]mCamera " + null);
      }
    }
    for (;;)
    {
      return;
      ajrw.a("begin pic taken");
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.enableShutterSound(false);
        try
        {
          long l = System.currentTimeMillis();
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, null, new azhh(this, paramInt1, l, paramFile, paramRect, paramajwh, paramBoolean, paramInt2));
          return;
        }
        catch (RuntimeException paramFile) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_b_of_type_JavaLangString, 2, "", paramFile);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.i(jdField_b_of_type_JavaLangString, 1, "[takePicture]enableShutterSound error, ", localException);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (c(c())))
    {
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (paramArrayOfByte != null)) {
      this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramArrayOfByte);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
      return false;
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + "]");
    }
    boolean bool2 = a(paramInt, false);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=false success=" + bool2 + "]");
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = a(paramInt, true);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=true success=" + bool2 + "]");
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setPreviewFps[failed]getCameraParameters=null");
      }
    }
    int[] arrayOfInt;
    do
    {
      return false;
      arrayOfInt = a(paramInt, paramBoolean);
      if ((arrayOfInt != null) && (arrayOfInt.length >= 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "setPreviewFps[getFpsRange=null]");
    return false;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "setPreviewFps[ fps[low]=" + arrayOfInt[0] + " fps[high]=" + arrayOfInt[1] + "]");
    }
    try
    {
      localParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      paramBoolean = a(localParameters);
      return paramBoolean;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramSurfaceTexture == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setPreviewTexture] mIsPreviewing=" + this.jdField_a_of_type_Boolean);
    return true;
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(paramSurfaceTexture);
      return true;
    }
    catch (Exception paramSurfaceTexture)
    {
      paramSurfaceTexture.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setPreviewTexture] exp=", paramSurfaceTexture);
      }
    }
    return false;
  }
  
  public boolean a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!this.jdField_a_of_type_Boolean) || (!h())) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(paramAutoFocusCallback);
      return true;
    }
    catch (Exception paramAutoFocusCallback) {}
    return false;
  }
  
  public boolean a(Camera.Parameters paramParameters)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (paramParameters == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 2, paramParameters, new Object[0]);
    }
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, SurfaceHolder paramSurfaceHolder)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramPreviewCallback == null) || (paramSurfaceHolder == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] mCamera=" + this.jdField_a_of_type_AndroidHardwareCamera + " holder=" + paramSurfaceHolder + " callback=" + paramPreviewCallback);
      }
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception paramPreviewCallback)
    {
      paramPreviewCallback.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramPreviewCallback.getMessage());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramPreviewCallback);
      }
    }
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramPreviewCallback == null)) {
      return false;
    }
    if (paramBoolean) {
      try
      {
        if (c(c()))
        {
          this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
          this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
        }
      }
      catch (Exception paramPreviewCallback)
      {
        paramPreviewCallback.printStackTrace();
        return false;
      }
    } else {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(paramPreviewCallback);
    }
    return true;
  }
  
  public boolean a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (paramSurfaceHolder == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setSurfaceHolder] mIsPreviewing=" + this.jdField_a_of_type_Boolean);
    return true;
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(paramSurfaceHolder);
      return true;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "@$[setSurfaceHolder] exp=", paramSurfaceHolder);
      }
    }
    return false;
  }
  
  public boolean a(azhj paramazhj)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewSize[failed]getCameraParameters=null");
      }
      return false;
    }
    try
    {
      localParameters.setPreviewSize(paramazhj.jdField_a_of_type_Int, paramazhj.jdField_b_of_type_Int);
      this.jdField_a_of_type_Azhj = paramazhj;
      boolean bool = a(localParameters);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewSize, result = " + bool + ",size.width = " + paramazhj.jdField_a_of_type_Int + ",size.height = " + paramazhj.jdField_b_of_type_Int);
      }
      return bool;
    }
    catch (Exception paramazhj)
    {
      paramazhj.printStackTrace();
    }
    return false;
  }
  
  public boolean a(azhx paramazhx)
  {
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      return false;
    }
    localParameters.setPreviewFormat(paramazhx.jdField_a_of_type_Int);
    localParameters.setPreviewSize(paramazhx.jdField_a_of_type_Azhj.jdField_a_of_type_Int, paramazhx.jdField_a_of_type_Azhj.jdField_b_of_type_Int);
    localParameters.setPreviewFpsRange(paramazhx.jdField_b_of_type_Int, paramazhx.jdField_c_of_type_Int);
    if (paramazhx.jdField_a_of_type_Boolean) {
      localParameters.setPictureSize(paramazhx.jdField_b_of_type_Azhj.jdField_a_of_type_Int, paramazhx.jdField_b_of_type_Azhj.jdField_b_of_type_Int);
    }
    boolean bool = a(localParameters);
    if (bool)
    {
      this.jdField_b_of_type_Int = paramazhx.jdField_a_of_type_Int;
      this.jdField_a_of_type_Azhj = paramazhx.jdField_a_of_type_Azhj;
      this.jdField_a_of_type_ArrayOfInt = new int[] { paramazhx.jdField_b_of_type_Int, paramazhx.jdField_c_of_type_Int };
      this.jdField_b_of_type_Azhj = paramazhx.jdField_b_of_type_Azhj;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (!h()) {}
    boolean bool3;
    do
    {
      for (;;)
      {
        return bool2;
        try
        {
          this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
          Camera.Parameters localParameters = a();
          if (localParameters != null)
          {
            String str = localParameters.getFocusMode();
            if (QLog.isColorLevel()) {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsFocusMode getFocusMode=" + str);
            }
            if ((str != null) && (str.equals(paramString))) {
              return true;
            }
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "", localRuntimeException);
            }
          }
          bool3 = azhe.a().a(paramString);
          if (bool3)
          {
            localRuntimeException.setFocusMode(paramString);
            bool1 = a(localRuntimeException);
          }
          bool2 = bool1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsFocusMode support=" + bool3 + " success=" + bool1 + " setTo=" + paramString);
    return bool1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (azhe.a().e())
    {
      Camera.Parameters localParameters = a();
      String str = localParameters.getFlashMode();
      if ((paramBoolean) && (!TextUtils.equals(str, "on"))) {
        localParameters.setFlashMode("on");
      }
      for (;;)
      {
        return a(localParameters);
        if ((!paramBoolean) && (!TextUtils.equals(str, "off"))) {
          localParameters.setFlashMode("off");
        }
      }
    }
    return false;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 2147483647;
    int[] tmp13_7 = tmp7_5;
    tmp13_7[1] = 2147483647;
    tmp13_7;
    int i = paramInt * 1000;
    List localList = azhe.a().c();
    if (localList == null)
    {
      arrayOfInt1[0] = i;
      arrayOfInt1[1] = i;
      return arrayOfInt1;
    }
    a(localList);
    if (!paramBoolean) {
      return a(localList, paramInt);
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt2 = (int[])localIterator.next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (i >= arrayOfInt2[0]) && (i <= arrayOfInt2[1]))
      {
        arrayOfInt1[0] = i;
        arrayOfInt1[1] = arrayOfInt2[1];
        return arrayOfInt1;
      }
    }
    return a(localList, paramInt);
  }
  
  public azhj[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    }
    azhj[] arrayOfazhj = new azhj[2];
    azhj localazhj1 = a(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localazhj1 != null)
    {
      arrayOfazhj[0] = localazhj1;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localazhj1.jdField_a_of_type_Int + " " + localazhj1.jdField_b_of_type_Int);
      }
      azhj localazhj2 = a(localazhj1.jdField_a_of_type_Int, localazhj1.jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      arrayOfazhj[1] = localazhj2;
      if (localazhj2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localazhj2.jdField_a_of_type_Int + " " + localazhj2.jdField_b_of_type_Int);
        }
        ajrw.a(true, localazhj1.jdField_a_of_type_Int, localazhj1.jdField_b_of_type_Int, localazhj2.jdField_a_of_type_Int, localazhj2.jdField_b_of_type_Int);
      }
    }
    else
    {
      return arrayOfazhj;
    }
    ajrw.a(true, localazhj1.jdField_a_of_type_Int, localazhj1.jdField_b_of_type_Int, -1, -1);
    return arrayOfazhj;
  }
  
  public int b()
  {
    int j = this.jdField_c_of_type_Int;
    if (ajpx.jdField_a_of_type_Int == 1) {
      if (this.jdField_c_of_type_Int != 270) {
        break label70;
      }
    }
    label70:
    for (int i = this.jdField_c_of_type_Int - 180;; i = this.jdField_c_of_type_Int + 180)
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "getPreviewOrientation:blackPhone= orientation=" + i);
        j = i;
      }
      return j;
    }
  }
  
  public azhj b()
  {
    return this.jdField_b_of_type_Azhj;
  }
  
  public azhj b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeV3: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = azhe.a().a();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    float f2 = 1.0F * paramInt1 / paramInt2 * 1000.0F;
    float f1 = f2;
    if (f2 > 1700.0F) {
      f1 = 1700.0F;
    }
    azhj localazhj = a((List)localObject, paramInt1, paramInt2, 2600, 1500, (int)f1, 1000);
    if (localazhj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localazhj;
      if (paramBoolean)
      {
        ajrw.a(2, paramInt1, paramInt2, localazhj.jdField_a_of_type_Int, localazhj.jdField_b_of_type_Int);
        localObject = localazhj;
      }
    }
    do
    {
      return localObject;
      f2 = 1.0F * paramInt1 / paramInt2 * 700.0F;
      f1 = f2;
      if (f2 > 1000.0F) {
        f1 = 1000.0F;
      }
      localazhj = a((List)localObject, paramInt1, paramInt2, 2600, 1500, (int)f1, 700);
      if (localazhj == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      localObject = localazhj;
    } while (!paramBoolean);
    ajrw.a(3, paramInt1, paramInt2, localazhj.jdField_a_of_type_Int, localazhj.jdField_b_of_type_Int);
    return localazhj;
    localObject = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject != null) {
        break label444;
      }
      paramInt3 = 0;
      if (localObject != null) {
        break label453;
      }
    }
    label444:
    label453:
    for (paramInt4 = 0;; paramInt4 = ((azhj)localObject).jdField_b_of_type_Int)
    {
      ajrw.a(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject;
      paramInt3 = ((azhj)localObject).jdField_a_of_type_Int;
      break;
    }
  }
  
  @TargetApi(14)
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "release camera");
    }
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      azhe.a().a();
    } while (this.jdField_a_of_type_AndroidHardwareCamera == null);
    d();
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_ArrayOfInt = null;
      this.jdField_a_of_type_Azhj = null;
      this.jdField_b_of_type_Boolean = false;
      a();
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 347	azhg:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 529	azhg:jdField_a_of_type_Boolean	Z
    //   13: ifne +5 -> 18
    //   16: iconst_1
    //   17: ireturn
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 529	azhg:jdField_a_of_type_Boolean	Z
    //   23: aload_0
    //   24: invokespecial 595	azhg:h	()Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +10 -> 39
    //   32: aload_0
    //   33: getfield 347	azhg:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   36: invokevirtual 598	android/hardware/Camera:cancelAutoFocus	()V
    //   39: aload_0
    //   40: getfield 347	azhg:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   43: invokevirtual 750	android/hardware/Camera:stopPreview	()V
    //   46: aload_0
    //   47: getfield 347	azhg:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   50: aconst_null
    //   51: invokevirtual 621	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   54: aload_0
    //   55: getfield 347	azhg:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   58: aconst_null
    //   59: invokevirtual 617	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_2
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_2
    //   68: goto -29 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	azhg
    //   27	2	1	bool	boolean
    //   64	1	2	localException	Exception
    //   67	1	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   18	28	64	java/lang/Exception
    //   32	39	64	java/lang/Exception
    //   39	62	64	java/lang/Exception
    //   32	39	67	java/lang/RuntimeException
  }
  
  public boolean b(int paramInt)
  {
    int j = 0;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters;
    int i;
    if (azhe.a().d())
    {
      localParameters = a();
      if (localParameters == null) {
        return false;
      }
      i = localParameters.getMaxZoom();
      paramInt = localParameters.getZoom() + paramInt;
      if (paramInt >= 0) {
        break label90;
      }
      paramInt = j;
    }
    label90:
    for (;;)
    {
      if (paramInt > i) {
        paramInt = i;
      }
      for (;;)
      {
        localParameters.setZoom(paramInt);
        return a(localParameters);
        return false;
      }
    }
  }
  
  public boolean b(azhj paramazhj)
  {
    Camera.Parameters localParameters = a();
    if (localParameters == null) {}
    do
    {
      return false;
      try
      {
        localParameters.setPictureSize(paramazhj.jdField_a_of_type_Int, paramazhj.jdField_b_of_type_Int);
        this.jdField_b_of_type_Azhj = paramazhj;
        boolean bool = a(localParameters);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "setRawPictureSize w " + paramazhj.jdField_a_of_type_Int + ", h " + paramazhj.jdField_b_of_type_Int + ", success=" + bool);
        }
        return bool;
      }
      catch (Exception paramazhj)
      {
        paramazhj.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "setParamsPictureSize", paramazhj);
    return false;
  }
  
  public boolean b(String paramString)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (azhe.a().b(paramString))
    {
      Camera.Parameters localParameters = a();
      String str = localParameters.getSceneMode();
      if ((str != null) && (!str.equals(paramString)))
      {
        localParameters.setSceneMode(paramString);
        boolean bool = a(localParameters);
        if (QLog.isColorLevel()) {
          QLog.e(jdField_b_of_type_JavaLangString, 2, new Object[] { "setSceneMode success: ", Boolean.valueOf(bool) });
        }
        return bool;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (azhe.a().e())
    {
      Camera.Parameters localParameters = a();
      if (paramBoolean) {}
      for (String str = "torch";; str = "off")
      {
        localParameters.setFlashMode(str);
        return a(localParameters);
      }
    }
    return false;
  }
  
  public azhj[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    }
    azhj[] arrayOfazhj = new azhj[2];
    azhj localazhj1 = b(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localazhj1 != null)
    {
      arrayOfazhj[0] = localazhj1;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localazhj1.jdField_a_of_type_Int + " " + localazhj1.jdField_b_of_type_Int);
      }
      azhj localazhj2 = a(localazhj1.jdField_a_of_type_Int, localazhj1.jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      arrayOfazhj[1] = localazhj2;
      if (localazhj2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localazhj2.jdField_a_of_type_Int + " " + localazhj2.jdField_b_of_type_Int);
        }
        ajrw.a(true, localazhj1.jdField_a_of_type_Int, localazhj1.jdField_b_of_type_Int, localazhj2.jdField_a_of_type_Int, localazhj2.jdField_b_of_type_Int);
      }
    }
    else
    {
      return arrayOfazhj;
    }
    ajrw.a(true, localazhj1.jdField_a_of_type_Int, localazhj1.jdField_b_of_type_Int, -1, -1);
    return arrayOfazhj;
  }
  
  public azhj c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = azhe.a().a();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    azhj localazhj = a((List)localObject, azfx.jdField_c_of_type_Int, azfx.d);
    if (localazhj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localazhj;
      if (paramBoolean)
      {
        ajrw.a(2, azfx.jdField_c_of_type_Int, azfx.d, localazhj.jdField_a_of_type_Int, localazhj.jdField_b_of_type_Int);
        localObject = localazhj;
      }
    }
    do
    {
      do
      {
        return localObject;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: Degeneration to 640*480...");
        }
        localazhj = a((List)localObject, azfx.jdField_a_of_type_ArrayOfInt[1], azfx.b[1]);
        if (localazhj == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
        }
        localObject = localazhj;
      } while (!paramBoolean);
      ajrw.a(3, azfx.jdField_c_of_type_Int, azfx.d, localazhj.jdField_a_of_type_Int, localazhj.jdField_b_of_type_Int);
      return localazhj;
      localazhj = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = localazhj;
    } while (!paramBoolean);
    if (localazhj == null)
    {
      paramInt1 = 0;
      if (localazhj != null) {
        break label413;
      }
    }
    label413:
    for (paramInt2 = j;; paramInt2 = localazhj.jdField_b_of_type_Int)
    {
      ajrw.a(4, azfx.jdField_c_of_type_Int, azfx.d, paramInt1, paramInt2);
      return localazhj;
      paramInt1 = localazhj.jdField_a_of_type_Int;
      break;
    }
  }
  
  @TargetApi(14)
  public void c()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.startFaceDetection();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "startFaceDetection");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean c()
  {
    int j = 90;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Object localObject = Build.MODEL.toUpperCase();
    int i;
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && ((((String)localObject).contains("RLI-AN00")) || (((String)localObject).contains("RLI-N29")) || (((String)localObject).contains("TAH-AN00")) || (((String)localObject).contains("TAH-N29"))))
    {
      i = 1;
      if (i == 0)
      {
        i = j;
        if (Build.VERSION.SDK_INT < 28) {}
      }
      else
      {
        localObject = new Camera.CameraInfo();
        Camera.getCameraInfo(this.jdField_a_of_type_Int, (Camera.CameraInfo)localObject);
        switch (((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay().getRotation())
        {
        default: 
          i = 90;
          label175:
          if (((Camera.CameraInfo)localObject).facing == 1) {
            i = (360 - (i + ((Camera.CameraInfo)localObject).orientation) % 360) % 360;
          }
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int == 1)
        {
          bool1 = azhf.d(azhf.e);
          bool2 = azhf.b(azhf.f);
          if (bool1) {
            break label405;
          }
          if (!bool2) {
            break label402;
          }
          break label405;
          this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(i);
          this.jdField_c_of_type_Int = i;
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "setDisplayOrientation degrees=" + i + " blackPhone=" + bool1 + " camera=" + ajpx.jdField_a_of_type_Int + " rom_black=" + bool2);
          }
          return true;
          i = 0;
          break;
          i = 0;
          break label175;
          i = 90;
          break label175;
          i = 180;
          break label175;
          i = 270;
          break label175;
          i = (((Camera.CameraInfo)localObject).orientation - i + 360) % 360;
          continue;
        }
        boolean bool1 = azhf.d(azhf.g);
        if (bool1)
        {
          i += 180;
          bool2 = false;
          continue;
        }
        boolean bool2 = false;
      }
      catch (Exception localException)
      {
        return false;
      }
      continue;
      label402:
      continue;
      label405:
      i += 180;
    }
  }
  
  public azhj[] c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee wanted size=" + azfx.jdField_c_of_type_Int + " " + azfx.d + " cliped=" + paramInt1 + " " + paramInt2);
    }
    if (0 != 0)
    {
      paramInt1 = azfx.jdField_c_of_type_Int;
      paramInt1 = azfx.d;
      throw new NullPointerException();
    }
    azhj[] arrayOfazhj = new azhj[2];
    azhj localazhj2 = c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localazhj2 != null)
    {
      arrayOfazhj[0] = localazhj2;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localazhj2.jdField_a_of_type_Int + " " + localazhj2.jdField_b_of_type_Int);
      }
      azhj localazhj1 = a(localazhj2.jdField_a_of_type_Int, localazhj2.jdField_b_of_type_Int, paramInt3, paramInt4, 1);
      arrayOfazhj[1] = localazhj1;
      if (localazhj1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localazhj1.jdField_a_of_type_Int + " " + localazhj1.jdField_b_of_type_Int);
        }
        ajrw.a(true, localazhj2.jdField_a_of_type_Int, localazhj2.jdField_b_of_type_Int, localazhj1.jdField_a_of_type_Int, localazhj1.jdField_b_of_type_Int);
        return arrayOfazhj;
      }
      ajrw.a(true, localazhj2.jdField_a_of_type_Int, localazhj2.jdField_b_of_type_Int, -1, -1);
    }
    return arrayOfazhj;
  }
  
  @TargetApi(14)
  public void d()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setFaceDetectionListener(null);
      this.jdField_a_of_type_AndroidHardwareCamera.stopFaceDetection();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "stopFaceDetection");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  @TargetApi(14)
  public boolean d()
  {
    boolean bool = false;
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      i = this.jdField_a_of_type_AndroidHardwareCamera.getParameters().getMaxNumDetectedFaces();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "supportFaceDetect" + i);
      }
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public boolean e()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    boolean bool1;
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (!azhe.a().a(17)) {
                  break;
                }
                localParameters.setPreviewFormat(17);
                this.jdField_b_of_type_Int = 17;
                bool2 = a(localParameters);
                bool1 = bool2;
              } while (!QLog.isColorLevel());
              QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + ", isSupportPreviewFormat=NV21 ok");
              return bool2;
              if (!azhe.a().a(842094169)) {
                break;
              }
              localParameters.setPreviewFormat(842094169);
              this.jdField_b_of_type_Int = 842094169;
              bool2 = a(localParameters);
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=YV12 OK");
            return bool2;
            if (!azhe.a().a(20)) {
              break;
            }
            localParameters.setPreviewFormat(20);
            this.jdField_b_of_type_Int = 20;
            bool2 = a(localParameters);
            bool1 = bool2;
          } while (!QLog.isColorLevel());
          QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=YUY2 OK");
          return bool2;
          if (!azhe.a().a(4)) {
            break;
          }
          localParameters.setPreviewFormat(4);
          this.jdField_b_of_type_Int = 4;
          bool2 = a(localParameters);
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=RGB_565 OK");
        return bool2;
        if (!azhe.a().a(256)) {
          break;
        }
        localParameters.setPreviewFormat(256);
        this.jdField_b_of_type_Int = 256;
        bool2 = a(localParameters);
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=JPEG OK");
      return bool2;
      if (!azhe.a().a(16)) {
        break;
      }
      localParameters.setPreviewFormat(16);
      this.jdField_b_of_type_Int = 16;
      bool2 = a(localParameters);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=NV16 OK");
    return bool2;
    return false;
  }
  
  public boolean f()
  {
    if ((!jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (azhe.a().e())
    {
      Camera.Parameters localParameters = a();
      if (TextUtils.equals(localParameters.getFlashMode(), "torch")) {
        localParameters.setFlashMode("off");
      }
      for (;;)
      {
        return a(localParameters);
        localParameters.setFlashMode("torch");
      }
    }
    return false;
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhg
 * JD-Core Version:    0.7.0.1
 */