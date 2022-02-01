import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;

public class bhog
{
  public static int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {
      return 1;
    }
    if (paramBoolean2) {
      return 2;
    }
    if (paramBoolean1) {
      return 3;
    }
    return 4;
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, float paramFloat)
  {
    String str = "";
    boolean bool1 = MediaPlayerManager.a(paramFloat);
    boolean bool2 = MediaPlayerManager.a(paramFloat, MediaPlayerManager.b);
    boolean bool3 = MediaPlayerManager.a(paramFloat, MediaPlayerManager.c);
    if ((paramInt == 0) && (bool1)) {
      if (bool3)
      {
        paramFloat = 2.0F;
        if (!paramBoolean3) {
          break label95;
        }
        str = anzj.a(2131707093) + paramFloat + anzj.a(2131707079);
      }
    }
    label95:
    do
    {
      do
      {
        return str;
        paramFloat = 1.5F;
        break;
        if (paramBoolean2) {
          return anzj.a(2131707105) + paramFloat + anzj.a(2131707100);
        }
        if (paramBoolean1) {
          return anzj.a(2131707088) + paramFloat + anzj.a(2131707087);
        }
        return anzj.a(2131707078) + paramFloat + anzj.a(2131707085);
      } while (paramInt == 0);
      str = anzj.a(2131707094);
      if (bool2) {
        return "当前为1.5倍速播放";
      }
    } while (!bool3);
    return "当前为2倍速播放";
  }
  
  public static int b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    if (!AppSetting.c)
    {
      if (paramBoolean3) {
        i = 2131718358;
      }
    }
    else {
      return i;
    }
    if (paramBoolean2) {
      return 2131718360;
    }
    if (paramBoolean1) {
      return 2131718361;
    }
    return 2131718359;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhog
 * JD-Core Version:    0.7.0.1
 */