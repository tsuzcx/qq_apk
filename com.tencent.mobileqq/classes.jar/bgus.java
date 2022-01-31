import android.text.TextUtils;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.utils.ErrorCodeUtil;
import com.tencent.weiyun.utils.NetworkUtils;

public final class bgus
{
  public static String a(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramInt != 0)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        str = ErrorCodeUtil.getErrorMsg(paramInt);
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          if (!ErrorCodeUtil.isHttpError(paramInt)) {
            break label101;
          }
        }
      }
    }
    label101:
    for (paramString = ErrorCodeUtil.getErrorMsg(1810023);; paramString = ErrorCodeUtil.getErrorMsg(1810014))
    {
      str = paramString;
      if (1810008 == paramInt) {
        str = paramString + "\n请尝试下载到其他路径";
      }
      str = "(" + paramInt + ")" + str;
      return str;
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int i = NetworkUtils.getNetworkType(WeiyunTransmissionGlobal.getInstance().getContext());
    paramString.append("&nettype=").append(i);
    return paramString.toString();
  }
  
  static boolean a(int paramInt)
  {
    return (-29150 == paramInt) || (-29151 == paramInt) || (-29152 == paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgus
 * JD-Core Version:    0.7.0.1
 */