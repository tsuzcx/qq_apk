import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class anuh
  extends anuf
{
  anuh(anug paramanug) {}
  
  protected void a(boolean paramBoolean1, anua paramanua, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = anug.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      anug.a(this.a, str4, null, null);
      return;
    }
    if ((paramanua != null) && (paramanua.a != null) && (!paramanua.a.isEmpty())) {}
    for (paramanua = DynamicAvatar.convertFrom((anub)paramanua.a.get(0));; paramanua = null)
    {
      if (paramanua == null)
      {
        anug.a(this.a, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramanua);
      }
      String str2 = anug.a(paramInt2, paramInt3, paramanua);
      String str3 = anug.a(paramInt2, 640, paramanua);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = anug.a(17, paramInt3, paramanua);
          str1 = anug.a(17, 640, paramanua);
        }
      }
      anug.a(this.a, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anuh
 * JD-Core Version:    0.7.0.1
 */