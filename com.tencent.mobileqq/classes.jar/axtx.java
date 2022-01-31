import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.richmediabrowser.presenter.IProvider;

public class axtx
  implements IProvider
{
  public agft a;
  
  public void a(agft paramagft)
  {
    this.a = paramagft;
  }
  
  public void cancelDownloadMedia(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.b(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void downloadMedia(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void favorite(long paramLong)
  {
    if (this.a != null) {
      this.a.e(paramLong);
    }
  }
  
  public Intent getFavorateParams(long paramLong, int paramInt)
  {
    if (this.a != null) {
      return this.a.a(paramLong, paramInt);
    }
    return null;
  }
  
  public Intent getForwardData(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      return this.a.a(paramLong, paramInt1, paramInt2);
    }
    return null;
  }
  
  public int getSaveFileProgress(long paramLong, int paramInt)
  {
    if (this.a != null) {
      return this.a.a(paramLong, paramInt);
    }
    return 0;
  }
  
  public boolean isPingBinder()
  {
    if (this.a != null) {
      return this.a.asBinder().pingBinder();
    }
    return false;
  }
  
  public void loadMedias(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public void onFileVideoStatusChange(long paramLong, int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.a(paramLong, paramInt, paramBundle);
    }
  }
  
  public void payFlow(long paramLong, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramLong, paramInt);
    }
  }
  
  public void reportData(String paramString, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramString, paramInt);
    }
  }
  
  public void safetyReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.a != null) {
      this.a.a(paramInt, paramBoolean, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void saveToWeiyun(long paramLong)
  {
    if (this.a != null) {
      this.a.c(paramLong);
    }
  }
  
  public void sendFileToPC(long paramLong)
  {
    if (this.a != null) {
      this.a.d(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtx
 * JD-Core Version:    0.7.0.1
 */