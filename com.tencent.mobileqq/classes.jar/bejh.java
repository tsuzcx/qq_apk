import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Comparator;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

class bejh
  implements Comparator<oidb_0xe61.BeancurdCubeInfoResult>
{
  private final aggr jdField_a_of_type_Aggr;
  private final awxb<bejl, QQAppInterface> jdField_a_of_type_Awxb;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bejh(QQAppInterface paramQQAppInterface, aggr paramaggr, awxb<bejl, QQAppInterface> paramawxb)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aggr = paramaggr;
    this.jdField_a_of_type_Awxb = paramawxb;
  }
  
  private int a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    int i = bejj.b((int)((oidb_0xe61.BeancurdCubeInfo)paramBeancurdCubeInfoResult.beancurdCubeInfo.get()).uint64_busi_id.get());
    paramBeancurdCubeInfoResult = ((bejl)this.jdField_a_of_type_Awxb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).a(i);
    if (paramBeancurdCubeInfoResult != null) {
      return paramBeancurdCubeInfoResult.a();
    }
    return 0;
  }
  
  private boolean a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    return (paramBeancurdCubeInfoResult != null) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.has()) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.get() != null) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.uint64_busi_id.has());
  }
  
  public int a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult1, oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult2)
  {
    if ((a(paramBeancurdCubeInfoResult1)) && (a(paramBeancurdCubeInfoResult2)))
    {
      int i = a(paramBeancurdCubeInfoResult1);
      int j = a(paramBeancurdCubeInfoResult2);
      return this.jdField_a_of_type_Aggr.b(i) - this.jdField_a_of_type_Aggr.b(j);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejh
 * JD-Core Version:    0.7.0.1
 */