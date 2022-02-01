import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qflutter.resource_loader.NinePatchChunk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinData;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import rx.Observable;
import rx.schedulers.Schedulers;

class azym
{
  private SparseArray<String> a = new SparseArray();
  private SparseArray<String> b = new SparseArray();
  
  private Bitmap a(Bitmap paramBitmap, String paramString)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramString.endsWith(".9.png"))
    {
      localBitmap = paramBitmap;
      if (NinePatch.isNinePatchChunk(paramBitmap.getNinePatchChunk()))
      {
        paramString = NinePatchChunk.deserialize(paramBitmap.getNinePatchChunk());
        localBitmap = paramBitmap;
        if (paramString != null)
        {
          int j = paramBitmap.getWidth() + 2;
          int k = paramBitmap.getHeight() + 2;
          localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.translate(1.0F, 1.0F);
          localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
          int m = paramString.mPaddings.left;
          int n = paramString.mPaddings.right;
          int i1 = paramString.mPaddings.top;
          int i2 = paramString.mPaddings.bottom;
          int i = 1;
          while (i < Math.max(k, j) - 1)
          {
            if (a(paramString, i, true)) {
              localBitmap.setPixel(i, 0, -16777216);
            }
            if ((i > m) && (i < j - 1 - n)) {
              localBitmap.setPixel(i, k - 1, -16777216);
            }
            if (a(paramString, i, false)) {
              localBitmap.setPixel(0, i, -16777216);
            }
            if ((i > i1) && (i < k - 1 - i2)) {
              localBitmap.setPixel(j - 1, i, -16777216);
            }
            i += 1;
          }
        }
      }
    }
    return localBitmap;
  }
  
  private Bitmap a(azys paramazys)
  {
    if (paramazys != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inScaled = false;
      if ((!ThemeUtil.isDefaultTheme()) && (!TextUtils.isEmpty(paramazys.jdField_a_of_type_ComTencentThemeSkinData.mFilePath)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabModel", 2, "get theme package resource");
        }
        return BitmapFactory.decodeFile(paramazys.jdField_a_of_type_ComTencentThemeSkinData.mFilePath, localOptions);
      }
      paramazys = paramazys.jdField_a_of_type_ComTencentThemeSkinData.mFileName.substring(0, paramazys.jdField_a_of_type_ComTencentThemeSkinData.mFileName.indexOf("."));
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      String str = localBaseApplication.getPackageName();
      int i = localBaseApplication.getResources().getIdentifier(paramazys, "drawable", str);
      if (i > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ResourceGrabModel", 2, "get system resource");
        }
        return BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), i, localOptions);
      }
    }
    return null;
  }
  
  private File a(String paramString)
  {
    return new File(BaseApplicationImpl.getContext().getExternalCacheDir(), "bitmapResource/" + paramString);
  }
  
  private void a(azys paramazys, HashSet<String> paramHashSet)
  {
    if (paramazys.jdField_a_of_type_Int == 3)
    {
      b(paramazys, paramHashSet);
      return;
    }
    c(paramazys, paramHashSet);
  }
  
  /* Error */
  private void a(String paramString1, HashSet<String> paramHashSet, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +141 -> 145
    //   7: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +28 -> 38
    //   13: ldc 151
    //   15: iconst_2
    //   16: new 218	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   23: ldc 249
    //   25: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: aload_3
    //   40: invokespecial 251	azym:b	(Ljava/lang/String;)Ljava/io/File;
    //   43: astore 5
    //   45: aload_2
    //   46: aload 5
    //   48: invokevirtual 254	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 260	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aconst_null
    //   56: astore_3
    //   57: aconst_null
    //   58: astore 4
    //   60: aload_3
    //   61: astore_2
    //   62: aload 5
    //   64: invokevirtual 263	java/io/File:exists	()Z
    //   67: ifne +35 -> 102
    //   70: aload_3
    //   71: astore_2
    //   72: aload 5
    //   74: invokevirtual 266	java/io/File:getParentFile	()Ljava/io/File;
    //   77: invokevirtual 263	java/io/File:exists	()Z
    //   80: ifne +14 -> 94
    //   83: aload_3
    //   84: astore_2
    //   85: aload 5
    //   87: invokevirtual 266	java/io/File:getParentFile	()Ljava/io/File;
    //   90: invokevirtual 269	java/io/File:mkdir	()Z
    //   93: pop
    //   94: aload_3
    //   95: astore_2
    //   96: aload 5
    //   98: invokevirtual 272	java/io/File:createNewFile	()Z
    //   101: pop
    //   102: aload_3
    //   103: astore_2
    //   104: new 274	java/io/OutputStreamWriter
    //   107: dup
    //   108: new 276	java/io/FileOutputStream
    //   111: dup
    //   112: aload 5
    //   114: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   117: ldc_w 281
    //   120: invokespecial 284	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   123: astore_3
    //   124: aload_3
    //   125: aload_1
    //   126: invokevirtual 288	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   129: aload_3
    //   130: invokevirtual 291	java/io/OutputStreamWriter:flush	()V
    //   133: aload_3
    //   134: invokevirtual 294	java/io/OutputStreamWriter:close	()V
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 294	java/io/OutputStreamWriter:close	()V
    //   145: return
    //   146: astore_1
    //   147: ldc 151
    //   149: iconst_1
    //   150: aload_1
    //   151: iconst_0
    //   152: anewarray 4	java/lang/Object
    //   155: invokestatic 297	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   158: return
    //   159: astore_3
    //   160: aload 4
    //   162: astore_1
    //   163: aload_1
    //   164: astore_2
    //   165: ldc 151
    //   167: iconst_1
    //   168: aload_3
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 297	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   176: aload_1
    //   177: ifnull -32 -> 145
    //   180: aload_1
    //   181: invokevirtual 294	java/io/OutputStreamWriter:close	()V
    //   184: return
    //   185: astore_1
    //   186: ldc 151
    //   188: iconst_1
    //   189: aload_1
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 297	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   197: return
    //   198: astore_1
    //   199: aload_2
    //   200: ifnull +7 -> 207
    //   203: aload_2
    //   204: invokevirtual 294	java/io/OutputStreamWriter:close	()V
    //   207: aload_1
    //   208: athrow
    //   209: astore_2
    //   210: ldc 151
    //   212: iconst_1
    //   213: aload_2
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 297	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   221: goto -14 -> 207
    //   224: astore_1
    //   225: aload_3
    //   226: astore_2
    //   227: goto -28 -> 199
    //   230: astore_2
    //   231: aload_3
    //   232: astore_1
    //   233: aload_2
    //   234: astore_3
    //   235: goto -72 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	azym
    //   0	238	1	paramString1	String
    //   0	238	2	paramHashSet	HashSet<String>
    //   0	238	3	paramString2	String
    //   58	103	4	localObject	Object
    //   43	70	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   141	145	146	java/lang/Exception
    //   62	70	159	java/lang/Exception
    //   72	83	159	java/lang/Exception
    //   85	94	159	java/lang/Exception
    //   96	102	159	java/lang/Exception
    //   104	124	159	java/lang/Exception
    //   180	184	185	java/lang/Exception
    //   62	70	198	finally
    //   72	83	198	finally
    //   85	94	198	finally
    //   96	102	198	finally
    //   104	124	198	finally
    //   165	176	198	finally
    //   203	207	209	java/lang/Exception
    //   124	137	224	finally
    //   124	137	230	java/lang/Exception
  }
  
  private boolean a(NinePatchChunk paramNinePatchChunk, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    int i;
    if (paramBoolean)
    {
      paramNinePatchChunk = paramNinePatchChunk.mDivX;
      paramBoolean = bool;
      if (paramNinePatchChunk != null)
      {
        paramBoolean = bool;
        if (paramNinePatchChunk.length > 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      paramBoolean = bool;
      if (i < paramNinePatchChunk.length - 1)
      {
        if ((paramInt > paramNinePatchChunk[i]) && (paramInt <= paramNinePatchChunk[(i + 1)])) {
          paramBoolean = true;
        }
      }
      else
      {
        return paramBoolean;
        paramNinePatchChunk = paramNinePatchChunk.mDivY;
        break;
      }
      i += 2;
    }
  }
  
  private File b(String paramString)
  {
    return new File(BaseApplicationImpl.getContext().getExternalCacheDir(), "xmlResource/" + paramString);
  }
  
  private void b(azys paramazys, HashSet<String> paramHashSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramazys.jdField_a_of_type_Array2dOfInt != null) && (paramazys.jdField_a_of_type_ArrayOfInt != null) && (paramazys.jdField_a_of_type_Array2dOfInt.length == paramazys.jdField_a_of_type_ArrayOfInt.length))
    {
      localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
      localStringBuilder.append("<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">\n");
      int i = 0;
      while (i < paramazys.jdField_a_of_type_ArrayOfInt.length)
      {
        localStringBuilder.append("    <item ");
        int j = 0;
        while (j < paramazys.jdField_a_of_type_Array2dOfInt[i].length)
        {
          int k = paramazys.jdField_a_of_type_Array2dOfInt[i][j];
          String str = (String)this.a.get(k);
          if (!TextUtils.isEmpty(str)) {
            localStringBuilder.append(str).append(" ");
          }
          j += 1;
        }
        j = paramazys.jdField_a_of_type_ArrayOfInt[i];
        localStringBuilder.append("android:color=\"").append("#").append(Integer.toHexString(j).toUpperCase()).append("\"");
        localStringBuilder.append(" />\n");
        i += 1;
      }
      localStringBuilder.append("</selector>");
    }
    a(localStringBuilder.toString(), paramHashSet, paramazys.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
  }
  
  private void c(azys paramazys, HashSet<String> paramHashSet)
  {
    Bitmap localBitmap = a(paramazys);
    if (localBitmap != null)
    {
      localBitmap = a(localBitmap, paramazys.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      paramazys = a(paramazys.jdField_a_of_type_ComTencentThemeSkinData.mFileName);
      paramHashSet.add(paramazys.getAbsolutePath());
    }
    try
    {
      if (!paramazys.exists())
      {
        if (!paramazys.getParentFile().exists()) {
          paramazys.getParentFile().mkdir();
        }
        paramazys.createNewFile();
      }
      paramazys = new FileOutputStream(paramazys);
      localBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramazys);
      paramazys.flush();
      paramazys.close();
      return;
    }
    catch (Exception paramazys)
    {
      QLog.d("ResourceGrabModel", 1, paramazys, new Object[0]);
    }
  }
  
  String a(int paramInt)
  {
    String str2 = (String)this.b.get(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = String.valueOf(paramInt);
    }
    return str1;
  }
  
  void a()
  {
    this.a.put(16842909, "android:state_window_focused=\"true\"");
    this.a.put(-16842909, "android:state_window_focused=\"false\"");
    this.a.put(16842913, "android:state_selected=\"true\"");
    this.a.put(-16842913, "android:state_selected=\"false\"");
    this.a.put(16842908, "android:state_focused=\"true\"");
    this.a.put(-16842908, "android:state_focused=\"false\"");
    this.a.put(16842910, "android:state_enabled=\"true\"");
    this.a.put(-16842910, "android:state_enabled=\"false\"");
    this.a.put(16842919, "android:state_pressed=\"true\"");
    this.a.put(-16842919, "android:state_pressed=\"false\"");
    this.a.put(16842912, "android:state_checked=\"true\"");
    this.a.put(-16842912, "android:state_checked=\"false\"");
    this.a.put(16843518, "android:state_activated=\"true\"");
    this.a.put(-16843518, "android:state_activated=\"false\"");
    this.a.put(16843547, "android:state_accelerated=\"true\"");
    this.a.put(-16843547, "android:state_accelerated=\"false\"");
    this.a.put(16843623, "android:state_hovered=\"true\"");
    this.a.put(-16843623, "android:state_hovered=\"false\"");
    this.a.put(16843624, "android:state_drag_can_accept=\"true\"");
    this.a.put(-16843624, "android:state_drag_can_accept=\"false\"");
    this.a.put(16843625, "android:state_drag_hovered=\"true\"");
    this.a.put(-16843625, "android:state_drag_hovered=\"false\"");
    this.b.put(0, "background");
    this.b.put(1, "image_drawable");
    this.b.put(2, "compound_drawables");
    this.b.put(3, "text_color");
  }
  
  void a(List<azys> paramList, azyr paramazyr)
  {
    if (!paramList.isEmpty())
    {
      HashSet localHashSet = new HashSet();
      Observable.from(paramList).distinct(new azyq(this)).subscribeOn(Schedulers.io()).subscribe(new azyn(this, localHashSet), new azyo(this), new azyp(this, paramazyr, localHashSet));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azym
 * JD-Core Version:    0.7.0.1
 */