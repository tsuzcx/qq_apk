import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1;
import java.util.UUID;

public class bfof
  extends aahn
{
  bfof(bfoe parambfoe) {}
  
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
      bfmf.c("TroopFileUploadFeedsSender", bfmf.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult retCode:" + paramInt1);
      paramBundle = paramBundle.getString("fileId");
      bgjh localbgjh = bfmd.a(this.a.d);
      if (localbgjh == null)
      {
        bfmf.a("TroopFileUploadFeedsSender", bfmf.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getTroopFileMgr()=null");
        return;
      }
      paramString = localbgjh.a(paramString);
      if (paramString == null)
      {
        bfmf.a("TroopFileUploadFeedsSender", bfmf.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getFileInfo()=null");
        return;
      }
    } while (paramInt1 != 0);
    bfmf.c("TroopFileUploadFeedsSender", bfmf.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult refreshOneFile");
    aagu.a(bfmd.a(), this.a.d, paramString.a, paramString.b, this.a.jdField_a_of_type_Aahi);
    ThreadManager.executeOnSubThread(new TroopFileUploadFeedsSender.1.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfof
 * JD-Core Version:    0.7.0.1
 */