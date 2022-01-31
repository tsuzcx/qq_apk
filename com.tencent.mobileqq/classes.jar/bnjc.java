import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import java.util.Arrays;
import java.util.HashMap;

@TargetApi(18)
public class bnjc
  extends bnfd
{
  private static bnjc a;
  public boolean d;
  
  private bnjc()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static bnjc a()
  {
    if (jdField_a_of_type_Bnjc == null) {}
    try
    {
      if (jdField_a_of_type_Bnjc == null) {
        jdField_a_of_type_Bnjc = new bnjc();
      }
      return jdField_a_of_type_Bnjc;
    }
    finally {}
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    label253:
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          return;
        }
        if (this.jdField_a_of_type_Bnff != null)
        {
          if (!paramBoolean)
          {
            l1 = a(this.jdField_a_of_type_Bnff.c - this.jdField_a_of_type_Bnff.jdField_b_of_type_Long);
            if ((this.jdField_a_of_type_Bnff.jdField_a_of_type_Long > 0L) && (l1 > a()))
            {
              long l2 = (this.jdField_a_of_type_Bnff.c - this.jdField_a_of_type_Bnff.jdField_b_of_type_Long) / this.jdField_b_of_type_Long;
              long l3 = this.jdField_a_of_type_Bnff.jdField_a_of_type_Long;
              paramString = new HashMap(10);
              paramString.put("dropCount", String.valueOf(l2 + 1L - l3));
              paramString.put("totalMs", String.valueOf(l1));
              paramString.put("scene", this.jdField_a_of_type_Bnff.jdField_a_of_type_JavaLangString);
              paramString.put("dropTimes", Arrays.toString(this.jdField_a_of_type_Bnff.jdField_a_of_type_ArrayOfLong));
              paramString.put("isFirstLaunch", String.valueOf(BaseApplicationImpl.isFirstLaunchNew));
              if (jdField_a_of_type_Long <= 0L) {
                break label253;
              }
              l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
              paramString.put("intervalAfterSyncMsg", String.valueOf(l1));
              UnifiedMonitor.a().addEvent(9, null, 0, 0, paramString);
            }
          }
          this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(this.jdField_a_of_type_Bnff);
          this.jdField_a_of_type_Bnff = null;
        }
        else
        {
          this.c = false;
          continue;
        }
        long l1 = -1L;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjc
 * JD-Core Version:    0.7.0.1
 */