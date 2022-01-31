import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList<Lazri;>;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipException;

public class azrj
{
  protected static azrj a;
  protected static Object a;
  protected azri a;
  protected File a;
  protected ArrayList<azri> a;
  protected File b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private azrj(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
    this.jdField_a_of_type_JavaIoFile = new File(a(paramContext) + "group_catalog_new.xml");
  }
  
  private azri a(azri paramazri, String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = null;
    if (paramazri.b.equals(paramString)) {}
    do
    {
      for (Object localObject1 = paramazri; !localIterator.hasNext(); localObject1 = localObject2)
      {
        do
        {
          do
          {
            return localObject1;
            localObject1 = localIterator;
          } while (paramazri.jdField_a_of_type_JavaUtilArrayList == null);
          localObject1 = localIterator;
        } while (paramazri.jdField_a_of_type_JavaUtilArrayList.isEmpty());
        localIterator = paramazri.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      paramazri = a((azri)localIterator.next(), paramString);
      localObject1 = paramazri;
    } while (paramazri == null);
    return paramazri;
  }
  
  private azri a(String paramString)
  {
    Object localObject1 = null;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        azri localazri = a((azri)localIterator.next(), paramString);
        localObject1 = localazri;
        if (localazri != null) {
          localObject1 = localazri;
        }
      }
      return localObject1;
    }
  }
  
  public static azrj a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Azrj == null) {
        jdField_a_of_type_Azrj = new azrj(paramContext);
      }
      return jdField_a_of_type_Azrj;
    }
  }
  
  private String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "group_catalog" + File.separator;
    if ((this.b != null) && (this.b.exists()) && (paramContext.equals(this.b.getPath() + File.separator))) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupCatalogTool", 2, "mCatalogXmlDirFile != null && path.equals(mCatalogXmlDirFile.getPath()");
      }
    }
    do
    {
      return paramContext;
      this.b = new File(paramContext);
    } while (this.b.exists());
    this.b.mkdirs();
    return paramContext;
  }
  
  private ArrayList<azri> a(ArrayList<azri> paramArrayList, String paramString)
  {
    Object localObject = null;
    azri localazri = null;
    Iterator localIterator;
    if (paramArrayList != null)
    {
      localIterator = paramArrayList.iterator();
      paramArrayList = localazri;
    }
    for (;;)
    {
      localObject = paramArrayList;
      if (localIterator.hasNext())
      {
        localazri = (azri)localIterator.next();
        if ((localazri.jdField_a_of_type_JavaUtilArrayList == null) || (localazri.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label100;
        }
        if (!localazri.b.equals(paramString)) {
          break label81;
        }
        localObject = localazri.jdField_a_of_type_JavaUtilArrayList;
      }
      label81:
      label100:
      do
      {
        return localObject;
        localObject = a(localazri.jdField_a_of_type_JavaUtilArrayList, paramString);
        paramArrayList = (ArrayList<azri>)localObject;
        if (localObject == null) {
          break;
        }
        return localObject;
        localObject = paramArrayList;
      } while (localazri.jdField_a_of_type_Int == 4);
    }
  }
  
  /* Error */
  private azri b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 148	azrj:a	()Z
    //   7: ifne +14 -> 21
    //   10: aload_1
    //   11: ldc 150
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 36	azrj:a	(Landroid/content/Context;)Ljava/lang/String;
    //   18: invokestatic 155	befr:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   21: new 157	azrm
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 158	azrm:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: invokestatic 164	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   33: invokevirtual 168	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   36: astore 5
    //   38: new 170	java/io/BufferedInputStream
    //   41: dup
    //   42: new 172	java/io/FileInputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 51	azrj:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   50: invokespecial 175	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 178	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload 5
    //   61: new 180	org/xml/sax/InputSource
    //   64: dup
    //   65: new 182	java/io/InputStreamReader
    //   68: dup
    //   69: aload_2
    //   70: ldc 184
    //   72: invokespecial 187	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   75: invokespecial 190	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   78: aload_3
    //   79: invokevirtual 196	javax/xml/parsers/SAXParser:parse	(Lorg/xml/sax/InputSource;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: aload_3
    //   86: invokevirtual 199	azrm:a	()Ljava/util/ArrayList;
    //   89: putfield 28	azrj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: invokevirtual 202	azrm:a	()Lazri;
    //   98: astore_3
    //   99: aload_3
    //   100: astore_1
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: invokevirtual 207	java/io/InputStream:close	()V
    //   109: aload_3
    //   110: astore_1
    //   111: aload_1
    //   112: areturn
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   118: aload_3
    //   119: areturn
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_1
    //   125: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +14 -> 142
    //   131: aload_2
    //   132: astore_1
    //   133: ldc 118
    //   135: iconst_2
    //   136: ldc 212
    //   138: aload_3
    //   139: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload 4
    //   144: astore_1
    //   145: aload_2
    //   146: ifnull -35 -> 111
    //   149: aload_2
    //   150: invokevirtual 207	java/io/InputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_1
    //   167: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +14 -> 184
    //   173: aload_2
    //   174: astore_1
    //   175: ldc 118
    //   177: iconst_2
    //   178: ldc 218
    //   180: aload_3
    //   181: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: aload 4
    //   186: astore_1
    //   187: aload_2
    //   188: ifnull -77 -> 111
    //   191: aload_2
    //   192: invokevirtual 207	java/io/InputStream:close	()V
    //   195: aconst_null
    //   196: areturn
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_2
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 207	java/io/InputStream:close	()V
    //   215: aload_2
    //   216: athrow
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   222: goto -7 -> 215
    //   225: astore_2
    //   226: goto -19 -> 207
    //   229: astore_3
    //   230: goto -65 -> 165
    //   233: astore_3
    //   234: goto -111 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	azrj
    //   0	237	1	paramContext	Context
    //   0	237	2	paramString	String
    //   29	90	3	localObject1	Object
    //   120	19	3	localException1	java.lang.Exception
    //   162	19	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   229	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   233	1	3	localException2	java.lang.Exception
    //   1	184	4	localObject2	Object
    //   36	24	5	localSAXParser	javax.xml.parsers.SAXParser
    // Exception table:
    //   from	to	target	type
    //   105	109	113	java/io/IOException
    //   30	57	120	java/lang/Exception
    //   149	153	155	java/io/IOException
    //   30	57	162	java/lang/OutOfMemoryError
    //   191	195	197	java/io/IOException
    //   30	57	204	finally
    //   211	215	217	java/io/IOException
    //   59	82	225	finally
    //   84	92	225	finally
    //   94	99	225	finally
    //   125	131	225	finally
    //   133	142	225	finally
    //   167	173	225	finally
    //   175	184	225	finally
    //   59	82	229	java/lang/OutOfMemoryError
    //   84	92	229	java/lang/OutOfMemoryError
    //   94	99	229	java/lang/OutOfMemoryError
    //   59	82	233	java/lang/Exception
    //   84	92	233	java/lang/Exception
    //   94	99	233	java/lang/Exception
  }
  
  private String b(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "group_catalog_temp" + File.separator;
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  protected long a(Context paramContext)
  {
    return paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).getLong("GroupCatalogTool", 0L);
  }
  
  public azri a()
  {
    return this.jdField_a_of_type_Azri;
  }
  
  public azri a(Context paramContext, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      paramContext = a(paramString);
      this.jdField_a_of_type_Azri = paramContext;
      return paramContext;
    }
    paramContext = b(paramContext, paramString);
    this.jdField_a_of_type_Azri = paramContext;
    return paramContext;
  }
  
  public ArrayList<azri> a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(new azri[this.jdField_a_of_type_JavaUtilArrayList.size()]));
      Collections.copy(localArrayList, this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
  }
  
  public ArrayList<azri> a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
      return paramString;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Azri = null;
      return;
    }
  }
  
  public void a(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).edit();
    paramContext.putLong("GroupCatalogTool", paramLong);
    paramContext.commit();
  }
  
  public void a(azri paramazri)
  {
    this.jdField_a_of_type_Azri = paramazri;
  }
  
  public void a(String paramString, azrl paramazrl)
  {
    long l = a(BaseApplicationImpl.getContext());
    boolean bool = this.jdField_a_of_type_JavaIoFile.exists();
    if ((System.currentTimeMillis() - l > 86400000L) || (!bool))
    {
      paramString = new bato(BaseApplicationImpl.getApplication().getRuntime()).a(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("http://pub.idqqimg.com/pc/group/layer_new.zip");
      HashMap localHashMap = new HashMap();
      File localFile = new File(b(BaseApplicationImpl.getContext()) + "layer_new.zip");
      localHashMap.put("http://pub.idqqimg.com/pc/group/layer_new.zip", localFile);
      paramString.a(new batm(localArrayList, localHashMap, "http://pub.idqqimg.com/pc/group/layer_new.zip"), new azrk(this, localFile, paramazrl), new Bundle());
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaIoFile.length() > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool = false;
    try
    {
      mpx.a(new File(b(paramContext) + "layer_new.zip"), b(paramContext));
      bool = true;
    }
    catch (ZipException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GroupCatalogTool", 2, paramContext.getMessage());
      return false;
    }
    catch (IOException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GroupCatalogTool", 2, paramContext.getMessage());
    }
    return bool;
    return false;
  }
  
  public boolean b(Context paramContext)
  {
    return bace.b(b(paramContext) + "group_catalog_new.xml", a(paramContext) + "group_catalog_new.xml");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azrj
 * JD-Core Version:    0.7.0.1
 */