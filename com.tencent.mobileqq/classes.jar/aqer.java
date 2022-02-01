import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aqer
  extends aqep
{
  aqer(aqeq paramaqeq) {}
  
  protected void a(boolean paramBoolean1, aqek paramaqek, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = aqeq.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      aqeq.a(this.a, str4, null, null);
      return;
    }
    if ((paramaqek != null) && (paramaqek.a != null) && (!paramaqek.a.isEmpty())) {}
    for (paramaqek = DynamicAvatar.convertFrom((aqel)paramaqek.a.get(0));; paramaqek = null)
    {
      if (paramaqek == null)
      {
        aqeq.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramaqek);
      }
      String str2 = aqeq.a(paramInt2, paramInt3, paramaqek);
      String str3 = aqeq.a(paramInt2, 640, paramaqek);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = aqeq.a(17, paramInt3, paramaqek);
          str1 = aqeq.a(17, 640, paramaqek);
        }
      }
      aqeq.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqer
 * JD-Core Version:    0.7.0.1
 */