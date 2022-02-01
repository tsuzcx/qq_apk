import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apbn
  extends apbl
{
  apbn(apbm paramapbm) {}
  
  protected void a(boolean paramBoolean1, apbg paramapbg, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = apbm.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      apbm.a(this.a, str4, null, null);
      return;
    }
    if ((paramapbg != null) && (paramapbg.a != null) && (!paramapbg.a.isEmpty())) {}
    for (paramapbg = DynamicAvatar.convertFrom((apbh)paramapbg.a.get(0));; paramapbg = null)
    {
      if (paramapbg == null)
      {
        apbm.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramapbg);
      }
      String str2 = apbm.a(paramInt2, paramInt3, paramapbg);
      String str3 = apbm.a(paramInt2, 640, paramapbg);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = apbm.a(17, paramInt3, paramapbg);
          str1 = apbm.a(17, 640, paramapbg);
        }
      }
      apbm.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbn
 * JD-Core Version:    0.7.0.1
 */