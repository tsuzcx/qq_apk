import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialMgr.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bnpg
{
  private static bnpg jdField_a_of_type_Bnpg = new bnpg();
  private static final String jdField_a_of_type_JavaLangString = bnpg.class.getSimpleName();
  private Map<String, WeakReference<bnpi>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, MetaMaterial> b = new HashMap();
  
  public static bnpg a()
  {
    return jdField_a_of_type_Bnpg;
  }
  
  private void a(MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (bnpi)((WeakReference)localObject).get();
        if (localObject != null) {
          ((bnpi)localObject).a(paramMetaMaterial);
        }
      }
    }
  }
  
  private void a(MetaMaterial paramMetaMaterial, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramMetaMaterial.id))
    {
      Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramMetaMaterial.id);
      if (localObject != null)
      {
        localObject = (bnpi)((WeakReference)localObject).get();
        if (localObject != null) {
          ((bnpi)localObject).a(paramMetaMaterial, paramInt);
        }
      }
    }
  }
  
  public String a(MetaMaterial paramMetaMaterial)
  {
    return new File(bndm.e, paramMetaMaterial.id).getAbsolutePath();
  }
  
  public void a(AppInterface paramAppInterface, MetaMaterial paramMetaMaterial, bnpi parambnpi)
  {
    if ((paramMetaMaterial == null) || (TextUtils.isEmpty(paramMetaMaterial.id)))
    {
      if (parambnpi != null) {
        parambnpi.b(paramMetaMaterial);
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramMetaMaterial.id, new WeakReference(parambnpi));
    ThreadManager.getFileThreadHandler().post(new AEMaterialMgr.1(this, paramMetaMaterial, paramAppInterface));
  }
  
  /* Error */
  public boolean a(MetaMaterial paramMetaMaterial)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 53	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   8: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: getstatic 127	bndm:d	Ljava/lang/String;
    //   19: astore_2
    //   20: new 75	java/io/File
    //   23: dup
    //   24: aload_2
    //   25: aload_1
    //   26: getfield 53	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   29: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: astore_3
    //   33: aload_3
    //   34: invokevirtual 131	java/io/File:exists	()Z
    //   37: ifeq -23 -> 14
    //   40: aload_3
    //   41: invokevirtual 134	java/io/File:getPath	()Ljava/lang/String;
    //   44: invokestatic 140	bgmg:c	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne -38 -> 14
    //   55: aload_3
    //   56: aload_1
    //   57: getfield 143	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:packageMd5	Ljava/lang/String;
    //   60: invokevirtual 149	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   63: ifeq -49 -> 14
    //   66: new 151	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   73: getstatic 80	bndm:e	Ljava/lang/String;
    //   76: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: getstatic 159	java/io/File:separator	Ljava/lang/String;
    //   82: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: getfield 53	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   89: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: getstatic 159	java/io/File:separator	Ljava/lang/String;
    //   95: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore 4
    //   103: new 75	java/io/File
    //   106: dup
    //   107: aload 4
    //   109: ldc 164
    //   111: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: astore_3
    //   115: new 75	java/io/File
    //   118: dup
    //   119: aload 4
    //   121: ldc 166
    //   123: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: astore 4
    //   128: aload_3
    //   129: invokevirtual 131	java/io/File:exists	()Z
    //   132: ifne +76 -> 208
    //   135: aload 4
    //   137: invokevirtual 131	java/io/File:exists	()Z
    //   140: ifne +68 -> 208
    //   143: new 75	java/io/File
    //   146: dup
    //   147: aload_2
    //   148: aload_1
    //   149: getfield 53	camera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial:id	Ljava/lang/String;
    //   152: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: new 151	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   162: getstatic 80	bndm:e	Ljava/lang/String;
    //   165: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: getstatic 159	java/io/File:separator	Ljava/lang/String;
    //   171: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 171	nmk:a	(Ljava/io/File;Ljava/lang/String;)V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore_1
    //   183: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq -172 -> 14
    //   189: aload_1
    //   190: invokevirtual 179	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_1
    //   196: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq -185 -> 14
    //   202: aload_1
    //   203: invokevirtual 180	java/lang/Exception:printStackTrace	()V
    //   206: iconst_0
    //   207: ireturn
    //   208: iconst_1
    //   209: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	bnpg
    //   0	210	1	paramMetaMaterial	MetaMaterial
    //   19	129	2	str	String
    //   32	97	3	localObject1	Object
    //   101	35	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	48	182	java/lang/UnsatisfiedLinkError
    //   143	180	195	java/lang/Exception
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpg
 * JD-Core Version:    0.7.0.1
 */