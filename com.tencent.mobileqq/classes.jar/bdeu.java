import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;

public class bdeu
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
        str = alpo.a(2131708596) + paramFloat + alpo.a(2131708582);
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
          return alpo.a(2131708608) + paramFloat + alpo.a(2131708603);
        }
        if (paramBoolean1) {
          return alpo.a(2131708591) + paramFloat + alpo.a(2131708590);
        }
        return alpo.a(2131708581) + paramFloat + alpo.a(2131708588);
      } while (paramInt == 0);
      str = alpo.a(2131708597);
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
        i = 2131720320;
      }
    }
    else {
      return i;
    }
    if (paramBoolean2) {
      return 2131720322;
    }
    if (paramBoolean1) {
      return 2131720324;
    }
    return 2131720321;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdeu
 * JD-Core Version:    0.7.0.1
 */