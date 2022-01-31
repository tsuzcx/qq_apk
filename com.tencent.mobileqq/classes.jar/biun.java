import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.2.1.1;
import java.util.ArrayList;

public class biun
  implements biwf
{
  biun(bium parambium) {}
  
  public void a()
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateFail");
    biuk.d(this.a.a);
    bfny.a(new AEGIFSinglePreviewFragment.2.1.1(this));
  }
  
  public void a(String paramString)
  {
    QLog.d("AEGIFSinglePreviewFragment", 4, "onGifCreateSuccess, come from AECAMERA_MODE_ALL");
    biuk.d(this.a.a);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String str;
    if (!biuk.a(this.a.a)) {
      if (biuk.a(this.a.a) != null) {
        str = biuk.a(this.a.a).a();
      }
    }
    for (;;)
    {
      localArrayList1.add(paramString);
      localArrayList2.add(str);
      biuk.a(this.a.a, localArrayList1, localArrayList2);
      if ((!biuk.b(this.a.a)) || (biuk.a(this.a.a) == null)) {
        break;
      }
      biuk.a(this.a.a, paramString, biuk.a(this.a.a), str);
      return;
      str = "";
      continue;
      str = biuk.b(this.a.a);
    }
    bjzs.a(biuk.a(this.a.a), paramString, birt.b(this.a.a.getActivity()), true, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biun
 * JD-Core Version:    0.7.0.1
 */