import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1;
import java.util.UUID;

public class bfxr
  extends aavo
{
  bfxr(bfxq parambfxq) {}
  
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
      bfvr.c("TroopFileUploadFeedsSender", bfvr.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult retCode:" + paramInt1);
      paramBundle = paramBundle.getString("fileId");
      bgrn localbgrn = bfvp.a(this.a.d);
      if (localbgrn == null)
      {
        bfvr.a("TroopFileUploadFeedsSender", bfvr.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getTroopFileMgr()=null");
        return;
      }
      paramString = localbgrn.a(paramString);
      if (paramString == null)
      {
        bfvr.a("TroopFileUploadFeedsSender", bfvr.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getFileInfo()=null");
        return;
      }
    } while (paramInt1 != 0);
    bfvr.c("TroopFileUploadFeedsSender", bfvr.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult refreshOneFile");
    aauw.a(bfvp.a(), this.a.d, paramString.a, paramString.b, this.a.jdField_a_of_type_Aavj);
    ThreadManager.executeOnSubThread(new TroopFileUploadFeedsSender.1.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxr
 * JD-Core Version:    0.7.0.1
 */