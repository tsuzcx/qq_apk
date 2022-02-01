import android.view.View;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

public class bcil
  extends bcjc
{
  private bchk jdField_a_of_type_Bchk;
  private bchu jdField_a_of_type_Bchu;
  private bcih jdField_a_of_type_Bcih;
  private bcin jdField_a_of_type_Bcin;
  
  public bcil(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Bcih = new bcih(paramFaceDecoder);
    this.jdField_a_of_type_Bchu = new bchu(paramFaceDecoder);
    this.jdField_a_of_type_Bchk = new bchk(paramFaceDecoder, 268435456);
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    if ((!(parambcfj instanceof bcff)) && (!(parambcfj instanceof bceh))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((parambcfj instanceof bcff))
      {
        localObject = (bcff)parambcfj;
        int i = bcgu.a(((bcff)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Bcih.b(parambcfj, parambcnt);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Bchu.b(parambcfj, parambcnt);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((bcff)localObject).e());
        return;
      }
    } while (!(parambcfj instanceof bceh));
    Object localObject = (bceh)parambcfj;
    if (bcgu.a(((bceh)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Bchk.b(parambcfj, parambcnt);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((bceh)localObject).e());
  }
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    if (this.jdField_a_of_type_Bcin != null)
    {
      if (parambcnt.a() != null) {
        parambcnt.a().setOnClickListener(new bcim(this));
      }
      return;
    }
    super.c(parambcfj, parambcnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcil
 * JD-Core Version:    0.7.0.1
 */