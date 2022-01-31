import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class amyn
  implements AsyncBack
{
  amyn(amym paramamym) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipPreloadReaderProcess", 2, "Load offline package finish, code = " + paramInt);
    }
    if ((paramInt != 0) && (QLog.isColorLevel())) {
      QLog.e("VipProxyRreLoadReaderProcess", 2, "offline update failed.");
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyn
 * JD-Core Version:    0.7.0.1
 */