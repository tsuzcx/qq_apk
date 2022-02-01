import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bcid
  extends bciz
{
  public bcid(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder, 268435456);
  }
  
  public void a(bcfh parambcfh, bcns parambcns)
  {
    Object localObject1 = (bcfi)parambcfh;
    parambcfh = ((bcnq)parambcns).a();
    if (parambcfh != null)
    {
      List localList = ((bcfi)localObject1).a();
      if (localList != null)
      {
        parambcfh.removeAllViews();
        int j = Math.min(localList.size(), ((bcfi)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new bcpb(((bcnq)parambcns).a(), 268435456);
          Object localObject2 = ((bcpb)localObject1).a();
          bcfj localbcfj = (bcfj)localList.get(i);
          ((View)localObject2).setTag(2131381183, localbcfj);
          ((View)localObject2).setTag(2131381188, localObject1);
          ((View)localObject2).setTag(2131381184, Integer.valueOf(i));
          ((View)localObject2).setTag(2131381182, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131381185, this.a);
          if ((localbcfj instanceof bceh)) {
            bcnf.a((bceh)localbcfj, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          parambcfh.addView(((bcpb)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localbcfj, (bcnu)localObject1);
          i += 1;
        }
      }
    }
    if (parambcns.b() != null) {
      parambcns.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcid
 * JD-Core Version:    0.7.0.1
 */