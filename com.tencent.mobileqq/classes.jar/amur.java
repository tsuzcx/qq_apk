import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "allSucceeded", "", "resultMap", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "onComplete"}, k=3, mv={1, 1, 16})
final class amur
  implements bnjf
{
  amur(amuq paramamuq, long paramLong) {}
  
  public final void a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      amuq localamuq = this.jdField_a_of_type_Amuq;
      paramHashMap = paramHashMap.get("video_3DFaceFila_kapu_placeholder");
      if (paramHashMap == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
      localamuq.a((String)paramHashMap);
      this.jdField_a_of_type_Amuq.e();
      anlx.a("aekit_init", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "success");
      return;
    }
    QLog.e(amup.a.a(), 1, "[AEKit]AECMShowQipcModule downloadEssentialResources error");
    this.jdField_a_of_type_Amuq.a(-5033, "");
    anlx.a("aekit_essential_res", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "download fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amur
 * JD-Core Version:    0.7.0.1
 */