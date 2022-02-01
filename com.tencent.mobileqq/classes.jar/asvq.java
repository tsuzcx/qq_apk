import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.9;
import com.tencent.qphone.base.util.QLog;

public class asvq
  extends apck
{
  public asvq(ExtendFriendManager.9 param9, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync onLocationFinish " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvq
 * JD-Core Version:    0.7.0.1
 */