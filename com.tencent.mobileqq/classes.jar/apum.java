import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apum
  extends apuk
{
  apum(apul paramapul) {}
  
  protected void a(boolean paramBoolean1, apuf paramapuf, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = apul.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      apul.a(this.a, str4, null, null);
      return;
    }
    if ((paramapuf != null) && (paramapuf.a != null) && (!paramapuf.a.isEmpty())) {}
    for (paramapuf = DynamicAvatar.convertFrom((apug)paramapuf.a.get(0));; paramapuf = null)
    {
      if (paramapuf == null)
      {
        apul.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramapuf);
      }
      String str2 = apul.a(paramInt2, paramInt3, paramapuf);
      String str3 = apul.a(paramInt2, 640, paramapuf);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = apul.a(17, paramInt3, paramapuf);
          str1 = apul.a(17, 640, paramapuf);
        }
      }
      apul.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apum
 * JD-Core Version:    0.7.0.1
 */