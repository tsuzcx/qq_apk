import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import java.io.File;
import java.util.List;

public class bnts
  extends ViewModel
{
  private MutableLiveData<bnrl> a = new MutableLiveData();
  private MutableLiveData<String> b = new MutableLiveData();
  private MutableLiveData<bnub> c = new MutableLiveData();
  
  public MutableLiveData<bnrl> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.postValue(new bnrl("#ccffffff", "#000000"));
    this.b.postValue("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.postValue(paramString);
    this.a.postValue(bnrk.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    bnub localbnub = new bnub();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bncx.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localbnub.a = paramString2;
    localbnub.b = paramString1;
    localbnub.c = str;
    this.c.postValue(localbnub);
  }
  
  public MutableLiveData<String> b()
  {
    return this.b;
  }
  
  public MutableLiveData<bnub> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnts
 * JD-Core Version:    0.7.0.1
 */