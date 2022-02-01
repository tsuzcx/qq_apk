import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

class amwh
  implements bhot
{
  amwh(amwf paramamwf, List paramList, String paramString1, String paramString2, int paramInt) {}
  
  public boolean a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA onGetBaseInfo uin:" + ApolloUtil.d(paramString));
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int i = amme.a(ApolloUtil.a(), this.jdField_a_of_type_JavaLangString, true);
      int j = amme.a(ApolloUtil.a(), this.b, true);
      paramString = new Bundle();
      paramString.putInt("selfUinStatus", i);
      paramString.putInt("friendUinStatus", j);
      paramString = EIPCResult.createSuccessResult(paramString);
      this.jdField_a_of_type_Amwf.callbackResult(this.jdField_a_of_type_Int, paramString);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA onDressUpdated uin:" + ApolloUtil.d(paramString));
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      int i = amme.a(ApolloUtil.a(), this.jdField_a_of_type_JavaLangString, true);
      int j = amme.a(ApolloUtil.a(), this.b, true);
      paramString = new Bundle();
      paramString.putInt("selfUinStatus", i);
      paramString.putInt("friendUinStatus", j);
      paramString = EIPCResult.createSuccessResult(paramString);
      this.jdField_a_of_type_Amwf.callbackResult(this.jdField_a_of_type_Int, paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwh
 * JD-Core Version:    0.7.0.1
 */