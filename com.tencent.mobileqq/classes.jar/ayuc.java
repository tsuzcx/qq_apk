import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1;
import java.util.UUID;

public class ayuc
  extends wmb
{
  ayuc(ayub paramayub) {}
  
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
      aysb.c("TroopFileUploadFeedsSender", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult retCode:" + paramInt1);
      paramBundle = paramBundle.getString("fileId");
      azih localazih = ayrz.a(this.a.d);
      if (localazih == null)
      {
        aysb.a("TroopFileUploadFeedsSender", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getTroopFileMgr()=null");
        return;
      }
      paramString = localazih.a(paramString);
      if (paramString == null)
      {
        aysb.a("TroopFileUploadFeedsSender", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getFileInfo()=null");
        return;
      }
    } while (paramInt1 != 0);
    aysb.c("TroopFileUploadFeedsSender", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult refreshOneFile");
    wln.a(ayrz.a(), this.a.d, paramString.a, paramString.b, this.a.jdField_a_of_type_Wlv);
    ThreadManager.executeOnSubThread(new TroopFileUploadFeedsSender.1.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayuc
 * JD-Core Version:    0.7.0.1
 */