import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bbch
  implements bbbn<bayr, bbha>
{
  protected bbbm a;
  private FaceDecoder a;
  
  public bbch(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bbbm = a(paramFaceDecoder);
  }
  
  public bbch(FaceDecoder paramFaceDecoder, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bbbm = a(paramFaceDecoder, paramInt);
  }
  
  public bbch(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bbbm = a(paramFaceDecoder, paramBoolean);
  }
  
  public bbbm a()
  {
    return this.jdField_a_of_type_Bbbm;
  }
  
  protected bbbm<bayt, bbhb> a(FaceDecoder paramFaceDecoder)
  {
    return new bbck(paramFaceDecoder);
  }
  
  protected bbbm<bayt, bbhb> a(FaceDecoder paramFaceDecoder, int paramInt)
  {
    return new bbau(paramFaceDecoder, paramInt);
  }
  
  protected bbbm<bayt, bbhb> a(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramFaceDecoder);
    }
    return new bbbk(paramFaceDecoder);
  }
  
  public void a(bayr parambayr, bbha parambbha)
  {
    int i = 0;
    Object localObject = (bays)parambayr;
    a(parambbha, (bays)localObject);
    int n = ((bays)localObject).a();
    parambayr = parambbha.a();
    if ((parambayr != null) && (parambayr != null))
    {
      localObject = ((bays)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < parambayr.size())
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
          ((bbhb)parambayr.get(i)).a().setVisibility(0);
          ((bbhb)parambayr.get(i)).a().setTag(2131380831, ((List)localObject).get(i));
          ((bbhb)parambayr.get(i)).a().setTag(2131380836, parambayr.get(i));
          ((bbhb)parambayr.get(i)).a().setTag(2131380832, Integer.valueOf(i));
          ((bbhb)parambayr.get(i)).a().setTag(2131380830, Integer.valueOf(parambayr.size()));
          ((bbhb)parambayr.get(i)).a().setTag(2131380833, this.jdField_a_of_type_Bbbm);
          this.jdField_a_of_type_Bbbm.a((bayr)((List)localObject).get(i), (bbhc)parambayr.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
        while (i < parambayr.size())
        {
          ((bbhb)parambayr.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < parambayr.size())
      {
        ((bbhb)parambayr.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (parambbha.b() != null) {
      parambbha.b().setVisibility(8);
    }
  }
  
  protected void a(bbha parambbha, bays parambays)
  {
    if (parambbha.a() != null) {
      parambbha.a().setText(parambays.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbch
 * JD-Core Version:    0.7.0.1
 */