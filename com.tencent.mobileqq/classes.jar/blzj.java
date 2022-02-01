import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import java.io.File;
import java.util.List;

public class blzj
  extends ViewModel
{
  private MutableLiveData<blxe> a = new MutableLiveData();
  private MutableLiveData<String> b = new MutableLiveData();
  private MutableLiveData<blzs> c = new MutableLiveData();
  
  public MutableLiveData<blxe> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.postValue(new blxe("#ccffffff", "#000000"));
    this.b.postValue("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.postValue(paramString);
    this.a.postValue(blxd.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    blzs localblzs = new blzs();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      blin.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localblzs.a = paramString2;
    localblzs.b = paramString1;
    localblzs.c = str;
    this.c.postValue(localblzs);
  }
  
  public MutableLiveData<String> b()
  {
    return this.b;
  }
  
  public MutableLiveData<blzs> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzj
 * JD-Core Version:    0.7.0.1
 */