import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bciz
  implements bcif<bcfh, bcns>
{
  protected bcie a;
  private FaceDecoder a;
  
  public bciz(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bcie = a(paramFaceDecoder);
  }
  
  public bciz(FaceDecoder paramFaceDecoder, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bcie = a(paramFaceDecoder, paramInt);
  }
  
  public bciz(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bcie = a(paramFaceDecoder, paramBoolean);
  }
  
  public bcie a()
  {
    return this.jdField_a_of_type_Bcie;
  }
  
  protected bcie<bcfj, bcnt> a(FaceDecoder paramFaceDecoder)
  {
    return new bcjc(paramFaceDecoder);
  }
  
  protected bcie<bcfj, bcnt> a(FaceDecoder paramFaceDecoder, int paramInt)
  {
    return new bchk(paramFaceDecoder, paramInt);
  }
  
  protected bcie<bcfj, bcnt> a(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramFaceDecoder);
    }
    return new bcic(paramFaceDecoder);
  }
  
  public void a(bcfh parambcfh, bcns parambcns)
  {
    int i = 0;
    Object localObject = (bcfi)parambcfh;
    a(parambcns, (bcfi)localObject);
    int n = ((bcfi)localObject).a();
    parambcfh = parambcns.a();
    if ((parambcfh != null) && (parambcfh != null))
    {
      localObject = ((bcfi)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < parambcfh.size())
        {
          j = 1;
          if (i >= ((List)localObject).size()) {
            break label296;
          }
          k = 1;
          label82:
          if (i >= n) {
            break label302;
          }
        }
        label296:
        label302:
        for (int m = 1;; m = 0)
        {
          if ((m & k & j) == 0) {
            break label308;
          }
          ((bcnt)parambcfh.get(i)).a().setVisibility(0);
          ((bcnt)parambcfh.get(i)).a().setTag(2131381183, ((List)localObject).get(i));
          ((bcnt)parambcfh.get(i)).a().setTag(2131381188, parambcfh.get(i));
          ((bcnt)parambcfh.get(i)).a().setTag(2131381184, Integer.valueOf(i));
          ((bcnt)parambcfh.get(i)).a().setTag(2131381182, Integer.valueOf(parambcfh.size()));
          ((bcnt)parambcfh.get(i)).a().setTag(2131381185, this.jdField_a_of_type_Bcie);
          this.jdField_a_of_type_Bcie.a((bcfh)((List)localObject).get(i), (bcnu)parambcfh.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
        while (i < parambcfh.size())
        {
          ((bcnt)parambcfh.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < parambcfh.size())
      {
        ((bcnt)parambcfh.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (parambcns.b() != null) {
      parambcns.b().setVisibility(8);
    }
  }
  
  protected void a(bcns parambcns, bcfi parambcfi)
  {
    if (parambcns.a() != null) {
      parambcns.a().setText(parambcfi.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciz
 * JD-Core Version:    0.7.0.1
 */