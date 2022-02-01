import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aqic
  extends aqia
{
  aqic(aqib paramaqib) {}
  
  protected void a(boolean paramBoolean1, aqhv paramaqhv, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = aqib.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      aqib.a(this.a, str4, null, null);
      return;
    }
    if ((paramaqhv != null) && (paramaqhv.a != null) && (!paramaqhv.a.isEmpty())) {}
    for (paramaqhv = DynamicAvatar.convertFrom((aqhw)paramaqhv.a.get(0));; paramaqhv = null)
    {
      if (paramaqhv == null)
      {
        aqib.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramaqhv);
      }
      String str2 = aqib.a(paramInt2, paramInt3, paramaqhv);
      String str3 = aqib.a(paramInt2, 640, paramaqhv);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = aqib.a(17, paramInt3, paramaqhv);
          str1 = aqib.a(17, 640, paramaqhv);
        }
      }
      aqib.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqic
 * JD-Core Version:    0.7.0.1
 */