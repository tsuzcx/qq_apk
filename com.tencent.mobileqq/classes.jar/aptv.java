import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aptv
  implements apwu
{
  aptv(apts paramapts) {}
  
  public void a(List<apws> paramList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshPanelData call back dataList = ");
      if (paramList != null) {
        break label60;
      }
    }
    label60:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.d("CameraEmotionAdapter", 2, localObject);
      if (paramList != null)
      {
        this.a.a(paramList);
        this.a.notifyDataSetChanged();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptv
 * JD-Core Version:    0.7.0.1
 */