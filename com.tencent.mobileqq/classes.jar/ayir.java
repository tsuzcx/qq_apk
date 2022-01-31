import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class ayir
  implements Manager
{
  private aukp jdField_a_of_type_Aukp;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, auko> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, auko> b = new ConcurrentHashMap();
  
  public ayir(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getString(paramContext, paramString3);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putString(paramContext, paramString3);
    localEditor.commit();
  }
  
  /* Error */
  private void c(List<GPadInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   4: invokevirtual 97	aukp:a	()Laukr;
    //   7: invokevirtual 101	aukr:a	()V
    //   10: aload_1
    //   11: invokeinterface 107 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 112 1 0
    //   23: ifeq +64 -> 87
    //   26: aload_1
    //   27: invokeinterface 116 1 0
    //   32: checkcast 118	com/tencent/mobileqq/teamworkforgroup/GPadInfo
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   40: aload_2
    //   41: invokevirtual 121	aukp:a	(Lauko;)V
    //   44: goto -27 -> 17
    //   47: astore_1
    //   48: ldc 123
    //   50: iconst_1
    //   51: new 56	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   58: ldc 125
    //   60: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 126	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   80: invokevirtual 97	aukp:a	()Laukr;
    //   83: invokevirtual 134	aukr:b	()V
    //   86: return
    //   87: aload_0
    //   88: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   91: invokevirtual 97	aukp:a	()Laukr;
    //   94: invokevirtual 136	aukr:c	()V
    //   97: aload_0
    //   98: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   101: invokevirtual 97	aukp:a	()Laukr;
    //   104: invokevirtual 134	aukr:b	()V
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   113: invokevirtual 97	aukp:a	()Laukr;
    //   116: invokevirtual 134	aukr:b	()V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	ayir
    //   0	121	1	paramList	List<GPadInfo>
    //   35	6	2	localGPadInfo	GPadInfo
    // Exception table:
    //   from	to	target	type
    //   0	17	47	java/lang/Exception
    //   17	44	47	java/lang/Exception
    //   87	97	47	java/lang/Exception
    //   0	17	108	finally
    //   17	44	108	finally
    //   48	76	108	finally
    //   87	97	108	finally
  }
  
  /* Error */
  private void d(List<GroupPadTemplateInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   4: invokevirtual 97	aukp:a	()Laukr;
    //   7: invokevirtual 101	aukr:a	()V
    //   10: aload_1
    //   11: invokeinterface 107 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 112 1 0
    //   23: ifeq +64 -> 87
    //   26: aload_1
    //   27: invokeinterface 116 1 0
    //   32: checkcast 141	com/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   40: aload_2
    //   41: invokevirtual 121	aukp:a	(Lauko;)V
    //   44: goto -27 -> 17
    //   47: astore_1
    //   48: ldc 123
    //   50: iconst_1
    //   51: new 56	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   58: ldc 143
    //   60: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 126	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   80: invokevirtual 97	aukp:a	()Laukr;
    //   83: invokevirtual 134	aukr:b	()V
    //   86: return
    //   87: aload_0
    //   88: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   91: invokevirtual 97	aukp:a	()Laukr;
    //   94: invokevirtual 136	aukr:c	()V
    //   97: aload_0
    //   98: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   101: invokevirtual 97	aukp:a	()Laukr;
    //   104: invokevirtual 134	aukr:b	()V
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   113: invokevirtual 97	aukp:a	()Laukr;
    //   116: invokevirtual 134	aukr:b	()V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	ayir
    //   0	121	1	paramList	List<GroupPadTemplateInfo>
    //   35	6	2	localGroupPadTemplateInfo	GroupPadTemplateInfo
    // Exception table:
    //   from	to	target	type
    //   0	17	47	java/lang/Exception
    //   17	44	47	java/lang/Exception
    //   87	97	47	java/lang/Exception
    //   0	17	108	finally
    //   17	44	108	finally
    //   48	76	108	finally
    //   87	97	108	finally
  }
  
  public List<GPadInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((GPadInfo)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public ConcurrentHashMap<String, auko> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aukp.a(GPadInfo.class);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(int paramInt, List<GPadInfo> paramList)
  {
    if (paramInt == 2) {
      a();
    }
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        GPadInfo localGPadInfo = (GPadInfo)localIterator.next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(ayfx.c(localGPadInfo.pad_url), localGPadInfo);
      }
      c(paramList);
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject4;
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      Object localObject1 = this.jdField_a_of_type_Aukp.a(GPadInfo.class, false, "groupCode=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (GPadInfo)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(ayfx.c(((GPadInfo)localObject4).pad_url), localObject4);
        }
      }
      this.b.clear();
    }
    finally {}
    Object localObject3 = this.jdField_a_of_type_Aukp.a(GroupPadTemplateInfo.class, false, "groupCode=?", new String[] { "" + paramLong }, null, null, null, null);
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (GroupPadTemplateInfo)((Iterator)localObject3).next();
        this.b.put(((GroupPadTemplateInfo)localObject4).templateUrl, localObject4);
      }
    }
  }
  
  public void a(GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    if ((paramGroupPadTemplateInfo == null) || (TextUtils.isEmpty(paramGroupPadTemplateInfo.templateUrl))) {
      return;
    }
    this.b.put(paramGroupPadTemplateInfo.templateUrl, paramGroupPadTemplateInfo);
    a(paramGroupPadTemplateInfo);
  }
  
  public void a(List<GroupPadTemplateInfo> paramList)
  {
    if (this.b != null) {
      b();
    }
    if ((paramList != null) && (this.b != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)localIterator.next();
        this.b.put(localGroupPadTemplateInfo.templateUrl, localGroupPadTemplateInfo);
      }
      d(paramList);
      b(paramList);
    }
  }
  
  public boolean a(auko paramauko)
  {
    boolean bool = false;
    if (paramauko.getStatus() == 1000)
    {
      this.jdField_a_of_type_Aukp.b(paramauko);
      if (paramauko.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramauko.getStatus() != 1001) && (paramauko.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_Aukp.a(paramauko);
  }
  
  public List<GroupPadTemplateInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.b != null)
    {
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((GroupPadTemplateInfo)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aukp.a(GroupPadTemplateInfo.class);
    this.b.clear();
  }
  
  /* Error */
  public void b(List<GroupPadTemplateInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +80 -> 81
    //   4: aload_0
    //   5: getfield 40	ayir:jdField_a_of_type_Aukp	Laukp;
    //   8: invokevirtual 97	aukp:a	()Laukr;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 101	aukr:a	()V
    //   16: aload_1
    //   17: invokeinterface 107 1 0
    //   22: astore_1
    //   23: aload_1
    //   24: invokeinterface 112 1 0
    //   29: ifeq +53 -> 82
    //   32: aload_0
    //   33: aload_1
    //   34: invokeinterface 116 1 0
    //   39: checkcast 141	com/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo
    //   42: invokevirtual 230	ayir:a	(Lcom/tencent/mobileqq/teamworkforgroup/GroupPadTemplateInfo;)V
    //   45: goto -22 -> 23
    //   48: astore_1
    //   49: ldc 123
    //   51: iconst_1
    //   52: new 56	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   59: ldc 232
    //   61: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 126	java/lang/Exception:toString	()Ljava/lang/String;
    //   68: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_2
    //   78: invokevirtual 134	aukr:b	()V
    //   81: return
    //   82: aload_2
    //   83: invokevirtual 134	aukr:b	()V
    //   86: return
    //   87: astore_1
    //   88: aload_2
    //   89: invokevirtual 134	aukr:b	()V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	ayir
    //   0	94	1	paramList	List<GroupPadTemplateInfo>
    //   11	78	2	localaukr	aukr
    // Exception table:
    //   from	to	target	type
    //   16	23	48	java/lang/Exception
    //   23	45	48	java/lang/Exception
    //   16	23	87	finally
    //   23	45	87	finally
    //   49	77	87	finally
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Aukp != null) && (this.jdField_a_of_type_Aukp.a())) {
      this.jdField_a_of_type_Aukp.a();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayir
 * JD-Core Version:    0.7.0.1
 */