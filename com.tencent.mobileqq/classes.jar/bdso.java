import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.List;

public class bdso
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString;
  private List<Long> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private List<Long> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private List<Long> jdField_c_of_type_JavaUtilList;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private List<Long> jdField_d_of_type_JavaUtilList;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString;
  private long jdField_h_of_type_Long;
  private String jdField_h_of_type_JavaLangString;
  private long jdField_i_of_type_Long;
  private String jdField_i_of_type_JavaLangString;
  private long jdField_j_of_type_Long;
  private String jdField_j_of_type_JavaLangString;
  private long jdField_k_of_type_Long;
  private String jdField_k_of_type_JavaLangString;
  private long jdField_l_of_type_Long;
  private String jdField_l_of_type_JavaLangString;
  private long jdField_m_of_type_Long;
  private String jdField_m_of_type_JavaLangString;
  private long jdField_n_of_type_Long;
  private String jdField_n_of_type_JavaLangString;
  private long o;
  private long p;
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.jdField_c_of_type_Int = ((int)paramFloat1);
    this.jdField_d_of_type_Int = ((int)paramFloat2);
    this.jdField_e_of_type_Int = ((int)paramFloat3);
    this.jdField_a_of_type_Int = ((int)paramFloat4);
    this.jdField_b_of_type_Int = ((int)paramFloat5);
  }
  
  private void b()
  {
    long l2 = 0L;
    try
    {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_Long;
      int i1;
      Iterator localIterator;
      long l1;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        i1 = this.jdField_a_of_type_JavaUtilList.size();
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (l1 = 0L; localIterator.hasNext(); l1 = ((Long)localIterator.next()).longValue() + l1) {}
        this.jdField_e_of_type_Long = (l1 / i1);
      }
      if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        for (l1 = 0L; localIterator.hasNext(); l1 = ((Long)localIterator.next()).longValue() + l1) {}
        this.jdField_h_of_type_Long = (l1 / this.jdField_b_of_type_JavaUtilList.size());
      }
      if (!this.jdField_c_of_type_JavaUtilList.isEmpty())
      {
        i1 = this.jdField_c_of_type_JavaUtilList.size();
        localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        for (l1 = 0L; localIterator.hasNext(); l1 = Math.max(((Long)localIterator.next()).longValue(), 0L) + l1) {}
        this.jdField_i_of_type_Long = (l1 / i1);
      }
      if (!this.jdField_d_of_type_JavaUtilList.isEmpty())
      {
        localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
        for (l1 = l2; localIterator.hasNext(); l1 = ((Long)localIterator.next()).longValue() + l1) {}
        this.jdField_l_of_type_Long = (l1 / this.jdField_d_of_type_JavaUtilList.size());
      }
      return;
    }
    finally {}
  }
  
  public String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    b();
    int i1;
    label47:
    StringBuilder localStringBuilder2;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null)
    {
      localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
      localObject = localStringBuilder1.append((String)localObject).append('|');
      if (!this.jdField_a_of_type_Boolean) {
        break label639;
      }
      i1 = 1;
      localStringBuilder2 = ((StringBuilder)localObject).append(i1).append('|').append(this.jdField_a_of_type_Long).append('|').append(this.jdField_b_of_type_Long).append('|').append(this.jdField_c_of_type_Long).append('|').append(this.jdField_a_of_type_JavaLangString).append('|').append(this.jdField_d_of_type_Long).append('|').append(this.jdField_a_of_type_Int).append('|').append(this.jdField_b_of_type_Int).append('|').append(this.jdField_c_of_type_Int).append('|').append(this.jdField_d_of_type_Int).append('|').append(this.jdField_e_of_type_Int).append('|').append(this.jdField_e_of_type_Long).append('|').append(this.jdField_f_of_type_Long).append('|').append(this.jdField_g_of_type_Long).append('|').append(this.jdField_h_of_type_Long).append('|').append(this.jdField_i_of_type_Long).append('|').append(this.jdField_j_of_type_Long).append('|').append(this.jdField_k_of_type_Long).append('|').append(this.jdField_l_of_type_Long).append('|').append(this.jdField_m_of_type_Long).append('|').append(this.jdField_n_of_type_Long).append('|').append(this.o).append('|').append(this.jdField_b_of_type_JavaLangString).append('|').append(this.p).append('|');
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam == null)) {
        break label644;
      }
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.jdField_a_of_type_Int);
      label366:
      localStringBuilder2 = localStringBuilder2.append(localObject).append('|').append(System.currentTimeMillis()).append('|');
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {
        break label650;
      }
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.getReportType());
      label408:
      localStringBuilder2 = localStringBuilder2.append(localObject).append('|').append(this.jdField_k_of_type_JavaLangString).append('|').append(this.jdField_j_of_type_JavaLangString).append('|').append(this.jdField_e_of_type_JavaLangString).append('|');
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) {
        break label656;
      }
      localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.version;
      label472:
      localStringBuilder2 = localStringBuilder2.append((String)localObject).append('|');
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.baseLibInfo == null)) {
        break label662;
      }
    }
    label644:
    label650:
    label656:
    label662:
    for (Object localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.baseLibInfo.baseLibVersion;; localObject = "null")
    {
      localStringBuilder2.append((String)localObject).append('|').append(this.jdField_c_of_type_JavaLangString).append('|').append(this.jdField_f_of_type_JavaLangString).append('|').append(this.jdField_g_of_type_JavaLangString).append('|').append(this.jdField_h_of_type_JavaLangString).append('|').append(this.jdField_i_of_type_JavaLangString).append('|').append(this.jdField_l_of_type_JavaLangString).append('|').append(this.jdField_m_of_type_JavaLangString).append('|').append(this.jdField_n_of_type_JavaLangString).append('|').append(this.jdField_d_of_type_JavaLangString);
      return localStringBuilder1.toString();
      localObject = "null";
      break;
      label639:
      i1 = 0;
      break label47;
      localObject = "null";
      break label366;
      localObject = "null";
      break label408;
      localObject = "null";
      break label472;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_k_of_type_Long = 0L;
      this.jdField_j_of_type_Long = 0L;
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_g_of_type_Long = 0L;
      this.jdField_f_of_type_Long = 0L;
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 136	bdso:jdField_f_of_type_Long	J
    //   7: lconst_1
    //   8: ladd
    //   9: putfield 136	bdso:jdField_f_of_type_Long	J
    //   12: iload 5
    //   14: ifge +16 -> 30
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 138	bdso:jdField_g_of_type_Long	J
    //   22: lconst_1
    //   23: ladd
    //   24: putfield 138	bdso:jdField_g_of_type_Long	J
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 49	bdso:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   34: lload_1
    //   35: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokeinterface 228 2 0
    //   43: pop
    //   44: aload_0
    //   45: getfield 82	bdso:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   48: lload_3
    //   49: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokeinterface 228 2 0
    //   57: pop
    //   58: goto -31 -> 27
    //   61: astore 6
    //   63: aload_0
    //   64: monitorexit
    //   65: aload 6
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	bdso
    //   0	68	1	paramLong1	long
    //   0	68	3	paramLong2	long
    //   0	68	5	paramInt	int
    //   61	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	61	finally
    //   17	27	61	finally
    //   30	58	61	finally
  }
  
  /* Error */
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 140	bdso:jdField_j_of_type_Long	J
    //   7: lconst_1
    //   8: ladd
    //   9: putfield 140	bdso:jdField_j_of_type_Long	J
    //   12: iload 5
    //   14: ifeq +16 -> 30
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 142	bdso:jdField_k_of_type_Long	J
    //   22: lconst_1
    //   23: ladd
    //   24: putfield 142	bdso:jdField_k_of_type_Long	J
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 86	bdso:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   34: lload_1
    //   35: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokeinterface 228 2 0
    //   43: pop
    //   44: aload_0
    //   45: getfield 96	bdso:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   48: lload_3
    //   49: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: invokeinterface 228 2 0
    //   57: pop
    //   58: goto -31 -> 27
    //   61: astore 6
    //   63: aload_0
    //   64: monitorexit
    //   65: aload 6
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	bdso
    //   0	68	1	paramLong1	long
    //   0	68	3	paramLong2	long
    //   0	68	5	paramBoolean	boolean
    //   61	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	61	finally
    //   17	27	61	finally
    //   30	58	61	finally
  }
  
  public String toString()
  {
    return "ReportModel{launchFlag=" + this.jdField_a_of_type_Boolean + ", launchCost=" + this.jdField_a_of_type_Long + ", relaunchCost=" + this.jdField_b_of_type_Long + ", pkgDownloadCost=" + this.jdField_c_of_type_Long + ", pkgDownloadResult='" + this.jdField_a_of_type_JavaLangString + '\'' + ", gamePrepareCost=" + this.jdField_d_of_type_Long + ", fpsAVG=" + this.jdField_a_of_type_Int + ", fpsVARI=" + this.jdField_b_of_type_Int + ", cpuAVG=" + this.jdField_c_of_type_Int + ", memAVG=" + this.jdField_d_of_type_Int + ", memINC=" + this.jdField_e_of_type_Int + ", httpRequestCost=" + this.jdField_e_of_type_Long + ", httpRequestNum=" + this.jdField_f_of_type_Long + ", httpRequestErrorNum=" + this.jdField_g_of_type_Long + ", httpRequestLength=" + this.jdField_h_of_type_Long + ", downloadRequestCost=" + this.jdField_i_of_type_Long + ", downloadRequestNum=" + this.jdField_j_of_type_Long + ", downloadRequestErrorNum=" + this.jdField_k_of_type_Long + ", downloadRequestLength=" + this.jdField_l_of_type_Long + ", jsErrorNum=" + this.jdField_m_of_type_Long + ", oomErrorNum=" + this.jdField_n_of_type_Long + ", crashErrorNum=" + this.o + ", launchResult='" + this.jdField_b_of_type_JavaLangString + '\'' + ", gameUseTime=" + this.p + ", x5Version='" + this.jdField_c_of_type_JavaLangString + '\'' + ", openID='" + this.jdField_d_of_type_JavaLangString + '\'' + ", clientVersion='" + this.jdField_e_of_type_JavaLangString + '\'' + ", devicePlatform='" + this.jdField_f_of_type_JavaLangString + '\'' + ", deviceManufacturer='" + this.jdField_g_of_type_JavaLangString + '\'' + ", deviceModel='" + this.jdField_h_of_type_JavaLangString + '\'' + ", deviceVersion='" + this.jdField_i_of_type_JavaLangString + '\'' + ", qua='" + this.jdField_j_of_type_JavaLangString + '\'' + ", networkType='" + this.jdField_k_of_type_JavaLangString + '\'' + ", networkGateWayIP='" + this.jdField_l_of_type_JavaLangString + '\'' + ", networkSSID='" + this.jdField_m_of_type_JavaLangString + '\'' + ", androidID='" + this.jdField_n_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdso
 * JD-Core Version:    0.7.0.1
 */