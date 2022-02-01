import com.tencent.mobileqq.apollo.ApolloResManager.ApolloDressInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "apolloDressInfo", "Lcom/tencent/mobileqq/apollo/ApolloResManager$ApolloDressInfo;", "kotlin.jvm.PlatformType", "errMsg", "", "errCode", "", "onGetApolloUserDressInfo"}, k=3, mv={1, 1, 16})
final class amuv
  implements amof
{
  amuv(amuu paramamuu) {}
  
  public final void a(ApolloResManager.ApolloDressInfo paramApolloDressInfo, String paramString, int paramInt)
  {
    if (paramApolloDressInfo == null)
    {
      QLog.e(amup.a.a(), 1, "getApolloUserRes return null " + paramString);
      this.a.a(-5031, "");
      return;
    }
    paramApolloDressInfo = anju.a(paramApolloDressInfo);
    this.a.a(paramApolloDressInfo);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuv
 * JD-Core Version:    0.7.0.1
 */