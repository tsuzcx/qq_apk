import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class blfr
{
  private long jdField_a_of_type_Long;
  private final blfn jdField_a_of_type_Blfn;
  private final blfs jdField_a_of_type_Blfs;
  private blgh jdField_a_of_type_Blgh;
  private HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private blfr(String paramString1, String paramString2, blfn paramblfn, blfs paramblfs)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Blfn = paramblfn;
    this.jdField_a_of_type_Blfs = paramblfs;
  }
  
  public static blfr a(String paramString1, blfn paramblfn, String paramString2, blfs paramblfs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramblfn == null) || (paramblfs == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new blfr(paramString1, IOUtils.getDirPathNoSeparator(paramString2), paramblfn, paramblfs);
  }
  
  public static HttpNetReq a(Object paramObject, String paramString1, String paramString2, String paramString3, INetEngine.IBreakDownFix paramIBreakDownFix, INetEngine.INetEngineListener paramINetEngineListener)
  {
    return a(paramObject, paramString1, paramString2, paramString3, paramIBreakDownFix, paramINetEngineListener, null);
  }
  
  public static HttpNetReq a(Object paramObject, String paramString1, String paramString2, String paramString3, INetEngine.IBreakDownFix paramIBreakDownFix, INetEngine.INetEngineListener paramINetEngineListener, String paramString4)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = paramINetEngineListener;
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localHttpNetReq.mReqProperties = new HashMap();
      localHttpNetReq.mReqProperties.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHttpNetReq.mTempPath = paramString4;
    }
    localHttpNetReq.mOutPath = paramString2;
    localHttpNetReq.mPrioty = 1;
    localHttpNetReq.setUserData(paramObject);
    localHttpNetReq.mBreakDownFix = paramIBreakDownFix;
    return localHttpNetReq;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public blfn a()
  {
    return this.jdField_a_of_type_Blfn;
  }
  
  public blfs a()
  {
    return this.jdField_a_of_type_Blfs;
  }
  
  public blgh a()
  {
    return this.jdField_a_of_type_Blgh;
  }
  
  public HttpNetReq a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(blgh paramblgh)
  {
    this.jdField_a_of_type_Blgh = paramblgh;
  }
  
  public void a(HttpNetReq paramHttpNetReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public blfs b()
  {
    return this.jdField_a_of_type_Blfs.a();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfr
 * JD-Core Version:    0.7.0.1
 */