import com.tencent.mobileqq.apollo.ApolloResManager.6;

public class amob
  implements anfg
{
  public amob(ApolloResManager.6 param6) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    amoe localamoe;
    if (this.a.a != null)
    {
      localamoe = this.a.a;
      if (!paramBoolean) {
        break label69;
      }
      paramString = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + paramInt1;
      if (!paramBoolean) {
        break label74;
      }
      paramArrayOfInt = "success";
      label51:
      if (!paramBoolean) {
        break label81;
      }
    }
    label69:
    label74:
    label81:
    for (paramInt1 = 0;; paramInt1 = -5003)
    {
      localamoe.a(paramString, paramArrayOfInt, paramInt1);
      return;
      paramString = null;
      break;
      paramArrayOfInt = "download error";
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amob
 * JD-Core Version:    0.7.0.1
 */