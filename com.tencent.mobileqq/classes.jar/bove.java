import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import java.io.File;
import java.util.List;

public class bove
  extends ViewModel
{
  private MutableLiveData<bosz> a = new MutableLiveData();
  private MutableLiveData<String> b = new MutableLiveData();
  private MutableLiveData<bovn> c = new MutableLiveData();
  
  public MutableLiveData<bosz> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.postValue(new bosz("#ccffffff", "#000000"));
    this.b.postValue("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.postValue(paramString);
    this.a.postValue(bosy.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    bovn localbovn = new bovn();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      boef.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localbovn.a = paramString2;
    localbovn.b = paramString1;
    localbovn.c = str;
    this.c.postValue(localbovn);
  }
  
  public MutableLiveData<String> b()
  {
    return this.b;
  }
  
  public MutableLiveData<bovn> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bove
 * JD-Core Version:    0.7.0.1
 */