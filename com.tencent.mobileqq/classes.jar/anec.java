import com.tencent.qphone.base.util.QLog;

class anec
  extends biht
{
  anec(anea paramanea) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    QLog.i("cmgame_process.CmGameRscDownloader", 2, "[onDone], status:" + parambihu.a());
  }
  
  public void onDoneFile(bihu parambihu)
  {
    if ((parambihu == null) || (anea.a(this.a) == null)) {
      return;
    }
    if (parambihu.a() != 3)
    {
      anea.a(this.a, 2);
      if (anea.a(this.a) != null) {
        anea.a(this.a).c(-1005, anea.a(this.a).jdField_b_of_type_JavaLangString);
      }
      QLog.e("cmgame_process.CmGameRscDownloader", 1, "downLoad game res fail retCode: " + parambihu.a());
      return;
    }
    anea.a(this.a);
  }
  
  public void onProgress(bihu parambihu)
  {
    int i = (int)parambihu.a;
    if (anea.a(this.a) != null) {
      anea.a(this.a).a(i, anea.a(this.a).jdField_b_of_type_Int, anea.a(this.a).jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anec
 * JD-Core Version:    0.7.0.1
 */