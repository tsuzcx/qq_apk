import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment.3.1;
import com.tencent.qphone.base.util.QLog;

public class bdya
  implements bdxl
{
  public bdya(LiangHaoBuyFragment paramLiangHaoBuyFragment) {}
  
  public void a(Intent paramIntent, boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("lockLH uin=").append(paramString1).append(",suc=").append(paramBoolean).append(",lhsig=");
      if (paramArrayOfByte == null) {
        break label89;
      }
    }
    label89:
    for (String str = SecUtil.toHexString(paramArrayOfByte);; str = "null")
    {
      QLog.i("LiangHaoBuyFragment", 4, str);
      ThreadManagerV2.getUIHandlerV2().post(new LiangHaoBuyFragment.3.1(this, paramBoolean, paramIntent, paramString1, paramArrayOfByte, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdya
 * JD-Core Version:    0.7.0.1
 */