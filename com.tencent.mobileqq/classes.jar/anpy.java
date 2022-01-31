import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class anpy
  extends anpw
{
  anpy(anpx paramanpx) {}
  
  protected void a(boolean paramBoolean1, anpr paramanpr, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = anpx.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      anpx.a(this.a, str4, null, null);
      return;
    }
    if ((paramanpr != null) && (paramanpr.a != null) && (!paramanpr.a.isEmpty())) {}
    for (paramanpr = DynamicAvatar.convertFrom((anps)paramanpr.a.get(0));; paramanpr = null)
    {
      if (paramanpr == null)
      {
        anpx.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramanpr);
      }
      String str2 = anpx.a(paramInt2, paramInt3, paramanpr);
      String str3 = anpx.a(paramInt2, 640, paramanpr);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = anpx.a(17, paramInt3, paramanpr);
          str1 = anpx.a(17, 640, paramanpr);
        }
      }
      anpx.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpy
 * JD-Core Version:    0.7.0.1
 */