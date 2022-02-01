import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import java.io.File;
import java.util.List;

public class bnot
  extends ViewModel
{
  private MutableLiveData<bnmo> a = new MutableLiveData();
  private MutableLiveData<String> b = new MutableLiveData();
  private MutableLiveData<bnpc> c = new MutableLiveData();
  
  public MutableLiveData<bnmo> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.postValue(new bnmo("#ccffffff", "#000000"));
    this.b.postValue("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.postValue(paramString);
    this.a.postValue(bnmn.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    bnpc localbnpc = new bnpc();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      bmve.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localbnpc.a = paramString2;
    localbnpc.b = paramString1;
    localbnpc.c = str;
    this.c.postValue(localbnpc);
  }
  
  public MutableLiveData<String> b()
  {
    return this.b;
  }
  
  public MutableLiveData<bnpc> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnot
 * JD-Core Version:    0.7.0.1
 */