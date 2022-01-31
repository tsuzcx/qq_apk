import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1;
import java.util.UUID;

public class azuu
  extends xbb
{
  azuu(azut paramazut) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        do
        {
          return;
          paramString = paramBundle.getString("itemKey");
        } while (paramString == null);
        paramString = UUID.fromString(paramString);
      } while (!paramString.equals(this.a.a()));
      azst.c("TroopFileUploadFeedsSender", azst.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult retCode:" + paramInt1);
      paramBundle = paramBundle.getString("fileId");
      bajy localbajy = azsr.a(this.a.d);
      if (localbajy == null)
      {
        azst.a("TroopFileUploadFeedsSender", azst.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getTroopFileMgr()=null");
        return;
      }
      paramString = localbajy.a(paramString);
      if (paramString == null)
      {
        azst.a("TroopFileUploadFeedsSender", azst.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getFileInfo()=null");
        return;
      }
    } while (paramInt1 != 0);
    azst.c("TroopFileUploadFeedsSender", azst.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult refreshOneFile");
    xam.a(azsr.a(), this.a.d, paramString.a, paramString.b, this.a.jdField_a_of_type_Xav);
    ThreadManager.executeOnSubThread(new TroopFileUploadFeedsSender.1.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azuu
 * JD-Core Version:    0.7.0.1
 */