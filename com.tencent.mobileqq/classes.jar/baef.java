import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;

public class baef
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
        str = ajjy.a(2131642428) + paramFloat + ajjy.a(2131642414);
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
          return ajjy.a(2131642440) + paramFloat + ajjy.a(2131642435);
        }
        if (paramBoolean1) {
          return ajjy.a(2131642423) + paramFloat + ajjy.a(2131642422);
        }
        return ajjy.a(2131642413) + paramFloat + ajjy.a(2131642420);
      } while (paramInt == 0);
      str = ajjy.a(2131642429);
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
        i = 2131653899;
      }
    }
    else {
      return i;
    }
    if (paramBoolean2) {
      return 2131653901;
    }
    if (paramBoolean1) {
      return 2131653903;
    }
    return 2131653900;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baef
 * JD-Core Version:    0.7.0.1
 */