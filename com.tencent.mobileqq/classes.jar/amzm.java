import com.tencent.qphone.base.util.QLog;

class amzm
  extends bhyn
{
  amzm(amzk paramamzk) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambhyo.a());
  }
  
  public void onDoneFile(bhyo parambhyo)
  {
    if ((parambhyo == null) || (amzk.a(this.a) == null)) {
      return;
    }
    if (parambhyo.a() != 3)
    {
      amzk.a(this.a, 2);
      if (amzk.a(this.a) != null) {
        amzk.a(this.a).c(-1005, amzk.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambhyo.a());
      return;
    }
    amzk.a(this.a);
  }
  
  public void onProgress(bhyo parambhyo)
  {
    int i = (int)parambhyo.a;
    if (amzk.a(this.a) != null) {
      amzk.a(this.a).a(i, amzk.a(this.a).jdField_b_of_type_Int, amzk.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzm
 * JD-Core Version:    0.7.0.1
 */