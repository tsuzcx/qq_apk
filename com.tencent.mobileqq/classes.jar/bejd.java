import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Comparator;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

class bejd
  implements Comparator<oidb_0xe61.BeancurdCubeInfoResult>
{
  private final afqy jdField_a_of_type_Afqy;
  private final awqn<bejh, QQAppInterface> jdField_a_of_type_Awqn;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bejd(QQAppInterface paramQQAppInterface, afqy paramafqy, awqn<bejh, QQAppInterface> paramawqn)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Afqy = paramafqy;
    this.jdField_a_of_type_Awqn = paramawqn;
  }
  
  private int a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    int i = bejf.b((int)((oidb_0xe61.BeancurdCubeInfo)paramBeancurdCubeInfoResult.beancurdCubeInfo.get()).uint64_busi_id.get());
    paramBeancurdCubeInfoResult = ((bejh)this.jdField_a_of_type_Awqn.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).a(i);
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
      return this.jdField_a_of_type_Afqy.b(i) - this.jdField_a_of_type_Afqy.b(j);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejd
 * JD-Core Version:    0.7.0.1
 */