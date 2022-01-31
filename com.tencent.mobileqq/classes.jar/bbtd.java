import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1;
import java.util.UUID;

public class bbtd
  extends ypu
{
  bbtd(bbtc parambbtc) {}
  
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
      bbrc.c("TroopFileUploadFeedsSender", bbrc.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult retCode:" + paramInt1);
      paramBundle = paramBundle.getString("fileId");
      bcil localbcil = bbra.a(this.a.d);
      if (localbcil == null)
      {
        bbrc.a("TroopFileUploadFeedsSender", bbrc.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getTroopFileMgr()=null");
        return;
      }
      paramString = localbcil.a(paramString);
      if (paramString == null)
      {
        bbrc.a("TroopFileUploadFeedsSender", bbrc.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getFileInfo()=null");
        return;
      }
    } while (paramInt1 != 0);
    bbrc.c("TroopFileUploadFeedsSender", bbrc.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult refreshOneFile");
    ypf.a(bbra.a(), this.a.d, paramString.a, paramString.b, this.a.jdField_a_of_type_Ypo);
    ThreadManager.executeOnSubThread(new TroopFileUploadFeedsSender.1.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtd
 * JD-Core Version:    0.7.0.1
 */