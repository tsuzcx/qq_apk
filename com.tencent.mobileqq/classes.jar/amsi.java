import com.tencent.qphone.base.util.QLog;

class amsi
  extends bhhe
{
  amsi(amsg paramamsg) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambhhf.a());
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    if ((parambhhf == null) || (amsg.a(this.a) == null)) {
      return;
    }
    if (parambhhf.a() != 3)
    {
      amsg.a(this.a, 2);
      if (amsg.a(this.a) != null) {
        amsg.a(this.a).c(-1005, amsg.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambhhf.a());
      return;
    }
    amsg.a(this.a);
  }
  
  public void onProgress(bhhf parambhhf)
  {
    int i = (int)parambhhf.a;
    if (amsg.a(this.a) != null) {
      amsg.a(this.a).a(i, amsg.a(this.a).jdField_b_of_type_Int, amsg.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsi
 * JD-Core Version:    0.7.0.1
 */