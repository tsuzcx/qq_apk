import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleLogListener;
import org.jetbrains.annotations.NotNull;

final class bggx
  implements WebBundleLogListener
{
  public void log(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    if (QLog.isColorLevel()) {}
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      QLog.i(paramString1, 2, paramString2);
      return;
    case 3: 
      QLog.d(paramString1, 2, paramString2);
      return;
    case 5: 
      QLog.w(paramString1, 2, paramString2);
      return;
    }
    QLog.e(paramString1, 2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggx
 * JD-Core Version:    0.7.0.1
 */