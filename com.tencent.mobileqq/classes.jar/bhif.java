import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.util.QQAvatarFHDDecoder.1.1;
import com.tencent.mobileqq.util.QQAvatarFHDDecoder.1.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bhif
  extends anyu
{
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetHeadInfo ").append(paramBoolean).append(" ");
      if (paramSetting == null) {
        break label99;
      }
    }
    label99:
    for (String str = paramSetting.uin;; str = "")
    {
      QLog.i("QQAvatarFHDDecoder", 2, str);
      if ((paramSetting != null) && (paramSetting.uin != null) && (paramSetting.uin.equals(bhie.a(this.a)))) {
        ThreadManagerV2.excute(new QQAvatarFHDDecoder.1.1(this, paramSetting), 128, null, true);
      }
      return;
    }
  }
  
  public void onGetHeadInfoEmpty(boolean paramBoolean, int paramInt, List<String> paramList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetHeadInfoEmpty ").append(paramBoolean).append(" ").append(paramInt).append(" ");
      if (paramList == null) {
        break label138;
      }
    }
    label138:
    for (String str = paramList.toString();; str = "")
    {
      QLog.i("QQAvatarFHDDecoder", 2, str);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          if ((str != null) && (str.equals(bhie.a(this.a))))
          {
            if (!paramBoolean) {
              break label145;
            }
            ThreadManagerV2.excute(new QQAvatarFHDDecoder.1.2(this, str), 128, null, true);
          }
        }
      }
      return;
    }
    label145:
    bhie.a(this.a).obtainMessage(1).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhif
 * JD-Core Version:    0.7.0.1
 */