import android.view.View;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

public class bbbt
  extends bbck
{
  private bbau jdField_a_of_type_Bbau;
  private bbbc jdField_a_of_type_Bbbc;
  private bbbp jdField_a_of_type_Bbbp;
  private bbbv jdField_a_of_type_Bbbv;
  
  public bbbt(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Bbbp = new bbbp(paramFaceDecoder);
    this.jdField_a_of_type_Bbbc = new bbbc(paramFaceDecoder);
    this.jdField_a_of_type_Bbau = new bbau(paramFaceDecoder, 268435456);
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    if ((!(parambayt instanceof bayp)) && (!(parambayt instanceof baxr))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((parambayt instanceof bayp))
      {
        localObject = (bayp)parambayt;
        int i = bbae.a(((bayp)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Bbbp.b(parambayt, parambbhb);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Bbbc.b(parambayt, parambbhb);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((bayp)localObject).e());
        return;
      }
    } while (!(parambayt instanceof baxr));
    Object localObject = (baxr)parambayt;
    if (bbae.a(((baxr)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Bbau.b(parambayt, parambbhb);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((baxr)localObject).e());
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    if (this.jdField_a_of_type_Bbbv != null)
    {
      if (parambbhb.a() != null) {
        parambbhb.a().setOnClickListener(new bbbu(this));
      }
      return;
    }
    super.c(parambayt, parambbhb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbt
 * JD-Core Version:    0.7.0.1
 */